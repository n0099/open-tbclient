package d.a.k0.d2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes5.dex */
public class d extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final String f53013e;

    /* renamed from: f  reason: collision with root package name */
    public final String f53014f;

    /* renamed from: g  reason: collision with root package name */
    public final String f53015g;

    public d(String str, String str2, String str3) {
        this.f53013e = str;
        this.f53014f = str2;
        this.f53015g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        netWork.addPostData("tid", this.f53013e);
        netWork.addPostData("phonenum", this.f53014f);
        netWork.addPostData("optype", this.f53015g);
        netWork.postNetData();
    }
}
