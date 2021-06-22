package d.a.l.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f44336b;

    /* renamed from: a  reason: collision with root package name */
    public String f44337a;

    public static a b() {
        if (f44336b == null) {
            synchronized (a.class) {
                if (f44336b == null) {
                    f44336b = new a();
                }
            }
        }
        return f44336b;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f44337a)) {
            return this.f44337a;
        }
        return b.a().getAppName();
    }

    public void c(String str) {
        this.f44337a = str;
    }
}
