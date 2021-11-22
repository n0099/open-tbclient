package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class DefaultPlacement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] bits;
    public final CharSequence codewords;
    public final int numcols;
    public final int numrows;

    public DefaultPlacement(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {charSequence, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.codewords = charSequence;
        this.numcols = i2;
        this.numrows = i3;
        byte[] bArr = new byte[i2 * i3];
        this.bits = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void corner1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            module(this.numrows - 1, 0, i2, 1);
            module(this.numrows - 1, 1, i2, 2);
            module(this.numrows - 1, 2, i2, 3);
            module(0, this.numcols - 2, i2, 4);
            module(0, this.numcols - 1, i2, 5);
            module(1, this.numcols - 1, i2, 6);
            module(2, this.numcols - 1, i2, 7);
            module(3, this.numcols - 1, i2, 8);
        }
    }

    private void corner2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            module(this.numrows - 3, 0, i2, 1);
            module(this.numrows - 2, 0, i2, 2);
            module(this.numrows - 1, 0, i2, 3);
            module(0, this.numcols - 4, i2, 4);
            module(0, this.numcols - 3, i2, 5);
            module(0, this.numcols - 2, i2, 6);
            module(0, this.numcols - 1, i2, 7);
            module(1, this.numcols - 1, i2, 8);
        }
    }

    private void corner3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            module(this.numrows - 3, 0, i2, 1);
            module(this.numrows - 2, 0, i2, 2);
            module(this.numrows - 1, 0, i2, 3);
            module(0, this.numcols - 2, i2, 4);
            module(0, this.numcols - 1, i2, 5);
            module(1, this.numcols - 1, i2, 6);
            module(2, this.numcols - 1, i2, 7);
            module(3, this.numcols - 1, i2, 8);
        }
    }

    private void corner4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            module(this.numrows - 1, 0, i2, 1);
            module(this.numrows - 1, this.numcols - 1, i2, 2);
            module(0, this.numcols - 3, i2, 3);
            module(0, this.numcols - 2, i2, 4);
            module(0, this.numcols - 1, i2, 5);
            module(1, this.numcols - 3, i2, 6);
            module(1, this.numcols - 2, i2, 7);
            module(1, this.numcols - 1, i2, 8);
        }
    }

    private boolean hasBit(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, this, i2, i3)) == null) ? this.bits[(i3 * this.numcols) + i2] >= 0 : invokeII.booleanValue;
    }

    private void module(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(AdIconUtil.BAIDU_LOGO_ID, this, i2, i3, i4, i5) == null) {
            if (i2 < 0) {
                int i6 = this.numrows;
                i2 += i6;
                i3 += 4 - ((i6 + 4) % 8);
            }
            if (i3 < 0) {
                int i7 = this.numcols;
                i3 += i7;
                i2 += 4 - ((i7 + 4) % 8);
            }
            setBit(i3, i2, (this.codewords.charAt(i4) & (1 << (8 - i5))) != 0);
        }
    }

    private void setBit(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.bits[(i3 * this.numcols) + i2] = z ? (byte) 1 : (byte) 0;
        }
    }

    private void utah(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65544, this, i2, i3, i4) == null) {
            int i5 = i2 - 2;
            int i6 = i3 - 2;
            module(i5, i6, i4, 1);
            int i7 = i3 - 1;
            module(i5, i7, i4, 2);
            int i8 = i2 - 1;
            module(i8, i6, i4, 3);
            module(i8, i7, i4, 4);
            module(i8, i3, i4, 5);
            module(i2, i6, i4, 6);
            module(i2, i7, i4, 7);
            module(i2, i3, i4, 8);
        }
    }

    public final boolean getBit(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? this.bits[(i3 * this.numcols) + i2] == 1 : invokeII.booleanValue;
    }

    public final byte[] getBits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bits : (byte[]) invokeV.objValue;
    }

    public final int getNumcols() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.numcols : invokeV.intValue;
    }

    public final int getNumrows() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.numrows : invokeV.intValue;
    }

    public final void place() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 4;
            while (true) {
                if (i6 == this.numrows && i4 == 0) {
                    corner1(i5);
                    i5++;
                }
                if (i6 == this.numrows - 2 && i4 == 0 && this.numcols % 4 != 0) {
                    corner2(i5);
                    i5++;
                }
                if (i6 == this.numrows - 2 && i4 == 0 && this.numcols % 8 == 4) {
                    corner3(i5);
                    i5++;
                }
                if (i6 == this.numrows + 4 && i4 == 2 && this.numcols % 8 == 0) {
                    corner4(i5);
                    i5++;
                }
                do {
                    if (i6 < this.numrows && i4 >= 0 && !hasBit(i4, i6)) {
                        utah(i6, i4, i5);
                        i5++;
                    }
                    i6 -= 2;
                    i4 += 2;
                    if (i6 < 0) {
                        break;
                    }
                } while (i4 < this.numcols);
                int i7 = i6 + 1;
                int i8 = i4 + 3;
                do {
                    if (i7 >= 0 && i8 < this.numcols && !hasBit(i8, i7)) {
                        utah(i7, i8, i5);
                        i5++;
                    }
                    i7 += 2;
                    i8 -= 2;
                    if (i7 >= this.numrows) {
                        break;
                    }
                } while (i8 >= 0);
                i6 = i7 + 3;
                i4 = i8 + 1;
                i2 = this.numrows;
                if (i6 >= i2 && i4 >= (i3 = this.numcols)) {
                    break;
                }
            }
            if (hasBit(i3 - 1, i2 - 1)) {
                return;
            }
            setBit(this.numcols - 1, this.numrows - 1, true);
            setBit(this.numcols - 2, this.numrows - 2, true);
        }
    }
}
