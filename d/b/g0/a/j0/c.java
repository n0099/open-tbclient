package d.b.g0.a.j0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.g0.a.j0.j.b;
import d.b.g0.a.k;
import d.b.g0.g.l.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class c implements d.b.g0.a.m.c, d.b.g0.a.j0.j.b {
    public static final boolean l = k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public final InterfaceC0717c f45187e;

    /* renamed from: f  reason: collision with root package name */
    public final String f45188f = ProcessUtils.getCurProcessName();

    /* renamed from: g  reason: collision with root package name */
    public f f45189g;

    /* renamed from: h  reason: collision with root package name */
    public g f45190h;
    public AtomicInteger i;
    public CopyOnWriteArrayList<String> j;
    public d.b.g0.a.j0.h.f k;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.w0.a.O().d(c.this);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45193f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.C0720b f45194g;

        public b(List list, boolean z, b.C0720b c0720b) {
            this.f45192e = list;
            this.f45193f = z;
            this.f45194g = c0720b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            c.this.h(this.f45192e, this.f45193f, this.f45194g);
        }
    }

    /* renamed from: d.b.g0.a.j0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0717c extends d.b.g0.a.j0.b {
    }

    public c(InterfaceC0717c interfaceC0717c) {
        this.f45187e = interfaceC0717c;
        ExecutorUtilsExt.postOnElastic(new a(), "addLoginStatusChangedListener", 2);
        this.i = new AtomicInteger(0);
        this.j = new CopyOnWriteArrayList<>();
        this.f45189g = new f();
        this.f45190h = new g();
        this.k = new d.b.g0.a.j0.h.f();
        if (l) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // d.b.g0.a.m.c
    public void a(boolean z) {
        String a2 = d.b.g0.a.w0.a.O().a(this.f45187e.a());
        if (l) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + a2 + ")  -> " + z);
        }
        if (z) {
            n();
        } else {
            j();
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.j.add(str);
    }

    public final Set<String> c(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<d.b.g0.a.n1.c.f.c> p = d.b.g0.a.n1.c.f.e.j().p();
        if (p.size() < 1) {
            return hashSet;
        }
        Iterator<d.b.g0.a.n1.c.f.c> it = p.iterator();
        while (it.hasNext()) {
            d.b.g0.a.n1.c.f.c next = it.next();
            if (next.D() && next.x()) {
                hashSet.add(next.getAppId());
                if (l) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + SmallTailInfo.EMOTION_SUFFIX);
                }
                d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
                d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(i);
                cVar.b(next.f45783f);
                e2.h(cVar);
            }
        }
        return hashSet;
    }

    public final void d(String str, b.C0720b c0720b) {
        d.b.g0.a.j0.j.c.l(c0720b).b(str);
        this.f45189g.g(str);
        this.f45190h.g(str);
        d.b.g0.a.e0.p.p.a.n(str);
    }

    public void e(@Nullable String str, boolean z, b.C0720b c0720b) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        f(arrayList, z, c0720b);
    }

    public void f(@Nullable List<String> list, boolean z, b.C0720b c0720b) {
        if (list == null || list.isEmpty()) {
            return;
        }
        g(list, true, z, c0720b);
    }

    public void g(@Nullable List<String> list, boolean z, boolean z2, b.C0720b c0720b) {
        if (!ProcessUtils.isMainProcess()) {
            if (l) {
                Log.w("SwanAppPurger", "非主进程调用，不执行操作");
                return;
            }
            return;
        }
        if (l) {
            Log.d("SwanAppPurger", "deleteSwanApp");
        }
        if (z2) {
            i(list);
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        h.d.j("").p(Schedulers.io()).D(new b(list, z, c0720b));
    }

    @WorkerThread
    public void h(@Nullable List<String> list, boolean z, b.C0720b c0720b) {
        if (list == null) {
            if (l) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.i.incrementAndGet();
        if (z) {
            if (l) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.f45189g.f(list);
            int size = list.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = d.b.g0.a.u.a.a(list.get(i));
            }
            d.b.g0.a.g0.e.a.b(strArr);
        }
        if (l) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.f45189g.d(list);
        for (String str : list) {
            if (this.j.contains(str)) {
                if (l) {
                    Log.d("SwanAppPurger", "删除小程序==>删除忽略: " + str);
                }
            } else {
                if (l) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str);
                }
                if (l) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序文件: " + str);
                }
                d(str, c0720b);
                if (l) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.f45189g.e(str);
                if (l) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.f45189g.c(str);
            }
        }
        if (this.i.decrementAndGet() <= 0) {
            this.i.set(0);
            this.j.clear();
        }
        d.b.g0.a.j0.j.c.l(c0720b).i();
    }

    public final void i(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        List<SwanFavorItemData> j = SwanFavorDataManager.i().j();
        HashMap hashMap = new HashMap();
        for (SwanFavorItemData swanFavorItemData : j) {
            hashMap.put(swanFavorItemData.getAppKey(), swanFavorItemData);
        }
        Set<String> i = d.b.g0.a.g0.d.b.i(AppRuntime.getAppContext().getContentResolver());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean contains = i.contains(next);
            boolean containsKey = hashMap.containsKey(next);
            if (!contains && !containsKey) {
                if (k.f45443a) {
                    Log.d("SwanAppPurger", "清理过滤-不过滤： " + next);
                }
            } else {
                if (k.f45443a) {
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
        d.b.g0.a.w0.a.Z().b("aiapp_", set, true);
        String g2 = d.b.g0.a.a2.b.g();
        if (!TextUtils.isEmpty(g2)) {
            d.b.g0.p.d.g(g2);
        }
        String i = d.b.g0.a.a2.b.i();
        if (!TextUtils.isEmpty(i)) {
            d.b.g0.p.d.g(i);
        }
        d.b.g0.g.d0.b.b();
        n.c();
    }

    public boolean m() {
        return this.i.get() > 0;
    }

    public final void n() {
        p(o());
    }

    public final Set<String> o() {
        return c(103);
    }

    public final void p(Set<String> set) {
        d.b.g0.a.w0.a.Z().b("aiapp_setting_", set, true);
    }

    public void q(@Nullable Set<String> set, b.C0720b c0720b) {
        d.b.g0.a.j0.h.f fVar = this.k;
        if (fVar != null) {
            fVar.d(set, c0720b);
        }
    }

    public String toString() {
        return "Process<" + this.f45188f + "> " + super.toString();
    }
}
