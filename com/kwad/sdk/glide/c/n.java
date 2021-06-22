package com.kwad.sdk.glide.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class n extends KsFragment {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.c.a f35893a;

    /* renamed from: b  reason: collision with root package name */
    public final l f35894b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<n> f35895c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public n f35896d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.g f35897e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f35898f;

    /* loaded from: classes7.dex */
    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<n> f35899a;

        public a(n nVar) {
            this.f35899a = new WeakReference<>(nVar);
        }

        public String toString() {
            return super.toString() + "{fragment=" + this.f35899a.get() + "}";
        }
    }

    public n() {
        this(new com.kwad.sdk.glide.c.a());
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public n(@NonNull com.kwad.sdk.glide.c.a aVar) {
        this.f35894b = new a(this);
        this.f35895c = new HashSet();
        this.f35893a = aVar;
    }

    private void a(KsFragmentManager ksFragmentManager, @NonNull Activity activity) {
        e();
        n a2 = com.kwad.sdk.glide.c.a(getActivity()).g().a(ksFragmentManager, activity);
        this.f35896d = a2;
        if (equals(a2)) {
            return;
        }
        this.f35896d.a(this);
    }

    private void a(n nVar) {
        this.f35895c.add(nVar);
    }

    private void b(n nVar) {
        this.f35895c.remove(nVar);
    }

    @Nullable
    private KsFragment d() {
        KsFragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f35898f;
    }

    private void e() {
        n nVar = this.f35896d;
        if (nVar != null) {
            nVar.b(this);
            this.f35896d = null;
        }
    }

    @NonNull
    public com.kwad.sdk.glide.c.a a() {
        return this.f35893a;
    }

    public void a(@Nullable KsFragment ksFragment) {
        this.f35898f = ksFragment;
        if (ksFragment == null || ksFragment.getActivity() == null) {
            return;
        }
        a(ksFragment.getFragmentManager(), ksFragment.getActivity());
    }

    public void a(@Nullable com.kwad.sdk.glide.g gVar) {
        this.f35897e = gVar;
    }

    @Nullable
    public com.kwad.sdk.glide.g b() {
        return this.f35897e;
    }

    @NonNull
    public l c() {
        return this.f35894b;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            a(getFragmentManager(), getActivity());
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(SupportRequestManagerFragment.TAG, 5)) {
                Log.w(SupportRequestManagerFragment.TAG, "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        this.f35893a.c();
        e();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDetach() {
        super.onDetach();
        this.f35898f = null;
        e();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStart() {
        super.onStart();
        this.f35893a.a();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStop() {
        super.onStop();
        this.f35893a.b();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }
}
