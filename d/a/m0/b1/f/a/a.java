package d.a.m0.b1.f.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.a.m0.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<T> extends b {

    /* renamed from: b  reason: collision with root package name */
    public int f52685b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f52686c;

    /* renamed from: d  reason: collision with root package name */
    public Context f52687d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f52688e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f52689f;

    /* renamed from: d.a.m0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1163a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public T f52690e;

        /* renamed from: f  reason: collision with root package name */
        public int f52691f;

        public View$OnClickListenerC1163a(T t, int i2) {
            this.f52690e = t;
            this.f52691f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar = a.this.f52689f;
            if (eVar != null) {
                T t = this.f52690e;
                int i2 = this.f52691f;
                eVar.a(view, t, i2, i2);
            }
        }
    }

    public a(Context context, List<T> list, int i2) {
        this.f52687d = context;
        this.f52686c = list == null ? new ArrayList() : new ArrayList(list);
        this.f52685b = i2;
        this.f52688e = LayoutInflater.from(this.f52687d);
    }

    @Override // d.a.m0.b1.f.a.b
    public int a() {
        return this.f52686c.size();
    }

    @Override // d.a.m0.b1.f.a.b
    public View b(int i2, ViewGroup viewGroup) {
        View inflate = this.f52688e.inflate(this.f52685b, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.f52686c.get(i2);
        f(cVar, t, i2);
        cVar.c(new View$OnClickListenerC1163a(t, i2));
        return inflate;
    }

    public abstract void f(c cVar, T t, int i2);

    public void g(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f52686c = list;
        c();
    }

    public void h(e<T> eVar) {
        this.f52689f = eVar;
    }

    public a(Context context, int i2) {
        this(context, null, i2);
    }
}
