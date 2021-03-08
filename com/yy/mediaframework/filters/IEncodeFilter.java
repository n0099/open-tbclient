package com.yy.mediaframework.filters;

import com.yy.mediaframework.IEncoderListener;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
/* loaded from: classes6.dex */
public abstract class IEncodeFilter extends AbstractYYMediaFilter {
    public abstract VideoEncoderType getEncoderFilterType();

    public boolean startEncode() {
        return false;
    }

    public void stopEncode() {
    }

    public boolean init() {
        return false;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
    }

    public void adjustBitRate(int i) {
    }

    public void setEncoderListener(IEncoderListener iEncoderListener) {
    }

    public void requestSyncFrame() {
    }

    public boolean startEncoderOnly(VideoEncoderConfig videoEncoderConfig) {
        return false;
    }

    public boolean stopEncoderAsync() {
        return false;
    }

    public boolean getCacheEncodedData() {
        return false;
    }

    public void createGlElementEnvOnly() {
    }

    public void destoryGlElementEnvOnly() {
    }

    public void reSetEncodingState() {
    }
}
