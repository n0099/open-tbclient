package d.b.i0.c2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class b extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final String f52607e;

    /* renamed from: f  reason: collision with root package name */
    public final String f52608f;

    /* renamed from: g  reason: collision with root package name */
    public final String f52609g;

    public b(String str, String str2, String str3) {
        this.f52607e = str;
        this.f52608f = str2;
        this.f52609g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        netWork.addPostData("tid", this.f52607e);
        netWork.addPostData("phonenum", this.f52608f);
        netWork.addPostData("optype", this.f52609g);
        netWork.postNetData();
    }
}
