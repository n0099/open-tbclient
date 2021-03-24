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
    public int f49867b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f49868c;

    /* renamed from: d  reason: collision with root package name */
    public Context f49869d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f49870e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f49871f;

    /* renamed from: d.b.h0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1050a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public T f49872e;

        /* renamed from: f  reason: collision with root package name */
        public int f49873f;

        public View$OnClickListenerC1050a(T t, int i) {
            this.f49872e = t;
            this.f49873f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar = a.this.f49871f;
            if (eVar != null) {
                T t = this.f49872e;
                int i = this.f49873f;
                eVar.a(view, t, i, i);
            }
        }
    }

    public a(Context context, List<T> list, int i) {
        this.f49869d = context;
        this.f49868c = list == null ? new ArrayList() : new ArrayList(list);
        this.f49867b = i;
        this.f49870e = LayoutInflater.from(this.f49869d);
    }

    @Override // d.b.h0.b1.f.a.b
    public int a() {
        return this.f49868c.size();
    }

    @Override // d.b.h0.b1.f.a.b
    public View b(int i, ViewGroup viewGroup) {
        View inflate = this.f49870e.inflate(this.f49867b, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.f49868c.get(i);
        f(cVar, t, i);
        cVar.c(new View$OnClickListenerC1050a(t, i));
        return inflate;
    }

    public abstract void f(c cVar, T t, int i);

    public void g(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f49868c = list;
        c();
    }

    public void h(e<T> eVar) {
        this.f49871f = eVar;
    }

    public a(Context context, int i) {
        this(context, null, i);
    }
}
