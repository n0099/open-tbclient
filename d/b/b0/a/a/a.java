package d.b.b0.a.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42104a = d.b.b0.a.b.a.f42106a.get().D();

    /* renamed from: b  reason: collision with root package name */
    public static String f42105b = "https://afd.baidu.com/afd/entry";

    public static String a() {
        if (!f42104a || TextUtils.isEmpty(d.b.b0.a.b.a.f42106a.get().f())) {
            return TextUtils.isEmpty(f42105b) ? "https://afd.baidu.com/afd/entry" : f42105b;
        }
        return d.b.b0.a.b.a.f42106a.get().f();
    }
}
