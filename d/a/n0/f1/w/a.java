package d.a.n0.f1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f58467e;

    /* renamed from: f  reason: collision with root package name */
    public String f58468f;

    /* renamed from: g  reason: collision with root package name */
    public String f58469g;

    public a(String str, String str2, String str3) {
        this.f58467e = null;
        this.f58468f = null;
        this.f58469g = null;
        this.f58467e = str;
        this.f58468f = str2;
        this.f58469g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("obj", this.f58467e);
        netWork.addPostData("obj_tp", this.f58468f);
        netWork.addPostData("group_id", this.f58469g);
        netWork.postNetData();
    }
}
