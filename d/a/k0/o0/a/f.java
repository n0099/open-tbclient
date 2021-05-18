package d.a.k0.o0.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoReadCacheRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamReadCacheResponseMessage;
/* loaded from: classes4.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof BawuTeamInfoReadCacheRequestMessage)) {
            return null;
        }
        byte[] a2 = new d().a(((BawuTeamInfoReadCacheRequestMessage) customMessage).getCacheKey());
        BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = new BawuTeamReadCacheResponseMessage();
        try {
            bawuTeamReadCacheResponseMessage.decodeInBackGround(2003005, a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bawuTeamReadCacheResponseMessage;
    }
}
