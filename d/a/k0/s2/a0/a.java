package d.a.k0.s2.a0;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.a.e;
import d.a.j0.c.f;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d.a.j0.c.a {

    /* renamed from: a  reason: collision with root package name */
    public String f60788a;

    /* renamed from: d.a.k0.s2.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1607a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f60789a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f60790b;

        /* renamed from: c  reason: collision with root package name */
        public String f60791c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f60792d;

        /* renamed from: e  reason: collision with root package name */
        public e f60793e;

        public C1607a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            this.f60790b = str;
            this.f60791c = str2;
            this.f60792d = hashMap;
            this.f60793e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f60789a = new NetWork(this.f60791c);
                Set<String> keySet = this.f60792d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f60789a.addPostData(str, this.f60792d.get(str));
                        }
                    }
                }
                this.f60789a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f60789a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f60789a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f60789a.postNetData();
                if (!this.f60789a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f49190b = this.f60789a.getNetErrorCode();
                    fVar.f49191c = this.f60789a.getNetString();
                } else {
                    fVar.f49190b = this.f60789a.getServerErrorCode();
                    fVar.f49191c = this.f60789a.getErrorString();
                }
                if (this.f60789a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            fVar.f49189a = true;
                            return fVar;
                        }
                        String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                        fVar.f49189a = false;
                        fVar.f49191c = optString;
                        return fVar;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f49189a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar = this.f60793e;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f60789a != null) {
                this.f60789a.cancelNetConnect();
                this.f60789a = null;
            }
            super.cancel(true);
            e eVar = this.f60793e;
            if (eVar != null) {
                eVar.c(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            e eVar = this.f60793e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    public a(String str) {
        this.f60788a = str;
    }

    @Override // d.a.j0.c.a, d.a.j0.c.d
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

    @Override // d.a.j0.c.a
    public String c() {
        Uri parse = Uri.parse(this.f60788a);
        if (parse != null) {
            return parse.getAuthority() + parse.getPath();
        }
        return "";
    }
}
