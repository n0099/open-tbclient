package d.b.q.d;

import android.content.Context;
import android.os.Bundle;
import d.b.q.e.b;
import d.b.q.h.b;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public C1772a f65215e;

    /* renamed from: f  reason: collision with root package name */
    public b f65216f;

    /* renamed from: d.b.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1772a {

        /* renamed from: a  reason: collision with root package name */
        public b.a f65217a;

        /* renamed from: b  reason: collision with root package name */
        public b.a f65218b;

        /* renamed from: c  reason: collision with root package name */
        public Context f65219c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f65220d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f65221e;
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
        public String f65222a;

        /* renamed from: b  reason: collision with root package name */
        public int f65223b;

        public d() {
        }

        public d(int i, String str, Exception exc) {
            this.f65223b = i;
            this.f65222a = str;
        }

        public static d a(int i, Exception exc) {
            d dVar = new d();
            dVar.f65223b = i;
            return dVar;
        }

        public static d c(String str) {
            d dVar = new d();
            dVar.f65223b = 0;
            dVar.f65222a = str;
            return dVar;
        }

        public boolean b() {
            return this.f65223b == 0;
        }
    }

    public abstract void a(String str, Bundle bundle, c<String> cVar);

    public void b(C1772a c1772a) {
        this.f65215e = c1772a;
    }

    public void c(b bVar) {
        this.f65216f = bVar;
        e(bVar);
    }

    public abstract boolean d(String str);

    public abstract void e(b bVar);

    public abstract d f(String str, Bundle bundle);
}
