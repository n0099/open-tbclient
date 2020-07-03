package tv.chushou.zues.widget.adapterview.abslistview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a<T> extends BaseAdapter {
    protected Context context;
    protected List<T> data;
    protected final int nxF;

    public abstract void a(C0939a c0939a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nxF = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        if (this.data == null || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0939a c0939a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(Kt(getItemViewType(i)), viewGroup, false);
            c0939a = new C0939a(view);
            view.setTag(c0939a);
        } else {
            c0939a = (C0939a) view.getTag();
        }
        a(c0939a, this.data.get(i));
        return view;
    }

    protected int Kt(int i) {
        return this.nxF;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0939a {
        public View jja;
        private final SparseArray<View> nxP = new SparseArray<>();

        public C0939a(View view) {
            this.jja = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View or(int i) {
            View view = this.nxP.get(i);
            if (view == null) {
                View findViewById = this.jja.findViewById(i);
                this.nxP.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
