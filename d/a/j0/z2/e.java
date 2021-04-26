package d.a.j0.z2;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final String f62989c = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";

    /* renamed from: a  reason: collision with root package name */
    public String f62990a;

    /* renamed from: b  reason: collision with root package name */
    public NetWork f62991b = null;

    public void a() {
        NetWork netWork = this.f62991b;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public String b() {
        NetWork netWork = this.f62991b;
        if (netWork != null) {
            return netWork.getErrorString();
        }
        return null;
    }

    public boolean c() {
        NetWork netWork = this.f62991b;
        if (netWork != null) {
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return false;
    }

    public void d(String str) {
        this.f62990a = str;
    }

    public String e(String str) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        String id = currentAccountObj != null ? currentAccountObj.getID() : null;
        NetWork netWork = new NetWork(f62989c);
        this.f62991b = netWork;
        netWork.addPostData("user_id", id);
        this.f62991b.addPostData("forum_ids", str);
        this.f62991b.addPostData("authsid", this.f62990a);
        this.f62991b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f62991b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f62991b.setNeedSig(true);
        return this.f62991b.postNetData();
    }

    public String f() {
        NetWork netWork = new NetWork(f62989c);
        this.f62991b = netWork;
        netWork.addPostData("authsid", this.f62990a);
        this.f62991b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f62991b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f62991b.setNeedSig(true);
        return this.f62991b.postNetData();
    }
}
