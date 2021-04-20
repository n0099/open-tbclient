package com.kwad.sdk.contentalliance.profile.tabvideo.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.tabvideo.detail.ProfileVideoDetailParam;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RadiusPvFrameLayout;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.profile.tabvideo.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public RadiusPvFrameLayout f33205b;

    /* renamed from: c  reason: collision with root package name */
    public RadiusPvFrameLayout.a f33206c = new RadiusPvFrameLayout.a() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.a.b.a.1
        @Override // com.kwad.sdk.widget.RadiusPvFrameLayout.a
        public void a() {
            a.this.f();
        }
    };

    private void e() {
        com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().a(((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).f36294f.g());
        ProfileVideoDetailParam profileVideoDetailParam = new ProfileVideoDetailParam();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a;
        profileVideoDetailParam.mEnterScene = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) callercontext).f33204a.mEntryScene;
        profileVideoDetailParam.mAuthorId = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) callercontext).f33204a.mAuthorId;
        profileVideoDetailParam.mTabId = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) callercontext).f33204a.mTabId;
        profileVideoDetailParam.mSelectedPosition = ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) callercontext).f36296h;
        com.kwad.sdk.contentalliance.profile.tabvideo.detail.b.a(o(), profileVideoDetailParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        e.a((AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i);
    }

    private void g() {
        e.b((AdTemplate) ((com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i, 1);
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33205b.setOnClickListener(this);
        this.f33205b.a(this.f33206c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33205b.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33205b = (RadiusPvFrameLayout) b(R.id.ksad_profile_item_root);
    }

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
