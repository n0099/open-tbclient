package d.b.g0.a.e0.p;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44139b = d.b.g0.a.k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.b.g0.l.k.e, Set<InterfaceC0668c>> f44140a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f44141a = new c();
    }

    /* renamed from: d.b.g0.a.e0.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0668c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar);
    }

    public static c c() {
        return b.f44141a;
    }

    public synchronized void a(d.b.g0.l.k.e eVar, PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
        if (f44139b) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0668c> set = this.f44140a.get(eVar);
        if (set != null) {
            for (InterfaceC0668c interfaceC0668c : set) {
                if (interfaceC0668c != null) {
                    interfaceC0668c.b(pMSDownloadType, aVar);
                }
            }
            this.f44140a.remove(eVar);
        }
    }

    public synchronized void b(d.b.g0.l.k.e eVar, PMSDownloadType pMSDownloadType) {
        if (f44139b) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0668c> set = this.f44140a.get(eVar);
        if (set != null) {
            for (InterfaceC0668c interfaceC0668c : set) {
                if (interfaceC0668c != null) {
                    interfaceC0668c.a(pMSDownloadType);
                }
            }
            this.f44140a.remove(eVar);
        }
    }

    public synchronized void d(d.b.g0.l.k.e eVar, InterfaceC0668c interfaceC0668c) {
        if (f44139b) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0668c != null) {
            Set<InterfaceC0668c> set = this.f44140a.get(eVar);
            if (set != null) {
                set.add(interfaceC0668c);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0668c);
                this.f44140a.put(eVar, hashSet);
            }
        }
    }

    public c() {
        this.f44140a = new HashMap<>();
    }
}
