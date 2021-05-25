package d.a.d0.a.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f39588a = d.a.d0.a.b.a.f39590a.get().s();

    /* renamed from: b  reason: collision with root package name */
    public static String f39589b = "https://afd.baidu.com/afd/entry";

    public static String a() {
        if (!f39588a || TextUtils.isEmpty(d.a.d0.a.b.a.f39590a.get().c())) {
            return TextUtils.isEmpty(f39589b) ? "https://afd.baidu.com/afd/entry" : f39589b;
        }
        return d.a.d0.a.b.a.f39590a.get().c();
    }
}
