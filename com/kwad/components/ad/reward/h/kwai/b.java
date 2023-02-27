package com.kwad.components.ad.reward.h.kwai;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public final class b extends com.kwad.components.core.webview.b.b.d {
    public static WeakReference<b> tT;
    public long tS;

    @Nullable
    public static b a(Activity activity, AdTemplate adTemplate, long j, DialogInterface.OnDismissListener onDismissListener, com.kwad.components.core.webview.b.d.c cVar) {
        if (activity == null || activity.isFinishing() || il()) {
            return null;
        }
        d.b bVar = new d.b();
        bVar.setAdTemplate(adTemplate);
        bVar.aI("ksad-video-secondclick-card");
        b a = a(bVar);
        a.Of = cVar;
        a.On = onDismissListener;
        a.g(j);
        a.show(activity.getFragmentManager(), "tkExtraReward");
        tT = new WeakReference<>(a);
        return a;
    }

    @Nullable
    public static b a(b bVar, Activity activity, long j, com.kwad.components.core.webview.b.d.c cVar, d.a aVar) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        bVar.Of = cVar;
        bVar.Og = aVar;
        bVar.show(activity.getFragmentManager(), "tkCloseDialog");
        if (j > 0) {
            bVar.g(j);
        }
        return bVar;
    }

    public static b a(d.b bVar) {
        b bVar2 = new b();
        bVar2.mAdTemplate = bVar.getAdTemplate();
        bVar2.Od = bVar.getTemplateId();
        bVar2.Oe = bVar.pP();
        bVar2.Oo = bVar.pQ();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    private void g(long j) {
        this.tS = j;
        com.kwad.components.core.webview.b.b.b bVar = this.Ob;
        if (bVar != null) {
            bVar.tS = j;
        }
    }

    public static boolean il() {
        WeakReference<b> weakReference = tT;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    @Override // com.kwad.components.core.webview.b.b.d
    public final com.kwad.components.core.webview.b.b.b im() {
        return new a();
    }

    @Override // com.kwad.components.core.webview.b.b.d
    public final com.kwad.components.core.webview.b.b.c in() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.b.b.d
    public final void io() {
        super.io();
        this.Ob.tS = this.tS;
    }

    @Override // com.kwad.components.core.webview.b.b.d, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tT = null;
    }
}
