package d.a.j0.d2.o.p;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
import tbclient.Promotion;
/* loaded from: classes3.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId r = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52951e;

    /* renamed from: f  reason: collision with root package name */
    public String f52952f;

    /* renamed from: g  reason: collision with root package name */
    public String f52953g;

    /* renamed from: h  reason: collision with root package name */
    public String f52954h;

    /* renamed from: i  reason: collision with root package name */
    public String f52955i;
    public Long j;
    public long l;
    public boolean m;
    public String n;
    public String o;
    public long p;
    public boolean k = false;
    public boolean q = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return r;
    }

    public long h() {
        return this.l;
    }

    public Long l() {
        return this.j;
    }

    public String m() {
        return this.f52953g;
    }

    public String p() {
        return this.f52954h;
    }

    public String s() {
        return this.f52955i;
    }

    public String t() {
        return this.f52952f;
    }

    public String u() {
        return this.f52951e;
    }

    public boolean v() {
        return this.k;
    }

    public void w(@NonNull AlaLiveInfo alaLiveInfo) {
        this.f52951e = alaLiveInfo.first_headline;
        this.f52952f = alaLiveInfo.second_headline;
        this.f52953g = alaLiveInfo.cover;
        this.l = alaLiveInfo.live_id.longValue();
        AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
        this.p = alaUserInfo != null ? alaUserInfo.user_id.longValue() : 0L;
        this.m = alaLiveInfo.live_from.intValue() == 1;
        this.n = alaLiveInfo.third_live_type;
        this.o = alaLiveInfo.third_room_id;
        String str = alaLiveInfo.router_type;
        this.f52954h = "";
        this.f52955i = TbadkCoreApplication.getInst().getString(R.string.pb_ala_enter);
        this.j = 1L;
        this.k = true;
        this.q = false;
    }

    public void x(Promotion promotion) {
        this.f52951e = promotion.title;
        this.f52952f = promotion.sub_title;
        this.f52953g = promotion.image;
        this.f52954h = promotion.link;
        this.f52955i = promotion.link_text;
        this.j = promotion.appear_time;
        this.k = false;
        this.q = false;
    }
}
