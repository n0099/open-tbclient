package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
/* loaded from: classes7.dex */
public final class AI013x0x1xDecoder extends AI01weightDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DATE_SIZE = 16;
    public static final int HEADER_SIZE = 8;
    public static final int WEIGHT_SIZE = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public final String dateCode;
    public final String firstAIdigits;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AI013x0x1xDecoder(BitArray bitArray, String str, String str2) {
        super(bitArray);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitArray, str, str2};
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
        this.dateCode = str2;
        this.firstAIdigits = str;
    }

    private void encodeCompressedDate(StringBuilder sb, int i) {
        int extractNumericValueFromBitArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, this, sb, i) == null) || (extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i, 16)) == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.dateCode);
        sb.append(')');
        int i2 = extractNumericValueFromBitArray % 32;
        int i3 = extractNumericValueFromBitArray / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public void addWeightCode(StringBuilder sb, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, sb, i) == null) {
            sb.append('(');
            sb.append(this.firstAIdigits);
            sb.append(i / 100000);
            sb.append(')');
        }
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public int checkWeight(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i % 100000 : invokeI.intValue;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getInformation().getSize() == 84) {
                StringBuilder sb = new StringBuilder();
                encodeCompressedGtin(sb, 8);
                encodeCompressedWeight(sb, 48, 20);
                encodeCompressedDate(sb, 68);
                return sb.toString();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (String) invokeV.objValue;
    }
}
