package d.a.f0.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, h> f43534a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f43535b = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f43536a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f43537b;

        public b() {
            this.f43537b = false;
        }
    }

    public static void a(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (f43534a.get(str) == null) {
                b bVar = new b();
                bVar.f43536a = iBinder;
                bVar.f43537b = z;
                f43535b.put(str, bVar);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new SecurityException();
    }

    public static IBinder d(String str) {
        h hVar = f43534a.get(str);
        if (hVar != null) {
            hVar.b();
            return hVar.c();
        }
        b bVar = f43535b.get(str);
        if (bVar != null) {
            if (!bVar.f43537b && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return bVar.f43536a;
        }
        return null;
    }

    public static boolean e(String str) {
        if (Binder.getCallingUid() == Process.myUid()) {
            return f43535b.remove(str) != null;
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
