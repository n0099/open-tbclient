package com.kwad.sdk.contentalliance.profile.tabvideo.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.tabvideo.detail.ProfileVideoDetailParam;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RadiusPvFrameLayout;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.contentalliance.profile.tabvideo.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private RadiusPvFrameLayout f9097b;
    private RadiusPvFrameLayout.a c = new RadiusPvFrameLayout.a() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.a.b.a.1
        @Override // com.kwad.sdk.widget.RadiusPvFrameLayout.a
        public void a() {
            a.this.f();
        }
    };

    private void e() {
        com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().a(((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).f.g());
        ProfileVideoDetailParam profileVideoDetailParam = new ProfileVideoDetailParam();
        profileVideoDetailParam.mEnterScene = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).f9096a.mEntryScene;
        profileVideoDetailParam.mAuthorId = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).f9096a.mAuthorId;
        profileVideoDetailParam.mTabId = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).f9096a.mTabId;
        profileVideoDetailParam.mSelectedPosition = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).h;
        com.kwad.sdk.contentalliance.profile.tabvideo.detail.b.a(o(), profileVideoDetailParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        e.a((AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).i);
    }

    private void g() {
        e.b((AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) this.f10751a).i, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f9097b.setOnClickListener(this);
        this.f9097b.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9097b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9097b = (RadiusPvFrameLayout) b(R.id.ksad_profile_item_root);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.a()) {
            return;
        }
        e();
        g();
    }
}
