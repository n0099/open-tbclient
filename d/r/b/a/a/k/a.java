package d.r.b.a.a.k;

import android.os.Build;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.f.f.b;
import d.r.b.a.a.m.c.a.b;
import d.r.b.a.a.m.c.a.c;
/* loaded from: classes7.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.m.b f68096a;

    /* renamed from: b  reason: collision with root package name */
    public d.r.b.a.a.m.a f68097b;

    public a(d.r.b.a.a.b bVar) {
        e(bVar);
        d.r.b.a.a.m.c.a.b d2 = d(bVar);
        if (d2 == null) {
            d.e("SDKReporter", "new SDKReporter error baseHiidoContent null", new Object[0]);
            return;
        }
        this.f68096a = new d.r.b.a.a.m.b(d2);
        this.f68097b = new d.r.b.a.a.m.a(d2);
    }

    @Override // d.r.b.a.a.f.f.b
    public void a(String str, String str2) {
        d.r.b.a.a.m.b bVar = this.f68096a;
        if (bVar == null) {
            d.e("SDKReporter", "reportUiEvent mUiEventReporter null", new Object[0]);
        } else {
            bVar.b(str, str2);
        }
    }

    @Override // d.r.b.a.a.f.f.b
    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        d.r.b.a.a.m.a aVar = this.f68097b;
        if (aVar == null) {
            d.e("SDKReporter", "reportPayFlow mPayEventReporter null", new Object[0]);
        } else {
            aVar.a(str, str2, str3, str4, str5, str6, str7, str8);
        }
    }

    @Override // d.r.b.a.a.f.f.b
    public void c(String str) {
        d.r.b.a.a.m.b bVar = this.f68096a;
        if (bVar == null) {
            d.e("SDKReporter", "reportUiEvent mUiEventReporter null", new Object[0]);
        } else {
            bVar.a(str);
        }
    }

    public final d.r.b.a.a.m.c.a.b d(d.r.b.a.a.b bVar) {
        if (bVar == null) {
            d.e("SDKReporter", "createBaseContent config null", new Object[0]);
            return null;
        }
        b.a aVar = new b.a();
        aVar.b("lpfrevenuepayoriginal");
        aVar.c(bVar.q() + "");
        aVar.e(bVar.B() + "");
        aVar.d(bVar.A() + "");
        return aVar.a();
    }

    public final void e(d.r.b.a.a.b bVar) {
        if (bVar == null) {
            d.e("SDKReporter", "initHiidoConstantContent config null", new Object[0]);
            return;
        }
        c.f68106a = "";
        c.f68109d = bVar.r();
        c.f68111f = Build.MANUFACTURER + "_" + Build.MODEL;
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append(Build.VERSION.RELEASE);
        c.f68112g = sb.toString();
        if (bVar.y() != null) {
            c.f68108c = bVar.y().getAppName();
        }
        c.f68107b = "4.1.4-bdpay";
    }
}
