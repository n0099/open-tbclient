package d.b.g0.a.n1.c.f;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import d.b.g0.a.k;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45395f = k.f45050a;

    /* renamed from: g  reason: collision with root package name */
    public static final long f45396g = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<SwanAppProcessInfo, d.b.g0.a.n1.c.f.c> f45397a;

    /* renamed from: b  reason: collision with root package name */
    public final Deque<Long> f45398b;

    /* renamed from: c  reason: collision with root package name */
    public final Messenger f45399c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<d.b.g0.a.n1.c.f.a> f45400d;

    /* renamed from: e  reason: collision with root package name */
    public final d.b.g0.a.n1.c.f.a f45401e;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.n1.c.f.a {

        /* renamed from: d.b.g0.a.n1.c.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0747a implements d.b.g0.a.i2.u0.b<d.b.g0.a.n1.c.f.a> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f45403e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.n1.c.f.c f45404f;

            public C0747a(a aVar, String str, d.b.g0.a.n1.c.f.c cVar) {
                this.f45403e = str;
                this.f45404f = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.g0.a.n1.c.f.a aVar) {
                aVar.a(this.f45403e, this.f45404f);
            }
        }

        public a() {
        }

        @Override // d.b.g0.a.n1.c.f.a
        public void a(String str, d.b.g0.a.n1.c.f.c cVar) {
            if (e.f45395f) {
                Log.i("SwanPuppetManager", "onEvent: to=" + e.this.f45400d.size() + " event=" + str + " client=" + cVar.f45390f);
            }
            synchronized (e.this.f45400d) {
                d.b.g0.a.i2.u0.a.a(d.b.g0.a.r1.d.g(), new C0747a(this, str, cVar), e.this.f45400d);
            }
        }

        @Override // d.b.g0.a.n1.c.f.a
        public void timeout() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.n1.c.f.a f45405e;

        public b(d.b.g0.a.n1.c.f.a aVar) {
            this.f45405e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (e.this.f45400d) {
                if (e.this.f45400d.contains(this.f45405e)) {
                    if (e.f45395f) {
                        Log.i("SwanPuppetManager", "timeout: callback = " + this.f45405e);
                    }
                    e.this.g(this.f45405e);
                    this.f45405e.timeout();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, d.b.g0.a.n1.c.f.c cVar);
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static e f45407a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e j() {
        if (!f45395f || ProcessUtils.isMainProcess()) {
            return d.f45407a;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    public void b(d.b.g0.a.n1.c.f.a aVar, long j) {
        synchronized (this.f45400d) {
            this.f45400d.add(aVar);
            if (f45395f) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.f45400d.size());
            }
        }
        if (j > 0) {
            d.b.g0.a.r1.d.g().postDelayed(new b(aVar), j);
        }
    }

    public final boolean c() {
        synchronized (this.f45398b) {
            s("checkRescuable ===>");
            if (this.f45398b.size() < 3) {
                s(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.f45398b.size()), 3));
                return true;
            }
            int size = this.f45398b.size() - 3;
            s("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    s("purge: " + this.f45398b.poll());
                }
            }
            s("after purge");
            Long peek = this.f45398b.peek();
            if (peek == null) {
                s("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > f45396g;
            s("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    public synchronized d.b.g0.a.n1.c.f.c d() {
        t("b4 computNextAvailableProcess");
        d.b.g0.a.n1.c.f.c cVar = null;
        d.b.g0.a.n1.c.f.c cVar2 = null;
        for (int i = 0; i <= 5; i++) {
            d.b.g0.a.n1.c.f.c cVar3 = this.f45397a.get(SwanAppProcessInfo.indexOf(i));
            if (cVar3 != null && cVar3.f45390f.isSwanAppProcess() && !cVar3.x()) {
                if (cVar3.C()) {
                    if (f45395f) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + cVar3);
                    }
                    return cVar3;
                }
                if (cVar == null && cVar3.D()) {
                    cVar = cVar3;
                }
                if (cVar2 == null) {
                    cVar2 = cVar3;
                }
            }
        }
        if (cVar != null) {
            if (f45395f) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar);
            }
            return cVar;
        } else if (cVar2 != null) {
            if (f45395f) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + cVar2);
            }
            return cVar2;
        } else {
            for (d.b.g0.a.n1.c.f.c cVar4 : this.f45397a.values()) {
                if (cVar4 != null) {
                    if (f45395f) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + cVar4);
                    }
                    return cVar4;
                }
            }
            if (f45395f) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
            }
            return n(SwanAppProcessInfo.P0);
        }
    }

    @Nullable
    public synchronized d.b.g0.a.n1.c.f.c e() {
        t("b4 computNextPreloadProcess");
        d.b.g0.a.n1.c.f.c cVar = null;
        for (int i = 0; i <= 5; i++) {
            d.b.g0.a.n1.c.f.c cVar2 = this.f45397a.get(SwanAppProcessInfo.indexOf(i));
            if (cVar2 != null && cVar2.f45390f.isSwanAppProcess() && !cVar2.x()) {
                if (cVar2.C()) {
                    if (f45395f) {
                        Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + cVar2);
                    }
                    return null;
                } else if (cVar == null) {
                    cVar = cVar2;
                }
            }
        }
        if (f45395f) {
            Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + cVar);
        }
        return cVar;
    }

    public synchronized void f(String str, d.b.g0.a.n1.c.f.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<d.b.g0.a.n1.c.f.c> i = j().i(str);
        if (i.isEmpty()) {
            return;
        }
        for (d.b.g0.a.n1.c.f.c cVar2 : i) {
            if (cVar2 != cVar && cVar2 != null && cVar2.x()) {
                if (f45395f) {
                    Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                    Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                }
                cVar2.O();
                cVar2.N();
                if (cVar2.D()) {
                    d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
                    d.b.g0.a.n1.c.c cVar3 = new d.b.g0.a.n1.c.c(110, new Bundle());
                    cVar3.b(cVar2.f45390f);
                    e2.h(cVar3);
                }
            }
        }
    }

    public void g(d.b.g0.a.n1.c.f.a aVar) {
        synchronized (this.f45400d) {
            this.f45400d.remove(aVar);
            if (f45395f) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.f45400d.size());
            }
        }
    }

    @Nullable
    public synchronized d.b.g0.a.n1.c.f.c h(@Nullable String str) {
        List<d.b.g0.a.n1.c.f.c> i = i(str);
        if (i.isEmpty()) {
            return null;
        }
        return i.get(i.size() - 1);
    }

    @NonNull
    public synchronized List<d.b.g0.a.n1.c.f.c> i(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (d.b.g0.a.n1.c.f.c cVar : this.f45397a.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized d.b.g0.a.n1.c.f.c k(@Nullable String str) {
        d.b.g0.a.n1.c.f.c h2;
        h2 = h(str);
        if (h2 == null) {
            h2 = d();
        }
        return h2;
    }

    public d.b.g0.a.n1.c.f.a l() {
        return this.f45401e;
    }

    public synchronized d.b.g0.a.n1.c.f.c m(int i) {
        return n(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized d.b.g0.a.n1.c.f.c n(SwanAppProcessInfo swanAppProcessInfo) {
        return this.f45397a.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> d.b.g0.a.n1.c.f.c o(FILTER filter, c<FILTER> cVar) {
        for (d.b.g0.a.n1.c.f.c cVar2 : this.f45397a.values()) {
            if (cVar.a(filter, cVar2)) {
                return cVar2;
            }
        }
        return null;
    }

    public synchronized LinkedHashSet<d.b.g0.a.n1.c.f.c> p() {
        return new LinkedHashSet<>(this.f45397a.values());
    }

    @NonNull
    public synchronized d.b.g0.a.n1.c.f.c q(@Nullable String str) {
        d.b.g0.a.n1.c.f.c k;
        k = k(str);
        u(k.f45390f);
        return k;
    }

    public void r(Message message) {
        d.b.g0.a.n1.c.f.c n;
        if (message == null) {
            return;
        }
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
        if (indexOf.isSwanAppProcess() && (n = n(indexOf)) != null) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(e.class.getClassLoader());
                n.Y(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public final void s(String str) {
        if (f45395f) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.f45398b.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public void t(String str) {
        if (f45395f) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<d.b.g0.a.n1.c.f.c> p = p();
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(":");
        sb.append("\n-> clients: ");
        for (d.b.g0.a.n1.c.f.c cVar : p) {
            sb.append("\n--> ");
            sb.append(cVar.toString());
        }
        return sb.toString();
    }

    public synchronized void u(SwanAppProcessInfo swanAppProcessInfo) {
        d.b.g0.a.n1.c.f.c remove = this.f45397a.remove(swanAppProcessInfo);
        if (remove != null) {
            this.f45397a.put(swanAppProcessInfo, remove);
        }
        if (f45395f) {
            t("lru -> " + swanAppProcessInfo);
        }
    }

    public void v() {
        synchronized (this.f45398b) {
            if (c()) {
                this.f45398b.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                d.b.g0.a.n1.c.f.b.l(d.b.g0.a.w0.a.c(), bundle);
            }
        }
    }

    public e() {
        SwanAppProcessInfo[] indices;
        this.f45397a = new LinkedHashMap<>();
        this.f45398b = new ArrayDeque();
        this.f45399c = new Messenger(new SwanAppMessengerService.a());
        this.f45400d = new HashSet();
        this.f45401e = new a();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.f45397a.put(swanAppProcessInfo, new d.b.g0.a.n1.c.f.c(swanAppProcessInfo));
            }
        }
    }
}
