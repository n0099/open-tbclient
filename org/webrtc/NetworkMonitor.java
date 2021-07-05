package org.webrtc;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.webrtc.NetworkMonitorAutoDetect;
/* loaded from: classes10.dex */
public class NetworkMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NetworkMonitor";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public NetworkMonitorAutoDetect autoDetect;
    public final Object autoDetectLock;
    public volatile NetworkMonitorAutoDetect.ConnectionType currentConnectionType;
    public final ArrayList<Long> nativeNetworkObservers;
    public final ArrayList<NetworkObserver> networkObservers;
    public int numObservers;

    /* loaded from: classes10.dex */
    public static class InstanceHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final NetworkMonitor instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-567373203, "Lorg/webrtc/NetworkMonitor$InstanceHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-567373203, "Lorg/webrtc/NetworkMonitor$InstanceHolder;");
                    return;
                }
            }
            instance = new NetworkMonitor();
        }

        public InstanceHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface NetworkObserver {
        void onConnectionTypeChanged(NetworkMonitorAutoDetect.ConnectionType connectionType);
    }

    public NetworkMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.autoDetectLock = new Object();
        this.nativeNetworkObservers = new ArrayList<>();
        this.networkObservers = new ArrayList<>();
        this.numObservers = 0;
        this.currentConnectionType = NetworkMonitorAutoDetect.ConnectionType.CONNECTION_UNKNOWN;
    }

    @Deprecated
    public static void addNetworkObserver(NetworkObserver networkObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, networkObserver) == null) {
            getInstance().addObserver(networkObserver);
        }
    }

    @CalledByNative
    public static int androidSdkInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public static void assertIsTrue(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65543, null, z) == null) && !z) {
            throw new AssertionError("Expected to be true");
        }
    }

    public static NetworkMonitorAutoDetect createAndSetAutoDetectForTest(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            NetworkMonitor networkMonitor = getInstance();
            NetworkMonitorAutoDetect createAutoDetect = networkMonitor.createAutoDetect(context);
            networkMonitor.autoDetect = createAutoDetect;
            return createAutoDetect;
        }
        return (NetworkMonitorAutoDetect) invokeL.objValue;
    }

    private NetworkMonitorAutoDetect createAutoDetect(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, this, context)) == null) ? new NetworkMonitorAutoDetect(new NetworkMonitorAutoDetect.Observer(this) { // from class: org.webrtc.NetworkMonitor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NetworkMonitor this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // org.webrtc.NetworkMonitorAutoDetect.Observer
            public void onConnectionTypeChanged(NetworkMonitorAutoDetect.ConnectionType connectionType) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, connectionType) == null) {
                    this.this$0.updateCurrentConnectionType(connectionType);
                }
            }

            @Override // org.webrtc.NetworkMonitorAutoDetect.Observer
            public void onNetworkConnect(NetworkMonitorAutoDetect.NetworkInformation networkInformation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkInformation) == null) {
                    this.this$0.notifyObserversOfNetworkConnect(networkInformation);
                }
            }

            @Override // org.webrtc.NetworkMonitorAutoDetect.Observer
            public void onNetworkDisconnect(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                    this.this$0.notifyObserversOfNetworkDisconnect(j);
                }
            }
        }, context) : (NetworkMonitorAutoDetect) invokeL.objValue;
    }

    private NetworkMonitorAutoDetect.ConnectionType getCurrentConnectionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.currentConnectionType : (NetworkMonitorAutoDetect.ConnectionType) invokeV.objValue;
    }

    private long getCurrentDefaultNetId() {
        InterceptResult invokeV;
        long defaultNetId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            synchronized (this.autoDetectLock) {
                defaultNetId = this.autoDetect == null ? -1L : this.autoDetect.getDefaultNetId();
            }
            return defaultNetId;
        }
        return invokeV.longValue;
    }

    @CalledByNative
    public static NetworkMonitor getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? InstanceHolder.instance : (NetworkMonitor) invokeV.objValue;
    }

    private List<Long> getNativeNetworkObserversSync() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            synchronized (this.nativeNetworkObservers) {
                arrayList = new ArrayList(this.nativeNetworkObservers);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Deprecated
    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
        }
    }

    public static boolean isOnline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? getInstance().getCurrentConnectionType() != NetworkMonitorAutoDetect.ConnectionType.CONNECTION_NONE : invokeV.booleanValue;
    }

    private native void nativeNotifyConnectionTypeChanged(long j);

    private native void nativeNotifyOfActiveNetworkList(long j, NetworkMonitorAutoDetect.NetworkInformation[] networkInformationArr);

    private native void nativeNotifyOfNetworkConnect(long j, NetworkMonitorAutoDetect.NetworkInformation networkInformation);

    private native void nativeNotifyOfNetworkDisconnect(long j, long j2);

    @CalledByNative
    private boolean networkBindingSupported() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            synchronized (this.autoDetectLock) {
                z = this.autoDetect != null && this.autoDetect.supportNetworkCallback();
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private void notifyObserversOfConnectionTypeChange(NetworkMonitorAutoDetect.ConnectionType connectionType) {
        ArrayList<NetworkObserver> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, connectionType) == null) {
            for (Long l : getNativeNetworkObserversSync()) {
                nativeNotifyConnectionTypeChanged(l.longValue());
            }
            synchronized (this.networkObservers) {
                arrayList = new ArrayList(this.networkObservers);
            }
            for (NetworkObserver networkObserver : arrayList) {
                networkObserver.onConnectionTypeChanged(connectionType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObserversOfNetworkConnect(NetworkMonitorAutoDetect.NetworkInformation networkInformation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, networkInformation) == null) {
            for (Long l : getNativeNetworkObserversSync()) {
                nativeNotifyOfNetworkConnect(l.longValue(), networkInformation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObserversOfNetworkDisconnect(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65559, this, j) == null) {
            for (Long l : getNativeNetworkObserversSync()) {
                nativeNotifyOfNetworkDisconnect(l.longValue(), j);
            }
        }
    }

    @Deprecated
    public static void removeNetworkObserver(NetworkObserver networkObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, networkObserver) == null) {
            getInstance().removeObserver(networkObserver);
        }
    }

    @CalledByNative
    private void startMonitoring(@Nullable Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65561, this, context, j) == null) {
            Logging.d(TAG, "Start monitoring with native observer " + j);
            if (context == null) {
                context = ContextUtils.getApplicationContext();
            }
            startMonitoring(context);
            synchronized (this.nativeNetworkObservers) {
                this.nativeNetworkObservers.add(Long.valueOf(j));
            }
            updateObserverActiveNetworkList(j);
            notifyObserversOfConnectionTypeChange(this.currentConnectionType);
        }
    }

    @CalledByNative
    private void stopMonitoring(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65562, this, j) == null) {
            Logging.d(TAG, "Stop monitoring with native observer " + j);
            stopMonitoring();
            synchronized (this.nativeNetworkObservers) {
                this.nativeNetworkObservers.remove(Long.valueOf(j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConnectionType(NetworkMonitorAutoDetect.ConnectionType connectionType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, connectionType) == null) {
            this.currentConnectionType = connectionType;
            notifyObserversOfConnectionTypeChange(connectionType);
        }
    }

    private void updateObserverActiveNetworkList(long j) {
        List<NetworkMonitorAutoDetect.NetworkInformation> activeNetworkList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65564, this, j) == null) {
            synchronized (this.autoDetectLock) {
                activeNetworkList = this.autoDetect == null ? null : this.autoDetect.getActiveNetworkList();
            }
            if (activeNetworkList == null || activeNetworkList.size() == 0) {
                return;
            }
            nativeNotifyOfActiveNetworkList(j, (NetworkMonitorAutoDetect.NetworkInformation[]) activeNetworkList.toArray(new NetworkMonitorAutoDetect.NetworkInformation[activeNetworkList.size()]));
        }
    }

    public void addObserver(NetworkObserver networkObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, networkObserver) == null) {
            synchronized (this.networkObservers) {
                this.networkObservers.add(networkObserver);
            }
        }
    }

    @Nullable
    public NetworkMonitorAutoDetect getNetworkMonitorAutoDetect() {
        InterceptResult invokeV;
        NetworkMonitorAutoDetect networkMonitorAutoDetect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.autoDetectLock) {
                networkMonitorAutoDetect = this.autoDetect;
            }
            return networkMonitorAutoDetect;
        }
        return (NetworkMonitorAutoDetect) invokeV.objValue;
    }

    public int getNumObservers() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.autoDetectLock) {
                i2 = this.numObservers;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void removeObserver(NetworkObserver networkObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, networkObserver) == null) {
            synchronized (this.networkObservers) {
                this.networkObservers.remove(networkObserver);
            }
        }
    }

    @Deprecated
    public void startMonitoring() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            startMonitoring(ContextUtils.getApplicationContext());
        }
    }

    public void startMonitoring(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            synchronized (this.autoDetectLock) {
                this.numObservers++;
                if (this.autoDetect == null) {
                    this.autoDetect = createAutoDetect(context);
                }
                this.currentConnectionType = NetworkMonitorAutoDetect.getConnectionType(this.autoDetect.getCurrentNetworkState());
            }
        }
    }

    public void stopMonitoring() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.autoDetectLock) {
                int i2 = this.numObservers - 1;
                this.numObservers = i2;
                if (i2 == 0) {
                    this.autoDetect.destroy();
                    this.autoDetect = null;
                }
            }
        }
    }
}
