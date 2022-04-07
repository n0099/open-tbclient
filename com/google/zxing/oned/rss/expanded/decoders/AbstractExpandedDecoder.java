package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
/* loaded from: classes5.dex */
public abstract class AbstractExpandedDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final GeneralAppIdDecoder generalDecoder;
    public final BitArray information;

    public AbstractExpandedDecoder(BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.information = bitArray;
        this.generalDecoder = new GeneralAppIdDecoder(bitArray);
    }

    public static AbstractExpandedDecoder createDecoder(BitArray bitArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bitArray)) == null) {
            if (bitArray.get(1)) {
                return new AI01AndOtherAIs(bitArray);
            }
            if (!bitArray.get(2)) {
                return new AnyAIDecoder(bitArray);
            }
            int extractNumericValueFromBitArray = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 4);
            if (extractNumericValueFromBitArray != 4) {
                if (extractNumericValueFromBitArray != 5) {
                    int extractNumericValueFromBitArray2 = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 5);
                    if (extractNumericValueFromBitArray2 != 12) {
                        if (extractNumericValueFromBitArray2 != 13) {
                            switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 7)) {
                                case 56:
                                    return new AI013x0x1xDecoder(bitArray, "310", "11");
                                case 57:
                                    return new AI013x0x1xDecoder(bitArray, PaymentConfirmRequestData.TERMINAL_ANDROID, "11");
                                case 58:
                                    return new AI013x0x1xDecoder(bitArray, "310", "13");
                                case 59:
                                    return new AI013x0x1xDecoder(bitArray, PaymentConfirmRequestData.TERMINAL_ANDROID, "13");
                                case 60:
                                    return new AI013x0x1xDecoder(bitArray, "310", "15");
                                case 61:
                                    return new AI013x0x1xDecoder(bitArray, PaymentConfirmRequestData.TERMINAL_ANDROID, "15");
                                case 62:
                                    return new AI013x0x1xDecoder(bitArray, "310", "17");
                                case 63:
                                    return new AI013x0x1xDecoder(bitArray, PaymentConfirmRequestData.TERMINAL_ANDROID, "17");
                                default:
                                    throw new IllegalStateException("unknown decoder: " + bitArray);
                            }
                        }
                        return new AI01393xDecoder(bitArray);
                    }
                    return new AI01392xDecoder(bitArray);
                }
                return new AI01320xDecoder(bitArray);
            }
            return new AI013103decoder(bitArray);
        }
        return (AbstractExpandedDecoder) invokeL.objValue;
    }

    public final GeneralAppIdDecoder getGeneralDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.generalDecoder : (GeneralAppIdDecoder) invokeV.objValue;
    }

    public final BitArray getInformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.information : (BitArray) invokeV.objValue;
    }

    public abstract String parseInformation() throws NotFoundException, FormatException;
}
