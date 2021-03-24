package com.kwad.sdk.api.core.fragment;

import androidx.fragment.app.Fragment;
/* loaded from: classes6.dex */
public class KsSavedState {
    public final Fragment.SavedState mSaveState;

    public KsSavedState(Fragment.SavedState savedState) {
        this.mSaveState = savedState;
    }

    public Fragment.SavedState getBase() {
        return this.mSaveState;
    }
}
