package d.a.n0.r1.t;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService;
import com.baidu.tieba.medialive.thirdaccount.ThirdPartyAccountServiceImpl;
/* loaded from: classes3.dex */
public class a extends d.a.e0.b.b.a<ThirdPartAccountService> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.e0.b.b.a
    /* renamed from: a */
    public ThirdPartAccountService createService() throws ServiceNotFoundException {
        return new ThirdPartyAccountServiceImpl();
    }
}
