package d.b.g0.a.e0;

import d.b.g0.a.e0.f;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f43857a = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.b.f43880g));

    /* renamed from: b  reason: collision with root package name */
    public static final String f43858b = "检测到白屏区域超过" + a(f.b.f43879f);

    /* renamed from: c  reason: collision with root package name */
    public static final String f43859c = "检测到白屏区域超过" + a(f.b.f43878e) + "且正在loading";

    /* renamed from: d  reason: collision with root package name */
    public static final String f43860d;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("请求失败率超过");
        sb.append(a(f.b.f43876c));
        f43860d = sb.toString();
    }

    public static String a(double d2) {
        return ((int) (d2 * 100.0d)) + "%";
    }
}
