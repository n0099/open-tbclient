package d.b.j0.s2.y;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.b.c.a.e;
import d.b.i0.c.f;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d.b.i0.c.a {

    /* renamed from: a  reason: collision with root package name */
    public String f62171a;

    /* renamed from: d.b.j0.s2.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1607a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f62172a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f62173b;

        /* renamed from: c  reason: collision with root package name */
        public String f62174c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f62175d;

        /* renamed from: e  reason: collision with root package name */
        public e f62176e;

        public C1607a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            this.f62173b = str;
            this.f62174c = str2;
            this.f62175d = hashMap;
            this.f62176e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f62172a = new NetWork(this.f62174c);
                Set<String> keySet = this.f62175d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f62172a.addPostData(str, this.f62175d.get(str));
                        }
                    }
                }
                this.f62172a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f62172a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f62172a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f62172a.postNetData();
                if (!this.f62172a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f50790b = this.f62172a.getNetErrorCode();
                    fVar.f50791c = this.f62172a.getNetString();
                } else {
                    fVar.f50790b = this.f62172a.getServerErrorCode();
                    fVar.f50791c = this.f62172a.getErrorString();
                }
                if (this.f62172a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            fVar.f50789a = true;
                            return fVar;
                        }
                        String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                        fVar.f50789a = false;
                        fVar.f50791c = optString;
                        return fVar;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f50789a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar = this.f62176e;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f62172a != null) {
                this.f62172a.cancelNetConnect();
                this.f62172a = null;
            }
            super.cancel(true);
            e eVar = this.f62176e;
            if (eVar != null) {
                eVar.c(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            e eVar = this.f62176e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    public a(String str) {
        this.f62171a = str;
    }

    @Override // d.b.i0.c.a, d.b.i0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, e eVar) {
        if (hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        C1607a c1607a = new C1607a(this, str, str2, hashMap, eVar);
        c1607a.setPriority(2);
        c1607a.execute(new Object[0]);
    }

    @Override // d.b.i0.c.a
    public String c() {
        Uri parse = Uri.parse(this.f62171a);
        if (parse != null) {
            return parse.getAuthority() + parse.getPath();
        }
        return "";
    }
}
