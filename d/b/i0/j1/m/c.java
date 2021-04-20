package d.b.i0.j1.m;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import d.b.h0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c implements d.b.h0.c.e {
    @Override // d.b.h0.c.e
    public String a() {
        return TbConfig.FOLLOW_ADDRESS;
    }

    @Override // d.b.h0.c.e
    public void b(HashMap<String, String> hashMap, f fVar) {
        if (fVar == null || hashMap == null || hashMap.isEmpty()) {
            return;
        }
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f13354a = fVar.f50453a;
        aVar.f13355b = fVar.f50455c;
        aVar.f13357d = true;
        aVar.f13356c = hashMap.get("touid") == null ? "" : hashMap.get("touid");
        MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
    }
}
