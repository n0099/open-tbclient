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
    public String f53963a = BarDetailForDirSwitch.BAR_DETAIL_DIR;

    /* renamed from: b  reason: collision with root package name */
    public a f53964b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f53965a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f53966b;

        /* renamed from: c  reason: collision with root package name */
        public long f53967c;

        /* renamed from: d  reason: collision with root package name */
        public String f53968d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f53969e;

        /* renamed from: f  reason: collision with root package name */
        public int f53970f;

        /* renamed from: g  reason: collision with root package name */
        public String f53971g;

        public b(String str, long j, String str2, a aVar, f0 f0Var, String str3) {
            this.f53966b = null;
            this.f53967c = 0L;
            this.f53969e = null;
            new WeakReference(f0Var);
            this.f53966b = str;
            this.f53967c = j;
            this.f53969e = new WeakReference<>(aVar);
            this.f53968d = str2;
            this.f53971g = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.f53967c != 0 && this.f53966b != null) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.f53965a = netWork;
                    netWork.addPostData("fid", String.valueOf(this.f53967c));
                    this.f53965a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f53966b);
                    this.f53965a.addPostData("favo_type", "1");
                    this.f53965a.addPostData("st_type", this.f53968d);
                    this.f53965a.addPostData("authsid", this.f53971g);
                    this.f53965a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f53965a.postNetData();
                    if (!d.a.c.e.p.k.isEmpty(postNetData)) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        this.f53970f = jSONObject.optInt("error_code");
                        jSONObject.optString("error_msg");
                        AuthTokenData.parse(jSONObject);
                    }
                    if (this.f53965a.getNetContext().getResponse().isRequestSuccess()) {
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
            if (this.f53969e != null) {
                d.a.n0.e3.q0.e eVar = new d.a.n0.e3.q0.e();
                eVar.f54223a = this.f53967c;
                a aVar = this.f53969e.get();
                if (aVar == null) {
                    return;
                }
                if (num.intValue() == 1 && (netWork = this.f53965a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                    TbadkCoreApplication.getInst().delLikeForum(this.f53966b);
                    aVar.b(this.f53966b, this.f53967c);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f53967c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f53966b));
                    eVar.f54224b = true;
                } else {
                    eVar.f54224b = false;
                    NetWork netWork2 = this.f53965a;
                    if (netWork2 != null) {
                        String errorString = netWork2.isNetSuccess() ? this.f53965a.getErrorString() : this.f53965a.getNetException();
                        eVar.f54225c = errorString;
                        aVar.a(errorString, this.f53970f);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, eVar));
            }
        }
    }

    public void a(String str) {
        this.f53963a = str;
    }

    public void b(a aVar) {
        this.f53964b = aVar;
    }

    public void c(String str, long j) {
        new b(str, j, this.f53963a, this.f53964b, this, null).execute(new Integer[0]);
    }
}
