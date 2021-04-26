package d.a.h0.a.e0.p;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42161b = d.a.h0.a.k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.a.h0.l.k.e, Set<InterfaceC0639c>> f42162a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f42163a = new c();
    }

    /* renamed from: d.a.h0.a.e0.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0639c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar);
    }

    public static c c() {
        return b.f42163a;
    }

    public synchronized void a(d.a.h0.l.k.e eVar, PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
        if (f42161b) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0639c> set = this.f42162a.get(eVar);
        if (set != null) {
            for (InterfaceC0639c interfaceC0639c : set) {
                if (interfaceC0639c != null) {
                    interfaceC0639c.b(pMSDownloadType, aVar);
                }
            }
            this.f42162a.remove(eVar);
        }
    }

    public synchronized void b(d.a.h0.l.k.e eVar, PMSDownloadType pMSDownloadType) {
        if (f42161b) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0639c> set = this.f42162a.get(eVar);
        if (set != null) {
            for (InterfaceC0639c interfaceC0639c : set) {
                if (interfaceC0639c != null) {
                    interfaceC0639c.a(pMSDownloadType);
                }
            }
            this.f42162a.remove(eVar);
        }
    }

    public synchronized void d(d.a.h0.l.k.e eVar, InterfaceC0639c interfaceC0639c) {
        if (f42161b) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0639c != null) {
            Set<InterfaceC0639c> set = this.f42162a.get(eVar);
            if (set != null) {
                set.add(interfaceC0639c);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0639c);
                this.f42162a.put(eVar, hashSet);
            }
        }
    }

    public c() {
        this.f42162a = new HashMap<>();
    }
}
