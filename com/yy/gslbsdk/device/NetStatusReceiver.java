package com.yy.gslbsdk.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.yy.gslbsdk.util.LogTools;
import java.util.Locale;
/* loaded from: classes8.dex */
public class NetStatusReceiver {
    public static final String TAG = "NetStatusReceiver";
    public ChangeNetworkInter mChangeNetworkInter;
    public boolean mRegistered = false;
    public BroadcastReceiver mNetReceiver = new BroadcastReceiver() { // from class: com.yy.gslbsdk.device.NetStatusReceiver.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && NetStatusReceiver.this.mRegistered && NetStatusReceiver.this.mChangeNetworkInter != null) {
                NetStatusReceiver.this.mChangeNetworkInter.onNetStateChanged();
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface ChangeNetworkInter {
        void onNetStateChanged();
    }

    public NetStatusReceiver(ChangeNetworkInter changeNetworkInter) {
        this.mChangeNetworkInter = null;
        this.mChangeNetworkInter = changeNetworkInter;
    }

    public void register(Context context) {
        if (context != null && !this.mRegistered) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                context.registerReceiver(this.mNetReceiver, intentFilter);
                this.mRegistered = true;
            } catch (Exception e) {
                LogTools.printWarning(TAG, String.format(Locale.US, "register net receiver failed! error: %s", e.getMessage()));
            }
        }
    }

    public void unregister(Context context) {
        if (context != null && this.mRegistered) {
            context.unregisterReceiver(this.mNetReceiver);
            this.mRegistered = false;
        }
    }
}
