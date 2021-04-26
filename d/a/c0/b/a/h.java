package d.a.c0.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, h> f40457a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f40458b = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f40459a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f40460b;

        public b() {
            this.f40460b = false;
        }
    }

    public static void a(String str, IBinder iBinder, boolean z) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (f40457a.get(str) == null) {
                b bVar = new b();
                bVar.f40459a = iBinder;
                bVar.f40460b = z;
                f40458b.put(str, bVar);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new SecurityException();
    }

    public static IBinder d(String str) {
        h hVar = f40457a.get(str);
        if (hVar != null) {
            hVar.b();
            return hVar.c();
        }
        b bVar = f40458b.get(str);
        if (bVar != null) {
            if (!bVar.f40460b && Binder.getCallingUid() != Process.myUid()) {
                throw new SecurityException();
            }
            return bVar.f40459a;
        }
        return null;
    }

    public static boolean e(String str) {
        if (Binder.getCallingUid() == Process.myUid()) {
            return f40458b.remove(str) != null;
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
