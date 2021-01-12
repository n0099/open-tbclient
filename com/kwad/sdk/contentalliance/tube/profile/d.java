package com.kwad.sdk.contentalliance.tube.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.profile.b.f;
import com.kwad.sdk.contentalliance.tube.profile.b.g;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class d extends com.kwad.sdk.contentalliance.tube.a.c<com.kwad.sdk.contentalliance.tube.profile.a.b> {
    private SceneImpl e;
    private TubeProfileParam f;
    private com.kwad.sdk.contentalliance.tube.profile.a.b g;
    private com.kwad.sdk.core.i.a h;

    public static d a(TubeProfileParam tubeProfileParam) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_TUBE_HOME_PARAM", tubeProfileParam);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    private void a(LayoutInflater layoutInflater) {
        ((ViewGroup) this.c.findViewById(R.id.ksad_tube_fragment_loading)).addView(layoutInflater.inflate(R.layout.ksad_tube_fragment_loading_layout, (ViewGroup) null, false));
    }

    private boolean g() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_TUBE_HOME_PARAM");
        if (serializable instanceof TubeProfileParam) {
            this.f = (TubeProfileParam) serializable;
            this.e = new SceneImpl(this.f.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 7);
            uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f.getTubeId());
            this.e.setUrlPackage(uRLPackage);
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.contentalliance.b
    protected int b() {
        return R.layout.ksad_tube_fragment_home;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public Presenter d() {
        com.kwad.sdk.core.d.a.a("TubeProfileFragment", "onCreatePresenter()");
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.d());
        presenter.a((Presenter) new f());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.b());
        presenter.a((Presenter) new g());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.e());
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
    public com.kwad.sdk.contentalliance.tube.profile.a.b c() {
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = new com.kwad.sdk.contentalliance.tube.profile.a.b();
        bVar.f8954a = this;
        this.h = new com.kwad.sdk.core.i.a(this, this.c, 70);
        this.h.a();
        bVar.d = this.h;
        bVar.c = this.f;
        bVar.f = this.e;
        bVar.f8955b = this.d;
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
