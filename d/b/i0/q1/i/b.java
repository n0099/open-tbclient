package d.b.i0.q1.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.FollowStatusService;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes3.dex */
public class b implements FollowStatusService {
    @Override // com.baidu.searchbox.live.interfaces.service.FollowStatusService
    public void saveFollowStatus(boolean z, String str, String str2) {
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f13354a = true;
        aVar.f13356c = str;
        aVar.f13357d = z;
        MessageManager.getInstance().dispatchResponsedMessage(new UpdateAttentionMessage(aVar));
    }
}
