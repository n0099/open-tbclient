package d.a.n0.r1.k;

import com.baidu.searchbox.live.interfaces.like.ILiveLikeView;
import com.baidu.searchbox.live.interfaces.like.LiveLikeProxyService;
/* loaded from: classes3.dex */
public class b implements LiveLikeProxyService {
    @Override // com.baidu.searchbox.live.interfaces.like.LiveLikeProxyService
    public ILiveLikeView buildLikeViewInstance() {
        return new c();
    }
}
