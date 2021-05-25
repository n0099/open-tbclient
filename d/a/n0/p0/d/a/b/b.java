package d.a.n0.p0.d.a.b;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.forumMember.tbtitle.model.cache.GetLevelInfoReadCacheResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoReadCacheRequestMessage;
/* loaded from: classes4.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GetLevelInfoReadCacheRequestMessage)) {
            return null;
        }
        byte[] a2 = new a().a(((GetLevelInfoReadCacheRequestMessage) customMessage).getCacheKey());
        GetLevelInfoReadCacheResponsedMessage getLevelInfoReadCacheResponsedMessage = new GetLevelInfoReadCacheResponsedMessage();
        try {
            getLevelInfoReadCacheResponsedMessage.decodeInBackGround(2003007, a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return getLevelInfoReadCacheResponsedMessage;
    }
}
