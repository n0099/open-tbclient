package com.kwad.sdk.feed.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.AbstractKsFeedPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
/* loaded from: classes3.dex */
public class e extends AbstractKsFeedPage {

    /* renamed from: a  reason: collision with root package name */
    private KsScene f9845a;

    public e(KsScene ksScene) {
        this.f9845a = ksScene;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedPage
    @NonNull
    public KsFragment getFragment2() {
        return c.a(this.f9845a);
    }
}
