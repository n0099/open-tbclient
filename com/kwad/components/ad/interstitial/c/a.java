package com.kwad.components.ad.interstitial.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static boolean c(final c cVar) {
        Activity ownerActivity;
        Dialog dialog = cVar.gi;
        if (dialog != null && (ownerActivity = dialog.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo bQ = d.bQ(cVar.mAdTemplate);
            int cp = com.kwad.components.ad.interstitial.a.b.cp();
            int cq = com.kwad.components.ad.interstitial.a.b.cq();
            if (cp > com.kwad.sdk.core.response.a.a.bp(bQ) && cq < com.kwad.sdk.core.response.a.a.bq(bQ)) {
                if (com.kwad.sdk.core.response.a.a.br(bQ) == 2) {
                    com.kwad.components.ad.interstitial.widget.d.d(cVar);
                    return true;
                } else if (com.kwad.sdk.core.response.a.a.br(bQ) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.a.a.bs(bQ), new a.InterfaceC0657a() { // from class: com.kwad.components.ad.interstitial.c.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0657a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.report.a.c(c.this.mAdTemplate, (JSONObject) null, new f().aM(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0657a
                        public final void b(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.report.a.a(c.this.mAdTemplate, new f().aK(Cea708Decoder.COMMAND_SWA).aM(8));
                            c.this.gi.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0657a
                        public final void c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new f().aK(149).aM(8));
                    return true;
                }
            }
        }
        return false;
    }
}
