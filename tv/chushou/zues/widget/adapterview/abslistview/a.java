package tv.chushou.zues.widget.adapterview.abslistview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a<T> extends BaseAdapter {
    protected Context context;
    protected List<T> data;
    protected final int nhj;

    public abstract void a(C0804a c0804a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nhj = i;
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
        C0804a c0804a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(MW(getItemViewType(i)), viewGroup, false);
            c0804a = new C0804a(view);
            view.setTag(c0804a);
        } else {
            c0804a = (C0804a) view.getTag();
        }
        a(c0804a, this.data.get(i));
        return view;
    }

    protected int MW(int i) {
        return this.nhj;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0804a {
        public View hOI;
        private final SparseArray<View> nht = new SparseArray<>();

        public C0804a(View view) {
            this.hOI = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View Ol(int i) {
            View view = this.nht.get(i);
            if (view == null) {
                View findViewById = this.hOI.findViewById(i);
                this.nht.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
