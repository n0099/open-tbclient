package d.b.i0.y2;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final String f62619c = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";

    /* renamed from: a  reason: collision with root package name */
    public String f62620a;

    /* renamed from: b  reason: collision with root package name */
    public NetWork f62621b = null;

    public void a() {
        NetWork netWork = this.f62621b;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public String b() {
        NetWork netWork = this.f62621b;
        if (netWork != null) {
            return netWork.getErrorString();
        }
        return null;
    }

    public boolean c() {
        NetWork netWork = this.f62621b;
        if (netWork != null) {
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return false;
    }

    public void d(String str) {
        this.f62620a = str;
    }

    public String e(String str) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        String id = currentAccountObj != null ? currentAccountObj.getID() : null;
        NetWork netWork = new NetWork(f62619c);
        this.f62621b = netWork;
        netWork.addPostData("user_id", id);
        this.f62621b.addPostData("forum_ids", str);
        this.f62621b.addPostData("authsid", this.f62620a);
        this.f62621b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f62621b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f62621b.setNeedSig(true);
        return this.f62621b.postNetData();
    }

    public String f() {
        NetWork netWork = new NetWork(f62619c);
        this.f62621b = netWork;
        netWork.addPostData("authsid", this.f62620a);
        this.f62621b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f62621b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f62621b.setNeedSig(true);
        return this.f62621b.postNetData();
    }
}
