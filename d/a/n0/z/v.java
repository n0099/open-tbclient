package d.a.n0.z;

import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.b2;
import d.a.m0.r.q.v0;
/* loaded from: classes4.dex */
public class v extends d.a.n0.z.b<b2> implements Object {
    public boolean A;
    public TbImageView B;
    public String C;
    public String D;
    public String E;
    public View F;
    public ViewGroup G;
    public final View.OnClickListener H;
    public OriginalThreadCardView.b I;
    public HeadPendantClickableView m;
    public ThreadUserInfoLayout n;
    public TextView o;
    public TextView p;
    public OriginalThreadCardView q;
    public ThreadCommentAndPraiseInfoLayout r;
    public ThreadSourceShareAndPraiseLayout s;
    public NEGFeedBackView t;
    public View u;
    public View v;
    public TbImageView w;
    public TbPageContext<?> x;
    public b2 y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (v.this.h() != null) {
                v.this.h().a(view, v.this.y);
            }
            if (v.this.y == null || v.this.y.f49949e == null) {
                return;
            }
            m.a(v.this.y.f49949e.o0());
            v vVar = v.this;
            vVar.G(vVar.y.f49949e.o0());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (v.this.h() != null) {
                v.this.h().a(view, v.this.y);
            }
            v vVar = v.this;
            if (view == vVar.s.f12400e || vVar.y == null || v.this.y.f49949e == null) {
                return;
            }
            m.a(v.this.y.f49949e.o0());
            v vVar2 = v.this;
            vVar2.G(vVar2.y.f49949e.o0());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.this.r.changeSelectStatus();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.j {
        public d() {
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            SkinManager.setBackgroundColor(v.this.F, z ? R.color.CAM_X0201 : R.color.transparent);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a2 f63583e;

        public e(a2 a2Var) {
            this.f63583e = a2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (v.this.x != null) {
                v.this.f63441f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.f63441f.getContext(), "", this.f63583e.v1, true)));
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f63585e;

        public f(ThemeCardInUserData themeCardInUserData) {
            this.f63585e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.x.getPageActivity(), this.f63585e.getCardId())));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (v.this.h() != null) {
                v.this.h().a(view, v.this.y);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements OriginalThreadCardView.b {
        public h() {
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            if (v.this.y == null || v.this.y.f49949e == null) {
                return;
            }
            if (v.this.h() != null) {
                b0<b2> h2 = v.this.h();
                v vVar = v.this;
                h2.a(vVar.q, vVar.y);
            }
            String o0 = v.this.y.f49949e.o0();
            m.a(o0);
            v.this.G(o0);
        }
    }

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.t = null;
        this.z = true;
        this.H = new g();
        this.I = new h();
        this.x = tbPageContext;
        View l = l();
        ViewGroup viewGroup = (ViewGroup) l.findViewById(R.id.thread_content_layout_outter);
        this.G = viewGroup;
        viewGroup.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) l.findViewById(R.id.thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(d.a.c.e.p.l.g(this.x.getPageActivity(), R.dimen.ds70));
            this.m.getHeadView().setPlaceHolder(1);
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.n = (ThreadUserInfoLayout) l.findViewById(R.id.thread_user_info_layout);
        this.t = new NEGFeedBackView(this.x);
        this.t.l((ViewGroup) l(), d.a.c.e.p.l.g(this.f63442g, R.dimen.tbds92), d.a.c.e.p.l.g(b(), R.dimen.tbds16));
        this.o = (TextView) l.findViewById(R.id.thread_title);
        this.p = (TextView) l.findViewById(R.id.thread_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) l.findViewById(R.id.original_thread_view);
        this.q = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.I);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) l.findViewById(R.id.thread_comment_layout);
        this.r = threadCommentAndPraiseInfoLayout;
        if (threadCommentAndPraiseInfoLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.r.setLayoutParams(layoutParams);
        }
        l.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.r.setReplyTimeVisible(false);
        this.r.setShowPraiseNum(true);
        this.r.setNeedAddPraiseIcon(true);
        this.r.setNeedAddReplyIcon(true);
        this.r.setShareVisible(true);
        this.r.setForumAfterClickListener(new a());
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) l.findViewById(R.id.card_transmit_source_read_share_layout);
        this.s = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12401f.setOnClickListener(this);
        this.s.f12401f.setNeedAddReplyIcon(true);
        this.s.setForumAfterClickListener(new b());
        this.u = l.findViewById(R.id.divider_line_above_praise);
        this.v = l.findViewById(R.id.card_divider_line);
        this.w = (TbImageView) l.findViewById(R.id.thread_theme_card);
        this.B = (TbImageView) l.findViewById(R.id.frs_normal_item_star_view);
        View findViewById = l.findViewById(R.id.thread_multi_del_mask_view);
        this.F = findViewById;
        findViewById.setOnClickListener(new c());
        this.r.setOnSelectStatusChangeListener(new d());
    }

    public final boolean A(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || StringUtils.isNull(a2Var.T().getUserId())) {
            return false;
        }
        return a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public final void B() {
        a2 a2Var;
        b2 b2Var = this.y;
        if (b2Var == null || (a2Var = b2Var.f49949e) == null) {
            return;
        }
        m.a(a2Var.o0());
        G(a2Var.o0());
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(a2Var, null, this.y.f49950f, 18003, true, false, false);
        createFromThreadCfg.setStartFrom(this.l);
        createFromThreadCfg.setIsShareThread(true);
        m.a(a2Var.y1());
        this.x.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: F */
    public void m(b2 b2Var) {
        if (b2Var != null && b2Var.f49949e != null) {
            if (l() != null) {
                l().setVisibility(0);
            }
            this.y = b2Var;
            a2 a2Var = b2Var.f49949e;
            if (this.t != null) {
                SparseArray<String> b0 = a2Var.b0();
                if (b0 != null && b0.size() > 0 && this.z) {
                    v0 v0Var = new v0();
                    v0Var.n(a2Var.y1());
                    v0Var.k(a2Var.c0());
                    v0Var.m(a2Var.M0());
                    v0Var.j(b0);
                    v0Var.f50147g = a2Var.f1;
                    this.t.setData(v0Var);
                    this.t.setFirstRowSingleColumn(true);
                    this.t.setVisibility(A(a2Var) ? 8 : 0);
                } else {
                    this.t.setVisibility(8);
                }
            }
            if (this.y.f49952h == 1) {
                this.n.setFrom(3);
                z(a2Var);
                N(a2Var);
            }
            this.n.setIsFromConcern(this.A);
            this.n.j(a2Var);
            this.n.setUserAfterClickListener(this.H);
            if (this.n.getHeaderImg() != null) {
                if (this.n.getIsSimpleThread()) {
                    this.n.getHeaderImg().setVisibility(8);
                    this.m.setVisibility(8);
                } else if (a2Var.T() != null && a2Var.T().getPendantData() != null && !StringUtils.isNull(a2Var.T().getPendantData().a())) {
                    this.n.getHeaderImg().setVisibility(4);
                    this.m.setVisibility(0);
                    this.m.setData(a2Var);
                } else {
                    this.m.setVisibility(8);
                    this.n.getHeaderImg().setVisibility(0);
                    this.n.getHeaderImg().setData(a2Var);
                }
            }
            L(a2Var);
            this.q.f(a2Var.s1);
            M(w(1));
            K(i());
            n(this.x, TbadkCoreApplication.getInst().getSkinType());
            G(a2Var.o0());
            if (this.r.isInFrsAllThread() && (d.a.n0.r0.b.e().g() || d.a.n0.r0.a.h().j())) {
                this.F.setVisibility(0);
                if (!a2Var.l2() && !a2Var.m2() && !a2Var.A2()) {
                    this.F.setBackgroundResource(R.color.transparent);
                    return;
                } else {
                    SkinManager.setBackgroundColor(this.F, R.color.CAM_X0201);
                    return;
                }
            }
            this.F.setVisibility(8);
        } else if (l() != null) {
            l().setVisibility(8);
        }
    }

    public final void G(String str) {
        m.l(this.o, str, R.color.CAM_X0105, R.color.CAM_X0109);
        m.l(this.p, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.q.setReadState(m.k(str));
    }

    public void H(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        K(bdUniqueId);
    }

    public void I(boolean z) {
        View view = this.v;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void J(boolean z) {
        this.z = z;
    }

    public final void K(BdUniqueId bdUniqueId) {
        p(bdUniqueId);
        NEGFeedBackView nEGFeedBackView = this.t;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        ThreadUserInfoLayout threadUserInfoLayout = this.n;
        if (threadUserInfoLayout != null) {
            threadUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
    }

    public final void L(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        if (!StringUtils.isNull(this.C) && !StringUtils.isNull(this.E)) {
            a2Var.l4(this.C, this.E);
        }
        SpannableStringBuilder R2 = a2Var.R2(false, true);
        if (R2 != null && !StringUtils.isNull(R2.toString())) {
            this.o.setVisibility(0);
            this.o.setOnTouchListener(new d.a.n0.v3.i(R2));
            this.o.setText(R2);
            m.l(this.o, a2Var.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        this.o.setVisibility(8);
    }

    public void M(int i2) {
        b2 b2Var = this.y;
        if (b2Var == null || b2Var.f49949e == null) {
            return;
        }
        if (i2 == 1) {
            this.r.setVisibility(8);
            this.s.setFrom(this.y.f49951g);
            this.s.setShareReportFrom(this.y.f49952h);
            this.s.setStType(this.y.f49950f);
            this.s.g(this.y.f49949e);
            this.n.l(false);
            return;
        }
        this.r.setFrom(b2Var.f49951g);
        this.r.setShareReportFrom(this.y.f49952h);
        this.r.setStType(this.y.f49950f);
        this.r.setData(this.y.f49949e);
        this.r.setDisPraiseFrom(this.y.f49953i);
        this.s.setVisibility(8);
        this.n.l(true);
    }

    public final void N(a2 a2Var) {
        if (this.B == null) {
            return;
        }
        if (this.w != null && a2Var != null) {
            if (!StringUtils.isNull(a2Var.u1) && this.w.getVisibility() != 0) {
                NEGFeedBackView nEGFeedBackView = this.t;
                if (nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0 && (this.B.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                    layoutParams.rightMargin = d.a.c.e.p.l.g(this.x.getPageActivity(), R.dimen.tbds106);
                    this.B.setLayoutParams(layoutParams);
                }
                this.B.setVisibility(0);
                this.B.setImageDrawable(null);
                this.B.V(a2Var.u1, 10, false);
                this.B.setOnClickListener(new e(a2Var));
                return;
            }
            this.B.setVisibility(8);
            return;
        }
        this.B.setVisibility(8);
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.card_transmit_thread_view;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        a2 a2Var;
        if (this.f63440e != i2) {
            SkinManager.setBackgroundResource(l(), R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
            this.r.onChangeSkinType();
            this.n.h();
            NEGFeedBackView nEGFeedBackView = this.t;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.q();
            }
            this.q.n();
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0205);
            this.s.f();
        }
        b2 b2Var = this.y;
        if (b2Var != null && (a2Var = b2Var.f49949e) != null) {
            SkinManager.setBackgroundColor(this.F, (a2Var.l2() || this.y.f49949e.m2()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        HeadPendantClickableView headPendantClickableView = this.m;
        if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
            this.m.getHeadView().setPlaceHolder(1);
        }
        this.f63440e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (h() != null) {
            h().a(view, this.y);
        }
        if (view == l() || view.getId() == R.id.thread_content_layout_outter) {
            B();
        }
    }

    public void setPage(String str) {
        this.D = str;
    }

    public int w(int i2) {
        return d.a.n0.o.d.c().b(this.D, i2);
    }

    public ClickableHeaderImageView x() {
        ThreadUserInfoLayout threadUserInfoLayout = this.n;
        if (threadUserInfoLayout != null) {
            return threadUserInfoLayout.f12406e;
        }
        return null;
    }

    public View y() {
        ThreadUserInfoLayout threadUserInfoLayout = this.n;
        if (threadUserInfoLayout != null) {
            return threadUserInfoLayout.f12408g;
        }
        return null;
    }

    public void z(a2 a2Var) {
        MetaData T;
        if (a2Var == null || this.w == null || (T = a2Var.T()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = T.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.w.setVisibility(0);
            this.w.setImageBitmap(null);
            this.w.V(themeCard.getCardImageUrlAndroid(), 10, false);
            this.w.setOnClickListener(new f(themeCard));
            return;
        }
        this.w.setVisibility(8);
    }
}
