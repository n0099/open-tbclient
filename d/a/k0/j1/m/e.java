package d.a.k0.j1.m;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.j0.c.f;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes4.dex */
public class e extends d.a.j0.c.a {

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f56450a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f56451b;

        /* renamed from: c  reason: collision with root package name */
        public String f56452c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f56453d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.c.a.e f56454e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.a.c.a.e eVar2) {
            this.f56451b = str;
            this.f56452c = str2;
            this.f56453d = hashMap;
            this.f56454e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f56450a = new NetWork(TbConfig.SERVER_ADDRESS + this.f56452c);
                Set<String> keySet = this.f56453d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f56450a.addPostData(str, this.f56453d.get(str));
                        }
                    }
                }
                this.f56450a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f56450a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                boolean z = true;
                this.f56450a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f56450a.postNetData();
                if (!this.f56450a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f49190b = this.f56450a.getNetErrorCode();
                    fVar.f49191c = this.f56450a.getNetString();
                } else {
                    fVar.f49190b = this.f56450a.getServerErrorCode();
                    fVar.f49191c = this.f56450a.getErrorString();
                }
                if (this.f56450a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    if (fVar.f49190b != 0) {
                        z = false;
                    }
                    fVar.f49189a = z;
                    return fVar;
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
            d.a.c.a.e eVar = this.f56454e;
            if (eVar != null) {
                eVar.c(fVar);
            }
            d.a.k0.j1.m.a.a().d(this.f56452c, this.f56453d, fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f56450a != null) {
                this.f56450a.cancelNetConnect();
                this.f56450a = null;
            }
            super.cancel(true);
            d.a.c.a.e eVar = this.f56454e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    @Override // d.a.j0.c.a, d.a.j0.c.d
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

    @Override // d.a.j0.c.a
    public String c() {
        return "post";
    }
}
