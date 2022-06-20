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
/* loaded from: classes7.dex */
public class t08 implements jz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<nn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public s08 e;
    public u08 f;
    public w08 g;
    public w08 h;
    public w08 i;
    public w08 j;
    public x08 k;
    public PersonMoreData l;
    public d18 m;
    public a18 n;
    public v08 o;

    public t08() {
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

    @Override // com.repackage.jz7
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        x08 x08Var = new x08();
        this.k = x08Var;
        x08Var.a = this.b;
        this.a.add(x08Var);
        g();
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.repackage.jz7
    public void b(ProfileResIdl profileResIdl) {
        DuxiaomanEntry duxiaomanEntry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.k = new x08();
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
        w08 w08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (w08Var = this.i) == null) {
            return;
        }
        if (w08Var.i == null) {
            w08Var.i = new y08();
        }
        this.i.i.a = z;
    }

    public void d(boolean z) {
        s08 s08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (s08Var = this.e) == null) {
            return;
        }
        s08Var.d = z;
    }

    public void e(boolean z) {
        w08 w08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (w08Var = this.j) == null) {
            return;
        }
        if (w08Var.i == null) {
            w08Var.i = new y08();
        }
        this.j.i.a = z;
    }

    public void f(boolean z) {
        w08 w08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (w08Var = this.g) == null) {
            return;
        }
        if (w08Var.i == null) {
            w08Var.i = new y08();
        }
        this.g.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            s08 s08Var = this.e;
            if (s08Var != null) {
                this.a.add(s08Var);
            } else if (this.b == null) {
            } else {
                this.e = new s08();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                s08 s08Var2 = this.e;
                s08Var2.e = this.b;
                this.a.add(s08Var2);
            }
        }
    }

    public final void h(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            v08 v08Var = this.o;
            if (v08Var != null) {
                this.a.add(v08Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            v08 v08Var2 = new v08();
            this.o = v08Var2;
            v08Var2.h(creationData);
            this.o.j(creationData2);
            this.a.add(this.o);
        }
    }

    public final void i(DuxiaomanEntry duxiaomanEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, duxiaomanEntry) == null) {
            u08 u08Var = this.f;
            if (u08Var != null) {
                this.a.add(u08Var);
                return;
            }
            u08 u08Var2 = new u08();
            this.f = u08Var2;
            u08Var2.f(duxiaomanEntry);
            this.a.add(this.f);
        }
    }

    public final w08 j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            w08 w08Var = new w08();
            w08Var.b = i;
            w08Var.e = TbadkCoreApplication.getInst().getString(i2);
            w08Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                w08Var.h = userData;
            }
            return w08Var;
        }
        return (w08) invokeIII.objValue;
    }

    public final w08 k(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            w08 w08Var = new w08();
            w08Var.b = i;
            w08Var.e = str;
            w08Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                w08Var.h = userData;
            }
            return w08Var;
        }
        return (w08) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            w08 j = j(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e58, 31);
            this.j = j;
            j.c = true;
            this.a.add(j);
            w08 j2 = j(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02cd, 39);
            j2.c = true;
            this.a.add(j2);
            w08 k = k(R.drawable.obfuscated_res_0x7f080833, "订单中心", 47);
            k.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(k);
            w08 k2 = k(R.drawable.obfuscated_res_0x7f080821, "开店", 48);
            k2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(k2);
            w08 k3 = k(R.drawable.obfuscated_res_0x7f080816, "广告推广", 49);
            k3.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(k3);
            if (this.l == null) {
                this.l = new PersonMoreData();
            }
            w08 j3 = j(R.drawable.obfuscated_res_0x7f080832, R.string.obfuscated_res_0x7f0f0e18, 33);
            j3.j = OrmObject.bundleWithObject(this.l);
            j3.i = new y08();
            this.a.add(j3);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            z08 z08Var = new z08();
            ArrayList arrayList = new ArrayList();
            w08 j = j(R.drawable.obfuscated_res_0x7f08081f, R.string.obfuscated_res_0x7f0f0ab3, 12);
            j.c = true;
            arrayList.add(j);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(j(R.drawable.obfuscated_res_0x7f0807b0, R.string.obfuscated_res_0x7f0f0381, 53));
            w08 j2 = j(R.drawable.obfuscated_res_0x7f080818, R.string.obfuscated_res_0x7f0f0456, 56);
            j2.g = TbConfig.CREATE_BA;
            arrayList.add(j2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                w08 j3 = j(R.drawable.obfuscated_res_0x7f08081e, R.string.obfuscated_res_0x7f0f021f, 25);
                j3.c = true;
                j3.f = true;
                arrayList.add(j3);
            }
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080824, R.string.obfuscated_res_0x7f0f0787, 58));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                w08 j4 = j(R.drawable.obfuscated_res_0x7f080817, R.string.obfuscated_res_0x7f0f0cc5, 15);
                j4.c = true;
                arrayList.add(j4);
            }
            w08 j5 = j(R.drawable.obfuscated_res_0x7f08081d, R.string.obfuscated_res_0x7f0f006b, 50);
            j5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(j5);
            w08 j6 = j(R.drawable.obfuscated_res_0x7f08081a, R.string.obfuscated_res_0x7f0f0b47, 10);
            this.h = j6;
            j6.i = new y08();
            this.h.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            y08 y08Var = this.h.i;
            y08Var.c = formatNumForTdouDisPlay;
            y08Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.h);
            w08 j7 = j(R.drawable.obfuscated_res_0x7f080820, R.string.obfuscated_res_0x7f0f0378, 18);
            j7.c = true;
            arrayList.add(j7);
            w08 j8 = j(R.drawable.obfuscated_res_0x7f080823, R.string.obfuscated_res_0x7f0f0a93, 51);
            j8.g = "http://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(j8);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080822, R.string.obfuscated_res_0x7f0f1234, 52));
            w08 j9 = j(R.drawable.obfuscated_res_0x7f08081b, R.string.obfuscated_res_0x7f0f0cb9, 54);
            j9.g = j75.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(j9);
            w08 j10 = j(R.drawable.obfuscated_res_0x7f08082d, R.string.obfuscated_res_0x7f0f040a, 55);
            j10.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(j10);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08081c, R.string.obfuscated_res_0x7f0f050f, 57));
            z08Var.f(arrayList);
            this.a.add(z08Var);
        }
    }

    public final void n(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.n == null) {
            a18 a18Var = new a18();
            this.n = a18Var;
            this.a.add(a18Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new c18(smartApp));
                }
            }
        }
        this.n.f(arrayList);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d18 d18Var = this.m;
            if (d18Var != null) {
                this.a.add(d18Var);
                return;
            }
            this.m = new d18();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                p08 p08Var = new p08();
                p08Var.d(this.c.get(i));
                if (!oi.isEmpty(p08Var.c())) {
                    this.m.a.add(p08Var);
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
        vz7 vz7Var = new vz7();
        vz7Var.a(tbBookrack);
        new yz7(true, vz7Var);
    }

    public final void s(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ucCard) == null) {
            new oz7().a(ucCard);
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
