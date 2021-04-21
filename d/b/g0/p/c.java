package d.b.g0.p;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class c implements d.b.g0.m.b {

    /* renamed from: a  reason: collision with root package name */
    public b f43742a;

    /* renamed from: b  reason: collision with root package name */
    public String f43743b;

    /* renamed from: c  reason: collision with root package name */
    public Context f43744c;

    /* renamed from: d  reason: collision with root package name */
    public a f43745d;

    @Override // d.b.g0.m.b
    public final String a() {
        if (TextUtils.isEmpty(this.f43743b)) {
            this.f43743b = this.f43742a.a();
        }
        return this.f43743b;
    }

    @Override // d.b.g0.m.b
    public final void a(Context context, d.b.g0.m.c cVar) {
        this.f43742a = new b(context);
        this.f43744c = context;
        if (b()) {
            this.f43745d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f43745d);
        }
    }

    public final boolean b() {
        return "1".equals(d.b.g0.r.a.a("persist.sys.identifierid.supported", "0"));
    }
}
