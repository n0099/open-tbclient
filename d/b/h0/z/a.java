package d.b.h0.z;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public UserData f51648a;

    public UserData a() {
        return this.f51648a;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        UserData userData = new UserData();
        this.f51648a = userData;
        userData.parserProtobuf(dataRes.user);
    }
}
