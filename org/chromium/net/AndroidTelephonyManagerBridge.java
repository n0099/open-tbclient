package org.chromium.net;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.annotation.CheckForNull;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.MainDex;
import org.chromium.net.AndroidTelephonyManagerBridge;
@AnyThread
@MainDex
/* loaded from: classes2.dex */
public class AndroidTelephonyManagerBridge {
    public static volatile AndroidTelephonyManagerBridge sInstance;
    public Listener mListener;
    @CheckForNull
    public volatile String mNetworkCountryIso;
    @CheckForNull
    public volatile String mNetworkOperator;
    @CheckForNull
    public volatile String mSimOperator;

    /* loaded from: classes2.dex */
    public class Listener extends PhoneStateListener {
        @CheckForNull
        public ServiceState mServiceState;

        public Listener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            ServiceState serviceState2 = this.mServiceState;
            if (serviceState2 == null || !serviceState2.equals(serviceState)) {
                this.mServiceState = serviceState;
                AndroidTelephonyManagerBridge.this.update(AndroidTelephonyManagerBridge.access$100());
            }
        }
    }

    public static /* synthetic */ TelephonyManager access$100() {
        return getTelephonyManager();
    }

    public static AndroidTelephonyManagerBridge create() {
        final AndroidTelephonyManagerBridge androidTelephonyManagerBridge = new AndroidTelephonyManagerBridge();
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.smc
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    AndroidTelephonyManagerBridge.a(AndroidTelephonyManagerBridge.this);
                }
            }
        });
        return androidTelephonyManagerBridge;
    }

    public static AndroidTelephonyManagerBridge getInstance() {
        AndroidTelephonyManagerBridge androidTelephonyManagerBridge = sInstance;
        if (androidTelephonyManagerBridge == null) {
            synchronized (AndroidTelephonyManagerBridge.class) {
                androidTelephonyManagerBridge = sInstance;
                if (androidTelephonyManagerBridge == null) {
                    androidTelephonyManagerBridge = create();
                    sInstance = androidTelephonyManagerBridge;
                }
            }
        }
        return androidTelephonyManagerBridge;
    }

    @CheckForNull
    public static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
    }

    public String getNetworkCountryIso() {
        if (this.mNetworkCountryIso == null) {
            TelephonyManager telephonyManager = getTelephonyManager();
            if (telephonyManager == null) {
                return "";
            }
            this.mNetworkCountryIso = telephonyManager.getNetworkCountryIso();
        }
        return this.mNetworkCountryIso;
    }

    public String getNetworkOperator() {
        if (this.mNetworkOperator == null) {
            TelephonyManager telephonyManager = getTelephonyManager();
            if (telephonyManager == null) {
                return "";
            }
            this.mNetworkOperator = telephonyManager.getNetworkOperator();
        }
        return this.mNetworkOperator;
    }

    public String getSimOperator() {
        if (this.mSimOperator == null) {
            TelephonyManager telephonyManager = getTelephonyManager();
            if (telephonyManager == null) {
                return "";
            }
            this.mSimOperator = telephonyManager.getSimOperator();
        }
        return this.mSimOperator;
    }

    public static /* synthetic */ void a(AndroidTelephonyManagerBridge androidTelephonyManagerBridge) {
        TelephonyManager telephonyManager = getTelephonyManager();
        if (telephonyManager != null) {
            androidTelephonyManagerBridge.listenTelephonyServiceState(telephonyManager);
        }
    }

    @MainThread
    private void listenTelephonyServiceState(TelephonyManager telephonyManager) {
        ThreadUtils.assertOnUiThread();
        Listener listener = new Listener();
        this.mListener = listener;
        telephonyManager.listen(listener, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(@CheckForNull TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return;
        }
        this.mNetworkCountryIso = telephonyManager.getNetworkCountryIso();
        this.mNetworkOperator = telephonyManager.getNetworkOperator();
        this.mSimOperator = telephonyManager.getSimOperator();
    }
}
