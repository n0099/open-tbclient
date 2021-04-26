package d.a.j0.j1.m;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.i0.c.f;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes4.dex */
public class e extends d.a.i0.c.a {

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f55743a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f55744b;

        /* renamed from: c  reason: collision with root package name */
        public String f55745c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f55746d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.c.a.e f55747e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.a.c.a.e eVar2) {
            this.f55744b = str;
            this.f55745c = str2;
            this.f55746d = hashMap;
            this.f55747e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f55743a = new NetWork(TbConfig.SERVER_ADDRESS + this.f55745c);
                Set<String> keySet = this.f55746d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f55743a.addPostData(str, this.f55746d.get(str));
                        }
                    }
                }
                this.f55743a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f55743a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                boolean z = true;
                this.f55743a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f55743a.postNetData();
                if (!this.f55743a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f48362b = this.f55743a.getNetErrorCode();
                    fVar.f48363c = this.f55743a.getNetString();
                } else {
                    fVar.f48362b = this.f55743a.getServerErrorCode();
                    fVar.f48363c = this.f55743a.getErrorString();
                }
                if (this.f55743a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    if (fVar.f48362b != 0) {
                        z = false;
                    }
                    fVar.f48361a = z;
                    return fVar;
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
            d.a.c.a.e eVar = this.f55747e;
            if (eVar != null) {
                eVar.c(fVar);
            }
            d.a.j0.j1.m.a.a().d(this.f55745c, this.f55746d, fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f55743a != null) {
                this.f55743a.cancelNetConnect();
                this.f55743a = null;
            }
            super.cancel(true);
            d.a.c.a.e eVar = this.f55747e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    @Override // d.a.i0.c.a, d.a.i0.c.d
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

    @Override // d.a.i0.c.a
    public String c() {
        return "post";
    }
}
