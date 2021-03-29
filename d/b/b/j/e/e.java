package d.b.b.j.e;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends BaseAdapter implements o {

    /* renamed from: e  reason: collision with root package name */
    public Context f42375e;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f42377g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f42378h;
    public boolean i;
    public DataSetObserver k;

    /* renamed from: f  reason: collision with root package name */
    public ListAdapter f42376f = null;
    public DataSetObserver j = null;
    public b l = null;

    /* loaded from: classes.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            if (e.this.j != null) {
                e.this.j.onChanged();
            }
            if (e.this.l != null) {
                e.this.l.onPreLoad();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            if (e.this.j != null) {
                e.this.j.onInvalidated();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onPreLoad();
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f42380a;

        /* renamed from: b  reason: collision with root package name */
        public Object f42381b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42382c;

        public c(e eVar) {
        }
    }

    public e(Context context) {
        this.f42375e = null;
        this.f42377g = null;
        this.f42378h = null;
        boolean z = false;
        this.i = false;
        this.k = null;
        this.f42375e = context;
        this.f42377g = new ArrayList<>();
        this.f42378h = new ArrayList<>();
        if (i(this.f42377g) && i(this.f42378h)) {
            z = true;
        }
        this.i = z;
        this.k = new a();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter != null) {
            return this.i && listAdapter.areAllItemsEnabled();
        }
        return super.areAllItemsEnabled();
    }

    public void e(View view) {
        f(view, null, true, -1);
    }

    public void f(View view, Object obj, boolean z, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42380a = view;
        cVar.f42381b = obj;
        cVar.f42382c = z;
        if (i >= 0 && i <= this.f42378h.size()) {
            this.f42378h.add(i, cVar);
        } else {
            this.f42378h.add(cVar);
        }
        notifyDataSetChanged();
    }

    public void g(View view, int i) {
        h(view, null, true, i);
    }

    @Override // android.widget.Adapter, d.b.b.j.e.o
    public int getCount() {
        int l;
        int n;
        if (this.f42376f != null) {
            l = l() + n();
            n = this.f42376f.getCount();
        } else {
            l = l();
            n = n();
        }
        return l + n;
    }

    @Override // android.widget.Adapter, d.b.b.j.e.o
    public Object getItem(int i) {
        int n = n();
        if (i < n) {
            return this.f42377g.get(i).f42381b;
        }
        int i2 = i - n;
        int i3 = 0;
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f42376f.getItem(i2);
        }
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= this.f42378h.size()) {
            return null;
        }
        return this.f42378h.get(i4).f42381b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int n = n();
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter == null || i < n || (i2 = i - n) >= listAdapter.getCount()) {
            return Long.MIN_VALUE;
        }
        return this.f42376f.getItemId(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int n = n();
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter == null || i < n || (i2 = i - n) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f42376f.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int n = n();
        if (i < n) {
            View view2 = this.f42377g.get(i).f42380a;
            return view2 == null ? j() : view2;
        }
        int i2 = i - n;
        int i3 = 0;
        ListAdapter listAdapter = this.f42376f;
        View view3 = null;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            try {
                view3 = this.f42376f.getView(i2, view, viewGroup);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    BdLog.detailException(e2);
                    Log.e("BdListAdapter", e2.getMessage());
                    e2.printStackTrace();
                }
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
                view3 = this.f42376f.getView(i2, view, viewGroup);
            }
            return view3 == null ? j() : view3;
        }
        try {
            view3 = this.f42378h.get(i2 - i3).f42380a;
        } catch (Exception e3) {
            BdLog.detailException(e3);
        }
        return view3 == null ? j() : view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount() + 1;
        }
        return 1;
    }

    public ListAdapter getWrappedAdapter() {
        return this.f42376f;
    }

    public void h(View view, Object obj, boolean z, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42380a = view;
        cVar.f42381b = obj;
        cVar.f42382c = z;
        if (i >= 0 && i <= this.f42377g.size()) {
            this.f42377g.add(i, cVar);
        } else {
            this.f42377g.add(cVar);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return super.hasStableIds();
    }

    public final boolean i(ArrayList<c> arrayList) {
        if (arrayList != null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f42382c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f42376f;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int i2;
        int n = n();
        if (i < n) {
            return this.f42377g.get(i).f42382c;
        }
        int i3 = i - n;
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter != null) {
            i2 = listAdapter.getCount();
            if (i3 < i2) {
                return this.f42376f.isEnabled(i3);
            }
        } else {
            i2 = 0;
        }
        int i4 = i3 - i2;
        if (i4 < 0 || i4 >= this.f42378h.size()) {
            return false;
        }
        return this.f42378h.get(i4).f42382c;
    }

    public final View j() {
        TextView textView = new TextView(this.f42375e);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int e2 = d.b.b.e.p.l.e(this.f42375e, 15.0f);
        textView.setPadding(e2, e2, e2, e2);
        return textView;
    }

    public int k() {
        return this.f42378h.size();
    }

    public int l() {
        return this.f42378h.size();
    }

    public int m() {
        return this.f42377g.size();
    }

    public int n() {
        return this.f42377g.size();
    }

    @Override // android.widget.BaseAdapter, d.b.b.j.e.o
    public void notifyDataSetChanged() {
        if (d.b.b.e.p.l.B()) {
            super.notifyDataSetChanged();
        }
    }

    public int o() {
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter != null) {
            return listAdapter.getCount();
        }
        return 0;
    }

    public boolean p(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.f42378h.size(); i++) {
            if (this.f42378h.get(i).f42380a == view) {
                this.f42378h.remove(i);
                if (i(this.f42377g) && i(this.f42378h)) {
                    z = true;
                }
                this.i = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public boolean q(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.f42377g.size(); i++) {
            if (this.f42377g.get(i).f42380a == view) {
                this.f42377g.remove(i);
                if (i(this.f42377g) && i(this.f42378h)) {
                    z = true;
                }
                this.i = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public void r(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f42376f;
        this.f42376f = listAdapter;
        if (listAdapter != null) {
            boolean z = listAdapter instanceof Filterable;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.j = dataSetObserver;
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.k);
        }
    }

    public void s(b bVar) {
        this.l = bVar;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.j = dataSetObserver;
        ListAdapter listAdapter = this.f42376f;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(this.k);
        }
    }
}
