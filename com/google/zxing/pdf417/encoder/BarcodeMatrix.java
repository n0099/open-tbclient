package com.google.zxing.pdf417.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
/* loaded from: classes7.dex */
public final class BarcodeMatrix {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentRow;
    public final int height;
    public final BarcodeRow[] matrix;
    public final int width;

    public BarcodeMatrix(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BarcodeRow[] barcodeRowArr = new BarcodeRow[i2];
        this.matrix = barcodeRowArr;
        int length = barcodeRowArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.matrix[i6] = new BarcodeRow(((i3 + 4) * 17) + 1);
        }
        this.width = i3 * 17;
        this.height = i2;
        this.currentRow = -1;
    }

    public BarcodeRow getCurrentRow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.matrix[this.currentRow] : (BarcodeRow) invokeV.objValue;
    }

    public byte[][] getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getScaledMatrix(1, 1) : (byte[][]) invokeV.objValue;
    }

    public byte[][] getScaledMatrix(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            byte[][] bArr = (byte[][]) Array.newInstance(byte.class, this.height * i3, this.width * i2);
            int i4 = this.height * i3;
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[(i4 - i5) - 1] = this.matrix[i5 / i3].getScaledRow(i2);
            }
            return bArr;
        }
        return (byte[][]) invokeII.objValue;
    }

    public void set(int i2, int i3, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Byte.valueOf(b2)}) == null) {
            this.matrix[i3].set(i2, b2);
        }
    }

    public void startRow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.currentRow++;
        }
    }
}
