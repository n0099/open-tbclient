package d.b.i0.c2.h;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.c1;
import d.b.h0.r.q.d1;
import d.b.h0.r.q.w1;
import d.b.h0.r.q.z0;
import d.b.i0.c2.k.e.g0;
import d.b.i0.c2.k.e.w;
import d.b.i0.c2.k.e.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.App;
import tbclient.Baijiahao;
import tbclient.ForumRuleStatus;
import tbclient.ManagerElection;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbFollowTip;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class e {
    public List<a2> B;
    public AlaLiveInfoCoreData C;
    public TwzhiboAnti F;
    public List<w1> G;
    public List<w1> H;
    public PostData J;
    public i K;
    public long L;
    public p M;
    public String N;
    public String O;
    public List<d.b.h0.r.q.p> R;
    public d.b.i0.c2.o.i.a T;
    public PostData U;
    public PostData W;
    public boolean Y;

    /* renamed from: b  reason: collision with root package name */
    public String f52421b;

    /* renamed from: c  reason: collision with root package name */
    public CardHListViewData f52422c;
    public y c0;

    /* renamed from: d  reason: collision with root package name */
    public int f52423d;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public int f52424e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public List<PbSortType> f52425f;
    public List<ThreadInfo> f0;

    /* renamed from: g  reason: collision with root package name */
    public int f52426g;
    public ForumRuleStatus g0;

    /* renamed from: h  reason: collision with root package name */
    public k f52427h;
    public d.b.h0.t.c h0;
    public boolean i0;
    public a l;
    public int w;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean m = false;
    public ArrayList<d.b.i0.c3.h0.o> D = new ArrayList<>();
    public d.b.i0.c3.h0.o E = null;
    public int S = 0;
    public boolean V = true;
    public int X = 0;
    public int Z = 0;
    public List<d.b.i0.c3.h0.o> a0 = new ArrayList();
    public boolean j0 = false;
    public ForumData n = new ForumData();
    public w1 o = new w1();
    public a2 p = new a2();
    public ArrayList<PostData> q = new ArrayList<>();
    public HashMap<String, MetaData> r = new HashMap<>();
    public z0 s = new z0();
    public AntiData t = new AntiData();
    public d.b.h0.t.f u = new d.b.h0.t.f();
    public int v = 0;

    /* renamed from: a  reason: collision with root package name */
    public final UserData f52420a = new UserData();
    public List<MuteUser> z = new ArrayList();
    public c1 x = new c1();
    public d1 A = new d1();
    public g0 y = new g0();
    public s I = new s();
    public w b0 = new w();
    public List<RecommendTopicData.RecommendTopicListData> P = new ArrayList();
    public HashSet<String> Q = new HashSet<>();

    public e() {
        this.w = 0;
        this.F = null;
        this.w = 0;
        this.F = new TwzhiboAnti();
    }

    public y A() {
        y yVar = this.c0;
        if (yVar == null || !yVar.isValid()) {
            return null;
        }
        return this.c0;
    }

    public g0 B() {
        return this.y;
    }

    public d1 C() {
        return this.A;
    }

    public ArrayList<PostData> D() {
        return this.q;
    }

    public d.b.i0.c2.o.i.a E() {
        return this.T;
    }

    public List<ThreadInfo> F() {
        return this.f0;
    }

    public AlaLiveInfoCoreData G() {
        return this.C;
    }

    public List<a2> H() {
        return this.B;
    }

    public int I() {
        AntiData antiData = this.t;
        if (antiData != null) {
            return antiData.replyPrivateFlag;
        }
        return 1;
    }

    public String[] J(Context context) {
        return K(context, true);
    }

    public String[] K(Context context, boolean z) {
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        String str = "";
        if (d0()) {
            int size = this.q.size() <= 30 ? this.q.size() : 30;
            if (L() != null && L().T() != null && !d.b.b.e.p.k.isEmpty(L().T().getUserId())) {
                String userId = L().T().getUserId();
                PostData i = i();
                if (i != null && i.s() != null && !d.b.b.e.p.k.isEmpty(i.s().getUserId())) {
                    r2 = StringHelper.equals(userId, i.s().getUserId()) ? i.y() : null;
                    if (d.b.b.e.p.k.isEmpty("")) {
                        str = i.O();
                    }
                }
                if (d.b.b.e.p.k.isEmpty(str) && d.b.b.e.p.k.isEmpty(r2)) {
                    for (int i2 = 0; i2 < size; i2++) {
                        PostData postData = (PostData) ListUtils.getItem(this.q, i2);
                        if (postData != null && postData.s() != null && !d.b.b.e.p.k.isEmpty(postData.s().getUserId()) && StringHelper.equals(userId, postData.s().getUserId())) {
                            if (d.b.b.e.p.k.isEmpty(r2)) {
                                r2 = postData.y();
                            }
                            if (d.b.b.e.p.k.isEmpty(str)) {
                                str = postData.O();
                            }
                            if (!d.b.b.e.p.k.isEmpty(r2) && !d.b.b.e.p.k.isEmpty(str)) {
                                break;
                            }
                        }
                    }
                }
                if (z && d.b.b.e.p.k.isEmpty(r2)) {
                    r2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                }
                a2 a2Var = this.p;
                if (a2Var != null && a2Var.O() != null && this.p.O().getGroup_id() != 0) {
                    str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
                }
                a2 a2Var2 = this.p;
                if (a2Var2 != null && a2Var2.u1() != null && !d.b.b.e.p.k.isEmpty(this.p.u1().thumbnail_url)) {
                    r2 = this.p.u1().thumbnail_url;
                }
                a2 a2Var3 = this.p;
                if (a2Var3 != null && !a2Var3.s1 && r2 == null && (originalThreadInfo = a2Var3.r1) != null && (arrayList = originalThreadInfo.f13218h) != null) {
                    int size2 = arrayList.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size2) {
                            break;
                        }
                        MediaData mediaData = arrayList.get(i3);
                        if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                            if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                                r2 = mediaData.getThumbnails_url();
                                break;
                            } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                                r2 = mediaData.getPicUrl();
                                break;
                            }
                        }
                        i3++;
                    }
                }
            } else {
                return new String[]{null, ""};
            }
        }
        return new String[]{r2, str};
    }

    public a2 L() {
        return this.p;
    }

    public long M() {
        return this.L;
    }

    public String N() {
        a2 a2Var = this.p;
        return a2Var != null ? a2Var.o0() : "";
    }

    public p O() {
        return this.M;
    }

    public s P() {
        return this.I;
    }

    public UserData Q() {
        return this.f52420a;
    }

    public int R() {
        return this.v;
    }

    public PostData S() {
        return this.J;
    }

    public String T() {
        return this.f52421b;
    }

    public List<d.b.i0.c3.h0.o> U() {
        return this.a0;
    }

    public final void V(DataRes dataRes) {
        this.M = new p(this.p, this.t);
        String str = dataRes.partial_visible_toast;
        PbFollowTip pbFollowTip = dataRes.follow_tip;
        if (pbFollowTip != null && pbFollowTip.is_toast_tip.intValue() == 1) {
            String str2 = dataRes.follow_tip.tip_text;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        this.C = alaLiveInfoCoreData;
        AlaLiveInfo alaLiveInfo = dataRes.ala_info;
        if (alaLiveInfo != null) {
            alaLiveInfoCoreData.parserProtoBuf(alaLiveInfo);
        }
        this.N = dataRes.fold_tip;
        this.f52423d = dataRes.exp_news_today.intValue();
        this.f52424e = dataRes.exp_guide_today.intValue();
        if (!ListUtils.isEmpty(dataRes.thread_topic)) {
            for (int i = 0; i < dataRes.thread_topic.size(); i++) {
                RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                recommendTopicListData.parserProtoBuf(dataRes.thread_topic.get(i));
                this.P.add(recommendTopicListData);
            }
        }
        this.f52425f = dataRes.pb_sort_info;
        this.f52426g = dataRes.sort_type.intValue();
        ManagerElection managerElection = dataRes.manager_election;
        if (managerElection != null) {
            this.f52427h = k.i(managerElection);
        }
    }

    public final void W(DataRes dataRes, Context context) {
        a2 a2Var;
        a2 a2Var2;
        List<Post> list = dataRes.post_list;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (Post post : dataRes.post_list) {
            if (!this.Q.contains(String.valueOf(post.id))) {
                PostData postData = new PostData();
                postData.w0(this.r);
                postData.h0(this.n.isBrandForum);
                postData.a0(post, context);
                postData.q0(L().P0());
                if (postData.q() != null && postData.q().baijiahaoData == null && L() != null && L().V() != null) {
                    postData.q().baijiahaoData = L().V();
                }
                this.Q.add(postData.D());
                if (postData.z() == 1 && this.p.L1()) {
                    if (b0()) {
                        postData.p0(0);
                    } else {
                        postData.p0(this.p.G());
                    }
                } else if (postData.z() == 1 && this.p.c2()) {
                    postData.p0(41);
                } else if (postData.z() == 1 && (a2Var = this.p) != null && a2Var.y2()) {
                    postData.p0(0);
                    postData.T();
                    if (this.p.b1() != null && this.p.b1().size() != 0) {
                        postData.r0(new TbRichText(TbadkCoreApplication.getInst(), this.p.b1(), this.p.w1(), true));
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", 0);
                            jSONObject.put("text", "");
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        postData.r0(TbRichTextView.Q(context, jSONArray, false));
                    }
                    this.J = postData;
                }
                if (postData.z() == 1 && (a2Var2 = this.p) != null && a2Var2.s1) {
                    postData.o0(a2Var2.r1);
                }
                if (postData.z() == 1) {
                    this.W = postData;
                    this.V = false;
                    if (postData.s() != null && this.h0 != null) {
                        postData.s().setBusinessAccountData(this.h0);
                    }
                }
                this.q.add(postData);
            }
        }
    }

    public final void X(DataRes dataRes) {
        List<ThreadInfo> list = dataRes.feed_thread_list;
        if (list == null || list.size() <= 0) {
            return;
        }
        List<ThreadInfo> list2 = dataRes.feed_thread_list;
        if (this.B == null) {
            this.B = new ArrayList();
        }
        this.B.clear();
        for (ThreadInfo threadInfo : list2) {
            if (threadInfo != null) {
                a2 a2Var = new a2();
                a2Var.Q2(threadInfo);
                this.B.add(a2Var);
            }
        }
        List<a2> list3 = this.B;
        if (list3 == null || list3.size() <= 15) {
            return;
        }
        this.B = ListUtils.subList(this.B, 0, 15);
    }

    public final boolean Y(ThreadInfo threadInfo) {
        Baijiahao baijiahao;
        a2 a2Var;
        if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (a2Var = this.p) == null || a2Var.V() == null || this.p.V().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.V().oriUgcNid);
    }

    public boolean Z() {
        return L() != null && L().x2();
    }

    public void a() {
        this.b0 = null;
        this.c0 = null;
    }

    public boolean a0() {
        return this.i0;
    }

    public void b() {
        if (this.E.B0() != null) {
            this.E.B0().legoCard = null;
        }
        this.E = null;
    }

    public boolean b0() {
        a2 a2Var = this.p;
        return (a2Var == null || a2Var.E() == null || this.p.E().size() <= 0 || this.p.E().get(0) == null || !this.p.E().get(0).d()) ? false : true;
    }

    public String c() {
        List<PbSortType> list = this.f52425f;
        if (list == null || list.size() <= this.f52426g) {
            return "";
        }
        for (int i = 0; i < this.f52425f.size(); i++) {
            if (this.f52425f.get(i).sort_type.intValue() == this.f52426g) {
                return this.f52425f.get(i).sort_name;
            }
        }
        return "";
    }

    public final boolean c0(ThreadInfo threadInfo) {
        if (threadInfo == null || N() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return N().equals(threadInfo.id) || N().equals(threadInfo.tid);
    }

    public AntiData d() {
        return this.t;
    }

    public boolean d0() {
        ArrayList<PostData> arrayList = this.q;
        return arrayList != null && arrayList.size() > 0;
    }

    public ArrayList<d.b.i0.c3.h0.o> e() {
        return this.D;
    }

    public boolean e0() {
        return (L() == null || !L().y2() || L().u1() == null) ? false : true;
    }

    public List<d.b.h0.r.q.p> f() {
        return this.R;
    }

    public boolean f0() {
        return (L() == null || L().E2 == null || !L().E2.isWorks) ? false : true;
    }

    public int g() {
        return this.S;
    }

    public final void g0(DataRes dataRes) {
        List<String> c2;
        ArrayList<String> arrayList;
        d.b.i0.c3.h0.o oVar = new d.b.i0.c3.h0.o();
        oVar.x0 = true;
        App app = dataRes.banner_list.pb_banner_ad;
        App c3 = d.b.i0.r2.s.o().c(app, Cmatch.PB_BANNER);
        if (c3 != null && !this.j0 && !d.b.i0.r2.a.i(c3, dataRes.banner_list)) {
            oVar.M0 = true;
            this.j0 = true;
            app = c3;
        }
        oVar.I0(app);
        AppData B0 = oVar.B0();
        AppData.AppGoods appGoods = B0.goods;
        if (appGoods != null) {
            if (ListUtils.isEmpty(appGoods.thread_pic_list) && (c2 = AdvertAppInfo.a.c(B0.goods.lego_card)) != null && (arrayList = B0.goods.thread_pic_list) != null) {
                arrayList.addAll(c2);
            }
            this.E = oVar;
        }
    }

    public w1 h() {
        return this.o;
    }

    public final void h0(DataRes dataRes) {
        AppData.AppGoods appGoods;
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.a0.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        for (App app : list) {
            d.b.i0.c3.h0.o oVar = new d.b.i0.c3.h0.o();
            oVar.I0(app);
            AppData B0 = oVar.B0();
            if (!this.a0.contains(oVar) && (appGoods = B0.goods) != null && (!StringUtils.isNull(appGoods.user_name) || !StringUtils.isNull(B0.goods.lego_card))) {
                oVar.K0 = e0();
                this.a0.add(oVar);
            }
        }
    }

    public PostData i() {
        return this.W;
    }

    public void i0(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return;
        }
        try {
            d.b.i0.r2.a0.a.e().h(dataRes.asp_shown_info);
            List<User> list = dataRes.user_list;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(list.get(i));
                    String userId = metaData.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.r.put(metaData.getUserId(), metaData);
                    }
                    if (i == 0) {
                        this.h0 = metaData.getBusinessAccountData();
                    }
                }
            }
            o0(dataRes.is_new_url.intValue());
            this.n.parserProtobuf(dataRes.forum);
            this.o.e(dataRes.display_forum);
            this.p.p4(this.r);
            this.p.Q2(dataRes.thread);
            if (this.p.T() != null && this.p.T().getBusinessAccountData() == null) {
                this.p.T().setBusinessAccountData(this.h0);
            }
            this.x.a(dataRes.news_info);
            int i2 = this.x.f50737c;
            if (i2 == 1) {
                this.y.w0 = this.x;
            } else if (i2 == 2) {
                this.y.x0 = this.x;
            } else if (i2 != 3) {
                this.y.x0 = this.x;
            } else {
                this.y.y0 = this.x;
            }
            this.A.B0(dataRes.recommend_book);
            W(dataRes, context);
            PostData postData = new PostData();
            this.U = postData;
            postData.g0(1);
            this.U.w0(this.r);
            this.U.h0(this.n.isBrandForum);
            this.U.u0(this.p.Z());
            if (dataRes.first_floor_post != null) {
                this.U.a0(dataRes.first_floor_post, context);
            }
            if (this.p != null && this.p.s1) {
                this.U.o0(this.p.r1);
            }
            if (this.W == null) {
                this.W = this.U;
                this.V = true;
            }
            this.s.j(dataRes.page);
            this.t.parserProtobuf(dataRes.anti);
            this.u.c(dataRes.location);
            if (dataRes.user != null) {
                this.v = dataRes.user.is_manager.intValue();
            }
            this.f52420a.parserProtobuf(dataRes.user);
            if (dataRes.user != null && dataRes.user.mute_user != null) {
                for (SimpleUser simpleUser : dataRes.user.mute_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.z.add(muteUser);
                    }
                }
            }
            this.p.Y3(this.p.Z0() > 0 ? this.p.Z0() - 1 : 0);
            List<AppData> n = d.b.i0.r2.s.o().n();
            if (n != null) {
                n.clear();
            }
            String str = null;
            this.E = null;
            this.j0 = false;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                g0(dataRes);
                for (App app : list2) {
                    d.b.i0.c3.h0.o oVar = new d.b.i0.c3.h0.o();
                    App c2 = d.b.i0.r2.s.o().c(app, e0() ? Cmatch.VIDEO_PB_COMMENT : Cmatch.PB_COMMENT);
                    if (c2 != null && !this.j0 && !d.b.i0.r2.a.i(c2, dataRes.banner_list)) {
                        oVar.M0 = true;
                        this.j0 = true;
                        app = c2;
                    }
                    oVar.I0(app);
                    AppData B0 = oVar.B0();
                    if (!this.D.contains(oVar) && B0.goods != null && (!StringUtils.isNull(B0.goods.user_name) || !StringUtils.isNull(B0.goods.lego_card))) {
                        oVar.K0 = e0();
                        this.D.add(oVar);
                        if (n != null) {
                            n.add(oVar.B0());
                        }
                    }
                }
                h0(dataRes);
            }
            d.b.i0.r2.s.o().m();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.f52420a.getIsSelectTail());
            }
            this.F.parserProtobuf(dataRes.twzhibo_anti);
            AppealInfo appealInfo = dataRes.appeal_info;
            if (dataRes.forum_headline_img_info != null) {
                i iVar = new i();
                this.K = iVar;
                iVar.c(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.f52422c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            X(dataRes);
            if (ListUtils.getCount(dataRes.repost_recommend_forum_list) > 0) {
                if (this.G == null) {
                    this.G = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                    w1 w1Var = new w1();
                    w1Var.e(simpleForum);
                    this.G.add(w1Var);
                }
            }
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.H == null) {
                    this.H = new ArrayList();
                }
                for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                    if (simpleForum2 != null) {
                        w1 w1Var2 = new w1();
                        w1Var2.e(simpleForum2);
                        this.H.add(w1Var2);
                    }
                }
            }
            this.O = dataRes.multi_forum_text;
            if (this.L >= 0) {
                this.L = dataRes.thread_freq_num.longValue();
            }
            V(dataRes);
            if (this.R == null) {
                this.R = new ArrayList();
            }
            this.R.clear();
            if (dataRes.bjh_recommend != null) {
                int i3 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !c0(threadInfo) && !Y(threadInfo)) {
                        d.b.h0.r.q.p pVar = new d.b.h0.r.q.p();
                        pVar.C4(i3);
                        pVar.Q2(threadInfo);
                        this.R.add(pVar);
                        i3++;
                    }
                }
            }
            if (this.T != null && this.T.v()) {
                this.T = null;
            }
            if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                if (this.T == null) {
                    d.b.i0.c2.o.i.a aVar = new d.b.i0.c2.o.i.a();
                    this.T = aVar;
                    aVar.w(dataRes.recom_ala_info);
                }
            } else if (this.T == null && dataRes.promotion != null) {
                d.b.i0.c2.o.i.a aVar2 = new d.b.i0.c2.o.i.a();
                this.T = aVar2;
                aVar2.x(dataRes.promotion);
            }
            if (dataRes.business_promot_info != null) {
                this.i = dataRes.business_promot_info.is_promot.longValue() == 1;
                this.j = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                this.k = dataRes.business_promot_info.is_s_card.intValue() == 1;
                if (dataRes.business_promot_info.send_card_info != null) {
                    b bVar = new b();
                    bVar.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new a();
                    }
                    this.l.a(bVar);
                }
            }
            this.b0.e();
            this.b0.f(this.r);
            this.b0.a(dataRes.recom_ala_info);
            if (this.b0.s != null) {
                this.b0.s.n(N());
            }
            y yVar = new y();
            this.c0 = yVar;
            yVar.e(this.r);
            this.c0.a(dataRes.recom_ala_info);
            if (this.c0.r != null) {
                this.c0.r.n(N());
            }
            if (ListUtils.getCount(dataRes.recom_thread_info) > 0) {
                this.f0 = dataRes.recom_thread_info;
            }
            if (dataRes.jumptotab1 != null) {
                str = dataRes.jumptotab1.toString();
            }
            this.d0 = str;
            this.e0 = dataRes.jumptotab2;
            if (dataRes.forum_rule != null) {
                this.g0 = dataRes.forum_rule;
            }
            this.i0 = dataRes.is_black_white.intValue() == 1;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public PostData j() {
        return this.U;
    }

    public void j0(int i) {
        this.S = i;
    }

    public String k() {
        return this.N;
    }

    public void k0(w1 w1Var) {
        this.o = w1Var;
    }

    public ForumData l() {
        return this.n;
    }

    public void l0(PostData postData) {
        this.U = postData;
        this.W = postData;
        this.V = false;
    }

    public String m() {
        ForumData forumData = this.n;
        return forumData != null ? forumData.getId() : "";
    }

    public void m0(PostData postData) {
        this.W = postData;
    }

    public String n() {
        ForumData forumData = this.n;
        return forumData != null ? forumData.getName() : "";
    }

    public void n0(boolean z) {
        a2 a2Var = this.p;
        if (a2Var == null) {
            return;
        }
        if (z) {
            a2Var.H3(1);
        } else {
            a2Var.H3(0);
        }
    }

    public ForumRuleStatus o() {
        return this.g0;
    }

    public void o0(int i) {
        this.w = i;
    }

    public List<w1> p() {
        return this.H;
    }

    public void p0(String str) {
        a2 a2Var = this.p;
        if (a2Var != null) {
            a2Var.R3(str);
        }
    }

    public CardHListViewData q() {
        return this.f52422c;
    }

    public void q0(z0 z0Var, int i) {
        this.s.k(z0Var.a());
        this.s.p(z0Var.g());
        this.s.q(z0Var.h());
        this.s.o(z0Var.e());
        this.s.n(z0Var.d());
        if (i == 0) {
            this.s = z0Var;
        } else if (i == 1) {
            this.s.l(z0Var.b());
        } else if (i == 2) {
            this.s.m(z0Var.c());
        }
    }

    public boolean r() {
        return this.p.t0() != 0;
    }

    public void r0(d.b.i0.c3.h0.o oVar) {
        this.E = oVar;
    }

    public int s() {
        return this.w;
    }

    public void s0(p pVar) {
        this.M = pVar;
    }

    public String t() {
        a2 a2Var = this.p;
        if (a2Var != null) {
            return a2Var.J0();
        }
        return null;
    }

    public void t0(int i) {
        AntiData antiData = this.t;
        if (antiData != null) {
            antiData.replyPrivateFlag = i;
        }
    }

    public List<MuteUser> u() {
        return this.z;
    }

    public void u0(a2 a2Var) {
        this.p = a2Var;
    }

    public String v() {
        return this.O;
    }

    public PostData v0(PostData postData) {
        this.J = postData;
        return postData;
    }

    public z0 w() {
        return this.s;
    }

    public void w0(String str) {
        this.f52421b = str;
    }

    public d.b.i0.c3.h0.o x() {
        return this.E;
    }

    public i y() {
        return this.K;
    }

    public w z() {
        w wVar = this.b0;
        if (wVar == null || !wVar.isValid()) {
            return null;
        }
        return this.b0;
    }
}
