package com.kwad.components.core.i;

import com.kwad.components.core.m.i;
import com.kwad.sdk.api.core.fragment.KsFragment;
/* loaded from: classes8.dex */
public class c extends KsFragment implements com.kwad.sdk.g.kwai.b {
    public final com.kwad.sdk.g.kwai.a mBackPressDelete = new com.kwad.sdk.g.kwai.a();
    public boolean enableDestroyer = true;

    @Override // com.kwad.sdk.g.kwai.b
    public boolean bG() {
        return this.mBackPressDelete.bG();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (!this.enableDestroyer || getHost() == null) {
            return;
        }
        i.destroyFragment(getContext(), getView());
    }
}
