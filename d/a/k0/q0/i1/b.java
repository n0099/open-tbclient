package d.a.k0.q0.i1;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
import d.a.c.e.p.l;
import d.a.k0.j2.c;
import d.a.k0.j2.o;
import d.a.k0.q0.i1.g;
/* loaded from: classes4.dex */
public class b extends d.a.k0.x.b<d.a.k0.q0.i1.g> implements d.a.k0.q0.i1.c {
    public LinearLayout A;
    public LinearLayout B;
    public d.a.k0.j2.c C;
    public TbPageContext<?> D;
    public d.a.k0.q0.i1.g E;
    public int F;
    public h G;
    public o H;
    public o I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public Animation N;
    public Animation O;
    public ScaleAnimation P;
    public boolean Q;
    public boolean R;
    public FrameLayout m;
    public FrameLayout n;
    public TextView o;
    public TextView p;
    public FrameLayout q;
    public TextView r;
    public TextView s;
    public HeadImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public ImageView y;
    public ImageView z;

    /* loaded from: classes4.dex */
    public class a implements c.x {
        public a() {
        }

        @Override // d.a.k0.j2.c.x
        public void a() {
            if (b.this.C.T0()) {
                b.this.p.setVisibility(8);
            }
        }

        @Override // d.a.k0.j2.c.x
        public void b() {
            if (b.this.C.T0()) {
                b.this.p.setVisibility(8);
            }
            if (b.this.M) {
                b.this.C.k2();
            }
        }
    }

    /* renamed from: d.a.k0.q0.i1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1485b implements c.g0 {
        public C1485b() {
        }

        @Override // d.a.k0.j2.c.g0
        public void a() {
            b.this.p.setVisibility(8);
            b bVar = b.this;
            bVar.onClick(bVar.m);
        }

        @Override // d.a.k0.j2.c.g0
        public void b() {
            b.this.M = false;
            b.this.p.setVisibility(8);
            b bVar = b.this;
            bVar.M(bVar.Q ? "1" : "2");
            b bVar2 = b.this;
            bVar2.onClick(bVar2.n);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a0 {
        public c() {
        }

        @Override // d.a.k0.j2.c.a0
        public void a(boolean z) {
            if (z) {
                b.this.D.showToast(b.this.r.getText().toString());
                b bVar = b.this;
                d.a.k0.j2.c cVar = bVar.C;
                d.a.k0.q0.i1.g gVar = bVar.E;
                cVar.d2(gVar.z.f58576d, gVar.f58549f);
                b.this.p.setVisibility(8);
                b.this.M("2");
            } else {
                b.this.q.setVisibility(0);
            }
            b bVar2 = b.this;
            bVar2.onClick(bVar2.n);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.y {
        public d() {
        }

        @Override // d.a.k0.j2.c.y
        public void a(boolean z) {
            if (!b.this.C.T0()) {
                b.this.o.setVisibility(0);
            } else if (z) {
                if (b.this.o.getVisibility() == 0) {
                    b.this.o.setVisibility(8);
                    b bVar = b.this;
                    bVar.o.startAnimation(bVar.N);
                }
            } else if (b.this.o.getVisibility() == 8) {
                b.this.o.setVisibility(0);
                b bVar2 = b.this;
                bVar2.o.startAnimation(bVar2.O);
            }
        }

        @Override // d.a.k0.j2.c.y
        public void b() {
            if (!b.this.C.T0()) {
                b.this.o.setVisibility(0);
            } else if (b.this.o.getVisibility() == 0) {
                b.this.o.setVisibility(8);
                b bVar = b.this;
                bVar.o.startAnimation(bVar.N);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.q0.i1.a f58535e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58536f;

        public e(d.a.k0.q0.i1.a aVar, int i2) {
            this.f58535e = aVar;
            this.f58536f = i2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (b.this.L) {
                b.this.M = true;
                b.this.K = false;
            }
            if (this.f58535e == null || b.this.L) {
                return;
            }
            this.f58535e.a(this.f58536f);
            b.this.C.a1();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CyberPlayerManager.OnErrorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.q0.i1.a f58538e;

        public f(d.a.k0.q0.i1.a aVar) {
            this.f58538e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            d.a.k0.q0.i1.g gVar = b.this.E;
            if (gVar != null && gVar.z != null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.E.z.f58576d);
            }
            d.a.k0.q0.i1.a aVar = this.f58538e;
            if (aVar != null) {
                aVar.cancel();
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements c.d0 {
        public g() {
        }

        @Override // d.a.k0.j2.c.d0
        public void a() {
            b.this.p.setVisibility(8);
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.K = true;
        this.R = z;
        View l = l();
        this.D = tbPageContext;
        this.m = (FrameLayout) l.findViewById(R.id.video_agg_container);
        FrameLayout frameLayout = (FrameLayout) l.findViewById(R.id.video_container);
        this.n = frameLayout;
        d.a.k0.j2.c cVar = new d.a.k0.j2.c(tbPageContext, frameLayout, false);
        this.C = cVar;
        cVar.O1("2005");
        this.o = (TextView) l.findViewById(R.id.title);
        this.p = (TextView) l.findViewById(R.id.duration);
        this.q = (FrameLayout) l.findViewById(R.id.mobile_network_container);
        this.r = (TextView) l.findViewById(R.id.mobile_network_text);
        this.s = (TextView) l.findViewById(R.id.mobile_network_play);
        this.t = (HeadImageView) l.findViewById(R.id.user_icon);
        this.u = (TextView) l.findViewById(R.id.user_name);
        this.v = (TextView) l.findViewById(R.id.attention);
        this.A = (LinearLayout) l.findViewById(R.id.thread_info_commont_container);
        this.B = (LinearLayout) l.findViewById(R.id.agree_view_container);
        this.w = (TextView) l.findViewById(R.id.thread_info_commont_num);
        this.x = (TextView) l.findViewById(R.id.thread_info_praise_num);
        this.y = (ImageView) l.findViewById(R.id.thread_info_commont_img);
        this.z = (ImageView) l.findViewById(R.id.thread_info_praise_img);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        l.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.F = l.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.height = (int) (this.F * 0.5625f);
        this.m.setLayoutParams(layoutParams);
        this.t.setIsRound(true);
        this.G = new h(this.D, this);
        this.N = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.O = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    public final Animation B() {
        if (this.P == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.P = scaleAnimation;
            scaleAnimation.setDuration(200L);
        }
        return this.P;
    }

    public final void F(d.a.k0.q0.i1.g gVar, int i2, d.a.k0.q0.i1.a aVar) {
        if (gVar == null || gVar.z == null) {
            return;
        }
        this.C.k2();
        this.C.s1(true);
        this.C.v1(false);
        this.C.y1(new a());
        this.C.G1(new C1485b());
        this.C.A1(new c());
        this.C.o1(false);
        o oVar = new o();
        this.H = oVar;
        oVar.f56720c = gVar.f58549f;
        oVar.f56721d = gVar.f58548e;
        oVar.f56722e = TbadkCoreApplication.getCurrentAccount();
        o oVar2 = new o();
        this.I = oVar2;
        oVar2.f56720c = gVar.f58549f;
        oVar2.f56721d = gVar.f58548e;
        oVar2.f56722e = TbadkCoreApplication.getCurrentAccount();
        if (this.R) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar.f58549f);
            statisticItem.param("nid", gVar.f58550g);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.p());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", gVar.f58548e);
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            o oVar3 = this.H;
            oVar3.f56724g = "auto_midpage";
            oVar3.f56718a = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            oVar3.f56726i = "1";
            o oVar4 = this.I;
            oVar4.f56724g = "auto_midpage";
            oVar4.f56718a = "auto_midpage";
            oVar4.f56726i = "1";
        } else {
            o oVar5 = this.H;
            oVar5.f56726i = "frs_bavideotab";
            oVar5.f56718a = Constants.VIA_REPORT_TYPE_SET_AVATAR;
            o oVar6 = this.I;
            oVar6.f56726i = "frs_bavideotab";
            oVar6.f56718a = "frs_bavideotab";
        }
        g.c cVar = gVar.z;
        if (cVar != null) {
            o oVar7 = this.H;
            String str = cVar.f58575c;
            oVar7.m = str;
            this.I.m = str;
        }
        this.C.I0().setVideoStatData(this.H);
        this.C.q0();
        this.C.z1(new d());
        this.C.I1(new e(aVar, i2));
        this.C.J1(new f(aVar));
        this.C.S1(gVar.z.j);
        this.C.Y1(gVar.z.f58576d, gVar.f58549f);
        this.C.X1(gVar.x);
        this.C.D1(new g());
        this.C.a1();
        this.C.a2();
        if (gVar.F) {
            onClick(this.n);
            this.M = false;
            this.C.i2(gVar.z.f58576d, gVar.f58549f, null, new Object[0]);
        }
        this.M = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: G */
    public void m(d.a.k0.q0.i1.g gVar) {
    }

    public void H(d.a.k0.q0.i1.g gVar, int i2, d.a.k0.q0.i1.a aVar) {
        String format;
        if (gVar == null || gVar.z == null) {
            return;
        }
        this.E = gVar;
        this.Q = gVar.F;
        this.o.setVisibility(0);
        this.o.setText(gVar.x);
        this.p.setVisibility(0);
        this.p.setText(StringHelper.stringForVideoTime(gVar.z.f58577e * 1000));
        long j = gVar.z.f58580h;
        if (j == 0) {
            format = this.D.getString(R.string.video_mobile_play_tips);
        } else {
            format = String.format(this.D.getString(R.string.video_mobile_network_tips), S(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
        }
        this.r.setText(format);
        this.q.setVisibility(8);
        F(gVar, i2, aVar);
        O(gVar);
        n(this.D, TbadkCoreApplication.getInst().getSkinType());
    }

    public void I(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        if (this.C == null || this.n == null || (tbPageContext = this.D) == null || tbPageContext.getPageActivity() == null || this.D.getPageActivity().getWindow() == null || !(this.D.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.D.getPageActivity().getWindow().getDecorView();
        if (this.K) {
            this.C.k1();
        }
        if (configuration.orientation == 2) {
            this.L = true;
            if (this.n.getParent() != null) {
                if (this.n.getParent() == frameLayout) {
                    frameLayout.removeView(this.n);
                } else {
                    ViewParent parent = this.n.getParent();
                    FrameLayout frameLayout2 = this.m;
                    if (parent == frameLayout2) {
                        frameLayout2.removeView(this.n);
                    }
                }
            }
            if (this.n.getParent() != null) {
                return;
            }
            frameLayout.addView(this.n);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.n.setLayoutParams(layoutParams);
        } else {
            this.L = false;
            if (this.n.getParent() != null) {
                if (this.n.getParent() == frameLayout) {
                    frameLayout.removeView(this.n);
                } else {
                    ViewParent parent2 = this.n.getParent();
                    FrameLayout frameLayout3 = this.m;
                    if (parent2 == frameLayout3) {
                        frameLayout3.removeView(this.n);
                    }
                }
            }
            if (this.n.getParent() != null) {
                return;
            }
            this.m.addView(this.n, 0);
            int i2 = this.F;
            this.n.setLayoutParams(new FrameLayout.LayoutParams(i2, (int) (i2 * 0.5625f)));
            this.C.q0();
            this.K = true;
        }
        this.C.V0(this.D, configuration);
        this.p.setVisibility(8);
    }

    public boolean J(int i2) {
        return this.C.f1(i2);
    }

    public void K() {
        if (isPlaying()) {
            this.C.W0();
        }
    }

    public void L() {
        d.a.k0.j2.c cVar = this.C;
        if (cVar != null) {
            cVar.v0();
        }
    }

    public final void M(String str) {
        d.a.k0.q0.i1.g gVar = this.E;
        if (gVar == null || gVar.z == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            d.a.k0.j2.h.e(this.E.z.f58575c, "", str, this.I, this.C.I0().getPcdnState());
        }
    }

    public void N(d.a.k0.q0.i1.g gVar) {
        if (gVar == null || gVar.y == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.y.f58559a) && TbadkCoreApplication.getCurrentAccount().equals(gVar.y.f58559a)) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        if (gVar.y.f58563e) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
            this.v.setCompoundDrawables(null, null, null, null);
            this.v.setText(this.D.getString(R.string.relate_forum_is_followed));
            return;
        }
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, l.g(this.f63162g, R.dimen.ds20), l.g(this.f63162g, R.dimen.ds20));
        this.v.setCompoundDrawables(drawable, null, null, null);
        this.v.setText(this.D.getString(R.string.attention));
    }

    public void O(d.a.k0.q0.i1.g gVar) {
        g.b bVar;
        if (gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        this.u.setText(TextUtils.isEmpty(bVar.f58561c) ? gVar.y.f58560b : gVar.y.f58561c);
        this.t.V(gVar.y.f58562d, 12, false);
        this.t.setShowV(gVar.y.f58564f);
        this.t.setIsBigV(gVar.y.f58564f);
        N(gVar);
        Q(gVar);
        P(gVar);
    }

    public void P(d.a.k0.q0.i1.g gVar) {
        if (gVar == null) {
            return;
        }
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0106);
        this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.w.setText(StringHelper.numFormatOverWan(gVar.k));
    }

    public void Q(d.a.k0.q0.i1.g gVar) {
        if (gVar == null) {
            return;
        }
        if (gVar.p) {
            this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0301);
        } else {
            this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0106);
        }
        this.x.setText(StringHelper.numFormatOverWan(gVar.m));
    }

    public void R() {
        this.q.setVisibility(8);
        this.C.k2();
        TextView textView = this.o;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.p;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    public String S(String str) {
        return str.indexOf(".") > 0 ? str.replaceAll("0+?$", "").replaceAll("[.]$", "") : str;
    }

    @Override // d.a.k0.q0.i1.c
    public void c(String str) {
        this.D.showToast(str);
    }

    @Override // d.a.k0.q0.i1.c
    public void d() {
        d.a.k0.q0.i1.g gVar = this.E;
        if (gVar == null) {
            return;
        }
        boolean z = !gVar.p;
        gVar.p = z;
        if (z) {
            gVar.m++;
        } else {
            gVar.m--;
        }
        ImageView imageView = this.z;
        if (imageView != null) {
            imageView.startAnimation(B());
        }
        Q(this.E);
    }

    @Override // d.a.k0.q0.i1.c
    public void e(boolean z) {
        g.b bVar;
        d.a.k0.q0.i1.g gVar = this.E;
        if (gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        bVar.f58563e = z;
        N(gVar);
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.card_video_aggregation_layout;
    }

    public boolean isPlaying() {
        return this.C.T0();
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        g.b bVar;
        if (this.f63160e != i2) {
            tbPageContext.getLayoutMode().k(i2 == 1);
            tbPageContext.getLayoutMode().j(l());
            SkinManager.setBackgroundColor(l(), R.color.CAM_X0201);
            d.a.k0.q0.i1.g gVar = this.E;
            if (gVar != null && (bVar = gVar.y) != null) {
                if (bVar.f58563e) {
                    SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
                    this.v.setCompoundDrawables(null, null, null, null);
                } else {
                    SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
                    Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.g(this.f63162g, R.dimen.ds20), l.g(this.f63162g, R.dimen.ds20));
                    this.v.setCompoundDrawables(drawable, null, null, null);
                }
            }
            d.a.k0.q0.i1.g gVar2 = this.E;
            if (gVar2 != null) {
                if (gVar2.p) {
                    this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
                    SkinManager.setViewTextColor(this.x, R.color.CAM_X0301);
                } else {
                    this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
                    SkinManager.setViewTextColor(this.x, R.color.CAM_X0106);
                }
            }
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0106);
            this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        }
        this.f63160e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        if (h() != null) {
            view.setTag(this);
            h().a(view, this.E);
        }
        if (view != this.t && view != this.u) {
            if (view != this.A && view != this.o && view != l()) {
                if (view == this.s) {
                    d.a.k0.q0.i1.g gVar = this.E;
                    if (gVar == null || gVar.z == null) {
                        return;
                    }
                    this.q.setVisibility(8);
                    this.C.j1();
                    d.a.k0.j2.c cVar = this.C;
                    d.a.k0.q0.i1.g gVar2 = this.E;
                    cVar.d2(gVar2.z.f58576d, gVar2.f58549f);
                    M("2");
                    return;
                } else if (view == this.v) {
                    d.a.k0.q0.i1.g gVar3 = this.E;
                    if (gVar3.y.f58563e) {
                        return;
                    }
                    this.G.c(gVar3);
                    return;
                } else if (view == this.B) {
                    d.a.j0.i0.c k = TbPageExtraHelper.k(b());
                    if (k != null) {
                        this.E.u = k.a();
                    }
                    this.G.d(this.E);
                    return;
                } else {
                    return;
                }
            } else if (this.E == null) {
                return;
            } else {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f63162g);
                pbActivityConfig.createNormalCfg(this.E.f58549f, null, null);
                if (!this.R) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source("auto_midpage");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                return;
            }
        }
        boolean z = false;
        d.a.k0.q0.i1.g gVar4 = this.E;
        if (gVar4 == null || (bVar = gVar4.y) == null || TextUtils.isEmpty(bVar.f58559a)) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && this.E.y.f58559a.equals(TbadkCoreApplication.getCurrentAccount())) {
            z = true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.D.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(this.E.y.f58559a, 0L), z, this.E.y.f58564f)));
    }

    public void onDestroy() {
        L();
        h hVar = this.G;
        if (hVar != null) {
            hVar.b();
        }
    }
}
