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
    protected final int pAz;

    public abstract void a(C1120a c1120a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.pAz = i;
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
        C1120a c1120a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(QO(getItemViewType(i)), viewGroup, false);
            c1120a = new C1120a(view);
            view.setTag(c1120a);
        } else {
            c1120a = (C1120a) view.getTag();
        }
        a(c1120a, this.data.get(i));
        return view;
    }

    protected int QO(int i) {
        return this.pAz;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1120a {
        private final SparseArray<View> pAJ = new SparseArray<>();
        public View qnq;

        public C1120a(View view) {
            this.qnq = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View sg(int i) {
            View view = this.pAJ.get(i);
            if (view == null) {
                View findViewById = this.qnq.findViewById(i);
                this.pAJ.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
