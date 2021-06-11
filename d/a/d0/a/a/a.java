package d.a.d0.a.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43269a = d.a.d0.a.b.a.f43271a.get().s();

    /* renamed from: b  reason: collision with root package name */
    public static String f43270b = "https://afd.baidu.com/afd/entry";

    public static String a() {
        if (!f43269a || TextUtils.isEmpty(d.a.d0.a.b.a.f43271a.get().c())) {
            return TextUtils.isEmpty(f43270b) ? "https://afd.baidu.com/afd/entry" : f43270b;
        }
        return d.a.d0.a.b.a.f43271a.get().c();
    }
}
