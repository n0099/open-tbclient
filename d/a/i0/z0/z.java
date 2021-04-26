package d.a.i0.z0;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes3.dex */
public class z extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public int f50201e;

    /* renamed from: f  reason: collision with root package name */
    public int f50202f;

    /* renamed from: g  reason: collision with root package name */
    public String f50203g = null;

    public z(int i2, int i3) {
        this.f50201e = 0;
        this.f50202f = 0;
        this.f50201e = i2;
        this.f50202f = i3;
    }

    public void a(String str) {
        this.f50203g = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        netWork.addPostData("img_num", String.valueOf(this.f50201e));
        netWork.addPostData("img_total", String.valueOf(this.f50202f));
        String str = this.f50203g;
        if (str != null) {
            netWork.addPostData("img_type", str);
        }
        netWork.postNetData();
    }
}
