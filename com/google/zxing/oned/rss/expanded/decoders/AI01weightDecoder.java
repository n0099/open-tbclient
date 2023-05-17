package com.google.zxing.oned.rss.expanded.decoders;

import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.google.zxing.common.BitArray;
import com.huawei.hms.common.internal.TransactionIdCreater;
/* loaded from: classes9.dex */
public abstract class AI01weightDecoder extends AI01decoder {
    public abstract void addWeightCode(StringBuilder sb, int i);

    public abstract int checkWeight(int i);

    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public final void encodeCompressedWeight(StringBuilder sb, int i, int i2) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i, i2);
        addWeightCode(sb, extractNumericValueFromBitArray);
        int checkWeight = checkWeight(extractNumericValueFromBitArray);
        int i3 = DefaultOggSeeker.MATCH_BYTE_RANGE;
        for (int i4 = 0; i4 < 5; i4++) {
            if (checkWeight / i3 == 0) {
                sb.append(TransactionIdCreater.FILL_BYTE);
            }
            i3 /= 10;
        }
        sb.append(checkWeight);
    }
}
