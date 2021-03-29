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
    public String f53343a = BarDetailForDirSwitch.BAR_DETAIL_DIR;

    /* renamed from: b  reason: collision with root package name */
    public a f53344b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f53345a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f53346b;

        /* renamed from: c  reason: collision with root package name */
        public long f53347c;

        /* renamed from: d  reason: collision with root package name */
        public String f53348d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f53349e;

        /* renamed from: f  reason: collision with root package name */
        public int f53350f;

        /* renamed from: g  reason: collision with root package name */
        public String f53351g;

        public b(String str, long j, String str2, a aVar, f0 f0Var, String str3) {
            this.f53346b = null;
            this.f53347c = 0L;
            this.f53349e = null;
            new WeakReference(f0Var);
            this.f53346b = str;
            this.f53347c = j;
            this.f53349e = new WeakReference<>(aVar);
            this.f53348d = str2;
            this.f53351g = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.f53347c != 0 && this.f53346b != null) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.f53345a = netWork;
                    netWork.addPostData("fid", String.valueOf(this.f53347c));
                    this.f53345a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f53346b);
                    this.f53345a.addPostData("favo_type", "1");
                    this.f53345a.addPostData("st_type", this.f53348d);
                    this.f53345a.addPostData("authsid", this.f53351g);
                    this.f53345a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f53345a.postNetData();
                    if (!d.b.b.e.p.k.isEmpty(postNetData)) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        this.f53350f = jSONObject.optInt("error_code");
                        jSONObject.optString("error_msg");
                        AuthTokenData.parse(jSONObject);
                    }
                    if (this.f53345a.getNetContext().getResponse().isRequestSuccess()) {
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
            if (this.f53349e != null) {
                d.b.i0.c3.q0.e eVar = new d.b.i0.c3.q0.e();
                eVar.f53594a = this.f53347c;
                a aVar = this.f53349e.get();
                if (aVar == null) {
                    return;
                }
                if (num.intValue() == 1 && (netWork = this.f53345a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                    TbadkCoreApplication.getInst().delLikeForum(this.f53346b);
                    aVar.b(this.f53346b, this.f53347c);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f53347c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f53346b));
                    eVar.f53595b = true;
                } else {
                    eVar.f53595b = false;
                    NetWork netWork2 = this.f53345a;
                    if (netWork2 != null) {
                        String errorString = netWork2.isNetSuccess() ? this.f53345a.getErrorString() : this.f53345a.getNetException();
                        eVar.f53596c = errorString;
                        aVar.a(errorString, this.f53350f);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, eVar));
            }
        }
    }

    public void a(String str) {
        this.f53343a = str;
    }

    public void b(a aVar) {
        this.f53344b = aVar;
    }

    public void c(String str, long j) {
        new b(str, j, this.f53343a, this.f53344b, this, null).execute(new Integer[0]);
    }
}
