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
/* loaded from: classes3.dex */
public abstract class a extends PagerAdapter {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final KsFragmentManager f5502a;
    private boolean c;
    protected final SparseArray<List<KsFragment>> f = new SparseArray<>();
    private KsFragmentTransaction b = null;
    protected KsFragment g = null;

    public a(@NonNull KsFragmentManager ksFragmentManager) {
        this.f5502a = ksFragmentManager;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    private List<KsFragment> a(int i) {
        return this.f.get(i);
    }

    private long b(int i) {
        return i;
    }

    protected int a(KsFragment ksFragment) {
        return 0;
    }

    protected abstract KsFragment a(int i, int i2);

    protected abstract void a(KsFragment ksFragment, int i, int i2);

    protected abstract boolean b(KsFragment ksFragment);

    protected int d(int i) {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        if (this.b == null) {
            this.b = this.f5502a.beginTransaction();
        }
        KsFragment ksFragment = (KsFragment) obj;
        if (this.c) {
            this.b.remove(ksFragment);
            return;
        }
        this.b.detach(ksFragment);
        if (b(ksFragment)) {
            int a2 = a(ksFragment);
            if (!f(a2)) {
                this.b.remove(ksFragment);
                return;
            }
            List<KsFragment> a3 = a(a2);
            if (a3 == null) {
                a3 = new ArrayList<>();
                this.f.put(a2, a3);
            }
            a3.add(ksFragment);
        }
    }

    protected boolean f(int i) {
        return true;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        if (this.b != null) {
            try {
                this.b.commitNowAllowingStateLoss();
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
            this.b = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        if (this.b == null) {
            this.b = this.f5502a.beginTransaction();
        }
        long b = b(i);
        int d = d(i);
        KsFragment ksFragment = null;
        List<KsFragment> a2 = a(d);
        if (a2 != null && a2.size() > 0) {
            ksFragment = a2.remove(0);
        }
        if (ksFragment != null) {
            a(ksFragment, i, d);
            this.b.attach(ksFragment);
        } else {
            ksFragment = a(i, d);
            a(ksFragment, i, d);
            this.b.add(viewGroup.getId(), ksFragment, a(viewGroup.getId(), b));
        }
        if (ksFragment != this.g) {
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
        if (ksFragment != this.g) {
            if (this.g != null) {
                this.g.setMenuVisibility(false);
                this.g.setUserVisibleHint(false);
            }
            ksFragment.setMenuVisibility(true);
            ksFragment.setUserVisibleHint(true);
            this.g = ksFragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
