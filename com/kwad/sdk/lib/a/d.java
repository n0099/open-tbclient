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
/* loaded from: classes7.dex */
public abstract class d extends KsFragment {

    /* renamed from: a  reason: collision with root package name */
    public View f36639a;

    /* renamed from: b  reason: collision with root package name */
    public PagerSlidingTabStrip f36640b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f36641c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.viewpager.tabstrip.a f36642d;

    /* renamed from: e  reason: collision with root package name */
    public int f36643e;

    /* renamed from: f  reason: collision with root package name */
    public int f36644f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f36645g = null;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f36646h = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.lib.a.d.1

        /* renamed from: b  reason: collision with root package name */
        public boolean f36649b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36650c;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (d.this.j()) {
                if (i2 == 0 && this.f36650c && this.f36649b) {
                    d dVar = d.this;
                    dVar.a(dVar.g());
                    this.f36649b = false;
                    this.f36650c = false;
                } else if (i2 == 2) {
                    this.f36649b = true;
                }
            }
            if (d.this.f36647i != null) {
                d.this.f36647i.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (d.this.f36647i != null) {
                d.this.f36647i.onPageScrolled(i2, f2, i3);
            }
            this.f36649b = true;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            this.f36650c = true;
            if (!this.f36649b || !d.this.j()) {
                d.this.a(i2);
            }
            if (d.this.f36647i != null) {
                d.this.f36647i.onPageSelected(i2);
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f36647i;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        int i3;
        com.kwad.sdk.lib.widget.viewpager.tabstrip.a aVar = this.f36642d;
        if (aVar == null || i2 == (i3 = this.f36643e)) {
            return;
        }
        aVar.a(i3);
        this.f36642d.a(i2);
        this.f36643e = i2;
    }

    private String b(int i2) {
        return this.f36642d.c(i2);
    }

    private int e() {
        int a2;
        if (h() == null || this.f36642d == null || (a2 = a(h())) < 0) {
            return 0;
        }
        return a2;
    }

    public abstract int a();

    public int a(String str) {
        return this.f36642d.a(str);
    }

    public void a(int i2, Bundle bundle) {
        a(i2, bundle, false);
    }

    public void a(int i2, Bundle bundle, boolean z) {
        this.f36642d.a(i2, bundle);
        this.f36641c.setCurrentItem(i2, z);
    }

    public void a(List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> list) {
        this.f36642d.a(list);
        this.f36640b.c();
    }

    public abstract int b();

    public abstract int c();

    public abstract List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d();

    public boolean f() {
        return true;
    }

    public int g() {
        ViewPager viewPager = this.f36641c;
        return viewPager != null ? viewPager.getCurrentItem() : e();
    }

    public String h() {
        if (TextUtils.isEmpty(this.f36645g)) {
            int i2 = this.f36644f;
            return i2 >= 0 ? b(i2) : i();
        }
        return this.f36645g;
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
        this.f36639a = inflate;
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
        int i2;
        super.onViewCreated(view, bundle);
        this.f36640b = (PagerSlidingTabStrip) this.f36639a.findViewById(b());
        this.f36641c = (ViewPager) this.f36639a.findViewById(c());
        this.f36642d = new com.kwad.sdk.lib.widget.viewpager.tabstrip.a(getActivity(), getChildFragmentManager());
        List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d2 = d();
        this.f36641c.setAdapter(this.f36642d);
        if (d2 != null && !d2.isEmpty()) {
            this.f36642d.a(d2);
            this.f36643e = e();
            if (getArguments() == null || !getArguments().containsKey("last_selected_item_pos")) {
                viewPager = this.f36641c;
                i2 = this.f36643e;
            } else {
                viewPager = this.f36641c;
                i2 = getArguments().getInt("last_selected_item_pos");
            }
            viewPager.setCurrentItem(i2, false);
        }
        this.f36640b.setViewPager(this.f36641c);
        this.f36640b.setOnPageChangeListener(this.f36646h);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewStateRestored(@Nullable Bundle bundle) {
        int i2;
        if (bundle != null && (i2 = bundle.getInt("last_selected_item_pos", -1)) != -1) {
            a(i2, f() ? bundle : null);
        }
        super.onViewStateRestored(bundle);
    }
}
