package d.b.i0.d3;

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
/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public String f54785a = BarDetailForDirSwitch.BAR_DETAIL_DIR;

    /* renamed from: b  reason: collision with root package name */
    public a f54786b;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);
    }

    /* loaded from: classes3.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f54787a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f54788b;

        /* renamed from: c  reason: collision with root package name */
        public long f54789c;

        /* renamed from: d  reason: collision with root package name */
        public String f54790d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f54791e;

        /* renamed from: f  reason: collision with root package name */
        public int f54792f;

        /* renamed from: g  reason: collision with root package name */
        public String f54793g;

        public b(String str, long j, String str2, a aVar, f0 f0Var, String str3) {
            this.f54788b = null;
            this.f54789c = 0L;
            this.f54791e = null;
            new WeakReference(f0Var);
            this.f54788b = str;
            this.f54789c = j;
            this.f54791e = new WeakReference<>(aVar);
            this.f54790d = str2;
            this.f54793g = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.f54789c != 0 && this.f54788b != null) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.f54787a = netWork;
                    netWork.addPostData("fid", String.valueOf(this.f54789c));
                    this.f54787a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f54788b);
                    this.f54787a.addPostData("favo_type", "1");
                    this.f54787a.addPostData("st_type", this.f54790d);
                    this.f54787a.addPostData("authsid", this.f54793g);
                    this.f54787a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f54787a.postNetData();
                    if (!d.b.c.e.p.k.isEmpty(postNetData)) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        this.f54792f = jSONObject.optInt("error_code");
                        jSONObject.optString("error_msg");
                        AuthTokenData.parse(jSONObject);
                    }
                    if (this.f54787a.getNetContext().getResponse().isRequestSuccess()) {
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
            if (this.f54791e != null) {
                d.b.i0.d3.q0.e eVar = new d.b.i0.d3.q0.e();
                eVar.f55038a = this.f54789c;
                a aVar = this.f54791e.get();
                if (aVar == null) {
                    return;
                }
                if (num.intValue() == 1 && (netWork = this.f54787a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                    TbadkCoreApplication.getInst().delLikeForum(this.f54788b);
                    aVar.b(this.f54788b, this.f54789c);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f54789c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f54788b));
                    eVar.f55039b = true;
                } else {
                    eVar.f55039b = false;
                    NetWork netWork2 = this.f54787a;
                    if (netWork2 != null) {
                        String errorString = netWork2.isNetSuccess() ? this.f54787a.getErrorString() : this.f54787a.getNetException();
                        eVar.f55040c = errorString;
                        aVar.a(errorString, this.f54792f);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, eVar));
            }
        }
    }

    public void a(String str) {
        this.f54785a = str;
    }

    public void b(a aVar) {
        this.f54786b = aVar;
    }

    public void c(String str, long j) {
        new b(str, j, this.f54785a, this.f54786b, this, null).execute(new Integer[0]);
    }
}
