package com.kwad.sdk.contentalliance;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.AbstractKsContentAllianceAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.g;
/* loaded from: classes3.dex */
public class e extends AbstractKsContentAllianceAd {

    /* renamed from: a  reason: collision with root package name */
    private KsScene f5749a;

    public e(KsScene ksScene) {
        this.f5749a = ksScene;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentAllianceAd
    @NonNull
    public KsFragment getFragment2() {
        return g.a(this.f5749a);
    }
}
