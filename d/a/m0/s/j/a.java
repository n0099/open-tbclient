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
    public String f54388a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f54389b;

    /* renamed from: c  reason: collision with root package name */
    public c f54390c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54391d;

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public b f54392a;

        /* renamed from: b  reason: collision with root package name */
        public volatile NetWork f54393b = null;

        /* renamed from: d.a.m0.s.j.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1217a implements Comparator<Map.Entry<String, Integer>> {
            public C1217a(c cVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                return (int) (d.a.c.e.m.b.d(String.valueOf(entry.getValue()), 0) - d.a.c.e.m.b.d(String.valueOf(entry2.getValue()), 0));
            }
        }

        public c(b bVar) {
            this.f54392a = null;
            this.f54392a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            try {
                this.f54393b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.f54393b.postNetData();
                if (!this.f54393b.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(postNetData);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a.this.f54389b = a.this.j(optString);
                    if (a.this.f54389b == null || a.this.f54389b.size() <= 0) {
                        return null;
                    }
                    HashMap hashMap = new HashMap();
                    int i2 = 0;
                    for (int i3 = 0; i3 < a.this.f54389b.size(); i3++) {
                        String str = (String) a.this.f54389b.get(i3);
                        f fVar = new f();
                        fVar.a(str);
                        if (fVar.d()) {
                            hashMap.put(str, Integer.valueOf(fVar.b()));
                        }
                    }
                    if (hashMap.size() > 0) {
                        a.this.f54389b = new ArrayList();
                        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                        Collections.sort(arrayList, new C1217a(this));
                        StringBuilder sb = new StringBuilder(50);
                        for (Map.Entry entry : arrayList) {
                            a.this.f54389b.add(entry.getKey());
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
            a.this.f54390c = null;
            b bVar = this.f54392a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f54393b != null) {
                this.f54393b.cancelNetConnect();
                this.f54393b = null;
            }
            a.this.f54390c = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r2) {
            a.this.f54390c = null;
            b bVar = this.f54392a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.f54390c = null;
            b bVar = this.f54392a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static a f54395a = new a();
    }

    public static a f() {
        return d.f54395a;
    }

    public int e() {
        return d.a.m0.r.d0.b.j().k("KeyOfSharedPrefImCount", 0);
    }

    public List<String> g() {
        if (this.f54389b == null) {
            if (System.currentTimeMillis() - d.a.m0.r.d0.b.j().l("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                d.a.m0.r.d0.b.j().x("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.f54389b = j(d.a.m0.r.d0.b.j().p("KeyOfSharedPrefIpList", null));
        }
        return this.f54389b;
    }

    public String h() {
        int e2 = e();
        if (e2 >= 10) {
            d.a.m0.r.d0.b.j().v("KeyOfSharedPrefImCount", 0);
            d.a.m0.r.d0.b.j().x("KeyOfSharedPrefValidIp", "");
            this.f54388a = null;
            return null;
        }
        if (this.f54388a == null) {
            this.f54388a = d.a.m0.r.d0.b.j().p("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.f54388a)) {
            d.a.m0.r.d0.b.j().v("KeyOfSharedPrefImCount", e2 + 1);
        } else {
            this.f54388a = null;
        }
        return this.f54388a;
    }

    public boolean i() {
        return this.f54391d;
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
        this.f54391d = false;
    }

    public void l(String str) {
        if (TiebaIMConfig.defaultUrl.equals(str)) {
            return;
        }
        this.f54388a = str;
        d.a.m0.r.d0.b.j().x("KeyOfSharedPrefValidIp", str);
    }

    public void m(b bVar) {
        if (this.f54390c == null) {
            this.f54391d = true;
            c cVar = new c(bVar);
            this.f54390c = cVar;
            cVar.setSelfExecute(true);
            this.f54390c.execute(new Object[0]);
        }
    }

    public a() {
        this.f54388a = null;
        this.f54389b = null;
        this.f54390c = null;
        this.f54391d = false;
        this.f54391d = false;
        this.f54389b = null;
    }
}
