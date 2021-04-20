package d.b.p.d;

import android.content.Context;
import android.os.Bundle;
import d.b.p.e.b;
import d.b.p.h.b;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public C1753a f64951e;

    /* renamed from: f  reason: collision with root package name */
    public b f64952f;

    /* renamed from: d.b.p.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1753a {

        /* renamed from: a  reason: collision with root package name */
        public b.a f64953a;

        /* renamed from: b  reason: collision with root package name */
        public b.a f64954b;

        /* renamed from: c  reason: collision with root package name */
        public Context f64955c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f64956d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f64957e;
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
        public String f64958a;

        /* renamed from: b  reason: collision with root package name */
        public int f64959b;

        public d() {
        }

        public d(int i, String str, Exception exc) {
            this.f64959b = i;
            this.f64958a = str;
        }

        public static d a(int i, Exception exc) {
            d dVar = new d();
            dVar.f64959b = i;
            return dVar;
        }

        public static d c(String str) {
            d dVar = new d();
            dVar.f64959b = 0;
            dVar.f64958a = str;
            return dVar;
        }

        public boolean b() {
            return this.f64959b == 0;
        }
    }

    public abstract void a(String str, Bundle bundle, c<String> cVar);

    public void b(C1753a c1753a) {
        this.f64951e = c1753a;
    }

    public void c(b bVar) {
        this.f64952f = bVar;
        e(bVar);
    }

    public abstract boolean d(String str);

    public abstract void e(b bVar);

    public abstract d f(String str, Bundle bundle);
}
