package d.b.g0.q;

import android.content.Context;
import android.text.TextUtils;
import d.b.g0.q.c.c;
import d.b.g0.q.c.d;
import d.b.g0.q.c.e;
import d.b.g0.q.c.f;
import d.b.g0.q.c.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f49339c;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f49340a;

    /* renamed from: b  reason: collision with root package name */
    public String f49341b;

    public b(Context context) {
        a<String> aVar = new a<>();
        this.f49340a = aVar;
        aVar.a(new c(context));
        this.f49340a.a(new e(context));
        this.f49340a.a(new d(context));
        this.f49340a.a(new g(context));
        this.f49340a.a(new d.b.g0.q.c.a(context));
        this.f49340a.a(new f(context));
    }

    public static b b(Context context) {
        if (f49339c == null) {
            synchronized (b.class) {
                if (f49339c == null) {
                    f49339c = new b(context);
                }
            }
        }
        return f49339c;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f49341b)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f49341b)) {
                    String b2 = this.f49340a.b();
                    this.f49341b = b2;
                    this.f49340a.d(b2);
                }
            }
        }
        return this.f49341b;
    }
}
