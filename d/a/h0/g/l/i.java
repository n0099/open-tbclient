package d.a.h0.g.l;

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
    public static final boolean f46671c = d.a.h0.a.k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i f46672d;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<h> f46673a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public g f46674b = new g();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Semaphore f46675e;

        public a(i iVar, Semaphore semaphore) {
            this.f46675e = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46675e.release();
        }
    }

    public static i d() {
        if (f46672d == null) {
            synchronized (i.class) {
                if (f46672d == null) {
                    f46672d = new i();
                }
            }
        }
        return f46672d;
    }

    public static synchronized void i() {
        synchronized (i.class) {
            if (f46672d != null) {
                f46672d.f();
                f46672d = null;
            }
        }
    }

    public final void a(@NonNull h hVar, @NonNull ArrayList<h> arrayList) {
        if (f46671c) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + "," + arrayList.size() + "," + this.f46673a.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.i();
            hVar.a(next);
        }
        this.f46673a.add(hVar);
    }

    public final h b(@NonNull Semaphore semaphore) {
        return new h(this, new a(this, semaphore), "JS_WAKE_UP_TASK", null);
    }

    public final synchronized boolean c(Semaphore semaphore, String... strArr) {
        ArrayList<h> c2 = this.f46674b.c(strArr);
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
        this.f46674b.b();
        Iterator<h> it = this.f46673a.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (e(next)) {
                next.h();
            }
        }
        this.f46673a.clear();
    }

    public synchronized void g(h hVar) {
        if (hVar == null) {
            return;
        }
        this.f46674b.d(hVar, hVar.b());
        if (hVar.e()) {
            if (f46671c) {
                Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + "," + this.f46673a.size());
            }
            for (int size = this.f46673a.size() - 1; size >= 0; size--) {
                h hVar2 = this.f46673a.get(size);
                hVar2.g(hVar);
                if (hVar2.d()) {
                    this.f46673a.remove(size);
                    hVar2.f();
                }
            }
        }
    }

    public synchronized void h(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> c2 = this.f46674b.c(strArr);
        this.f46674b.a(hVar, strArr);
        if (c2 != null && c2.size() != 0) {
            a(hVar, c2);
        }
        hVar.f();
    }

    public final void j(Semaphore semaphore) {
        try {
            semaphore.tryAcquire(10L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            if (f46671c) {
                Log.e("FileSystemTaskManager", "semaphore.acquire: " + e2);
            }
        }
    }

    public void k(String... strArr) {
        Semaphore semaphore = new Semaphore(0);
        if (c(semaphore, strArr)) {
            if (f46671c) {
                Log.i("FileSystemTaskManager", "waitIfHasPathDependence: " + Arrays.toString(strArr));
            }
            j(semaphore);
        }
    }
}
