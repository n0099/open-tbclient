package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
/* loaded from: classes6.dex */
public abstract class AI013x0xDecoder extends AI01weightDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEADER_SIZE = 5;
    public static final int WEIGHT_SIZE = 15;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AI013x0xDecoder(BitArray bitArray) {
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
    public String parseInformation() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getInformation().getSize() == 60) {
                StringBuilder sb = new StringBuilder();
                encodeCompressedGtin(sb, 5);
                encodeCompressedWeight(sb, 45, 15);
                return sb.toString();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (String) invokeV.objValue;
    }
}
