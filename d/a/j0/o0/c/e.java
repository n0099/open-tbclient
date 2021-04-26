package d.a.j0.o0.c;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheRequestMessage;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheResponseMessage;
/* loaded from: classes4.dex */
public class e implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage instanceof ForumMemberReadCacheRequestMessage) {
            byte[] a2 = new c().a(((ForumMemberReadCacheRequestMessage) customMessage).getForumName());
            ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = new ForumMemberReadCacheResponseMessage();
            try {
                forumMemberReadCacheResponseMessage.decodeInBackGround(2003009, a2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return forumMemberReadCacheResponseMessage;
        }
        return null;
    }
}
