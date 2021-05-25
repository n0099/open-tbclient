package d.a.n0.w2.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.setting.forbiddenforum.CancelForbiddenForumResMsg;
/* loaded from: classes5.dex */
public class a {
    public a() {
        b();
    }

    public void a(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM);
        httpMessage.addParam("forum_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM, TbConfig.SERVER_ADDRESS + TbConfig.URL_CANCEL_FORBIDDEN_FORUM);
        tbHttpMessageTask.setResponsedClass(CancelForbiddenForumResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
