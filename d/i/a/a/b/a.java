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
    public final ListAdapter f66339e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f66340f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f66341g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66342h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f66343i;

    public a(ArrayList<PLA_ListView.a> arrayList, ArrayList<PLA_ListView.a> arrayList2, ListAdapter listAdapter) {
        this.f66339e = listAdapter;
        this.f66343i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f66340f = j;
        } else {
            this.f66340f = arrayList;
        }
        if (arrayList2 == null) {
            this.f66341g = j;
        } else {
            this.f66341g = arrayList2;
        }
        this.f66342h = a(this.f66340f) && a(this.f66341g);
    }

    public final boolean a(ArrayList<PLA_ListView.a> arrayList) {
        if (arrayList != null) {
            Iterator<PLA_ListView.a> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f31649c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter != null) {
            return this.f66342h && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f66341g.size();
    }

    public int c() {
        return this.f66340f.size();
    }

    public boolean d(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f66341g.size(); i2++) {
            if (this.f66341g.get(i2).f31647a == view) {
                this.f66341g.remove(i2);
                if (a(this.f66340f) && a(this.f66341g)) {
                    z = true;
                }
                this.f66342h = z;
                return true;
            }
        }
        return false;
    }

    public boolean e(View view) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f66340f.size(); i2++) {
            if (this.f66340f.get(i2).f31647a == view) {
                this.f66340f.remove(i2);
                if (a(this.f66340f) && a(this.f66341g)) {
                    z = true;
                }
                this.f66342h = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        int c2;
        if (this.f66339e != null) {
            b2 = b() + c();
            c2 = this.f66339e.getCount();
        } else {
            b2 = b();
            c2 = c();
        }
        return b2 + c2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f66343i) {
            return ((Filterable) this.f66339e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f66340f.get(i2).f31648b;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f66339e.getItem(i3);
        }
        return this.f66341g.get(i3 - i4).f31648b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f66339e.getItemId(i3);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i2) {
        int i3;
        int c2 = c();
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f66339e.getItemViewType(i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int c2 = c();
        if (i2 < c2) {
            return this.f66340f.get(i2).f31647a;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f66339e.getView(i3, view, viewGroup);
        }
        return this.f66341g.get(i3 - i4).f31647a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f66339e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f66339e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        int c2 = c();
        if (i2 < c2) {
            return this.f66340f.get(i2).f31649c;
        }
        int i3 = i2 - c2;
        int i4 = 0;
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f66339e.isEnabled(i3);
        }
        return this.f66341g.get(i3 - i4).f31649c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f66339e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
