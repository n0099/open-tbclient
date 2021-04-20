package d.b.a0.a.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41815a = d.b.a0.a.b.a.f41817a.get().D();

    /* renamed from: b  reason: collision with root package name */
    public static String f41816b = "https://afd.baidu.com/afd/entry";

    public static String a() {
        if (!f41815a || TextUtils.isEmpty(d.b.a0.a.b.a.f41817a.get().f())) {
            return TextUtils.isEmpty(f41816b) ? "https://afd.baidu.com/afd/entry" : f41816b;
        }
        return d.b.a0.a.b.a.f41817a.get().f();
    }
}
