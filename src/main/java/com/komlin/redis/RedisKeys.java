package com.komlin.redis;

public class RedisKeys {

    /**
     * 短信验证码(Key:tel,V:string)
     */
    public final static String MESSAGE_CODE = "ceserted_balley:contributor:vcode:";

    public final static String MESSAGE_CODE_ID = "ceserted_balley:user:vcode:id:";

    public final static String WATCH_DEVICE_BEAT = "watch:device:beat:";
    /**
     * 手表在校状态(KEY:watchId : V: 0 校外 1 校内)
     */
    public final static String WATCH_IN_SCHOOL_STATUS = "ceserted_balley:watch:location:in:school:";


    /**
     * 问卷关联问卷图片位置
     */
    public final static String WJ_IMG_TOKEN = "watch:user:wj:token:";
    /**
     * 接口访问Token(Key:UID,V:string)
     */
    public final static String VISIT_TOKEN = "oil_card:user:token:";

    /**
     * 预约场馆时间key
     */
    public final static String MEET_ROOM_DATE = "MEET_ROOM_DATE";
    /**
     * 联通查询健康码token
     */
    public final static String HEALTH_AUTH_TOKEN = "HEALTH:AUTH:TOKEN";
    /**
     * 预约时长
     */
    public final static String MEET_ROOM_TIME_LONG = "MEET_ROOM_TIME_LONG";


    /**
     * 手机号
     */
    public final static String PHONE_ID = "ceserted_balley:contributor:phone:id";

    public final static String WECHAT_JSSDK_TICKET = "ceserted_balley:wechat:jssdk:ticket:";

    public final static String WECHAT_GLOBAL_ACCESS_TOKEN = "ceserted_balley:wechat:global:access:token:";
    public final static String WECHAT_GLOBAL_OPEN_ID_APP_TOKEN = "ceserted_balley:wechat:global:openid:app-token:";
    //当前天气
    public final static String WEATHER_NOW = "api:weather_now:";
    //未来7天的天气预报
    public final static String WEATHER_FORECAST = "api:weather_forecast:";
    //逐小时的天气预报
    public final static String WEATHER_HOURLY = "api:weather_hourly:";
    //当前城市的空气质量
    public final static String WEATHER_AIR = "api:weather_air:";


    //宿舍离开推送结束时间
    public final static String HOSTEL_OUT_END_TIME = "ceserted_balley:hostel:out:end:";
    //宿舍进入推送开始时间
    public final static String HOSTEL_IN_START_TIME = "ceserted_balley:hostel:in:start:";
    //宿舍进入推送结束时间
    public final static String HOSTEL_IN_END_TIME = "ceserted_balley:hostel:in:end:";

    //学生进寝室推送记录
    public final static String STUDENT_BEDROOM_PUSH_IN = "student:bedroom:in";

    //学生出寝室推送记录
    public final static String STUDENT_BEDROOM_PUSH_OUT = "student:bedroom:out";

    //学生进校
    public final static String STUDENT_SCHOOL_SIGN= "student:school:in";
    //短信类型
    public final static String MSG_SEND_TYPE ="MSG_SEND_TYPE";
    //邮箱验证码
    public final static String EMAIL_CODE = "ceserted_balley:email:vcode:";


    //学校访客
    public final static String SCHOOL_VISITOR = "ceserted_balley:school:visitor:";
    //投票活动访问数
    public final static String ACTIVITY_VISIT = "ceserted_balley:activity:visit:";
}
