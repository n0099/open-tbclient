package com.kwad.sdk.contentalliance.profile.tabvideo;

import com.kwad.sdk.core.scene.URLPackage;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class ProfileTabVideoParam implements Serializable {
    public static final long serialVersionUID = -6152648276167879373L;
    public long mAuthorId;
    public long mCurrentPhotoId;
    public long mEntryScene;
    public long mTabId;
    public String mTabName;
    public URLPackage mURLPackage;

    public boolean isValid() {
        return (this.mEntryScene == 0 || this.mURLPackage == null || this.mAuthorId == 0) ? false : true;
    }
}
