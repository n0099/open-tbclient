package com.kwad.components.core.webview.tachikoma.c;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.j;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.utils.bi;
/* loaded from: classes10.dex */
public class c extends a {
    public FrameLayout SA;
    public e Yv;
    public p aar;
    public aw aas;
    public com.kwad.components.core.webview.tachikoma.e.d aat = new com.kwad.components.core.webview.tachikoma.e.d() { // from class: com.kwad.components.core.webview.tachikoma.c.c.2
        @Override // com.kwad.components.core.webview.tachikoma.e.d
        public final void fP() {
            if (c.this.aas != null) {
                c.this.aas.sg();
                c.this.aas.sh();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.d
        public final void fX() {
            if (c.this.aas != null) {
                c.this.aas.si();
                c.this.aas.sj();
            }
        }
    };
    public String xm;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0664a c0664a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_dialog";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sL() {
        e.a aVar = this.aal.aaq;
        if (aVar != null) {
            aVar.fR();
        }
        com.kwad.components.core.webview.tachikoma.d.b.sS().p(getTkTemplateId(), getTKReaderScene());
        j jVar = this.aal.aan;
        if (jVar != null) {
            jVar.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        e eVar = this.Yv;
        if (eVar != null) {
            eVar.a(this.aat);
        }
        if (this.aal.aan != null) {
            this.gj.a(new g() { // from class: com.kwad.components.core.webview.tachikoma.c.c.1
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    c.this.aal.aan.callTKBridge(str);
                }
            });
            this.aal.aan.a(this.gj);
            this.gj.a("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        j jVar = this.aal.aan;
        if (jVar != null) {
            jVar.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
        super.bG();
        b bVar = this.aal;
        if (bVar.aap) {
            com.kwad.components.core.webview.tachikoma.e.c cVar = bVar.So;
            if (cVar != null) {
                cVar.F(true);
                return;
            }
            return;
        }
        e eVar = this.Yv;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.e.c cVar2 = this.aal.So;
        if (cVar2 != null) {
            cVar2.fY();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.SA;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        StyleTemplate styleTemplate = this.aal.Sq;
        if (styleTemplate != null) {
            return styleTemplate.templateId;
        }
        return this.xm;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.SA = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0914da);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.aas = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aI = com.kwad.sdk.d.a.a.aI(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.Yv;
        if (eVar != null) {
            if (eVar.isShowing()) {
                this.Yv.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.tachikoma.c.c.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        c.this.Yv.e(this);
                        c.this.sL();
                    }
                });
            } else {
                sL();
            }
            this.Yv.dismiss();
            return;
        }
        sL();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
        this.aar = pVar;
        long j = this.aal.xr;
        if (pVar != null && j > 0) {
            y yVar = new y();
            yVar.nD = (int) ((((float) j) / 1000.0f) + 0.5f);
            this.aar.a(yVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        super.a(tVar);
        e eVar = this.Yv;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.aal.So;
        if (cVar != null) {
            cVar.F(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a
    public final void a(b bVar) {
        super.a(bVar);
        b bVar2 = this.aal;
        this.xm = bVar2.xm;
        this.Yv = bVar2.Yv;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        j jVar = this.aal.aan;
        if (jVar != null) {
            jVar.callbackDialogDismiss();
        }
    }
}
