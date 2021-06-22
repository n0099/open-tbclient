package d.a.o0.j2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes5.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public boolean f60223e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60224f;

    /* renamed from: g  reason: collision with root package name */
    public String f60225g;

    /* renamed from: h  reason: collision with root package name */
    public String f60226h;

    /* renamed from: i  reason: collision with root package name */
    public String f60227i;
    public int j;
    public List<d.a.c.k.e.n> k;

    public void c(User user) {
        if (user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        this.f60225g = String.valueOf(user.id);
        this.f60226h = user.name;
        this.f60227i = user.name_show;
        this.j = user.sex.intValue();
        String str = this.f60225g;
        if (str != null && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.f60223e = true;
        } else {
            this.f60223e = false;
        }
        if (user.sex.intValue() == 2) {
            this.f60224f = false;
        } else {
            this.f60224f = true;
        }
        Integer num = user.gift_num;
        if (num != null) {
            num.intValue();
        }
        this.k = new ArrayList();
        for (GiftInfo giftInfo : user.gift_list) {
            if (giftInfo != null) {
                o oVar = new o();
                oVar.c(giftInfo);
                this.k.add(oVar);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return l;
    }

    public boolean isValid() {
        return !ListUtils.isEmpty(this.k);
    }
}
