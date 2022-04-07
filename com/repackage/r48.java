package com.repackage;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.HotUserRankEntry;
import tbclient.PostInfoList;
import tbclient.PrivSets;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes7.dex */
public abstract class r48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NicknameInfo A;
    public User B;
    public MetaData C;
    public List<ThreadData> D;
    public HotUserRankEntry E;
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public UserData g;
    public AntiData h;
    public ArrayList<uo> i;
    public t48 j;
    public d18 k;
    public gt6 l;
    public List<AlaLiveInfoCoreData> m;
    public x48 n;
    public z48 o;
    public List<uo> p;
    public ArrayList<uo> q;
    public ArrayList<e58> r;
    public ArrayList<uo> s;
    public h18 t;
    public e58 u;
    public e58 v;
    public e58 w;
    public e58 x;
    public e58 y;
    public PersonUserGodInfo z;

    public r48(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = 1;
        this.d = 1;
        this.e = 1;
        this.f = -1;
        this.a = z;
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.D = new ArrayList();
    }

    public u08 a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            u08 u08Var = new u08();
            u08Var.a = i;
            u08Var.c = i2;
            return u08Var;
        }
        return (u08) invokeII.objValue;
    }

    public abstract void b();

    public final e58 c(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3)) == null) {
            e58 e58Var = new e58();
            TbadkCoreApplication.getInst().getString(i2);
            l28 l28Var = new l28();
            e58Var.a = l28Var;
            l28Var.a = i3;
            return e58Var;
        }
        return (e58) invokeIII.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.clear();
            e58 c = c(R.drawable.icon_starer_caise_heibai, R.string.obfuscated_res_0x7f0f0a81, 20);
            this.v = c;
            c.b = new Bundle();
            this.v.b.putBoolean("person_center_item_red_tip", true);
            this.v.a.b = new Bundle();
            this.v.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.v);
            e58 c2 = c(R.drawable.icon_lover_caise_heibai, R.string.obfuscated_res_0x7f0f0432, 24);
            this.w = c2;
            c2.b = new Bundle();
            this.w.b.putBoolean("person_center_item_red_tip", true);
            this.w.a.b = new Bundle();
            this.w.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.w);
            e58 c3 = c(R.drawable.icon_liwu_caise_heibai, R.string.obfuscated_res_0x7f0f0796, 32);
            this.u = c3;
            c3.b = new Bundle();
            this.u.b.putBoolean("person_center_item_red_tip", true);
            this.u.a.b = new Bundle();
            this.u.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.u);
            e58 c4 = c(R.drawable.icon_lishi_caise_heibai, R.string.obfuscated_res_0x7f0f082a, 21);
            c4.a.b = new Bundle();
            c4.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c4);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
                e58 c5 = c(R.drawable.icon_zhibou_caise_heibai, R.string.obfuscated_res_0x7f0f021c, 29);
                c5.b = new Bundle();
                c5.a.b = new Bundle();
                c5.a.b.putSerializable(UserData.TYPE_USER, this.g);
                this.r.add(c5);
            }
            e58 c6 = c(R.drawable.icon_vip_heibai, R.string.obfuscated_res_0x7f0f0aa2, 16);
            this.x = c6;
            c6.b = new Bundle();
            this.x.b.putBoolean("person_center_item_red_tip", true);
            this.x.a.b = new Bundle();
            this.x.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.x);
            e58 c7 = c(R.drawable.icon_bookshoop_caise_heibai, R.string.obfuscated_res_0x7f0f031a, 31);
            c7.a.b = new Bundle();
            c7.a.b.putSerializable(UserData.TYPE_USER, this.g);
            h18 h18Var = this.t;
            if (h18Var != null) {
                c7.a.b.putString("book_jump_link", h18Var.a);
            }
            this.r.add(c7);
            e58 c8 = c(R.drawable.icon_kabao_caise_heibai, R.string.obfuscated_res_0x7f0f037f, 33);
            c8.a.b = new Bundle();
            c8.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c8);
            e58 c9 = c(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.obfuscated_res_0x7f0f042f, 17);
            c9.a.b = new Bundle();
            c9.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c9);
            e58 c10 = c(R.drawable.icon_fuwu_caise_heibai, R.string.obfuscated_res_0x7f0f0e2f, 39);
            c10.a.b = new Bundle();
            c10.a.b.putString("key_service_centre", "");
            this.r.add(c10);
        }
    }

    public AntiData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (AntiData) invokeV.objValue;
    }

    public ArrayList<uo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public gt6 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (gt6) invokeV.objValue;
    }

    public List<ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : (List) invokeV.objValue;
    }

    public User i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (User) invokeV.objValue;
    }

    public UserData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.g : (UserData) invokeV.objValue;
    }

    public List<uo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d18 d18Var = this.k;
            if (d18Var == null) {
                return null;
            }
            return d18Var.a();
        }
        return (List) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a) {
                return false;
            }
            int i = this.d;
            if (i == 3) {
                return true;
            }
            return i == 2 && !this.b;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.a) {
                return false;
            }
            int i = this.e;
            if (i == 3) {
                return true;
            }
            return i == 2 && !this.b;
        }
        return invokeV.booleanValue;
    }

    public final void p(List<ForumDynamic> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            t48 t48Var = new t48();
            this.j = t48Var;
            t48Var.a = new ArrayList();
            for (ForumDynamic forumDynamic : list) {
                if (forumDynamic != null) {
                    w48 w48Var = new w48();
                    w48Var.a = forumDynamic.forum_id.longValue();
                    w48Var.b = forumDynamic.forum_name;
                    w48Var.c = forumDynamic.avatar;
                    w48Var.e = this.c;
                    w48Var.d = forumDynamic.user_thread_count.intValue();
                    this.j.a.add(w48Var);
                }
            }
        }
    }

    public final void q(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, dynamicInfo, z) == null) {
            if ((!n() || this.a) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
                if (this.p == null) {
                    this.p = new ArrayList();
                }
                s48 s48Var = new s48();
                s48Var.a = this.a;
                s48Var.b = this.c;
                s48Var.c = z;
                s48Var.d = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                s48Var.e = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                s48Var.f = forumDynamic.forum_id.longValue();
                s48Var.g = forumDynamic.avatar;
                s48Var.h = forumDynamic.forum_name;
                s48Var.i = forumDynamic.is_like.intValue() == 1;
                s48Var.j = forumDynamic.member_count.intValue();
                s48Var.k = forumDynamic.thread_count.intValue();
                this.p.add(s48Var);
                this.p.add(a(oi.f(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.obfuscated_res_0x7f070198), R.color.CAM_X0204));
            }
        }
    }

    public final void r(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048593, this, dynamicInfo, z) == null) || (userDynamic = dynamicInfo.user_dynamic) == null) {
            return;
        }
        List<User> list = userDynamic.concerned_user_list;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        u48 u48Var = new u48();
        u48Var.a = this.a;
        u48Var.b = z;
        u48Var.e = this.c;
        u48Var.c = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        u48Var.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        u48Var.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        u48Var.f = new ArrayList();
        for (User user : list) {
            if (user != null) {
                UserData userData = new UserData();
                userData.parserProtobuf(user);
                u48Var.f.add(userData);
            }
        }
        this.p.add(u48Var);
    }

    public final void s(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{user, dynamicInfo, random, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if ((!o() || this.a) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
                if (this.p == null) {
                    this.p = new ArrayList();
                }
                int random2 = UtilHelper.getRandom(random, 3, this.f);
                this.f = random2;
                CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
                cardPersonDynamicThreadData.F = this.a;
                cardPersonDynamicThreadData.D = z;
                cardPersonDynamicThreadData.C = z2;
                cardPersonDynamicThreadData.E = z3;
                cardPersonDynamicThreadData.q = 3;
                cardPersonDynamicThreadData.k(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
                this.p.add(cardPersonDynamicThreadData);
            }
        }
    }

    public final void t(User user, PostInfoList postInfoList, Random random) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, user, postInfoList, random) == null) {
            if (!o() || this.a) {
                if (this.s == null) {
                    this.s = new ArrayList<>();
                }
                this.f = UtilHelper.getRandom(random, 3, this.f);
                CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
                cardPersonDynamicThreadData.F = this.a;
                cardPersonDynamicThreadData.D = false;
                cardPersonDynamicThreadData.C = false;
                cardPersonDynamicThreadData.i(user, null, postInfoList, this.f);
                this.s.add(cardPersonDynamicThreadData);
            }
        }
    }

    public final void u(User user) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, user) == null) || user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        x48 x48Var = new x48();
        this.n = x48Var;
        x48Var.e(user);
    }

    public void v(t08 t08Var) {
        String str;
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, t08Var) == null) || t08Var == null) {
            return;
        }
        this.B = t08Var.GetUser();
        if (this.g == null) {
            this.g = new UserData();
        }
        this.g.parserProtobuf(this.B);
        if (this.C == null) {
            this.C = new MetaData();
        }
        this.C.parserProtobuf(this.B);
        if (this.z == null) {
            this.z = new PersonUserGodInfo();
        }
        UserGodInfo userGodInfo = t08Var.getUserGodInfo();
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.g.setIsBigV(true);
            this.z.parserProtobuf(t08Var.getUserGodInfo());
        }
        if (this.h == null) {
            this.h = new AntiData();
        }
        this.h.parserProtobuf(t08Var.GetAntiStat());
        User user = this.B;
        if (user != null) {
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.d = privSets.like.intValue();
                this.e = this.B.priv_sets.post.intValue();
            }
            this.c = this.B.sex.intValue();
        }
        if (t08Var.getTaInfo() != null) {
            this.b = t08Var.getTaInfo().is_friend.intValue() == 1;
        }
        this.g.setIsFriend(t08Var.getTaInfo().is_friend.intValue());
        if (t08Var.getBookrackData() != null) {
            e18 e18Var = new e18();
            e18Var.a(t08Var.getBookrackData());
            this.t = new h18(true, e18Var);
        }
        if (!ListUtils.isEmpty(t08Var.getConcernedForumList()) && !this.a && !n()) {
            p(t08Var.getConcernedForumList());
        }
        if (this.n == null) {
            u(this.B);
        }
        Random random = new Random();
        if (this.a && !ListUtils.isEmpty(t08Var.GetPostList())) {
            for (PostInfoList postInfoList : t08Var.GetPostList()) {
                if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                    t(this.B, postInfoList, random);
                }
            }
        }
        String yearBytime = StringHelper.getYearBytime(System.currentTimeMillis());
        if (!ListUtils.isEmpty(t08Var.getDynamicInfoList())) {
            Date date = new Date();
            String str3 = "";
            String str4 = "";
            boolean z2 = true;
            for (DynamicInfo dynamicInfo : t08Var.getDynamicInfoList()) {
                if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                    long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                    date.setTime(longValue);
                    String yearBytime2 = StringHelper.getYearBytime(longValue);
                    String chineseMonthBytime = StringHelper.getChineseMonthBytime(longValue);
                    String dateBytime = StringHelper.getDateBytime(longValue);
                    boolean z3 = !StringHelper.equals(yearBytime2, yearBytime);
                    if (StringHelper.equals(dateBytime, str3) && StringHelper.equals(chineseMonthBytime, str4) && StringHelper.equals(yearBytime2, yearBytime)) {
                        yearBytime2 = yearBytime;
                        str2 = str3;
                        str = str4;
                        z = false;
                    } else {
                        str = chineseMonthBytime;
                        str2 = dateBytime;
                        z = true;
                    }
                    int intValue = dynamicInfo.type.intValue();
                    if (intValue == 1) {
                        s(this.B, dynamicInfo, random, z3, z, z2);
                    } else if (intValue == 2) {
                        r(dynamicInfo, z);
                    } else if (intValue == 3) {
                        q(dynamicInfo, z);
                    }
                    yearBytime = yearBytime2;
                    str3 = str2;
                    str4 = str;
                    z2 = false;
                }
            }
        }
        if (this.o == null && ListUtils.isEmpty(this.p) && ListUtils.isEmpty(this.s)) {
            z48 z48Var = new z48();
            this.o = z48Var;
            z48Var.b = this.c;
            z48Var.a = this.a;
        }
        if (this.a) {
            d();
            t08Var.getMaskType();
        }
        t08Var.getUserAgreeInfo();
        t08Var.getLiveInfo();
        this.l = t08Var.getGoodsWindowInfo();
        this.m = t08Var.getLiveReplayInfo();
        this.A = t08Var.getNicknameInfo();
        this.E = t08Var.getHotRankEntry();
        List<ThreadInfo> newestThreadList = t08Var.getNewestThreadList();
        if (ListUtils.isEmpty(newestThreadList)) {
            return;
        }
        for (int i = 0; i < newestThreadList.size(); i++) {
            ThreadData threadData = new ThreadData();
            threadData.parserProtobuf(newestThreadList.get(i));
            threadData.setAuthor(this.C);
            threadData.praserTimeConsumingInfo();
            this.D.add(threadData);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b = true;
            this.c = 1;
            this.d = 1;
            this.e = 1;
            this.f = -1;
            this.g = null;
            ArrayList<uo> arrayList = this.i;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.i = null;
            this.j = null;
            this.k = null;
            this.n = null;
            this.o = null;
            List<uo> list = this.p;
            if (list != null) {
                list.clear();
            }
            ArrayList<uo> arrayList2 = this.s;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.p = null;
            this.s = null;
            this.q.clear();
            this.A = null;
            this.l = null;
            List<AlaLiveInfoCoreData> list2 = this.m;
            if (list2 != null) {
                list2.clear();
            }
            List<ThreadData> list3 = this.D;
            if (list3 != null) {
                list3.clear();
            }
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.b = z;
        }
    }
}
