package d.a.j0.q;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class c implements d.a.j0.n.a {

    /* renamed from: a  reason: collision with root package name */
    public b f44182a;

    /* renamed from: b  reason: collision with root package name */
    public String f44183b;

    /* renamed from: c  reason: collision with root package name */
    public Context f44184c;

    /* renamed from: d  reason: collision with root package name */
    public a f44185d;

    @Override // d.a.j0.n.a
    public String a() {
        if (TextUtils.isEmpty(this.f44183b)) {
            this.f44183b = this.f44182a.a(0, null);
        }
        return this.f44183b;
    }

    @Override // d.a.j0.n.a
    public void a(Context context, d.a.j0.n.b bVar) {
        this.f44182a = new b(context);
        this.f44184c = context;
        if (b()) {
            this.f44185d = new a(this);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f44185d);
        }
        if (bVar != null) {
            bVar.a();
        }
    }

    public boolean b() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.identifierid.supported", "0");
        } catch (Throwable unused) {
            str = null;
        }
        return "1".equals(str);
    }
}
