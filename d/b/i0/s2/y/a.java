package d.b.i0.s2.y;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.b.c.a.e;
import d.b.h0.c.f;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d.b.h0.c.a {

    /* renamed from: a  reason: collision with root package name */
    public String f61750a;

    /* renamed from: d.b.i0.s2.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1584a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f61751a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f61752b;

        /* renamed from: c  reason: collision with root package name */
        public String f61753c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f61754d;

        /* renamed from: e  reason: collision with root package name */
        public e f61755e;

        public C1584a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            this.f61752b = str;
            this.f61753c = str2;
            this.f61754d = hashMap;
            this.f61755e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f61751a = new NetWork(this.f61753c);
                Set<String> keySet = this.f61754d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f61751a.addPostData(str, this.f61754d.get(str));
                        }
                    }
                }
                this.f61751a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f61751a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f61751a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f61751a.postNetData();
                if (!this.f61751a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f50454b = this.f61751a.getNetErrorCode();
                    fVar.f50455c = this.f61751a.getNetString();
                } else {
                    fVar.f50454b = this.f61751a.getServerErrorCode();
                    fVar.f50455c = this.f61751a.getErrorString();
                }
                if (this.f61751a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            fVar.f50453a = true;
                            return fVar;
                        }
                        String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                        fVar.f50453a = false;
                        fVar.f50455c = optString;
                        return fVar;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f50453a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar = this.f61755e;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f61751a != null) {
                this.f61751a.cancelNetConnect();
                this.f61751a = null;
            }
            super.cancel(true);
            e eVar = this.f61755e;
            if (eVar != null) {
                eVar.c(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            e eVar = this.f61755e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    public a(String str) {
        this.f61750a = str;
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
        C1584a c1584a = new C1584a(this, str, str2, hashMap, eVar);
        c1584a.setPriority(2);
        c1584a.execute(new Object[0]);
    }

    @Override // d.b.h0.c.a
    public String c() {
        Uri parse = Uri.parse(this.f61750a);
        if (parse != null) {
            return parse.getAuthority() + parse.getPath();
        }
        return "";
    }
}
