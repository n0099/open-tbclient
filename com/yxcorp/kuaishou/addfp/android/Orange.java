package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yxcorp.kuaishou.addfp.c.a.a;
/* loaded from: classes10.dex */
public class Orange {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int JNI_CONTROL_COMMAND_DIR_DETECT = 1114128;
    public static final int JNI_CONTROL_COMMAND_GK_DETECT = 1114132;
    public static final int JNI_CONTROL_COMMAND_MANU_DETECT = 1114140;
    public static final int JNI_CONTROL_COMMAND_PROPS_DETECT = 1114131;
    public static final int JNI_CONTROL_COMMAND_SERIAL_DETECT = 1179649;
    public static boolean sLibLoadFail = true;
    public static final String sdkVersion = "1.3.4.85.ee9555a2";
    public static volatile Orange singleton;
    public transient /* synthetic */ FieldHolder $fh;

    public Orange() {
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
        loadSoLib();
    }

    public static String gLs(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
            try {
                return a.a(i, str);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeIL.objValue;
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

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? sdkVersion : (String) invokeV.objValue;
    }

    private boolean isReject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? sLibLoadFail : invokeV.booleanValue;
    }

    public static native Object jniCommand(int i, Object obj, Object obj2, Object obj3);

    private void loadSoLib() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            try {
                System.loadLibrary("sgcore");
                sLibLoadFail = false;
            } catch (Throwable th) {
                sLibLoadFail = true;
                th.printStackTrace();
            }
        }
    }

    public byte[] dcc(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, bArr2)) == null) {
            try {
                isReject();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public String gKpsd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_GK_DETECT, null, null, null);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String gManu(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            try {
                return (isReject() || context == null) ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_MANU_DETECT, str, context.getPackageName(), null);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public String gProps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, context, bArr, i)) == null) {
            synchronized (this) {
                return isReject() ? "" : getClock(context, bArr, i);
            }
        }
        return (String) invokeLLI.objValue;
    }

    public synchronized byte[] getMagicWrapper(Context context, byte[] bArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, context, bArr, i)) == null) {
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
