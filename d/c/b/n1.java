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
    public final CountDownLatch f65887a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public final Intent f65888b;

    /* renamed from: c  reason: collision with root package name */
    public final b<SERVICE, RESULT> f65889c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f65890d;

    /* loaded from: classes5.dex */
    public class a implements ServiceConnection {

        /* renamed from: e  reason: collision with root package name */
        public final CountDownLatch f65891e;

        /* renamed from: f  reason: collision with root package name */
        public final b<SERVICE, RESULT> f65892f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public SERVICE f65893g;

        public a(n1 n1Var, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.f65891e = countDownLatch;
            this.f65892f = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str = f1.j;
            y0.e(str, "ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                this.f65893g = this.f65892f.a(iBinder);
                this.f65891e.countDown();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            String str = f1.j;
            y0.e(str, "ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.f65891e.countDown();
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
        this.f65890d = context;
        this.f65888b = intent;
        this.f65889c = bVar;
    }

    public RESULT a() {
        n1<SERVICE, RESULT>.a aVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return null;
        }
        try {
            aVar = new a(this, this.f65887a, this.f65889c);
            this.f65890d.bindService(this.f65888b, aVar, 1);
            this.f65887a.await();
        } catch (Throwable th) {
            th = th;
            aVar = null;
        }
        try {
            return this.f65889c.a((b<SERVICE, RESULT>) aVar.f65893g);
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
                this.f65890d.unbindService(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
