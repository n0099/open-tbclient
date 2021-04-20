package d.c.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d2 extends v1 {
    public static final long[] i = {60000};

    /* renamed from: d  reason: collision with root package name */
    public final i f65815d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f65816e;

    /* renamed from: f  reason: collision with root package name */
    public final j f65817f;

    /* renamed from: g  reason: collision with root package name */
    public long f65818g;

    /* renamed from: h  reason: collision with root package name */
    public long f65819h;

    public d2(Context context, a0 a0Var, i iVar, j jVar) {
        super(context);
        this.f65816e = a0Var;
        this.f65815d = iVar;
        this.f65817f = jVar;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        long U = this.f65815d.U();
        if (U > 60000 || U <= 0) {
            U = 60000;
        }
        i[0] = U;
        return this.f65818g + U;
    }

    @Override // d.c.b.v1
    public long[] c() {
        return i;
    }

    @Override // d.c.b.v1
    public boolean d() {
        f0 c2;
        if (System.currentTimeMillis() > this.f65819h + this.f65815d.U()) {
            JSONObject i2 = this.f65817f.i();
            e2 i3 = x1.i();
            if (i3 != null && i2 != null && (c2 = i3.c()) != null) {
                this.f65816e.n(i2, c2, i3.h());
                this.f65819h = System.currentTimeMillis();
            }
        }
        ArrayList<g0> e2 = this.f65816e.e();
        ArrayList<g0> arrayList = new ArrayList<>(e2.size());
        ArrayList<g0> arrayList2 = new ArrayList<>(e2.size());
        String[] b2 = y.b(this.f65933a, this.f65817f.c());
        Iterator<g0> it = e2.iterator();
        while (it.hasNext()) {
            g0 next = it.next();
            int a2 = x.a(b2, next.m, this.f65815d);
            if (a2 == 200) {
                arrayList.add(next);
            } else {
                next.o = a2;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.f65816e.k(arrayList, arrayList2);
        }
        r0.e(e() + arrayList.size() + " " + e2.size(), null);
        if (arrayList.size() == e2.size()) {
            this.f65818g = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // d.c.b.v1
    public String e() {
        return "s";
    }
}
