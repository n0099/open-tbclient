package com.kwad.sdk.contentalliance.tube.detail;

import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class TubeDetailParam implements Serializable {
    private static final long serialVersionUID = -5238032101385027454L;
    public AdTemplate mAdTemplate;
    public long mEntryScene;
    public TubeInfo mTubeInfo;

    public long getTubeId() {
        if (this.mTubeInfo != null) {
            return this.mTubeInfo.tubeId;
        }
        return 0L;
    }

    public boolean isValid() {
        return (this.mEntryScene == 0 || this.mTubeInfo == null) ? false : true;
    }
}
