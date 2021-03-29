package d.b.i0.a1.b;

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
/* loaded from: classes3.dex */
public class d implements WrapperListAdapter, Filterable {
    public static final ArrayList<HListView.c> j = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ListAdapter f51880e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<HListView.c> f51881f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<HListView.c> f51882g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51883h;
    public final boolean i;

    public d(ArrayList<HListView.c> arrayList, ArrayList<HListView.c> arrayList2, ListAdapter listAdapter) {
        this.f51880e = listAdapter;
        this.i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f51881f = j;
        } else {
            this.f51881f = arrayList;
        }
        if (arrayList2 == null) {
            this.f51882g = j;
        } else {
            this.f51882g = arrayList2;
        }
        this.f51883h = a(this.f51881f) && a(this.f51882g);
    }

    public final boolean a(ArrayList<HListView.c> arrayList) {
        if (arrayList != null) {
            Iterator<HListView.c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f17520c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter != null) {
            return this.f51883h && listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int b() {
        return this.f51882g.size();
    }

    public int c() {
        return this.f51881f.size();
    }

    public boolean d(View view) {
        boolean z = false;
        for (int i = 0; i < this.f51882g.size(); i++) {
            if (this.f51882g.get(i).f17518a == view) {
                this.f51882g.remove(i);
                if (a(this.f51881f) && a(this.f51882g)) {
                    z = true;
                }
                this.f51883h = z;
                return true;
            }
        }
        return false;
    }

    public boolean e(View view) {
        boolean z = false;
        for (int i = 0; i < this.f51881f.size(); i++) {
            if (this.f51881f.get(i).f17518a == view) {
                this.f51881f.remove(i);
                if (a(this.f51881f) && a(this.f51882g)) {
                    z = true;
                }
                this.f51883h = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        int c2;
        if (this.f51880e != null) {
            b2 = b() + c();
            c2 = this.f51880e.getCount();
        } else {
            b2 = b();
            c2 = c();
        }
        return b2 + c2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i) {
            return ((Filterable) this.f51880e).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int c2 = c();
        if (i < c2) {
            return this.f51881f.get(i).f17519b;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f51880e.getItem(i2);
        }
        return this.f51882g.get(i2 - i3).f17519b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int c2 = c();
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
            return -1L;
        }
        return this.f51880e.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int c2 = c();
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f51880e.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int c2 = c();
        if (i < c2) {
            return this.f51881f.get(i).f17518a;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f51880e.getView(i2, view, viewGroup);
        }
        return this.f51882g.get(i2 - i3).f17518a;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f51880e;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f51880e;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int c2 = c();
        if (i < c2) {
            return this.f51881f.get(i).f17520c;
        }
        int i2 = i - c2;
        int i3 = 0;
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f51880e.isEnabled(i2);
        }
        return this.f51882g.get(i2 - i3).f17520c;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter = this.f51880e;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
