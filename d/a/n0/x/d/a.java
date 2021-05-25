package d.a.n0.x.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.barselect.model.CandidateSearchHttpResMsg;
import com.baidu.tieba.barselect.model.CandidateSearchReqMsg;
import com.baidu.tieba.barselect.model.CandidateSearchSocketResMsg;
import d.a.m0.v0.b;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63200a;

    public a(TbPageContext tbPageContext) {
        this.f63200a = tbPageContext;
        b bVar = new b(309641);
        bVar.setResponsedClass(CandidateSearchSocketResMsg.class);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CANDIDATE_SEARCH, d.a.n0.e3.d0.a.a(TbConfig.URL_CANDIDATE_SEARCH, 309641));
        tbHttpMessageTask.setResponsedClass(CandidateSearchHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(int i2, long j) {
        CandidateSearchReqMsg candidateSearchReqMsg = new CandidateSearchReqMsg();
        candidateSearchReqMsg.applyId = i2;
        candidateSearchReqMsg.fid = j;
        candidateSearchReqMsg.setTag(this.f63200a.getUniqueId());
        MessageManager.getInstance().sendMessage(candidateSearchReqMsg);
    }
}
