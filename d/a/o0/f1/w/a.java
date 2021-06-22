package d.a.o0.f1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f58592e;

    /* renamed from: f  reason: collision with root package name */
    public String f58593f;

    /* renamed from: g  reason: collision with root package name */
    public String f58594g;

    public a(String str, String str2, String str3) {
        this.f58592e = null;
        this.f58593f = null;
        this.f58594g = null;
        this.f58592e = str;
        this.f58593f = str2;
        this.f58594g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("obj", this.f58592e);
        netWork.addPostData("obj_tp", this.f58593f);
        netWork.addPostData("group_id", this.f58594g);
        netWork.postNetData();
    }
}
