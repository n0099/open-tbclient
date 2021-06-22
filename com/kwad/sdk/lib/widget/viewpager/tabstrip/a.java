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
    public final Context f36861a;

    /* renamed from: b  reason: collision with root package name */
    public final KsFragmentManager f36862b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f36863c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public KsFragmentTransaction f36864d = null;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<KsFragment> f36865e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<KsSavedState> f36866f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<Bundle> f36867g = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    public KsFragment f36868h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f36869i;

    /* renamed from: com.kwad.sdk.lib.widget.viewpager.tabstrip.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0432a {
        void a(Bundle bundle);
    }

    public a(Context context, KsFragmentManager ksFragmentManager) {
        this.f36862b = ksFragmentManager;
        this.f36861a = context;
    }

    private KsFragment d(int i2) {
        return KsFragment.instantiate(this.f36861a, this.f36863c.get(i2).b().getName(), this.f36867g.get(i2));
    }

    public int a(String str) {
        if (this.f36863c != null && !TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < this.f36863c.size(); i2++) {
                b bVar = this.f36863c.get(i2);
                if (bVar != null && bVar.a() != null && str.equals(bVar.a().a())) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public KsFragment a() {
        return this.f36868h;
    }

    public KsFragment a(int i2) {
        return this.f36865e.get(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: a */
    public KsFragment instantiateItem(ViewGroup viewGroup, int i2) {
        KsFragment ksFragment = this.f36865e.get(i2);
        if (ksFragment != null) {
            this.f36863c.get(i2).a(i2, ksFragment);
            return ksFragment;
        }
        if (this.f36864d == null) {
            this.f36864d = this.f36862b.beginTransaction();
        }
        KsFragment d2 = d(i2);
        this.f36863c.get(i2).a(i2, d2);
        KsSavedState ksSavedState = this.f36866f.get(i2);
        if (ksSavedState != null) {
            d2.setInitialSavedState(ksSavedState);
        }
        d2.setMenuVisibility(false);
        d2.setUserVisibleHint(false);
        this.f36865e.put(i2, d2);
        this.f36864d.add(viewGroup.getId(), d2);
        return d2;
    }

    public void a(int i2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = this.f36867g.get(i2);
        if (bundle2 != null) {
            bundle2.putAll(bundle);
            bundle = bundle2;
        }
        this.f36867g.put(i2, bundle);
        KsFragment a2 = a(i2);
        if (a2 instanceof InterfaceC0432a) {
            ((InterfaceC0432a) a2).a(bundle);
        }
    }

    public void a(List<b> list) {
        this.f36863c.clear();
        b(list);
    }

    @Override // com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.a
    public PagerSlidingTabStrip.c b(int i2) {
        if (!this.f36863c.isEmpty() && i2 >= 0 && i2 < this.f36863c.size()) {
            return this.f36863c.get(i2).a();
        }
        return null;
    }

    public void b(List<b> list) {
        if (list == null) {
            throw new RuntimeException("delegates should not be null for setFragments()");
        }
        int size = this.f36863c.size();
        int size2 = list.size() + size;
        for (int i2 = size; i2 < size2; i2++) {
            this.f36867g.put(i2, list.get(i2 - size).c());
        }
        this.f36863c.addAll(list);
        notifyDataSetChanged();
    }

    public String c(int i2) {
        PagerSlidingTabStrip.c b2 = b(i2);
        return (b2 == null || b2.a() == null) ? "" : b2.a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        KsFragment ksFragment = (KsFragment) obj;
        if (this.f36864d == null) {
            this.f36864d = this.f36862b.beginTransaction();
        }
        this.f36866f.put(i2, this.f36862b.saveFragmentInstanceState(ksFragment));
        this.f36865e.remove(i2);
        this.f36864d.remove(ksFragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        KsFragmentTransaction ksFragmentTransaction = this.f36864d;
        if (ksFragmentTransaction != null) {
            ksFragmentTransaction.commitAllowingStateLoss();
            this.f36864d = null;
            try {
                this.f36862b.executePendingTransactions();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f36863c.size();
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
        KsFragment ksFragment2 = this.f36868h;
        if (ksFragment != ksFragment2) {
            if (ksFragment2 != null) {
                ksFragment2.setMenuVisibility(false);
                this.f36868h.setUserVisibleHint(false);
            }
            if (ksFragment != null) {
                ksFragment.setMenuVisibility(true);
                ksFragment.setUserVisibleHint(true);
            }
            this.f36868h = ksFragment;
            this.f36869i = i2;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }
}
