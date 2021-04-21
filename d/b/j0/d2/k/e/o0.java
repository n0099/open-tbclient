package d.b.j0.d2.k.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.SubmitPbShowTipHttpResponseMessage;
/* loaded from: classes3.dex */
public class o0 {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f54637a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.b0.e f54638b;

    public o0(PbFragment pbFragment) {
        this.f54637a = pbFragment;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a() {
        d.b.j0.b0.e eVar = this.f54638b;
        if (eVar != null) {
            eVar.H();
        }
    }
}
