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
    public static final boolean f45994b = d.a.l0.a.k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.a.l0.n.h.e, Set<InterfaceC0732c>> f45995a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f45996a = new c();
    }

    /* renamed from: d.a.l0.a.h0.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0732c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.a.l0.a.q2.a aVar);
    }

    public static c c() {
        return b.f45996a;
    }

    public synchronized void a(d.a.l0.n.h.e eVar, PMSDownloadType pMSDownloadType, d.a.l0.a.q2.a aVar) {
        if (f45994b) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0732c> set = this.f45995a.get(eVar);
        if (set != null) {
            for (InterfaceC0732c interfaceC0732c : set) {
                if (interfaceC0732c != null) {
                    interfaceC0732c.b(pMSDownloadType, aVar);
                }
            }
            this.f45995a.remove(eVar);
        }
    }

    public synchronized void b(d.a.l0.n.h.e eVar, PMSDownloadType pMSDownloadType) {
        if (f45994b) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0732c> set = this.f45995a.get(eVar);
        if (set != null) {
            for (InterfaceC0732c interfaceC0732c : set) {
                if (interfaceC0732c != null) {
                    interfaceC0732c.a(pMSDownloadType);
                }
            }
            this.f45995a.remove(eVar);
        }
    }

    public synchronized void d(d.a.l0.n.h.e eVar, InterfaceC0732c interfaceC0732c) {
        if (f45994b) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0732c != null) {
            Set<InterfaceC0732c> set = this.f45995a.get(eVar);
            if (set != null) {
                set.add(interfaceC0732c);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0732c);
                this.f45995a.put(eVar, hashSet);
            }
        }
    }

    public c() {
        this.f45995a = new HashMap<>();
    }
}
