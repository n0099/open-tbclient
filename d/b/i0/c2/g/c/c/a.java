package d.b.i0.c2.g.c.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.net.zan.ChosenPbZanHttpResponse;
import com.baidu.tieba.pb.chosen.net.zan.ChosenPbZanSocketResponse;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import d.b.h0.v0.b;
/* loaded from: classes4.dex */
public class a {
    public a() {
        a();
        b();
    }

    public final void a() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, d.b.i0.c3.d0.a.a(TbConfig.FINE_PB_PRAISE, 309095));
        tbHttpMessageTask.setResponsedClass(ChosenPbZanHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public final void b() {
        b bVar = new b(309095);
        bVar.setResponsedClass(ChosenPbZanSocketResponse.class);
        bVar.g(true);
        bVar.h(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void c(PbChosenActivity pbChosenActivity, long j, long j2, long j3, int i) {
        ChosenZanNetMessage chosenZanNetMessage = new ChosenZanNetMessage();
        chosenZanNetMessage.setExcId(j);
        chosenZanNetMessage.setAction(i);
        chosenZanNetMessage.setThreadId(j2);
        chosenZanNetMessage.setPostId(j3);
        pbChosenActivity.sendMessage(chosenZanNetMessage);
    }
}
