package tv.chushou.zues.widget.adapterview.abslistview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<T> extends BaseAdapter {
    protected Context context;
    protected List<T> data;
    protected final int nGt;

    public abstract void a(C0955a c0955a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nGt = i;
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
        C0955a c0955a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(KN(getItemViewType(i)), viewGroup, false);
            c0955a = new C0955a(view);
            view.setTag(c0955a);
        } else {
            c0955a = (C0955a) view.getTag();
        }
        a(c0955a, this.data.get(i));
        return view;
    }

    protected int KN(int i) {
        return this.nGt;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0955a {
        private final SparseArray<View> nGD = new SparseArray<>();
        public View otA;

        public C0955a(View view) {
            this.otA = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View oK(int i) {
            View view = this.nGD.get(i);
            if (view == null) {
                View findViewById = this.otA.findViewById(i);
                this.nGD.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
