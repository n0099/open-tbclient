package d.a.n0.h2.e;

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
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.n0.h2.e.g;
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
public class f implements d.a.n0.g2.b {

    /* renamed from: b  reason: collision with root package name */
    public UserData f55542b;

    /* renamed from: c  reason: collision with root package name */
    public Duxiaoman f55543c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.x0.b f55544d;

    /* renamed from: e  reason: collision with root package name */
    public List<BannerImage> f55545e;

    /* renamed from: f  reason: collision with root package name */
    public PersonUserGodInfo f55546f;

    /* renamed from: g  reason: collision with root package name */
    public d f55547g;

    /* renamed from: h  reason: collision with root package name */
    public h f55548h;

    /* renamed from: i  reason: collision with root package name */
    public h f55549i;
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
    public ArrayList<d.a.c.j.e.n> f55541a = new ArrayList<>();

    @Override // d.a.n0.g2.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.f55542b == null) {
            this.f55542b = new UserData();
        }
        this.f55542b.parserProtobuf(personalResIdl.data.user);
        i iVar = new i();
        this.l = iVar;
        iVar.f55562e = this.f55542b;
        this.f55541a.add(iVar);
        g();
        k();
        d.a.n0.u2.a.v().K(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.f55542b.getSex());
        }
    }

    @Override // d.a.n0.g2.b
    public void b(ProfileResIdl profileResIdl) {
        if (profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new i();
        DataRes dataRes = profileResIdl.data;
        this.f55545e = dataRes.banner;
        this.f55543c = dataRes.duxiaoman;
        t(dataRes.user, dataRes.user_god_info);
        q(profileResIdl.data.tbbookrack);
        r(profileResIdl.data.uc_card);
        s(profileResIdl.data.url_map);
        this.f55541a.add(this.l);
        g();
        h();
        l(profileResIdl.data.recom_swan_list);
        m();
        k();
        d.a.n0.u2.a.v().K(true);
    }

    public void c(boolean z) {
        h hVar = this.j;
        if (hVar != null) {
            if (hVar.m == null) {
                hVar.m = new j();
            }
            this.j.m.f55563a = z;
        }
    }

    public void d(boolean z) {
        d dVar = this.f55547g;
        if (dVar != null) {
            dVar.f55539i = z;
        }
    }

    public void e(boolean z) {
        h hVar = this.k;
        if (hVar != null) {
            if (hVar.m == null) {
                hVar.m = new j();
            }
            this.k.m.f55563a = z;
        }
    }

    public void f(boolean z) {
        h hVar = this.f55548h;
        if (hVar != null) {
            if (hVar.m == null) {
                hVar.m = new j();
            }
            this.f55548h.m.f55563a = z;
        }
    }

    public final void g() {
        d dVar = this.f55547g;
        if (dVar != null) {
            this.f55541a.add(dVar);
        } else if (this.f55542b == null) {
        } else {
            d dVar2 = new d();
            this.f55547g = dVar2;
            dVar2.f55535e = this.f55542b.getFansNum();
            this.f55547g.f55536f = this.f55542b.getConcern_num();
            this.f55547g.f55537g = this.f55542b.getLike_bars();
            this.f55547g.f55538h = this.f55542b.getThreadNum();
            d dVar3 = this.f55547g;
            dVar3.j = this.f55542b;
            this.f55541a.add(dVar3);
        }
    }

    public final void h() {
        if (d.a.m0.r.d0.b.j().k("key_create_center_entrance_switch", 0) == 0) {
            return;
        }
        g gVar = new g();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            g.a aVar = new g.a();
            aVar.f55554b = this.q[i2];
            if (i2 == 1) {
                UserData userData = this.f55542b;
                if (userData != null && userData.isNewGod()) {
                    aVar.f55555c = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                    aVar.f55553a = 5;
                } else {
                    aVar.f55555c = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                    aVar.f55553a = 2;
                }
            } else {
                aVar.f55555c = TbadkCoreApplication.getInst().getString(this.p[i2]);
                aVar.f55553a = this.r[i2];
            }
            arrayList.add(aVar);
        }
        gVar.h(arrayList);
        gVar.f55552f = this.f55542b;
        this.f55541a.add(gVar);
    }

    public final h i(int i2, int i3, int i4) {
        h hVar = new h();
        hVar.f55557f = i2;
        hVar.f55560i = TbadkCoreApplication.getInst().getString(i3);
        hVar.f55556e = i4;
        UserData userData = this.f55542b;
        if (userData != null) {
            hVar.l = userData;
        }
        return hVar;
    }

    public final h j(int i2, String str, int i3) {
        h hVar = new h();
        hVar.f55557f = i2;
        hVar.f55560i = str;
        hVar.f55556e = i3;
        UserData userData = this.f55542b;
        if (userData != null) {
            hVar.l = userData;
        }
        return hVar;
    }

    public final void k() {
        if (this.f55548h == null) {
            h i2 = i(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.f55548h = i2;
            i2.f55558g = true;
            i2.m = new j();
        }
        this.f55541a.add(this.f55548h);
        h i3 = i(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        i3.f55558g = true;
        i3.j = true;
        this.f55541a.add(i3);
        h i4 = i(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        i4.j = true;
        i4.f55558g = true;
        d.a.n0.x0.b bVar = this.f55544d;
        if (bVar != null && bVar.a() && !TextUtils.isEmpty(this.f55544d.f63221b)) {
            h i5 = i(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            i5.f55558g = true;
            i5.k = this.f55544d.f63221b;
            this.f55541a.add(i5);
        }
        h i6 = i(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        i6.f55558g = true;
        i6.m = new j();
        if (!d.a.m0.r.d0.b.j().g("key_has_borrow_cash_clicked", false)) {
            i6.m.f55563a = true;
        }
        i6.m.f55570h = true;
        this.f55541a.add(i6);
        if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
            h i7 = i(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            i7.f55558g = true;
            i7.k = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.f55541a.add(i7);
        }
        if (d.a.m0.r.d0.b.j().k("baidu_financial_display", 1) == 1) {
            h i8 = i(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            i8.f55558g = true;
            if (!d.a.m0.r.d0.b.j().g("key_baidu_financial_has_clicked", false)) {
                j jVar = new j();
                i8.m = jVar;
                jVar.f55563a = true;
            }
            this.f55541a.add(i8);
        }
        Duxiaoman duxiaoman = this.f55543c;
        if (duxiaoman != null && duxiaoman.is_end.intValue() != 1) {
            h i9 = i(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            i9.f55558g = true;
            i9.k = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.f55543c.total_cash.intValue();
            if (intValue > 0) {
                j jVar2 = new j();
                jVar2.f55565c = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar2.f55566d = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                i9.m = jVar2;
            }
            this.f55541a.add(i9);
        }
        h i10 = i(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        i10.f55558g = true;
        this.f55541a.add(i10);
        h i11 = i(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        i11.f55558g = true;
        this.f55541a.add(i11);
        h i12 = i(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.f55549i = i12;
        i12.m = new j();
        this.f55549i.f55558g = true;
        String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.f55542b.getTDouNum());
        if (CurrencySwitchUtil.isYyIsConvert()) {
            formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.f55542b.getTDouNum());
        }
        j jVar3 = this.f55549i.m;
        jVar3.f55565c = formatNumForTdouDisPlay;
        jVar3.f55567e = CurrencySwitchUtil.getMoneyIcon();
        this.f55541a.add(this.f55549i);
        h i13 = i(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        i13.f55558g = true;
        this.f55541a.add(i13);
        h i14 = i(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        i14.f55558g = true;
        MembershipUserInfo membershipUserInfo = this.f55542b.membershipInfo;
        if (membershipUserInfo != null) {
            i14.k = membershipUserInfo.mLink;
        }
        this.f55541a.add(i14);
        boolean f2 = TbadkCoreApplication.getInst().getActivityPrizeData().f();
        String e2 = TbadkCoreApplication.getInst().getActivityPrizeData().e();
        if (f2 && !StringUtils.isNull(e2)) {
            h j = j(R.drawable.icon_mine_list_logingift, e2, 38);
            this.j = j;
            j.j = true;
            j.m = new j();
            this.f55541a.add(this.j);
            TiebaStatic.log(new StatisticItem("c12597"));
        } else {
            i14.j = true;
        }
        h i15 = i(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        i15.f55558g = true;
        this.f55541a.add(i15);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h i16 = i(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            i16.f55558g = true;
            i16.j = true;
            this.f55541a.add(i16);
        }
        h i17 = i(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.k = i17;
        i17.j = true;
        i17.f55558g = true;
        this.f55541a.add(i17);
        h i18 = i(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        i18.f55558g = true;
        this.f55541a.add(i18);
        if (this.m == null) {
            this.m = new PersonMoreData();
        }
        h i19 = i(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        i19.f55558g = true;
        i19.f55559h = true;
        i19.n = OrmObject.bundleWithObject(this.m);
        i19.m = new j();
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
                i19.m.f55564b = o(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.f55541a.add(i19);
    }

    public final void l(List<SmartApp> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o == null) {
            k kVar = new k();
            this.o = kVar;
            this.f55541a.add(kVar);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new m(smartApp));
                }
            }
        }
        this.o.l(arrayList);
    }

    public final void m() {
        n nVar = this.n;
        if (nVar != null) {
            this.f55541a.add(nVar);
            return;
        }
        this.n = new n();
        if (ListUtils.isEmpty(this.f55545e)) {
            return;
        }
        for (int i2 = 0; i2 < this.f55545e.size(); i2++) {
            a aVar = new a();
            aVar.d(this.f55545e.get(i2));
            if (!d.a.c.e.p.k.isEmpty(aVar.c())) {
                this.n.f55582e.add(aVar);
            }
        }
        if (this.n.f55582e.size() > 0) {
            this.f55541a.add(this.n);
        }
    }

    public ArrayList<d.a.c.j.e.n> n() {
        return this.f55541a;
    }

    public final String o(@StringRes int i2, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i2, objArr);
    }

    public UserData p() {
        return this.f55542b;
    }

    public final void q(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            d.a.n0.g2.i.a aVar = new d.a.n0.g2.i.a();
            aVar.a(tbBookrack);
            new d.a.n0.g2.i.d(true, aVar);
        }
    }

    public final void r(UcCard ucCard) {
        new d.a.n0.g2.g().a(ucCard);
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
        if (this.f55542b == null) {
            this.f55542b = new UserData();
        }
        this.f55542b.parserProtobuf(user);
        if (this.f55546f == null && userGodInfo != null) {
            this.f55546f = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.f55542b.setIsBigV(true);
            this.f55546f.parserProtobuf(userGodInfo);
        }
        this.l.f55562e = this.f55542b;
    }

    public void u(d.a.m0.t.n nVar) {
        this.f55542b.setPendantData(nVar);
    }
}
