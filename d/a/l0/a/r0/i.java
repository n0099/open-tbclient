package d.a.l0.a.r0;

import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48074c = d.a.l0.a.k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i f48075d;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<h> f48076a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public g f48077b = new g();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Semaphore f48078e;

        public a(i iVar, Semaphore semaphore) {
            this.f48078e = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f48078e.release();
        }
    }

    public static i d() {
        if (f48075d == null) {
            synchronized (i.class) {
                if (f48075d == null) {
                    f48075d = new i();
                }
            }
        }
        return f48075d;
    }

    public static synchronized void i() {
        synchronized (i.class) {
            if (f48075d != null) {
                f48075d.f();
                f48075d = null;
            }
        }
    }

    public final void a(@NonNull h hVar, @NonNull ArrayList<h> arrayList) {
        if (f48074c) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + "," + arrayList.size() + "," + this.f48076a.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.i();
            hVar.a(next);
        }
        this.f48076a.add(hVar);
    }

    public final h b(@NonNull Semaphore semaphore) {
        return new h(this, new a(this, semaphore), "JS_WAKE_UP_TASK", null);
    }

    public final synchronized boolean c(Semaphore semaphore, String... strArr) {
        ArrayList<h> c2 = this.f48077b.c(strArr);
        if (c2 != null && c2.size() != 0) {
            a(b(semaphore), c2);
            return true;
        }
        return false;
    }

    public final boolean e(h hVar) {
        return hVar != null && "JS_WAKE_UP_TASK".equals(hVar.c());
    }

    public final synchronized void f() {
        this.f48077b.b();
        Iterator<h> it = this.f48076a.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (e(next)) {
                next.h();
            }
        }
        this.f48076a.clear();
    }

    public synchronized void g(h hVar) {
        if (hVar == null) {
            return;
        }
        this.f48077b.d(hVar, hVar.b());
        if (hVar.e()) {
            if (f48074c) {
                Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + "," + this.f48076a.size());
            }
            for (int size = this.f48076a.size() - 1; size >= 0; size--) {
                h hVar2 = this.f48076a.get(size);
                hVar2.g(hVar);
                if (hVar2.d()) {
                    this.f48076a.remove(size);
                    hVar2.f();
                }
            }
        }
    }

    public synchronized void h(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> c2 = this.f48077b.c(strArr);
        this.f48077b.a(hVar, strArr);
        if (c2 != null && c2.size() != 0) {
            a(hVar, c2);
        }
        hVar.f();
    }

    public final void j(Semaphore semaphore) {
        try {
            semaphore.tryAcquire(10L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            if (f48074c) {
                Log.e("FileSystemTaskManager", "semaphore.acquire: " + e2);
            }
        }
    }

    public void k(String... strArr) {
        Semaphore semaphore = new Semaphore(0);
        if (c(semaphore, strArr)) {
            if (f48074c) {
                Log.i("FileSystemTaskManager", "waitIfHasPathDependence: " + Arrays.toString(strArr));
            }
            j(semaphore);
        }
    }
}
