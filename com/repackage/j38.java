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
/* loaded from: classes6.dex */
public abstract class j38 {
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
    public ArrayList<nn> i;
    public l38 j;
    public uz7 k;
    public pr6 l;
    public List<AlaLiveInfoCoreData> m;
    public p38 n;
    public r38 o;
    public List<nn> p;
    public ArrayList<nn> q;
    public ArrayList<w38> r;
    public ArrayList<nn> s;
    public yz7 t;
    public w38 u;
    public w38 v;
    public w38 w;
    public w38 x;
    public w38 y;
    public PersonUserGodInfo z;

    public j38(boolean z) {
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

    public lz7 a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            lz7 lz7Var = new lz7();
            lz7Var.a = i;
            lz7Var.c = i2;
            return lz7Var;
        }
        return (lz7) invokeII.objValue;
    }

    public abstract void b();

    public final w38 c(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3)) == null) {
            w38 w38Var = new w38();
            TbadkCoreApplication.getInst().getString(i2);
            e18 e18Var = new e18();
            w38Var.a = e18Var;
            e18Var.a = i3;
            return w38Var;
        }
        return (w38) invokeIII.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.clear();
            w38 c = c(R.drawable.icon_starer_caise_heibai, R.string.obfuscated_res_0x7f0f0a92, 20);
            this.v = c;
            c.b = new Bundle();
            this.v.b.putBoolean("person_center_item_red_tip", true);
            this.v.a.b = new Bundle();
            this.v.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.v);
            w38 c2 = c(R.drawable.icon_lover_caise_heibai, R.string.obfuscated_res_0x7f0f0430, 24);
            this.w = c2;
            c2.b = new Bundle();
            this.w.b.putBoolean("person_center_item_red_tip", true);
            this.w.a.b = new Bundle();
            this.w.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.w);
            w38 c3 = c(R.drawable.icon_liwu_caise_heibai, R.string.obfuscated_res_0x7f0f07a2, 32);
            this.u = c3;
            c3.b = new Bundle();
            this.u.b.putBoolean("person_center_item_red_tip", true);
            this.u.a.b = new Bundle();
            this.u.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.u);
            w38 c4 = c(R.drawable.icon_lishi_caise_heibai, R.string.obfuscated_res_0x7f0f0835, 21);
            c4.a.b = new Bundle();
            c4.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c4);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
                w38 c5 = c(R.drawable.icon_zhibou_caise_heibai, R.string.obfuscated_res_0x7f0f021f, 29);
                c5.b = new Bundle();
                c5.a.b = new Bundle();
                c5.a.b.putSerializable(UserData.TYPE_USER, this.g);
                this.r.add(c5);
            }
            w38 c6 = c(R.drawable.icon_vip_heibai, R.string.obfuscated_res_0x7f0f0ab4, 16);
            this.x = c6;
            c6.b = new Bundle();
            this.x.b.putBoolean("person_center_item_red_tip", true);
            this.x.a.b = new Bundle();
            this.x.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.x);
            w38 c7 = c(R.drawable.icon_bookshoop_caise_heibai, R.string.obfuscated_res_0x7f0f031f, 31);
            c7.a.b = new Bundle();
            c7.a.b.putSerializable(UserData.TYPE_USER, this.g);
            yz7 yz7Var = this.t;
            if (yz7Var != null) {
                c7.a.b.putString("book_jump_link", yz7Var.a);
            }
            this.r.add(c7);
            w38 c8 = c(R.drawable.icon_kabao_caise_heibai, R.string.obfuscated_res_0x7f0f0378, 33);
            c8.a.b = new Bundle();
            c8.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c8);
            w38 c9 = c(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.obfuscated_res_0x7f0f042d, 17);
            c9.a.b = new Bundle();
            c9.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c9);
            w38 c10 = c(R.drawable.icon_fuwu_caise_heibai, R.string.obfuscated_res_0x7f0f0e58, 39);
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

    public ArrayList<nn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public pr6 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (pr6) invokeV.objValue;
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

    public List<nn> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            uz7 uz7Var = this.k;
            if (uz7Var == null) {
                return null;
            }
            return uz7Var.a();
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
            l38 l38Var = new l38();
            this.j = l38Var;
            l38Var.a = new ArrayList();
            for (ForumDynamic forumDynamic : list) {
                if (forumDynamic != null) {
                    o38 o38Var = new o38();
                    o38Var.a = forumDynamic.forum_id.longValue();
                    o38Var.b = forumDynamic.forum_name;
                    o38Var.c = forumDynamic.avatar;
                    o38Var.e = this.c;
                    o38Var.d = forumDynamic.user_thread_count.intValue();
                    this.j.a.add(o38Var);
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
                k38 k38Var = new k38();
                k38Var.a = this.a;
                k38Var.b = this.c;
                k38Var.c = z;
                k38Var.d = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                k38Var.e = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                k38Var.f = forumDynamic.forum_id.longValue();
                k38Var.g = forumDynamic.avatar;
                k38Var.h = forumDynamic.forum_name;
                k38Var.i = forumDynamic.is_like.intValue() == 1;
                k38Var.j = forumDynamic.member_count.intValue();
                k38Var.k = forumDynamic.thread_count.intValue();
                this.p.add(k38Var);
                this.p.add(a(pi.f(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.obfuscated_res_0x7f070198), R.color.CAM_X0204));
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
        m38 m38Var = new m38();
        m38Var.a = this.a;
        m38Var.b = z;
        m38Var.e = this.c;
        m38Var.c = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        m38Var.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        m38Var.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        m38Var.f = new ArrayList();
        for (User user : list) {
            if (user != null) {
                UserData userData = new UserData();
                userData.parserProtobuf(user);
                m38Var.f.add(userData);
            }
        }
        this.p.add(m38Var);
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
                cardPersonDynamicThreadData.j(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
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
                cardPersonDynamicThreadData.h(user, null, postInfoList, this.f);
                this.s.add(cardPersonDynamicThreadData);
            }
        }
    }

    public final void u(User user) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, user) == null) || user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        p38 p38Var = new p38();
        this.n = p38Var;
        p38Var.c(user);
    }

    public void v(kz7 kz7Var) {
        String str;
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, kz7Var) == null) || kz7Var == null) {
            return;
        }
        this.B = kz7Var.GetUser();
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
        UserGodInfo userGodInfo = kz7Var.getUserGodInfo();
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.g.setIsBigV(true);
            this.z.parserProtobuf(kz7Var.getUserGodInfo());
        }
        if (this.h == null) {
            this.h = new AntiData();
        }
        this.h.parserProtobuf(kz7Var.GetAntiStat());
        User user = this.B;
        if (user != null) {
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.d = privSets.like.intValue();
                this.e = this.B.priv_sets.post.intValue();
            }
            this.c = this.B.sex.intValue();
        }
        if (kz7Var.getTaInfo() != null) {
            this.b = kz7Var.getTaInfo().is_friend.intValue() == 1;
        }
        this.g.setIsFriend(kz7Var.getTaInfo().is_friend.intValue());
        if (kz7Var.getBookrackData() != null) {
            vz7 vz7Var = new vz7();
            vz7Var.a(kz7Var.getBookrackData());
            this.t = new yz7(true, vz7Var);
        }
        if (!ListUtils.isEmpty(kz7Var.getConcernedForumList()) && !this.a && !n()) {
            p(kz7Var.getConcernedForumList());
        }
        if (this.n == null) {
            u(this.B);
        }
        Random random = new Random();
        if (this.a && !ListUtils.isEmpty(kz7Var.GetPostList())) {
            for (PostInfoList postInfoList : kz7Var.GetPostList()) {
                if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                    t(this.B, postInfoList, random);
                }
            }
        }
        String yearBytime = StringHelper.getYearBytime(System.currentTimeMillis());
        if (!ListUtils.isEmpty(kz7Var.getDynamicInfoList())) {
            Date date = new Date();
            String str3 = "";
            String str4 = "";
            boolean z2 = true;
            for (DynamicInfo dynamicInfo : kz7Var.getDynamicInfoList()) {
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
            r38 r38Var = new r38();
            this.o = r38Var;
            r38Var.b = this.c;
            r38Var.a = this.a;
        }
        if (this.a) {
            d();
            kz7Var.getMaskType();
        }
        kz7Var.getUserAgreeInfo();
        kz7Var.getLiveInfo();
        this.l = kz7Var.getGoodsWindowInfo();
        this.m = kz7Var.getLiveReplayInfo();
        this.A = kz7Var.getNicknameInfo();
        this.E = kz7Var.getHotRankEntry();
        List<ThreadInfo> newestThreadList = kz7Var.getNewestThreadList();
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
            ArrayList<nn> arrayList = this.i;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.i = null;
            this.j = null;
            this.k = null;
            this.n = null;
            this.o = null;
            List<nn> list = this.p;
            if (list != null) {
                list.clear();
            }
            ArrayList<nn> arrayList2 = this.s;
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
