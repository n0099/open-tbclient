package com.kwad.sdk.core.network;

import androidx.media2.session.SessionCommand;
/* loaded from: classes5.dex */
public final class f {
    public static f a = new f(-1, "请求超时事件");
    public static f b = new f(-2, "请求异常");
    public static f c = new f(-1000, "该业务组件未加载");
    public static f d = new f(SessionCommand.COMMAND_CODE_SESSION_REWIND, "网络错误");
    public static f e = new f(SessionCommand.COMMAND_CODE_SESSION_SKIP_FORWARD, "数据解析错误");
    public static f f = new f(SessionCommand.COMMAND_CODE_SESSION_SKIP_BACKWARD, "广告数据为空");
    public static f g = new f(40004, "视频资源缓存失败");
    public static f h = new f(40005, "网络超时");
    public static f i = new f(40007, "图片下载失败");
    public static f j = new f(40008, "广告场景不匹配");
    public static f k = new f(100006, "更多视频请前往快手App查看");
    public static f l = new f(100007, "复制链接失败，请稍后重试");
    public static f m = new f(100008, "内容有点敏感，不可以发送哦");
    public static f n = new f(130001, "数据不存在");
    public static f o = new f(0, "网络超时");
    public int p;
    public String q;

    public f(int i2, String str) {
        this.p = i2;
        this.q = str;
    }
}
