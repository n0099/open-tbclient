package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.BitArray;
/* loaded from: classes3.dex */
public abstract class AI01weightDecoder extends AI01decoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BitArray) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public abstract void addWeightCode(StringBuilder sb, int i2);

    public abstract int checkWeight(int i2);

    public final void encodeCompressedWeight(StringBuilder sb, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sb, i2, i3) == null) {
            int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i2, i3);
            addWeightCode(sb, extractNumericValueFromBitArray);
            int checkWeight = checkWeight(extractNumericValueFromBitArray);
            int i4 = 100000;
            for (int i5 = 0; i5 < 5; i5++) {
                if (checkWeight / i4 == 0) {
                    sb.append('0');
                }
                i4 /= 10;
            }
            sb.append(checkWeight);
        }
    }
}
