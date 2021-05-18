package d.a.k0.b1.b;

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
    public final ListAdapter f52167e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<HListView.c> f52168f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<HListView.c> f52169g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52170h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f52171i;

    public d(ArrayList<HListView.c> arrayList, ArrayList<HListView.c> arrayList2, ListAdapter listAdapter) {
        this.f52167e = listAdapter;
        this.f52171i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f52168f = j;
        } else {
            this.f52168f = arrayList;
        }
        if (arrayList2 == null) {
            this.f52169g = j;
        } else {
            this.f52169g = arrayList2;
        }
        this.f52170h = a(this.f52168f) && a(this.f52169g);
    }

    public final boolean a(ArrayList<HListView.c> arrayList) {
        if (arrayList != null) {
            Iterator<HListView.c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f16813c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter != null) {
            return this.f52170h && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f52169g.size();
    }

    public int c() {
        return this.f52168f.size();
    }

    public boolean d(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f52169g.size(); i2++) {
            if (this.f52169g.get(i2).f16811a == view) {
                this.f52169g.remove(i2);
                if (a(this.f52168f) && a(this.f52169g)) {
                    z = true;
                }
                this.f52170h = z;
                return true;
            }
        }
        return false;
    }

    public boolean e(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f52168f.size(); i2++) {
            if (this.f52168f.get(i2).f16811a == view) {
                this.f52168f.remove(i2);
                if (a(this.f52168f) && a(this.f52169g)) {
                    z = true;
                }
                this.f52170h = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        int c2;
        if (this.f52167e != null) {
            b2 = b() + c();
            c2 = this.f52167e.getCount();
        } else {
            b2 = b();
            c2 = c();
        }
        return b2 + c2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f52171i) {
            return ((Filterable) this.f52167e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f52168f.get(i2).f16812b;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f52167e.getItem(i3);
        }
        return this.f52169g.get(i3 - i4).f16812b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f52167e.getItemId(i3);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f52167e.getItemViewType(i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int c2 = c();
        if (i2 < c2) {
            return this.f52168f.get(i2).f16811a;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f52167e.getView(i3, view, viewGroup);
        }
        return this.f52169g.get(i3 - i4).f16811a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f52167e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f52167e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f52168f.get(i2).f16813c;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f52167e.isEnabled(i3);
        }
        return this.f52169g.get(i3 - i4).f16813c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f52167e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
