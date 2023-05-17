package com.vivo.identifier;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes10.dex */
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

    @Keep
    public static native String getAAID(Context context);

    @Keep
    public static native String getAAID(Context context, String str);

    @Keep
    public static native String getOAID(Context context);

    @Keep
    public static native String getOAIDStatus(Context context);

    @Keep
    public static native String getVAID(Context context);

    @Keep
    public static native String getVAID(Context context, String str);

    @Keep
    public static native boolean isSupported(Context context);

    @Keep
    public static native boolean setDebuggable(boolean z);
}
