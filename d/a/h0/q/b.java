package d.a.h0.q;

import android.content.Context;
import android.text.TextUtils;
import d.a.h0.q.c.c;
import d.a.h0.q.c.d;
import d.a.h0.q.c.e;
import d.a.h0.q.c.f;
import d.a.h0.q.c.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f47593c;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f47594a;

    /* renamed from: b  reason: collision with root package name */
    public String f47595b;

    public b(Context context) {
        a<String> aVar = new a<>();
        this.f47594a = aVar;
        aVar.a(new c(context));
        this.f47594a.a(new e(context));
        this.f47594a.a(new d(context));
        this.f47594a.a(new g(context));
        this.f47594a.a(new d.a.h0.q.c.a(context));
        this.f47594a.a(new f(context));
    }

    public static b b(Context context) {
        if (f47593c == null) {
            synchronized (b.class) {
                if (f47593c == null) {
                    f47593c = new b(context);
                }
            }
        }
        return f47593c;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f47595b)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f47595b)) {
                    String b2 = this.f47594a.b();
                    this.f47595b = b2;
                    this.f47594a.d(b2);
                }
            }
        }
        return this.f47595b;
    }
}
