package com.kwad.sdk.glide.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class n extends KsFragment {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.c.a f9957a;

    /* renamed from: b  reason: collision with root package name */
    private final l f9958b;
    private final Set<n> c;
    @Nullable
    private n d;
    @Nullable
    private com.kwad.sdk.glide.g e;
    @Nullable
    private KsFragment f;

    /* loaded from: classes3.dex */
    private static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<n> f9959a;

        a(n nVar) {
            this.f9959a = new WeakReference<>(nVar);
        }

        public String toString() {
            return super.toString() + "{fragment=" + this.f9959a.get() + "}";
        }
    }

    public n() {
        this(new com.kwad.sdk.glide.c.a());
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public n(@NonNull com.kwad.sdk.glide.c.a aVar) {
        this.f9958b = new a(this);
        this.c = new HashSet();
        this.f9957a = aVar;
    }

    private void a(KsFragmentManager ksFragmentManager, @NonNull Activity activity) {
        e();
        this.d = com.kwad.sdk.glide.c.a(getActivity()).g().a(ksFragmentManager, activity);
        if (equals(this.d)) {
            return;
        }
        this.d.a(this);
    }

    private void a(n nVar) {
        this.c.add(nVar);
    }

    private void b(n nVar) {
        this.c.remove(nVar);
    }

    @Nullable
    private KsFragment d() {
        KsFragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f;
    }

    private void e() {
        if (this.d != null) {
            this.d.b(this);
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public com.kwad.sdk.glide.c.a a() {
        return this.f9957a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable KsFragment ksFragment) {
        this.f = ksFragment;
        if (ksFragment == null || ksFragment.getActivity() == null) {
            return;
        }
        a(ksFragment.getFragmentManager(), ksFragment.getActivity());
    }

    public void a(@Nullable com.kwad.sdk.glide.g gVar) {
        this.e = gVar;
    }

    @Nullable
    public com.kwad.sdk.glide.g b() {
        return this.e;
    }

    @NonNull
    public l c() {
        return this.f9958b;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            a(getFragmentManager(), getActivity());
        } catch (IllegalStateException e) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        this.f9957a.c();
        e();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDetach() {
        super.onDetach();
        this.f = null;
        e();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStart() {
        super.onStart();
        this.f9957a.a();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStop() {
        super.onStop();
        this.f9957a.b();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }
}
