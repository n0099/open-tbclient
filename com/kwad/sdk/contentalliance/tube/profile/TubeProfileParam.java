package com.kwad.sdk.contentalliance.tube.profile;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class TubeProfileParam implements Serializable {
    public static final long serialVersionUID = -5238032101385027454L;
    public AdTemplate mAdTemplate;
    public long mEntryScene;
    public PhotoInfo.TubeEpisode mTubeEpisode;

    public long getTubeId() {
        PhotoInfo.TubeEpisode tubeEpisode = this.mTubeEpisode;
        if (tubeEpisode != null) {
            return tubeEpisode.tubeId;
        }
        return 0L;
    }

    public boolean isValid() {
        return (this.mEntryScene == 0 || this.mTubeEpisode == null) ? false : true;
    }
}
