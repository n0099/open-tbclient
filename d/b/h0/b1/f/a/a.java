package d.b.h0.b1.f.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.b.h0.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<T> extends b {

    /* renamed from: b  reason: collision with root package name */
    public int f49868b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f49869c;

    /* renamed from: d  reason: collision with root package name */
    public Context f49870d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f49871e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f49872f;

    /* renamed from: d.b.h0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1051a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public T f49873e;

        /* renamed from: f  reason: collision with root package name */
        public int f49874f;

        public View$OnClickListenerC1051a(T t, int i) {
            this.f49873e = t;
            this.f49874f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar = a.this.f49872f;
            if (eVar != null) {
                T t = this.f49873e;
                int i = this.f49874f;
                eVar.a(view, t, i, i);
            }
        }
    }

    public a(Context context, List<T> list, int i) {
        this.f49870d = context;
        this.f49869c = list == null ? new ArrayList() : new ArrayList(list);
        this.f49868b = i;
        this.f49871e = LayoutInflater.from(this.f49870d);
    }

    @Override // d.b.h0.b1.f.a.b
    public int a() {
        return this.f49869c.size();
    }

    @Override // d.b.h0.b1.f.a.b
    public View b(int i, ViewGroup viewGroup) {
        View inflate = this.f49871e.inflate(this.f49868b, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.f49869c.get(i);
        f(cVar, t, i);
        cVar.c(new View$OnClickListenerC1051a(t, i));
        return inflate;
    }

    public abstract void f(c cVar, T t, int i);

    public void g(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f49869c = list;
        c();
    }

    public void h(e<T> eVar) {
        this.f49872f = eVar;
    }

    public a(Context context, int i) {
        this(context, null, i);
    }
}
