package d.a.o0.x1.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.e.d.l;
import d.a.o0.x1.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f67110g;

    /* renamed from: a  reason: collision with root package name */
    public b f67104a = null;

    /* renamed from: b  reason: collision with root package name */
    public c f67105b = null;

    /* renamed from: c  reason: collision with root package name */
    public C1800a f67106c = null;

    /* renamed from: e  reason: collision with root package name */
    public int f67108e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f67109f = 0;

    /* renamed from: h  reason: collision with root package name */
    public d f67111h = null;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MarkData> f67107d = new ArrayList<>();

    /* renamed from: d.a.o0.x1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1800a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f67112a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f67113b;

        /* renamed from: c  reason: collision with root package name */
        public String f67114c;

        /* renamed from: d  reason: collision with root package name */
        public int f67115d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.o0.x1.g.c f67116e;

        public C1800a(String str, int i2, String str2) {
            this.f67113b = null;
            this.f67114c = null;
            this.f67115d = 0;
            this.f67116e = null;
            this.f67113b = str;
            this.f67115d = i2;
            this.f67114c = str2;
            this.f67116e = new d.a.o0.x1.g.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.f67112a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.f67112a.addPostData("tid", this.f67113b);
            this.f67112a.addPostData("fid", this.f67114c);
            this.f67116e.c(this.f67112a.postNetData());
            if (this.f67112a.getNetContext().getResponse().isRequestSuccess() && this.f67116e.a() == 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f67112a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f67106c = null;
            d dVar = a.this.f67111h;
            if (dVar != null) {
                dVar.a(2, Boolean.FALSE, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.f67106c = null;
            if (bool.booleanValue()) {
                if (this.f67115d < a.this.f67107d.size()) {
                    a.this.f67107d.remove(this.f67115d);
                    a.i(a.this);
                }
            } else if (this.f67112a.getNetContext().getResponse().isRequestSuccess()) {
                str = this.f67116e.b();
            } else {
                str = this.f67112a.getErrorString();
            }
            d dVar = a.this.f67111h;
            if (dVar != null) {
                dVar.a(2, bool, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {

        /* renamed from: c  reason: collision with root package name */
        public int f67120c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.o0.x1.g.c f67121d;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f67118a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f67119b = null;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f67122e = Boolean.FALSE;

        public b(int i2) {
            this.f67120c = 0;
            this.f67121d = null;
            this.f67120c = i2;
            this.f67121d = new d.a.o0.x1.g.c();
        }

        public final void b(String str) {
            l<String> g2;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || (g2 = d.a.n0.r.r.a.f().g("tb.my_bookmarks")) == null) {
                return;
            }
            g2.e(currentAccount, str, 604800000L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Boolean... boolArr) {
            this.f67122e = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.f67122e.booleanValue() && booleanValue) {
                l<String> g2 = d.a.n0.r.r.a.f().g("tb.my_bookmarks");
                if (g2 != null) {
                    publishProgress(g2.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.f67107d == null) {
                    a.this.f67107d = new ArrayList();
                } else {
                    a.this.f67107d.clear();
                }
                a.this.f67108e = 0;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.f67118a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.f67110g) {
                this.f67118a.addPostData("offset", String.valueOf(0));
            } else {
                this.f67118a.addPostData("offset", String.valueOf(this.f67120c));
            }
            this.f67118a.addPostData("rn", String.valueOf(20));
            String postNetData = this.f67118a.postNetData();
            this.f67119b = postNetData;
            this.f67121d.c(postNetData);
            if (this.f67118a.getNetContext().getResponse().isRequestSuccess()) {
                aVar.u(this.f67119b);
                if (this.f67120c == 0) {
                    if (a.this.f67107d == null) {
                        a.this.f67107d = new ArrayList();
                    } else {
                        a.this.f67107d.clear();
                    }
                    a.this.f67108e = 0;
                    if (this.f67122e.booleanValue()) {
                        b(this.f67119b);
                    }
                }
            }
            return aVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f67118a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f67104a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            d.a.o0.x1.g.c cVar = this.f67121d;
            if (cVar != null) {
                d.a.n0.r.z.a.a("collection", 0L, 0, "collection_thread_list_result", cVar.a(), this.f67121d.b(), new Object[0]);
            }
            a.this.f67108e = aVar.m();
            ArrayList<MarkData> n = aVar.n();
            if (this.f67122e.booleanValue()) {
                if (n != null && n.size() != 0) {
                    a.this.B(n);
                }
            } else {
                a.this.k(n);
            }
            Iterator<MarkData> it = n.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i2++;
                    a.this.C(i2);
                }
            }
            if (a.this.f67111h != null) {
                if (this.f67118a.getNetContext().getResponse().isRequestSuccess()) {
                    a.this.f67111h.a(0, this.f67121d.a() != 0 ? this.f67121d.b() : null, Boolean.FALSE);
                } else {
                    a.this.f67111h.a(3, this.f67118a.getErrorString());
                }
            }
            a.this.f67110g = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate((Object[]) strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.t(str);
                if (this.f67122e.booleanValue()) {
                    a.this.B(arrayList);
                } else {
                    a.this.k(arrayList);
                }
            } else {
                a.this.B(arrayList);
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            a.this.f67111h.a(0, null, Boolean.TRUE);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<a, Integer, Boolean> {
    }

    public a() {
        this.f67110g = false;
        this.f67110g = true;
    }

    public static /* synthetic */ int i(a aVar) {
        int i2 = aVar.f67109f;
        aVar.f67109f = i2 - 1;
        return i2;
    }

    public void A(d dVar) {
        this.f67111h = dVar;
    }

    public void B(ArrayList<MarkData> arrayList) {
        this.f67107d = arrayList;
    }

    public void C(int i2) {
        this.f67109f = i2;
    }

    public boolean D(int i2) {
        C1800a c1800a = this.f67106c;
        if (c1800a != null) {
            c1800a.cancel();
        }
        if (i2 >= this.f67107d.size() || this.f67107d.get(i2) == null || this.f67107d.get(i2).getId() == null) {
            return false;
        }
        C1800a c1800a2 = new C1800a(this.f67107d.get(i2).getId(), i2, this.f67107d.get(i2).getForumId());
        this.f67106c = c1800a2;
        c1800a2.setPriority(2);
        this.f67106c.execute(new Boolean[0]);
        return true;
    }

    public String E(int i2, int i3) {
        ArrayList<MarkData> arrayList = this.f67107d;
        if (arrayList == null) {
            return null;
        }
        if (i2 >= arrayList.size()) {
            i3 -= (i2 - this.f67107d.size()) - 1;
            i2 = this.f67107d.size() - 1;
        }
        JSONArray jSONArray = new JSONArray();
        int i4 = 0;
        for (int i5 = i2; i5 >= 0 && i5 > i2 - i3; i5--) {
            try {
                JSONObject json = this.f67107d.get(i5).toJson();
                if (json != null && i4 >= 0) {
                    int i6 = i4 + 1;
                    jSONArray.put(i4, json);
                    i4 = i6;
                }
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                jSONArray = null;
            }
        }
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }

    public void j(MarkData markData) {
        this.f67107d.add(markData);
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2 = this.f67107d;
        if (arrayList2 == null || arrayList == null) {
            return;
        }
        arrayList2.addAll(arrayList);
        y();
    }

    public final void l(String str, int i2) {
        ArrayList<MarkData> arrayList = this.f67107d;
        if (arrayList == null || ListUtils.getCount(arrayList) <= 0) {
            return;
        }
        Iterator<MarkData> it = this.f67107d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            if (next != null && next.getId().equals(str)) {
                next.setReplyNum(i2);
            }
        }
    }

    public int m() {
        ArrayList<MarkData> arrayList = this.f67107d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<MarkData> n() {
        return this.f67107d;
    }

    public int o() {
        return this.f67109f;
    }

    public int p() {
        return this.f67108e;
    }

    public int q() {
        ArrayList<MarkData> arrayList = this.f67107d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean r() {
        return this.f67108e > 0;
    }

    public void s() {
        b bVar = this.f67104a;
        if (bVar != null) {
            bVar.cancel();
        }
        c cVar = this.f67105b;
        if (cVar != null) {
            cVar.cancel();
        }
        C1800a c1800a = this.f67106c;
        if (c1800a != null) {
            c1800a.cancel();
        }
    }

    public final ArrayList<MarkData> t(String str) {
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i2));
                    arrayList.add(markData);
                }
                return arrayList;
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
            return null;
        }
    }

    public void u(String str) {
        try {
            v(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void v(JSONObject jSONObject) {
        try {
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i2));
                    this.f67107d.add(markData);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void w(Boolean bool) {
        x(bool, true);
    }

    public void x(Boolean bool, boolean z) {
        b bVar = this.f67104a;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(q());
        this.f67104a = bVar2;
        bVar2.setPriority(3);
        this.f67104a.execute(bool, Boolean.valueOf(z));
    }

    public final void y() {
        if (this.f67107d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.f67107d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            String id = next.getId();
            int replyNum = next.getReplyNum();
            if (!hashSet.add(id)) {
                l(id, replyNum);
                it.remove();
            }
        }
    }

    public void z() {
        this.f67109f = 0;
        this.f67108e = 0;
        this.f67110g = true;
    }
}
