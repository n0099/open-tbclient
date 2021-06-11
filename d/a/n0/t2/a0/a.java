package d.a.n0.t2.a0;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.a.e;
import d.a.m0.c.f;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d.a.m0.c.a {

    /* renamed from: a  reason: collision with root package name */
    public String f64582a;

    /* renamed from: d.a.n0.t2.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1669a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f64583a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f64584b;

        /* renamed from: c  reason: collision with root package name */
        public String f64585c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f64586d;

        /* renamed from: e  reason: collision with root package name */
        public e f64587e;

        public C1669a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            this.f64584b = str;
            this.f64585c = str2;
            this.f64586d = hashMap;
            this.f64587e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f64583a = new NetWork(this.f64585c);
                Set<String> keySet = this.f64586d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f64583a.addPostData(str, this.f64586d.get(str));
                        }
                    }
                }
                this.f64583a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f64583a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f64583a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f64583a.postNetData();
                if (!this.f64583a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f52889b = this.f64583a.getNetErrorCode();
                    fVar.f52890c = this.f64583a.getNetString();
                } else {
                    fVar.f52889b = this.f64583a.getServerErrorCode();
                    fVar.f52890c = this.f64583a.getErrorString();
                }
                if (this.f64583a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            fVar.f52888a = true;
                            return fVar;
                        }
                        String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                        fVar.f52888a = false;
                        fVar.f52890c = optString;
                        return fVar;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f52888a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar = this.f64587e;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f64583a != null) {
                this.f64583a.cancelNetConnect();
                this.f64583a = null;
            }
            super.cancel(true);
            e eVar = this.f64587e;
            if (eVar != null) {
                eVar.c(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            e eVar = this.f64587e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    public a(String str) {
        this.f64582a = str;
    }

    @Override // d.a.m0.c.a, d.a.m0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, e eVar) {
        if (hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        C1669a c1669a = new C1669a(this, str, str2, hashMap, eVar);
        c1669a.setPriority(2);
        c1669a.execute(new Object[0]);
    }

    @Override // d.a.m0.c.a
    public String c() {
        Uri parse = Uri.parse(this.f64582a);
        if (parse != null) {
            return parse.getAuthority() + parse.getPath();
        }
        return "";
    }
}
