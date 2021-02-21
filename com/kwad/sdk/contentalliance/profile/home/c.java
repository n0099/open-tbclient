package com.kwad.sdk.contentalliance.profile.home;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.c.e;
import com.kwad.sdk.contentalliance.profile.home.c.f;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.a.a;
import com.kwad.sdk.lib.a.d;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends d implements a.InterfaceC1138a {
    private SceneImpl i;
    private ProfileHomeParam j;
    private com.kwad.sdk.contentalliance.profile.home.b.b k;
    private com.kwad.sdk.lib.a.a l;
    private com.kwad.sdk.core.i.a m;

    public static c a(ProfileHomeParam profileHomeParam) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_PROFILE_HOME_PARAM", profileHomeParam);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    private boolean k() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_PROFILE_HOME_PARAM");
        if (serializable instanceof ProfileHomeParam) {
            this.j = (ProfileHomeParam) serializable;
            this.i = new SceneImpl(this.j.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 3);
            uRLPackage.putParams(URLPackage.KEY_AUTHOR_ID, this.j.mAuthorId);
            this.i.setUrlPackage(uRLPackage);
            return true;
        }
        return false;
    }

    private com.kwad.sdk.contentalliance.profile.home.b.b l() {
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = new com.kwad.sdk.contentalliance.profile.home.b.b();
        bVar.f8781a = this;
        bVar.f8782b = this.i;
        bVar.c = this.c;
        this.m = new com.kwad.sdk.core.i.a(this, this.f10418a, 70);
        this.m.a();
        bVar.e = this.m;
        bVar.d = this.j;
        return bVar;
    }

    @Override // com.kwad.sdk.lib.a.d
    protected int a() {
        return R.layout.ksad_profile_fragment_home;
    }

    @Override // com.kwad.sdk.lib.a.d
    protected int b() {
        return R.id.ksad_tab_strip;
    }

    @Override // com.kwad.sdk.lib.a.d
    protected int c() {
        return R.id.ksad_profile_view_pager;
    }

    @Override // com.kwad.sdk.lib.a.d
    public List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d() {
        return new ArrayList();
    }

    @Override // com.kwad.sdk.lib.a.a.InterfaceC1138a
    @NonNull
    public Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.home.c.d());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.home.c.c());
        presenter.a((Presenter) new f());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.home.c.b());
        presenter.a((Presenter) new e());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.home.c.a());
        return presenter;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        if (this.k != null) {
            this.k.a();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        if (this.m != null) {
            this.m.d();
        }
    }

    @Override // com.kwad.sdk.lib.a.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        if (!k() && getActivity() != null) {
            getActivity().finish();
            return;
        }
        super.onViewCreated(view, bundle);
        this.k = l();
        if (this.l == null) {
            this.l = new com.kwad.sdk.lib.a.a(this, this);
        }
        this.l.a(this.k);
    }
}
