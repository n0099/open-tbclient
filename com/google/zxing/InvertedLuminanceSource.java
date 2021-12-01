package com.google.zxing;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class InvertedLuminanceSource extends LuminanceSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LuminanceSource delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.getWidth(), luminanceSource.getHeight());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {luminanceSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.delegate = luminanceSource;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) ? new InvertedLuminanceSource(this.delegate.crop(i2, i3, i4, i5)) : (LuminanceSource) invokeIIII.objValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] matrix = this.delegate.getMatrix();
            int width = getWidth() * getHeight();
            byte[] bArr = new byte[width];
            for (int i2 = 0; i2 < width; i2++) {
                bArr[i2] = (byte) (255 - (matrix[i2] & 255));
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
            byte[] row = this.delegate.getRow(i2, bArr);
            int width = getWidth();
            for (int i3 = 0; i3 < width; i3++) {
                row[i3] = (byte) (255 - (row[i3] & 255));
            }
            return row;
        }
        return (byte[]) invokeIL.objValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource invert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.delegate : (LuminanceSource) invokeV.objValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.delegate.isCropSupported() : invokeV.booleanValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isRotateSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.delegate.isRotateSupported() : invokeV.booleanValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new InvertedLuminanceSource(this.delegate.rotateCounterClockwise()) : (LuminanceSource) invokeV.objValue;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise45() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new InvertedLuminanceSource(this.delegate.rotateCounterClockwise45()) : (LuminanceSource) invokeV.objValue;
    }
}
