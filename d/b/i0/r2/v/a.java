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
    public String f59856a;

    /* renamed from: d.b.i0.r2.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1507a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f59857a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f59858b;

        /* renamed from: c  reason: collision with root package name */
        public String f59859c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f59860d;

        /* renamed from: e  reason: collision with root package name */
        public e f59861e;

        public C1507a(a aVar, String str, String str2, HashMap<String, String> hashMap, e eVar) {
            this.f59858b = str;
            this.f59859c = str2;
            this.f59860d = hashMap;
            this.f59861e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f59857a = new NetWork(this.f59859c);
                Set<String> keySet = this.f59860d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f59857a.addPostData(str, this.f59860d.get(str));
                        }
                    }
                }
                this.f59857a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f59857a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f59857a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f59857a.postNetData();
                if (!this.f59857a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f50060b = this.f59857a.getNetErrorCode();
                    fVar.f50061c = this.f59857a.getNetString();
                } else {
                    fVar.f50060b = this.f59857a.getServerErrorCode();
                    fVar.f50061c = this.f59857a.getErrorString();
                }
                if (this.f59857a.getNetContext().getResponse().isRequestSuccess() && !TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.has("code")) {
                        if (jSONObject.optInt("code", -1) == 0) {
                            fVar.f50059a = true;
                            return fVar;
                        }
                        String optString = jSONObject.has("msg") ? jSONObject.optString("msg", "") : "";
                        fVar.f50059a = false;
                        fVar.f50061c = optString;
                        return fVar;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f50059a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            e eVar = this.f59861e;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f59857a != null) {
                this.f59857a.cancelNetConnect();
                this.f59857a = null;
            }
            super.cancel(true);
            e eVar = this.f59861e;
            if (eVar != null) {
                eVar.c(null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            e eVar = this.f59861e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    public a(String str) {
        this.f59856a = str;
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
        C1507a c1507a = new C1507a(this, str, str2, hashMap, eVar);
        c1507a.setPriority(2);
        c1507a.execute(new Object[0]);
    }

    @Override // d.b.h0.c.a
    public String c() {
        Uri parse = Uri.parse(this.f59856a);
        if (parse != null) {
            return parse.getAuthority() + parse.getPath();
        }
        return "";
    }
}
