package com.kwad.sdk.internal.api;

import com.kwad.sdk.api.KsAdVideoPlayConfig;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class KSAdVideoPlayConfigImpl implements KsAdVideoPlayConfig, Serializable {
    public static final long serialVersionUID = -154151744722615768L;
    public boolean dataFlowAutoStart = com.kwad.sdk.core.config.b.o();
    public boolean hasNoCache;
    public boolean videoSoundEnable;

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isDataFlowAutoStart() {
        return this.dataFlowAutoStart;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isNoCache() {
        return this.hasNoCache;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public boolean isVideoSoundEnable() {
        return this.videoSoundEnable;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setDataFlowAutoStart(boolean z) {
        this.dataFlowAutoStart = z;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setNoCache() {
        this.hasNoCache = true;
    }

    @Override // com.kwad.sdk.api.KsAdVideoPlayConfig
    public void setVideoSoundEnable(boolean z) {
        this.videoSoundEnable = z;
    }
}
