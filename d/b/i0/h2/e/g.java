package d.b.i0.h2.e;

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
    public boolean f55286e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55287f;

    /* renamed from: g  reason: collision with root package name */
    public String f55288g;

    /* renamed from: h  reason: collision with root package name */
    public String f55289h;
    public String i;
    public int j;
    public List<d.b.b.j.e.n> k;

    public void g(User user) {
        if (user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        this.f55288g = String.valueOf(user.id);
        this.f55289h = user.name;
        this.i = user.name_show;
        this.j = user.sex.intValue();
        String str = this.f55288g;
        if (str != null && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.f55286e = true;
        } else {
            this.f55286e = false;
        }
        if (user.sex.intValue() == 2) {
            this.f55287f = false;
        } else {
            this.f55287f = true;
        }
        Integer num = user.gift_num;
        if (num != null) {
            num.intValue();
        }
        this.k = new ArrayList();
        for (GiftInfo giftInfo : user.gift_list) {
            if (giftInfo != null) {
                o oVar = new o();
                oVar.g(giftInfo);
                this.k.add(oVar);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public boolean isValid() {
        return !ListUtils.isEmpty(this.k);
    }
}
