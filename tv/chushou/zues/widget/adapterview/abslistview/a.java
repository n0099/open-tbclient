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
    protected final int mGz;

    public abstract void a(C0836a c0836a, T t);

    public a(Context context, List<T> list, int i) {
        this.context = context;
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.mGz = i;
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
        C0836a c0836a;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(Iz(getItemViewType(i)), viewGroup, false);
            c0836a = new C0836a(view);
            view.setTag(c0836a);
        } else {
            c0836a = (C0836a) view.getTag();
        }
        a(c0836a, this.data.get(i));
        return view;
    }

    protected int Iz(int i) {
        return this.mGz;
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.abslistview.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0836a {
        public View iCl;
        private final SparseArray<View> mGJ = new SparseArray<>();

        public C0836a(View view) {
            this.iCl = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View JQ(int i) {
            View view = this.mGJ.get(i);
            if (view == null) {
                View findViewById = this.iCl.findViewById(i);
                this.mGJ.put(i, findViewById);
                return findViewById;
            }
            return view;
        }
    }
}
