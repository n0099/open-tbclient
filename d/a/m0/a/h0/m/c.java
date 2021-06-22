package d.a.m0.a.h0.m;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46102b = d.a.m0.a.k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.a.m0.n.h.e, Set<InterfaceC0735c>> f46103a;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f46104a = new c();
    }

    /* renamed from: d.a.m0.a.h0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0735c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar);
    }

    public static c c() {
        return b.f46104a;
    }

    public synchronized void a(d.a.m0.n.h.e eVar, PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar) {
        if (f46102b) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0735c> set = this.f46103a.get(eVar);
        if (set != null) {
            for (InterfaceC0735c interfaceC0735c : set) {
                if (interfaceC0735c != null) {
                    interfaceC0735c.b(pMSDownloadType, aVar);
                }
            }
            this.f46103a.remove(eVar);
        }
    }

    public synchronized void b(d.a.m0.n.h.e eVar, PMSDownloadType pMSDownloadType) {
        if (f46102b) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0735c> set = this.f46103a.get(eVar);
        if (set != null) {
            for (InterfaceC0735c interfaceC0735c : set) {
                if (interfaceC0735c != null) {
                    interfaceC0735c.a(pMSDownloadType);
                }
            }
            this.f46103a.remove(eVar);
        }
    }

    public synchronized void d(d.a.m0.n.h.e eVar, InterfaceC0735c interfaceC0735c) {
        if (f46102b) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0735c != null) {
            Set<InterfaceC0735c> set = this.f46103a.get(eVar);
            if (set != null) {
                set.add(interfaceC0735c);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0735c);
                this.f46103a.put(eVar, hashSet);
            }
        }
    }

    public c() {
        this.f46103a = new HashMap<>();
    }
}
