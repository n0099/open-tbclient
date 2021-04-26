package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public final class SimpleToken extends Token {
    public final short bitCount;
    public final short value;

    public SimpleToken(Token token, int i2, int i3) {
        super(token);
        this.value = (short) i2;
        this.bitCount = (short) i3;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public String toString() {
        short s = this.value;
        short s2 = this.bitCount;
        int i2 = (s & ((1 << s2) - 1)) | (1 << s2);
        return "<" + Integer.toBinaryString(i2 | (1 << this.bitCount)).substring(1) + Typography.greater;
    }
}
