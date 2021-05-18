package d.a.k0.d2.f.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.pb.account.forbid.ForbidTplData;
import d.a.c.e.p.k;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f52618a = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* loaded from: classes4.dex */
    public static class a extends BdAsyncTask<String, Object, ForbidTplData> {

        /* renamed from: a  reason: collision with root package name */
        public String f52619a;

        /* renamed from: b  reason: collision with root package name */
        public String f52620b;

        /* renamed from: c  reason: collision with root package name */
        public InterfaceC1232b f52621c;

        public a(String str, String str2, InterfaceC1232b interfaceC1232b) {
            this.f52619a = str;
            this.f52620b = str2;
            this.f52621c = interfaceC1232b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidTplData doInBackground(String... strArr) {
            NetWork netWork = new NetWork(b.f52618a);
            netWork.addPostData("forum_id", this.f52619a);
            netWork.addPostData("user_id", this.f52620b);
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
            if (this.f52621c != null) {
                ForbidTplData.ErrorInfo errorInfo = forbidTplData.error;
                if (errorInfo.errno == 0 && k.isEmpty(errorInfo.errMsg)) {
                    this.f52621c.b(forbidTplData);
                } else {
                    this.f52621c.a(forbidTplData);
                }
            }
        }
    }

    /* renamed from: d.a.k0.d2.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1232b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void b(String str, String str2, InterfaceC1232b interfaceC1232b) {
        new a(str, str2, interfaceC1232b).execute(new String[0]);
    }
}
