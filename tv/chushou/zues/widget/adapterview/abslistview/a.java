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
    protected final int okq;

    public abstract void a(C1010a c1010a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.okq = i;
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
        C1010a c1010a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(NW(getItemViewType(i)), viewGroup, false);
            c1010a = new C1010a(view);
            view.setTag(c1010a);
        } else {
            c1010a = (C1010a) view.getTag();
        }
        a(c1010a, this.data.get(i));
        return view;
    }

    protected int NW(int i) {
        return this.okq;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1010a {
        public View oXm;
        private final SparseArray<View> okA = new SparseArray<>();

        public C1010a(View view) {
            this.oXm = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View rn(int i) {
            View view = this.okA.get(i);
            if (view == null) {
                View findViewById = this.oXm.findViewById(i);
                this.okA.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
