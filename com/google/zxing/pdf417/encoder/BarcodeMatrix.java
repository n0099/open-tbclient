package com.google.zxing.pdf417.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
/* loaded from: classes8.dex */
public final class BarcodeMatrix {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentRow;
    public final int height;
    public final BarcodeRow[] matrix;
    public final int width;

    public BarcodeMatrix(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BarcodeRow[] barcodeRowArr = new BarcodeRow[i];
        this.matrix = barcodeRowArr;
        int length = barcodeRowArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.matrix[i5] = new BarcodeRow(((i2 + 4) * 17) + 1);
        }
        this.width = i2 * 17;
        this.height = i;
        this.currentRow = -1;
    }

    public BarcodeRow getCurrentRow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.matrix[this.currentRow];
        }
        return (BarcodeRow) invokeV.objValue;
    }

    public byte[][] getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getScaledMatrix(1, 1);
        }
        return (byte[][]) invokeV.objValue;
    }

    public void startRow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.currentRow++;
        }
    }

    public byte[][] getScaledMatrix(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            byte[][] bArr = (byte[][]) Array.newInstance(byte.class, this.height * i2, this.width * i);
            int i3 = this.height * i2;
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[(i3 - i4) - 1] = this.matrix[i4 / i2].getScaledRow(i);
            }
            return bArr;
        }
        return (byte[][]) invokeII.objValue;
    }

    public void set(int i, int i2, byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Byte.valueOf(b)}) == null) {
            this.matrix[i2].set(i, b);
        }
    }
}
