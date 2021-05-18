package d.a.k0.z2;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final String f63713c = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";

    /* renamed from: a  reason: collision with root package name */
    public String f63714a;

    /* renamed from: b  reason: collision with root package name */
    public NetWork f63715b = null;

    public void a() {
        NetWork netWork = this.f63715b;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public String b() {
        NetWork netWork = this.f63715b;
        if (netWork != null) {
            return netWork.getErrorString();
        }
        return null;
    }

    public boolean c() {
        NetWork netWork = this.f63715b;
        if (netWork != null) {
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return false;
    }

    public void d(String str) {
        this.f63714a = str;
    }

    public String e(String str) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        String id = currentAccountObj != null ? currentAccountObj.getID() : null;
        NetWork netWork = new NetWork(f63713c);
        this.f63715b = netWork;
        netWork.addPostData("user_id", id);
        this.f63715b.addPostData("forum_ids", str);
        this.f63715b.addPostData("authsid", this.f63714a);
        this.f63715b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f63715b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f63715b.setNeedSig(true);
        return this.f63715b.postNetData();
    }

    public String f() {
        NetWork netWork = new NetWork(f63713c);
        this.f63715b = netWork;
        netWork.addPostData("authsid", this.f63714a);
        this.f63715b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f63715b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f63715b.setNeedSig(true);
        return this.f63715b.postNetData();
    }
}
