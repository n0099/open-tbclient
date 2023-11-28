package com.kwad.components.ad.interstitial.f;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static boolean d(final c cVar) {
        Activity ownerActivity;
        d dVar = cVar.io;
        if (dVar != null && (ownerActivity = dVar.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo dP = e.dP(cVar.mAdTemplate);
            int cM = com.kwad.components.ad.interstitial.c.b.cM();
            int cN = com.kwad.components.ad.interstitial.c.b.cN();
            if (cM > com.kwad.sdk.core.response.b.a.cl(dP) && cN < com.kwad.sdk.core.response.b.a.cm(dP)) {
                if (com.kwad.sdk.core.response.b.a.cn(dP) == 2) {
                    com.kwad.components.ad.interstitial.g.b.e(cVar);
                    return true;
                } else if (com.kwad.sdk.core.response.b.a.cn(dP) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.b.a.co(dP), new a.InterfaceC0658a() { // from class: com.kwad.components.ad.interstitial.f.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0658a
                        public final void c(DialogInterface dialogInterface) {
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0658a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.report.a.c(c.this.mAdTemplate, (JSONObject) null, new j().cH(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0658a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = c.this;
                            cVar2.a(false, -1, cVar2.eN);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.report.a.e(c.this.mAdTemplate, (JSONObject) null, new j().cC(Cea708Decoder.COMMAND_SWA).cH(8));
                            c.this.io.dismiss();
                        }
                    }).show();
                    com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new j().cC(149).cH(8));
                    return true;
                }
            }
        }
        return false;
    }
}
