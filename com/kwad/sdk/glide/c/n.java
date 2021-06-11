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
    public final com.kwad.sdk.glide.c.a f35795a;

    /* renamed from: b  reason: collision with root package name */
    public final l f35796b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<n> f35797c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public n f35798d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.g f35799e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f35800f;

    /* loaded from: classes7.dex */
    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<n> f35801a;

        public a(n nVar) {
            this.f35801a = new WeakReference<>(nVar);
        }

        public String toString() {
            return super.toString() + "{fragment=" + this.f35801a.get() + "}";
        }
    }

    public n() {
        this(new com.kwad.sdk.glide.c.a());
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public n(@NonNull com.kwad.sdk.glide.c.a aVar) {
        this.f35796b = new a(this);
        this.f35797c = new HashSet();
        this.f35795a = aVar;
    }

    private void a(KsFragmentManager ksFragmentManager, @NonNull Activity activity) {
        e();
        n a2 = com.kwad.sdk.glide.c.a(getActivity()).g().a(ksFragmentManager, activity);
        this.f35798d = a2;
        if (equals(a2)) {
            return;
        }
        this.f35798d.a(this);
    }

    private void a(n nVar) {
        this.f35797c.add(nVar);
    }

    private void b(n nVar) {
        this.f35797c.remove(nVar);
    }

    @Nullable
    private KsFragment d() {
        KsFragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f35800f;
    }

    private void e() {
        n nVar = this.f35798d;
        if (nVar != null) {
            nVar.b(this);
            this.f35798d = null;
        }
    }

    @NonNull
    public com.kwad.sdk.glide.c.a a() {
        return this.f35795a;
    }

    public void a(@Nullable KsFragment ksFragment) {
        this.f35800f = ksFragment;
        if (ksFragment == null || ksFragment.getActivity() == null) {
            return;
        }
        a(ksFragment.getFragmentManager(), ksFragment.getActivity());
    }

    public void a(@Nullable com.kwad.sdk.glide.g gVar) {
        this.f35799e = gVar;
    }

    @Nullable
    public com.kwad.sdk.glide.g b() {
        return this.f35799e;
    }

    @NonNull
    public l c() {
        return this.f35796b;
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
        this.f35795a.c();
        e();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDetach() {
        super.onDetach();
        this.f35800f = null;
        e();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStart() {
        super.onStart();
        this.f35795a.a();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStop() {
        super.onStop();
        this.f35795a.b();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }
}
