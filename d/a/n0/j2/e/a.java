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
    public boolean f56379a;

    /* renamed from: g  reason: collision with root package name */
    public UserData f56385g;

    /* renamed from: h  reason: collision with root package name */
    public AntiData f56386h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<d.a.c.j.e.n> f56387i;
    public c j;
    public d.a.n0.g2.h.f k;
    public d.a.n0.x0.b l;
    public List<AlaLiveInfoCoreData> m;
    public g n;
    public i o;
    public List<d.a.c.j.e.n> p;
    public ArrayList<d.a.c.j.e.n> s;
    public d.a.n0.g2.i.d t;
    public n u;
    public n v;
    public n w;
    public n x;
    public n y;
    public PersonUserGodInfo z;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56380b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f56381c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f56382d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f56383e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f56384f = -1;
    public ArrayList<d.a.c.j.e.n> q = new ArrayList<>();
    public ArrayList<n> r = new ArrayList<>();
    public List<a2> D = new ArrayList();

    public a(boolean z) {
        this.f56379a = z;
    }

    public d.a.n0.g2.d a(int i2, int i3) {
        d.a.n0.g2.d dVar = new d.a.n0.g2.d();
        dVar.f55165e = i2;
        dVar.f55167g = i3;
        return dVar;
    }

    public abstract void b();

    public final n c(int i2, int i3, int i4) {
        n nVar = new n();
        TbadkCoreApplication.getInst().getString(i3);
        d.a.n0.h2.f.a aVar = new d.a.n0.h2.f.a();
        nVar.f56435a = aVar;
        aVar.f56586a = i4;
        return nVar;
    }

    public final void d() {
        this.r.clear();
        n c2 = c(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.v = c2;
        c2.f56436b = new Bundle();
        this.v.f56436b.putBoolean("person_center_item_red_tip", true);
        this.v.f56435a.f56587b = new Bundle();
        this.v.f56435a.f56587b.putSerializable(UserData.TYPE_USER, this.f56385g);
        this.r.add(this.v);
        n c3 = c(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.w = c3;
        c3.f56436b = new Bundle();
        this.w.f56436b.putBoolean("person_center_item_red_tip", true);
        this.w.f56435a.f56587b = new Bundle();
        this.w.f56435a.f56587b.putSerializable(UserData.TYPE_USER, this.f56385g);
        this.r.add(this.w);
        n c4 = c(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.u = c4;
        c4.f56436b = new Bundle();
        this.u.f56436b.putBoolean("person_center_item_red_tip", true);
        this.u.f56435a.f56587b = new Bundle();
        this.u.f56435a.f56587b.putSerializable(UserData.TYPE_USER, this.f56385g);
        this.r.add(this.u);
        n c5 = c(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        c5.f56435a.f56587b = new Bundle();
        c5.f56435a.f56587b.putSerializable(UserData.TYPE_USER, this.f56385g);
        this.r.add(c5);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n c6 = c(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            c6.f56436b = new Bundle();
            c6.f56435a.f56587b = new Bundle();
            c6.f56435a.f56587b.putSerializable(UserData.TYPE_USER, this.f56385g);
            this.r.add(c6);
        }
        n c7 = c(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.x = c7;
        c7.f56436b = new Bundle();
        this.x.f56436b.putBoolean("person_center_item_red_tip", true);
        this.x.f56435a.f56587b = new Bundle();
        this.x.f56435a.f56587b.putSerializable(UserData.TYPE_USER, this.f56385g);
        this.r.add(this.x);
        n c8 = c(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        c8.f56435a.f56587b = new Bundle();
        c8.f56435a.f56587b.putSerializable(UserData.TYPE_USER, this.f56385g);
        d.a.n0.g2.i.d dVar = this.t;
        if (dVar != null) {
            c8.f56435a.f56587b.putString("book_jump_link", dVar.f55203e);
        }
        this.r.add(c8);
        n c9 = c(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        c9.f56435a.f56587b = new Bundle();
        c9.f56435a.f56587b.putSerializable(UserData.TYPE_USER, this.f56385g);
        this.r.add(c9);
        n c10 = c(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        c10.f56435a.f56587b = new Bundle();
        c10.f56435a.f56587b.putSerializable(UserData.TYPE_USER, this.f56385g);
        this.r.add(c10);
        n c11 = c(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        c11.f56435a.f56587b = new Bundle();
        c11.f56435a.f56587b.putString("key_service_centre", "");
        this.r.add(c11);
    }

    public AntiData e() {
        return this.f56386h;
    }

    public ArrayList<d.a.c.j.e.n> f() {
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
        return this.f56385g;
    }

    public List<d.a.c.j.e.n> k() {
        d.a.n0.g2.h.f fVar = this.k;
        if (fVar == null) {
            return null;
        }
        return fVar.c();
    }

    public boolean l() {
        return this.f56380b;
    }

    public boolean m() {
        return this.f56379a;
    }

    public final boolean n() {
        if (this.f56379a) {
            return false;
        }
        int i2 = this.f56382d;
        if (i2 == 3) {
            return true;
        }
        return i2 == 2 && !this.f56380b;
    }

    public boolean o() {
        if (this.f56379a) {
            return false;
        }
        int i2 = this.f56383e;
        if (i2 == 3) {
            return true;
        }
        return i2 == 2 && !this.f56380b;
    }

    public final void p(List<ForumDynamic> list) {
        c cVar = new c();
        this.j = cVar;
        cVar.f56394e = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.f56404e = forumDynamic.forum_id.longValue();
                fVar.f56405f = forumDynamic.forum_name;
                fVar.f56406g = forumDynamic.avatar;
                fVar.f56408i = this.f56381c;
                fVar.f56407h = forumDynamic.user_thread_count.intValue();
                this.j.f56394e.add(fVar);
            }
        }
    }

    public final void q(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!n() || this.f56379a) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.p == null) {
                this.p = new ArrayList();
            }
            b bVar = new b();
            bVar.f56388e = this.f56379a;
            bVar.f56389f = this.f56381c;
            bVar.f56390g = z;
            bVar.f56391h = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.f56392i = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
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
        dVar.f56395e = this.f56379a;
        dVar.f56396f = z;
        dVar.f56399i = this.f56381c;
        dVar.f56397g = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.f56398h = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.f56398h = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
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
        if ((!o() || this.f56379a) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.p == null) {
                this.p = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.f56384f);
            this.f56384f = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.H = this.f56379a;
            cardPersonDynamicThreadData.F = z;
            cardPersonDynamicThreadData.E = z2;
            cardPersonDynamicThreadData.G = z3;
            cardPersonDynamicThreadData.s = 3;
            cardPersonDynamicThreadData.C(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.p.add(cardPersonDynamicThreadData);
        }
    }

    public final void t(User user, PostInfoList postInfoList, Random random) {
        if (!o() || this.f56379a) {
            if (this.s == null) {
                this.s = new ArrayList<>();
            }
            this.f56384f = UtilHelper.getRandom(random, 3, this.f56384f);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.H = this.f56379a;
            cardPersonDynamicThreadData.F = false;
            cardPersonDynamicThreadData.E = false;
            cardPersonDynamicThreadData.B(user, postInfoList, this.f56384f);
            this.s.add(cardPersonDynamicThreadData);
        }
    }

    public final void u(User user) {
        if (user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        g gVar = new g();
        this.n = gVar;
        gVar.h(user);
    }

    public void v(d.a.n0.g2.c cVar) {
        String str;
        String str2;
        boolean z;
        if (cVar == null) {
            return;
        }
        this.B = cVar.GetUser();
        if (this.f56385g == null) {
            this.f56385g = new UserData();
        }
        this.f56385g.parserProtobuf(this.B);
        if (this.C == null) {
            this.C = new MetaData();
        }
        this.C.parserProtobuf(this.B);
        if (this.z == null) {
            this.z = new PersonUserGodInfo();
        }
        UserGodInfo userGodInfo = cVar.getUserGodInfo();
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.f56385g.setIsBigV(true);
            this.z.parserProtobuf(cVar.getUserGodInfo());
        }
        if (this.f56386h == null) {
            this.f56386h = new AntiData();
        }
        this.f56386h.parserProtobuf(cVar.GetAntiStat());
        User user = this.B;
        if (user != null) {
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.f56382d = privSets.like.intValue();
                this.f56383e = this.B.priv_sets.post.intValue();
            }
            this.f56381c = this.B.sex.intValue();
        }
        if (cVar.getTaInfo() != null) {
            this.f56380b = cVar.getTaInfo().is_friend.intValue() == 1;
        }
        this.f56385g.setIsFriend(cVar.getTaInfo().is_friend.intValue());
        if (cVar.getBookrackData() != null) {
            d.a.n0.g2.i.a aVar = new d.a.n0.g2.i.a();
            aVar.a(cVar.getBookrackData());
            this.t = new d.a.n0.g2.i.d(true, aVar);
        }
        if (!ListUtils.isEmpty(cVar.getConcernedForumList()) && !this.f56379a && !n()) {
            p(cVar.getConcernedForumList());
        }
        if (this.n == null) {
            u(this.B);
        }
        Random random = new Random();
        if (this.f56379a && !ListUtils.isEmpty(cVar.GetPostList())) {
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
            iVar.f56419f = this.f56381c;
            iVar.f56418e = this.f56379a;
        }
        if (this.f56379a) {
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
            a2Var.U2(newestThreadList.get(i2));
            a2Var.t3(this.C);
            a2Var.a3();
            this.D.add(a2Var);
        }
    }

    public void w() {
        this.f56380b = true;
        this.f56381c = 1;
        this.f56382d = 1;
        this.f56383e = 1;
        this.f56384f = -1;
        this.f56385g = null;
        ArrayList<d.a.c.j.e.n> arrayList = this.f56387i;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f56387i = null;
        this.j = null;
        this.k = null;
        this.n = null;
        this.o = null;
        List<d.a.c.j.e.n> list = this.p;
        if (list != null) {
            list.clear();
        }
        ArrayList<d.a.c.j.e.n> arrayList2 = this.s;
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
        this.f56380b = z;
    }
}
