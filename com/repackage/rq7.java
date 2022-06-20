package com.repackage;

import androidx.annotation.NonNull;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.BusinessAccountData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import tbclient.PbPage.FloatingIconItem;
import tbclient.PbPage.PbFollowTip;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class rq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ju7 A;
    public List<MuteUser> B;
    public dp4 C;
    public List<ThreadData> D;
    public AlaLiveInfoCoreData E;
    public ArrayList<sh8> F;
    public sh8 G;
    public TwzhiboAnti H;
    public List<xp4> I;
    public List<xp4> J;
    public kr7 K;
    public PostData L;
    public vq7 M;
    public long N;
    public fr7 O;
    public String P;
    public String Q;
    public List<RecommendTopicData.RecommendTopicListData> R;
    public HashSet<String> S;
    public List<pn4> T;
    public int U;
    public ny7 V;
    public PostData W;
    public boolean X;
    public PostData Y;
    public int Z;
    public final UserData a;
    public boolean a0;
    public String b;
    public int b0;
    public CardHListViewData c;
    public List<sh8> c0;
    public int d;
    public xt7 d0;
    public int e;
    public zt7 e0;
    public List<PbSortType> f;
    public String f0;
    public int g;
    public String g0;
    public ar7 h;
    public List<ThreadInfo> h0;
    public boolean i;
    public ForumRuleStatus i0;
    public boolean j;
    public BusinessAccountData j0;
    public boolean k;
    public boolean k0;
    public mq7 l;
    public int l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public boolean n0;
    public xp4 o;
    public boolean o0;
    public ThreadData p;
    public xv4 p0;
    public ArrayList<PostData> q;
    public int q0;
    public HashMap<String, MetaData> r;
    public List<nn> r0;
    public zo4 s;
    public boolean s0;
    public AntiData t;
    public mz4 u;
    public int v;
    public int w;
    public int x;
    public String y;
    public cp4 z;

    public rq7() {
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
        this.i = false;
        this.j = false;
        this.k = false;
        this.m = false;
        this.w = 0;
        this.F = new ArrayList<>();
        this.G = null;
        this.H = null;
        this.U = 0;
        this.X = true;
        this.Z = 0;
        this.b0 = 0;
        this.c0 = new ArrayList();
        this.l0 = 0;
        this.q0 = 0;
        this.s0 = false;
        this.n = new ForumData();
        this.o = new xp4();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.r = new HashMap<>();
        this.s = new zo4();
        this.t = new AntiData();
        this.u = new mz4();
        this.v = 0;
        this.w = 0;
        this.a = new UserData();
        this.B = new ArrayList();
        this.z = new cp4();
        this.C = new dp4();
        this.A = new ju7();
        this.H = new TwzhiboAnti();
        this.K = new kr7();
        this.d0 = new xt7();
        this.R = new ArrayList();
        this.S = new HashSet<>();
        this.p0 = new xv4();
    }

    public vq7 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.M : (vq7) invokeV.objValue;
    }

    public void A0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) {
            this.W = postData;
            this.Y = postData;
            this.X = false;
        }
    }

    public xt7 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            xt7 xt7Var = this.d0;
            if (xt7Var == null || !xt7Var.isValid()) {
                return null;
            }
            return this.d0;
        }
        return (xt7) invokeV.objValue;
    }

    public void B0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, postData) == null) {
            this.Y = postData;
        }
    }

    public zt7 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            zt7 zt7Var = this.e0;
            if (zt7Var == null || !zt7Var.isValid()) {
                return null;
            }
            return this.e0;
        }
        return (zt7) invokeV.objValue;
    }

    public void C0(boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (threadData = this.p) == null) {
            return;
        }
        if (z) {
            threadData.setIsMarked(1);
        } else {
            threadData.setIsMarked(0);
        }
    }

    public ju7 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : (ju7) invokeV.objValue;
    }

    public void D0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.w = i;
        }
    }

    public dp4 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : (dp4) invokeV.objValue;
    }

    public void E0(String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (threadData = this.p) == null) {
            return;
        }
        threadData.setMarkID(str);
    }

    public ArrayList<PostData> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public void F0(zo4 zo4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, zo4Var, i) == null) {
            this.s.k(zo4Var.a());
            this.s.p(zo4Var.g());
            this.s.q(zo4Var.h());
            this.s.o(zo4Var.e());
            this.s.n(zo4Var.d());
            if (i == 0) {
                this.s = zo4Var;
            } else if (i == 1) {
                this.s.l(zo4Var.b());
            } else if (i == 2) {
                this.s.m(zo4Var.c());
            }
        }
    }

    public ny7 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.V : (ny7) invokeV.objValue;
    }

    public void G0(sh8 sh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, sh8Var) == null) {
            this.G = sh8Var;
        }
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.l0 : invokeV.intValue;
    }

    public void H0(fr7 fr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fr7Var) == null) {
            this.O = fr7Var;
        }
    }

    public List<ThreadInfo> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.h0 : (List) invokeV.objValue;
    }

    public void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.l0 = i;
        }
    }

    public AlaLiveInfoCoreData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.E : (AlaLiveInfoCoreData) invokeV.objValue;
    }

    public void J0(int i) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (antiData = this.t) == null) {
            return;
        }
        antiData.replyPrivateFlag = i;
    }

    public List<ThreadData> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.D : (List) invokeV.objValue;
    }

    public void K0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, threadData) == null) {
            this.p = threadData;
        }
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AntiData antiData = this.t;
            if (antiData != null) {
                return antiData.replyPrivateFlag;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public void L0(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            this.r0 = list;
        }
    }

    public String[] M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? N(true) : (String[]) invokeV.objValue;
    }

    public PostData M0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, postData)) == null) {
            this.L = postData;
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public String[] N(boolean z) {
        InterceptResult invokeZ;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
            String str = "";
            if (q0()) {
                int size = this.q.size() <= 30 ? this.q.size() : 30;
                if (O() != null && O().getAuthor() != null && !oi.isEmpty(O().getAuthor().getUserId())) {
                    String userId = O().getAuthor().getUserId();
                    PostData i = i();
                    if (i != null && i.s() != null && !oi.isEmpty(i.s().getUserId())) {
                        r2 = StringHelper.equals(userId, i.s().getUserId()) ? i.A() : null;
                        if (oi.isEmpty("")) {
                            str = i.W();
                        }
                    }
                    if (oi.isEmpty(str) && oi.isEmpty(r2)) {
                        for (int i2 = 0; i2 < size; i2++) {
                            PostData postData = (PostData) ListUtils.getItem(this.q, i2);
                            if (postData != null && postData.s() != null && !oi.isEmpty(postData.s().getUserId()) && StringHelper.equals(userId, postData.s().getUserId())) {
                                if (oi.isEmpty(r2)) {
                                    r2 = postData.A();
                                }
                                if (oi.isEmpty(str)) {
                                    str = postData.W();
                                }
                                if (!oi.isEmpty(r2) && !oi.isEmpty(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && oi.isEmpty(r2)) {
                        r2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e66) + "] " + str;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !oi.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
                        r2 = this.p.getThreadVideoInfo().thumbnail_url;
                    }
                    ThreadData threadData3 = this.p;
                    if (threadData3 != null && !threadData3.isShareThread && r2 == null && (originalThreadInfo = threadData3.originalThreadData) != null && (arrayList = originalThreadInfo.h) != null) {
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
        return (String[]) invokeZ.objValue;
    }

    public void N0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.b = str;
        }
    }

    public ThreadData O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : (ThreadData) invokeV.objValue;
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.N : invokeV.longValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ThreadData threadData = this.p;
            return threadData != null ? threadData.getId() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<nn> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.r0 : (List) invokeV.objValue;
    }

    public fr7 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.O : (fr7) invokeV.objValue;
    }

    public kr7 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.K : (kr7) invokeV.objValue;
    }

    public UserData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.a : (UserData) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.v : invokeV.intValue;
    }

    public PostData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.L : (PostData) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public List<sh8> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.c0 : (List) invokeV.objValue;
    }

    public xv4 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.p0 : (xv4) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.d0 = null;
            this.e0 = null;
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            zo4 zo4Var = this.s;
            return zo4Var != null && zo4Var.b() == 1;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (this.G.getAdvertAppInfo() != null) {
                this.G.getAdvertAppInfo().h = null;
            }
            this.G = null;
        }
    }

    public final void b0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, dataRes) == null) {
            this.O = new fr7(this.p, this.t);
            String str = dataRes.partial_visible_toast;
            PbFollowTip pbFollowTip = dataRes.follow_tip;
            if (pbFollowTip != null && pbFollowTip.is_toast_tip.intValue() == 1) {
                String str2 = dataRes.follow_tip.tip_text;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            this.E = alaLiveInfoCoreData;
            AlaLiveInfo alaLiveInfo = dataRes.ala_info;
            if (alaLiveInfo != null) {
                alaLiveInfoCoreData.parserProtoBuf(alaLiveInfo);
            }
            this.P = dataRes.fold_tip;
            this.d = dataRes.exp_news_today.intValue();
            this.e = dataRes.exp_guide_today.intValue();
            if (!ListUtils.isEmpty(dataRes.thread_topic)) {
                for (int i = 0; i < dataRes.thread_topic.size(); i++) {
                    RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(dataRes.thread_topic.get(i));
                    this.R.add(recommendTopicListData);
                }
            }
            this.f = dataRes.pb_sort_info;
            this.g = dataRes.sort_type.intValue();
            ManagerElection managerElection = dataRes.manager_election;
            if (managerElection != null) {
                this.h = ar7.i(managerElection);
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            List<PbSortType> list = this.f;
            if (list == null || list.size() <= this.g) {
                return "";
            }
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i).sort_type.intValue() == this.g) {
                    return this.f.get(i).sort_name;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void c0(DataRes dataRes) {
        List<Post> list;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, dataRes) == null) || (list = dataRes.post_list) == null || list.size() <= 0) {
            return;
        }
        for (Post post : dataRes.post_list) {
            if (!this.S.contains(String.valueOf(post.id))) {
                PostData postData = new PostData();
                postData.I0(this.r);
                postData.t0(this.n.isBrandForum);
                postData.l0(post, O());
                postData.C0(O().getPraise());
                postData.r0(dataRes.forum.id.longValue());
                postData.s0(dataRes.forum.name);
                if (postData.q() != null && postData.q().baijiahaoData == null && O() != null && O().getBaijiahaoData() != null) {
                    postData.q().baijiahaoData = O().getBaijiahaoData();
                }
                this.S.add(postData.J());
                if (postData.B() == 1 && this.p.isActInfo()) {
                    if (m0()) {
                        postData.B0(0);
                    } else {
                        postData.B0(this.p.getActInfoType());
                    }
                } else if (postData.B() == 1 && this.p.isInterviewLive()) {
                    postData.B0(41);
                } else if (postData.B() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                    postData.B0(0);
                    postData.b0();
                    if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                        postData.D0(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", 0);
                            jSONObject.put("text", "");
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        postData.D0(TbRichTextView.U(jSONArray, false));
                    }
                    this.L = postData;
                }
                if (postData.B() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                    postData.A0(threadData2.originalThreadData);
                }
                if (postData.B() == 1) {
                    this.Y = postData;
                    this.X = false;
                    if (postData.s() != null && this.j0 != null) {
                        postData.s().setBusinessAccountData(this.j0);
                    }
                }
                this.q.add(postData);
            }
        }
    }

    public AntiData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.t : (AntiData) invokeV.objValue;
    }

    public final void d0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, dataRes) == null) || (list = dataRes.feed_thread_list) == null || list.size() <= 0) {
            return;
        }
        List<ThreadInfo> list2 = dataRes.feed_thread_list;
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.clear();
        for (ThreadInfo threadInfo : list2) {
            if (threadInfo != null) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                this.D.add(threadData);
            }
        }
        List<ThreadData> list3 = this.D;
        if (list3 == null || list3.size() <= 15) {
            return;
        }
        this.D = ListUtils.subList(this.D, 0, 15);
    }

    public ArrayList<sh8> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.F : (ArrayList) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.s0 : invokeV.booleanValue;
    }

    public List<pn4> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.T : (List) invokeV.objValue;
    }

    public final boolean f0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (threadData = this.p) == null || threadData.getBaijiahaoData() == null || this.p.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.getBaijiahaoData().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.U : invokeV.intValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? O() != null && O().isUgcThreadType() : invokeV.booleanValue;
    }

    public xp4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.o : (xp4) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.k0 : invokeV.booleanValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.Y : (PostData) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PostData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.W : (PostData) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? O() != null && O().isNovelThread() : invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.m0 : invokeV.booleanValue;
    }

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.n : (ForumData) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.o0 : invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getId() : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            ThreadData threadData = this.p;
            return (threadData == null || threadData.getActDatas() == null || this.p.getActDatas().size() <= 0 || this.p.getActDatas().get(0) == null || !this.p.getActDatas().get(0).d()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getName() : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.n0 : invokeV.booleanValue;
    }

    public ForumRuleStatus o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.i0 : (ForumRuleStatus) invokeV.objValue;
    }

    public boolean o0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048645, this, z)) == null) ? (this.x == 2 && z) || this.x == 1 : invokeZ.booleanValue;
    }

    public List<xp4> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.J : (List) invokeV.objValue;
    }

    public final boolean p0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, threadInfo)) == null) {
            if (threadInfo == null || Q() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
                return false;
            }
            return Q().equals(threadInfo.id) || Q().equals(threadInfo.tid);
        }
        return invokeL.booleanValue;
    }

    public CardHListViewData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.c : (CardHListViewData) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            ArrayList<PostData> arrayList = this.q;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.p.getIsMarked() != 0 : invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? (O() == null || !O().isVideoThreadType() || O().getThreadVideoInfo() == null) ? false : true : invokeV.booleanValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.w : invokeV.intValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? (O() == null || O().worksInfoData == null || !O().worksInfoData.isWorks) ? false : true : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.q0 == 1 : invokeV.booleanValue;
    }

    public final void t0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, dataRes) == null) {
            this.x = dataRes.pb_notice_type.intValue();
            this.y = dataRes.pb_notice;
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getMarkID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void u0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, dataRes) == null) {
            sh8 sh8Var = new sh8();
            sh8Var.H0 = true;
            sh8Var.S0(dataRes.banner_list.pb_banner_ad);
            this.G = sh8Var;
        }
    }

    public List<MuteUser> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.B : (List) invokeV.objValue;
    }

    public final void v0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.c0.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (App app : list) {
                sh8 sh8Var = new sh8();
                sh8Var.N0 = r0();
                sh8Var.S0(app);
                if (!this.c0.contains(sh8Var)) {
                    this.c0.add(sh8Var);
                }
            }
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    public void w0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, floatingIcon) == null) || floatingIcon == null || (floatingIconItem = floatingIcon.pbpage) == null) {
            return;
        }
        xv4 xv4Var = this.p0;
        xv4Var.b = floatingIconItem.icon_url;
        xv4Var.c = floatingIconItem.fold_lottie;
        xv4Var.d = floatingIconItem.unfold_lottie;
        xv4Var.e = floatingIconItem.float_type;
        xv4Var.f = floatingIconItem.fold_name;
        xv4Var.g = floatingIconItem.unfold_name;
        xv4Var.a = floatingIconItem.url;
        xv4Var.j = floatingIconItem.scheme;
        xv4Var.k = floatingIconItem.package_name;
        xv4Var.l = floatingIconItem.deeplink;
        xv4Var.h = floatingIconItem.view_statistics_url;
        xv4Var.i = floatingIconItem.click_statistics_url;
        xv4Var.r = floatingIconItem.display_ad_icon;
    }

    @NonNull
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public void x0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048663, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            fa8.e().h(dataRes.asp_shown_info);
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
                        this.j0 = metaData.getBusinessAccountData();
                    }
                }
            }
            D0(dataRes.is_new_url.intValue());
            t0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.j(dataRes.display_forum);
            this.p.setUserMap(this.r);
            this.p.parserProtobuf(dataRes.thread);
            if (this.p.getFid() == 0) {
                this.p.setFid(dataRes.forum.id.longValue());
            }
            if (this.p.getAuthor() != null && this.p.getAuthor().getBusinessAccountData() == null) {
                this.p.getAuthor().setBusinessAccountData(this.j0);
            }
            this.z.a(dataRes.news_info);
            int i2 = this.z.c;
            if (i2 == 1) {
                this.A.G0 = this.z;
            } else if (i2 == 2) {
                this.A.H0 = this.z;
            } else if (i2 != 3) {
                this.A.H0 = this.z;
            } else {
                this.A.I0 = this.z;
            }
            this.C.O0(dataRes.recommend_book);
            c0(dataRes);
            PostData postData = new PostData();
            this.W = postData;
            postData.q0(1);
            this.W.I0(this.r);
            this.W.t0(this.n.isBrandForum);
            this.W.G0(this.p.getCreateTime());
            this.W.r0(dataRes.forum.id.longValue());
            this.W.s0(dataRes.forum.name);
            if (dataRes.first_floor_post != null) {
                this.W.k0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.isShareThread) {
                this.W.A0(this.p.originalThreadData);
            }
            if (this.Y == null) {
                this.Y = this.W;
                this.X = true;
            }
            this.s.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.s0 = true;
            }
            this.t.parserProtobuf(dataRes.anti);
            this.u.c(dataRes.location);
            if (dataRes.user != null) {
                this.v = dataRes.user.is_manager.intValue();
            }
            this.a.parserProtobuf(dataRes.user);
            if (dataRes.user != null && dataRes.user.mute_user != null) {
                for (SimpleUser simpleUser : dataRes.user.mute_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.B.add(muteUser);
                    }
                }
            }
            this.p.setReply_num(this.p.getReply_num() > 0 ? this.p.getReply_num() - 1 : 0);
            List<AdvertAppInfo> f = x88.l().f();
            if (f != null) {
                f.clear();
            }
            String str = null;
            this.G = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                u0(dataRes);
                for (App app : list2) {
                    sh8 sh8Var = new sh8();
                    sh8Var.N0 = r0();
                    sh8Var.S0(app);
                    if (!this.F.contains(sh8Var)) {
                        this.F.add(sh8Var);
                        if (f != null) {
                            f.add(sh8Var.getAdvertAppInfo());
                        }
                    }
                }
                v0(dataRes);
            }
            x88.l().e();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.H.parserProtobuf(dataRes.twzhibo_anti);
            AppealInfo appealInfo = dataRes.appeal_info;
            if (dataRes.forum_headline_img_info != null) {
                vq7 vq7Var = new vq7();
                this.M = vq7Var;
                vq7Var.c(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            d0(dataRes);
            if (ListUtils.getCount(dataRes.repost_recommend_forum_list) > 0) {
                if (this.I == null) {
                    this.I = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                    xp4 xp4Var = new xp4();
                    xp4Var.j(simpleForum);
                    this.I.add(xp4Var);
                }
            }
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                    if (simpleForum2 != null) {
                        xp4 xp4Var2 = new xp4();
                        xp4Var2.j(simpleForum2);
                        this.J.add(xp4Var2);
                    }
                }
            }
            this.Q = dataRes.multi_forum_text;
            if (this.N >= 0) {
                this.N = dataRes.thread_freq_num.longValue();
            }
            b0(dataRes);
            if (this.T == null) {
                this.T = new ArrayList();
            }
            this.T.clear();
            if (dataRes.bjh_recommend != null) {
                int i3 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !p0(threadInfo) && !f0(threadInfo)) {
                        pn4 pn4Var = new pn4();
                        pn4Var.l(i3);
                        pn4Var.parserProtobuf(threadInfo);
                        this.T.add(pn4Var);
                        i3++;
                    }
                }
            }
            if (this.V != null && this.V.n()) {
                this.V = null;
            }
            if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                if (this.V == null) {
                    ny7 ny7Var = new ny7();
                    this.V = ny7Var;
                    ny7Var.r(dataRes.recom_ala_info);
                }
            } else if (this.V == null && dataRes.promotion != null) {
                ny7 ny7Var2 = new ny7();
                this.V = ny7Var2;
                ny7Var2.s(dataRes.promotion);
            }
            if (dataRes.business_promot_info != null) {
                this.i = dataRes.business_promot_info.is_promot.longValue() == 1;
                this.j = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                this.k = dataRes.business_promot_info.is_s_card.intValue() == 1;
                if (dataRes.business_promot_info.send_card_info != null) {
                    nq7 nq7Var = new nq7();
                    nq7Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new mq7();
                    }
                    this.l.a(nq7Var);
                }
            }
            this.d0.b();
            this.d0.c(this.r);
            this.d0.a(dataRes.recom_ala_info);
            if (this.d0.o != null) {
                this.d0.o.o(Q());
            }
            zt7 zt7Var = new zt7();
            this.e0 = zt7Var;
            zt7Var.b(this.r);
            this.e0.a(dataRes.recom_ala_info);
            if (this.e0.m != null) {
                this.e0.m.o(Q());
            }
            if (ListUtils.getCount(dataRes.recom_thread_info) > 0) {
                this.h0 = dataRes.recom_thread_info;
            }
            if (dataRes.jumptotab1 != null) {
                str = dataRes.jumptotab1.toString();
            }
            this.f0 = str;
            this.g0 = dataRes.jumptotab2;
            if (dataRes.forum_rule != null) {
                this.i0 = dataRes.forum_rule;
            }
            this.k0 = dataRes.is_black_white.intValue() == 1;
            this.m0 = dataRes.is_official_forum.intValue() == 1;
            this.n0 = dataRes.show_adsense.intValue() == 1;
            this.o0 = dataRes.is_purchase.intValue() == 1;
            FloatingIcon floatingIcon = dataRes.floating_icon;
            w0(dataRes.floating_icon);
            this.q0 = dataRes.has_fold_comment.intValue();
            dataRes.fold_comment_num.longValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public zo4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.s : (zo4) invokeV.objValue;
    }

    public void y0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i) == null) {
            this.U = i;
        }
    }

    public sh8 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.G : (sh8) invokeV.objValue;
    }

    public void z0(xp4 xp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, xp4Var) == null) {
            this.o = xp4Var;
        }
    }
}
