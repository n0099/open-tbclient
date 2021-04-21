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
    public final KsFragmentManager f32271a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32273c;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<List<KsFragment>> f32274f = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public KsFragmentTransaction f32272b = null;

    /* renamed from: g  reason: collision with root package name */
    public KsFragment f32275g = null;

    public a(@NonNull KsFragmentManager ksFragmentManager) {
        this.f32271a = ksFragmentManager;
    }

    public static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    private List<KsFragment> a(int i) {
        return this.f32274f.get(i);
    }

    private long b(int i) {
        return i;
    }

    public int a(KsFragment ksFragment) {
        return 0;
    }

    public abstract KsFragment a(int i, int i2);

    public abstract void a(KsFragment ksFragment, int i, int i2);

    public abstract boolean b(KsFragment ksFragment);

    public int d(int i) {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        if (this.f32272b == null) {
            this.f32272b = this.f32271a.beginTransaction();
        }
        KsFragment ksFragment = (KsFragment) obj;
        if (!this.f32273c) {
            this.f32272b.detach(ksFragment);
            if (!b(ksFragment)) {
                return;
            }
            int a2 = a(ksFragment);
            if (f(a2)) {
                List<KsFragment> a3 = a(a2);
                if (a3 == null) {
                    a3 = new ArrayList<>();
                    this.f32274f.put(a2, a3);
                }
                a3.add(ksFragment);
                return;
            }
        }
        this.f32272b.remove(ksFragment);
    }

    public boolean f(int i) {
        return true;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        KsFragmentTransaction ksFragmentTransaction = this.f32272b;
        if (ksFragmentTransaction != null) {
            try {
                ksFragmentTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            this.f32272b = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        if (this.f32272b == null) {
            this.f32272b = this.f32271a.beginTransaction();
        }
        long b2 = b(i);
        int d2 = d(i);
        KsFragment ksFragment = null;
        List<KsFragment> a2 = a(d2);
        if (a2 != null && a2.size() > 0) {
            ksFragment = a2.remove(0);
        }
        if (ksFragment != null) {
            a(ksFragment, i, d2);
            this.f32272b.attach(ksFragment);
        } else {
            ksFragment = a(i, d2);
            a(ksFragment, i, d2);
            this.f32272b.add(viewGroup.getId(), ksFragment, a(viewGroup.getId(), b2));
        }
        if (ksFragment != this.f32275g) {
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
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        KsFragment ksFragment2 = this.f32275g;
        if (ksFragment != ksFragment2) {
            if (ksFragment2 != null) {
                ksFragment2.setMenuVisibility(false);
                this.f32275g.setUserVisibleHint(false);
            }
            ksFragment.setMenuVisibility(true);
            ksFragment.setUserVisibleHint(true);
            this.f32275g = ksFragment;
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
