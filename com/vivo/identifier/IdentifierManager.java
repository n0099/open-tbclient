package com.vivo.identifier;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class IdentifierManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IdentifierManager() {
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

    public static native String getAAID(Context context, String str);

    public static native String getOAID(Context context);

    public static native String getOAIDStatus(Context context);

    public static native String getVAID(Context context);

    public static native String getVAID(Context context, String str);

    public static native boolean isSupported(Context context);

    public static native boolean setDebuggable(boolean z);
}
