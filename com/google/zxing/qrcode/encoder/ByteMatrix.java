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
/* loaded from: classes8.dex */
public final class ByteMatrix {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[][] bytes;
    public final int height;
    public final int width;

    public ByteMatrix(int i, int i2) {
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
        this.bytes = (byte[][]) Array.newInstance(byte.class, i2, i);
        this.width = i;
        this.height = i2;
    }

    public void clear(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048576, this, b) == null) {
            for (int i = 0; i < this.height; i++) {
                for (int i2 = 0; i2 < this.width; i2++) {
                    this.bytes[i][i2] = b;
                }
            }
        }
    }

    public byte get(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            return this.bytes[i2][i];
        }
        return invokeII.byteValue;
    }

    public byte[][] getArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bytes;
        }
        return (byte[][]) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
    }

    public void set(int i, int i2, byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Byte.valueOf(b)}) == null) {
            this.bytes[i2][i] = b;
        }
    }

    public void set(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) {
            this.bytes[i2][i] = (byte) i3;
        }
    }

    public void set(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.bytes[i2][i] = z ? (byte) 1 : (byte) 0;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
            for (int i = 0; i < this.height; i++) {
                for (int i2 = 0; i2 < this.width; i2++) {
                    byte b = this.bytes[i][i2];
                    if (b != 0) {
                        if (b != 1) {
                            sb.append(GlideException.IndentedAppendable.INDENT);
                        } else {
                            sb.append(" 1");
                        }
                    } else {
                        sb.append(" 0");
                    }
                }
                sb.append('\n');
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
