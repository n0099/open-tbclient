package d.a.o0.a3;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final String f55006c = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";

    /* renamed from: a  reason: collision with root package name */
    public String f55007a;

    /* renamed from: b  reason: collision with root package name */
    public NetWork f55008b = null;

    public void a() {
        NetWork netWork = this.f55008b;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public String b() {
        NetWork netWork = this.f55008b;
        if (netWork != null) {
            return netWork.getErrorString();
        }
        return null;
    }

    public boolean c() {
        NetWork netWork = this.f55008b;
        if (netWork != null) {
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return false;
    }

    public void d(String str) {
        this.f55007a = str;
    }

    public String e(String str) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        String id = currentAccountObj != null ? currentAccountObj.getID() : null;
        NetWork netWork = new NetWork(f55006c);
        this.f55008b = netWork;
        netWork.addPostData("user_id", id);
        this.f55008b.addPostData("forum_ids", str);
        this.f55008b.addPostData("authsid", this.f55007a);
        this.f55008b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f55008b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f55008b.setNeedSig(true);
        return this.f55008b.postNetData();
    }

    public String f() {
        NetWork netWork = new NetWork(f55006c);
        this.f55008b = netWork;
        netWork.addPostData("authsid", this.f55007a);
        this.f55008b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f55008b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f55008b.setNeedSig(true);
        return this.f55008b.postNetData();
    }
}
