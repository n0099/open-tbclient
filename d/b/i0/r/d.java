package d.b.i0.r;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f51188a;

    /* renamed from: b  reason: collision with root package name */
    public NewErrorData f51189b = null;

    public d() {
        this.f51188a = null;
        this.f51188a = new NetWork();
    }

    public void a(String str, String str2) {
        this.f51188a.addPostData(str, str2);
    }

    public void b() {
        NetWork netWork = this.f51188a;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public String c() {
        NetWork netWork = this.f51188a;
        if (netWork != null) {
            return netWork.getErrorString();
        }
        return null;
    }

    public String d() {
        String postNetData = this.f51188a.postNetData();
        NewErrorData newErrorData = new NewErrorData();
        this.f51189b = newErrorData;
        newErrorData.parserJson(postNetData);
        return postNetData;
    }

    public boolean e() {
        NetWork netWork = this.f51188a;
        if (netWork != null) {
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return false;
    }

    public void f(String str) {
        this.f51188a.setUrl(str);
    }
}
