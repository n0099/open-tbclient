package com.kwad.sdk.contentalliance.b;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.api.core.fragment.KsFragmentTransaction;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a extends PagerAdapter {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final KsFragmentManager f32434a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32436c;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<List<KsFragment>> f32437f = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public KsFragmentTransaction f32435b = null;

    /* renamed from: g  reason: collision with root package name */
    public KsFragment f32438g = null;

    public a(@NonNull KsFragmentManager ksFragmentManager) {
        this.f32434a = ksFragmentManager;
    }

    public static String a(int i2, long j) {
        return "android:switcher:" + i2 + ":" + j;
    }

    private List<KsFragment> a(int i2) {
        return this.f32437f.get(i2);
    }

    private long b(int i2) {
        return i2;
    }

    public int a(KsFragment ksFragment) {
        return 0;
    }

    public abstract KsFragment a(int i2, int i3);

    public abstract void a(KsFragment ksFragment, int i2, int i3);

    public abstract boolean b(KsFragment ksFragment);

    public int d(int i2) {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        if (this.f32435b == null) {
            this.f32435b = this.f32434a.beginTransaction();
        }
        KsFragment ksFragment = (KsFragment) obj;
        if (!this.f32436c) {
            this.f32435b.detach(ksFragment);
            if (!b(ksFragment)) {
                return;
            }
            int a2 = a(ksFragment);
            if (f(a2)) {
                List<KsFragment> a3 = a(a2);
                if (a3 == null) {
                    a3 = new ArrayList<>();
                    this.f32437f.put(a2, a3);
                }
                a3.add(ksFragment);
                return;
            }
        }
        this.f32435b.remove(ksFragment);
    }

    public boolean f(int i2) {
        return true;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        KsFragmentTransaction ksFragmentTransaction = this.f32435b;
        if (ksFragmentTransaction != null) {
            try {
                ksFragmentTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            this.f32435b = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        if (this.f32435b == null) {
            this.f32435b = this.f32434a.beginTransaction();
        }
        long b2 = b(i2);
        int d2 = d(i2);
        KsFragment ksFragment = null;
        List<KsFragment> a2 = a(d2);
        if (a2 != null && a2.size() > 0) {
            ksFragment = a2.remove(0);
        }
        if (ksFragment != null) {
            a(ksFragment, i2, d2);
            this.f32435b.attach(ksFragment);
        } else {
            ksFragment = a(i2, d2);
            a(ksFragment, i2, d2);
            this.f32435b.add(viewGroup.getId(), ksFragment, a(viewGroup.getId(), b2));
        }
        if (ksFragment != this.f32438g) {
            ksFragment.setMenuVisibility(false);
            ksFragment.setUserVisibleHint(false);
        }
        return ksFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((KsFragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        KsFragment ksFragment2 = this.f32438g;
        if (ksFragment != ksFragment2) {
            if (ksFragment2 != null) {
                ksFragment2.setMenuVisibility(false);
                this.f32438g.setUserVisibleHint(false);
            }
            ksFragment.setMenuVisibility(true);
            ksFragment.setUserVisibleHint(true);
            this.f32438g = ksFragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
