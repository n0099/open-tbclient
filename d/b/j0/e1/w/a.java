package d.b.j0.e1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f56013e;

    /* renamed from: f  reason: collision with root package name */
    public String f56014f;

    /* renamed from: g  reason: collision with root package name */
    public String f56015g;

    public a(String str, String str2, String str3) {
        this.f56013e = null;
        this.f56014f = null;
        this.f56015g = null;
        this.f56013e = str;
        this.f56014f = str2;
        this.f56015g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("obj", this.f56013e);
        netWork.addPostData("obj_tp", this.f56014f);
        netWork.addPostData("group_id", this.f56015g);
        netWork.postNetData();
    }
}
