package d.a.o0.r1.n;

import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.service.NetworkAgentService;
/* loaded from: classes3.dex */
public class b implements NetworkAgentService {
    @Override // com.baidu.searchbox.live.interfaces.service.NetworkAgentService
    public INetWork buildNetworkInstance() {
        return new c();
    }
}
