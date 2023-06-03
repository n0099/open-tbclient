package org.chromium.base;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("base::android")
/* loaded from: classes2.dex */
public class PowerMonitor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static PowerMonitor sInstance;
    public boolean mIsBatteryPower;

    /* loaded from: classes2.dex */
    public interface Natives {
        void onBatteryChargingChanged();
    }

    public static void createForTests() {
        sInstance = new PowerMonitor();
    }

    @CalledByNative
    public static int getRemainingBatteryCapacity() {
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        if (sInstance == null) {
            create();
        }
        return getRemainingBatteryCapacityImpl();
    }

    @TargetApi(21)
    public static int getRemainingBatteryCapacityImpl() {
        return ((BatteryManager) ContextUtils.getApplicationContext().getSystemService("batterymanager")).getIntProperty(1);
    }

    @CalledByNative
    public static boolean isBatteryPower() {
        if (sInstance == null) {
            create();
        }
        return sInstance.mIsBatteryPower;
    }

    public static void onBatteryChargingChanged(boolean z) {
        sInstance.mIsBatteryPower = z;
        PowerMonitorJni.get().onBatteryChargingChanged();
    }

    public static void create() {
        ThreadUtils.assertOnUiThread();
        if (sInstance != null) {
            return;
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        sInstance = new PowerMonitor();
        Intent registerReceiver = applicationContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            boolean z = false;
            if (registerReceiver.getIntExtra("plugged", 0) == 0) {
                z = true;
            }
            onBatteryChargingChanged(z);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        applicationContext.registerReceiver(new BroadcastReceiver() { // from class: org.chromium.base.PowerMonitor.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                PowerMonitor.onBatteryChargingChanged(intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED"));
            }
        }, intentFilter);
    }
}
