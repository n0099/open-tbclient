package d.a.q.d;

import android.content.Context;
import android.os.Bundle;
import d.a.q.e.b;
import d.a.q.h.b;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public C1836a f67717e;

    /* renamed from: f  reason: collision with root package name */
    public b f67718f;

    /* renamed from: d.a.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1836a {

        /* renamed from: a  reason: collision with root package name */
        public b.a f67719a;

        /* renamed from: b  reason: collision with root package name */
        public b.a f67720b;

        /* renamed from: c  reason: collision with root package name */
        public Context f67721c;

        /* renamed from: d  reason: collision with root package name */
        public ExecutorService f67722d;

        /* renamed from: e  reason: collision with root package name */
        public ExecutorService f67723e;
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
        public String f67724a;

        /* renamed from: b  reason: collision with root package name */
        public int f67725b;

        public d() {
        }

        public d(int i2, String str, Exception exc) {
            this.f67725b = i2;
            this.f67724a = str;
        }

        public static d a(int i2, Exception exc) {
            d dVar = new d();
            dVar.f67725b = i2;
            return dVar;
        }

        public static d c(String str) {
            d dVar = new d();
            dVar.f67725b = 0;
            dVar.f67724a = str;
            return dVar;
        }

        public boolean b() {
            return this.f67725b == 0;
        }
    }

    public abstract void a(String str, Bundle bundle, c<String> cVar);

    public void b(C1836a c1836a) {
        this.f67717e = c1836a;
    }

    public void c(b bVar) {
        this.f67718f = bVar;
        e(bVar);
    }

    public abstract boolean d(String str);

    public abstract void e(b bVar);

    public abstract d f(String str, Bundle bundle);
}
