package d.a.n0.r.q;

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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidubce.services.vod.VodClient;
import com.bumptech.glide.load.engine.GlideException;
import d.a.o0.z.m;
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
/* loaded from: classes3.dex */
public class a2 extends a implements PreLoadImageProvider, d.a.c.k.e.n, IVideoData {
    public int A0;
    public String A1;
    public String A2;
    public VideoInfo B1;
    public String B2;
    public w1 C;
    public String D;
    public boolean D1;
    public String E;
    public OriginalForumInfo E1;
    public int E2;
    public t F0;
    public boolean F1;
    public d.a.o0.e3.h0.n F2;
    public boolean G1;
    public int G2;
    public SmartApp H1;
    public WorksInfoData H2;
    public int I2;
    public String J1;
    public String K1;
    public String L1;
    public String M1;
    public SkinInfo N0;
    public String N1;
    public String O;
    public boolean O0;
    public int O1;
    public String P0;
    public String P1;
    public String Q1;
    public boolean S0;
    public String T0;
    public boolean T1;
    public String U0;
    public boolean U1;
    public int V;
    public String V0;
    public boolean V1;
    public String W0;
    public boolean W1;
    public String X0;
    public boolean X1;
    public int Y;
    public long Y0;
    public boolean Y1;
    public int Z;
    public boolean Z1;
    public boolean a2;
    public boolean b2;
    public String c0;
    public boolean c1;
    public boolean c2;
    public String d2;
    public boolean e2;
    public String f2;
    public String h1;
    public String h2;
    public HashMap<String, MetaData> i0;
    public boolean i1;
    public String i2;
    public String j0;
    public int j2;
    public String k0;
    public BaijiahaoData k2;
    public String l0;
    public long l1;
    public p0 m1;
    public String m2;
    public int n0;
    public boolean n1;
    public int n2;
    public String o2;
    public VideoInfo p0;
    public g p1;
    public ThreadInfo p2;
    public int q;
    public VideoDesc q0;
    public MediaData q1;
    public h2 r0;
    public int r1;
    public AlaInfoData s0;
    public boolean s2;
    public OriginalThreadInfo t1;
    public Item t2;
    public boolean u1;
    public ItemData u2;
    public long v0;
    public List<HeadItem> v2;
    public SpannableStringBuilder w;
    public long w0;
    public ItemStarData w2;
    public SpannableStringBuilder x;
    public PollData x2;
    public SpannableString y;
    public TopicModule y1;
    public String z1;
    public String z2;
    public static final BdUniqueId L2 = BdUniqueId.gen();
    public static final BdUniqueId M2 = BdUniqueId.gen();
    public static final BdUniqueId N2 = BdUniqueId.gen();
    public static final BdUniqueId O2 = BdUniqueId.gen();
    public static final BdUniqueId P2 = BdUniqueId.gen();
    public static final BdUniqueId Q2 = BdUniqueId.gen();
    public static final BdUniqueId R2 = BdUniqueId.gen();
    public static final BdUniqueId S2 = BdUniqueId.gen();
    public static final BdUniqueId T2 = BdUniqueId.gen();
    public static final BdUniqueId U2 = BdUniqueId.gen();
    public static final BdUniqueId V2 = BdUniqueId.gen();
    public static final BdUniqueId W2 = BdUniqueId.gen();
    public static final BdUniqueId X2 = BdUniqueId.gen();
    public static final BdUniqueId Y2 = BdUniqueId.gen();
    public static final BdUniqueId Z2 = BdUniqueId.gen();
    public static final BdUniqueId a3 = BdUniqueId.gen();
    public static final BdUniqueId b3 = BdUniqueId.gen();
    public static final BdUniqueId c3 = BdUniqueId.gen();
    public static final BdUniqueId d3 = BdUniqueId.gen();
    public static final BdUniqueId e3 = BdUniqueId.gen();
    public static final BdUniqueId f3 = BdUniqueId.gen();
    public static final BdUniqueId g3 = BdUniqueId.gen();
    public static final BdUniqueId h3 = BdUniqueId.gen();
    public static final BdUniqueId i3 = BdUniqueId.gen();
    public static final BdUniqueId j3 = BdUniqueId.gen();
    public static final BdUniqueId k3 = BdUniqueId.gen();
    public static final BdUniqueId l3 = BdUniqueId.gen();
    public static final BdUniqueId m3 = BdUniqueId.gen();
    public static final BdUniqueId n3 = BdUniqueId.gen();
    public static final BdUniqueId o3 = BdUniqueId.gen();
    public static final BdUniqueId p3 = BdUniqueId.gen();
    public static final BdUniqueId q3 = BdUniqueId.gen();
    public static final BdUniqueId r3 = BdUniqueId.gen();
    public static final BdUniqueId s3 = BdUniqueId.gen();
    public static final BdUniqueId t3 = BdUniqueId.gen();
    public static final BdUniqueId u3 = BdUniqueId.gen();
    public static final BdUniqueId v3 = BdUniqueId.gen();
    public static final BdUniqueId w3 = BdUniqueId.gen();
    public static final BdUniqueId x3 = BdUniqueId.gen();
    public static AtomicBoolean y3 = new AtomicBoolean(false);
    public static AtomicBoolean z3 = new AtomicBoolean(false);
    public static AtomicBoolean A3 = new AtomicBoolean(false);
    public static final BdUniqueId B3 = BdUniqueId.gen();
    public static final BdUniqueId C3 = BdUniqueId.gen();
    public static HashMap<Point, Integer> D3 = new HashMap<>();
    public static HashMap<Integer, Integer> E3 = new HashMap<>();
    public static final BdUniqueId F3 = BdUniqueId.gen();
    public static final BdUniqueId G3 = BdUniqueId.gen();
    public static HashMap<Point, Integer> H3 = new HashMap<>();
    public static SparseArray<m.a> I3 = new SparseArray<>(3);

    /* renamed from: e  reason: collision with root package name */
    public boolean f53712e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53713f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53714g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53715h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53716i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public int n = 0;
    public String o = "1";
    public int p = 1;
    public String X = null;
    public int y0 = 0;
    public String z0 = "";
    public boolean B0 = false;
    public String G0 = "";
    public boolean Z0 = true;
    public boolean d1 = false;
    public int e1 = -1;
    public SparseArray<String> f1 = null;
    public SparseArray<String> g1 = null;
    public boolean o1 = false;
    public int x1 = 0;
    public boolean C1 = false;
    public boolean I1 = false;
    public boolean R1 = false;
    public boolean S1 = false;
    public boolean g2 = false;
    public boolean l2 = false;
    public boolean C2 = false;
    public boolean D2 = false;
    public String K2 = "";
    public String z = null;
    public String A = null;
    public long B = 0;
    public String r = null;
    public int u0 = 0;
    public int G = 0;
    public int H = 0;
    public long I = 0;
    public int J = 0;
    public int K = 0;
    public int L = 0;
    public int M = 0;
    public e2 N = new e2();
    public MetaData P = new MetaData();
    public String Q = null;
    public ArrayList<MediaData> T = new ArrayList<>();
    public ArrayList<VoiceData$VoiceModel> U = new ArrayList<>();
    public int R = 0;
    public String S = null;
    public String s = null;
    public int W = 0;
    public PraiseData a0 = new PraiseData();
    public AnchorInfoData b0 = new AnchorInfoData();
    public int m0 = 0;
    public ArrayList<b> C0 = new ArrayList<>();
    public m2 D0 = null;
    public h E0 = null;
    public ArrayList<d.a.n0.s.i.c> o0 = new ArrayList<>();
    public int H0 = 0;
    public int t0 = 0;
    public int Q0 = 0;
    public q R0 = new q();
    public List<PbContent> v = new ArrayList();
    public List<PbContent> t = new ArrayList();
    public List<PbContent> u = new ArrayList();
    public String F = null;
    public y1 I0 = new y1();
    public ArrayList<d.a.n0.t.c> J0 = new ArrayList<>();
    public PushStatusData K0 = new PushStatusData();
    public boolean a1 = false;
    public int b1 = -1;
    public PostData k1 = new PostData();
    public AgreeData j1 = new AgreeData();
    public int s1 = 0;
    public String x0 = "";
    public String w1 = "";
    public String v1 = "";
    public String L0 = "";
    public String M0 = "";
    public List<PbLinkData> q2 = new ArrayList();
    public List<PbGoodsData> r2 = new ArrayList();
    public List<ThreadRecommendInfoData> J2 = new ArrayList();
    public int y2 = -1;

    static {
        D3.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        D3.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        D3.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        D3.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        D3.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        D3.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        D3.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        D3.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        H3.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        H3.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        H3.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        H3.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        H3.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        H3.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        H3.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        H3.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        E3.put(1, Integer.valueOf(R.drawable.label_interview_no));
        E3.put(2, Integer.valueOf(R.drawable.label_interview_live));
        E3.put(3, Integer.valueOf(R.drawable.label_interview_off));
        I3.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        I3.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        I3.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public a2() {
        this.V = 0;
        this.n0 = 0;
        this.r1 = 0;
        this.A0 = 0;
        this.A0 = 0;
        this.n0 = 0;
        this.V = 0;
        this.r1 = 0;
    }

    public boolean A() {
        return false;
    }

    public List<HeadItem> A0() {
        return this.v2;
    }

    public String A1() {
        return this.r;
    }

    public boolean A2() {
        return this.x1 == 1;
    }

    public void A3(List<PbContent> list) {
        this.v = list;
    }

    public final d.a.c.k.b A4(String str) {
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

    public SpannableString B(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
        Bitmap bitmap = SkinManager.getBitmap(R.drawable.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        d.a.n0.r.f0.j jVar = new d.a.n0.r.f0.j(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String p = d.a.n0.r.d0.b.j().p("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(p)) {
            p = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(p);
        if (T() != null) {
            if (T().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (T().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(jVar, 0, 6, 17);
        spannableString.setSpan(clickableSpan, 6, spannableString.length(), 17);
        return spannableString;
    }

    public long B0() {
        return this.Y0;
    }

    public SpannableStringBuilder B1() {
        return this.x;
    }

    public boolean B2() {
        return this.E1 != null;
    }

    public void B3(boolean z) {
        this.O0 = z;
    }

    public void B4(int i2) {
        this.q = i2;
    }

    public String C() {
        return this.s;
    }

    public long C0() {
        return this.I;
    }

    public PostData C1() {
        return this.k1;
    }

    public boolean C2() {
        BaijiahaoData baijiahaoData = this.k2;
        if (baijiahaoData == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(baijiahaoData.oriUgcType);
    }

    public void C3(String str) {
        this.Q = str;
    }

    public void C4() {
        if (this.y0 == 0) {
            this.y0 = 1;
        }
    }

    public SpannableString D() {
        return this.y;
    }

    public String D0() {
        return this.j0;
    }

    public e2 D1() {
        return this.N;
    }

    public boolean D2() {
        int i2 = this.Z;
        return i2 == 40 || i2 == 50;
    }

    public void D3(boolean z) {
        this.W1 = z;
    }

    public ArrayList<b> E() {
        return this.C0;
    }

    public String E0() {
        return this.L0;
    }

    public TopicModule E1() {
        return this.y1;
    }

    public boolean E2() {
        return D2() && H2();
    }

    public void E3(boolean z) {
        this.U1 = z;
    }

    public int F() {
        if (!O1() || this.C0.size() < 1) {
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

    public String F0() {
        return this.P0;
    }

    public String F1() {
        return this.A1;
    }

    public boolean F2() {
        return this.Z == 11 || this.Y == 1;
    }

    public void F3(String str) {
        this.h1 = str;
    }

    public int G() {
        if (!O1() || this.C0.size() < 1 || this.C0.get(0) == null) {
            return -1;
        }
        return this.C0.get(0).a();
    }

    public String G0() {
        return this.J1;
    }

    public String G1() {
        return this.z1;
    }

    public boolean G2() {
        return this.Z == 36;
    }

    public void G3(int i2) {
        this.j1.hasAgree = i2 == 1;
    }

    public String H() {
        return (!O1() || this.C0.size() < 1 || this.C0.get(0) == null) ? "" : this.C0.get(0).g();
    }

    public List<PbLinkData> H0() {
        return this.q2;
    }

    public HashMap<String, MetaData> H1() {
        return this.i0;
    }

    public boolean H2() {
        WorksInfoData worksInfoData = this.H2;
        return worksInfoData != null && worksInfoData.isWorks;
    }

    public void H3(VideoInfo videoInfo) {
        this.B1 = videoInfo;
    }

    public ActivityItemData I() {
        String str;
        List<PbContent> list = this.t;
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = this.t.size();
        for (int i2 = 0; i2 < size; i2++) {
            PbContent pbContent = this.t.get(i2);
            if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && D2() && (str = pbContent.text) != null && str.length() >= 3) {
                ActivityItemData activityItemData = new ActivityItemData();
                activityItemData.link_url = d.a.n0.p0.b.d(pbContent.text);
                String str2 = pbContent.text;
                activityItemData.activity_name = str2.substring(1, str2.length() - 2);
                return activityItemData;
            }
        }
        return null;
    }

    public p0 I0() {
        return this.m1;
    }

    public int I1() {
        if (T1() || S1()) {
            return 2;
        }
        return (R1() || U1()) ? 3 : 1;
    }

    public boolean I2() {
        return this.u0 != 0;
    }

    public void I3(String str) {
        this.z = str;
    }

    public String J() {
        return this.S;
    }

    public String J0() {
        return this.k0;
    }

    public int J1() {
        return this.H;
    }

    public SpannableString J2() {
        SpannableStringBuilder M22 = M2();
        d.a.o0.z.m.b(this, M22, false);
        return new SpannableString(M22);
    }

    public void J3(int i2) {
        this.b1 = i2 + 1;
    }

    public String K() {
        return this.l0;
    }

    public String K0() {
        return this.X;
    }

    public ArrayList<VoiceData$VoiceModel> K1() {
        return this.U;
    }

    public SpannableString K2() {
        if (ListUtils.isEmpty(this.v)) {
            return null;
        }
        return new SpannableString(d.a.n0.b1.m.e.w(this, this.v, this.s));
    }

    public void K3(int i2) {
    }

    public AgreeData L() {
        return this.j1;
    }

    public ArrayList<MediaData> L0() {
        return this.T;
    }

    public m2 L1() {
        return this.D0;
    }

    public void L2(WriteData writeData) {
        String i2;
        if (writeData == null) {
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
            if (d.a.c.e.p.k.isEmpty(d.a.o0.e3.q0.a.f().i())) {
                i2 = writeData.getVideoInfo().getThumbPath();
            } else {
                i2 = d.a.o0.e3.q0.a.f().i();
            }
            builder.thumbnail_url = i2;
            builder.video_url = writeData.getVideoInfo().getVideoUrl();
            this.p0 = builder.build(true);
            this.Z = 40;
            System.currentTimeMillis();
            this.q = writeData.isNoTitle() ? 1 : 0;
            this.s = writeData.getContent();
            w1 w1Var = new w1();
            this.C = w1Var;
            w1Var.f53940a = writeData.getForumId();
            this.C.f53941b = writeData.getForumName();
            this.n2 = writeData.getTabId();
            this.o2 = writeData.getTabName();
            b3();
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
            this.t2 = builder2.build(true);
            ItemData itemData = new ItemData();
            this.u2 = itemData;
            itemData.parseItemInfo(writeData.getItemInfo());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void L3(boolean z) {
        this.a1 = z;
    }

    public long M() {
        return this.j1.agreeNum;
    }

    public String M0() {
        return this.Q1;
    }

    public void M1() {
        if (ListUtils.getCount(this.v2) > 0) {
            SpannableStringBuilder spannableStringBuilder = this.x;
            if (spannableStringBuilder != null) {
                spannableStringBuilder.insert(0, (CharSequence) d.a.n0.b1.m.e.f(this.v2));
                return;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.y);
            spannableStringBuilder2.insert(0, (CharSequence) d.a.n0.b1.m.e.f(this.v2));
            this.y = new SpannableString(spannableStringBuilder2);
        }
    }

    public SpannableStringBuilder M2() {
        return d.a.n0.b1.m.e.w(this, this.u, this.s);
    }

    public void M3(int i2) {
        this.W = i2;
    }

    public int N() {
        return this.j1.agreeType;
    }

    public int N0() {
        return this.n0;
    }

    public void N1(SpannableString spannableString) {
        if (T() == null || x() || y()) {
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

    public SpannableStringBuilder N2() {
        return d.a.n0.b1.m.e.w(this, this.t, this.r);
    }

    public void N3(boolean z) {
        this.T1 = z;
    }

    public AnchorInfoData O() {
        return this.b0;
    }

    public String O0() {
        return this.o;
    }

    public boolean O1() {
        return this.m0 == 1;
    }

    public void O2(ArrayList<u> arrayList) {
        if (this.q == 1 || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<u> it = arrayList.iterator();
        while (it.hasNext()) {
            u next = it.next();
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

    public void O3() {
        this.x1 = 1;
    }

    public int P() {
        return this.t0;
    }

    public PollData P0() {
        return this.x2;
    }

    public boolean P1() {
        return (T() == null || T().getAlaUserData() == null || T().getAlaUserData().live_status != 1) ? false : true;
    }

    public SpannableStringBuilder P2() {
        if (StringUtils.isNull(this.r) || this.q == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(N2());
        this.w = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public void P3(int i2) {
        this.L = i2;
    }

    public h Q() {
        return this.E0;
    }

    public int Q0() {
        return this.A0;
    }

    public boolean Q1() {
        String userId;
        MetaData metaData = this.P;
        return metaData == null || (userId = metaData.getUserId()) == null || userId.equals("0");
    }

    public SpannableStringBuilder Q2(boolean z, boolean z2) {
        return R2(z, z2, false);
    }

    public void Q3(int i2) {
        this.J = i2;
    }

    public String R() {
        return this.i2;
    }

    public PraiseData R0() {
        return this.a0;
    }

    public boolean R1() {
        BaijiahaoData baijiahaoData = this.k2;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
    }

    public SpannableStringBuilder R2(boolean z, boolean z2, boolean z4) {
        SpannableStringBuilder N22;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.q == 1) {
            N22 = M2();
            spannableStringBuilder = N22.toString();
        } else {
            N22 = N2();
            spannableStringBuilder = N22.toString();
        }
        SpannableStringBuilder spannableStringBuilder3 = N22;
        String str = spannableStringBuilder;
        if (z) {
            spannableStringBuilder2 = z(str, spannableStringBuilder3, z, true, z2, z4);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder3);
        }
        this.w = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public void R3(Item item) {
        this.t2 = item;
    }

    public long S() {
        return this.w0;
    }

    public ArrayList<d.a.n0.b1.m.b> S0() {
        ArrayList<d.a.n0.b1.m.b> arrayList = new ArrayList<>();
        if (this.l2) {
            arrayList.add(new d.a.n0.b1.m.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public boolean S1() {
        BaijiahaoData baijiahaoData = this.k2;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 3;
    }

    public SpannableStringBuilder S2(boolean z, boolean z2) {
        SpannableStringBuilder M22;
        if (!StringUtils.isNull(this.r) && this.q != 1) {
            M22 = N2();
        } else {
            M22 = M2();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(M22);
        this.w = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public void S3(ItemData itemData) {
        this.u2 = itemData;
    }

    public MetaData T() {
        return this.P;
    }

    public final ArrayList<m.a> T0(boolean z, boolean z2, boolean z4, boolean z5) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean I2 = I2();
        if (z2) {
            if (z) {
                if (I2 && !D2()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (s0() == 1 || v1() == 33 || (D1() != null && D1().a() != 0)) {
                    if (q1() == null || !g2()) {
                        if (!I2) {
                            arrayList.add(new m.a(R.string.photo_live_tips));
                        }
                    } else if (r1() == 2) {
                        arrayList.add(new m.a(R.string.interview_live));
                    }
                }
                if (g2()) {
                    arrayList.add(I3.get(r1()));
                }
                if (O1()) {
                    Integer num = H3.get(new Point(G(), F()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (L1() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!d.a.c.e.p.k.isEmpty(X())) {
                    arrayList.add(new m.a(X()));
                }
            } else {
                if (I2 && y0() != 1 && !D2()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((s0() == 1 || v1() == 33) && !g2() && !I2) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (x0() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (y0() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (g2() && q1() != null && r1() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (O1()) {
                    Integer num2 = H3.get(new Point(G(), F()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.Q0 == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (Q() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (L1() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!d.a.c.e.p.k.isEmpty(X())) {
                    arrayList.add(new m.a(X()));
                }
                if (z4 && l2()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z4 && k2()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (s2()) {
                    arrayList.add(new m.a(R.string.video_title_str));
                }
                if (z5) {
                    arrayList.add(new m.a(R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public boolean T1() {
        BaijiahaoData baijiahaoData = this.k2;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T2(boolean z, boolean z2) {
        d.a.c.k.b bVar;
        SpannableStringBuilder N22;
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        if (!z2) {
            if (v1() == 42 && X1()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (y0() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (y0() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (s0() == 1 || this.N.a() != 0) {
                if (q1() != null && v1() == 41) {
                    if (r1() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && g2()) {
                Integer num = E3.get(Integer.valueOf(r1()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (x0() == 1 && !z2() && j3 != getType() && s3 != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            AnchorInfoData anchorInfoData = this.b0;
            if (anchorInfoData != null && anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (j1() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = D3.get(new Point(G(), F()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (L1() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (Q() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!d.a.c.e.p.k.isEmpty(this.F)) {
                bVar = A4(this.F);
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
                        d.a.n0.r.f0.i iVar = new d.a.n0.r.f0.i(bitmapDrawable);
                        iVar.b(d.a.c.e.p.l.e(TbadkCoreApplication.getInst().getApplicationContext(), this.p));
                        spannableString.setSpan(iVar, i4, i4 + 1, 33);
                        i4 += 2;
                    }
                    if (bVar != null) {
                        spannableString.setSpan(bVar, i4, this.F.length() + i4, 33);
                    }
                    spannableStringBuilder.append((CharSequence) spannableString);
                }
                N22 = N2();
                if (N22 != null) {
                    spannableStringBuilder.append((CharSequence) N22);
                }
                this.w = spannableStringBuilder;
            }
        }
        bVar = null;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (arrayList.size() > 0) {
        }
        N22 = N2();
        if (N22 != null) {
        }
        this.w = spannableStringBuilder2;
    }

    public void T3(List<HeadItem> list) {
        this.v2 = list;
    }

    public int U() {
        return this.j2;
    }

    public PushStatusData U0() {
        return this.K0;
    }

    public boolean U1() {
        BaijiahaoData baijiahaoData = this.k2;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
    }

    @Deprecated
    public void U2(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
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
            this.l1 = jSONObject.optLong("share_num");
            this.c0 = jSONObject.optString("first_post_id", "0");
            this.z0 = jSONObject.optString("post_id", "0");
            jSONObject.optLong("time", 0L);
            this.q = jSONObject.optInt("is_ntitle");
            this.F = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            this.x0 = jSONObject.optString("tieba_game_information_source", "");
            this.j1.parseJson(jSONObject.optJSONObject("agree"));
            this.j1.threadId = this.A;
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
                this.f1 = sparseArray;
                this.g1 = sparseArray2;
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
            this.K2 = jSONObject.optString("mode_url");
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
                m2 m2Var = new m2();
                this.D0 = m2Var;
                m2Var.c(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
            if (optJSONObject5 != null) {
                h hVar = new h();
                this.E0 = hVar;
                hVar.b(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject6 != null) {
                t tVar = new t();
                this.F0 = tVar;
                tVar.c(optJSONObject6);
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
                    d.a.n0.t.c cVar = new d.a.n0.t.c();
                    cVar.a(optJSONArray6.getJSONObject(i8));
                    this.J0.add(cVar);
                }
            }
            this.Q0 = jSONObject.optInt("is_book_chapter", 0);
            this.R0.a(jSONObject.optJSONObject("book_chapter"));
            this.T0 = jSONObject.optString("recom_source");
            this.X0 = jSONObject.optString("recom_reason");
            this.U0 = jSONObject.optString(TiebaStatic.Params.RECOM_WEIGHT);
            this.W0 = jSONObject.optString(TiebaStatic.Params.RECOM_EXTRA);
            jSONObject.optString("recom_extra_img");
            jSONObject.optString("recom_extra_img_night");
            jSONObject.optInt("recom_extra_img_width", 0);
            jSONObject.optInt("recom_extra_img_height", 0);
            this.Y0 = jSONObject.optLong("last_read_pid");
            this.Z0 = jSONObject.optInt("cheak_repeat") == 1;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
            if (optJSONObject8 != null) {
                h2 h2Var = new h2();
                this.r0 = h2Var;
                h2Var.a(optJSONObject8);
            }
            this.i1 = jSONObject.optInt("is_multiforum_thread") == 1;
            this.n1 = jSONObject.optBoolean("is_link_thread");
            JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
            if (this.n1 && optJSONObject9 != null) {
                p0 p0Var = new p0();
                this.m1 = p0Var;
                p0Var.g(optJSONObject9);
            }
            this.o1 = jSONObject.optInt("is_partial_visible") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
            if (optJSONObject10 != null) {
                g gVar = new g();
                this.p1 = gVar;
                gVar.a(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
            if (optJSONObject11 != null) {
                MediaData mediaData2 = new MediaData();
                this.q1 = mediaData2;
                mediaData2.parserJson(optJSONObject11);
            }
            jSONObject.optInt("is_called", 0);
            this.r1 = jSONObject.optInt("middle_page_num", 0);
            this.s1 = jSONObject.optInt("middle_page_pass_flag", 0);
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
            this.u1 = z;
            if (z) {
                JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                if (optJSONObject13 != null) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    this.t1 = originalThreadInfo;
                    originalThreadInfo.l(optJSONObject13);
                } else {
                    this.t1 = null;
                }
            } else {
                this.t1 = null;
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
                this.H1 = builder2.build(false);
            }
            this.P1 = jSONObject.optString("t_share_img");
            this.Q1 = jSONObject.optString("nid");
            this.R1 = jSONObject.optInt("is_headlinepost", 0) == 1;
            jSONObject.optInt(ImageViewerConfig.IS_BJH);
            this.j2 = jSONObject.optInt("bjh_content_tag");
            this.i2 = jSONObject.optString("article_cover");
            JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject15 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.k2 = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject15);
                this.j1.baijiahaoData = this.k2;
            }
            this.l2 = jSONObject.optInt("is_s_card", 0) == 1;
            this.m2 = jSONObject.optString("scard_packet_id");
            this.n2 = jSONObject.optInt("tab_id");
            this.o2 = jSONObject.optString("tab_name");
            jSONObject.optString("wonderful_post_info");
            this.g2 = jSONObject.optInt("if_comment", 0) == 1;
            this.h2 = jSONObject.optString("if_comment_info");
            JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
            if (optJSONObject16 != null) {
                if (this.x2 == null) {
                    this.x2 = new PollData();
                }
                this.x2.parserJson(optJSONObject16);
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
            if (optJSONArray7 != null) {
                for (int i9 = 0; i9 < optJSONArray7.length(); i9++) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseJson(optJSONArray7.getJSONObject(i9));
                    if (pbLinkData.urlType == 2 && !this.s2) {
                        this.s2 = true;
                    }
                    this.q2.add(pbLinkData);
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
            if (optJSONArray8 != null) {
                for (int i10 = 0; i10 < optJSONArray8.length(); i10++) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseJson(optJSONArray8.getJSONObject(i10));
                    this.r2.add(pbGoodsData);
                }
                if (this.r2.size() > 0 && !this.s2) {
                    this.s2 = true;
                }
            }
            this.y2 = jSONObject.optInt("hot_num", -1);
            jSONObject.optInt("is_local");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("works_info");
            if (optJSONObject17 != null) {
                if (this.H2 == null) {
                    this.H2 = new WorksInfoData();
                }
                this.H2.parseJson(optJSONObject17);
            }
            this.I2 = jSONObject.optInt("collect_num");
            JSONArray optJSONArray9 = jSONObject.optJSONArray("thread_recommend_infos");
            if (optJSONArray9 != null) {
                for (int i11 = 0; i11 < optJSONArray9.length(); i11++) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseJson(optJSONArray9.getJSONObject(i11));
                    this.J2.add(threadRecommendInfoData);
                }
            }
            w1 w1Var = new w1();
            this.C = w1Var;
            w1Var.d(jSONObject.optJSONObject("forum_info"));
            this.G2 = jSONObject.optInt("is_author_view");
            jSONObject.optString("scard_packet_id");
            this.G0 = jSONObject.optString("livecover_src");
            JSONArray optJSONArray10 = jSONObject.optJSONArray("rich_abstract");
            if (optJSONArray10 != null) {
                this.u = a1.a(optJSONArray10);
            }
            JSONArray optJSONArray11 = jSONObject.optJSONArray("rich_title");
            if (optJSONArray11 != null) {
                this.t = a1.a(optJSONArray11);
            }
            JSONArray optJSONArray12 = jSONObject.optJSONArray("first_post_content");
            if (optJSONArray12 != null) {
                this.v = a1.a(optJSONArray12);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("star_rank_icon");
            if (optJSONObject18 != null) {
                this.v1 = optJSONObject18.optString("icon_pic_url");
                this.w1 = optJSONObject18.optString("icon_link");
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
                this.E1 = originalForumInfo;
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
                        if (this.v2 == null) {
                            this.v2 = new ArrayList();
                        }
                        this.v2.add(builder3.build(true));
                    }
                }
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("item");
            if (optJSONObject22 != null && 0 != optJSONObject22.optLong(LegoListActivityConfig.ITEM_ID)) {
                Item.Builder builder4 = new Item.Builder();
                builder4.item_id = Long.valueOf(optJSONObject22.optLong(LegoListActivityConfig.ITEM_ID));
                builder4.item_name = optJSONObject22.optString("item_name");
                builder4.icon_size = Double.valueOf(optJSONObject22.optDouble("icon_size"));
                builder4.score = Double.valueOf(optJSONObject22.optDouble("score"));
                builder4.icon_url = optJSONObject22.optString("icon_url");
                builder4.star = Integer.valueOf(optJSONObject22.optInt(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR));
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
                    this.t2 = build2;
                    ItemData itemData = new ItemData();
                    this.u2 = itemData;
                    itemData.parseProto(build2);
                }
            }
            b3();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void U3(long j) {
        this.I = j;
    }

    public BaijiahaoData V() {
        return this.k2;
    }

    public ThreadInfo V0() {
        return this.p2;
    }

    @Deprecated
    public boolean V1() {
        return C2();
    }

    public void V2(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo == null) {
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
                this.j1.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                this.j1.parseProtobuf(threadInfo.agree);
            }
            if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                this.x0 = threadInfo.tieba_game_information_source;
            } else {
                this.x0 = "";
            }
            this.l1 = threadInfo.share_num.longValue();
            this.F = threadInfo.category_name;
            this.n0 = threadInfo.operator_flag.intValue();
            if (threadInfo.is_operate_thread != null) {
                this.S0 = threadInfo.is_operate_thread.intValue() == 1;
            }
            this.t = threadInfo.rich_title;
            this.v = threadInfo.first_post_content;
            this.u = threadInfo.rich_abstract;
            threadInfo.is_godthread_recommend.intValue();
            if ((this.P == null || this.P.getUserId() == null || this.P.getUserId().equals("0") || this.D2) && this.O != null && !this.O.equals("0") && this.i0 != null && (metaData = this.i0.get(this.O)) != null) {
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
                h2 h2Var = new h2();
                this.r0 = h2Var;
                h2Var.b(threadInfo.video_channel_info);
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
                m2 m2Var = new m2();
                this.D0 = m2Var;
                m2Var.d(threadInfo.yule_post_activity);
            }
            if (threadInfo.app_code != null) {
                h hVar = new h();
                this.E0 = hVar;
                hVar.c(threadInfo.app_code);
            }
            if (threadInfo.cartoon_info != null) {
                t tVar = new t();
                this.F0 = tVar;
                tVar.d(threadInfo.cartoon_info);
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
                            d.a.n0.s.i.c cVar = new d.a.n0.s.i.c();
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
                    d.a.n0.t.c cVar2 = new d.a.n0.t.c();
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
            this.U0 = threadInfo.recom_weight;
            this.V0 = threadInfo.ab_tag;
            this.W0 = threadInfo.recom_extra;
            this.Y0 = threadInfo.last_read_pid.longValue();
            this.Z0 = threadInfo.cheak_repeat.intValue() == 1;
            List<ReportInfo> list6 = threadInfo.report_info;
            if (threadInfo.top_agree_post != null) {
                this.k1.b0(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.f1 = sparseArray;
                this.g1 = sparseArray2;
            }
            this.i1 = threadInfo.is_multiforum_thread.intValue() == 1;
            boolean z = threadInfo.is_link_thread.intValue() == 1;
            this.n1 = z;
            if (z && threadInfo.link_info != null) {
                p0 p0Var = new p0();
                this.m1 = p0Var;
                p0Var.h(threadInfo.link_info);
            }
            this.o1 = threadInfo.is_partial_visible.intValue() == 1;
            if (threadInfo.activity_info != null) {
                g gVar = new g();
                this.p1 = gVar;
                gVar.b(threadInfo.activity_info);
            }
            if (threadInfo.pic_info != null) {
                MediaData mediaData2 = new MediaData();
                this.q1 = mediaData2;
                mediaData2.parserProtobuf(threadInfo.pic_info);
            }
            threadInfo.is_called.intValue();
            this.r1 = threadInfo.middle_page_num.intValue();
            this.s1 = threadInfo.middle_page_pass_flag.intValue();
            this.u1 = threadInfo.is_share_thread.intValue() == 1;
            if (threadInfo.star_rank_icon != null) {
                this.v1 = threadInfo.star_rank_icon.icon_pic_url;
                this.w1 = threadInfo.star_rank_icon.icon_link;
            }
            if (threadInfo.origin_thread_info != null) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.t1 = originalThreadInfo;
                originalThreadInfo.j(threadInfo.origin_thread_info);
            } else {
                this.t1 = null;
                this.u1 = false;
            }
            this.x1 = threadInfo.is_topic.intValue();
            this.z1 = threadInfo.topic_user_name;
            this.A1 = threadInfo.topic_h5_url;
            this.y1 = threadInfo.topic_module;
            String str4 = threadInfo.presentation_style;
            this.E1 = OriginalForumInfo.parser(threadInfo.ori_forum_info);
            String str5 = threadInfo.daily_paper_time;
            if (threadInfo.forum_info != null) {
                w1 w1Var = new w1();
                this.C = w1Var;
                w1Var.e(threadInfo.forum_info);
            }
            if (threadInfo.swan_info != null) {
                this.H1 = threadInfo.swan_info;
            }
            this.P1 = threadInfo.t_share_img;
            this.Q1 = threadInfo.nid;
            this.R1 = threadInfo.is_headlinepost.intValue() == 1;
            String str6 = threadInfo.thread_share_link;
            this.i2 = threadInfo.article_cover;
            this.j2 = threadInfo.bjh_content_tag.intValue();
            threadInfo.is_bjh.intValue();
            if (threadInfo.baijiahao != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.k2 = baijiahaoData;
                baijiahaoData.parseProto(threadInfo.baijiahao);
                this.j1.baijiahaoData = this.k2;
            }
            this.l2 = threadInfo.is_s_card.intValue() == 1;
            this.m2 = threadInfo.scard_packet_id;
            this.n2 = threadInfo.tab_id.intValue();
            this.o2 = threadInfo.tab_name;
            String str7 = threadInfo.wonderful_post_info;
            this.g2 = threadInfo.if_comment.intValue() == 1;
            this.h2 = threadInfo.if_comment_info;
            this.p2 = threadInfo;
            if (!ListUtils.isEmpty(threadInfo.pb_link_info)) {
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    if (pbLinkData.urlType == 2 && !this.s2) {
                        this.s2 = true;
                    }
                    this.q2.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(threadInfo.pb_goods_info)) {
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    this.r2.add(pbGoodsData);
                }
                if (this.r2.size() > 0 && !this.s2) {
                    this.s2 = true;
                }
            }
            if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                this.t2 = threadInfo.item;
            }
            if (this.t2 != null) {
                ItemData itemData = new ItemData();
                this.u2 = itemData;
                itemData.parseProto(this.t2);
            }
            List<HeadItem> list8 = threadInfo.item_star;
            this.v2 = list8;
            if (!ListUtils.isEmpty(list8)) {
                ItemStarData itemStarData = new ItemStarData();
                this.w2 = itemStarData;
                itemStarData.parseProto(this.v2);
            }
            if (threadInfo.poll_info != null) {
                if (this.x2 == null) {
                    this.x2 = new PollData();
                }
                this.x2.parserProtobuf(threadInfo.poll_info);
            }
            this.y2 = threadInfo.hot_num.intValue();
            threadInfo.is_local.intValue();
            this.G2 = threadInfo.is_author_view.intValue();
            if (threadInfo.works_info != null) {
                if (this.H2 == null) {
                    this.H2 = new WorksInfoData();
                }
                this.H2.parseProto(threadInfo.works_info);
            }
            b3();
            this.I2 = threadInfo.collect_num.intValue();
            if (ListUtils.isEmpty(threadInfo.thread_recommend_infos)) {
                return;
            }
            for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                threadRecommendInfoData.parseProto(threadRecommendInfo);
                this.J2.add(threadRecommendInfoData);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void V3(List<PbLinkData> list) {
        this.q2 = list;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (PbLinkData pbLinkData : this.q2) {
            if (pbLinkData.urlType == 2 && !this.s2) {
                this.s2 = true;
            }
        }
    }

    public t W() {
        return this.F0;
    }

    public int W0() {
        if (r2()) {
            return 4;
        }
        if (l2() || k2()) {
            return 3;
        }
        if (R1()) {
            return 5;
        }
        if (U1()) {
            return 6;
        }
        if (S1()) {
            return 7;
        }
        if (T1()) {
            return 8;
        }
        if (!this.u1 || this.t1 == null) {
            return s2() ? 2 : 1;
        }
        return 9;
    }

    public boolean W1() {
        return S1() || T1();
    }

    public void W2(boolean z, boolean z2) {
        X2(z, z2, true);
    }

    public void W3(String str) {
        this.X = str;
    }

    public String X() {
        return this.F;
    }

    public String X0() {
        return this.X0;
    }

    public final boolean X1() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void X2(boolean z, boolean z2, boolean z4) {
        SpannableStringBuilder spannableStringBuilder;
        if (ListUtils.getCount(T0(z, z2, z4, false)) > 0) {
            Q2(z, z4);
            return;
        }
        SpannableStringBuilder N22 = N2();
        if (z) {
            spannableStringBuilder = z(N22.toString(), N22, z, z2, z4, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(N22);
        }
        this.w = spannableStringBuilder;
    }

    public void X3(boolean z) {
        this.C1 = z;
    }

    public int Y() {
        return this.H0;
    }

    public String Y0() {
        return this.T0;
    }

    public boolean Y1() {
        return H2();
    }

    public void Y2() {
        T2(false, true);
    }

    public void Y3(boolean z) {
        this.D1 = z;
    }

    public long Z() {
        return this.v0;
    }

    public String Z0() {
        return this.M1;
    }

    public boolean Z1() {
        MetaData metaData = this.P;
        return metaData != null && metaData.isForumBusinessAccount();
    }

    public void Z2() {
        T2(false, false);
    }

    public void Z3(ArrayList<MediaData> arrayList) {
        this.T = arrayList;
    }

    public long a0() {
        return this.j1.disAgreeNum;
    }

    public String a1() {
        return this.N1;
    }

    public boolean a2() {
        return this.O0;
    }

    public int a3() {
        if (!d.a.n0.r.k.c().g() || ListUtils.getCount(L0()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < L0().size(); i2++) {
            MediaData mediaData = (MediaData) ListUtils.getItem(L0(), i2);
            if (mediaData != null && mediaData.getType() == 3) {
                linkedList.add(mediaData);
            }
        }
        return linkedList.size();
    }

    public void a4(String str) {
        this.o = str;
    }

    public SparseArray<String> b0() {
        return this.f1;
    }

    public int b1() {
        return this.G;
    }

    public boolean b2() {
        return this.W1;
    }

    public void b3() {
        m3();
        e3();
        k3();
        l3();
        c3();
        i3();
        j3();
    }

    public void b4(PollData pollData) {
        this.x2 = pollData;
    }

    @Override // d.a.n0.r.q.a
    public v0 c() {
        SparseArray<String> sparseArray = this.f1;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        v0 v0Var = new v0();
        i();
        v0Var.n(z1());
        i();
        v0Var.k(c0());
        i();
        v0Var.m(M0());
        v0Var.j(this.f1);
        v0Var.f53930g = this.g1;
        v0Var.o = this.V0;
        v0Var.j = this.U0;
        v0Var.l = this.W0;
        v0Var.k = this.T0;
        v0Var.p = this.O1;
        v0Var.n = W0();
        return v0Var;
    }

    public long c0() {
        return this.B;
    }

    public int c1() {
        return this.n;
    }

    public boolean c2() {
        d.a.o0.e3.h0.n nVar = this.F2;
        if (nVar != null) {
            return nVar.f();
        }
        return false;
    }

    public final void c3() {
        this.y = J2();
    }

    public void c4(PraiseData praiseData) {
        this.a0 = praiseData;
    }

    public String d0() {
        return this.D;
    }

    public List<PbContent> d1() {
        return this.t;
    }

    public boolean d2() {
        MetaData metaData = this.P;
        return (metaData == null || metaData.getGodUserData() == null || this.P.getGodUserData().getType() != 2) ? false : true;
    }

    public final void d3() {
        AlaUserInfoData alaUserInfoData;
        AlaInfoData alaInfoData = this.s0;
        if (alaInfoData == null) {
            return;
        }
        if (alaInfoData.openRecomDuration == 1) {
            long j = this.v0;
            if (j > 0) {
                String formatTimeForAlaCardCreate = StringHelper.getFormatTimeForAlaCardCreate(j);
                if (!StringUtils.isNull(formatTimeForAlaCardCreate)) {
                    this.K1 = formatTimeForAlaCardCreate;
                }
            }
        }
        AlaInfoData alaInfoData2 = this.s0;
        if (alaInfoData2.openRecomFans == 1) {
            int i2 = 0;
            if (alaInfoData2 != null && (alaUserInfoData = alaInfoData2.user_info) != null) {
                i2 = alaUserInfoData.anchor_fans;
            }
            if (TextUtils.isEmpty(this.K1) || i2 <= 0) {
                if (i2 > 0) {
                    this.K1 = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    return;
                }
                return;
            }
            this.K1 += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
        }
    }

    public void d4(int i2) {
        this.G = i2;
    }

    public List<PbContent> e0() {
        return this.v;
    }

    public String e1() {
        return this.M0;
    }

    public boolean e2() {
        return this.s2;
    }

    public final void e3() {
        MetaData metaData;
        MetaData metaData2;
        if ((this instanceof w0) && "0".equals(o0())) {
            this.K1 = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
            return;
        }
        if (!C2() && (!b2() || getType() == k3)) {
            if (getType() != k3 && getType() != n3) {
                long C0 = C0() * 1000;
                if (C0 != 0) {
                    String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(C0);
                    if (StringHelper.isThisYear(formatTimeForJustNow)) {
                        formatTimeForJustNow = StringHelper.getFormatTimeShort(C0);
                    }
                    String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                    if (y()) {
                        formatTimeForJustNow = StringHelper.getFormatTimeForHomeC(C0);
                    }
                    this.K1 = string + formatTimeForJustNow;
                } else {
                    long j = this.v0;
                    String formatTimeForJustNow2 = StringHelper.getFormatTimeForJustNow(j);
                    if (StringHelper.isThisYear(formatTimeForJustNow2)) {
                        formatTimeForJustNow2 = StringHelper.getFormatTimeShort(j);
                    }
                    this.K1 = formatTimeForJustNow2;
                }
                if (q2()) {
                    g3();
                } else if (u2()) {
                    f3();
                } else if (!this.V1 && (metaData2 = this.P) != null && metaData2.showBazhuGrade()) {
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getBazhuGradeData().getDesc(), this.U1 ? 24 : 16, StringHelper.STRING_MORE);
                    if (!TextUtils.isEmpty(this.K1)) {
                        this.K1 += "   " + cutChineseAndEnglishWithSuffix;
                    } else {
                        this.K1 = cutChineseAndEnglishWithSuffix;
                    }
                }
                if (TextUtils.isEmpty(this.K1) || TextUtils.isEmpty(K())) {
                    return;
                }
                this.K1 += " • " + K();
                return;
            }
            d3();
            return;
        }
        long j2 = this.v0;
        if (j2 != 0) {
            String formatTimeForJustNow3 = StringHelper.getFormatTimeForJustNow(j2);
            if (StringHelper.isThisYear(formatTimeForJustNow3)) {
                formatTimeForJustNow3 = StringHelper.getFormatTimeShort(j2);
            }
            this.K1 = formatTimeForJustNow3;
        }
        MetaData metaData3 = this.P;
        String str = (metaData3 == null || metaData3.getBaijiahaoInfo() == null || TextUtils.isEmpty(this.P.getBaijiahaoInfo().auth_desc)) ? "" : this.P.getBaijiahaoInfo().auth_desc;
        if (q2()) {
            g3();
        } else if (!this.V1 && (metaData = this.P) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix2 = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
            if (!TextUtils.isEmpty(this.K1)) {
                this.K1 += "   " + cutChineseAndEnglishWithSuffix2;
                return;
            }
            this.K1 = cutChineseAndEnglishWithSuffix2;
        } else if (!TextUtils.isEmpty(this.K1) && !TextUtils.isEmpty(str)) {
            this.K1 += "   " + str;
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.K1 = str;
        }
    }

    public void e4(int i2) {
        this.n = i2;
    }

    public String f0() {
        return this.z0;
    }

    public String f1() {
        return this.E;
    }

    public boolean f2() {
        return this.a1;
    }

    public final void f3() {
        if (StringUtils.isNull(this.Q)) {
            return;
        }
        this.K1 = (StringHelper.cutChineseAndEnglishWithSuffix(this.Q, 12, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getContext().getString(R.string.forum)) + GlideException.IndentedAppendable.INDENT + this.K1;
    }

    public void f4(List<PbContent> list) {
        this.u = list;
    }

    public String g0() {
        return this.c0;
    }

    public String g1() {
        return this.P1;
    }

    public boolean g2() {
        return this.Z == 41;
    }

    public final void g3() {
        if (!q2() || TextUtils.isEmpty(this.P.getNewGodData().getFieldName())) {
            return;
        }
        if (!TextUtils.isEmpty(this.K1)) {
            this.K1 += "   " + this.P.getNewGodData().getFieldName() + d.a.n0.z0.l0.d(this.P.getNewGodData().isVideoGod());
            return;
        }
        this.K1 = this.P.getNewGodData().getFieldName() + d.a.n0.z0.l0.d(this.P.getNewGodData().isVideoGod());
    }

    public void g4(List<PbContent> list) {
        this.t = list;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> L0 = L0();
        if (L0 == null || z2()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < L0.size() && i2 < 3; i2++) {
            if (L0.get(i2) != null && L0.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(L0.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = L0.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = L0.get(i2).getPicUrl();
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

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        OriginalThreadInfo originalThreadInfo;
        int i2;
        d.a.o0.e3.h0.n nVar = this.F2;
        if (nVar != null) {
            return nVar.f() ? this.F2.g() ? AdvertAppInfo.n4 : AdvertAppInfo.o4 : this.F2.g() ? AdvertAppInfo.n4 : AdvertAppInfo.m4;
        } else if (r0()) {
            if (x1() != null) {
                return j3;
            }
            return M2;
        } else {
            int y0 = y0();
            if (this.x1 == 1) {
                if (this.y1 != null) {
                    return a3;
                }
                return this.B1 != null ? u3 : t3;
            } else if (this.s0 != null && this.Z == 60) {
                return m3;
            } else {
                if (this.s0 != null && ((i2 = this.Z) == 49 || i2 == 69)) {
                    return k3;
                }
                if (this.s0 != null && this.Z == 67) {
                    return n3;
                }
                int i4 = this.Z;
                if (i4 == 51) {
                    return l3;
                }
                if (i4 == 63) {
                    return v3;
                }
                if (i4 == 64) {
                    return w3;
                }
                if (y0 != 2 && y0 != 1) {
                    if (this.p0 != null && f2() && !j2()) {
                        return B3;
                    }
                    if (this.p0 != null && !j2()) {
                        if (d2()) {
                            return s3;
                        }
                        if (this instanceof w0) {
                            return C3;
                        }
                        return j3;
                    } else if (this.u1 && (originalThreadInfo = this.t1) != null) {
                        if (originalThreadInfo.u) {
                            if (originalThreadInfo.r != null) {
                                return r3;
                            }
                            if (originalThreadInfo.d()) {
                                return q3;
                            }
                            return p3;
                        }
                        return o3;
                    } else if (R1()) {
                        return b3;
                    } else {
                        if (h2()) {
                            return y3.get() ? F3 : M2;
                        } else if (O1() && G() == 1) {
                            return y3.get() ? G3 : M2;
                        } else if (i2()) {
                            return h3;
                        } else {
                            if (d2()) {
                                return i3;
                            }
                            if (this.f53712e) {
                                return S2;
                            }
                            if (this.f53713f) {
                                return T2;
                            }
                            if (this.f53714g) {
                                return U2;
                            }
                            if (this.f53715h) {
                                return V2;
                            }
                            if (this.f53716i) {
                                return W2;
                            }
                            if (this.k) {
                                return Y2;
                            }
                            if (this.l) {
                                return Z2;
                            }
                            if (this.j) {
                                return X2;
                            }
                            if (this.m) {
                                return d3;
                            }
                            if (this.B0) {
                                int a32 = a3();
                                if (a32 == 1) {
                                    return O2;
                                }
                                if (a32 == 2) {
                                    return P2;
                                }
                                if (a32 > 2) {
                                    return Q2;
                                }
                                return M2;
                            }
                            return M2;
                        }
                    }
                }
                return L2;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        VideoInfo videoInfo = this.p0;
        if (videoInfo != null) {
            return videoInfo.video_url;
        }
        return null;
    }

    public w1 h0() {
        return this.C;
    }

    public String h1() {
        return this.L1;
    }

    public boolean h2() {
        return q1() != null && v1() == 41 && s0() == 1 && r1() == 2;
    }

    public void h3() {
        MetaData metaData;
        if (C2() || b2()) {
            return;
        }
        long C0 = C0() * 1000;
        if (C0 != 0) {
            String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(C0);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(C0);
            }
            this.K1 = formatTimeForJustNow;
        }
        if (q2()) {
            g3();
        } else if (!this.V1 && (metaData = this.P) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
            if (!TextUtils.isEmpty(this.K1)) {
                this.K1 += "   " + cutChineseAndEnglishWithSuffix;
            } else {
                this.K1 = cutChineseAndEnglishWithSuffix;
            }
        }
        if (TextUtils.isEmpty(this.K1) || TextUtils.isEmpty(K())) {
            return;
        }
        this.K1 += " • " + K();
    }

    public void h4(String str) {
        this.E = str;
    }

    @Override // d.a.n0.r.q.a
    public a2 i() {
        return this;
    }

    public String i0() {
        return this.Q;
    }

    public long i1() {
        return this.l1;
    }

    public boolean i2() {
        return this.n1;
    }

    public final void i3() {
        this.M1 = StringHelper.getFormatTimeShort(C0() * 1000);
    }

    public void i4(long j) {
        this.l1 = j;
    }

    public String j0() {
        return this.h1;
    }

    public int j1() {
        return this.R;
    }

    public boolean j2() {
        return this.Z == 41;
    }

    public final void j3() {
        this.N1 = StringHelper.getFormatTimeShort(C0());
    }

    public void j4(boolean z) {
        this.I1 = z;
    }

    @Override // d.a.n0.r.q.a
    public boolean k() {
        return this.U1;
    }

    public String k0() {
        return this.x0;
    }

    public SkinInfo k1() {
        return this.N0;
    }

    public boolean k2() {
        return v1() == 50;
    }

    public final void k3() {
        if (s1() != null && s1().share_info != null && s1().share_info.share_user_count > 0 && t2() && (this.r1 <= 0 || this.s1 != 0)) {
            int i2 = s1().share_info.share_user_count;
            if (i2 == 1) {
                this.L1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
                return;
            } else {
                this.L1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i2)});
                return;
            }
        }
        this.L1 = null;
    }

    public void k4(int i2) {
        this.e1 = i2;
    }

    public List<PbGoodsData> l0() {
        return this.r2;
    }

    public SmartApp l1() {
        return this.H1;
    }

    public boolean l2() {
        return v1() == 49 || v1() == 69;
    }

    public final void l3() {
        SpannableStringBuilder P22 = P2();
        this.x = P22;
        d.a.o0.z.m.b(this, P22, true);
    }

    public void l4(int i2) {
    }

    public int m0() {
        return this.j1.hasAgree ? 1 : 0;
    }

    public int m1() {
        return this.e1;
    }

    public boolean m2() {
        return this.C1;
    }

    public final void m3() {
        if (StringUtils.isNull(this.P.getName_show())) {
            return;
        }
        this.J1 = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getName_show(), 12, StringHelper.STRING_MORE);
    }

    public void m4(String str, String str2) {
        this.L0 = str;
        this.M0 = str2;
    }

    public VideoInfo n0() {
        return this.B1;
    }

    public SpannableStringBuilder n1() {
        return this.w;
    }

    public boolean n2() {
        return this.D1;
    }

    public void n3(String str) {
        this.s = str;
    }

    public void n4(AlaInfoData alaInfoData) {
        this.s0 = alaInfoData;
    }

    public String o0() {
        return this.z;
    }

    public int o1() {
        return this.n2;
    }

    public boolean o2() {
        return this.i1;
    }

    public void o3(ArrayList<b> arrayList) {
        this.C0 = arrayList;
    }

    public void o4(String str) {
        this.K1 = str;
    }

    public int[] p0() {
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(d.a.c.e.p.l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i12 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> L0 = L0();
        if (d.a.n0.r.k.c().g() && ListUtils.getCount(L0) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i13 = 0; i13 < L0.size(); i13++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(L0, i13);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) ListUtils.getItem(L0, 0);
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
        d.a.n0.b.g.b.i(this, iArr);
        return iArr;
    }

    public String p1() {
        return this.o2;
    }

    public boolean p2() {
        return this.Z0;
    }

    public void p3(int i2) {
        this.j1.agreeNum = i2;
    }

    public void p4(int i2) {
        this.Z = i2;
    }

    public int q0() {
        return this.b1;
    }

    public y1 q1() {
        return this.I0;
    }

    public boolean q2() {
        MetaData metaData = this.P;
        return metaData != null && metaData.isNewGod();
    }

    public void q3(long j) {
        this.j1.agreeNum = j;
    }

    public void q4(String str) {
        this.A = str;
    }

    public boolean r0() {
        return this.G1;
    }

    public int r1() {
        y1 y1Var = this.I0;
        if (y1Var != null) {
            long e2 = y1Var.e();
            long a2 = this.I0.a();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < e2) {
                return 1;
            }
            return currentTimeMillis > a2 ? 3 : 2;
        }
        return -1;
    }

    public boolean r2() {
        return this.u0 == 1;
    }

    public void r3(int i2) {
        this.j1.agreeType = i2;
    }

    public void r4(String str) {
        this.r = str;
    }

    public int s0() {
        return this.M;
    }

    public AlaInfoData s1() {
        return this.s0;
    }

    public boolean s2() {
        return v1() == 40;
    }

    public void s3(int i2) {
        this.t0 = i2;
    }

    public void s4(String str) {
        this.A1 = str;
    }

    public int t0() {
        return this.W;
    }

    public String t1() {
        return this.K1;
    }

    public boolean t2() {
        return v1() == 60;
    }

    public void t3(String str) {
        this.i2 = str;
    }

    public void t4(String str) {
        this.z1 = str;
    }

    public int u0() {
        return this.K;
    }

    public List<ThreadRecommendInfoData> u1() {
        return this.J2;
    }

    public boolean u2() {
        return H2() && !StringUtils.isNull(this.Q) && this.V1;
    }

    public void u3(MetaData metaData) {
        this.P = metaData;
    }

    public void u4(HashMap<String, MetaData> hashMap) {
        this.i0 = hashMap;
    }

    public int v0() {
        return this.q;
    }

    public int v1() {
        return this.Z;
    }

    public boolean v2() {
        return this.I1;
    }

    public void v3(BaijiahaoData baijiahaoData) {
        this.k2 = baijiahaoData;
    }

    public void v4(VideoInfo videoInfo) {
        this.p0 = videoInfo;
    }

    public boolean w0() {
        return this.S0;
    }

    public h2 w1() {
        return this.r0;
    }

    public boolean w2() {
        int i2 = this.Z;
        return i2 == 63 || i2 == 64;
    }

    public void w3(int i2) {
        this.H0 = i2;
    }

    public void w4(int i2) {
        this.H = i2;
    }

    public int x0() {
        return this.L;
    }

    public VideoInfo x1() {
        return this.p0;
    }

    public boolean x2() {
        return this.T1;
    }

    public void x3(long j) {
        this.j1.diffAgreeNum = j;
    }

    public void x4(ArrayList<VoiceData$VoiceModel> arrayList) {
        this.U = arrayList;
    }

    public int y0() {
        return this.J;
    }

    public VideoDesc y1() {
        return this.q0;
    }

    public boolean y2() {
        return this.V == 1;
    }

    public void y3(long j) {
        this.B = j;
    }

    public void y4(long j) {
        this.v0 = j;
    }

    public final SpannableStringBuilder z(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z4, boolean z5) {
        ArrayList<m.a> T0 = T0(z, z2, z4, z5);
        if (T0 == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder h2 = d.a.o0.z.m.h(TbadkCoreApplication.getInst(), str, T0, false);
        if (T0.size() > 0) {
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
        } else if (T0.size() > 0 || h2.length() == 0) {
            h2.append((CharSequence) str);
        }
        return h2;
    }

    public Item z0() {
        return this.t2;
    }

    public String z1() {
        if (!StringUtils.isNull(this.A) && !"0".equals(this.A)) {
            return this.A;
        }
        return this.z;
    }

    public boolean z2() {
        return y0() != 0;
    }

    public void z3(String str) {
        this.D = str;
    }

    public void z4(List<PbGoodsData> list) {
        this.r2 = list;
        if (ListUtils.isEmpty(list) || this.s2) {
            return;
        }
        this.s2 = true;
    }
}
