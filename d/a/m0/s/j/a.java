package d.a.m0.s.j;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f50711a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f50712b;

    /* renamed from: c  reason: collision with root package name */
    public c f50713c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50714d;

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public b f50715a;

        /* renamed from: b  reason: collision with root package name */
        public volatile NetWork f50716b = null;

        /* renamed from: d.a.m0.s.j.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1161a implements Comparator<Map.Entry<String, Integer>> {
            public C1161a(c cVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                return (int) (d.a.c.e.m.b.d(String.valueOf(entry.getValue()), 0) - d.a.c.e.m.b.d(String.valueOf(entry2.getValue()), 0));
            }
        }

        public c(b bVar) {
            this.f50715a = null;
            this.f50715a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            try {
                this.f50716b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.f50716b.postNetData();
                if (!this.f50716b.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(postNetData);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a.this.f50712b = a.this.j(optString);
                    if (a.this.f50712b == null || a.this.f50712b.size() <= 0) {
                        return null;
                    }
                    HashMap hashMap = new HashMap();
                    int i2 = 0;
                    for (int i3 = 0; i3 < a.this.f50712b.size(); i3++) {
                        String str = (String) a.this.f50712b.get(i3);
                        f fVar = new f();
                        fVar.a(str);
                        if (fVar.d()) {
                            hashMap.put(str, Integer.valueOf(fVar.b()));
                        }
                    }
                    if (hashMap.size() > 0) {
                        a.this.f50712b = new ArrayList();
                        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                        Collections.sort(arrayList, new C1161a(this));
                        StringBuilder sb = new StringBuilder(50);
                        for (Map.Entry entry : arrayList) {
                            a.this.f50712b.add(entry.getKey());
                            if (i2 != 0) {
                                sb.append(",");
                            }
                            i2++;
                            sb.append((String) entry.getKey());
                        }
                        optString = sb.toString();
                    }
                    d.a.m0.r.d0.b.j().w("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                    d.a.m0.r.d0.b.j().x("KeyOfSharedPrefIpList", optString);
                    return null;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r2) {
            a.this.f50713c = null;
            b bVar = this.f50715a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f50716b != null) {
                this.f50716b.cancelNetConnect();
                this.f50716b = null;
            }
            a.this.f50713c = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r2) {
            a.this.f50713c = null;
            b bVar = this.f50715a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.f50713c = null;
            b bVar = this.f50715a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static a f50718a = new a();
    }

    public static a f() {
        return d.f50718a;
    }

    public int e() {
        return d.a.m0.r.d0.b.j().k("KeyOfSharedPrefImCount", 0);
    }

    public List<String> g() {
        if (this.f50712b == null) {
            if (System.currentTimeMillis() - d.a.m0.r.d0.b.j().l("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                d.a.m0.r.d0.b.j().x("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.f50712b = j(d.a.m0.r.d0.b.j().p("KeyOfSharedPrefIpList", null));
        }
        return this.f50712b;
    }

    public String h() {
        int e2 = e();
        if (e2 >= 10) {
            d.a.m0.r.d0.b.j().v("KeyOfSharedPrefImCount", 0);
            d.a.m0.r.d0.b.j().x("KeyOfSharedPrefValidIp", "");
            this.f50711a = null;
            return null;
        }
        if (this.f50711a == null) {
            this.f50711a = d.a.m0.r.d0.b.j().p("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.f50711a)) {
            d.a.m0.r.d0.b.j().v("KeyOfSharedPrefImCount", e2 + 1);
        } else {
            this.f50711a = null;
        }
        return this.f50711a;
    }

    public boolean i() {
        return this.f50714d;
    }

    public final List<String> j(String str) {
        String[] split;
        if (str == null || str.length() <= 0 || (split = str.split(",")) == null || split.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(3);
        for (String str2 : split) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    public void k() {
        this.f50714d = false;
    }

    public void l(String str) {
        if (TiebaIMConfig.defaultUrl.equals(str)) {
            return;
        }
        this.f50711a = str;
        d.a.m0.r.d0.b.j().x("KeyOfSharedPrefValidIp", str);
    }

    public void m(b bVar) {
        if (this.f50713c == null) {
            this.f50714d = true;
            c cVar = new c(bVar);
            this.f50713c = cVar;
            cVar.setSelfExecute(true);
            this.f50713c.execute(new Object[0]);
        }
    }

    public a() {
        this.f50711a = null;
        this.f50712b = null;
        this.f50713c = null;
        this.f50714d = false;
        this.f50714d = false;
        this.f50712b = null;
    }
}
