package d.b.i0.z2;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final String f64281c = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";

    /* renamed from: a  reason: collision with root package name */
    public String f64282a;

    /* renamed from: b  reason: collision with root package name */
    public NetWork f64283b = null;

    public void a() {
        NetWork netWork = this.f64283b;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public String b() {
        NetWork netWork = this.f64283b;
        if (netWork != null) {
            return netWork.getErrorString();
        }
        return null;
    }

    public boolean c() {
        NetWork netWork = this.f64283b;
        if (netWork != null) {
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return false;
    }

    public void d(String str) {
        this.f64282a = str;
    }

    public String e(String str) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        String id = currentAccountObj != null ? currentAccountObj.getID() : null;
        NetWork netWork = new NetWork(f64281c);
        this.f64283b = netWork;
        netWork.addPostData("user_id", id);
        this.f64283b.addPostData("forum_ids", str);
        this.f64283b.addPostData("authsid", this.f64282a);
        this.f64283b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f64283b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f64283b.setNeedSig(true);
        return this.f64283b.postNetData();
    }

    public String f() {
        NetWork netWork = new NetWork(f64281c);
        this.f64283b = netWork;
        netWork.addPostData("authsid", this.f64282a);
        this.f64283b.getNetContext().getRequest().mNeedBackgroundLogin = true;
        this.f64283b.getNetContext().getRequest().mIsNeedTbs = true;
        this.f64283b.setNeedSig(true);
        return this.f64283b.postNetData();
    }
}
