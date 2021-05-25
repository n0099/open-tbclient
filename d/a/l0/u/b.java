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
    public static volatile b f48499c;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f48500a;

    /* renamed from: b  reason: collision with root package name */
    public String f48501b;

    public b(Context context) {
        a<String> aVar = new a<>();
        this.f48500a = aVar;
        if (context == null) {
            return;
        }
        aVar.a(new c(context));
        this.f48500a.a(new e(context));
        this.f48500a.a(new d(context));
        this.f48500a.a(new g(context));
        this.f48500a.a(new d.a.l0.u.c.a(context));
        this.f48500a.a(new f(context));
    }

    public static b b(Context context) {
        if (f48499c == null) {
            synchronized (b.class) {
                if (f48499c == null) {
                    f48499c = new b(context);
                }
            }
        }
        return f48499c;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f48501b)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f48501b)) {
                    String b2 = this.f48500a.b();
                    this.f48501b = b2;
                    this.f48500a.d(b2);
                }
            }
        }
        return this.f48501b;
    }
}
