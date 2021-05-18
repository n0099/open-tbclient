package d.a.i0.a.h0.m;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42144b = d.a.i0.a.k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.a.i0.n.h.e, Set<InterfaceC0665c>> f42145a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f42146a = new c();
    }

    /* renamed from: d.a.i0.a.h0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0665c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.a.i0.a.q2.a aVar);
    }

    public static c c() {
        return b.f42146a;
    }

    public synchronized void a(d.a.i0.n.h.e eVar, PMSDownloadType pMSDownloadType, d.a.i0.a.q2.a aVar) {
        if (f42144b) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0665c> set = this.f42145a.get(eVar);
        if (set != null) {
            for (InterfaceC0665c interfaceC0665c : set) {
                if (interfaceC0665c != null) {
                    interfaceC0665c.b(pMSDownloadType, aVar);
                }
            }
            this.f42145a.remove(eVar);
        }
    }

    public synchronized void b(d.a.i0.n.h.e eVar, PMSDownloadType pMSDownloadType) {
        if (f42144b) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0665c> set = this.f42145a.get(eVar);
        if (set != null) {
            for (InterfaceC0665c interfaceC0665c : set) {
                if (interfaceC0665c != null) {
                    interfaceC0665c.a(pMSDownloadType);
                }
            }
            this.f42145a.remove(eVar);
        }
    }

    public synchronized void d(d.a.i0.n.h.e eVar, InterfaceC0665c interfaceC0665c) {
        if (f42144b) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0665c != null) {
            Set<InterfaceC0665c> set = this.f42145a.get(eVar);
            if (set != null) {
                set.add(interfaceC0665c);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0665c);
                this.f42145a.put(eVar, hashSet);
            }
        }
    }

    public c() {
        this.f42145a = new HashMap<>();
    }
}
