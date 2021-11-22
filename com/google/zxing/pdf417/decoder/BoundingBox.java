package com.google.zxing.pdf417.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes11.dex */
public final class BoundingBox {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ResultPoint bottomLeft;
    public ResultPoint bottomRight;
    public BitMatrix image;
    public int maxX;
    public int maxY;
    public int minX;
    public int minY;
    public ResultPoint topLeft;
    public ResultPoint topRight;

    public BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if ((resultPoint == null && resultPoint3 == null) || ((resultPoint2 == null && resultPoint4 == null) || ((resultPoint != null && resultPoint2 == null) || (resultPoint3 != null && resultPoint4 == null)))) {
            throw NotFoundException.getNotFoundInstance();
        }
        init(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
    }

    private void calculateMinMaxValues() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.topLeft == null) {
                this.topLeft = new ResultPoint(0.0f, this.topRight.getY());
                this.bottomLeft = new ResultPoint(0.0f, this.bottomRight.getY());
            } else if (this.topRight == null) {
                this.topRight = new ResultPoint(this.image.getWidth() - 1, this.topLeft.getY());
                this.bottomRight = new ResultPoint(this.image.getWidth() - 1, this.bottomLeft.getY());
            }
            this.minX = (int) Math.min(this.topLeft.getX(), this.bottomLeft.getX());
            this.maxX = (int) Math.max(this.topRight.getX(), this.bottomRight.getX());
            this.minY = (int) Math.min(this.topLeft.getY(), this.topRight.getY());
            this.maxY = (int) Math.max(this.bottomLeft.getY(), this.bottomRight.getY());
        }
    }

    private void init(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, this, bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4) == null) {
            this.image = bitMatrix;
            this.topLeft = resultPoint;
            this.bottomLeft = resultPoint2;
            this.topRight = resultPoint3;
            this.bottomRight = resultPoint4;
            calculateMinMaxValues();
        }
    }

    public static BoundingBox merge(BoundingBox boundingBox, BoundingBox boundingBox2) throws NotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, boundingBox, boundingBox2)) == null) ? boundingBox == null ? boundingBox2 : boundingBox2 == null ? boundingBox : new BoundingBox(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox2.topRight, boundingBox2.bottomRight) : (BoundingBox) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BoundingBox addMissingRows(int i2, int i3, boolean z) throws NotFoundException {
        InterceptResult invokeCommon;
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            ResultPoint resultPoint5 = this.topLeft;
            ResultPoint resultPoint6 = this.bottomLeft;
            ResultPoint resultPoint7 = this.topRight;
            ResultPoint resultPoint8 = this.bottomRight;
            if (i2 > 0) {
                ResultPoint resultPoint9 = z ? resultPoint5 : resultPoint7;
                int y = ((int) resultPoint9.getY()) - i2;
                if (y < 0) {
                    y = 0;
                }
                ResultPoint resultPoint10 = new ResultPoint(resultPoint9.getX(), y);
                if (!z) {
                    resultPoint2 = resultPoint10;
                    resultPoint = resultPoint5;
                    if (i3 <= 0) {
                        ResultPoint resultPoint11 = z ? this.bottomLeft : this.bottomRight;
                        int y2 = ((int) resultPoint11.getY()) + i3;
                        if (y2 >= this.image.getHeight()) {
                            y2 = this.image.getHeight() - 1;
                        }
                        ResultPoint resultPoint12 = new ResultPoint(resultPoint11.getX(), y2);
                        if (!z) {
                            resultPoint4 = resultPoint12;
                            resultPoint3 = resultPoint6;
                            calculateMinMaxValues();
                            return new BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
                        }
                        resultPoint3 = resultPoint12;
                    } else {
                        resultPoint3 = resultPoint6;
                    }
                    resultPoint4 = resultPoint8;
                    calculateMinMaxValues();
                    return new BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
                }
                resultPoint = resultPoint10;
            } else {
                resultPoint = resultPoint5;
            }
            resultPoint2 = resultPoint7;
            if (i3 <= 0) {
            }
            resultPoint4 = resultPoint8;
            calculateMinMaxValues();
            return new BoundingBox(this.image, resultPoint, resultPoint3, resultPoint2, resultPoint4);
        }
        return (BoundingBox) invokeCommon.objValue;
    }

    public ResultPoint getBottomLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bottomLeft : (ResultPoint) invokeV.objValue;
    }

    public ResultPoint getBottomRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bottomRight : (ResultPoint) invokeV.objValue;
    }

    public int getMaxX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.maxX : invokeV.intValue;
    }

    public int getMaxY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.maxY : invokeV.intValue;
    }

    public int getMinX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.minX : invokeV.intValue;
    }

    public int getMinY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.minY : invokeV.intValue;
    }

    public ResultPoint getTopLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.topLeft : (ResultPoint) invokeV.objValue;
    }

    public ResultPoint getTopRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.topRight : (ResultPoint) invokeV.objValue;
    }

    public BoundingBox(BoundingBox boundingBox) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {boundingBox};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox.topRight, boundingBox.bottomRight);
    }
}
