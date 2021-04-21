package d.b.h0.a.e0.p;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44860b = d.b.h0.a.k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.b.h0.l.k.e, Set<InterfaceC0700c>> f44861a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f44862a = new c();
    }

    /* renamed from: d.b.h0.a.e0.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0700c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.b.h0.a.f2.a aVar);
    }

    public static c c() {
        return b.f44862a;
    }

    public synchronized void a(d.b.h0.l.k.e eVar, PMSDownloadType pMSDownloadType, d.b.h0.a.f2.a aVar) {
        if (f44860b) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0700c> set = this.f44861a.get(eVar);
        if (set != null) {
            for (InterfaceC0700c interfaceC0700c : set) {
                if (interfaceC0700c != null) {
                    interfaceC0700c.b(pMSDownloadType, aVar);
                }
            }
            this.f44861a.remove(eVar);
        }
    }

    public synchronized void b(d.b.h0.l.k.e eVar, PMSDownloadType pMSDownloadType) {
        if (f44860b) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0700c> set = this.f44861a.get(eVar);
        if (set != null) {
            for (InterfaceC0700c interfaceC0700c : set) {
                if (interfaceC0700c != null) {
                    interfaceC0700c.a(pMSDownloadType);
                }
            }
            this.f44861a.remove(eVar);
        }
    }

    public synchronized void d(d.b.h0.l.k.e eVar, InterfaceC0700c interfaceC0700c) {
        if (f44860b) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0700c != null) {
            Set<InterfaceC0700c> set = this.f44861a.get(eVar);
            if (set != null) {
                set.add(interfaceC0700c);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0700c);
                this.f44861a.put(eVar, hashSet);
            }
        }
    }

    public c() {
        this.f44861a = new HashMap<>();
    }
}
