package com.kwad.sdk.contentalliance.detail.photo.related.b;

import android.view.View;
import com.kwad.sdk.contentalliance.related.RelatedVideoDetailParam;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.photo.related.a.a implements View.OnClickListener {
    private void e() {
        SceneImpl sceneImpl = ((AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).i).mAdScene;
        if (sceneImpl == null) {
            return;
        }
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().a(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).f36004f.g());
        RelatedVideoDetailParam relatedVideoDetailParam = new RelatedVideoDetailParam();
        relatedVideoDetailParam.mEntryScene = sceneImpl.entryScene;
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a;
        relatedVideoDetailParam.mSelectedPosition = ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) callercontext).f36006h;
        relatedVideoDetailParam.mSourcePhotoId = String.valueOf(com.kwad.sdk.core.response.b.c.z(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) callercontext).f32479a));
        com.kwad.sdk.contentalliance.related.a.a(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).f36002d, 1000, relatedVideoDetailParam);
    }

    private void f() {
        e.a((AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).i, 1, "related_video_list");
    }

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
