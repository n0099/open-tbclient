package com.kwad.sdk.core.network;

import com.baidu.searchbox.account.result.NickNameGuideErrorCode;
/* loaded from: classes9.dex */
public final class f {
    public static f XY = new f(-1, "请求超时事件");
    public static f XZ = new f(-2, "请求异常");
    public static f Ya = new f(-1000, "该业务组件未加载");
    public static f Yb = new f(40001, "网络错误");
    public static f Yc = new f(40002, "数据解析错误");
    public static f Yd = new f(40003, "广告数据为空");
    public static f Ye = new f(NickNameGuideErrorCode.NO_DEFAULT_NICKNAME_PORTRAIT, "视频资源缓存失败");
    public static f Yf = new f(NickNameGuideErrorCode.NO_NEED_DISTRIBUTE, "网络超时");
    public static f Yg = new f(40007, "图片下载失败");
    public static f Yh = new f(40008, "广告场景不匹配");
    public static f Yi = new f(100006, "更多视频请前往快手App查看");
    public static f Yj = new f(100007, "复制链接失败，请稍后重试");
    public static f Yk = new f(100008, "内容有点敏感，不可以发送哦");
    public static f Yl = new f(130001, "数据不存在");
    public static f Ym = new f(0, "网络超时");
    public String Qd;
    public int errorCode;

    public f(int i, String str) {
        this.errorCode = i;
        this.Qd = str;
    }
}
