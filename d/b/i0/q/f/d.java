package d.b.i0.q.f;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class d implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        boolean d2;
        if (customMessage == null) {
            return null;
        }
        int cmd = customMessage.getCmd();
        if (customMessage.getData() != null && (cmd == 2001179 || cmd == 2001180)) {
            d.b.h0.s.f.a aVar = (d.b.h0.s.f.a) customMessage.getData();
            if (cmd == 2001179) {
                d2 = f.f().a(aVar);
            } else {
                d2 = f.f().d(aVar.e());
            }
            if (!d2) {
                d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
                i.s("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
        return null;
    }
}
