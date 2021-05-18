package com.kwad.sdk.b;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.utils.i;
/* loaded from: classes6.dex */
public class d extends KsFragment {

    /* renamed from: a  reason: collision with root package name */
    public boolean f31892a = true;

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (!this.f31892a || getHost() == null) {
            return;
        }
        i.a(this);
    }
}
