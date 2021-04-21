package d.b.j0.w1.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import d.b.c.e.d.l;
import d.b.j0.w1.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f64107g;

    /* renamed from: a  reason: collision with root package name */
    public b f64101a = null;

    /* renamed from: b  reason: collision with root package name */
    public c f64102b = null;

    /* renamed from: c  reason: collision with root package name */
    public C1720a f64103c = null;

    /* renamed from: e  reason: collision with root package name */
    public int f64105e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f64106f = 0;

    /* renamed from: h  reason: collision with root package name */
    public d f64108h = null;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MarkData> f64104d = new ArrayList<>();

    /* renamed from: d.b.j0.w1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1720a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f64109a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f64110b;

        /* renamed from: c  reason: collision with root package name */
        public String f64111c;

        /* renamed from: d  reason: collision with root package name */
        public int f64112d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.j0.w1.g.c f64113e;

        public C1720a(String str, int i, String str2) {
            this.f64110b = null;
            this.f64111c = null;
            this.f64112d = 0;
            this.f64113e = null;
            this.f64110b = str;
            this.f64112d = i;
            this.f64111c = str2;
            this.f64113e = new d.b.j0.w1.g.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.f64109a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.f64109a.addPostData("tid", this.f64110b);
            this.f64109a.addPostData("fid", this.f64111c);
            this.f64113e.c(this.f64109a.postNetData());
            if (this.f64109a.getNetContext().getResponse().isRequestSuccess() && this.f64113e.a() == 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f64109a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f64103c = null;
            d dVar = a.this.f64108h;
            if (dVar != null) {
                dVar.a(2, Boolean.FALSE, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.f64103c = null;
            if (bool.booleanValue()) {
                if (this.f64112d < a.this.f64104d.size()) {
                    a.this.f64104d.remove(this.f64112d);
                    a.i(a.this);
                }
            } else if (this.f64109a.getNetContext().getResponse().isRequestSuccess()) {
                str = this.f64113e.b();
            } else {
                str = this.f64109a.getErrorString();
            }
            d dVar = a.this.f64108h;
            if (dVar != null) {
                dVar.a(2, bool, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {

        /* renamed from: c  reason: collision with root package name */
        public int f64117c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.j0.w1.g.c f64118d;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f64115a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f64116b = null;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f64119e = Boolean.FALSE;

        public b(int i) {
            this.f64117c = 0;
            this.f64118d = null;
            this.f64117c = i;
            this.f64118d = new d.b.j0.w1.g.c();
        }

        public final void b(String str) {
            l<String> g2;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || (g2 = d.b.i0.r.r.a.f().g("tb.my_bookmarks")) == null) {
                return;
            }
            g2.e(currentAccount, str, 604800000L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Boolean... boolArr) {
            this.f64119e = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.f64119e.booleanValue() && booleanValue) {
                l<String> g2 = d.b.i0.r.r.a.f().g("tb.my_bookmarks");
                if (g2 != null) {
                    publishProgress(g2.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.f64104d == null) {
                    a.this.f64104d = new ArrayList();
                } else {
                    a.this.f64104d.clear();
                }
                a.this.f64105e = 0;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.f64115a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.f64107g) {
                this.f64115a.addPostData("offset", String.valueOf(0));
            } else {
                this.f64115a.addPostData("offset", String.valueOf(this.f64117c));
            }
            this.f64115a.addPostData("rn", String.valueOf(20));
            String postNetData = this.f64115a.postNetData();
            this.f64116b = postNetData;
            this.f64118d.c(postNetData);
            if (this.f64115a.getNetContext().getResponse().isRequestSuccess()) {
                aVar.u(this.f64116b);
                if (this.f64117c == 0) {
                    if (a.this.f64104d == null) {
                        a.this.f64104d = new ArrayList();
                    } else {
                        a.this.f64104d.clear();
                    }
                    a.this.f64105e = 0;
                    if (this.f64119e.booleanValue()) {
                        b(this.f64116b);
                    }
                }
            }
            return aVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f64115a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f64101a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            d.b.j0.w1.g.c cVar = this.f64118d;
            if (cVar != null) {
                d.b.i0.r.z.a.a("collection", 0L, 0, "collection_thread_list_result", cVar.a(), this.f64118d.b(), new Object[0]);
            }
            a.this.f64105e = aVar.m();
            ArrayList<MarkData> n = aVar.n();
            if (this.f64119e.booleanValue()) {
                if (n != null && n.size() != 0) {
                    a.this.B(n);
                }
            } else {
                a.this.k(n);
            }
            Iterator<MarkData> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getNewCounts() > 0) {
                    i++;
                    a.this.C(i);
                }
            }
            if (a.this.f64108h != null) {
                if (this.f64115a.getNetContext().getResponse().isRequestSuccess()) {
                    a.this.f64108h.a(0, this.f64118d.a() != 0 ? this.f64118d.b() : null, Boolean.FALSE);
                } else {
                    a.this.f64108h.a(3, this.f64115a.getErrorString());
                }
            }
            a.this.f64107g = false;
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
                if (this.f64119e.booleanValue()) {
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
            a.this.f64108h.a(0, null, Boolean.TRUE);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<a, Integer, Boolean> {
    }

    public a() {
        this.f64107g = false;
        this.f64107g = true;
    }

    public static /* synthetic */ int i(a aVar) {
        int i = aVar.f64106f;
        aVar.f64106f = i - 1;
        return i;
    }

    public void A(d dVar) {
        this.f64108h = dVar;
    }

    public void B(ArrayList<MarkData> arrayList) {
        this.f64104d = arrayList;
    }

    public void C(int i) {
        this.f64106f = i;
    }

    public boolean D(int i) {
        C1720a c1720a = this.f64103c;
        if (c1720a != null) {
            c1720a.cancel();
        }
        if (i >= this.f64104d.size() || this.f64104d.get(i) == null || this.f64104d.get(i).getId() == null) {
            return false;
        }
        C1720a c1720a2 = new C1720a(this.f64104d.get(i).getId(), i, this.f64104d.get(i).getForumId());
        this.f64103c = c1720a2;
        c1720a2.setPriority(2);
        this.f64103c.execute(new Boolean[0]);
        return true;
    }

    public String E(int i, int i2) {
        ArrayList<MarkData> arrayList = this.f64104d;
        if (arrayList == null) {
            return null;
        }
        if (i >= arrayList.size()) {
            i2 -= (i - this.f64104d.size()) - 1;
            i = this.f64104d.size() - 1;
        }
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        for (int i4 = i; i4 >= 0 && i4 > i - i2; i4--) {
            try {
                JSONObject json = this.f64104d.get(i4).toJson();
                if (json != null && i3 >= 0) {
                    int i5 = i3 + 1;
                    jSONArray.put(i3, json);
                    i3 = i5;
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
        this.f64104d.add(markData);
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2 = this.f64104d;
        if (arrayList2 == null || arrayList == null) {
            return;
        }
        arrayList2.addAll(arrayList);
        y();
    }

    public final void l(String str, int i) {
        ArrayList<MarkData> arrayList = this.f64104d;
        if (arrayList == null || ListUtils.getCount(arrayList) <= 0) {
            return;
        }
        Iterator<MarkData> it = this.f64104d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            if (next != null && next.getId().equals(str)) {
                next.setReplyNum(i);
            }
        }
    }

    public int m() {
        ArrayList<MarkData> arrayList = this.f64104d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<MarkData> n() {
        return this.f64104d;
    }

    public int o() {
        return this.f64106f;
    }

    public int p() {
        return this.f64105e;
    }

    public int q() {
        ArrayList<MarkData> arrayList = this.f64104d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean r() {
        return this.f64105e > 0;
    }

    public void s() {
        b bVar = this.f64101a;
        if (bVar != null) {
            bVar.cancel();
        }
        c cVar = this.f64102b;
        if (cVar != null) {
            cVar.cancel();
        }
        C1720a c1720a = this.f64103c;
        if (c1720a != null) {
            c1720a.cancel();
        }
    }

    public final ArrayList<MarkData> t(String str) {
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
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
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.f64104d.add(markData);
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
        b bVar = this.f64101a;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(q());
        this.f64101a = bVar2;
        bVar2.setPriority(3);
        this.f64101a.execute(bool, Boolean.valueOf(z));
    }

    public final void y() {
        if (this.f64104d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.f64104d.iterator();
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
        this.f64106f = 0;
        this.f64105e = 0;
        this.f64107g = true;
    }
}
