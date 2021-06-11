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
/* loaded from: classes7.dex */
public class a extends PagerAdapter implements PagerSlidingTabStrip.c.a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36763a;

    /* renamed from: b  reason: collision with root package name */
    public final KsFragmentManager f36764b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f36765c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public KsFragmentTransaction f36766d = null;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<KsFragment> f36767e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<KsSavedState> f36768f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<Bundle> f36769g = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    public KsFragment f36770h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f36771i;

    /* renamed from: com.kwad.sdk.lib.widget.viewpager.tabstrip.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0429a {
        void a(Bundle bundle);
    }

    public a(Context context, KsFragmentManager ksFragmentManager) {
        this.f36764b = ksFragmentManager;
        this.f36763a = context;
    }

    private KsFragment d(int i2) {
        return KsFragment.instantiate(this.f36763a, this.f36765c.get(i2).b().getName(), this.f36769g.get(i2));
    }

    public int a(String str) {
        if (this.f36765c != null && !TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < this.f36765c.size(); i2++) {
                b bVar = this.f36765c.get(i2);
                if (bVar != null && bVar.a() != null && str.equals(bVar.a().a())) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public KsFragment a() {
        return this.f36770h;
    }

    public KsFragment a(int i2) {
        return this.f36767e.get(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: a */
    public KsFragment instantiateItem(ViewGroup viewGroup, int i2) {
        KsFragment ksFragment = this.f36767e.get(i2);
        if (ksFragment != null) {
            this.f36765c.get(i2).a(i2, ksFragment);
            return ksFragment;
        }
        if (this.f36766d == null) {
            this.f36766d = this.f36764b.beginTransaction();
        }
        KsFragment d2 = d(i2);
        this.f36765c.get(i2).a(i2, d2);
        KsSavedState ksSavedState = this.f36768f.get(i2);
        if (ksSavedState != null) {
            d2.setInitialSavedState(ksSavedState);
        }
        d2.setMenuVisibility(false);
        d2.setUserVisibleHint(false);
        this.f36767e.put(i2, d2);
        this.f36766d.add(viewGroup.getId(), d2);
        return d2;
    }

    public void a(int i2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = this.f36769g.get(i2);
        if (bundle2 != null) {
            bundle2.putAll(bundle);
            bundle = bundle2;
        }
        this.f36769g.put(i2, bundle);
        KsFragment a2 = a(i2);
        if (a2 instanceof InterfaceC0429a) {
            ((InterfaceC0429a) a2).a(bundle);
        }
    }

    public void a(List<b> list) {
        this.f36765c.clear();
        b(list);
    }

    @Override // com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.a
    public PagerSlidingTabStrip.c b(int i2) {
        if (!this.f36765c.isEmpty() && i2 >= 0 && i2 < this.f36765c.size()) {
            return this.f36765c.get(i2).a();
        }
        return null;
    }

    public void b(List<b> list) {
        if (list == null) {
            throw new RuntimeException("delegates should not be null for setFragments()");
        }
        int size = this.f36765c.size();
        int size2 = list.size() + size;
        for (int i2 = size; i2 < size2; i2++) {
            this.f36769g.put(i2, list.get(i2 - size).c());
        }
        this.f36765c.addAll(list);
        notifyDataSetChanged();
    }

    public String c(int i2) {
        PagerSlidingTabStrip.c b2 = b(i2);
        return (b2 == null || b2.a() == null) ? "" : b2.a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        if (this.f36766d == null) {
            this.f36766d = this.f36764b.beginTransaction();
        }
        this.f36768f.put(i2, this.f36764b.saveFragmentInstanceState(ksFragment));
        this.f36767e.remove(i2);
        this.f36766d.remove(ksFragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        KsFragmentTransaction ksFragmentTransaction = this.f36766d;
        if (ksFragmentTransaction != null) {
            ksFragmentTransaction.commitAllowingStateLoss();
            this.f36766d = null;
            try {
                this.f36764b.executePendingTransactions();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f36765c.size();
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
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        KsFragment ksFragment2 = this.f36770h;
        if (ksFragment != ksFragment2) {
            if (ksFragment2 != null) {
                ksFragment2.setMenuVisibility(false);
                this.f36770h.setUserVisibleHint(false);
            }
            if (ksFragment != null) {
                ksFragment.setMenuVisibility(true);
                ksFragment.setUserVisibleHint(true);
            }
            this.f36770h = ksFragment;
            this.f36771i = i2;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }
}
