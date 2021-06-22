package d.a.o0.j0;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
/* loaded from: classes4.dex */
public class b {
    public static void a(TbPageContext<?> tbPageContext, String str) {
        ForumSquareActivityConfig forumSquareActivityConfig;
        if (tbPageContext == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity(), str);
        } else {
            forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity());
        }
        tbPageContext.sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
    }
}
