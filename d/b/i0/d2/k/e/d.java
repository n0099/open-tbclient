package d.b.i0.d2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes3.dex */
public class d extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final String f54092e;

    /* renamed from: f  reason: collision with root package name */
    public final String f54093f;

    /* renamed from: g  reason: collision with root package name */
    public final String f54094g;

    public d(String str, String str2, String str3) {
        this.f54092e = str;
        this.f54093f = str2;
        this.f54094g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        netWork.addPostData("tid", this.f54092e);
        netWork.addPostData("phonenum", this.f54093f);
        netWork.addPostData("optype", this.f54094g);
        netWork.postNetData();
    }
}
