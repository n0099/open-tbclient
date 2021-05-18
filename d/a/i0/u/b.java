package d.a.i0.u;

import android.content.Context;
import android.text.TextUtils;
import d.a.i0.u.c.c;
import d.a.i0.u.c.d;
import d.a.i0.u.c.e;
import d.a.i0.u.c.f;
import d.a.i0.u.c.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f48323c;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f48324a;

    /* renamed from: b  reason: collision with root package name */
    public String f48325b;

    public b(Context context) {
        a<String> aVar = new a<>();
        this.f48324a = aVar;
        if (context == null) {
            return;
        }
        aVar.a(new c(context));
        this.f48324a.a(new e(context));
        this.f48324a.a(new d(context));
        this.f48324a.a(new g(context));
        this.f48324a.a(new d.a.i0.u.c.a(context));
        this.f48324a.a(new f(context));
    }

    public static b b(Context context) {
        if (f48323c == null) {
            synchronized (b.class) {
                if (f48323c == null) {
                    f48323c = new b(context);
                }
            }
        }
        return f48323c;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f48325b)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f48325b)) {
                    String b2 = this.f48324a.b();
                    this.f48325b = b2;
                    this.f48324a.d(b2);
                }
            }
        }
        return this.f48325b;
    }
}
