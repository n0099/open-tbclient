package d.b.j0.s2.g0;

import android.webkit.CookieManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import d.b.c.e.j.a.c;
import d.b.c.e.j.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f62124a;

    /* renamed from: d.b.j0.s2.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1605a extends BdAsyncTask<String, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f62125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f62126b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f62127c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f62128d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62129e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62130f;

        public C1605a(String str, int i, int i2, int i3, String str2, String str3) {
            this.f62125a = str;
            this.f62126b = i;
            this.f62127c = i2;
            this.f62128d = i3;
            this.f62129e = str2;
            this.f62130f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            HashMap d2 = a.this.d();
            HashMap e2 = a.this.e(this.f62125a, this.f62126b, this.f62127c, this.f62128d, this.f62129e, this.f62130f);
            e eVar = new e();
            eVar.b().s(a.this.f62124a);
            eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
            if (d2 != null && !d2.isEmpty()) {
                eVar.b().p(a.this.d());
            }
            if (e2 != null && !e2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, Object> entry : e2.entrySet()) {
                    arrayList.add(entry);
                }
                eVar.b().r(arrayList);
            }
            new c(eVar).n(1, 0, 0);
            eVar.c();
            return null;
        }
    }

    public a(String str) {
        this.f62124a = str;
    }

    public final HashMap<String, String> d() {
        String cookie = CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Cookie", cookie);
        return hashMap;
    }

    public final HashMap<String, Object> e(String str, int i, int i2, int i3, String str2, String str3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ev", str);
        hashMap.put("st", i + "");
        hashMap.put("et", i2 + "");
        hashMap.put("dur", i3 + "");
        hashMap.put("pg", str2);
        hashMap.put("at", str3);
        return hashMap;
    }

    public void f(String str, int i, int i2, int i3, String str2, String str3) {
        new C1605a(str, i, i2, i3, str2, str3).execute(new String[0]);
    }
}
