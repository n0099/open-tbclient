package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.api.core.fragment.KsFragmentTransaction;
import com.kwad.sdk.api.core.fragment.KsSavedState;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends PagerAdapter implements PagerSlidingTabStrip.c.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10773a;

    /* renamed from: b  reason: collision with root package name */
    private final KsFragmentManager f10774b;
    private final List<b> c = new ArrayList();
    private KsFragmentTransaction d = null;
    private SparseArray<KsFragment> e = new SparseArray<>();
    private SparseArray<KsSavedState> f = new SparseArray<>();
    private SparseArray<Bundle> g = new SparseArray<>();
    private KsFragment h = null;
    private int i;

    /* renamed from: com.kwad.sdk.lib.widget.viewpager.tabstrip.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1155a {
        void a(Bundle bundle);
    }

    public a(Context context, KsFragmentManager ksFragmentManager) {
        this.f10774b = ksFragmentManager;
        this.f10773a = context;
    }

    private KsFragment d(int i) {
        return KsFragment.instantiate(this.f10773a, this.c.get(i).b().getName(), this.g.get(i));
    }

    public int a(String str) {
        if (this.c == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                return -1;
            }
            b bVar = this.c.get(i2);
            if (bVar != null && bVar.a() != null && str.equals(bVar.a().a())) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public KsFragment a() {
        return this.h;
    }

    public KsFragment a(int i) {
        return this.e.get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: a */
    public KsFragment instantiateItem(ViewGroup viewGroup, int i) {
        KsFragment ksFragment = this.e.get(i);
        if (ksFragment != null) {
            this.c.get(i).a(i, ksFragment);
            return ksFragment;
        }
        if (this.d == null) {
            this.d = this.f10774b.beginTransaction();
        }
        KsFragment d = d(i);
        this.c.get(i).a(i, d);
        KsSavedState ksSavedState = this.f.get(i);
        if (ksSavedState != null) {
            d.setInitialSavedState(ksSavedState);
        }
        d.setMenuVisibility(false);
        d.setUserVisibleHint(false);
        this.e.put(i, d);
        this.d.add(viewGroup.getId(), d);
        return d;
    }

    public void a(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = this.g.get(i);
        if (bundle2 != null) {
            bundle2.putAll(bundle);
            bundle = bundle2;
        }
        this.g.put(i, bundle);
        KsFragment a2 = a(i);
        if (a2 instanceof InterfaceC1155a) {
            ((InterfaceC1155a) a2).a(bundle);
        }
    }

    public void a(List<b> list) {
        this.c.clear();
        b(list);
    }

    @Override // com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.a
    public PagerSlidingTabStrip.c b(int i) {
        if (!this.c.isEmpty() && i >= 0 && i < this.c.size()) {
            return this.c.get(i).a();
        }
        return null;
    }

    public void b(List<b> list) {
        if (list == null) {
            throw new RuntimeException("delegates should not be null for setFragments()");
        }
        int size = this.c.size();
        int size2 = size + list.size();
        for (int i = size; i < size2; i++) {
            this.g.put(i, list.get(i - size).c());
        }
        this.c.addAll(list);
        notifyDataSetChanged();
    }

    public String c(int i) {
        PagerSlidingTabStrip.c b2 = b(i);
        return (b2 == null || b2.a() == null) ? "" : b2.a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        if (this.d == null) {
            this.d = this.f10774b.beginTransaction();
        }
        this.f.put(i, this.f10774b.saveFragmentInstanceState(ksFragment));
        this.e.remove(i);
        this.d.remove(ksFragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        if (this.d != null) {
            this.d.commitAllowingStateLoss();
            this.d = null;
            try {
                this.f10774b.executePendingTransactions();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.c.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
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
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        if (ksFragment != this.h) {
            if (this.h != null) {
                this.h.setMenuVisibility(false);
                this.h.setUserVisibleHint(false);
            }
            if (ksFragment != null) {
                ksFragment.setMenuVisibility(true);
                ksFragment.setUserVisibleHint(true);
            }
            this.h = ksFragment;
            this.i = i;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }
}
