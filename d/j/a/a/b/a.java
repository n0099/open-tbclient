package d.j.a.a.b;

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
    public final ListAdapter f67326e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f67327f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f67328g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67329h;
    public final boolean i;

    public a(ArrayList<PLA_ListView.a> arrayList, ArrayList<PLA_ListView.a> arrayList2, ListAdapter listAdapter) {
        this.f67326e = listAdapter;
        this.i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f67327f = j;
        } else {
            this.f67327f = arrayList;
        }
        if (arrayList2 == null) {
            this.f67328g = j;
        } else {
            this.f67328g = arrayList2;
        }
        this.f67329h = a(this.f67327f) && a(this.f67328g);
    }

    public final boolean a(ArrayList<PLA_ListView.a> arrayList) {
        if (arrayList != null) {
            Iterator<PLA_ListView.a> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f31533c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter != null) {
            return this.f67329h && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f67328g.size();
    }

    public int c() {
        return this.f67327f.size();
    }

    public boolean d(View view) {
        boolean z = false;
        for (int i = 0; i < this.f67328g.size(); i++) {
            if (this.f67328g.get(i).f31531a == view) {
                this.f67328g.remove(i);
                if (a(this.f67327f) && a(this.f67328g)) {
                    z = true;
                }
                this.f67329h = z;
                return true;
            }
        }
        return false;
    }

    public boolean e(View view) {
        boolean z = false;
        for (int i = 0; i < this.f67327f.size(); i++) {
            if (this.f67327f.get(i).f31531a == view) {
                this.f67327f.remove(i);
                if (a(this.f67327f) && a(this.f67328g)) {
                    z = true;
                }
                this.f67329h = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        int c2;
        if (this.f67326e != null) {
            b2 = b() + c();
            c2 = this.f67326e.getCount();
        } else {
            b2 = b();
            c2 = c();
        }
        return b2 + c2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i) {
            return ((Filterable) this.f67326e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int c2 = c();
        if (i < c2) {
            return this.f67327f.get(i).f31532b;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f67326e.getItem(i2);
        }
        return this.f67328g.get(i2 - i3).f31532b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int c2 = c();
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f67326e.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int c2 = c();
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f67326e.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int c2 = c();
        if (i < c2) {
            return this.f67327f.get(i).f31531a;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f67326e.getView(i2, view, viewGroup);
        }
        return this.f67328g.get(i2 - i3).f31531a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f67326e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f67326e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int c2 = c();
        if (i < c2) {
            return this.f67327f.get(i).f31533c;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f67326e.isEnabled(i2);
        }
        return this.f67328g.get(i2 - i3).f31533c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f67326e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
