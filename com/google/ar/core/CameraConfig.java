package com.google.ar.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes4.dex */
public class CameraConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class FacingDirection {
        public static final /* synthetic */ FacingDirection[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FacingDirection BACK;
        public static final FacingDirection FRONT;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-970336443, "Lcom/google/ar/core/CameraConfig$FacingDirection;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-970336443, "Lcom/google/ar/core/CameraConfig$FacingDirection;");
                    return;
                }
            }
            BACK = new FacingDirection("BACK", 0, 0);
            FacingDirection facingDirection = new FacingDirection("FRONT", 1, 1);
            FRONT = facingDirection;
            $VALUES = new FacingDirection[]{BACK, facingDirection};
        }

        public FacingDirection(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeCode = i2;
        }

        public static FacingDirection forNumber(int i) {
            InterceptResult invokeI;
            FacingDirection[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                for (FacingDirection facingDirection : values()) {
                    if (facingDirection.nativeCode == i) {
                        return facingDirection;
                    }
                }
                StringBuilder sb = new StringBuilder(62);
                sb.append("Unexpected value for native FacingDirection, value=");
                sb.append(i);
                throw new FatalException(sb.toString());
            }
            return (FacingDirection) invokeI.objValue;
        }

        public static FacingDirection valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (FacingDirection) Enum.valueOf(FacingDirection.class, str) : (FacingDirection) invokeL.objValue;
        }

        public static FacingDirection[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (FacingDirection[]) $VALUES.clone() : (FacingDirection[]) invokeV.objValue;
        }
    }

    public CameraConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
    }

    public static native void nativeDestroyCameraConfig(long j);

    private native String nativeGetCameraId(long j, long j2);

    private native int nativeGetFacingDirection(long j, long j2);

    private native void nativeGetImageDimensions(long j, long j2, int[] iArr);

    private native void nativeGetTextureDimensions(long j, long j2, int[] iArr);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.a;
            if (j != 0) {
                nativeDestroyCameraConfig(j);
                this.a = 0L;
            }
            super.finalize();
        }
    }
}
