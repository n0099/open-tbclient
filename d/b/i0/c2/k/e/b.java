package d.b.i0.c2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class b extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final String f52606e;

    /* renamed from: f  reason: collision with root package name */
    public final String f52607f;

    /* renamed from: g  reason: collision with root package name */
    public final String f52608g;

    public b(String str, String str2, String str3) {
        this.f52606e = str;
        this.f52607f = str2;
        this.f52608g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        netWork.addPostData("tid", this.f52606e);
        netWork.addPostData("phonenum", this.f52607f);
        netWork.addPostData("optype", this.f52608g);
        netWork.postNetData();
    }
}
