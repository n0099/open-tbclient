package d.a.q0.h2.h;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
import com.baidu.tbadk.data.BusinessAccountData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.a1;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.d1;
import d.a.p0.s.q.e1;
import d.a.p0.s.q.x1;
import d.a.q0.h2.k.e.a0;
import d.a.q0.h2.k.e.i0;
import d.a.q0.h2.k.e.y;
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
import tbclient.PbPage.FloatingIcon;
import tbclient.PbPage.PbFollowTip;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e1 A;
    public List<b2> B;
    public AlaLiveInfoCoreData C;
    public ArrayList<d.a.q0.h3.h0.o> D;
    public d.a.q0.h3.h0.o E;
    public TwzhiboAnti F;
    public List<x1> G;
    public List<x1> H;
    public u I;
    public PostData J;
    public i K;
    public long L;
    public p M;
    public String N;
    public String O;
    public List<RecommendTopicData.RecommendTopicListData> P;
    public HashSet<String> Q;
    public List<d.a.p0.s.q.q> R;
    public int S;
    public d.a.q0.h2.o.i.a T;
    public PostData U;
    public boolean V;
    public PostData W;
    public int X;
    public boolean Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public final UserData f57437a;
    public List<d.a.q0.h3.h0.o> a0;

    /* renamed from: b  reason: collision with root package name */
    public String f57438b;
    public y b0;

    /* renamed from: c  reason: collision with root package name */
    public CardHListViewData f57439c;
    public a0 c0;

    /* renamed from: d  reason: collision with root package name */
    public int f57440d;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public int f57441e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public List<PbSortType> f57442f;
    public List<ThreadInfo> f0;

    /* renamed from: g  reason: collision with root package name */
    public int f57443g;
    public ForumRuleStatus g0;

    /* renamed from: h  reason: collision with root package name */
    public k f57444h;
    public BusinessAccountData h0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57445i;
    public boolean i0;
    public boolean j;
    public boolean j0;
    public boolean k;
    public int k0;
    public a l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public FloatingIcon n0;
    public x1 o;
    public List<d.a.d.k.e.n> o0;
    public b2 p;
    public boolean p0;
    public ArrayList<PostData> q;
    public HashMap<String, MetaData> r;
    public a1 s;
    public AntiData t;
    public d.a.p0.u.f u;
    public int v;
    public int w;
    public d1 x;
    public i0 y;
    public List<MuteUser> z;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57445i = false;
        this.j = false;
        this.k = false;
        this.m = false;
        this.w = 0;
        this.D = new ArrayList<>();
        this.E = null;
        this.F = null;
        this.S = 0;
        this.V = true;
        this.X = 0;
        this.Z = 0;
        this.a0 = new ArrayList();
        this.j0 = false;
        this.k0 = 0;
        this.p0 = false;
        this.n = new ForumData();
        this.o = new x1();
        this.p = new b2();
        this.q = new ArrayList<>();
        this.r = new HashMap<>();
        this.s = new a1();
        this.t = new AntiData();
        this.u = new d.a.p0.u.f();
        this.v = 0;
        this.w = 0;
        this.f57437a = new UserData();
        this.z = new ArrayList();
        this.x = new d1();
        this.A = new e1();
        this.y = new i0();
        this.F = new TwzhiboAnti();
        this.I = new u();
        this.b0 = new y();
        this.P = new ArrayList();
        this.Q = new HashSet<>();
    }

    public y A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            y yVar = this.b0;
            if (yVar == null || !yVar.isValid()) {
                return null;
            }
            return this.b0;
        }
        return (y) invokeV.objValue;
    }

    public void A0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.k0 = i2;
        }
    }

    public a0 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a0 a0Var = this.c0;
            if (a0Var == null || !a0Var.isValid()) {
                return null;
            }
            return this.c0;
        }
        return (a0) invokeV.objValue;
    }

    public void B0(int i2) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (antiData = this.t) == null) {
            return;
        }
        antiData.replyPrivateFlag = i2;
    }

    public i0 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.y : (i0) invokeV.objValue;
    }

    public void C0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b2Var) == null) {
            this.p = b2Var;
        }
    }

    public e1 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : (e1) invokeV.objValue;
    }

    public void D0(List<d.a.d.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.o0 = list;
        }
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public PostData E0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, postData)) == null) {
            this.J = postData;
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public d.a.q0.h2.o.i.a F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.T : (d.a.q0.h2.o.i.a) invokeV.objValue;
    }

    public void F0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f57438b = str;
        }
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k0 : invokeV.intValue;
    }

    public List<ThreadInfo> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f0 : (List) invokeV.objValue;
    }

    public AlaLiveInfoCoreData I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.C : (AlaLiveInfoCoreData) invokeV.objValue;
    }

    public List<b2> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.B : (List) invokeV.objValue;
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            AntiData antiData = this.t;
            if (antiData != null) {
                return antiData.replyPrivateFlag;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public String[] L(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, context)) == null) ? M(context, true) : (String[]) invokeL.objValue;
    }

    public String[] M(Context context, boolean z) {
        InterceptResult invokeLZ;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, context, z)) == null) {
            String str = "";
            if (k0()) {
                int size = this.q.size() <= 30 ? this.q.size() : 30;
                if (N() != null && N().H() != null && !d.a.d.e.p.k.isEmpty(N().H().getUserId())) {
                    String userId = N().H().getUserId();
                    PostData i2 = i();
                    if (i2 != null && i2.t() != null && !d.a.d.e.p.k.isEmpty(i2.t().getUserId())) {
                        r2 = StringHelper.equals(userId, i2.t().getUserId()) ? i2.z() : null;
                        if (d.a.d.e.p.k.isEmpty("")) {
                            str = i2.P();
                        }
                    }
                    if (d.a.d.e.p.k.isEmpty(str) && d.a.d.e.p.k.isEmpty(r2)) {
                        for (int i3 = 0; i3 < size; i3++) {
                            PostData postData = (PostData) ListUtils.getItem(this.q, i3);
                            if (postData != null && postData.t() != null && !d.a.d.e.p.k.isEmpty(postData.t().getUserId()) && StringHelper.equals(userId, postData.t().getUserId())) {
                                if (d.a.d.e.p.k.isEmpty(r2)) {
                                    r2 = postData.z();
                                }
                                if (d.a.d.e.p.k.isEmpty(str)) {
                                    str = postData.P();
                                }
                                if (!d.a.d.e.p.k.isEmpty(r2) && !d.a.d.e.p.k.isEmpty(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && d.a.d.e.p.k.isEmpty(r2)) {
                        r2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    b2 b2Var = this.p;
                    if (b2Var != null && b2Var.C() != null && this.p.C().getGroup_id() != 0) {
                        str = PreferencesUtil.LEFT_MOUNT + context.getString(R.string.photo_live_tips) + "] " + str;
                    }
                    b2 b2Var2 = this.p;
                    if (b2Var2 != null && b2Var2.m1() != null && !d.a.d.e.p.k.isEmpty(this.p.m1().thumbnail_url)) {
                        r2 = this.p.m1().thumbnail_url;
                    }
                    b2 b2Var3 = this.p;
                    if (b2Var3 != null && !b2Var3.v1 && r2 == null && (originalThreadInfo = b2Var3.u1) != null && (arrayList = originalThreadInfo.f12284h) != null) {
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
        return (String[]) invokeLZ.objValue;
    }

    public b2 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.p : (b2) invokeV.objValue;
    }

    public long O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.L : invokeV.longValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            b2 b2Var = this.p;
            return b2Var != null ? b2Var.d0() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<d.a.d.k.e.n> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.o0 : (List) invokeV.objValue;
    }

    public p R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.M : (p) invokeV.objValue;
    }

    public u S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.I : (u) invokeV.objValue;
    }

    public UserData T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f57437a : (UserData) invokeV.objValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.v : invokeV.intValue;
    }

    public PostData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.J : (PostData) invokeV.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f57438b : (String) invokeV.objValue;
    }

    public List<d.a.q0.h3.h0.o> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.a0 : (List) invokeV.objValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            a1 a1Var = this.s;
            return a1Var != null && a1Var.b() == 1;
        }
        return invokeV.booleanValue;
    }

    public final void Z(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, dataRes) == null) {
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
            this.f57440d = dataRes.exp_news_today.intValue();
            this.f57441e = dataRes.exp_guide_today.intValue();
            if (!ListUtils.isEmpty(dataRes.thread_topic)) {
                for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                    RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(dataRes.thread_topic.get(i2));
                    this.P.add(recommendTopicListData);
                }
            }
            this.f57442f = dataRes.pb_sort_info;
            this.f57443g = dataRes.sort_type.intValue();
            ManagerElection managerElection = dataRes.manager_election;
            if (managerElection != null) {
                this.f57444h = k.i(managerElection);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.b0 = null;
            this.c0 = null;
        }
    }

    public final void a0(DataRes dataRes, Context context) {
        List<Post> list;
        b2 b2Var;
        b2 b2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, dataRes, context) == null) || (list = dataRes.post_list) == null || list.size() <= 0) {
            return;
        }
        for (Post post : dataRes.post_list) {
            if (!this.Q.contains(String.valueOf(post.id))) {
                PostData postData = new PostData();
                postData.y0(this.r);
                postData.j0(this.n.isBrandForum);
                postData.b0(post, context);
                postData.s0(N().H0());
                if (postData.q() != null && postData.q().baijiahaoData == null && N() != null && N().J() != null) {
                    postData.q().baijiahaoData = N().J();
                }
                this.Q.add(postData.E());
                if (postData.A() == 1 && this.p.C1()) {
                    if (i0()) {
                        postData.r0(0);
                    } else {
                        postData.r0(this.p.q());
                    }
                } else if (postData.A() == 1 && this.p.U1()) {
                    postData.r0(41);
                } else if (postData.A() == 1 && (b2Var = this.p) != null && b2Var.s2()) {
                    postData.r0(0);
                    postData.U();
                    if (this.p.S0() != null && this.p.S0().size() != 0) {
                        postData.t0(new TbRichText(TbadkCoreApplication.getInst(), this.p.S0(), this.p.o1(), true));
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
                        postData.t0(TbRichTextView.T(context, jSONArray, false));
                    }
                    this.J = postData;
                }
                if (postData.A() == 1 && (b2Var2 = this.p) != null && b2Var2.v1) {
                    postData.q0(b2Var2.u1);
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

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.E.getAdvertAppInfo() != null) {
                this.E.getAdvertAppInfo().Z3 = null;
            }
            this.E = null;
        }
    }

    public final void b0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, dataRes) == null) || (list = dataRes.feed_thread_list) == null || list.size() <= 0) {
            return;
        }
        List<ThreadInfo> list2 = dataRes.feed_thread_list;
        if (this.B == null) {
            this.B = new ArrayList();
        }
        this.B.clear();
        for (ThreadInfo threadInfo : list2) {
            if (threadInfo != null) {
                b2 b2Var = new b2();
                b2Var.K2(threadInfo);
                this.B.add(b2Var);
            }
        }
        List<b2> list3 = this.B;
        if (list3 == null || list3.size() <= 15) {
            return;
        }
        this.B = ListUtils.subList(this.B, 0, 15);
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            List<PbSortType> list = this.f57442f;
            if (list == null || list.size() <= this.f57443g) {
                return "";
            }
            for (int i2 = 0; i2 < this.f57442f.size(); i2++) {
                if (this.f57442f.get(i2).sort_type.intValue() == this.f57443g) {
                    return this.f57442f.get(i2).sort_name;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.p0 : invokeV.booleanValue;
    }

    public AntiData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.t : (AntiData) invokeV.objValue;
    }

    public final boolean d0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (b2Var = this.p) == null || b2Var.J() == null || this.p.J().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.J().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<d.a.q0.h3.h0.o> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.D : (ArrayList) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? N() != null && N().r2() : invokeV.booleanValue;
    }

    public List<d.a.p0.s.q.q> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.R : (List) invokeV.objValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.S : invokeV.intValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.l0 : invokeV.booleanValue;
    }

    public x1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.o : (x1) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.m0 : invokeV.booleanValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.W : (PostData) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            b2 b2Var = this.p;
            return (b2Var == null || b2Var.o() == null || this.p.o().size() <= 0 || this.p.o().get(0) == null || !this.p.o().get(0).d()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public PostData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.U : (PostData) invokeV.objValue;
    }

    public final boolean j0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, threadInfo)) == null) {
            if (threadInfo == null || P() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
                return false;
            }
            return P().equals(threadInfo.id) || P().equals(threadInfo.tid);
        }
        return invokeL.booleanValue;
    }

    public FloatingIcon k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.n0 : (FloatingIcon) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            ArrayList<PostData> arrayList = this.q;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.N : (String) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? (N() == null || !N().s2() || N().m1() == null) ? false : true : invokeV.booleanValue;
    }

    public ForumData m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.n : (ForumData) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? (N() == null || N().I2 == null || !N().I2.isWorks) ? false : true : invokeV.booleanValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getId() : "";
        }
        return (String) invokeV.objValue;
    }

    public final void n0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, dataRes) == null) {
            d.a.q0.h3.h0.o oVar = new d.a.q0.h3.h0.o();
            oVar.D0 = true;
            App app = dataRes.banner_list.pb_banner_ad;
            App c2 = d.a.q0.w2.w.o().c(app, Cmatch.PB_BANNER);
            if (c2 != null && !this.j0 && !d.a.q0.w2.a.j(c2, dataRes.banner_list)) {
                oVar.L0 = true;
                this.j0 = true;
                app = c2;
            }
            oVar.H0(app);
            this.E = oVar;
        }
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getName() : "";
        }
        return (String) invokeV.objValue;
    }

    public final void o0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.a0.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (App app : list) {
                d.a.q0.h3.h0.o oVar = new d.a.q0.h3.h0.o();
                oVar.J0 = l0();
                oVar.H0(app);
                if (!this.a0.contains(oVar)) {
                    this.a0.add(oVar);
                }
            }
        }
    }

    public ForumRuleStatus p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.g0 : (ForumRuleStatus) invokeV.objValue;
    }

    public void p0(DataRes dataRes, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048639, this, dataRes, context) == null) || dataRes == null) {
            return;
        }
        try {
            d.a.q0.w2.g0.a.e().h(dataRes.asp_shown_info);
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
            v0(dataRes.is_new_url.intValue());
            this.n.parserProtobuf(dataRes.forum);
            this.o.e(dataRes.display_forum);
            this.p.l4(this.r);
            this.p.K2(dataRes.thread);
            if (this.p.R() == 0) {
                this.p.o3(dataRes.forum.id.longValue());
            }
            if (this.p.H() != null && this.p.H().getBusinessAccountData() == null) {
                this.p.H().setBusinessAccountData(this.h0);
            }
            this.x.a(dataRes.news_info);
            int i3 = this.x.f53284c;
            if (i3 == 1) {
                this.y.C0 = this.x;
            } else if (i3 == 2) {
                this.y.D0 = this.x;
            } else if (i3 != 3) {
                this.y.D0 = this.x;
            } else {
                this.y.E0 = this.x;
            }
            this.A.D0(dataRes.recommend_book);
            a0(dataRes, context);
            PostData postData = new PostData();
            this.U = postData;
            postData.i0(1);
            this.U.y0(this.r);
            this.U.j0(this.n.isBrandForum);
            this.U.w0(this.p.N());
            if (dataRes.first_floor_post != null) {
                this.U.b0(dataRes.first_floor_post, context);
            }
            if (this.p != null && this.p.v1) {
                this.U.q0(this.p.u1);
            }
            if (this.W == null) {
                this.W = this.U;
                this.V = true;
            }
            this.s.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.p0 = true;
            }
            this.t.parserProtobuf(dataRes.anti);
            this.u.c(dataRes.location);
            if (dataRes.user != null) {
                this.v = dataRes.user.is_manager.intValue();
            }
            this.f57437a.parserProtobuf(dataRes.user);
            if (dataRes.user != null && dataRes.user.mute_user != null) {
                for (SimpleUser simpleUser : dataRes.user.mute_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.z.add(muteUser);
                    }
                }
            }
            this.p.U3(this.p.Q0() > 0 ? this.p.Q0() - 1 : 0);
            List<AdvertAppInfo> h2 = d.a.q0.w2.w.o().h();
            if (h2 != null) {
                h2.clear();
            }
            String str = null;
            this.E = null;
            this.j0 = false;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                n0(dataRes);
                for (App app : list2) {
                    d.a.q0.h3.h0.o oVar = new d.a.q0.h3.h0.o();
                    oVar.J0 = l0();
                    App c2 = d.a.q0.w2.w.o().c(app, l0() ? Cmatch.VIDEO_PB_COMMENT : Cmatch.PB_COMMENT);
                    if (c2 != null && !this.j0 && !d.a.q0.w2.a.j(c2, dataRes.banner_list)) {
                        oVar.L0 = true;
                        this.j0 = true;
                        app = c2;
                    }
                    oVar.H0(app);
                    if (!this.D.contains(oVar)) {
                        this.D.add(oVar);
                        if (h2 != null) {
                            h2.add(oVar.getAdvertAppInfo());
                        }
                    }
                }
                o0(dataRes);
            }
            d.a.q0.w2.w.o().g();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.f57437a.getIsSelectTail());
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
                this.f57439c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            b0(dataRes);
            if (ListUtils.getCount(dataRes.repost_recommend_forum_list) > 0) {
                if (this.G == null) {
                    this.G = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                    x1 x1Var = new x1();
                    x1Var.e(simpleForum);
                    this.G.add(x1Var);
                }
            }
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.H == null) {
                    this.H = new ArrayList();
                }
                for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                    if (simpleForum2 != null) {
                        x1 x1Var2 = new x1();
                        x1Var2.e(simpleForum2);
                        this.H.add(x1Var2);
                    }
                }
            }
            this.O = dataRes.multi_forum_text;
            if (this.L >= 0) {
                this.L = dataRes.thread_freq_num.longValue();
            }
            Z(dataRes);
            if (this.R == null) {
                this.R = new ArrayList();
            }
            this.R.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !j0(threadInfo) && !d0(threadInfo)) {
                        d.a.p0.s.q.q qVar = new d.a.p0.s.q.q();
                        qVar.y4(i4);
                        qVar.K2(threadInfo);
                        this.R.add(qVar);
                        i4++;
                    }
                }
            }
            if (this.T != null && this.T.o()) {
                this.T = null;
            }
            if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                if (this.T == null) {
                    d.a.q0.h2.o.i.a aVar = new d.a.q0.h2.o.i.a();
                    this.T = aVar;
                    aVar.p(dataRes.recom_ala_info);
                }
            } else if (this.T == null && dataRes.promotion != null) {
                d.a.q0.h2.o.i.a aVar2 = new d.a.q0.h2.o.i.a();
                this.T = aVar2;
                aVar2.q(dataRes.promotion);
            }
            if (dataRes.business_promot_info != null) {
                this.f57445i = dataRes.business_promot_info.is_promot.longValue() == 1;
                this.j = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                this.k = dataRes.business_promot_info.is_s_card.intValue() == 1;
                if (dataRes.business_promot_info.send_card_info != null) {
                    b bVar = new b();
                    bVar.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new a();
                    }
                    this.l.b(bVar);
                }
            }
            this.b0.c();
            this.b0.d(this.r);
            this.b0.b(dataRes.recom_ala_info);
            if (this.b0.s != null) {
                this.b0.s.n(P());
            }
            a0 a0Var = new a0();
            this.c0 = a0Var;
            a0Var.c(this.r);
            this.c0.b(dataRes.recom_ala_info);
            if (this.c0.q != null) {
                this.c0.q.n(P());
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
            this.l0 = dataRes.is_official_forum.intValue() == 1;
            this.m0 = dataRes.is_purchase.intValue() == 1;
            this.n0 = dataRes.floating_icon;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public List<x1> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.H : (List) invokeV.objValue;
    }

    public void q0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            this.S = i2;
        }
    }

    public CardHListViewData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.f57439c : (CardHListViewData) invokeV.objValue;
    }

    public void r0(x1 x1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, x1Var) == null) {
            this.o = x1Var;
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.p.i0() != 0 : invokeV.booleanValue;
    }

    public void s0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, postData) == null) {
            this.U = postData;
            this.W = postData;
            this.V = false;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.w : invokeV.intValue;
    }

    public void t0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, postData) == null) {
            this.W = postData;
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            b2 b2Var = this.p;
            if (b2Var != null) {
                return b2Var.z0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void u0(boolean z) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048649, this, z) == null) || (b2Var = this.p) == null) {
            return;
        }
        if (z) {
            b2Var.C3(1);
        } else {
            b2Var.C3(0);
        }
    }

    public List<MuteUser> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.z : (List) invokeV.objValue;
    }

    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            this.w = i2;
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.O : (String) invokeV.objValue;
    }

    public void w0(String str) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048653, this, str) == null) || (b2Var = this.p) == null) {
            return;
        }
        b2Var.M3(str);
    }

    public a1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.s : (a1) invokeV.objValue;
    }

    public void x0(a1 a1Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048655, this, a1Var, i2) == null) {
            this.s.k(a1Var.a());
            this.s.p(a1Var.g());
            this.s.q(a1Var.h());
            this.s.o(a1Var.e());
            this.s.n(a1Var.d());
            if (i2 == 0) {
                this.s = a1Var;
            } else if (i2 == 1) {
                this.s.l(a1Var.b());
            } else if (i2 == 2) {
                this.s.m(a1Var.c());
            }
        }
    }

    public d.a.q0.h3.h0.o y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.E : (d.a.q0.h3.h0.o) invokeV.objValue;
    }

    public void y0(d.a.q0.h3.h0.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, oVar) == null) {
            this.E = oVar;
        }
    }

    public i z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.K : (i) invokeV.objValue;
    }

    public void z0(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, pVar) == null) {
            this.M = pVar;
        }
    }
}
