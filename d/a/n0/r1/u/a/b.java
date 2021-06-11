package d.a.n0.r1.u.a;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService;
/* loaded from: classes3.dex */
public class b implements ThirdPartAliRechargeService {
    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService
    public String aliRecharge(Activity activity, String str, boolean z) {
        d.a.m0.d.a aVar = new d.a.m0.d.a();
        aVar.f52933a = activity;
        aVar.f52934b = str;
        aVar.f52935c = z;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921539, String.class, aVar);
        return runTask == null ? "" : (String) runTask.getData();
    }
}
