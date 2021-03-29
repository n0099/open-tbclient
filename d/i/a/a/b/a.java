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
    public final ListAdapter f66186e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f66187f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f66188g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66189h;
    public final boolean i;

    public a(ArrayList<PLA_ListView.a> arrayList, ArrayList<PLA_ListView.a> arrayList2, ListAdapter listAdapter) {
        this.f66186e = listAdapter;
        this.i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f66187f = j;
        } else {
            this.f66187f = arrayList;
        }
        if (arrayList2 == null) {
            this.f66188g = j;
        } else {
            this.f66188g = arrayList2;
        }
        this.f66189h = a(this.f66187f) && a(this.f66188g);
    }

    public final boolean a(ArrayList<PLA_ListView.a> arrayList) {
        if (arrayList != null) {
            Iterator<PLA_ListView.a> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f31149c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter != null) {
            return this.f66189h && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f66188g.size();
    }

    public int c() {
        return this.f66187f.size();
    }

    public boolean d(View view) {
        boolean z = false;
        for (int i = 0; i < this.f66188g.size(); i++) {
            if (this.f66188g.get(i).f31147a == view) {
                this.f66188g.remove(i);
                if (a(this.f66187f) && a(this.f66188g)) {
                    z = true;
                }
                this.f66189h = z;
                return true;
            }
        }
        return false;
    }

    public boolean e(View view) {
        boolean z = false;
        for (int i = 0; i < this.f66187f.size(); i++) {
            if (this.f66187f.get(i).f31147a == view) {
                this.f66187f.remove(i);
                if (a(this.f66187f) && a(this.f66188g)) {
                    z = true;
                }
                this.f66189h = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        int c2;
        if (this.f66186e != null) {
            b2 = b() + c();
            c2 = this.f66186e.getCount();
        } else {
            b2 = b();
            c2 = c();
        }
        return b2 + c2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i) {
            return ((Filterable) this.f66186e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int c2 = c();
        if (i < c2) {
            return this.f66187f.get(i).f31148b;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f66186e.getItem(i2);
        }
        return this.f66188g.get(i2 - i3).f31148b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int c2 = c();
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f66186e.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int c2 = c();
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f66186e.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int c2 = c();
        if (i < c2) {
            return this.f66187f.get(i).f31147a;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f66186e.getView(i2, view, viewGroup);
        }
        return this.f66188g.get(i2 - i3).f31147a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f66186e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f66186e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int c2 = c();
        if (i < c2) {
            return this.f66187f.get(i).f31149c;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f66186e.isEnabled(i2);
        }
        return this.f66188g.get(i2 - i3).f31149c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f66186e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
