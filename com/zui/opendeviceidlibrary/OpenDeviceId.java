package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.zui.deviceidservice.IDeviceidInterface;
/* loaded from: classes2.dex */
public class OpenDeviceId {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DBG = false;
    public static String TAG = "OpenDeviceId library";
    public transient /* synthetic */ FieldHolder $fh;
    public CallBack mCallerCallBack;
    public ServiceConnection mConnection;
    public Context mContext;
    public IDeviceidInterface mDeviceidInterface;

    /* loaded from: classes2.dex */
    public interface CallBack<T> {
        void serviceConnected(T t, OpenDeviceId openDeviceId);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-308352714, "Lcom/zui/opendeviceidlibrary/OpenDeviceId;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-308352714, "Lcom/zui/opendeviceidlibrary/OpenDeviceId;");
        }
    }

    public OpenDeviceId() {
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
        this.mContext = null;
        this.mCallerCallBack = null;
    }

    private void logPrintE(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) {
            boolean z = DBG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPrintI(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            boolean z = DBG;
        }
    }

    public String getAAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context context = this.mContext;
            if (context == null) {
                logPrintI("Context is null.");
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            String packageName = context.getPackageName();
            logPrintI("liufeng, getAAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                logPrintI("input package is null!");
                return null;
            }
            try {
                IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
                if (iDeviceidInterface != null) {
                    String aaid = iDeviceidInterface.getAAID(packageName);
                    return ((aaid == null || "".equals(aaid)) && this.mDeviceidInterface.createAAIDForPackageName(packageName)) ? this.mDeviceidInterface.getAAID(packageName) : aaid;
                }
                return null;
            } catch (RemoteException unused) {
                logPrintE("getAAID error, RemoteException!");
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mContext == null) {
                logPrintE("Context is null.");
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            try {
                IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.getOAID();
                }
                return null;
            } catch (RemoteException e2) {
                logPrintE("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String getUDID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mContext == null) {
                logPrintE("Context is null.");
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            try {
                IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.getUDID();
                }
                return null;
            } catch (RemoteException e2) {
                logPrintE("getUDID error, RemoteException!");
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                logPrintE("getUDID error, Exception!");
                e3.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String getVAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.mContext;
            if (context == null) {
                logPrintI("Context is null.");
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            String packageName = context.getPackageName();
            logPrintI("liufeng, getVAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                logPrintI("input package is null!");
                return null;
            }
            try {
                IDeviceidInterface iDeviceidInterface = this.mDeviceidInterface;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.getVAID(packageName);
                }
                return null;
            } catch (RemoteException e2) {
                logPrintE("getVAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public int init(Context context, CallBack<String> callBack) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, callBack)) == null) {
            if (context != null) {
                this.mContext = context;
                this.mCallerCallBack = callBack;
                this.mConnection = new ServiceConnection(this) { // from class: com.zui.opendeviceidlibrary.OpenDeviceId.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OpenDeviceId this$0;

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

                    @Override // android.content.ServiceConnection
                    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                            synchronized (this) {
                                this.this$0.mDeviceidInterface = IDeviceidInterface.Stub.asInterface(iBinder);
                                if (this.this$0.mCallerCallBack != null) {
                                    this.this$0.mCallerCallBack.serviceConnected("Deviceid Service Connected", this.this$0);
                                }
                                this.this$0.logPrintI("Service onServiceConnected");
                            }
                        }
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                            this.this$0.mDeviceidInterface = null;
                            this.this$0.logPrintI("Service onServiceDisconnected");
                        }
                    }
                };
                Intent intent = new Intent();
                intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
                if (this.mContext.bindService(intent, this.mConnection, 1)) {
                    logPrintI("bindService Successful!");
                    return 1;
                }
                logPrintI("bindService Failed!");
                return -1;
            }
            throw new NullPointerException("Context can not be null.");
        }
        return invokeLL.intValue;
    }

    public boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if (this.mDeviceidInterface != null) {
                    logPrintI("Device support opendeviceid");
                    return this.mDeviceidInterface.isSupport();
                }
                return false;
            } catch (RemoteException unused) {
                logPrintE("isSupport error, RemoteException!");
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setLogEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            DBG = z;
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.mContext.unbindService(this.mConnection);
                logPrintI("unBind Service successful");
            } catch (IllegalArgumentException unused) {
                logPrintE("unBind Service exception");
            }
            this.mDeviceidInterface = null;
        }
    }
}
