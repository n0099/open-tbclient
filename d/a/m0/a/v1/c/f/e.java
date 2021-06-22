package d.a.m0.a.v1.c.f;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.ipc.SwanProcessCallStub;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import d.a.m0.a.k;
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

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f49119h = k.f46983a;

    /* renamed from: i  reason: collision with root package name */
    public static final long f49120i = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<SwanAppProcessInfo, d.a.m0.a.v1.c.f.c> f49121a;

    /* renamed from: b  reason: collision with root package name */
    public final Deque<Long> f49122b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f49123c;

    /* renamed from: d  reason: collision with root package name */
    public final Messenger f49124d;

    /* renamed from: e  reason: collision with root package name */
    public final SwanProcessCallStub f49125e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.a.m0.a.v1.c.f.a> f49126f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.m0.a.v1.c.f.a f49127g;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v1.c.f.a {

        /* renamed from: d.a.m0.a.v1.c.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0942a implements d.a.m0.a.v2.e1.b<d.a.m0.a.v1.c.f.a> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f49129e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.v1.c.f.c f49130f;

            public C0942a(a aVar, String str, d.a.m0.a.v1.c.f.c cVar) {
                this.f49129e = str;
                this.f49130f = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.m0.a.v1.c.f.a aVar) {
                aVar.a(this.f49129e, this.f49130f);
            }
        }

        public a() {
        }

        @Override // d.a.m0.a.v1.c.f.a
        public void a(String str, d.a.m0.a.v1.c.f.c cVar) {
            if (e.f49119h) {
                Log.i("SwanPuppetManager", "onEvent: to=" + e.this.f49126f.size() + " event=" + str + " client=" + cVar.f49113f);
            }
            synchronized (e.this.f49126f) {
                d.a.m0.a.v2.e1.a.a(d.a.m0.a.a2.d.i(), new C0942a(this, str, cVar), e.this.f49126f);
            }
        }

        @Override // d.a.m0.a.v1.c.f.a
        public void timeout() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v1.c.f.a f49131e;

        public b(d.a.m0.a.v1.c.f.a aVar) {
            this.f49131e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (e.this.f49126f) {
                if (e.this.f49126f.contains(this.f49131e)) {
                    if (e.f49119h) {
                        Log.i("SwanPuppetManager", "timeout: callback = " + this.f49131e);
                    }
                    e.this.h(this.f49131e);
                    this.f49131e.timeout();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, d.a.m0.a.v1.c.f.c cVar);
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static e f49133a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e k() {
        if (!f49119h || ProcessUtils.isMainProcess()) {
            return d.f49133a;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    public void b(d.a.m0.a.v1.c.f.a aVar) {
        c(aVar, -1L);
    }

    public void c(d.a.m0.a.v1.c.f.a aVar, long j) {
        synchronized (this.f49126f) {
            this.f49126f.add(aVar);
            if (f49119h) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.f49126f.size());
            }
        }
        if (j > 0) {
            d.a.m0.a.a2.d.i().postDelayed(new b(aVar), j);
        }
    }

    public final boolean d() {
        synchronized (this.f49122b) {
            t("checkRescuable ===>");
            if (this.f49122b.size() < 3) {
                t(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.f49122b.size()), 3));
                return true;
            }
            int size = this.f49122b.size() - 3;
            t("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    t("purge: " + this.f49122b.poll());
                }
            }
            t("after purge");
            Long peek = this.f49122b.peek();
            if (peek == null) {
                t("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > f49120i;
            t("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    public synchronized d.a.m0.a.v1.c.f.c e() {
        u("b4 computNextAvailableProcess");
        d.a.m0.a.v1.c.f.c cVar = null;
        d.a.m0.a.v1.c.f.c cVar2 = null;
        for (int i2 = 0; i2 <= 5; i2++) {
            d.a.m0.a.v1.c.f.c cVar3 = this.f49121a.get(SwanAppProcessInfo.indexOf(i2));
            if (cVar3 != null && cVar3.f49113f.isSwanAppProcess() && !cVar3.C()) {
                if (cVar3.G()) {
                    if (f49119h) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + cVar3);
                    }
                    return cVar3;
                }
                if (cVar == null && cVar3.H()) {
                    cVar = cVar3;
                }
                if (cVar2 == null) {
                    cVar2 = cVar3;
                }
            }
        }
        if (cVar != null) {
            if (f49119h) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar);
            }
            return cVar;
        } else if (cVar2 != null) {
            if (f49119h) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + cVar2);
            }
            return cVar2;
        } else {
            for (d.a.m0.a.v1.c.f.c cVar4 : this.f49121a.values()) {
                if (cVar4 != null) {
                    if (f49119h) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + cVar4);
                    }
                    return cVar4;
                }
            }
            if (f49119h) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
            }
            return o(SwanAppProcessInfo.P0);
        }
    }

    @Nullable
    public synchronized d.a.m0.a.v1.c.f.c f() {
        u("b4 computNextPreloadProcess");
        d.a.m0.a.v1.c.f.c cVar = null;
        for (int i2 = 0; i2 <= 5; i2++) {
            d.a.m0.a.v1.c.f.c cVar2 = this.f49121a.get(SwanAppProcessInfo.indexOf(i2));
            if (cVar2 != null && cVar2.f49113f.isSwanAppProcess() && !cVar2.C()) {
                if (cVar2.G()) {
                    if (f49119h) {
                        Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + cVar2);
                    }
                    return null;
                } else if (cVar == null) {
                    cVar = cVar2;
                }
            }
        }
        if (f49119h) {
            Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + cVar);
        }
        return cVar;
    }

    public synchronized void g(String str, d.a.m0.a.v1.c.f.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<d.a.m0.a.v1.c.f.c> j = k().j(str);
        if (j.isEmpty()) {
            return;
        }
        for (d.a.m0.a.v1.c.f.c cVar2 : j) {
            if (cVar2 != cVar && cVar2 != null && cVar2.C()) {
                if (f49119h) {
                    Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                    Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                }
                cVar2.S();
                cVar2.R();
                if (cVar2.H()) {
                    d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
                    d.a.m0.a.v1.c.c cVar3 = new d.a.m0.a.v1.c.c(110, new Bundle());
                    cVar3.b(cVar2.f49113f);
                    e2.h(cVar3);
                }
            }
        }
    }

    public void h(d.a.m0.a.v1.c.f.a aVar) {
        synchronized (this.f49126f) {
            this.f49126f.remove(aVar);
            if (f49119h) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.f49126f.size());
            }
        }
    }

    @Nullable
    public synchronized d.a.m0.a.v1.c.f.c i(@Nullable String str) {
        List<d.a.m0.a.v1.c.f.c> j = j(str);
        if (j.isEmpty()) {
            return null;
        }
        return j.get(j.size() - 1);
    }

    @NonNull
    public synchronized List<d.a.m0.a.v1.c.f.c> j(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (d.a.m0.a.v1.c.f.c cVar : this.f49121a.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized d.a.m0.a.v1.c.f.c l(@Nullable String str) {
        d.a.m0.a.v1.c.f.c i2;
        i2 = i(str);
        if (i2 == null) {
            i2 = e();
        }
        return i2;
    }

    public d.a.m0.a.v1.c.f.a m() {
        return this.f49127g;
    }

    public synchronized d.a.m0.a.v1.c.f.c n(int i2) {
        return o(SwanAppProcessInfo.indexOf(i2));
    }

    public synchronized d.a.m0.a.v1.c.f.c o(SwanAppProcessInfo swanAppProcessInfo) {
        return this.f49121a.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> d.a.m0.a.v1.c.f.c p(FILTER filter, c<FILTER> cVar) {
        for (d.a.m0.a.v1.c.f.c cVar2 : this.f49121a.values()) {
            if (cVar.a(filter, cVar2)) {
                return cVar2;
            }
        }
        return null;
    }

    public synchronized LinkedHashSet<d.a.m0.a.v1.c.f.c> q() {
        return new LinkedHashSet<>(this.f49121a.values());
    }

    @NonNull
    public synchronized d.a.m0.a.v1.c.f.c r(@Nullable String str) {
        d.a.m0.a.v1.c.f.c l;
        l = l(str);
        v(l.f49113f);
        return l;
    }

    public void s(Message message) {
        d.a.m0.a.v1.c.f.c o;
        if (message == null) {
            return;
        }
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
        if (indexOf.isSwanAppProcess() && (o = o(indexOf)) != null) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(e.class.getClassLoader());
                o.d0(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public final void t(String str) {
        if (f49119h) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.f49122b.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public String toString() {
        LinkedHashSet<d.a.m0.a.v1.c.f.c> q = q();
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(":");
        sb.append("\n-> clients: ");
        for (d.a.m0.a.v1.c.f.c cVar : q) {
            sb.append("\n--> ");
            sb.append(cVar.toString());
        }
        return sb.toString();
    }

    public void u(String str) {
        if (f49119h) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public synchronized void v(SwanAppProcessInfo swanAppProcessInfo) {
        d.a.m0.a.v1.c.f.c remove = this.f49121a.remove(swanAppProcessInfo);
        if (remove != null) {
            this.f49121a.put(swanAppProcessInfo, remove);
        }
        if (f49119h) {
            u("lru -> " + swanAppProcessInfo);
        }
    }

    public void w() {
        synchronized (this.f49122b) {
            if (d()) {
                this.f49122b.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                d.a.m0.a.v1.c.f.b.n(d.a.m0.a.c1.a.b(), bundle);
            }
        }
    }

    public e() {
        SwanAppProcessInfo[] indices;
        this.f49121a = new LinkedHashMap<>();
        this.f49122b = new ArrayDeque();
        this.f49123c = new SwanAppMessengerService.a();
        this.f49124d = new Messenger(this.f49123c);
        this.f49125e = new SwanProcessCallStub(this.f49123c);
        this.f49126f = new HashSet();
        this.f49127g = new a();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.f49121a.put(swanAppProcessInfo, new d.a.m0.a.v1.c.f.c(swanAppProcessInfo));
            }
        }
    }
}
