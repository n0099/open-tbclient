package d.a.q.d;

import android.content.Context;
import android.os.Bundle;
import d.a.q.e.b;
import d.a.q.h.b;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public C1773a f64167e;

    /* renamed from: f  reason: collision with root package name */
    public b f64168f;

    /* renamed from: d.a.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1773a {

        /* renamed from: a  reason: collision with root package name */
        public b.a f64169a;

        /* renamed from: b  reason: collision with root package name */
        public b.a f64170b;

        /* renamed from: c  reason: collision with root package name */
        public Context f64171c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f64172d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f64173e;
    }

    /* loaded from: classes2.dex */
    public static class b {
    }

    /* loaded from: classes2.dex */
    public interface c<T> {
        void a(T t, Bundle bundle);

        void b(int i2, Exception exc, Bundle bundle);
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f64174a;

        /* renamed from: b  reason: collision with root package name */
        public int f64175b;

        public d() {
        }

        public d(int i2, String str, Exception exc) {
            this.f64175b = i2;
            this.f64174a = str;
        }

        public static d a(int i2, Exception exc) {
            d dVar = new d();
            dVar.f64175b = i2;
            return dVar;
        }

        public static d c(String str) {
            d dVar = new d();
            dVar.f64175b = 0;
            dVar.f64174a = str;
            return dVar;
        }

        public boolean b() {
            return this.f64175b == 0;
        }
    }

    public abstract void a(String str, Bundle bundle, c<String> cVar);

    public void b(C1773a c1773a) {
        this.f64167e = c1773a;
    }

    public void c(b bVar) {
        this.f64168f = bVar;
        e(bVar);
    }

    public abstract boolean d(String str);

    public abstract void e(b bVar);

    public abstract d f(String str, Bundle bundle);
}
