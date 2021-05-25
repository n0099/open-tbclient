package d.a.n0.x1.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.e.d.l;
import d.a.n0.x1.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f63270g;

    /* renamed from: a  reason: collision with root package name */
    public b f63264a = null;

    /* renamed from: b  reason: collision with root package name */
    public c f63265b = null;

    /* renamed from: c  reason: collision with root package name */
    public C1739a f63266c = null;

    /* renamed from: e  reason: collision with root package name */
    public int f63268e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f63269f = 0;

    /* renamed from: h  reason: collision with root package name */
    public d f63271h = null;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MarkData> f63267d = new ArrayList<>();

    /* renamed from: d.a.n0.x1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1739a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f63272a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f63273b;

        /* renamed from: c  reason: collision with root package name */
        public String f63274c;

        /* renamed from: d  reason: collision with root package name */
        public int f63275d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.n0.x1.g.c f63276e;

        public C1739a(String str, int i2, String str2) {
            this.f63273b = null;
            this.f63274c = null;
            this.f63275d = 0;
            this.f63276e = null;
            this.f63273b = str;
            this.f63275d = i2;
            this.f63274c = str2;
            this.f63276e = new d.a.n0.x1.g.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.f63272a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.f63272a.addPostData("tid", this.f63273b);
            this.f63272a.addPostData("fid", this.f63274c);
            this.f63276e.c(this.f63272a.postNetData());
            if (this.f63272a.getNetContext().getResponse().isRequestSuccess() && this.f63276e.a() == 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f63272a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f63266c = null;
            d dVar = a.this.f63271h;
            if (dVar != null) {
                dVar.a(2, Boolean.FALSE, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.f63266c = null;
            if (bool.booleanValue()) {
                if (this.f63275d < a.this.f63267d.size()) {
                    a.this.f63267d.remove(this.f63275d);
                    a.i(a.this);
                }
            } else if (this.f63272a.getNetContext().getResponse().isRequestSuccess()) {
                str = this.f63276e.b();
            } else {
                str = this.f63272a.getErrorString();
            }
            d dVar = a.this.f63271h;
            if (dVar != null) {
                dVar.a(2, bool, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {

        /* renamed from: c  reason: collision with root package name */
        public int f63280c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.n0.x1.g.c f63281d;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f63278a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f63279b = null;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f63282e = Boolean.FALSE;

        public b(int i2) {
            this.f63280c = 0;
            this.f63281d = null;
            this.f63280c = i2;
            this.f63281d = new d.a.n0.x1.g.c();
        }

        public final void b(String str) {
            l<String> g2;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || (g2 = d.a.m0.r.r.a.f().g("tb.my_bookmarks")) == null) {
                return;
            }
            g2.e(currentAccount, str, 604800000L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Boolean... boolArr) {
            this.f63282e = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.f63282e.booleanValue() && booleanValue) {
                l<String> g2 = d.a.m0.r.r.a.f().g("tb.my_bookmarks");
                if (g2 != null) {
                    publishProgress(g2.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.f63267d == null) {
                    a.this.f63267d = new ArrayList();
                } else {
                    a.this.f63267d.clear();
                }
                a.this.f63268e = 0;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.f63278a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.f63270g) {
                this.f63278a.addPostData("offset", String.valueOf(0));
            } else {
                this.f63278a.addPostData("offset", String.valueOf(this.f63280c));
            }
            this.f63278a.addPostData("rn", String.valueOf(20));
            String postNetData = this.f63278a.postNetData();
            this.f63279b = postNetData;
            this.f63281d.c(postNetData);
            if (this.f63278a.getNetContext().getResponse().isRequestSuccess()) {
                aVar.u(this.f63279b);
                if (this.f63280c == 0) {
                    if (a.this.f63267d == null) {
                        a.this.f63267d = new ArrayList();
                    } else {
                        a.this.f63267d.clear();
                    }
                    a.this.f63268e = 0;
                    if (this.f63282e.booleanValue()) {
                        b(this.f63279b);
                    }
                }
            }
            return aVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f63278a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f63264a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            d.a.n0.x1.g.c cVar = this.f63281d;
            if (cVar != null) {
                d.a.m0.r.z.a.a("collection", 0L, 0, "collection_thread_list_result", cVar.a(), this.f63281d.b(), new Object[0]);
            }
            a.this.f63268e = aVar.m();
            ArrayList<MarkData> n = aVar.n();
            if (this.f63282e.booleanValue()) {
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
            if (a.this.f63271h != null) {
                if (this.f63278a.getNetContext().getResponse().isRequestSuccess()) {
                    a.this.f63271h.a(0, this.f63281d.a() != 0 ? this.f63281d.b() : null, Boolean.FALSE);
                } else {
                    a.this.f63271h.a(3, this.f63278a.getErrorString());
                }
            }
            a.this.f63270g = false;
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
                if (this.f63282e.booleanValue()) {
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
            a.this.f63271h.a(0, null, Boolean.TRUE);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<a, Integer, Boolean> {
    }

    public a() {
        this.f63270g = false;
        this.f63270g = true;
    }

    public static /* synthetic */ int i(a aVar) {
        int i2 = aVar.f63269f;
        aVar.f63269f = i2 - 1;
        return i2;
    }

    public void A(d dVar) {
        this.f63271h = dVar;
    }

    public void B(ArrayList<MarkData> arrayList) {
        this.f63267d = arrayList;
    }

    public void C(int i2) {
        this.f63269f = i2;
    }

    public boolean D(int i2) {
        C1739a c1739a = this.f63266c;
        if (c1739a != null) {
            c1739a.cancel();
        }
        if (i2 >= this.f63267d.size() || this.f63267d.get(i2) == null || this.f63267d.get(i2).getId() == null) {
            return false;
        }
        C1739a c1739a2 = new C1739a(this.f63267d.get(i2).getId(), i2, this.f63267d.get(i2).getForumId());
        this.f63266c = c1739a2;
        c1739a2.setPriority(2);
        this.f63266c.execute(new Boolean[0]);
        return true;
    }

    public String E(int i2, int i3) {
        ArrayList<MarkData> arrayList = this.f63267d;
        if (arrayList == null) {
            return null;
        }
        if (i2 >= arrayList.size()) {
            i3 -= (i2 - this.f63267d.size()) - 1;
            i2 = this.f63267d.size() - 1;
        }
        JSONArray jSONArray = new JSONArray();
        int i4 = 0;
        for (int i5 = i2; i5 >= 0 && i5 > i2 - i3; i5--) {
            try {
                JSONObject json = this.f63267d.get(i5).toJson();
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
        this.f63267d.add(markData);
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2 = this.f63267d;
        if (arrayList2 == null || arrayList == null) {
            return;
        }
        arrayList2.addAll(arrayList);
        y();
    }

    public final void l(String str, int i2) {
        ArrayList<MarkData> arrayList = this.f63267d;
        if (arrayList == null || ListUtils.getCount(arrayList) <= 0) {
            return;
        }
        Iterator<MarkData> it = this.f63267d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            if (next != null && next.getId().equals(str)) {
                next.setReplyNum(i2);
            }
        }
    }

    public int m() {
        ArrayList<MarkData> arrayList = this.f63267d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<MarkData> n() {
        return this.f63267d;
    }

    public int o() {
        return this.f63269f;
    }

    public int p() {
        return this.f63268e;
    }

    public int q() {
        ArrayList<MarkData> arrayList = this.f63267d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean r() {
        return this.f63268e > 0;
    }

    public void s() {
        b bVar = this.f63264a;
        if (bVar != null) {
            bVar.cancel();
        }
        c cVar = this.f63265b;
        if (cVar != null) {
            cVar.cancel();
        }
        C1739a c1739a = this.f63266c;
        if (c1739a != null) {
            c1739a.cancel();
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
                    this.f63267d.add(markData);
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
        b bVar = this.f63264a;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(q());
        this.f63264a = bVar2;
        bVar2.setPriority(3);
        this.f63264a.execute(bool, Boolean.valueOf(z));
    }

    public final void y() {
        if (this.f63267d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.f63267d.iterator();
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
        this.f63269f = 0;
        this.f63268e = 0;
        this.f63270g = true;
    }
}
