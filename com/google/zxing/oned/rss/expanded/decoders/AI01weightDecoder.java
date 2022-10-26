package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.BitArray;
/* loaded from: classes7.dex */
public abstract class AI01weightDecoder extends AI01decoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void addWeightCode(StringBuilder sb, int i);

    public abstract int checkWeight(int i);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BitArray) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void encodeCompressedWeight(StringBuilder sb, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sb, i, i2) == null) {
            int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i, i2);
            addWeightCode(sb, extractNumericValueFromBitArray);
            int checkWeight = checkWeight(extractNumericValueFromBitArray);
            int i3 = 100000;
            for (int i4 = 0; i4 < 5; i4++) {
                if (checkWeight / i3 == 0) {
                    sb.append('0');
                }
                i3 /= 10;
            }
            sb.append(checkWeight);
        }
    }
}
