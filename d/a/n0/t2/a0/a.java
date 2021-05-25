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
    public String f60890a;

    /* renamed from: d.a.n0.t2.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1613a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f60891a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f60892b;

        /* renamed from: c  reason: collision with root package name */
        public String f60893c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f60894d;

        /* renamed from: e  reason: collision with root package name */
        public e f60895e;

        public C1613a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            this.f60892b = str;
            this.f60893c = str2;
            this.f60894d = hashMap;
            this.f60895e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f60891a = new NetWork(this.f60893c);
                Set<String> keySet = this.f60894d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f60891a.addPostData(str, this.f60894d.get(str));
                        }
                    }
                }
                this.f60891a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f60891a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f60891a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f60891a.postNetData();
                if (!this.f60891a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f49215b = this.f60891a.getNetErrorCode();
                    fVar.f49216c = this.f60891a.getNetString();
                } else {
                    fVar.f49215b = this.f60891a.getServerErrorCode();
                    fVar.f49216c = this.f60891a.getErrorString();
                }
                if (this.f60891a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            fVar.f49214a = true;
                            return fVar;
                        }
                        String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                        fVar.f49214a = false;
                        fVar.f49216c = optString;
                        return fVar;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f49214a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar = this.f60895e;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f60891a != null) {
                this.f60891a.cancelNetConnect();
                this.f60891a = null;
            }
            super.cancel(true);
            e eVar = this.f60895e;
            if (eVar != null) {
                eVar.c(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            e eVar = this.f60895e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    public a(String str) {
        this.f60890a = str;
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
        C1613a c1613a = new C1613a(this, str, str2, hashMap, eVar);
        c1613a.setPriority(2);
        c1613a.execute(new Object[0]);
    }

    @Override // d.a.m0.c.a
    public String c() {
        Uri parse = Uri.parse(this.f60890a);
        if (parse != null) {
            return parse.getAuthority() + parse.getPath();
        }
        return "";
    }
}
