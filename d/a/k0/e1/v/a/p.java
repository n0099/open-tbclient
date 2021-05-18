package d.a.k0.e1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestSearchGroupsLocalMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupLocalMessage;
import d.a.c.e.d.l;
import java.util.List;
/* loaded from: classes4.dex */
public class p implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestSearchGroupsLocalMessage)) {
            return null;
        }
        List<l.b<String>> b2 = d.a.c.e.p.p.b(d.a.j0.r.r.a.f().g("tb.im_group_search_history"));
        ResponseSearchGroupLocalMessage responseSearchGroupLocalMessage = new ResponseSearchGroupLocalMessage();
        responseSearchGroupLocalMessage.setCacheList(b2);
        return responseSearchGroupLocalMessage;
    }
}
