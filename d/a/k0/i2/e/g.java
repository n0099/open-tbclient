package d.a.k0.i2.e;

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
    public boolean f56225e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56226f;

    /* renamed from: g  reason: collision with root package name */
    public String f56227g;

    /* renamed from: h  reason: collision with root package name */
    public String f56228h;

    /* renamed from: i  reason: collision with root package name */
    public String f56229i;
    public int j;
    public List<d.a.c.j.e.n> k;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public void h(User user) {
        if (user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        this.f56227g = String.valueOf(user.id);
        this.f56228h = user.name;
        this.f56229i = user.name_show;
        this.j = user.sex.intValue();
        String str = this.f56227g;
        if (str != null && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.f56225e = true;
        } else {
            this.f56225e = false;
        }
        if (user.sex.intValue() == 2) {
            this.f56226f = false;
        } else {
            this.f56226f = true;
        }
        Integer num = user.gift_num;
        if (num != null) {
            num.intValue();
        }
        this.k = new ArrayList();
        for (GiftInfo giftInfo : user.gift_list) {
            if (giftInfo != null) {
                o oVar = new o();
                oVar.h(giftInfo);
                this.k.add(oVar);
            }
        }
    }

    public boolean isValid() {
        return !ListUtils.isEmpty(this.k);
    }
}
