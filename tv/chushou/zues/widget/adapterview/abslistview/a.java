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
    protected final int ozJ;

    public abstract void a(C1028a c1028a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.ozJ = i;
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
        C1028a c1028a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(OC(getItemViewType(i)), viewGroup, false);
            c1028a = new C1028a(view);
            view.setTag(c1028a);
        } else {
            c1028a = (C1028a) view.getTag();
        }
        a(c1028a, this.data.get(i));
        return view;
    }

    protected int OC(int i) {
        return this.ozJ;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1028a {
        private final SparseArray<View> ozT = new SparseArray<>();
        public View pmG;

        public C1028a(View view) {
            this.pmG = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View rL(int i) {
            View view = this.ozT.get(i);
            if (view == null) {
                View findViewById = this.pmG.findViewById(i);
                this.ozT.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
