package d.a.n0.e3;

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
    public String f57652a = BarDetailForDirSwitch.BAR_DETAIL_DIR;

    /* renamed from: b  reason: collision with root package name */
    public a f57653b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f57654a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f57655b;

        /* renamed from: c  reason: collision with root package name */
        public long f57656c;

        /* renamed from: d  reason: collision with root package name */
        public String f57657d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f57658e;

        /* renamed from: f  reason: collision with root package name */
        public int f57659f;

        /* renamed from: g  reason: collision with root package name */
        public String f57660g;

        public b(String str, long j, String str2, a aVar, f0 f0Var, String str3) {
            this.f57655b = null;
            this.f57656c = 0L;
            this.f57658e = null;
            new WeakReference(f0Var);
            this.f57655b = str;
            this.f57656c = j;
            this.f57658e = new WeakReference<>(aVar);
            this.f57657d = str2;
            this.f57660g = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.f57656c != 0 && this.f57655b != null) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.f57654a = netWork;
                    netWork.addPostData("fid", String.valueOf(this.f57656c));
                    this.f57654a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f57655b);
                    this.f57654a.addPostData("favo_type", "1");
                    this.f57654a.addPostData("st_type", this.f57657d);
                    this.f57654a.addPostData("authsid", this.f57660g);
                    this.f57654a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f57654a.postNetData();
                    if (!d.a.c.e.p.k.isEmpty(postNetData)) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        this.f57659f = jSONObject.optInt("error_code");
                        jSONObject.optString("error_msg");
                        AuthTokenData.parse(jSONObject);
                    }
                    if (this.f57654a.getNetContext().getResponse().isRequestSuccess()) {
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
            if (this.f57658e != null) {
                d.a.n0.e3.q0.e eVar = new d.a.n0.e3.q0.e();
                eVar.f57912a = this.f57656c;
                a aVar = this.f57658e.get();
                if (aVar == null) {
                    return;
                }
                if (num.intValue() == 1 && (netWork = this.f57654a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                    TbadkCoreApplication.getInst().delLikeForum(this.f57655b);
                    aVar.b(this.f57655b, this.f57656c);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f57656c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f57655b));
                    eVar.f57913b = true;
                } else {
                    eVar.f57913b = false;
                    NetWork netWork2 = this.f57654a;
                    if (netWork2 != null) {
                        String errorString = netWork2.isNetSuccess() ? this.f57654a.getErrorString() : this.f57654a.getNetException();
                        eVar.f57914c = errorString;
                        aVar.a(errorString, this.f57659f);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, eVar));
            }
        }
    }

    public void a(String str) {
        this.f57652a = str;
    }

    public void b(a aVar) {
        this.f57653b = aVar;
    }

    public void c(String str, long j) {
        new b(str, j, this.f57652a, this.f57653b, this, null).execute(new Integer[0]);
    }
}
