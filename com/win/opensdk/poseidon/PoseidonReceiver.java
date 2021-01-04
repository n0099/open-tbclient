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
            Context eJQ = iJ.eJQ();
            if (eJQ == null || iJ.qbH == null || !az.iL(eJQ) || !iJ.qbH.isReady()) {
                return;
            }
            iJ.qbH.show();
            az.j(eJQ, (float) System.currentTimeMillis());
            return;
        }
        final u iJ2 = u.iJ(context);
        Context eJQ2 = iJ2.eJQ();
        if (eJQ2 == null || !az.iL(eJQ2)) {
            return;
        }
        String m58c = az.m58c(eJQ2);
        if (TextUtils.isEmpty(m58c)) {
            return;
        }
        if (iJ2.qbH == null) {
            iJ2.qbH = new PBInterstitial(eJQ2, m58c);
            iJ2.qbH.setInterstitialListener(new PBInterstitialListener() { // from class: com.win.opensdk.u.1
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
        if (iJ2.qbH == null || iJ2.qbH.isReady()) {
            return;
        }
        iJ2.qbH.load();
    }
}
