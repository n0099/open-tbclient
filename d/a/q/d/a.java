package d.a.q.d;

import android.content.Context;
import android.os.Bundle;
import d.a.q.e.b;
import d.a.q.h.b;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public C1834a f67761e;

    /* renamed from: f  reason: collision with root package name */
    public b f67762f;

    /* renamed from: d.a.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1834a {

        /* renamed from: a  reason: collision with root package name */
        public b.a f67763a;

        /* renamed from: b  reason: collision with root package name */
        public b.a f67764b;

        /* renamed from: c  reason: collision with root package name */
        public Context f67765c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f67766d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f67767e;
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
        public String f67768a;

        /* renamed from: b  reason: collision with root package name */
        public int f67769b;

        public d() {
        }

        public d(int i2, String str, Exception exc) {
            this.f67769b = i2;
            this.f67768a = str;
        }

        public static d a(int i2, Exception exc) {
            d dVar = new d();
            dVar.f67769b = i2;
            return dVar;
        }

        public static d c(String str) {
            d dVar = new d();
            dVar.f67769b = 0;
            dVar.f67768a = str;
            return dVar;
        }

        public boolean b() {
            return this.f67769b == 0;
        }
    }

    public abstract void a(String str, Bundle bundle, c<String> cVar);

    public void b(C1834a c1834a) {
        this.f67761e = c1834a;
    }

    public void c(b bVar) {
        this.f67762f = bVar;
        e(bVar);
    }

    public abstract boolean d(String str);

    public abstract void e(b bVar);

    public abstract d f(String str, Bundle bundle);
}
