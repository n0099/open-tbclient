package d.a.o0.k1.m;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import d.a.n0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c implements d.a.n0.c.e {
    @Override // d.a.n0.c.e
    public String a() {
        return TbConfig.FOLLOW_ADDRESS;
    }

    @Override // d.a.n0.c.e
    public void b(HashMap<String, String> hashMap, f fVar) {
        if (fVar == null || hashMap == null || hashMap.isEmpty()) {
            return;
        }
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f12718a = fVar.f52995a;
        aVar.f12719b = fVar.f52997c;
        aVar.f12721d = true;
        aVar.f12720c = hashMap.get("touid") == null ? "" : hashMap.get("touid");
        MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
    }
}
