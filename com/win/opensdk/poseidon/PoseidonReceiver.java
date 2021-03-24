package com.win.opensdk.poseidon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.V0;
import com.win.opensdk.V1;
import com.win.opensdk.W0;
/* loaded from: classes7.dex */
public class PoseidonReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            W0 a2 = W0.a(context);
            Context a3 = a2.a();
            if (a3 == null || a2.f39826b == null || !V1.u(a3) || !a2.f39826b.isReady()) {
                return;
            }
            a2.f39826b.show();
            SharedPreferences.Editor edit = a3.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("psdpt", (float) System.currentTimeMillis());
            edit.apply();
            return;
        }
        W0 a4 = W0.a(context);
        Context a5 = a4.a();
        if (a5 == null || !V1.u(a5)) {
            return;
        }
        String m = V1.m(a5);
        if (TextUtils.isEmpty(m)) {
            return;
        }
        if (a4.f39826b == null) {
            PBInterstitial pBInterstitial = new PBInterstitial(a5, m);
            a4.f39826b = pBInterstitial;
            pBInterstitial.setInterstitialListener(new V0(a4));
        }
        PBInterstitial pBInterstitial2 = a4.f39826b;
        if (pBInterstitial2 == null || pBInterstitial2.isReady()) {
            return;
        }
        a4.f39826b.load();
    }
}
