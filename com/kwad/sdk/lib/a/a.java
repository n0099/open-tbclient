package com.kwad.sdk.lib.a;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final KsFragment f10702a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC1149a f10703b;
    private Presenter c;

    /* renamed from: com.kwad.sdk.lib.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1149a {
        @NonNull
        Presenter e();
    }

    public a(KsFragment ksFragment, InterfaceC1149a interfaceC1149a) {
        this.f10702a = ksFragment;
        this.f10703b = interfaceC1149a;
        KsFragmentManager fragmentManager = ksFragment.getFragmentManager();
        if (fragmentManager != null) {
            a(fragmentManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.c == null) {
            this.c = this.f10703b.e();
            this.c.a(this.f10702a.getView());
        }
    }

    private void a(@NonNull KsFragmentManager ksFragmentManager) {
        ksFragmentManager.registerFragmentLifecycleCallbacks(new KsFragmentManager.FragmentLifecycleCallbacks() { // from class: com.kwad.sdk.lib.a.a.1
            @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
            public void onFragmentDestroyed(KsFragmentManager ksFragmentManager2, KsFragment ksFragment) {
                super.onFragmentDestroyed(ksFragmentManager2, ksFragment);
                if (ksFragment == a.this.f10702a) {
                    ksFragmentManager2.unregisterFragmentLifecycleCallbacks(this);
                }
            }

            @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(KsFragmentManager ksFragmentManager2, KsFragment ksFragment, View view, Bundle bundle) {
                super.onFragmentViewCreated(ksFragmentManager2, ksFragment, view, bundle);
                if (ksFragment == a.this.f10702a) {
                    a.this.a();
                }
            }

            @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewDestroyed(KsFragmentManager ksFragmentManager2, KsFragment ksFragment) {
                super.onFragmentViewDestroyed(ksFragmentManager2, ksFragment);
                if (ksFragment == a.this.f10702a) {
                    a.this.b();
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
    }

    public void a(Object obj) {
        a();
        this.c.a(obj);
    }
}
