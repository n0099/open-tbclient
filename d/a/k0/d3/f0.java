package d.a.k0.d3;

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
    public String f53750a = BarDetailForDirSwitch.BAR_DETAIL_DIR;

    /* renamed from: b  reason: collision with root package name */
    public a f53751b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, long j);

        void b(String str, long j);
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f53752a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f53753b;

        /* renamed from: c  reason: collision with root package name */
        public long f53754c;

        /* renamed from: d  reason: collision with root package name */
        public String f53755d;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f53756e;

        /* renamed from: f  reason: collision with root package name */
        public int f53757f;

        /* renamed from: g  reason: collision with root package name */
        public String f53758g;

        public b(String str, long j, String str2, a aVar, f0 f0Var, String str3) {
            this.f53753b = null;
            this.f53754c = 0L;
            this.f53756e = null;
            new WeakReference(f0Var);
            this.f53753b = str;
            this.f53754c = j;
            this.f53756e = new WeakReference<>(aVar);
            this.f53755d = str2;
            this.f53758g = str3;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.f53754c != 0 && this.f53753b != null) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.f53752a = netWork;
                    netWork.addPostData("fid", String.valueOf(this.f53754c));
                    this.f53752a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f53753b);
                    this.f53752a.addPostData("favo_type", "1");
                    this.f53752a.addPostData("st_type", this.f53755d);
                    this.f53752a.addPostData("authsid", this.f53758g);
                    this.f53752a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.f53752a.postNetData();
                    if (!d.a.c.e.p.k.isEmpty(postNetData)) {
                        JSONObject jSONObject = new JSONObject(postNetData);
                        this.f53757f = jSONObject.optInt("error_code");
                        jSONObject.optString("error_msg");
                        AuthTokenData.parse(jSONObject);
                    }
                    if (this.f53752a.getNetContext().getResponse().isRequestSuccess()) {
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
            if (this.f53756e != null) {
                d.a.k0.d3.q0.e eVar = new d.a.k0.d3.q0.e();
                eVar.f54010a = this.f53754c;
                a aVar = this.f53756e.get();
                if (aVar == null) {
                    return;
                }
                if (num.intValue() == 1 && (netWork = this.f53752a) != null && netWork.getNetContext().getResponse().isRequestSuccess()) {
                    TbadkCoreApplication.getInst().delLikeForum(this.f53753b);
                    aVar.b(this.f53753b, this.f53754c);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.f53754c)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f53753b));
                    eVar.f54011b = true;
                } else {
                    eVar.f54011b = false;
                    NetWork netWork2 = this.f53752a;
                    if (netWork2 != null) {
                        String errorString = netWork2.isNetSuccess() ? this.f53752a.getErrorString() : this.f53752a.getNetException();
                        eVar.f54012c = errorString;
                        aVar.a(errorString, this.f53757f);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, eVar));
            }
        }
    }

    public void a(String str) {
        this.f53750a = str;
    }

    public void b(a aVar) {
        this.f53751b = aVar;
    }

    public void c(String str, long j) {
        new b(str, j, this.f53750a, this.f53751b, this, null).execute(new Integer[0]);
    }
}
