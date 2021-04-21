package d.b.i0.s.j;

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
    public String f52154a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f52155b;

    /* renamed from: c  reason: collision with root package name */
    public c f52156c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52157d;

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public b f52158a;

        /* renamed from: b  reason: collision with root package name */
        public volatile NetWork f52159b = null;

        /* renamed from: d.b.i0.s.j.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1138a implements Comparator<Map.Entry<String, Integer>> {
            public C1138a(c cVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                return (int) (d.b.c.e.m.b.d(String.valueOf(entry.getValue()), 0) - d.b.c.e.m.b.d(String.valueOf(entry2.getValue()), 0));
            }
        }

        public c(b bVar) {
            this.f52158a = null;
            this.f52158a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            try {
                this.f52159b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                String postNetData = this.f52159b.postNetData();
                if (!this.f52159b.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(postNetData);
                if (jSONObject.optInt("error_code") == 0) {
                    String optString = jSONObject.optString("urls");
                    a.this.f52155b = a.this.j(optString);
                    if (a.this.f52155b == null || a.this.f52155b.size() <= 0) {
                        return null;
                    }
                    HashMap hashMap = new HashMap();
                    int i = 0;
                    for (int i2 = 0; i2 < a.this.f52155b.size(); i2++) {
                        String str = (String) a.this.f52155b.get(i2);
                        f fVar = new f();
                        fVar.a(str);
                        if (fVar.d()) {
                            hashMap.put(str, Integer.valueOf(fVar.b()));
                        }
                    }
                    if (hashMap.size() > 0) {
                        a.this.f52155b = new ArrayList();
                        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                        Collections.sort(arrayList, new C1138a(this));
                        StringBuilder sb = new StringBuilder(50);
                        for (Map.Entry entry : arrayList) {
                            a.this.f52155b.add(entry.getKey());
                            if (i != 0) {
                                sb.append(",");
                            }
                            i++;
                            sb.append((String) entry.getKey());
                        }
                        optString = sb.toString();
                    }
                    d.b.i0.r.d0.b.j().w("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                    d.b.i0.r.d0.b.j().x("KeyOfSharedPrefIpList", optString);
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
            a.this.f52156c = null;
            b bVar = this.f52158a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f52159b != null) {
                this.f52159b.cancelNetConnect();
                this.f52159b = null;
            }
            a.this.f52156c = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r2) {
            a.this.f52156c = null;
            b bVar = this.f52158a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            a.this.f52156c = null;
            b bVar = this.f52158a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static a f52161a = new a();
    }

    public static a f() {
        return d.f52161a;
    }

    public int e() {
        return d.b.i0.r.d0.b.j().k("KeyOfSharedPrefImCount", 0);
    }

    public List<String> g() {
        if (this.f52155b == null) {
            if (System.currentTimeMillis() - d.b.i0.r.d0.b.j().l("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                d.b.i0.r.d0.b.j().x("KeyOfSharedPrefIpList", "");
                return null;
            }
            this.f52155b = j(d.b.i0.r.d0.b.j().p("KeyOfSharedPrefIpList", null));
        }
        return this.f52155b;
    }

    public String h() {
        int e2 = e();
        if (e2 >= 10) {
            d.b.i0.r.d0.b.j().v("KeyOfSharedPrefImCount", 0);
            d.b.i0.r.d0.b.j().x("KeyOfSharedPrefValidIp", "");
            this.f52154a = null;
            return null;
        }
        if (this.f52154a == null) {
            this.f52154a = d.b.i0.r.d0.b.j().p("KeyOfSharedPrefValidIp", null);
        }
        if (!k.isEmpty(this.f52154a)) {
            d.b.i0.r.d0.b.j().v("KeyOfSharedPrefImCount", e2 + 1);
        } else {
            this.f52154a = null;
        }
        return this.f52154a;
    }

    public boolean i() {
        return this.f52157d;
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
        this.f52157d = false;
    }

    public void l(String str) {
        if (TiebaIMConfig.defaultUrl.equals(str)) {
            return;
        }
        this.f52154a = str;
        d.b.i0.r.d0.b.j().x("KeyOfSharedPrefValidIp", str);
    }

    public void m(b bVar) {
        if (this.f52156c == null) {
            this.f52157d = true;
            c cVar = new c(bVar);
            this.f52156c = cVar;
            cVar.setSelfExecute(true);
            this.f52156c.execute(new Object[0]);
        }
    }

    public a() {
        this.f52154a = null;
        this.f52155b = null;
        this.f52156c = null;
        this.f52157d = false;
        this.f52157d = false;
        this.f52155b = null;
    }
}
