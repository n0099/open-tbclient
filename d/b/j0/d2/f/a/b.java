package d.b.j0.d2.f.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.pb.account.forbid.ForbidTplData;
import d.b.c.e.p.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f54144a = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<String, Object, ForbidTplData> {

        /* renamed from: a  reason: collision with root package name */
        public String f54145a;

        /* renamed from: b  reason: collision with root package name */
        public String f54146b;

        /* renamed from: c  reason: collision with root package name */
        public InterfaceC1221b f54147c;

        public a(String str, String str2, InterfaceC1221b interfaceC1221b) {
            this.f54145a = str;
            this.f54146b = str2;
            this.f54147c = interfaceC1221b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidTplData doInBackground(String... strArr) {
            NetWork netWork = new NetWork(b.f54144a);
            netWork.addPostData("forum_id", this.f54145a);
            netWork.addPostData("user_id", this.f54146b);
            String postNetData = netWork.postNetData();
            if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(postNetData, ForbidTplData.class);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = -1000;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = netWork.getServerErrorCode();
            forbidTplData2.error.errMsg = netWork.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            if (this.f54147c != null) {
                ForbidTplData.ErrorInfo errorInfo = forbidTplData.error;
                if (errorInfo.errno == 0 && k.isEmpty(errorInfo.errMsg)) {
                    this.f54147c.a(forbidTplData);
                } else {
                    this.f54147c.b(forbidTplData);
                }
            }
        }
    }

    /* renamed from: d.b.j0.d2.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1221b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void b(String str, String str2, InterfaceC1221b interfaceC1221b) {
        new a(str, str2, interfaceC1221b).execute(new String[0]);
    }
}
