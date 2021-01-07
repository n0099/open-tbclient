package com.kwad.sdk.contentalliance.profile.tabvideo;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.lib.a.c<AdResultData, AdTemplate> {
    private SceneImpl d;
    private ProfileTabVideoParam e;

    private boolean k() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_PROFILE_TAB_VIDEO_PARAM");
        if (serializable instanceof ProfileTabVideoParam) {
            this.e = (ProfileTabVideoParam) serializable;
            if (this.e.isValid()) {
                this.d = new SceneImpl(this.e.mEntryScene);
                this.d.setUrlPackage(this.e.mURLPackage);
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.lib.a.c
    protected int a() {
        return R.layout.ksad_profile_fragment_tab_video;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: a */
    public RecyclerView.ItemDecoration b(AdResultData adResultData) {
        return new a(3, ao.a(getContext(), 2.0f), ao.a(getContext(), 2.0f));
    }

    @Override // com.kwad.sdk.lib.a.c
    protected void a(@NonNull Presenter presenter) {
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.b.a());
    }

    @Override // com.kwad.sdk.lib.a.c
    protected int b() {
        return R.id.ksad_recycler_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: b */
    public RecyclerView.LayoutManager a(AdResultData adResultData) {
        return new StaggeredGridLayoutManager(3, 1);
    }

    @Override // com.kwad.sdk.lib.a.c
    protected com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> c() {
        return new d(this.d, this.e);
    }

    @Override // com.kwad.sdk.lib.a.c
    protected com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> d() {
        return new b(this, this.f10715b, this.e);
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        Activity activity;
        if (k() || (activity = getActivity()) == null) {
            super.onCreate(bundle);
        } else {
            activity.finish();
        }
    }
}
