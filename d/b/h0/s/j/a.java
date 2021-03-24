package d.b.h0.s.j;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.b.b.e.p.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f51400a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f51401b;

    /* renamed from: c  reason: collision with root package name */
    public c f51402c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51403d;

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public b f51404a;

        /* renamed from: b  reason: collision with root package name */
        public volatile NetWork f51405b = null;

        /* renamed from: d.b.h0.s.j.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1102a implements Comparator<Map.Entry<String, Integer>> {
            public C1102a(c cVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                return (int) (d.b.b.e.m.b.d(String.valueOf(entry.getValue()), 0) - d.b.b.e.m.b.d(String.valueOf(entry2.getValue()), 0));
            }
        }

        public c(b bVar) {
            this.f51404a = null;
            this.f51404a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            try {
                this.f51405b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.f51405b.postNetData();
                if (!this.f51405b.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(postNetData);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a.this.f51401b = a.this.j(optString);
                    if (a.this.f51401b == null || a.this.f51401b.size() <= 0) {
                        return null;
                    }
                    HashMap hashMap = new HashMap();
                    int i = 0;
                    for (int i2 = 0; i2 < a.this.f51401b.size(); i2++) {
                        String str = (String) a.this.f51401b.get(i2);
                        f fVar = new f();
                        fVar.a(str);
                        if (fVar.d()) {
                            hashMap.put(str, Integer.valueOf(fVar.b()));
                        }
                    }
                    if (hashMap.size() > 0) {
                        a.this.f51401b = new ArrayList();
                        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                        Collections.sort(arrayList, new C1102a(this));
                        StringBuilder sb = new StringBuilder(50);
                        for (Map.Entry entry : arrayList) {
                            a.this.f51401b.add(entry.getKey());
                            if (i != 0) {
                                sb.append(",");
                            }
                            i++;
                            sb.append((String) entry.getKey());
                        }
                        optString = sb.toString();
                    }
                    d.b.h0.r.d0.b.i().v("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                    d.b.h0.r.d0.b.i().w("KeyOfSharedPrefIpList", optString);
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
            a.this.f51402c = null;
            b bVar = this.f51404a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f51405b != null) {
                this.f51405b.cancelNetConnect();
                this.f51405b = null;
            }
            a.this.f51402c = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r2) {
            a.this.f51402c = null;
            b bVar = this.f51404a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.f51402c = null;
            b bVar = this.f51404a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static a f51407a = new a();
    }

    public static a f() {
        return d.f51407a;
    }

    public int e() {
        return d.b.h0.r.d0.b.i().j("KeyOfSharedPrefImCount", 0);
    }

    public List<String> g() {
        if (this.f51401b == null) {
            if (System.currentTimeMillis() - d.b.h0.r.d0.b.i().k("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                d.b.h0.r.d0.b.i().w("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.f51401b = j(d.b.h0.r.d0.b.i().o("KeyOfSharedPrefIpList", null));
        }
        return this.f51401b;
    }

    public String h() {
        int e2 = e();
        if (e2 >= 10) {
            d.b.h0.r.d0.b.i().u("KeyOfSharedPrefImCount", 0);
            d.b.h0.r.d0.b.i().w("KeyOfSharedPrefValidIp", "");
            this.f51400a = null;
            return null;
        }
        if (this.f51400a == null) {
            this.f51400a = d.b.h0.r.d0.b.i().o("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.f51400a)) {
            d.b.h0.r.d0.b.i().u("KeyOfSharedPrefImCount", e2 + 1);
        } else {
            this.f51400a = null;
        }
        return this.f51400a;
    }

    public boolean i() {
        return this.f51403d;
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
        this.f51403d = false;
    }

    public void l(String str) {
        if (TiebaIMConfig.defaultUrl.equals(str)) {
            return;
        }
        this.f51400a = str;
        d.b.h0.r.d0.b.i().w("KeyOfSharedPrefValidIp", str);
    }

    public void m(b bVar) {
        if (this.f51402c == null) {
            this.f51403d = true;
            c cVar = new c(bVar);
            this.f51402c = cVar;
            cVar.setSelfExecute(true);
            this.f51402c.execute(new Object[0]);
        }
    }

    public a() {
        this.f51400a = null;
        this.f51401b = null;
        this.f51402c = null;
        this.f51403d = false;
        this.f51403d = false;
        this.f51401b = null;
    }
}
