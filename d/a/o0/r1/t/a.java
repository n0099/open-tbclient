package d.a.o0.r1.t;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService;
import com.baidu.tieba.medialive.thirdaccount.ThirdPartyAccountServiceImpl;
/* loaded from: classes4.dex */
public class a extends d.a.f0.b.b.a<ThirdPartAccountService> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.f0.b.b.a
    /* renamed from: a */
    public ThirdPartAccountService createService() throws ServiceNotFoundException {
        return new ThirdPartyAccountServiceImpl();
    }
}
