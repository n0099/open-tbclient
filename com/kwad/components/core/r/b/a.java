package com.kwad.components.core.r.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.proxy.c;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.k;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.e;
/* loaded from: classes10.dex */
public final class a extends Presenter implements j {
    public FrameLayout SA;
    public aw SB;
    public boolean SC;
    public com.kwad.components.core.r.a.b SD;
    public com.kwad.components.core.l.a.a SE = new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.core.r.b.a.1
        @Override // com.kwad.components.core.l.a.a
        public final void fN() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void c(c cVar) {
            a.this.qG();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void d(c cVar) {
            a.this.qH();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void fO() {
            a.this.qI();
        }
    };
    public i gj;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0664a c0664a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.components.p pVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_activity";
    }

    private void qF() {
        aw awVar = this.SB;
        if (awVar == null) {
            return;
        }
        if (!this.SC) {
            awVar.sg();
            this.SB.sh();
            this.SC = true;
            return;
        }
        awVar.sk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG() {
        qF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qH() {
        aw awVar = this.SB;
        if (awVar != null && this.SC) {
            awVar.sl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qI() {
        aw awVar = this.SB;
        if (awVar != null && this.SC) {
            awVar.si();
            this.SB.sj();
            k kVar = this.SD.St;
            if (kVar != null) {
                kVar.callbackDismiss();
            }
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        qF();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.SA;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return this.SD.Sq.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final e getTouchCoordsView() {
        return this.SD.mRootContainer;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        qI();
        this.gj.jn();
        this.SD.Mm.remove(this.SE);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.SB = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aI = com.kwad.sdk.d.a.a.aI(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        getActivity().finish();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.SD = (com.kwad.components.core.r.a.b) HU();
        this.SA = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09139a);
        i iVar = new i(getContext(), 1000, 0);
        this.gj = iVar;
        iVar.a(this.SD.Sq);
        k kVar = this.SD.St;
        if (kVar != null) {
            kVar.a(this.gj);
            this.gj.a(new g() { // from class: com.kwad.components.core.r.b.a.2
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    k kVar2 = a.this.SD.St;
                    if (kVar2 != null) {
                        kVar2.callTKBridge(str);
                    }
                }
            });
            this.gj.a("hasTKBridge", Boolean.TRUE);
        }
        this.gj.a(getActivity(), this.SD.mAdResultData, this);
        this.SD.Mm.add(this.SE);
    }
}
