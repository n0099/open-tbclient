package d.a.k0.q0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes4.dex */
public class x implements d.a.c.j.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f59661i = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public List<MetaData> f59663f;

    /* renamed from: e  reason: collision with root package name */
    public int f59662e = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f59664g = "本吧都在关注";

    /* renamed from: h  reason: collision with root package name */
    public boolean f59665h = false;

    public int c() {
        return this.f59662e;
    }

    public String e() {
        return this.f59664g;
    }

    public List<MetaData> f() {
        return this.f59663f;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f59661i;
    }

    public boolean h() {
        return this.f59665h;
    }

    public void i(FeatureCardGod featureCardGod) {
        if (featureCardGod == null || ListUtils.isEmpty(featureCardGod.sub_nodes)) {
            return;
        }
        this.f59662e = featureCardGod.floor.intValue();
        this.f59663f = featureCardGod.sub_nodes;
        this.f59664g = featureCardGod.title;
    }

    public void k(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend == null || ListUtils.isEmpty(frsPageUserExtend.data)) {
            return;
        }
        List<User> list = frsPageUserExtend.data;
        this.f59662e = frsPageUserExtend.user_extend_storey.intValue();
        this.f59663f = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            User user = list.get(i2);
            if (user != null && user.id.longValue() != 0) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f59663f.add(metaData);
            }
        }
        this.f59664g = frsPageUserExtend.tips;
    }

    public void l(boolean z) {
        this.f59665h = z;
    }
}
