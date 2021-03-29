package d.b.i0.v1.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import d.b.b.e.d.l;
import d.b.i0.v1.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f62020g;

    /* renamed from: a  reason: collision with root package name */
    public b f62014a = null;

    /* renamed from: b  reason: collision with root package name */
    public c f62015b = null;

    /* renamed from: c  reason: collision with root package name */
    public C1640a f62016c = null;

    /* renamed from: e  reason: collision with root package name */
    public int f62018e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f62019f = 0;

    /* renamed from: h  reason: collision with root package name */
    public d f62021h = null;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MarkData> f62017d = new ArrayList<>();

    /* renamed from: d.b.i0.v1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1640a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f62022a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f62023b;

        /* renamed from: c  reason: collision with root package name */
        public String f62024c;

        /* renamed from: d  reason: collision with root package name */
        public int f62025d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.i0.v1.g.c f62026e;

        public C1640a(String str, int i, String str2) {
            this.f62023b = null;
            this.f62024c = null;
            this.f62025d = 0;
            this.f62026e = null;
            this.f62023b = str;
            this.f62025d = i;
            this.f62024c = str2;
            this.f62026e = new d.b.i0.v1.g.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.f62022a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.f62022a.addPostData("tid", this.f62023b);
            this.f62022a.addPostData("fid", this.f62024c);
            this.f62026e.c(this.f62022a.postNetData());
            if (this.f62022a.getNetContext().getResponse().isRequestSuccess() && this.f62026e.a() == 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f62022a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f62016c = null;
            d dVar = a.this.f62021h;
            if (dVar != null) {
                dVar.a(2, Boolean.FALSE, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.f62016c = null;
            if (bool.booleanValue()) {
                if (this.f62025d < a.this.f62017d.size()) {
                    a.this.f62017d.remove(this.f62025d);
                    a.i(a.this);
                }
            } else if (this.f62022a.getNetContext().getResponse().isRequestSuccess()) {
                str = this.f62026e.b();
            } else {
                str = this.f62022a.getErrorString();
            }
            d dVar = a.this.f62021h;
            if (dVar != null) {
                dVar.a(2, bool, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {

        /* renamed from: c  reason: collision with root package name */
        public int f62030c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.i0.v1.g.c f62031d;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f62028a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f62029b = null;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f62032e = Boolean.FALSE;

        public b(int i) {
            this.f62030c = 0;
            this.f62031d = null;
            this.f62030c = i;
            this.f62031d = new d.b.i0.v1.g.c();
        }

        public final void b(String str) {
            l<String> g2;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || (g2 = d.b.h0.r.r.a.f().g("tb.my_bookmarks")) == null) {
                return;
            }
            g2.e(currentAccount, str, 604800000L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Boolean... boolArr) {
            this.f62032e = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.f62032e.booleanValue() && booleanValue) {
                l<String> g2 = d.b.h0.r.r.a.f().g("tb.my_bookmarks");
                if (g2 != null) {
                    publishProgress(g2.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.f62017d == null) {
                    a.this.f62017d = new ArrayList();
                } else {
                    a.this.f62017d.clear();
                }
                a.this.f62018e = 0;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.f62028a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.f62020g) {
                this.f62028a.addPostData("offset", String.valueOf(0));
            } else {
                this.f62028a.addPostData("offset", String.valueOf(this.f62030c));
            }
            this.f62028a.addPostData("rn", String.valueOf(20));
            String postNetData = this.f62028a.postNetData();
            this.f62029b = postNetData;
            this.f62031d.c(postNetData);
            if (this.f62028a.getNetContext().getResponse().isRequestSuccess()) {
                aVar.u(this.f62029b);
                if (this.f62030c == 0) {
                    if (a.this.f62017d == null) {
                        a.this.f62017d = new ArrayList();
                    } else {
                        a.this.f62017d.clear();
                    }
                    a.this.f62018e = 0;
                    if (this.f62032e.booleanValue()) {
                        b(this.f62029b);
                    }
                }
            }
            return aVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f62028a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f62014a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            d.b.i0.v1.g.c cVar = this.f62031d;
            if (cVar != null) {
                d.b.h0.r.z.a.a("collection", 0L, 0, "collection_thread_list_result", cVar.a(), this.f62031d.b(), new Object[0]);
            }
            a.this.f62018e = aVar.m();
            ArrayList<MarkData> n = aVar.n();
            if (this.f62032e.booleanValue()) {
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
            if (a.this.f62021h != null) {
                if (this.f62028a.getNetContext().getResponse().isRequestSuccess()) {
                    a.this.f62021h.a(0, this.f62031d.a() != 0 ? this.f62031d.b() : null, Boolean.FALSE);
                } else {
                    a.this.f62021h.a(3, this.f62028a.getErrorString());
                }
            }
            a.this.f62020g = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            String str = strArr[0];
            ArrayList<MarkData> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList = a.this.t(str);
                if (this.f62032e.booleanValue()) {
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
            a.this.f62021h.a(0, null, Boolean.TRUE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<a, Integer, Boolean> {
    }

    public a() {
        this.f62020g = false;
        this.f62020g = true;
    }

    public static /* synthetic */ int i(a aVar) {
        int i = aVar.f62019f;
        aVar.f62019f = i - 1;
        return i;
    }

    public void A(d dVar) {
        this.f62021h = dVar;
    }

    public void B(ArrayList<MarkData> arrayList) {
        this.f62017d = arrayList;
    }

    public void C(int i) {
        this.f62019f = i;
    }

    public boolean D(int i) {
        C1640a c1640a = this.f62016c;
        if (c1640a != null) {
            c1640a.cancel();
        }
        if (i >= this.f62017d.size() || this.f62017d.get(i) == null || this.f62017d.get(i).getId() == null) {
            return false;
        }
        C1640a c1640a2 = new C1640a(this.f62017d.get(i).getId(), i, this.f62017d.get(i).getForumId());
        this.f62016c = c1640a2;
        c1640a2.setPriority(2);
        this.f62016c.execute(new Boolean[0]);
        return true;
    }

    public String E(int i, int i2) {
        ArrayList<MarkData> arrayList = this.f62017d;
        if (arrayList == null) {
            return null;
        }
        if (i >= arrayList.size()) {
            i2 -= (i - this.f62017d.size()) - 1;
            i = this.f62017d.size() - 1;
        }
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        for (int i4 = i; i4 >= 0 && i4 > i - i2; i4--) {
            try {
                JSONObject json = this.f62017d.get(i4).toJson();
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
        this.f62017d.add(markData);
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2 = this.f62017d;
        if (arrayList2 == null || arrayList == null) {
            return;
        }
        arrayList2.addAll(arrayList);
        y();
    }

    public final void l(String str, int i) {
        ArrayList<MarkData> arrayList = this.f62017d;
        if (arrayList == null || ListUtils.getCount(arrayList) <= 0) {
            return;
        }
        Iterator<MarkData> it = this.f62017d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            if (next != null && next.getId().equals(str)) {
                next.setReplyNum(i);
            }
        }
    }

    public int m() {
        ArrayList<MarkData> arrayList = this.f62017d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<MarkData> n() {
        return this.f62017d;
    }

    public int o() {
        return this.f62019f;
    }

    public int p() {
        return this.f62018e;
    }

    public int q() {
        ArrayList<MarkData> arrayList = this.f62017d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean r() {
        return this.f62018e > 0;
    }

    public void s() {
        b bVar = this.f62014a;
        if (bVar != null) {
            bVar.cancel();
        }
        c cVar = this.f62015b;
        if (cVar != null) {
            cVar.cancel();
        }
        C1640a c1640a = this.f62016c;
        if (c1640a != null) {
            c1640a.cancel();
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
                    this.f62017d.add(markData);
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
        b bVar = this.f62014a;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(q());
        this.f62014a = bVar2;
        bVar2.setPriority(3);
        this.f62014a.execute(bool, Boolean.valueOf(z));
    }

    public final void y() {
        if (this.f62017d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.f62017d.iterator();
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
        this.f62019f = 0;
        this.f62018e = 0;
        this.f62020g = true;
    }
}
