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
    public View f36225a;

    /* renamed from: b  reason: collision with root package name */
    public PagerSlidingTabStrip f36226b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f36227c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.viewpager.tabstrip.a f36228d;

    /* renamed from: e  reason: collision with root package name */
    public int f36229e;

    /* renamed from: f  reason: collision with root package name */
    public int f36230f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f36231g = null;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f36232h = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.lib.a.d.1

        /* renamed from: b  reason: collision with root package name */
        public boolean f36234b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36235c;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (d.this.j()) {
                if (i == 0 && this.f36235c && this.f36234b) {
                    d dVar = d.this;
                    dVar.a(dVar.g());
                    this.f36234b = false;
                    this.f36235c = false;
                } else if (i == 2) {
                    this.f36234b = true;
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
            this.f36234b = true;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            this.f36235c = true;
            if (!this.f36234b || !d.this.j()) {
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
        com.kwad.sdk.lib.widget.viewpager.tabstrip.a aVar = this.f36228d;
        if (aVar == null || i == (i2 = this.f36229e)) {
            return;
        }
        aVar.a(i2);
        this.f36228d.a(i);
        this.f36229e = i;
    }

    private String b(int i) {
        return this.f36228d.c(i);
    }

    private int e() {
        int a2;
        if (h() == null || this.f36228d == null || (a2 = a(h())) < 0) {
            return 0;
        }
        return a2;
    }

    public abstract int a();

    public int a(String str) {
        return this.f36228d.a(str);
    }

    public void a(int i, Bundle bundle) {
        a(i, bundle, false);
    }

    public void a(int i, Bundle bundle, boolean z) {
        this.f36228d.a(i, bundle);
        this.f36227c.setCurrentItem(i, z);
    }

    public void a(List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> list) {
        this.f36228d.a(list);
        this.f36226b.c();
    }

    public abstract int b();

    public abstract int c();

    public abstract List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d();

    public boolean f() {
        return true;
    }

    public int g() {
        ViewPager viewPager = this.f36227c;
        return viewPager != null ? viewPager.getCurrentItem() : e();
    }

    public String h() {
        if (TextUtils.isEmpty(this.f36231g)) {
            int i = this.f36230f;
            return i >= 0 ? b(i) : i();
        }
        return this.f36231g;
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
        this.f36225a = inflate;
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
        this.f36226b = (PagerSlidingTabStrip) this.f36225a.findViewById(b());
        this.f36227c = (ViewPager) this.f36225a.findViewById(c());
        this.f36228d = new com.kwad.sdk.lib.widget.viewpager.tabstrip.a(getActivity(), getChildFragmentManager());
        List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d2 = d();
        this.f36227c.setAdapter(this.f36228d);
        if (d2 != null && !d2.isEmpty()) {
            this.f36228d.a(d2);
            this.f36229e = e();
            if (getArguments() == null || !getArguments().containsKey("last_selected_item_pos")) {
                viewPager = this.f36227c;
                i = this.f36229e;
            } else {
                viewPager = this.f36227c;
                i = getArguments().getInt("last_selected_item_pos");
            }
            viewPager.setCurrentItem(i, false);
        }
        this.f36226b.setViewPager(this.f36227c);
        this.f36226b.setOnPageChangeListener(this.f36232h);
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
