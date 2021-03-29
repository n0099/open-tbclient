package d.b.h0.r.q;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import d.b.i0.x.m;
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
import tbclient.TopicModule;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes3.dex */
public class a2 extends a implements PreLoadImageProvider, d.b.b.j.e.n, IVideoData {
    public boolean B1;
    public int B2;
    public w1 C;
    public OriginalForumInfo C1;
    public d.b.i0.c3.h0.n C2;
    public String D;
    public boolean D1;
    public int D2;
    public String E;
    public boolean E1;
    public WorksInfoData E2;
    public SmartApp F1;
    public int F2;
    public String H1;
    public String I1;
    public String J1;
    public String K1;
    public String L1;
    public SkinInfo M0;
    public int M1;
    public boolean N0;
    public String N1;
    public String O;
    public String O0;
    public String O1;
    public String R0;
    public boolean R1;
    public String S0;
    public boolean S1;
    public String T0;
    public boolean T1;
    public String U0;
    public boolean U1;
    public int V;
    public String V0;
    public boolean V1;
    public long W0;
    public boolean W1;
    public boolean X1;
    public int Y;
    public boolean Y1;
    public int Z;
    public boolean Z1;
    public boolean a1;
    public String a2;
    public boolean b2;
    public String c0;
    public String c2;
    public HashMap<String, MetaData> d0;
    public String e0;
    public String e2;
    public String f0;
    public String f1;
    public String f2;
    public String g0;
    public boolean g1;
    public int g2;
    public BaijiahaoData h2;
    public int i0;
    public long j1;
    public String j2;
    public VideoInfo k0;
    public p0 k1;
    public int k2;
    public VideoDesc l0;
    public boolean l1;
    public String l2;
    public h2 m0;
    public ThreadInfo m2;
    public AlaInfoData n0;
    public g n1;
    public MediaData o1;
    public int p1;
    public boolean p2;
    public int q;
    public long q0;
    public Item q2;
    public long r0;
    public OriginalThreadInfo r1;
    public ItemData r2;
    public boolean s1;
    public List<HeadItem> s2;
    public ItemStarData t2;
    public PollData u2;
    public SpannableStringBuilder w;
    public TopicModule w1;
    public String w2;
    public SpannableStringBuilder x;
    public String x1;
    public String x2;
    public SpannableString y;
    public String y1;
    public String y2;
    public t z0;
    public VideoInfo z1;
    public static final BdUniqueId G2 = BdUniqueId.gen();
    public static final BdUniqueId H2 = BdUniqueId.gen();
    public static final BdUniqueId I2 = BdUniqueId.gen();
    public static final BdUniqueId J2 = BdUniqueId.gen();
    public static final BdUniqueId K2 = BdUniqueId.gen();
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
    public static AtomicBoolean t3 = new AtomicBoolean(false);
    public static AtomicBoolean u3 = new AtomicBoolean(false);
    public static AtomicBoolean v3 = new AtomicBoolean(false);
    public static final BdUniqueId w3 = BdUniqueId.gen();
    public static final BdUniqueId x3 = BdUniqueId.gen();
    public static HashMap<Point, Integer> y3 = new HashMap<>();
    public static HashMap<Integer, Integer> z3 = new HashMap<>();
    public static final BdUniqueId A3 = BdUniqueId.gen();
    public static final BdUniqueId B3 = BdUniqueId.gen();
    public static HashMap<Point, Integer> C3 = new HashMap<>();
    public static SparseArray<m.a> D3 = new SparseArray<>(3);

    /* renamed from: e  reason: collision with root package name */
    public boolean f50702e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50703f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50704g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50705h = false;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public int n = 0;
    public String o = "1";
    public int p = 1;
    public String X = null;
    public int t0 = 0;
    public String u0 = "";
    public boolean v0 = false;
    public String A0 = "";
    public boolean X0 = true;
    public boolean b1 = false;
    public int c1 = -1;
    public SparseArray<String> d1 = null;
    public SparseArray<String> e1 = null;
    public boolean m1 = false;
    public int v1 = 0;
    public boolean A1 = false;
    public boolean G1 = false;
    public boolean P1 = false;
    public boolean Q1 = false;
    public boolean d2 = false;
    public boolean i2 = false;
    public boolean z2 = false;
    public boolean A2 = false;
    public String z = null;
    public String A = null;
    public long B = 0;
    public String r = null;
    public int p0 = 0;
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
    public int h0 = 0;
    public ArrayList<b> w0 = new ArrayList<>();
    public m2 x0 = null;
    public h y0 = null;
    public ArrayList<d.b.h0.s.i.c> j0 = new ArrayList<>();
    public int B0 = 0;
    public int o0 = 0;
    public int P0 = 0;
    public q Q0 = new q();
    public List<PbContent> v = new ArrayList();
    public List<PbContent> t = new ArrayList();
    public List<PbContent> u = new ArrayList();
    public String F = null;
    public y1 C0 = new y1();
    public ArrayList<d.b.h0.t.b> D0 = new ArrayList<>();
    public PushStatusData E0 = new PushStatusData();
    public boolean Y0 = false;
    public int Z0 = -1;
    public PostData i1 = new PostData();
    public AgreeData h1 = new AgreeData();
    public int q1 = 0;
    public String s0 = "";
    public String u1 = "";
    public String t1 = "";
    public String K0 = "";
    public String L0 = "";
    public List<PbLinkData> n2 = new ArrayList();
    public List<PbGoodsData> o2 = new ArrayList();
    public int v2 = -1;

    static {
        y3.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        y3.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        y3.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        y3.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        y3.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        y3.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        y3.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        y3.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        C3.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        C3.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        C3.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        C3.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        C3.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        C3.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        C3.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        C3.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        z3.put(1, Integer.valueOf(R.drawable.label_interview_no));
        z3.put(2, Integer.valueOf(R.drawable.label_interview_live));
        z3.put(3, Integer.valueOf(R.drawable.label_interview_off));
        D3.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        D3.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        D3.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public a2() {
        this.V = 0;
        this.i0 = 0;
        this.p1 = 0;
        this.i0 = 0;
        this.V = 0;
        this.p1 = 0;
    }

    public boolean A() {
        return false;
    }

    public long A0() {
        return this.W0;
    }

    public e2 A1() {
        return this.N;
    }

    public boolean A2() {
        return this.Z == 11 || this.Y == 1;
    }

    public void A3(String str) {
        this.f1 = str;
    }

    public SpannableString B(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
        Bitmap bitmap = SkinManager.getBitmap(R.drawable.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        d.b.h0.r.f0.j jVar = new d.b.h0.r.f0.j(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String o = d.b.h0.r.d0.b.i().o("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(o)) {
            o = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(o);
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
        return this.I;
    }

    public TopicModule B1() {
        return this.w1;
    }

    public boolean B2() {
        return this.Z == 36;
    }

    public void B3(int i) {
        this.h1.hasAgree = i == 1;
    }

    public String C() {
        return this.s;
    }

    public String C0() {
        return this.e0;
    }

    public String C1() {
        return this.y1;
    }

    public boolean C2() {
        WorksInfoData worksInfoData = this.E2;
        return worksInfoData != null && worksInfoData.isWorks;
    }

    public void C3(VideoInfo videoInfo) {
        this.z1 = videoInfo;
    }

    public SpannableString D() {
        return this.y;
    }

    public String D0() {
        return this.K0;
    }

    public String D1() {
        return this.x1;
    }

    public boolean D2() {
        return this.p0 != 0;
    }

    public void D3(String str) {
        this.z = str;
    }

    public ArrayList<b> E() {
        return this.w0;
    }

    public String E0() {
        return this.O0;
    }

    public HashMap<String, MetaData> E1() {
        return this.d0;
    }

    public SpannableString E2() {
        SpannableStringBuilder H22 = H2();
        d.b.i0.x.m.b(this, H22, false);
        return new SpannableString(H22);
    }

    public void E3(int i) {
        this.Z0 = i + 1;
    }

    public int F() {
        if (!L1() || this.w0.size() < 1) {
            return -1;
        }
        b bVar = this.w0.get(0);
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
        return this.H1;
    }

    public int F1() {
        if (Q1() || P1()) {
            return 2;
        }
        return (O1() || R1()) ? 3 : 1;
    }

    public SpannableString F2() {
        if (ListUtils.isEmpty(this.v)) {
            return null;
        }
        return new SpannableString(d.b.h0.b1.m.e.w(this, this.v, this.s));
    }

    public void F3(int i) {
    }

    public int G() {
        if (!L1() || this.w0.size() < 1 || this.w0.get(0) == null) {
            return -1;
        }
        return this.w0.get(0).a();
    }

    public List<PbLinkData> G0() {
        return this.n2;
    }

    public int G1() {
        return this.H;
    }

    public void G2(WriteData writeData) {
        String i;
        if (writeData == null) {
            return;
        }
        try {
            this.z = "0";
            this.A = "";
            this.B = d.b.b.e.m.b.f(writeData.getForumId(), 0L);
            this.r = writeData.getTitle();
            this.q0 = System.currentTimeMillis() / 1000;
            String str = (System.currentTimeMillis() / 1000) + "";
            this.I = System.currentTimeMillis() / 1000;
            MetaData metaData = new MetaData();
            this.P = metaData;
            metaData.parseFromCurrentUser();
            this.O = TbadkCoreApplication.getCurrentAccount();
            this.Q = writeData.getForumName();
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
            if (d.b.b.e.p.k.isEmpty(d.b.i0.c3.q0.a.f().i())) {
                i = writeData.getVideoInfo().getThumbPath();
            } else {
                i = d.b.i0.c3.q0.a.f().i();
            }
            builder.thumbnail_url = i;
            builder.video_url = writeData.getVideoInfo().getVideoUrl();
            this.k0 = builder.build(true);
            this.Z = 40;
            System.currentTimeMillis();
            this.q = writeData.isNoTitle() ? 1 : 0;
            this.s = writeData.getContent();
            w1 w1Var = new w1();
            this.C = w1Var;
            w1Var.f50916a = writeData.getForumId();
            this.C.f50917b = writeData.getForumName();
            this.k2 = writeData.getTabId();
            this.l2 = writeData.getTabName();
            W2();
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
            this.q2 = builder2.build(true);
            ItemData itemData = new ItemData();
            this.r2 = itemData;
            itemData.parseItemInfo(writeData.getItemInfo());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void G3(boolean z) {
        this.Y0 = z;
    }

    public String H() {
        return (!L1() || this.w0.size() < 1 || this.w0.get(0) == null) ? "" : this.w0.get(0).g();
    }

    public p0 H0() {
        return this.k1;
    }

    public ArrayList<VoiceData$VoiceModel> H1() {
        return this.U;
    }

    public SpannableStringBuilder H2() {
        return d.b.h0.b1.m.e.w(this, this.u, this.s);
    }

    public void H3(int i) {
        this.W = i;
    }

    public ActivityItemData I() {
        String str;
        List<PbContent> list = this.t;
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = this.t.size();
        for (int i = 0; i < size; i++) {
            PbContent pbContent = this.t.get(i);
            if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && y2() && (str = pbContent.text) != null && str.length() >= 3) {
                ActivityItemData activityItemData = new ActivityItemData();
                activityItemData.link_url = d.b.h0.p0.b.d(pbContent.text);
                String str2 = pbContent.text;
                activityItemData.activity_name = str2.substring(1, str2.length() - 2);
                return activityItemData;
            }
        }
        return null;
    }

    public String I0() {
        return this.f0;
    }

    public m2 I1() {
        return this.x0;
    }

    public SpannableStringBuilder I2() {
        return d.b.h0.b1.m.e.w(this, this.t, this.r);
    }

    public void I3(boolean z) {
        this.R1 = z;
    }

    public String J() {
        return this.S;
    }

    public String J0() {
        return this.X;
    }

    public void J1() {
        if (ListUtils.getCount(this.s2) > 0) {
            SpannableStringBuilder spannableStringBuilder = this.x;
            if (spannableStringBuilder != null) {
                spannableStringBuilder.insert(0, (CharSequence) d.b.h0.b1.m.e.f(this.s2));
                return;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.y);
            spannableStringBuilder2.insert(0, (CharSequence) d.b.h0.b1.m.e.f(this.s2));
            this.y = new SpannableString(spannableStringBuilder2);
        }
    }

    public void J2(ArrayList<u> arrayList) {
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

    public void J3() {
        this.v1 = 1;
    }

    public String K() {
        return this.g0;
    }

    public ArrayList<MediaData> K0() {
        return this.T;
    }

    public void K1(SpannableString spannableString) {
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

    public SpannableStringBuilder K2() {
        if (StringUtils.isNull(this.r) || this.q == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(I2());
        this.w = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public void K3(int i) {
        this.L = i;
    }

    public AgreeData L() {
        return this.h1;
    }

    public String L0() {
        return this.O1;
    }

    public boolean L1() {
        return this.h0 == 1;
    }

    public SpannableStringBuilder L2(boolean z, boolean z2) {
        return M2(z, z2, false);
    }

    public void L3(int i) {
        this.J = i;
    }

    public long M() {
        return this.h1.agreeNum;
    }

    public int M0() {
        return this.i0;
    }

    public boolean M1() {
        return (T() == null || T().getAlaUserData() == null || T().getAlaUserData().live_status != 1) ? false : true;
    }

    public SpannableStringBuilder M2(boolean z, boolean z2, boolean z4) {
        SpannableStringBuilder I22;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.q == 1) {
            I22 = H2();
            spannableStringBuilder = I22.toString();
        } else {
            I22 = I2();
            spannableStringBuilder = I22.toString();
        }
        SpannableStringBuilder spannableStringBuilder3 = I22;
        String str = spannableStringBuilder;
        if (z) {
            spannableStringBuilder2 = z(str, spannableStringBuilder3, z, true, z2, z4);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder3);
        }
        this.w = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public void M3(Item item) {
        this.q2 = item;
    }

    public int N() {
        return this.h1.agreeType;
    }

    public String N0() {
        return this.o;
    }

    public boolean N1() {
        String userId;
        MetaData metaData = this.P;
        return metaData == null || (userId = metaData.getUserId()) == null || userId.equals("0");
    }

    public SpannableStringBuilder N2(boolean z, boolean z2) {
        SpannableStringBuilder H22;
        if (!StringUtils.isNull(this.r) && this.q != 1) {
            H22 = I2();
        } else {
            H22 = H2();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(H22);
        this.w = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public void N3(ItemData itemData) {
        this.r2 = itemData;
    }

    public AnchorInfoData O() {
        return this.b0;
    }

    public PollData O0() {
        return this.u2;
    }

    public boolean O1() {
        BaijiahaoData baijiahaoData = this.h2;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O2(boolean z, boolean z2) {
        d.b.b.j.b bVar;
        SpannableStringBuilder I22;
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        if (!z2) {
            if (s1() == 42 && U1()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (x0() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (x0() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (s0() == 1 || this.N.a() != 0) {
                if (o1() != null && s1() == 41) {
                    if (p1() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && c2()) {
                Integer num = z3.get(Integer.valueOf(p1()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (w0() == 1 && !u2() && e3 != getType() && n3 != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            AnchorInfoData anchorInfoData = this.b0;
            if (anchorInfoData != null && anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (h1() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = y3.get(new Point(G(), F()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (I1() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (Q() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!d.b.b.e.p.k.isEmpty(this.F)) {
                bVar = v4(this.F);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (arrayList.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append("1 ");
                    }
                    String sb2 = sb.toString();
                    if (bVar != null) {
                        spannableString = new SpannableString(sb2 + this.F + " ");
                    } else {
                        spannableString = new SpannableString(sb2);
                    }
                    int i2 = 0;
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        Bitmap bitmap = SkinManager.getBitmap(((Integer) arrayList.get(i4)).intValue());
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                        if (bitmap != null) {
                            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        }
                        d.b.h0.r.f0.i iVar = new d.b.h0.r.f0.i(bitmapDrawable);
                        iVar.b(d.b.b.e.p.l.e(TbadkCoreApplication.getInst().getApplicationContext(), this.p));
                        spannableString.setSpan(iVar, i2, i2 + 1, 33);
                        i2 += 2;
                    }
                    if (bVar != null) {
                        spannableString.setSpan(bVar, i2, this.F.length() + i2, 33);
                    }
                    spannableStringBuilder.append((CharSequence) spannableString);
                }
                I22 = I2();
                if (I22 != null) {
                    spannableStringBuilder.append((CharSequence) I22);
                }
                this.w = spannableStringBuilder;
            }
        }
        bVar = null;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (arrayList.size() > 0) {
        }
        I22 = I2();
        if (I22 != null) {
        }
        this.w = spannableStringBuilder2;
    }

    public void O3(List<HeadItem> list) {
        this.s2 = list;
    }

    public int P() {
        return this.o0;
    }

    public PraiseData P0() {
        return this.a0;
    }

    public boolean P1() {
        BaijiahaoData baijiahaoData = this.h2;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 3;
    }

    @Deprecated
    public void P2(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        try {
            this.z = jSONObject.optString("id");
            this.B = jSONObject.optLong("fid", 0L);
            this.A = jSONObject.optString("tid");
            this.r = jSONObject.optString("title");
            this.p0 = jSONObject.optInt("is_god");
            this.q0 = jSONObject.optLong("create_time", 0L) * 1000;
            this.r0 = jSONObject.optLong("audit_time", 0L) * 1000;
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
            this.j1 = jSONObject.optLong("share_num");
            this.c0 = jSONObject.optString("first_post_id", "0");
            this.u0 = jSONObject.optString("post_id", "0");
            jSONObject.optLong("time", 0L);
            this.q = jSONObject.optInt("is_ntitle");
            this.F = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            this.s0 = jSONObject.optString("tieba_game_information_source", "");
            this.h1.parseJson(jSONObject.optJSONObject("agree"));
            this.h1.threadId = this.A;
            JSONArray optJSONArray = jSONObject.optJSONArray("dislike_info");
            ArrayList<DislikeInfo> arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    DislikeInfo build = new DislikeInfo.Builder().build(true);
                    build.parseJson(optJSONArray.getJSONObject(i));
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
                this.d1 = sparseArray;
                this.e1 = sparseArray2;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
            if (optJSONObject2 != null) {
                this.C0.k(optJSONObject2);
            }
            if ((this.P == null || this.P.getUserId() == null) && this.d0 != null) {
                this.P = this.d0.get(this.O);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                this.g0 = optJSONObject.optString("location");
            }
            AlaInfoData alaInfoData = new AlaInfoData();
            this.n0 = alaInfoData;
            alaInfoData.parserJson(jSONObject.optJSONObject("ala_info"));
            StringBuilder sb = new StringBuilder();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                        sb.append(optJSONArray2.getJSONObject(i2).optString("text"));
                    }
                }
            }
            this.s = sb.toString();
            JSONArray optJSONArray3 = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
            if (optJSONArray3 != null) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray3.getJSONObject(i4));
                    this.T.add(mediaData);
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray4 != null) {
                int length = optJSONArray4.length();
                for (int i5 = 0; i5 < length; i5++) {
                    VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                    JSONObject jSONObject3 = optJSONArray4.getJSONObject(i5);
                    voiceData$VoiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                    voiceData$VoiceModel.voiceId = jSONObject3.optString("voice_md5");
                    voiceData$VoiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                    this.U.add(voiceData$VoiceModel);
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
            if (optJSONArray5 != null) {
                for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                    b bVar = new b();
                    bVar.h(optJSONArray5.getJSONObject(i6));
                    this.w0.add(bVar);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
            if (optJSONObject4 != null) {
                m2 m2Var = new m2();
                this.x0 = m2Var;
                m2Var.c(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
            if (optJSONObject5 != null) {
                h hVar = new h();
                this.y0 = hVar;
                hVar.b(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject6 != null) {
                t tVar = new t();
                this.z0 = tVar;
                tVar.c(optJSONObject6);
            }
            this.a0.setUserMap(this.d0);
            this.a0.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
            this.b0.parserJson(jSONObject.optJSONObject("anchor_info"));
            if (!d.b.b.e.p.k.isEmpty(this.r)) {
                this.a0.setTitle(this.r);
            } else {
                this.a0.setTitle(this.s);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.C0.k(optJSONObject7);
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
            if (optJSONArray6 != null) {
                for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                    d.b.h0.t.b bVar2 = new d.b.h0.t.b();
                    bVar2.a(optJSONArray6.getJSONObject(i7));
                    this.D0.add(bVar2);
                }
            }
            this.P0 = jSONObject.optInt("is_book_chapter", 0);
            this.Q0.a(jSONObject.optJSONObject("book_chapter"));
            this.R0 = jSONObject.optString("recom_source");
            this.V0 = jSONObject.optString("recom_reason");
            this.S0 = jSONObject.optString(TiebaStatic.Params.RECOM_WEIGHT);
            this.U0 = jSONObject.optString(TiebaStatic.Params.RECOM_EXTRA);
            jSONObject.optString("recom_extra_img");
            jSONObject.optString("recom_extra_img_night");
            jSONObject.optInt("recom_extra_img_width", 0);
            jSONObject.optInt("recom_extra_img_height", 0);
            this.W0 = jSONObject.optLong("last_read_pid");
            this.X0 = jSONObject.optInt("cheak_repeat") == 1;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
            if (optJSONObject8 != null) {
                h2 h2Var = new h2();
                this.m0 = h2Var;
                h2Var.a(optJSONObject8);
            }
            this.g1 = jSONObject.optInt("is_multiforum_thread") == 1;
            this.l1 = jSONObject.optBoolean("is_link_thread");
            JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
            if (this.l1 && optJSONObject9 != null) {
                p0 p0Var = new p0();
                this.k1 = p0Var;
                p0Var.g(optJSONObject9);
            }
            this.m1 = jSONObject.optInt("is_partial_visible") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
            if (optJSONObject10 != null) {
                g gVar = new g();
                this.n1 = gVar;
                gVar.a(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
            if (optJSONObject11 != null) {
                MediaData mediaData2 = new MediaData();
                this.o1 = mediaData2;
                mediaData2.parserJson(optJSONObject11);
            }
            jSONObject.optInt("is_called", 0);
            this.p1 = jSONObject.optInt("middle_page_num", 0);
            this.q1 = jSONObject.optInt("middle_page_pass_flag", 0);
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
                this.k0 = builder.build(true);
            }
            boolean z = jSONObject.optInt("is_share_thread", 0) == 1;
            this.s1 = z;
            if (z) {
                JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                if (optJSONObject13 != null) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    this.r1 = originalThreadInfo;
                    originalThreadInfo.l(optJSONObject13);
                } else {
                    this.r1 = null;
                }
            } else {
                this.r1 = null;
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
                this.F1 = builder2.build(false);
            }
            this.N1 = jSONObject.optString("t_share_img");
            this.O1 = jSONObject.optString("nid");
            this.P1 = jSONObject.optInt("is_headlinepost", 0) == 1;
            jSONObject.optInt(ImageViewerConfig.IS_BJH);
            this.g2 = jSONObject.optInt("bjh_content_tag");
            this.f2 = jSONObject.optString("article_cover");
            JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject15 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.h2 = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject15);
                this.h1.baijiahaoData = this.h2;
            }
            this.i2 = jSONObject.optInt("is_s_card", 0) == 1;
            this.j2 = jSONObject.optString("scard_packet_id");
            this.k2 = jSONObject.optInt("tab_id");
            this.l2 = jSONObject.optString("tab_name");
            jSONObject.optString("wonderful_post_info");
            W2();
            this.d2 = jSONObject.optInt("if_comment", 0) == 1;
            this.e2 = jSONObject.optString("if_comment_info");
            JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
            if (optJSONObject16 != null) {
                if (this.u2 == null) {
                    this.u2 = new PollData();
                }
                this.u2.parserJson(optJSONObject16);
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
            if (optJSONArray7 != null) {
                for (int i8 = 0; i8 < optJSONArray7.length(); i8++) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseJson(optJSONArray7.getJSONObject(i8));
                    if (pbLinkData.urlType == 2 && !this.p2) {
                        this.p2 = true;
                    }
                    this.n2.add(pbLinkData);
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
            if (optJSONArray8 != null) {
                for (int i9 = 0; i9 < optJSONArray8.length(); i9++) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseJson(optJSONArray8.getJSONObject(i9));
                    this.o2.add(pbGoodsData);
                }
                if (this.o2.size() > 0 && !this.p2) {
                    this.p2 = true;
                }
            }
            this.v2 = jSONObject.optInt("hot_num", -1);
            jSONObject.optInt("is_local");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("works_info");
            if (optJSONObject17 != null) {
                if (this.E2 == null) {
                    this.E2 = new WorksInfoData();
                }
                this.E2.parseJson(optJSONObject17);
            }
            this.F2 = jSONObject.optInt("collect_num");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void P3(long j) {
        this.I = j;
    }

    public h Q() {
        return this.y0;
    }

    public ArrayList<d.b.h0.b1.m.b> Q0() {
        ArrayList<d.b.h0.b1.m.b> arrayList = new ArrayList<>();
        if (this.i2) {
            arrayList.add(new d.b.h0.b1.m.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public boolean Q1() {
        BaijiahaoData baijiahaoData = this.h2;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 4;
    }

    public void Q2(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo == null) {
            return;
        }
        try {
            if (threadInfo.location != null) {
                this.e0 = threadInfo.location.lat;
                this.f0 = threadInfo.location.lng;
                this.g0 = threadInfo.location.name;
            }
            this.V = threadInfo.is_tbread_dispatch.intValue();
            this.z = threadInfo.id + "";
            this.A = threadInfo.tid + "";
            this.B = threadInfo.fid.longValue();
            this.r = threadInfo.title;
            this.p0 = threadInfo.is_god.intValue();
            this.q0 = threadInfo.create_time.intValue() * 1000;
            this.r0 = threadInfo.audit_time.longValue() * 1000;
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
            this.k0 = threadInfo.video_info;
            this.l0 = threadInfo.video_segment;
            AlaInfoData alaInfoData = new AlaInfoData();
            this.n0 = alaInfoData;
            alaInfoData.parserProtobuf(threadInfo.ala_info);
            String str2 = threadInfo.from;
            this.W = threadInfo.collect_status.intValue();
            this.X = threadInfo.collect_mark_pid;
            this.Y = threadInfo.is_voice_thread.intValue();
            this.Z = threadInfo.thread_type.intValue();
            threadInfo.thread_type.intValue();
            this.c0 = threadInfo.first_post_id + "";
            this.u0 = threadInfo.post_id + "";
            threadInfo.time.intValue();
            this.q = threadInfo.is_ntitle.intValue();
            this.h0 = threadInfo.is_activity.intValue();
            if (threadInfo.agree != null) {
                this.h1.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                this.h1.parseProtobuf(threadInfo.agree);
            }
            if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                this.s0 = threadInfo.tieba_game_information_source;
            } else {
                this.s0 = "";
            }
            this.j1 = threadInfo.share_num.longValue();
            this.F = threadInfo.category_name;
            this.i0 = threadInfo.operator_flag.intValue();
            if (threadInfo.is_operate_thread != null) {
                threadInfo.is_operate_thread.intValue();
            }
            this.t = threadInfo.rich_title;
            this.v = threadInfo.first_post_content;
            this.u = threadInfo.rich_abstract;
            threadInfo.is_godthread_recommend.intValue();
            if ((this.P == null || this.P.getUserId() == null || this.P.getUserId().equals("0") || this.A2) && this.O != null && !this.O.equals("0") && this.d0 != null && (metaData = this.d0.get(this.O)) != null) {
                this.P = metaData;
            }
            StringBuilder sb = new StringBuilder();
            List<Abstract> list = threadInfo._abstract;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null && list.get(i).type.intValue() == 0) {
                        sb.append(list.get(i).text);
                    }
                }
            }
            this.s = sb.toString();
            List<Media> list2 = threadInfo.media;
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(list2.get(i2));
                    this.T.add(mediaData);
                }
            }
            if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                this.k0 = threadInfo.video_info;
            }
            if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                h2 h2Var = new h2();
                this.m0 = h2Var;
                h2Var.b(threadInfo.video_channel_info);
            }
            List<Voice> list3 = threadInfo.voice_info;
            if (list3 != null) {
                int size = list3.size();
                for (int i4 = 0; i4 < size; i4++) {
                    VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                    Voice voice = list3.get(i4);
                    voiceData$VoiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                    voiceData$VoiceModel.voiceId = voice.voice_md5;
                    voiceData$VoiceModel.duration = voice.during_time.intValue() / 1000;
                    this.U.add(voiceData$VoiceModel);
                }
            }
            List<ActInfo> list4 = threadInfo.act_info;
            if (list4 != null) {
                int size2 = list4.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    b bVar = new b();
                    bVar.i(list4.get(i5));
                    this.w0.add(bVar);
                }
            }
            if (threadInfo.yule_post_activity != null) {
                m2 m2Var = new m2();
                this.x0 = m2Var;
                m2Var.d(threadInfo.yule_post_activity);
            }
            if (threadInfo.app_code != null) {
                h hVar = new h();
                this.y0 = hVar;
                hVar.c(threadInfo.app_code);
            }
            if (threadInfo.cartoon_info != null) {
                t tVar = new t();
                this.z0 = tVar;
                tVar.d(threadInfo.cartoon_info);
            }
            this.a0.setUserMap(this.d0);
            this.a0.parserProtobuf(threadInfo.zan);
            this.b0.parserProtobuf(threadInfo.anchor_info);
            if (!d.b.b.e.p.k.isEmpty(this.r)) {
                this.a0.setTitle(this.r);
            } else {
                this.a0.setTitle(this.s);
            }
            this.A0 = threadInfo.livecover_src;
            threadInfo.storecount.intValue();
            threadInfo.post_num.intValue();
            threadInfo.post_num.intValue();
            threadInfo.freq_num.longValue();
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                if (zhiBoInfoTW.labelInfo != null) {
                    int size3 = zhiBoInfoTW.labelInfo.size();
                    for (int i6 = 0; i6 < size3; i6++) {
                        if (zhiBoInfoTW.labelInfo.get(i6) != null) {
                            d.b.h0.s.i.c cVar = new d.b.h0.s.i.c();
                            cVar.a(zhiBoInfoTW.labelInfo.get(i6).labelHot.intValue());
                            cVar.b(zhiBoInfoTW.labelInfo.get(i6).labelId);
                            cVar.c(zhiBoInfoTW.labelInfo.get(i6).labelContent);
                            this.j0.add(cVar);
                        }
                    }
                }
                NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                if (noticeInfo != null) {
                    String str3 = noticeInfo.notice;
                }
                this.B0 = zhiBoInfoTW.copythread_remind.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                if (StringUtils.isNull(this.A0)) {
                    this.A0 = zhiBoInfoTW.livecover_src;
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
                    this.o0 = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                }
            }
            threadInfo.is_copythread.intValue();
            if (threadInfo.task_info != null) {
                this.C0.l(threadInfo.task_info);
            }
            if (threadInfo.ext_tails != null) {
                for (int i7 = 0; i7 != threadInfo.ext_tails.size(); i7++) {
                    d.b.h0.t.b bVar2 = new d.b.h0.t.b();
                    bVar2.b(threadInfo.ext_tails.get(i7));
                    this.D0.add(bVar2);
                }
            }
            this.E0.parserProtobuf(threadInfo.push_status);
            this.O0 = threadInfo.lego_card;
            this.M0 = threadInfo.skin_info;
            this.P0 = threadInfo.is_book_chapter.intValue();
            this.Q0.b(threadInfo.book_chapter);
            this.R0 = threadInfo.recom_source;
            this.V0 = threadInfo.recom_reason;
            this.S0 = threadInfo.recom_weight;
            this.T0 = threadInfo.ab_tag;
            this.U0 = threadInfo.recom_extra;
            this.W0 = threadInfo.last_read_pid.longValue();
            this.X0 = threadInfo.cheak_repeat.intValue() == 1;
            List<ReportInfo> list6 = threadInfo.report_info;
            if (threadInfo.top_agree_post != null) {
                this.i1.a0(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.d1 = sparseArray;
                this.e1 = sparseArray2;
            }
            this.g1 = threadInfo.is_multiforum_thread.intValue() == 1;
            boolean z = threadInfo.is_link_thread.intValue() == 1;
            this.l1 = z;
            if (z && threadInfo.link_info != null) {
                p0 p0Var = new p0();
                this.k1 = p0Var;
                p0Var.h(threadInfo.link_info);
            }
            this.m1 = threadInfo.is_partial_visible.intValue() == 1;
            if (threadInfo.activity_info != null) {
                g gVar = new g();
                this.n1 = gVar;
                gVar.b(threadInfo.activity_info);
            }
            if (threadInfo.pic_info != null) {
                MediaData mediaData2 = new MediaData();
                this.o1 = mediaData2;
                mediaData2.parserProtobuf(threadInfo.pic_info);
            }
            threadInfo.is_called.intValue();
            this.p1 = threadInfo.middle_page_num.intValue();
            this.q1 = threadInfo.middle_page_pass_flag.intValue();
            this.s1 = threadInfo.is_share_thread.intValue() == 1;
            if (threadInfo.star_rank_icon != null) {
                this.t1 = threadInfo.star_rank_icon.icon_pic_url;
                this.u1 = threadInfo.star_rank_icon.icon_link;
            }
            if (threadInfo.origin_thread_info != null) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.r1 = originalThreadInfo;
                originalThreadInfo.j(threadInfo.origin_thread_info);
            } else {
                this.r1 = null;
                this.s1 = false;
            }
            this.v1 = threadInfo.is_topic.intValue();
            this.x1 = threadInfo.topic_user_name;
            this.y1 = threadInfo.topic_h5_url;
            this.w1 = threadInfo.topic_module;
            String str4 = threadInfo.presentation_style;
            this.C1 = OriginalForumInfo.parser(threadInfo.ori_forum_info);
            String str5 = threadInfo.daily_paper_time;
            if (threadInfo.forum_info != null) {
                w1 w1Var = new w1();
                this.C = w1Var;
                w1Var.e(threadInfo.forum_info);
            }
            if (threadInfo.swan_info != null) {
                this.F1 = threadInfo.swan_info;
            }
            this.N1 = threadInfo.t_share_img;
            this.O1 = threadInfo.nid;
            this.P1 = threadInfo.is_headlinepost.intValue() == 1;
            String str6 = threadInfo.thread_share_link;
            this.f2 = threadInfo.article_cover;
            this.g2 = threadInfo.bjh_content_tag.intValue();
            threadInfo.is_bjh.intValue();
            if (threadInfo.baijiahao != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.h2 = baijiahaoData;
                baijiahaoData.parseProto(threadInfo.baijiahao);
                this.h1.baijiahaoData = this.h2;
            }
            this.i2 = threadInfo.is_s_card.intValue() == 1;
            this.j2 = threadInfo.scard_packet_id;
            this.k2 = threadInfo.tab_id.intValue();
            this.l2 = threadInfo.tab_name;
            String str7 = threadInfo.wonderful_post_info;
            W2();
            this.d2 = threadInfo.if_comment.intValue() == 1;
            this.e2 = threadInfo.if_comment_info;
            this.m2 = threadInfo;
            if (!ListUtils.isEmpty(threadInfo.pb_link_info)) {
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    if (pbLinkData.urlType == 2 && !this.p2) {
                        this.p2 = true;
                    }
                    this.n2.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(threadInfo.pb_goods_info)) {
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    this.o2.add(pbGoodsData);
                }
                if (this.o2.size() > 0 && !this.p2) {
                    this.p2 = true;
                }
            }
            if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                this.q2 = threadInfo.item;
            }
            if (this.q2 != null) {
                ItemData itemData = new ItemData();
                this.r2 = itemData;
                itemData.parseProto(this.q2);
            }
            List<HeadItem> list8 = threadInfo.item_star;
            this.s2 = list8;
            if (!ListUtils.isEmpty(list8)) {
                ItemStarData itemStarData = new ItemStarData();
                this.t2 = itemStarData;
                itemStarData.parseProto(this.s2);
            }
            if (threadInfo.poll_info != null) {
                if (this.u2 == null) {
                    this.u2 = new PollData();
                }
                this.u2.parserProtobuf(threadInfo.poll_info);
            }
            this.v2 = threadInfo.hot_num.intValue();
            threadInfo.is_local.intValue();
            this.D2 = threadInfo.is_author_view.intValue();
            if (threadInfo.works_info != null) {
                if (this.E2 == null) {
                    this.E2 = new WorksInfoData();
                }
                this.E2.parseProto(threadInfo.works_info);
            }
            this.F2 = threadInfo.collect_num.intValue();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void Q3(List<PbLinkData> list) {
        this.n2 = list;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (PbLinkData pbLinkData : this.n2) {
            if (pbLinkData.urlType == 2 && !this.p2) {
                this.p2 = true;
            }
        }
    }

    public String R() {
        return this.f2;
    }

    public final ArrayList<m.a> R0(boolean z, boolean z2, boolean z4, boolean z5) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean D2 = D2();
        if (z2) {
            if (z) {
                if (D2 && !y2()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (s0() == 1 || s1() == 33 || (A1() != null && A1().a() != 0)) {
                    if (o1() == null || !c2()) {
                        if (!D2) {
                            arrayList.add(new m.a(R.string.photo_live_tips));
                        }
                    } else if (p1() == 2) {
                        arrayList.add(new m.a(R.string.interview_live));
                    }
                }
                if (c2()) {
                    arrayList.add(D3.get(p1()));
                }
                if (L1()) {
                    Integer num = C3.get(new Point(G(), F()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (I1() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!d.b.b.e.p.k.isEmpty(X())) {
                    arrayList.add(new m.a(X()));
                }
            } else {
                if (D2 && x0() != 1 && !y2()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((s0() == 1 || s1() == 33) && !c2() && !D2) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (w0() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (x0() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (c2() && o1() != null && p1() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (L1()) {
                    Integer num2 = C3.get(new Point(G(), F()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.P0 == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (Q() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (I1() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!d.b.b.e.p.k.isEmpty(X())) {
                    arrayList.add(new m.a(X()));
                }
                if (z4 && h2()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z4 && g2()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (o2()) {
                    arrayList.add(new m.a(R.string.video_title_str));
                }
                if (z5) {
                    arrayList.add(new m.a(R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public boolean R1() {
        BaijiahaoData baijiahaoData = this.h2;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
    }

    public void R2(boolean z, boolean z2) {
        S2(z, z2, true);
    }

    public void R3(String str) {
        this.X = str;
    }

    public long S() {
        return this.r0;
    }

    public PushStatusData S0() {
        return this.E0;
    }

    @Deprecated
    public boolean S1() {
        return x2();
    }

    public void S2(boolean z, boolean z2, boolean z4) {
        SpannableStringBuilder spannableStringBuilder;
        if (ListUtils.getCount(R0(z, z2, z4, false)) > 0) {
            L2(z, z4);
            return;
        }
        SpannableStringBuilder I22 = I2();
        if (z) {
            spannableStringBuilder = z(I22.toString(), I22, z, z2, z4, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(I22);
        }
        this.w = spannableStringBuilder;
    }

    public void S3(boolean z) {
        this.A1 = z;
    }

    public MetaData T() {
        return this.P;
    }

    public ThreadInfo T0() {
        return this.m2;
    }

    public boolean T1() {
        return P1() || Q1();
    }

    public void T2() {
        O2(false, true);
    }

    public void T3(boolean z) {
        this.B1 = z;
    }

    public int U() {
        return this.g2;
    }

    public int U0() {
        if (n2()) {
            return 4;
        }
        if (h2() || g2()) {
            return 3;
        }
        if (O1()) {
            return 5;
        }
        if (R1()) {
            return 6;
        }
        if (P1()) {
            return 7;
        }
        if (Q1()) {
            return 8;
        }
        if (!this.s1 || this.r1 == null) {
            return o2() ? 2 : 1;
        }
        return 9;
    }

    public final boolean U1() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void U2() {
        O2(false, false);
    }

    public void U3(ArrayList<MediaData> arrayList) {
        this.T = arrayList;
    }

    public BaijiahaoData V() {
        return this.h2;
    }

    public String V0() {
        return this.V0;
    }

    public boolean V1() {
        return C2();
    }

    public int V2() {
        if (!d.b.h0.r.k.c().g() || ListUtils.getCount(K0()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < K0().size(); i++) {
            MediaData mediaData = (MediaData) ListUtils.getItem(K0(), i);
            if (mediaData != null && mediaData.getType() == 3) {
                linkedList.add(mediaData);
            }
        }
        return linkedList.size();
    }

    public void V3(String str) {
        this.o = str;
    }

    public t W() {
        return this.z0;
    }

    public String W0() {
        return this.R0;
    }

    public boolean W1() {
        MetaData metaData = this.P;
        return metaData != null && metaData.isForumBusinessAccount();
    }

    public void W2() {
        g3();
        Z2();
        e3();
        f3();
        X2();
        c3();
        d3();
    }

    public void W3(PollData pollData) {
        this.u2 = pollData;
    }

    public String X() {
        return this.F;
    }

    public String X0() {
        return this.K1;
    }

    public boolean X1() {
        return this.N0;
    }

    public final void X2() {
        this.y = E2();
    }

    public void X3(PraiseData praiseData) {
        this.a0 = praiseData;
    }

    public int Y() {
        return this.B0;
    }

    public String Y0() {
        return this.L1;
    }

    public boolean Y1() {
        return this.U1;
    }

    public final void Y2() {
        AlaUserInfoData alaUserInfoData;
        AlaInfoData alaInfoData = this.n0;
        if (alaInfoData == null) {
            return;
        }
        if (alaInfoData.openRecomDuration == 1) {
            long j = this.q0;
            if (j > 0) {
                String formatTimeForAlaCardCreate = StringHelper.getFormatTimeForAlaCardCreate(j);
                if (!StringUtils.isNull(formatTimeForAlaCardCreate)) {
                    this.I1 = formatTimeForAlaCardCreate;
                }
            }
        }
        AlaInfoData alaInfoData2 = this.n0;
        if (alaInfoData2.openRecomFans == 1) {
            int i = 0;
            if (alaInfoData2 != null && (alaUserInfoData = alaInfoData2.user_info) != null) {
                i = alaUserInfoData.anchor_fans;
            }
            if (TextUtils.isEmpty(this.I1) || i <= 0) {
                if (i > 0) {
                    this.I1 = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + StringHelper.numberUniformFormatExtraWithRoundInt(i);
                    return;
                }
                return;
            }
            this.I1 += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + StringHelper.numberUniformFormatExtraWithRoundInt(i);
        }
    }

    public void Y3(int i) {
        this.G = i;
    }

    public long Z() {
        return this.q0;
    }

    public int Z0() {
        return this.G;
    }

    public boolean Z1() {
        MetaData metaData = this.P;
        return (metaData == null || metaData.getGodUserData() == null || this.P.getGodUserData().getType() != 2) ? false : true;
    }

    public final void Z2() {
        MetaData metaData;
        MetaData metaData2;
        if ((this instanceof w0) && "0".equals(o0())) {
            this.I1 = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
            return;
        }
        if (!x2() && (!Y1() || getType() == f3)) {
            if (getType() != f3 && getType() != i3) {
                long B0 = B0() * 1000;
                if (B0 != 0) {
                    String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(B0);
                    if (StringHelper.isThisYear(formatTimeForJustNow)) {
                        formatTimeForJustNow = StringHelper.getFormatTimeShort(B0);
                    }
                    String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                    if (y()) {
                        formatTimeForJustNow = StringHelper.getFormatTimeForHomeC(B0);
                    }
                    this.I1 = string + formatTimeForJustNow;
                } else {
                    long j = this.q0;
                    String formatTimeForJustNow2 = StringHelper.getFormatTimeForJustNow(j);
                    if (StringHelper.isThisYear(formatTimeForJustNow2)) {
                        formatTimeForJustNow2 = StringHelper.getFormatTimeShort(j);
                    }
                    this.I1 = formatTimeForJustNow2;
                }
                if (m2()) {
                    a3();
                } else if (!this.T1 && (metaData2 = this.P) != null && metaData2.showBazhuGrade()) {
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getBazhuGradeData().getDesc(), this.S1 ? 24 : 16, StringHelper.STRING_MORE);
                    if (!TextUtils.isEmpty(this.I1)) {
                        this.I1 += "   " + cutChineseAndEnglishWithSuffix;
                    } else {
                        this.I1 = cutChineseAndEnglishWithSuffix;
                    }
                }
                if (TextUtils.isEmpty(this.I1) || TextUtils.isEmpty(K())) {
                    return;
                }
                this.I1 += " • " + K();
                return;
            }
            Y2();
            return;
        }
        long j2 = this.q0;
        if (j2 != 0) {
            String formatTimeForJustNow3 = StringHelper.getFormatTimeForJustNow(j2);
            if (StringHelper.isThisYear(formatTimeForJustNow3)) {
                formatTimeForJustNow3 = StringHelper.getFormatTimeShort(j2);
            }
            this.I1 = formatTimeForJustNow3;
        }
        MetaData metaData3 = this.P;
        String str = (metaData3 == null || metaData3.getBaijiahaoInfo() == null || TextUtils.isEmpty(this.P.getBaijiahaoInfo().auth_desc)) ? "" : this.P.getBaijiahaoInfo().auth_desc;
        if (m2()) {
            a3();
        } else if (!this.T1 && (metaData = this.P) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix2 = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
            if (!TextUtils.isEmpty(this.I1)) {
                this.I1 += "   " + cutChineseAndEnglishWithSuffix2;
                return;
            }
            this.I1 = cutChineseAndEnglishWithSuffix2;
        } else if (!TextUtils.isEmpty(this.I1) && !TextUtils.isEmpty(str)) {
            this.I1 += "   " + str;
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.I1 = str;
        }
    }

    public void Z3(int i) {
        this.n = i;
    }

    public long a0() {
        return this.h1.disAgreeNum;
    }

    public int a1() {
        return this.n;
    }

    public boolean a2() {
        return this.p2;
    }

    public final void a3() {
        if (!m2() || TextUtils.isEmpty(this.P.getNewGodData().getFieldName())) {
            return;
        }
        if (!TextUtils.isEmpty(this.I1)) {
            this.I1 += "   " + this.P.getNewGodData().getFieldName() + d.b.h0.z0.l0.c(this.P.getNewGodData().isVideoGod());
            return;
        }
        this.I1 = this.P.getNewGodData().getFieldName() + d.b.h0.z0.l0.c(this.P.getNewGodData().isVideoGod());
    }

    public void a4(List<PbContent> list) {
        this.u = list;
    }

    public SparseArray<String> b0() {
        return this.d1;
    }

    public List<PbContent> b1() {
        return this.t;
    }

    public boolean b2() {
        return this.Y0;
    }

    public void b3() {
        MetaData metaData;
        if (x2() || Y1()) {
            return;
        }
        long B0 = B0() * 1000;
        if (B0 != 0) {
            String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(B0);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(B0);
            }
            this.I1 = formatTimeForJustNow;
        }
        if (m2()) {
            a3();
        } else if (!this.T1 && (metaData = this.P) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
            if (!TextUtils.isEmpty(this.I1)) {
                this.I1 += "   " + cutChineseAndEnglishWithSuffix;
            } else {
                this.I1 = cutChineseAndEnglishWithSuffix;
            }
        }
        if (TextUtils.isEmpty(this.I1) || TextUtils.isEmpty(K())) {
            return;
        }
        this.I1 += " • " + K();
    }

    public void b4(List<PbContent> list) {
        this.t = list;
    }

    public long c0() {
        return this.B;
    }

    public String c1() {
        return this.L0;
    }

    public boolean c2() {
        return this.Z == 41;
    }

    public final void c3() {
        this.K1 = StringHelper.getFormatTimeShort(B0() * 1000);
    }

    public void c4(String str) {
        this.E = str;
    }

    public String d0() {
        return this.D;
    }

    public String d1() {
        return this.E;
    }

    public boolean d2() {
        return o1() != null && s1() == 41 && s0() == 1 && p1() == 2;
    }

    public final void d3() {
        this.L1 = StringHelper.getFormatTimeShort(B0());
    }

    public void d4(long j) {
        this.j1 = j;
    }

    public List<PbContent> e0() {
        return this.v;
    }

    public String e1() {
        return this.N1;
    }

    public boolean e2() {
        return this.l1;
    }

    public final void e3() {
        if (q1() != null && q1().share_info != null && q1().share_info.share_user_count > 0 && p2() && (this.p1 <= 0 || this.q1 != 0)) {
            int i = q1().share_info.share_user_count;
            if (i == 1) {
                this.J1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
                return;
            } else {
                this.J1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i)});
                return;
            }
        }
        this.J1 = null;
    }

    public void e4(boolean z) {
        this.G1 = z;
    }

    public String f0() {
        return this.u0;
    }

    public String f1() {
        return this.J1;
    }

    public boolean f2() {
        return this.Z == 41;
    }

    public final void f3() {
        SpannableStringBuilder K22 = K2();
        this.x = K22;
        d.b.i0.x.m.b(this, K22, true);
    }

    public void f4(int i) {
        this.c1 = i;
    }

    @Override // d.b.h0.r.q.a
    public v0 g() {
        SparseArray<String> sparseArray = this.d1;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        v0 v0Var = new v0();
        n();
        v0Var.n(w1());
        n();
        v0Var.k(c0());
        n();
        v0Var.m(L0());
        v0Var.j(this.d1);
        v0Var.f50907g = this.e1;
        v0Var.o = this.T0;
        v0Var.j = this.S0;
        v0Var.l = this.U0;
        v0Var.k = this.R0;
        v0Var.p = this.M1;
        v0Var.n = U0();
        return v0Var;
    }

    public String g0() {
        return this.c0;
    }

    public long g1() {
        return this.j1;
    }

    public boolean g2() {
        return s1() == 50;
    }

    public final void g3() {
        if (StringUtils.isNull(this.P.getName_show())) {
            return;
        }
        this.H1 = StringHelper.cutChineseAndEnglishWithSuffix(this.P.getName_show(), 14, StringHelper.STRING_MORE);
    }

    public void g4(int i) {
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> K0 = K0();
        if (K0 == null || u2()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < K0.size() && i < 3; i++) {
            if (K0.get(i) != null && K0.get(i).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(K0.get(i).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = K0.get(i).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = K0.get(i).getPicUrl();
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
        VideoInfo videoInfo = this.k0;
        if (videoInfo != null && !StringUtils.isNull(videoInfo.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.k0.thumbnail_url;
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

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        OriginalThreadInfo originalThreadInfo;
        d.b.i0.c3.h0.n nVar = this.C2;
        if (nVar != null) {
            return nVar.d() ? this.C2.e() ? AdvertAppInfo.m4 : AdvertAppInfo.n4 : this.C2.e() ? AdvertAppInfo.m4 : AdvertAppInfo.l4;
        } else if (r0()) {
            if (u1() != null) {
                return e3;
            }
            return H2;
        } else {
            int x0 = x0();
            if (this.v1 == 1) {
                if (this.w1 != null) {
                    return V2;
                }
                return this.z1 != null ? p3 : o3;
            } else if (this.n0 != null && this.Z == 60) {
                return h3;
            } else {
                if (this.n0 != null && this.Z == 49) {
                    return f3;
                }
                if (this.n0 != null && this.Z == 67) {
                    return i3;
                }
                int i = this.Z;
                if (i == 51) {
                    return g3;
                }
                if (i == 63) {
                    return q3;
                }
                if (i == 64) {
                    return r3;
                }
                if (x0 != 2 && x0 != 1) {
                    if (this.k0 != null && b2() && !f2()) {
                        return w3;
                    }
                    if (this.k0 != null && !f2()) {
                        if (Z1()) {
                            return n3;
                        }
                        if (this instanceof w0) {
                            return x3;
                        }
                        return e3;
                    } else if (this.s1 && (originalThreadInfo = this.r1) != null) {
                        if (originalThreadInfo.u) {
                            if (originalThreadInfo.r != null) {
                                return m3;
                            }
                            if (originalThreadInfo.d()) {
                                return l3;
                            }
                            return k3;
                        }
                        return j3;
                    } else if (O1()) {
                        return W2;
                    } else {
                        if (d2()) {
                            return t3.get() ? A3 : H2;
                        } else if (L1() && G() == 1) {
                            return t3.get() ? B3 : H2;
                        } else if (e2()) {
                            return c3;
                        } else {
                            if (Z1()) {
                                return d3;
                            }
                            if (this.f50702e) {
                                return N2;
                            }
                            if (this.f50703f) {
                                return O2;
                            }
                            if (this.f50704g) {
                                return P2;
                            }
                            if (this.f50705h) {
                                return Q2;
                            }
                            if (this.i) {
                                return R2;
                            }
                            if (this.k) {
                                return T2;
                            }
                            if (this.l) {
                                return U2;
                            }
                            if (this.j) {
                                return S2;
                            }
                            if (this.m) {
                                return Y2;
                            }
                            if (this.v0) {
                                int V22 = V2();
                                if (V22 == 1) {
                                    return J2;
                                }
                                if (V22 == 2) {
                                    return K2;
                                }
                                if (V22 > 2) {
                                    return L2;
                                }
                                return H2;
                            }
                            return H2;
                        }
                    }
                }
                return G2;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        VideoInfo videoInfo = this.k0;
        if (videoInfo != null) {
            return videoInfo.video_url;
        }
        return null;
    }

    public w1 h0() {
        return this.C;
    }

    public int h1() {
        return this.R;
    }

    public boolean h2() {
        return s1() == 49;
    }

    public void h3(String str) {
        this.s = str;
    }

    public void h4(String str, String str2) {
        this.K0 = str;
        this.L0 = str2;
    }

    public String i0() {
        return this.Q;
    }

    public SkinInfo i1() {
        return this.M0;
    }

    public boolean i2() {
        return this.A1;
    }

    public void i3(ArrayList<b> arrayList) {
        this.w0 = arrayList;
    }

    public void i4(AlaInfoData alaInfoData) {
        this.n0 = alaInfoData;
    }

    public String j0() {
        return this.f1;
    }

    public SmartApp j1() {
        return this.F1;
    }

    public boolean j2() {
        return this.B1;
    }

    public void j3(String str) {
        this.g0 = str;
    }

    public void j4(String str) {
        this.I1 = str;
    }

    public String k0() {
        return this.s0;
    }

    public int k1() {
        return this.c1;
    }

    public boolean k2() {
        return this.g1;
    }

    public void k3(int i) {
        this.h1.agreeNum = i;
    }

    public void k4(int i) {
        this.Z = i;
    }

    public List<PbGoodsData> l0() {
        return this.o2;
    }

    public SpannableStringBuilder l1() {
        return this.w;
    }

    public boolean l2() {
        return this.X0;
    }

    public void l3(long j) {
        this.h1.agreeNum = j;
    }

    public void l4(String str) {
        this.A = str;
    }

    public int m0() {
        return this.h1.hasAgree ? 1 : 0;
    }

    public int m1() {
        return this.k2;
    }

    public boolean m2() {
        MetaData metaData = this.P;
        return metaData != null && metaData.isNewGod();
    }

    public void m3(int i) {
        this.h1.agreeType = i;
    }

    public void m4(String str) {
        this.r = str;
    }

    @Override // d.b.h0.r.q.a
    public a2 n() {
        return this;
    }

    public VideoInfo n0() {
        return this.z1;
    }

    public String n1() {
        return this.l2;
    }

    public boolean n2() {
        return this.p0 == 1;
    }

    public void n3(int i) {
        this.o0 = i;
    }

    public void n4(String str) {
        this.y1 = str;
    }

    @Override // d.b.h0.r.q.a
    public boolean o() {
        return this.S1;
    }

    public String o0() {
        return this.z;
    }

    public y1 o1() {
        return this.C0;
    }

    public boolean o2() {
        return s1() == 40;
    }

    public void o3(String str) {
        this.f2 = str;
    }

    public void o4(String str) {
        this.x1 = str;
    }

    public int[] p0() {
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(d.b.b.e.p.l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i11 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> K0 = K0();
        if (d.b.h0.r.k.c().g() && ListUtils.getCount(K0) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i12 = 0; i12 < K0.size(); i12++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i12);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) ListUtils.getItem(K0, 0);
        if (mediaData2 == null || (i2 = mediaData2.picWidth) <= 0 || (i = mediaData2.picHeight) <= 0) {
            i11 = (i11 * 2) + dimensionPixelSize;
            i = i11;
        } else {
            if (i2 * 2 <= i) {
                i9 = ((int) (i11 * 1.5f)) + dimensionPixelSize;
                i10 = i11 * 2;
            } else if (i * 2 <= i2) {
                i9 = (i11 * 2) + dimensionPixelSize;
                i10 = (int) (i11 * 1.5f);
            } else if (i2 >= i11) {
                if (i2 < i11 || i2 >= (i8 = i11 * 2)) {
                    int i13 = mediaData2.picHeight;
                    if (i13 >= i11) {
                        if (i13 >= i11 && i13 < (i7 = i11 * 2)) {
                            i11 = i7 + dimensionPixelSize;
                            i4 = (i13 * i11) / mediaData2.picWidth;
                        } else {
                            int i14 = mediaData2.picWidth;
                            int i15 = mediaData2.picHeight;
                            if (i14 < i15) {
                                i5 = (i11 * 2) + dimensionPixelSize;
                                i6 = (i14 * i5) / i15;
                            } else {
                                i11 = (i11 * 2) + dimensionPixelSize;
                                i4 = (i15 * i11) / i14;
                            }
                        }
                        i = i4;
                    }
                    i11 = 0;
                    i = 0;
                } else if (i < i11) {
                    i2 = (i2 * i11) / i;
                    i = i11;
                    i11 = i2;
                } else {
                    if (i < i11 || i >= i8) {
                        i5 = i8 + dimensionPixelSize;
                        i6 = (mediaData2.picWidth * i5) / mediaData2.picHeight;
                    }
                    i11 = i2;
                }
                i = i5;
                i11 = i6;
            } else if (i >= i11) {
                if (i >= i11 && i < i11 * 2) {
                    i = (i * i11) / i2;
                }
                i11 = 0;
                i = 0;
            } else if (i2 < i) {
                i = (i * i11) / i2;
            } else {
                i2 = (i2 * i11) / i;
                i = i11;
                i11 = i2;
            }
            i = i10 + dimensionPixelSize;
            i11 = i9;
        }
        iArr[0] = i11;
        iArr[1] = i;
        d.b.h0.b.g.b.i(this, iArr);
        return iArr;
    }

    public int p1() {
        y1 y1Var = this.C0;
        if (y1Var != null) {
            long e2 = y1Var.e();
            long a2 = this.C0.a();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < e2) {
                return 1;
            }
            return currentTimeMillis > a2 ? 3 : 2;
        }
        return -1;
    }

    public boolean p2() {
        return s1() == 60;
    }

    public void p3(MetaData metaData) {
        this.P = metaData;
    }

    public void p4(HashMap<String, MetaData> hashMap) {
        this.d0 = hashMap;
    }

    public int q0() {
        return this.Z0;
    }

    public AlaInfoData q1() {
        return this.n0;
    }

    public boolean q2() {
        return this.G1;
    }

    public void q3(BaijiahaoData baijiahaoData) {
        this.h2 = baijiahaoData;
    }

    public void q4(VideoInfo videoInfo) {
        this.k0 = videoInfo;
    }

    public boolean r0() {
        return this.E1;
    }

    public String r1() {
        return this.I1;
    }

    public boolean r2() {
        int i = this.Z;
        return i == 63 || i == 64;
    }

    public void r3(int i) {
        this.B0 = i;
    }

    public void r4(int i) {
        this.H = i;
    }

    public int s0() {
        return this.M;
    }

    public int s1() {
        return this.Z;
    }

    public boolean s2() {
        return this.R1;
    }

    public void s3(long j) {
        this.h1.diffAgreeNum = j;
    }

    public void s4(ArrayList<VoiceData$VoiceModel> arrayList) {
        this.U = arrayList;
    }

    public int t0() {
        return this.W;
    }

    public h2 t1() {
        return this.m0;
    }

    public boolean t2() {
        return this.V == 1;
    }

    public void t3(long j) {
        this.B = j;
    }

    public void t4(long j) {
        this.q0 = j;
    }

    public int u0() {
        return this.K;
    }

    public VideoInfo u1() {
        return this.k0;
    }

    public boolean u2() {
        return x0() != 0;
    }

    public void u3(String str) {
        this.D = str;
    }

    public void u4(List<PbGoodsData> list) {
        this.o2 = list;
        if (ListUtils.isEmpty(list) || this.p2) {
            return;
        }
        this.p2 = true;
    }

    public int v0() {
        return this.q;
    }

    public VideoDesc v1() {
        return this.l0;
    }

    public boolean v2() {
        return this.v1 == 1;
    }

    public void v3(List<PbContent> list) {
        this.v = list;
    }

    public final d.b.b.j.b v4(String str) {
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
            return new d.b.b.j.b(bitmapDrawable, 1);
        }
        return null;
    }

    public int w0() {
        return this.L;
    }

    public String w1() {
        if (!StringUtils.isNull(this.A) && !"0".equals(this.A)) {
            return this.A;
        }
        return this.z;
    }

    public boolean w2() {
        return this.C1 != null;
    }

    public void w3(boolean z) {
        this.N0 = z;
    }

    public void w4(int i) {
        this.q = i;
    }

    public int x0() {
        return this.J;
    }

    public String x1() {
        return this.r;
    }

    public boolean x2() {
        BaijiahaoData baijiahaoData = this.h2;
        if (baijiahaoData == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(baijiahaoData.oriUgcType);
    }

    public void x3(String str) {
        this.Q = str;
    }

    public void x4() {
        if (this.t0 == 0) {
            this.t0 = 1;
        }
    }

    public Item y0() {
        return this.q2;
    }

    public SpannableStringBuilder y1() {
        return this.x;
    }

    public boolean y2() {
        int i = this.Z;
        return i == 40 || i == 50;
    }

    public void y3(boolean z) {
        this.U1 = z;
    }

    public final SpannableStringBuilder z(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z4, boolean z5) {
        ArrayList<m.a> R0 = R0(z, z2, z4, z5);
        if (R0 == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder h2 = d.b.i0.x.m.h(TbadkCoreApplication.getInst(), str, R0, false);
        if (R0.size() > 0) {
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
        } else if (R0.size() > 0 || h2.length() == 0) {
            h2.append((CharSequence) str);
        }
        return h2;
    }

    public List<HeadItem> z0() {
        return this.s2;
    }

    public PostData z1() {
        return this.i1;
    }

    public boolean z2() {
        return y2() && C2();
    }

    public void z3(boolean z) {
        this.S1 = z;
    }
}
