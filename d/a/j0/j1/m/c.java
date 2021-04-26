package d.a.j0.j1.m;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import d.a.i0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c implements d.a.i0.c.e {
    @Override // d.a.i0.c.e
    public String a() {
        return TbConfig.FOLLOW_ADDRESS;
    }

    @Override // d.a.i0.c.e
    public void b(HashMap<String, String> hashMap, f fVar) {
        if (fVar == null || hashMap == null || hashMap.isEmpty()) {
            return;
        }
        UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
        aVar.f13330a = fVar.f48361a;
        aVar.f13331b = fVar.f48363c;
        aVar.f13333d = true;
        aVar.f13332c = hashMap.get("touid") == null ? "" : hashMap.get("touid");
        MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
    }
}
