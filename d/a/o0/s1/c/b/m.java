package d.a.o0.s1.c.b;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f64259a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.s1.c.a.a f64260b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, c> f64261c;

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
        d.a.o0.s1.c.a.a aVar = new d.a.o0.s1.c.a.a();
        this.f64260b = aVar;
        aVar.b(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.f64261c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    c cVar = new c(vipBasicList);
                    if (cVar.f64240g != 3 || cVar.b().size() >= 2) {
                        this.f64261c.put(cVar.f64241h, cVar);
                    }
                }
            }
        }
        List<String> list3 = dataRes.card_order;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        this.f64259a = new ArrayList<>();
        for (String str3 : dataRes.card_order) {
            if (!StringUtils.isNull(str3)) {
                this.f64259a.add(str3);
            }
        }
    }
}
