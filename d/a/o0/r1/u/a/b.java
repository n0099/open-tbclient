package d.a.o0.r1.u.a;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService;
/* loaded from: classes4.dex */
public class b implements ThirdPartAliRechargeService {
    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService
    public String aliRecharge(Activity activity, String str, boolean z) {
        d.a.n0.d.a aVar = new d.a.n0.d.a();
        aVar.f53040a = activity;
        aVar.f53041b = str;
        aVar.f53042c = z;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921539, String.class, aVar);
        return runTask == null ? "" : (String) runTask.getData();
    }
}
