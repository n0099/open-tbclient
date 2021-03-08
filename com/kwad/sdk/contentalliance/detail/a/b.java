package com.kwad.sdk.contentalliance.detail.a;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.swipe.SwipeLayout;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    private View b;
    private SwipeLayout c;
    private AdTemplate d;
    private com.kwad.sdk.contentalliance.a.a e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.b.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            b.this.c.a(b.this.f);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            if (b.this.c.b(b.this.f)) {
                b.this.c.c(b.this.f);
            }
        }
    };
    private SwipeLayout.a f = new SwipeLayout.a() { // from class: com.kwad.sdk.contentalliance.detail.a.b.2
        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
        public void b() {
            b.this.e();
        }
    };

    private void a(KsFragment ksFragment) {
        if (this.b != null) {
            return;
        }
        this.b = ksFragment.getParentFragment().getView();
        this.c = (SwipeLayout) this.b.findViewById(R.id.ksad_swipe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.d);
        SceneImpl sceneImpl = this.d.mAdScene;
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
        com.kwad.sdk.core.report.e.o(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        a(this.f5594a.k);
        this.d = this.f5594a.j;
        this.f5594a.b.add(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        this.f5594a.b.remove(this.e);
    }
}
