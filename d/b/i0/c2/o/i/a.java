package d.b.i0.c2.o.i;

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
    public String f53274e;

    /* renamed from: f  reason: collision with root package name */
    public String f53275f;

    /* renamed from: g  reason: collision with root package name */
    public String f53276g;

    /* renamed from: h  reason: collision with root package name */
    public String f53277h;
    public String i;
    public Long j;
    public long l;
    public boolean m;
    public String n;
    public String o;
    public long p;
    public boolean k = false;
    public boolean q = false;

    public long g() {
        return this.l;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return r;
    }

    public Long j() {
        return this.j;
    }

    public String n() {
        return this.f53276g;
    }

    public String o() {
        return this.f53277h;
    }

    public String s() {
        return this.i;
    }

    public String t() {
        return this.f53275f;
    }

    public String u() {
        return this.f53274e;
    }

    public boolean v() {
        return this.k;
    }

    public void w(@NonNull AlaLiveInfo alaLiveInfo) {
        this.f53274e = alaLiveInfo.first_headline;
        this.f53275f = alaLiveInfo.second_headline;
        this.f53276g = alaLiveInfo.cover;
        this.l = alaLiveInfo.live_id.longValue();
        AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
        this.p = alaUserInfo != null ? alaUserInfo.user_id.longValue() : 0L;
        this.m = alaLiveInfo.live_from.intValue() == 1;
        this.n = alaLiveInfo.third_live_type;
        this.o = alaLiveInfo.third_room_id;
        String str = alaLiveInfo.router_type;
        this.f53277h = "";
        this.i = TbadkCoreApplication.getInst().getString(R.string.pb_ala_enter);
        this.j = 1L;
        this.k = true;
        this.q = false;
    }

    public void x(Promotion promotion) {
        this.f53274e = promotion.title;
        this.f53275f = promotion.sub_title;
        this.f53276g = promotion.image;
        this.f53277h = promotion.link;
        this.i = promotion.link_text;
        this.j = promotion.appear_time;
        this.k = false;
        this.q = false;
    }
}
