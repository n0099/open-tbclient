package d.b.i0.s2.g0;

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
    public String f61703a;

    /* renamed from: d.b.i0.s2.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1582a extends BdAsyncTask<String, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61704a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f61705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f61706c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f61707d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f61708e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f61709f;

        public C1582a(String str, int i, int i2, int i3, String str2, String str3) {
            this.f61704a = str;
            this.f61705b = i;
            this.f61706c = i2;
            this.f61707d = i3;
            this.f61708e = str2;
            this.f61709f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            HashMap d2 = a.this.d();
            HashMap e2 = a.this.e(this.f61704a, this.f61705b, this.f61706c, this.f61707d, this.f61708e, this.f61709f);
            e eVar = new e();
            eVar.b().s(a.this.f61703a);
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
        this.f61703a = str;
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
        new C1582a(str, i, i2, i3, str2, str3).execute(new String[0]);
    }
}
