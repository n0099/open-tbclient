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
public final class AI01392xDecoder extends AI01decoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEADER_SIZE = 8;
    public static final int LAST_DIGIT_SIZE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AI01392xDecoder(BitArray bitArray) {
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

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException, FormatException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getInformation().getSize() >= 48) {
                StringBuilder sb = new StringBuilder();
                encodeCompressedGtin(sb, 8);
                int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
                sb.append("(392");
                sb.append(extractNumericValueFromBitArray);
                sb.append(')');
                sb.append(getGeneralDecoder().decodeGeneralPurposeField(50, null).getNewString());
                return sb.toString();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (String) invokeV.objValue;
    }
}
