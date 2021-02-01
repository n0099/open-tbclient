package com.kwad.sdk.contentalliance.detail.photo.related.b;

import android.view.View;
import com.kwad.sdk.contentalliance.related.RelatedVideoDetailParam;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.detail.photo.related.a.a implements View.OnClickListener {
    private void e() {
        SceneImpl sceneImpl = ((AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10454a).i).mAdScene;
        if (sceneImpl == null) {
            return;
        }
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().a(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10454a).f.g());
        RelatedVideoDetailParam relatedVideoDetailParam = new RelatedVideoDetailParam();
        relatedVideoDetailParam.mEntryScene = sceneImpl.entryScene;
        relatedVideoDetailParam.mSelectedPosition = ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10454a).h;
        relatedVideoDetailParam.mSourcePhotoId = String.valueOf(com.kwad.sdk.core.response.b.c.z(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10454a).f8578a));
        com.kwad.sdk.contentalliance.related.a.a(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10454a).d, 1000, relatedVideoDetailParam);
    }

    private void f() {
        e.a((AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10454a).i, 1, "related_video_list");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        l().setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.a()) {
            return;
        }
        e();
        f();
    }
}
