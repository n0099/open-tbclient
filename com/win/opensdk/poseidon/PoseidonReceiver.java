package com.win.opensdk.poseidon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
import com.win.opensdk.az;
import com.win.opensdk.u;
/* loaded from: classes3.dex */
public class PoseidonReceiver extends BroadcastReceiver {
    private String java = "Poseidon";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            u iH = u.iH(context);
            Context eGE = iH.eGE();
            if (eGE == null || iH.pYP == null || !az.iJ(eGE) || !iH.pYP.isReady()) {
                return;
            }
            iH.pYP.show();
            az.j(eGE, (float) System.currentTimeMillis());
            return;
        }
        final u iH2 = u.iH(context);
        Context eGE2 = iH2.eGE();
        if (eGE2 == null || !az.iJ(eGE2)) {
            return;
        }
        String m65c = az.m65c(eGE2);
        if (TextUtils.isEmpty(m65c)) {
            return;
        }
        if (iH2.pYP == null) {
            iH2.pYP = new PBInterstitial(eGE2, m65c);
            iH2.pYP.setInterstitialListener(new PBInterstitialListener() { // from class: com.win.opensdk.u.1
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
        if (iH2.pYP == null || iH2.pYP.isReady()) {
            return;
        }
        iH2.pYP.load();
    }
}
