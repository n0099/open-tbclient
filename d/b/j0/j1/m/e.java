package d.b.j0.j1.m;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.b.i0.c.f;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes4.dex */
public class e extends d.b.i0.c.a {

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f57778a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f57779b;

        /* renamed from: c  reason: collision with root package name */
        public String f57780c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f57781d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.c.a.e f57782e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.b.c.a.e eVar2) {
            this.f57779b = str;
            this.f57780c = str2;
            this.f57781d = hashMap;
            this.f57782e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f57778a = new NetWork(TbConfig.SERVER_ADDRESS + this.f57780c);
                Set<String> keySet = this.f57781d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f57778a.addPostData(str, this.f57781d.get(str));
                        }
                    }
                }
                this.f57778a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f57778a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                boolean z = true;
                this.f57778a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f57778a.postNetData();
                if (!this.f57778a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f50790b = this.f57778a.getNetErrorCode();
                    fVar.f50791c = this.f57778a.getNetString();
                } else {
                    fVar.f50790b = this.f57778a.getServerErrorCode();
                    fVar.f50791c = this.f57778a.getErrorString();
                }
                if (this.f57778a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    if (fVar.f50790b != 0) {
                        z = false;
                    }
                    fVar.f50789a = z;
                    return fVar;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f50789a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            d.b.c.a.e eVar = this.f57782e;
            if (eVar != null) {
                eVar.c(fVar);
            }
            d.b.j0.j1.m.a.a().d(this.f57780c, this.f57781d, fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f57778a != null) {
                this.f57778a.cancelNetConnect();
                this.f57778a = null;
            }
            super.cancel(true);
            d.b.c.a.e eVar = this.f57782e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    @Override // d.b.i0.c.a, d.b.i0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, d.b.c.a.e eVar) {
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

    @Override // d.b.i0.c.a
    public String c() {
        return "post";
    }
}
