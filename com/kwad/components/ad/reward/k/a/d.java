package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.ad.reward.k.n;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes10.dex */
public final class d extends i implements r, w.b {
    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public WeakReference<g> qg;
    @Nullable
    public DialogInterface.OnDismissListener xA;
    public com.kwad.components.ad.reward.c.e xv;
    public m xw;
    public l xx;
    public n xy;
    public List<AdTemplate> xz;

    public d(@NonNull g gVar, long j, Context context) {
        super(j, context);
        this.xz = null;
        this.qg = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(@Nullable Activity activity, AdResultData adResultData, j jVar) {
        g gVar;
        super.a(activity, adResultData, jVar);
        WeakReference<g> weakReference = this.qg;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        if (gVar != null) {
            gVar.a(this);
        }
    }

    public d(g gVar, long j, Context context, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(-1L, context);
        this.xz = null;
        this.xA = onDismissListener;
        this.qg = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.w.b
    public final void N(AdTemplate adTemplate) {
        g gVar;
        com.kwad.components.core.i.c cVar = new com.kwad.components.core.i.c(adTemplate, com.kwad.components.core.i.e.AGGREGATION);
        WeakReference<g> weakReference = this.qg;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    @Override // com.kwad.components.ad.reward.k.r
    public final void aa(boolean z) {
        n nVar = this.xy;
        if (nVar != null) {
            nVar.Z(z);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final ak c(com.kwad.sdk.core.webview.b bVar) {
        g gVar;
        WeakReference<g> weakReference = this.qg;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        return new p(gVar, getTkTemplateId(), this.xr, bVar);
    }

    public final void h(List<AdTemplate> list) {
        this.xz = list;
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.components.p pVar, ViewGroup viewGroup) {
        g gVar;
        g gVar2;
        g gVar3;
        super.a(bVar, cVar, pVar, viewGroup);
        this.mApkDownloadHelper = cVar;
        WeakReference<g> weakReference = this.qg;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        com.kwad.sdk.core.webview.c.a qVar = new q(bVar, cVar, gVar, this.xr, this, this.xA);
        com.kwad.components.core.e.e.g.oh().a(this);
        pVar.c(qVar);
        com.kwad.components.ad.reward.c.e eVar = new com.kwad.components.ad.reward.c.e();
        this.xv = eVar;
        pVar.c(eVar);
        Context context = this.mContext;
        WeakReference<g> weakReference2 = this.qg;
        if (weakReference2 != null) {
            gVar2 = weakReference2.get();
        } else {
            gVar2 = null;
        }
        pVar.c(new s(context, gVar2));
        WeakReference<g> weakReference3 = this.qg;
        if (weakReference3 != null) {
            gVar3 = weakReference3.get();
        } else {
            gVar3 = null;
        }
        pVar.c(new o(gVar3));
        m mVar = new m();
        this.xw = mVar;
        pVar.c(mVar);
        l lVar = new l();
        this.xx = lVar;
        pVar.c(lVar);
        List<AdTemplate> list = this.xz;
        if (list != null) {
            this.xx.g(list);
            this.xz = null;
        }
        w wVar = new w(bVar);
        wVar.a(this);
        pVar.c(wVar);
        n nVar = new n();
        this.xy = nVar;
        pVar.c(nVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void dismiss() {
        WeakReference<g> weakReference = this.qg;
        if (weakReference != null) {
            weakReference.get().D(false);
        }
        super.dismiss();
    }

    public final BackPressHandleResult gl() {
        m mVar = this.xw;
        if (mVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        mVar.je();
        return BackPressHandleResult.HANDLED;
    }

    public final com.kwad.components.ad.reward.c.e jl() {
        return this.xv;
    }

    public final l jm() {
        return this.xx;
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void jn() {
        g gVar;
        super.jn();
        WeakReference<g> weakReference = this.qg;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        if (gVar != null) {
            gVar.b(this);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void show() {
        super.show();
        WeakReference<g> weakReference = this.qg;
        if (weakReference != null) {
            weakReference.get().D(true);
        }
    }
}
