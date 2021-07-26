package d.a.q0.m2.e;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
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
import d.a.p0.s.q.b2;
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
/* loaded from: classes8.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NicknameInfo A;
    public User B;
    public MetaData C;
    public List<b2> D;
    public HotUserRankEntry E;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60837a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60838b;

    /* renamed from: c  reason: collision with root package name */
    public int f60839c;

    /* renamed from: d  reason: collision with root package name */
    public int f60840d;

    /* renamed from: e  reason: collision with root package name */
    public int f60841e;

    /* renamed from: f  reason: collision with root package name */
    public int f60842f;

    /* renamed from: g  reason: collision with root package name */
    public UserData f60843g;

    /* renamed from: h  reason: collision with root package name */
    public AntiData f60844h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<d.a.d.k.e.n> f60845i;
    public c j;
    public d.a.q0.j2.h.f k;
    public d.a.q0.a1.b l;
    public List<AlaLiveInfoCoreData> m;
    public g n;
    public i o;
    public List<d.a.d.k.e.n> p;
    public ArrayList<d.a.d.k.e.n> q;
    public ArrayList<n> r;
    public ArrayList<d.a.d.k.e.n> s;
    public d.a.q0.j2.i.d t;
    public n u;
    public n v;
    public n w;
    public n x;
    public n y;
    public PersonUserGodInfo z;

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60838b = true;
        this.f60839c = 1;
        this.f60840d = 1;
        this.f60841e = 1;
        this.f60842f = -1;
        this.f60837a = z;
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.D = new ArrayList();
    }

    public d.a.q0.j2.d a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            d.a.q0.j2.d dVar = new d.a.q0.j2.d();
            dVar.f59726e = i2;
            dVar.f59728g = i3;
            return dVar;
        }
        return (d.a.q0.j2.d) invokeII.objValue;
    }

    public abstract void b();

    public final n c(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4)) == null) {
            n nVar = new n();
            TbadkCoreApplication.getInst().getString(i3);
            d.a.q0.k2.f.a aVar = new d.a.q0.k2.f.a();
            nVar.f60893a = aVar;
            aVar.f60701a = i4;
            return nVar;
        }
        return (n) invokeIII.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.clear();
            n c2 = c(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
            this.v = c2;
            c2.f60894b = new Bundle();
            this.v.f60894b.putBoolean("person_center_item_red_tip", true);
            this.v.f60893a.f60702b = new Bundle();
            this.v.f60893a.f60702b.putSerializable(UserData.TYPE_USER, this.f60843g);
            this.r.add(this.v);
            n c3 = c(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
            this.w = c3;
            c3.f60894b = new Bundle();
            this.w.f60894b.putBoolean("person_center_item_red_tip", true);
            this.w.f60893a.f60702b = new Bundle();
            this.w.f60893a.f60702b.putSerializable(UserData.TYPE_USER, this.f60843g);
            this.r.add(this.w);
            n c4 = c(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
            this.u = c4;
            c4.f60894b = new Bundle();
            this.u.f60894b.putBoolean("person_center_item_red_tip", true);
            this.u.f60893a.f60702b = new Bundle();
            this.u.f60893a.f60702b.putSerializable(UserData.TYPE_USER, this.f60843g);
            this.r.add(this.u);
            n c5 = c(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
            c5.f60893a.f60702b = new Bundle();
            c5.f60893a.f60702b.putSerializable(UserData.TYPE_USER, this.f60843g);
            this.r.add(c5);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
                n c6 = c(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
                c6.f60894b = new Bundle();
                c6.f60893a.f60702b = new Bundle();
                c6.f60893a.f60702b.putSerializable(UserData.TYPE_USER, this.f60843g);
                this.r.add(c6);
            }
            n c7 = c(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
            this.x = c7;
            c7.f60894b = new Bundle();
            this.x.f60894b.putBoolean("person_center_item_red_tip", true);
            this.x.f60893a.f60702b = new Bundle();
            this.x.f60893a.f60702b.putSerializable(UserData.TYPE_USER, this.f60843g);
            this.r.add(this.x);
            n c8 = c(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
            c8.f60893a.f60702b = new Bundle();
            c8.f60893a.f60702b.putSerializable(UserData.TYPE_USER, this.f60843g);
            d.a.q0.j2.i.d dVar = this.t;
            if (dVar != null) {
                c8.f60893a.f60702b.putString("book_jump_link", dVar.f59764e);
            }
            this.r.add(c8);
            n c9 = c(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
            c9.f60893a.f60702b = new Bundle();
            c9.f60893a.f60702b.putSerializable(UserData.TYPE_USER, this.f60843g);
            this.r.add(c9);
            n c10 = c(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
            c10.f60893a.f60702b = new Bundle();
            c10.f60893a.f60702b.putSerializable(UserData.TYPE_USER, this.f60843g);
            this.r.add(c10);
            n c11 = c(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
            c11.f60893a.f60702b = new Bundle();
            c11.f60893a.f60702b.putString("key_service_centre", "");
            this.r.add(c11);
        }
    }

    public AntiData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60844h : (AntiData) invokeV.objValue;
    }

    public ArrayList<d.a.d.k.e.n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public d.a.q0.a1.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (d.a.q0.a1.b) invokeV.objValue;
    }

    public List<b2> h() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f60843g : (UserData) invokeV.objValue;
    }

    public List<d.a.d.k.e.n> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d.a.q0.j2.h.f fVar = this.k;
            if (fVar == null) {
                return null;
            }
            return fVar.b();
        }
        return (List) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f60838b : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f60837a : invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f60837a) {
                return false;
            }
            int i2 = this.f60840d;
            if (i2 == 3) {
                return true;
            }
            return i2 == 2 && !this.f60838b;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f60837a) {
                return false;
            }
            int i2 = this.f60841e;
            if (i2 == 3) {
                return true;
            }
            return i2 == 2 && !this.f60838b;
        }
        return invokeV.booleanValue;
    }

    public final void p(List<ForumDynamic> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            c cVar = new c();
            this.j = cVar;
            cVar.f60852e = new ArrayList();
            for (ForumDynamic forumDynamic : list) {
                if (forumDynamic != null) {
                    f fVar = new f();
                    fVar.f60862e = forumDynamic.forum_id.longValue();
                    fVar.f60863f = forumDynamic.forum_name;
                    fVar.f60864g = forumDynamic.avatar;
                    fVar.f60866i = this.f60839c;
                    fVar.f60865h = forumDynamic.user_thread_count.intValue();
                    this.j.f60852e.add(fVar);
                }
            }
        }
    }

    public final void q(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, dynamicInfo, z) == null) {
            if ((!n() || this.f60837a) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
                if (this.p == null) {
                    this.p = new ArrayList();
                }
                b bVar = new b();
                bVar.f60846e = this.f60837a;
                bVar.f60847f = this.f60839c;
                bVar.f60848g = z;
                bVar.f60849h = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                bVar.f60850i = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                bVar.j = forumDynamic.forum_id.longValue();
                bVar.k = forumDynamic.avatar;
                bVar.l = forumDynamic.forum_name;
                bVar.m = forumDynamic.is_like.intValue() == 1;
                bVar.n = forumDynamic.member_count.intValue();
                bVar.o = forumDynamic.thread_count.intValue();
                this.p.add(bVar);
                this.p.add(a(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
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
        d dVar = new d();
        dVar.f60853e = this.f60837a;
        dVar.f60854f = z;
        dVar.f60857i = this.f60839c;
        dVar.f60855g = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.f60856h = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.f60856h = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.j = new ArrayList();
        for (User user : list) {
            if (user != null) {
                UserData userData = new UserData();
                userData.parserProtobuf(user);
                dVar.j.add(userData);
            }
        }
        this.p.add(dVar);
    }

    public final void s(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{user, dynamicInfo, random, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if ((!o() || this.f60837a) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
                if (this.p == null) {
                    this.p = new ArrayList();
                }
                int random2 = UtilHelper.getRandom(random, 3, this.f60842f);
                this.f60842f = random2;
                CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
                cardPersonDynamicThreadData.H = this.f60837a;
                cardPersonDynamicThreadData.F = z;
                cardPersonDynamicThreadData.E = z2;
                cardPersonDynamicThreadData.G = z3;
                cardPersonDynamicThreadData.s = 3;
                cardPersonDynamicThreadData.h(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
                this.p.add(cardPersonDynamicThreadData);
            }
        }
    }

    public final void t(User user, PostInfoList postInfoList, Random random) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, user, postInfoList, random) == null) {
            if (!o() || this.f60837a) {
                if (this.s == null) {
                    this.s = new ArrayList<>();
                }
                this.f60842f = UtilHelper.getRandom(random, 3, this.f60842f);
                CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
                cardPersonDynamicThreadData.H = this.f60837a;
                cardPersonDynamicThreadData.F = false;
                cardPersonDynamicThreadData.E = false;
                cardPersonDynamicThreadData.e(user, postInfoList, this.f60842f);
                this.s.add(cardPersonDynamicThreadData);
            }
        }
    }

    public final void u(User user) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, user) == null) || user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        g gVar = new g();
        this.n = gVar;
        gVar.c(user);
    }

    public void v(d.a.q0.j2.c cVar) {
        String str;
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) || cVar == null) {
            return;
        }
        this.B = cVar.GetUser();
        if (this.f60843g == null) {
            this.f60843g = new UserData();
        }
        this.f60843g.parserProtobuf(this.B);
        if (this.C == null) {
            this.C = new MetaData();
        }
        this.C.parserProtobuf(this.B);
        if (this.z == null) {
            this.z = new PersonUserGodInfo();
        }
        UserGodInfo userGodInfo = cVar.getUserGodInfo();
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.f60843g.setIsBigV(true);
            this.z.parserProtobuf(cVar.getUserGodInfo());
        }
        if (this.f60844h == null) {
            this.f60844h = new AntiData();
        }
        this.f60844h.parserProtobuf(cVar.GetAntiStat());
        User user = this.B;
        if (user != null) {
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.f60840d = privSets.like.intValue();
                this.f60841e = this.B.priv_sets.post.intValue();
            }
            this.f60839c = this.B.sex.intValue();
        }
        if (cVar.getTaInfo() != null) {
            this.f60838b = cVar.getTaInfo().is_friend.intValue() == 1;
        }
        this.f60843g.setIsFriend(cVar.getTaInfo().is_friend.intValue());
        if (cVar.getBookrackData() != null) {
            d.a.q0.j2.i.a aVar = new d.a.q0.j2.i.a();
            aVar.a(cVar.getBookrackData());
            this.t = new d.a.q0.j2.i.d(true, aVar);
        }
        if (!ListUtils.isEmpty(cVar.getConcernedForumList()) && !this.f60837a && !n()) {
            p(cVar.getConcernedForumList());
        }
        if (this.n == null) {
            u(this.B);
        }
        Random random = new Random();
        if (this.f60837a && !ListUtils.isEmpty(cVar.GetPostList())) {
            for (PostInfoList postInfoList : cVar.GetPostList()) {
                if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                    t(this.B, postInfoList, random);
                }
            }
        }
        String yearBytime = StringHelper.getYearBytime(System.currentTimeMillis());
        if (!ListUtils.isEmpty(cVar.getDynamicInfoList())) {
            Date date = new Date();
            String str3 = "";
            String str4 = "";
            boolean z2 = true;
            for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
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
            i iVar = new i();
            this.o = iVar;
            iVar.f60877f = this.f60839c;
            iVar.f60876e = this.f60837a;
        }
        if (this.f60837a) {
            d();
            cVar.getMaskType();
        }
        cVar.getUserAgreeInfo();
        cVar.getLiveInfo();
        this.l = cVar.getGoodsWindowInfo();
        this.m = cVar.getLiveReplayInfo();
        this.A = cVar.getNicknameInfo();
        this.E = cVar.getHotRankEntry();
        List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
        if (ListUtils.isEmpty(newestThreadList)) {
            return;
        }
        for (int i2 = 0; i2 < newestThreadList.size(); i2++) {
            b2 b2Var = new b2();
            b2Var.K2(newestThreadList.get(i2));
            b2Var.j3(this.C);
            b2Var.Q2();
            this.D.add(b2Var);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f60838b = true;
            this.f60839c = 1;
            this.f60840d = 1;
            this.f60841e = 1;
            this.f60842f = -1;
            this.f60843g = null;
            ArrayList<d.a.d.k.e.n> arrayList = this.f60845i;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.f60845i = null;
            this.j = null;
            this.k = null;
            this.n = null;
            this.o = null;
            List<d.a.d.k.e.n> list = this.p;
            if (list != null) {
                list.clear();
            }
            ArrayList<d.a.d.k.e.n> arrayList2 = this.s;
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
            List<b2> list3 = this.D;
            if (list3 != null) {
                list3.clear();
            }
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f60838b = z;
        }
    }
}
