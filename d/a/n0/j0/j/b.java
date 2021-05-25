package d.a.n0.j0.j;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.HttpsConnSwitch;
import d.a.c.e.p.j;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                return null;
            }
            NetWork netWork = new NetWork("http://tiebac.baidu.com/empty.gif");
            netWork.getNetData();
            boolean isNetSuccess = netWork.isNetSuccess();
            NetWork netWork2 = new NetWork("https://tiebac.baidu.com/empty.gif");
            netWork2.getNetData();
            boolean isNetSuccess2 = netWork2.isNetSuccess();
            NetWork netWork3 = new NetWork("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
            netWork3.addPostData("is_success_http", String.valueOf(isNetSuccess ? 1 : 0));
            netWork3.addPostData("is_success_https", String.valueOf(isNetSuccess2 ? 1 : 0));
            netWork3.postNetData();
            TiebaStatic.log(new StatisticItem("c13734").param("obj_locate", 1).param("obj_type", isNetSuccess ? 1 : 0));
            TiebaStatic.log(new StatisticItem("c13734").param("obj_locate", 2).param("obj_type", isNetSuccess2 ? 1 : 0));
            return null;
        }
    }

    public static void a() {
        a aVar = new a();
        aVar.setPriority(1);
        aVar.execute(new Void[0]);
    }

    public static boolean b() {
        return j.z() && SwitchManager.getInstance().findType(HttpsConnSwitch.KEY) == 1;
    }
}
