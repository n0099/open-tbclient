package d.b.h0.q;

import android.content.Context;
import android.text.TextUtils;
import d.b.h0.q.c.c;
import d.b.h0.q.c.d;
import d.b.h0.q.c.e;
import d.b.h0.q.c.f;
import d.b.h0.q.c.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f50061c;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f50062a;

    /* renamed from: b  reason: collision with root package name */
    public String f50063b;

    public b(Context context) {
        a<String> aVar = new a<>();
        this.f50062a = aVar;
        aVar.a(new c(context));
        this.f50062a.a(new e(context));
        this.f50062a.a(new d(context));
        this.f50062a.a(new g(context));
        this.f50062a.a(new d.b.h0.q.c.a(context));
        this.f50062a.a(new f(context));
    }

    public static b b(Context context) {
        if (f50061c == null) {
            synchronized (b.class) {
                if (f50061c == null) {
                    f50061c = new b(context);
                }
            }
        }
        return f50061c;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f50063b)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f50063b)) {
                    String b2 = this.f50062a.b();
                    this.f50063b = b2;
                    this.f50062a.d(b2);
                }
            }
        }
        return this.f50063b;
    }
}
