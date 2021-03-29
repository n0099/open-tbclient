package com.kwad.sdk.contentalliance.detail.a;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.swipe.SwipeLayout;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public View f31964b;

    /* renamed from: c  reason: collision with root package name */
    public SwipeLayout f31965c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f31966d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f31967e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.b.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            b.this.f31965c.a(b.this.f31968f);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            if (b.this.f31965c.b(b.this.f31968f)) {
                b.this.f31965c.c(b.this.f31968f);
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public SwipeLayout.a f31968f = new SwipeLayout.a() { // from class: com.kwad.sdk.contentalliance.detail.a.b.2
        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void b() {
            b.this.e();
        }
    };

    private void a(KsFragment ksFragment) {
        if (this.f31964b != null) {
            return;
        }
        View view = ksFragment.getParentFragment().getView();
        this.f31964b = view;
        this.f31965c = (SwipeLayout) view.findViewById(R.id.ksad_swipe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.f31966d);
        SceneImpl sceneImpl = this.f31966d.mAdScene;
        if (sceneImpl != null) {
            f();
            ProfileHomeParam profileHomeParam = new ProfileHomeParam();
            profileHomeParam.mEntryScene = sceneImpl.entryScene;
            profileHomeParam.mAuthorId = com.kwad.sdk.core.response.b.d.o(k);
            profileHomeParam.mAuthorIcon = com.kwad.sdk.core.response.b.d.r(k);
            profileHomeParam.mAuthorName = com.kwad.sdk.core.response.b.d.p(k);
            profileHomeParam.mCurrentPhotoId = com.kwad.sdk.core.response.b.d.k(k);
            com.kwad.sdk.contentalliance.profile.home.a.a(o(), profileHomeParam);
        }
    }

    private void f() {
        com.kwad.sdk.core.report.e.o(this.f31966d);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        a(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.k);
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        this.f31966d = cVar.j;
        cVar.f32153b.add(this.f31967e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.remove(this.f31967e);
    }
}
