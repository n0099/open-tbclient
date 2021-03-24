package com.qq.e.comm.util;

import com.bytedance.sdk.adnet.err.VAdError;
import com.qq.e.comm.constants.ErrorCode;
/* loaded from: classes6.dex */
public class AdErrorConvertor {
    public static AdError formatErrorCode(int i) {
        AdError adError;
        switch (i) {
            case 300:
            case 2001:
                return new AdError(2001, "初始化错误");
            case 301:
            case 200101:
                return new AdError(2001, "初始化错误，详细码：200101");
            case 302:
            case 200102:
                return new AdError(2001, "初始化错误，详细码：200102");
            case 303:
            case ErrorCode.POFACTORY_GET_INTERFACE_ERROR /* 200103 */:
                return new AdError(2001, "初始化错误，详细码：200103");
            case 400:
            case 403:
            case 3001:
                return new AdError(3001, "网络异常");
            case 404:
            case 4011:
                return new AdError(4011, "开屏广告拉取超时");
            case 405:
            case ErrorCode.RESOURCE_LOAD_ERROR /* 5007 */:
                return new AdError(ErrorCode.RESOURCE_LOAD_ERROR, "资源加载错误");
            case 406:
            case ErrorCode.IMAGE_LOAD_ERROR /* 5008 */:
                return new AdError(ErrorCode.IMAGE_LOAD_ERROR, "图片加载错误");
            case 500:
            case 4003:
                return new AdError(4003, "广告位错误");
            case 501:
            case ErrorCode.NO_AD_FILL /* 5004 */:
                return new AdError(ErrorCode.NO_AD_FILL, "没有广告");
            case 502:
            case ErrorCode.SERVER_JSON_PARSE_ERROR /* 5001 */:
                return new AdError(ErrorCode.SERVER_JSON_PARSE_ERROR, "服务端数据错误");
            case 600:
            case 4004:
                return new AdError(4004, "开屏广告容器不可见");
            case 601:
            case 3003:
                return new AdError(3003, "网络不可用");
            case 602:
            case 4002:
                return new AdError(4002, "Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            case 603:
            case ErrorCode.NATIVE_PARSE_JS_PARAM_ERROR /* 200201 */:
                return new AdError(2002, "内部错误，详细码：200201");
            case 604:
            case ErrorCode.JS_PARSE_NATIVE_PARAM_ERROR /* 200202 */:
                return new AdError(2002, "内部错误，详细码：200202");
            case 606:
            case 4005:
                return new AdError(4005, "广告容器尺寸错误");
            case 607:
            case 4006:
                return new AdError(4006, "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口");
            case VAdError.NETWORK_DISPATCH_FAIL_CODE /* 608 */:
            case ErrorCode.SKIP_VIEW_SIZE_ERROR /* 4009 */:
                return new AdError(ErrorCode.SKIP_VIEW_SIZE_ERROR, "开屏广告的自定义跳过按钮尺寸小于3x3dp");
            case 700:
            case ErrorCode.VIDEO_DOWNLOAD_FAIL /* 5002 */:
                return new AdError(ErrorCode.VIDEO_DOWNLOAD_FAIL, "视频素材下载错误");
            case 701:
            case 5003:
                return new AdError(5003, "视频素材播放错误");
            case 800:
                return new AdError(ErrorCode.CONTENT_FORCE_EXPOSURE, "内容接口调用顺序错误，调用点击接口前未调用曝光接口");
            case 2002:
                return new AdError(2002, "内部错误");
            case 2003:
                return new AdError(2003, "SDK未初始化");
            case 3002:
                return new AdError(3002, "网络超时");
            case 4001:
                return new AdError(4001, "传入的参数有错误");
            case 4007:
                return new AdError(4007, "当前设备或系统不支持");
            case 4008:
                return new AdError(4008, "设备方向不适合展示广告");
            case ErrorCode.AD_DATA_NOT_READY /* 4014 */:
                return new AdError(ErrorCode.AD_DATA_NOT_READY, "广告数据尚未准备好");
            case ErrorCode.AD_REPLAY /* 4015 */:
                return new AdError(ErrorCode.AD_REPLAY, "同一条广告不允许多次展示，请再次拉取后展示");
            case ErrorCode.TRAFFIC_CONTROL_DAY /* 5005 */:
            case ErrorCode.ServerError.TRAFFIC_CONTROL_DAY /* 109506 */:
                return new AdError(ErrorCode.TRAFFIC_CONTROL_DAY, "广告请求量或者消耗等超过日限额，请明天再请求广告");
            case ErrorCode.PACKAGE_NAME_ERROR /* 5006 */:
            case ErrorCode.ServerError.PACKAGE_NAME_ERROR /* 107030 */:
                return new AdError(ErrorCode.PACKAGE_NAME_ERROR, "包名校验错误，当前App的包名和广点通移动联盟官网注册的媒体包名不一致，因此无广告返回");
            case ErrorCode.TRAFFIC_CONTROL_HOUR /* 5009 */:
            case ErrorCode.ServerError.TRAFFIC_CONTROL_HOUR /* 109507 */:
                return new AdError(ErrorCode.TRAFFIC_CONTROL_HOUR, "广告请求量或者消耗等超过小时限额，请一小时后再请求广告");
            case ErrorCode.RENDER_TYPE_POSTYPE_NOTMATCH /* 5010 */:
            case ErrorCode.ServerError.RENDER_TYPE_POSTYPE_NOTMATCH /* 107034 */:
                return new AdError(ErrorCode.RENDER_TYPE_POSTYPE_NOTMATCH, "广告样式校验失败，请检查广告位与接口使用是否一致");
            case ErrorCode.NATIVE_EXPRESS_DATA_AND_TEMPLATE_NOT_MATCHED_ERROR /* 5011 */:
                return new AdError(ErrorCode.RENDER_TYPE_POSTYPE_NOTMATCH, "原生模版渲染失败");
            case ErrorCode.AD_DATA_EXPIRE /* 5012 */:
                return new AdError(ErrorCode.AD_DATA_EXPIRE, "广告数据已过期，请重新拉取广告");
            case ErrorCode.AD_TYPE_DEPRECATED /* 5021 */:
                return new AdError(ErrorCode.AD_TYPE_DEPRECATED, "该类型广告已废弃，请使用其他类型的广告");
            case ErrorCode.EXPRESS_REWARD_VIDEO_RENDER_FAIL /* 5022 */:
                return new AdError(ErrorCode.EXPRESS_REWARD_VIDEO_RENDER_FAIL, "模板激励视频渲染失败");
            case ErrorCode.ServerError.ORENTATION_MISMATCH /* 100159 */:
                return new AdError(ErrorCode.ORENTATION_MISMATCH, "应用横竖方向参数与广告位支持方向不匹配");
            case ErrorCode.ServerError.NOT_SUPPORT_EXPRESS_VIDEO /* 107035 */:
                return new AdError(ErrorCode.NOT_SUPPORT_EXPRESS_VIDEO, "使用支持视频素材的原生模板广告位前，请升级您的SDK");
            case ErrorCode.POSID_NULL /* 400101 */:
            case ErrorCode.APPID_NULL /* 400102 */:
            case ErrorCode.CONTEXT_NULL /* 400103 */:
            case ErrorCode.SPLASH_CONTAINER_NULL /* 400104 */:
                adError = new AdError(4001, "传入的参数有错误，详细码：" + i);
                break;
            case ErrorCode.SPLASH_CONTAINER_HEIGHT_ERROR /* 400501 */:
                return new AdError(4005, "开屏广告容器的高度低于400dp");
            default:
                adError = new AdError(6000, "未知错误，详细码：" + i);
                break;
        }
        return adError;
    }
}
