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
    protected final int nbO;

    public abstract void a(C0920a c0920a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nbO = i;
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
        C0920a c0920a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(Jm(getItemViewType(i)), viewGroup, false);
            c0920a = new C0920a(view);
            view.setTag(c0920a);
        } else {
            c0920a = (C0920a) view.getTag();
        }
        a(c0920a, this.data.get(i));
        return view;
    }

    protected int Jm(int i) {
        return this.nbO;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0920a {
        public View iRO;
        private final SparseArray<View> nbY = new SparseArray<>();

        public C0920a(View view) {
            this.iRO = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View KD(int i) {
            View view = this.nbY.get(i);
            if (view == null) {
                View findViewById = this.iRO.findViewById(i);
                this.nbY.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
