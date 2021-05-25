package d.a.l0.a.n0.j.g;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import d.a.l0.a.n0.g;
import d.a.l0.a.p.b.a.l;
import d.a.l0.a.v2.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a implements b, d.a.l0.a.n0.j.d.a {

    /* renamed from: a  reason: collision with root package name */
    public g f43628a = new g();

    /* renamed from: b  reason: collision with root package name */
    public l f43629b = d.a.l0.a.c1.b.m();

    /* renamed from: c  reason: collision with root package name */
    public volatile d.a.l0.a.n0.j.d.a[] f43630c = {new d.a.l0.a.n0.j.d.e(), new d.a.l0.a.n0.j.d.c(), new d.a.l0.a.n0.j.d.b(), new d.a.l0.a.n0.j.d.d()};

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.n0.j.f.a f43631d;

    /* renamed from: d.a.l0.a.n0.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0760a implements Runnable {
        public RunnableC0760a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.e();
        }
    }

    public a(@NonNull d.a.l0.a.n0.j.f.a aVar) {
        this.f43631d = aVar;
    }

    @Override // d.a.l0.a.n0.j.d.a
    public synchronized ArraySet<String> a() {
        ArraySet<String> arraySet;
        d.a.l0.a.e0.d.h("RecoveryPolicy", "renameAllPlatformFiles start");
        arraySet = new ArraySet<>();
        for (d.a.l0.a.n0.j.d.a aVar : this.f43630c) {
            arraySet.addAll((ArraySet<? extends String>) aVar.a());
        }
        d.a.l0.a.e0.d.h("RecoveryPolicy", "renameAllPlatformFiles end");
        return arraySet;
    }

    @Override // d.a.l0.a.n0.j.g.b
    public void b() {
        q.j(new RunnableC0760a(), "performRecovery");
    }

    public void c(ArraySet<String> arraySet) {
        if (arraySet == null || arraySet.isEmpty()) {
            return;
        }
        d.a.l0.a.e0.d.h("RecoveryPolicy", "deleteFiles start");
        Iterator<String> it = arraySet.iterator();
        while (it.hasNext()) {
            d.a.l0.t.d.j(it.next());
        }
        d.a.l0.a.e0.d.h("RecoveryPolicy", "deleteFiles end");
    }

    public void d() {
        d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
        d.a.l0.a.v1.c.c cVar = new d.a.l0.a.v1.c.c(132);
        cVar.d();
        e2.h(cVar);
    }

    public void e() {
    }

    public void f(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        d.a.l0.a.e0.d.h("RecoveryPolicy", "resetAccredit appIds=" + collection);
        this.f43628a.g(new ArrayList(collection));
    }
}
