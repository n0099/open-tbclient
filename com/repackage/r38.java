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
public class r38 implements f28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<on> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public q38 e;
    public s38 f;
    public t38 g;
    public v38 h;
    public v38 i;
    public v38 j;
    public v38 k;
    public w38 l;
    public PersonMoreData m;
    public c48 n;
    public z38 o;
    public u38 p;

    public r38() {
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

    @Override // com.repackage.f28
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        w38 w38Var = new w38();
        this.l = w38Var;
        w38Var.a = this.b;
        this.a.add(w38Var);
        g();
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.repackage.f28
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        DuxiaomanEntry duxiaomanEntry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new w38();
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
        v38 v38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (v38Var = this.j) == null) {
            return;
        }
        if (v38Var.i == null) {
            v38Var.i = new x38();
        }
        this.j.i.a = z;
    }

    public void d(boolean z) {
        q38 q38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (q38Var = this.e) == null) {
            return;
        }
        q38Var.d = z;
    }

    public void e(boolean z) {
        v38 v38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (v38Var = this.k) == null) {
            return;
        }
        if (v38Var.i == null) {
            v38Var.i = new x38();
        }
        this.k.i.a = z;
    }

    public void f(boolean z) {
        v38 v38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (v38Var = this.h) == null) {
            return;
        }
        if (v38Var.i == null) {
            v38Var.i = new x38();
        }
        this.h.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            q38 q38Var = this.e;
            if (q38Var != null) {
                this.a.add(q38Var);
            } else if (this.b == null) {
            } else {
                this.e = new q38();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                q38 q38Var2 = this.e;
                q38Var2.e = this.b;
                this.a.add(q38Var2);
            }
        }
    }

    public final void h(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            u38 u38Var = this.p;
            if (u38Var != null) {
                this.a.add(u38Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            u38 u38Var2 = new u38();
            this.p = u38Var2;
            u38Var2.h(creationData);
            this.p.j(creationData2);
            this.a.add(this.p);
        }
    }

    public final void i(DuxiaomanEntry duxiaomanEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, duxiaomanEntry) == null) {
            s38 s38Var = this.f;
            if (s38Var != null) {
                this.a.add(s38Var);
                return;
            }
            s38 s38Var2 = new s38();
            this.f = s38Var2;
            s38Var2.f(duxiaomanEntry);
            this.a.add(this.f);
        }
    }

    public final v38 j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            v38 v38Var = new v38();
            v38Var.b = i;
            v38Var.e = TbadkCoreApplication.getInst().getString(i2);
            v38Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                v38Var.h = userData;
            }
            return v38Var;
        }
        return (v38) invokeIII.objValue;
    }

    public final v38 k(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            v38 v38Var = new v38();
            v38Var.b = i;
            v38Var.e = str;
            v38Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                v38Var.h = userData;
            }
            return v38Var;
        }
        return (v38) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            v38 j = j(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e65, 31);
            this.k = j;
            j.c = true;
            this.a.add(j);
            v38 j2 = j(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02d5, 39);
            j2.c = true;
            this.a.add(j2);
            v38 k = k(R.drawable.obfuscated_res_0x7f080858, "订单中心", 47);
            k.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(k);
            v38 k2 = k(R.drawable.obfuscated_res_0x7f080846, "开店", 48);
            k2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(k2);
            v38 k3 = k(R.drawable.obfuscated_res_0x7f08083a, "广告推广", 49);
            k3.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(k3);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            v38 j3 = j(R.drawable.obfuscated_res_0x7f080857, R.string.obfuscated_res_0x7f0f0e25, 33);
            j3.j = OrmObject.bundleWithObject(this.m);
            j3.i = new x38();
            this.a.add(j3);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            y38 y38Var = new y38();
            ArrayList arrayList = new ArrayList();
            v38 j = j(R.drawable.obfuscated_res_0x7f080844, R.string.obfuscated_res_0x7f0f0ab2, 12);
            j.c = true;
            arrayList.add(j);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(j(R.drawable.obfuscated_res_0x7f0807ba, R.string.obfuscated_res_0x7f0f038b, 53));
            v38 j2 = j(R.drawable.obfuscated_res_0x7f08083d, R.string.obfuscated_res_0x7f0f0468, 56);
            j2.g = TbConfig.CREATE_BA;
            arrayList.add(j2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                v38 j3 = j(R.drawable.obfuscated_res_0x7f080843, R.string.obfuscated_res_0x7f0f0224, 25);
                j3.c = true;
                j3.f = true;
                arrayList.add(j3);
            }
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080849, R.string.obfuscated_res_0x7f0f079c, 58));
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08083b, R.string.obfuscated_res_0x7f0f0327, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                v38 j4 = j(R.drawable.obfuscated_res_0x7f08083c, R.string.obfuscated_res_0x7f0f0ccb, 15);
                j4.c = true;
                arrayList.add(j4);
            }
            v38 j5 = j(R.drawable.obfuscated_res_0x7f080842, R.string.obfuscated_res_0x7f0f006b, 50);
            j5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(j5);
            v38 j6 = j(R.drawable.obfuscated_res_0x7f08083f, R.string.obfuscated_res_0x7f0f0b47, 10);
            this.i = j6;
            j6.i = new x38();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            x38 x38Var = this.i.i;
            x38Var.c = formatNumForTdouDisPlay;
            x38Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            v38 j7 = j(R.drawable.obfuscated_res_0x7f080845, R.string.obfuscated_res_0x7f0f0382, 18);
            j7.c = true;
            arrayList.add(j7);
            v38 j8 = j(R.drawable.obfuscated_res_0x7f080848, R.string.obfuscated_res_0x7f0f0a92, 51);
            j8.g = "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(j8);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080847, R.string.obfuscated_res_0x7f0f121a, 52));
            v38 j9 = j(R.drawable.obfuscated_res_0x7f080840, R.string.obfuscated_res_0x7f0f0cbf, 54);
            j9.g = k95.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(j9);
            v38 j10 = j(R.drawable.obfuscated_res_0x7f080852, R.string.obfuscated_res_0x7f0f041c, 55);
            j10.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(j10);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080841, R.string.obfuscated_res_0x7f0f0522, 57));
            y38Var.f(arrayList);
            this.a.add(y38Var);
        }
    }

    public final void n(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o == null) {
            z38 z38Var = new z38();
            this.o = z38Var;
            this.a.add(z38Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new b48(smartApp));
                }
            }
        }
        this.o.f(arrayList);
    }

    public final void o(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, userGrowth) == null) {
            t38 t38Var = this.g;
            if (t38Var != null) {
                this.a.add(t38Var);
                return;
            }
            this.g = new t38();
            t15 t15Var = new t15();
            t15Var.g(userGrowth);
            this.g.f(t15Var);
            this.a.add(this.g);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c48 c48Var = this.n;
            if (c48Var != null) {
                this.a.add(c48Var);
                return;
            }
            this.n = new c48();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                n38 n38Var = new n38();
                n38Var.d(this.c.get(i));
                if (!pi.isEmpty(n38Var.c())) {
                    this.n.a.add(n38Var);
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
        s28 s28Var = new s28();
        s28Var.a(tbBookrack);
        new v28(true, s28Var);
    }

    public final void t(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ucCard) == null) {
            new l28().a(ucCard);
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
