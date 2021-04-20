package d.b.i0.r1.c.b;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f61009a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.r1.c.a.a f61010b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, c> f61011c;

    public m(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        String str = dataRes.grade_intro_title;
        String str2 = dataRes.grade_intro_link;
        new l(dataRes);
        new n(dataRes.special_list);
        new e(dataRes.cooperate_list);
        new i(dataRes.theme_list);
        new a(dataRes.banner_list);
        new q(dataRes.task_list);
        new p(dataRes.rank, dataRes.user);
        new g(dataRes.daily_list);
        d.b.i0.r1.c.a.a aVar = new d.b.i0.r1.c.a.a();
        this.f61010b = aVar;
        aVar.a(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.f61011c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    c cVar = new c(vipBasicList);
                    if (cVar.f60991g != 3 || cVar.a().size() >= 2) {
                        this.f61011c.put(cVar.f60992h, cVar);
                    }
                }
            }
        }
        List<String> list3 = dataRes.card_order;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        this.f61009a = new ArrayList<>();
        for (String str3 : dataRes.card_order) {
            if (!StringUtils.isNull(str3)) {
                this.f61009a.add(str3);
            }
        }
    }
}
