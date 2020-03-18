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
    protected final int njS;

    public abstract void a(C0813a c0813a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.njS = i;
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
        C0813a c0813a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(Nf(getItemViewType(i)), viewGroup, false);
            c0813a = new C0813a(view);
            view.setTag(c0813a);
        } else {
            c0813a = (C0813a) view.getTag();
        }
        a(c0813a, this.data.get(i));
        return view;
    }

    protected int Nf(int i) {
        return this.njS;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0813a {
        public View hSu;
        private final SparseArray<View> nkc = new SparseArray<>();

        public C0813a(View view) {
            this.hSu = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View Ou(int i) {
            View view = this.nkc.get(i);
            if (view == null) {
                View findViewById = this.hSu.findViewById(i);
                this.nkc.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
