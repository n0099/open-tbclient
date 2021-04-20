package d.b.i0.e1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f55592e;

    /* renamed from: f  reason: collision with root package name */
    public String f55593f;

    /* renamed from: g  reason: collision with root package name */
    public String f55594g;

    public a(String str, String str2, String str3) {
        this.f55592e = null;
        this.f55593f = null;
        this.f55594g = null;
        this.f55592e = str;
        this.f55593f = str2;
        this.f55594g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("obj", this.f55592e);
        netWork.addPostData("obj_tp", this.f55593f);
        netWork.addPostData("group_id", this.f55594g);
        netWork.postNetData();
    }
}
