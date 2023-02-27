package com.google.zxing.datamatrix.encoder;
/* loaded from: classes8.dex */
public final class ASCIIEncoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 0;
    }

    public static char encodeASCIIDigits(char c, char c2) {
        if (HighLevelEncoder.isDigit(c) && HighLevelEncoder.isDigit(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(encoderContext.getMessage(), encoderContext.pos) >= 2) {
            encoderContext.writeCodeword(encodeASCIIDigits(encoderContext.getMessage().charAt(encoderContext.pos), encoderContext.getMessage().charAt(encoderContext.pos + 1)));
            encoderContext.pos += 2;
            return;
        }
        char currentChar = encoderContext.getCurrentChar();
        int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
        if (lookAheadTest != getEncodingMode()) {
            if (lookAheadTest != 1) {
                if (lookAheadTest != 2) {
                    if (lookAheadTest != 3) {
                        if (lookAheadTest != 4) {
                            if (lookAheadTest == 5) {
                                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_BASE256);
                                encoderContext.signalEncoderChange(5);
                                return;
                            }
                            throw new IllegalStateException("Illegal mode: " + lookAheadTest);
                        }
                        encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_EDIFACT);
                        encoderContext.signalEncoderChange(4);
                        return;
                    }
                    encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_ANSIX12);
                    encoderContext.signalEncoderChange(3);
                    return;
                }
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_TEXT);
                encoderContext.signalEncoderChange(2);
                return;
            }
            encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_C40);
            encoderContext.signalEncoderChange(1);
        } else if (HighLevelEncoder.isExtendedASCII(currentChar)) {
            encoderContext.writeCodeword(HighLevelEncoder.UPPER_SHIFT);
            encoderContext.writeCodeword((char) ((currentChar - 128) + 1));
            encoderContext.pos++;
        } else {
            encoderContext.writeCodeword((char) (currentChar + 1));
            encoderContext.pos++;
        }
    }
}
