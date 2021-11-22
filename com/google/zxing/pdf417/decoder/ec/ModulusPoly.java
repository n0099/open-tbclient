package com.google.zxing.pdf417.decoder.ec;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class ModulusPoly {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] coefficients;
    public final ModulusGF field;

    public ModulusPoly(ModulusGF modulusGF, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {modulusGF, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (iArr.length != 0) {
            this.field = modulusGF;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i4 = 1;
                while (i4 < length && iArr[i4] == 0) {
                    i4++;
                }
                if (i4 == length) {
                    this.coefficients = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i4];
                this.coefficients = iArr2;
                System.arraycopy(iArr, i4, iArr2, 0, iArr2.length);
                return;
            }
            this.coefficients = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    public ModulusPoly add(ModulusPoly modulusPoly) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, modulusPoly)) == null) {
            if (this.field.equals(modulusPoly.field)) {
                if (isZero()) {
                    return modulusPoly;
                }
                if (modulusPoly.isZero()) {
                    return this;
                }
                int[] iArr = this.coefficients;
                int[] iArr2 = modulusPoly.coefficients;
                if (iArr.length <= iArr2.length) {
                    iArr = iArr2;
                    iArr2 = iArr;
                }
                int[] iArr3 = new int[iArr.length];
                int length = iArr.length - iArr2.length;
                System.arraycopy(iArr, 0, iArr3, 0, length);
                for (int i2 = length; i2 < iArr.length; i2++) {
                    iArr3[i2] = this.field.add(iArr2[i2 - length], iArr[i2]);
                }
                return new ModulusPoly(this.field, iArr3);
            }
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        return (ModulusPoly) invokeL.objValue;
    }

    public int evaluateAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 == 0) {
                return getCoefficient(0);
            }
            if (i2 == 1) {
                int i3 = 0;
                for (int i4 : this.coefficients) {
                    i3 = this.field.add(i3, i4);
                }
                return i3;
            }
            int[] iArr = this.coefficients;
            int i5 = iArr[0];
            int length = iArr.length;
            for (int i6 = 1; i6 < length; i6++) {
                ModulusGF modulusGF = this.field;
                i5 = modulusGF.add(modulusGF.multiply(i2, i5), this.coefficients[i6]);
            }
            return i5;
        }
        return invokeI.intValue;
    }

    public int getCoefficient(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int[] iArr = this.coefficients;
            return iArr[(iArr.length - 1) - i2];
        }
        return invokeI.intValue;
    }

    public int[] getCoefficients() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.coefficients : (int[]) invokeV.objValue;
    }

    public int getDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.coefficients.length - 1 : invokeV.intValue;
    }

    public boolean isZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.coefficients[0] == 0 : invokeV.booleanValue;
    }

    public ModulusPoly multiply(ModulusPoly modulusPoly) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, modulusPoly)) == null) {
            if (this.field.equals(modulusPoly.field)) {
                if (!isZero() && !modulusPoly.isZero()) {
                    int[] iArr = this.coefficients;
                    int length = iArr.length;
                    int[] iArr2 = modulusPoly.coefficients;
                    int length2 = iArr2.length;
                    int[] iArr3 = new int[(length + length2) - 1];
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = iArr[i2];
                        for (int i4 = 0; i4 < length2; i4++) {
                            int i5 = i2 + i4;
                            ModulusGF modulusGF = this.field;
                            iArr3[i5] = modulusGF.add(iArr3[i5], modulusGF.multiply(i3, iArr2[i4]));
                        }
                    }
                    return new ModulusPoly(this.field, iArr3);
                }
                return this.field.getZero();
            }
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        return (ModulusPoly) invokeL.objValue;
    }

    public ModulusPoly multiplyByMonomial(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            if (i2 >= 0) {
                if (i3 == 0) {
                    return this.field.getZero();
                }
                int length = this.coefficients.length;
                int[] iArr = new int[i2 + length];
                for (int i4 = 0; i4 < length; i4++) {
                    iArr[i4] = this.field.multiply(this.coefficients[i4], i3);
                }
                return new ModulusPoly(this.field, iArr);
            }
            throw new IllegalArgumentException();
        }
        return (ModulusPoly) invokeII.objValue;
    }

    public ModulusPoly negative() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int length = this.coefficients.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = this.field.subtract(0, this.coefficients[i2]);
            }
            return new ModulusPoly(this.field, iArr);
        }
        return (ModulusPoly) invokeV.objValue;
    }

    public ModulusPoly subtract(ModulusPoly modulusPoly) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, modulusPoly)) == null) {
            if (this.field.equals(modulusPoly.field)) {
                return modulusPoly.isZero() ? this : add(modulusPoly.negative());
            }
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        return (ModulusPoly) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuilder sb = new StringBuilder(getDegree() * 8);
            for (int degree = getDegree(); degree >= 0; degree--) {
                int coefficient = getCoefficient(degree);
                if (coefficient != 0) {
                    if (coefficient < 0) {
                        sb.append(" - ");
                        coefficient = -coefficient;
                    } else if (sb.length() > 0) {
                        sb.append(" + ");
                    }
                    if (degree == 0 || coefficient != 1) {
                        sb.append(coefficient);
                    }
                    if (degree != 0) {
                        if (degree == 1) {
                            sb.append('x');
                        } else {
                            sb.append("x^");
                            sb.append(degree);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ModulusPoly multiply(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 == 0) {
                return this.field.getZero();
            }
            if (i2 == 1) {
                return this;
            }
            int length = this.coefficients.length;
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.field.multiply(this.coefficients[i3], i2);
            }
            return new ModulusPoly(this.field, iArr);
        }
        return (ModulusPoly) invokeI.objValue;
    }
}
