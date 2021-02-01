package com.qq.e.comm.plugin.util;

import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mapapi.UIMsg;
import com.kwai.sodler.lib.ext.PluginError;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.util.AdError;
/* loaded from: classes15.dex */
public class ag {
    public static AdError a(int i) {
        switch (i) {
            case 300:
            case 2001:
                return new AdError(2001, "初始化错误");
            case 301:
            case UIMsg.f_FUN.FUN_ID_VOICE_SCH_ACTION /* 200101 */:
                return new AdError(2001, "初始化错误，详细码：200101");
            case 302:
            case UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION /* 200102 */:
                return new AdError(2001, "初始化错误，详细码：200102");
            case 303:
            case 200103:
                return new AdError(2001, "初始化错误，详细码：200103");
            case 400:
            case 403:
            case 3001:
                return new AdError(3001, "网络异常");
            case 404:
            case PluginError.ERROR_LOA_CREATE_PLUGIN /* 4011 */:
                return new AdError(PluginError.ERROR_LOA_CREATE_PLUGIN, "开屏广告拉取超时");
            case 405:
            case 5007:
                return new AdError(5007, "资源加载错误");
            case 406:
            case 5008:
                return new AdError(5008, "图片加载错误");
            case 500:
            case 4003:
                return new AdError(4003, "广告位错误");
            case 501:
            case 5004:
                return new AdError(5004, "没有广告");
            case 502:
            case ARPMessageType.MSG_TYPE_RES_REQUEST /* 5001 */:
                return new AdError(ARPMessageType.MSG_TYPE_RES_REQUEST, "服务端数据错误");
            case 600:
            case 4004:
                return new AdError(4004, "开屏广告容器不可见");
            case 602:
            case 4002:
                return new AdError(4002, "Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            case 603:
            case 200201:
                return new AdError(2002, "内部错误，详细码：200201");
            case ErrorCode.OtherError.GET_PARAS_FROM_NATIVE_ERROR /* 604 */:
            case 200202:
                return new AdError(2002, "内部错误，详细码：200202");
            case ErrorCode.OtherError.CONTAINER_HEIGHT_ERROR /* 606 */:
            case 4005:
                return new AdError(4005, "开屏广告容器的高度低于400dp");
            case 607:
            case PluginError.ERROR_LOA_ASSET_MANAGER /* 4006 */:
                return new AdError(PluginError.ERROR_LOA_ASSET_MANAGER, "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口");
            case ErrorCode.OtherError.SKIP_VIEW_SIZE_ERROR /* 608 */:
            case 4009:
                return new AdError(4009, "开屏广告的自定义跳过按钮尺寸小于3x3dp");
            case 700:
            case 5002:
                return new AdError(5002, "视频素材下载错误");
            case 701:
            case 5003:
                return new AdError(5003, "视频素材播放错误");
            case 800:
                return new AdError(4012, "内容接口调用顺序错误，调用点击接口前未调用曝光接口");
            case 2002:
                return new AdError(2002, "内部错误");
            case 3003:
                return new AdError(3003, "网络不可用");
            case 4001:
                return new AdError(4001, "传入的参数有错误");
            case PluginError.ERROR_LOA_CLASS /* 4007 */:
                return new AdError(PluginError.ERROR_LOA_CLASS, "当前设备或系统不支持");
            case PluginError.ERROR_LOA_SO_MD5_CHECK /* 4008 */:
                return new AdError(PluginError.ERROR_LOA_SO_MD5_CHECK, "设备方向不适合展示广告");
            case 4014:
                return new AdError(4014, "广告数据尚未准备好");
            case 4015:
                return new AdError(4015, "同一条广告不允许多次展示，请再次拉取后展示");
            case 5005:
            case 109506:
                return new AdError(5005, "广告请求量或者消耗等超过日限额，请明天再请求广告");
            case 5006:
            case 107030:
                return new AdError(5006, "包名校验错误，当前App的包名和广点通移动联盟官网注册的媒体包名不一致，因此无广告返回");
            case 5009:
            case 109507:
                return new AdError(5009, "广告请求量或者消耗等超过小时限额，请一小时后再请求广告");
            case 5011:
                return new AdError(5010, "原生模版渲染失败");
            case 5012:
                return new AdError(5012, "广告数据已过期，请重新拉取广告");
            case 100159:
                return new AdError(4016, "应用横竖方向参数与广告位支持方向不匹配");
            case 107034:
                return new AdError(5010, "广告样式校验失败，请检查广告位与接口使用是否一致");
            case 107035:
                return new AdError(4013, "使用支持视频素材的原生模板广告位前，请升级您的SDK");
            case 400101:
                return new AdError(4001, "传入的参数有错误，详细码：" + i);
            case 400102:
                return new AdError(4001, "传入的参数有错误，详细码：" + i);
            case 400103:
                return new AdError(4001, "传入的参数有错误，详细码：" + i);
            case 400104:
                return new AdError(4001, "传入的参数有错误，详细码：" + i);
            default:
                return new AdError(SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME, "未知错误，详细码：" + i);
        }
    }
}
