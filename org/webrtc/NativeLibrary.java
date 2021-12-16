package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NativeLibrary {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "NativeLibrary";
    public static boolean libraryLoaded;
    public static Object lock;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class DefaultLoader implements NativeLibraryLoader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultLoader() {
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

        @Override // org.webrtc.NativeLibraryLoader
        public boolean load(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                String str2 = NativeLibrary.TAG;
                Logging.d(str2, "Loading library: " + str);
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (UnsatisfiedLinkError e2) {
                    String str3 = NativeLibrary.TAG;
                    Logging.e(str3, "Failed to load native library: " + str, e2);
                    Logging.e(NativeLibrary.TAG, "force treat as OK.", e2);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2077048898, "Lorg/webrtc/NativeLibrary;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2077048898, "Lorg/webrtc/NativeLibrary;");
                return;
            }
        }
        lock = new Object();
    }

    public NativeLibrary() {
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

    public static void initialize(NativeLibraryLoader nativeLibraryLoader, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, nativeLibraryLoader, str) == null) {
            synchronized (lock) {
                if (libraryLoaded) {
                    Logging.d(TAG, "Native library has already been loaded.");
                } else {
                    String str2 = TAG;
                    Logging.d(str2, "Loading native library: " + str);
                    libraryLoaded = nativeLibraryLoader.load(str);
                }
            }
        }
    }

    public static boolean isLoaded() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (lock) {
                z = libraryLoaded;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
