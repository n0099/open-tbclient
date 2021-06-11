package com.kwad.sdk.contentalliance;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.AbstractKsContentAllianceAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.g;
/* loaded from: classes6.dex */
public class e extends AbstractKsContentAllianceAd {

    /* renamed from: a  reason: collision with root package name */
    public KsScene f33128a;

    public e(KsScene ksScene) {
        this.f33128a = ksScene;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentAllianceAd
    @NonNull
    public KsFragment getFragment2() {
        return g.a(this.f33128a);
    }
}
