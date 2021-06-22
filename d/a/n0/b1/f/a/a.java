package d.a.n0.b1.f.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.a.n0.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<T> extends b {

    /* renamed from: b  reason: collision with root package name */
    public int f52792b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f52793c;

    /* renamed from: d  reason: collision with root package name */
    public Context f52794d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f52795e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f52796f;

    /* renamed from: d.a.n0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1166a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public T f52797e;

        /* renamed from: f  reason: collision with root package name */
        public int f52798f;

        public View$OnClickListenerC1166a(T t, int i2) {
            this.f52797e = t;
            this.f52798f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar = a.this.f52796f;
            if (eVar != null) {
                T t = this.f52797e;
                int i2 = this.f52798f;
                eVar.a(view, t, i2, i2);
            }
        }
    }

    public a(Context context, List<T> list, int i2) {
        this.f52794d = context;
        this.f52793c = list == null ? new ArrayList() : new ArrayList(list);
        this.f52792b = i2;
        this.f52795e = LayoutInflater.from(this.f52794d);
    }

    @Override // d.a.n0.b1.f.a.b
    public int a() {
        return this.f52793c.size();
    }

    @Override // d.a.n0.b1.f.a.b
    public View b(int i2, ViewGroup viewGroup) {
        View inflate = this.f52795e.inflate(this.f52792b, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.f52793c.get(i2);
        f(cVar, t, i2);
        cVar.c(new View$OnClickListenerC1166a(t, i2));
        return inflate;
    }

    public abstract void f(c cVar, T t, int i2);

    public void g(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f52793c = list;
        c();
    }

    public void h(e<T> eVar) {
        this.f52796f = eVar;
    }

    public a(Context context, int i2) {
        this(context, null, i2);
    }
}
