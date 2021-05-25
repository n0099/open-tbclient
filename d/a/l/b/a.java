package d.a.l.b;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f40559b;

    /* renamed from: a  reason: collision with root package name */
    public String f40560a;

    public static a b() {
        if (f40559b == null) {
            synchronized (a.class) {
                if (f40559b == null) {
                    f40559b = new a();
                }
            }
        }
        return f40559b;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f40560a)) {
            return this.f40560a;
        }
        return b.a().getAppName();
    }

    public void c(String str) {
        this.f40560a = str;
    }
}
