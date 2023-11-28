package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.zui.deviceidservice.IDeviceidInterface;
@Keep
/* loaded from: classes2.dex */
public class OpenDeviceId {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static boolean DBG = false;
    @Keep
    public static String TAG = "OpenDeviceId library";
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public CallBack mCallerCallBack;
    @Keep
    public ServiceConnection mConnection;
    @Keep
    public Context mContext;
    @Keep
    public IDeviceidInterface mDeviceidInterface;

    @Keep
    /* loaded from: classes2.dex */
    public interface CallBack<T> {
        @Keep
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mCallerCallBack = null;
    }

    @Keep
    private native void logPrintE(String str);

    /* JADX INFO: Access modifiers changed from: private */
    @Keep
    public native void logPrintI(String str);

    @Keep
    public native String getAAID();

    @Keep
    public native String getOAID();

    @Keep
    public native String getUDID();

    @Keep
    public native String getVAID();

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
                    @Keep
                    public final /* synthetic */ OpenDeviceId this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.content.ServiceConnection
                    @Keep
                    public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

                    @Override // android.content.ServiceConnection
                    @Keep
                    public native void onServiceDisconnected(ComponentName componentName);
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

    @Keep
    public native boolean isSupported();

    @Keep
    public native void setLogEnable(boolean z);

    @Keep
    public native void shutdown();
}
