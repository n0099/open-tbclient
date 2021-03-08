package com.win.opensdk.poseidon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.bo;
import com.win.opensdk.bp;
import com.win.opensdk.bq;
/* loaded from: classes14.dex */
public class PoseidonReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            bq iS = bq.iS(context);
            Context a2 = iS.a();
            if (a2 != null && iS.qlh != null && bp.u(a2) && iS.qlh.isReady()) {
                iS.qlh.show();
                SharedPreferences.Editor edit = a2.getSharedPreferences("_prefs", 0).edit();
                edit.putFloat("psdpt", (float) System.currentTimeMillis());
                edit.apply();
                return;
            }
            return;
        }
        bq iS2 = bq.iS(context);
        Context a3 = iS2.a();
        if (a3 == null || !bp.u(a3)) {
            return;
        }
        String m = bp.m(a3);
        if (!TextUtils.isEmpty(m)) {
            if (iS2.qlh == null) {
                iS2.qlh = new PBInterstitial(a3, m);
                iS2.qlh.setInterstitialListener(new bo(iS2));
            }
            PBInterstitial pBInterstitial = iS2.qlh;
            if (pBInterstitial == null || pBInterstitial.isReady()) {
                return;
            }
            iS2.qlh.load();
        }
    }
}
