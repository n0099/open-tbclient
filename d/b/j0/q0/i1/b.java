package d.b.j0.q0.i1;

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
import d.b.c.e.p.l;
import d.b.j0.j2.c;
import d.b.j0.j2.o;
import d.b.j0.q0.i1.g;
/* loaded from: classes4.dex */
public class b extends d.b.j0.x.b<d.b.j0.q0.i1.g> implements d.b.j0.q0.i1.c {
    public LinearLayout A;
    public LinearLayout B;
    public d.b.j0.j2.c C;
    public TbPageContext<?> D;
    public d.b.j0.q0.i1.g E;
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

        @Override // d.b.j0.j2.c.x
        public void a() {
            if (b.this.C.T0()) {
                b.this.p.setVisibility(8);
            }
        }

        @Override // d.b.j0.j2.c.x
        public void b() {
            if (b.this.C.T0()) {
                b.this.p.setVisibility(8);
            }
            if (b.this.M) {
                b.this.C.k2();
            }
        }
    }

    /* renamed from: d.b.j0.q0.i1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1472b implements c.g0 {
        public C1472b() {
        }

        @Override // d.b.j0.j2.c.g0
        public void a() {
            b.this.M = false;
            b.this.p.setVisibility(8);
            b bVar = b.this;
            bVar.P(bVar.Q ? "1" : "2");
            b bVar2 = b.this;
            bVar2.onClick(bVar2.n);
        }

        @Override // d.b.j0.j2.c.g0
        public void b() {
            b.this.p.setVisibility(8);
            b bVar = b.this;
            bVar.onClick(bVar.m);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a0 {
        public c() {
        }

        @Override // d.b.j0.j2.c.a0
        public void a(boolean z) {
            if (z) {
                b.this.D.showToast(b.this.r.getText().toString());
                b bVar = b.this;
                d.b.j0.j2.c cVar = bVar.C;
                d.b.j0.q0.i1.g gVar = bVar.E;
                cVar.d2(gVar.z.f59766d, gVar.f59740f);
                b.this.p.setVisibility(8);
                b.this.P("2");
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

        @Override // d.b.j0.j2.c.y
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

        @Override // d.b.j0.j2.c.y
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
        public final /* synthetic */ d.b.j0.q0.i1.a f59727e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59728f;

        public e(d.b.j0.q0.i1.a aVar, int i) {
            this.f59727e = aVar;
            this.f59728f = i;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (b.this.L) {
                b.this.M = true;
                b.this.K = false;
            }
            if (this.f59727e == null || b.this.L) {
                return;
            }
            this.f59727e.a(this.f59728f);
            b.this.C.a1();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CyberPlayerManager.OnErrorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.q0.i1.a f59730e;

        public f(d.b.j0.q0.i1.a aVar) {
            this.f59730e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            d.b.j0.q0.i1.g gVar = b.this.E;
            if (gVar != null && gVar.z != null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", b.this.E.z.f59766d);
            }
            d.b.j0.q0.i1.a aVar = this.f59730e;
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

        @Override // d.b.j0.j2.c.d0
        public void a() {
            b.this.p.setVisibility(8);
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.K = true;
        this.R = z;
        View m = m();
        this.D = tbPageContext;
        this.m = (FrameLayout) m.findViewById(R.id.video_agg_container);
        FrameLayout frameLayout = (FrameLayout) m.findViewById(R.id.video_container);
        this.n = frameLayout;
        d.b.j0.j2.c cVar = new d.b.j0.j2.c(tbPageContext, frameLayout, false);
        this.C = cVar;
        cVar.O1("2005");
        this.o = (TextView) m.findViewById(R.id.title);
        this.p = (TextView) m.findViewById(R.id.duration);
        this.q = (FrameLayout) m.findViewById(R.id.mobile_network_container);
        this.r = (TextView) m.findViewById(R.id.mobile_network_text);
        this.s = (TextView) m.findViewById(R.id.mobile_network_play);
        this.t = (HeadImageView) m.findViewById(R.id.user_icon);
        this.u = (TextView) m.findViewById(R.id.user_name);
        this.v = (TextView) m.findViewById(R.id.attention);
        this.A = (LinearLayout) m.findViewById(R.id.thread_info_commont_container);
        this.B = (LinearLayout) m.findViewById(R.id.agree_view_container);
        this.w = (TextView) m.findViewById(R.id.thread_info_commont_num);
        this.x = (TextView) m.findViewById(R.id.thread_info_praise_num);
        this.y = (ImageView) m.findViewById(R.id.thread_info_commont_img);
        this.z = (ImageView) m.findViewById(R.id.thread_info_praise_img);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        m.setOnClickListener(this);
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

    public final Animation F() {
        if (this.P == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.P = scaleAnimation;
            scaleAnimation.setDuration(200L);
        }
        return this.P;
    }

    public final void G(d.b.j0.q0.i1.g gVar, int i, d.b.j0.q0.i1.a aVar) {
        if (gVar == null || gVar.z == null) {
            return;
        }
        this.C.k2();
        this.C.s1(true);
        this.C.v1(false);
        this.C.y1(new a());
        this.C.G1(new C1472b());
        this.C.A1(new c());
        this.C.o1(false);
        o oVar = new o();
        this.H = oVar;
        oVar.f58034c = gVar.f59740f;
        oVar.f58035d = gVar.f59739e;
        oVar.f58036e = TbadkCoreApplication.getCurrentAccount();
        o oVar2 = new o();
        this.I = oVar2;
        oVar2.f58034c = gVar.f59740f;
        oVar2.f58035d = gVar.f59739e;
        oVar2.f58036e = TbadkCoreApplication.getCurrentAccount();
        if (this.R) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar.f59740f);
            statisticItem.param("nid", gVar.f59741g);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.o());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", gVar.f59739e);
            statisticItem.param("obj_locate", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            o oVar3 = this.H;
            oVar3.f58038g = "auto_midpage";
            oVar3.f58032a = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            oVar3.i = "1";
            o oVar4 = this.I;
            oVar4.f58038g = "auto_midpage";
            oVar4.f58032a = "auto_midpage";
            oVar4.i = "1";
        } else {
            o oVar5 = this.H;
            oVar5.i = "frs_bavideotab";
            oVar5.f58032a = Constants.VIA_REPORT_TYPE_SET_AVATAR;
            o oVar6 = this.I;
            oVar6.i = "frs_bavideotab";
            oVar6.f58032a = "frs_bavideotab";
        }
        g.c cVar = gVar.z;
        if (cVar != null) {
            o oVar7 = this.H;
            String str = cVar.f59765c;
            oVar7.m = str;
            this.I.m = str;
        }
        this.C.I0().setVideoStatData(this.H);
        this.C.q0();
        this.C.z1(new d());
        this.C.I1(new e(aVar, i));
        this.C.J1(new f(aVar));
        this.C.S1(gVar.z.j);
        this.C.Y1(gVar.z.f59766d, gVar.f59740f);
        this.C.X1(gVar.x);
        this.C.D1(new g());
        this.C.a1();
        this.C.a2();
        if (gVar.F) {
            onClick(this.n);
            this.M = false;
            this.C.i2(gVar.z.f59766d, gVar.f59740f, null, new Object[0]);
        }
        this.M = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: I */
    public void n(d.b.j0.q0.i1.g gVar) {
    }

    public void J(d.b.j0.q0.i1.g gVar, int i, d.b.j0.q0.i1.a aVar) {
        String format;
        if (gVar == null || gVar.z == null) {
            return;
        }
        this.E = gVar;
        this.Q = gVar.F;
        this.o.setVisibility(0);
        this.o.setText(gVar.x);
        this.p.setVisibility(0);
        this.p.setText(StringHelper.stringForVideoTime(gVar.z.f59767e * 1000));
        long j = gVar.z.f59770h;
        if (j == 0) {
            format = this.D.getString(R.string.video_mobile_play_tips);
        } else {
            format = String.format(this.D.getString(R.string.video_mobile_network_tips), V(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
        }
        this.r.setText(format);
        this.q.setVisibility(8);
        G(gVar, i, aVar);
        R(gVar);
        o(this.D, TbadkCoreApplication.getInst().getSkinType());
    }

    public void K(Configuration configuration) {
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
            int i = this.F;
            this.n.setLayoutParams(new FrameLayout.LayoutParams(i, (int) (i * 0.5625f)));
            this.C.q0();
            this.K = true;
        }
        this.C.V0(this.D, configuration);
        this.p.setVisibility(8);
    }

    public boolean L(int i) {
        return this.C.f1(i);
    }

    public void M() {
        if (isPlaying()) {
            this.C.W0();
        }
    }

    public void O() {
        d.b.j0.j2.c cVar = this.C;
        if (cVar != null) {
            cVar.v0();
        }
    }

    public final void P(String str) {
        d.b.j0.q0.i1.g gVar = this.E;
        if (gVar == null || gVar.z == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            d.b.j0.j2.h.e(this.E.z.f59765c, "", str, this.I, this.C.I0().getPcdnState());
        }
    }

    public void Q(d.b.j0.q0.i1.g gVar) {
        if (gVar == null || gVar.y == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.y.f59749a) && TbadkCoreApplication.getCurrentAccount().equals(gVar.y.f59749a)) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        if (gVar.y.f59753e) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
            this.v.setCompoundDrawables(null, null, null, null);
            this.v.setText(this.D.getString(R.string.relate_forum_is_followed));
            return;
        }
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, l.g(this.f64178g, R.dimen.ds20), l.g(this.f64178g, R.dimen.ds20));
        this.v.setCompoundDrawables(drawable, null, null, null);
        this.v.setText(this.D.getString(R.string.attention));
    }

    public void R(d.b.j0.q0.i1.g gVar) {
        g.b bVar;
        if (gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        this.u.setText(TextUtils.isEmpty(bVar.f59751c) ? gVar.y.f59750b : gVar.y.f59751c);
        this.t.W(gVar.y.f59752d, 12, false);
        this.t.setShowV(gVar.y.f59754f);
        this.t.setIsBigV(gVar.y.f59754f);
        Q(gVar);
        T(gVar);
        S(gVar);
    }

    public void S(d.b.j0.q0.i1.g gVar) {
        if (gVar == null) {
            return;
        }
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0106);
        this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.w.setText(StringHelper.numFormatOverWan(gVar.k));
    }

    public void T(d.b.j0.q0.i1.g gVar) {
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

    public void U() {
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

    public String V(String str) {
        return str.indexOf(".") > 0 ? str.replaceAll("0+?$", "").replaceAll("[.]$", "") : str;
    }

    @Override // d.b.j0.q0.i1.c
    public void c(String str) {
        this.D.showToast(str);
    }

    @Override // d.b.j0.q0.i1.c
    public void d(boolean z) {
        g.b bVar;
        d.b.j0.q0.i1.g gVar = this.E;
        if (gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        bVar.f59753e = z;
        Q(gVar);
    }

    @Override // d.b.j0.q0.i1.c
    public void e() {
        d.b.j0.q0.i1.g gVar = this.E;
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
            imageView.startAnimation(F());
        }
        T(this.E);
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.card_video_aggregation_layout;
    }

    public boolean isPlaying() {
        return this.C.T0();
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        g.b bVar;
        if (this.f64176e != i) {
            tbPageContext.getLayoutMode().k(i == 1);
            tbPageContext.getLayoutMode().j(m());
            SkinManager.setBackgroundColor(m(), R.color.CAM_X0201);
            d.b.j0.q0.i1.g gVar = this.E;
            if (gVar != null && (bVar = gVar.y) != null) {
                if (bVar.f59753e) {
                    SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
                    this.v.setCompoundDrawables(null, null, null, null);
                } else {
                    SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
                    Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.g(this.f64178g, R.dimen.ds20), l.g(this.f64178g, R.dimen.ds20));
                    this.v.setCompoundDrawables(drawable, null, null, null);
                }
            }
            d.b.j0.q0.i1.g gVar2 = this.E;
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
        this.f64176e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        if (i() != null) {
            view.setTag(this);
            i().a(view, this.E);
        }
        if (view != this.t && view != this.u) {
            if (view != this.A && view != this.o && view != m()) {
                if (view == this.s) {
                    d.b.j0.q0.i1.g gVar = this.E;
                    if (gVar == null || gVar.z == null) {
                        return;
                    }
                    this.q.setVisibility(8);
                    this.C.j1();
                    d.b.j0.j2.c cVar = this.C;
                    d.b.j0.q0.i1.g gVar2 = this.E;
                    cVar.d2(gVar2.z.f59766d, gVar2.f59740f);
                    P("2");
                    return;
                } else if (view == this.v) {
                    d.b.j0.q0.i1.g gVar3 = this.E;
                    if (gVar3.y.f59753e) {
                        return;
                    }
                    this.G.c(gVar3);
                    return;
                } else if (view == this.B) {
                    d.b.i0.i0.c k = TbPageExtraHelper.k(b());
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
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f64178g);
                pbActivityConfig.createNormalCfg(this.E.f59740f, null, null);
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
        d.b.j0.q0.i1.g gVar4 = this.E;
        if (gVar4 == null || (bVar = gVar4.y) == null || TextUtils.isEmpty(bVar.f59749a)) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && this.E.y.f59749a.equals(TbadkCoreApplication.getCurrentAccount())) {
            z = true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.D.getPageActivity()).createNormalConfig(d.b.c.e.m.b.f(this.E.y.f59749a, 0L), z, this.E.y.f59754f)));
    }

    public void onDestroy() {
        O();
        h hVar = this.G;
        if (hVar != null) {
            hVar.b();
        }
    }
}
