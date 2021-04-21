package d.b.i0.b1.f.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.b.i0.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<T> extends b {

    /* renamed from: b  reason: collision with root package name */
    public int f50597b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f50598c;

    /* renamed from: d  reason: collision with root package name */
    public Context f50599d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f50600e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f50601f;

    /* renamed from: d.b.i0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1085a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public T f50602e;

        /* renamed from: f  reason: collision with root package name */
        public int f50603f;

        public View$OnClickListenerC1085a(T t, int i) {
            this.f50602e = t;
            this.f50603f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar = a.this.f50601f;
            if (eVar != null) {
                T t = this.f50602e;
                int i = this.f50603f;
                eVar.a(view, t, i, i);
            }
        }
    }

    public a(Context context, List<T> list, int i) {
        this.f50599d = context;
        this.f50598c = list == null ? new ArrayList() : new ArrayList(list);
        this.f50597b = i;
        this.f50600e = LayoutInflater.from(this.f50599d);
    }

    @Override // d.b.i0.b1.f.a.b
    public int a() {
        return this.f50598c.size();
    }

    @Override // d.b.i0.b1.f.a.b
    public View b(int i, ViewGroup viewGroup) {
        View inflate = this.f50600e.inflate(this.f50597b, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.f50598c.get(i);
        f(cVar, t, i);
        cVar.c(new View$OnClickListenerC1085a(t, i));
        return inflate;
    }

    public abstract void f(c cVar, T t, int i);

    public void g(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f50598c = list;
        c();
    }

    public void h(e<T> eVar) {
        this.f50601f = eVar;
    }

    public a(Context context, int i) {
        this(context, null, i);
    }
}
