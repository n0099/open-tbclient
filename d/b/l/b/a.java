package d.b.l.b;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f64837b;

    /* renamed from: a  reason: collision with root package name */
    public String f64838a;

    public static a b() {
        if (f64837b == null) {
            synchronized (a.class) {
                if (f64837b == null) {
                    f64837b = new a();
                }
            }
        }
        return f64837b;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f64838a)) {
            return this.f64838a;
        }
        return b.a().getAppName();
    }

    public void c(String str) {
        this.f64838a = str;
    }
}
