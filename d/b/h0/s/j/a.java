package d.b.h0.s.j;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.NetWork;
import d.b.c.e.p.k;
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
    public String f51818a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f51819b;

    /* renamed from: c  reason: collision with root package name */
    public c f51820c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51821d;

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public b f51822a;

        /* renamed from: b  reason: collision with root package name */
        public volatile NetWork f51823b = null;

        /* renamed from: d.b.h0.s.j.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1116a implements Comparator<Map.Entry<String, Integer>> {
            public C1116a(c cVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                return (int) (d.b.c.e.m.b.d(String.valueOf(entry.getValue()), 0) - d.b.c.e.m.b.d(String.valueOf(entry2.getValue()), 0));
            }
        }

        public c(b bVar) {
            this.f51822a = null;
            this.f51822a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            try {
                this.f51823b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.f51823b.postNetData();
                if (!this.f51823b.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(postNetData);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a.this.f51819b = a.this.j(optString);
                    if (a.this.f51819b == null || a.this.f51819b.size() <= 0) {
                        return null;
                    }
                    HashMap hashMap = new HashMap();
                    int i = 0;
                    for (int i2 = 0; i2 < a.this.f51819b.size(); i2++) {
                        String str = (String) a.this.f51819b.get(i2);
                        f fVar = new f();
                        fVar.a(str);
                        if (fVar.d()) {
                            hashMap.put(str, Integer.valueOf(fVar.b()));
                        }
                    }
                    if (hashMap.size() > 0) {
                        a.this.f51819b = new ArrayList();
                        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                        Collections.sort(arrayList, new C1116a(this));
                        StringBuilder sb = new StringBuilder(50);
                        for (Map.Entry entry : arrayList) {
                            a.this.f51819b.add(entry.getKey());
                            if (i != 0) {
                                sb.append(",");
                            }
                            i++;
                            sb.append((String) entry.getKey());
                        }
                        optString = sb.toString();
                    }
                    d.b.h0.r.d0.b.j().w("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                    d.b.h0.r.d0.b.j().x("KeyOfSharedPrefIpList", optString);
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
            a.this.f51820c = null;
            b bVar = this.f51822a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f51823b != null) {
                this.f51823b.cancelNetConnect();
                this.f51823b = null;
            }
            a.this.f51820c = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r2) {
            a.this.f51820c = null;
            b bVar = this.f51822a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.f51820c = null;
            b bVar = this.f51822a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static a f51825a = new a();
    }

    public static a f() {
        return d.f51825a;
    }

    public int e() {
        return d.b.h0.r.d0.b.j().k("KeyOfSharedPrefImCount", 0);
    }

    public List<String> g() {
        if (this.f51819b == null) {
            if (System.currentTimeMillis() - d.b.h0.r.d0.b.j().l("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                d.b.h0.r.d0.b.j().x("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.f51819b = j(d.b.h0.r.d0.b.j().p("KeyOfSharedPrefIpList", null));
        }
        return this.f51819b;
    }

    public String h() {
        int e2 = e();
        if (e2 >= 10) {
            d.b.h0.r.d0.b.j().v("KeyOfSharedPrefImCount", 0);
            d.b.h0.r.d0.b.j().x("KeyOfSharedPrefValidIp", "");
            this.f51818a = null;
            return null;
        }
        if (this.f51818a == null) {
            this.f51818a = d.b.h0.r.d0.b.j().p("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.f51818a)) {
            d.b.h0.r.d0.b.j().v("KeyOfSharedPrefImCount", e2 + 1);
        } else {
            this.f51818a = null;
        }
        return this.f51818a;
    }

    public boolean i() {
        return this.f51821d;
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
        this.f51821d = false;
    }

    public void l(String str) {
        if (TiebaIMConfig.defaultUrl.equals(str)) {
            return;
        }
        this.f51818a = str;
        d.b.h0.r.d0.b.j().x("KeyOfSharedPrefValidIp", str);
    }

    public void m(b bVar) {
        if (this.f51820c == null) {
            this.f51821d = true;
            c cVar = new c(bVar);
            this.f51820c = cVar;
            cVar.setSelfExecute(true);
            this.f51820c.execute(new Object[0]);
        }
    }

    public a() {
        this.f51818a = null;
        this.f51819b = null;
        this.f51820c = null;
        this.f51821d = false;
        this.f51821d = false;
        this.f51819b = null;
    }
}
