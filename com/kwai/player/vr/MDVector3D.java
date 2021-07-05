package com.kwai.player.vr;

import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MDVector3D {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] values;

    public MDVector3D() {
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
        float[] fArr = new float[4];
        this.values = fArr;
        fArr[3] = 1.0f;
    }

    public static float len(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4)) : invokeCommon.floatValue;
    }

    public float getX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.values[0] : invokeV.floatValue;
    }

    public float getY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.values[1] : invokeV.floatValue;
    }

    public float getZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.values[2] : invokeV.floatValue;
    }

    public void multiplyMV(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fArr) == null) {
            float[] fArr2 = this.values;
            Matrix.multiplyMV(fArr2, 0, fArr, 0, fArr2, 0);
        }
    }

    public MDVector3D setX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
            this.values[0] = f2;
            return this;
        }
        return (MDVector3D) invokeF.objValue;
    }

    public MDVector3D setY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            this.values[1] = f2;
            return this;
        }
        return (MDVector3D) invokeF.objValue;
    }

    public MDVector3D setZ(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
            this.values[2] = f2;
            return this;
        }
        return (MDVector3D) invokeF.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "MDVector3D{x=" + getX() + ", y=" + getY() + ", z=" + getZ() + '}';
        }
        return (String) invokeV.objValue;
    }

    public float x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.values[0] : invokeV.floatValue;
    }

    public float y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.values[1] : invokeV.floatValue;
    }

    public float z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.values[2] : invokeV.floatValue;
    }
}
