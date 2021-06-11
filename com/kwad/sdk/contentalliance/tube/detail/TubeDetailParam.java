package com.kwad.sdk.contentalliance.tube.detail;

import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class TubeDetailParam implements Serializable {
    public static final long serialVersionUID = -5238032101385027454L;
    public AdTemplate mAdTemplate;
    public long mEntryScene;
    public TubeInfo mTubeInfo;

    public long getTubeId() {
        TubeInfo tubeInfo = this.mTubeInfo;
        if (tubeInfo != null) {
            return tubeInfo.tubeId;
        }
        return 0L;
    }

    public boolean isValid() {
        return (this.mEntryScene == 0 || this.mTubeInfo == null) ? false : true;
    }
}
