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
    protected final int naE;

    public abstract void a(C0919a c0919a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.naE = i;
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
        C0919a c0919a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(Jk(getItemViewType(i)), viewGroup, false);
            c0919a = new C0919a(view);
            view.setTag(c0919a);
        } else {
            c0919a = (C0919a) view.getTag();
        }
        a(c0919a, this.data.get(i));
        return view;
    }

    protected int Jk(int i) {
        return this.naE;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0919a {
        public View iRb;
        private final SparseArray<View> naO = new SparseArray<>();

        public C0919a(View view) {
            this.iRb = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View KB(int i) {
            View view = this.naO.get(i);
            if (view == null) {
                View findViewById = this.iRb.findViewById(i);
                this.naO.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
