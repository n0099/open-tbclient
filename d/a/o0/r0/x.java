package d.a.o0.r0;

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
    public static final BdUniqueId f63618i = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public List<MetaData> f63620f;

    /* renamed from: e  reason: collision with root package name */
    public int f63619e = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f63621g = "本吧都在关注";

    /* renamed from: h  reason: collision with root package name */
    public boolean f63622h = false;

    public int b() {
        return this.f63619e;
    }

    public String c() {
        return this.f63621g;
    }

    public List<MetaData> e() {
        return this.f63620f;
    }

    public boolean g() {
        return this.f63622h;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f63618i;
    }

    public void h(FeatureCardGod featureCardGod) {
        if (featureCardGod == null || ListUtils.isEmpty(featureCardGod.sub_nodes)) {
            return;
        }
        this.f63619e = featureCardGod.floor.intValue();
        this.f63620f = featureCardGod.sub_nodes;
        this.f63621g = featureCardGod.title;
    }

    public void i(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend == null || ListUtils.isEmpty(frsPageUserExtend.data)) {
            return;
        }
        List<User> list = frsPageUserExtend.data;
        this.f63619e = frsPageUserExtend.user_extend_storey.intValue();
        this.f63620f = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            User user = list.get(i2);
            if (user != null && user.id.longValue() != 0) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f63620f.add(metaData);
            }
        }
        this.f63621g = frsPageUserExtend.tips;
    }

    public void k(boolean z) {
        this.f63622h = z;
    }
}
