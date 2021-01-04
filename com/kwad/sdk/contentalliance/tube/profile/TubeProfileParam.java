package com.kwad.sdk.contentalliance.tube.profile;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class TubeProfileParam implements Serializable {
    private static final long serialVersionUID = -5238032101385027454L;
    public AdTemplate mAdTemplate;
    public long mEntryScene;
    public PhotoInfo.TubeEpisode mTubeEpisode;

    public long getTubeId() {
        if (this.mTubeEpisode != null) {
            return this.mTubeEpisode.tubeId;
        }
        return 0L;
    }

    public boolean isValid() {
        return (this.mEntryScene == 0 || this.mTubeEpisode == null) ? false : true;
    }
}
