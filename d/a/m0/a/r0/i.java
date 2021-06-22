package d.a.m0.a.r0;

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
    public static final boolean f48182c = d.a.m0.a.k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i f48183d;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<h> f48184a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public g f48185b = new g();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Semaphore f48186e;

        public a(i iVar, Semaphore semaphore) {
            this.f48186e = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f48186e.release();
        }
    }

    public static i d() {
        if (f48183d == null) {
            synchronized (i.class) {
                if (f48183d == null) {
                    f48183d = new i();
                }
            }
        }
        return f48183d;
    }

    public static synchronized void i() {
        synchronized (i.class) {
            if (f48183d != null) {
                f48183d.f();
                f48183d = null;
            }
        }
    }

    public final void a(@NonNull h hVar, @NonNull ArrayList<h> arrayList) {
        if (f48182c) {
            Log.i("FileSystemTaskManager", "addToWaitList: " + hVar + "," + arrayList.size() + "," + this.f48184a.size());
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            next.i();
            hVar.a(next);
        }
        this.f48184a.add(hVar);
    }

    public final h b(@NonNull Semaphore semaphore) {
        return new h(this, new a(this, semaphore), "JS_WAKE_UP_TASK", null);
    }

    public final synchronized boolean c(Semaphore semaphore, String... strArr) {
        ArrayList<h> c2 = this.f48185b.c(strArr);
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
        this.f48185b.b();
        Iterator<h> it = this.f48184a.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (e(next)) {
                next.h();
            }
        }
        this.f48184a.clear();
    }

    public synchronized void g(h hVar) {
        if (hVar == null) {
            return;
        }
        this.f48185b.d(hVar, hVar.b());
        if (hVar.e()) {
            if (f48182c) {
                Log.i("FileSystemTaskManager", "onTaskComplete: " + hVar + "," + this.f48184a.size());
            }
            for (int size = this.f48184a.size() - 1; size >= 0; size--) {
                h hVar2 = this.f48184a.get(size);
                hVar2.g(hVar);
                if (hVar2.d()) {
                    this.f48184a.remove(size);
                    hVar2.f();
                }
            }
        }
    }

    public synchronized void h(@NonNull Runnable runnable, String str, String... strArr) {
        h hVar = new h(this, runnable, str, strArr);
        ArrayList<h> c2 = this.f48185b.c(strArr);
        this.f48185b.a(hVar, strArr);
        if (c2 != null && c2.size() != 0) {
            a(hVar, c2);
        }
        hVar.f();
    }

    public final void j(Semaphore semaphore) {
        try {
            semaphore.tryAcquire(10L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            if (f48182c) {
                Log.e("FileSystemTaskManager", "semaphore.acquire: " + e2);
            }
        }
    }

    public void k(String... strArr) {
        Semaphore semaphore = new Semaphore(0);
        if (c(semaphore, strArr)) {
            if (f48182c) {
                Log.i("FileSystemTaskManager", "waitIfHasPathDependence: " + Arrays.toString(strArr));
            }
            j(semaphore);
        }
    }
}
