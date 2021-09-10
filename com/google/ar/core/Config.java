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
/* loaded from: classes10.dex */
public class Config {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f70231a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class AugmentedFaceMode {
        public static final /* synthetic */ AugmentedFaceMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AugmentedFaceMode DISABLED;
        public static final AugmentedFaceMode MESH3D;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(264686111, "Lcom/google/ar/core/Config$AugmentedFaceMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(264686111, "Lcom/google/ar/core/Config$AugmentedFaceMode;");
                    return;
                }
            }
            DISABLED = new AugmentedFaceMode("DISABLED", 0, 0);
            AugmentedFaceMode augmentedFaceMode = new AugmentedFaceMode("MESH3D", 1, 2);
            MESH3D = augmentedFaceMode;
            $VALUES = new AugmentedFaceMode[]{DISABLED, augmentedFaceMode};
        }

        public AugmentedFaceMode(String str, int i2, int i3) {
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

        public static AugmentedFaceMode forNumber(int i2) {
            InterceptResult invokeI;
            AugmentedFaceMode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (AugmentedFaceMode augmentedFaceMode : values()) {
                    if (augmentedFaceMode.nativeCode == i2) {
                        return augmentedFaceMode;
                    }
                }
                StringBuilder sb = new StringBuilder(64);
                sb.append("Unexpected value for native AugmentedFaceMode, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (AugmentedFaceMode) invokeI.objValue;
        }

        public static AugmentedFaceMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (AugmentedFaceMode) Enum.valueOf(AugmentedFaceMode.class, str) : (AugmentedFaceMode) invokeL.objValue;
        }

        public static AugmentedFaceMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (AugmentedFaceMode[]) $VALUES.clone() : (AugmentedFaceMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class CloudAnchorMode {
        public static final /* synthetic */ CloudAnchorMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CloudAnchorMode DISABLED;
        public static final CloudAnchorMode ENABLED;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-100766366, "Lcom/google/ar/core/Config$CloudAnchorMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-100766366, "Lcom/google/ar/core/Config$CloudAnchorMode;");
                    return;
                }
            }
            DISABLED = new CloudAnchorMode("DISABLED", 0, 0);
            CloudAnchorMode cloudAnchorMode = new CloudAnchorMode("ENABLED", 1, 1);
            ENABLED = cloudAnchorMode;
            $VALUES = new CloudAnchorMode[]{DISABLED, cloudAnchorMode};
        }

        public CloudAnchorMode(String str, int i2, int i3) {
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

        public static CloudAnchorMode forNumber(int i2) {
            InterceptResult invokeI;
            CloudAnchorMode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (CloudAnchorMode cloudAnchorMode : values()) {
                    if (cloudAnchorMode.nativeCode == i2) {
                        return cloudAnchorMode;
                    }
                }
                StringBuilder sb = new StringBuilder(64);
                sb.append("Unexpected value for native AnchorHostingMode, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (CloudAnchorMode) invokeI.objValue;
        }

        public static CloudAnchorMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (CloudAnchorMode) Enum.valueOf(CloudAnchorMode.class, str) : (CloudAnchorMode) invokeL.objValue;
        }

        public static CloudAnchorMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (CloudAnchorMode[]) $VALUES.clone() : (CloudAnchorMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class FocusMode {
        public static final /* synthetic */ FocusMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FocusMode AUTO;
        public static final FocusMode FIXED;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(981283220, "Lcom/google/ar/core/Config$FocusMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(981283220, "Lcom/google/ar/core/Config$FocusMode;");
                    return;
                }
            }
            FIXED = new FocusMode("FIXED", 0, 0);
            FocusMode focusMode = new FocusMode("AUTO", 1, 1);
            AUTO = focusMode;
            $VALUES = new FocusMode[]{FIXED, focusMode};
        }

        public FocusMode(String str, int i2, int i3) {
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

        public static FocusMode forNumber(int i2) {
            InterceptResult invokeI;
            FocusMode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (FocusMode focusMode : values()) {
                    if (focusMode.nativeCode == i2) {
                        return focusMode;
                    }
                }
                StringBuilder sb = new StringBuilder(56);
                sb.append("Unexpected value for native FocusMode, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (FocusMode) invokeI.objValue;
        }

        public static FocusMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (FocusMode) Enum.valueOf(FocusMode.class, str) : (FocusMode) invokeL.objValue;
        }

        public static FocusMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (FocusMode[]) $VALUES.clone() : (FocusMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class LightEstimationMode {
        public static final /* synthetic */ LightEstimationMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LightEstimationMode AMBIENT_INTENSITY;
        public static final LightEstimationMode DISABLED;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(840581451, "Lcom/google/ar/core/Config$LightEstimationMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(840581451, "Lcom/google/ar/core/Config$LightEstimationMode;");
                    return;
                }
            }
            DISABLED = new LightEstimationMode("DISABLED", 0, 0);
            LightEstimationMode lightEstimationMode = new LightEstimationMode("AMBIENT_INTENSITY", 1, 1);
            AMBIENT_INTENSITY = lightEstimationMode;
            $VALUES = new LightEstimationMode[]{DISABLED, lightEstimationMode};
        }

        public LightEstimationMode(String str, int i2, int i3) {
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

        public static LightEstimationMode forNumber(int i2) {
            InterceptResult invokeI;
            LightEstimationMode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (LightEstimationMode lightEstimationMode : values()) {
                    if (lightEstimationMode.nativeCode == i2) {
                        return lightEstimationMode;
                    }
                }
                StringBuilder sb = new StringBuilder(66);
                sb.append("Unexpected value for native LightEstimationMode, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (LightEstimationMode) invokeI.objValue;
        }

        public static LightEstimationMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (LightEstimationMode) Enum.valueOf(LightEstimationMode.class, str) : (LightEstimationMode) invokeL.objValue;
        }

        public static LightEstimationMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (LightEstimationMode[]) $VALUES.clone() : (LightEstimationMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class PlaneFindingMode {
        public static final /* synthetic */ PlaneFindingMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PlaneFindingMode DISABLED;
        public static final PlaneFindingMode HORIZONTAL;
        public static final PlaneFindingMode HORIZONTAL_AND_VERTICAL;
        public static final PlaneFindingMode VERTICAL;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1986199977, "Lcom/google/ar/core/Config$PlaneFindingMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1986199977, "Lcom/google/ar/core/Config$PlaneFindingMode;");
                    return;
                }
            }
            DISABLED = new PlaneFindingMode("DISABLED", 0, 0);
            HORIZONTAL = new PlaneFindingMode("HORIZONTAL", 1, 1);
            VERTICAL = new PlaneFindingMode("VERTICAL", 2, 2);
            PlaneFindingMode planeFindingMode = new PlaneFindingMode("HORIZONTAL_AND_VERTICAL", 3, 3);
            HORIZONTAL_AND_VERTICAL = planeFindingMode;
            $VALUES = new PlaneFindingMode[]{DISABLED, HORIZONTAL, VERTICAL, planeFindingMode};
        }

        public PlaneFindingMode(String str, int i2, int i3) {
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

        public static PlaneFindingMode forNumber(int i2) {
            InterceptResult invokeI;
            PlaneFindingMode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (PlaneFindingMode planeFindingMode : values()) {
                    if (planeFindingMode.nativeCode == i2) {
                        return planeFindingMode;
                    }
                }
                StringBuilder sb = new StringBuilder(63);
                sb.append("Unexpected value for native PlaneFindingMode, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (PlaneFindingMode) invokeI.objValue;
        }

        public static PlaneFindingMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (PlaneFindingMode) Enum.valueOf(PlaneFindingMode.class, str) : (PlaneFindingMode) invokeL.objValue;
        }

        public static PlaneFindingMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (PlaneFindingMode[]) $VALUES.clone() : (PlaneFindingMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class UpdateMode {
        public static final /* synthetic */ UpdateMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final UpdateMode BLOCKING;
        public static final UpdateMode LATEST_CAMERA_IMAGE;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1786362469, "Lcom/google/ar/core/Config$UpdateMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1786362469, "Lcom/google/ar/core/Config$UpdateMode;");
                    return;
                }
            }
            BLOCKING = new UpdateMode("BLOCKING", 0, 0);
            UpdateMode updateMode = new UpdateMode("LATEST_CAMERA_IMAGE", 1, 1);
            LATEST_CAMERA_IMAGE = updateMode;
            $VALUES = new UpdateMode[]{BLOCKING, updateMode};
        }

        public UpdateMode(String str, int i2, int i3) {
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

        public static UpdateMode forNumber(int i2) {
            InterceptResult invokeI;
            UpdateMode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (UpdateMode updateMode : values()) {
                    if (updateMode.nativeCode == i2) {
                        return updateMode;
                    }
                }
                StringBuilder sb = new StringBuilder(57);
                sb.append("Unexpected value for native UpdateMode, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (UpdateMode) invokeI.objValue;
        }

        public static UpdateMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (UpdateMode) Enum.valueOf(UpdateMode.class, str) : (UpdateMode) invokeL.objValue;
        }

        public static UpdateMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (UpdateMode[]) $VALUES.clone() : (UpdateMode[]) invokeV.objValue;
        }
    }

    public Config() {
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
        this.f70231a = 0L;
    }

    public static native long nativeCreate(long j2);

    public static native void nativeDestroy(long j2);

    private native int nativeGetAugmentedFaceMode(long j2, long j3);

    private native long nativeGetAugmentedImageDatabase(long j2, long j3);

    private native int nativeGetCloudAnchorMode(long j2, long j3);

    private native int nativeGetFocusMode(long j2, long j3);

    private native int nativeGetLightEstimationMode(long j2, long j3);

    private native int nativeGetPlaneFindingMode(long j2, long j3);

    private native int nativeGetUpdateMode(long j2, long j3);

    private native void nativeSetAugmentedFaceMode(long j2, long j3, int i2);

    private native void nativeSetAugmentedImageDatabase(long j2, long j3, long j4);

    private native void nativeSetCloudAnchorMode(long j2, long j3, int i2);

    private native void nativeSetFocusMode(long j2, long j3, int i2);

    private native void nativeSetLightEstimationMode(long j2, long j3, int i2);

    private native void nativeSetPlaneFindingMode(long j2, long j3, int i2);

    private native void nativeSetUpdateMode(long j2, long j3, int i2);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.f70231a;
            if (j2 != 0) {
                nativeDestroy(j2);
            }
            super.finalize();
        }
    }
}
