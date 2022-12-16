package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.BitArray;
/* loaded from: classes8.dex */
public abstract class AI01decoder extends AbstractExpandedDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GTIN_SIZE = 40;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AI01decoder(BitArray bitArray) {
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

    public static void appendCheckDigit(StringBuilder sb, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, sb, i) == null) {
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 13; i4++) {
                int charAt = sb.charAt(i4 + i) - '0';
                if ((i4 & 1) == 0) {
                    charAt *= 3;
                }
                i3 += charAt;
            }
            int i5 = 10 - (i3 % 10);
            if (i5 != 10) {
                i2 = i5;
            }
            sb.append(i2);
        }
    }

    public final void encodeCompressedGtin(StringBuilder sb, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, sb, i) == null) {
            sb.append("(01)");
            int length = sb.length();
            sb.append('9');
            encodeCompressedGtinWithoutAI(sb, i, length);
        }
    }

    public final void encodeCompressedGtinWithoutAI(StringBuilder sb, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb, i, i2) == null) {
            for (int i3 = 0; i3 < 4; i3++) {
                int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray((i3 * 10) + i, 10);
                if (extractNumericValueFromBitArray / 100 == 0) {
                    sb.append('0');
                }
                if (extractNumericValueFromBitArray / 10 == 0) {
                    sb.append('0');
                }
                sb.append(extractNumericValueFromBitArray);
            }
            appendCheckDigit(sb, i2);
        }
    }
}
