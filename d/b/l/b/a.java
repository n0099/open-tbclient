package d.b.l.b;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f64010b;

    /* renamed from: a  reason: collision with root package name */
    public String f64011a;

    public static a b() {
        if (f64010b == null) {
            synchronized (a.class) {
                if (f64010b == null) {
                    f64010b = new a();
                }
            }
        }
        return f64010b;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f64011a)) {
            return this.f64011a;
        }
        return b.a().getAppName();
    }

    public void c(String str) {
        this.f64011a = str;
    }
}
