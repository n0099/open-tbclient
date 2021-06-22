package d.a.o0.e2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes5.dex */
public class d extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final String f57035e;

    /* renamed from: f  reason: collision with root package name */
    public final String f57036f;

    /* renamed from: g  reason: collision with root package name */
    public final String f57037g;

    public d(String str, String str2, String str3) {
        this.f57035e = str;
        this.f57036f = str2;
        this.f57037g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        netWork.addPostData("tid", this.f57035e);
        netWork.addPostData("phonenum", this.f57036f);
        netWork.addPostData("optype", this.f57037g);
        netWork.postNetData();
    }
}
