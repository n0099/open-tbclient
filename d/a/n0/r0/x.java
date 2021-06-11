package d.a.n0.r0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes4.dex */
public class x implements d.a.c.k.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f63493i = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public List<MetaData> f63495f;

    /* renamed from: e  reason: collision with root package name */
    public int f63494e = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f63496g = "本吧都在关注";

    /* renamed from: h  reason: collision with root package name */
    public boolean f63497h = false;

    public int b() {
        return this.f63494e;
    }

    public String c() {
        return this.f63496g;
    }

    public List<MetaData> e() {
        return this.f63495f;
    }

    public boolean g() {
        return this.f63497h;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f63493i;
    }

    public void h(FeatureCardGod featureCardGod) {
        if (featureCardGod == null || ListUtils.isEmpty(featureCardGod.sub_nodes)) {
            return;
        }
        this.f63494e = featureCardGod.floor.intValue();
        this.f63495f = featureCardGod.sub_nodes;
        this.f63496g = featureCardGod.title;
    }

    public void i(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend == null || ListUtils.isEmpty(frsPageUserExtend.data)) {
            return;
        }
        List<User> list = frsPageUserExtend.data;
        this.f63494e = frsPageUserExtend.user_extend_storey.intValue();
        this.f63495f = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            User user = list.get(i2);
            if (user != null && user.id.longValue() != 0) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f63495f.add(metaData);
            }
        }
        this.f63496g = frsPageUserExtend.tips;
    }

    public void k(boolean z) {
        this.f63497h = z;
    }
}
