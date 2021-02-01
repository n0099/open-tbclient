package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;
/* loaded from: classes4.dex */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BitArray buildBitArray(List<ExpandedPair> list) {
        int size = (list.size() << 1) - 1;
        BitArray bitArray = new BitArray((list.get(list.size() + (-1)).getRightChar() == null ? size - 1 : size) * 12);
        int value = list.get(0).getRightChar().getValue();
        int i = 0;
        for (int i2 = 11; i2 >= 0; i2--) {
            if (((1 << i2) & value) != 0) {
                bitArray.set(i);
            }
            i++;
        }
        int i3 = i;
        for (int i4 = 1; i4 < list.size(); i4++) {
            ExpandedPair expandedPair = list.get(i4);
            int value2 = expandedPair.getLeftChar().getValue();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & value2) != 0) {
                    bitArray.set(i3);
                }
                i3++;
            }
            if (expandedPair.getRightChar() != null) {
                int value3 = expandedPair.getRightChar().getValue();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & value3) != 0) {
                        bitArray.set(i3);
                    }
                    i3++;
                }
            }
        }
        return bitArray;
    }
}
