package d.a.k0.d2.h;

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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.c1;
import d.a.j0.r.q.d1;
import d.a.j0.r.q.w1;
import d.a.j0.r.q.z0;
import d.a.k0.d2.k.e.a0;
import d.a.k0.d2.k.e.i0;
import d.a.k0.d2.k.e.y;
import d.a.k0.s2.x;
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
    public List<d.a.j0.r.q.p> R;
    public d.a.k0.d2.o.p.a T;
    public PostData U;
    public PostData W;
    public boolean Y;

    /* renamed from: b  reason: collision with root package name */
    public String f52715b;

    /* renamed from: c  reason: collision with root package name */
    public CardHListViewData f52716c;
    public a0 c0;

    /* renamed from: d  reason: collision with root package name */
    public int f52717d;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public int f52718e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public List<PbSortType> f52719f;
    public List<ThreadInfo> f0;

    /* renamed from: g  reason: collision with root package name */
    public int f52720g;
    public ForumRuleStatus g0;

    /* renamed from: h  reason: collision with root package name */
    public k f52721h;
    public d.a.j0.t.d h0;
    public boolean i0;
    public List<d.a.c.j.e.n> k0;
    public a l;
    public int w;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52722i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean m = false;
    public ArrayList<d.a.k0.d3.h0.o> D = new ArrayList<>();
    public d.a.k0.d3.h0.o E = null;
    public int S = 0;
    public boolean V = true;
    public int X = 0;
    public int Z = 0;
    public List<d.a.k0.d3.h0.o> a0 = new ArrayList();
    public boolean j0 = false;
    public ForumData n = new ForumData();
    public w1 o = new w1();
    public a2 p = new a2();
    public ArrayList<PostData> q = new ArrayList<>();
    public HashMap<String, MetaData> r = new HashMap<>();
    public z0 s = new z0();
    public AntiData t = new AntiData();
    public d.a.j0.t.g u = new d.a.j0.t.g();
    public int v = 0;

    /* renamed from: a  reason: collision with root package name */
    public final UserData f52714a = new UserData();
    public List<MuteUser> z = new ArrayList();
    public c1 x = new c1();
    public d1 A = new d1();
    public i0 y = new i0();
    public s I = new s();
    public y b0 = new y();
    public List<RecommendTopicData.RecommendTopicListData> P = new ArrayList();
    public HashSet<String> Q = new HashSet<>();

    public e() {
        this.w = 0;
        this.F = null;
        this.w = 0;
        this.F = new TwzhiboAnti();
    }

    public a0 A() {
        a0 a0Var = this.c0;
        if (a0Var == null || !a0Var.isValid()) {
            return null;
        }
        return this.c0;
    }

    public i0 B() {
        return this.y;
    }

    public d1 C() {
        return this.A;
    }

    public ArrayList<PostData> D() {
        return this.q;
    }

    public d.a.k0.d2.o.p.a E() {
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
        if (e0()) {
            int size = this.q.size() <= 30 ? this.q.size() : 30;
            if (L() != null && L().T() != null && !d.a.c.e.p.k.isEmpty(L().T().getUserId())) {
                String userId = L().T().getUserId();
                PostData i2 = i();
                if (i2 != null && i2.t() != null && !d.a.c.e.p.k.isEmpty(i2.t().getUserId())) {
                    r2 = StringHelper.equals(userId, i2.t().getUserId()) ? i2.z() : null;
                    if (d.a.c.e.p.k.isEmpty("")) {
                        str = i2.P();
                    }
                }
                if (d.a.c.e.p.k.isEmpty(str) && d.a.c.e.p.k.isEmpty(r2)) {
                    for (int i3 = 0; i3 < size; i3++) {
                        PostData postData = (PostData) ListUtils.getItem(this.q, i3);
                        if (postData != null && postData.t() != null && !d.a.c.e.p.k.isEmpty(postData.t().getUserId()) && StringHelper.equals(userId, postData.t().getUserId())) {
                            if (d.a.c.e.p.k.isEmpty(r2)) {
                                r2 = postData.z();
                            }
                            if (d.a.c.e.p.k.isEmpty(str)) {
                                str = postData.P();
                            }
                            if (!d.a.c.e.p.k.isEmpty(r2) && !d.a.c.e.p.k.isEmpty(str)) {
                                break;
                            }
                        }
                    }
                }
                if (z && d.a.c.e.p.k.isEmpty(r2)) {
                    r2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                }
                a2 a2Var = this.p;
                if (a2Var != null && a2Var.O() != null && this.p.O().getGroup_id() != 0) {
                    str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
                }
                a2 a2Var2 = this.p;
                if (a2Var2 != null && a2Var2.v1() != null && !d.a.c.e.p.k.isEmpty(this.p.v1().thumbnail_url)) {
                    r2 = this.p.v1().thumbnail_url;
                }
                a2 a2Var3 = this.p;
                if (a2Var3 != null && !a2Var3.s1 && r2 == null && (originalThreadInfo = a2Var3.r1) != null && (arrayList = originalThreadInfo.f12139h) != null) {
                    int size2 = arrayList.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size2) {
                            break;
                        }
                        MediaData mediaData = arrayList.get(i4);
                        if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                            if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                                r2 = mediaData.getThumbnails_url();
                                break;
                            } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                                r2 = mediaData.getPicUrl();
                                break;
                            }
                        }
                        i4++;
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

    public List<d.a.c.j.e.n> O() {
        return this.k0;
    }

    public p P() {
        return this.M;
    }

    public s Q() {
        return this.I;
    }

    public UserData R() {
        return this.f52714a;
    }

    public int S() {
        return this.v;
    }

    public PostData T() {
        return this.J;
    }

    public String U() {
        return this.f52715b;
    }

    public List<d.a.k0.d3.h0.o> V() {
        return this.a0;
    }

    public final void W(DataRes dataRes) {
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
        this.f52717d = dataRes.exp_news_today.intValue();
        this.f52718e = dataRes.exp_guide_today.intValue();
        if (!ListUtils.isEmpty(dataRes.thread_topic)) {
            for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                recommendTopicListData.parserProtoBuf(dataRes.thread_topic.get(i2));
                this.P.add(recommendTopicListData);
            }
        }
        this.f52719f = dataRes.pb_sort_info;
        this.f52720g = dataRes.sort_type.intValue();
        ManagerElection managerElection = dataRes.manager_election;
        if (managerElection != null) {
            this.f52721h = k.i(managerElection);
        }
    }

    public final void X(DataRes dataRes, Context context) {
        a2 a2Var;
        a2 a2Var2;
        List<Post> list = dataRes.post_list;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (Post post : dataRes.post_list) {
            if (!this.Q.contains(String.valueOf(post.id))) {
                PostData postData = new PostData();
                postData.y0(this.r);
                postData.j0(this.n.isBrandForum);
                postData.b0(post, context);
                postData.s0(L().P0());
                if (postData.r() != null && postData.r().baijiahaoData == null && L() != null && L().V() != null) {
                    postData.r().baijiahaoData = L().V();
                }
                this.Q.add(postData.E());
                if (postData.A() == 1 && this.p.M1()) {
                    if (c0()) {
                        postData.r0(0);
                    } else {
                        postData.r0(this.p.G());
                    }
                } else if (postData.A() == 1 && this.p.e2()) {
                    postData.r0(41);
                } else if (postData.A() == 1 && (a2Var = this.p) != null && a2Var.B2()) {
                    postData.r0(0);
                    postData.U();
                    if (this.p.b1() != null && this.p.b1().size() != 0) {
                        postData.t0(new TbRichText(TbadkCoreApplication.getInst(), this.p.b1(), this.p.x1(), true));
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
                        postData.t0(TbRichTextView.S(context, jSONArray, false));
                    }
                    this.J = postData;
                }
                if (postData.A() == 1 && (a2Var2 = this.p) != null && a2Var2.s1) {
                    postData.q0(a2Var2.r1);
                }
                if (postData.A() == 1) {
                    this.W = postData;
                    this.V = false;
                    if (postData.t() != null && this.h0 != null) {
                        postData.t().setBusinessAccountData(this.h0);
                    }
                }
                this.q.add(postData);
            }
        }
    }

    public final void Y(DataRes dataRes) {
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
                a2Var.T2(threadInfo);
                this.B.add(a2Var);
            }
        }
        List<a2> list3 = this.B;
        if (list3 == null || list3.size() <= 15) {
            return;
        }
        this.B = ListUtils.subList(this.B, 0, 15);
    }

    public final boolean Z(ThreadInfo threadInfo) {
        Baijiahao baijiahao;
        a2 a2Var;
        if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (a2Var = this.p) == null || a2Var.V() == null || this.p.V().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.V().oriUgcNid);
    }

    public void a() {
        this.b0 = null;
        this.c0 = null;
    }

    public boolean a0() {
        return L() != null && L().A2();
    }

    public void b() {
        if (this.E.getAdvertAppInfo() != null) {
            this.E.getAdvertAppInfo().N3 = null;
        }
        this.E = null;
    }

    public boolean b0() {
        return this.i0;
    }

    public String c() {
        List<PbSortType> list = this.f52719f;
        if (list == null || list.size() <= this.f52720g) {
            return "";
        }
        for (int i2 = 0; i2 < this.f52719f.size(); i2++) {
            if (this.f52719f.get(i2).sort_type.intValue() == this.f52720g) {
                return this.f52719f.get(i2).sort_name;
            }
        }
        return "";
    }

    public boolean c0() {
        a2 a2Var = this.p;
        return (a2Var == null || a2Var.E() == null || this.p.E().size() <= 0 || this.p.E().get(0) == null || !this.p.E().get(0).d()) ? false : true;
    }

    public AntiData d() {
        return this.t;
    }

    public final boolean d0(ThreadInfo threadInfo) {
        if (threadInfo == null || N() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return N().equals(threadInfo.id) || N().equals(threadInfo.tid);
    }

    public ArrayList<d.a.k0.d3.h0.o> e() {
        return this.D;
    }

    public boolean e0() {
        ArrayList<PostData> arrayList = this.q;
        return arrayList != null && arrayList.size() > 0;
    }

    public List<d.a.j0.r.q.p> f() {
        return this.R;
    }

    public boolean f0() {
        return (L() == null || !L().B2() || L().v1() == null) ? false : true;
    }

    public int g() {
        return this.S;
    }

    public boolean g0() {
        return (L() == null || L().E2 == null || !L().E2.isWorks) ? false : true;
    }

    public w1 h() {
        return this.o;
    }

    public final void h0(DataRes dataRes) {
        d.a.k0.d3.h0.o oVar = new d.a.k0.d3.h0.o();
        oVar.y0 = true;
        App app = dataRes.banner_list.pb_banner_ad;
        App c2 = x.p().c(app, Cmatch.PB_BANNER);
        if (c2 != null && !this.j0 && !d.a.k0.s2.a.i(c2, dataRes.banner_list)) {
            oVar.L0 = true;
            this.j0 = true;
            app = c2;
        }
        oVar.H0(app);
        this.E = oVar;
    }

    public PostData i() {
        return this.W;
    }

    public final void i0(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.a0.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        for (App app : list) {
            d.a.k0.d3.h0.o oVar = new d.a.k0.d3.h0.o();
            oVar.E0 = f0();
            oVar.H0(app);
            if (!this.a0.contains(oVar)) {
                this.a0.add(oVar);
            }
        }
    }

    public PostData j() {
        return this.U;
    }

    public void j0(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return;
        }
        try {
            d.a.k0.s2.g0.a.e().h(dataRes.asp_shown_info);
            List<User> list = dataRes.user_list;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(list.get(i2));
                    String userId = metaData.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.r.put(metaData.getUserId(), metaData);
                    }
                    if (i2 == 0) {
                        this.h0 = metaData.getBusinessAccountData();
                    }
                }
            }
            p0(dataRes.is_new_url.intValue());
            this.n.parserProtobuf(dataRes.forum);
            this.o.e(dataRes.display_forum);
            this.p.s4(this.r);
            this.p.T2(dataRes.thread);
            if (this.p.T() != null && this.p.T().getBusinessAccountData() == null) {
                this.p.T().setBusinessAccountData(this.h0);
            }
            this.x.a(dataRes.news_info);
            int i3 = this.x.f49923c;
            if (i3 == 1) {
                this.y.x0 = this.x;
            } else if (i3 == 2) {
                this.y.y0 = this.x;
            } else if (i3 != 3) {
                this.y.y0 = this.x;
            } else {
                this.y.z0 = this.x;
            }
            this.A.D0(dataRes.recommend_book);
            X(dataRes, context);
            PostData postData = new PostData();
            this.U = postData;
            postData.i0(1);
            this.U.y0(this.r);
            this.U.j0(this.n.isBrandForum);
            this.U.w0(this.p.Z());
            if (dataRes.first_floor_post != null) {
                this.U.b0(dataRes.first_floor_post, context);
            }
            if (this.p != null && this.p.s1) {
                this.U.q0(this.p.r1);
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
            this.f52714a.parserProtobuf(dataRes.user);
            if (dataRes.user != null && dataRes.user.mute_user != null) {
                for (SimpleUser simpleUser : dataRes.user.mute_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.z.add(muteUser);
                    }
                }
            }
            this.p.b4(this.p.Z0() > 0 ? this.p.Z0() - 1 : 0);
            List<AdvertAppInfo> j = x.p().j();
            if (j != null) {
                j.clear();
            }
            String str = null;
            this.E = null;
            this.j0 = false;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                h0(dataRes);
                for (App app : list2) {
                    d.a.k0.d3.h0.o oVar = new d.a.k0.d3.h0.o();
                    oVar.E0 = f0();
                    App c2 = x.p().c(app, f0() ? Cmatch.VIDEO_PB_COMMENT : Cmatch.PB_COMMENT);
                    if (c2 != null && !this.j0 && !d.a.k0.s2.a.i(c2, dataRes.banner_list)) {
                        oVar.L0 = true;
                        this.j0 = true;
                        app = c2;
                    }
                    oVar.H0(app);
                    if (!this.D.contains(oVar)) {
                        this.D.add(oVar);
                        if (j != null) {
                            j.add(oVar.getAdvertAppInfo());
                        }
                    }
                }
                i0(dataRes);
            }
            x.p().i();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.f52714a.getIsSelectTail());
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
                this.f52716c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            Y(dataRes);
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
            W(dataRes);
            if (this.R == null) {
                this.R = new ArrayList();
            }
            this.R.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !d0(threadInfo) && !Z(threadInfo)) {
                        d.a.j0.r.q.p pVar = new d.a.j0.r.q.p();
                        pVar.F4(i4);
                        pVar.T2(threadInfo);
                        this.R.add(pVar);
                        i4++;
                    }
                }
            }
            if (this.T != null && this.T.v()) {
                this.T = null;
            }
            if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                if (this.T == null) {
                    d.a.k0.d2.o.p.a aVar = new d.a.k0.d2.o.p.a();
                    this.T = aVar;
                    aVar.w(dataRes.recom_ala_info);
                }
            } else if (this.T == null && dataRes.promotion != null) {
                d.a.k0.d2.o.p.a aVar2 = new d.a.k0.d2.o.p.a();
                this.T = aVar2;
                aVar2.x(dataRes.promotion);
            }
            if (dataRes.business_promot_info != null) {
                this.f52722i = dataRes.business_promot_info.is_promot.longValue() == 1;
                this.j = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                this.k = dataRes.business_promot_info.is_s_card.intValue() == 1;
                if (dataRes.business_promot_info.send_card_info != null) {
                    b bVar = new b();
                    bVar.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new a();
                    }
                    this.l.c(bVar);
                }
            }
            this.b0.e();
            this.b0.f(this.r);
            this.b0.c(dataRes.recom_ala_info);
            if (this.b0.s != null) {
                this.b0.s.n(N());
            }
            a0 a0Var = new a0();
            this.c0 = a0Var;
            a0Var.e(this.r);
            this.c0.c(dataRes.recom_ala_info);
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

    public String k() {
        return this.N;
    }

    public void k0(int i2) {
        this.S = i2;
    }

    public ForumData l() {
        return this.n;
    }

    public void l0(w1 w1Var) {
        this.o = w1Var;
    }

    public String m() {
        ForumData forumData = this.n;
        return forumData != null ? forumData.getId() : "";
    }

    public void m0(PostData postData) {
        this.U = postData;
        this.W = postData;
        this.V = false;
    }

    public String n() {
        ForumData forumData = this.n;
        return forumData != null ? forumData.getName() : "";
    }

    public void n0(PostData postData) {
        this.W = postData;
    }

    public ForumRuleStatus o() {
        return this.g0;
    }

    public void o0(boolean z) {
        a2 a2Var = this.p;
        if (a2Var == null) {
            return;
        }
        if (z) {
            a2Var.K3(1);
        } else {
            a2Var.K3(0);
        }
    }

    public List<w1> p() {
        return this.H;
    }

    public void p0(int i2) {
        this.w = i2;
    }

    public CardHListViewData q() {
        return this.f52716c;
    }

    public void q0(String str) {
        a2 a2Var = this.p;
        if (a2Var != null) {
            a2Var.U3(str);
        }
    }

    public boolean r() {
        return this.p.t0() != 0;
    }

    public void r0(z0 z0Var, int i2) {
        this.s.k(z0Var.a());
        this.s.p(z0Var.g());
        this.s.q(z0Var.h());
        this.s.o(z0Var.e());
        this.s.n(z0Var.d());
        if (i2 == 0) {
            this.s = z0Var;
        } else if (i2 == 1) {
            this.s.l(z0Var.b());
        } else if (i2 == 2) {
            this.s.m(z0Var.c());
        }
    }

    public int s() {
        return this.w;
    }

    public void s0(d.a.k0.d3.h0.o oVar) {
        this.E = oVar;
    }

    public String t() {
        a2 a2Var = this.p;
        if (a2Var != null) {
            return a2Var.J0();
        }
        return null;
    }

    public void t0(p pVar) {
        this.M = pVar;
    }

    public List<MuteUser> u() {
        return this.z;
    }

    public void u0(int i2) {
        AntiData antiData = this.t;
        if (antiData != null) {
            antiData.replyPrivateFlag = i2;
        }
    }

    public String v() {
        return this.O;
    }

    public void v0(a2 a2Var) {
        this.p = a2Var;
    }

    public z0 w() {
        return this.s;
    }

    public PostData w0(PostData postData) {
        this.J = postData;
        return postData;
    }

    public d.a.k0.d3.h0.o x() {
        return this.E;
    }

    public void x0(String str) {
        this.f52715b = str;
    }

    public i y() {
        return this.K;
    }

    public y z() {
        y yVar = this.b0;
        if (yVar == null || !yVar.isValid()) {
            return null;
        }
        return this.b0;
    }
}
