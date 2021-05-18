package d.a.b0.a.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f38531a = d.a.b0.a.b.a.f38533a.get().s();

    /* renamed from: b  reason: collision with root package name */
    public static String f38532b = "https://afd.baidu.com/afd/entry";

    public static String a() {
        if (!f38531a || TextUtils.isEmpty(d.a.b0.a.b.a.f38533a.get().c())) {
            return TextUtils.isEmpty(f38532b) ? "https://afd.baidu.com/afd/entry" : f38532b;
        }
        return d.a.b0.a.b.a.f38533a.get().c();
    }
}
