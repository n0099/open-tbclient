package d.b.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d2 extends v1 {

    /* renamed from: i  reason: collision with root package name */
    public static final long[] f68829i = {60000};

    /* renamed from: d  reason: collision with root package name */
    public final i f68830d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f68831e;

    /* renamed from: f  reason: collision with root package name */
    public final j f68832f;

    /* renamed from: g  reason: collision with root package name */
    public long f68833g;

    /* renamed from: h  reason: collision with root package name */
    public long f68834h;

    public d2(Context context, a0 a0Var, i iVar, j jVar) {
        super(context);
        this.f68831e = a0Var;
        this.f68830d = iVar;
        this.f68832f = jVar;
    }

    @Override // d.b.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.b.b.v1
    public long b() {
        long U = this.f68830d.U();
        if (U > 60000 || U <= 0) {
            U = 60000;
        }
        f68829i[0] = U;
        return this.f68833g + U;
    }

    @Override // d.b.b.v1
    public long[] c() {
        return f68829i;
    }

    @Override // d.b.b.v1
    public boolean d() {
        f0 c2;
        if (System.currentTimeMillis() > this.f68834h + this.f68830d.U()) {
            JSONObject i2 = this.f68832f.i();
            e2 i3 = x1.i();
            if (i3 != null && i2 != null && (c2 = i3.c()) != null) {
                this.f68831e.n(i2, c2, i3.h());
                this.f68834h = System.currentTimeMillis();
            }
        }
        ArrayList<g0> e2 = this.f68831e.e();
        ArrayList<g0> arrayList = new ArrayList<>(e2.size());
        ArrayList<g0> arrayList2 = new ArrayList<>(e2.size());
        String[] b2 = y.b(this.f68952a, this.f68832f.c());
        Iterator<g0> it = e2.iterator();
        while (it.hasNext()) {
            g0 next = it.next();
            int a2 = x.a(b2, next.m, this.f68830d);
            if (a2 == 200) {
                arrayList.add(next);
            } else {
                next.o = a2;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.f68831e.k(arrayList, arrayList2);
        }
        r0.e(e() + arrayList.size() + " " + e2.size(), null);
        if (arrayList.size() == e2.size()) {
            this.f68833g = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // d.b.b.v1
    public String e() {
        return "s";
    }
}
