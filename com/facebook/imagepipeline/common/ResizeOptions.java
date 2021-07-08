package com.facebook.imagepipeline.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ResizeOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_ROUNDUP_FRACTION = 0.6666667f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int height;
    public final float maxBitmapSize;
    public final float roundUpFraction;
    public final int width;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResizeOptions(int i2, int i3) {
        this(i2, i3, 2048.0f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Float) objArr2[2]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static ResizeOptions forDimensions(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i2 <= 0 || i3 <= 0) {
                return null;
            }
            return new ResizeOptions(i2, i3);
        }
        return (ResizeOptions) invokeII.objValue;
    }

    @Nullable
    public static ResizeOptions forSquareSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 <= 0) {
                return null;
            }
            return new ResizeOptions(i2, i2);
        }
        return (ResizeOptions) invokeI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ResizeOptions) {
                ResizeOptions resizeOptions = (ResizeOptions) obj;
                return this.width == resizeOptions.width && this.height == resizeOptions.height;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? HashCodeUtil.hashCode(this.width, this.height) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.format(null, "%dx%d", Integer.valueOf(this.width), Integer.valueOf(this.height)) : (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResizeOptions(int i2, int i3, float f2) {
        this(i2, i3, f2, 0.6666667f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public ResizeOptions(int i2, int i3, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkArgument(i3 > 0);
        this.width = i2;
        this.height = i3;
        this.maxBitmapSize = f2;
        this.roundUpFraction = f3;
    }
}
