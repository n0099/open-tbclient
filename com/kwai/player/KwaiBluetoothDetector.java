package com.kwai.player;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class KwaiBluetoothDetector {
    public static /* synthetic */ Interceptable $ic;
    public static KwaiBluetoothDetector sBluetoothUtil;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public BluetoothA2dp mBluetoothA2dp;
    public BluetoothAdapter mBluetoothAdapter;
    public BluetoothHeadset mBluetoothHeadset;
    public final Object mLock;
    public BluetoothProfile.ServiceListener mProfileListener;
    public boolean misInited;

    /* loaded from: classes7.dex */
    public class KwaiBluetoothDeviceInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAddress;
        public String mDeviceInfo;
        public String mName;
        public final /* synthetic */ KwaiBluetoothDetector this$0;

        public KwaiBluetoothDeviceInfo(KwaiBluetoothDetector kwaiBluetoothDetector) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kwaiBluetoothDetector};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = kwaiBluetoothDetector;
            this.mName = null;
            this.mAddress = null;
            this.mDeviceInfo = null;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mName != null) {
                    this.mDeviceInfo = "name: " + this.mName;
                }
                if (this.mAddress != null) {
                    this.mDeviceInfo += ", address: " + this.mAddress;
                }
                return this.mDeviceInfo;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1263415112, "Lcom/kwai/player/KwaiBluetoothDetector;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1263415112, "Lcom/kwai/player/KwaiBluetoothDetector;");
        }
    }

    public KwaiBluetoothDetector() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.TAG = "KwaiBluetoothDetector";
        this.mLock = new Object();
        this.misInited = false;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothHeadset = null;
        this.mBluetoothA2dp = null;
        this.mProfileListener = new BluetoothProfile.ServiceListener(this) { // from class: com.kwai.player.KwaiBluetoothDetector.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KwaiBluetoothDetector this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i4, BluetoothProfile bluetoothProfile) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, bluetoothProfile) == null) {
                    synchronized (this.this$0.mLock) {
                        try {
                            if (i4 == 2) {
                                this.this$0.mBluetoothA2dp = (BluetoothA2dp) bluetoothProfile;
                            } else if (i4 == 1) {
                                this.this$0.mBluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4) == null) {
                    synchronized (this.this$0.mLock) {
                        try {
                            if (i4 == 2) {
                                this.this$0.mBluetoothA2dp = null;
                            } else if (i4 == 1) {
                                this.this$0.mBluetoothHeadset = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        };
    }

    public static synchronized KwaiBluetoothDetector getInstance() {
        InterceptResult invokeV;
        KwaiBluetoothDetector kwaiBluetoothDetector;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (KwaiBluetoothDetector.class) {
                if (sBluetoothUtil == null) {
                    sBluetoothUtil = new KwaiBluetoothDetector();
                }
                kwaiBluetoothDetector = sBluetoothUtil;
            }
            return kwaiBluetoothDetector;
        }
        return (KwaiBluetoothDetector) invokeV.objValue;
    }

    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.misInited) {
                    this.mBluetoothAdapter.closeProfileProxy(2, this.mBluetoothA2dp);
                    this.mBluetoothAdapter.closeProfileProxy(1, this.mBluetoothHeadset);
                    this.misInited = false;
                }
            }
        }
    }

    public String getBlueToothInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            KwaiBluetoothDeviceInfo kwaiBluetoothDeviceInfo = new KwaiBluetoothDeviceInfo(this);
            BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
            if (bluetoothAdapter != null && 12 == bluetoothAdapter.getState()) {
                synchronized (this.mLock) {
                    if (this.mBluetoothA2dp != null) {
                        for (BluetoothDevice bluetoothDevice : this.mBluetoothA2dp.getConnectedDevices()) {
                            if (this.mBluetoothA2dp.isA2dpPlaying(bluetoothDevice)) {
                                kwaiBluetoothDeviceInfo.mName = bluetoothDevice.getName();
                                kwaiBluetoothDeviceInfo.mAddress = bluetoothDevice.getAddress();
                            }
                        }
                    } else if (this.mBluetoothHeadset != null) {
                        for (BluetoothDevice bluetoothDevice2 : this.mBluetoothHeadset.getConnectedDevices()) {
                            if (this.mBluetoothHeadset.isAudioConnected(bluetoothDevice2)) {
                                kwaiBluetoothDeviceInfo.mName = bluetoothDevice2.getName();
                                kwaiBluetoothDeviceInfo.mAddress = bluetoothDevice2.getAddress();
                            }
                        }
                    }
                }
            }
            return kwaiBluetoothDeviceInfo.toString();
        }
        return (String) invokeV.objValue;
    }

    public synchronized void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            synchronized (this) {
                if (!this.misInited) {
                    this.mBluetoothAdapter.getProfileProxy(context, this.mProfileListener, 2);
                    this.mBluetoothAdapter.getProfileProxy(context, this.mProfileListener, 1);
                    this.misInited = true;
                }
            }
        }
    }
}
