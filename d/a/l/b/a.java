package d.a.l.b;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f63135b;

    /* renamed from: a  reason: collision with root package name */
    public String f63136a;

    public static a b() {
        if (f63135b == null) {
            synchronized (a.class) {
                if (f63135b == null) {
                    f63135b = new a();
                }
            }
        }
        return f63135b;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f63136a)) {
            return this.f63136a;
        }
        return b.a().getAppName();
    }

    public void c(String str) {
        this.f63136a = str;
    }
}
