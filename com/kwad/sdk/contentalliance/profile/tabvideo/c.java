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
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.lib.a.c<AdResultData, AdTemplate> {

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f33316d;

    /* renamed from: e  reason: collision with root package name */
    public ProfileTabVideoParam f33317e;

    private boolean k() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_PROFILE_TAB_VIDEO_PARAM");
        if (serializable instanceof ProfileTabVideoParam) {
            ProfileTabVideoParam profileTabVideoParam = (ProfileTabVideoParam) serializable;
            this.f33317e = profileTabVideoParam;
            if (profileTabVideoParam.isValid()) {
                SceneImpl sceneImpl = new SceneImpl(this.f33317e.mEntryScene);
                this.f33316d = sceneImpl;
                sceneImpl.setUrlPackage(this.f33317e.mURLPackage);
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.lib.a.c
    public int a() {
        return R.layout.ksad_profile_fragment_tab_video;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: a */
    public RecyclerView.ItemDecoration b(AdResultData adResultData) {
        return new a(3, ao.a(getContext(), 2.0f), ao.a(getContext(), 2.0f));
    }

    @Override // com.kwad.sdk.lib.a.c
    public void a(@NonNull Presenter presenter) {
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.b.a());
    }

    @Override // com.kwad.sdk.lib.a.c
    public int b() {
        return R.id.ksad_recycler_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: b */
    public RecyclerView.LayoutManager a(AdResultData adResultData) {
        return new StaggeredGridLayoutManager(3, 1);
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> c() {
        return new d(this.f33316d, this.f33317e);
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> d() {
        return new b(this, this.f36314b, this.f33317e);
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
