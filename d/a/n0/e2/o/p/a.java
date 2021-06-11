package d.a.n0.e2.o.p;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
import tbclient.Promotion;
/* loaded from: classes5.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId r = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f57560e;

    /* renamed from: f  reason: collision with root package name */
    public String f57561f;

    /* renamed from: g  reason: collision with root package name */
    public String f57562g;

    /* renamed from: h  reason: collision with root package name */
    public String f57563h;

    /* renamed from: i  reason: collision with root package name */
    public String f57564i;
    public Long j;
    public long l;
    public boolean m;
    public String n;
    public String o;
    public long p;
    public boolean k = false;
    public boolean q = false;

    public long c() {
        return this.l;
    }

    public Long g() {
        return this.j;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return r;
    }

    public String i() {
        return this.f57562g;
    }

    public String k() {
        return this.f57563h;
    }

    public String o() {
        return this.f57564i;
    }

    public String p() {
        return this.f57561f;
    }

    public String q() {
        return this.f57560e;
    }

    public boolean t() {
        return this.k;
    }

    public void w(@NonNull AlaLiveInfo alaLiveInfo) {
        this.f57560e = alaLiveInfo.first_headline;
        this.f57561f = alaLiveInfo.second_headline;
        this.f57562g = alaLiveInfo.cover;
        this.l = alaLiveInfo.live_id.longValue();
        AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
        this.p = alaUserInfo != null ? alaUserInfo.user_id.longValue() : 0L;
        this.m = alaLiveInfo.live_from.intValue() == 1;
        this.n = alaLiveInfo.third_live_type;
        this.o = alaLiveInfo.third_room_id;
        String str = alaLiveInfo.router_type;
        this.f57563h = "";
        this.f57564i = TbadkCoreApplication.getInst().getString(R.string.pb_ala_enter);
        this.j = 1L;
        this.k = true;
        this.q = false;
    }

    public void x(Promotion promotion) {
        this.f57560e = promotion.title;
        this.f57561f = promotion.sub_title;
        this.f57562g = promotion.image;
        this.f57563h = promotion.link;
        this.f57564i = promotion.link_text;
        this.j = promotion.appear_time;
        this.k = false;
        this.q = false;
    }
}
