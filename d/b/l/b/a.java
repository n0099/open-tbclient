package d.b.l.b;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f64011b;

    /* renamed from: a  reason: collision with root package name */
    public String f64012a;

    public static a b() {
        if (f64011b == null) {
            synchronized (a.class) {
                if (f64011b == null) {
                    f64011b = new a();
                }
            }
        }
        return f64011b;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f64012a)) {
            return this.f64012a;
        }
        return b.a().getAppName();
    }

    public void c(String str) {
        this.f64012a = str;
    }
}
