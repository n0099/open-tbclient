package d.b.c.j.e;

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
    public Context f43112e;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f43114g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f43115h;
    public boolean i;
    public DataSetObserver k;

    /* renamed from: f  reason: collision with root package name */
    public ListAdapter f43113f = null;
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
        public View f43117a;

        /* renamed from: b  reason: collision with root package name */
        public Object f43118b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43119c;

        public c(e eVar) {
        }
    }

    public e(Context context) {
        this.f43112e = null;
        this.f43114g = null;
        this.f43115h = null;
        boolean z = false;
        this.i = false;
        this.k = null;
        this.f43112e = context;
        this.f43114g = new ArrayList<>();
        this.f43115h = new ArrayList<>();
        if (i(this.f43114g) && i(this.f43115h)) {
            z = true;
        }
        this.i = z;
        this.k = new a();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f43113f;
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
        cVar.f43117a = view;
        cVar.f43118b = obj;
        cVar.f43119c = z;
        if (i >= 0 && i <= this.f43115h.size()) {
            this.f43115h.add(i, cVar);
        } else {
            this.f43115h.add(cVar);
        }
        notifyDataSetChanged();
    }

    public void g(View view, int i) {
        h(view, null, true, i);
    }

    @Override // android.widget.Adapter, d.b.c.j.e.o
    public int getCount() {
        int l;
        int n;
        if (this.f43113f != null) {
            l = l() + n();
            n = this.f43113f.getCount();
        } else {
            l = l();
            n = n();
        }
        return l + n;
    }

    @Override // android.widget.Adapter, d.b.c.j.e.o
    public Object getItem(int i) {
        int n = n();
        if (i < n) {
            return this.f43114g.get(i).f43118b;
        }
        int i2 = i - n;
        int i3 = 0;
        ListAdapter listAdapter = this.f43113f;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            return this.f43113f.getItem(i2);
        }
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= this.f43115h.size()) {
            return null;
        }
        return this.f43115h.get(i4).f43118b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int n = n();
        ListAdapter listAdapter = this.f43113f;
        if (listAdapter == null || i < n || (i2 = i - n) >= listAdapter.getCount()) {
            return Long.MIN_VALUE;
        }
        return this.f43113f.getItemId(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int n = n();
        ListAdapter listAdapter = this.f43113f;
        if (listAdapter == null || i < n || (i2 = i - n) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f43113f.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int n = n();
        if (i < n) {
            View view2 = this.f43114g.get(i).f43117a;
            return view2 == null ? j() : view2;
        }
        int i2 = i - n;
        int i3 = 0;
        ListAdapter listAdapter = this.f43113f;
        View view3 = null;
        if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
            try {
                view3 = this.f43113f.getView(i2, view, viewGroup);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    BdLog.detailException(e2);
                    Log.e("BdListAdapter", e2.getMessage());
                    e2.printStackTrace();
                }
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
                view3 = this.f43113f.getView(i2, view, viewGroup);
            }
            return view3 == null ? j() : view3;
        }
        try {
            view3 = this.f43115h.get(i2 - i3).f43117a;
        } catch (Exception e3) {
            BdLog.detailException(e3);
        }
        return view3 == null ? j() : view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f43113f;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount() + 1;
        }
        return 1;
    }

    public ListAdapter getWrappedAdapter() {
        return this.f43113f;
    }

    public void h(View view, Object obj, boolean z, int i) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f43117a = view;
        cVar.f43118b = obj;
        cVar.f43119c = z;
        if (i >= 0 && i <= this.f43114g.size()) {
            this.f43114g.add(i, cVar);
        } else {
            this.f43114g.add(cVar);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f43113f;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return super.hasStableIds();
    }

    public final boolean i(ArrayList<c> arrayList) {
        if (arrayList != null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f43119c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f43113f;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int i2;
        int n = n();
        if (i < n) {
            return this.f43114g.get(i).f43119c;
        }
        int i3 = i - n;
        ListAdapter listAdapter = this.f43113f;
        if (listAdapter != null) {
            i2 = listAdapter.getCount();
            if (i3 < i2) {
                return this.f43113f.isEnabled(i3);
            }
        } else {
            i2 = 0;
        }
        int i4 = i3 - i2;
        if (i4 < 0 || i4 >= this.f43115h.size()) {
            return false;
        }
        return this.f43115h.get(i4).f43119c;
    }

    public final View j() {
        TextView textView = new TextView(this.f43112e);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int e2 = d.b.c.e.p.l.e(this.f43112e, 15.0f);
        textView.setPadding(e2, e2, e2, e2);
        return textView;
    }

    public int k() {
        return this.f43115h.size();
    }

    public int l() {
        return this.f43115h.size();
    }

    public int m() {
        return this.f43114g.size();
    }

    public int n() {
        return this.f43114g.size();
    }

    @Override // android.widget.BaseAdapter, d.b.c.j.e.o
    public void notifyDataSetChanged() {
        if (d.b.c.e.p.l.B()) {
            super.notifyDataSetChanged();
        }
    }

    public int o() {
        ListAdapter listAdapter = this.f43113f;
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
        for (int i = 0; i < this.f43115h.size(); i++) {
            if (this.f43115h.get(i).f43117a == view) {
                this.f43115h.remove(i);
                if (i(this.f43114g) && i(this.f43115h)) {
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
        for (int i = 0; i < this.f43114g.size(); i++) {
            if (this.f43114g.get(i).f43117a == view) {
                this.f43114g.remove(i);
                if (i(this.f43114g) && i(this.f43115h)) {
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
        ListAdapter listAdapter2 = this.f43113f;
        this.f43113f = listAdapter;
        if (listAdapter != null) {
            boolean z = listAdapter instanceof Filterable;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.j = dataSetObserver;
        ListAdapter listAdapter = this.f43113f;
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
        ListAdapter listAdapter = this.f43113f;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(this.k);
        }
    }
}
