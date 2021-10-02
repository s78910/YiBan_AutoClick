# SUST易班自动打卡

本项目是基于[SUST易班打卡](https://github.com/N0I0C0K/SUST_autocheck_public)进行重构的。本项目是使用Java语言。

**个人已经使用单人配置打卡了2个多月了,极其稳定**

# 项目功能

1. 易班晨午检自动打卡。
2. 自定义配置用户（无需账号密码），支持多个用户打卡
3. 配置问题/打卡失败/打卡成功都会发送邮箱(前提是邮箱不能填错)
4. 记录日志到click.log，方便排查问题
5. 支持用Idea打成jar包后命令行直接运行(可以部署在服务器上定时任务)

# 使用步骤

1. 配置src\main\resources\config\mail.setting。配置发送邮件的邮箱。
2. 在main\resources\data.json配置用户，支持多个用户
3. 执行src\main\java\com\add\Main1.java的main方法进行打卡。

# 如何从修改配置到部署到服务器自动打卡

[从导入到打包到部署服务器自动打卡手把手](https://github.com/XddAdd/YiBan_AutoClick/blob/main/%E5%A6%82%E4%BD%95%E7%94%A8Idea%E4%BF%AE%E6%94%B9%E9%85%8D%E7%BD%AE%E5%B9%B6%E9%83%A8%E7%BD%B2%E5%88%B0%E6%9C%8D%E5%8A%A1%E5%99%A8%E8%87%AA%E5%8A%A8%E6%89%93%E5%8D%A1.md)

# 目前存在的bug
1. 打包部署到服务器会存在打卡位置提交是乱码的情况。(目前初步判断是部署的服务器的环境导致的问题)
2. 偶尔会出现Read Timeout的错误。(目前没排查过，初步判断是打卡时间是高峰期，易班服务器压力大，导致打卡失败，建议定时时间不要设置到整点)

# 配置文件data.json说明

如：

```json
{
    "users": [
        {
            "url_generate_date": "2021-05-22", //url产生的日期,一个url有一定的有效期
            "email": "123456789@qq.com", //接收邮箱地址
            "name": "tom", //name，发送邮件需要，跟打卡无关
            "id": "1", //id，日志/邮件需要，跟打卡无关
            "url": "http://yiban.sust.edu.cn/v4/public/index.php?key=Em7/z2oL422315QKqT8pGGgcnsyhgyNhBOsIQZWwPoKB9MOSBCyqRxsaphLn8Yr7LY2KdnXnONwu6K7TTcBF_f8bdGhiE=", //url，从易班复制
            "location": "陕西省 西安市 未央区 111县道 111县 靠近北城驾校 ", //打卡地址
            "morning_click": true, //是否需要晨检
            "noon_click": true, //是否需要午检
            "summer_click": true,//是否需要假期打卡
            "send_email":true //是否发送邮件
        }
    ]
}
```

## URL从哪里复制？

1. 打开易班->信息上报
2. ![image-20210530142045825](https://gitee.com/xddadd/cloud-image/raw/master/image-20210530142045825.png)

## 如何配置多个用户?

修改data.json文件即可。

users是一个数组，只需要模仿着，copy一份即可。如下是两个用户的。

```json
{
    "users": [
        {
            "url_generate_date": "2021-05-22",
            "email": "123456789@qq.com",
            "name": "tom",
            "id": "1",
            "url": "http://yiban.sust.edu.cn/v4/public/index.php?key=Em7/z2oL422315QKqT8pGGgcnsyhgyNhBOsIQZWwPoKB9MOSBCyqRxsaphLn8Yr7LY2KdnXnONwu6K7TTcBF_f8bdGhiE=",
            "location": "陕西省 西安市 未央区 111县道 111县 靠近北城驾校",
            "morning_click": true,
            "noon_click": true,
            "summer_click": true,
            "send_email":true
        },
        {
            "url_generate_date": "2021-05-22",
            "email": "123456789@qq.com",
            "name": "jerry",
            "id": "1",
            "url": "http://yiban.sust.edu.cn/v4/public/index.php?key=Em7/z2oL422315QKqT8pGGgcnsyhgyNhBOsIQZWwPoKB9MOSBCyqRxsaphLn8Yr7LY2KdnXnONwu6K7TTcBF_f8bdGhiE=",
            "location": "陕西省 西安市 未央区 111县道 111县 靠近北城驾校",
            "morning_click": true,
            "noon_click": true,
            "summer_click": true,
            "send_email":true
        }
    ]
}
```

