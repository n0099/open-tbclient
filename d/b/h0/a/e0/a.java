package d.b.h0.a.e0;

import d.b.h0.a.e0.f;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f44579a = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.b.f44602g));

    /* renamed from: b  reason: collision with root package name */
    public static final String f44580b = "检测到白屏区域超过" + a(f.b.f44601f);

    /* renamed from: c  reason: collision with root package name */
    public static final String f44581c = "检测到白屏区域超过" + a(f.b.f44600e) + "且正在loading";

    /* renamed from: d  reason: collision with root package name */
    public static final String f44582d;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("请求失败率超过");
        sb.append(a(f.b.f44598c));
        f44582d = sb.toString();
    }

    public static String a(double d2) {
        return ((int) (d2 * 100.0d)) + "%";
    }
}
