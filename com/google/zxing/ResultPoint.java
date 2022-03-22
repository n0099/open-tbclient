package com.google.zxing;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.detector.MathUtils;
/* loaded from: classes7.dex */
public class ResultPoint {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float x;
    public final float y;

    public ResultPoint(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = f2;
        this.y = f3;
    }

    public static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, resultPoint, resultPoint2, resultPoint3)) == null) {
            float f2 = resultPoint2.x;
            float f3 = resultPoint2.y;
            return ((resultPoint3.x - f2) * (resultPoint.y - f3)) - ((resultPoint3.y - f3) * (resultPoint.x - f2));
        }
        return invokeLLL.floatValue;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, resultPoint, resultPoint2)) == null) ? MathUtils.distance(resultPoint.x, resultPoint.y, resultPoint2.x, resultPoint2.y) : invokeLL.floatValue;
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, resultPointArr) == null) {
            float distance = distance(resultPointArr[0], resultPointArr[1]);
            float distance2 = distance(resultPointArr[1], resultPointArr[2]);
            float distance3 = distance(resultPointArr[0], resultPointArr[2]);
            if (distance2 >= distance && distance2 >= distance3) {
                resultPoint = resultPointArr[0];
                resultPoint2 = resultPointArr[1];
                resultPoint3 = resultPointArr[2];
            } else if (distance3 >= distance2 && distance3 >= distance) {
                resultPoint = resultPointArr[1];
                resultPoint2 = resultPointArr[0];
                resultPoint3 = resultPointArr[2];
            } else {
                resultPoint = resultPointArr[2];
                resultPoint2 = resultPointArr[0];
                resultPoint3 = resultPointArr[1];
            }
            if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
                ResultPoint resultPoint4 = resultPoint3;
                resultPoint3 = resultPoint2;
                resultPoint2 = resultPoint4;
            }
            resultPointArr[0] = resultPoint2;
            resultPointArr[1] = resultPoint;
            resultPointArr[2] = resultPoint3;
        }
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof ResultPoint) {
                ResultPoint resultPoint = (ResultPoint) obj;
                if (this.x == resultPoint.x && this.y == resultPoint.y) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final float getX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.x : invokeV.floatValue;
    }

    public final float getY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.y : invokeV.floatValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y) : invokeV.intValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "(" + this.x + ',' + this.y + ')';
        }
        return (String) invokeV.objValue;
    }
}
