package d.a.j0.b1.b;

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
    public final ListAdapter f51468e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<HListView.c> f51469f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<HListView.c> f51470g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51471h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f51472i;

    public d(ArrayList<HListView.c> arrayList, ArrayList<HListView.c> arrayList2, ListAdapter listAdapter) {
        this.f51468e = listAdapter;
        this.f51472i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f51469f = j;
        } else {
            this.f51469f = arrayList;
        }
        if (arrayList2 == null) {
            this.f51470g = j;
        } else {
            this.f51470g = arrayList2;
        }
        this.f51471h = a(this.f51469f) && a(this.f51470g);
    }

    public final boolean a(ArrayList<HListView.c> arrayList) {
        if (arrayList != null) {
            Iterator<HListView.c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f17498c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter != null) {
            return this.f51471h && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f51470g.size();
    }

    public int c() {
        return this.f51469f.size();
    }

    public boolean d(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f51470g.size(); i2++) {
            if (this.f51470g.get(i2).f17496a == view) {
                this.f51470g.remove(i2);
                if (a(this.f51469f) && a(this.f51470g)) {
                    z = true;
                }
                this.f51471h = z;
                return true;
            }
        }
        return false;
    }

    public boolean e(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f51469f.size(); i2++) {
            if (this.f51469f.get(i2).f17496a == view) {
                this.f51469f.remove(i2);
                if (a(this.f51469f) && a(this.f51470g)) {
                    z = true;
                }
                this.f51471h = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        int c2;
        if (this.f51468e != null) {
            b2 = b() + c();
            c2 = this.f51468e.getCount();
        } else {
            b2 = b();
            c2 = c();
        }
        return b2 + c2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f51472i) {
            return ((Filterable) this.f51468e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f51469f.get(i2).f17497b;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f51468e.getItem(i3);
        }
        return this.f51470g.get(i3 - i4).f17497b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f51468e.getItemId(i3);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f51468e.getItemViewType(i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int c2 = c();
        if (i2 < c2) {
            return this.f51469f.get(i2).f17496a;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f51468e.getView(i3, view, viewGroup);
        }
        return this.f51470g.get(i3 - i4).f17496a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f51468e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f51468e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f51469f.get(i2).f17498c;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f51468e.isEnabled(i3);
        }
        return this.f51470g.get(i3 - i4).f17498c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f51468e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
