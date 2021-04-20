package d.b.i0.w1.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import d.b.c.e.d.l;
import d.b.i0.w1.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f63686g;

    /* renamed from: a  reason: collision with root package name */
    public b f63680a = null;

    /* renamed from: b  reason: collision with root package name */
    public c f63681b = null;

    /* renamed from: c  reason: collision with root package name */
    public C1697a f63682c = null;

    /* renamed from: e  reason: collision with root package name */
    public int f63684e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f63685f = 0;

    /* renamed from: h  reason: collision with root package name */
    public d f63687h = null;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MarkData> f63683d = new ArrayList<>();

    /* renamed from: d.b.i0.w1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1697a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f63688a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f63689b;

        /* renamed from: c  reason: collision with root package name */
        public String f63690c;

        /* renamed from: d  reason: collision with root package name */
        public int f63691d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.i0.w1.g.c f63692e;

        public C1697a(String str, int i, String str2) {
            this.f63689b = null;
            this.f63690c = null;
            this.f63691d = 0;
            this.f63692e = null;
            this.f63689b = str;
            this.f63691d = i;
            this.f63690c = str2;
            this.f63692e = new d.b.i0.w1.g.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.f63688a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.f63688a.addPostData("tid", this.f63689b);
            this.f63688a.addPostData("fid", this.f63690c);
            this.f63692e.c(this.f63688a.postNetData());
            if (this.f63688a.getNetContext().getResponse().isRequestSuccess() && this.f63692e.a() == 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f63688a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f63682c = null;
            d dVar = a.this.f63687h;
            if (dVar != null) {
                dVar.a(2, Boolean.FALSE, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.f63682c = null;
            if (bool.booleanValue()) {
                if (this.f63691d < a.this.f63683d.size()) {
                    a.this.f63683d.remove(this.f63691d);
                    a.i(a.this);
                }
            } else if (this.f63688a.getNetContext().getResponse().isRequestSuccess()) {
                str = this.f63692e.b();
            } else {
                str = this.f63688a.getErrorString();
            }
            d dVar = a.this.f63687h;
            if (dVar != null) {
                dVar.a(2, bool, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {

        /* renamed from: c  reason: collision with root package name */
        public int f63696c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.i0.w1.g.c f63697d;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f63694a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f63695b = null;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f63698e = Boolean.FALSE;

        public b(int i) {
            this.f63696c = 0;
            this.f63697d = null;
            this.f63696c = i;
            this.f63697d = new d.b.i0.w1.g.c();
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
            this.f63698e = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.f63698e.booleanValue() && booleanValue) {
                l<String> g2 = d.b.h0.r.r.a.f().g("tb.my_bookmarks");
                if (g2 != null) {
                    publishProgress(g2.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.f63683d == null) {
                    a.this.f63683d = new ArrayList();
                } else {
                    a.this.f63683d.clear();
                }
                a.this.f63684e = 0;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.f63694a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.f63686g) {
                this.f63694a.addPostData("offset", String.valueOf(0));
            } else {
                this.f63694a.addPostData("offset", String.valueOf(this.f63696c));
            }
            this.f63694a.addPostData("rn", String.valueOf(20));
            String postNetData = this.f63694a.postNetData();
            this.f63695b = postNetData;
            this.f63697d.c(postNetData);
            if (this.f63694a.getNetContext().getResponse().isRequestSuccess()) {
                aVar.u(this.f63695b);
                if (this.f63696c == 0) {
                    if (a.this.f63683d == null) {
                        a.this.f63683d = new ArrayList();
                    } else {
                        a.this.f63683d.clear();
                    }
                    a.this.f63684e = 0;
                    if (this.f63698e.booleanValue()) {
                        b(this.f63695b);
                    }
                }
            }
            return aVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f63694a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f63680a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            d.b.i0.w1.g.c cVar = this.f63697d;
            if (cVar != null) {
                d.b.h0.r.z.a.a("collection", 0L, 0, "collection_thread_list_result", cVar.a(), this.f63697d.b(), new Object[0]);
            }
            a.this.f63684e = aVar.m();
            ArrayList<MarkData> n = aVar.n();
            if (this.f63698e.booleanValue()) {
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
            if (a.this.f63687h != null) {
                if (this.f63694a.getNetContext().getResponse().isRequestSuccess()) {
                    a.this.f63687h.a(0, this.f63697d.a() != 0 ? this.f63697d.b() : null, Boolean.FALSE);
                } else {
                    a.this.f63687h.a(3, this.f63694a.getErrorString());
                }
            }
            a.this.f63686g = false;
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
                if (this.f63698e.booleanValue()) {
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
            a.this.f63687h.a(0, null, Boolean.TRUE);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<a, Integer, Boolean> {
    }

    public a() {
        this.f63686g = false;
        this.f63686g = true;
    }

    public static /* synthetic */ int i(a aVar) {
        int i = aVar.f63685f;
        aVar.f63685f = i - 1;
        return i;
    }

    public void A(d dVar) {
        this.f63687h = dVar;
    }

    public void B(ArrayList<MarkData> arrayList) {
        this.f63683d = arrayList;
    }

    public void C(int i) {
        this.f63685f = i;
    }

    public boolean D(int i) {
        C1697a c1697a = this.f63682c;
        if (c1697a != null) {
            c1697a.cancel();
        }
        if (i >= this.f63683d.size() || this.f63683d.get(i) == null || this.f63683d.get(i).getId() == null) {
            return false;
        }
        C1697a c1697a2 = new C1697a(this.f63683d.get(i).getId(), i, this.f63683d.get(i).getForumId());
        this.f63682c = c1697a2;
        c1697a2.setPriority(2);
        this.f63682c.execute(new Boolean[0]);
        return true;
    }

    public String E(int i, int i2) {
        ArrayList<MarkData> arrayList = this.f63683d;
        if (arrayList == null) {
            return null;
        }
        if (i >= arrayList.size()) {
            i2 -= (i - this.f63683d.size()) - 1;
            i = this.f63683d.size() - 1;
        }
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        for (int i4 = i; i4 >= 0 && i4 > i - i2; i4--) {
            try {
                JSONObject json = this.f63683d.get(i4).toJson();
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
        this.f63683d.add(markData);
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2 = this.f63683d;
        if (arrayList2 == null || arrayList == null) {
            return;
        }
        arrayList2.addAll(arrayList);
        y();
    }

    public final void l(String str, int i) {
        ArrayList<MarkData> arrayList = this.f63683d;
        if (arrayList == null || ListUtils.getCount(arrayList) <= 0) {
            return;
        }
        Iterator<MarkData> it = this.f63683d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            if (next != null && next.getId().equals(str)) {
                next.setReplyNum(i);
            }
        }
    }

    public int m() {
        ArrayList<MarkData> arrayList = this.f63683d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<MarkData> n() {
        return this.f63683d;
    }

    public int o() {
        return this.f63685f;
    }

    public int p() {
        return this.f63684e;
    }

    public int q() {
        ArrayList<MarkData> arrayList = this.f63683d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean r() {
        return this.f63684e > 0;
    }

    public void s() {
        b bVar = this.f63680a;
        if (bVar != null) {
            bVar.cancel();
        }
        c cVar = this.f63681b;
        if (cVar != null) {
            cVar.cancel();
        }
        C1697a c1697a = this.f63682c;
        if (c1697a != null) {
            c1697a.cancel();
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
                    this.f63683d.add(markData);
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
        b bVar = this.f63680a;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(q());
        this.f63680a = bVar2;
        bVar2.setPriority(3);
        this.f63680a.execute(bool, Boolean.valueOf(z));
    }

    public final void y() {
        if (this.f63683d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.f63683d.iterator();
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
        this.f63685f = 0;
        this.f63684e = 0;
        this.f63686g = true;
    }
}
