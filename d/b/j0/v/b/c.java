package d.b.j0.v.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.barselect.data.CommitCardInfoHttpResMsg;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import com.baidu.tieba.barselect.data.CommitCardInfoSocketResMsg;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63334a;

    public c(TbPageContext tbPageContext) {
        this.f63334a = tbPageContext;
        SocketMessageTask socketMessageTask = new SocketMessageTask(309643);
        socketMessageTask.setResponsedClass(CommitCardInfoSocketResMsg.class);
        MessageManager.getInstance().registerTask(socketMessageTask);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMMIT_CARD_INFO, d.b.j0.d3.d0.a.a(TbConfig.URL_COMMIT_CARD_INFO, 309643));
        tbHttpMessageTask.setResponsedClass(CommitCardInfoHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, int i, String str2) {
        CommitCardInfoReqMsg commitCardInfoReqMsg = new CommitCardInfoReqMsg();
        commitCardInfoReqMsg.resource_id = str;
        commitCardInfoReqMsg.card_type = i;
        commitCardInfoReqMsg.image_info = str2;
        commitCardInfoReqMsg.setTag(this.f63334a.getUniqueId());
        MessageManager.getInstance().sendMessage(commitCardInfoReqMsg);
    }
}
