package com.kwad.sdk.core.network;

import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.account.result.NickNameGuideErrorCode;
/* loaded from: classes10.dex */
public final class e {
    public final int errorCode;
    public final String msg;
    public static e atn = new e(-1, "请求超时事件");
    public static e ato = new e(-2, "请求异常");
    public static e atp = new e(-1000, "该业务组件未加载");
    public static e atq = new e(40001, "网络错误");
    public static e atr = new e(40002, "数据解析错误");
    public static e ats = new e(40003, "数据为空");
    public static e att = new e(NickNameGuideErrorCode.NO_DEFAULT_NICKNAME_PORTRAIT, "视频资源缓存失败");
    public static e atu = new e(NickNameGuideErrorCode.NO_NEED_DISTRIBUTE, "网络超时");
    public static e atv = new e(40007, "图片下载失败");
    public static e atw = new e(40008, "广告场景不匹配");
    public static e atx = new e(40009, "广告加载异常");
    public static e aty = new e(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, "activity场景不匹配");
    public static e atz = new e(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, "sdk初始化失败");
    public static e atA = new e(40012, "权限未开启");
    public static e atB = new e(100006, "更多视频请前往快手App查看");
    public static e atC = new e(100007, "复制链接失败，请稍后重试");
    public static e atD = new e(100008, "内容有点敏感，不可以发送哦");
    public static e atE = new e(130001, "数据不存在");
    public static e atF = new e(0, "网络超时");

    public e(int i, String str) {
        this.errorCode = i;
        this.msg = str;
    }
}
