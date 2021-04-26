package d.a.j0.w1.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.e.d.l;
import d.a.j0.w1.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f62361g;

    /* renamed from: a  reason: collision with root package name */
    public b f62355a = null;

    /* renamed from: b  reason: collision with root package name */
    public c f62356b = null;

    /* renamed from: c  reason: collision with root package name */
    public C1657a f62357c = null;

    /* renamed from: e  reason: collision with root package name */
    public int f62359e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f62360f = 0;

    /* renamed from: h  reason: collision with root package name */
    public d f62362h = null;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MarkData> f62358d = new ArrayList<>();

    /* renamed from: d.a.j0.w1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1657a extends BdAsyncTask<Boolean, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f62363a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f62364b;

        /* renamed from: c  reason: collision with root package name */
        public String f62365c;

        /* renamed from: d  reason: collision with root package name */
        public int f62366d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.j0.w1.g.c f62367e;

        public C1657a(String str, int i2, String str2) {
            this.f62364b = null;
            this.f62365c = null;
            this.f62366d = 0;
            this.f62367e = null;
            this.f62364b = str;
            this.f62366d = i2;
            this.f62365c = str2;
            this.f62367e = new d.a.j0.w1.g.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
            this.f62363a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            this.f62363a.addPostData("tid", this.f62364b);
            this.f62363a.addPostData("fid", this.f62365c);
            this.f62367e.c(this.f62363a.postNetData());
            if (this.f62363a.getNetContext().getResponse().isRequestSuccess() && this.f62367e.a() == 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f62363a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f62357c = null;
            d dVar = a.this.f62362h;
            if (dVar != null) {
                dVar.a(2, Boolean.FALSE, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str = null;
            a.this.f62357c = null;
            if (bool.booleanValue()) {
                if (this.f62366d < a.this.f62358d.size()) {
                    a.this.f62358d.remove(this.f62366d);
                    a.i(a.this);
                }
            } else if (this.f62363a.getNetContext().getResponse().isRequestSuccess()) {
                str = this.f62367e.b();
            } else {
                str = this.f62363a.getErrorString();
            }
            d dVar = a.this.f62362h;
            if (dVar != null) {
                dVar.a(2, bool, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {

        /* renamed from: c  reason: collision with root package name */
        public int f62371c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.j0.w1.g.c f62372d;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f62369a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f62370b = null;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f62373e = Boolean.FALSE;

        public b(int i2) {
            this.f62371c = 0;
            this.f62372d = null;
            this.f62371c = i2;
            this.f62372d = new d.a.j0.w1.g.c();
        }

        public final void b(String str) {
            l<String> g2;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || (g2 = d.a.i0.r.r.a.f().g("tb.my_bookmarks")) == null) {
                return;
            }
            g2.e(currentAccount, str, 604800000L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Boolean... boolArr) {
            this.f62373e = boolArr[0];
            boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
            a aVar = new a();
            if (this.f62373e.booleanValue() && booleanValue) {
                l<String> g2 = d.a.i0.r.r.a.f().g("tb.my_bookmarks");
                if (g2 != null) {
                    publishProgress(g2.get(TbadkCoreApplication.getCurrentAccount()));
                }
                if (a.this.f62358d == null) {
                    a.this.f62358d = new ArrayList();
                } else {
                    a.this.f62358d.clear();
                }
                a.this.f62359e = 0;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
            this.f62369a = netWork;
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            if (a.this.f62361g) {
                this.f62369a.addPostData("offset", String.valueOf(0));
            } else {
                this.f62369a.addPostData("offset", String.valueOf(this.f62371c));
            }
            this.f62369a.addPostData("rn", String.valueOf(20));
            String postNetData = this.f62369a.postNetData();
            this.f62370b = postNetData;
            this.f62372d.c(postNetData);
            if (this.f62369a.getNetContext().getResponse().isRequestSuccess()) {
                aVar.u(this.f62370b);
                if (this.f62371c == 0) {
                    if (a.this.f62358d == null) {
                        a.this.f62358d = new ArrayList();
                    } else {
                        a.this.f62358d.clear();
                    }
                    a.this.f62359e = 0;
                    if (this.f62373e.booleanValue()) {
                        b(this.f62370b);
                    }
                }
            }
            return aVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f62369a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            a.this.f62355a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            if (aVar == null) {
                aVar = new a();
            }
            d.a.j0.w1.g.c cVar = this.f62372d;
            if (cVar != null) {
                d.a.i0.r.z.a.a("collection", 0L, 0, "collection_thread_list_result", cVar.a(), this.f62372d.b(), new Object[0]);
            }
            a.this.f62359e = aVar.m();
            ArrayList<MarkData> n = aVar.n();
            if (this.f62373e.booleanValue()) {
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
            if (a.this.f62362h != null) {
                if (this.f62369a.getNetContext().getResponse().isRequestSuccess()) {
                    a.this.f62362h.a(0, this.f62372d.a() != 0 ? this.f62372d.b() : null, Boolean.FALSE);
                } else {
                    a.this.f62362h.a(3, this.f62369a.getErrorString());
                }
            }
            a.this.f62361g = false;
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
                if (this.f62373e.booleanValue()) {
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
            a.this.f62362h.a(0, null, Boolean.TRUE);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<a, Integer, Boolean> {
    }

    public a() {
        this.f62361g = false;
        this.f62361g = true;
    }

    public static /* synthetic */ int i(a aVar) {
        int i2 = aVar.f62360f;
        aVar.f62360f = i2 - 1;
        return i2;
    }

    public void A(d dVar) {
        this.f62362h = dVar;
    }

    public void B(ArrayList<MarkData> arrayList) {
        this.f62358d = arrayList;
    }

    public void C(int i2) {
        this.f62360f = i2;
    }

    public boolean D(int i2) {
        C1657a c1657a = this.f62357c;
        if (c1657a != null) {
            c1657a.cancel();
        }
        if (i2 >= this.f62358d.size() || this.f62358d.get(i2) == null || this.f62358d.get(i2).getId() == null) {
            return false;
        }
        C1657a c1657a2 = new C1657a(this.f62358d.get(i2).getId(), i2, this.f62358d.get(i2).getForumId());
        this.f62357c = c1657a2;
        c1657a2.setPriority(2);
        this.f62357c.execute(new Boolean[0]);
        return true;
    }

    public String E(int i2, int i3) {
        ArrayList<MarkData> arrayList = this.f62358d;
        if (arrayList == null) {
            return null;
        }
        if (i2 >= arrayList.size()) {
            i3 -= (i2 - this.f62358d.size()) - 1;
            i2 = this.f62358d.size() - 1;
        }
        JSONArray jSONArray = new JSONArray();
        int i4 = 0;
        for (int i5 = i2; i5 >= 0 && i5 > i2 - i3; i5--) {
            try {
                JSONObject json = this.f62358d.get(i5).toJson();
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
        this.f62358d.add(markData);
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2 = this.f62358d;
        if (arrayList2 == null || arrayList == null) {
            return;
        }
        arrayList2.addAll(arrayList);
        y();
    }

    public final void l(String str, int i2) {
        ArrayList<MarkData> arrayList = this.f62358d;
        if (arrayList == null || ListUtils.getCount(arrayList) <= 0) {
            return;
        }
        Iterator<MarkData> it = this.f62358d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            if (next != null && next.getId().equals(str)) {
                next.setReplyNum(i2);
            }
        }
    }

    public int m() {
        ArrayList<MarkData> arrayList = this.f62358d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<MarkData> n() {
        return this.f62358d;
    }

    public int o() {
        return this.f62360f;
    }

    public int p() {
        return this.f62359e;
    }

    public int q() {
        ArrayList<MarkData> arrayList = this.f62358d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean r() {
        return this.f62359e > 0;
    }

    public void s() {
        b bVar = this.f62355a;
        if (bVar != null) {
            bVar.cancel();
        }
        c cVar = this.f62356b;
        if (cVar != null) {
            cVar.cancel();
        }
        C1657a c1657a = this.f62357c;
        if (c1657a != null) {
            c1657a.cancel();
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
                    this.f62358d.add(markData);
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
        b bVar = this.f62355a;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(q());
        this.f62355a = bVar2;
        bVar2.setPriority(3);
        this.f62355a.execute(bool, Boolean.valueOf(z));
    }

    public final void y() {
        if (this.f62358d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.f62358d.iterator();
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
        this.f62360f = 0;
        this.f62359e = 0;
        this.f62361g = true;
    }
}
