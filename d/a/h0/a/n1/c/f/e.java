package d.a.h0.a.n1.c.f;

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
import d.a.h0.a.k;
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
    public static final boolean f43463f = k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public static final long f43464g = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<SwanAppProcessInfo, d.a.h0.a.n1.c.f.c> f43465a;

    /* renamed from: b  reason: collision with root package name */
    public final Deque<Long> f43466b;

    /* renamed from: c  reason: collision with root package name */
    public final Messenger f43467c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<d.a.h0.a.n1.c.f.a> f43468d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.h0.a.n1.c.f.a f43469e;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.n1.c.f.a {

        /* renamed from: d.a.h0.a.n1.c.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0719a implements d.a.h0.a.i2.u0.b<d.a.h0.a.n1.c.f.a> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43471e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.n1.c.f.c f43472f;

            public C0719a(a aVar, String str, d.a.h0.a.n1.c.f.c cVar) {
                this.f43471e = str;
                this.f43472f = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.a.h0.a.n1.c.f.a aVar) {
                aVar.a(this.f43471e, this.f43472f);
            }
        }

        public a() {
        }

        @Override // d.a.h0.a.n1.c.f.a
        public void a(String str, d.a.h0.a.n1.c.f.c cVar) {
            if (e.f43463f) {
                Log.i("SwanPuppetManager", "onEvent: to=" + e.this.f43468d.size() + " event=" + str + " client=" + cVar.f43457f);
            }
            synchronized (e.this.f43468d) {
                d.a.h0.a.i2.u0.a.a(d.a.h0.a.r1.d.g(), new C0719a(this, str, cVar), e.this.f43468d);
            }
        }

        @Override // d.a.h0.a.n1.c.f.a
        public void timeout() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.n1.c.f.a f43473e;

        public b(d.a.h0.a.n1.c.f.a aVar) {
            this.f43473e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (e.this.f43468d) {
                if (e.this.f43468d.contains(this.f43473e)) {
                    if (e.f43463f) {
                        Log.i("SwanPuppetManager", "timeout: callback = " + this.f43473e);
                    }
                    e.this.g(this.f43473e);
                    this.f43473e.timeout();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, d.a.h0.a.n1.c.f.c cVar);
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static e f43475a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e j() {
        if (!f43463f || ProcessUtils.isMainProcess()) {
            return d.f43475a;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    public void b(d.a.h0.a.n1.c.f.a aVar, long j) {
        synchronized (this.f43468d) {
            this.f43468d.add(aVar);
            if (f43463f) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.f43468d.size());
            }
        }
        if (j > 0) {
            d.a.h0.a.r1.d.g().postDelayed(new b(aVar), j);
        }
    }

    public final boolean c() {
        synchronized (this.f43466b) {
            s("checkRescuable ===>");
            if (this.f43466b.size() < 3) {
                s(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.f43466b.size()), 3));
                return true;
            }
            int size = this.f43466b.size() - 3;
            s("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    s("purge: " + this.f43466b.poll());
                }
            }
            s("after purge");
            Long peek = this.f43466b.peek();
            if (peek == null) {
                s("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > f43464g;
            s("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    public synchronized d.a.h0.a.n1.c.f.c d() {
        t("b4 computNextAvailableProcess");
        d.a.h0.a.n1.c.f.c cVar = null;
        d.a.h0.a.n1.c.f.c cVar2 = null;
        for (int i2 = 0; i2 <= 5; i2++) {
            d.a.h0.a.n1.c.f.c cVar3 = this.f43465a.get(SwanAppProcessInfo.indexOf(i2));
            if (cVar3 != null && cVar3.f43457f.isSwanAppProcess() && !cVar3.z()) {
                if (cVar3.C()) {
                    if (f43463f) {
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
            if (f43463f) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar);
            }
            return cVar;
        } else if (cVar2 != null) {
            if (f43463f) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + cVar2);
            }
            return cVar2;
        } else {
            for (d.a.h0.a.n1.c.f.c cVar4 : this.f43465a.values()) {
                if (cVar4 != null) {
                    if (f43463f) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + cVar4);
                    }
                    return cVar4;
                }
            }
            if (f43463f) {
                Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
            }
            return n(SwanAppProcessInfo.P0);
        }
    }

    @Nullable
    public synchronized d.a.h0.a.n1.c.f.c e() {
        t("b4 computNextPreloadProcess");
        d.a.h0.a.n1.c.f.c cVar = null;
        for (int i2 = 0; i2 <= 5; i2++) {
            d.a.h0.a.n1.c.f.c cVar2 = this.f43465a.get(SwanAppProcessInfo.indexOf(i2));
            if (cVar2 != null && cVar2.f43457f.isSwanAppProcess() && !cVar2.z()) {
                if (cVar2.C()) {
                    if (f43463f) {
                        Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + cVar2);
                    }
                    return null;
                } else if (cVar == null) {
                    cVar = cVar2;
                }
            }
        }
        if (f43463f) {
            Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + cVar);
        }
        return cVar;
    }

    public synchronized void f(String str, d.a.h0.a.n1.c.f.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<d.a.h0.a.n1.c.f.c> i2 = j().i(str);
        if (i2.isEmpty()) {
            return;
        }
        for (d.a.h0.a.n1.c.f.c cVar2 : i2) {
            if (cVar2 != cVar && cVar2 != null && cVar2.z()) {
                if (f43463f) {
                    Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                    Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                }
                cVar2.O();
                cVar2.N();
                if (cVar2.D()) {
                    d.a.h0.a.n1.c.a e2 = d.a.h0.a.n1.c.a.e();
                    d.a.h0.a.n1.c.c cVar3 = new d.a.h0.a.n1.c.c(110, new Bundle());
                    cVar3.b(cVar2.f43457f);
                    e2.h(cVar3);
                }
            }
        }
    }

    public void g(d.a.h0.a.n1.c.f.a aVar) {
        synchronized (this.f43468d) {
            this.f43468d.remove(aVar);
            if (f43463f) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.f43468d.size());
            }
        }
    }

    @Nullable
    public synchronized d.a.h0.a.n1.c.f.c h(@Nullable String str) {
        List<d.a.h0.a.n1.c.f.c> i2 = i(str);
        if (i2.isEmpty()) {
            return null;
        }
        return i2.get(i2.size() - 1);
    }

    @NonNull
    public synchronized List<d.a.h0.a.n1.c.f.c> i(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (d.a.h0.a.n1.c.f.c cVar : this.f43465a.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized d.a.h0.a.n1.c.f.c k(@Nullable String str) {
        d.a.h0.a.n1.c.f.c h2;
        h2 = h(str);
        if (h2 == null) {
            h2 = d();
        }
        return h2;
    }

    public d.a.h0.a.n1.c.f.a l() {
        return this.f43469e;
    }

    public synchronized d.a.h0.a.n1.c.f.c m(int i2) {
        return n(SwanAppProcessInfo.indexOf(i2));
    }

    public synchronized d.a.h0.a.n1.c.f.c n(SwanAppProcessInfo swanAppProcessInfo) {
        return this.f43465a.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> d.a.h0.a.n1.c.f.c o(FILTER filter, c<FILTER> cVar) {
        for (d.a.h0.a.n1.c.f.c cVar2 : this.f43465a.values()) {
            if (cVar.a(filter, cVar2)) {
                return cVar2;
            }
        }
        return null;
    }

    public synchronized LinkedHashSet<d.a.h0.a.n1.c.f.c> p() {
        return new LinkedHashSet<>(this.f43465a.values());
    }

    @NonNull
    public synchronized d.a.h0.a.n1.c.f.c q(@Nullable String str) {
        d.a.h0.a.n1.c.f.c k;
        k = k(str);
        u(k.f43457f);
        return k;
    }

    public void r(Message message) {
        d.a.h0.a.n1.c.f.c n;
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
        if (f43463f) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.f43466b.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public void t(String str) {
        if (f43463f) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<d.a.h0.a.n1.c.f.c> p = p();
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(":");
        sb.append("\n-> clients: ");
        for (d.a.h0.a.n1.c.f.c cVar : p) {
            sb.append("\n--> ");
            sb.append(cVar.toString());
        }
        return sb.toString();
    }

    public synchronized void u(SwanAppProcessInfo swanAppProcessInfo) {
        d.a.h0.a.n1.c.f.c remove = this.f43465a.remove(swanAppProcessInfo);
        if (remove != null) {
            this.f43465a.put(swanAppProcessInfo, remove);
        }
        if (f43463f) {
            t("lru -> " + swanAppProcessInfo);
        }
    }

    public void v() {
        synchronized (this.f43466b) {
            if (c()) {
                this.f43466b.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                d.a.h0.a.n1.c.f.b.l(d.a.h0.a.w0.a.c(), bundle);
            }
        }
    }

    public e() {
        SwanAppProcessInfo[] indices;
        this.f43465a = new LinkedHashMap<>();
        this.f43466b = new ArrayDeque();
        this.f43467c = new Messenger(new SwanAppMessengerService.a());
        this.f43468d = new HashSet();
        this.f43469e = new a();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.f43465a.put(swanAppProcessInfo, new d.a.h0.a.n1.c.f.c(swanAppProcessInfo));
            }
        }
    }
}
