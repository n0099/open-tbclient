package d.b.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
public final class n1<SERVICE, RESULT> {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f68904a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public final Intent f68905b;

    /* renamed from: c  reason: collision with root package name */
    public final b<SERVICE, RESULT> f68906c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f68907d;

    /* loaded from: classes6.dex */
    public class a implements ServiceConnection {

        /* renamed from: e  reason: collision with root package name */
        public final CountDownLatch f68908e;

        /* renamed from: f  reason: collision with root package name */
        public final b<SERVICE, RESULT> f68909f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public SERVICE f68910g;

        public a(n1 n1Var, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.f68908e = countDownLatch;
            this.f68909f = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str = f1.j;
            y0.e(str, "ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                this.f68910g = this.f68909f.a(iBinder);
                this.f68908e.countDown();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            String str = f1.j;
            y0.e(str, "ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.f68908e.countDown();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b<T, RESULT> {
        T a(IBinder iBinder);

        RESULT a(T t);
    }

    public n1(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.f68907d = context;
        this.f68905b = intent;
        this.f68906c = bVar;
    }

    public RESULT a() {
        n1<SERVICE, RESULT>.a aVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return null;
        }
        try {
            aVar = new a(this, this.f68904a, this.f68906c);
            this.f68907d.bindService(this.f68905b, aVar, 1);
            this.f68904a.await();
        } catch (Throwable th) {
            th = th;
            aVar = null;
        }
        try {
            return this.f68906c.a((b<SERVICE, RESULT>) aVar.f68910g);
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
                this.f68907d.unbindService(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
