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
/* loaded from: classes9.dex */
public class CameraConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69849a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

        public FacingDirection(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeCode = i3;
        }

        public static FacingDirection forNumber(int i2) {
            InterceptResult invokeI;
            FacingDirection[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (FacingDirection facingDirection : values()) {
                    if (facingDirection.nativeCode == i2) {
                        return facingDirection;
                    }
                }
                StringBuilder sb = new StringBuilder(62);
                sb.append("Unexpected value for native FacingDirection, value=");
                sb.append(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69849a = 0L;
    }

    public static native void nativeDestroyCameraConfig(long j2);

    private native String nativeGetCameraId(long j2, long j3);

    private native int nativeGetFacingDirection(long j2, long j3);

    private native void nativeGetImageDimensions(long j2, long j3, int[] iArr);

    private native void nativeGetTextureDimensions(long j2, long j3, int[] iArr);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.f69849a;
            if (j2 != 0) {
                nativeDestroyCameraConfig(j2);
                this.f69849a = 0L;
            }
            super.finalize();
        }
    }
}
