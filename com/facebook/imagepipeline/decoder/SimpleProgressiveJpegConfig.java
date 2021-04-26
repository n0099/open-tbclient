package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {
    public final DynamicValueConfig mDynamicValueConfig;

    /* loaded from: classes6.dex */
    public static class DefaultDynamicValueConfig implements DynamicValueConfig {
        public DefaultDynamicValueConfig() {
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public int getGoodEnoughScanNumber() {
            return 0;
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public List<Integer> getScansToDecode() {
            return Collections.EMPTY_LIST;
        }
    }

    /* loaded from: classes6.dex */
    public interface DynamicValueConfig {
        int getGoodEnoughScanNumber();

        List<Integer> getScansToDecode();
    }

    public SimpleProgressiveJpegConfig() {
        this(new DefaultDynamicValueConfig());
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public int getNextScanNumberToDecode(int i2) {
        List<Integer> scansToDecode = this.mDynamicValueConfig.getScansToDecode();
        if (scansToDecode == null || scansToDecode.isEmpty()) {
            return i2 + 1;
        }
        for (int i3 = 0; i3 < scansToDecode.size(); i3++) {
            if (scansToDecode.get(i3).intValue() > i2) {
                return scansToDecode.get(i3).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public QualityInfo getQualityInfo(int i2) {
        return ImmutableQualityInfo.of(i2, i2 >= this.mDynamicValueConfig.getGoodEnoughScanNumber(), false);
    }

    public SimpleProgressiveJpegConfig(DynamicValueConfig dynamicValueConfig) {
        this.mDynamicValueConfig = (DynamicValueConfig) Preconditions.checkNotNull(dynamicValueConfig);
    }
}
