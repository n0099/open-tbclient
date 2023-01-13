package com.google.zxing;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int dataHeight;
    public final int dataWidth;
    public final int left;
    public final byte[] luminances;
    public final int top;

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
    public RGBLuminanceSource(int i, int i2, int[] iArr) {
        super(i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dataWidth = i;
        this.dataHeight = i2;
        this.left = 0;
        this.top = 0;
        int i5 = i * i2;
        this.luminances = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iArr[i6];
            this.luminances[i6] = (byte) (((((i7 >> 16) & 255) + ((i7 >> 7) & 510)) + (i7 & 255)) / 4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGBLuminanceSource(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i5 + i3 <= i && i6 + i4 <= i2) {
            this.luminances = bArr;
            this.dataWidth = i;
            this.dataHeight = i2;
            this.left = i3;
            this.top = i4;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i, i2, i3, i4)) == null) {
            return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + i, this.top + i2, i3, i4);
        }
        return (LuminanceSource) invokeIIII.objValue;
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
            int i = width * height;
            byte[] bArr = new byte[i];
            int i2 = this.top;
            int i3 = this.dataWidth;
            int i4 = (i2 * i3) + this.left;
            if (width == i3) {
                System.arraycopy(this.luminances, i4, bArr, 0, i);
                return bArr;
            }
            for (int i5 = 0; i5 < height; i5++) {
                System.arraycopy(this.luminances, i4, bArr, i5 * width, width);
                i4 += this.dataWidth;
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i, byte[] bArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            if (i >= 0 && i < getHeight()) {
                int width = getWidth();
                if (bArr == null || bArr.length < width) {
                    bArr = new byte[width];
                }
                System.arraycopy(this.luminances, ((i + this.top) * this.dataWidth) + this.left, bArr, 0, width);
                return bArr;
            }
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        return (byte[]) invokeIL.objValue;
    }
}
