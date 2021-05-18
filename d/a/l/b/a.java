package d.a.l.b;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f63767b;

    /* renamed from: a  reason: collision with root package name */
    public String f63768a;

    public static a b() {
        if (f63767b == null) {
            synchronized (a.class) {
                if (f63767b == null) {
                    f63767b = new a();
                }
            }
        }
        return f63767b;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f63768a)) {
            return this.f63768a;
        }
        return b.a().getAppName();
    }

    public void c(String str) {
        this.f63768a = str;
    }
}
