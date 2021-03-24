package d.b.i0.i1.m;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.b.h0.c.f;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes4.dex */
public class e extends d.b.h0.c.a {

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f55909a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f55910b;

        /* renamed from: c  reason: collision with root package name */
        public String f55911c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f55912d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.b.a.e f55913e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.b.b.a.e eVar2) {
            this.f55910b = str;
            this.f55911c = str2;
            this.f55912d = hashMap;
            this.f55913e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f55909a = new NetWork(TbConfig.SERVER_ADDRESS + this.f55911c);
                Set<String> keySet = this.f55912d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f55909a.addPostData(str, this.f55912d.get(str));
                        }
                    }
                }
                this.f55909a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f55909a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                boolean z = true;
                this.f55909a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f55909a.postNetData();
                if (!this.f55909a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f50060b = this.f55909a.getNetErrorCode();
                    fVar.f50061c = this.f55909a.getNetString();
                } else {
                    fVar.f50060b = this.f55909a.getServerErrorCode();
                    fVar.f50061c = this.f55909a.getErrorString();
                }
                if (this.f55909a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    if (fVar.f50060b != 0) {
                        z = false;
                    }
                    fVar.f50059a = z;
                    return fVar;
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
            d.b.b.a.e eVar = this.f55913e;
            if (eVar != null) {
                eVar.c(fVar);
            }
            d.b.i0.i1.m.a.a().d(this.f55911c, this.f55912d, fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f55909a != null) {
                this.f55909a.cancelNetConnect();
                this.f55909a = null;
            }
            super.cancel(true);
            d.b.b.a.e eVar = this.f55913e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    @Override // d.b.h0.c.a, d.b.h0.c.d
    public void a(Object obj, HashMap<String, String> hashMap, String str, d.b.b.a.e eVar) {
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

    @Override // d.b.h0.c.a
    public String c() {
        return "post";
    }
}
