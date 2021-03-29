package d.b.q.d;

import android.content.Context;
import android.os.Bundle;
import d.b.q.e.b;
import d.b.q.h.b;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public C1741a f64257e;

    /* renamed from: f  reason: collision with root package name */
    public b f64258f;

    /* renamed from: d.b.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1741a {

        /* renamed from: a  reason: collision with root package name */
        public b.a f64259a;

        /* renamed from: b  reason: collision with root package name */
        public b.a f64260b;

        /* renamed from: c  reason: collision with root package name */
        public Context f64261c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f64262d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f64263e;
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
        public String f64264a;

        /* renamed from: b  reason: collision with root package name */
        public int f64265b;

        public d() {
        }

        public d(int i, String str, Exception exc) {
            this.f64265b = i;
            this.f64264a = str;
        }

        public static d a(int i, Exception exc) {
            d dVar = new d();
            dVar.f64265b = i;
            return dVar;
        }

        public static d c(String str) {
            d dVar = new d();
            dVar.f64265b = 0;
            dVar.f64264a = str;
            return dVar;
        }

        public boolean b() {
            return this.f64265b == 0;
        }
    }

    public abstract void a(String str, Bundle bundle, c<String> cVar);

    public void b(C1741a c1741a) {
        this.f64257e = c1741a;
    }

    public void c(b bVar) {
        this.f64258f = bVar;
        e(bVar);
    }

    public abstract boolean d(String str);

    public abstract void e(b bVar);

    public abstract d f(String str, Bundle bundle);
}
