package i.a.a.e.o.c;

import android.content.Context;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class a<T> extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<T> f72188e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f72189f;

    public a(Context context) {
        this.f72189f = context;
    }

    public List<T> a() {
        return this.f72188e;
    }

    public void b(List<T> list) {
        c(list, true);
    }

    public final void c(List<T> list, boolean z) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (z) {
            this.f72188e.clear();
        }
        this.f72188e.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f72188e.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        if (this.f72188e.size() == 0) {
            return null;
        }
        List<T> list = this.f72188e;
        return list.get(i2 % list.size());
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }
}
