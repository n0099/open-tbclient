package com.yxcorp.kuaishou.addfp.android;

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
public class Orange {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int JNI_CONTROL_COMMAND_DIR_DETECT = 1114128;
    public static final int JNI_CONTROL_COMMAND_GK_DETECT = 1114132;
    public static final int JNI_CONTROL_COMMAND_MACS_DETECT = 1179653;
    public static final int JNI_CONTROL_COMMAND_PROPS_DETECT = 1114131;
    public static final int JNI_CONTROL_COMMAND_SERIAL_DETECT = 1179649;
    public static boolean sLibLoadFail = true;
    public static volatile Orange singleton;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-831239597, "Lcom/yxcorp/kuaishou/addfp/android/Orange;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-831239597, "Lcom/yxcorp/kuaishou/addfp/android/Orange;");
        }
    }

    public Orange() {
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
        loadSoLib();
    }

    public static native String getClock(Context context, byte[] bArr, int i);

    public static Orange getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (singleton == null) {
                synchronized (Orange.class) {
                    if (singleton == null) {
                        singleton = new Orange();
                    }
                }
            }
            return singleton;
        }
        return (Orange) invokeV.objValue;
    }

    public static native byte[] getMagic(Context context, byte[] bArr, int i);

    private boolean isReject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? sLibLoadFail : invokeV.booleanValue;
    }

    public static native Object jniCommand(int i, Object obj, Object obj2, Object obj3);

    private void loadSoLib() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                System.loadLibrary("sgcore");
                sLibLoadFail = false;
            } catch (Throwable th) {
                sLibLoadFail = true;
                th.printStackTrace();
            }
        }
    }

    public String gKpsd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_GK_DETECT, null, null, null);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String gMas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_MACS_DETECT, null, null, null);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String gProps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_PROPS_DETECT, null, null, null);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String gRdi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_DIR_DETECT, null, null, null);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String gSer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_SERIAL_DETECT, null, null, null);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized String getClockWrapper(Context context, byte[] bArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, context, bArr, i)) == null) {
            synchronized (this) {
                return isReject() ? "" : getClock(context, bArr, i);
            }
        }
        return (String) invokeLLI.objValue;
    }

    public synchronized byte[] getMagicWrapper(Context context, byte[] bArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, context, bArr, i)) == null) {
            synchronized (this) {
                if (isReject()) {
                    return null;
                }
                return getMagic(context, bArr, i);
            }
        }
        return (byte[]) invokeLLI.objValue;
    }
}
