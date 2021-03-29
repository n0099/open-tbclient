package d.b.g0.a.v1.c;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: e  reason: collision with root package name */
    public Exception f46764e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.v1.c.b f46765f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (d.this.f()) {
                    d.this.d();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                d.this.e(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f46765f.m(d.this);
        }
    }

    public Exception b() {
        return this.f46764e;
    }

    public boolean c() {
        return this.f46764e == null;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        this.f46764e = exc;
        c.k(new b());
    }

    public abstract boolean f() throws Exception;

    public d g() {
        AsyncTask.execute(new a());
        return this;
    }

    public d h(d.b.g0.a.v1.c.b bVar) {
        this.f46765f = bVar;
        return this;
    }
}
