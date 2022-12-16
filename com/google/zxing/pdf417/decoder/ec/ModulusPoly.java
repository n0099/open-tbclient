package com.google.zxing.pdf417.decoder.ec;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (iArr.length != 0) {
            this.field = modulusGF;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i3 = 1;
                while (i3 < length && iArr[i3] == 0) {
                    i3++;
                }
                if (i3 == length) {
                    this.coefficients = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i3];
                this.coefficients = iArr2;
                System.arraycopy(iArr, i3, iArr2, 0, iArr2.length);
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
                for (int i = length; i < iArr.length; i++) {
                    iArr3[i] = this.field.add(iArr2[i - length], iArr[i]);
                }
                return new ModulusPoly(this.field, iArr3);
            }
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        return (ModulusPoly) invokeL.objValue;
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
                    for (int i = 0; i < length; i++) {
                        int i2 = iArr[i];
                        for (int i3 = 0; i3 < length2; i3++) {
                            int i4 = i + i3;
                            ModulusGF modulusGF = this.field;
                            iArr3[i4] = modulusGF.add(iArr3[i4], modulusGF.multiply(i2, iArr2[i3]));
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

    public int evaluateAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i == 0) {
                return getCoefficient(0);
            }
            if (i == 1) {
                int i2 = 0;
                for (int i3 : this.coefficients) {
                    i2 = this.field.add(i2, i3);
                }
                return i2;
            }
            int[] iArr = this.coefficients;
            int i4 = iArr[0];
            int length = iArr.length;
            for (int i5 = 1; i5 < length; i5++) {
                ModulusGF modulusGF = this.field;
                i4 = modulusGF.add(modulusGF.multiply(i, i4), this.coefficients[i5]);
            }
            return i4;
        }
        return invokeI.intValue;
    }

    public int getCoefficient(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            int[] iArr = this.coefficients;
            return iArr[(iArr.length - 1) - i];
        }
        return invokeI.intValue;
    }

    public int[] getCoefficients() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.coefficients;
        }
        return (int[]) invokeV.objValue;
    }

    public int getDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.coefficients.length - 1;
        }
        return invokeV.intValue;
    }

    public boolean isZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.coefficients[0] != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ModulusPoly multiply(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i == 0) {
                return this.field.getZero();
            }
            if (i == 1) {
                return this;
            }
            int length = this.coefficients.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = this.field.multiply(this.coefficients[i2], i);
            }
            return new ModulusPoly(this.field, iArr);
        }
        return (ModulusPoly) invokeI.objValue;
    }

    public ModulusPoly subtract(ModulusPoly modulusPoly) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, modulusPoly)) == null) {
            if (this.field.equals(modulusPoly.field)) {
                if (modulusPoly.isZero()) {
                    return this;
                }
                return add(modulusPoly.negative());
            }
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        return (ModulusPoly) invokeL.objValue;
    }

    public ModulusPoly multiplyByMonomial(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
            if (i >= 0) {
                if (i2 == 0) {
                    return this.field.getZero();
                }
                int length = this.coefficients.length;
                int[] iArr = new int[i + length];
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = this.field.multiply(this.coefficients[i3], i2);
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
            for (int i = 0; i < length; i++) {
                iArr[i] = this.field.subtract(0, this.coefficients[i]);
            }
            return new ModulusPoly(this.field, iArr);
        }
        return (ModulusPoly) invokeV.objValue;
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
}
