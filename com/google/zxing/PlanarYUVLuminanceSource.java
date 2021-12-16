package com.google.zxing;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int THUMBNAIL_SCALE_FACTOR = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int dataHeight;
    public final int dataWidth;
    public final int left;
    public final int top;
    public final byte[] yuvData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanarYUVLuminanceSource(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i6, i7);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i4 + i6 <= i2 && i5 + i7 <= i3) {
            this.yuvData = bArr;
            this.dataWidth = i2;
            this.dataHeight = i3;
            this.left = i4;
            this.top = i5;
            if (z) {
                reverseHorizontal(i6, i7);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    private void reverseHorizontal(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65537, this, i2, i3) == null) {
            byte[] bArr = this.yuvData;
            int i4 = (this.top * this.dataWidth) + this.left;
            int i5 = 0;
            while (i5 < i3) {
                int i6 = (i2 / 2) + i4;
                int i7 = (i4 + i2) - 1;
                int i8 = i4;
                while (i8 < i6) {
                    byte b2 = bArr[i8];
                    bArr[i8] = bArr[i7];
                    bArr[i7] = b2;
                    i8++;
                    i7--;
                }
                i5++;
                i4 += this.dataWidth;
            }
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) ? new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + i2, this.top + i3, i4, i5, false) : (LuminanceSource) invokeIIII.objValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int width = getWidth();
            int height = getHeight();
            if (width == this.dataWidth && height == this.dataHeight) {
                return this.yuvData;
            }
            int i2 = width * height;
            byte[] bArr = new byte[i2];
            int i3 = this.top;
            int i4 = this.dataWidth;
            int i5 = (i3 * i4) + this.left;
            if (width == i4) {
                System.arraycopy(this.yuvData, i5, bArr, 0, i2);
                return bArr;
            }
            for (int i6 = 0; i6 < height; i6++) {
                System.arraycopy(this.yuvData, i5, bArr, i6 * width, width);
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
                System.arraycopy(this.yuvData, ((i2 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
                return bArr;
            }
            throw new IllegalArgumentException("Requested row is outside the image: " + i2);
        }
        return (byte[]) invokeIL.objValue;
    }

    public int getThumbnailHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getHeight() / 2 : invokeV.intValue;
    }

    public int getThumbnailWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getWidth() / 2 : invokeV.intValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public int[] renderThumbnail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int width = getWidth() / 2;
            int height = getHeight() / 2;
            int[] iArr = new int[width * height];
            byte[] bArr = this.yuvData;
            int i2 = (this.top * this.dataWidth) + this.left;
            for (int i3 = 0; i3 < height; i3++) {
                int i4 = i3 * width;
                for (int i5 = 0; i5 < width; i5++) {
                    iArr[i4 + i5] = ((bArr[(i5 << 1) + i2] & 255) * 65793) | (-16777216);
                }
                i2 += this.dataWidth << 1;
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }
}
