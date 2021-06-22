package d.a.m0.u;

import android.content.Context;
import android.text.TextUtils;
import d.a.m0.u.c.c;
import d.a.m0.u.c.d;
import d.a.m0.u.c.e;
import d.a.m0.u.c.f;
import d.a.m0.u.c.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f52281c;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f52282a;

    /* renamed from: b  reason: collision with root package name */
    public String f52283b;

    public b(Context context) {
        a<String> aVar = new a<>();
        this.f52282a = aVar;
        if (context == null) {
            return;
        }
        aVar.a(new c(context));
        this.f52282a.a(new e(context));
        this.f52282a.a(new d(context));
        this.f52282a.a(new g(context));
        this.f52282a.a(new d.a.m0.u.c.a(context));
        this.f52282a.a(new f(context));
    }

    public static b b(Context context) {
        if (f52281c == null) {
            synchronized (b.class) {
                if (f52281c == null) {
                    f52281c = new b(context);
                }
            }
        }
        return f52281c;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f52283b)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f52283b)) {
                    String b2 = this.f52282a.b();
                    this.f52283b = b2;
                    this.f52282a.d(b2);
                }
            }
        }
        return this.f52283b;
    }
}
