package d.a.l0.a.n0;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.n0.l.b;
import d.a.l0.a.p.b.a.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class d implements d.a.l0.a.m.c, d.a.l0.a.n0.l.b {
    public static final boolean m = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public final InterfaceC0815d f47253e;

    /* renamed from: f  reason: collision with root package name */
    public final String f47254f = ProcessUtils.getCurProcessName();

    /* renamed from: g  reason: collision with root package name */
    public g f47255g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.a.n0.c f47256h;

    /* renamed from: i  reason: collision with root package name */
    public l f47257i;
    public AtomicInteger j;
    public CopyOnWriteArrayList<String> k;
    public d.a.l0.a.n0.h.e l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.c1.a.a0().c(d.this);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f47259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f47260f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.C0819b f47261g;

        public b(List list, boolean z, b.C0819b c0819b) {
            this.f47259e = list;
            this.f47260f = z;
            this.f47261g = c0819b;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.h(this.f47259e, this.f47260f, this.f47261g);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            HashSet hashSet;
            int i2;
            boolean z;
            if (bundle != null) {
                hashSet = d.a.l0.a.v2.z0.a.a(bundle.getStringArray("key_exclude_ids"));
                z = bundle.getBoolean("key_force_clean");
                i2 = bundle.getInt("key_clean_scenes_type");
            } else {
                hashSet = null;
                i2 = 0;
                z = false;
            }
            d d2 = f.c().d();
            d.a.l0.a.n0.l.c l = d.a.l0.a.n0.l.c.l();
            l.i(i2);
            d2.t(hashSet, z, l.k());
            return null;
        }
    }

    /* renamed from: d.a.l0.a.n0.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0815d extends d.a.l0.a.n0.b {
    }

    public d(InterfaceC0815d interfaceC0815d) {
        this.f47253e = interfaceC0815d;
        ExecutorUtilsExt.postOnElastic(new a(), "addLoginStatusChangedListener", 2);
        this.j = new AtomicInteger(0);
        this.k = new CopyOnWriteArrayList<>();
        this.f47257i = d.a.l0.a.c1.b.m();
        this.f47255g = new g();
        l lVar = this.f47257i;
        if (lVar != null) {
            this.f47256h = lVar.b();
        }
        this.l = new d.a.l0.a.n0.h.e();
        if (m) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // d.a.l0.a.m.c
    public void a(boolean z) {
        String h2 = d.a.l0.a.c1.a.a0().h(this.f47253e.a());
        if (m) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + h2 + ")  -> " + z);
        }
        if (z) {
            q();
        } else {
            j();
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.k.add(str);
    }

    public final Set<String> c(int i2) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<d.a.l0.a.v1.c.f.c> q = d.a.l0.a.v1.c.f.e.k().q();
        if (q.size() < 1) {
            return hashSet;
        }
        Iterator<d.a.l0.a.v1.c.f.c> it = q.iterator();
        while (it.hasNext()) {
            d.a.l0.a.v1.c.f.c next = it.next();
            if (next.H() && (next.C() || next.E())) {
                hashSet.add(next.getAppId());
                if (m) {
                    Log.i("SwanAppPurger", "sent msg(" + i2 + ") to active swan(" + next.getAppId() + SmallTailInfo.EMOTION_SUFFIX);
                }
                d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
                d.a.l0.a.v1.c.c cVar = new d.a.l0.a.v1.c.c(i2);
                cVar.b(next.f49005f);
                e2.h(cVar);
            }
        }
        return hashSet;
    }

    public final void d(String str, b.C0819b c0819b) {
        d.a.l0.a.n0.l.c.m(c0819b).b(str);
        this.f47255g.a(str);
        d.a.l0.a.n0.c cVar = this.f47256h;
        if (cVar != null) {
            cVar.a(str);
        }
        d.a.l0.a.h0.m.p.a.n(str);
    }

    public void e(@Nullable String str, boolean z, b.C0819b c0819b) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        f(arrayList, z, c0819b);
    }

    public void f(@Nullable List<String> list, boolean z, b.C0819b c0819b) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g(list, true, z, c0819b);
    }

    public void g(@Nullable List<String> list, boolean z, boolean z2, b.C0819b c0819b) {
        if (!ProcessUtils.isMainProcess()) {
            if (m) {
                Log.w("SwanAppPurger", "非主进程调用，不执行操作");
                return;
            }
            return;
        }
        d.a.l0.a.e0.d.i("SwanAppPurger", "deleteSwanApp", new Exception("deleteSwanApp"));
        if (z2) {
            i(list);
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        o(list);
        ExecutorUtilsExt.postOnSerial(new b(list, z, c0819b), "deleteSwanApp");
    }

    @WorkerThread
    public void h(@Nullable List<String> list, boolean z, b.C0819b c0819b) {
        if (list == null) {
            if (m) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.j.incrementAndGet();
        if (z) {
            d.a.l0.a.e0.d.h("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            this.f47255g.g(list);
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = d.a.l0.a.v.a.a(list.get(i2));
            }
            d.a.l0.a.j0.d.a.b(strArr);
        }
        d.a.l0.a.e0.d.h("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        this.f47255g.e(list);
        for (String str : list) {
            if (this.k.contains(str) || TextUtils.isEmpty(str)) {
                d.a.l0.a.e0.d.h("SwanAppPurger", "删除小程序==>删除忽略: " + str);
            } else {
                if (m) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str);
                }
                d.a.l0.a.e0.d.h("SwanAppPurger", "删除小程序==>删除小程序文件: " + str);
                p(str, c0819b);
            }
        }
        if (this.j.decrementAndGet() <= 0) {
            this.j.set(0);
            this.k.clear();
            d.a.l0.a.n0.h.b.a();
        }
        d.a.l0.a.n0.l.c.m(c0819b).j();
    }

    public final void i(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        List<SwanFavorItemData> i2 = SwanFavorDataManager.h().i();
        HashMap hashMap = new HashMap();
        for (SwanFavorItemData swanFavorItemData : i2) {
            hashMap.put(swanFavorItemData.getAppKey(), swanFavorItemData);
        }
        Set<String> h2 = d.a.l0.a.j0.c.b.h(AppRuntime.getAppContext().getContentResolver());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean contains = h2.contains(next);
            boolean containsKey = hashMap.containsKey(next);
            if (!contains && !containsKey) {
                if (k.f46875a) {
                    Log.d("SwanAppPurger", "清理过滤-不过滤： " + next);
                }
            } else {
                if (k.f46875a) {
                    Log.d("SwanAppPurger", "清理过滤-过滤此App：" + next + "； 历史：" + contains + "； 我的小程序：" + containsKey);
                }
                it.remove();
            }
        }
    }

    public final void j() {
        l(k());
    }

    public final Set<String> k() {
        return c(100);
    }

    public final void l(Set<String> set) {
        d.a.l0.a.k2.h.d.j().g("aiapp_", set, true);
        String w = d.a.l0.a.k2.b.w();
        if (!TextUtils.isEmpty(w)) {
            d.a.l0.t.d.j(w);
        }
        String y = d.a.l0.a.k2.b.y();
        if (!TextUtils.isEmpty(y)) {
            d.a.l0.t.d.j(y);
        }
        String n = d.a.l0.a.a1.e.n();
        if (!TextUtils.isEmpty(n)) {
            d.a.l0.t.d.j(n);
        }
        l lVar = this.f47257i;
        if (lVar != null) {
            lVar.g();
            this.f47257i.c();
        }
    }

    public boolean m() {
        return this.j.get() > 0;
    }

    public boolean n(Map<String, PMSAppInfo> map) {
        if (map == null || map.size() <= 0) {
            return false;
        }
        return (map.size() == 1 && map.containsKey("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) ? false : true;
    }

    public void o(@Nullable List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            d.a.l0.a.k2.g.b a2 = h.a();
            a2.putInt("bookshelf_insert" + it.next(), 0);
        }
    }

    public final void p(String str, b.C0819b c0819b) {
        if (d.a.l0.a.n0.h.c.a() && d.a.l0.a.a1.e.f().contains(str)) {
            d.a.l0.a.e0.d.h("SwanAppPurger", "删除小程序==>小程序现在存活: " + str);
        } else if (d.a.l0.a.n0.h.b.c(str)) {
            d.a.l0.a.e0.d.h("SwanAppPurger", "删除小程序==>小程序现正在下载中: " + str);
        } else {
            d(str, c0819b);
            d.a.l0.a.e0.d.h("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
            this.f47255g.f(str);
            d.a.l0.a.e0.d.h("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
            this.f47255g.d(str);
        }
    }

    public final void q() {
        s(r());
    }

    public final Set<String> r() {
        return c(103);
    }

    public final void s(Set<String> set) {
        d.a.l0.a.k2.h.d.j().g("aiapp_setting_", set, true);
    }

    public void t(@Nullable Set<String> set, boolean z, b.C0819b c0819b) {
        d.a.l0.a.n0.h.e eVar = this.l;
        if (eVar != null) {
            eVar.i(set, z, c0819b);
        }
    }

    public String toString() {
        return "Process<" + this.f47254f + "> " + super.toString();
    }

    public void u(@Nullable Set<String> set, boolean z, int i2) {
        if (ProcessUtils.isMainProcess()) {
            d.a.l0.a.n0.l.c l = d.a.l0.a.n0.l.c.l();
            l.i(i2);
            t(set, z, l.k());
            return;
        }
        Bundle bundle = new Bundle();
        if (set != null && set.size() > 0) {
            bundle.putStringArray("key_exclude_ids", (String[]) set.toArray(new String[0]));
        }
        bundle.putBoolean("key_force_clean", z);
        bundle.putInt("key_clean_scenes_type", i2);
        d.a.l0.a.v1.b.d.b(c.class, bundle);
    }
}
