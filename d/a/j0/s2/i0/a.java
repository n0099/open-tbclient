package d.a.j0.s2.i0;

import android.webkit.CookieManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import d.a.c.e.j.a.c;
import d.a.c.e.j.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60322a;

    /* renamed from: d.a.j0.s2.i0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1548a extends BdAsyncTask<String, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60323a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60324b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60325c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f60326d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f60327e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f60328f;

        public C1548a(String str, int i2, int i3, int i4, String str2, String str3) {
            this.f60323a = str;
            this.f60324b = i2;
            this.f60325c = i3;
            this.f60326d = i4;
            this.f60327e = str2;
            this.f60328f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            HashMap d2 = a.this.d();
            HashMap e2 = a.this.e(this.f60323a, this.f60324b, this.f60325c, this.f60326d, this.f60327e, this.f60328f);
            e eVar = new e();
            eVar.b().s(a.this.f60322a);
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
        this.f60322a = str;
    }

    public final HashMap<String, String> d() {
        String cookie = CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Cookie", cookie);
        return hashMap;
    }

    public final HashMap<String, Object> e(String str, int i2, int i3, int i4, String str2, String str3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ev", str);
        hashMap.put("st", i2 + "");
        hashMap.put("et", i3 + "");
        hashMap.put("dur", i4 + "");
        hashMap.put("pg", str2);
        hashMap.put("at", str3);
        return hashMap;
    }

    public void f(String str, int i2, int i3, int i4, String str2, String str3) {
        new C1548a(str, i2, i3, i4, str2, str3).execute(new String[0]);
    }
}
