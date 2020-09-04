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
    protected final int oaC;

    public abstract void a(C1013a c1013a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.oaC = i;
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
        C1013a c1013a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(Nr(getItemViewType(i)), viewGroup, false);
            c1013a = new C1013a(view);
            view.setTag(c1013a);
        } else {
            c1013a = (C1013a) view.getTag();
        }
        a(c1013a, this.data.get(i));
        return view;
    }

    protected int Nr(int i) {
        return this.oaC;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1013a {
        public View oNK;
        private final SparseArray<View> oaM = new SparseArray<>();

        public C1013a(View view) {
            this.oNK = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View qW(int i) {
            View view = this.oaM.get(i);
            if (view == null) {
                View findViewById = this.oNK.findViewById(i);
                this.oaM.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
