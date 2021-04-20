package d.b.h0.r;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f50852a;

    /* renamed from: b  reason: collision with root package name */
    public NewErrorData f50853b = null;

    public d() {
        this.f50852a = null;
        this.f50852a = new NetWork();
    }

    public void a(String str, String str2) {
        this.f50852a.addPostData(str, str2);
    }

    public void b() {
        NetWork netWork = this.f50852a;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public String c() {
        NetWork netWork = this.f50852a;
        if (netWork != null) {
            return netWork.getErrorString();
        }
        return null;
    }

    public String d() {
        String postNetData = this.f50852a.postNetData();
        NewErrorData newErrorData = new NewErrorData();
        this.f50853b = newErrorData;
        newErrorData.parserJson(postNetData);
        return postNetData;
    }

    public boolean e() {
        NetWork netWork = this.f50852a;
        if (netWork != null) {
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return false;
    }

    public void f(String str) {
        this.f50852a.setUrl(str);
    }
}
