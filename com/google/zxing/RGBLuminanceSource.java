package com.google.zxing;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int dataHeight;
    public final int dataWidth;
    public final int left;
    public final byte[] luminances;
    public final int top;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGBLuminanceSource(int i2, int i3, int[] iArr) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dataWidth = i2;
        this.dataHeight = i3;
        this.left = 0;
        this.top = 0;
        int i6 = i2 * i3;
        this.luminances = new byte[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = iArr[i7];
            this.luminances[i7] = (byte) (((((i8 >> 16) & 255) + ((i8 >> 7) & 510)) + (i8 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) ? new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + i2, this.top + i3, i4, i5) : (LuminanceSource) invokeIIII.objValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int width = getWidth();
            int height = getHeight();
            if (width == this.dataWidth && height == this.dataHeight) {
                return this.luminances;
            }
            int i2 = width * height;
            byte[] bArr = new byte[i2];
            int i3 = this.top;
            int i4 = this.dataWidth;
            int i5 = (i3 * i4) + this.left;
            if (width == i4) {
                System.arraycopy(this.luminances, i5, bArr, 0, i2);
                return bArr;
            }
            for (int i6 = 0; i6 < height; i6++) {
                System.arraycopy(this.luminances, i5, bArr, i6 * width, width);
                i5 += this.dataWidth;
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i2, byte[] bArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr)) == null) {
            if (i2 >= 0 && i2 < getHeight()) {
                int width = getWidth();
                if (bArr == null || bArr.length < width) {
                    bArr = new byte[width];
                }
                System.arraycopy(this.luminances, ((i2 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
                return bArr;
            }
            throw new IllegalArgumentException("Requested row is outside the image: " + i2);
        }
        return (byte[]) invokeIL.objValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGBLuminanceSource(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i6 + i4 <= i2 && i7 + i5 <= i3) {
            this.luminances = bArr;
            this.dataWidth = i2;
            this.dataHeight = i3;
            this.left = i4;
            this.top = i5;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
