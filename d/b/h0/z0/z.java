package d.b.h0.z0;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes3.dex */
public class z extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public int f51759e;

    /* renamed from: f  reason: collision with root package name */
    public int f51760f;

    /* renamed from: g  reason: collision with root package name */
    public String f51761g = null;

    public z(int i, int i2) {
        this.f51759e = 0;
        this.f51760f = 0;
        this.f51759e = i;
        this.f51760f = i2;
    }

    public void a(String str) {
        this.f51761g = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("img_num", String.valueOf(this.f51759e));
        netWork.addPostData("img_total", String.valueOf(this.f51760f));
        String str = this.f51761g;
        if (str != null) {
            netWork.addPostData("img_type", str);
        }
        netWork.postNetData();
    }
}
