package d.a.o0.r.q;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.AnchorInfoData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.PushStatusData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.switchs.ConveneThreadOpenSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
import com.bumptech.glide.load.engine.GlideException;
import d.a.p0.a0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.DislikeInfo;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.LiveCoverStatus;
import tbclient.Media;
import tbclient.NoticeInfo;
import tbclient.PbContent;
import tbclient.PbGoodsInfo;
import tbclient.PbLinkInfo;
import tbclient.ReportInfo;
import tbclient.SkinInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.ThreadRecommendInfo;
import tbclient.TopicModule;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes7.dex */
public class b2 extends a implements PreLoadImageProvider, d.a.c.k.e.n, IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean A3;
    public static AtomicBoolean B3;
    public static AtomicBoolean C3;
    public static final BdUniqueId D3;
    public static final BdUniqueId E3;
    public static HashMap<Point, Integer> F3;
    public static HashMap<Integer, Integer> G3;
    public static final BdUniqueId H3;
    public static final BdUniqueId I3;
    public static HashMap<Point, Integer> J3;
    public static SparseArray<m.a> K3;
    public static final BdUniqueId N2;
    public static final BdUniqueId O2;
    public static final BdUniqueId P2;
    public static final BdUniqueId Q2;
    public static final BdUniqueId R2;
    public static final BdUniqueId S2;
    public static final BdUniqueId T2;
    public static final BdUniqueId U2;
    public static final BdUniqueId V2;
    public static final BdUniqueId W2;
    public static final BdUniqueId X2;
    public static final BdUniqueId Y2;
    public static final BdUniqueId Z2;
    public static final BdUniqueId a3;
    public static final BdUniqueId b3;
    public static final BdUniqueId c3;
    public static final BdUniqueId d3;
    public static final BdUniqueId e3;
    public static final BdUniqueId f3;
    public static final BdUniqueId g3;
    public static final BdUniqueId h3;
    public static final BdUniqueId i3;
    public static final BdUniqueId j3;
    public static final BdUniqueId k3;
    public static final BdUniqueId l3;
    public static final BdUniqueId m3;
    public static final BdUniqueId n3;
    public static final BdUniqueId o3;
    public static final BdUniqueId p3;
    public static final BdUniqueId q3;
    public static final BdUniqueId r3;
    public static final BdUniqueId s3;
    public static final BdUniqueId t3;
    public static final BdUniqueId u3;
    public static final BdUniqueId v3;
    public static final BdUniqueId w3;
    public static final BdUniqueId x3;
    public static final BdUniqueId y3;
    public static final BdUniqueId z3;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int A0;
    public String A1;
    public String A2;
    public long B;
    public boolean B0;
    public String B1;
    public String B2;
    public x1 C;
    public ArrayList<b> C0;
    public VideoInfo C1;
    public String C2;
    public String D;
    public o2 D0;
    public boolean D1;
    public boolean D2;
    public String E;
    public i E0;
    public boolean E1;
    public boolean E2;
    public String F;
    public u F0;
    public OriginalForumInfo F1;
    public int F2;
    public int G;
    public String G0;
    public boolean G1;
    public d.a.p0.h3.h0.n G2;
    public int H;
    public int H0;
    public boolean H1;
    public int H2;
    public long I;
    public z1 I0;
    public SmartApp I1;
    public WorksInfoData I2;
    public int J;
    public ArrayList<d.a.o0.t.c> J0;
    public boolean J1;
    public int J2;
    public int K;
    public PushStatusData K0;
    public String K1;
    public List<ThreadRecommendInfoData> K2;
    public int L;
    public String L0;
    public String L1;
    public String L2;
    public int M;
    public String M0;
    public String M1;
    public int M2;
    public f2 N;
    public SkinInfo N0;
    public String N1;
    public String O;
    public boolean O0;
    public String O1;
    public MetaData P;
    public String P0;
    public int P1;
    public String Q;
    public int Q0;
    public String Q1;
    public int R;
    public r R0;
    public String R1;
    public String S;
    public boolean S0;
    public boolean S1;
    public ArrayList<MediaData> T;
    public String T0;
    public boolean T1;
    public ArrayList<VoiceData$VoiceModel> U;
    public String U0;
    public boolean U1;
    public int V;
    public String V0;
    public boolean V1;
    public int W;
    public String W0;
    public boolean W1;
    public String X;
    public String X0;
    public boolean X1;
    public int Y;
    public String Y0;
    public boolean Y1;
    public int Z;
    public long Z0;
    public boolean Z1;
    public PraiseData a0;
    public boolean a1;
    public boolean a2;
    public AnchorInfoData b0;
    public boolean b1;
    public boolean b2;
    public String c0;
    public int c1;
    public boolean c2;
    public boolean d1;
    public boolean d2;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52586e;
    public boolean e1;
    public String e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52587f;
    public int f1;
    public boolean f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52588g;
    public SparseArray<String> g1;
    public String g2;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52589h;
    public SparseArray<String> h1;
    public boolean h2;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52590i;
    public HashMap<String, MetaData> i0;
    public String i1;
    public String i2;
    public boolean j;
    public String j0;
    public boolean j1;
    public String j2;
    public boolean k;
    public String k0;
    public AgreeData k1;
    public int k2;
    public boolean l;
    public String l0;
    public PostData l1;
    public BaijiahaoData l2;
    public boolean m;
    public int m0;
    public long m1;
    public boolean m2;
    public int n;
    public int n0;
    public q0 n1;
    public String n2;
    public String o;
    public ArrayList<d.a.o0.s.i.c> o0;
    public boolean o1;
    public int o2;
    public int p;
    public VideoInfo p0;
    public boolean p1;
    public String p2;
    public int q;
    public VideoDesc q0;
    public h q1;
    public ThreadInfo q2;
    public String r;
    public i2 r0;
    public MediaData r1;
    public List<PbLinkData> r2;
    public String s;
    public AlaInfoData s0;
    public int s1;
    public List<PbGoodsData> s2;
    public List<PbContent> t;
    public int t0;
    public int t1;
    public boolean t2;
    public List<PbContent> u;
    public int u0;
    public OriginalThreadInfo u1;
    public Item u2;
    public List<PbContent> v;
    public long v0;
    public boolean v1;
    public ItemData v2;
    public SpannableStringBuilder w;
    public long w0;
    public String w1;
    public List<HeadItem> w2;
    public SpannableStringBuilder x;
    public String x0;
    public String x1;
    public ItemStarData x2;
    public SpannableString y;
    public int y0;
    public int y1;
    public PollData y2;
    public String z;
    public String z0;
    public TopicModule z1;
    public int z2;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1574015289, "Ld/a/o0/r/q/b2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1574015289, "Ld/a/o0/r/q/b2;");
                return;
            }
        }
        N2 = BdUniqueId.gen();
        O2 = BdUniqueId.gen();
        P2 = BdUniqueId.gen();
        Q2 = BdUniqueId.gen();
        R2 = BdUniqueId.gen();
        S2 = BdUniqueId.gen();
        T2 = BdUniqueId.gen();
        U2 = BdUniqueId.gen();
        V2 = BdUniqueId.gen();
        W2 = BdUniqueId.gen();
        X2 = BdUniqueId.gen();
        Y2 = BdUniqueId.gen();
        Z2 = BdUniqueId.gen();
        a3 = BdUniqueId.gen();
        b3 = BdUniqueId.gen();
        c3 = BdUniqueId.gen();
        d3 = BdUniqueId.gen();
        e3 = BdUniqueId.gen();
        f3 = BdUniqueId.gen();
        g3 = BdUniqueId.gen();
        h3 = BdUniqueId.gen();
        i3 = BdUniqueId.gen();
        j3 = BdUniqueId.gen();
        k3 = BdUniqueId.gen();
        l3 = BdUniqueId.gen();
        m3 = BdUniqueId.gen();
        n3 = BdUniqueId.gen();
        o3 = BdUniqueId.gen();
        p3 = BdUniqueId.gen();
        q3 = BdUniqueId.gen();
        r3 = BdUniqueId.gen();
        s3 = BdUniqueId.gen();
        t3 = BdUniqueId.gen();
        u3 = BdUniqueId.gen();
        v3 = BdUniqueId.gen();
        w3 = BdUniqueId.gen();
        x3 = BdUniqueId.gen();
        y3 = BdUniqueId.gen();
        z3 = BdUniqueId.gen();
        A3 = new AtomicBoolean(false);
        B3 = new AtomicBoolean(false);
        C3 = new AtomicBoolean(false);
        D3 = BdUniqueId.gen();
        E3 = BdUniqueId.gen();
        F3 = new HashMap<>();
        G3 = new HashMap<>();
        H3 = BdUniqueId.gen();
        I3 = BdUniqueId.gen();
        J3 = new HashMap<>();
        K3 = new SparseArray<>(3);
        F3.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        F3.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        F3.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        F3.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        F3.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        F3.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        F3.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        F3.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        J3.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        J3.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        J3.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        J3.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        J3.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        J3.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        J3.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        J3.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        G3.put(1, Integer.valueOf(R.drawable.label_interview_no));
        G3.put(2, Integer.valueOf(R.drawable.label_interview_live));
        G3.put(3, Integer.valueOf(R.drawable.label_interview_off));
        K3.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        K3.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        K3.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public b2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i4 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52586e = false;
        this.f52587f = false;
        this.f52588g = false;
        this.f52589h = false;
        this.f52590i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = 0;
        this.o = "1";
        this.p = 1;
        this.V = 0;
        this.X = null;
        this.n0 = 0;
        this.y0 = 0;
        this.z0 = "";
        this.B0 = false;
        this.G0 = "";
        this.a1 = true;
        this.e1 = false;
        this.f1 = -1;
        this.g1 = null;
        this.h1 = null;
        this.p1 = false;
        this.s1 = 0;
        this.y1 = 0;
        this.D1 = false;
        this.J1 = false;
        this.S1 = false;
        this.T1 = false;
        this.h2 = false;
        this.m2 = false;
        this.D2 = false;
        this.E2 = false;
        this.L2 = "";
        this.z = null;
        this.A = null;
        this.B = 0L;
        this.r = null;
        this.u0 = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0L;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = new f2();
        this.P = new MetaData();
        this.Q = null;
        this.T = new ArrayList<>();
        this.U = new ArrayList<>();
        this.R = 0;
        this.S = null;
        this.s = null;
        this.W = 0;
        this.a0 = new PraiseData();
        this.b0 = new AnchorInfoData();
        this.m0 = 0;
        this.C0 = new ArrayList<>();
        this.D0 = null;
        this.E0 = null;
        this.o0 = new ArrayList<>();
        this.A0 = 0;
        this.A0 = 0;
        this.H0 = 0;
        this.n0 = 0;
        this.t0 = 0;
        this.Q0 = 0;
        this.R0 = new r();
        this.v = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.F = null;
        this.I0 = new z1();
        this.J0 = new ArrayList<>();
        this.K0 = new PushStatusData();
        this.V = 0;
        this.b1 = false;
        this.c1 = -1;
        this.l1 = new PostData();
        this.k1 = new AgreeData();
        this.s1 = 0;
        this.t1 = 0;
        this.x0 = "";
        this.x1 = "";
        this.w1 = "";
        this.L0 = "";
        this.M0 = "";
        this.r2 = new ArrayList();
        this.s2 = new ArrayList();
        this.K2 = new ArrayList();
        this.z2 = -1;
    }

    public long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k1.agreeNum : invokeV.longValue;
    }

    public String A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.R1 : (String) invokeV.objValue;
    }

    public void A1(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, spannableString) == null) || H() == null || showNoName() || showWeakenName()) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.x;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.y);
        spannableStringBuilder2.insert(0, (CharSequence) spannableString);
        this.y = new SpannableString(spannableStringBuilder2);
    }

    public SpannableStringBuilder A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.o0.b1.m.e.x(this, this.t, this.r) : (SpannableStringBuilder) invokeV.objValue;
    }

    public void A3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.U1 = z;
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k1.agreeType : invokeV.intValue;
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n0 : invokeV.intValue;
    }

    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m0 == 1 : invokeV.booleanValue;
    }

    public void B2(ArrayList<v> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) || this.q == 1 || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<v> it = arrayList.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next != null && next.a() != null && !StringUtils.isNull(this.r)) {
                Iterator<String> it2 = next.a().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        String next2 = it2.next();
                        if (!StringUtils.isNull(next2) && this.r.contains(next2)) {
                            next.b();
                            break;
                        }
                    }
                }
            }
        }
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.y1 = 1;
        }
    }

    public AnchorInfoData C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b0 : (AnchorInfoData) invokeV.objValue;
    }

    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (H() == null || H().getAlaUserData() == null || H().getAlaUserData().live_status != 1) ? false : true : invokeV.booleanValue;
    }

    public SpannableStringBuilder C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (StringUtils.isNull(this.r) || this.q == 1) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(A2());
            this.w = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void C3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.L = i2;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.t0 : invokeV.intValue;
    }

    public PollData D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.y2 : (PollData) invokeV.objValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        String userId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            MetaData metaData = this.P;
            return metaData == null || (userId = metaData.getUserId()) == null || userId.equals("0");
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder D2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? E2(z, z2, false) : (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void D3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.J = i2;
        }
    }

    public i E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.E0 : (i) invokeV.objValue;
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.M2 : invokeV.intValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            BaijiahaoData baijiahaoData = this.l2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder E2(boolean z, boolean z2, boolean z4) {
        InterceptResult invokeCommon;
        SpannableStringBuilder A2;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)})) == null) {
            if (this.q == 1) {
                A2 = z2();
                spannableStringBuilder = A2.toString();
            } else {
                A2 = A2();
                spannableStringBuilder = A2.toString();
            }
            SpannableStringBuilder spannableStringBuilder3 = A2;
            String str = spannableStringBuilder;
            if (z) {
                spannableStringBuilder2 = c(str, spannableStringBuilder3, z, true, z2, z4);
            } else {
                spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder3);
            }
            this.w = spannableStringBuilder2;
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void E3(Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, item) == null) {
            this.u2 = item;
        }
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.j2 : (String) invokeV.objValue;
    }

    public int F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.A0 : invokeV.intValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            BaijiahaoData baijiahaoData = this.l2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 3;
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder F2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        SpannableStringBuilder z22;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!StringUtils.isNull(this.r) && this.q != 1) {
                z22 = A2();
            } else {
                z22 = z2();
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(z22);
            this.w = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void F3(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, itemData) == null) {
            this.v2 = itemData;
        }
    }

    public long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.w0 : invokeV.longValue;
    }

    public PraiseData G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.a0 : (PraiseData) invokeV.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            BaijiahaoData baijiahaoData = this.l2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 4;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G2(boolean z, boolean z2) {
        d.a.c.k.b bVar;
        SpannableStringBuilder A2;
        SpannableString spannableString;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!z2) {
                if (j1() == 42 && K1()) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_convene));
                }
                if (m0() == 1) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_top));
                } else if (m0() == 2) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_notice));
                }
                if (g0() == 1 || this.N.a() != 0) {
                    if (e1() != null && j1() == 41) {
                        if (f1() == 2) {
                            arrayList.add(Integer.valueOf(R.drawable.label_interview));
                        }
                    } else {
                        arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                    }
                }
                if (z && T1() && (num = G3.get(Integer.valueOf(f1()))) != null) {
                    arrayList.add(num);
                }
                if (l0() == 1 && !m2() && l3 != getType() && u3 != getType()) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_elite));
                }
                AnchorInfoData anchorInfoData = this.b0;
                if (anchorInfoData != null && anchorInfoData.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
                }
                if (X0() == 1) {
                    arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
                }
                Integer num2 = F3.get(new Point(q(), p()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
                if (y1() != null) {
                    arrayList.add(Integer.valueOf(R.drawable.tag_act));
                }
                if (E() != null) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
                }
                if (!d.a.c.e.p.k.isEmpty(this.F)) {
                    bVar = o4(this.F);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (arrayList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            sb.append("1 ");
                        }
                        String sb2 = sb.toString();
                        if (bVar != null) {
                            spannableString = new SpannableString(sb2 + this.F + " ");
                        } else {
                            spannableString = new SpannableString(sb2);
                        }
                        int i4 = 0;
                        for (int i5 = 0; i5 < arrayList.size(); i5++) {
                            Bitmap bitmap = SkinManager.getBitmap(((Integer) arrayList.get(i5)).intValue());
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                            if (bitmap != null) {
                                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            }
                            d.a.o0.r.f0.j jVar = new d.a.o0.r.f0.j(bitmapDrawable);
                            jVar.b(d.a.c.e.p.l.e(TbadkCoreApplication.getInst().getApplicationContext(), this.p));
                            spannableString.setSpan(jVar, i4, i4 + 1, 33);
                            i4 += 2;
                        }
                        if (bVar != null) {
                            spannableString.setSpan(bVar, i4, this.F.length() + i4, 33);
                        }
                        spannableStringBuilder.append((CharSequence) spannableString);
                    }
                    A2 = A2();
                    if (A2 != null) {
                        spannableStringBuilder.append((CharSequence) A2);
                    }
                    this.w = spannableStringBuilder;
                }
            }
            bVar = null;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (arrayList.size() > 0) {
            }
            A2 = A2();
            if (A2 != null) {
            }
            this.w = spannableStringBuilder2;
        }
    }

    public void G3(List<HeadItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, list) == null) {
            this.w2 = list;
        }
    }

    public MetaData H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.P : (MetaData) invokeV.objValue;
    }

    public ArrayList<d.a.o0.b1.m.b> H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            ArrayList<d.a.o0.b1.m.b> arrayList = new ArrayList<>();
            if (this.m2) {
                arrayList.add(new d.a.o0.b1.m.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            BaijiahaoData baijiahaoData = this.l2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public void H2(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.z = jSONObject.optString("id");
            this.B = jSONObject.optLong("fid", 0L);
            this.A = jSONObject.optString("tid");
            this.r = jSONObject.optString("title");
            this.u0 = jSONObject.optInt("is_god");
            this.v0 = jSONObject.optLong("create_time", 0L) * 1000;
            this.w0 = jSONObject.optLong("audit_time", 0L) * 1000;
            this.G = jSONObject.optInt("reply_num", 0);
            jSONObject.optInt("repost_num", 0);
            this.H = jSONObject.optInt("view_num", 0);
            jSONObject.optString("last_time");
            this.I = jSONObject.optLong("last_time_int", 0L);
            this.J = jSONObject.optInt("is_top", 0);
            this.K = jSONObject.optInt("is_membertop", 0);
            this.L = jSONObject.optInt("is_good", 0);
            this.M = jSONObject.optInt("is_livepost", 0);
            this.N.c(jSONObject.optJSONObject("topic"));
            this.O = jSONObject.optString("author_id");
            this.P.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
            this.Q = jSONObject.optString("fname");
            jSONObject.optInt("has_commented", 0);
            this.R = jSONObject.optInt("show_commented", 0);
            this.S = jSONObject.optString("click_url");
            jSONObject.optString("from");
            this.W = jSONObject.optInt("collect_status");
            this.X = jSONObject.optString("collect_mark_pid");
            this.Y = jSONObject.optInt("is_voice_thread");
            this.Z = jSONObject.optInt("thread_type");
            jSONObject.optInt("thread_type");
            this.m1 = jSONObject.optLong("share_num");
            this.c0 = jSONObject.optString("first_post_id", "0");
            this.z0 = jSONObject.optString("post_id", "0");
            jSONObject.optLong("time", 0L);
            this.q = jSONObject.optInt("is_ntitle");
            this.F = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            this.x0 = jSONObject.optString("tieba_game_information_source", "");
            this.k1.parseJson(jSONObject.optJSONObject("agree"));
            this.k1.threadId = this.A;
            JSONArray optJSONArray = jSONObject.optJSONArray("dislike_info");
            ArrayList<DislikeInfo> arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    DislikeInfo build = new DislikeInfo.Builder().build(true);
                    build.parseJson(optJSONArray.getJSONObject(i2));
                    arrayList.add(build);
                }
            }
            if (ListUtils.getCount(arrayList) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : arrayList) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                this.g1 = sparseArray;
                this.h1 = sparseArray2;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
            if (optJSONObject2 != null) {
                this.I0.k(optJSONObject2);
            }
            if ((this.P == null || this.P.getUserId() == null) && this.i0 != null) {
                this.P = this.i0.get(this.O);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                this.l0 = optJSONObject.optString("location");
            }
            jSONObject.optString("label_url");
            this.L2 = jSONObject.optString("mode_url");
            jSONObject.optString("location");
            AlaInfoData alaInfoData = new AlaInfoData();
            this.s0 = alaInfoData;
            alaInfoData.parserJson(jSONObject.optJSONObject("ala_info"));
            StringBuilder sb = new StringBuilder();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i4);
                    if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                        sb.append(optJSONArray2.getJSONObject(i4).optString("text"));
                    }
                }
            }
            this.s = sb.toString();
            JSONArray optJSONArray3 = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
            if (optJSONArray3 != null) {
                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray3.getJSONObject(i5));
                    this.T.add(mediaData);
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray4 != null) {
                int length = optJSONArray4.length();
                for (int i6 = 0; i6 < length; i6++) {
                    VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                    JSONObject jSONObject3 = optJSONArray4.getJSONObject(i6);
                    voiceData$VoiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                    voiceData$VoiceModel.voiceId = jSONObject3.optString("voice_md5");
                    voiceData$VoiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                    this.U.add(voiceData$VoiceModel);
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
            if (optJSONArray5 != null) {
                for (int i7 = 0; i7 < optJSONArray5.length(); i7++) {
                    b bVar = new b();
                    bVar.h(optJSONArray5.getJSONObject(i7));
                    this.C0.add(bVar);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
            if (optJSONObject4 != null) {
                o2 o2Var = new o2();
                this.D0 = o2Var;
                o2Var.c(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
            if (optJSONObject5 != null) {
                i iVar = new i();
                this.E0 = iVar;
                iVar.b(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject6 != null) {
                u uVar = new u();
                this.F0 = uVar;
                uVar.c(optJSONObject6);
            }
            this.a0.setUserMap(this.i0);
            this.a0.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
            this.b0.parserJson(jSONObject.optJSONObject("anchor_info"));
            if (!d.a.c.e.p.k.isEmpty(this.r)) {
                this.a0.setTitle(this.r);
            } else {
                this.a0.setTitle(this.s);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.I0.k(optJSONObject7);
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
            if (optJSONArray6 != null) {
                for (int i8 = 0; i8 < optJSONArray6.length(); i8++) {
                    d.a.o0.t.c cVar = new d.a.o0.t.c();
                    cVar.a(optJSONArray6.getJSONObject(i8));
                    this.J0.add(cVar);
                }
            }
            this.Q0 = jSONObject.optInt("is_book_chapter", 0);
            this.R0.a(jSONObject.optJSONObject("book_chapter"));
            this.T0 = jSONObject.optString("recom_source");
            this.X0 = jSONObject.optString("recom_reason");
            this.Y0 = jSONObject.optString("recom_tag_icon");
            this.U0 = jSONObject.optString(TiebaStatic.Params.RECOM_WEIGHT);
            this.W0 = jSONObject.optString(TiebaStatic.Params.RECOM_EXTRA);
            jSONObject.optString("recom_extra_img");
            jSONObject.optString("recom_extra_img_night");
            jSONObject.optInt("recom_extra_img_width", 0);
            jSONObject.optInt("recom_extra_img_height", 0);
            this.Z0 = jSONObject.optLong("last_read_pid");
            this.a1 = jSONObject.optInt("cheak_repeat") == 1;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
            if (optJSONObject8 != null) {
                i2 i2Var = new i2();
                this.r0 = i2Var;
                i2Var.a(optJSONObject8);
            }
            this.j1 = jSONObject.optInt("is_multiforum_thread") == 1;
            this.o1 = jSONObject.optBoolean("is_link_thread");
            JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
            if (this.o1 && optJSONObject9 != null) {
                q0 q0Var = new q0();
                this.n1 = q0Var;
                q0Var.g(optJSONObject9);
            }
            this.p1 = jSONObject.optInt("is_partial_visible") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
            if (optJSONObject10 != null) {
                h hVar = new h();
                this.q1 = hVar;
                hVar.a(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
            if (optJSONObject11 != null) {
                MediaData mediaData2 = new MediaData();
                this.r1 = mediaData2;
                mediaData2.parserJson(optJSONObject11);
            }
            jSONObject.optInt("is_called", 0);
            this.s1 = jSONObject.optInt("middle_page_num", 0);
            this.t1 = jSONObject.optInt("middle_page_pass_flag", 0);
            JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
            if (optJSONObject12 != null) {
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                builder.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                builder.video_md5 = optJSONObject12.optString(VideoFinishResult.KEY_VIDEO_MD5);
                builder.video_url = optJSONObject12.optString("video_url");
                builder.video_duration = new Integer(optJSONObject12.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
                builder.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                builder.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                builder.video_type = new Integer(optJSONObject12.optInt("video_type", 0));
                builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                builder.is_vertical = new Integer(optJSONObject12.optInt(TiebaStatic.Params.IS_VERTICAL, 0));
                builder.mcn_lead_page = new String(optJSONObject12.optString("mcn_lead_page"));
                this.p0 = builder.build(true);
            }
            boolean z = jSONObject.optInt("is_share_thread", 0) == 1;
            this.v1 = z;
            if (z) {
                JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                if (optJSONObject13 != null) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    this.u1 = originalThreadInfo;
                    originalThreadInfo.l(optJSONObject13);
                } else {
                    this.u1 = null;
                }
            } else {
                this.u1 = null;
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("swan_info");
            if (optJSONObject14 != null) {
                SmartApp.Builder builder2 = new SmartApp.Builder();
                builder2.avatar = optJSONObject14.optString("avatar");
                builder2.name = optJSONObject14.optString("name");
                builder2._abstract = optJSONObject14.optString("abstract");
                builder2.pic = optJSONObject14.optString("pic");
                builder2.h5_url = optJSONObject14.optString("h5_url");
                builder2.id = optJSONObject14.optString("id");
                builder2.link = optJSONObject14.optString("link");
                this.I1 = builder2.build(false);
            }
            this.Q1 = jSONObject.optString("t_share_img");
            this.R1 = jSONObject.optString("nid");
            this.S1 = jSONObject.optInt("is_headlinepost", 0) == 1;
            jSONObject.optInt(ImageViewerConfig.IS_BJH);
            this.k2 = jSONObject.optInt("bjh_content_tag");
            this.j2 = jSONObject.optString("article_cover");
            JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject15 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.l2 = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject15);
                this.k1.baijiahaoData = this.l2;
            }
            this.m2 = jSONObject.optInt("is_s_card", 0) == 1;
            this.n2 = jSONObject.optString("scard_packet_id");
            this.o2 = jSONObject.optInt("tab_id");
            this.p2 = jSONObject.optString("tab_name");
            jSONObject.optString("wonderful_post_info");
            this.h2 = jSONObject.optInt("if_comment", 0) == 1;
            this.i2 = jSONObject.optString("if_comment_info");
            JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
            if (optJSONObject16 != null) {
                if (this.y2 == null) {
                    this.y2 = new PollData();
                }
                this.y2.parserJson(optJSONObject16);
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
            if (optJSONArray7 != null) {
                for (int i9 = 0; i9 < optJSONArray7.length(); i9++) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseJson(optJSONArray7.getJSONObject(i9));
                    if (pbLinkData.urlType == 2 && !this.t2) {
                        this.t2 = true;
                    }
                    this.r2.add(pbLinkData);
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
            if (optJSONArray8 != null) {
                for (int i10 = 0; i10 < optJSONArray8.length(); i10++) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseJson(optJSONArray8.getJSONObject(i10));
                    this.s2.add(pbGoodsData);
                }
                if (this.s2.size() > 0 && !this.t2) {
                    this.t2 = true;
                }
            }
            this.z2 = jSONObject.optInt("hot_num", -1);
            jSONObject.optInt("is_local");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("works_info");
            if (optJSONObject17 != null) {
                if (this.I2 == null) {
                    this.I2 = new WorksInfoData();
                }
                this.I2.parseJson(optJSONObject17);
            }
            this.J2 = jSONObject.optInt("collect_num");
            JSONArray optJSONArray9 = jSONObject.optJSONArray("thread_recommend_infos");
            if (optJSONArray9 != null) {
                for (int i11 = 0; i11 < optJSONArray9.length(); i11++) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseJson(optJSONArray9.getJSONObject(i11));
                    this.K2.add(threadRecommendInfoData);
                }
            }
            x1 x1Var = new x1();
            this.C = x1Var;
            x1Var.d(jSONObject.optJSONObject("forum_info"));
            this.H2 = jSONObject.optInt("is_author_view");
            jSONObject.optString("scard_packet_id");
            this.G0 = jSONObject.optString("livecover_src");
            JSONArray optJSONArray10 = jSONObject.optJSONArray("rich_abstract");
            if (optJSONArray10 != null) {
                this.u = b1.a(optJSONArray10);
            }
            JSONArray optJSONArray11 = jSONObject.optJSONArray("rich_title");
            if (optJSONArray11 != null) {
                this.t = b1.a(optJSONArray11);
            }
            JSONArray optJSONArray12 = jSONObject.optJSONArray("first_post_content");
            if (optJSONArray12 != null) {
                this.v = b1.a(optJSONArray12);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("star_rank_icon");
            if (optJSONObject18 != null) {
                this.w1 = optJSONObject18.optString("icon_pic_url");
                this.x1 = optJSONObject18.optString("icon_link");
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("location");
            if (optJSONObject19 != null) {
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LAT))) {
                    this.j0 = optJSONObject19.optString(SuggestAddrField.KEY_LAT);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LNG))) {
                    this.j0 = optJSONObject19.optString(SuggestAddrField.KEY_LNG);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString("name"))) {
                    this.j0 = optJSONObject19.optString("name");
                }
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("ori_forum_info");
            if (optJSONObject20 != null) {
                OriginalForumInfo originalForumInfo = new OriginalForumInfo();
                originalForumInfo.id = optJSONObject20.optLong("ori_fid") + "";
                originalForumInfo.ori_fname = optJSONObject20.optString("ori_fname");
                originalForumInfo.ori_avatar = optJSONObject20.optString("ori_avatar");
                originalForumInfo.ori_member_num = optJSONObject20.optLong("ori_member_num");
                this.F1 = originalForumInfo;
            }
            JSONArray optJSONArray13 = jSONObject.optJSONArray("item_star");
            if (optJSONArray13 != null) {
                for (int i12 = 0; i12 < optJSONArray13.length(); i12++) {
                    JSONObject optJSONObject21 = optJSONArray13.optJSONObject(i12);
                    if (optJSONObject21 != null) {
                        HeadItem.Builder builder3 = new HeadItem.Builder();
                        builder3.content = optJSONObject21.optString("content");
                        builder3.name = optJSONObject21.optString("name");
                        builder3.type = Integer.valueOf(optJSONObject21.optInt("type"));
                        if (this.w2 == null) {
                            this.w2 = new ArrayList();
                        }
                        this.w2.add(builder3.build(true));
                    }
                }
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("item");
            if (optJSONObject22 != null && 0 != optJSONObject22.optLong(LegoListActivityConfig.ITEM_ID)) {
                Item.Builder builder4 = new Item.Builder();
                builder4.item_id = Long.valueOf(optJSONObject22.optLong(LegoListActivityConfig.ITEM_ID));
                builder4.item_name = optJSONObject22.optString("item_name");
                builder4.icon_size = Double.valueOf(optJSONObject22.optDouble("icon_size"));
                builder4.score = Double.valueOf(optJSONObject22.optDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE));
                builder4.icon_url = optJSONObject22.optString("icon_url");
                builder4.star = Integer.valueOf(optJSONObject22.optInt(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR));
                builder4.forum_name = optJSONObject22.optString("forum_name");
                JSONArray optJSONArray14 = jSONObject.optJSONArray("mTags");
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray14 != null) {
                    for (int i13 = 0; i13 < optJSONArray14.length(); i13++) {
                        arrayList2.add(optJSONArray14.optString(i13));
                    }
                    builder4.tags = arrayList2;
                }
                Item build2 = builder4.build(true);
                if (build2 != null) {
                    this.u2 = build2;
                    ItemData itemData = new ItemData();
                    this.v2 = itemData;
                    itemData.parseProto(build2);
                }
            }
            O2();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void H3(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
            this.I = j;
        }
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.k2 : invokeV.intValue;
    }

    public final ArrayList<m.a> I0(boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> arrayList = new ArrayList<>();
            boolean v2 = v2();
            if (z2) {
                if (z) {
                    if (v2 && !q2()) {
                        arrayList.add(new m.a(R.string.god_title));
                    }
                    if (g0() == 1 || j1() == 33 || (q1() != null && q1().a() != 0)) {
                        if (e1() == null || !T1()) {
                            if (!v2) {
                                arrayList.add(new m.a(R.string.photo_live_tips));
                            }
                        } else if (f1() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    }
                    if (T1()) {
                        arrayList.add(K3.get(f1()));
                    }
                    if (B1()) {
                        Integer num = J3.get(new Point(q(), p()));
                        if (num != null) {
                            arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(R.string.card_promotion_text));
                        }
                    }
                    if (y1() != null) {
                        arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!d.a.c.e.p.k.isEmpty(L())) {
                        arrayList.add(new m.a(L()));
                    }
                } else {
                    if (v2 && m0() != 1 && !q2()) {
                        arrayList.add(new m.a(R.string.god_title));
                    }
                    if ((g0() == 1 || j1() == 33) && !T1() && !v2) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                    if (l0() == 1) {
                        arrayList.add(new m.a(R.string.good));
                    }
                    if (m0() == 1) {
                        arrayList.add(new m.a(R.string.top));
                    }
                    if (T1() && e1() != null && f1() == 2) {
                        arrayList.add(new m.a(R.string.interview_live));
                    }
                    if (B1()) {
                        Integer num2 = J3.get(new Point(q(), p()));
                        if (num2 != null) {
                            arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(R.string.card_promotion_text));
                        }
                    }
                    if (this.Q0 == 1) {
                        arrayList.add(new m.a(R.string.card_tbread_text));
                    }
                    if (E() != null) {
                        arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (y1() != null) {
                        arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!d.a.c.e.p.k.isEmpty(L())) {
                        arrayList.add(new m.a(L()));
                    }
                    if (z4 && Y1()) {
                        arrayList.add(new m.a(R.string.ala_live));
                    }
                    if (z4 && X1()) {
                        arrayList.add(new m.a(R.string.live_record));
                    } else if (f2()) {
                        arrayList.add(new m.a(R.string.video_title_str));
                    }
                    if (z5) {
                        arrayList.add(new m.a(R.string.video_review_state));
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    @Deprecated
    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? p2() : invokeV.booleanValue;
    }

    public void I2(ThreadInfo threadInfo) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        try {
            if (threadInfo.location != null) {
                this.j0 = threadInfo.location.lat;
                this.k0 = threadInfo.location.lng;
                this.l0 = threadInfo.location.name;
            }
            this.V = threadInfo.is_tbread_dispatch.intValue();
            this.z = threadInfo.id + "";
            this.A = threadInfo.tid + "";
            this.B = threadInfo.fid.longValue();
            this.r = threadInfo.title;
            this.u0 = threadInfo.is_god.intValue();
            this.v0 = threadInfo.create_time.intValue() * 1000;
            this.w0 = threadInfo.audit_time.longValue() * 1000;
            this.G = threadInfo.reply_num.intValue();
            threadInfo.repost_num.intValue();
            this.H = threadInfo.view_num.intValue();
            String str = threadInfo.last_time;
            this.I = threadInfo.last_time_int.intValue();
            this.J = threadInfo.is_top.intValue();
            this.K = threadInfo.is_membertop.intValue();
            this.L = threadInfo.is_good.intValue();
            this.M = threadInfo.is_livepost.intValue();
            this.N.d(threadInfo.topic);
            this.P.parserProtobuf(threadInfo.author);
            this.O = threadInfo.author_id.toString();
            this.Q = threadInfo.fname;
            threadInfo.has_commented.intValue();
            this.R = threadInfo.show_commented.intValue();
            this.S = threadInfo.click_url;
            this.p0 = threadInfo.video_info;
            this.q0 = threadInfo.video_segment;
            AlaInfoData alaInfoData = new AlaInfoData();
            this.s0 = alaInfoData;
            alaInfoData.parserProtobuf(threadInfo.ala_info);
            String str2 = threadInfo.from;
            this.W = threadInfo.collect_status.intValue();
            this.X = threadInfo.collect_mark_pid;
            this.Y = threadInfo.is_voice_thread.intValue();
            this.Z = threadInfo.thread_type.intValue();
            threadInfo.thread_type.intValue();
            this.c0 = threadInfo.first_post_id + "";
            this.z0 = threadInfo.post_id + "";
            threadInfo.time.intValue();
            this.q = threadInfo.is_ntitle.intValue();
            this.m0 = threadInfo.is_activity.intValue();
            if (threadInfo.agree != null) {
                this.k1.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                this.k1.parseProtobuf(threadInfo.agree);
            }
            if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                this.x0 = threadInfo.tieba_game_information_source;
            } else {
                this.x0 = "";
            }
            this.m1 = threadInfo.share_num.longValue();
            this.F = threadInfo.category_name;
            this.n0 = threadInfo.operator_flag.intValue();
            if (threadInfo.is_operate_thread != null) {
                this.S0 = threadInfo.is_operate_thread.intValue() == 1;
            }
            this.t = threadInfo.rich_title;
            this.v = threadInfo.first_post_content;
            this.u = threadInfo.rich_abstract;
            threadInfo.is_godthread_recommend.intValue();
            if ((this.P == null || this.P.getUserId() == null || this.P.getUserId().equals("0") || this.E2) && this.O != null && !this.O.equals("0") && this.i0 != null && (metaData = this.i0.get(this.O)) != null) {
                this.P = metaData;
            }
            StringBuilder sb = new StringBuilder();
            List<Abstract> list = threadInfo._abstract;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2) != null && list.get(i2).type.intValue() == 0) {
                        sb.append(list.get(i2).text);
                    }
                }
            }
            this.s = sb.toString();
            List<Media> list2 = threadInfo.media;
            if (list2 != null) {
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(list2.get(i4));
                    this.T.add(mediaData);
                }
            }
            if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                this.p0 = threadInfo.video_info;
            }
            if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                i2 i2Var = new i2();
                this.r0 = i2Var;
                i2Var.b(threadInfo.video_channel_info);
            }
            List<Voice> list3 = threadInfo.voice_info;
            if (list3 != null) {
                int size = list3.size();
                for (int i5 = 0; i5 < size; i5++) {
                    VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                    Voice voice = list3.get(i5);
                    voiceData$VoiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                    voiceData$VoiceModel.voiceId = voice.voice_md5;
                    voiceData$VoiceModel.duration = voice.during_time.intValue() / 1000;
                    this.U.add(voiceData$VoiceModel);
                }
            }
            List<ActInfo> list4 = threadInfo.act_info;
            if (list4 != null) {
                int size2 = list4.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    b bVar = new b();
                    bVar.i(list4.get(i6));
                    this.C0.add(bVar);
                }
            }
            if (threadInfo.yule_post_activity != null) {
                o2 o2Var = new o2();
                this.D0 = o2Var;
                o2Var.d(threadInfo.yule_post_activity);
            }
            if (threadInfo.app_code != null) {
                i iVar = new i();
                this.E0 = iVar;
                iVar.c(threadInfo.app_code);
            }
            if (threadInfo.cartoon_info != null) {
                u uVar = new u();
                this.F0 = uVar;
                uVar.d(threadInfo.cartoon_info);
            }
            this.a0.setUserMap(this.i0);
            this.a0.parserProtobuf(threadInfo.zan);
            this.b0.parserProtobuf(threadInfo.anchor_info);
            if (!d.a.c.e.p.k.isEmpty(this.r)) {
                this.a0.setTitle(this.r);
            } else {
                this.a0.setTitle(this.s);
            }
            this.G0 = threadInfo.livecover_src;
            threadInfo.storecount.intValue();
            this.A0 = threadInfo.post_num.intValue();
            threadInfo.post_num.intValue();
            threadInfo.freq_num.longValue();
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                if (zhiBoInfoTW.labelInfo != null) {
                    int size3 = zhiBoInfoTW.labelInfo.size();
                    for (int i7 = 0; i7 < size3; i7++) {
                        if (zhiBoInfoTW.labelInfo.get(i7) != null) {
                            d.a.o0.s.i.c cVar = new d.a.o0.s.i.c();
                            cVar.a(zhiBoInfoTW.labelInfo.get(i7).labelHot.intValue());
                            cVar.b(zhiBoInfoTW.labelInfo.get(i7).labelId);
                            cVar.c(zhiBoInfoTW.labelInfo.get(i7).labelContent);
                            this.o0.add(cVar);
                        }
                    }
                }
                NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                if (noticeInfo != null) {
                    String str3 = noticeInfo.notice;
                }
                this.H0 = zhiBoInfoTW.copythread_remind.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                if (StringUtils.isNull(this.G0)) {
                    this.G0 = zhiBoInfoTW.livecover_src;
                }
                if (zhiBoInfoTW.user != null) {
                    TwZhiBoUser twZhiBoUser = zhiBoInfoTW.user.tw_anchor_info;
                    List<TwAnchorProfitItem> list5 = zhiBoInfoTW.user.profit_list;
                }
            }
            if (threadInfo.twzhibo_info != null) {
                threadInfo.twzhibo_info.is_headline.intValue();
                LiveCoverStatus liveCoverStatus = threadInfo.twzhibo_info.livecover_status;
                threadInfo.twzhibo_info.freq_num.intValue();
                if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                    this.t0 = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                }
            }
            threadInfo.is_copythread.intValue();
            if (threadInfo.task_info != null) {
                this.I0.l(threadInfo.task_info);
            }
            if (threadInfo.ext_tails != null) {
                for (int i8 = 0; i8 != threadInfo.ext_tails.size(); i8++) {
                    d.a.o0.t.c cVar2 = new d.a.o0.t.c();
                    cVar2.b(threadInfo.ext_tails.get(i8));
                    this.J0.add(cVar2);
                }
            }
            this.K0.parserProtobuf(threadInfo.push_status);
            this.P0 = threadInfo.lego_card;
            this.N0 = threadInfo.skin_info;
            this.Q0 = threadInfo.is_book_chapter.intValue();
            this.R0.b(threadInfo.book_chapter);
            this.T0 = threadInfo.recom_source;
            this.X0 = threadInfo.recom_reason;
            this.Y0 = threadInfo.recom_tag_icon;
            this.U0 = threadInfo.recom_weight;
            this.V0 = threadInfo.ab_tag;
            this.W0 = threadInfo.recom_extra;
            this.Z0 = threadInfo.last_read_pid.longValue();
            this.a1 = threadInfo.cheak_repeat.intValue() == 1;
            List<ReportInfo> list6 = threadInfo.report_info;
            if (threadInfo.top_agree_post != null) {
                this.l1.b0(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
            }
            List<DislikeInfo> list7 = threadInfo.dislike_info;
            if (ListUtils.getCount(list7) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : list7) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                this.g1 = sparseArray;
                this.h1 = sparseArray2;
            }
            this.j1 = threadInfo.is_multiforum_thread.intValue() == 1;
            boolean z = threadInfo.is_link_thread.intValue() == 1;
            this.o1 = z;
            if (z && threadInfo.link_info != null) {
                q0 q0Var = new q0();
                this.n1 = q0Var;
                q0Var.h(threadInfo.link_info);
            }
            this.p1 = threadInfo.is_partial_visible.intValue() == 1;
            if (threadInfo.activity_info != null) {
                h hVar = new h();
                this.q1 = hVar;
                hVar.b(threadInfo.activity_info);
            }
            if (threadInfo.pic_info != null) {
                MediaData mediaData2 = new MediaData();
                this.r1 = mediaData2;
                mediaData2.parserProtobuf(threadInfo.pic_info);
            }
            threadInfo.is_called.intValue();
            this.s1 = threadInfo.middle_page_num.intValue();
            this.t1 = threadInfo.middle_page_pass_flag.intValue();
            this.v1 = threadInfo.is_share_thread.intValue() == 1;
            if (threadInfo.star_rank_icon != null) {
                this.w1 = threadInfo.star_rank_icon.icon_pic_url;
                this.x1 = threadInfo.star_rank_icon.icon_link;
            }
            if (threadInfo.origin_thread_info != null) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.u1 = originalThreadInfo;
                originalThreadInfo.j(threadInfo.origin_thread_info);
            } else {
                this.u1 = null;
                this.v1 = false;
            }
            this.y1 = threadInfo.is_topic.intValue();
            this.A1 = threadInfo.topic_user_name;
            this.B1 = threadInfo.topic_h5_url;
            this.z1 = threadInfo.topic_module;
            String str4 = threadInfo.presentation_style;
            this.F1 = OriginalForumInfo.parser(threadInfo.ori_forum_info);
            String str5 = threadInfo.daily_paper_time;
            if (threadInfo.forum_info != null) {
                x1 x1Var = new x1();
                this.C = x1Var;
                x1Var.e(threadInfo.forum_info);
            }
            if (threadInfo.swan_info != null) {
                this.I1 = threadInfo.swan_info;
            }
            this.Q1 = threadInfo.t_share_img;
            this.R1 = threadInfo.nid;
            this.S1 = threadInfo.is_headlinepost.intValue() == 1;
            String str6 = threadInfo.thread_share_link;
            this.j2 = threadInfo.article_cover;
            this.k2 = threadInfo.bjh_content_tag.intValue();
            threadInfo.is_bjh.intValue();
            if (threadInfo.baijiahao != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.l2 = baijiahaoData;
                baijiahaoData.parseProto(threadInfo.baijiahao);
                this.k1.baijiahaoData = this.l2;
            }
            this.m2 = threadInfo.is_s_card.intValue() == 1;
            this.n2 = threadInfo.scard_packet_id;
            this.o2 = threadInfo.tab_id.intValue();
            this.p2 = threadInfo.tab_name;
            String str7 = threadInfo.wonderful_post_info;
            this.h2 = threadInfo.if_comment.intValue() == 1;
            this.i2 = threadInfo.if_comment_info;
            this.q2 = threadInfo;
            if (!ListUtils.isEmpty(threadInfo.pb_link_info)) {
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    if (pbLinkData.urlType == 2 && !this.t2) {
                        this.t2 = true;
                    }
                    this.r2.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(threadInfo.pb_goods_info)) {
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    this.s2.add(pbGoodsData);
                }
                if (this.s2.size() > 0 && !this.t2) {
                    this.t2 = true;
                }
            }
            if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                this.u2 = threadInfo.item;
            }
            if (this.u2 != null) {
                ItemData itemData = new ItemData();
                this.v2 = itemData;
                itemData.parseProto(this.u2);
            }
            List<HeadItem> list8 = threadInfo.item_star;
            this.w2 = list8;
            if (!ListUtils.isEmpty(list8)) {
                ItemStarData itemStarData = new ItemStarData();
                this.x2 = itemStarData;
                itemStarData.parseProto(this.w2);
            }
            if (threadInfo.poll_info != null) {
                if (this.y2 == null) {
                    this.y2 = new PollData();
                }
                this.y2.parserProtobuf(threadInfo.poll_info);
            }
            this.z2 = threadInfo.hot_num.intValue();
            threadInfo.is_local.intValue();
            this.H2 = threadInfo.is_author_view.intValue();
            if (threadInfo.works_info != null) {
                if (this.I2 == null) {
                    this.I2 = new WorksInfoData();
                }
                this.I2.parseProto(threadInfo.works_info);
            }
            O2();
            this.J2 = threadInfo.collect_num.intValue();
            if (ListUtils.isEmpty(threadInfo.thread_recommend_infos)) {
                return;
            }
            for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                threadRecommendInfoData.parseProto(threadRecommendInfo);
                this.K2.add(threadRecommendInfoData);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void I3(List<PbLinkData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, list) == null) {
            this.r2 = list;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (PbLinkData pbLinkData : this.r2) {
                if (pbLinkData.urlType == 2 && !this.t2) {
                    this.t2 = true;
                }
            }
        }
    }

    public BaijiahaoData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.l2 : (BaijiahaoData) invokeV.objValue;
    }

    public PushStatusData J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.K0 : (PushStatusData) invokeV.objValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? F1() || G1() : invokeV.booleanValue;
    }

    public void J2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            K2(z, z2, true);
        }
    }

    public void J3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.X = str;
        }
    }

    public u K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.F0 : (u) invokeV.objValue;
    }

    public ThreadInfo K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.q2 : (ThreadInfo) invokeV.objValue;
    }

    public final boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public void K2(boolean z, boolean z2, boolean z4) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)}) == null) {
            if (ListUtils.getCount(I0(z, z2, z4, false)) > 0) {
                D2(z, z4);
                return;
            }
            SpannableStringBuilder A2 = A2();
            if (z) {
                spannableStringBuilder = c(A2.toString(), A2, z, z2, z4, false);
            } else {
                spannableStringBuilder = new SpannableStringBuilder(A2);
            }
            this.w = spannableStringBuilder;
        }
    }

    public void K3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.D1 = z;
        }
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.F : (String) invokeV.objValue;
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (e2()) {
                return 4;
            }
            if (Y1() || X1()) {
                return 3;
            }
            if (E1()) {
                return 5;
            }
            if (H1()) {
                return 6;
            }
            if (F1()) {
                return 7;
            }
            if (G1()) {
                return 8;
            }
            if (!this.v1 || this.u1 == null) {
                return f2() ? 2 : 1;
            }
            return 9;
        }
        return invokeV.intValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? u2() : invokeV.booleanValue;
    }

    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            G2(false, true);
        }
    }

    public void L3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.E1 = z;
        }
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.H0 : invokeV.intValue;
    }

    public String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.T0 : (String) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            MetaData metaData = this.P;
            return metaData != null && metaData.isForumBusinessAccount();
        }
        return invokeV.booleanValue;
    }

    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            G2(false, false);
        }
    }

    public void M3(ArrayList<MediaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, arrayList) == null) {
            this.T = arrayList;
        }
    }

    public long N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.v0 : invokeV.longValue;
    }

    public String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.N1 : (String) invokeV.objValue;
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.O0 : invokeV.booleanValue;
    }

    public int N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (!d.a.o0.r.k.c().g() || ListUtils.getCount(z0()) == 0) {
                return 0;
            }
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < z0().size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(z0(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    public void N3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.o = str;
        }
    }

    public long O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.k1.disAgreeNum : invokeV.longValue;
    }

    public String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.O1 : (String) invokeV.objValue;
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.X1 : invokeV.booleanValue;
    }

    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            Z2();
            R2();
            X2();
            Y2();
            P2();
            V2();
            W2();
        }
    }

    public void O3(PollData pollData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, pollData) == null) {
            this.y2 = pollData;
        }
    }

    public SparseArray<String> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.g1 : (SparseArray) invokeV.objValue;
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.G : invokeV.intValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            d.a.p0.h3.h0.n nVar = this.G2;
            if (nVar != null) {
                return nVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            this.y = w2();
        }
    }

    public void P3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            this.M2 = i2;
        }
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.B : invokeV.longValue;
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.n : invokeV.intValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            MetaData metaData = this.P;
            return (metaData == null || metaData.getGodUserData() == null || this.P.getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void Q2() {
        AlaInfoData alaInfoData;
        AlaUserInfoData alaUserInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048659, this) == null) || (alaInfoData = this.s0) == null) {
            return;
        }
        if (alaInfoData.openRecomDuration == 1) {
            long j = this.v0;
            if (j > 0) {
                String formatTimeForAlaCardCreate = StringHelper.getFormatTimeForAlaCardCreate(j);
                if (!StringUtils.isNull(formatTimeForAlaCardCreate)) {
                    this.L1 = formatTimeForAlaCardCreate;
                }
            }
        }
        AlaInfoData alaInfoData2 = this.s0;
        if (alaInfoData2.openRecomFans == 1) {
            int i2 = 0;
            if (alaInfoData2 != null && (alaUserInfoData = alaInfoData2.user_info) != null) {
                i2 = alaUserInfoData.anchor_fans;
            }
            if (TextUtils.isEmpty(this.L1) || i2 <= 0) {
                if (i2 > 0) {
                    this.L1 = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    return;
                }
                return;
            }
            this.L1 += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
        }
    }

    public void Q3(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, praiseData) == null) {
            this.a0 = praiseData;
        }
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.D : (String) invokeV.objValue;
    }

    public List<PbContent> R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.t2 : invokeV.booleanValue;
    }

    public final void R2() {
        MetaData metaData;
        MetaData metaData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            if ((this instanceof x0) && "0".equals(c0())) {
                this.L1 = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
                return;
            }
            if (!p2() && (!O1() || getType() == m3)) {
                if (getType() != m3 && getType() != p3) {
                    long q0 = q0() * 1000;
                    if (q0 != 0) {
                        String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(q0);
                        if (StringHelper.isThisYear(formatTimeForJustNow)) {
                            formatTimeForJustNow = StringHelper.getFormatTimeShort(q0);
                        }
                        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                        if (showWeakenName()) {
                            formatTimeForJustNow = StringHelper.getFormatTimeForHomeC(q0);
                        }
                        this.L1 = string + formatTimeForJustNow;
                    } else {
                        long j = this.v0;
                        String formatTimeForJustNow2 = StringHelper.getFormatTimeForJustNow(j);
                        if (StringHelper.isThisYear(formatTimeForJustNow2)) {
                            formatTimeForJustNow2 = StringHelper.getFormatTimeShort(j);
                        }
                        this.L1 = formatTimeForJustNow2;
                    }
                    if (d2()) {
                        T2();
                    } else if (h2()) {
                        S2();
                    } else if (!this.W1 && (metaData2 = this.P) != null && metaData2.showBazhuGrade()) {
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getBazhuGradeData().getDesc(), this.V1 ? 24 : 16, StringHelper.STRING_MORE);
                        if (!TextUtils.isEmpty(this.L1)) {
                            this.L1 += "   " + cutChineseAndEnglishWithSuffix;
                        } else {
                            this.L1 = cutChineseAndEnglishWithSuffix;
                        }
                    }
                    if (TextUtils.isEmpty(this.L1) || TextUtils.isEmpty(y())) {
                        return;
                    }
                    this.L1 += " • " + y();
                    return;
                }
                Q2();
                return;
            }
            long j2 = this.v0;
            if (j2 != 0) {
                String formatTimeForJustNow3 = StringHelper.getFormatTimeForJustNow(j2);
                if (StringHelper.isThisYear(formatTimeForJustNow3)) {
                    formatTimeForJustNow3 = StringHelper.getFormatTimeShort(j2);
                }
                this.L1 = formatTimeForJustNow3;
            }
            MetaData metaData3 = this.P;
            String str = (metaData3 == null || metaData3.getBaijiahaoInfo() == null || TextUtils.isEmpty(this.P.getBaijiahaoInfo().auth_desc)) ? "" : this.P.getBaijiahaoInfo().auth_desc;
            if (d2()) {
                T2();
            } else if (!this.W1 && (metaData = this.P) != null && metaData.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.L1)) {
                    this.L1 += "   " + cutChineseAndEnglishWithSuffix2;
                    return;
                }
                this.L1 = cutChineseAndEnglishWithSuffix2;
            } else if (!TextUtils.isEmpty(this.L1) && !TextUtils.isEmpty(str)) {
                this.L1 += "   " + str;
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.L1 = str;
            }
        }
    }

    public void R3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i2) == null) {
            this.G = i2;
        }
    }

    public List<PbContent> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.M0 : (String) invokeV.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.b1 : invokeV.booleanValue;
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || StringUtils.isNull(this.Q)) {
            return;
        }
        this.L1 = (StringHelper.cutChineseAndEnglishWithSuffix(this.Q, 12, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getContext().getString(R.string.forum)) + GlideException.IndentedAppendable.INDENT + this.L1;
    }

    public void S3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i2) == null) {
            this.n = i2;
        }
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.z0 : (String) invokeV.objValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.Z == 41 : invokeV.booleanValue;
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048674, this) == null) && d2() && !TextUtils.isEmpty(this.P.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.L1)) {
                this.L1 += "   " + this.P.getNewGodData().getFieldName() + d.a.o0.z0.n0.d(this.P.getNewGodData().isVideoGod());
                return;
            }
            this.L1 = this.P.getNewGodData().getFieldName() + d.a.o0.z0.n0.d(this.P.getNewGodData().isVideoGod());
        }
    }

    public void T3(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, list) == null) {
            this.u = list;
        }
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.c0 : (String) invokeV.objValue;
    }

    public String U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.Q1 : (String) invokeV.objValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? e1() != null && j1() == 41 && g0() == 1 && f1() == 2 : invokeV.booleanValue;
    }

    public void U2() {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || p2() || O1()) {
            return;
        }
        long q0 = q0() * 1000;
        if (q0 != 0) {
            String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(q0);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(q0);
            }
            this.L1 = formatTimeForJustNow;
        }
        if (d2()) {
            T2();
        } else if (!this.W1 && (metaData = this.P) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
            if (!TextUtils.isEmpty(this.L1)) {
                this.L1 += "   " + cutChineseAndEnglishWithSuffix;
            } else {
                this.L1 = cutChineseAndEnglishWithSuffix;
            }
        }
        if (TextUtils.isEmpty(this.L1) || TextUtils.isEmpty(y())) {
            return;
        }
        this.L1 += " • " + y();
    }

    public void U3(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, list) == null) {
            this.t = list;
        }
    }

    public x1 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.C : (x1) invokeV.objValue;
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.M1 : (String) invokeV.objValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.o1 : invokeV.booleanValue;
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            this.N1 = StringHelper.getFormatTimeShort(q0() * 1000);
        }
    }

    public void V3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
            this.E = str;
        }
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    public long W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.m1 : invokeV.longValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.Z == 41 : invokeV.booleanValue;
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            this.O1 = StringHelper.getFormatTimeShort(q0());
        }
    }

    public void W3(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048690, this, j) == null) {
            this.m1 = j;
        }
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.i1 : (String) invokeV.objValue;
    }

    public int X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.R : invokeV.intValue;
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? j1() == 50 : invokeV.booleanValue;
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            if (g1() != null && g1().share_info != null && g1().share_info.share_user_count > 0 && g2() && (this.s1 <= 0 || this.t1 != 0)) {
                int i2 = g1().share_info.share_user_count;
                if (i2 == 1) {
                    this.M1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
                    return;
                } else {
                    this.M1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i2)});
                    return;
                }
            }
            this.M1 = null;
        }
    }

    public void X3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z) == null) {
            this.J1 = z;
        }
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.x0 : (String) invokeV.objValue;
    }

    public SkinInfo Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.N0 : (SkinInfo) invokeV.objValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? j1() == 49 || j1() == 69 : invokeV.booleanValue;
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            SpannableStringBuilder C2 = C2();
            this.x = C2;
            d.a.p0.a0.m.b(this, C2, true);
        }
    }

    public void Y3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048700, this, i2) == null) {
            this.f1 = i2;
        }
    }

    public List<PbGoodsData> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.s2 : (List) invokeV.objValue;
    }

    public SmartApp Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.I1 : (SmartApp) invokeV.objValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this.D1 : invokeV.booleanValue;
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || StringUtils.isNull(this.P.getName_show())) {
            return;
        }
        this.K1 = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getName_show(), 12, StringHelper.STRING_MORE);
    }

    public void Z3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048705, this, i2) == null) {
        }
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.k1.hasAgree ? 1 : 0 : invokeV.intValue;
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? this.f1 : invokeV.intValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? this.E1 : invokeV.booleanValue;
    }

    public void a3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            this.s = str;
        }
    }

    public void a4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048710, this, str, str2) == null) {
            this.L0 = str;
            this.M0 = str2;
        }
    }

    public VideoInfo b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.C1 : (VideoInfo) invokeV.objValue;
    }

    public SpannableStringBuilder b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? this.w : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? this.j1 : invokeV.booleanValue;
    }

    public void b3(ArrayList<b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, arrayList) == null) {
            this.C0 = arrayList;
        }
    }

    public void b4(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, alaInfoData) == null) {
            this.s0 = alaInfoData;
        }
    }

    public final SpannableStringBuilder c(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048716, this, new Object[]{str, spannableStringBuilder, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> I0 = I0(z, z2, z4, z5);
            if (I0 == null) {
                return new SpannableStringBuilder();
            }
            SpannableStringBuilder h2 = d.a.p0.a0.m.h(TbadkCoreApplication.getInst(), str, I0, false);
            if (I0.size() > 0) {
                if (h2 == null) {
                    h2 = new SpannableStringBuilder();
                }
                if (this.q == 1) {
                    this.w = h2;
                    return h2;
                }
            } else if (this.q == 1) {
                this.w = new SpannableStringBuilder();
                return h2;
            }
            if (spannableStringBuilder != null) {
                h2.append((CharSequence) spannableStringBuilder);
            } else if (I0.size() > 0 || h2.length() == 0) {
                h2.append((CharSequence) str);
            }
            return h2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) ? this.o2 : invokeV.intValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? this.a1 : invokeV.booleanValue;
    }

    public void c3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i2) == null) {
            this.k1.agreeNum = i2;
        }
    }

    public void c4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, str) == null) {
            this.L1 = str;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int[] d0() {
        InterceptResult invokeV;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            int[] iArr = new int[2];
            int size = View.MeasureSpec.getSize(d.a.c.e.p.l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i12 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
            ArrayList<MediaData> z0 = z0();
            if (d.a.o0.r.k.c().g() && ListUtils.getCount(z0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i13 = 0; i13 < z0.size(); i13++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(z0, i13);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
            }
            MediaData mediaData2 = (MediaData) ListUtils.getItem(z0, 0);
            if (mediaData2 == null || (i4 = mediaData2.picWidth) <= 0 || (i2 = mediaData2.picHeight) <= 0) {
                i12 = (i12 * 2) + dimensionPixelSize;
                i2 = i12;
            } else {
                if (i4 * 2 <= i2) {
                    i10 = ((int) (i12 * 1.5f)) + dimensionPixelSize;
                    i11 = i12 * 2;
                } else if (i2 * 2 <= i4) {
                    i10 = (i12 * 2) + dimensionPixelSize;
                    i11 = (int) (i12 * 1.5f);
                } else if (i4 >= i12) {
                    if (i4 < i12 || i4 >= (i9 = i12 * 2)) {
                        int i14 = mediaData2.picHeight;
                        if (i14 >= i12) {
                            if (i14 >= i12 && i14 < (i8 = i12 * 2)) {
                                i12 = i8 + dimensionPixelSize;
                                i5 = (i14 * i12) / mediaData2.picWidth;
                            } else {
                                int i15 = mediaData2.picWidth;
                                int i16 = mediaData2.picHeight;
                                if (i15 < i16) {
                                    i6 = (i12 * 2) + dimensionPixelSize;
                                    i7 = (i15 * i6) / i16;
                                } else {
                                    i12 = (i12 * 2) + dimensionPixelSize;
                                    i5 = (i16 * i12) / i15;
                                }
                            }
                            i2 = i5;
                        }
                        i12 = 0;
                        i2 = 0;
                    } else if (i2 < i12) {
                        i4 = (i4 * i12) / i2;
                        i2 = i12;
                        i12 = i4;
                    } else {
                        if (i2 < i12 || i2 >= i9) {
                            i6 = i9 + dimensionPixelSize;
                            i7 = (mediaData2.picWidth * i6) / mediaData2.picHeight;
                        }
                        i12 = i4;
                    }
                    i2 = i6;
                    i12 = i7;
                } else if (i2 >= i12) {
                    if (i2 >= i12 && i2 < i12 * 2) {
                        i2 = (i2 * i12) / i4;
                    }
                    i12 = 0;
                    i2 = 0;
                } else if (i4 < i2) {
                    i2 = (i2 * i12) / i4;
                } else {
                    i4 = (i4 * i12) / i2;
                    i2 = i12;
                    i12 = i4;
                }
                i2 = i11 + dimensionPixelSize;
                i12 = i10;
            }
            iArr[0] = i12;
            iArr[1] = i2;
            d.a.o0.b.g.b.k(this, iArr);
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public String d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.p2 : (String) invokeV.objValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            MetaData metaData = this.P;
            return metaData != null && metaData.isNewGod();
        }
        return invokeV.booleanValue;
    }

    public void d3(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048726, this, j) == null) {
            this.k1.agreeNum = j;
        }
    }

    public void d4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048727, this, i2) == null) {
            this.Z = i2;
        }
    }

    public SpannableString e(ClickableSpan clickableSpan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048728, this, clickableSpan)) == null) {
            if (clickableSpan == null) {
                return null;
            }
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.icon_card_video_jump);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            d.a.o0.r.f0.k kVar = new d.a.o0.r.f0.k(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
            String p = d.a.o0.r.d0.b.j().p("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
            if (StringUtils.isNull(p)) {
                p = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
            }
            StringBuilder sb = new StringBuilder(p);
            if (H() != null) {
                if (H().getGender() == 1) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
                } else if (H().getGender() == 2) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.she));
                } else {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
                }
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
            }
            sb.insert(0, "[icon]");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(kVar, 0, 6, 17);
            spannableString.setSpan(clickableSpan, 6, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? this.c1 : invokeV.intValue;
    }

    public z1 e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) ? this.I0 : (z1) invokeV.objValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? this.u0 == 1 : invokeV.booleanValue;
    }

    public void e3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048732, this, i2) == null) {
            this.k1.agreeType = i2;
        }
    }

    public void e4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, str) == null) {
            this.A = str;
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) ? this.H1 : invokeV.booleanValue;
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            z1 z1Var = this.I0;
            if (z1Var != null) {
                long e2 = z1Var.e();
                long a2 = this.I0.a();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < e2) {
                    return 1;
                }
                return currentTimeMillis > a2 ? 3 : 2;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? j1() == 40 : invokeV.booleanValue;
    }

    public void f3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048737, this, i2) == null) {
            this.t0 = i2;
        }
    }

    public void f4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, str) == null) {
            this.r = str;
        }
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? this.M : invokeV.intValue;
    }

    public AlaInfoData g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.s0 : (AlaInfoData) invokeV.objValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? j1() == 60 : invokeV.booleanValue;
    }

    public void g3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, str) == null) {
            this.j2 = str;
        }
    }

    public void g4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            this.B1 = str;
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            ArrayList<MediaData> z0 = z0();
            if (z0 == null || m2()) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < z0.size() && i2 < 3; i2++) {
                if (z0.get(i2) != null && z0.get(i2).getType() == 3) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    if (!StringUtils.isNull(z0.get(i2).getThumbnails_url())) {
                        preLoadImageInfo.imgUrl = z0.get(i2).getThumbnails_url();
                    } else {
                        preLoadImageInfo.imgUrl = z0.get(i2).getPicUrl();
                    }
                    preLoadImageInfo.procType = 13;
                    arrayList.add(preLoadImageInfo);
                }
            }
            int size = arrayList.size();
            Iterator<PreLoadImageInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                PreLoadImageInfo next = it.next();
                if (size == 1) {
                    next.preloadType = 1;
                } else {
                    next.preloadType = 2;
                }
            }
            VideoInfo videoInfo = this.p0;
            if (videoInfo != null && !StringUtils.isNull(videoInfo.thumbnail_url)) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.imgUrl = this.p0.thumbnail_url;
                preLoadImageInfo2.procType = 10;
                preLoadImageInfo2.preloadType = 1;
                arrayList.add(preLoadImageInfo2);
            }
            if (this.P != null) {
                PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
                preLoadImageInfo3.imgUrl = this.P.getPortrait();
                preLoadImageInfo3.procType = 28;
                preLoadImageInfo3.preloadType = 3;
                arrayList.add(preLoadImageInfo3);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // d.a.o0.r.q.a
    public w0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            SparseArray<String> sparseArray = this.g1;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return null;
            }
            w0 w0Var = new w0();
            getThreadData();
            w0Var.n(n1());
            getThreadData();
            w0Var.k(Q());
            getThreadData();
            w0Var.m(A0());
            w0Var.j(this.g1);
            w0Var.f52804g = this.h1;
            w0Var.o = this.V0;
            w0Var.j = this.U0;
            w0Var.l = this.W0;
            w0Var.k = this.T0;
            w0Var.p = this.P1;
            w0Var.n = L0();
            return w0Var;
        }
        return (w0) invokeV.objValue;
    }

    @Override // d.a.o0.r.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) ? this.X0 : (String) invokeV.objValue;
    }

    @Override // d.a.o0.r.q.a
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? this : (b2) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            d.a.p0.h3.h0.n nVar = this.G2;
            if (nVar != null) {
                return nVar.f() ? this.G2.g() ? AdvertAppInfo.p4 : AdvertAppInfo.q4 : this.G2.g() ? AdvertAppInfo.p4 : AdvertAppInfo.o4;
            } else if (f0()) {
                if (l1() != null) {
                    return l3;
                }
                return O2;
            } else {
                int m0 = m0();
                if (this.y1 == 1) {
                    if (this.z1 != null) {
                        return c3;
                    }
                    return this.C1 != null ? w3 : v3;
                } else if (this.s0 != null && this.Z == 60) {
                    return o3;
                } else {
                    if (this.s0 != null && ((i2 = this.Z) == 49 || i2 == 69)) {
                        return m3;
                    }
                    if (this.s0 != null && this.Z == 67) {
                        return p3;
                    }
                    int i4 = this.Z;
                    if (i4 == 51) {
                        return n3;
                    }
                    if (i4 == 63) {
                        return x3;
                    }
                    if (i4 == 64) {
                        return y3;
                    }
                    if (m0 != 2 && m0 != 1) {
                        if (this.p0 != null && S1() && !W1()) {
                            return D3;
                        }
                        if (this.p0 != null && !W1()) {
                            if (Q1()) {
                                return u3;
                            }
                            if (this instanceof x0) {
                                return E3;
                            }
                            return l3;
                        } else if (this.v1 && (originalThreadInfo = this.u1) != null) {
                            if (originalThreadInfo.u) {
                                if (originalThreadInfo.r != null) {
                                    return t3;
                                }
                                if (originalThreadInfo.d()) {
                                    return s3;
                                }
                                return r3;
                            }
                            return q3;
                        } else if (E1()) {
                            return d3;
                        } else {
                            if (U1()) {
                                return A3.get() ? H3 : O2;
                            } else if (B1() && q() == 1) {
                                return A3.get() ? I3 : O2;
                            } else if (V1()) {
                                return j3;
                            } else {
                                if (Q1()) {
                                    return k3;
                                }
                                if (this.f52586e) {
                                    return U2;
                                }
                                if (this.f52587f) {
                                    return V2;
                                }
                                if (this.f52588g) {
                                    return W2;
                                }
                                if (this.f52589h) {
                                    return X2;
                                }
                                if (this.f52590i) {
                                    return Y2;
                                }
                                if (this.k) {
                                    return a3;
                                }
                                if (this.l) {
                                    return b3;
                                }
                                if (this.j) {
                                    return Z2;
                                }
                                if (this.m) {
                                    return f3;
                                }
                                if (this.B0) {
                                    int N22 = N2();
                                    if (N22 == 1) {
                                        return Q2;
                                    }
                                    if (N22 == 2) {
                                        return R2;
                                    }
                                    if (N22 > 2) {
                                        return S2;
                                    }
                                    return O2;
                                }
                                return O2;
                            }
                        }
                    }
                    return N2;
                }
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            VideoInfo videoInfo = this.p0;
            if (videoInfo != null) {
                return videoInfo.video_url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) ? this.W : invokeV.intValue;
    }

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) ? this.L1 : (String) invokeV.objValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? u2() && !StringUtils.isNull(this.Q) && this.W1 : invokeV.booleanValue;
    }

    public void h3(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, metaData) == null) {
            this.P = metaData;
        }
    }

    public void h4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, str) == null) {
            this.A1 = str;
        }
    }

    public int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) ? this.K : invokeV.intValue;
    }

    public List<ThreadRecommendInfoData> i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) ? this.K2 : (List) invokeV.objValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this.J1 : invokeV.booleanValue;
    }

    public void i3(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, baijiahaoData) == null) {
            this.l2 = baijiahaoData;
        }
    }

    public void i4(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, hashMap) == null) {
            this.i0 = hashMap;
        }
    }

    @Override // d.a.o0.r.q.a
    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) ? this.V1 : invokeV.booleanValue;
    }

    public SpannableString j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? this.y : (SpannableString) invokeV.objValue;
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? this.q : invokeV.intValue;
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) ? this.Z : invokeV.intValue;
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) {
            int i2 = this.Z;
            return i2 == 63 || i2 == 64;
        }
        return invokeV.booleanValue;
    }

    public void j3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048767, this, i2) == null) {
            this.H0 = i2;
        }
    }

    public void j4(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, videoInfo) == null) {
            this.p0 = videoInfo;
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) ? this.S0 : invokeV.booleanValue;
    }

    public i2 k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) ? this.r0 : (i2) invokeV.objValue;
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) ? this.U1 : invokeV.booleanValue;
    }

    public void k3(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048772, this, j) == null) {
            this.k1.diffAgreeNum = j;
        }
    }

    public void k4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048773, this, i2) == null) {
            this.H = i2;
        }
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) ? this.L : invokeV.intValue;
    }

    public VideoInfo l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? this.p0 : (VideoInfo) invokeV.objValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.V == 1 : invokeV.booleanValue;
    }

    public void l3(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048777, this, j) == null) {
            this.B = j;
        }
    }

    public void l4(ArrayList<VoiceData$VoiceModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, arrayList) == null) {
            this.U = arrayList;
        }
    }

    public int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) ? this.J : invokeV.intValue;
    }

    public VideoDesc m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) ? this.q0 : (VideoDesc) invokeV.objValue;
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? m0() != 0 : invokeV.booleanValue;
    }

    public void m3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048782, this, str) == null) {
            this.D = str;
        }
    }

    public void m4(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048783, this, j) == null) {
            this.v0 = j;
        }
    }

    public Item n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048784, this)) == null) ? this.u2 : (Item) invokeV.objValue;
    }

    public String n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048785, this)) == null) {
            if (!StringUtils.isNull(this.A) && !"0".equals(this.A)) {
                return this.A;
            }
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) ? this.y1 == 1 : invokeV.booleanValue;
    }

    public void n3(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048787, this, list) == null) {
            this.v = list;
        }
    }

    public void n4(List<PbGoodsData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048788, this, list) == null) {
            this.s2 = list;
            if (ListUtils.isEmpty(list) || this.t2) {
                return;
            }
            this.t2 = true;
        }
    }

    public ArrayList<b> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048789, this)) == null) ? this.C0 : (ArrayList) invokeV.objValue;
    }

    public List<HeadItem> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) ? this.w2 : (List) invokeV.objValue;
    }

    public SpannableStringBuilder o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) ? this.x : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) ? this.F1 != null : invokeV.booleanValue;
    }

    public void o3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048793, this, z) == null) {
            this.O0 = z;
        }
    }

    public final d.a.c.k.b o4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048794, this, str)) == null) {
            if (str == null) {
                return null;
            }
            if (str.length() > 4) {
                str = str.substring(0, 4);
            }
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(R.layout.thread_category, (ViewGroup) null);
            if (inflate == null) {
                return null;
            }
            TextView textView = (TextView) inflate.findViewById(R.id.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0106_1));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                return new d.a.c.k.b(bitmapDrawable, 1);
            }
            return null;
        }
        return (d.a.c.k.b) invokeL.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048795, this)) == null) {
            if (!B1() || this.C0.size() < 1) {
                return -1;
            }
            b bVar = this.C0.get(0);
            int e2 = bVar.e();
            if (e2 == 3) {
                return e2;
            }
            int b2 = bVar.b();
            int c2 = bVar.c();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < b2) {
                return 4;
            }
            return currentTimeMillis > c2 ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public long p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) ? this.Z0 : invokeV.longValue;
    }

    public PostData p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) ? this.l1 : (PostData) invokeV.objValue;
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048798, this)) == null) {
            BaijiahaoData baijiahaoData = this.l2;
            if (baijiahaoData == null) {
                return false;
            }
            return UtilHelper.isUgcThreadType(baijiahaoData.oriUgcType);
        }
        return invokeV.booleanValue;
    }

    public void p3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, str) == null) {
            this.Q = str;
        }
    }

    public void p4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048800, this, i2) == null) {
            this.q = i2;
        }
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) {
            if (!B1() || this.C0.size() < 1 || this.C0.get(0) == null) {
                return -1;
            }
            return this.C0.get(0).a();
        }
        return invokeV.intValue;
    }

    public long q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) ? this.I : invokeV.longValue;
    }

    public f2 q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048803, this)) == null) ? this.N : (f2) invokeV.objValue;
    }

    public boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) {
            int i2 = this.Z;
            return i2 == 40 || i2 == 50;
        }
        return invokeV.booleanValue;
    }

    public void q3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048805, this, z) == null) {
            this.X1 = z;
        }
    }

    public void q4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048806, this) == null) && this.y0 == 0) {
            this.y0 = 1;
        }
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048807, this)) == null) ? this.j0 : (String) invokeV.objValue;
    }

    public TopicModule r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048808, this)) == null) ? this.z1 : (TopicModule) invokeV.objValue;
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048809, this)) == null) ? q2() && u2() : invokeV.booleanValue;
    }

    public void r3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048810, this, z) == null) {
            this.V1 = z;
        }
    }

    public String s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048811, this)) == null) ? this.L0 : (String) invokeV.objValue;
    }

    public String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048812, this)) == null) ? this.B1 : (String) invokeV.objValue;
    }

    public boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048813, this)) == null) ? this.Z == 11 || this.Y == 1 : invokeV.booleanValue;
    }

    public void s3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048814, this, str) == null) {
            this.i1 = str;
        }
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048815, this)) == null) ? (!B1() || this.C0.size() < 1 || this.C0.get(0) == null) ? "" : this.C0.get(0).g() : (String) invokeV.objValue;
    }

    public String t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048816, this)) == null) ? this.P0 : (String) invokeV.objValue;
    }

    public String t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048817, this)) == null) ? this.A1 : (String) invokeV.objValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048818, this)) == null) ? this.Z == 36 : invokeV.booleanValue;
    }

    public void t3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048819, this, i2) == null) {
            this.k1.hasAgree = i2 == 1;
        }
    }

    public String u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048820, this)) == null) ? this.K1 : (String) invokeV.objValue;
    }

    public HashMap<String, MetaData> u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048821, this)) == null) ? this.i0 : (HashMap) invokeV.objValue;
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048822, this)) == null) {
            WorksInfoData worksInfoData = this.I2;
            return worksInfoData != null && worksInfoData.isWorks;
        }
        return invokeV.booleanValue;
    }

    public void u3(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, videoInfo) == null) {
            this.C1 = videoInfo;
        }
    }

    public List<PbLinkData> v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048824, this)) == null) ? this.r2 : (List) invokeV.objValue;
    }

    public int v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048825, this)) == null) {
            if (G1() || F1()) {
                return 2;
            }
            return (E1() || H1()) ? 3 : 1;
        }
        return invokeV.intValue;
    }

    public boolean v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048826, this)) == null) ? this.u0 != 0 : invokeV.booleanValue;
    }

    public void v3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048827, this, str) == null) {
            this.z = str;
        }
    }

    public ActivityItemData w() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048828, this)) == null) {
            List<PbContent> list = this.t;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int size = this.t.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = this.t.get(i2);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && q2() && (str = pbContent.text) != null && str.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = d.a.o0.p0.b.d(pbContent.text);
                    String str2 = pbContent.text;
                    activityItemData.activity_name = str2.substring(1, str2.length() - 2);
                    return activityItemData;
                }
            }
            return null;
        }
        return (ActivityItemData) invokeV.objValue;
    }

    public q0 w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048829, this)) == null) ? this.n1 : (q0) invokeV.objValue;
    }

    public int w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048830, this)) == null) ? this.H : invokeV.intValue;
    }

    public SpannableString w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048831, this)) == null) {
            SpannableStringBuilder z2 = z2();
            d.a.p0.a0.m.b(this, z2, false);
            return new SpannableString(z2);
        }
        return (SpannableString) invokeV.objValue;
    }

    public void w3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048832, this, i2) == null) {
            this.c1 = i2 + 1;
        }
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048833, this)) == null) ? this.S : (String) invokeV.objValue;
    }

    public String x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048834, this)) == null) ? this.k0 : (String) invokeV.objValue;
    }

    public ArrayList<VoiceData$VoiceModel> x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048835, this)) == null) ? this.U : (ArrayList) invokeV.objValue;
    }

    public SpannableString x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048836, this)) == null) {
            if (ListUtils.isEmpty(this.v)) {
                return null;
            }
            return new SpannableString(d.a.o0.b1.m.e.x(this, this.v, this.s));
        }
        return (SpannableString) invokeV.objValue;
    }

    public void x3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048837, this, i2) == null) {
        }
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048838, this)) == null) ? this.l0 : (String) invokeV.objValue;
    }

    public String y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048839, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public o2 y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048840, this)) == null) ? this.D0 : (o2) invokeV.objValue;
    }

    public void y2(WriteData writeData) {
        String j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048841, this, writeData) == null) || writeData == null) {
            return;
        }
        try {
            this.z = "0";
            this.A = "";
            this.B = d.a.c.e.m.b.f(writeData.getForumId(), 0L);
            this.r = writeData.getTitle();
            this.v0 = System.currentTimeMillis() / 1000;
            String str = (System.currentTimeMillis() / 1000) + "";
            this.I = System.currentTimeMillis() / 1000;
            MetaData metaData = new MetaData();
            this.P = metaData;
            metaData.parseFromCurrentUser();
            this.O = TbadkCoreApplication.getCurrentAccount();
            this.Q = writeData.getForumName();
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
            if (d.a.c.e.p.k.isEmpty(d.a.p0.h3.q0.a.g().j())) {
                j = writeData.getVideoInfo().getThumbPath();
            } else {
                j = d.a.p0.h3.q0.a.g().j();
            }
            builder.thumbnail_url = j;
            builder.video_url = writeData.getVideoInfo().getVideoUrl();
            this.p0 = builder.build(true);
            this.Z = 40;
            System.currentTimeMillis();
            this.q = writeData.isNoTitle() ? 1 : 0;
            this.s = writeData.getContent();
            x1 x1Var = new x1();
            this.C = x1Var;
            x1Var.f52814a = writeData.getForumId();
            this.C.f52815b = writeData.getForumName();
            this.o2 = writeData.getTabId();
            this.p2 = writeData.getTabName();
            O2();
            if (StringUtils.isNull(writeData.getItem_id()) || writeData.getItemInfo() == null) {
                return;
            }
            Item.Builder builder2 = new Item.Builder();
            builder2.icon_size = Double.valueOf(writeData.getItemInfo().getIconSize());
            builder2.icon_url = writeData.getItemInfo().getIconUrl();
            builder2.item_name = writeData.getItemInfo().getTitle();
            builder2.tags = writeData.getItemInfo().getTags();
            builder2.score = Double.valueOf(writeData.getItemInfo().getScore());
            builder2.star = Integer.valueOf(writeData.getItemInfo().getStar());
            this.u2 = builder2.build(true);
            ItemData itemData = new ItemData();
            this.v2 = itemData;
            itemData.parseItemInfo(writeData.getItemInfo());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void y3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048842, this, z) == null) {
            this.b1 = z;
        }
    }

    public AgreeData z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048843, this)) == null) ? this.k1 : (AgreeData) invokeV.objValue;
    }

    public ArrayList<MediaData> z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048844, this)) == null) ? this.T : (ArrayList) invokeV.objValue;
    }

    public void z1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048845, this) == null) || ListUtils.getCount(this.w2) <= 0) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.x;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) d.a.o0.b1.m.e.f(this.w2));
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.y);
        spannableStringBuilder2.insert(0, (CharSequence) d.a.o0.b1.m.e.f(this.w2));
        this.y = new SpannableString(spannableStringBuilder2);
    }

    public SpannableStringBuilder z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048846, this)) == null) ? d.a.o0.b1.m.e.x(this, this.u, this.s) : (SpannableStringBuilder) invokeV.objValue;
    }

    public void z3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048847, this, i2) == null) {
            this.W = i2;
        }
    }
}
