package com.kwad.yoga;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class YogaConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static int SPACING_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public YogaLogger mLogger;
    public long mNativePointer;
    public YogaNodeCloneFunction mYogaNodeCloneFunction;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1008830992, "Lcom/kwad/yoga/YogaConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1008830992, "Lcom/kwad/yoga/YogaConfig;");
        }
    }

    public YogaConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        long jni_YGConfigNew = YogaNative.jni_YGConfigNew();
        this.mNativePointer = jni_YGConfigNew;
        if (jni_YGConfigNew == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                YogaNative.jni_YGConfigFree(this.mNativePointer);
            } finally {
                super.finalize();
            }
        }
    }

    public YogaLogger getLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLogger : (YogaLogger) invokeV.objValue;
    }

    public void setExperimentalFeatureEnabled(YogaExperimentalFeature yogaExperimentalFeature, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, yogaExperimentalFeature, z) == null) {
            YogaNative.jni_YGConfigSetExperimentalFeatureEnabled(this.mNativePointer, yogaExperimentalFeature.intValue(), z);
        }
    }

    public void setLogger(YogaLogger yogaLogger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yogaLogger) == null) {
            this.mLogger = yogaLogger;
            YogaNative.jni_YGConfigSetLogger(this.mNativePointer, yogaLogger);
        }
    }

    public void setPointScaleFactor(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            YogaNative.jni_YGConfigSetPointScaleFactor(this.mNativePointer, f2);
        }
    }

    public void setPrintTreeFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            YogaNative.jni_YGConfigSetPrintTreeFlag(this.mNativePointer, z);
        }
    }

    public void setShouldDiffLayoutWithoutLegacyStretchBehaviour(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            YogaNative.jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviour(this.mNativePointer, z);
        }
    }

    public void setUseLegacyStretchBehaviour(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            YogaNative.jni_YGConfigSetUseLegacyStretchBehaviour(this.mNativePointer, z);
        }
    }

    public void setUseWebDefaults(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            YogaNative.jni_YGConfigSetUseWebDefaults(this.mNativePointer, z);
        }
    }
}
