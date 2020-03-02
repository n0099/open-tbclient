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
    protected final int nhT;

    public abstract void a(C0812a c0812a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nhT = i;
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
        C0812a c0812a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(MZ(getItemViewType(i)), viewGroup, false);
            c0812a = new C0812a(view);
            view.setTag(c0812a);
        } else {
            c0812a = (C0812a) view.getTag();
        }
        a(c0812a, this.data.get(i));
        return view;
    }

    protected int MZ(int i) {
        return this.nhT;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0812a {
        public View hQI;
        private final SparseArray<View> nie = new SparseArray<>();

        public C0812a(View view) {
            this.hQI = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View Oo(int i) {
            View view = this.nie.get(i);
            if (view == null) {
                View findViewById = this.hQI.findViewById(i);
                this.nie.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
