package com.google.zxing.pdf417.encoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class BarcodeRow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentLocation;
    public final byte[] row;

    public BarcodeRow(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.row = new byte[i2];
        this.currentLocation = 0;
    }

    public void addBar(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = this.currentLocation;
                this.currentLocation = i4 + 1;
                set(i4, z);
            }
        }
    }

    public byte[] getScaledRow(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int length = this.row.length * i2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                bArr[i3] = this.row[i3 / i2];
            }
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    public void set(int i2, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Byte.valueOf(b2)}) == null) {
            this.row[i2] = b2;
        }
    }

    private void set(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.row[i2] = z ? (byte) 1 : (byte) 0;
        }
    }
}
