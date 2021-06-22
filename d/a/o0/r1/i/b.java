package d.a.o0.r1.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.FollowStatusService;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes3.dex */
public class b implements FollowStatusService {
    @Override // com.baidu.searchbox.live.interfaces.service.FollowStatusService
    public void saveFollowStatus(boolean z, String str, String str2) {
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f12718a = true;
        aVar.f12720c = str;
        aVar.f12721d = z;
        aVar.f12722e = true;
        MessageManager.getInstance().dispatchResponsedMessage(new UpdateAttentionMessage(aVar));
    }
}
