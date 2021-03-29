package d.b.i0.b1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<l> f52117a;

    public void a(JoinUser joinUser) {
        joinUser.join_user_num.longValue();
        this.f52117a = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.f52117a.add(lVar);
            }
        }
    }
}
