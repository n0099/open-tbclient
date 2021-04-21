package d.b.j0.j1.m;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import d.b.i0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c implements d.b.i0.c.e {
    @Override // d.b.i0.c.e
    public String a() {
        return TbConfig.FOLLOW_ADDRESS;
    }

    @Override // d.b.i0.c.e
    public void b(HashMap<String, String> hashMap, f fVar) {
        if (fVar == null || hashMap == null || hashMap.isEmpty()) {
            return;
        }
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f13362a = fVar.f50789a;
        aVar.f13363b = fVar.f50791c;
        aVar.f13365d = true;
        aVar.f13364c = hashMap.get("touid") == null ? "" : hashMap.get("touid");
        MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
    }
}
