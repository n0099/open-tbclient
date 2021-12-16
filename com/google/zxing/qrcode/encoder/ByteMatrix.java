package com.google.zxing.qrcode.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.lang.reflect.Array;
/* loaded from: classes3.dex */
public final class ByteMatrix {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[][] bytes;
    public final int height;
    public final int width;

    public ByteMatrix(int i2, int i3) {
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
        this.bytes = (byte[][]) Array.newInstance(byte.class, i3, i2);
        this.width = i2;
        this.height = i3;
    }

    public void clear(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048576, this, b2) == null) {
            for (int i2 = 0; i2 < this.height; i2++) {
                for (int i3 = 0; i3 < this.width; i3++) {
                    this.bytes[i2][i3] = b2;
                }
            }
        }
    }

    public byte get(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? this.bytes[i3][i2] : invokeII.byteValue;
    }

    public byte[][] getArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bytes : (byte[][]) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.height : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.width : invokeV.intValue;
    }

    public void set(int i2, int i3, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Byte.valueOf(b2)}) == null) {
            this.bytes[i3][i2] = b2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
            for (int i2 = 0; i2 < this.height; i2++) {
                for (int i3 = 0; i3 < this.width; i3++) {
                    byte b2 = this.bytes[i2][i3];
                    if (b2 == 0) {
                        sb.append(" 0");
                    } else if (b2 != 1) {
                        sb.append(GlideException.IndentedAppendable.INDENT);
                    } else {
                        sb.append(" 1");
                    }
                }
                sb.append('\n');
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void set(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            this.bytes[i3][i2] = (byte) i4;
        }
    }

    public void set(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.bytes[i3][i2] = z ? (byte) 1 : (byte) 0;
        }
    }
}
