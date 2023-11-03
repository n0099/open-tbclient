package com.google.zxing.oned.rss.expanded.decoders;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import kotlin.text.Typography;
import org.apache.commons.codec.net.RFC1522Codec;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes10.dex */
public final class GeneralAppIdDecoder {
    public final BitArray information;
    public final CurrentParsingState current = new CurrentParsingState();
    public final StringBuilder buffer = new StringBuilder();

    public GeneralAppIdDecoder(BitArray bitArray) {
        this.information = bitArray;
    }

    private boolean isAlphaOr646ToNumericLatch(int i) {
        int i2 = i + 3;
        if (i2 > this.information.getSize()) {
            return false;
        }
        while (i < i2) {
            if (this.information.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int i) {
        int i2;
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.information.getSize(); i3++) {
            if (this.information.get(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStillAlpha(int i) {
        int extractNumericValueFromBitArray;
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray2 >= 5 && extractNumericValueFromBitArray2 < 16) {
            return true;
        }
        if (i + 6 > this.information.getSize() || (extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 6)) < 16 || extractNumericValueFromBitArray >= 63) {
            return false;
        }
        return true;
    }

    private boolean isStillNumeric(int i) {
        if (i + 7 > this.information.getSize()) {
            if (i + 4 <= this.information.getSize()) {
                return true;
            }
            return false;
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 < i3) {
                if (this.information.get(i2)) {
                    return true;
                }
                i2++;
            } else {
                return this.information.get(i3);
            }
        }
    }

    private DecodedChar decodeAlphanumeric(int i) {
        char c;
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 6);
        if (extractNumericValueFromBitArray2 >= 32 && extractNumericValueFromBitArray2 < 58) {
            return new DecodedChar(i + 6, (char) (extractNumericValueFromBitArray2 + 33));
        }
        switch (extractNumericValueFromBitArray2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = SignatureImpl.SEP;
                break;
            case 61:
                c = IStringUtil.EXTENSION_SEPARATOR;
                break;
            case 62:
                c = WebvttCueParser.CHAR_SLASH;
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + extractNumericValueFromBitArray2);
        }
        return new DecodedChar(i + 6, c);
    }

    private DecodedChar decodeIsoIec646(int i) throws FormatException {
        char c;
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
        if (extractNumericValueFromBitArray2 >= 64 && extractNumericValueFromBitArray2 < 90) {
            return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray2 + 1));
        }
        if (extractNumericValueFromBitArray2 >= 90 && extractNumericValueFromBitArray2 < 116) {
            return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray2 + 7));
        }
        switch (extractNumericValueFromBitArray(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = Typography.quote;
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case Constants.METHOD_IM_CONSULT_NOTIFY_MSG /* 236 */:
                c = '\'';
                break;
            case Constants.METHOD_IM_CONSULT_IM_UPDATE_MSG /* 237 */:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case Constants.METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG /* 239 */:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case MatroskaExtractor.ID_CUE_CLUSTER_POSITION /* 241 */:
                c = ',';
                break;
            case 242:
                c = SignatureImpl.SEP;
                break;
            case 243:
                c = IStringUtil.EXTENSION_SEPARATOR;
                break;
            case GDiffPatcher.COPY_UBYTE_UBYTE /* 244 */:
                c = WebvttCueParser.CHAR_SLASH;
                break;
            case GDiffPatcher.COPY_UBYTE_USHORT /* 245 */:
                c = ':';
                break;
            case 246:
                c = WebvttCueParser.CHAR_SEMI_COLON;
                break;
            case GDiffPatcher.DATA_USHORT /* 247 */:
                c = '<';
                break;
            case GDiffPatcher.DATA_INT /* 248 */:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = RFC1522Codec.SEP;
                break;
            case 251:
                c = '_';
                break;
            case GDiffPatcher.COPY_INT_UBYTE /* 252 */:
                c = WebvttCueParser.CHAR_SPACE;
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new DecodedChar(i + 8, c);
    }

    private DecodedNumeric decodeNumeric(int i) throws FormatException {
        int i2 = i + 7;
        if (i2 > this.information.getSize()) {
            int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 4);
            if (extractNumericValueFromBitArray == 0) {
                return new DecodedNumeric(this.information.getSize(), 10, 10);
            }
            return new DecodedNumeric(this.information.getSize(), extractNumericValueFromBitArray - 1, 10);
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7) - 8;
        return new DecodedNumeric(i2, extractNumericValueFromBitArray2 / 11, extractNumericValueFromBitArray2 % 11);
    }

    private boolean isAlphaTo646ToAlphaLatch(int i) {
        int i2;
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.information.getSize(); i3++) {
            if (i3 == 2) {
                if (!this.information.get(i + 2)) {
                    return false;
                }
            } else if (this.information.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public static int extractNumericValueFromBitArray(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private boolean isStillIsoIec646(int i) {
        int extractNumericValueFromBitArray;
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray2 >= 5 && extractNumericValueFromBitArray2 < 16) {
            return true;
        }
        if (i + 7 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray3 = extractNumericValueFromBitArray(i, 7);
        if (extractNumericValueFromBitArray3 >= 64 && extractNumericValueFromBitArray3 < 116) {
            return true;
        }
        if (i + 8 > this.information.getSize() || (extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 8)) < 232 || extractNumericValueFromBitArray >= 253) {
            return false;
        }
        return true;
    }

    private BlockParsedResult parseAlphaBlock() {
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

    private BlockParsedResult parseIsoIec646Block() throws FormatException {
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

    private BlockParsedResult parseNumericBlock() throws FormatException {
        DecodedInformation decodedInformation;
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

    private DecodedInformation parseBlocks() throws FormatException {
        BlockParsedResult parseNumericBlock;
        boolean isFinished;
        boolean z;
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
            if (position != this.current.getPosition()) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !isFinished) {
                break;
            }
        } while (!isFinished);
        return parseNumericBlock.getDecodedInformation();
    }

    public String decodeAllCodes(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str;
        String str2 = null;
        while (true) {
            DecodedInformation decodeGeneralPurposeField = decodeGeneralPurposeField(i, str2);
            String parseFieldsInGeneralPurpose = FieldParser.parseFieldsInGeneralPurpose(decodeGeneralPurposeField.getNewString());
            if (parseFieldsInGeneralPurpose != null) {
                sb.append(parseFieldsInGeneralPurpose);
            }
            if (decodeGeneralPurposeField.isRemaining()) {
                str = String.valueOf(decodeGeneralPurposeField.getRemainingValue());
            } else {
                str = null;
            }
            if (i != decodeGeneralPurposeField.getNewPosition()) {
                i = decodeGeneralPurposeField.getNewPosition();
                str2 = str;
            } else {
                return sb.toString();
            }
        }
    }

    public DecodedInformation decodeGeneralPurposeField(int i, String str) throws FormatException {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.setPosition(i);
        DecodedInformation parseBlocks = parseBlocks();
        if (parseBlocks != null && parseBlocks.isRemaining()) {
            return new DecodedInformation(this.current.getPosition(), this.buffer.toString(), parseBlocks.getRemainingValue());
        }
        return new DecodedInformation(this.current.getPosition(), this.buffer.toString());
    }

    public int extractNumericValueFromBitArray(int i, int i2) {
        return extractNumericValueFromBitArray(this.information, i, i2);
    }
}
