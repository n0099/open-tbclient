package com.qq.e.comm.plugin.splash;

import android.view.ViewGroup;
import com.qq.e.comm.plugin.ad.q;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.util.GDTLogger;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private b f12809a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.c.a.a f12810b;

    public e(b bVar, com.qq.e.comm.plugin.c.a.a aVar) {
        this.f12809a = bVar;
        this.f12810b = aVar;
    }

    private int a(int i) {
        if (i == 7) {
            return 8;
        }
        return i == 8 ? 11 : 0;
    }

    private String a(int i, q qVar, ViewGroup viewGroup, com.qq.e.comm.plugin.ad.g gVar) {
        try {
            gVar.b(System.currentTimeMillis());
            gVar.a().a("41");
            gVar.a().b(viewGroup.getWidth());
            gVar.a().a(viewGroup.getHeight());
            gVar.a().c(qVar == q.IMG ? 2 : 1);
            gVar.a().d(i);
            return URLEncoder.encode(gVar.b(), "UTF-8");
        } catch (Exception e) {
            GDTLogger.w("GetAntiSpamInfoException:" + e.getMessage());
            return null;
        }
    }

    private void a(com.qq.e.comm.plugin.s.f fVar, String str, int i, boolean z, int i2) {
        d.a a2 = com.qq.e.comm.plugin.w.i.a(fVar);
        d.e eVar = new d.e(fVar.D(), fVar.C(), fVar.B());
        boolean v = fVar.v();
        GDTLogger.d("deep link need confirm:" + z);
        int i3 = v ? 1 : 0;
        if (fVar.a_() == 48) {
            i3 = 48;
        }
        com.qq.e.comm.plugin.w.a.d.a(this.f12809a, a2, eVar, new d.b(i3, d.c.InnerBrowser).a(str).b(i2).c(i).b(z));
    }

    private void b(com.qq.e.comm.plugin.s.f fVar, String str, int i, boolean z, int i2) {
        com.qq.e.comm.plugin.c.e.a(new f.a(fVar, this.f12809a).a(str).a(i).c(z).b(false).e(true).a(), this.f12810b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.qq.e.comm.plugin.s.f fVar, int i, q qVar, ViewGroup viewGroup, com.qq.e.comm.plugin.ad.g gVar) {
        boolean c = i.c(fVar.B());
        int d = i.d(fVar.B());
        int a2 = a(i);
        String a3 = a(a2, qVar, viewGroup, gVar);
        if (com.qq.e.comm.plugin.c.e.a(fVar)) {
            b(fVar, a3, a2, c, d);
        } else {
            a(fVar, a3, a2, c, d);
        }
    }
}
