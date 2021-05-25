package d.a.n0.e2.g.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.net.ChosenPbHttpResponse;
import com.baidu.tieba.pb.chosen.net.ChosenPbNetMessage;
import com.baidu.tieba.pb.chosen.net.ChosenPbSocketResponse;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class b {
    public b() {
        b();
        a();
    }

    public final void a() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FINE_PB, d.a.n0.e3.d0.a.a(TbConfig.FINE_PB_PAGE, 309093));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void b() {
        d.a.m0.v0.b bVar = new d.a.m0.v0.b(309093);
        bVar.setResponsedClass(ChosenPbSocketResponse.class);
        bVar.g(true);
        bVar.h(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void c(PbChosenActivity pbChosenActivity, long j, long j2, long j3) {
        ChosenPbNetMessage chosenPbNetMessage = new ChosenPbNetMessage();
        int k = l.k(pbChosenActivity.getPageContext().getPageActivity());
        int i2 = l.i(pbChosenActivity.getPageContext().getPageActivity());
        float h2 = l.h(pbChosenActivity.getPageContext().getPageActivity());
        chosenPbNetMessage.setQ_type(45L);
        chosenPbNetMessage.setScrH(i2);
        chosenPbNetMessage.setScrW(k);
        chosenPbNetMessage.setScr_dip(h2);
        chosenPbNetMessage.setExcId(j);
        chosenPbNetMessage.setTagCode(j2);
        chosenPbNetMessage.setThreadId(j3);
        pbChosenActivity.sendMessage(chosenPbNetMessage);
    }
}
