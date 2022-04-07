package com.kwad.v8;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class Platform {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANDROID = "android";
    public static final String LINUX = "linux";
    public static final String MACOSX = "macosx";
    public static final String NATIVE_CLIENT = "nacl";
    public static final String UNKNOWN = "unknown";
    public static final String WINDOWS = "windows";
    public transient /* synthetic */ FieldHolder $fh;

    public Platform() {
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
}
