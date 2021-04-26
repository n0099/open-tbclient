package d.a.j0.d2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes3.dex */
public class d extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final String f52314e;

    /* renamed from: f  reason: collision with root package name */
    public final String f52315f;

    /* renamed from: g  reason: collision with root package name */
    public final String f52316g;

    public d(String str, String str2, String str3) {
        this.f52314e = str;
        this.f52315f = str2;
        this.f52316g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        netWork.addPostData("tid", this.f52314e);
        netWork.addPostData("phonenum", this.f52315f);
        netWork.addPostData("optype", this.f52316g);
        netWork.postNetData();
    }
}
