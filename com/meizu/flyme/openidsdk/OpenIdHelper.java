package com.meizu.flyme.openidsdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class OpenIdHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "OpenIdHelper";
    public static Method sContextMethod;
    public transient /* synthetic */ FieldHolder $fh;

    public OpenIdHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static native String getAAID(Context context);

    public static native String getOAID(Context context);

    public static native String getUDID(Context context);

    public static native String getVAID(Context context);

    public static final native boolean isSupported();

    public static native void setLogEnable(boolean z);
}
