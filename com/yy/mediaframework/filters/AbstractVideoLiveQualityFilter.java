package com.yy.mediaframework.filters;

import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class AbstractVideoLiveQualityFilter extends AbstractYYMediaFilter {
    public int mLastEncoderInitBitrate = 0;
    public int mLastEncoderInitFrameRate = 0;

    /* loaded from: classes6.dex */
    public interface IWeakerNetworkCallback {
        void notifyInitEncoderParams(int i, int i2);

        void onReCreateEncoder(VideoEncoderConfig videoEncoderConfig);
    }

    public void setEncodeStats(int i, int i2) {
    }

    public void installAdaptor() {
    }

    public boolean hasAdapator() {
        return false;
    }

    public void setResolutionModifyConfigs(List<ResolutionModifyConfig> list, int i) {
    }

    public boolean setNetworkBitrateSuggest(int i) {
        return false;
    }

    public void setWeakNetworkCallback(IWeakerNetworkCallback iWeakerNetworkCallback) {
    }

    public void estimateRebootEncoder(int i, int i2) {
    }

    public float getLastFrameRate() {
        return 0.0f;
    }

    public void setLastFrameRate(float f) {
    }

    public void setLastNetWorkBitrate(int i) {
    }
}
