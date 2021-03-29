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
    public static b f49340c;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f49341a;

    /* renamed from: b  reason: collision with root package name */
    public String f49342b;

    public b(Context context) {
        a<String> aVar = new a<>();
        this.f49341a = aVar;
        aVar.a(new c(context));
        this.f49341a.a(new e(context));
        this.f49341a.a(new d(context));
        this.f49341a.a(new g(context));
        this.f49341a.a(new d.b.g0.q.c.a(context));
        this.f49341a.a(new f(context));
    }

    public static b b(Context context) {
        if (f49340c == null) {
            synchronized (b.class) {
                if (f49340c == null) {
                    f49340c = new b(context);
                }
            }
        }
        return f49340c;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f49342b)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f49342b)) {
                    String b2 = this.f49341a.b();
                    this.f49342b = b2;
                    this.f49341a.d(b2);
                }
            }
        }
        return this.f49342b;
    }
}
