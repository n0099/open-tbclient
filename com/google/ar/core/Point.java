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
/* loaded from: classes5.dex */
public class Point extends TrackableBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class OrientationMode {
        public static final /* synthetic */ OrientationMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OrientationMode ESTIMATED_SURFACE_NORMAL;
        public static final OrientationMode INITIALIZED_TO_IDENTITY;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(745344298, "Lcom/google/ar/core/Point$OrientationMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(745344298, "Lcom/google/ar/core/Point$OrientationMode;");
                    return;
                }
            }
            INITIALIZED_TO_IDENTITY = new OrientationMode("INITIALIZED_TO_IDENTITY", 0, 0);
            OrientationMode orientationMode = new OrientationMode("ESTIMATED_SURFACE_NORMAL", 1, 1);
            ESTIMATED_SURFACE_NORMAL = orientationMode;
            $VALUES = new OrientationMode[]{INITIALIZED_TO_IDENTITY, orientationMode};
        }

        public OrientationMode(String str, int i, int i2) {
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

        public static OrientationMode fromNumber(int i) {
            InterceptResult invokeI;
            OrientationMode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                for (OrientationMode orientationMode : values()) {
                    if (orientationMode.nativeCode == i) {
                        return orientationMode;
                    }
                }
                StringBuilder sb = new StringBuilder(69);
                sb.append("Unexpected value for native Point Orientation Mode, value=");
                sb.append(i);
                throw new FatalException(sb.toString());
            }
            return (OrientationMode) invokeI.objValue;
        }

        public static OrientationMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (OrientationMode) Enum.valueOf(OrientationMode.class, str) : (OrientationMode) invokeL.objValue;
        }

        public static OrientationMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (OrientationMode[]) $VALUES.clone() : (OrientationMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Point(long j, Session session) {
        super(j, session);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), session};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Long) objArr2[0]).longValue(), (Session) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private native int nativeGetOrientationMode(long j, long j2);

    private native Pose nativeGetPose(long j, long j2);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Point() {
        super(0L, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Long) objArr[0]).longValue(), (Session) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
