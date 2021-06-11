package d.a.n0.e2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes5.dex */
public class d extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final String f56910e;

    /* renamed from: f  reason: collision with root package name */
    public final String f56911f;

    /* renamed from: g  reason: collision with root package name */
    public final String f56912g;

    public d(String str, String str2, String str3) {
        this.f56910e = str;
        this.f56911f = str2;
        this.f56912g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        netWork.addPostData("tid", this.f56910e);
        netWork.addPostData("phonenum", this.f56911f);
        netWork.addPostData("optype", this.f56912g);
        netWork.postNetData();
    }
}
