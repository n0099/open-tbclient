package com.kwad.sdk.contentalliance.profile.home;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class ProfileHomeParam implements Serializable {
    public static final long serialVersionUID = -6152648276167879373L;
    public String mAuthorIcon;
    public long mAuthorId;
    public String mAuthorName;
    public long mCurrentPhotoId;
    public long mEntryScene;

    public boolean isValid() {
        return (this.mEntryScene == 0 || this.mAuthorId == 0) ? false : true;
    }
}
