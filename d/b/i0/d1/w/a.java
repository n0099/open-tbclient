package d.b.i0.d1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class a extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public String f54069e;

    /* renamed from: f  reason: collision with root package name */
    public String f54070f;

    /* renamed from: g  reason: collision with root package name */
    public String f54071g;

    public a(String str, String str2, String str3) {
        this.f54069e = null;
        this.f54070f = null;
        this.f54071g = null;
        this.f54069e = str;
        this.f54070f = str2;
        this.f54071g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("obj", this.f54069e);
        netWork.addPostData("obj_tp", this.f54070f);
        netWork.addPostData("group_id", this.f54071g);
        netWork.postNetData();
    }
}
