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
    public View f36737a;

    /* renamed from: b  reason: collision with root package name */
    public PagerSlidingTabStrip f36738b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f36739c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.viewpager.tabstrip.a f36740d;

    /* renamed from: e  reason: collision with root package name */
    public int f36741e;

    /* renamed from: f  reason: collision with root package name */
    public int f36742f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f36743g = null;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f36744h = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.lib.a.d.1

        /* renamed from: b  reason: collision with root package name */
        public boolean f36747b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36748c;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (d.this.j()) {
                if (i2 == 0 && this.f36748c && this.f36747b) {
                    d dVar = d.this;
                    dVar.a(dVar.g());
                    this.f36747b = false;
                    this.f36748c = false;
                } else if (i2 == 2) {
                    this.f36747b = true;
                }
            }
            if (d.this.f36745i != null) {
                d.this.f36745i.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (d.this.f36745i != null) {
                d.this.f36745i.onPageScrolled(i2, f2, i3);
            }
            this.f36747b = true;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            this.f36748c = true;
            if (!this.f36747b || !d.this.j()) {
                d.this.a(i2);
            }
            if (d.this.f36745i != null) {
                d.this.f36745i.onPageSelected(i2);
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f36745i;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        int i3;
        com.kwad.sdk.lib.widget.viewpager.tabstrip.a aVar = this.f36740d;
        if (aVar == null || i2 == (i3 = this.f36741e)) {
            return;
        }
        aVar.a(i3);
        this.f36740d.a(i2);
        this.f36741e = i2;
    }

    private String b(int i2) {
        return this.f36740d.c(i2);
    }

    private int e() {
        int a2;
        if (h() == null || this.f36740d == null || (a2 = a(h())) < 0) {
            return 0;
        }
        return a2;
    }

    public abstract int a();

    public int a(String str) {
        return this.f36740d.a(str);
    }

    public void a(int i2, Bundle bundle) {
        a(i2, bundle, false);
    }

    public void a(int i2, Bundle bundle, boolean z) {
        this.f36740d.a(i2, bundle);
        this.f36739c.setCurrentItem(i2, z);
    }

    public void a(List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> list) {
        this.f36740d.a(list);
        this.f36738b.c();
    }

    public abstract int b();

    public abstract int c();

    public abstract List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d();

    public boolean f() {
        return true;
    }

    public int g() {
        ViewPager viewPager = this.f36739c;
        return viewPager != null ? viewPager.getCurrentItem() : e();
    }

    public String h() {
        if (TextUtils.isEmpty(this.f36743g)) {
            int i2 = this.f36742f;
            return i2 >= 0 ? b(i2) : i();
        }
        return this.f36743g;
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
        this.f36737a = inflate;
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
        this.f36738b = (PagerSlidingTabStrip) this.f36737a.findViewById(b());
        this.f36739c = (ViewPager) this.f36737a.findViewById(c());
        this.f36740d = new com.kwad.sdk.lib.widget.viewpager.tabstrip.a(getActivity(), getChildFragmentManager());
        List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d2 = d();
        this.f36739c.setAdapter(this.f36740d);
        if (d2 != null && !d2.isEmpty()) {
            this.f36740d.a(d2);
            this.f36741e = e();
            if (getArguments() == null || !getArguments().containsKey("last_selected_item_pos")) {
                viewPager = this.f36739c;
                i2 = this.f36741e;
            } else {
                viewPager = this.f36739c;
                i2 = getArguments().getInt("last_selected_item_pos");
            }
            viewPager.setCurrentItem(i2, false);
        }
        this.f36738b.setViewPager(this.f36739c);
        this.f36738b.setOnPageChangeListener(this.f36744h);
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
