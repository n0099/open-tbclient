package org.chromium.net;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("net::android")
/* loaded from: classes2.dex */
public class NetworkActivationRequest extends ConnectivityManager.NetworkCallback {
    public final ConnectivityManager mConnectivityManager;
    @GuardedBy("mNativePtrLock")
    public long mNativePtr;
    public final Object mNativePtrLock = new Object();

    /* loaded from: classes2.dex */
    public interface Natives {
        void notifyAvailable(long j, long j2);
    }

    public NetworkActivationRequest(long j, int i) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        this.mConnectivityManager = connectivityManager;
        if (connectivityManager == null) {
            return;
        }
        try {
            connectivityManager.requestNetwork(new NetworkRequest.Builder().addTransportType(i).addCapability(12).build(), this);
            this.mNativePtr = j;
        } catch (SecurityException unused) {
        }
    }

    @CalledByNative
    public static NetworkActivationRequest createMobileNetworkRequest(long j) {
        return new NetworkActivationRequest(j, 0);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        synchronized (this.mNativePtrLock) {
            if (this.mNativePtr == 0) {
                return;
            }
            NetworkActivationRequestJni.get().notifyAvailable(this.mNativePtr, NetworkChangeNotifierAutoDetect.networkToNetId(network));
        }
    }

    @CalledByNative
    private void unregister() {
        boolean z;
        synchronized (this.mNativePtrLock) {
            if (this.mNativePtr != 0) {
                z = true;
            } else {
                z = false;
            }
            this.mNativePtr = 0L;
        }
        if (z) {
            this.mConnectivityManager.unregisterNetworkCallback(this);
        }
    }
}
