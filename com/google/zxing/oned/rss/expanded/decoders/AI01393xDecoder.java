package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
/* loaded from: classes7.dex */
public final class AI01393xDecoder extends AI01decoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_THREE_DIGITS_SIZE = 10;
    public static final int HEADER_SIZE = 8;
    public static final int LAST_DIGIT_SIZE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AI01393xDecoder(BitArray bitArray) {
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

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException, FormatException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getInformation().getSize() >= 48) {
                StringBuilder sb = new StringBuilder();
                encodeCompressedGtin(sb, 8);
                int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
                sb.append("(393");
                sb.append(extractNumericValueFromBitArray);
                sb.append(')');
                int extractNumericValueFromBitArray2 = getGeneralDecoder().extractNumericValueFromBitArray(50, 10);
                if (extractNumericValueFromBitArray2 / 100 == 0) {
                    sb.append('0');
                }
                if (extractNumericValueFromBitArray2 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(extractNumericValueFromBitArray2);
                sb.append(getGeneralDecoder().decodeGeneralPurposeField(60, null).getNewString());
                return sb.toString();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (String) invokeV.objValue;
    }
}
