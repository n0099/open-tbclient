package d.b.b0.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, h> f41952a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f41953b = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f41954a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f41955b;

        public b() {
            this.f41955b = false;
        }
    }

    public static void a(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (f41952a.get(str) == null) {
                b bVar = new b();
                bVar.f41954a = iBinder;
                bVar.f41955b = z;
                f41953b.put(str, bVar);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new SecurityException();
    }

    public static IBinder d(String str) {
        h hVar = f41952a.get(str);
        if (hVar != null) {
            hVar.b();
            return hVar.c();
        }
        b bVar = f41953b.get(str);
        if (bVar != null) {
            if (!bVar.f41955b && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return bVar.f41954a;
        }
        return null;
    }

    public static boolean e(String str) {
        if (Binder.getCallingUid() == Process.myUid()) {
            return f41953b.remove(str) != null;
        }
        throw new SecurityException();
    }

    public void b() {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }

    public abstract IBinder c();
}
