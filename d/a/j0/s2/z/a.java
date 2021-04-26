package d.a.j0.s2.z;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.a.e;
import d.a.i0.c.f;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.i0.c.a {

    /* renamed from: a  reason: collision with root package name */
    public String f60367a;

    /* renamed from: d.a.j0.s2.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1550a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f60368a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f60369b;

        /* renamed from: c  reason: collision with root package name */
        public String f60370c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f60371d;

        /* renamed from: e  reason: collision with root package name */
        public e f60372e;

        public C1550a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            this.f60369b = str;
            this.f60370c = str2;
            this.f60371d = hashMap;
            this.f60372e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f60368a = new NetWork(this.f60370c);
                Set<String> keySet = this.f60371d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f60368a.addPostData(str, this.f60371d.get(str));
                        }
                    }
                }
                this.f60368a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f60368a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f60368a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f60368a.postNetData();
                if (!this.f60368a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f48362b = this.f60368a.getNetErrorCode();
                    fVar.f48363c = this.f60368a.getNetString();
                } else {
                    fVar.f48362b = this.f60368a.getServerErrorCode();
                    fVar.f48363c = this.f60368a.getErrorString();
                }
                if (this.f60368a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            fVar.f48361a = true;
                            return fVar;
                        }
                        String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                        fVar.f48361a = false;
                        fVar.f48363c = optString;
                        return fVar;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f48361a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar = this.f60372e;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f60368a != null) {
                this.f60368a.cancelNetConnect();
                this.f60368a = null;
            }
            super.cancel(true);
            e eVar = this.f60372e;
            if (eVar != null) {
                eVar.c(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            e eVar = this.f60372e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    public a(String str) {
        this.f60367a = str;
    }

    @Override // d.a.i0.c.a, d.a.i0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, e eVar) {
        if (hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        C1550a c1550a = new C1550a(this, str, str2, hashMap, eVar);
        c1550a.setPriority(2);
        c1550a.execute(new Object[0]);
    }

    @Override // d.a.i0.c.a
    public String c() {
        Uri parse = Uri.parse(this.f60367a);
        if (parse != null) {
            return parse.getAuthority() + parse.getPath();
        }
        return "";
    }
}
