package d.a.j0.p;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements d.a.j0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public b f40505a;

    /* renamed from: b  reason: collision with root package name */
    public String f40506b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40507c;

    /* renamed from: d  reason: collision with root package name */
    public a f40508d;

    @Override // d.a.j0.m.b
    public final String a() {
        if (TextUtils.isEmpty(this.f40506b)) {
            this.f40506b = this.f40505a.a();
        }
        return this.f40506b;
    }

    @Override // d.a.j0.m.b
    public final void a(Context context, d.a.j0.m.c cVar) {
        this.f40505a = new b(context);
        this.f40507c = context;
        if (b()) {
            this.f40508d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f40508d);
        }
    }

    public final boolean b() {
        return "1".equals(d.a.j0.r.a.a("persist.sys.identifierid.supported", "0"));
    }
}
