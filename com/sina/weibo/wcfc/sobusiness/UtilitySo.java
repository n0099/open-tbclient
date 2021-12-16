package com.sina.weibo.wcfc.sobusiness;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class UtilitySo {
    public static /* synthetic */ Interceptable $ic;
    public static UtilitySo sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(652602547, "Lcom/sina/weibo/wcfc/sobusiness/UtilitySo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(652602547, "Lcom/sina/weibo/wcfc/sobusiness/UtilitySo;");
                return;
            }
        }
        try {
            System.loadLibrary("utility");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public UtilitySo() {
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

    public static synchronized UtilitySo getInstance() {
        InterceptResult invokeV;
        UtilitySo utilitySo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (UtilitySo.class) {
                if (sInstance == null) {
                    sInstance = new UtilitySo();
                }
                utilitySo = sInstance;
            }
            return utilitySo;
        }
        return (UtilitySo) invokeV.objValue;
    }

    public native String calculateS(Context context, String str);

    public native String generateCheckToken(Context context, String str, String str2);

    public native String getDecryptionString(Context context, String str);

    public native String getIValue(Context context, String str);
}
