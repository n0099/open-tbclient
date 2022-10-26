package org.webrtc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class NetworkMonitorAutoDetect extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long INVALID_NET_ID = -1;
    public static final String TAG = "NetworkMonitorAutoDetect";
    public transient /* synthetic */ FieldHolder $fh;
    public final ConnectivityManager.NetworkCallback allNetworkCallback;
    public ConnectionType connectionType;
    public ConnectivityManagerDelegate connectivityManagerDelegate;
    public final Context context;
    public final IntentFilter intentFilter;
    public boolean isRegistered;
    public final ConnectivityManager.NetworkCallback mobileNetworkCallback;
    public final Observer observer;
    public WifiDirectManagerDelegate wifiDirectManagerDelegate;
    public WifiManagerDelegate wifiManagerDelegate;
    public String wifiSSID;

    /* renamed from: org.webrtc.NetworkMonitorAutoDetect$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface Observer {
        void onConnectionTypeChanged(ConnectionType connectionType);

        void onNetworkConnect(NetworkInformation networkInformation);

        void onNetworkDisconnect(long j);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public final class ConnectionType {
        public static final /* synthetic */ ConnectionType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ConnectionType CONNECTION_2G;
        public static final ConnectionType CONNECTION_3G;
        public static final ConnectionType CONNECTION_4G;
        public static final ConnectionType CONNECTION_BLUETOOTH;
        public static final ConnectionType CONNECTION_ETHERNET;
        public static final ConnectionType CONNECTION_NONE;
        public static final ConnectionType CONNECTION_UNKNOWN;
        public static final ConnectionType CONNECTION_UNKNOWN_CELLULAR;
        public static final ConnectionType CONNECTION_VPN;
        public static final ConnectionType CONNECTION_WIFI;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(852823368, "Lorg/webrtc/NetworkMonitorAutoDetect$ConnectionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(852823368, "Lorg/webrtc/NetworkMonitorAutoDetect$ConnectionType;");
                    return;
                }
            }
            CONNECTION_UNKNOWN = new ConnectionType("CONNECTION_UNKNOWN", 0);
            CONNECTION_ETHERNET = new ConnectionType("CONNECTION_ETHERNET", 1);
            CONNECTION_WIFI = new ConnectionType("CONNECTION_WIFI", 2);
            CONNECTION_4G = new ConnectionType("CONNECTION_4G", 3);
            CONNECTION_3G = new ConnectionType("CONNECTION_3G", 4);
            CONNECTION_2G = new ConnectionType("CONNECTION_2G", 5);
            CONNECTION_UNKNOWN_CELLULAR = new ConnectionType("CONNECTION_UNKNOWN_CELLULAR", 6);
            CONNECTION_BLUETOOTH = new ConnectionType("CONNECTION_BLUETOOTH", 7);
            CONNECTION_VPN = new ConnectionType("CONNECTION_VPN", 8);
            ConnectionType connectionType = new ConnectionType("CONNECTION_NONE", 9);
            CONNECTION_NONE = connectionType;
            $VALUES = new ConnectionType[]{CONNECTION_UNKNOWN, CONNECTION_ETHERNET, CONNECTION_WIFI, CONNECTION_4G, CONNECTION_3G, CONNECTION_2G, CONNECTION_UNKNOWN_CELLULAR, CONNECTION_BLUETOOTH, CONNECTION_VPN, connectionType};
        }

        public ConnectionType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ConnectionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ConnectionType) Enum.valueOf(ConnectionType.class, str);
            }
            return (ConnectionType) invokeL.objValue;
        }

        public static ConnectionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ConnectionType[]) $VALUES.clone();
            }
            return (ConnectionType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class ConnectivityManagerDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConnectivityManager connectivityManager;

        public ConnectivityManagerDelegate() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.connectivityManager = null;
        }

        public Network[] getAllNetworks() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ConnectivityManager connectivityManager = this.connectivityManager;
                if (connectivityManager == null) {
                    return new Network[0];
                }
                return connectivityManager.getAllNetworks();
            }
            return (Network[]) invokeV.objValue;
        }

        public NetworkState getNetworkState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ConnectivityManager connectivityManager = this.connectivityManager;
                if (connectivityManager == null) {
                    return new NetworkState(false, -1, -1, -1, -1);
                }
                return getNetworkState(connectivityManager.getActiveNetworkInfo());
            }
            return (NetworkState) invokeV.objValue;
        }

        public boolean supportNetworkCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (Build.VERSION.SDK_INT >= 21 && this.connectivityManager != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public ConnectivityManagerDelegate(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        private NetworkState getNetworkState(NetworkInfo networkInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, networkInfo)) == null) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    return new NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), -1, -1);
                }
                return new NetworkState(false, -1, -1, -1, -1);
            }
            return (NetworkState) invokeL.objValue;
        }

        public IPAddress[] getIPAddresses(LinkProperties linkProperties) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, linkProperties)) == null) {
                IPAddress[] iPAddressArr = new IPAddress[linkProperties.getLinkAddresses().size()];
                int i = 0;
                for (LinkAddress linkAddress : linkProperties.getLinkAddresses()) {
                    iPAddressArr[i] = new IPAddress(linkAddress.getAddress().getAddress());
                    i++;
                }
                return iPAddressArr;
            }
            return (IPAddress[]) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public NetworkInformation networkToInfo(Network network) {
            InterceptResult invokeL;
            ConnectivityManager connectivityManager;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, network)) == null) {
                if (network == null || (connectivityManager = this.connectivityManager) == null) {
                    return null;
                }
                LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
                if (linkProperties == null) {
                    Logging.w(NetworkMonitorAutoDetect.TAG, "Detected unknown network: " + network.toString());
                    return null;
                } else if (linkProperties.getInterfaceName() == null) {
                    Logging.w(NetworkMonitorAutoDetect.TAG, "Null interface name for network " + network.toString());
                    return null;
                } else {
                    NetworkState networkState = getNetworkState(network);
                    ConnectionType connectionType = NetworkMonitorAutoDetect.getConnectionType(networkState);
                    if (connectionType == ConnectionType.CONNECTION_NONE) {
                        Logging.d(NetworkMonitorAutoDetect.TAG, "Network " + network.toString() + " is disconnected");
                        return null;
                    }
                    if (connectionType == ConnectionType.CONNECTION_UNKNOWN || connectionType == ConnectionType.CONNECTION_UNKNOWN_CELLULAR) {
                        Logging.d(NetworkMonitorAutoDetect.TAG, "Network " + network.toString() + " connection type is " + connectionType + " because it has type " + networkState.getNetworkType() + " and subtype " + networkState.getNetworkSubType());
                    }
                    return new NetworkInformation(linkProperties.getInterfaceName(), connectionType, NetworkMonitorAutoDetect.getUnderlyingConnectionTypeForVpn(networkState), NetworkMonitorAutoDetect.networkToNetId(network), getIPAddresses(linkProperties));
                }
            }
            return (NetworkInformation) invokeL.objValue;
        }

        public NetworkState getNetworkState(Network network) {
            InterceptResult invokeL;
            ConnectivityManager connectivityManager;
            NetworkInfo activeNetworkInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, network)) == null) {
                if (network != null && (connectivityManager = this.connectivityManager) != null) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                    if (networkInfo == null) {
                        Logging.w(NetworkMonitorAutoDetect.TAG, "Couldn't retrieve information from network " + network.toString());
                        return new NetworkState(false, -1, -1, -1, -1);
                    } else if (networkInfo.getType() != 17) {
                        NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(network);
                        if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                            return new NetworkState(networkInfo.isConnected(), 17, -1, networkInfo.getType(), networkInfo.getSubtype());
                        }
                        return getNetworkState(networkInfo);
                    } else if (networkInfo.getType() == 17) {
                        if (Build.VERSION.SDK_INT >= 23 && network.equals(this.connectivityManager.getActiveNetwork()) && (activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 17) {
                            return new NetworkState(networkInfo.isConnected(), 17, -1, activeNetworkInfo.getType(), activeNetworkInfo.getSubtype());
                        }
                        return new NetworkState(networkInfo.isConnected(), 17, -1, -1, -1);
                    } else {
                        return getNetworkState(networkInfo);
                    }
                }
                return new NetworkState(false, -1, -1, -1, -1);
            }
            return (NetworkState) invokeL.objValue;
        }

        public List getActiveNetworkList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!supportNetworkCallback()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Network network : getAllNetworks()) {
                    NetworkInformation networkToInfo = networkToInfo(network);
                    if (networkToInfo != null) {
                        arrayList.add(networkToInfo);
                    }
                }
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public long getDefaultNetId() {
            InterceptResult invokeV;
            NetworkInfo activeNetworkInfo;
            Network[] allNetworks;
            NetworkInfo networkInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!supportNetworkCallback() || (activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo()) == null) {
                    return -1L;
                }
                long j = -1;
                for (Network network : getAllNetworks()) {
                    if (hasInternetCapability(network) && (networkInfo = this.connectivityManager.getNetworkInfo(network)) != null && networkInfo.getType() == activeNetworkInfo.getType()) {
                        if (j == -1) {
                            j = NetworkMonitorAutoDetect.networkToNetId(network);
                        } else {
                            throw new RuntimeException("Multiple connected networks of same type are not supported.");
                        }
                    }
                }
                return j;
            }
            return invokeV.longValue;
        }

        public boolean hasInternetCapability(Network network) {
            InterceptResult invokeL;
            NetworkCapabilities networkCapabilities;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, network)) == null) {
                ConnectivityManager connectivityManager = this.connectivityManager;
                if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null || !networkCapabilities.hasCapability(12)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public void registerNetworkCallback(ConnectivityManager.NetworkCallback networkCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, networkCallback) == null) {
                this.connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), networkCallback);
            }
        }

        public void releaseCallback(ConnectivityManager.NetworkCallback networkCallback) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, networkCallback) == null) && supportNetworkCallback()) {
                Logging.d(NetworkMonitorAutoDetect.TAG, "Unregister network callback");
                this.connectivityManager.unregisterNetworkCallback(networkCallback);
            }
        }

        public void requestMobileNetwork(ConnectivityManager.NetworkCallback networkCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, networkCallback) == null) {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12).addTransportType(0);
                this.connectivityManager.requestNetwork(builder.build(), networkCallback);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class IPAddress {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] address;

        public IPAddress(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.address = bArr;
        }

        private byte[] getAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                return this.address;
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class NetworkInformation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long handle;
        public final IPAddress[] ipAddresses;
        public final String name;
        public final ConnectionType type;
        public final ConnectionType underlyingTypeForVpn;

        public NetworkInformation(String str, ConnectionType connectionType, ConnectionType connectionType2, long j, IPAddress[] iPAddressArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, connectionType, connectionType2, Long.valueOf(j), iPAddressArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.type = connectionType;
            this.underlyingTypeForVpn = connectionType2;
            this.handle = j;
            this.ipAddresses = iPAddressArr;
        }

        private ConnectionType getConnectionType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                return this.type;
            }
            return (ConnectionType) invokeV.objValue;
        }

        private long getHandle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                return this.handle;
            }
            return invokeV.longValue;
        }

        private IPAddress[] getIpAddresses() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                return this.ipAddresses;
            }
            return (IPAddress[]) invokeV.objValue;
        }

        private String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        private ConnectionType getUnderlyingConnectionTypeForVpn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                return this.underlyingTypeForVpn;
            }
            return (ConnectionType) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class NetworkState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean connected;
        public final int subtype;
        public final int type;
        public final int underlyingNetworkSubtypeForVpn;
        public final int underlyingNetworkTypeForVpn;

        public NetworkState(boolean z, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.connected = z;
            this.type = i;
            this.subtype = i2;
            this.underlyingNetworkTypeForVpn = i3;
            this.underlyingNetworkSubtypeForVpn = i4;
        }

        public int getNetworkSubType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.subtype;
            }
            return invokeV.intValue;
        }

        public int getNetworkType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.type;
            }
            return invokeV.intValue;
        }

        public int getUnderlyingNetworkSubtypeForVpn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.underlyingNetworkSubtypeForVpn;
            }
            return invokeV.intValue;
        }

        public int getUnderlyingNetworkTypeForVpn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.underlyingNetworkTypeForVpn;
            }
            return invokeV.intValue;
        }

        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.connected;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class SimpleNetworkCallback extends ConnectivityManager.NetworkCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetworkMonitorAutoDetect this$0;

        public SimpleNetworkCallback(NetworkMonitorAutoDetect networkMonitorAutoDetect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {networkMonitorAutoDetect};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = networkMonitorAutoDetect;
        }

        private void onNetworkChanged(Network network) {
            NetworkInformation networkToInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65538, this, network) == null) && (networkToInfo = this.this$0.connectivityManagerDelegate.networkToInfo(network)) != null) {
                this.this$0.observer.onNetworkConnect(networkToInfo);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, network) == null) {
                Logging.d(NetworkMonitorAutoDetect.TAG, "Network becomes available: " + network.toString());
                onNetworkChanged(network);
            }
        }

        public /* synthetic */ SimpleNetworkCallback(NetworkMonitorAutoDetect networkMonitorAutoDetect, AnonymousClass1 anonymousClass1) {
            this(networkMonitorAutoDetect);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network, networkCapabilities) == null) {
                Logging.d(NetworkMonitorAutoDetect.TAG, "capabilities changed: " + networkCapabilities.toString());
                onNetworkChanged(network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, network, linkProperties) == null) {
                Logging.d(NetworkMonitorAutoDetect.TAG, "link properties changed: " + linkProperties.toString());
                onNetworkChanged(network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, network, i) == null) {
                Logging.d(NetworkMonitorAutoDetect.TAG, "Network " + network.toString() + " is about to lose in " + i + "ms");
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, network) == null) {
                Logging.d(NetworkMonitorAutoDetect.TAG, "Network " + network.toString() + " is disconnected");
                this.this$0.observer.onNetworkDisconnect(NetworkMonitorAutoDetect.networkToNetId(network));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class WifiDirectManagerDelegate extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public static final int WIFI_P2P_NETWORK_HANDLE = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context context;
        public final Observer observer;
        public NetworkInformation wifiP2pNetworkInfo;

        public WifiDirectManagerDelegate(Observer observer, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = context;
            this.observer = observer;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
            context.registerReceiver(this, intentFilter);
        }

        private void onWifiP2pGroupChange(WifiP2pGroup wifiP2pGroup) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, wifiP2pGroup) == null) && wifiP2pGroup != null && wifiP2pGroup.getInterface() != null) {
                try {
                    ArrayList list = Collections.list(NetworkInterface.getByName(wifiP2pGroup.getInterface()).getInetAddresses());
                    IPAddress[] iPAddressArr = new IPAddress[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        iPAddressArr[i] = new IPAddress(((InetAddress) list.get(i)).getAddress());
                    }
                    NetworkInformation networkInformation = new NetworkInformation(wifiP2pGroup.getInterface(), ConnectionType.CONNECTION_WIFI, ConnectionType.CONNECTION_NONE, 0L, iPAddressArr);
                    this.wifiP2pNetworkInfo = networkInformation;
                    this.observer.onNetworkConnect(networkInformation);
                } catch (SocketException e) {
                    Logging.e(NetworkMonitorAutoDetect.TAG, "Unable to get WifiP2p network interface", e);
                }
            }
        }

        private void onWifiP2pStateChange(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(65538, this, i) == null) && i == 1) {
                this.wifiP2pNetworkInfo = null;
                this.observer.onNetworkDisconnect(0L);
            }
        }

        public List getActiveNetworkList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetworkInformation networkInformation = this.wifiP2pNetworkInfo;
                if (networkInformation != null) {
                    return Collections.singletonList(networkInformation);
                }
                return Collections.emptyList();
            }
            return (List) invokeV.objValue;
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.context.unregisterReceiver(this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent) == null) {
                if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(intent.getAction())) {
                    onWifiP2pGroupChange((WifiP2pGroup) intent.getParcelableExtra("p2pGroupInfo"));
                } else if ("android.net.wifi.p2p.STATE_CHANGED".equals(intent.getAction())) {
                    onWifiP2pStateChange(intent.getIntExtra("wifi_p2p_state", 0));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class WifiManagerDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context context;

        public WifiManagerDelegate() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = null;
        }

        public WifiManagerDelegate(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.context = context;
        }

        public String getWifiSSID() {
            InterceptResult invokeV;
            WifiInfo wifiInfo;
            String ssid;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter(McastConfig.ACTION_NETWORK_STATE_CHANGED));
                if (registerReceiver != null && (wifiInfo = (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo")) != null && (ssid = wifiInfo.getSSID()) != null) {
                    return ssid;
                }
                return "";
            }
            return (String) invokeV.objValue;
        }
    }

    public NetworkMonitorAutoDetect(Observer observer, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observer, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.observer = observer;
        this.context = context;
        this.connectivityManagerDelegate = new ConnectivityManagerDelegate(context);
        this.wifiManagerDelegate = new WifiManagerDelegate(context);
        NetworkState networkState = this.connectivityManagerDelegate.getNetworkState();
        this.connectionType = getConnectionType(networkState);
        this.wifiSSID = getWifiSSID(networkState);
        this.intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (PeerConnectionFactory.fieldTrialsFindFullName("IncludeWifiDirect").equals(PeerConnectionFactory.TRIAL_ENABLED)) {
            this.wifiDirectManagerDelegate = new WifiDirectManagerDelegate(observer, context);
        }
        registerReceiver();
        if (this.connectivityManagerDelegate.supportNetworkCallback()) {
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback();
            try {
                this.connectivityManagerDelegate.requestMobileNetwork(networkCallback);
            } catch (SecurityException unused) {
                Logging.w(TAG, "Unable to obtain permission to request a cellular network.");
                networkCallback = null;
            }
            this.mobileNetworkCallback = networkCallback;
            SimpleNetworkCallback simpleNetworkCallback = new SimpleNetworkCallback(this, null);
            this.allNetworkCallback = simpleNetworkCallback;
            this.connectivityManagerDelegate.registerNetworkCallback(simpleNetworkCallback);
            return;
        }
        this.mobileNetworkCallback = null;
        this.allNetworkCallback = null;
    }

    public static ConnectionType getConnectionType(NetworkState networkState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, networkState)) == null) {
            return getConnectionType(networkState.isConnected(), networkState.getNetworkType(), networkState.getNetworkSubType());
        }
        return (ConnectionType) invokeL.objValue;
    }

    public static ConnectionType getUnderlyingConnectionTypeForVpn(NetworkState networkState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, networkState)) == null) {
            if (networkState.getNetworkType() != 17) {
                return ConnectionType.CONNECTION_NONE;
            }
            return getConnectionType(networkState.isConnected(), networkState.getUnderlyingNetworkTypeForVpn(), networkState.getUnderlyingNetworkSubtypeForVpn());
        }
        return (ConnectionType) invokeL.objValue;
    }

    private String getWifiSSID(NetworkState networkState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, networkState)) == null) {
            if (getConnectionType(networkState) != ConnectionType.CONNECTION_WIFI) {
                return "";
            }
            return this.wifiManagerDelegate.getWifiSSID();
        }
        return (String) invokeL.objValue;
    }

    public static long networkToNetId(Network network) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, network)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return network.getNetworkHandle();
            }
            return Integer.parseInt(network.toString());
        }
        return invokeL.longValue;
    }

    public void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate connectivityManagerDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, connectivityManagerDelegate) == null) {
            this.connectivityManagerDelegate = connectivityManagerDelegate;
        }
    }

    public void setWifiManagerDelegateForTests(WifiManagerDelegate wifiManagerDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wifiManagerDelegate) == null) {
            this.wifiManagerDelegate = wifiManagerDelegate;
        }
    }

    private void connectionTypeChanged(NetworkState networkState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, networkState) == null) {
            ConnectionType connectionType = getConnectionType(networkState);
            String wifiSSID = getWifiSSID(networkState);
            if (connectionType != this.connectionType || !wifiSSID.equals(this.wifiSSID)) {
                this.connectionType = connectionType;
                this.wifiSSID = wifiSSID;
                Logging.d(TAG, "Network connectivity changed, type is: " + this.connectionType);
                this.observer.onConnectionTypeChanged(connectionType);
            }
        }
    }

    public static ConnectionType getConnectionType(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (!z) {
                return ConnectionType.CONNECTION_NONE;
            }
            if (i != 0) {
                if (i != 1) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 9) {
                                if (i != 17) {
                                    return ConnectionType.CONNECTION_UNKNOWN;
                                }
                                return ConnectionType.CONNECTION_VPN;
                            }
                            return ConnectionType.CONNECTION_ETHERNET;
                        }
                        return ConnectionType.CONNECTION_BLUETOOTH;
                    }
                    return ConnectionType.CONNECTION_4G;
                }
                return ConnectionType.CONNECTION_WIFI;
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return ConnectionType.CONNECTION_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return ConnectionType.CONNECTION_3G;
                case 13:
                    return ConnectionType.CONNECTION_4G;
                default:
                    return ConnectionType.CONNECTION_UNKNOWN_CELLULAR;
            }
        }
        return (ConnectionType) invokeCommon.objValue;
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && !this.isRegistered) {
            this.isRegistered = true;
            this.context.registerReceiver(this, this.intentFilter);
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && this.isRegistered) {
            this.isRegistered = false;
            try {
                this.context.unregisterReceiver(this);
            } catch (Exception unused) {
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ConnectivityManager.NetworkCallback networkCallback = this.allNetworkCallback;
            if (networkCallback != null) {
                this.connectivityManagerDelegate.releaseCallback(networkCallback);
            }
            ConnectivityManager.NetworkCallback networkCallback2 = this.mobileNetworkCallback;
            if (networkCallback2 != null) {
                this.connectivityManagerDelegate.releaseCallback(networkCallback2);
            }
            WifiDirectManagerDelegate wifiDirectManagerDelegate = this.wifiDirectManagerDelegate;
            if (wifiDirectManagerDelegate != null) {
                wifiDirectManagerDelegate.release();
            }
            unregisterReceiver();
        }
    }

    public List getActiveNetworkList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List activeNetworkList = this.connectivityManagerDelegate.getActiveNetworkList();
            if (activeNetworkList == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(activeNetworkList);
            WifiDirectManagerDelegate wifiDirectManagerDelegate = this.wifiDirectManagerDelegate;
            if (wifiDirectManagerDelegate != null) {
                arrayList.addAll(wifiDirectManagerDelegate.getActiveNetworkList());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public NetworkState getCurrentNetworkState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.connectivityManagerDelegate.getNetworkState();
        }
        return (NetworkState) invokeV.objValue;
    }

    public long getDefaultNetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.connectivityManagerDelegate.getDefaultNetId();
        }
        return invokeV.longValue;
    }

    public boolean isReceiverRegisteredForTesting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.isRegistered;
        }
        return invokeV.booleanValue;
    }

    public boolean supportNetworkCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.connectivityManagerDelegate.supportNetworkCallback();
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, intent) == null) {
            NetworkState currentNetworkState = getCurrentNetworkState();
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                connectionTypeChanged(currentNetworkState);
            }
        }
    }
}
