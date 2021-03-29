package d.b.f0.p;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements d.b.f0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public b f43053a;

    /* renamed from: b  reason: collision with root package name */
    public String f43054b;

    /* renamed from: c  reason: collision with root package name */
    public Context f43055c;

    /* renamed from: d  reason: collision with root package name */
    public a f43056d;

    @Override // d.b.f0.m.b
    public final String a() {
        if (TextUtils.isEmpty(this.f43054b)) {
            this.f43054b = this.f43053a.a();
        }
        return this.f43054b;
    }

    @Override // d.b.f0.m.b
    public final void a(Context context, d.b.f0.m.c cVar) {
        this.f43053a = new b(context);
        this.f43055c = context;
        if (b()) {
            this.f43056d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f43056d);
        }
    }

    public final boolean b() {
        return "1".equals(d.b.f0.r.a.a("persist.sys.identifierid.supported", "0"));
    }
}
