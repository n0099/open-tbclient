package com.kwad.components.core.webview.b.b;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.a.s;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.sdk.utils.az;
/* loaded from: classes9.dex */
public class c extends a {
    public d Ne;
    public String Od;
    public FrameLayout Oh;
    public j Oi;
    public aa Oj;
    public com.kwad.components.core.webview.b.d.d Ok = new com.kwad.components.core.webview.b.d.d() { // from class: com.kwad.components.core.webview.b.b.c.1
        @Override // com.kwad.components.core.webview.b.d.d
        public final void fH() {
            if (c.this.Oj != null) {
                c.this.Oj.py();
                c.this.Oj.pz();
            }
        }

        @Override // com.kwad.components.core.webview.b.d.d
        public final void pO() {
            if (c.this.Oj != null) {
                c.this.Oj.pA();
                c.this.Oj.pB();
            }
        }
    };

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.components.core.webview.b.e
    public final void a(q qVar) {
        super.a(qVar);
        d dVar = this.Ne;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.kwad.components.core.webview.b.d.c cVar = this.Ob.Of;
        if (cVar != null) {
            cVar.G(true);
        }
    }

    @Override // com.kwad.components.core.webview.b.b.a
    public final void a(b bVar) {
        super.a(bVar);
        b bVar2 = this.Ob;
        this.Od = bVar2.Od;
        this.Ne = bVar2.Ne;
    }

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.components.core.webview.b.e
    public final void a(j jVar) {
        this.Oi = jVar;
        long j = this.Ob.tS;
        if (jVar == null || j <= 0) {
            return;
        }
        s sVar = new s();
        sVar.kD = (int) (j / 1000);
        this.Oi.a(sVar);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(aa aaVar) {
        this.Oj = aaVar;
    }

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        d dVar = this.Ne;
        if (dVar != null) {
            dVar.a(this.Ok);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
        float aI = com.kwad.sdk.b.kwai.a.aI(getContext());
        aVar.width = (int) ((az.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((az.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        return this.Od;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        return this.Oh;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        d.a aVar = this.Ob.Og;
        if (aVar != null) {
            aVar.fG();
        }
        com.kwad.components.core.webview.b.c.a.pR().aK(bZ());
        d dVar = this.Ne;
        if (dVar != null) {
            dVar.dismiss();
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dF() {
    }

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.components.core.webview.b.e
    public final void dI() {
        super.dI();
        b bVar = this.Ob;
        if (bVar.Oe) {
            com.kwad.components.core.webview.b.d.c cVar = bVar.Of;
            if (cVar != null) {
                cVar.G(true);
                return;
            }
            return;
        }
        d dVar = this.Ne;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.kwad.components.core.webview.b.d.c cVar2 = this.Ob.Of;
        if (cVar2 != null) {
            cVar2.fI();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Oh = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0913db);
    }
}
