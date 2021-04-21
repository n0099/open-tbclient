package d.b.j0.d3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public String f55206a = BarDetailForDirSwitch.BAR_DETAIL_DIR;

    /* renamed from: b  reason: collision with root package name */
    public a f55207b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f55208a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f55209b;

        /* renamed from: c  reason: collision with root package name */
        public long f55210c;

        /* renamed from: d  reason: collision with root package name */
        public String f55211d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f55212e;

        /* renamed from: f  reason: collision with root package name */
        public int f55213f;

        /* renamed from: g  reason: collision with root package name */
        public String f55214g;

        public b(String str, long j, String str2, a aVar, f0 f0Var, String str3) {
            this.f55209b = null;
            this.f55210c = 0L;
            this.f55212e = null;
            new WeakReference(f0Var);
            this.f55209b = str;
            this.f55210c = j;
            this.f55212e = new WeakReference<>(aVar);
            this.f55211d = str2;
            this.f55214g = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.f55210c != 0 && this.f55209b != null) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.f55208a = netWork;
                    netWork.addPostData("fid", String.valueOf(this.f55210c));
                    this.f55208a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f55209b);
                    this.f55208a.addPostData("favo_type", "1");
                    this.f55208a.addPostData("st_type", this.f55211d);
                    this.f55208a.addPostData("authsid", this.f55214g);
                    this.f55208a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f55208a.postNetData();
                    if (!d.b.c.e.p.k.isEmpty(postNetData)) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        this.f55213f = jSONObject.optInt("error_code");
                        jSONObject.optString("error_msg");
                        AuthTokenData.parse(jSONObject);
                    }
                    if (this.f55208a.getNetContext().getResponse().isRequestSuccess()) {
                        return 1;
                    }
                }
                return 0;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            NetWork netWork;
            super.onPostExecute((b) num);
            if (this.f55212e != null) {
                d.b.j0.d3.q0.e eVar = new d.b.j0.d3.q0.e();
                eVar.f55459a = this.f55210c;
                a aVar = this.f55212e.get();
                if (aVar == null) {
                    return;
                }
                if (num.intValue() == 1 && (netWork = this.f55208a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                    TbadkCoreApplication.getInst().delLikeForum(this.f55209b);
                    aVar.b(this.f55209b, this.f55210c);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f55210c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f55209b));
                    eVar.f55460b = true;
                } else {
                    eVar.f55460b = false;
                    NetWork netWork2 = this.f55208a;
                    if (netWork2 != null) {
                        String errorString = netWork2.isNetSuccess() ? this.f55208a.getErrorString() : this.f55208a.getNetException();
                        eVar.f55461c = errorString;
                        aVar.a(errorString, this.f55213f);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, eVar));
            }
        }
    }

    public void a(String str) {
        this.f55206a = str;
    }

    public void b(a aVar) {
        this.f55207b = aVar;
    }

    public void c(String str, long j) {
        new b(str, j, this.f55206a, this.f55207b, this, null).execute(new Integer[0]);
    }
}
