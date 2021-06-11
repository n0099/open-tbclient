package com.yy.mobile.framework.revenuesdk.baseapi;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes7.dex */
public class ConstCode {

    /* loaded from: classes7.dex */
    public static final class BindResCode {
        public static final int BIND_LOAD_FULL = 406;
        public static final int BIND_NOTREADY_TORETRY = 300;
        public static final int BIND_OTP_FAIL = 403;
        public static final int BIND_OTP_TIMEOUT = 408;
        public static final int BIND_RESOURCE_CONFLICT = 409;
        public static final int BIND_SUCCESS = 200;

        public static String Desc(int i2) {
            if (200 == i2) {
                return "绑定成功(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (300 == i2) {
                return "未就绪，请重试(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (403 == i2) {
                return "票据验证失败(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (408 == i2) {
                return "票据验证超时(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (406 == i2) {
                return "负载满，请重试(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (409 == i2) {
                return "资源冲突，请重试(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                return "UNKNOW-未知绑定错误(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class PktErrorCode {
        public static final int PKT_LEN_BIG = 2;
        public static final int PKT_LEN_WRONG = 1;
        public static final int PKT_UNPACK_ERR = 4;
        public static final int PKT_URI_INVALID = 3;
    }

    /* loaded from: classes7.dex */
    public static final class SdkResCode {
        public static final int NEED_BIND = -2;
        public static final int NO_CONNECTED = -1;
        public static final int RECV_RESPONSE = 1;
        public static final int SEND_SUCCESS = 0;
        public static final int TIMEOUT = -3;
        public static final int UNKNOW = -255;

        public static String Desc(int i2) {
            if (1 == i2) {
                return "成功收到服务响应(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (i2 == 0) {
                return "发送请求成功(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (-1 == i2) {
                return "未连接(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (-2 == i2) {
                return "需要绑定ID(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (-3 == i2) {
                return "客户端请求超时(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                return "UNKNOW-客户端未知错误(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class SrvResCode {
        public static final int RES_BADGATEWAY = 502;
        public static final int RES_BADREQUEST = 400;
        public static final int RES_FAIL = 403;
        public static final int RES_GATEWAYTIMEOUT = 504;
        public static final int RES_INTERNALSERVERERROR = 500;
        public static final int RES_NOTFOUND = 404;
        public static final int RES_PAYMENTREQUIRED = 402;
        public static final int RES_SERVICEUNAVAILABLE = 503;
        public static final int RES_SUCCESS = 200;
        public static final int RES_TIMEOUT = 408;
        public static final int RES_UNAUTHORIZED = 401;

        public static String Desc(int i2) {
            if (200 == i2) {
                return "请求业务服务成功(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (400 == i2) {
                return "上行消息解析失败(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (401 == i2) {
                return "上行消息uid未验证(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (402 == i2) {
                return "你懂的\t该请service组吃顿饭了(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (403 == i2) {
                return "请求业务服务失败(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (404 == i2) {
                return "找不到服务(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (408 == i2) {
                return "请求业务服务超时(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (500 == i2) {
                return "内部服务错误(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (502 == i2) {
                return "网关错误(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (503 == i2) {
                return "找不到后端服务(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else if (504 == i2) {
                return "网关超时(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                return "UNKNOW-未知服务错误(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class Status {
        public static final int Binded = 6;
        public static final int Close = 5;
        public static final int Init = 0;
        public static final int OnClosed = 4;
        public static final int OnConnected = 3;
        public static final int OnConnecting = 1;
        public static final int OnConnecttimeout = 2;

        public static String Desc(int i2) {
            return i2 == 0 ? "初始化" : 1 == i2 ? "正在连接服务器..." : 2 == i2 ? "连接超时!" : 3 == i2 ? "连接成功!" : 4 == i2 ? "连接断开了!" : 5 == i2 ? "关闭连接" : 6 == i2 ? "连接绑定ID状态!" : "UNKNOW-未知状态";
        }
    }
}
