package d.b.c0.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, h> f43222a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f43223b = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f43224a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f43225b;

        public b() {
            this.f43225b = false;
        }
    }

    public static void a(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (f43222a.get(str) == null) {
                b bVar = new b();
                bVar.f43224a = iBinder;
                bVar.f43225b = z;
                f43223b.put(str, bVar);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new SecurityException();
    }

    public static IBinder d(String str) {
        h hVar = f43222a.get(str);
        if (hVar != null) {
            hVar.b();
            return hVar.c();
        }
        b bVar = f43223b.get(str);
        if (bVar != null) {
            if (!bVar.f43225b && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return bVar.f43224a;
        }
        return null;
    }

    public static boolean e(String str) {
        if (Binder.getCallingUid() == Process.myUid()) {
            return f43223b.remove(str) != null;
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
