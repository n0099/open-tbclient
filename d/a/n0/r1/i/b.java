package d.a.n0.r1.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.FollowStatusService;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes3.dex */
public class b implements FollowStatusService {
    @Override // com.baidu.searchbox.live.interfaces.service.FollowStatusService
    public void saveFollowStatus(boolean z, String str, String str2) {
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f12574a = true;
        aVar.f12576c = str;
        aVar.f12577d = z;
        aVar.f12578e = true;
        MessageManager.getInstance().dispatchResponsedMessage(new UpdateAttentionMessage(aVar));
    }
}
