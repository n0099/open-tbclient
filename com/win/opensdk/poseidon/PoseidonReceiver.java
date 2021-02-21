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
            u iK = u.iK(context);
            Context eJc = iK.eJc();
            if (eJc == null || iK.qjt == null || !az.iM(eJc) || !iK.qjt.isReady()) {
                return;
            }
            iK.qjt.show();
            az.j(eJc, (float) System.currentTimeMillis());
            return;
        }
        final u iK2 = u.iK(context);
        Context eJc2 = iK2.eJc();
        if (eJc2 == null || !az.iM(eJc2)) {
            return;
        }
        String m64c = az.m64c(eJc2);
        if (TextUtils.isEmpty(m64c)) {
            return;
        }
        if (iK2.qjt == null) {
            iK2.qjt = new PBInterstitial(eJc2, m64c);
            iK2.qjt.setInterstitialListener(new PBInterstitialListener() { // from class: com.win.opensdk.u.1
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
        if (iK2.qjt == null || iK2.qjt.isReady()) {
            return;
        }
        iK2.qjt.load();
    }
}
