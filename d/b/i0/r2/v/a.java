package d.b.i0.r2.v;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.b.b.a.e;
import d.b.h0.c.f;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d.b.h0.c.a {

    /* renamed from: a  reason: collision with root package name */
    public String f59857a;

    /* renamed from: d.b.i0.r2.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1508a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f59858a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f59859b;

        /* renamed from: c  reason: collision with root package name */
        public String f59860c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f59861d;

        /* renamed from: e  reason: collision with root package name */
        public e f59862e;

        public C1508a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            this.f59859b = str;
            this.f59860c = str2;
            this.f59861d = hashMap;
            this.f59862e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f59858a = new NetWork(this.f59860c);
                Set<String> keySet = this.f59861d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f59858a.addPostData(str, this.f59861d.get(str));
                        }
                    }
                }
                this.f59858a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f59858a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f59858a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f59858a.postNetData();
                if (!this.f59858a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f50061b = this.f59858a.getNetErrorCode();
                    fVar.f50062c = this.f59858a.getNetString();
                } else {
                    fVar.f50061b = this.f59858a.getServerErrorCode();
                    fVar.f50062c = this.f59858a.getErrorString();
                }
                if (this.f59858a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            fVar.f50060a = true;
                            return fVar;
                        }
                        String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                        fVar.f50060a = false;
                        fVar.f50062c = optString;
                        return fVar;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f50060a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar = this.f59862e;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f59858a != null) {
                this.f59858a.cancelNetConnect();
                this.f59858a = null;
            }
            super.cancel(true);
            e eVar = this.f59862e;
            if (eVar != null) {
                eVar.c(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            e eVar = this.f59862e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    public a(String str) {
        this.f59857a = str;
    }

    @Override // d.b.h0.c.a, d.b.h0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, e eVar) {
        if (hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        C1508a c1508a = new C1508a(this, str, str2, hashMap, eVar);
        c1508a.setPriority(2);
        c1508a.execute(new Object[0]);
    }

    @Override // d.b.h0.c.a
    public String c() {
        Uri parse = Uri.parse(this.f59857a);
        if (parse != null) {
            return parse.getAuthority() + parse.getPath();
        }
        return "";
    }
}
