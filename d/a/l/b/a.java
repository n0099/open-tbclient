package d.a.l.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f44235b;

    /* renamed from: a  reason: collision with root package name */
    public String f44236a;

    public static a b() {
        if (f44235b == null) {
            synchronized (a.class) {
                if (f44235b == null) {
                    f44235b = new a();
                }
            }
        }
        return f44235b;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f44236a)) {
            return this.f44236a;
        }
        return b.a().getAppName();
    }

    public void c(String str) {
        this.f44236a = str;
    }
}
