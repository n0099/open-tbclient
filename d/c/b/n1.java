package d.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public final class n1<SERVICE, RESULT> {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f65042a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public final Intent f65043b;

    /* renamed from: c  reason: collision with root package name */
    public final b<SERVICE, RESULT> f65044c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f65045d;

    /* loaded from: classes5.dex */
    public class a implements ServiceConnection {

        /* renamed from: e  reason: collision with root package name */
        public final CountDownLatch f65046e;

        /* renamed from: f  reason: collision with root package name */
        public final b<SERVICE, RESULT> f65047f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public SERVICE f65048g;

        public a(n1 n1Var, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.f65046e = countDownLatch;
            this.f65047f = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str = f1.j;
            y0.e(str, "ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                this.f65048g = this.f65047f.a(iBinder);
                this.f65046e.countDown();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            String str = f1.j;
            y0.e(str, "ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.f65046e.countDown();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b<T, RESULT> {
        T a(IBinder iBinder);

        RESULT a(T t);
    }

    public n1(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.f65045d = context;
        this.f65043b = intent;
        this.f65044c = bVar;
    }

    public RESULT a() {
        n1<SERVICE, RESULT>.a aVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return null;
        }
        try {
            aVar = new a(this, this.f65042a, this.f65044c);
            this.f65045d.bindService(this.f65043b, aVar, 1);
            this.f65042a.await();
        } catch (Throwable th) {
            th = th;
            aVar = null;
        }
        try {
            return this.f65044c.a((b<SERVICE, RESULT>) aVar.f65048g);
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                return null;
            } finally {
                b(aVar);
            }
        }
    }

    public final void b(n1<SERVICE, RESULT>.a aVar) {
        if (aVar != null) {
            try {
                this.f65045d.unbindService(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
