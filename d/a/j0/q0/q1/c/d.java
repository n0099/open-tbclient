package d.a.j0.q0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import tbclient.BaijiahaoInfo;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class d implements n {

    /* renamed from: e  reason: collision with root package name */
    public static BdUniqueId f58539e = BdUniqueId.gen();

    public void c(DataRes dataRes) {
        BawuRoleInfoPub bawuRoleInfoPub = dataRes.bazhu;
        String str = bawuRoleInfoPub.name_show;
        String str2 = bawuRoleInfoPub.portrait;
        dataRes.is_manager.intValue();
        dataRes.bazhu.user_level.intValue();
        BaijiahaoInfo baijiahaoInfo = dataRes.bazhu.baijiahao_info;
        if (baijiahaoInfo != null) {
            String str3 = baijiahaoInfo.auth_desc;
        }
        String str4 = dataRes.publish_time;
        dataRes.audit_status.intValue();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f58539e;
    }
}
