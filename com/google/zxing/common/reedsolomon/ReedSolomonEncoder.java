package com.google.zxing.common.reedsolomon;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class ReedSolomonEncoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<GenericGFPoly> cachedGenerators;
    public final GenericGF field;

    public ReedSolomonEncoder(GenericGF genericGF) {
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
        ArrayList arrayList = new ArrayList();
        this.cachedGenerators = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    private GenericGFPoly buildGenerator(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            if (i2 >= this.cachedGenerators.size()) {
                List<GenericGFPoly> list = this.cachedGenerators;
                GenericGFPoly genericGFPoly = list.get(list.size() - 1);
                for (int size = this.cachedGenerators.size(); size <= i2; size++) {
                    GenericGF genericGF = this.field;
                    genericGFPoly = genericGFPoly.multiply(new GenericGFPoly(genericGF, new int[]{1, genericGF.exp((size - 1) + genericGF.getGeneratorBase())}));
                    this.cachedGenerators.add(genericGFPoly);
                }
            }
            return this.cachedGenerators.get(i2);
        }
        return (GenericGFPoly) invokeI.objValue;
    }

    public void encode(int[] iArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, iArr, i2) == null) {
            if (i2 != 0) {
                int length = iArr.length - i2;
                if (length > 0) {
                    GenericGFPoly buildGenerator = buildGenerator(i2);
                    int[] iArr2 = new int[length];
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                    int[] coefficients = new GenericGFPoly(this.field, iArr2).multiplyByMonomial(i2, 1).divide(buildGenerator)[1].getCoefficients();
                    int length2 = i2 - coefficients.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        iArr[length + i3] = 0;
                    }
                    System.arraycopy(coefficients, 0, iArr, length + length2, coefficients.length);
                    return;
                }
                throw new IllegalArgumentException("No data bytes provided");
            }
            throw new IllegalArgumentException("No error correction bytes");
        }
    }
}
