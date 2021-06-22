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
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.a.c<com.kwad.sdk.contentalliance.tube.profile.a.b> {

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f34039e;

    /* renamed from: f  reason: collision with root package name */
    public TubeProfileParam f34040f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.a.b f34041g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34042h;

    public static d a(TubeProfileParam tubeProfileParam) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_TUBE_HOME_PARAM", tubeProfileParam);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    private void a(LayoutInflater layoutInflater) {
        ((ViewGroup) this.f32531c.findViewById(R.id.ksad_tube_fragment_loading)).addView(layoutInflater.inflate(R.layout.ksad_tube_fragment_loading_layout, (ViewGroup) null, false));
    }

    private boolean g() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_TUBE_HOME_PARAM");
        if (serializable instanceof TubeProfileParam) {
            TubeProfileParam tubeProfileParam = (TubeProfileParam) serializable;
            this.f34040f = tubeProfileParam;
            this.f34039e = new SceneImpl(tubeProfileParam.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 7);
            uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f34040f.getTubeId());
            this.f34039e.setUrlPackage(uRLPackage);
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int b() {
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
    public int e() {
        return R.id.ksad_tube_recycler_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: f */
    public com.kwad.sdk.contentalliance.tube.profile.a.b c() {
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = new com.kwad.sdk.contentalliance.tube.profile.a.b();
        bVar.f33943a = this;
        com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f32531c, 70);
        this.f34042h = aVar;
        aVar.a();
        bVar.f33946d = this.f34042h;
        bVar.f33945c = this.f34040f;
        bVar.f33948f = this.f34039e;
        bVar.f33944b = this.f33842d;
        return bVar;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        a(layoutInflater);
        return this.f32531c;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = this.f34041g;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        com.kwad.sdk.core.i.a aVar = this.f34042h;
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
        this.f34041g = c();
    }
}
