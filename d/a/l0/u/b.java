package d.a.l0.u;

import android.content.Context;
import android.text.TextUtils;
import d.a.l0.u.c.c;
import d.a.l0.u.c.d;
import d.a.l0.u.c.e;
import d.a.l0.u.c.f;
import d.a.l0.u.c.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f52173c;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f52174a;

    /* renamed from: b  reason: collision with root package name */
    public String f52175b;

    public b(Context context) {
        a<String> aVar = new a<>();
        this.f52174a = aVar;
        if (context == null) {
            return;
        }
        aVar.a(new c(context));
        this.f52174a.a(new e(context));
        this.f52174a.a(new d(context));
        this.f52174a.a(new g(context));
        this.f52174a.a(new d.a.l0.u.c.a(context));
        this.f52174a.a(new f(context));
    }

    public static b b(Context context) {
        if (f52173c == null) {
            synchronized (b.class) {
                if (f52173c == null) {
                    f52173c = new b(context);
                }
            }
        }
        return f52173c;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f52175b)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f52175b)) {
                    String b2 = this.f52174a.b();
                    this.f52175b = b2;
                    this.f52174a.d(b2);
                }
            }
        }
        return this.f52175b;
    }
}
