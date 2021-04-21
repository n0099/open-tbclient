package d.b.h0.a.n1.c.f;

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
import d.b.h0.a.k;
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
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46117f = k.f45772a;

    /* renamed from: g  reason: collision with root package name */
    public static final long f46118g = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<SwanAppProcessInfo, d.b.h0.a.n1.c.f.c> f46119a;

    /* renamed from: b  reason: collision with root package name */
    public final Deque<Long> f46120b;

    /* renamed from: c  reason: collision with root package name */
    public final Messenger f46121c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<d.b.h0.a.n1.c.f.a> f46122d;

    /* renamed from: e  reason: collision with root package name */
    public final d.b.h0.a.n1.c.f.a f46123e;

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.n1.c.f.a {

        /* renamed from: d.b.h0.a.n1.c.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0780a implements d.b.h0.a.i2.u0.b<d.b.h0.a.n1.c.f.a> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46125e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.a.n1.c.f.c f46126f;

            public C0780a(a aVar, String str, d.b.h0.a.n1.c.f.c cVar) {
                this.f46125e = str;
                this.f46126f = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.h0.a.n1.c.f.a aVar) {
                aVar.a(this.f46125e, this.f46126f);
            }
        }

        public a() {
        }

        @Override // d.b.h0.a.n1.c.f.a
        public void a(String str, d.b.h0.a.n1.c.f.c cVar) {
            if (e.f46117f) {
                Log.i("SwanPuppetManager", "onEvent: to=" + e.this.f46122d.size() + " event=" + str + " client=" + cVar.f46112f);
            }
            synchronized (e.this.f46122d) {
                d.b.h0.a.i2.u0.a.a(d.b.h0.a.r1.d.g(), new C0780a(this, str, cVar), e.this.f46122d);
            }
        }

        @Override // d.b.h0.a.n1.c.f.a
        public void timeout() {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.n1.c.f.a f46127e;

        public b(d.b.h0.a.n1.c.f.a aVar) {
            this.f46127e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (e.this.f46122d) {
                if (e.this.f46122d.contains(this.f46127e)) {
                    if (e.f46117f) {
                        Log.i("SwanPuppetManager", "timeout: callback = " + this.f46127e);
                    }
                    e.this.g(this.f46127e);
                    this.f46127e.timeout();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, d.b.h0.a.n1.c.f.c cVar);
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static e f46129a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e j() {
        if (!f46117f || ProcessUtils.isMainProcess()) {
            return d.f46129a;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    public void b(d.b.h0.a.n1.c.f.a aVar, long j) {
        synchronized (this.f46122d) {
            this.f46122d.add(aVar);
            if (f46117f) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.f46122d.size());
            }
        }
        if (j > 0) {
            d.b.h0.a.r1.d.g().postDelayed(new b(aVar), j);
        }
    }

    public final boolean c() {
        synchronized (this.f46120b) {
            s("checkRescuable ===>");
            if (this.f46120b.size() < 3) {
                s(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.f46120b.size()), 3));
                return true;
            }
            int size = this.f46120b.size() - 3;
            s("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    s("purge: " + this.f46120b.poll());
                }
            }
            s("after purge");
            Long peek = this.f46120b.peek();
            if (peek == null) {
                s("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > f46118g;
            s("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    public synchronized d.b.h0.a.n1.c.f.c d() {
        t("b4 computNextAvailableProcess");
        d.b.h0.a.n1.c.f.c cVar = null;
        d.b.h0.a.n1.c.f.c cVar2 = null;
        for (int i = 0; i <= 5; i++) {
            d.b.h0.a.n1.c.f.c cVar3 = this.f46119a.get(SwanAppProcessInfo.indexOf(i));
            if (cVar3 != null && cVar3.f46112f.isSwanAppProcess() && !cVar3.x()) {
                if (cVar3.C()) {
                    if (f46117f) {
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
            if (f46117f) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar);
            }
            return cVar;
        } else if (cVar2 != null) {
            if (f46117f) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + cVar2);
            }
            return cVar2;
        } else {
            for (d.b.h0.a.n1.c.f.c cVar4 : this.f46119a.values()) {
                if (cVar4 != null) {
                    if (f46117f) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + cVar4);
                    }
                    return cVar4;
                }
            }
            if (f46117f) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
            }
            return n(SwanAppProcessInfo.P0);
        }
    }

    @Nullable
    public synchronized d.b.h0.a.n1.c.f.c e() {
        t("b4 computNextPreloadProcess");
        d.b.h0.a.n1.c.f.c cVar = null;
        for (int i = 0; i <= 5; i++) {
            d.b.h0.a.n1.c.f.c cVar2 = this.f46119a.get(SwanAppProcessInfo.indexOf(i));
            if (cVar2 != null && cVar2.f46112f.isSwanAppProcess() && !cVar2.x()) {
                if (cVar2.C()) {
                    if (f46117f) {
                        Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + cVar2);
                    }
                    return null;
                } else if (cVar == null) {
                    cVar = cVar2;
                }
            }
        }
        if (f46117f) {
            Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + cVar);
        }
        return cVar;
    }

    public synchronized void f(String str, d.b.h0.a.n1.c.f.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<d.b.h0.a.n1.c.f.c> i = j().i(str);
        if (i.isEmpty()) {
            return;
        }
        for (d.b.h0.a.n1.c.f.c cVar2 : i) {
            if (cVar2 != cVar && cVar2 != null && cVar2.x()) {
                if (f46117f) {
                    Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                    Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                }
                cVar2.O();
                cVar2.N();
                if (cVar2.D()) {
                    d.b.h0.a.n1.c.a e2 = d.b.h0.a.n1.c.a.e();
                    d.b.h0.a.n1.c.c cVar3 = new d.b.h0.a.n1.c.c(110, new Bundle());
                    cVar3.b(cVar2.f46112f);
                    e2.h(cVar3);
                }
            }
        }
    }

    public void g(d.b.h0.a.n1.c.f.a aVar) {
        synchronized (this.f46122d) {
            this.f46122d.remove(aVar);
            if (f46117f) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.f46122d.size());
            }
        }
    }

    @Nullable
    public synchronized d.b.h0.a.n1.c.f.c h(@Nullable String str) {
        List<d.b.h0.a.n1.c.f.c> i = i(str);
        if (i.isEmpty()) {
            return null;
        }
        return i.get(i.size() - 1);
    }

    @NonNull
    public synchronized List<d.b.h0.a.n1.c.f.c> i(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (d.b.h0.a.n1.c.f.c cVar : this.f46119a.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized d.b.h0.a.n1.c.f.c k(@Nullable String str) {
        d.b.h0.a.n1.c.f.c h2;
        h2 = h(str);
        if (h2 == null) {
            h2 = d();
        }
        return h2;
    }

    public d.b.h0.a.n1.c.f.a l() {
        return this.f46123e;
    }

    public synchronized d.b.h0.a.n1.c.f.c m(int i) {
        return n(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized d.b.h0.a.n1.c.f.c n(SwanAppProcessInfo swanAppProcessInfo) {
        return this.f46119a.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> d.b.h0.a.n1.c.f.c o(FILTER filter, c<FILTER> cVar) {
        for (d.b.h0.a.n1.c.f.c cVar2 : this.f46119a.values()) {
            if (cVar.a(filter, cVar2)) {
                return cVar2;
            }
        }
        return null;
    }

    public synchronized LinkedHashSet<d.b.h0.a.n1.c.f.c> p() {
        return new LinkedHashSet<>(this.f46119a.values());
    }

    @NonNull
    public synchronized d.b.h0.a.n1.c.f.c q(@Nullable String str) {
        d.b.h0.a.n1.c.f.c k;
        k = k(str);
        u(k.f46112f);
        return k;
    }

    public void r(Message message) {
        d.b.h0.a.n1.c.f.c n;
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
        if (f46117f) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.f46120b.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public void t(String str) {
        if (f46117f) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<d.b.h0.a.n1.c.f.c> p = p();
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(":");
        sb.append("\n-> clients: ");
        for (d.b.h0.a.n1.c.f.c cVar : p) {
            sb.append("\n--> ");
            sb.append(cVar.toString());
        }
        return sb.toString();
    }

    public synchronized void u(SwanAppProcessInfo swanAppProcessInfo) {
        d.b.h0.a.n1.c.f.c remove = this.f46119a.remove(swanAppProcessInfo);
        if (remove != null) {
            this.f46119a.put(swanAppProcessInfo, remove);
        }
        if (f46117f) {
            t("lru -> " + swanAppProcessInfo);
        }
    }

    public void v() {
        synchronized (this.f46120b) {
            if (c()) {
                this.f46120b.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                d.b.h0.a.n1.c.f.b.l(d.b.h0.a.w0.a.c(), bundle);
            }
        }
    }

    public e() {
        SwanAppProcessInfo[] indices;
        this.f46119a = new LinkedHashMap<>();
        this.f46120b = new ArrayDeque();
        this.f46121c = new Messenger(new SwanAppMessengerService.a());
        this.f46122d = new HashSet();
        this.f46123e = new a();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.f46119a.put(swanAppProcessInfo, new d.b.h0.a.n1.c.f.c(swanAppProcessInfo));
            }
        }
    }
}
