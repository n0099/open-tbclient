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
    public Context f42928e;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f42930g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f42931h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42932i;
    public DataSetObserver k;

    /* renamed from: f  reason: collision with root package name */
    public ListAdapter f42929f = null;
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
        public View f42934a;

        /* renamed from: b  reason: collision with root package name */
        public Object f42935b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42936c;

        public c(e eVar) {
        }
    }

    public e(Context context) {
        this.f42928e = null;
        this.f42930g = null;
        this.f42931h = null;
        boolean z = false;
        this.f42932i = false;
        this.k = null;
        this.f42928e = context;
        this.f42930g = new ArrayList<>();
        this.f42931h = new ArrayList<>();
        if (i(this.f42930g) && i(this.f42931h)) {
            z = true;
        }
        this.f42932i = z;
        this.k = new a();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f42929f;
        if (listAdapter != null) {
            return this.f42932i && listAdapter.areAllItemsEnabled();
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
        cVar.f42934a = view;
        cVar.f42935b = obj;
        cVar.f42936c = z;
        if (i2 >= 0 && i2 <= this.f42931h.size()) {
            this.f42931h.add(i2, cVar);
        } else {
            this.f42931h.add(cVar);
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
        if (this.f42929f != null) {
            l = l() + n();
            n = this.f42929f.getCount();
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
            return this.f42930g.get(i2).f42935b;
        }
        int i3 = i2 - n;
        int i4 = 0;
        ListAdapter listAdapter = this.f42929f;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            return this.f42929f.getItem(i3);
        }
        int i5 = i3 - i4;
        if (i5 < 0 || i5 >= this.f42931h.size()) {
            return null;
        }
        return this.f42931h.get(i5).f42935b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        int i3;
        int n = n();
        ListAdapter listAdapter = this.f42929f;
        if (listAdapter == null || i2 < n || (i3 = i2 - n) >= listAdapter.getCount()) {
            return Long.MIN_VALUE;
        }
        return this.f42929f.getItemId(i3);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        int i3;
        int n = n();
        ListAdapter listAdapter = this.f42929f;
        if (listAdapter == null || i2 < n || (i3 = i2 - n) >= listAdapter.getCount()) {
            return -2;
        }
        return this.f42929f.getItemViewType(i3);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int n = n();
        if (i2 < n) {
            View view2 = this.f42930g.get(i2).f42934a;
            return view2 == null ? j() : view2;
        }
        int i3 = i2 - n;
        int i4 = 0;
        ListAdapter listAdapter = this.f42929f;
        View view3 = null;
        if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
            try {
                view3 = this.f42929f.getView(i3, view, viewGroup);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    BdLog.detailException(e2);
                    Log.e("BdListAdapter", e2.getMessage());
                    e2.printStackTrace();
                }
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
                view3 = this.f42929f.getView(i3, view, viewGroup);
            }
            return view3 == null ? j() : view3;
        }
        try {
            view3 = this.f42931h.get(i3 - i4).f42934a;
        } catch (Exception e3) {
            BdLog.detailException(e3);
        }
        return view3 == null ? j() : view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        ListAdapter listAdapter = this.f42929f;
        if (listAdapter != null) {
            return listAdapter.getViewTypeCount() + 1;
        }
        return 1;
    }

    public ListAdapter getWrappedAdapter() {
        return this.f42929f;
    }

    public void h(View view, Object obj, boolean z, int i2) {
        if (view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f42934a = view;
        cVar.f42935b = obj;
        cVar.f42936c = z;
        if (i2 >= 0 && i2 <= this.f42930g.size()) {
            this.f42930g.add(i2, cVar);
        } else {
            this.f42930g.add(cVar);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        ListAdapter listAdapter = this.f42929f;
        if (listAdapter != null) {
            return listAdapter.hasStableIds();
        }
        return super.hasStableIds();
    }

    public final boolean i(ArrayList<c> arrayList) {
        if (arrayList != null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().f42936c) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ListAdapter listAdapter = this.f42929f;
        return listAdapter == null || listAdapter.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        int i3;
        int n = n();
        if (i2 < n) {
            return this.f42930g.get(i2).f42936c;
        }
        int i4 = i2 - n;
        ListAdapter listAdapter = this.f42929f;
        if (listAdapter != null) {
            i3 = listAdapter.getCount();
            if (i4 < i3) {
                return this.f42929f.isEnabled(i4);
            }
        } else {
            i3 = 0;
        }
        int i5 = i4 - i3;
        if (i5 < 0 || i5 >= this.f42931h.size()) {
            return false;
        }
        return this.f42931h.get(i5).f42936c;
    }

    public final View j() {
        TextView textView = new TextView(this.f42928e);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int e2 = d.a.c.e.p.l.e(this.f42928e, 15.0f);
        textView.setPadding(e2, e2, e2, e2);
        return textView;
    }

    public int k() {
        return this.f42931h.size();
    }

    public int l() {
        return this.f42931h.size();
    }

    public int m() {
        return this.f42930g.size();
    }

    public int n() {
        return this.f42930g.size();
    }

    @Override // android.widget.BaseAdapter, d.a.c.k.e.o
    public void notifyDataSetChanged() {
        if (d.a.c.e.p.l.C()) {
            super.notifyDataSetChanged();
        }
    }

    public int o() {
        ListAdapter listAdapter = this.f42929f;
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
        for (int i2 = 0; i2 < this.f42931h.size(); i2++) {
            if (this.f42931h.get(i2).f42934a == view) {
                this.f42931h.remove(i2);
                if (i(this.f42930g) && i(this.f42931h)) {
                    z = true;
                }
                this.f42932i = z;
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
        for (int i2 = 0; i2 < this.f42930g.size(); i2++) {
            if (this.f42930g.get(i2).f42934a == view) {
                this.f42930g.remove(i2);
                if (i(this.f42930g) && i(this.f42931h)) {
                    z = true;
                }
                this.f42932i = z;
                notifyDataSetChanged();
                return true;
            }
        }
        return false;
    }

    public void r(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f42929f;
        this.f42929f = listAdapter;
        if (listAdapter != null) {
            boolean z = listAdapter instanceof Filterable;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.j = dataSetObserver;
        ListAdapter listAdapter = this.f42929f;
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
        ListAdapter listAdapter = this.f42929f;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(this.k);
        }
    }
}
