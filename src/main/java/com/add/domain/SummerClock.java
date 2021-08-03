package com.add.domain;

import cn.hutool.core.util.RandomUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
public class SummerClock extends Clock{
    String name = "易班假期打卡";
    String startTime = "08:00:00";
    String endTime = "11:00:00";
    //String endTime = "15:00:00";
    int code = 13;
    String reqUrl = String.format("http://yiban.sust.edu.cn/v4/public/index.php/Index/formflow/add.html?desgin_id=%s&list_id=9", code);



    @Override
    Map<String, Object> getClockRequestBody(User user) throws UnsupportedEncodingException {
        String temperature = "36" + "." + RandomUtil.randomInt(1, 5);
        String location = user.getLocation() == null ? DEFAULT_LOCATION : user.getLocation();
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put("13[0][0][name]", "form[13][field_1587635120_1722][]");bodyMap.put("13[0][0][value]", temperature);
        bodyMap.put("13[0][1][name]", "form[13][field_1587635142_8919][]");bodyMap.put("13[0][1][value]", "正常");
        bodyMap.put("13[0][2][name]", "form[13][field_1587635252_7450][]");bodyMap.put("13[0][2][value]", location);
        bodyMap.put("13[0][3][name]", "form[13][field_1587635509_7740][]");bodyMap.put("13[0][3][value]", "否");
        bodyMap.put("13[0][4][name]", "form[13][field_1587998920_6988][]");bodyMap.put("13[0][4][value]", "0");
        bodyMap.put("13[0][5][name]", "form[13][field_1587998777_8524][]");bodyMap.put("13[0][5][value]", "否");
        bodyMap.put("13[0][6][name]", "form[13][field_1587635441_3730][]");bodyMap.put("13[0][6][value]", "0");
        Map<String, Object> encodeBodyMap = new HashMap<String, Object>();
        for (String key : bodyMap.keySet()) {
            String v = (String) bodyMap.get(key);
            encodeBodyMap.put(new String(key.getBytes(), "UTF-8"), new String(v.getBytes(), "UTF-8"));
        }
        return encodeBodyMap;
    }

    @Override
    String getClockRequestUrl() {
        return this.reqUrl;
    }
}
