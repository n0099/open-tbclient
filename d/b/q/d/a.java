package d.b.q.d;

import android.content.Context;
import android.os.Bundle;
import d.b.q.e.b;
import d.b.q.h.b;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public C1740a f64256e;

    /* renamed from: f  reason: collision with root package name */
    public b f64257f;

    /* renamed from: d.b.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1740a {

        /* renamed from: a  reason: collision with root package name */
        public b.a f64258a;

        /* renamed from: b  reason: collision with root package name */
        public b.a f64259b;

        /* renamed from: c  reason: collision with root package name */
        public Context f64260c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f64261d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f64262e;
    }

    /* loaded from: classes2.dex */
    public static class b {
    }

    /* loaded from: classes2.dex */
    public interface c<T> {
        void a(T t, Bundle bundle);

        void b(int i, Exception exc, Bundle bundle);
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f64263a;

        /* renamed from: b  reason: collision with root package name */
        public int f64264b;

        public d() {
        }

        public d(int i, String str, Exception exc) {
            this.f64264b = i;
            this.f64263a = str;
        }

        public static d a(int i, Exception exc) {
            d dVar = new d();
            dVar.f64264b = i;
            return dVar;
        }

        public static d c(String str) {
            d dVar = new d();
            dVar.f64264b = 0;
            dVar.f64263a = str;
            return dVar;
        }

        public boolean b() {
            return this.f64264b == 0;
        }
    }

    public abstract void a(String str, Bundle bundle, c<String> cVar);

    public void b(C1740a c1740a) {
        this.f64256e = c1740a;
    }

    public void c(b bVar) {
        this.f64257f = bVar;
        e(bVar);
    }

    public abstract boolean d(String str);

    public abstract void e(b bVar);

    public abstract d f(String str, Bundle bundle);
}
