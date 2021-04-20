package d.b.i0.j1.m;

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
        public volatile NetWork f57357a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f57358b;

        /* renamed from: c  reason: collision with root package name */
        public String f57359c;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f57360d;

        /* renamed from: e  reason: collision with root package name */
        public d.b.c.a.e f57361e;

        public a(e eVar, String str, String str2, HashMap<String, String> hashMap, d.b.c.a.e eVar2) {
            this.f57358b = str;
            this.f57359c = str2;
            this.f57360d = hashMap;
            this.f57361e = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            f fVar = new f();
            try {
                this.f57357a = new NetWork(TbConfig.SERVER_ADDRESS + this.f57359c);
                Set<String> keySet = this.f57360d.keySet();
                if (keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!"url".equalsIgnoreCase(str)) {
                            this.f57357a.addPostData(str, this.f57360d.get(str));
                        }
                    }
                }
                this.f57357a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f57357a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                boolean z = true;
                this.f57357a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f57357a.postNetData();
                if (!this.f57357a.getNetContext().getResponse().isNetSuccess()) {
                    fVar.f50454b = this.f57357a.getNetErrorCode();
                    fVar.f50455c = this.f57357a.getNetString();
                } else {
                    fVar.f50454b = this.f57357a.getServerErrorCode();
                    fVar.f50455c = this.f57357a.getErrorString();
                }
                if (this.f57357a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                    if (fVar.f50454b != 0) {
                        z = false;
                    }
                    fVar.f50453a = z;
                    return fVar;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            fVar.f50453a = false;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            d.b.c.a.e eVar = this.f57361e;
            if (eVar != null) {
                eVar.c(fVar);
            }
            d.b.i0.j1.m.a.a().d(this.f57359c, this.f57360d, fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f57357a != null) {
                this.f57357a.cancelNetConnect();
                this.f57357a = null;
            }
            super.cancel(true);
            d.b.c.a.e eVar = this.f57361e;
            if (eVar != null) {
                eVar.c(null);
            }
        }
    }

    @Override // d.b.h0.c.a, d.b.h0.c.d
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

    @Override // d.b.h0.c.a
    public String c() {
        return "post";
    }
}
