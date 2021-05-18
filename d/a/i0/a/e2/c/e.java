package d.a.i0.a.e2.c;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: e  reason: collision with root package name */
    public Exception f41516e;

    /* renamed from: f  reason: collision with root package name */
    public c f41517f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (e.this.f()) {
                    e.this.d();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                e.this.e(e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f41517f.m(e.this);
        }
    }

    public Exception b() {
        return this.f41516e;
    }

    public boolean c() {
        return this.f41516e == null;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        this.f41516e = exc;
        d.k(new b());
    }

    public abstract boolean f() throws Exception;

    public e g() {
        AsyncTask.execute(new a());
        return this;
    }

    public e h(c cVar) {
        this.f41517f = cVar;
        return this;
    }
}
