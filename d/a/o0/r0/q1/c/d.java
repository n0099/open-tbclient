package d.a.o0.r0.q1.c;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import tbclient.BaijiahaoInfo;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes4.dex */
public class d implements n {

    /* renamed from: e  reason: collision with root package name */
    public static BdUniqueId f63238e = BdUniqueId.gen();

    public void b(DataRes dataRes) {
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

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f63238e;
    }
}
