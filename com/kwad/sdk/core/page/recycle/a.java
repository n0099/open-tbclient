package com.kwad.sdk.core.page.recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
/* loaded from: classes5.dex */
public abstract class a extends KsFragment {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f9651a;

    /* renamed from: b  reason: collision with root package name */
    private d f9652b;

    private void a() {
        this.f9651a.setAdapter(this.f9652b);
    }

    protected View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(b(), viewGroup, false);
    }

    protected abstract d a(RecyclerView recyclerView);

    public abstract int b();

    protected void c() {
        this.f9651a.setItemAnimator(null);
        this.f9651a.setLayoutManager(e());
        this.f9652b = a(this.f9651a);
    }

    public RecyclerView d() {
        return this.f9651a;
    }

    protected RecyclerView.LayoutManager e() {
        return new LinearLayoutManager(getContext());
    }

    protected int f() {
        return R.id.ksad_recycler_view;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @CallSuper
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a2 = a(layoutInflater, viewGroup, bundle);
        this.f9651a = (RecyclerView) a2.findViewById(f());
        return a2;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (this.f9651a != null) {
            this.f9651a.setAdapter(null);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        this.f9651a.clearOnChildAttachStateChangeListeners();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        c();
        a();
    }
}
