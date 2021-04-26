package d.a.j0.q0;

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
    public static final BdUniqueId f58919i = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public List<MetaData> f58921f;

    /* renamed from: e  reason: collision with root package name */
    public int f58920e = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f58922g = "本吧都在关注";

    /* renamed from: h  reason: collision with root package name */
    public boolean f58923h = false;

    public int c() {
        return this.f58920e;
    }

    public String e() {
        return this.f58922g;
    }

    public List<MetaData> f() {
        return this.f58921f;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f58919i;
    }

    public boolean h() {
        return this.f58923h;
    }

    public void i(FeatureCardGod featureCardGod) {
        if (featureCardGod == null || ListUtils.isEmpty(featureCardGod.sub_nodes)) {
            return;
        }
        this.f58920e = featureCardGod.floor.intValue();
        this.f58921f = featureCardGod.sub_nodes;
        this.f58922g = featureCardGod.title;
    }

    public void k(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend == null || ListUtils.isEmpty(frsPageUserExtend.data)) {
            return;
        }
        List<User> list = frsPageUserExtend.data;
        this.f58920e = frsPageUserExtend.user_extend_storey.intValue();
        this.f58921f = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            User user = list.get(i2);
            if (user != null && user.id.longValue() != 0) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f58921f.add(metaData);
            }
        }
        this.f58922g = frsPageUserExtend.tips;
    }

    public void l(boolean z) {
        this.f58923h = z;
    }
}
