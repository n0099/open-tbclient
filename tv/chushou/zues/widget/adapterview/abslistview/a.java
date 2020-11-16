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
    protected final int pCc;

    public abstract void a(C1123a c1123a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.pCc = i;
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
        C1123a c1123a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(Rr(getItemViewType(i)), viewGroup, false);
            c1123a = new C1123a(view);
            view.setTag(c1123a);
        } else {
            c1123a = (C1123a) view.getTag();
        }
        a(c1123a, this.data.get(i));
        return view;
    }

    protected int Rr(int i) {
        return this.pCc;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1123a {
        private final SparseArray<View> pCm = new SparseArray<>();
        public View qoT;

        public C1123a(View view) {
            this.qoT = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View sE(int i) {
            View view = this.pCm.get(i);
            if (view == null) {
                View findViewById = this.qoT.findViewById(i);
                this.pCm.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
