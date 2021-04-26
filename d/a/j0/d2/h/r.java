package d.a.j0.d2.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishReqMessage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52070a;

    public r(TbPageContext tbPageContext) {
        this.f52070a = tbPageContext;
        SocketMessageTask socketMessageTask = new SocketMessageTask(309644);
        socketMessageTask.setResponsedClass(ThreadPublishSocketResMessage.class);
        MessageManager.getInstance().registerTask(socketMessageTask);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, d.a.j0.d3.d0.a.a(TbConfig.URL_THREAD_PUBLISH, 309644));
        tbHttpMessageTask.setResponsedClass(ThreadPublishHttpResMeesage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(long j, long j2) {
        ThreadPublishReqMessage threadPublishReqMessage = new ThreadPublishReqMessage();
        threadPublishReqMessage.tid = j;
        threadPublishReqMessage.fid = j2;
        threadPublishReqMessage.setTag(this.f52070a.getUniqueId());
        MessageManager.getInstance().sendMessage(threadPublishReqMessage);
    }
}
