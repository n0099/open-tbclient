package com.kwad.sdk.lib.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class d extends KsFragment {

    /* renamed from: a  reason: collision with root package name */
    public View f35935a;

    /* renamed from: b  reason: collision with root package name */
    public PagerSlidingTabStrip f35936b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f35937c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.viewpager.tabstrip.a f35938d;

    /* renamed from: e  reason: collision with root package name */
    public int f35939e;

    /* renamed from: f  reason: collision with root package name */
    public int f35940f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f35941g = null;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f35942h = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.lib.a.d.1

        /* renamed from: b  reason: collision with root package name */
        public boolean f35944b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35945c;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (d.this.j()) {
                if (i == 0 && this.f35945c && this.f35944b) {
                    d dVar = d.this;
                    dVar.a(dVar.g());
                    this.f35944b = false;
                    this.f35945c = false;
                } else if (i == 2) {
                    this.f35944b = true;
                }
            }
            if (d.this.i != null) {
                d.this.i.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (d.this.i != null) {
                d.this.i.onPageScrolled(i, f2, i2);
            }
            this.f35944b = true;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            this.f35945c = true;
            if (!this.f35944b || !d.this.j()) {
                d.this.a(i);
            }
            if (d.this.i != null) {
                d.this.i.onPageSelected(i);
            }
        }
    };
    public ViewPager.OnPageChangeListener i;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        int i2;
        com.kwad.sdk.lib.widget.viewpager.tabstrip.a aVar = this.f35938d;
        if (aVar == null || i == (i2 = this.f35939e)) {
            return;
        }
        aVar.a(i2);
        this.f35938d.a(i);
        this.f35939e = i;
    }

    private String b(int i) {
        return this.f35938d.c(i);
    }

    private int e() {
        int a2;
        if (h() == null || this.f35938d == null || (a2 = a(h())) < 0) {
            return 0;
        }
        return a2;
    }

    public abstract int a();

    public int a(String str) {
        return this.f35938d.a(str);
    }

    public void a(int i, Bundle bundle) {
        a(i, bundle, false);
    }

    public void a(int i, Bundle bundle, boolean z) {
        this.f35938d.a(i, bundle);
        this.f35937c.setCurrentItem(i, z);
    }

    public void a(List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> list) {
        this.f35938d.a(list);
        this.f35936b.c();
    }

    public abstract int b();

    public abstract int c();

    public abstract List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d();

    public boolean f() {
        return true;
    }

    public int g() {
        ViewPager viewPager = this.f35937c;
        return viewPager != null ? viewPager.getCurrentItem() : e();
    }

    public String h() {
        if (TextUtils.isEmpty(this.f35941g)) {
            int i = this.f35940f;
            return i >= 0 ? b(i) : i();
        }
        return this.f35941g;
    }

    public String i() {
        return "";
    }

    public boolean j() {
        return false;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a(), viewGroup, false);
        this.f35935a = inflate;
        return inflate;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt("last_selected_item_pos", g());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        ViewPager viewPager;
        int i;
        super.onViewCreated(view, bundle);
        this.f35936b = (PagerSlidingTabStrip) this.f35935a.findViewById(b());
        this.f35937c = (ViewPager) this.f35935a.findViewById(c());
        this.f35938d = new com.kwad.sdk.lib.widget.viewpager.tabstrip.a(getActivity(), getChildFragmentManager());
        List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d2 = d();
        this.f35937c.setAdapter(this.f35938d);
        if (d2 != null && !d2.isEmpty()) {
            this.f35938d.a(d2);
            this.f35939e = e();
            if (getArguments() == null || !getArguments().containsKey("last_selected_item_pos")) {
                viewPager = this.f35937c;
                i = this.f35939e;
            } else {
                viewPager = this.f35937c;
                i = getArguments().getInt("last_selected_item_pos");
            }
            viewPager.setCurrentItem(i, false);
        }
        this.f35936b.setViewPager(this.f35937c);
        this.f35936b.setOnPageChangeListener(this.f35942h);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewStateRestored(@Nullable Bundle bundle) {
        int i;
        if (bundle != null && (i = bundle.getInt("last_selected_item_pos", -1)) != -1) {
            a(i, f() ? bundle : null);
        }
        super.onViewStateRestored(bundle);
    }
}
