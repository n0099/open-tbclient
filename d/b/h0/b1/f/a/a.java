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
    public int f50261b;

    /* renamed from: c  reason: collision with root package name */
    public List<T> f50262c;

    /* renamed from: d  reason: collision with root package name */
    public Context f50263d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f50264e;

    /* renamed from: f  reason: collision with root package name */
    public e<T> f50265f;

    /* renamed from: d.b.h0.b1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1063a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public T f50266e;

        /* renamed from: f  reason: collision with root package name */
        public int f50267f;

        public View$OnClickListenerC1063a(T t, int i) {
            this.f50266e = t;
            this.f50267f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e<T> eVar = a.this.f50265f;
            if (eVar != null) {
                T t = this.f50266e;
                int i = this.f50267f;
                eVar.a(view, t, i, i);
            }
        }
    }

    public a(Context context, List<T> list, int i) {
        this.f50263d = context;
        this.f50262c = list == null ? new ArrayList() : new ArrayList(list);
        this.f50261b = i;
        this.f50264e = LayoutInflater.from(this.f50263d);
    }

    @Override // d.b.h0.b1.f.a.b
    public int a() {
        return this.f50262c.size();
    }

    @Override // d.b.h0.b1.f.a.b
    public View b(int i, ViewGroup viewGroup) {
        View inflate = this.f50264e.inflate(this.f50261b, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.f50262c.get(i);
        f(cVar, t, i);
        cVar.c(new View$OnClickListenerC1063a(t, i));
        return inflate;
    }

    public abstract void f(c cVar, T t, int i);

    public void g(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f50262c = list;
        c();
    }

    public void h(e<T> eVar) {
        this.f50265f = eVar;
    }

    public a(Context context, int i) {
        this(context, null, i);
    }
}
