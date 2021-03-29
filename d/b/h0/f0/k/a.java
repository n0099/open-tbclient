package d.b.h0.f0.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import d.b.h0.f0.b;
import d.b.i0.c3.h0.e;
/* loaded from: classes3.dex */
public class a implements b<AgreeEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.f0.b
    /* renamed from: a */
    public boolean onEvent(AgreeEvent agreeEvent) {
        if (agreeEvent != null && agreeEvent.agreeData != null) {
            e eVar = new e();
            eVar.f53377b = agreeEvent.agreeData;
            String str = agreeEvent.agreeExtra;
            if (AgreeEvent.IS_THREAD.equals(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
                return true;
            } else if (AgreeEvent.IS_POST.equals(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, eVar));
                return true;
            }
        }
        return false;
    }
}
