package org.chromium.net;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.kuaishou.weapon.p0.g;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.BuildConfig;
import org.chromium.base.ContextUtils;
import org.chromium.base.StrictModeContext;
import org.chromium.base.compat.ApiHelperForM;
import org.chromium.base.compat.ApiHelperForP;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    public static final String TAG = NetworkChangeNotifierAutoDetect.class.getSimpleName();
    public static final int UNKNOWN_LINK_SPEED = -1;
    public ConnectivityManager.NetworkCallback mDefaultNetworkCallback;
    public boolean mIgnoreNextBroadcast;
    public final NetworkConnectivityIntentFilter mIntentFilter;
    public MyNetworkCallback mNetworkCallback;
    public NetworkRequest mNetworkRequest;
    public NetworkState mNetworkState;
    public final Observer mObserver;
    public boolean mRegisterNetworkCallbackFailed;
    public boolean mRegistered;
    public final RegistrationPolicy mRegistrationPolicy;
    public boolean mShouldSignalObserver;
    public WifiManagerDelegate mWifiManagerDelegate;
    public final Looper mLooper = Looper.myLooper();
    public final Handler mHandler = new Handler(this.mLooper);
    public ConnectivityManagerDelegate mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.getApplicationContext());

    /* loaded from: classes2.dex */
    public interface Observer {
        void onConnectionSubtypeChanged(int i);

        void onConnectionTypeChanged(int i);

        void onNetworkConnect(long j, int i);

        void onNetworkDisconnect(long j);

        void onNetworkSoonToDisconnect(long j);

        void purgeActiveNetworkList(long[] jArr);
    }

    public static int convertToConnectionType(int i, int i2) {
        if (i != 0) {
            if (i == 1) {
                return 2;
            }
            if (i != 4 && i != 5) {
                if (i != 6) {
                    if (i != 7) {
                        return i != 9 ? 0 : 1;
                    }
                    return 7;
                }
                return 5;
            }
        }
        if (i2 != 20) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 3;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 4;
                case 13:
                    return 5;
                default:
                    return 0;
            }
        }
        return 8;
    }

    @TargetApi(28)
    /* loaded from: classes2.dex */
    public class AndroidRDefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        public LinkProperties mLinkProperties;
        public NetworkCapabilities mNetworkCapabilities;

        public AndroidRDefaultNetworkCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
            if (!NetworkChangeNotifierAutoDetect.this.mRegistered) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.connectionTypeChangedTo(new NetworkState(false, -1, -1, null, false, ""));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            this.mNetworkCapabilities = networkCapabilities;
            if (!NetworkChangeNotifierAutoDetect.this.mRegistered || this.mLinkProperties == null || this.mNetworkCapabilities == null) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.connectionTypeChangedTo(getNetworkState(network));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            this.mLinkProperties = linkProperties;
            if (!NetworkChangeNotifierAutoDetect.this.mRegistered || this.mLinkProperties == null || this.mNetworkCapabilities == null) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.connectionTypeChangedTo(getNetworkState(network));
        }

        private NetworkState getNetworkState(Network network) {
            int i;
            int i2;
            int i3 = -1;
            if (!this.mNetworkCapabilities.hasTransport(1) && !this.mNetworkCapabilities.hasTransport(5)) {
                if (this.mNetworkCapabilities.hasTransport(0)) {
                    NetworkInfo networkInfo = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkInfo(network);
                    if (networkInfo != null) {
                        i3 = networkInfo.getSubtype();
                    }
                    i2 = i3;
                    i = 0;
                    return new NetworkState(true, i, i2, String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(network)), ApiHelperForP.isPrivateDnsActive(this.mLinkProperties), ApiHelperForP.getPrivateDnsServerName(this.mLinkProperties));
                } else if (this.mNetworkCapabilities.hasTransport(3)) {
                    i = 9;
                } else if (this.mNetworkCapabilities.hasTransport(2)) {
                    i = 7;
                } else if (this.mNetworkCapabilities.hasTransport(4)) {
                    i = 17;
                } else {
                    i = -1;
                }
            } else {
                i = 1;
            }
            i2 = -1;
            return new NetworkState(true, i, i2, String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(network)), ApiHelperForP.isPrivateDnsActive(this.mLinkProperties), ApiHelperForP.getPrivateDnsServerName(this.mLinkProperties));
        }
    }

    /* loaded from: classes2.dex */
    public static class ConnectivityManagerDelegate {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final ConnectivityManager mConnectivityManager;

        public ConnectivityManagerDelegate() {
            this.mConnectivityManager = null;
        }

        @TargetApi(21)
        @VisibleForTesting
        public Network[] getAllNetworksUnfiltered() {
            Network[] allNetworks = this.mConnectivityManager.getAllNetworks();
            if (allNetworks == null) {
                return new Network[0];
            }
            return allNetworks;
        }

        public ConnectivityManagerDelegate(Context context) {
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        @TargetApi(21)
        private NetworkInfo processActiveNetworkInfo(NetworkInfo networkInfo) {
            if (networkInfo == null) {
                return null;
            }
            if (networkInfo.isConnected()) {
                return networkInfo;
            }
            if (Build.VERSION.SDK_INT < 21 || networkInfo.getDetailedState() != NetworkInfo.DetailedState.BLOCKED || ApplicationStatus.getStateForApplication() != 1) {
                return null;
            }
            return networkInfo;
        }

        @TargetApi(21)
        public int getConnectionType(Network network) {
            NetworkInfo networkInfo = getNetworkInfo(network);
            if (networkInfo != null && networkInfo.getType() == 17) {
                networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                return 6;
            }
            return NetworkChangeNotifierAutoDetect.convertToConnectionType(networkInfo.getType(), networkInfo.getSubtype());
        }

        @TargetApi(21)
        @VisibleForTesting
        public NetworkCapabilities getNetworkCapabilities(Network network) {
            return this.mConnectivityManager.getNetworkCapabilities(network);
        }

        public NetworkInfo getNetworkInfo(Network network) {
            try {
                try {
                    return this.mConnectivityManager.getNetworkInfo(network);
                } catch (NullPointerException unused) {
                    return null;
                }
            } catch (NullPointerException unused2) {
                return this.mConnectivityManager.getNetworkInfo(network);
            }
        }

        @TargetApi(21)
        public void unregisterNetworkCallback(ConnectivityManager.NetworkCallback networkCallback) {
            this.mConnectivityManager.unregisterNetworkCallback(networkCallback);
        }

        @TargetApi(21)
        @VisibleForTesting
        public boolean vpnAccessible(Network network) {
            Socket socket = new Socket();
            try {
                StrictModeContext allowAllVmPolicies = StrictModeContext.allowAllVmPolicies();
                try {
                    network.bindSocket(socket);
                    if (allowAllVmPolicies != null) {
                        allowAllVmPolicies.close();
                    }
                    try {
                        socket.close();
                        return true;
                    } catch (IOException unused) {
                        return true;
                    }
                } catch (Throwable th) {
                    if (allowAllVmPolicies != null) {
                        try {
                            allowAllVmPolicies.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                try {
                    socket.close();
                } catch (IOException unused3) {
                }
                return false;
            } catch (Throwable th3) {
                try {
                    socket.close();
                } catch (IOException unused4) {
                }
                throw th3;
            }
        }

        @TargetApi(21)
        public Network getDefaultNetwork() {
            Network network;
            Network[] allNetworksFiltered;
            if (Build.VERSION.SDK_INT >= 23) {
                network = ApiHelperForM.getActiveNetwork(this.mConnectivityManager);
                if (network != null) {
                    return network;
                }
            } else {
                network = null;
            }
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                for (Network network2 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this, null)) {
                    NetworkInfo networkInfo = getNetworkInfo(network2);
                    if (networkInfo != null && (networkInfo.getType() == activeNetworkInfo.getType() || networkInfo.getType() == 17)) {
                        network = network2;
                    }
                }
                return network;
            }
            return null;
        }

        public NetworkState getNetworkState(WifiManagerDelegate wifiManagerDelegate) {
            NetworkInfo activeNetworkInfo;
            Network network;
            if (Build.VERSION.SDK_INT >= 23) {
                network = getDefaultNetwork();
                activeNetworkInfo = ApiHelperForM.getNetworkInfo(this.mConnectivityManager, network);
            } else {
                activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
                network = null;
            }
            NetworkInfo processActiveNetworkInfo = processActiveNetworkInfo(activeNetworkInfo);
            if (processActiveNetworkInfo == null) {
                return new NetworkState(false, -1, -1, null, false, "");
            }
            if (network != null) {
                DnsStatus dnsStatus = AndroidNetworkLibrary.getDnsStatus(network);
                if (dnsStatus == null) {
                    return new NetworkState(true, processActiveNetworkInfo.getType(), processActiveNetworkInfo.getSubtype(), String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(network)), false, "");
                }
                return new NetworkState(true, processActiveNetworkInfo.getType(), processActiveNetworkInfo.getSubtype(), String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(network)), dnsStatus.getPrivateDnsActive(), dnsStatus.getPrivateDnsServerName());
            } else if (processActiveNetworkInfo.getType() == 1) {
                if (processActiveNetworkInfo.getExtraInfo() != null && !"".equals(processActiveNetworkInfo.getExtraInfo())) {
                    return new NetworkState(true, processActiveNetworkInfo.getType(), processActiveNetworkInfo.getSubtype(), processActiveNetworkInfo.getExtraInfo(), false, "");
                }
                return new NetworkState(true, processActiveNetworkInfo.getType(), processActiveNetworkInfo.getSubtype(), wifiManagerDelegate.getWifiSsid(), false, "");
            } else {
                return new NetworkState(true, processActiveNetworkInfo.getType(), processActiveNetworkInfo.getSubtype(), null, false, "");
            }
        }

        @TargetApi(28)
        public void registerDefaultNetworkCallback(ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            this.mConnectivityManager.registerDefaultNetworkCallback(networkCallback, handler);
        }

        @TargetApi(21)
        public void registerNetworkCallback(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback, handler);
            } else {
                this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback);
            }
        }
    }

    @TargetApi(21)
    /* loaded from: classes2.dex */
    public class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        public DefaultNetworkCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (!NetworkChangeNotifierAutoDetect.this.mRegistered) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            onAvailable(null);
        }
    }

    @TargetApi(21)
    /* loaded from: classes2.dex */
    public class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public Network mVpnInPlace;

        public void initializeVpnInPlace() {
            NetworkCapabilities networkCapabilities;
            Network[] allNetworksFiltered = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, null);
            this.mVpnInPlace = null;
            if (allNetworksFiltered.length == 1 && (networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(allNetworksFiltered[0])) != null && networkCapabilities.hasTransport(4)) {
                this.mVpnInPlace = allNetworksFiltered[0];
            }
        }

        public MyNetworkCallback() {
        }

        private boolean ignoreNetworkDueToVpn(Network network) {
            Network network2 = this.mVpnInPlace;
            if (network2 != null && !network2.equals(network)) {
                return true;
            }
            return false;
        }

        private boolean ignoreConnectedInaccessibleVpn(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(network);
            }
            if (networkCapabilities != null && (!networkCapabilities.hasTransport(4) || NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.vpnAccessible(network))) {
                return false;
            }
            return true;
        }

        private boolean ignoreConnectedNetwork(Network network, NetworkCapabilities networkCapabilities) {
            if (!ignoreNetworkDueToVpn(network) && !ignoreConnectedInaccessibleVpn(network, networkCapabilities)) {
                return false;
            }
            return true;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (ignoreConnectedNetwork(network, networkCapabilities)) {
                return;
            }
            final long networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            final int connectionType = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network);
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkConnect(networkToNetId, connectionType);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            if (ignoreConnectedNetwork(network, null)) {
                return;
            }
            final long networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkSoonToDisconnect(networkToNetId);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            final boolean z;
            Network network2;
            NetworkCapabilities networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(network);
            if (ignoreConnectedNetwork(network, networkCapabilities)) {
                return;
            }
            if (networkCapabilities.hasTransport(4) && ((network2 = this.mVpnInPlace) == null || !network.equals(network2))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.mVpnInPlace = network;
            }
            final long networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            final int connectionType = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network);
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkConnect(networkToNetId, connectionType);
                    if (z) {
                        NetworkChangeNotifierAutoDetect.this.mObserver.onConnectionTypeChanged(connectionType);
                        NetworkChangeNotifierAutoDetect.this.mObserver.purgeActiveNetworkList(new long[]{networkToNetId});
                    }
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network network) {
            if (!ignoreNetworkDueToVpn(network)) {
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.4
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkDisconnect(NetworkChangeNotifierAutoDetect.networkToNetId(network));
                    }
                });
                if (this.mVpnInPlace != null) {
                    this.mVpnInPlace = null;
                    for (Network network2 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, network)) {
                        onAvailable(network2);
                    }
                    final int connectionType = NetworkChangeNotifierAutoDetect.this.getCurrentNetworkState().getConnectionType();
                    NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetworkChangeNotifierAutoDetect.this.mObserver.onConnectionTypeChanged(connectionType);
                        }
                    });
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public NetworkConnectivityIntentFilter() {
            addAction(NetworkMonitor.NET_CHANGE_ACTION);
        }
    }

    /* loaded from: classes2.dex */
    public static class NetworkState {
        public final boolean mConnected;
        public final boolean mIsPrivateDnsActive;
        public final String mNetworkIdentifier;
        public final String mPrivateDnsServerName;
        public final int mSubtype;
        public final int mType;

        public NetworkState(boolean z, int i, int i2, String str, boolean z2, String str2) {
            this.mConnected = z;
            this.mType = i;
            this.mSubtype = i2;
            this.mNetworkIdentifier = str == null ? "" : str;
            this.mIsPrivateDnsActive = z2;
            this.mPrivateDnsServerName = str2 == null ? "" : str2;
        }

        public int getConnectionSubtype() {
            if (!isConnected()) {
                return 1;
            }
            int networkType = getNetworkType();
            if (networkType != 0 && networkType != 4 && networkType != 5) {
                return 0;
            }
            switch (getNetworkSubType()) {
                case 1:
                    return 7;
                case 2:
                    return 8;
                case 3:
                    return 9;
                case 4:
                    return 5;
                case 5:
                    return 10;
                case 6:
                    return 11;
                case 7:
                    return 6;
                case 8:
                    return 14;
                case 9:
                    return 15;
                case 10:
                    return 12;
                case 11:
                    return 4;
                case 12:
                    return 13;
                case 13:
                    return 18;
                case 14:
                    return 16;
                case 15:
                    return 17;
                default:
                    return 0;
            }
        }

        public int getConnectionType() {
            if (isConnected()) {
                return NetworkChangeNotifierAutoDetect.convertToConnectionType(getNetworkType(), getNetworkSubType());
            }
            return 6;
        }

        public String getNetworkIdentifier() {
            return this.mNetworkIdentifier;
        }

        public int getNetworkSubType() {
            return this.mSubtype;
        }

        public int getNetworkType() {
            return this.mType;
        }

        public String getPrivateDnsServerName() {
            return this.mPrivateDnsServerName;
        }

        public boolean isConnected() {
            return this.mConnected;
        }

        public boolean isPrivateDnsActive() {
            return this.mIsPrivateDnsActive;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class RegistrationPolicy {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public NetworkChangeNotifierAutoDetect mNotifier;

        public abstract void destroy();

        public final void register() {
            this.mNotifier.register();
        }

        public final void unregister() {
            this.mNotifier.unregister();
        }

        public void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            this.mNotifier = networkChangeNotifierAutoDetect;
        }
    }

    /* loaded from: classes2.dex */
    public static class WifiManagerDelegate {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final Context mContext;
        @GuardedBy("mLock")
        public boolean mHasWifiPermission;
        @GuardedBy("mLock")
        public boolean mHasWifiPermissionComputed;
        public final Object mLock;
        @GuardedBy("mLock")
        public WifiManager mWifiManager;

        public WifiManagerDelegate() {
            this.mLock = new Object();
            this.mContext = null;
        }

        @GuardedBy("mLock")
        private WifiInfo getWifiInfoLocked() {
            try {
                try {
                    return this.mWifiManager.getConnectionInfo();
                } catch (NullPointerException unused) {
                    return null;
                }
            } catch (NullPointerException unused2) {
                return this.mWifiManager.getConnectionInfo();
            }
        }

        public String getWifiSsid() {
            synchronized (this.mLock) {
                if (hasPermissionLocked()) {
                    WifiInfo wifiInfoLocked = getWifiInfoLocked();
                    if (wifiInfoLocked != null) {
                        return wifiInfoLocked.getSSID();
                    }
                    return "";
                }
                return AndroidNetworkLibrary.getWifiSSID();
            }
        }

        public WifiManagerDelegate(Context context) {
            this.mLock = new Object();
            this.mContext = context;
        }

        @GuardedBy("mLock")
        @SuppressLint({"WifiManagerPotentialLeak"})
        private boolean hasPermissionLocked() {
            boolean z;
            WifiManager wifiManager;
            if (this.mHasWifiPermissionComputed) {
                return this.mHasWifiPermission;
            }
            if (this.mContext.getPackageManager().checkPermission(g.d, this.mContext.getPackageName()) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.mHasWifiPermission = z;
            if (z) {
                wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
            } else {
                wifiManager = null;
            }
            this.mWifiManager = wifiManager;
            this.mHasWifiPermissionComputed = true;
            return this.mHasWifiPermission;
        }
    }

    private void assertOnThread() {
        if (BuildConfig.DCHECK_IS_ON && !onThread()) {
            throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionTypeChanged() {
        connectionTypeChangedTo(getCurrentNetworkState());
    }

    private boolean onThread() {
        if (this.mLooper == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public void destroy() {
        assertOnThread();
        this.mRegistrationPolicy.destroy();
        unregister();
    }

    public NetworkState getCurrentNetworkState() {
        return this.mConnectivityManagerDelegate.getNetworkState(this.mWifiManagerDelegate);
    }

    public long getDefaultNetId() {
        Network defaultNetwork;
        if (Build.VERSION.SDK_INT < 21 || (defaultNetwork = this.mConnectivityManagerDelegate.getDefaultNetwork()) == null) {
            return -1L;
        }
        return networkToNetId(defaultNetwork);
    }

    @VisibleForTesting
    public RegistrationPolicy getRegistrationPolicy() {
        return this.mRegistrationPolicy;
    }

    @VisibleForTesting
    public boolean isReceiverRegisteredForTesting() {
        return this.mRegistered;
    }

    public boolean registerNetworkCallbackFailed() {
        return this.mRegisterNetworkCallbackFailed;
    }

    public void unregister() {
        assertOnThread();
        if (!this.mRegistered) {
            return;
        }
        this.mRegistered = false;
        MyNetworkCallback myNetworkCallback = this.mNetworkCallback;
        if (myNetworkCallback != null) {
            this.mConnectivityManagerDelegate.unregisterNetworkCallback(myNetworkCallback);
        }
        ConnectivityManager.NetworkCallback networkCallback = this.mDefaultNetworkCallback;
        if (networkCallback != null) {
            this.mConnectivityManagerDelegate.unregisterNetworkCallback(networkCallback);
        } else {
            ContextUtils.getApplicationContext().unregisterReceiver(this);
        }
    }

    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(Observer observer, RegistrationPolicy registrationPolicy) {
        this.mObserver = observer;
        if (Build.VERSION.SDK_INT < 23) {
            this.mWifiManagerDelegate = new WifiManagerDelegate(ContextUtils.getApplicationContext());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mNetworkCallback = new MyNetworkCallback();
            this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        } else {
            this.mNetworkCallback = null;
            this.mNetworkRequest = null;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.mDefaultNetworkCallback = new AndroidRDefaultNetworkCallback();
        } else {
            this.mDefaultNetworkCallback = i >= 28 ? new DefaultNetworkCallback() : null;
        }
        this.mNetworkState = getCurrentNetworkState();
        this.mIntentFilter = new NetworkConnectivityIntentFilter();
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = registrationPolicy;
        registrationPolicy.init(this);
        this.mShouldSignalObserver = true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        runOnThread(new Runnable() { // from class: org.chromium.net.NetworkChangeNotifierAutoDetect.1
            @Override // java.lang.Runnable
            public void run() {
                if (!NetworkChangeNotifierAutoDetect.this.mRegistered) {
                    return;
                }
                if (NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast) {
                    NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast = false;
                } else {
                    NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
                }
            }
        });
    }

    @TargetApi(21)
    public static long networkToNetId(Network network) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ApiHelperForM.getNetworkHandle(network);
        }
        return Integer.parseInt(network.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnThread(Runnable runnable) {
        if (onThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    public void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate connectivityManagerDelegate) {
        this.mConnectivityManagerDelegate = connectivityManagerDelegate;
    }

    public void setWifiManagerDelegateForTests(WifiManagerDelegate wifiManagerDelegate) {
        this.mWifiManagerDelegate = wifiManagerDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionTypeChangedTo(NetworkState networkState) {
        if (networkState.getConnectionType() != this.mNetworkState.getConnectionType() || !networkState.getNetworkIdentifier().equals(this.mNetworkState.getNetworkIdentifier()) || networkState.isPrivateDnsActive() != this.mNetworkState.isPrivateDnsActive() || !networkState.getPrivateDnsServerName().equals(this.mNetworkState.getPrivateDnsServerName())) {
            this.mObserver.onConnectionTypeChanged(networkState.getConnectionType());
        }
        if (networkState.getConnectionType() != this.mNetworkState.getConnectionType() || networkState.getConnectionSubtype() != this.mNetworkState.getConnectionSubtype()) {
            this.mObserver.onConnectionSubtypeChanged(networkState.getConnectionSubtype());
        }
        this.mNetworkState = networkState;
    }

    @TargetApi(21)
    public static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate connectivityManagerDelegate, Network network) {
        NetworkCapabilities networkCapabilities;
        Network[] allNetworksUnfiltered = connectivityManagerDelegate.getAllNetworksUnfiltered();
        int i = 0;
        for (Network network2 : allNetworksUnfiltered) {
            if (!network2.equals(network) && (networkCapabilities = connectivityManagerDelegate.getNetworkCapabilities(network2)) != null && networkCapabilities.hasCapability(12)) {
                if (networkCapabilities.hasTransport(4)) {
                    if (connectivityManagerDelegate.vpnAccessible(network2)) {
                        return new Network[]{network2};
                    }
                } else {
                    allNetworksUnfiltered[i] = network2;
                    i++;
                }
            }
        }
        return (Network[]) Arrays.copyOf(allNetworksUnfiltered, i);
    }

    public long[] getNetworksAndTypes() {
        if (Build.VERSION.SDK_INT < 21) {
            return new long[0];
        }
        Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] jArr = new long[allNetworksFiltered.length * 2];
        int i = 0;
        for (Network network : allNetworksFiltered) {
            int i2 = i + 1;
            jArr[i] = networkToNetId(network);
            i = i2 + 1;
            jArr[i2] = this.mConnectivityManagerDelegate.getConnectionType(network);
        }
        return jArr;
    }

    public void register() {
        boolean z;
        assertOnThread();
        if (this.mRegistered) {
            connectionTypeChanged();
            return;
        }
        if (this.mShouldSignalObserver) {
            connectionTypeChanged();
        }
        ConnectivityManager.NetworkCallback networkCallback = this.mDefaultNetworkCallback;
        if (networkCallback != null) {
            try {
                this.mConnectivityManagerDelegate.registerDefaultNetworkCallback(networkCallback, this.mHandler);
            } catch (RuntimeException unused) {
                this.mDefaultNetworkCallback = null;
            }
        }
        if (this.mDefaultNetworkCallback == null) {
            if (ContextUtils.getApplicationContext().registerReceiver(this, this.mIntentFilter) != null) {
                z = true;
            } else {
                z = false;
            }
            this.mIgnoreNextBroadcast = z;
        }
        this.mRegistered = true;
        MyNetworkCallback myNetworkCallback = this.mNetworkCallback;
        if (myNetworkCallback != null) {
            myNetworkCallback.initializeVpnInPlace();
            try {
                this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);
            } catch (RuntimeException unused2) {
                this.mRegisterNetworkCallbackFailed = true;
                this.mNetworkCallback = null;
            }
            if (!this.mRegisterNetworkCallbackFailed && this.mShouldSignalObserver) {
                Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
                long[] jArr = new long[allNetworksFiltered.length];
                for (int i = 0; i < allNetworksFiltered.length; i++) {
                    jArr[i] = networkToNetId(allNetworksFiltered[i]);
                }
                this.mObserver.purgeActiveNetworkList(jArr);
            }
        }
    }
}
