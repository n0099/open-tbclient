package org.chromium.net;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.kuaishou.weapon.p0.h;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import java.util.List;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.CalledByNativeUnchecked;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.compat.ApiHelperForM;
import org.chromium.base.compat.ApiHelperForN;
import org.chromium.base.compat.ApiHelperForP;
@MainDex
/* loaded from: classes2.dex */
public class AndroidNetworkLibrary {
    public static final String TAG = "AndroidNetworkLibrary";
    public static Boolean sHaveAccessNetworkState;
    public static Boolean sHaveAccessWifiState;

    /* loaded from: classes2.dex */
    public static class SocketFd extends Socket {

        /* loaded from: classes2.dex */
        public static class SocketImplFd extends SocketImpl {
            @Override // java.net.SocketImpl
            public void close() {
            }

            @Override // java.net.SocketImpl
            public void create(boolean z) {
            }

            public SocketImplFd(FileDescriptor fileDescriptor) {
                ((SocketImpl) this).fd = fileDescriptor;
            }

            @Override // java.net.SocketImpl
            public void accept(SocketImpl socketImpl) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int i) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketImpl
            public void listen(int i) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            public void sendUrgentData(int i) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketImpl
            public int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketImpl
            public OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            @Override // java.net.SocketImpl
            public void bind(InetAddress inetAddress, int i) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(String str, int i) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int i, Object obj) {
                throw new RuntimeException("setOption not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(InetAddress inetAddress, int i) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(SocketAddress socketAddress, int i) {
                throw new RuntimeException("connect not implemented");
            }
        }

        public SocketFd(FileDescriptor fileDescriptor) throws IOException {
            super(new SocketImplFd(fileDescriptor));
        }
    }

    /* loaded from: classes2.dex */
    public static class NetworkSecurityPolicyProxy {
        public static NetworkSecurityPolicyProxy sInstance = new NetworkSecurityPolicyProxy();

        public static NetworkSecurityPolicyProxy getInstance() {
            return sInstance;
        }

        @TargetApi(23)
        public boolean isCleartextTrafficPermitted() {
            if (Build.VERSION.SDK_INT < 23) {
                return true;
            }
            return ApiHelperForM.isCleartextTrafficPermitted();
        }

        @VisibleForTesting
        public static void setInstanceForTesting(NetworkSecurityPolicyProxy networkSecurityPolicyProxy) {
            sInstance = networkSecurityPolicyProxy;
        }

        @TargetApi(24)
        public boolean isCleartextTrafficPermitted(String str) {
            if (Build.VERSION.SDK_INT < 24) {
                return isCleartextTrafficPermitted();
            }
            return ApiHelperForN.isCleartextTrafficPermitted(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class SetFileDescriptor {
        public static final Method sFileDescriptorSetInt;

        static {
            try {
                sFileDescriptorSetInt = FileDescriptor.class.getMethod("setInt$", Integer.TYPE);
            } catch (NoSuchMethodException | SecurityException e) {
                throw new RuntimeException("Unable to get FileDescriptor.setInt$", e);
            }
        }

        public static FileDescriptor createWithFd(int i) {
            try {
                FileDescriptor fileDescriptor = new FileDescriptor();
                sFileDescriptorSetInt.invoke(fileDescriptor, Integer.valueOf(i));
                return fileDescriptor;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("FileDescriptor.setInt$() failed", e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("FileDescriptor.setInt$() failed", e2);
            }
        }
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        X509Util.clearTestRootCertificates();
    }

    @TargetApi(23)
    @CalledByNative
    public static boolean getIsCaptivePortal() {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (Build.VERSION.SDK_INT < 23 || (connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")) == null || (activeNetwork = ApiHelperForM.getActiveNetwork(connectivityManager)) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(17)) {
            return false;
        }
        return true;
    }

    @CalledByNative
    public static boolean getIsRoaming() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isRoaming();
    }

    @CalledByNative
    public static String getNetworkOperator() {
        return AndroidTelephonyManagerBridge.getInstance().getNetworkOperator();
    }

    @CalledByNative
    public static String getSimOperator() {
        return AndroidTelephonyManagerBridge.getInstance().getSimOperator();
    }

    public static boolean haveAccessNetworkState() {
        boolean z;
        if (sHaveAccessNetworkState == null) {
            if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0) {
                z = true;
            } else {
                z = false;
            }
            sHaveAccessNetworkState = Boolean.valueOf(z);
        }
        return sHaveAccessNetworkState.booleanValue();
    }

    public static boolean haveAccessWifiState() {
        boolean z;
        if (sHaveAccessWifiState == null) {
            if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), h.d, Process.myPid(), Process.myUid()) == 0) {
                z = true;
            } else {
                z = false;
            }
            sHaveAccessWifiState = Boolean.valueOf(z);
        }
        return sHaveAccessWifiState.booleanValue();
    }

    @TargetApi(23)
    @CalledByNative
    public static boolean reportBadDefaultNetwork() {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT < 23 || (connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        connectivityManager.reportNetworkConnectivity(null, false);
        return true;
    }

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        X509Util.addTestRootCertificate(bArr);
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String str) {
        return URLConnection.guessContentTypeFromName("foo." + str);
    }

    @CalledByNative
    public static boolean isCleartextPermitted(String str) {
        try {
            return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted(str);
        } catch (IllegalArgumentException unused) {
            return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted();
        }
    }

    @TargetApi(23)
    @CalledByNative
    public static DnsStatus getDnsStatus(Network network) {
        ConnectivityManager connectivityManager;
        if (!haveAccessNetworkState() || (connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")) == null) {
            return null;
        }
        if (network == null) {
            network = ApiHelperForM.getActiveNetwork(connectivityManager);
        }
        if (network == null) {
            return null;
        }
        try {
            LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
            if (linkProperties == null) {
                return null;
            }
            List<InetAddress> dnsServers = linkProperties.getDnsServers();
            if (Build.VERSION.SDK_INT >= 28) {
                return new DnsStatus(dnsServers, ApiHelperForP.isPrivateDnsActive(linkProperties), ApiHelperForP.getPrivateDnsServerName(linkProperties));
            }
            return new DnsStatus(dnsServers, false, "");
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @CalledByNative
    public static int getWifiSignalLevel(int i) {
        int intExtra;
        int calculateSignalLevel;
        if (ContextUtils.getApplicationContext() == null || ContextUtils.getApplicationContext().getContentResolver() == null) {
            return -1;
        }
        if (haveAccessWifiState()) {
            WifiInfo connectionInfo = ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return -1;
            }
            intExtra = connectionInfo.getRssi();
        } else {
            try {
                Intent registerReceiver = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
                if (registerReceiver == null) {
                    return -1;
                }
                intExtra = registerReceiver.getIntExtra("newRssi", Integer.MIN_VALUE);
            } catch (IllegalArgumentException unused) {
            }
        }
        if (intExtra == Integer.MIN_VALUE || (calculateSignalLevel = WifiManager.calculateSignalLevel(intExtra, i)) < 0 || calculateSignalLevel >= i) {
            return -1;
        }
        return calculateSignalLevel;
    }

    @CalledByNative
    public static String getWifiSSID() {
        String ssid;
        WifiInfo wifiInfo = null;
        if (haveAccessWifiState()) {
            wifiInfo = ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        } else {
            Intent registerReceiver = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter(McastConfig.ACTION_NETWORK_STATE_CHANGED));
            if (registerReceiver != null) {
                wifiInfo = (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo");
            }
        }
        if (wifiInfo != null && (ssid = wifiInfo.getSSID()) != null && !ssid.equals("<unknown ssid>")) {
            return ssid;
        }
        return "";
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                try {
                    if (nextElement.isUp() && !nextElement.isLoopback()) {
                        return false;
                    }
                } catch (SocketException unused) {
                }
            }
            return true;
        } catch (Exception e) {
            Log.w(TAG, "could not get network interfaces: " + e);
            return false;
        }
    }

    @CalledByNative
    public static void tagSocket(int i, int i2, int i3) throws IOException {
        ParcelFileDescriptor adoptFd;
        FileDescriptor fileDescriptor;
        int threadStatsTag = TrafficStats.getThreadStatsTag();
        if (i3 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(i3);
        }
        if (i2 != -1) {
            ThreadStatsUid.set(i2);
        }
        if (Build.VERSION.SDK_INT < 23) {
            adoptFd = null;
            fileDescriptor = SetFileDescriptor.createWithFd(i);
        } else {
            adoptFd = ParcelFileDescriptor.adoptFd(i);
            fileDescriptor = adoptFd.getFileDescriptor();
        }
        SocketFd socketFd = new SocketFd(fileDescriptor);
        TrafficStats.tagSocket(socketFd);
        socketFd.close();
        if (adoptFd != null) {
            adoptFd.detachFd();
        }
        if (i3 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(threadStatsTag);
        }
        if (i2 != -1) {
            ThreadStatsUid.clear();
        }
    }

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        try {
            return X509Util.verifyServerCertificates(bArr, str, str2);
        } catch (IllegalArgumentException unused) {
            return new AndroidCertVerifyResult(-1);
        } catch (KeyStoreException unused2) {
            return new AndroidCertVerifyResult(-1);
        } catch (NoSuchAlgorithmException unused3) {
            return new AndroidCertVerifyResult(-1);
        }
    }
}
