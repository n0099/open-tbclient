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
    protected final int nxI;

    public abstract void a(C0940a c0940a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nxI = i;
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
        C0940a c0940a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(Kt(getItemViewType(i)), viewGroup, false);
            c0940a = new C0940a(view);
            view.setTag(c0940a);
        } else {
            c0940a = (C0940a) view.getTag();
        }
        a(c0940a, this.data.get(i));
        return view;
    }

    protected int Kt(int i) {
        return this.nxI;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0940a {
        public View jja;
        private final SparseArray<View> nxS = new SparseArray<>();

        public C0940a(View view) {
            this.jja = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View or(int i) {
            View view = this.nxS.get(i);
            if (view == null) {
                View findViewById = this.jja.findViewById(i);
                this.nxS.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
