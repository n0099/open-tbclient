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
    public int f49011b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f49012c;

    /* renamed from: d  reason: collision with root package name */
    public Context f49013d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f49014e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f49015f;

    /* renamed from: d.a.m0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1107a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public T f49016e;

        /* renamed from: f  reason: collision with root package name */
        public int f49017f;

        public View$OnClickListenerC1107a(T t, int i2) {
            this.f49016e = t;
            this.f49017f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar = a.this.f49015f;
            if (eVar != null) {
                T t = this.f49016e;
                int i2 = this.f49017f;
                eVar.a(view, t, i2, i2);
            }
        }
    }

    public a(Context context, List<T> list, int i2) {
        this.f49013d = context;
        this.f49012c = list == null ? new ArrayList() : new ArrayList(list);
        this.f49011b = i2;
        this.f49014e = LayoutInflater.from(this.f49013d);
    }

    @Override // d.a.m0.b1.f.a.b
    public int a() {
        return this.f49012c.size();
    }

    @Override // d.a.m0.b1.f.a.b
    public View b(int i2, ViewGroup viewGroup) {
        View inflate = this.f49014e.inflate(this.f49011b, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.f49012c.get(i2);
        f(cVar, t, i2);
        cVar.c(new View$OnClickListenerC1107a(t, i2));
        return inflate;
    }

    public abstract void f(c cVar, T t, int i2);

    public void g(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f49012c = list;
        c();
    }

    public void h(e<T> eVar) {
        this.f49015f = eVar;
    }

    public a(Context context, int i2) {
        this(context, null, i2);
    }
}
