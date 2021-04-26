package d.a.b0.a.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f39286a = d.a.b0.a.b.a.f39288a.get().s();

    /* renamed from: b  reason: collision with root package name */
    public static String f39287b = "https://afd.baidu.com/afd/entry";

    public static String a() {
        if (!f39286a || TextUtils.isEmpty(d.a.b0.a.b.a.f39288a.get().c())) {
            return TextUtils.isEmpty(f39287b) ? "https://afd.baidu.com/afd/entry" : f39287b;
        }
        return d.a.b0.a.b.a.f39288a.get().c();
    }
}
