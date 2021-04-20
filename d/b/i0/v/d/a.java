package d.b.i0.v.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.barselect.model.CandidateSearchHttpResMsg;
import com.baidu.tieba.barselect.model.CandidateSearchReqMsg;
import com.baidu.tieba.barselect.model.CandidateSearchSocketResMsg;
import d.b.h0.v0.b;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62963a;

    public a(TbPageContext tbPageContext) {
        this.f62963a = tbPageContext;
        b bVar = new b(309641);
        bVar.setResponsedClass(CandidateSearchSocketResMsg.class);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CANDIDATE_SEARCH, d.b.i0.d3.d0.a.a(TbConfig.URL_CANDIDATE_SEARCH, 309641));
        tbHttpMessageTask.setResponsedClass(CandidateSearchHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(int i, long j) {
        CandidateSearchReqMsg candidateSearchReqMsg = new CandidateSearchReqMsg();
        candidateSearchReqMsg.applyId = i;
        candidateSearchReqMsg.fid = j;
        candidateSearchReqMsg.setTag(this.f62963a.getUniqueId());
        MessageManager.getInstance().sendMessage(candidateSearchReqMsg);
    }
}
