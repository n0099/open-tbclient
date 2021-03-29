package d.b.i0.c2.k.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.SubmitPbShowTipHttpResponseMessage;
/* loaded from: classes4.dex */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52731a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b0.e f52732b;

    public m0(PbFragment pbFragment) {
        this.f52731a = pbFragment;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a() {
        d.b.i0.b0.e eVar = this.f52732b;
        if (eVar != null) {
            eVar.H();
        }
    }
}
