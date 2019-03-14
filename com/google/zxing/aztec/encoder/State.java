package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class State {
    static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token, int i, int i2, int i3) {
        this.token = token;
        this.mode = i;
        this.binaryShiftByteCount = i2;
        this.bitCount = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMode() {
        return this.mode;
    }

    Token getToken() {
        return this.token;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBitCount() {
        return this.bitCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State latchAndAppend(int i, int i2) {
        int i3;
        Token token;
        int i4 = this.bitCount;
        Token token2 = this.token;
        if (i != this.mode) {
            int i5 = HighLevelEncoder.LATCH_TABLE[this.mode][i];
            i3 = i4 + (i5 >> 16);
            token = token2.add(65535 & i5, i5 >> 16);
        } else {
            i3 = i4;
            token = token2;
        }
        int i6 = i == 2 ? 4 : 5;
        return new State(token.add(i2, i6), i, 0, i6 + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State shiftAndAppend(int i, int i2) {
        Token token = this.token;
        int i3 = this.mode == 2 ? 4 : 5;
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[this.mode][i], i3).add(i2, 5), this.mode, 0, i3 + this.bitCount + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State addBinaryShiftChar(int i) {
        Token add;
        int i2;
        Token token = this.token;
        int i3 = this.mode;
        int i4 = this.bitCount;
        if (this.mode == 4 || this.mode == 2) {
            int i5 = HighLevelEncoder.LATCH_TABLE[i3][0];
            i4 += i5 >> 16;
            add = token.add(65535 & i5, i5 >> 16);
            i3 = 0;
        } else {
            add = token;
        }
        if (this.binaryShiftByteCount == 0 || this.binaryShiftByteCount == 31) {
            i2 = 18;
        } else {
            i2 = this.binaryShiftByteCount == 62 ? 9 : 8;
        }
        State state = new State(add, i3, this.binaryShiftByteCount + 1, i4 + i2);
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i + 1) : state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State endBinaryShift(int i) {
        return this.binaryShiftByteCount == 0 ? this : new State(this.token.addBinaryShift(i - this.binaryShiftByteCount, this.binaryShiftByteCount), this.mode, 0, this.bitCount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBetterThanOrEqualTo(State state) {
        int i = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        if (state.binaryShiftByteCount > 0 && (this.binaryShiftByteCount == 0 || this.binaryShiftByteCount > state.binaryShiftByteCount)) {
            i += 10;
        }
        return i <= state.bitCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitArray toBitArray(byte[] bArr) {
        LinkedList<Token> linkedList = new LinkedList();
        for (Token token = endBinaryShift(bArr.length).token; token != null; token = token.getPrevious()) {
            linkedList.addFirst(token);
        }
        BitArray bitArray = new BitArray();
        for (Token token2 : linkedList) {
            token2.appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount));
    }
}
