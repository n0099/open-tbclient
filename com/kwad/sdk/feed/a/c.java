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
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.lib.a.c<AdResultData, AdTemplate> {

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.feed.a.b.b f34857d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f34858e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34859f;

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
            SceneImpl sceneImpl = new SceneImpl((KsScene) serializable);
            this.f34858e = sceneImpl;
            sceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 11));
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.lib.a.c
    public int a() {
        return R.layout.ksad_content_feed_home_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: a */
    public RecyclerView.ItemDecoration b(AdResultData adResultData) {
        int a2;
        int a3;
        com.kwad.sdk.contentalliance.profile.tabvideo.a aVar;
        RecyclerView.ItemDecoration itemDecoration;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35929b.getLayoutParams();
        int i = adResultData.pageInfo.pageType;
        if (i == 2) {
            a2 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_small_horizontal_padding);
            a3 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_small_vertical_padding);
            aVar = new com.kwad.sdk.contentalliance.profile.tabvideo.a(1, a2, a3);
        } else if (i != 3) {
            int a4 = ao.a(getContext(), R.dimen.ksad_content_feed_item_double_padding);
            itemDecoration = new com.kwad.sdk.contentalliance.detail.photo.related.d(2, a4);
            marginLayoutParams.topMargin = a4;
            marginLayoutParams.leftMargin = a4;
            marginLayoutParams.rightMargin = a4;
            this.f35929b.setLayoutParams(marginLayoutParams);
            return itemDecoration;
        } else {
            a2 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_larger_horizontal_padding);
            a3 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_larger_vertical_padding);
            aVar = new com.kwad.sdk.contentalliance.profile.tabvideo.a(1, a2, a3);
        }
        marginLayoutParams.topMargin = a3;
        marginLayoutParams.leftMargin = a2;
        marginLayoutParams.rightMargin = a2;
        itemDecoration = aVar;
        this.f35929b.setLayoutParams(marginLayoutParams);
        return itemDecoration;
    }

    @Override // com.kwad.sdk.lib.a.c
    public void a(@NonNull Presenter presenter) {
        presenter.a((Presenter) new com.kwad.sdk.feed.a.c.a());
        presenter.a((Presenter) new com.kwad.sdk.feed.a.c.c());
        presenter.a((Presenter) new com.kwad.sdk.feed.a.c.b());
    }

    @Override // com.kwad.sdk.lib.a.c
    public int b() {
        return R.id.ksad_recycler_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: b */
    public RecyclerView.LayoutManager a(AdResultData adResultData) {
        int i = adResultData.pageInfo.pageType;
        return (i == 2 || i == 3) ? new LinearLayoutManager(getContext()) : new StaggeredGridLayoutManager(2, 1);
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> c() {
        return new d(this.f34858e);
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> d() {
        return new b(this, this.f35929b, this.f34857d);
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.a.a.b<AdResultData, AdTemplate> f() {
        com.kwad.sdk.feed.a.b.b bVar = new com.kwad.sdk.feed.a.b.b();
        this.f34857d = bVar;
        bVar.f34854a = this.f34858e;
        com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f35928a, 70);
        this.f34859f = aVar;
        aVar.a();
        com.kwad.sdk.feed.a.b.b bVar2 = this.f34857d;
        bVar2.f34855b = this.f34859f;
        return bVar2;
    }

    @Override // com.kwad.sdk.lib.a.c
    public boolean g() {
        return true;
    }

    @Override // com.kwad.sdk.lib.a.c
    public int h() {
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
        com.kwad.sdk.core.i.a aVar = this.f34859f;
        if (aVar != null) {
            aVar.f();
        }
        a.a().e();
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        com.kwad.sdk.core.i.a aVar = this.f34859f;
        if (aVar != null) {
            aVar.d();
        }
    }
}
