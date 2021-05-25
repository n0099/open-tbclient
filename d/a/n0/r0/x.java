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
public class x implements d.a.c.j.e.n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f59802i = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public List<MetaData> f59804f;

    /* renamed from: e  reason: collision with root package name */
    public int f59803e = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f59805g = "本吧都在关注";

    /* renamed from: h  reason: collision with root package name */
    public boolean f59806h = false;

    public int c() {
        return this.f59803e;
    }

    public String e() {
        return this.f59805g;
    }

    public List<MetaData> f() {
        return this.f59804f;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f59802i;
    }

    public boolean h() {
        return this.f59806h;
    }

    public void i(FeatureCardGod featureCardGod) {
        if (featureCardGod == null || ListUtils.isEmpty(featureCardGod.sub_nodes)) {
            return;
        }
        this.f59803e = featureCardGod.floor.intValue();
        this.f59804f = featureCardGod.sub_nodes;
        this.f59805g = featureCardGod.title;
    }

    public void k(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend == null || ListUtils.isEmpty(frsPageUserExtend.data)) {
            return;
        }
        List<User> list = frsPageUserExtend.data;
        this.f59803e = frsPageUserExtend.user_extend_storey.intValue();
        this.f59804f = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            User user = list.get(i2);
            if (user != null && user.id.longValue() != 0) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f59804f.add(metaData);
            }
        }
        this.f59805g = frsPageUserExtend.tips;
    }

    public void l(boolean z) {
        this.f59806h = z;
    }
}
