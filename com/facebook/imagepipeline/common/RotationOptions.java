package com.facebook.imagepipeline.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.HashCodeUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes6.dex */
public class RotationOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DISABLE_ROTATION = -2;
    public static final int NO_ROTATION = 0;
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_270 = 270;
    public static final int ROTATE_90 = 90;
    public static final RotationOptions ROTATION_OPTIONS_AUTO_ROTATE;
    public static final RotationOptions ROTATION_OPTIONS_DISABLE_ROTATION;
    public static final RotationOptions ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME;
    public static final int USE_EXIF_ROTATION_ANGLE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mDeferUntilRendered;
    public final int mRotation;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface RotationAngle {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1425608002, "Lcom/facebook/imagepipeline/common/RotationOptions;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1425608002, "Lcom/facebook/imagepipeline/common/RotationOptions;");
                return;
            }
        }
        ROTATION_OPTIONS_AUTO_ROTATE = new RotationOptions(-1, false);
        ROTATION_OPTIONS_DISABLE_ROTATION = new RotationOptions(-2, false);
        ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME = new RotationOptions(-1, true);
    }

    public RotationOptions(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRotation = i2;
        this.mDeferUntilRendered = z;
    }

    public static RotationOptions autoRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? ROTATION_OPTIONS_AUTO_ROTATE : (RotationOptions) invokeV.objValue;
    }

    public static RotationOptions autoRotateAtRenderTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME : (RotationOptions) invokeV.objValue;
    }

    public static RotationOptions disableRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? ROTATION_OPTIONS_DISABLE_ROTATION : (RotationOptions) invokeV.objValue;
    }

    public static RotationOptions forceRotation(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? new RotationOptions(i2, false) : (RotationOptions) invokeI.objValue;
    }

    public boolean canDeferUntilRendered() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDeferUntilRendered : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof RotationOptions) {
                RotationOptions rotationOptions = (RotationOptions) obj;
                return this.mRotation == rotationOptions.mRotation && this.mDeferUntilRendered == rotationOptions.mDeferUntilRendered;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getForcedAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!useImageMetadata()) {
                return this.mRotation;
            }
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? HashCodeUtil.hashCode(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mDeferUntilRendered)) : invokeV.intValue;
    }

    public boolean rotationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRotation != -2 : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.mDeferUntilRendered)) : (String) invokeV.objValue;
    }

    public boolean useImageMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRotation == -1 : invokeV.booleanValue;
    }
}
