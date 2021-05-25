package d.a.l0.a.h0.m;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42318b = d.a.l0.a.k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.a.l0.n.h.e, Set<InterfaceC0676c>> f42319a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f42320a = new c();
    }

    /* renamed from: d.a.l0.a.h0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0676c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.a.l0.a.q2.a aVar);
    }

    public static c c() {
        return b.f42320a;
    }

    public synchronized void a(d.a.l0.n.h.e eVar, PMSDownloadType pMSDownloadType, d.a.l0.a.q2.a aVar) {
        if (f42318b) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0676c> set = this.f42319a.get(eVar);
        if (set != null) {
            for (InterfaceC0676c interfaceC0676c : set) {
                if (interfaceC0676c != null) {
                    interfaceC0676c.b(pMSDownloadType, aVar);
                }
            }
            this.f42319a.remove(eVar);
        }
    }

    public synchronized void b(d.a.l0.n.h.e eVar, PMSDownloadType pMSDownloadType) {
        if (f42318b) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0676c> set = this.f42319a.get(eVar);
        if (set != null) {
            for (InterfaceC0676c interfaceC0676c : set) {
                if (interfaceC0676c != null) {
                    interfaceC0676c.a(pMSDownloadType);
                }
            }
            this.f42319a.remove(eVar);
        }
    }

    public synchronized void d(d.a.l0.n.h.e eVar, InterfaceC0676c interfaceC0676c) {
        if (f42318b) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0676c != null) {
            Set<InterfaceC0676c> set = this.f42319a.get(eVar);
            if (set != null) {
                set.add(interfaceC0676c);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0676c);
                this.f42319a.put(eVar, hashSet);
            }
        }
    }

    public c() {
        this.f42319a = new HashMap<>();
    }
}
