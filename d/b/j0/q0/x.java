package d.b.j0.q0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes4.dex */
public class x implements d.b.c.j.e.n {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public List<MetaData> f60806f;

    /* renamed from: e  reason: collision with root package name */
    public int f60805e = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f60807g = "本吧都在关注";

    /* renamed from: h  reason: collision with root package name */
    public boolean f60808h = false;

    public int a() {
        return this.f60805e;
    }

    public String e() {
        return this.f60807g;
    }

    public List<MetaData> f() {
        return this.f60806f;
    }

    public boolean g() {
        return this.f60808h;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return i;
    }

    public void j(FeatureCardGod featureCardGod) {
        if (featureCardGod == null || ListUtils.isEmpty(featureCardGod.sub_nodes)) {
            return;
        }
        this.f60805e = featureCardGod.floor.intValue();
        this.f60806f = featureCardGod.sub_nodes;
        this.f60807g = featureCardGod.title;
    }

    public void k(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend == null || ListUtils.isEmpty(frsPageUserExtend.data)) {
            return;
        }
        List<User> list = frsPageUserExtend.data;
        this.f60805e = frsPageUserExtend.user_extend_storey.intValue();
        this.f60806f = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            User user = list.get(i2);
            if (user != null && user.id.longValue() != 0) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f60806f.add(metaData);
            }
        }
        this.f60807g = frsPageUserExtend.tips;
    }

    public void l(boolean z) {
        this.f60808h = z;
    }
}
