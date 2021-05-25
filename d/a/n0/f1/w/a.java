package d.a.n0.f1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f54778e;

    /* renamed from: f  reason: collision with root package name */
    public String f54779f;

    /* renamed from: g  reason: collision with root package name */
    public String f54780g;

    public a(String str, String str2, String str3) {
        this.f54778e = null;
        this.f54779f = null;
        this.f54780g = null;
        this.f54778e = str;
        this.f54779f = str2;
        this.f54780g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("obj", this.f54778e);
        netWork.addPostData("obj_tp", this.f54779f);
        netWork.addPostData("group_id", this.f54780g);
        netWork.postNetData();
    }
}
