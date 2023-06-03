package org.chromium.net;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("net::android")
/* loaded from: classes2.dex */
public class AndroidCellularSignalStrength {
    public static final AndroidCellularSignalStrength sInstance = new AndroidCellularSignalStrength();
    public volatile int mSignalLevel = Integer.MIN_VALUE;

    /* loaded from: classes2.dex */
    public class CellStateListener extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final TelephonyManager mTelephonyManager;

        public CellStateListener() {
            ThreadUtils.assertOnBackgroundThread();
            TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
            this.mTelephonyManager = telephonyManager;
            if (telephonyManager.getSimState() != 5) {
                return;
            }
            ApplicationStatus.registerApplicationStateListener(this);
            onApplicationStateChange(ApplicationStatus.getStateForApplication());
        }

        @Override // org.chromium.base.ApplicationStatus.ApplicationStateListener
        public void onApplicationStateChange(int i) {
            if (i == 1) {
                register();
            } else if (i == 2) {
                unregister();
            }
        }

        @Override // android.telephony.PhoneStateListener
        @TargetApi(23)
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (ApplicationStatus.getStateForApplication() != 1) {
                return;
            }
            try {
                AndroidCellularSignalStrength.this.mSignalLevel = signalStrength.getLevel();
            } catch (SecurityException unused) {
                AndroidCellularSignalStrength.this.mSignalLevel = Integer.MIN_VALUE;
            }
        }

        private void register() {
            this.mTelephonyManager.listen(this, 256);
        }

        private void unregister() {
            AndroidCellularSignalStrength.this.mSignalLevel = Integer.MIN_VALUE;
            this.mTelephonyManager.listen(this, 0);
        }
    }

    public AndroidCellularSignalStrength() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("AndroidCellularSignalStrength");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: org.chromium.net.AndroidCellularSignalStrength.1
            @Override // java.lang.Runnable
            public void run() {
                new CellStateListener();
            }
        });
    }

    @TargetApi(23)
    @CalledByNative
    public static int getSignalStrengthLevel() {
        return sInstance.mSignalLevel;
    }
}
