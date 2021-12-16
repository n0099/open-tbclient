package com.google.zxing.common.reedsolomon;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class ReedSolomonDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final GenericGF field;

    public ReedSolomonDecoder(GenericGF genericGF) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {genericGF};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.field = genericGF;
    }

    private int[] findErrorLocations(GenericGFPoly genericGFPoly) throws ReedSolomonException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, genericGFPoly)) == null) {
            int degree = genericGFPoly.getDegree();
            int i2 = 0;
            if (degree == 1) {
                return new int[]{genericGFPoly.getCoefficient(1)};
            }
            int[] iArr = new int[degree];
            for (int i3 = 1; i3 < this.field.getSize() && i2 < degree; i3++) {
                if (genericGFPoly.evaluateAt(i3) == 0) {
                    iArr[i2] = this.field.inverse(i3);
                    i2++;
                }
            }
            if (i2 == degree) {
                return iArr;
            }
            throw new ReedSolomonException("Error locator degree does not match number of roots");
        }
        return (int[]) invokeL.objValue;
    }

    private int[] findErrorMagnitudes(GenericGFPoly genericGFPoly, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, genericGFPoly, iArr)) == null) {
            int length = iArr.length;
            int[] iArr2 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                int inverse = this.field.inverse(iArr[i2]);
                int i3 = 1;
                for (int i4 = 0; i4 < length; i4++) {
                    if (i2 != i4) {
                        int multiply = this.field.multiply(iArr[i4], inverse);
                        i3 = this.field.multiply(i3, (multiply & 1) == 0 ? multiply | 1 : multiply & (-2));
                    }
                }
                iArr2[i2] = this.field.multiply(genericGFPoly.evaluateAt(inverse), this.field.inverse(i3));
                if (this.field.getGeneratorBase() != 0) {
                    iArr2[i2] = this.field.multiply(iArr2[i2], inverse);
                }
            }
            return iArr2;
        }
        return (int[]) invokeLL.objValue;
    }

    private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly genericGFPoly, GenericGFPoly genericGFPoly2, int i2) throws ReedSolomonException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, this, genericGFPoly, genericGFPoly2, i2)) == null) {
            if (genericGFPoly.getDegree() < genericGFPoly2.getDegree()) {
                genericGFPoly2 = genericGFPoly;
                genericGFPoly = genericGFPoly2;
            }
            GenericGFPoly zero = this.field.getZero();
            GenericGFPoly one = this.field.getOne();
            do {
                GenericGFPoly genericGFPoly3 = genericGFPoly2;
                genericGFPoly2 = genericGFPoly;
                genericGFPoly = genericGFPoly3;
                GenericGFPoly genericGFPoly4 = one;
                GenericGFPoly genericGFPoly5 = zero;
                zero = genericGFPoly4;
                if (genericGFPoly.getDegree() >= i2 / 2) {
                    if (!genericGFPoly.isZero()) {
                        GenericGFPoly zero2 = this.field.getZero();
                        int inverse = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
                        while (genericGFPoly2.getDegree() >= genericGFPoly.getDegree() && !genericGFPoly2.isZero()) {
                            int degree = genericGFPoly2.getDegree() - genericGFPoly.getDegree();
                            int multiply = this.field.multiply(genericGFPoly2.getCoefficient(genericGFPoly2.getDegree()), inverse);
                            zero2 = zero2.addOrSubtract(this.field.buildMonomial(degree, multiply));
                            genericGFPoly2 = genericGFPoly2.addOrSubtract(genericGFPoly.multiplyByMonomial(degree, multiply));
                        }
                        one = zero2.multiply(zero).addOrSubtract(genericGFPoly5);
                    } else {
                        throw new ReedSolomonException("r_{i-1} was zero");
                    }
                } else {
                    int coefficient = zero.getCoefficient(0);
                    if (coefficient != 0) {
                        int inverse2 = this.field.inverse(coefficient);
                        return new GenericGFPoly[]{zero.multiply(inverse2), genericGFPoly.multiply(inverse2)};
                    }
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
            } while (genericGFPoly2.getDegree() < genericGFPoly.getDegree());
            throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
        }
        return (GenericGFPoly[]) invokeLLI.objValue;
    }

    public void decode(int[] iArr, int i2) throws ReedSolomonException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, iArr, i2) == null) {
            GenericGFPoly genericGFPoly = new GenericGFPoly(this.field, iArr);
            int[] iArr2 = new int[i2];
            boolean z = true;
            for (int i3 = 0; i3 < i2; i3++) {
                GenericGF genericGF = this.field;
                int evaluateAt = genericGFPoly.evaluateAt(genericGF.exp(genericGF.getGeneratorBase() + i3));
                iArr2[(i2 - 1) - i3] = evaluateAt;
                if (evaluateAt != 0) {
                    z = false;
                }
            }
            if (z) {
                return;
            }
            GenericGFPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i2, 1), new GenericGFPoly(this.field, iArr2), i2);
            GenericGFPoly genericGFPoly2 = runEuclideanAlgorithm[0];
            GenericGFPoly genericGFPoly3 = runEuclideanAlgorithm[1];
            int[] findErrorLocations = findErrorLocations(genericGFPoly2);
            int[] findErrorMagnitudes = findErrorMagnitudes(genericGFPoly3, findErrorLocations);
            for (int i4 = 0; i4 < findErrorLocations.length; i4++) {
                int length = (iArr.length - 1) - this.field.log(findErrorLocations[i4]);
                if (length >= 0) {
                    iArr[length] = GenericGF.addOrSubtract(iArr[length], findErrorMagnitudes[i4]);
                } else {
                    throw new ReedSolomonException("Bad error location");
                }
            }
        }
    }
}
