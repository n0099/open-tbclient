package d.b.i0.c3;

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
    public String f53342a = BarDetailForDirSwitch.BAR_DETAIL_DIR;

    /* renamed from: b  reason: collision with root package name */
    public a f53343b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f53344a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f53345b;

        /* renamed from: c  reason: collision with root package name */
        public long f53346c;

        /* renamed from: d  reason: collision with root package name */
        public String f53347d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f53348e;

        /* renamed from: f  reason: collision with root package name */
        public int f53349f;

        /* renamed from: g  reason: collision with root package name */
        public String f53350g;

        public b(String str, long j, String str2, a aVar, f0 f0Var, String str3) {
            this.f53345b = null;
            this.f53346c = 0L;
            this.f53348e = null;
            new WeakReference(f0Var);
            this.f53345b = str;
            this.f53346c = j;
            this.f53348e = new WeakReference<>(aVar);
            this.f53347d = str2;
            this.f53350g = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.f53346c != 0 && this.f53345b != null) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.f53344a = netWork;
                    netWork.addPostData("fid", String.valueOf(this.f53346c));
                    this.f53344a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f53345b);
                    this.f53344a.addPostData("favo_type", "1");
                    this.f53344a.addPostData("st_type", this.f53347d);
                    this.f53344a.addPostData("authsid", this.f53350g);
                    this.f53344a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f53344a.postNetData();
                    if (!d.b.b.e.p.k.isEmpty(postNetData)) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        this.f53349f = jSONObject.optInt("error_code");
                        jSONObject.optString("error_msg");
                        AuthTokenData.parse(jSONObject);
                    }
                    if (this.f53344a.getNetContext().getResponse().isRequestSuccess()) {
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
            if (this.f53348e != null) {
                d.b.i0.c3.q0.e eVar = new d.b.i0.c3.q0.e();
                eVar.f53593a = this.f53346c;
                a aVar = this.f53348e.get();
                if (aVar == null) {
                    return;
                }
                if (num.intValue() == 1 && (netWork = this.f53344a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                    TbadkCoreApplication.getInst().delLikeForum(this.f53345b);
                    aVar.b(this.f53345b, this.f53346c);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f53346c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f53345b));
                    eVar.f53594b = true;
                } else {
                    eVar.f53594b = false;
                    NetWork netWork2 = this.f53344a;
                    if (netWork2 != null) {
                        String errorString = netWork2.isNetSuccess() ? this.f53344a.getErrorString() : this.f53344a.getNetException();
                        eVar.f53595c = errorString;
                        aVar.a(errorString, this.f53349f);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, eVar));
            }
        }
    }

    public void a(String str) {
        this.f53342a = str;
    }

    public void b(a aVar) {
        this.f53343b = aVar;
    }

    public void c(String str, long j) {
        new b(str, j, this.f53342a, this.f53343b, this, null).execute(new Integer[0]);
    }
}
