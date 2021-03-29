package d.b.i0.x;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.b2;
import d.b.h0.r.q.v0;
/* loaded from: classes4.dex */
public class v extends d.b.i0.x.b<b2> implements Object {
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
            if (v.this.i() != null) {
                v.this.i().a(view, v.this.y);
            }
            if (v.this.y == null || v.this.y.f50720e == null) {
                return;
            }
            m.a(v.this.y.f50720e.o0());
            v vVar = v.this;
            vVar.I(vVar.y.f50720e.o0());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (v.this.i() != null) {
                v.this.i().a(view, v.this.y);
            }
            v vVar = v.this;
            if (view == vVar.s.f13535e || vVar.y == null || v.this.y.f50720e == null) {
                return;
            }
            m.a(v.this.y.f50720e.o0());
            v vVar2 = v.this;
            vVar2.I(vVar2.y.f50720e.o0());
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
        public final /* synthetic */ a2 f62315e;

        public e(a2 a2Var) {
            this.f62315e = a2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (v.this.x != null) {
                v.this.f62181f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.f62181f.getContext(), "", this.f62315e.u1, true)));
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f62317e;

        public f(ThemeCardInUserData themeCardInUserData) {
            this.f62317e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.x.getPageActivity(), this.f62317e.getCardId())));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (v.this.i() != null) {
                v.this.i().a(view, v.this.y);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements OriginalThreadCardView.b {
        public h() {
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            if (v.this.y == null || v.this.y.f50720e == null) {
                return;
            }
            if (v.this.i() != null) {
                b0<b2> i = v.this.i();
                v vVar = v.this;
                i.a(vVar.q, vVar.y);
            }
            String o0 = v.this.y.f50720e.o0();
            m.a(o0);
            v.this.I(o0);
        }
    }

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.t = null;
        this.z = true;
        this.H = new g();
        this.I = new h();
        this.x = tbPageContext;
        View m = m();
        ViewGroup viewGroup = (ViewGroup) m.findViewById(R.id.thread_content_layout_outter);
        this.G = viewGroup;
        viewGroup.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) m.findViewById(R.id.thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(d.b.b.e.p.l.g(this.x.getPageActivity(), R.dimen.ds70));
            this.m.getHeadView().setPlaceHolder(1);
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.n = (ThreadUserInfoLayout) m.findViewById(R.id.thread_user_info_layout);
        this.t = new NEGFeedBackView(this.x);
        this.t.g((ViewGroup) m(), d.b.b.e.p.l.g(this.f62182g, R.dimen.tbds92), d.b.b.e.p.l.g(b(), R.dimen.tbds16));
        this.o = (TextView) m.findViewById(R.id.thread_title);
        this.p = (TextView) m.findViewById(R.id.thread_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) m.findViewById(R.id.original_thread_view);
        this.q = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.I);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) m.findViewById(R.id.thread_comment_layout);
        this.r = threadCommentAndPraiseInfoLayout;
        if (threadCommentAndPraiseInfoLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.r.setLayoutParams(layoutParams);
        }
        m.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.r.setReplyTimeVisible(false);
        this.r.setShowPraiseNum(true);
        this.r.setNeedAddPraiseIcon(true);
        this.r.setNeedAddReplyIcon(true);
        this.r.setShareVisible(true);
        this.r.setForumAfterClickListener(new a());
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) m.findViewById(R.id.card_transmit_source_read_share_layout);
        this.s = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f13536f.setOnClickListener(this);
        this.s.f13536f.setNeedAddReplyIcon(true);
        this.s.setForumAfterClickListener(new b());
        this.u = m.findViewById(R.id.divider_line_above_praise);
        this.v = m.findViewById(R.id.card_divider_line);
        this.w = (TbImageView) m.findViewById(R.id.thread_theme_card);
        this.B = (TbImageView) m.findViewById(R.id.frs_normal_item_star_view);
        View findViewById = m.findViewById(R.id.thread_multi_del_mask_view);
        this.F = findViewById;
        findViewById.setOnClickListener(new c());
        this.r.setOnSelectStatusChangeListener(new d());
    }

    public View A() {
        ThreadUserInfoLayout threadUserInfoLayout = this.n;
        if (threadUserInfoLayout != null) {
            return threadUserInfoLayout.f13542g;
        }
        return null;
    }

    public void B(a2 a2Var) {
        MetaData T;
        if (a2Var == null || this.w == null || (T = a2Var.T()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = T.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.w.setVisibility(0);
            this.w.setImageBitmap(null);
            this.w.W(themeCard.getCardImageUrlAndroid(), 10, false);
            this.w.setOnClickListener(new f(themeCard));
            return;
        }
        this.w.setVisibility(8);
    }

    public final boolean E(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || StringUtils.isNull(a2Var.T().getUserId())) {
            return false;
        }
        return a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public final void F() {
        a2 a2Var;
        b2 b2Var = this.y;
        if (b2Var == null || (a2Var = b2Var.f50720e) == null) {
            return;
        }
        m.a(a2Var.o0());
        I(a2Var.o0());
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(a2Var, null, this.y.f50721f, 18003, true, false, false);
        createFromThreadCfg.setStartFrom(this.l);
        createFromThreadCfg.setIsShareThread(true);
        m.a(a2Var.w1());
        this.x.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: G */
    public void n(b2 b2Var) {
        if (b2Var != null && b2Var.f50720e != null) {
            if (m() != null) {
                m().setVisibility(0);
            }
            this.y = b2Var;
            a2 a2Var = b2Var.f50720e;
            if (this.t != null) {
                SparseArray<String> b0 = a2Var.b0();
                if (b0 != null && b0.size() > 0 && this.z) {
                    v0 v0Var = new v0();
                    v0Var.n(a2Var.w1());
                    v0Var.k(a2Var.c0());
                    v0Var.m(a2Var.L0());
                    v0Var.j(b0);
                    v0Var.f50907g = a2Var.e1;
                    this.t.setData(v0Var);
                    this.t.setFirstRowSingleColumn(true);
                    this.t.setVisibility(E(a2Var) ? 8 : 0);
                } else {
                    this.t.setVisibility(8);
                }
            }
            if (this.y.f50723h == 1) {
                this.n.setFrom(3);
                B(a2Var);
                Q(a2Var);
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
            O(a2Var);
            this.q.f(a2Var.r1);
            P(y(1));
            M(k());
            o(this.x, TbadkCoreApplication.getInst().getSkinType());
            I(a2Var.o0());
            if (this.r.isInFrsAllThread() && (d.b.i0.p0.b.e().g() || d.b.i0.p0.a.h().j())) {
                this.F.setVisibility(0);
                if (!a2Var.i2() && !a2Var.j2() && !a2Var.w2()) {
                    this.F.setBackgroundResource(R.color.transparent);
                    return;
                } else {
                    SkinManager.setBackgroundColor(this.F, R.color.CAM_X0201);
                    return;
                }
            }
            this.F.setVisibility(8);
        } else if (m() != null) {
            m().setVisibility(8);
        }
    }

    public final void I(String str) {
        m.l(this.o, str, R.color.CAM_X0105, R.color.CAM_X0109);
        m.l(this.p, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.q.setReadState(m.k(str));
    }

    public void J(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        M(bdUniqueId);
    }

    public void K(boolean z) {
        View view = this.v;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void L(boolean z) {
        this.z = z;
    }

    public final void M(BdUniqueId bdUniqueId) {
        r(bdUniqueId);
        NEGFeedBackView nEGFeedBackView = this.t;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        ThreadUserInfoLayout threadUserInfoLayout = this.n;
        if (threadUserInfoLayout != null) {
            threadUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
    }

    public final void O(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        if (!StringUtils.isNull(this.C) && !StringUtils.isNull(this.E)) {
            a2Var.h4(this.C, this.E);
        }
        SpannableStringBuilder N2 = a2Var.N2(false, true);
        if (N2 != null && !StringUtils.isNull(N2.toString())) {
            this.o.setVisibility(0);
            this.o.setOnTouchListener(new d.b.i0.t3.i(N2));
            this.o.setText(N2);
            m.l(this.o, a2Var.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        this.o.setVisibility(8);
    }

    public void P(int i) {
        b2 b2Var = this.y;
        if (b2Var == null || b2Var.f50720e == null) {
            return;
        }
        if (i == 1) {
            this.r.setVisibility(8);
            this.s.setFrom(this.y.f50722g);
            this.s.setShareReportFrom(this.y.f50723h);
            this.s.setStType(this.y.f50721f);
            this.s.g(this.y.f50720e);
            this.n.l(false);
            return;
        }
        this.r.setFrom(b2Var.f50722g);
        this.r.setShareReportFrom(this.y.f50723h);
        this.r.setStType(this.y.f50721f);
        this.r.setData(this.y.f50720e);
        this.r.setDisPraiseFrom(this.y.i);
        this.s.setVisibility(8);
        this.n.l(true);
    }

    public final void Q(a2 a2Var) {
        if (this.B == null) {
            return;
        }
        if (this.w != null && a2Var != null) {
            if (!StringUtils.isNull(a2Var.t1) && this.w.getVisibility() != 0) {
                NEGFeedBackView nEGFeedBackView = this.t;
                if (nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0 && (this.B.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                    layoutParams.rightMargin = d.b.b.e.p.l.g(this.x.getPageActivity(), R.dimen.tbds106);
                    this.B.setLayoutParams(layoutParams);
                }
                this.B.setVisibility(0);
                this.B.setImageDrawable(null);
                this.B.W(a2Var.t1, 10, false);
                this.B.setOnClickListener(new e(a2Var));
                return;
            }
            this.B.setVisibility(8);
            return;
        }
        this.B.setVisibility(8);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_transmit_thread_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        a2 a2Var;
        if (this.f62180e != i) {
            SkinManager.setBackgroundResource(m(), R.drawable.addresslist_item_bg);
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
        if (b2Var != null && (a2Var = b2Var.f50720e) != null) {
            SkinManager.setBackgroundColor(this.F, (a2Var.i2() || this.y.f50720e.j2()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        HeadPendantClickableView headPendantClickableView = this.m;
        if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
            this.m.getHeadView().setPlaceHolder(1);
        }
        this.f62180e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i() != null) {
            i().a(view, this.y);
        }
        if (view == m() || view.getId() == R.id.thread_content_layout_outter) {
            F();
        }
    }

    public void setPage(String str) {
        this.D = str;
    }

    public int y(int i) {
        return d.b.i0.m.d.c().b(this.D, i);
    }

    public ClickableHeaderImageView z() {
        ThreadUserInfoLayout threadUserInfoLayout = this.n;
        if (threadUserInfoLayout != null) {
            return threadUserInfoLayout.f13540e;
        }
        return null;
    }
}
