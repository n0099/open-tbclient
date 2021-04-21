package d.b.j0.q1.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.FollowStatusService;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes3.dex */
public class b implements FollowStatusService {
    @Override // com.baidu.searchbox.live.interfaces.service.FollowStatusService
    public void saveFollowStatus(boolean z, String str, String str2) {
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f13362a = true;
        aVar.f13364c = str;
        aVar.f13365d = z;
        MessageManager.getInstance().dispatchResponsedMessage(new UpdateAttentionMessage(aVar));
    }
}
