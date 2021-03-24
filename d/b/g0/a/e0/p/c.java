package d.b.g0.a.e0.p;

import android.util.Log;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44138b = d.b.g0.a.k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<d.b.g0.l.k.e, Set<InterfaceC0667c>> f44139a;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f44140a = new c();
    }

    /* renamed from: d.b.g0.a.e0.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0667c {
        void a(PMSDownloadType pMSDownloadType);

        void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar);
    }

    public static c c() {
        return b.f44140a;
    }

    public synchronized void a(d.b.g0.l.k.e eVar, PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
        if (f44138b) {
            Log.i("PMSDownloadRepeatSync", "downloadError:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0667c> set = this.f44139a.get(eVar);
        if (set != null) {
            for (InterfaceC0667c interfaceC0667c : set) {
                if (interfaceC0667c != null) {
                    interfaceC0667c.b(pMSDownloadType, aVar);
                }
            }
            this.f44139a.remove(eVar);
        }
    }

    public synchronized void b(d.b.g0.l.k.e eVar, PMSDownloadType pMSDownloadType) {
        if (f44138b) {
            Log.i("PMSDownloadRepeatSync", "downloadSuccess:" + eVar + ZeusCrashHandler.NAME_SEPERATOR + pMSDownloadType);
        }
        Set<InterfaceC0667c> set = this.f44139a.get(eVar);
        if (set != null) {
            for (InterfaceC0667c interfaceC0667c : set) {
                if (interfaceC0667c != null) {
                    interfaceC0667c.a(pMSDownloadType);
                }
            }
            this.f44139a.remove(eVar);
        }
    }

    public synchronized void d(d.b.g0.l.k.e eVar, InterfaceC0667c interfaceC0667c) {
        if (f44138b) {
            Log.i("PMSDownloadRepeatSync", "registerResultListener:" + eVar);
        }
        if (eVar != null && interfaceC0667c != null) {
            Set<InterfaceC0667c> set = this.f44139a.get(eVar);
            if (set != null) {
                set.add(interfaceC0667c);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(interfaceC0667c);
                this.f44139a.put(eVar, hashSet);
            }
        }
    }

    public c() {
        this.f44139a = new HashMap<>();
    }
}
