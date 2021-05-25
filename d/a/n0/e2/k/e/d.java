package d.a.n0.e2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes5.dex */
public class d extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final String f53221e;

    /* renamed from: f  reason: collision with root package name */
    public final String f53222f;

    /* renamed from: g  reason: collision with root package name */
    public final String f53223g;

    public d(String str, String str2, String str3) {
        this.f53221e = str;
        this.f53222f = str2;
        this.f53223g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
        netWork.addPostData("tid", this.f53221e);
        netWork.addPostData("phonenum", this.f53222f);
        netWork.addPostData("optype", this.f53223g);
        netWork.postNetData();
    }
}
