package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public final class HighLevelEncoder {
    public static final int[][] CHAR_MAP;
    public static final int MODE_DIGIT = 2;
    public static final int MODE_LOWER = 1;
    public static final int MODE_MIXED = 3;
    public static final int MODE_PUNCT = 4;
    public static final int MODE_UPPER = 0;
    public static final int[][] SHIFT_TABLE;
    public final byte[] text;
    public static final String[] MODE_NAMES = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    public static final int[][] LATCH_TABLE = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    static {
        int[][] iArr = (int[][]) Array.newInstance(int.class, 5, 256);
        CHAR_MAP = iArr;
        iArr[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            CHAR_MAP[0][i2] = (i2 - 65) + 2;
        }
        CHAR_MAP[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            CHAR_MAP[1][i3] = (i3 - 97) + 2;
        }
        CHAR_MAP[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            CHAR_MAP[2][i4] = (i4 - 48) + 2;
        }
        int[][] iArr2 = CHAR_MAP;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i5 = 0; i5 < 28; i5++) {
            CHAR_MAP[3][iArr3[i5]] = i5;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < 31; i6++) {
            if (iArr4[i6] > 0) {
                CHAR_MAP[4][iArr4[i6]] = i6;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance(int.class, 6, 6);
        SHIFT_TABLE = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = SHIFT_TABLE;
        iArr7[0][4] = 0;
        iArr7[1][4] = 0;
        iArr7[1][0] = 28;
        iArr7[3][4] = 0;
        iArr7[2][4] = 0;
        iArr7[2][0] = 15;
    }

    public HighLevelEncoder(byte[] bArr) {
        this.text = bArr;
    }

    public static Collection<State> simplifyStates(Iterable<State> iterable) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                State state2 = (State) it.next();
                if (state2.isBetterThanOrEqualTo(state)) {
                    z = false;
                    break;
                } else if (state.isBetterThanOrEqualTo(state2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(state);
            }
        }
        return linkedList;
    }

    private void updateStateForChar(State state, int i2, Collection<State> collection) {
        char c2 = (char) (this.text[i2] & 255);
        boolean z = CHAR_MAP[state.getMode()][c2] > 0;
        State state2 = null;
        for (int i3 = 0; i3 <= 4; i3++) {
            int i4 = CHAR_MAP[i3][c2];
            if (i4 > 0) {
                if (state2 == null) {
                    state2 = state.endBinaryShift(i2);
                }
                if (!z || i3 == state.getMode() || i3 == 2) {
                    collection.add(state2.latchAndAppend(i3, i4));
                }
                if (!z && SHIFT_TABLE[state.getMode()][i3] >= 0) {
                    collection.add(state2.shiftAndAppend(i3, i4));
                }
            }
        }
        if (state.getBinaryShiftByteCount() > 0 || CHAR_MAP[state.getMode()][c2] == 0) {
            collection.add(state.addBinaryShiftChar(i2));
        }
    }

    public static void updateStateForPair(State state, int i2, int i3, Collection<State> collection) {
        State endBinaryShift = state.endBinaryShift(i2);
        collection.add(endBinaryShift.latchAndAppend(4, i3));
        if (state.getMode() != 4) {
            collection.add(endBinaryShift.shiftAndAppend(4, i3));
        }
        if (i3 == 3 || i3 == 4) {
            collection.add(endBinaryShift.latchAndAppend(2, 16 - i3).latchAndAppend(2, 1));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            collection.add(state.addBinaryShiftChar(i2).addBinaryShiftChar(i2 + 1));
        }
    }

    private Collection<State> updateStateListForChar(Iterable<State> iterable, int i2) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            updateStateForChar(state, i2, linkedList);
        }
        return simplifyStates(linkedList);
    }

    public static Collection<State> updateStateListForPair(Iterable<State> iterable, int i2, int i3) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            updateStateForPair(state, i2, i3, linkedList);
        }
        return simplifyStates(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BitArray encode() {
        int i2;
        Collection<State> singletonList = Collections.singletonList(State.INITIAL_STATE);
        int i3 = 0;
        while (true) {
            byte[] bArr = this.text;
            if (i3 < bArr.length) {
                int i4 = i3 + 1;
                byte b2 = i4 < bArr.length ? bArr[i4] : (byte) 0;
                byte b3 = this.text[i3];
                if (b3 == 13) {
                    if (b2 == 10) {
                        i2 = 2;
                        if (i2 <= 0) {
                        }
                        i3++;
                    }
                    i2 = 0;
                    if (i2 <= 0) {
                    }
                    i3++;
                } else if (b3 == 44) {
                    if (b2 == 32) {
                        i2 = 4;
                        if (i2 <= 0) {
                        }
                        i3++;
                    }
                    i2 = 0;
                    if (i2 <= 0) {
                    }
                    i3++;
                } else if (b3 != 46) {
                    if (b3 == 58 && b2 == 32) {
                        i2 = 5;
                        if (i2 <= 0) {
                            singletonList = updateStateListForPair(singletonList, i3, i2);
                            i3 = i4;
                        } else {
                            singletonList = updateStateListForChar(singletonList, i3);
                        }
                        i3++;
                    }
                    i2 = 0;
                    if (i2 <= 0) {
                    }
                    i3++;
                } else {
                    if (b2 == 32) {
                        i2 = 3;
                        if (i2 <= 0) {
                        }
                        i3++;
                    }
                    i2 = 0;
                    if (i2 <= 0) {
                    }
                    i3++;
                }
            } else {
                return ((State) Collections.min(singletonList, new Comparator<State>() { // from class: com.google.zxing.aztec.encoder.HighLevelEncoder.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(State state, State state2) {
                        return state.getBitCount() - state2.getBitCount();
                    }
                })).toBitArray(this.text);
            }
        }
    }
}
