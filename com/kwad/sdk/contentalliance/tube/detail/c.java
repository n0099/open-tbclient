package com.kwad.sdk.contentalliance.tube.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.detail.b.d;
import com.kwad.sdk.contentalliance.tube.detail.b.e;
import com.kwad.sdk.contentalliance.tube.detail.b.f;
import com.kwad.sdk.contentalliance.tube.detail.b.g;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.tube.a.c<com.kwad.sdk.contentalliance.tube.detail.a.b> {

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33835e;

    /* renamed from: f  reason: collision with root package name */
    public TubeDetailParam f33836f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.detail.a.b f33837g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33838h;

    public static c a(TubeDetailParam tubeDetailParam) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_TUBE_DETAIL_PARAM", tubeDetailParam);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    private void a(LayoutInflater layoutInflater) {
        ((ViewGroup) this.f32433c.findViewById(R.id.ksad_tube_fragment_loading)).addView(layoutInflater.inflate(R.layout.ksad_tube_fragment_loading_layout, (ViewGroup) null, false));
    }

    private boolean g() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_TUBE_DETAIL_PARAM");
        if (serializable instanceof TubeDetailParam) {
            TubeDetailParam tubeDetailParam = (TubeDetailParam) serializable;
            this.f33836f = tubeDetailParam;
            this.f33835e = new SceneImpl(tubeDetailParam.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 6);
            uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f33836f.getTubeId());
            this.f33835e.setUrlPackage(uRLPackage);
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int b() {
        return R.layout.ksad_tube_fragment_detail;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public Presenter d() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new d());
        presenter.a((Presenter) new e());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.detail.b.b());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.detail.b.c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.detail.b.a());
        presenter.a((Presenter) new g());
        presenter.a((Presenter) new f());
        return presenter;
    }

    @Override // com.kwad.sdk.contentalliance.tube.a.c
    public int e() {
        return R.id.ksad_tube_recycler_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: f */
    public com.kwad.sdk.contentalliance.tube.detail.a.b c() {
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = new com.kwad.sdk.contentalliance.tube.detail.a.b();
        bVar.f33769a = this;
        com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f32433c, 70);
        this.f33838h = aVar;
        aVar.a();
        bVar.f33771c = this.f33838h;
        bVar.f33770b = this.f33836f;
        bVar.f33774f = this.f33835e;
        return bVar;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        a(layoutInflater);
        return this.f32433c;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = this.f33837g;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        com.kwad.sdk.core.i.a aVar = this.f33838h;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        if (!g() && getActivity() != null) {
            getActivity().finish();
            return;
        }
        super.onViewCreated(view, bundle);
        this.f33837g = c();
    }
}
