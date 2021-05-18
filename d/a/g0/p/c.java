package d.a.g0.p;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements d.a.g0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public b f40244a;

    /* renamed from: b  reason: collision with root package name */
    public String f40245b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40246c;

    /* renamed from: d  reason: collision with root package name */
    public a f40247d;

    @Override // d.a.g0.m.b
    public final String a() {
        if (TextUtils.isEmpty(this.f40245b)) {
            this.f40245b = this.f40244a.a();
        }
        return this.f40245b;
    }

    @Override // d.a.g0.m.b
    public final void a(Context context, d.a.g0.m.c cVar) {
        this.f40244a = new b(context);
        this.f40246c = context;
        if (b()) {
            this.f40247d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f40247d);
        }
    }

    public final boolean b() {
        return "1".equals(d.a.g0.r.a.a("persist.sys.identifierid.supported", "0"));
    }
}
