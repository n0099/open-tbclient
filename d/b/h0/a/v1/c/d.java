package d.b.h0.a.v1.c;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: e  reason: collision with root package name */
    public Exception f47485e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.a.v1.c.b f47486f;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47486f.m(d.this);
        }
    }

    public Exception b() {
        return this.f47485e;
    }

    public boolean c() {
        return this.f47485e == null;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        this.f47485e = exc;
        c.k(new b());
    }

    public abstract boolean f() throws Exception;

    public d g() {
        AsyncTask.execute(new a());
        return this;
    }

    public d h(d.b.h0.a.v1.c.b bVar) {
        this.f47486f = bVar;
        return this;
    }
}
