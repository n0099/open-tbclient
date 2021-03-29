package d.b.g0.a.e0;

import d.b.g0.a.e0.f;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f43858a = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.b.f43881g));

    /* renamed from: b  reason: collision with root package name */
    public static final String f43859b = "检测到白屏区域超过" + a(f.b.f43880f);

    /* renamed from: c  reason: collision with root package name */
    public static final String f43860c = "检测到白屏区域超过" + a(f.b.f43879e) + "且正在loading";

    /* renamed from: d  reason: collision with root package name */
    public static final String f43861d;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("请求失败率超过");
        sb.append(a(f.b.f43877c));
        f43861d = sb.toString();
    }

    public static String a(double d2) {
        return ((int) (d2 * 100.0d)) + "%";
    }
}
