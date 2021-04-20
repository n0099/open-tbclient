package d.b.i0.q0.e2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.ResponseIncrForumAccessCountHttpMessage;
import com.baidu.tieba.frs.ResponseIncrForumAccessCountSocketMessage;
import com.baidu.tieba.frs.ResponseSetCommForumStateHttpMessage;
import com.baidu.tieba.frs.ResponseSetCommForumStateSocketMessage;
/* loaded from: classes4.dex */
public class i {
    public i() {
        a();
        b();
    }

    public final void a() {
        d.b.h0.v0.b h2 = d.b.i0.d3.d0.a.h(309360, ResponseIncrForumAccessCountSocketMessage.class, false, false);
        h2.setResponsedClass(ResponseIncrForumAccessCountSocketMessage.class);
        h2.g(true);
        h2.h(false);
        h2.f(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(h2);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_INCREASE_FORUM_ACCESS_COUNT, d.b.i0.d3.d0.a.a(TbConfig.INCR_FORUM_ACCESS_ACOUNT, 309360));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseIncrForumAccessCountHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void b() {
        d.b.h0.v0.b h2 = d.b.i0.d3.d0.a.h(309365, ResponseSetCommForumStateSocketMessage.class, false, false);
        h2.setResponsedClass(ResponseSetCommForumStateSocketMessage.class);
        h2.g(true);
        h2.h(false);
        h2.f(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(h2);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, d.b.i0.d3.d0.a.a(TbConfig.SET_COMMON_FORUM_STATE, 309365));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseSetCommForumStateHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
