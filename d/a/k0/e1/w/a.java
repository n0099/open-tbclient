package d.a.k0.e1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f54588e;

    /* renamed from: f  reason: collision with root package name */
    public String f54589f;

    /* renamed from: g  reason: collision with root package name */
    public String f54590g;

    public a(String str, String str2, String str3) {
        this.f54588e = null;
        this.f54589f = null;
        this.f54590g = null;
        this.f54588e = str;
        this.f54589f = str2;
        this.f54590g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("obj", this.f54588e);
        netWork.addPostData("obj_tp", this.f54589f);
        netWork.addPostData("group_id", this.f54590g);
        netWork.postNetData();
    }
}
