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
/* loaded from: classes6.dex */
public class nz7 implements cy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<jn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public mz7 e;
    public oz7 f;
    public rz7 g;
    public rz7 h;
    public rz7 i;
    public rz7 j;
    public sz7 k;
    public PersonMoreData l;
    public yz7 m;
    public vz7 n;
    public qz7 o;

    public nz7() {
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

    @Override // com.repackage.cy7
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        sz7 sz7Var = new sz7();
        this.k = sz7Var;
        sz7Var.a = this.b;
        this.a.add(sz7Var);
        g();
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.repackage.cy7
    public void b(ProfileResIdl profileResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.k = new sz7();
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
        rz7 rz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (rz7Var = this.i) == null) {
            return;
        }
        if (rz7Var.i == null) {
            rz7Var.i = new tz7();
        }
        this.i.i.a = z;
    }

    public void d(boolean z) {
        mz7 mz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (mz7Var = this.e) == null) {
            return;
        }
        mz7Var.d = z;
    }

    public void e(boolean z) {
        rz7 rz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (rz7Var = this.j) == null) {
            return;
        }
        if (rz7Var.i == null) {
            rz7Var.i = new tz7();
        }
        this.j.i.a = z;
    }

    public void f(boolean z) {
        rz7 rz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (rz7Var = this.g) == null) {
            return;
        }
        if (rz7Var.i == null) {
            rz7Var.i = new tz7();
        }
        this.g.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            mz7 mz7Var = this.e;
            if (mz7Var != null) {
                this.a.add(mz7Var);
            } else if (this.b == null) {
            } else {
                this.e = new mz7();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                mz7 mz7Var2 = this.e;
                mz7Var2.e = this.b;
                this.a.add(mz7Var2);
            }
        }
    }

    public final void h(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            qz7 qz7Var = this.o;
            if (qz7Var != null) {
                this.a.add(qz7Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            qz7 qz7Var2 = new qz7();
            this.o = qz7Var2;
            qz7Var2.i(creationData);
            this.o.k(creationData2);
            this.a.add(this.o);
        }
    }

    public final void i(FinanceTab financeTab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, financeTab) == null) {
            oz7 oz7Var = this.f;
            if (oz7Var != null) {
                this.a.add(oz7Var);
                return;
            }
            oz7 oz7Var2 = new oz7();
            this.f = oz7Var2;
            oz7Var2.g(financeTab);
            this.a.add(this.f);
        }
    }

    public final rz7 j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            rz7 rz7Var = new rz7();
            rz7Var.b = i;
            rz7Var.e = TbadkCoreApplication.getInst().getString(i2);
            rz7Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                rz7Var.h = userData;
            }
            return rz7Var;
        }
        return (rz7) invokeIII.objValue;
    }

    public final rz7 k(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            rz7 rz7Var = new rz7();
            rz7Var.b = i;
            rz7Var.e = str;
            rz7Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                rz7Var.h = userData;
            }
            return rz7Var;
        }
        return (rz7) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            rz7 j = j(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e50, 31);
            this.j = j;
            j.c = true;
            this.a.add(j);
            rz7 j2 = j(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02cd, 39);
            j2.c = true;
            this.a.add(j2);
            rz7 k = k(R.drawable.obfuscated_res_0x7f08084c, "订单中心", 47);
            k.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(k);
            rz7 k2 = k(R.drawable.obfuscated_res_0x7f08083b, "开店", 48);
            k2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(k2);
            rz7 k3 = k(R.drawable.obfuscated_res_0x7f080831, "广告推广", 49);
            k3.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(k3);
            if (this.l == null) {
                this.l = new PersonMoreData();
            }
            rz7 j3 = j(R.drawable.obfuscated_res_0x7f08084b, R.string.obfuscated_res_0x7f0f0e10, 33);
            j3.j = OrmObject.bundleWithObject(this.l);
            j3.i = new tz7();
            this.a.add(j3);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            uz7 uz7Var = new uz7();
            ArrayList arrayList = new ArrayList();
            rz7 j = j(R.drawable.obfuscated_res_0x7f080839, R.string.obfuscated_res_0x7f0f0aaf, 12);
            j.c = true;
            arrayList.add(j);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(j(R.drawable.obfuscated_res_0x7f0807b4, R.string.obfuscated_res_0x7f0f0390, 53));
            rz7 j2 = j(R.drawable.obfuscated_res_0x7f080833, R.string.obfuscated_res_0x7f0f0465, 56);
            j2.g = TbConfig.CREATE_BA;
            arrayList.add(j2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                rz7 j3 = j(R.drawable.obfuscated_res_0x7f080838, R.string.obfuscated_res_0x7f0f021f, 25);
                j3.c = true;
                j3.f = true;
                arrayList.add(j3);
            }
            if (TbSingleton.getInstance().isBusinessAccount()) {
                rz7 j4 = j(R.drawable.obfuscated_res_0x7f080832, R.string.obfuscated_res_0x7f0f0cc0, 15);
                j4.c = true;
                arrayList.add(j4);
            }
            rz7 j5 = j(R.drawable.obfuscated_res_0x7f080837, R.string.obfuscated_res_0x7f0f006b, 50);
            j5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(j5);
            rz7 j6 = j(R.drawable.obfuscated_res_0x7f080835, R.string.obfuscated_res_0x7f0f0b43, 10);
            this.h = j6;
            j6.i = new tz7();
            this.h.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            tz7 tz7Var = this.h.i;
            tz7Var.c = formatNumForTdouDisPlay;
            tz7Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.h);
            rz7 j7 = j(R.drawable.obfuscated_res_0x7f08083a, R.string.obfuscated_res_0x7f0f0387, 18);
            j7.c = true;
            arrayList.add(j7);
            rz7 j8 = j(R.drawable.obfuscated_res_0x7f08083d, R.string.obfuscated_res_0x7f0f0a8f, 51);
            j8.g = "http://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(j8);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08083c, R.string.obfuscated_res_0x7f0f1227, 52));
            rz7 j9 = j(R.drawable.obfuscated_res_0x7f080836, R.string.obfuscated_res_0x7f0f0cb4, 54);
            j9.g = v65.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(j9);
            rz7 j10 = j(R.drawable.obfuscated_res_0x7f080846, R.string.obfuscated_res_0x7f0f0419, 55);
            j10.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(j10);
            uz7Var.g(arrayList);
            this.a.add(uz7Var);
        }
    }

    public final void n(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.n == null) {
            vz7 vz7Var = new vz7();
            this.n = vz7Var;
            this.a.add(vz7Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new xz7(smartApp));
                }
            }
        }
        this.n.g(arrayList);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            yz7 yz7Var = this.m;
            if (yz7Var != null) {
                this.a.add(yz7Var);
                return;
            }
            this.m = new yz7();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                jz7 jz7Var = new jz7();
                jz7Var.d(this.c.get(i));
                if (!ki.isEmpty(jz7Var.c())) {
                    this.m.a.add(jz7Var);
                }
            }
            if (this.m.a.size() > 0) {
                this.a.add(this.m);
            }
        }
    }

    public ArrayList<jn> p() {
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
        oy7 oy7Var = new oy7();
        oy7Var.a(tbBookrack);
        new ry7(true, oy7Var);
    }

    public final void s(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ucCard) == null) {
            new hy7().a(ucCard);
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
