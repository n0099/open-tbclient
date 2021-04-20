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
/* loaded from: classes6.dex */
public class a extends PagerAdapter implements PagerSlidingTabStrip.c.a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36344a;

    /* renamed from: b  reason: collision with root package name */
    public final KsFragmentManager f36345b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f36346c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public KsFragmentTransaction f36347d = null;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<KsFragment> f36348e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<KsSavedState> f36349f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<Bundle> f36350g = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    public KsFragment f36351h = null;
    public int i;

    /* renamed from: com.kwad.sdk.lib.widget.viewpager.tabstrip.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0443a {
        void a(Bundle bundle);
    }

    public a(Context context, KsFragmentManager ksFragmentManager) {
        this.f36345b = ksFragmentManager;
        this.f36344a = context;
    }

    private KsFragment d(int i) {
        return KsFragment.instantiate(this.f36344a, this.f36346c.get(i).b().getName(), this.f36350g.get(i));
    }

    public int a(String str) {
        if (this.f36346c != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.f36346c.size(); i++) {
                b bVar = this.f36346c.get(i);
                if (bVar != null && bVar.a() != null && str.equals(bVar.a().a())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public KsFragment a() {
        return this.f36351h;
    }

    public KsFragment a(int i) {
        return this.f36348e.get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: a */
    public KsFragment instantiateItem(ViewGroup viewGroup, int i) {
        KsFragment ksFragment = this.f36348e.get(i);
        if (ksFragment != null) {
            this.f36346c.get(i).a(i, ksFragment);
            return ksFragment;
        }
        if (this.f36347d == null) {
            this.f36347d = this.f36345b.beginTransaction();
        }
        KsFragment d2 = d(i);
        this.f36346c.get(i).a(i, d2);
        KsSavedState ksSavedState = this.f36349f.get(i);
        if (ksSavedState != null) {
            d2.setInitialSavedState(ksSavedState);
        }
        d2.setMenuVisibility(false);
        d2.setUserVisibleHint(false);
        this.f36348e.put(i, d2);
        this.f36347d.add(viewGroup.getId(), d2);
        return d2;
    }

    public void a(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = this.f36350g.get(i);
        if (bundle2 != null) {
            bundle2.putAll(bundle);
            bundle = bundle2;
        }
        this.f36350g.put(i, bundle);
        KsFragment a2 = a(i);
        if (a2 instanceof InterfaceC0443a) {
            ((InterfaceC0443a) a2).a(bundle);
        }
    }

    public void a(List<b> list) {
        this.f36346c.clear();
        b(list);
    }

    @Override // com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.a
    public PagerSlidingTabStrip.c b(int i) {
        if (!this.f36346c.isEmpty() && i >= 0 && i < this.f36346c.size()) {
            return this.f36346c.get(i).a();
        }
        return null;
    }

    public void b(List<b> list) {
        if (list == null) {
            throw new RuntimeException("delegates should not be null for setFragments()");
        }
        int size = this.f36346c.size();
        int size2 = list.size() + size;
        for (int i = size; i < size2; i++) {
            this.f36350g.put(i, list.get(i - size).c());
        }
        this.f36346c.addAll(list);
        notifyDataSetChanged();
    }

    public String c(int i) {
        PagerSlidingTabStrip.c b2 = b(i);
        return (b2 == null || b2.a() == null) ? "" : b2.a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        if (this.f36347d == null) {
            this.f36347d = this.f36345b.beginTransaction();
        }
        this.f36349f.put(i, this.f36345b.saveFragmentInstanceState(ksFragment));
        this.f36348e.remove(i);
        this.f36347d.remove(ksFragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        KsFragmentTransaction ksFragmentTransaction = this.f36347d;
        if (ksFragmentTransaction != null) {
            ksFragmentTransaction.commitAllowingStateLoss();
            this.f36347d = null;
            try {
                this.f36345b.executePendingTransactions();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f36346c.size();
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
        KsFragment ksFragment2 = this.f36351h;
        if (ksFragment != ksFragment2) {
            if (ksFragment2 != null) {
                ksFragment2.setMenuVisibility(false);
                this.f36351h.setUserVisibleHint(false);
            }
            if (ksFragment != null) {
                ksFragment.setMenuVisibility(true);
                ksFragment.setUserVisibleHint(true);
            }
            this.f36351h = ksFragment;
            this.i = i;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }
}
