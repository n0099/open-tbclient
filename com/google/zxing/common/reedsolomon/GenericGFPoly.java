package com.google.zxing.common.reedsolomon;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class GenericGFPoly {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] coefficients;
    public final GenericGF field;

    public GenericGFPoly(GenericGF genericGF, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {genericGF, iArr};
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
            this.field = genericGF;
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

    public GenericGFPoly addOrSubtract(GenericGFPoly genericGFPoly) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, genericGFPoly)) == null) {
            if (this.field.equals(genericGFPoly.field)) {
                if (isZero()) {
                    return genericGFPoly;
                }
                if (genericGFPoly.isZero()) {
                    return this;
                }
                int[] iArr = this.coefficients;
                int[] iArr2 = genericGFPoly.coefficients;
                if (iArr.length <= iArr2.length) {
                    iArr = iArr2;
                    iArr2 = iArr;
                }
                int[] iArr3 = new int[iArr.length];
                int length = iArr.length - iArr2.length;
                System.arraycopy(iArr, 0, iArr3, 0, length);
                for (int i = length; i < iArr.length; i++) {
                    iArr3[i] = GenericGF.addOrSubtract(iArr2[i - length], iArr[i]);
                }
                return new GenericGFPoly(this.field, iArr3);
            }
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        return (GenericGFPoly) invokeL.objValue;
    }

    public GenericGFPoly[] divide(GenericGFPoly genericGFPoly) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, genericGFPoly)) == null) {
            if (this.field.equals(genericGFPoly.field)) {
                if (!genericGFPoly.isZero()) {
                    GenericGFPoly zero = this.field.getZero();
                    int inverse = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
                    GenericGFPoly genericGFPoly2 = this;
                    while (genericGFPoly2.getDegree() >= genericGFPoly.getDegree() && !genericGFPoly2.isZero()) {
                        int degree = genericGFPoly2.getDegree() - genericGFPoly.getDegree();
                        int multiply = this.field.multiply(genericGFPoly2.getCoefficient(genericGFPoly2.getDegree()), inverse);
                        GenericGFPoly multiplyByMonomial = genericGFPoly.multiplyByMonomial(degree, multiply);
                        zero = zero.addOrSubtract(this.field.buildMonomial(degree, multiply));
                        genericGFPoly2 = genericGFPoly2.addOrSubtract(multiplyByMonomial);
                    }
                    return new GenericGFPoly[]{zero, genericGFPoly2};
                }
                throw new IllegalArgumentException("Divide by 0");
            }
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        return (GenericGFPoly[]) invokeL.objValue;
    }

    public GenericGFPoly multiply(GenericGFPoly genericGFPoly) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, genericGFPoly)) == null) {
            if (this.field.equals(genericGFPoly.field)) {
                if (!isZero() && !genericGFPoly.isZero()) {
                    int[] iArr = this.coefficients;
                    int length = iArr.length;
                    int[] iArr2 = genericGFPoly.coefficients;
                    int length2 = iArr2.length;
                    int[] iArr3 = new int[(length + length2) - 1];
                    for (int i = 0; i < length; i++) {
                        int i2 = iArr[i];
                        for (int i3 = 0; i3 < length2; i3++) {
                            int i4 = i + i3;
                            iArr3[i4] = GenericGF.addOrSubtract(iArr3[i4], this.field.multiply(i2, iArr2[i3]));
                        }
                    }
                    return new GenericGFPoly(this.field, iArr3);
                }
                return this.field.getZero();
            }
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        return (GenericGFPoly) invokeL.objValue;
    }

    public int evaluateAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 0) {
                return getCoefficient(0);
            }
            if (i == 1) {
                int i2 = 0;
                for (int i3 : this.coefficients) {
                    i2 = GenericGF.addOrSubtract(i2, i3);
                }
                return i2;
            }
            int[] iArr = this.coefficients;
            int i4 = iArr[0];
            int length = iArr.length;
            for (int i5 = 1; i5 < length; i5++) {
                i4 = GenericGF.addOrSubtract(this.field.multiply(i, i4), this.coefficients[i5]);
            }
            return i4;
        }
        return invokeI.intValue;
    }

    public GenericGFPoly multiply(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
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
            return new GenericGFPoly(this.field, iArr);
        }
        return (GenericGFPoly) invokeI.objValue;
    }

    public int getCoefficient(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int[] iArr = this.coefficients;
            return iArr[(iArr.length - 1) - i];
        }
        return invokeI.intValue;
    }

    public int[] getCoefficients() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.coefficients;
        }
        return (int[]) invokeV.objValue;
    }

    public int getDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.coefficients.length - 1;
        }
        return invokeV.intValue;
    }

    public boolean isZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.coefficients[0] != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public GenericGFPoly multiplyByMonomial(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            if (i >= 0) {
                if (i2 == 0) {
                    return this.field.getZero();
                }
                int length = this.coefficients.length;
                int[] iArr = new int[i + length];
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = this.field.multiply(this.coefficients[i3], i2);
                }
                return new GenericGFPoly(this.field, iArr);
            }
            throw new IllegalArgumentException();
        }
        return (GenericGFPoly) invokeII.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
                        int log = this.field.log(coefficient);
                        if (log == 0) {
                            sb.append('1');
                        } else if (log == 1) {
                            sb.append('a');
                        } else {
                            sb.append("a^");
                            sb.append(log);
                        }
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
