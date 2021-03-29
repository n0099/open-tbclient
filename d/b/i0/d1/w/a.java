package d.b.i0.d1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes3.dex */
public class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f54070e;

    /* renamed from: f  reason: collision with root package name */
    public String f54071f;

    /* renamed from: g  reason: collision with root package name */
    public String f54072g;

    public a(String str, String str2, String str3) {
        this.f54070e = null;
        this.f54071f = null;
        this.f54072g = null;
        this.f54070e = str;
        this.f54071f = str2;
        this.f54072g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("obj", this.f54070e);
        netWork.addPostData("obj_tp", this.f54071f);
        netWork.addPostData("group_id", this.f54072g);
        netWork.postNetData();
    }
}
