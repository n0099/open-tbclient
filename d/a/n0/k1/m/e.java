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
        public volatile NetWork f60319a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f60320b;

        /* renamed from: c  reason: collision with root package name */
        public String f60321c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f60322d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.c.a.e f60323e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.a.c.a.e eVar2) {
            this.f60320b = str;
            this.f60321c = str2;
            this.f60322d = hashMap;
            this.f60323e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f60319a = new NetWork(TbConfig.SERVER_ADDRESS + this.f60321c);
                Set<String> keySet = this.f60322d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f60319a.addPostData(str, this.f60322d.get(str));
                        }
                    }
                }
                this.f60319a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f60319a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                boolean z = true;
                this.f60319a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f60319a.postNetData();
                if (!this.f60319a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f52889b = this.f60319a.getNetErrorCode();
                    fVar.f52890c = this.f60319a.getNetString();
                } else {
                    fVar.f52889b = this.f60319a.getServerErrorCode();
                    fVar.f52890c = this.f60319a.getErrorString();
                }
                if (this.f60319a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    if (fVar.f52889b != 0) {
                        z = false;
                    }
                    fVar.f52888a = z;
                    return fVar;
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
            d.a.c.a.e eVar = this.f60323e;
            if (eVar != null) {
                eVar.c(fVar);
            }
            d.a.n0.k1.m.a.a().d(this.f60321c, this.f60322d, fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f60319a != null) {
                this.f60319a.cancelNetConnect();
                this.f60319a = null;
            }
            super.cancel(true);
            d.a.c.a.e eVar = this.f60323e;
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
