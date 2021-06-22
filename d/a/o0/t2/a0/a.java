package d.a.o0.t2.a0;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.a.e;
import d.a.n0.c.f;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d.a.n0.c.a {

    /* renamed from: a  reason: collision with root package name */
    public String f64707a;

    /* renamed from: d.a.o0.t2.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1673a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f64708a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f64709b;

        /* renamed from: c  reason: collision with root package name */
        public String f64710c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f64711d;

        /* renamed from: e  reason: collision with root package name */
        public e f64712e;

        public C1673a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            this.f64709b = str;
            this.f64710c = str2;
            this.f64711d = hashMap;
            this.f64712e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f64708a = new NetWork(this.f64710c);
                Set<String> keySet = this.f64711d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f64708a.addPostData(str, this.f64711d.get(str));
                        }
                    }
                }
                this.f64708a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f64708a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f64708a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f64708a.postNetData();
                if (!this.f64708a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f52996b = this.f64708a.getNetErrorCode();
                    fVar.f52997c = this.f64708a.getNetString();
                } else {
                    fVar.f52996b = this.f64708a.getServerErrorCode();
                    fVar.f52997c = this.f64708a.getErrorString();
                }
                if (this.f64708a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            fVar.f52995a = true;
                            return fVar;
                        }
                        String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                        fVar.f52995a = false;
                        fVar.f52997c = optString;
                        return fVar;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f52995a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar = this.f64712e;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f64708a != null) {
                this.f64708a.cancelNetConnect();
                this.f64708a = null;
            }
            super.cancel(true);
            e eVar = this.f64712e;
            if (eVar != null) {
                eVar.c(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            e eVar = this.f64712e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    public a(String str) {
        this.f64707a = str;
    }

    @Override // d.a.n0.c.a, d.a.n0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, e eVar) {
        if (hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        C1673a c1673a = new C1673a(this, str, str2, hashMap, eVar);
        c1673a.setPriority(2);
        c1673a.execute(new Object[0]);
    }

    @Override // d.a.n0.c.a
    public String c() {
        Uri parse = Uri.parse(this.f64707a);
        if (parse != null) {
            return parse.getAuthority() + parse.getPath();
        }
        return "";
    }
}
