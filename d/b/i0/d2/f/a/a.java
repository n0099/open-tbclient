package d.b.i0.d2.f.a;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.pb.account.forbid.ForbidResultData;
import d.b.c.e.p.k;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f53714a = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;

    /* renamed from: d.b.i0.d2.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1197a extends BdAsyncTask<String, Object, ForbidResultData> {

        /* renamed from: a  reason: collision with root package name */
        public String f53715a;

        /* renamed from: b  reason: collision with root package name */
        public String f53716b;

        /* renamed from: c  reason: collision with root package name */
        public String f53717c;

        /* renamed from: d  reason: collision with root package name */
        public String f53718d;

        /* renamed from: e  reason: collision with root package name */
        public String f53719e;

        /* renamed from: f  reason: collision with root package name */
        public String f53720f;

        /* renamed from: g  reason: collision with root package name */
        public String f53721g;

        /* renamed from: h  reason: collision with root package name */
        public String f53722h;
        public String i;
        public WeakReference<b> j;

        public C1197a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
            this.f53715a = str;
            this.f53716b = str2;
            this.f53717c = str3;
            this.f53718d = str4;
            this.f53721g = str6;
            this.f53719e = str8;
            this.f53720f = str9;
            this.f53722h = str7;
            this.i = str5;
            this.j = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForbidResultData doInBackground(String... strArr) {
            NetWork netWork = new NetWork(a.f53714a);
            netWork.addPostData(Config.TRACE_VISIT_RECENT_DAY, this.f53721g);
            netWork.addPostData("un", this.f53718d);
            netWork.addPostData("fid", this.f53715a);
            netWork.addPostData("word", this.f53716b);
            netWork.addPostData("z", this.f53717c);
            netWork.addPostData("reason", this.f53722h);
            netWork.addPostData("ntn", "banid");
            netWork.addPostData("post_id", this.i);
            netWork.addPostData("nick_name", this.f53719e);
            netWork.addPostData("portrait", this.f53720f);
            netWork.getNetContext().getRequest().mIsNeedTbs = true;
            String postNetData = netWork.postNetData();
            if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                try {
                    return (ForbidResultData) OrmObject.objectWithJsonStr(postNetData, ForbidResultData.class);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = -1000;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = netWork.getServerErrorCode();
            forbidResultData2.error_msg = netWork.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.j.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && k.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        new C1197a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
    }
}
