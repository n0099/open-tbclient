package d.b.l.b;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f64711b;

    /* renamed from: a  reason: collision with root package name */
    public String f64712a;

    public static a b() {
        if (f64711b == null) {
            synchronized (a.class) {
                if (f64711b == null) {
                    f64711b = new a();
                }
            }
        }
        return f64711b;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f64712a)) {
            return this.f64712a;
        }
        return b.a().getAppName();
    }

    public void c(String str) {
        this.f64712a = str;
    }
}
