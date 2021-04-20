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
    public static final boolean f44531b = d.b.g0.a.k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.b.g0.l.k.e, Set<InterfaceC0680c>> f44532a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f44533a = new c();
    }

    /* renamed from: d.b.g0.a.e0.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0680c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar);
    }

    public static c c() {
        return b.f44533a;
    }

    public synchronized void a(d.b.g0.l.k.e eVar, PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
        if (f44531b) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0680c> set = this.f44532a.get(eVar);
        if (set != null) {
            for (InterfaceC0680c interfaceC0680c : set) {
                if (interfaceC0680c != null) {
                    interfaceC0680c.b(pMSDownloadType, aVar);
                }
            }
            this.f44532a.remove(eVar);
        }
    }

    public synchronized void b(d.b.g0.l.k.e eVar, PMSDownloadType pMSDownloadType) {
        if (f44531b) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0680c> set = this.f44532a.get(eVar);
        if (set != null) {
            for (InterfaceC0680c interfaceC0680c : set) {
                if (interfaceC0680c != null) {
                    interfaceC0680c.a(pMSDownloadType);
                }
            }
            this.f44532a.remove(eVar);
        }
    }

    public synchronized void d(d.b.g0.l.k.e eVar, InterfaceC0680c interfaceC0680c) {
        if (f44531b) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0680c != null) {
            Set<InterfaceC0680c> set = this.f44532a.get(eVar);
            if (set != null) {
                set.add(interfaceC0680c);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0680c);
                this.f44532a.put(eVar, hashSet);
            }
        }
    }

    public c() {
        this.f44532a = new HashMap<>();
    }
}
