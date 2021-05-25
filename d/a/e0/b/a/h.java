package d.a.e0.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, h> f39715a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f39716b = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f39717a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f39718b;

        public b() {
            this.f39718b = false;
        }
    }

    public static void a(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (f39715a.get(str) == null) {
                b bVar = new b();
                bVar.f39717a = iBinder;
                bVar.f39718b = z;
                f39716b.put(str, bVar);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new SecurityException();
    }

    public static IBinder d(String str) {
        h hVar = f39715a.get(str);
        if (hVar != null) {
            hVar.b();
            return hVar.c();
        }
        b bVar = f39716b.get(str);
        if (bVar != null) {
            if (!bVar.f39718b && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return bVar.f39717a;
        }
        return null;
    }

    public static boolean e(String str) {
        if (Binder.getCallingUid() == Process.myUid()) {
            return f39716b.remove(str) != null;
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
