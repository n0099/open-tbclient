package d.a.n0.k1.m;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.m0.c.f;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes4.dex */
public class e extends d.a.m0.c.a {

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f56630a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f56631b;

        /* renamed from: c  reason: collision with root package name */
        public String f56632c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f56633d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.c.a.e f56634e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.a.c.a.e eVar2) {
            this.f56631b = str;
            this.f56632c = str2;
            this.f56633d = hashMap;
            this.f56634e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f56630a = new NetWork(TbConfig.SERVER_ADDRESS + this.f56632c);
                Set<String> keySet = this.f56633d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f56630a.addPostData(str, this.f56633d.get(str));
                        }
                    }
                }
                this.f56630a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f56630a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                boolean z = true;
                this.f56630a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f56630a.postNetData();
                if (!this.f56630a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f49215b = this.f56630a.getNetErrorCode();
                    fVar.f49216c = this.f56630a.getNetString();
                } else {
                    fVar.f49215b = this.f56630a.getServerErrorCode();
                    fVar.f49216c = this.f56630a.getErrorString();
                }
                if (this.f56630a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    if (fVar.f49215b != 0) {
                        z = false;
                    }
                    fVar.f49214a = z;
                    return fVar;
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
            d.a.c.a.e eVar = this.f56634e;
            if (eVar != null) {
                eVar.c(fVar);
            }
            d.a.n0.k1.m.a.a().d(this.f56632c, this.f56633d, fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f56630a != null) {
                this.f56630a.cancelNetConnect();
                this.f56630a = null;
            }
            super.cancel(true);
            d.a.c.a.e eVar = this.f56634e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    @Override // d.a.m0.c.a, d.a.m0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, d.a.c.a.e eVar) {
        if (hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("url")) {
            return;
        }
        String str2 = hashMap.get("url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a aVar = new a(this, str, str2, hashMap, eVar);
        aVar.setPriority(2);
        aVar.execute(new Object[0]);
    }

    @Override // d.a.m0.c.a
    public String c() {
        return "post";
    }
}
