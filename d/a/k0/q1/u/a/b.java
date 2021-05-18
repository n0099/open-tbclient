package d.a.k0.q1.u.a;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService;
/* loaded from: classes3.dex */
public class b implements ThirdPartAliRechargeService {
    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService
    public String aliRecharge(Activity activity, String str, boolean z) {
        d.a.j0.d.a aVar = new d.a.j0.d.a();
        aVar.f49215a = activity;
        aVar.f49216b = str;
        aVar.f49217c = z;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921539, String.class, aVar);
        return runTask == null ? "" : (String) runTask.getData();
    }
}
