package com.win.opensdk.poseidon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
import com.win.opensdk.az;
import com.win.opensdk.u;
/* loaded from: classes4.dex */
public class PoseidonReceiver extends BroadcastReceiver {
    private String java = "Poseidon";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            u iJ = u.iJ(context);
            Context eKu = iJ.eKu();
            if (eKu == null || iJ.qdp == null || !az.iL(eKu) || !iJ.qdp.isReady()) {
                return;
            }
            iJ.qdp.show();
            az.j(eKu, (float) System.currentTimeMillis());
            return;
        }
        final u iJ2 = u.iJ(context);
        Context eKu2 = iJ2.eKu();
        if (eKu2 == null || !az.iL(eKu2)) {
            return;
        }
        String m69c = az.m69c(eKu2);
        if (TextUtils.isEmpty(m69c)) {
            return;
        }
        if (iJ2.qdp == null) {
            iJ2.qdp = new PBInterstitial(eKu2, m69c);
            iJ2.qdp.setInterstitialListener(new PBInterstitialListener() { // from class: com.win.opensdk.u.1
                @Override // com.win.opensdk.PBListener
                public final void onFail(PBError pBError) {
                }

                @Override // com.win.opensdk.PBListener
                public final void onLoaded() {
                }

                @Override // com.win.opensdk.PBInterstitialListener
                public final void onInterstitialDismissed() {
                }

                @Override // com.win.opensdk.PBInterstitialListener
                public final void onInterstitialDisplayed() {
                }

                @Override // com.win.opensdk.PBInterstitialListener
                public final void onInterstitialShowFail(String str) {
                }

                @Override // com.win.opensdk.PBListener
                public final void onClicked() {
                }
            });
        }
        if (iJ2.qdp == null || iJ2.qdp.isReady()) {
            return;
        }
        iJ2.qdp.load();
    }
}
