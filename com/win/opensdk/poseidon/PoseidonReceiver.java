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
            Context eIU = iK.eIU();
            if (eIU == null || iK.qiT == null || !az.iM(eIU) || !iK.qiT.isReady()) {
                return;
            }
            iK.qiT.show();
            az.j(eIU, (float) System.currentTimeMillis());
            return;
        }
        final u iK2 = u.iK(context);
        Context eIU2 = iK2.eIU();
        if (eIU2 == null || !az.iM(eIU2)) {
            return;
        }
        String m65c = az.m65c(eIU2);
        if (TextUtils.isEmpty(m65c)) {
            return;
        }
        if (iK2.qiT == null) {
            iK2.qiT = new PBInterstitial(eIU2, m65c);
            iK2.qiT.setInterstitialListener(new PBInterstitialListener() { // from class: com.win.opensdk.u.1
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
        if (iK2.qiT == null || iK2.qiT.isReady()) {
            return;
        }
        iK2.qiT.load();
    }
}
