package com.google.zxing.datamatrix.encoder;
/* loaded from: classes8.dex */
public final class Base256Encoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 5;
    }

    public static char randomize255State(char c, int i) {
        int i2 = c + ((i * 149) % 255) + 1;
        if (i2 <= 255) {
            return (char) i2;
        }
        return (char) (i2 - 256);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            sb.append(encoderContext.getCurrentChar());
            encoderContext.pos++;
            int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
            if (lookAheadTest != getEncodingMode()) {
                encoderContext.signalEncoderChange(lookAheadTest);
                break;
            }
        }
        int length = sb.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        if (encoderContext.getSymbolInfo().getDataCapacity() - codewordCount > 0) {
            z = true;
        } else {
            z = false;
        }
        if (encoderContext.hasMoreCharacters() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            encoderContext.writeCodeword(randomize255State(sb.charAt(i), encoderContext.getCodewordCount() + 1));
        }
    }
}
