package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.BannerImage;
import tbclient.CreationData;
import tbclient.DuxiaomanEntry;
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
/* loaded from: classes6.dex */
public class o18 implements d08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<nn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public n18 e;
    public p18 f;
    public r18 g;
    public r18 h;
    public r18 i;
    public r18 j;
    public s18 k;
    public PersonMoreData l;
    public y18 m;
    public v18 n;
    public q18 o;

    public o18() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    @Override // com.repackage.d08
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        s18 s18Var = new s18();
        this.k = s18Var;
        s18Var.a = this.b;
        this.a.add(s18Var);
        g();
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.repackage.d08
    public void b(ProfileResIdl profileResIdl) {
        DuxiaomanEntry duxiaomanEntry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.k = new s18();
        DataRes dataRes = profileResIdl.data;
        this.c = dataRes.banner;
        Duxiaoman duxiaoman = dataRes.duxiaoman;
        u(dataRes.user, dataRes.user_god_info);
        r(profileResIdl.data.tbbookrack);
        s(profileResIdl.data.uc_card);
        t(profileResIdl.data.url_map);
        this.a.add(this.k);
        g();
        o();
        DataRes dataRes2 = profileResIdl.data;
        if (dataRes2.finance_tab != null && (duxiaomanEntry = dataRes2.duxiaoman_entry) != null) {
            i(duxiaomanEntry);
        }
        h(profileResIdl.data.user);
        m();
        n(profileResIdl.data.recom_swan_list);
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
    }

    public void c(boolean z) {
        r18 r18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (r18Var = this.i) == null) {
            return;
        }
        if (r18Var.i == null) {
            r18Var.i = new t18();
        }
        this.i.i.a = z;
    }

    public void d(boolean z) {
        n18 n18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (n18Var = this.e) == null) {
            return;
        }
        n18Var.d = z;
    }

    public void e(boolean z) {
        r18 r18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (r18Var = this.j) == null) {
            return;
        }
        if (r18Var.i == null) {
            r18Var.i = new t18();
        }
        this.j.i.a = z;
    }

    public void f(boolean z) {
        r18 r18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (r18Var = this.g) == null) {
            return;
        }
        if (r18Var.i == null) {
            r18Var.i = new t18();
        }
        this.g.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            n18 n18Var = this.e;
            if (n18Var != null) {
                this.a.add(n18Var);
            } else if (this.b == null) {
            } else {
                this.e = new n18();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                n18 n18Var2 = this.e;
                n18Var2.e = this.b;
                this.a.add(n18Var2);
            }
        }
    }

    public final void h(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            q18 q18Var = this.o;
            if (q18Var != null) {
                this.a.add(q18Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            q18 q18Var2 = new q18();
            this.o = q18Var2;
            q18Var2.g(creationData);
            this.o.i(creationData2);
            this.a.add(this.o);
        }
    }

    public final void i(DuxiaomanEntry duxiaomanEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, duxiaomanEntry) == null) {
            p18 p18Var = this.f;
            if (p18Var != null) {
                this.a.add(p18Var);
                return;
            }
            p18 p18Var2 = new p18();
            this.f = p18Var2;
            p18Var2.d(duxiaomanEntry);
            this.a.add(this.f);
        }
    }

    public final r18 j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            r18 r18Var = new r18();
            r18Var.b = i;
            r18Var.e = TbadkCoreApplication.getInst().getString(i2);
            r18Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                r18Var.h = userData;
            }
            return r18Var;
        }
        return (r18) invokeIII.objValue;
    }

    public final r18 k(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            r18 r18Var = new r18();
            r18Var.b = i;
            r18Var.e = str;
            r18Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                r18Var.h = userData;
            }
            return r18Var;
        }
        return (r18) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            r18 j = j(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e4e, 31);
            this.j = j;
            j.c = true;
            this.a.add(j);
            r18 j2 = j(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02d1, 39);
            j2.c = true;
            this.a.add(j2);
            r18 k = k(R.drawable.obfuscated_res_0x7f08083c, "订单中心", 47);
            k.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(k);
            r18 k2 = k(R.drawable.obfuscated_res_0x7f08082a, "开店", 48);
            k2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(k2);
            r18 k3 = k(R.drawable.obfuscated_res_0x7f08081f, "广告推广", 49);
            k3.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(k3);
            if (this.l == null) {
                this.l = new PersonMoreData();
            }
            r18 j3 = j(R.drawable.obfuscated_res_0x7f08083b, R.string.obfuscated_res_0x7f0f0e0e, 33);
            j3.j = OrmObject.bundleWithObject(this.l);
            j3.i = new t18();
            this.a.add(j3);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            u18 u18Var = new u18();
            ArrayList arrayList = new ArrayList();
            r18 j = j(R.drawable.obfuscated_res_0x7f080828, R.string.obfuscated_res_0x7f0f0aa1, 12);
            j.c = true;
            arrayList.add(j);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(j(R.drawable.obfuscated_res_0x7f0807b2, R.string.obfuscated_res_0x7f0f0385, 53));
            r18 j2 = j(R.drawable.obfuscated_res_0x7f080821, R.string.obfuscated_res_0x7f0f045e, 56);
            j2.g = TbConfig.CREATE_BA;
            arrayList.add(j2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                r18 j3 = j(R.drawable.obfuscated_res_0x7f080827, R.string.obfuscated_res_0x7f0f0221, 25);
                j3.c = true;
                j3.f = true;
                arrayList.add(j3);
            }
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08082d, R.string.obfuscated_res_0x7f0f0791, 58));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                r18 j4 = j(R.drawable.obfuscated_res_0x7f080820, R.string.obfuscated_res_0x7f0f0cb9, 15);
                j4.c = true;
                arrayList.add(j4);
            }
            r18 j5 = j(R.drawable.obfuscated_res_0x7f080826, R.string.obfuscated_res_0x7f0f006b, 50);
            j5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(j5);
            r18 j6 = j(R.drawable.obfuscated_res_0x7f080823, R.string.obfuscated_res_0x7f0f0b36, 10);
            this.h = j6;
            j6.i = new t18();
            this.h.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            t18 t18Var = this.h.i;
            t18Var.c = formatNumForTdouDisPlay;
            t18Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.h);
            r18 j7 = j(R.drawable.obfuscated_res_0x7f080829, R.string.obfuscated_res_0x7f0f037c, 18);
            j7.c = true;
            arrayList.add(j7);
            r18 j8 = j(R.drawable.obfuscated_res_0x7f08082c, R.string.obfuscated_res_0x7f0f0a81, 51);
            j8.g = "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(j8);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08082b, R.string.obfuscated_res_0x7f0f122d, 52));
            r18 j9 = j(R.drawable.obfuscated_res_0x7f080824, R.string.obfuscated_res_0x7f0f0cad, 54);
            j9.g = l85.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(j9);
            r18 j10 = j(R.drawable.obfuscated_res_0x7f080836, R.string.obfuscated_res_0x7f0f0412, 55);
            j10.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(j10);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080825, R.string.obfuscated_res_0x7f0f0519, 57));
            u18Var.d(arrayList);
            this.a.add(u18Var);
        }
    }

    public final void n(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.n == null) {
            v18 v18Var = new v18();
            this.n = v18Var;
            this.a.add(v18Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new x18(smartApp));
                }
            }
        }
        this.n.d(arrayList);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            y18 y18Var = this.m;
            if (y18Var != null) {
                this.a.add(y18Var);
                return;
            }
            this.m = new y18();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                k18 k18Var = new k18();
                k18Var.d(this.c.get(i));
                if (!oi.isEmpty(k18Var.c())) {
                    this.m.a.add(k18Var);
                }
            }
            if (this.m.a.size() > 0) {
                this.a.add(this.m);
            }
        }
    }

    public ArrayList<nn> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public UserData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.b : (UserData) invokeV.objValue;
    }

    public final void r(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        q08 q08Var = new q08();
        q08Var.a(tbBookrack);
        new t08(true, q08Var);
    }

    public final void s(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ucCard) == null) {
            new j08().a(ucCard);
        }
    }

    public final void t(List<UserMap> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.l = new PersonMoreData();
        for (UserMap userMap : list) {
            if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                String replaceAll = userMap.url.replaceAll("amp;", "");
                PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                personMoreItemData.mId = userMap.id.intValue();
                personMoreItemData.mName = userMap.name;
                personMoreItemData.mUrl = replaceAll;
                this.l.mUrlMaps.add(personMoreItemData);
            }
        }
    }

    public final void u(User user, UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, user, userGodInfo) == null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(user);
            if (this.d == null && userGodInfo != null) {
                this.d = new PersonUserGodInfo();
            }
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.b.setIsBigV(true);
                PersonUserGodInfo personUserGodInfo = this.d;
                if (personUserGodInfo != null) {
                    personUserGodInfo.parserProtobuf(userGodInfo);
                }
            }
            this.k.a = this.b;
        }
    }

    public void v(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }
}
