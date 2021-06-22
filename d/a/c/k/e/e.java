package d.a.c.k.e;

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
    public Context f43031e;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f43033g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f43034h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43035i;
    public DataSetObserver k;

    /* renamed from: f  reason: collision with root package name */
    public ListAdapter f43032f = null;
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
        public View f43037a;

        /* renamed from: b  reason: collision with root package name */
        public Object f43038b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43039c;

        public c(e eVar) {
        }
    }

    public e(Context context) {
        this.f43031e = null;
        this.f43033g = null;
        this.f43034h = null;
        boolean z = false;
        this.f43035i = false;
        this.k = null;
        this.f43031e = context;
        this.f43033g = new ArrayList<>();
        this.f43034h = new ArrayList<>();
        if (i(this.f43033g) && i(this.f43034h)) {
            z = true;
        }
        this.f43035i = z;
        this.k = new a();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f43032f;
        if (listAdapter != null) {
            return this.f43035i && listAdapter.areAllItemsEnabled();
        }
        return super.areAllItemsEnabled();
    }

    public void e(View view) {
        f(view, null, true, -1);
    }

    public void f(View view, Object obj, boolean z, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f43037a = view;
        cVar.f43038b = obj;
        cVar.f43039c = z;
        if (i2 >= 0 && i2 <= this.f43034h.size()) {
            this.f43034h.add(i2, cVar);
        } else {
            this.f43034h.add(cVar);
        }
        notifyDataSetChanged();
    }

    public void g(View view, int i2) {
        h(view, null, true, i2);
    }

    @Override // android.widget.Adapter, d.a.c.k.e.o
    public int getCount() {
        int l;
        int n;
        if (this.f43032f != null) {
            l = l() + n();
            n = this.f43032f.getCount();
        } else {
            l = l();
            n = n();
        }
        return l + n;
    }

    @Override // android.widget.Adapter, d.a.c.k.e.o
    public Object getItem(int i2) {
        int n = n();
        if (i2 < n) {
            return this.f43033g.get(i2).f43038b;
        }
        int i3 = i2 - n;
        int i4 = 0;
        ListAdapter listAdapter = this.f43032f;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f43032f.getItem(i3);
        }
        int i5 = i3 - i4;
        if (i5 < 0 || i5 >= this.f43034h.size()) {
            return null;
        }
        return this.f43034h.get(i5).f43038b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        int i3;
        int n = n();
        ListAdapter listAdapter = this.f43032f;
        if (listAdapter == null || i2 < n || (i3 = i2 - n) >= listAdapter.getCount()) {
            return Long.MIN_VALUE;
        }
        return this.f43032f.getItemId(i3);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        int i3;
        int n = n();
        ListAdapter listAdapter = this.f43032f;
        if (listAdapter == null || i2 < n || (i3 = i2 - n) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f43032f.getItemViewType(i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int n = n();
        if (i2 < n) {
            View view2 = this.f43033g.get(i2).f43037a;
            return view2 == null ? j() : view2;
        }
        int i3 = i2 - n;
        int i4 = 0;
        ListAdapter listAdapter = this.f43032f;
        View view3 = null;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            try {
                view3 = this.f43032f.getView(i3, view, viewGroup);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    BdLog.detailException(e2);
                    Log.e("BdListAdapter", e2.getMessage());
                    e2.printStackTrace();
                }
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
                view3 = this.f43032f.getView(i3, view, viewGroup);
            }
            return view3 == null ? j() : view3;
        }
        try {
            view3 = this.f43034h.get(i3 - i4).f43037a;
        } catch (Exception e3) {
            BdLog.detailException(e3);
        }
        return view3 == null ? j() : view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f43032f;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount() + 1;
        }
        return 1;
    }

    public ListAdapter getWrappedAdapter() {
        return this.f43032f;
    }

    public void h(View view, Object obj, boolean z, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f43037a = view;
        cVar.f43038b = obj;
        cVar.f43039c = z;
        if (i2 >= 0 && i2 <= this.f43033g.size()) {
            this.f43033g.add(i2, cVar);
        } else {
            this.f43033g.add(cVar);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f43032f;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return super.hasStableIds();
    }

    public final boolean i(ArrayList<c> arrayList) {
        if (arrayList != null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f43039c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f43032f;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        int i3;
        int n = n();
        if (i2 < n) {
            return this.f43033g.get(i2).f43039c;
        }
        int i4 = i2 - n;
        ListAdapter listAdapter = this.f43032f;
        if (listAdapter != null) {
            i3 = listAdapter.getCount();
            if (i4 < i3) {
                return this.f43032f.isEnabled(i4);
            }
        } else {
            i3 = 0;
        }
        int i5 = i4 - i3;
        if (i5 < 0 || i5 >= this.f43034h.size()) {
            return false;
        }
        return this.f43034h.get(i5).f43039c;
    }

    public final View j() {
        TextView textView = new TextView(this.f43031e);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int e2 = d.a.c.e.p.l.e(this.f43031e, 15.0f);
        textView.setPadding(e2, e2, e2, e2);
        return textView;
    }

    public int k() {
        return this.f43034h.size();
    }

    public int l() {
        return this.f43034h.size();
    }

    public int m() {
        return this.f43033g.size();
    }

    public int n() {
        return this.f43033g.size();
    }

    @Override // android.widget.BaseAdapter, d.a.c.k.e.o
    public void notifyDataSetChanged() {
        if (d.a.c.e.p.l.C()) {
            super.notifyDataSetChanged();
        }
    }

    public int o() {
        ListAdapter listAdapter = this.f43032f;
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
        for (int i2 = 0; i2 < this.f43034h.size(); i2++) {
            if (this.f43034h.get(i2).f43037a == view) {
                this.f43034h.remove(i2);
                if (i(this.f43033g) && i(this.f43034h)) {
                    z = true;
                }
                this.f43035i = z;
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
        for (int i2 = 0; i2 < this.f43033g.size(); i2++) {
            if (this.f43033g.get(i2).f43037a == view) {
                this.f43033g.remove(i2);
                if (i(this.f43033g) && i(this.f43034h)) {
                    z = true;
                }
                this.f43035i = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public void r(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f43032f;
        this.f43032f = listAdapter;
        if (listAdapter != null) {
            boolean z = listAdapter instanceof Filterable;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.j = dataSetObserver;
        ListAdapter listAdapter = this.f43032f;
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
        ListAdapter listAdapter = this.f43032f;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(this.k);
        }
    }
}
