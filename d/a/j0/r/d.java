package d.a.j0.r;

import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public NetWork f49624a;

    /* renamed from: b  reason: collision with root package name */
    public NewErrorData f49625b = null;

    public d() {
        this.f49624a = null;
        this.f49624a = new NetWork();
    }

    public void a(String str, String str2) {
        this.f49624a.addPostData(str, str2);
    }

    public void b() {
        NetWork netWork = this.f49624a;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public String c() {
        NetWork netWork = this.f49624a;
        if (netWork != null) {
            return netWork.getErrorString();
        }
        return null;
    }

    public String d() {
        String postNetData = this.f49624a.postNetData();
        NewErrorData newErrorData = new NewErrorData();
        this.f49625b = newErrorData;
        newErrorData.parserJson(postNetData);
        return postNetData;
    }

    public boolean e() {
        NetWork netWork = this.f49624a;
        if (netWork != null) {
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return false;
    }

    public void f(String str) {
        this.f49624a.setUrl(str);
    }
}
