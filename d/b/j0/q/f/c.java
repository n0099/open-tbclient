package d.b.j0.q.f;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import d.b.c.e.p.k;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof GetContactListRequestMessage)) {
            return null;
        }
        List<d.b.i0.s.f.a> e2 = f.f().e();
        if (e2 != null) {
            Iterator<d.b.i0.s.f.a> it = e2.iterator();
            while (it.hasNext()) {
                d.b.i0.s.f.a next = it.next();
                if ((k.isEmpty(next.f()) && k.isEmpty(next.g())) || next.i() == 1) {
                    it.remove();
                }
            }
        }
        GetContactListResponsedMessage getContactListResponsedMessage = new GetContactListResponsedMessage();
        getContactListResponsedMessage.setContacts(e2);
        return getContactListResponsedMessage;
    }
}
