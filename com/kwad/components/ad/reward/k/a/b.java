package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.tachikoma.c.e;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.core.webview.tachikoma.c.e {
    public static WeakReference<b> xs;
    public g xp;
    public long xr;

    public static boolean jh() {
        WeakReference<b> weakReference = xs;
        if (weakReference != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.b ji() {
        return new a(this.xp);
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.c jj() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final void jk() {
        super.jk();
        this.aal.xr = this.xr;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.xp = null;
        xs = null;
    }

    @Nullable
    public static b a(g gVar, Activity activity, long j, DialogInterface.OnDismissListener onDismissListener, com.kwad.components.core.webview.tachikoma.e.c cVar) {
        if (activity == null || activity.isFinishing() || jh()) {
            return null;
        }
        e.b bVar = new e.b();
        bVar.d(gVar.mAdResultData);
        bVar.aN(com.kwad.sdk.core.response.b.b.du(gVar.mAdTemplate));
        b a = a(gVar, bVar);
        a.So = cVar;
        a.d(onDismissListener);
        a.l(j);
        a.show(activity.getFragmentManager(), "tkExtraReward");
        xs = new WeakReference<>(a);
        return a;
    }

    public static b a(g gVar, e.b bVar) {
        b bVar2 = new b();
        bVar2.xp = gVar;
        bVar2.mAdResultData = bVar.hi();
        bVar2.xm = bVar.getTemplateId();
        bVar2.aap = bVar.kc();
        bVar2.aaz = bVar.sN();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    @Nullable
    public static b a(b bVar, Activity activity, long j, com.kwad.components.core.webview.tachikoma.e.c cVar, e.a aVar) {
        if (activity == null || activity.isFinishing() || jh()) {
            return null;
        }
        bVar.So = cVar;
        bVar.aaq = aVar;
        bVar.show(activity.getFragmentManager(), "tkCloseDialog");
        if (j > 0) {
            bVar.l(j);
        }
        xs = new WeakReference<>(bVar);
        return bVar;
    }

    private void l(long j) {
        this.xr = j;
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.aal;
        if (bVar != null) {
            bVar.xr = j;
        }
    }
}
