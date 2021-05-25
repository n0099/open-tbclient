package d.b.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d2 extends v1 {

    /* renamed from: i  reason: collision with root package name */
    public static final long[] f64994i = {60000};

    /* renamed from: d  reason: collision with root package name */
    public final i f64995d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f64996e;

    /* renamed from: f  reason: collision with root package name */
    public final j f64997f;

    /* renamed from: g  reason: collision with root package name */
    public long f64998g;

    /* renamed from: h  reason: collision with root package name */
    public long f64999h;

    public d2(Context context, a0 a0Var, i iVar, j jVar) {
        super(context);
        this.f64996e = a0Var;
        this.f64995d = iVar;
        this.f64997f = jVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        long U = this.f64995d.U();
        if (U > 60000 || U <= 0) {
            U = 60000;
        }
        f64994i[0] = U;
        return this.f64998g + U;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return f64994i;
    }

    @Override // d.b.b.v1
    public boolean d() {
        f0 c2;
        if (System.currentTimeMillis() > this.f64999h + this.f64995d.U()) {
            JSONObject i2 = this.f64997f.i();
            e2 i3 = x1.i();
            if (i3 != null && i2 != null && (c2 = i3.c()) != null) {
                this.f64996e.n(i2, c2, i3.h());
                this.f64999h = System.currentTimeMillis();
            }
        }
        ArrayList<g0> e2 = this.f64996e.e();
        ArrayList<g0> arrayList = new ArrayList<>(e2.size());
        ArrayList<g0> arrayList2 = new ArrayList<>(e2.size());
        String[] b2 = y.b(this.f65117a, this.f64997f.c());
        Iterator<g0> it = e2.iterator();
        while (it.hasNext()) {
            g0 next = it.next();
            int a2 = x.a(b2, next.m, this.f64995d);
            if (a2 == 200) {
                arrayList.add(next);
            } else {
                next.o = a2;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.f64996e.k(arrayList, arrayList2);
        }
        r0.e(e() + arrayList.size() + " " + e2.size(), null);
        if (arrayList.size() == e2.size()) {
            this.f64998g = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // d.b.b.v1
    public String e() {
        return "s";
    }
}
