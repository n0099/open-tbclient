package d.a.n0.j2.e;

import android.os.Bundle;
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
import d.a.m0.r.q.a2;
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
/* loaded from: classes5.dex */
public abstract class a {
    public NicknameInfo A;
    public User B;
    public MetaData C;
    public HotUserRankEntry E;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60068a;

    /* renamed from: g  reason: collision with root package name */
    public UserData f60074g;

    /* renamed from: h  reason: collision with root package name */
    public AntiData f60075h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<d.a.c.k.e.n> f60076i;
    public c j;
    public d.a.n0.g2.h.f k;
    public d.a.n0.x0.b l;
    public List<AlaLiveInfoCoreData> m;
    public g n;
    public i o;
    public List<d.a.c.k.e.n> p;
    public ArrayList<d.a.c.k.e.n> s;
    public d.a.n0.g2.i.d t;
    public n u;
    public n v;
    public n w;
    public n x;
    public n y;
    public PersonUserGodInfo z;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60069b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f60070c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f60071d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f60072e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f60073f = -1;
    public ArrayList<d.a.c.k.e.n> q = new ArrayList<>();
    public ArrayList<n> r = new ArrayList<>();
    public List<a2> D = new ArrayList();

    public a(boolean z) {
        this.f60068a = z;
    }

    public d.a.n0.g2.d a(int i2, int i3) {
        d.a.n0.g2.d dVar = new d.a.n0.g2.d();
        dVar.f58854e = i2;
        dVar.f58856g = i3;
        return dVar;
    }

    public abstract void b();

    public final n c(int i2, int i3, int i4) {
        n nVar = new n();
        TbadkCoreApplication.getInst().getString(i3);
        d.a.n0.h2.f.a aVar = new d.a.n0.h2.f.a();
        nVar.f60124a = aVar;
        aVar.f60275a = i4;
        return nVar;
    }

    public final void d() {
        this.r.clear();
        n c2 = c(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.v = c2;
        c2.f60125b = new Bundle();
        this.v.f60125b.putBoolean("person_center_item_red_tip", true);
        this.v.f60124a.f60276b = new Bundle();
        this.v.f60124a.f60276b.putSerializable(UserData.TYPE_USER, this.f60074g);
        this.r.add(this.v);
        n c3 = c(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.w = c3;
        c3.f60125b = new Bundle();
        this.w.f60125b.putBoolean("person_center_item_red_tip", true);
        this.w.f60124a.f60276b = new Bundle();
        this.w.f60124a.f60276b.putSerializable(UserData.TYPE_USER, this.f60074g);
        this.r.add(this.w);
        n c4 = c(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.u = c4;
        c4.f60125b = new Bundle();
        this.u.f60125b.putBoolean("person_center_item_red_tip", true);
        this.u.f60124a.f60276b = new Bundle();
        this.u.f60124a.f60276b.putSerializable(UserData.TYPE_USER, this.f60074g);
        this.r.add(this.u);
        n c5 = c(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        c5.f60124a.f60276b = new Bundle();
        c5.f60124a.f60276b.putSerializable(UserData.TYPE_USER, this.f60074g);
        this.r.add(c5);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n c6 = c(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            c6.f60125b = new Bundle();
            c6.f60124a.f60276b = new Bundle();
            c6.f60124a.f60276b.putSerializable(UserData.TYPE_USER, this.f60074g);
            this.r.add(c6);
        }
        n c7 = c(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.x = c7;
        c7.f60125b = new Bundle();
        this.x.f60125b.putBoolean("person_center_item_red_tip", true);
        this.x.f60124a.f60276b = new Bundle();
        this.x.f60124a.f60276b.putSerializable(UserData.TYPE_USER, this.f60074g);
        this.r.add(this.x);
        n c8 = c(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        c8.f60124a.f60276b = new Bundle();
        c8.f60124a.f60276b.putSerializable(UserData.TYPE_USER, this.f60074g);
        d.a.n0.g2.i.d dVar = this.t;
        if (dVar != null) {
            c8.f60124a.f60276b.putString("book_jump_link", dVar.f58892e);
        }
        this.r.add(c8);
        n c9 = c(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        c9.f60124a.f60276b = new Bundle();
        c9.f60124a.f60276b.putSerializable(UserData.TYPE_USER, this.f60074g);
        this.r.add(c9);
        n c10 = c(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        c10.f60124a.f60276b = new Bundle();
        c10.f60124a.f60276b.putSerializable(UserData.TYPE_USER, this.f60074g);
        this.r.add(c10);
        n c11 = c(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        c11.f60124a.f60276b = new Bundle();
        c11.f60124a.f60276b.putString("key_service_centre", "");
        this.r.add(c11);
    }

    public AntiData e() {
        return this.f60075h;
    }

    public ArrayList<d.a.c.k.e.n> f() {
        return this.q;
    }

    public d.a.n0.x0.b g() {
        return this.l;
    }

    public List<a2> h() {
        return this.D;
    }

    public User i() {
        return this.B;
    }

    public UserData j() {
        return this.f60074g;
    }

    public List<d.a.c.k.e.n> k() {
        d.a.n0.g2.h.f fVar = this.k;
        if (fVar == null) {
            return null;
        }
        return fVar.b();
    }

    public boolean l() {
        return this.f60069b;
    }

    public boolean m() {
        return this.f60068a;
    }

    public final boolean n() {
        if (this.f60068a) {
            return false;
        }
        int i2 = this.f60071d;
        if (i2 == 3) {
            return true;
        }
        return i2 == 2 && !this.f60069b;
    }

    public boolean o() {
        if (this.f60068a) {
            return false;
        }
        int i2 = this.f60072e;
        if (i2 == 3) {
            return true;
        }
        return i2 == 2 && !this.f60069b;
    }

    public final void p(List<ForumDynamic> list) {
        c cVar = new c();
        this.j = cVar;
        cVar.f60083e = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.f60093e = forumDynamic.forum_id.longValue();
                fVar.f60094f = forumDynamic.forum_name;
                fVar.f60095g = forumDynamic.avatar;
                fVar.f60097i = this.f60070c;
                fVar.f60096h = forumDynamic.user_thread_count.intValue();
                this.j.f60083e.add(fVar);
            }
        }
    }

    public final void q(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!n() || this.f60068a) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.p == null) {
                this.p = new ArrayList();
            }
            b bVar = new b();
            bVar.f60077e = this.f60068a;
            bVar.f60078f = this.f60070c;
            bVar.f60079g = z;
            bVar.f60080h = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.f60081i = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.j = forumDynamic.forum_id.longValue();
            bVar.k = forumDynamic.avatar;
            bVar.l = forumDynamic.forum_name;
            bVar.m = forumDynamic.is_like.intValue() == 1;
            bVar.n = forumDynamic.member_count.intValue();
            bVar.o = forumDynamic.thread_count.intValue();
            this.p.add(bVar);
            this.p.add(a(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public final void r(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic == null) {
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
        dVar.f60084e = this.f60068a;
        dVar.f60085f = z;
        dVar.f60088i = this.f60070c;
        dVar.f60086g = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.f60087h = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.f60087h = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
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
        if ((!o() || this.f60068a) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.p == null) {
                this.p = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.f60073f);
            this.f60073f = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.H = this.f60068a;
            cardPersonDynamicThreadData.F = z;
            cardPersonDynamicThreadData.E = z2;
            cardPersonDynamicThreadData.G = z3;
            cardPersonDynamicThreadData.s = 3;
            cardPersonDynamicThreadData.C(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.p.add(cardPersonDynamicThreadData);
        }
    }

    public final void t(User user, PostInfoList postInfoList, Random random) {
        if (!o() || this.f60068a) {
            if (this.s == null) {
                this.s = new ArrayList<>();
            }
            this.f60073f = UtilHelper.getRandom(random, 3, this.f60073f);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.H = this.f60068a;
            cardPersonDynamicThreadData.F = false;
            cardPersonDynamicThreadData.E = false;
            cardPersonDynamicThreadData.B(user, postInfoList, this.f60073f);
            this.s.add(cardPersonDynamicThreadData);
        }
    }

    public final void u(User user) {
        if (user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        g gVar = new g();
        this.n = gVar;
        gVar.c(user);
    }

    public void v(d.a.n0.g2.c cVar) {
        String str;
        String str2;
        boolean z;
        if (cVar == null) {
            return;
        }
        this.B = cVar.GetUser();
        if (this.f60074g == null) {
            this.f60074g = new UserData();
        }
        this.f60074g.parserProtobuf(this.B);
        if (this.C == null) {
            this.C = new MetaData();
        }
        this.C.parserProtobuf(this.B);
        if (this.z == null) {
            this.z = new PersonUserGodInfo();
        }
        UserGodInfo userGodInfo = cVar.getUserGodInfo();
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.f60074g.setIsBigV(true);
            this.z.parserProtobuf(cVar.getUserGodInfo());
        }
        if (this.f60075h == null) {
            this.f60075h = new AntiData();
        }
        this.f60075h.parserProtobuf(cVar.GetAntiStat());
        User user = this.B;
        if (user != null) {
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.f60071d = privSets.like.intValue();
                this.f60072e = this.B.priv_sets.post.intValue();
            }
            this.f60070c = this.B.sex.intValue();
        }
        if (cVar.getTaInfo() != null) {
            this.f60069b = cVar.getTaInfo().is_friend.intValue() == 1;
        }
        this.f60074g.setIsFriend(cVar.getTaInfo().is_friend.intValue());
        if (cVar.getBookrackData() != null) {
            d.a.n0.g2.i.a aVar = new d.a.n0.g2.i.a();
            aVar.a(cVar.getBookrackData());
            this.t = new d.a.n0.g2.i.d(true, aVar);
        }
        if (!ListUtils.isEmpty(cVar.getConcernedForumList()) && !this.f60068a && !n()) {
            p(cVar.getConcernedForumList());
        }
        if (this.n == null) {
            u(this.B);
        }
        Random random = new Random();
        if (this.f60068a && !ListUtils.isEmpty(cVar.GetPostList())) {
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
            iVar.f60108f = this.f60070c;
            iVar.f60107e = this.f60068a;
        }
        if (this.f60068a) {
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
            a2 a2Var = new a2();
            a2Var.V2(newestThreadList.get(i2));
            a2Var.u3(this.C);
            a2Var.b3();
            this.D.add(a2Var);
        }
    }

    public void w() {
        this.f60069b = true;
        this.f60070c = 1;
        this.f60071d = 1;
        this.f60072e = 1;
        this.f60073f = -1;
        this.f60074g = null;
        ArrayList<d.a.c.k.e.n> arrayList = this.f60076i;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f60076i = null;
        this.j = null;
        this.k = null;
        this.n = null;
        this.o = null;
        List<d.a.c.k.e.n> list = this.p;
        if (list != null) {
            list.clear();
        }
        ArrayList<d.a.c.k.e.n> arrayList2 = this.s;
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
        List<a2> list3 = this.D;
        if (list3 != null) {
            list3.clear();
        }
    }

    public void x(boolean z) {
        this.f60069b = z;
    }
}
