package d.b.i0.j1.o.h;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import d.b.c.e.j.a.e;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f57375a;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<String, Void, Void> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            HashMap c2 = c.this.c();
            e eVar = new e();
            eVar.b().s(c.this.f57375a);
            eVar.b().q(HttpMessageTask.HTTP_METHOD.GET);
            if (c2 != null && !c2.isEmpty()) {
                eVar.b().p(c.this.c());
            }
            new d.b.c.e.j.a.c(eVar).n(1, 0, 0);
            eVar.c();
            return null;
        }
    }

    public c(String str) {
        this.f57375a = str;
    }

    public static b e(AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.W3) == null || !(iLegoAdvert instanceof b)) {
            return null;
        }
        return (b) iLegoAdvert;
    }

    public static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new c(str).d();
    }

    public static void g(b bVar) {
        if (bVar == null || bVar.getParallelCharge() == null) {
            return;
        }
        f(bVar.getParallelCharge().f57372b);
        Iterator<String> it = bVar.getParallelCharge().f57373c.iterator();
        while (it.hasNext()) {
            f(it.next());
        }
    }

    public static boolean h(b bVar) {
        if (bVar == null || bVar.getParallelCharge() == null) {
            return false;
        }
        String str = bVar.getParallelCharge().f57371a;
        f(str);
        boolean z = !TextUtils.isEmpty(str);
        Iterator<String> it = bVar.getParallelCharge().f57374d.iterator();
        while (it.hasNext()) {
            String next = it.next();
            z = z || !TextUtils.isEmpty(next);
            f(next);
        }
        return z;
    }

    public final HashMap<String, String> c() {
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
            cookie = d.b.h0.l.a.f50659a;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Cookie", cookie);
        return hashMap;
    }

    public void d() {
        new a().execute(new String[0]);
    }
}
