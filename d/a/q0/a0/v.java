package d.a.q0.a0;

import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.c2;
import d.a.p0.s.q.w0;
/* loaded from: classes7.dex */
public class v extends d.a.q0.a0.b<c2> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public c2 y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f54459e;

        public a(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54459e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f54459e.h() != null) {
                    this.f54459e.h().a(view, this.f54459e.y);
                }
                if (this.f54459e.y == null || this.f54459e.y.f53274e == null) {
                    return;
                }
                m.a(this.f54459e.y.f53274e.d0());
                v vVar = this.f54459e;
                vVar.F(vVar.y.f53274e.d0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f54460e;

        public b(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54460e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f54460e.h() != null) {
                    this.f54460e.h().a(view, this.f54460e.y);
                }
                v vVar = this.f54460e;
                if (view == vVar.s.f12653e || vVar.y == null || this.f54460e.y.f53274e == null) {
                    return;
                }
                m.a(this.f54460e.y.f53274e.d0());
                v vVar2 = this.f54460e;
                vVar2.F(vVar2.y.f53274e.d0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f54461e;

        public c(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54461e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54461e.r.changeSelectStatus();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f54462a;

        public d(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54462a = vVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                SkinManager.setBackgroundColor(this.f54462a.F, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b2 f54463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ v f54464f;

        public e(v vVar, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, b2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54464f = vVar;
            this.f54463e = b2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f54464f.x != null) {
                    this.f54464f.f54320f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f54464f.f54320f.getContext(), "", this.f54463e.x1, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f54465e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ v f54466f;

        public f(v vVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54466f = vVar;
            this.f54465e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f54466f.x.getPageActivity(), this.f54465e.getCardId())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f54467e;

        public g(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54467e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54467e.h() == null) {
                return;
            }
            this.f54467e.h().a(view, this.f54467e.y);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f54468a;

        public h(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54468a = vVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || this.f54468a.y == null || this.f54468a.y.f53274e == null) {
                return;
            }
            if (this.f54468a.h() != null) {
                b0<c2> h2 = this.f54468a.h();
                v vVar = this.f54468a;
                h2.a(vVar.q, vVar.y);
            }
            String d0 = this.f54468a.y.f53274e.d0();
            m.a(d0);
            this.f54468a.F(d0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.z = true;
        this.H = new g(this);
        this.I = new h(this);
        this.x = tbPageContext;
        View k = k();
        ViewGroup viewGroup = (ViewGroup) k.findViewById(R.id.thread_content_layout_outter);
        this.G = viewGroup;
        viewGroup.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) k.findViewById(R.id.thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(d.a.d.e.p.l.g(this.x.getPageActivity(), R.dimen.ds70));
            this.m.getHeadView().setPlaceHolder(1);
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.n = (ThreadUserInfoLayout) k.findViewById(R.id.thread_user_info_layout);
        this.t = new NEGFeedBackView(this.x);
        this.t.l((ViewGroup) k(), d.a.d.e.p.l.g(this.f54321g, R.dimen.tbds92), d.a.d.e.p.l.g(b(), R.dimen.tbds16));
        this.o = (TextView) k.findViewById(R.id.thread_title);
        this.p = (TextView) k.findViewById(R.id.thread_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) k.findViewById(R.id.original_thread_view);
        this.q = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.I);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) k.findViewById(R.id.thread_comment_layout);
        this.r = threadCommentAndPraiseInfoLayout;
        if (threadCommentAndPraiseInfoLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.r.setLayoutParams(layoutParams);
        }
        k.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.r.setReplyTimeVisible(false);
        this.r.setShowPraiseNum(true);
        this.r.setNeedAddPraiseIcon(true);
        this.r.setNeedAddReplyIcon(true);
        this.r.setShareVisible(true);
        this.r.setForumAfterClickListener(new a(this));
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) k.findViewById(R.id.card_transmit_source_read_share_layout);
        this.s = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12654f.setOnClickListener(this);
        this.s.f12654f.setNeedAddReplyIcon(true);
        this.s.setForumAfterClickListener(new b(this));
        this.u = k.findViewById(R.id.divider_line_above_praise);
        this.v = k.findViewById(R.id.card_divider_line);
        this.w = (TbImageView) k.findViewById(R.id.thread_theme_card);
        this.B = (TbImageView) k.findViewById(R.id.frs_normal_item_star_view);
        View findViewById = k.findViewById(R.id.thread_multi_del_mask_view);
        this.F = findViewById;
        findViewById.setOnClickListener(new c(this));
        this.r.setOnSelectStatusChangeListener(new d(this));
    }

    public final void A() {
        c2 c2Var;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2Var = this.y) == null || (b2Var = c2Var.f53274e) == null) {
            return;
        }
        m.a(b2Var.d0());
        F(b2Var.d0());
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(b2Var, null, this.y.f53275f, 18003, true, false, false);
        createFromThreadCfg.setStartFrom(this.l);
        createFromThreadCfg.setIsShareThread(true);
        m.a(b2Var.o1());
        this.x.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: B */
    public void l(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) {
            if (c2Var != null && c2Var.f53274e != null) {
                if (k() != null) {
                    k().setVisibility(0);
                }
                this.y = c2Var;
                b2 b2Var = c2Var.f53274e;
                if (this.t != null) {
                    SparseArray<String> Q = b2Var.Q();
                    if (Q != null && Q.size() > 0 && this.z) {
                        w0 w0Var = new w0();
                        w0Var.n(b2Var.o1());
                        w0Var.k(b2Var.R());
                        w0Var.m(b2Var.B0());
                        w0Var.j(Q);
                        w0Var.f53468g = b2Var.h1;
                        this.t.setData(w0Var);
                        this.t.setFirstRowSingleColumn(true);
                        this.t.setVisibility(z(b2Var) ? 8 : 0);
                    } else {
                        this.t.setVisibility(8);
                    }
                }
                if (this.y.f53277h == 1) {
                    this.n.setFrom(3);
                    y(b2Var);
                    M(b2Var);
                }
                this.n.setIsFromConcern(this.A);
                this.n.j(b2Var);
                this.n.setUserAfterClickListener(this.H);
                if (this.n.getHeaderImg() != null) {
                    if (this.n.getIsSimpleThread()) {
                        this.n.getHeaderImg().setVisibility(8);
                        this.m.setVisibility(8);
                    } else if (b2Var.H() != null && b2Var.H().getPendantData() != null && !StringUtils.isNull(b2Var.H().getPendantData().getImgUrl())) {
                        this.n.getHeaderImg().setVisibility(4);
                        this.m.setVisibility(0);
                        this.m.setData(b2Var);
                    } else {
                        this.m.setVisibility(8);
                        this.n.getHeaderImg().setVisibility(0);
                        this.n.getHeaderImg().setData(b2Var);
                    }
                }
                K(b2Var);
                this.q.f(b2Var.u1);
                L(v(1));
                J(i());
                m(this.x, TbadkCoreApplication.getInst().getSkinType());
                F(b2Var.d0());
                if (this.r.isInFrsAllThread() && (d.a.q0.u0.b.e().g() || d.a.q0.u0.a.h().j())) {
                    this.F.setVisibility(0);
                    if (!b2Var.a2() && !b2Var.b2() && !b2Var.q2()) {
                        this.F.setBackgroundResource(R.color.transparent);
                        return;
                    } else {
                        SkinManager.setBackgroundColor(this.F, R.color.CAM_X0201);
                        return;
                    }
                }
                this.F.setVisibility(8);
            } else if (k() != null) {
                k().setVisibility(8);
            }
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            m.l(this.o, str, R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.p, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.q.setReadState(m.k(str));
        }
    }

    public void G(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        J(bdUniqueId);
    }

    public void H(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (view = this.v) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.z = z;
        }
    }

    public final void J(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            o(bdUniqueId);
            NEGFeedBackView nEGFeedBackView = this.t;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setUniqueId(bdUniqueId);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void K(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, b2Var) == null) || b2Var == null) {
            return;
        }
        if (!StringUtils.isNull(this.C) && !StringUtils.isNull(this.E)) {
            b2Var.d4(this.C, this.E);
        }
        SpannableStringBuilder H2 = b2Var.H2(false, true);
        if (H2 != null && !StringUtils.isNull(H2.toString())) {
            this.o.setVisibility(0);
            this.o.setOnTouchListener(new d.a.q0.z3.i(H2));
            this.o.setText(H2);
            m.l(this.o, b2Var.d0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        this.o.setVisibility(8);
    }

    public void L(int i2) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (c2Var = this.y) == null || c2Var.f53274e == null) {
            return;
        }
        if (i2 == 1) {
            this.r.setVisibility(8);
            this.s.setFrom(this.y.f53276g);
            this.s.setShareReportFrom(this.y.f53277h);
            this.s.setStType(this.y.f53275f);
            this.s.g(this.y.f53274e);
            this.n.l(false);
            return;
        }
        this.r.setFrom(c2Var.f53276g);
        this.r.setShareReportFrom(this.y.f53277h);
        this.r.setStType(this.y.f53275f);
        this.r.setData(this.y.f53274e);
        this.r.setDisPraiseFrom(this.y.f53278i);
        this.s.setVisibility(8);
        this.n.l(true);
    }

    public final void M(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, b2Var) == null) || this.B == null) {
            return;
        }
        if (this.w != null && b2Var != null) {
            if (!StringUtils.isNull(b2Var.w1) && this.w.getVisibility() != 0) {
                NEGFeedBackView nEGFeedBackView = this.t;
                if (nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0 && (this.B.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                    layoutParams.rightMargin = d.a.d.e.p.l.g(this.x.getPageActivity(), R.dimen.tbds106);
                    this.B.setLayoutParams(layoutParams);
                }
                this.B.setVisibility(0);
                this.B.setImageDrawable(null);
                this.B.M(b2Var.w1, 10, false);
                this.B.setOnClickListener(new e(this, b2Var));
                return;
            }
            this.B.setVisibility(8);
            return;
        }
        this.B.setVisibility(8);
    }

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? R.layout.card_transmit_thread_view : invokeV.intValue;
    }

    @Override // d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, tbPageContext, i2) == null) {
            if (this.f54319e != i2) {
                SkinManager.setBackgroundResource(k(), R.drawable.addresslist_item_bg);
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
            c2 c2Var = this.y;
            if (c2Var != null && (b2Var = c2Var.f53274e) != null) {
                SkinManager.setBackgroundColor(this.F, (b2Var.a2() || this.y.f53274e.b2()) ? R.color.CAM_X0201 : R.color.transparent);
            }
            HeadPendantClickableView headPendantClickableView = this.m;
            if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
                this.m.getHeadView().setPlaceHolder(1);
            }
            this.f54319e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (h() != null) {
                h().a(view, this.y);
            }
            if (view == k() || view.getId() == R.id.thread_content_layout_outter) {
                A();
            }
        }
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.D = str;
        }
    }

    public int v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? d.a.q0.o.d.c().b(this.D, i2) : invokeI.intValue;
    }

    public ClickableHeaderImageView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                return threadUserInfoLayout.f12659e;
            }
            return null;
        }
        return (ClickableHeaderImageView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                return threadUserInfoLayout.f12661g;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void y(b2 b2Var) {
        MetaData H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, b2Var) == null) || b2Var == null || this.w == null || (H = b2Var.H()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = H.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.w.setVisibility(0);
            this.w.setImageBitmap(null);
            this.w.M(themeCard.getCardImageUrlAndroid(), 10, false);
            this.w.setOnClickListener(new f(this, themeCard));
            return;
        }
        this.w.setVisibility(8);
    }

    public final boolean z(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, b2Var)) == null) {
            if (b2Var == null || b2Var.H() == null || StringUtils.isNull(b2Var.H().getUserId())) {
                return false;
            }
            return b2Var.H().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
        }
        return invokeL.booleanValue;
    }
}
