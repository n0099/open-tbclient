package com.kwad.sdk.feed.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.lib.a.c<AdResultData, AdTemplate> {
    private com.kwad.sdk.feed.a.b.b d;
    private SceneImpl e;
    private com.kwad.sdk.core.i.a f;

    public static c a(KsScene ksScene) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_KS_SCENE", ksScene);
        cVar.setArguments(bundle);
        return cVar;
    }

    private boolean k() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_KS_SCENE");
        if (serializable instanceof KsScene) {
            this.e = new SceneImpl((KsScene) serializable);
            this.e.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 11));
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.lib.a.c
    protected int a() {
        return R.layout.ksad_content_feed_home_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: a */
    public RecyclerView.ItemDecoration b(AdResultData adResultData) {
        RecyclerView.ItemDecoration aVar;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
        switch (adResultData.pageInfo.pageType) {
            case 2:
                int a2 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_small_horizontal_padding);
                int a3 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_small_vertical_padding);
                aVar = new com.kwad.sdk.contentalliance.profile.tabvideo.a(1, a2, a3);
                marginLayoutParams.topMargin = a3;
                marginLayoutParams.leftMargin = a2;
                marginLayoutParams.rightMargin = a2;
                break;
            case 3:
                int a4 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_larger_horizontal_padding);
                int a5 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_larger_vertical_padding);
                aVar = new com.kwad.sdk.contentalliance.profile.tabvideo.a(1, a4, a5);
                marginLayoutParams.topMargin = a5;
                marginLayoutParams.leftMargin = a4;
                marginLayoutParams.rightMargin = a4;
                break;
            default:
                int a6 = ao.a(getContext(), R.dimen.ksad_content_feed_item_double_padding);
                aVar = new com.kwad.sdk.contentalliance.detail.photo.related.d(2, a6);
                marginLayoutParams.topMargin = a6;
                marginLayoutParams.leftMargin = a6;
                marginLayoutParams.rightMargin = a6;
                break;
        }
        this.b.setLayoutParams(marginLayoutParams);
        return aVar;
    }

    @Override // com.kwad.sdk.lib.a.c
    protected void a(@NonNull Presenter presenter) {
        presenter.a((Presenter) new com.kwad.sdk.feed.a.c.a());
        presenter.a((Presenter) new com.kwad.sdk.feed.a.c.c());
        presenter.a((Presenter) new com.kwad.sdk.feed.a.c.b());
    }

    @Override // com.kwad.sdk.lib.a.c
    protected int b() {
        return R.id.ksad_recycler_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: b */
    public RecyclerView.LayoutManager a(AdResultData adResultData) {
        switch (adResultData.pageInfo.pageType) {
            case 2:
            case 3:
                return new LinearLayoutManager(getContext());
            default:
                return new StaggeredGridLayoutManager(2, 1);
        }
    }

    @Override // com.kwad.sdk.lib.a.c
    protected com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> c() {
        return new d(this.e);
    }

    @Override // com.kwad.sdk.lib.a.c
    protected com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> d() {
        return new b(this, this.b, this.d);
    }

    @Override // com.kwad.sdk.lib.a.c
    protected com.kwad.sdk.lib.a.a.b<AdResultData, AdTemplate> f() {
        this.d = new com.kwad.sdk.feed.a.b.b();
        this.d.f6506a = this.e;
        this.f = new com.kwad.sdk.core.i.a(this, this.f6870a, 70);
        this.f.a();
        this.d.b = this.f;
        return this.d;
    }

    @Override // com.kwad.sdk.lib.a.c
    protected boolean g() {
        return true;
    }

    @Override // com.kwad.sdk.lib.a.c
    protected int h() {
        return 6;
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

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f != null) {
            this.f.f();
        }
        a.a().e();
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        if (this.f != null) {
            this.f.d();
        }
    }
}
