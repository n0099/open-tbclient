package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {
    public final DynamicValueConfig mDynamicValueConfig;

    /* loaded from: classes9.dex */
    public interface DynamicValueConfig {
        int getGoodEnoughScanNumber();

        List<Integer> getScansToDecode();
    }

    /* loaded from: classes9.dex */
    public static class DefaultDynamicValueConfig implements DynamicValueConfig {
        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public int getGoodEnoughScanNumber() {
            return 0;
        }

        public DefaultDynamicValueConfig() {
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public List<Integer> getScansToDecode() {
            return Collections.EMPTY_LIST;
        }
    }

    public SimpleProgressiveJpegConfig() {
        this(new DefaultDynamicValueConfig());
    }

    public SimpleProgressiveJpegConfig(DynamicValueConfig dynamicValueConfig) {
        this.mDynamicValueConfig = (DynamicValueConfig) Preconditions.checkNotNull(dynamicValueConfig);
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public QualityInfo getQualityInfo(int i) {
        boolean z;
        if (i >= this.mDynamicValueConfig.getGoodEnoughScanNumber()) {
            z = true;
        } else {
            z = false;
        }
        return ImmutableQualityInfo.of(i, z, false);
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public int getNextScanNumberToDecode(int i) {
        List<Integer> scansToDecode = this.mDynamicValueConfig.getScansToDecode();
        if (scansToDecode != null && !scansToDecode.isEmpty()) {
            for (int i2 = 0; i2 < scansToDecode.size(); i2++) {
                if (scansToDecode.get(i2).intValue() > i) {
                    return scansToDecode.get(i2).intValue();
                }
            }
            return Integer.MAX_VALUE;
        }
        return i + 1;
    }
}
