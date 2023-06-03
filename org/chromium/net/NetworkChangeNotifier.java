package org.chromium.net;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.base.ContextUtils;
import org.chromium.base.ObserverList;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeClassQualifiedName;
import org.chromium.base.compat.ApiHelperForM;
import org.chromium.net.NetworkChangeNotifierAutoDetect;
@JNINamespace("net")
/* loaded from: classes2.dex */
public class NetworkChangeNotifier {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    @SuppressLint({"StaticFieldLeak"})
    public static NetworkChangeNotifier sInstance;
    public NetworkChangeNotifierAutoDetect mAutoDetector;
    public int mCurrentConnectionType = 0;
    public final ArrayList<Long> mNativeChangeNotifiers = new ArrayList<>();
    public final ObserverList<ConnectionTypeObserver> mConnectionTypeObservers = new ObserverList<>();
    public final ConnectivityManager mConnectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");

    /* loaded from: classes2.dex */
    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int i);
    }

    /* loaded from: classes2.dex */
    public interface Natives {
        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyConnectionTypeChanged(long j, NetworkChangeNotifier networkChangeNotifier, int i, long j2);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyMaxBandwidthChanged(long j, NetworkChangeNotifier networkChangeNotifier, int i);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkConnect(long j, NetworkChangeNotifier networkChangeNotifier, long j2, int i);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkDisconnect(long j, NetworkChangeNotifier networkChangeNotifier, long j2);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkSoonToDisconnect(long j, NetworkChangeNotifier networkChangeNotifier, long j2);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyPurgeActiveNetworkList(long j, NetworkChangeNotifier networkChangeNotifier, long[] jArr);
    }

    private void destroyAutoDetector() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
        if (networkChangeNotifierAutoDetect != null) {
            networkChangeNotifierAutoDetect.destroy();
            this.mAutoDetector = null;
        }
    }

    public static NetworkChangeNotifierAutoDetect getAutoDetectorForTest() {
        return getInstance().mAutoDetector;
    }

    public static NetworkChangeNotifier getInstance() {
        return sInstance;
    }

    @CalledByNative
    public static NetworkChangeNotifier init() {
        if (sInstance == null) {
            sInstance = new NetworkChangeNotifier();
        }
        return sInstance;
    }

    public static boolean isInitialized() {
        if (sInstance != null) {
            return true;
        }
        return false;
    }

    public static boolean isOnline() {
        if (getInstance().getCurrentConnectionType() != 6) {
            return true;
        }
        return false;
    }

    @CalledByNative
    public static boolean isProcessBoundToNetwork() {
        return getInstance().isProcessBoundToNetworkInternal();
    }

    private boolean isProcessBoundToNetworkInternal() {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return false;
        }
        if (i < 23) {
            if (ConnectivityManager.getProcessDefaultNetwork() == null) {
                return false;
            }
            return true;
        } else if (ApiHelperForM.getBoundNetworkForProcess(this.mConnectivityManager) == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void registerToReceiveNotificationsAlways() {
        getInstance().setAutoDetectConnectivityStateInternal(true, new RegistrationPolicyAlwaysRegister());
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
        if (networkChangeNotifierAutoDetect == null) {
            return 0;
        }
        return networkChangeNotifierAutoDetect.getCurrentNetworkState().getConnectionSubtype();
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    @CalledByNative
    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
        if (networkChangeNotifierAutoDetect == null) {
            return -1L;
        }
        return networkChangeNotifierAutoDetect.getDefaultNetId();
    }

    @CalledByNative
    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
        if (networkChangeNotifierAutoDetect == null) {
            return new long[0];
        }
        return networkChangeNotifierAutoDetect.getNetworksAndTypes();
    }

    @CalledByNative
    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
        if (networkChangeNotifierAutoDetect == null) {
            return false;
        }
        return networkChangeNotifierAutoDetect.registerNetworkCallbackFailed();
    }

    @CalledByNative
    public static void fakeDefaultNetwork(long j, int i) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionTypeChange(i, j);
    }

    @CalledByNative
    public static void fakeNetworkConnected(long j, int i) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkConnect(j, i);
    }

    private void setAutoDetectConnectivityStateInternal(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.mAutoDetector == null) {
                NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: org.chromium.net.NetworkChangeNotifier.1
                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onConnectionSubtypeChanged(int i) {
                        NetworkChangeNotifier.this.notifyObserversOfConnectionSubtypeChange(i);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onConnectionTypeChanged(int i) {
                        NetworkChangeNotifier.this.updateCurrentConnectionType(i);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onNetworkDisconnect(long j) {
                        NetworkChangeNotifier.this.notifyObserversOfNetworkDisconnect(j);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onNetworkSoonToDisconnect(long j) {
                        NetworkChangeNotifier.this.notifyObserversOfNetworkSoonToDisconnect(j);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void purgeActiveNetworkList(long[] jArr) {
                        NetworkChangeNotifier.this.notifyObserversToPurgeActiveNetworkList(jArr);
                    }

                    @Override // org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onNetworkConnect(long j, int i) {
                        NetworkChangeNotifier.this.notifyObserversOfNetworkConnect(j, i);
                    }
                }, registrationPolicy);
                this.mAutoDetector = networkChangeNotifierAutoDetect;
                NetworkChangeNotifierAutoDetect.NetworkState currentNetworkState = networkChangeNotifierAutoDetect.getCurrentNetworkState();
                updateCurrentConnectionType(currentNetworkState.getConnectionType());
                notifyObserversOfConnectionSubtypeChange(currentNetworkState.getConnectionSubtype());
                return;
            }
            return;
        }
        destroyAutoDetector();
    }

    public void notifyObserversOfNetworkConnect(long j, int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            NetworkChangeNotifierJni.get().notifyOfNetworkConnect(it.next().longValue(), this, j, i);
        }
    }

    public static void addConnectionTypeObserver(ConnectionTypeObserver connectionTypeObserver) {
        getInstance().addConnectionTypeObserverInternal(connectionTypeObserver);
    }

    private void addConnectionTypeObserverInternal(ConnectionTypeObserver connectionTypeObserver) {
        this.mConnectionTypeObservers.addObserver(connectionTypeObserver);
    }

    @CalledByNative
    public static void fakeConnectionSubtypeChanged(int i) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionSubtypeChange(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkDisconnect(j);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkSoonToDisconnect(j);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(long[] jArr) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversToPurgeActiveNetworkList(jArr);
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        setAutoDetectConnectivityState(false);
        getInstance().forceConnectivityStateInternal(z);
    }

    private void forceConnectivityStateInternal(boolean z) {
        boolean z2;
        int i = 0;
        if (this.mCurrentConnectionType != 6) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            if (!z) {
                i = 6;
            }
            updateCurrentConnectionType(i);
            notifyObserversOfConnectionSubtypeChange(!z);
        }
    }

    public static void removeConnectionTypeObserver(ConnectionTypeObserver connectionTypeObserver) {
        getInstance().removeConnectionTypeObserverInternal(connectionTypeObserver);
    }

    private void removeConnectionTypeObserverInternal(ConnectionTypeObserver connectionTypeObserver) {
        this.mConnectionTypeObservers.removeObserver(connectionTypeObserver);
    }

    @VisibleForTesting
    public static void resetInstanceForTests(NetworkChangeNotifier networkChangeNotifier) {
        sInstance = networkChangeNotifier;
    }

    public static void setAutoDetectConnectivityState(NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        getInstance().setAutoDetectConnectivityStateInternal(true, registrationPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConnectionType(int i) {
        this.mCurrentConnectionType = i;
        notifyObserversOfConnectionTypeChange(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.mNativeChangeNotifiers.add(Long.valueOf(j));
    }

    public void notifyObserversOfConnectionSubtypeChange(int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            NetworkChangeNotifierJni.get().notifyMaxBandwidthChanged(it.next().longValue(), this, i);
        }
    }

    public void notifyObserversOfConnectionTypeChange(int i) {
        notifyObserversOfConnectionTypeChange(i, getCurrentDefaultNetId());
    }

    public void notifyObserversOfNetworkDisconnect(long j) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            NetworkChangeNotifierJni.get().notifyOfNetworkDisconnect(it.next().longValue(), this, j);
        }
    }

    public void notifyObserversOfNetworkSoonToDisconnect(long j) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            NetworkChangeNotifierJni.get().notifyOfNetworkSoonToDisconnect(it.next().longValue(), this, j);
        }
    }

    public void notifyObserversToPurgeActiveNetworkList(long[] jArr) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            NetworkChangeNotifierJni.get().notifyPurgeActiveNetworkList(it.next().longValue(), this, jArr);
        }
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.mNativeChangeNotifiers.remove(Long.valueOf(j));
    }

    private void notifyObserversOfConnectionTypeChange(int i, long j) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            NetworkChangeNotifierJni.get().notifyConnectionTypeChanged(it.next().longValue(), this, i, j);
        }
        Iterator<ConnectionTypeObserver> it2 = this.mConnectionTypeObservers.iterator();
        while (it2.hasNext()) {
            it2.next().onConnectionTypeChanged(i);
        }
    }

    public static void setAutoDetectConnectivityState(boolean z) {
        getInstance().setAutoDetectConnectivityStateInternal(z, new RegistrationPolicyApplicationStatus());
    }
}
