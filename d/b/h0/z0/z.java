package d.b.h0.z0;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes3.dex */
public class z extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public int f52183e;

    /* renamed from: f  reason: collision with root package name */
    public int f52184f;

    /* renamed from: g  reason: collision with root package name */
    public String f52185g = null;

    public z(int i, int i2) {
        this.f52183e = 0;
        this.f52184f = 0;
        this.f52183e = i;
        this.f52184f = i2;
    }

    public void a(String str) {
        this.f52185g = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("img_num", String.valueOf(this.f52183e));
        netWork.addPostData("img_total", String.valueOf(this.f52184f));
        String str = this.f52185g;
        if (str != null) {
            netWork.addPostData("img_type", str);
        }
        netWork.postNetData();
    }
}
