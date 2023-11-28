package com.kwad.components.core.q;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.c.e;
/* loaded from: classes10.dex */
public final class b extends e {
    public com.kwad.components.core.webview.tachikoma.e.c So;

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.b ji() {
        return super.ji();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.c jj() {
        return new c();
    }

    @Nullable
    public static b a(b bVar, Activity activity, com.kwad.components.core.webview.tachikoma.e.c cVar) {
        if (activity != null && !activity.isFinishing()) {
            bVar.So = cVar;
            bVar.show(activity.getFragmentManager(), "webTKCloseDialog");
            return bVar;
        }
        return null;
    }

    public static b a(e.b bVar) {
        b bVar2 = new b();
        bVar2.mAdResultData = bVar.hi();
        bVar2.xm = bVar.getTemplateId();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.So;
        if (cVar != null) {
            cVar.fX();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e, android.app.Fragment
    public final void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.So;
        if (cVar != null) {
            cVar.fP();
        }
    }
}
