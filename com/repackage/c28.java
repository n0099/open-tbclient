package com.repackage;

import android.text.TextUtils;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.MembershipUserInfo;
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
import com.repackage.d28;
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
public class c28 implements s08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<uo> a;
    public UserData b;
    public Duxiaoman c;
    public gt6 d;
    public List<BannerImage> e;
    public PersonUserGodInfo f;
    public a28 g;
    public e28 h;
    public e28 i;
    public e28 j;
    public e28 k;
    public f28 l;
    public PersonMoreData m;
    public k28 n;
    public h28 o;
    public int[] p;
    public int[] q;
    public int[] r;

    public c28() {
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
        this.p = new int[]{R.string.obfuscated_res_0x7f0f0b39, R.string.obfuscated_res_0x7f0f07bb, R.string.obfuscated_res_0x7f0f045e, R.string.obfuscated_res_0x7f0f0857};
        this.q = new int[]{R.drawable.obfuscated_res_0x7f080852, R.drawable.obfuscated_res_0x7f08083e, R.drawable.obfuscated_res_0x7f080853, R.drawable.obfuscated_res_0x7f08083f};
        this.r = new int[]{1, 2, 3, 4};
        this.a = new ArrayList<>();
    }

    @Override // com.repackage.s08
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        f28 f28Var = new f28();
        this.l = f28Var;
        f28Var.a = this.b;
        this.a.add(f28Var);
        g();
        k();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.repackage.s08
    public void b(ProfileResIdl profileResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new f28();
        DataRes dataRes = profileResIdl.data;
        this.e = dataRes.banner;
        this.c = dataRes.duxiaoman;
        t(dataRes.user, dataRes.user_god_info);
        q(profileResIdl.data.tbbookrack);
        r(profileResIdl.data.uc_card);
        s(profileResIdl.data.url_map);
        this.a.add(this.l);
        g();
        h();
        l(profileResIdl.data.recom_swan_list);
        m();
        k();
        PersonRedTipManager.getInstance().syncRedTipState(true);
    }

    public void c(boolean z) {
        e28 e28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (e28Var = this.j) == null) {
            return;
        }
        if (e28Var.i == null) {
            e28Var.i = new g28();
        }
        this.j.i.a = z;
    }

    public void d(boolean z) {
        a28 a28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (a28Var = this.g) == null) {
            return;
        }
        a28Var.e = z;
    }

    public void e(boolean z) {
        e28 e28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (e28Var = this.k) == null) {
            return;
        }
        if (e28Var.i == null) {
            e28Var.i = new g28();
        }
        this.k.i.a = z;
    }

    public void f(boolean z) {
        e28 e28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (e28Var = this.h) == null) {
            return;
        }
        if (e28Var.i == null) {
            e28Var.i = new g28();
        }
        this.h.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a28 a28Var = this.g;
            if (a28Var != null) {
                this.a.add(a28Var);
            } else if (this.b == null) {
            } else {
                a28 a28Var2 = new a28();
                this.g = a28Var2;
                a28Var2.a = this.b.getFansNum();
                this.g.b = this.b.getConcern_num();
                this.g.c = this.b.getLike_bars();
                this.g.d = this.b.getThreadNum();
                a28 a28Var3 = this.g;
                a28Var3.f = this.b;
                this.a.add(a28Var3);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (wt4.k().l("key_create_center_entrance_switch", 0) == 0) {
                return;
            }
            d28 d28Var = new d28();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                d28.a aVar = new d28.a();
                aVar.b = this.q[i];
                if (i == 1) {
                    UserData userData = this.b;
                    if (userData != null && userData.isNewGod()) {
                        aVar.c = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07bb);
                        aVar.a = 5;
                    } else {
                        aVar.c = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07b6);
                        aVar.a = 2;
                    }
                } else {
                    aVar.c = TbadkCoreApplication.getInst().getString(this.p[i]);
                    aVar.a = this.r[i];
                }
                arrayList.add(aVar);
            }
            d28Var.e(arrayList);
            d28Var.b = this.b;
            this.a.add(d28Var);
        }
    }

    public final e28 i(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3)) == null) {
            e28 e28Var = new e28();
            e28Var.b = i;
            e28Var.e = TbadkCoreApplication.getInst().getString(i2);
            e28Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                e28Var.h = userData;
            }
            return e28Var;
        }
        return (e28) invokeIII.objValue;
    }

    public final e28 j(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            e28 e28Var = new e28();
            e28Var.b = i;
            e28Var.e = str;
            e28Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                e28Var.h = userData;
            }
            return e28Var;
        }
        return (e28) invokeCommon.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.h == null) {
                e28 i = i(R.drawable.icon_mask_wo_list_collect24_svg, R.string.obfuscated_res_0x7f0f0b32, 16);
                this.h = i;
                i.c = true;
                i.i = new g28();
            }
            this.a.add(this.h);
            e28 i2 = i(R.drawable.icon_mask_wo_list_history24_svg, R.string.obfuscated_res_0x7f0f0b2e, 17);
            i2.c = true;
            i2.f = true;
            this.a.add(i2);
            e28 i3 = i(R.drawable.icon_mask_wo_list_group24_svg, R.string.obfuscated_res_0x7f0f0b2d, 22);
            i3.f = true;
            i3.c = true;
            gt6 gt6Var = this.d;
            if (gt6Var != null && gt6Var.a() && !TextUtils.isEmpty(this.d.b)) {
                e28 i4 = i(R.drawable.obfuscated_res_0x7f08084c, R.string.obfuscated_res_0x7f0f0e1f, 46);
                i4.c = true;
                i4.g = this.d.b;
                this.a.add(i4);
            }
            e28 i5 = i(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.obfuscated_res_0x7f0f032d, 37);
            i5.c = true;
            i5.i = new g28();
            if (!wt4.k().h("key_has_borrow_cash_clicked", false)) {
                i5.i.a = true;
            }
            i5.i.h = true;
            this.a.add(i5);
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                e28 i6 = i(R.drawable.icon_mask_wo_list_game24_svg, R.string.obfuscated_res_0x7f0f09ec, 44);
                i6.c = true;
                i6.g = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
                this.a.add(i6);
            }
            if (wt4.k().l("baidu_financial_display", 1) == 1) {
                e28 i7 = i(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.obfuscated_res_0x7f0f02c3, 41);
                i7.c = true;
                if (!wt4.k().h("key_baidu_financial_has_clicked", false)) {
                    g28 g28Var = new g28();
                    i7.i = g28Var;
                    g28Var.a = true;
                }
                this.a.add(i7);
            }
            Duxiaoman duxiaoman = this.c;
            if (duxiaoman != null && duxiaoman.is_end.intValue() != 1) {
                e28 i8 = i(R.drawable.icon_mask_wo_list_sign24_svg, R.string.obfuscated_res_0x7f0f0df4, 45);
                i8.c = true;
                i8.g = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                int intValue = this.c.total_cash.intValue();
                if (intValue > 0) {
                    g28 g28Var2 = new g28();
                    g28Var2.c = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1164, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                    g28Var2.d = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                    i8.i = g28Var2;
                }
                this.a.add(i8);
            }
            e28 i9 = i(R.drawable.icon_mask_wo_list_task24_svg, R.string.obfuscated_res_0x7f0f0e32, 43);
            i9.c = true;
            this.a.add(i9);
            e28 i10 = i(R.drawable.icon_mask_wo_list_member24_svg, R.string.obfuscated_res_0x7f0f0aa1, 12);
            i10.c = true;
            this.a.add(i10);
            e28 i11 = i(R.drawable.icon_mask_wo_list_gift24_svg, R.string.obfuscated_res_0x7f0f0b2a, 10);
            this.i = i11;
            i11.i = new g28();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            g28 g28Var3 = this.i.i;
            g28Var3.c = formatNumForTdouDisPlay;
            g28Var3.e = CurrencySwitchUtil.getMoneyIcon();
            this.a.add(this.i);
            e28 i12 = i(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.obfuscated_res_0x7f0f037f, 18);
            i12.c = true;
            this.a.add(i12);
            e28 i13 = i(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.obfuscated_res_0x7f0f0317, 11);
            i13.c = true;
            MembershipUserInfo membershipUserInfo = this.b.membershipInfo;
            if (membershipUserInfo != null) {
                i13.g = membershipUserInfo.mLink;
            }
            this.a.add(i13);
            boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
            String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
            if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
                e28 j = j(R.drawable.icon_mine_list_logingift, personItemText, 38);
                this.j = j;
                j.f = true;
                j.i = new g28();
                this.a.add(this.j);
                TiebaStatic.log(new StatisticItem("c12597"));
            } else {
                i13.f = true;
            }
            e28 i14 = i(R.drawable.icon_mask_wo_list_topic24_svg, R.string.obfuscated_res_0x7f0f085f, 30);
            i14.c = true;
            this.a.add(i14);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                e28 i15 = i(R.drawable.icon_mask_wo_list_live24_svg, R.string.obfuscated_res_0x7f0f021c, 25);
                i15.c = true;
                i15.f = true;
                this.a.add(i15);
            }
            e28 i16 = i(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e2f, 31);
            this.k = i16;
            i16.f = true;
            i16.c = true;
            this.a.add(i16);
            e28 i17 = i(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02c6, 39);
            i17.c = true;
            this.a.add(i17);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            e28 i18 = i(R.drawable.icon_pure_wo_list_more24_svg, R.string.obfuscated_res_0x7f0f0df0, 33);
            i18.c = true;
            i18.d = true;
            i18.j = OrmObject.bundleWithObject(this.m);
            i18.i = new g28();
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
                    i18.i.b = o(R.string.obfuscated_res_0x7f0f0df1, sb.toString());
                }
            }
            this.a.add(i18);
        }
    }

    public final void l(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o == null) {
            h28 h28Var = new h28();
            this.o = h28Var;
            this.a.add(h28Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new j28(smartApp));
                }
            }
        }
        this.o.g(arrayList);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            k28 k28Var = this.n;
            if (k28Var != null) {
                this.a.add(k28Var);
                return;
            }
            this.n = new k28();
            if (ListUtils.isEmpty(this.e)) {
                return;
            }
            for (int i = 0; i < this.e.size(); i++) {
                x18 x18Var = new x18();
                x18Var.d(this.e.get(i));
                if (!ni.isEmpty(x18Var.c())) {
                    this.n.a.add(x18Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }

    public ArrayList<uo> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public final String o(@StringRes int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, objArr)) == null) ? TbadkCoreApplication.getInst().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public UserData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.b : (UserData) invokeV.objValue;
    }

    public final void q(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        e18 e18Var = new e18();
        e18Var.a(tbBookrack);
        new h18(true, e18Var);
    }

    public final void r(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ucCard) == null) {
            new x08().a(ucCard);
        }
    }

    public final void s(List<UserMap> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || ListUtils.isEmpty(list)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, user, userGodInfo) == null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(user);
            if (this.f == null && userGodInfo != null) {
                this.f = new PersonUserGodInfo();
            }
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.b.setIsBigV(true);
                this.f.parserProtobuf(userGodInfo);
            }
            this.l.a = this.b;
        }
    }

    public void u(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }
}
