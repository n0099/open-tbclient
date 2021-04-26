package d.a.j0.e1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f53881e;

    /* renamed from: f  reason: collision with root package name */
    public String f53882f;

    /* renamed from: g  reason: collision with root package name */
    public String f53883g;

    public a(String str, String str2, String str3) {
        this.f53881e = null;
        this.f53882f = null;
        this.f53883g = null;
        this.f53881e = str;
        this.f53882f = str2;
        this.f53883g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("obj", this.f53881e);
        netWork.addPostData("obj_tp", this.f53882f);
        netWork.addPostData("group_id", this.f53883g);
        netWork.postNetData();
    }
}
