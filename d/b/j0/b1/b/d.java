package d.b.j0.b1.b;

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
    public final ListAdapter f53721e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<HListView.c> f53722f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<HListView.c> f53723g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53724h;
    public final boolean i;

    public d(ArrayList<HListView.c> arrayList, ArrayList<HListView.c> arrayList2, ListAdapter listAdapter) {
        this.f53721e = listAdapter;
        this.i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f53722f = j;
        } else {
            this.f53722f = arrayList;
        }
        if (arrayList2 == null) {
            this.f53723g = j;
        } else {
            this.f53723g = arrayList2;
        }
        this.f53724h = a(this.f53722f) && a(this.f53723g);
    }

    public final boolean a(ArrayList<HListView.c> arrayList) {
        if (arrayList != null) {
            Iterator<HListView.c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f17205c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter != null) {
            return this.f53724h && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f53723g.size();
    }

    public int c() {
        return this.f53722f.size();
    }

    public boolean d(View view) {
        boolean z = false;
        for (int i = 0; i < this.f53723g.size(); i++) {
            if (this.f53723g.get(i).f17203a == view) {
                this.f53723g.remove(i);
                if (a(this.f53722f) && a(this.f53723g)) {
                    z = true;
                }
                this.f53724h = z;
                return true;
            }
        }
        return false;
    }

    public boolean e(View view) {
        boolean z = false;
        for (int i = 0; i < this.f53722f.size(); i++) {
            if (this.f53722f.get(i).f17203a == view) {
                this.f53722f.remove(i);
                if (a(this.f53722f) && a(this.f53723g)) {
                    z = true;
                }
                this.f53724h = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        int c2;
        if (this.f53721e != null) {
            b2 = b() + c();
            c2 = this.f53721e.getCount();
        } else {
            b2 = b();
            c2 = c();
        }
        return b2 + c2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i) {
            return ((Filterable) this.f53721e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int c2 = c();
        if (i < c2) {
            return this.f53722f.get(i).f17204b;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f53721e.getItem(i2);
        }
        return this.f53723g.get(i2 - i3).f17204b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int c2 = c();
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f53721e.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int c2 = c();
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f53721e.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int c2 = c();
        if (i < c2) {
            return this.f53722f.get(i).f17203a;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f53721e.getView(i2, view, viewGroup);
        }
        return this.f53723g.get(i2 - i3).f17203a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f53721e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f53721e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int c2 = c();
        if (i < c2) {
            return this.f53722f.get(i).f17205c;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f53721e.isEnabled(i2);
        }
        return this.f53723g.get(i2 - i3).f17205c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f53721e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
