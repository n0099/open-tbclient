package d.a.n0.s.j;

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
    public String f54495a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f54496b;

    /* renamed from: c  reason: collision with root package name */
    public c f54497c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54498d;

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public b f54499a;

        /* renamed from: b  reason: collision with root package name */
        public volatile NetWork f54500b = null;

        /* renamed from: d.a.n0.s.j.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1220a implements Comparator<Map.Entry<String, Integer>> {
            public C1220a(c cVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                return (int) (d.a.c.e.m.b.d(String.valueOf(entry.getValue()), 0) - d.a.c.e.m.b.d(String.valueOf(entry2.getValue()), 0));
            }
        }

        public c(b bVar) {
            this.f54499a = null;
            this.f54499a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            try {
                this.f54500b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.f54500b.postNetData();
                if (!this.f54500b.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(postNetData);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a.this.f54496b = a.this.j(optString);
                    if (a.this.f54496b == null || a.this.f54496b.size() <= 0) {
                        return null;
                    }
                    HashMap hashMap = new HashMap();
                    int i2 = 0;
                    for (int i3 = 0; i3 < a.this.f54496b.size(); i3++) {
                        String str = (String) a.this.f54496b.get(i3);
                        f fVar = new f();
                        fVar.a(str);
                        if (fVar.d()) {
                            hashMap.put(str, Integer.valueOf(fVar.b()));
                        }
                    }
                    if (hashMap.size() > 0) {
                        a.this.f54496b = new ArrayList();
                        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                        Collections.sort(arrayList, new C1220a(this));
                        StringBuilder sb = new StringBuilder(50);
                        for (Map.Entry entry : arrayList) {
                            a.this.f54496b.add(entry.getKey());
                            if (i2 != 0) {
                                sb.append(",");
                            }
                            i2++;
                            sb.append((String) entry.getKey());
                        }
                        optString = sb.toString();
                    }
                    d.a.n0.r.d0.b.j().w("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                    d.a.n0.r.d0.b.j().x("KeyOfSharedPrefIpList", optString);
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
            a.this.f54497c = null;
            b bVar = this.f54499a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f54500b != null) {
                this.f54500b.cancelNetConnect();
                this.f54500b = null;
            }
            a.this.f54497c = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r2) {
            a.this.f54497c = null;
            b bVar = this.f54499a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.f54497c = null;
            b bVar = this.f54499a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static a f54502a = new a();
    }

    public static a f() {
        return d.f54502a;
    }

    public int e() {
        return d.a.n0.r.d0.b.j().k("KeyOfSharedPrefImCount", 0);
    }

    public List<String> g() {
        if (this.f54496b == null) {
            if (System.currentTimeMillis() - d.a.n0.r.d0.b.j().l("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                d.a.n0.r.d0.b.j().x("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.f54496b = j(d.a.n0.r.d0.b.j().p("KeyOfSharedPrefIpList", null));
        }
        return this.f54496b;
    }

    public String h() {
        int e2 = e();
        if (e2 >= 10) {
            d.a.n0.r.d0.b.j().v("KeyOfSharedPrefImCount", 0);
            d.a.n0.r.d0.b.j().x("KeyOfSharedPrefValidIp", "");
            this.f54495a = null;
            return null;
        }
        if (this.f54495a == null) {
            this.f54495a = d.a.n0.r.d0.b.j().p("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.f54495a)) {
            d.a.n0.r.d0.b.j().v("KeyOfSharedPrefImCount", e2 + 1);
        } else {
            this.f54495a = null;
        }
        return this.f54495a;
    }

    public boolean i() {
        return this.f54498d;
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
        this.f54498d = false;
    }

    public void l(String str) {
        if (TiebaIMConfig.defaultUrl.equals(str)) {
            return;
        }
        this.f54495a = str;
        d.a.n0.r.d0.b.j().x("KeyOfSharedPrefValidIp", str);
    }

    public void m(b bVar) {
        if (this.f54497c == null) {
            this.f54498d = true;
            c cVar = new c(bVar);
            this.f54497c = cVar;
            cVar.setSelfExecute(true);
            this.f54497c.execute(new Object[0]);
        }
    }

    public a() {
        this.f54495a = null;
        this.f54496b = null;
        this.f54497c = null;
        this.f54498d = false;
        this.f54498d = false;
        this.f54496b = null;
    }
}
