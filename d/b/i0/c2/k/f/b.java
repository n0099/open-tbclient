package d.b.i0.c2.k.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.report.UEGReportRequestMessage;
import com.baidu.tieba.pb.pb.report.UEGReportResponsedMessage;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f53027a;

    public b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UEG_REPORT, TbConfig.SERVER_ADDRESS + TbConfig.URL_UEG_REPORT);
        tbHttpMessageTask.setResponsedClass(UEGReportResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str) {
        UEGReportRequestMessage uEGReportRequestMessage = new UEGReportRequestMessage();
        uEGReportRequestMessage.setTag(this.f53027a);
        uEGReportRequestMessage.setPid(str);
        MessageManager.getInstance().sendMessage(uEGReportRequestMessage);
    }

    public void b(String str) {
        UEGReportRequestMessage uEGReportRequestMessage = new UEGReportRequestMessage();
        uEGReportRequestMessage.setTag(this.f53027a);
        uEGReportRequestMessage.setTUid(str);
        MessageManager.getInstance().sendMessage(uEGReportRequestMessage);
    }

    public void c(BdUniqueId bdUniqueId) {
        this.f53027a = bdUniqueId;
    }
}
