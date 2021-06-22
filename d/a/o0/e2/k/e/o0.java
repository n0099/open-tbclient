package d.a.o0.e2.k.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.SubmitPbShowTipHttpResponseMessage;
/* loaded from: classes5.dex */
public class o0 {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f57215a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.d0.e f57216b;

    public o0(PbFragment pbFragment) {
        this.f57215a = pbFragment;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a() {
        d.a.o0.d0.e eVar = this.f57216b;
        if (eVar != null) {
            eVar.I();
        }
    }
}
