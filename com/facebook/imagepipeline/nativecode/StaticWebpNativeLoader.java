package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.soloader.SoLoaderProxy;
/* loaded from: classes6.dex */
public class StaticWebpNativeLoader {
    public static /* synthetic */ Interceptable $ic;
    public static boolean sInitialized;
    public transient /* synthetic */ FieldHolder $fh;

    public StaticWebpNativeLoader() {
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

    public static synchronized void ensure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (StaticWebpNativeLoader.class) {
                if (!sInitialized) {
                    if (Build.VERSION.SDK_INT <= 16) {
                        try {
                            SoLoaderProxy.loadLibrary("fb_jpegturbo");
                        } catch (UnsatisfiedLinkError unused) {
                        }
                    }
                    SoLoaderProxy.loadLibrary("static-webp");
                    sInitialized = true;
                }
            }
        }
    }
}
