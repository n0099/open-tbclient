package d.b.i0.f2.e;

import android.text.TextUtils;
import androidx.annotation.StringRes;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.MembershipUserInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import d.b.i0.f2.e.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.DataRes;
import tbclient.Profile.Duxiaoman;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes5.dex */
public class f implements d.b.i0.e2.b {

    /* renamed from: b  reason: collision with root package name */
    public UserData f54769b;

    /* renamed from: c  reason: collision with root package name */
    public Duxiaoman f54770c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.v0.b f54771d;

    /* renamed from: e  reason: collision with root package name */
    public List<BannerImage> f54772e;

    /* renamed from: f  reason: collision with root package name */
    public PersonUserGodInfo f54773f;

    /* renamed from: g  reason: collision with root package name */
    public d f54774g;

    /* renamed from: h  reason: collision with root package name */
    public h f54775h;
    public h i;
    public h j;
    public h k;
    public i l;
    public PersonMoreData m;
    public n n;
    public k o;
    public int[] p = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    public int[] q = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    public int[] r = {1, 2, 3, 4};

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.b.b.j.e.n> f54768a = new ArrayList<>();

    @Override // d.b.i0.e2.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.f54769b == null) {
            this.f54769b = new UserData();
        }
        this.f54769b.parserProtobuf(personalResIdl.data.user);
        i iVar = new i();
        this.l = iVar;
        iVar.f54787e = this.f54769b;
        this.f54768a.add(iVar);
        g();
        k();
        d.b.i0.s2.a.v().K(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.f54769b.getSex());
        }
    }

    @Override // d.b.i0.e2.b
    public void b(ProfileResIdl profileResIdl) {
        if (profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new i();
        DataRes dataRes = profileResIdl.data;
        this.f54772e = dataRes.banner;
        this.f54770c = dataRes.duxiaoman;
        t(dataRes.user, dataRes.user_god_info);
        q(profileResIdl.data.tbbookrack);
        r(profileResIdl.data.uc_card);
        s(profileResIdl.data.url_map);
        this.f54768a.add(this.l);
        g();
        h();
        l(profileResIdl.data.recom_swan_list);
        m();
        k();
        d.b.i0.s2.a.v().K(true);
    }

    public void c(boolean z) {
        h hVar = this.j;
        if (hVar != null) {
            if (hVar.m == null) {
                hVar.m = new j();
            }
            this.j.m.f54788a = z;
        }
    }

    public void d(boolean z) {
        d dVar = this.f54774g;
        if (dVar != null) {
            dVar.i = z;
        }
    }

    public void e(boolean z) {
        h hVar = this.k;
        if (hVar != null) {
            if (hVar.m == null) {
                hVar.m = new j();
            }
            this.k.m.f54788a = z;
        }
    }

    public void f(boolean z) {
        h hVar = this.f54775h;
        if (hVar != null) {
            if (hVar.m == null) {
                hVar.m = new j();
            }
            this.f54775h.m.f54788a = z;
        }
    }

    public final void g() {
        d dVar = this.f54774g;
        if (dVar != null) {
            this.f54768a.add(dVar);
        } else if (this.f54769b == null) {
        } else {
            d dVar2 = new d();
            this.f54774g = dVar2;
            dVar2.f54763e = this.f54769b.getFansNum();
            this.f54774g.f54764f = this.f54769b.getConcern_num();
            this.f54774g.f54765g = this.f54769b.getLike_bars();
            this.f54774g.f54766h = this.f54769b.getThreadNum();
            d dVar3 = this.f54774g;
            dVar3.j = this.f54769b;
            this.f54768a.add(dVar3);
        }
    }

    public final void h() {
        if (d.b.h0.r.d0.b.i().j("key_create_center_entrance_switch", 0) == 0) {
            return;
        }
        g gVar = new g();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            g.a aVar = new g.a();
            aVar.f54780b = this.q[i];
            if (i == 1) {
                UserData userData = this.f54769b;
                if (userData != null && userData.isNewGod()) {
                    aVar.f54781c = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                    aVar.f54779a = 5;
                } else {
                    aVar.f54781c = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                    aVar.f54779a = 2;
                }
            } else {
                aVar.f54781c = TbadkCoreApplication.getInst().getString(this.p[i]);
                aVar.f54779a = this.r[i];
            }
            arrayList.add(aVar);
        }
        gVar.g(arrayList);
        gVar.f54778f = this.f54769b;
        this.f54768a.add(gVar);
    }

    public final h i(int i, int i2, int i3) {
        h hVar = new h();
        hVar.f54783f = i;
        hVar.i = TbadkCoreApplication.getInst().getString(i2);
        hVar.f54782e = i3;
        UserData userData = this.f54769b;
        if (userData != null) {
            hVar.l = userData;
        }
        return hVar;
    }

    public final h j(int i, String str, int i2) {
        h hVar = new h();
        hVar.f54783f = i;
        hVar.i = str;
        hVar.f54782e = i2;
        UserData userData = this.f54769b;
        if (userData != null) {
            hVar.l = userData;
        }
        return hVar;
    }

    public final void k() {
        if (this.f54775h == null) {
            h i = i(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.f54775h = i;
            i.f54784g = true;
            i.m = new j();
        }
        this.f54768a.add(this.f54775h);
        h i2 = i(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        i2.f54784g = true;
        i2.j = true;
        this.f54768a.add(i2);
        h i3 = i(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        i3.j = true;
        i3.f54784g = true;
        d.b.i0.v0.b bVar = this.f54771d;
        if (bVar != null && bVar.a() && !TextUtils.isEmpty(this.f54771d.f61974b)) {
            h i4 = i(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            i4.f54784g = true;
            i4.k = this.f54771d.f61974b;
            this.f54768a.add(i4);
        }
        h i5 = i(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        i5.f54784g = true;
        i5.m = new j();
        if (!d.b.h0.r.d0.b.i().g("key_has_borrow_cash_clicked", false)) {
            i5.m.f54788a = true;
        }
        i5.m.f54795h = true;
        this.f54768a.add(i5);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h i6 = i(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            i6.f54784g = true;
            i6.k = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.f54768a.add(i6);
        }
        if (d.b.h0.r.d0.b.i().j("baidu_financial_display", 1) == 1) {
            h i7 = i(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            i7.f54784g = true;
            if (!d.b.h0.r.d0.b.i().g("key_baidu_financial_has_clicked", false)) {
                j jVar = new j();
                i7.m = jVar;
                jVar.f54788a = true;
            }
            this.f54768a.add(i7);
        }
        Duxiaoman duxiaoman = this.f54770c;
        if (duxiaoman != null && duxiaoman.is_end.intValue() != 1) {
            h i8 = i(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            i8.f54784g = true;
            i8.k = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.f54770c.total_cash.intValue();
            if (intValue > 0) {
                j jVar2 = new j();
                double d2 = intValue;
                Double.isNaN(d2);
                jVar2.f54790c = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(d2 / 100.0d))});
                jVar2.f54791d = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                i8.m = jVar2;
            }
            this.f54768a.add(i8);
        }
        h i9 = i(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        i9.f54784g = true;
        this.f54768a.add(i9);
        h i10 = i(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        i10.f54784g = true;
        this.f54768a.add(i10);
        h i11 = i(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.i = i11;
        i11.m = new j();
        h hVar = this.i;
        hVar.f54784g = true;
        hVar.m.f54790c = StringHelper.formatNumForTdouDisPlay(this.f54769b.getTDouNum());
        this.i.m.f54792e = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.f54768a.add(this.i);
        h i12 = i(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        i12.f54784g = true;
        this.f54768a.add(i12);
        h i13 = i(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        i13.f54784g = true;
        MembershipUserInfo membershipUserInfo = this.f54769b.membershipInfo;
        if (membershipUserInfo != null) {
            i13.k = membershipUserInfo.mLink;
        }
        this.f54768a.add(i13);
        boolean f2 = TbadkCoreApplication.getInst().getActivityPrizeData().f();
        String e2 = TbadkCoreApplication.getInst().getActivityPrizeData().e();
        if (f2 && !StringUtils.isNull(e2)) {
            h j = j(R.drawable.icon_mine_list_logingift, e2, 38);
            this.j = j;
            j.j = true;
            j.m = new j();
            this.f54768a.add(this.j);
            TiebaStatic.log(new StatisticItem("c12597"));
        } else {
            i13.j = true;
        }
        h i14 = i(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        i14.f54784g = true;
        this.f54768a.add(i14);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h i15 = i(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            i15.f54784g = true;
            i15.j = true;
            this.f54768a.add(i15);
        }
        h i16 = i(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.k = i16;
        i16.j = true;
        i16.f54784g = true;
        this.f54768a.add(i16);
        h i17 = i(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        i17.f54784g = true;
        this.f54768a.add(i17);
        if (this.m == null) {
            this.m = new PersonMoreData();
        }
        h i18 = i(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        i18.f54784g = true;
        i18.f54785h = true;
        i18.n = OrmObject.bundleWithObject(this.m);
        i18.m = new j();
        List<PersonMoreItemData> list = this.m.mUrlMaps;
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (PersonMoreItemData personMoreItemData : list) {
                if (personMoreItemData != null && !TextUtils.isEmpty(personMoreItemData.mName)) {
                    sb.append(personMoreItemData.mName);
                    sb.append("、");
                }
            }
            if (sb.toString().endsWith("、")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                i18.m.f54789b = o(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.f54768a.add(i18);
    }

    public final void l(List<SmartApp> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o == null) {
            k kVar = new k();
            this.o = kVar;
            this.f54768a.add(kVar);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new m(smartApp));
                }
            }
        }
        this.o.j(arrayList);
    }

    public final void m() {
        n nVar = this.n;
        if (nVar != null) {
            this.f54768a.add(nVar);
            return;
        }
        this.n = new n();
        if (ListUtils.isEmpty(this.f54772e)) {
            return;
        }
        for (int i = 0; i < this.f54772e.size(); i++) {
            a aVar = new a();
            aVar.d(this.f54772e.get(i));
            if (!d.b.b.e.p.k.isEmpty(aVar.c())) {
                this.n.f54807e.add(aVar);
            }
        }
        if (this.n.f54807e.size() > 0) {
            this.f54768a.add(this.n);
        }
    }

    public ArrayList<d.b.b.j.e.n> n() {
        return this.f54768a;
    }

    public final String o(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    public UserData p() {
        return this.f54769b;
    }

    public final void q(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            d.b.i0.e2.i.a aVar = new d.b.i0.e2.i.a();
            aVar.a(tbBookrack);
            new d.b.i0.e2.i.d(true, aVar);
        }
    }

    public final void r(UcCard ucCard) {
        new d.b.i0.e2.g().a(ucCard);
    }

    public final void s(List<UserMap> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.m = new PersonMoreData();
        for (UserMap userMap : list) {
            if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                String replaceAll = userMap.url.replaceAll("amp;", "");
                PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                personMoreItemData.mId = userMap.id.intValue();
                personMoreItemData.mName = userMap.name;
                personMoreItemData.mUrl = replaceAll;
                this.m.mUrlMaps.add(personMoreItemData);
            }
        }
    }

    public final void t(User user, UserGodInfo userGodInfo) {
        if (this.f54769b == null) {
            this.f54769b = new UserData();
        }
        this.f54769b.parserProtobuf(user);
        if (this.f54773f == null && userGodInfo != null) {
            this.f54773f = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.f54769b.setIsBigV(true);
            this.f54773f.parserProtobuf(userGodInfo);
        }
        this.l.f54787e = this.f54769b;
    }

    public void u(d.b.h0.t.m mVar) {
        this.f54769b.setPendantData(mVar);
    }
}
