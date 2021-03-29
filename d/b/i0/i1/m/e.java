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
/* loaded from: classes3.dex */
public class e extends d.b.h0.c.a {

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f55910a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f55911b;

        /* renamed from: c  reason: collision with root package name */
        public String f55912c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f55913d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.b.a.e f55914e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.b.b.a.e eVar2) {
            this.f55911b = str;
            this.f55912c = str2;
            this.f55913d = hashMap;
            this.f55914e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f55910a = new NetWork(TbConfig.SERVER_ADDRESS + this.f55912c);
                Set<String> keySet = this.f55913d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f55910a.addPostData(str, this.f55913d.get(str));
                        }
                    }
                }
                this.f55910a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f55910a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                boolean z = true;
                this.f55910a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f55910a.postNetData();
                if (!this.f55910a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f50061b = this.f55910a.getNetErrorCode();
                    fVar.f50062c = this.f55910a.getNetString();
                } else {
                    fVar.f50061b = this.f55910a.getServerErrorCode();
                    fVar.f50062c = this.f55910a.getErrorString();
                }
                if (this.f55910a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    if (fVar.f50061b != 0) {
                        z = false;
                    }
                    fVar.f50060a = z;
                    return fVar;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f50060a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            d.b.b.a.e eVar = this.f55914e;
            if (eVar != null) {
                eVar.c(fVar);
            }
            d.b.i0.i1.m.a.a().d(this.f55912c, this.f55913d, fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f55910a != null) {
                this.f55910a.cancelNetConnect();
                this.f55910a = null;
            }
            super.cancel(true);
            d.b.b.a.e eVar = this.f55914e;
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
