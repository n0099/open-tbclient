package d.a.i0.b1.f.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.a.i0.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<T> extends b {

    /* renamed from: b  reason: collision with root package name */
    public int f48158b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f48159c;

    /* renamed from: d  reason: collision with root package name */
    public Context f48160d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f48161e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f48162f;

    /* renamed from: d.a.i0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1024a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public T f48163e;

        /* renamed from: f  reason: collision with root package name */
        public int f48164f;

        public View$OnClickListenerC1024a(T t, int i2) {
            this.f48163e = t;
            this.f48164f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar = a.this.f48162f;
            if (eVar != null) {
                T t = this.f48163e;
                int i2 = this.f48164f;
                eVar.a(view, t, i2, i2);
            }
        }
    }

    public a(Context context, List<T> list, int i2) {
        this.f48160d = context;
        this.f48159c = list == null ? new ArrayList() : new ArrayList(list);
        this.f48158b = i2;
        this.f48161e = LayoutInflater.from(this.f48160d);
    }

    @Override // d.a.i0.b1.f.a.b
    public int a() {
        return this.f48159c.size();
    }

    @Override // d.a.i0.b1.f.a.b
    public View b(int i2, ViewGroup viewGroup) {
        View inflate = this.f48161e.inflate(this.f48158b, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.f48159c.get(i2);
        f(cVar, t, i2);
        cVar.c(new View$OnClickListenerC1024a(t, i2));
        return inflate;
    }

    public abstract void f(c cVar, T t, int i2);

    public void g(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f48159c = list;
        c();
    }

    public void h(e<T> eVar) {
        this.f48162f = eVar;
    }

    public a(Context context, int i2) {
        this(context, null, i2);
    }
}
