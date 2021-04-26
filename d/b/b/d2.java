package d.b.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d2 extends v1 {

    /* renamed from: i  reason: collision with root package name */
    public static final long[] f64265i = {60000};

    /* renamed from: d  reason: collision with root package name */
    public final i f64266d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f64267e;

    /* renamed from: f  reason: collision with root package name */
    public final j f64268f;

    /* renamed from: g  reason: collision with root package name */
    public long f64269g;

    /* renamed from: h  reason: collision with root package name */
    public long f64270h;

    public d2(Context context, a0 a0Var, i iVar, j jVar) {
        super(context);
        this.f64267e = a0Var;
        this.f64266d = iVar;
        this.f64268f = jVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        long U = this.f64266d.U();
        if (U > 60000 || U <= 0) {
            U = 60000;
        }
        f64265i[0] = U;
        return this.f64269g + U;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return f64265i;
    }

    @Override // d.b.b.v1
    public boolean d() {
        f0 c2;
        if (System.currentTimeMillis() > this.f64270h + this.f64266d.U()) {
            JSONObject i2 = this.f64268f.i();
            e2 i3 = x1.i();
            if (i3 != null && i2 != null && (c2 = i3.c()) != null) {
                this.f64267e.n(i2, c2, i3.h());
                this.f64270h = System.currentTimeMillis();
            }
        }
        ArrayList<g0> e2 = this.f64267e.e();
        ArrayList<g0> arrayList = new ArrayList<>(e2.size());
        ArrayList<g0> arrayList2 = new ArrayList<>(e2.size());
        String[] b2 = y.b(this.f64388a, this.f64268f.c());
        Iterator<g0> it = e2.iterator();
        while (it.hasNext()) {
            g0 next = it.next();
            int a2 = x.a(b2, next.m, this.f64266d);
            if (a2 == 200) {
                arrayList.add(next);
            } else {
                next.o = a2;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.f64267e.k(arrayList, arrayList2);
        }
        r0.e(e() + arrayList.size() + " " + e2.size(), null);
        if (arrayList.size() == e2.size()) {
            this.f64269g = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // d.b.b.v1
    public String e() {
        return "s";
    }
}
