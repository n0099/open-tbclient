package com.facebook.soloader.nativeloader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes7.dex */
public class NativeLoader {
    public static /* synthetic */ Interceptable $ic;
    public static NativeLoaderDelegate sDelegate;
    public transient /* synthetic */ FieldHolder $fh;

    public NativeLoader() {
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

    public static synchronized boolean isInitialized() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (NativeLoader.class) {
                if (sDelegate != null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
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

    public static boolean loadLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return loadLibrary(str, 0);
        }
        return invokeL.booleanValue;
    }

    public static boolean loadLibrary(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            synchronized (NativeLoader.class) {
                if (sDelegate == null) {
                    throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
                }
            }
            return sDelegate.loadLibrary(str, i);
        }
        return invokeLI.booleanValue;
    }
}
