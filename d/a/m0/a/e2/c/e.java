package d.a.m0.a.e2.c;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: e  reason: collision with root package name */
    public Exception f45474e;

    /* renamed from: f  reason: collision with root package name */
    public c f45475f;

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
            e.this.f45475f.m(e.this);
        }
    }

    public Exception b() {
        return this.f45474e;
    }

    public boolean c() {
        return this.f45474e == null;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        this.f45474e = exc;
        d.k(new b());
    }

    public abstract boolean f() throws Exception;

    public e g() {
        AsyncTask.execute(new a());
        return this;
    }

    public e h(c cVar) {
        this.f45475f = cVar;
        return this;
    }
}
