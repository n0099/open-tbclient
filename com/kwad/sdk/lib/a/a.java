package com.kwad.sdk.lib.a;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final KsFragment f35898a;

    /* renamed from: b  reason: collision with root package name */
    public final InterfaceC0423a f35899b;

    /* renamed from: c  reason: collision with root package name */
    public Presenter f35900c;

    /* renamed from: com.kwad.sdk.lib.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0423a {
        @NonNull
        Presenter e();
    }

    public a(KsFragment ksFragment, InterfaceC0423a interfaceC0423a) {
        this.f35898a = ksFragment;
        this.f35899b = interfaceC0423a;
        KsFragmentManager fragmentManager = ksFragment.getFragmentManager();
        if (fragmentManager != null) {
            a(fragmentManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f35900c == null) {
            Presenter e2 = this.f35899b.e();
            this.f35900c = e2;
            e2.a(this.f35898a.getView());
        }
    }

    private void a(@NonNull KsFragmentManager ksFragmentManager) {
        ksFragmentManager.registerFragmentLifecycleCallbacks(new KsFragmentManager.FragmentLifecycleCallbacks() { // from class: com.kwad.sdk.lib.a.a.1
            @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
            public void onFragmentDestroyed(KsFragmentManager ksFragmentManager2, KsFragment ksFragment) {
                super.onFragmentDestroyed(ksFragmentManager2, ksFragment);
                if (ksFragment == a.this.f35898a) {
                    ksFragmentManager2.unregisterFragmentLifecycleCallbacks(this);
                }
            }

            @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(KsFragmentManager ksFragmentManager2, KsFragment ksFragment, View view, Bundle bundle) {
                super.onFragmentViewCreated(ksFragmentManager2, ksFragment, view, bundle);
                if (ksFragment == a.this.f35898a) {
                    a.this.a();
                }
            }

            @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewDestroyed(KsFragmentManager ksFragmentManager2, KsFragment ksFragment) {
                super.onFragmentViewDestroyed(ksFragmentManager2, ksFragment);
                if (ksFragment == a.this.f35898a) {
                    a.this.b();
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Presenter presenter = this.f35900c;
        if (presenter != null) {
            presenter.j();
            this.f35900c = null;
        }
    }

    public void a(Object obj) {
        a();
        this.f35900c.a(obj);
    }
}
