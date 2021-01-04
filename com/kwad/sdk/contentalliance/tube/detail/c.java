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
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.contentalliance.tube.a.c<com.kwad.sdk.contentalliance.tube.detail.a.b> {
    private SceneImpl e;
    private TubeDetailParam f;
    private com.kwad.sdk.contentalliance.tube.detail.a.b g;
    private com.kwad.sdk.core.i.a h;

    public static c a(TubeDetailParam tubeDetailParam) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_TUBE_DETAIL_PARAM", tubeDetailParam);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    private void a(LayoutInflater layoutInflater) {
        ((ViewGroup) this.c.findViewById(R.id.ksad_tube_fragment_loading)).addView(layoutInflater.inflate(R.layout.ksad_tube_fragment_loading_layout, (ViewGroup) null, false));
    }

    private boolean g() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_TUBE_DETAIL_PARAM");
        if (serializable instanceof TubeDetailParam) {
            this.f = (TubeDetailParam) serializable;
            this.e = new SceneImpl(this.f.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 6);
            uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f.getTubeId());
            this.e.setUrlPackage(uRLPackage);
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.contentalliance.b
    protected int b() {
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
    protected int e() {
        return R.id.ksad_tube_recycler_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: f */
    public com.kwad.sdk.contentalliance.tube.detail.a.b c() {
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = new com.kwad.sdk.contentalliance.tube.detail.a.b();
        bVar.f9222a = this;
        this.h = new com.kwad.sdk.core.i.a(this, this.c, 70);
        this.h.a();
        bVar.c = this.h;
        bVar.f9223b = this.f;
        bVar.f = this.e;
        return bVar;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        a(layoutInflater);
        return this.c;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        if (this.g != null) {
            this.g.a();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        if (this.h != null) {
            this.h.d();
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        if (!g() && getActivity() != null) {
            getActivity().finish();
            return;
        }
        super.onViewCreated(view, bundle);
        this.g = c();
    }
}
