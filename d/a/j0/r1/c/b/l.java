package d.a.j0.r1.c.b;

import com.baidu.adp.BdUniqueId;
import tbclient.AutoPayInfo;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipInfo;
import tbclient.GetVipInfo.VipUpgrade;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes3.dex */
public class l implements d.a.c.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f59574e = BdUniqueId.gen();

    public l(DataRes dataRes) {
        VipUser vipUser;
        VipUpgrade vipUpgrade;
        if (dataRes == null || (vipUser = dataRes.user) == null || (vipUpgrade = dataRes.upgrade) == null) {
            return;
        }
        String str = vipUser.card_id;
        String str2 = vipUser.total_scores_link;
        String str3 = vipUser.speed_link;
        String str4 = vipUser.task_scores_link;
        vipUser.task_scores.intValue();
        String str5 = vipUser.name;
        vipUser.id.longValue();
        String str6 = vipUser.portrait;
        String str7 = vipUser.name_show;
        String str8 = vipUser.vip_link;
        VipInfo vipInfo = vipUser.vipInfo;
        if (vipInfo != null) {
            String str9 = vipInfo.icon_url;
            vipInfo.s_time.intValue();
            vipUser.vipInfo.e_time.intValue();
            vipUser.now_time.intValue();
            vipUser.vipInfo.v_status.intValue();
            vipUser.vipInfo.v_level.intValue();
            vipUser.vipInfo.ext_score.intValue();
            vipUser.vipInfo.a_score.intValue();
            vipUser.vipInfo.n_score.intValue();
        }
        dataRes.today_get_score.intValue();
        dataRes.today_unget_score.intValue();
        vipUpgrade.normal.intValue();
        vipUpgrade.pay.intValue();
        AutoPayInfo autoPayInfo = dataRes.autopay_info;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f59574e;
    }
}
