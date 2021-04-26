package d.a.j0.q1.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.FollowStatusService;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes3.dex */
public class b implements FollowStatusService {
    @Override // com.baidu.searchbox.live.interfaces.service.FollowStatusService
    public void saveFollowStatus(boolean z, String str, String str2) {
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f13330a = true;
        aVar.f13332c = str;
        aVar.f13333d = z;
        aVar.f13334e = true;
        MessageManager.getInstance().dispatchResponsedMessage(new UpdateAttentionMessage(aVar));
    }
}
