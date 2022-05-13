package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.DataRes;
import tbclient.Profile.Duxiaoman;
import tbclient.Profile.FinanceTab;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes5.dex */
public class e28 implements t08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ro> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public d28 e;
    public f28 f;
    public i28 g;
    public i28 h;
    public i28 i;
    public i28 j;
    public j28 k;
    public PersonMoreData l;
    public p28 m;
    public m28 n;
    public h28 o;

    public e28() {
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

    @Override // com.repackage.t08
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        j28 j28Var = new j28();
        this.k = j28Var;
        j28Var.a = this.b;
        this.a.add(j28Var);
        g();
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.repackage.t08
    public void b(ProfileResIdl profileResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.k = new j28();
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
        FinanceTab financeTab = profileResIdl.data.finance_tab;
        if (financeTab != null) {
            i(financeTab);
        }
        h(profileResIdl.data.user);
        m();
        n(profileResIdl.data.recom_swan_list);
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
    }

    public void c(boolean z) {
        i28 i28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (i28Var = this.i) == null) {
            return;
        }
        if (i28Var.i == null) {
            i28Var.i = new k28();
        }
        this.i.i.a = z;
    }

    public void d(boolean z) {
        d28 d28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (d28Var = this.e) == null) {
            return;
        }
        d28Var.d = z;
    }

    public void e(boolean z) {
        i28 i28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (i28Var = this.j) == null) {
            return;
        }
        if (i28Var.i == null) {
            i28Var.i = new k28();
        }
        this.j.i.a = z;
    }

    public void f(boolean z) {
        i28 i28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (i28Var = this.g) == null) {
            return;
        }
        if (i28Var.i == null) {
            i28Var.i = new k28();
        }
        this.g.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d28 d28Var = this.e;
            if (d28Var != null) {
                this.a.add(d28Var);
            } else if (this.b == null) {
            } else {
                this.e = new d28();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                d28 d28Var2 = this.e;
                d28Var2.e = this.b;
                this.a.add(d28Var2);
            }
        }
    }

    public final void h(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            h28 h28Var = this.o;
            if (h28Var != null) {
                this.a.add(h28Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            h28 h28Var2 = new h28();
            this.o = h28Var2;
            h28Var2.i(creationData);
            this.o.k(creationData2);
            this.a.add(this.o);
        }
    }

    public final void i(FinanceTab financeTab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, financeTab) == null) {
            f28 f28Var = this.f;
            if (f28Var != null) {
                this.a.add(f28Var);
                return;
            }
            f28 f28Var2 = new f28();
            this.f = f28Var2;
            f28Var2.g(financeTab);
            this.a.add(this.f);
        }
    }

    public final i28 j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            i28 i28Var = new i28();
            i28Var.b = i;
            i28Var.e = TbadkCoreApplication.getInst().getString(i2);
            i28Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                i28Var.h = userData;
            }
            return i28Var;
        }
        return (i28) invokeIII.objValue;
    }

    public final i28 k(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            i28 i28Var = new i28();
            i28Var.b = i;
            i28Var.e = str;
            i28Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                i28Var.h = userData;
            }
            return i28Var;
        }
        return (i28) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            i28 j = j(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e4c, 31);
            this.j = j;
            j.c = true;
            this.a.add(j);
            i28 j2 = j(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02cb, 39);
            j2.c = true;
            this.a.add(j2);
            i28 k = k(R.drawable.obfuscated_res_0x7f080849, "订单中心", 47);
            k.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(k);
            i28 k2 = k(R.drawable.obfuscated_res_0x7f080839, "开店", 48);
            k2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(k2);
            i28 k3 = k(R.drawable.obfuscated_res_0x7f080831, "广告推广", 49);
            k3.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(k3);
            if (this.l == null) {
                this.l = new PersonMoreData();
            }
            i28 j3 = j(R.drawable.obfuscated_res_0x7f080848, R.string.obfuscated_res_0x7f0f0e0c, 33);
            j3.j = OrmObject.bundleWithObject(this.l);
            j3.i = new k28();
            this.a.add(j3);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            l28 l28Var = new l28();
            ArrayList arrayList = new ArrayList();
            i28 j = j(R.drawable.obfuscated_res_0x7f080837, R.string.obfuscated_res_0x7f0f0aa8, 12);
            j.c = true;
            arrayList.add(j);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(j(R.drawable.obfuscated_res_0x7f0807b4, R.string.obfuscated_res_0x7f0f038e, 53));
            if (MessageManager.getInstance().findTask(2921431) != null) {
                i28 j2 = j(R.drawable.obfuscated_res_0x7f080836, R.string.obfuscated_res_0x7f0f021e, 25);
                j2.c = true;
                j2.f = true;
                arrayList.add(j2);
            }
            i28 j3 = j(R.drawable.obfuscated_res_0x7f080832, R.string.obfuscated_res_0x7f0f0cbc, 15);
            j3.c = true;
            arrayList.add(j3);
            i28 j4 = j(R.drawable.obfuscated_res_0x7f080835, R.string.obfuscated_res_0x7f0f006b, 50);
            j4.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(j4);
            i28 j5 = j(R.drawable.obfuscated_res_0x7f080834, R.string.obfuscated_res_0x7f0f0b3d, 10);
            this.h = j5;
            j5.i = new k28();
            this.h.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            k28 k28Var = this.h.i;
            k28Var.c = formatNumForTdouDisPlay;
            k28Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.h);
            i28 j6 = j(R.drawable.obfuscated_res_0x7f080838, R.string.obfuscated_res_0x7f0f0385, 18);
            j6.c = true;
            arrayList.add(j6);
            i28 j7 = j(R.drawable.obfuscated_res_0x7f08083b, R.string.obfuscated_res_0x7f0f0a88, 51);
            j7.g = "http://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(j7);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08083a, R.string.obfuscated_res_0x7f0f1215, 52));
            l28Var.g(arrayList);
            this.a.add(l28Var);
        }
    }

    public final void n(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.n == null) {
            m28 m28Var = new m28();
            this.n = m28Var;
            this.a.add(m28Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new o28(smartApp));
                }
            }
        }
        this.n.g(arrayList);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            p28 p28Var = this.m;
            if (p28Var != null) {
                this.a.add(p28Var);
                return;
            }
            this.m = new p28();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                a28 a28Var = new a28();
                a28Var.d(this.c.get(i));
                if (!li.isEmpty(a28Var.c())) {
                    this.m.a.add(a28Var);
                }
            }
            if (this.m.a.size() > 0) {
                this.a.add(this.m);
            }
        }
    }

    public ArrayList<ro> p() {
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
        f18 f18Var = new f18();
        f18Var.a(tbBookrack);
        new i18(true, f18Var);
    }

    public final void s(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ucCard) == null) {
            new y08().a(ucCard);
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
