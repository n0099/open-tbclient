package d.i.a.a.b;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.huewu.pla.lib.internal.PLA_ListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a implements WrapperListAdapter, Filterable {
    public static final ArrayList<PLA_ListView.a> j = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ListAdapter f65653e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f65654f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f65655g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65656h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f65657i;

    public a(ArrayList<PLA_ListView.a> arrayList, ArrayList<PLA_ListView.a> arrayList2, ListAdapter listAdapter) {
        this.f65653e = listAdapter;
        this.f65657i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f65654f = j;
        } else {
            this.f65654f = arrayList;
        }
        if (arrayList2 == null) {
            this.f65655g = j;
        } else {
            this.f65655g = arrayList2;
        }
        this.f65656h = a(this.f65654f) && a(this.f65655g);
    }

    public final boolean a(ArrayList<PLA_ListView.a> arrayList) {
        if (arrayList != null) {
            Iterator<PLA_ListView.a> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f32404c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter != null) {
            return this.f65656h && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f65655g.size();
    }

    public int c() {
        return this.f65654f.size();
    }

    public boolean d(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f65655g.size(); i2++) {
            if (this.f65655g.get(i2).f32402a == view) {
                this.f65655g.remove(i2);
                if (a(this.f65654f) && a(this.f65655g)) {
                    z = true;
                }
                this.f65656h = z;
                return true;
            }
        }
        return false;
    }

    public boolean e(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f65654f.size(); i2++) {
            if (this.f65654f.get(i2).f32402a == view) {
                this.f65654f.remove(i2);
                if (a(this.f65654f) && a(this.f65655g)) {
                    z = true;
                }
                this.f65656h = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        int c2;
        if (this.f65653e != null) {
            b2 = b() + c();
            c2 = this.f65653e.getCount();
        } else {
            b2 = b();
            c2 = c();
        }
        return b2 + c2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f65657i) {
            return ((Filterable) this.f65653e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f65654f.get(i2).f32403b;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f65653e.getItem(i3);
        }
        return this.f65655g.get(i3 - i4).f32403b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f65653e.getItemId(i3);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f65653e.getItemViewType(i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int c2 = c();
        if (i2 < c2) {
            return this.f65654f.get(i2).f32402a;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f65653e.getView(i3, view, viewGroup);
        }
        return this.f65655g.get(i3 - i4).f32402a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f65653e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f65653e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f65654f.get(i2).f32404c;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f65653e.isEnabled(i3);
        }
        return this.f65655g.get(i3 - i4).f32404c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f65653e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
