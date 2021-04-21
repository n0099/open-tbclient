package d.b.j0.q1.m;

import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.service.NetworkAgentService;
/* loaded from: classes3.dex */
public class b implements NetworkAgentService {
    @Override // com.baidu.searchbox.live.interfaces.service.NetworkAgentService
    public INetWork buildNetworkInstance() {
        return new c();
    }
}
