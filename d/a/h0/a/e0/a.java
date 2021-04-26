package d.a.h0.a.e0;

import d.a.h0.a.e0.f;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f41875a = String.format("FMP在%s毫秒内未到达", Integer.valueOf(f.b.f41898g));

    /* renamed from: b  reason: collision with root package name */
    public static final String f41876b = "检测到白屏区域超过" + a(f.b.f41897f);

    /* renamed from: c  reason: collision with root package name */
    public static final String f41877c = "检测到白屏区域超过" + a(f.b.f41896e) + "且正在loading";

    /* renamed from: d  reason: collision with root package name */
    public static final String f41878d;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("请求失败率超过");
        sb.append(a(f.b.f41894c));
        f41878d = sb.toString();
    }

    public static String a(double d2) {
        return ((int) (d2 * 100.0d)) + "%";
    }
}
