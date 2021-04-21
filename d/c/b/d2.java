package d.c.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d2 extends v1 {
    public static final long[] i = {60000};

    /* renamed from: d  reason: collision with root package name */
    public final i f65910d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f65911e;

    /* renamed from: f  reason: collision with root package name */
    public final j f65912f;

    /* renamed from: g  reason: collision with root package name */
    public long f65913g;

    /* renamed from: h  reason: collision with root package name */
    public long f65914h;

    public d2(Context context, a0 a0Var, i iVar, j jVar) {
        super(context);
        this.f65911e = a0Var;
        this.f65910d = iVar;
        this.f65912f = jVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        long U = this.f65910d.U();
        if (U > 60000 || U <= 0) {
            U = 60000;
        }
        i[0] = U;
        return this.f65913g + U;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return i;
    }

    @Override // d.c.b.v1
    public boolean d() {
        f0 c2;
        if (System.currentTimeMillis() > this.f65914h + this.f65910d.U()) {
            JSONObject i2 = this.f65912f.i();
            e2 i3 = x1.i();
            if (i3 != null && i2 != null && (c2 = i3.c()) != null) {
                this.f65911e.n(i2, c2, i3.h());
                this.f65914h = System.currentTimeMillis();
            }
        }
        ArrayList<g0> e2 = this.f65911e.e();
        ArrayList<g0> arrayList = new ArrayList<>(e2.size());
        ArrayList<g0> arrayList2 = new ArrayList<>(e2.size());
        String[] b2 = y.b(this.f66028a, this.f65912f.c());
        Iterator<g0> it = e2.iterator();
        while (it.hasNext()) {
            g0 next = it.next();
            int a2 = x.a(b2, next.m, this.f65910d);
            if (a2 == 200) {
                arrayList.add(next);
            } else {
                next.o = a2;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.f65911e.k(arrayList, arrayList2);
        }
        r0.e(e() + arrayList.size() + " " + e2.size(), null);
        if (arrayList.size() == e2.size()) {
            this.f65913g = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // d.c.b.v1
    public String e() {
        return "s";
    }
}
