package d.a.j0.b1.f.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.a.j0.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<T> extends b {

    /* renamed from: b  reason: collision with root package name */
    public int f48986b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f48987c;

    /* renamed from: d  reason: collision with root package name */
    public Context f48988d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f48989e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f48990f;

    /* renamed from: d.a.j0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1100a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public T f48991e;

        /* renamed from: f  reason: collision with root package name */
        public int f48992f;

        public View$OnClickListenerC1100a(T t, int i2) {
            this.f48991e = t;
            this.f48992f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar = a.this.f48990f;
            if (eVar != null) {
                T t = this.f48991e;
                int i2 = this.f48992f;
                eVar.a(view, t, i2, i2);
            }
        }
    }

    public a(Context context, List<T> list, int i2) {
        this.f48988d = context;
        this.f48987c = list == null ? new ArrayList() : new ArrayList(list);
        this.f48986b = i2;
        this.f48989e = LayoutInflater.from(this.f48988d);
    }

    @Override // d.a.j0.b1.f.a.b
    public int a() {
        return this.f48987c.size();
    }

    @Override // d.a.j0.b1.f.a.b
    public View b(int i2, ViewGroup viewGroup) {
        View inflate = this.f48989e.inflate(this.f48986b, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.f48987c.get(i2);
        f(cVar, t, i2);
        cVar.c(new View$OnClickListenerC1100a(t, i2));
        return inflate;
    }

    public abstract void f(c cVar, T t, int i2);

    public void g(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f48987c = list;
        c();
    }

    public void h(e<T> eVar) {
        this.f48990f = eVar;
    }

    public a(Context context, int i2) {
        this(context, null, i2);
    }
}
