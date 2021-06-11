package d.a.n0.c1.b;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d implements WrapperListAdapter, Filterable {
    public static final ArrayList<HListView.c> j = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ListAdapter f56014e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<HListView.c> f56015f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<HListView.c> f56016g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56017h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f56018i;

    public d(ArrayList<HListView.c> arrayList, ArrayList<HListView.c> arrayList2, ListAdapter listAdapter) {
        this.f56014e = listAdapter;
        this.f56018i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f56015f = j;
        } else {
            this.f56015f = arrayList;
        }
        if (arrayList2 == null) {
            this.f56016g = j;
        } else {
            this.f56016g = arrayList2;
        }
        this.f56017h = a(this.f56015f) && a(this.f56016g);
    }

    public final boolean a(ArrayList<HListView.c> arrayList) {
        if (arrayList != null) {
            Iterator<HListView.c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f16799c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter != null) {
            return this.f56017h && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f56016g.size();
    }

    public int c() {
        return this.f56015f.size();
    }

    public boolean d(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f56016g.size(); i2++) {
            if (this.f56016g.get(i2).f16797a == view) {
                this.f56016g.remove(i2);
                if (a(this.f56015f) && a(this.f56016g)) {
                    z = true;
                }
                this.f56017h = z;
                return true;
            }
        }
        return false;
    }

    public boolean e(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f56015f.size(); i2++) {
            if (this.f56015f.get(i2).f16797a == view) {
                this.f56015f.remove(i2);
                if (a(this.f56015f) && a(this.f56016g)) {
                    z = true;
                }
                this.f56017h = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        int c2;
        if (this.f56014e != null) {
            b2 = b() + c();
            c2 = this.f56014e.getCount();
        } else {
            b2 = b();
            c2 = c();
        }
        return b2 + c2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f56018i) {
            return ((Filterable) this.f56014e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f56015f.get(i2).f16798b;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f56014e.getItem(i3);
        }
        return this.f56016g.get(i3 - i4).f16798b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f56014e.getItemId(i3);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f56014e.getItemViewType(i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int c2 = c();
        if (i2 < c2) {
            return this.f56015f.get(i2).f16797a;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f56014e.getView(i3, view, viewGroup);
        }
        return this.f56016g.get(i3 - i4).f16797a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f56014e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f56014e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f56015f.get(i2).f16799c;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f56014e.isEnabled(i3);
        }
        return this.f56016g.get(i3 - i4).f16799c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f56014e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
