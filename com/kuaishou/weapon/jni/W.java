package com.kuaishou.weapon.jni;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.d;
/* loaded from: classes7.dex */
public class W {
    public static /* synthetic */ Interceptable $ic;
    public static volatile W instance;
    public static volatile int loadSoCount;
    public static volatile boolean loadSuccess;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(221746393, "Lcom/kuaishou/weapon/jni/W;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(221746393, "Lcom/kuaishou/weapon/jni/W;");
        }
    }

    public W() {
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

    public static W getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (instance == null) {
                synchronized (W.class) {
                    if (instance == null) {
                        instance = new W();
                    }
                    try {
                        d dVar = new d(context);
                        try {
                            String a = dVar.a(d.P0, "");
                            if (TextUtils.isEmpty(a)) {
                                a = "2.8.3";
                                dVar.b(d.P0, "2.8.3");
                            }
                            loadSoCount = dVar.c(d.O0);
                            if (!TextUtils.equals(a, "2.8.3")) {
                                loadSoCount = 0;
                                dVar.b(d.P0, "2.8.3");
                            }
                            if (loadSoCount + 1 < 5) {
                                loadSuccess = false;
                                loadSoCount++;
                                dVar.c(d.O0, loadSoCount);
                                System.loadLibrary("w");
                                loadSoCount = 0;
                                loadSuccess = true;
                            }
                        } catch (Exception unused) {
                            loadSuccess = false;
                        }
                        dVar.c(d.O0, loadSoCount);
                    } catch (Throwable unused2) {
                    }
                }
            }
            return instance;
        }
        return (W) invokeL.objValue;
    }

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native byte[] dr(byte[] bArr, byte[] bArr2);
}
