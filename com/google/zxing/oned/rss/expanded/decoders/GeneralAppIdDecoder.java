package com.google.zxing.oned.rss.expanded.decoders;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import kotlin.text.Typography;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes10.dex */
public final class GeneralAppIdDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuilder buffer;
    public final CurrentParsingState current;
    public final BitArray information;

    public GeneralAppIdDecoder(BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.current = new CurrentParsingState();
        this.buffer = new StringBuilder();
        this.information = bitArray;
    }

    private DecodedChar decodeAlphanumeric(int i2) {
        InterceptResult invokeI;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 5);
            if (extractNumericValueFromBitArray == 15) {
                return new DecodedChar(i2 + 5, '$');
            }
            if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
                return new DecodedChar(i2 + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
            }
            int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 6);
            if (extractNumericValueFromBitArray2 >= 32 && extractNumericValueFromBitArray2 < 58) {
                return new DecodedChar(i2 + 6, (char) (extractNumericValueFromBitArray2 + 33));
            }
            switch (extractNumericValueFromBitArray2) {
                case 58:
                    c2 = '*';
                    break;
                case 59:
                    c2 = ',';
                    break;
                case 60:
                    c2 = SignatureImpl.SEP;
                    break;
                case 61:
                    c2 = '.';
                    break;
                case 62:
                    c2 = '/';
                    break;
                default:
                    throw new IllegalStateException("Decoding invalid alphanumeric value: " + extractNumericValueFromBitArray2);
            }
            return new DecodedChar(i2 + 6, c2);
        }
        return (DecodedChar) invokeI.objValue;
    }

    private DecodedChar decodeIsoIec646(int i2) throws FormatException {
        InterceptResult invokeI;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 5);
            if (extractNumericValueFromBitArray == 15) {
                return new DecodedChar(i2 + 5, '$');
            }
            if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
                return new DecodedChar(i2 + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
            }
            int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 7);
            if (extractNumericValueFromBitArray2 < 64 || extractNumericValueFromBitArray2 >= 90) {
                if (extractNumericValueFromBitArray2 >= 90 && extractNumericValueFromBitArray2 < 116) {
                    return new DecodedChar(i2 + 7, (char) (extractNumericValueFromBitArray2 + 7));
                }
                switch (extractNumericValueFromBitArray(i2, 8)) {
                    case 232:
                        c2 = '!';
                        break;
                    case WriteActivity.CONTENT_MAX_COUNT /* 233 */:
                        c2 = '\"';
                        break;
                    case 234:
                        c2 = '%';
                        break;
                    case 235:
                        c2 = Typography.amp;
                        break;
                    case 236:
                        c2 = ExtendedMessageFormat.QUOTE;
                        break;
                    case 237:
                        c2 = '(';
                        break;
                    case 238:
                        c2 = ')';
                        break;
                    case 239:
                        c2 = '*';
                        break;
                    case 240:
                        c2 = '+';
                        break;
                    case BaseActivity.DIALOG_PROMPT /* 241 */:
                        c2 = ',';
                        break;
                    case BaseActivity.DIALOG_LOADING /* 242 */:
                        c2 = SignatureImpl.SEP;
                        break;
                    case LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK /* 243 */:
                        c2 = '.';
                        break;
                    case 244:
                        c2 = '/';
                        break;
                    case 245:
                        c2 = ':';
                        break;
                    case 246:
                        c2 = ';';
                        break;
                    case GDiffPatcher.DATA_USHORT /* 247 */:
                        c2 = Typography.less;
                        break;
                    case GDiffPatcher.DATA_INT /* 248 */:
                        c2 = a.f36026h;
                        break;
                    case 249:
                        c2 = Typography.greater;
                        break;
                    case 250:
                        c2 = '?';
                        break;
                    case GDiffPatcher.COPY_USHORT_INT /* 251 */:
                        c2 = '_';
                        break;
                    case GDiffPatcher.COPY_INT_UBYTE /* 252 */:
                        c2 = ' ';
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
                return new DecodedChar(i2 + 8, c2);
            }
            return new DecodedChar(i2 + 7, (char) (extractNumericValueFromBitArray2 + 1));
        }
        return (DecodedChar) invokeI.objValue;
    }

    private DecodedNumeric decodeNumeric(int i2) throws FormatException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            int i3 = i2 + 7;
            if (i3 > this.information.getSize()) {
                int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 4);
                if (extractNumericValueFromBitArray == 0) {
                    return new DecodedNumeric(this.information.getSize(), 10, 10);
                }
                return new DecodedNumeric(this.information.getSize(), extractNumericValueFromBitArray - 1, 10);
            }
            int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 7) - 8;
            return new DecodedNumeric(i3, extractNumericValueFromBitArray2 / 11, extractNumericValueFromBitArray2 % 11);
        }
        return (DecodedNumeric) invokeI.objValue;
    }

    private boolean isAlphaOr646ToNumericLatch(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
            int i3 = i2 + 3;
            if (i3 > this.information.getSize()) {
                return false;
            }
            while (i2 < i3) {
                if (this.information.get(i2)) {
                    return false;
                }
                i2++;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    private boolean isAlphaTo646ToAlphaLatch(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) {
            if (i2 + 1 > this.information.getSize()) {
                return false;
            }
            for (int i4 = 0; i4 < 5 && (i3 = i4 + i2) < this.information.getSize(); i4++) {
                if (i4 == 2) {
                    if (!this.information.get(i2 + 2)) {
                        return false;
                    }
                } else if (this.information.get(i3)) {
                    return false;
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    private boolean isNumericToAlphaNumericLatch(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            if (i2 + 1 > this.information.getSize()) {
                return false;
            }
            for (int i4 = 0; i4 < 4 && (i3 = i4 + i2) < this.information.getSize(); i4++) {
                if (this.information.get(i3)) {
                    return false;
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    private boolean isStillAlpha(int i2) {
        InterceptResult invokeI;
        int extractNumericValueFromBitArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            if (i2 + 5 > this.information.getSize()) {
                return false;
            }
            int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 5);
            if (extractNumericValueFromBitArray2 < 5 || extractNumericValueFromBitArray2 >= 16) {
                return i2 + 6 <= this.information.getSize() && (extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 6)) >= 16 && extractNumericValueFromBitArray < 63;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    private boolean isStillIsoIec646(int i2) {
        InterceptResult invokeI;
        int extractNumericValueFromBitArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) {
            if (i2 + 5 > this.information.getSize()) {
                return false;
            }
            int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 5);
            if (extractNumericValueFromBitArray2 < 5 || extractNumericValueFromBitArray2 >= 16) {
                if (i2 + 7 > this.information.getSize()) {
                    return false;
                }
                int extractNumericValueFromBitArray3 = extractNumericValueFromBitArray(i2, 7);
                if (extractNumericValueFromBitArray3 < 64 || extractNumericValueFromBitArray3 >= 116) {
                    return i2 + 8 <= this.information.getSize() && (extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 8)) >= 232 && extractNumericValueFromBitArray < 253;
                }
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    private boolean isStillNumeric(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65546, this, i2)) != null) {
            return invokeI.booleanValue;
        }
        if (i2 + 7 > this.information.getSize()) {
            return i2 + 4 <= this.information.getSize();
        }
        int i3 = i2;
        while (true) {
            int i4 = i2 + 3;
            if (i3 < i4) {
                if (this.information.get(i3)) {
                    return true;
                }
                i3++;
            } else {
                return this.information.get(i4);
            }
        }
    }

    private BlockParsedResult parseAlphaBlock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            while (isStillAlpha(this.current.getPosition())) {
                DecodedChar decodeAlphanumeric = decodeAlphanumeric(this.current.getPosition());
                this.current.setPosition(decodeAlphanumeric.getNewPosition());
                if (decodeAlphanumeric.isFNC1()) {
                    return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
                }
                this.buffer.append(decodeAlphanumeric.getValue());
            }
            if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
                this.current.incrementPosition(3);
                this.current.setNumeric();
            } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
                if (this.current.getPosition() + 5 < this.information.getSize()) {
                    this.current.incrementPosition(5);
                } else {
                    this.current.setPosition(this.information.getSize());
                }
                this.current.setIsoIec646();
            }
            return new BlockParsedResult(false);
        }
        return (BlockParsedResult) invokeV.objValue;
    }

    private DecodedInformation parseBlocks() throws FormatException {
        BlockParsedResult parseNumericBlock;
        boolean isFinished;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            do {
                int position = this.current.getPosition();
                if (this.current.isAlpha()) {
                    parseNumericBlock = parseAlphaBlock();
                    isFinished = parseNumericBlock.isFinished();
                } else if (this.current.isIsoIec646()) {
                    parseNumericBlock = parseIsoIec646Block();
                    isFinished = parseNumericBlock.isFinished();
                } else {
                    parseNumericBlock = parseNumericBlock();
                    isFinished = parseNumericBlock.isFinished();
                }
                if (!(position != this.current.getPosition()) && !isFinished) {
                    break;
                }
            } while (!isFinished);
            return parseNumericBlock.getDecodedInformation();
        }
        return (DecodedInformation) invokeV.objValue;
    }

    private BlockParsedResult parseIsoIec646Block() throws FormatException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            while (isStillIsoIec646(this.current.getPosition())) {
                DecodedChar decodeIsoIec646 = decodeIsoIec646(this.current.getPosition());
                this.current.setPosition(decodeIsoIec646.getNewPosition());
                if (decodeIsoIec646.isFNC1()) {
                    return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
                }
                this.buffer.append(decodeIsoIec646.getValue());
            }
            if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
                this.current.incrementPosition(3);
                this.current.setNumeric();
            } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
                if (this.current.getPosition() + 5 < this.information.getSize()) {
                    this.current.incrementPosition(5);
                } else {
                    this.current.setPosition(this.information.getSize());
                }
                this.current.setAlpha();
            }
            return new BlockParsedResult(false);
        }
        return (BlockParsedResult) invokeV.objValue;
    }

    private BlockParsedResult parseNumericBlock() throws FormatException {
        DecodedInformation decodedInformation;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            while (isStillNumeric(this.current.getPosition())) {
                DecodedNumeric decodeNumeric = decodeNumeric(this.current.getPosition());
                this.current.setPosition(decodeNumeric.getNewPosition());
                if (decodeNumeric.isFirstDigitFNC1()) {
                    if (decodeNumeric.isSecondDigitFNC1()) {
                        decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString());
                    } else {
                        decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodeNumeric.getSecondDigit());
                    }
                    return new BlockParsedResult(decodedInformation, true);
                }
                this.buffer.append(decodeNumeric.getFirstDigit());
                if (decodeNumeric.isSecondDigitFNC1()) {
                    return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
                }
                this.buffer.append(decodeNumeric.getSecondDigit());
            }
            if (isNumericToAlphaNumericLatch(this.current.getPosition())) {
                this.current.setAlpha();
                this.current.incrementPosition(4);
            }
            return new BlockParsedResult(false);
        }
        return (BlockParsedResult) invokeV.objValue;
    }

    public String decodeAllCodes(StringBuilder sb, int i2) throws NotFoundException, FormatException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(1048576, this, sb, i2)) != null) {
            return (String) invokeLI.objValue;
        }
        String str = null;
        while (true) {
            DecodedInformation decodeGeneralPurposeField = decodeGeneralPurposeField(i2, str);
            String parseFieldsInGeneralPurpose = FieldParser.parseFieldsInGeneralPurpose(decodeGeneralPurposeField.getNewString());
            if (parseFieldsInGeneralPurpose != null) {
                sb.append(parseFieldsInGeneralPurpose);
            }
            String valueOf = decodeGeneralPurposeField.isRemaining() ? String.valueOf(decodeGeneralPurposeField.getRemainingValue()) : null;
            if (i2 != decodeGeneralPurposeField.getNewPosition()) {
                i2 = decodeGeneralPurposeField.getNewPosition();
                str = valueOf;
            } else {
                return sb.toString();
            }
        }
    }

    public DecodedInformation decodeGeneralPurposeField(int i2, String str) throws FormatException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            this.buffer.setLength(0);
            if (str != null) {
                this.buffer.append(str);
            }
            this.current.setPosition(i2);
            DecodedInformation parseBlocks = parseBlocks();
            if (parseBlocks != null && parseBlocks.isRemaining()) {
                return new DecodedInformation(this.current.getPosition(), this.buffer.toString(), parseBlocks.getRemainingValue());
            }
            return new DecodedInformation(this.current.getPosition(), this.buffer.toString());
        }
        return (DecodedInformation) invokeIL.objValue;
    }

    public int extractNumericValueFromBitArray(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? extractNumericValueFromBitArray(this.information, i2, i3) : invokeII.intValue;
    }

    public static int extractNumericValueFromBitArray(BitArray bitArray, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bitArray, i2, i3)) == null) {
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                if (bitArray.get(i2 + i5)) {
                    i4 |= 1 << ((i3 - i5) - 1);
                }
            }
            return i4;
        }
        return invokeLII.intValue;
    }
}
