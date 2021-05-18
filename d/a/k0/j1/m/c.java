package d.a.k0.j1.m;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import d.a.j0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c implements d.a.j0.c.e {
    @Override // d.a.j0.c.e
    public String a() {
        return TbConfig.FOLLOW_ADDRESS;
    }

    @Override // d.a.j0.c.e
    public void b(HashMap<String, String> hashMap, f fVar) {
        if (fVar == null || hashMap == null || hashMap.isEmpty()) {
            return;
        }
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f12666a = fVar.f49189a;
        aVar.f12667b = fVar.f49191c;
        aVar.f12669d = true;
        aVar.f12668c = hashMap.get("touid") == null ? "" : hashMap.get("touid");
        MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
    }
}
