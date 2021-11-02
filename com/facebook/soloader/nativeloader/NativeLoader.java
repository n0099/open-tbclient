package com.facebook.soloader.nativeloader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes11.dex */
public class NativeLoader {
    public static /* synthetic */ Interceptable $ic;
    public static NativeLoaderDelegate sDelegate;
    public transient /* synthetic */ FieldHolder $fh;

    public NativeLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getLibraryPath(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (NativeLoader.class) {
                if (sDelegate == null) {
                    throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
                }
            }
            return sDelegate.getLibraryPath(str);
        }
        return (String) invokeL.objValue;
    }

    public static int getSoSourcesVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (NativeLoader.class) {
                if (sDelegate == null) {
                    throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
                }
            }
            return sDelegate.getSoSourcesVersion();
        }
        return invokeV.intValue;
    }

    public static synchronized void init(NativeLoaderDelegate nativeLoaderDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, nativeLoaderDelegate) == null) {
            synchronized (NativeLoader.class) {
                if (sDelegate == null) {
                    sDelegate = nativeLoaderDelegate;
                } else {
                    throw new IllegalStateException("Cannot re-initialize NativeLoader.");
                }
            }
        }
    }

    public static synchronized boolean isInitialized() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (NativeLoader.class) {
                z = sDelegate != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean loadLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? loadLibrary(str, 0) : invokeL.booleanValue;
    }

    public static boolean loadLibrary(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, str, i2)) == null) {
            synchronized (NativeLoader.class) {
                if (sDelegate == null) {
                    throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
                }
            }
            return sDelegate.loadLibrary(str, i2);
        }
        return invokeLI.booleanValue;
    }
}
