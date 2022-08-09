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
import tbclient.UserGrowth;
import tbclient.UserMap;
/* loaded from: classes7.dex */
public class s38 implements g28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<on> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public r38 e;
    public t38 f;
    public u38 g;
    public w38 h;
    public w38 i;
    public w38 j;
    public w38 k;
    public x38 l;
    public PersonMoreData m;
    public d48 n;
    public a48 o;
    public v38 p;

    public s38() {
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

    @Override // com.repackage.g28
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        x38 x38Var = new x38();
        this.l = x38Var;
        x38Var.a = this.b;
        this.a.add(x38Var);
        g();
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.repackage.g28
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        DuxiaomanEntry duxiaomanEntry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new x38();
        DataRes dataRes = profileResIdl.data;
        this.c = dataRes.banner;
        Duxiaoman duxiaoman = dataRes.duxiaoman;
        v(dataRes.user, dataRes.user_god_info);
        s(profileResIdl.data.tbbookrack);
        t(profileResIdl.data.uc_card);
        u(profileResIdl.data.url_map);
        this.a.add(this.l);
        g();
        p();
        DataRes dataRes2 = profileResIdl.data;
        if (dataRes2.finance_tab != null && (duxiaomanEntry = dataRes2.duxiaoman_entry) != null) {
            i(duxiaomanEntry);
        }
        User user = profileResIdl.data.user;
        if (user != null && (userGrowth = user.user_growth) != null) {
            o(userGrowth);
        }
        h(profileResIdl.data.user);
        m();
        n(profileResIdl.data.recom_swan_list);
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
    }

    public void c(boolean z) {
        w38 w38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (w38Var = this.j) == null) {
            return;
        }
        if (w38Var.i == null) {
            w38Var.i = new y38();
        }
        this.j.i.a = z;
    }

    public void d(boolean z) {
        r38 r38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (r38Var = this.e) == null) {
            return;
        }
        r38Var.d = z;
    }

    public void e(boolean z) {
        w38 w38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (w38Var = this.k) == null) {
            return;
        }
        if (w38Var.i == null) {
            w38Var.i = new y38();
        }
        this.k.i.a = z;
    }

    public void f(boolean z) {
        w38 w38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (w38Var = this.h) == null) {
            return;
        }
        if (w38Var.i == null) {
            w38Var.i = new y38();
        }
        this.h.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            r38 r38Var = this.e;
            if (r38Var != null) {
                this.a.add(r38Var);
            } else if (this.b == null) {
            } else {
                this.e = new r38();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                r38 r38Var2 = this.e;
                r38Var2.e = this.b;
                this.a.add(r38Var2);
            }
        }
    }

    public final void h(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            v38 v38Var = this.p;
            if (v38Var != null) {
                this.a.add(v38Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            v38 v38Var2 = new v38();
            this.p = v38Var2;
            v38Var2.h(creationData);
            this.p.j(creationData2);
            this.a.add(this.p);
        }
    }

    public final void i(DuxiaomanEntry duxiaomanEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, duxiaomanEntry) == null) {
            t38 t38Var = this.f;
            if (t38Var != null) {
                this.a.add(t38Var);
                return;
            }
            t38 t38Var2 = new t38();
            this.f = t38Var2;
            t38Var2.f(duxiaomanEntry);
            this.a.add(this.f);
        }
    }

    public final w38 j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            w38 w38Var = new w38();
            w38Var.b = i;
            w38Var.e = TbadkCoreApplication.getInst().getString(i2);
            w38Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                w38Var.h = userData;
            }
            return w38Var;
        }
        return (w38) invokeIII.objValue;
    }

    public final w38 k(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            w38 w38Var = new w38();
            w38Var.b = i;
            w38Var.e = str;
            w38Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                w38Var.h = userData;
            }
            return w38Var;
        }
        return (w38) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            w38 j = j(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e64, 31);
            this.k = j;
            j.c = true;
            this.a.add(j);
            w38 j2 = j(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02d5, 39);
            j2.c = true;
            this.a.add(j2);
            w38 k = k(R.drawable.obfuscated_res_0x7f080856, "订单中心", 47);
            k.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(k);
            w38 k2 = k(R.drawable.obfuscated_res_0x7f080844, "开店", 48);
            k2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(k2);
            w38 k3 = k(R.drawable.obfuscated_res_0x7f080838, "广告推广", 49);
            k3.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(k3);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            w38 j3 = j(R.drawable.obfuscated_res_0x7f080855, R.string.obfuscated_res_0x7f0f0e24, 33);
            j3.j = OrmObject.bundleWithObject(this.m);
            j3.i = new y38();
            this.a.add(j3);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            z38 z38Var = new z38();
            ArrayList arrayList = new ArrayList();
            w38 j = j(R.drawable.obfuscated_res_0x7f080842, R.string.obfuscated_res_0x7f0f0ab1, 12);
            j.c = true;
            arrayList.add(j);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(j(R.drawable.obfuscated_res_0x7f0807ba, R.string.obfuscated_res_0x7f0f038b, 53));
            w38 j2 = j(R.drawable.obfuscated_res_0x7f08083b, R.string.obfuscated_res_0x7f0f0468, 56);
            j2.g = TbConfig.CREATE_BA;
            arrayList.add(j2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                w38 j3 = j(R.drawable.obfuscated_res_0x7f080841, R.string.obfuscated_res_0x7f0f0224, 25);
                j3.c = true;
                j3.f = true;
                arrayList.add(j3);
            }
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080847, R.string.obfuscated_res_0x7f0f079c, 58));
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080839, R.string.obfuscated_res_0x7f0f0327, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                w38 j4 = j(R.drawable.obfuscated_res_0x7f08083a, R.string.obfuscated_res_0x7f0f0cca, 15);
                j4.c = true;
                arrayList.add(j4);
            }
            w38 j5 = j(R.drawable.obfuscated_res_0x7f080840, R.string.obfuscated_res_0x7f0f006b, 50);
            j5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(j5);
            w38 j6 = j(R.drawable.obfuscated_res_0x7f08083d, R.string.obfuscated_res_0x7f0f0b46, 10);
            this.i = j6;
            j6.i = new y38();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            y38 y38Var = this.i.i;
            y38Var.c = formatNumForTdouDisPlay;
            y38Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            w38 j7 = j(R.drawable.obfuscated_res_0x7f080843, R.string.obfuscated_res_0x7f0f0382, 18);
            j7.c = true;
            arrayList.add(j7);
            w38 j8 = j(R.drawable.obfuscated_res_0x7f080846, R.string.obfuscated_res_0x7f0f0a91, 51);
            j8.g = "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(j8);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080845, R.string.obfuscated_res_0x7f0f1218, 52));
            w38 j9 = j(R.drawable.obfuscated_res_0x7f08083e, R.string.obfuscated_res_0x7f0f0cbe, 54);
            j9.g = k95.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(j9);
            w38 j10 = j(R.drawable.obfuscated_res_0x7f080850, R.string.obfuscated_res_0x7f0f041c, 55);
            j10.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(j10);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08083f, R.string.obfuscated_res_0x7f0f0522, 57));
            z38Var.f(arrayList);
            this.a.add(z38Var);
        }
    }

    public final void n(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o == null) {
            a48 a48Var = new a48();
            this.o = a48Var;
            this.a.add(a48Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new c48(smartApp));
                }
            }
        }
        this.o.f(arrayList);
    }

    public final void o(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, userGrowth) == null) {
            u38 u38Var = this.g;
            if (u38Var != null) {
                this.a.add(u38Var);
                return;
            }
            this.g = new u38();
            t15 t15Var = new t15();
            t15Var.f(userGrowth);
            this.g.f(t15Var);
            this.a.add(this.g);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d48 d48Var = this.n;
            if (d48Var != null) {
                this.a.add(d48Var);
                return;
            }
            this.n = new d48();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                o38 o38Var = new o38();
                o38Var.d(this.c.get(i));
                if (!pi.isEmpty(o38Var.c())) {
                    this.n.a.add(o38Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }

    public ArrayList<on> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public UserData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.b : (UserData) invokeV.objValue;
    }

    public final void s(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        t28 t28Var = new t28();
        t28Var.a(tbBookrack);
        new w28(true, t28Var);
    }

    public final void t(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ucCard) == null) {
            new m28().a(ucCard);
        }
    }

    public final void u(List<UserMap> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || ListUtils.isEmpty(list)) {
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

    public final void v(User user, UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, user, userGodInfo) == null) {
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
            this.l.a = this.b;
        }
    }

    public void w(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }
}
