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
/* loaded from: classes3.dex */
public abstract class d extends KsFragment {

    /* renamed from: a  reason: collision with root package name */
    protected View f6871a;
    protected PagerSlidingTabStrip b;
    protected ViewPager c;
    protected com.kwad.sdk.lib.widget.viewpager.tabstrip.a d;
    protected int e;
    protected int f = -1;
    public String g = null;
    protected ViewPager.OnPageChangeListener h = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.lib.a.d.1
        private boolean b;
        private boolean c;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (d.this.j()) {
                if (i == 0 && this.c && this.b) {
                    d.this.a(d.this.g());
                    this.b = false;
                    this.c = false;
                } else if (i == 2) {
                    this.b = true;
                }
            }
            if (d.this.i != null) {
                d.this.i.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (d.this.i != null) {
                d.this.i.onPageScrolled(i, f, i2);
            }
            this.b = true;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            this.c = true;
            if (!this.b || !d.this.j()) {
                d.this.a(i);
            }
            if (d.this.i != null) {
                d.this.i.onPageSelected(i);
            }
        }
    };
    private ViewPager.OnPageChangeListener i;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.d == null || i == this.e) {
            return;
        }
        this.d.a(this.e);
        this.d.a(i);
        this.e = i;
    }

    private String b(int i) {
        return this.d.c(i);
    }

    private int e() {
        int a2;
        if (h() == null || this.d == null || (a2 = a(h())) < 0) {
            return 0;
        }
        return a2;
    }

    protected abstract int a();

    protected int a(String str) {
        return this.d.a(str);
    }

    public void a(int i, Bundle bundle) {
        a(i, bundle, false);
    }

    public void a(int i, Bundle bundle, boolean z) {
        this.d.a(i, bundle);
        this.c.setCurrentItem(i, z);
    }

    public void a(List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> list) {
        this.d.a(list);
        this.b.c();
    }

    protected abstract int b();

    protected abstract int c();

    public abstract List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d();

    protected boolean f() {
        return true;
    }

    public int g() {
        return this.c != null ? this.c.getCurrentItem() : e();
    }

    public String h() {
        return !TextUtils.isEmpty(this.g) ? this.g : this.f >= 0 ? b(this.f) : i();
    }

    protected String i() {
        return "";
    }

    protected boolean j() {
        return false;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6871a = layoutInflater.inflate(a(), viewGroup, false);
        return this.f6871a;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt("last_selected_item_pos", g());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.b = (PagerSlidingTabStrip) this.f6871a.findViewById(b());
        this.c = (ViewPager) this.f6871a.findViewById(c());
        this.d = new com.kwad.sdk.lib.widget.viewpager.tabstrip.a(getActivity(), getChildFragmentManager());
        List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d = d();
        this.c.setAdapter(this.d);
        if (d != null && !d.isEmpty()) {
            this.d.a(d);
            this.e = e();
            if (getArguments() == null || !getArguments().containsKey("last_selected_item_pos")) {
                this.c.setCurrentItem(this.e, false);
            } else {
                this.c.setCurrentItem(getArguments().getInt("last_selected_item_pos"), false);
            }
        }
        this.b.setViewPager(this.c);
        this.b.setOnPageChangeListener(this.h);
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
