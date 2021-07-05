package d.a.s0.u0.m1.g;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.k;
import d.a.r0.r.q.b2;
import d.a.s0.a0.b0;
import d.a.s0.a0.m;
import d.a.s0.a0.z;
import d.a.s0.u0.o2.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class c extends d.a.s0.a0.b<b2> implements z, Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> A;
    public TextView B;
    public TextView C;
    public ConstrainImageGroup D;
    public boolean E;
    public View F;
    public TbImageView G;
    public String H;
    public i I;
    public View J;
    public AppletsCellView K;
    public View.OnClickListener L;
    public final View.OnClickListener M;
    public final View.OnClickListener N;
    public HeadPendantClickableView m;
    public PlayVoiceBntNew n;
    public ThreadCommentAndPraiseInfoLayout o;
    public ThreadSourceShareAndPraiseLayout p;
    public ThreadGodReplyLayout q;
    public ThreadUserInfoLayout r;
    public RelativeLayout s;
    public View t;
    public TbImageView u;
    public LinearLayout v;
    public String w;
    public String x;
    public int y;
    public b2 z;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66421e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66421e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (threadCommentAndPraiseInfoLayout = this.f66421e.o) == null) {
                return;
            }
            threadCommentAndPraiseInfoLayout.changeSelectStatus();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ThreadCommentAndPraiseInfoLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f66422a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66422a = cVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f66422a.J == null) {
                return;
            }
            this.f66422a.J.setBackgroundColor(SkinManager.getColor(z ? R.color.CAM_X0201 : R.color.transparent));
        }
    }

    /* renamed from: d.a.s0.u0.m1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1734c implements d.a.r0.b1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f66423a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b2 f66424b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f66425c;

        public C1734c(c cVar, LinkedList linkedList, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, linkedList, b2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66425c = cVar;
            this.f66423a = linkedList;
            this.f66424b = b2Var;
        }

        @Override // d.a.r0.b1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                b0<b2> i3 = this.f66425c.i();
                if (!z) {
                    if (i3 != null) {
                        view.setTag("1");
                        i3.f57036a = Boolean.FALSE;
                        i3.a(view, this.f66425c.z);
                    }
                    this.f66425c.O(view, this.f66423a, i2, this.f66424b);
                    return;
                }
                if (i3 != null) {
                    view.setTag("1");
                    i3.f57036a = Boolean.TRUE;
                    i3.a(view, this.f66425c.z);
                }
                this.f66425c.z(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b2 f66426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f66427f;

        public d(c cVar, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, b2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66427f = cVar;
            this.f66426e = b2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f66427f.A != null) {
                    this.f66427f.f57032f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f66427f.f57032f.getContext(), "", this.f66426e.x1, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f66428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f66429f;

        public e(c cVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66429f = cVar;
            this.f66428e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f66429f.A.getPageActivity(), this.f66428e.getCardId())));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66430e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66430e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!d.a.s0.u0.b.e().g() && !d.a.s0.u0.a.h().j()) {
                    if (this.f66430e.i() != null) {
                        this.f66430e.i().a(view, this.f66430e.z);
                    }
                    c cVar = this.f66430e;
                    cVar.z(view == cVar.q);
                    return;
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.f66430e.o;
                if (threadCommentAndPraiseInfoLayout != null) {
                    threadCommentAndPraiseInfoLayout.changeSelectStatus();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66431e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66431e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<b2> i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (i2 = this.f66431e.i()) == null) {
                return;
            }
            view.setTag("2");
            i2.a(view, this.f66431e.z);
        }
    }

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66432e;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66432e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f66432e.i() == null) {
                return;
            }
            this.f66432e.i().a(view, this.f66432e.z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.y = 3;
        this.E = true;
        this.L = new f(this);
        this.M = new g(this);
        this.N = new h(this);
        View l = l();
        p(bdUniqueId);
        this.A = tbPageContext;
        this.l = 3;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) l.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(l.g(this.A.getPageActivity(), R.dimen.ds70));
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.m.setAfterClickListener(this.N);
        this.t = l.findViewById(R.id.divider_line);
        this.B = (TextView) l.findViewById(R.id.card_home_page_normal_thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) l.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.n = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.M);
        TextView textView = (TextView) l.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.C = textView;
        textView.setVisibility(8);
        this.F = l.findViewById(R.id.divider_line_above_praise);
        this.D = (ConstrainImageGroup) l.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.D.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.D.setChildClickListener(this.L);
        d.a.r0.b1.j.f fVar = new d.a.r0.b1.j.f(3);
        fVar.d(1.0d);
        this.D.setImageProcessor(fVar);
        this.o = (ThreadCommentAndPraiseInfoLayout) l.findViewById(R.id.card_home_page_normal_thread_info_layout);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) l.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.r = threadUserInfoLayout;
        threadUserInfoLayout.setUserAfterClickListener(this.N);
        this.r.setFrom(3);
        this.o.setOnClickListener(this.L);
        this.o.setForumAfterClickListener(this.N);
        this.o.setReplyTimeVisible(false);
        this.o.setShowPraiseNum(true);
        this.o.setNeedAddPraiseIcon(true);
        this.o.setNeedAddReplyIcon(true);
        this.o.setIsBarViewVisible(false);
        this.o.setShareVisible(true);
        this.o.setShareReportFrom(1);
        this.o.setStType("frs_page");
        this.o.setFrom(2);
        this.o.R = 3;
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) l.findViewById(R.id.card_home_page_source_read_share_layout);
        this.p = threadSourceShareAndPraiseLayout;
        if (threadSourceShareAndPraiseLayout != null) {
            threadSourceShareAndPraiseLayout.f12588f.setOnClickListener(this.L);
            this.p.setFrom(2);
            this.p.setShareReportFrom(1);
            this.p.setSourceFromForPb(3);
            this.p.setStType("frs_page");
            this.p.setHideBarName(true);
            this.p.f12588f.setNeedAddReplyIcon(true);
        }
        RelativeLayout relativeLayout = (RelativeLayout) l.findViewById(R.id.card_home_page_normal_thread_root);
        this.s = relativeLayout;
        i iVar = new i(this.A, relativeLayout);
        this.I = iVar;
        iVar.d(j());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) l.findViewById(R.id.card_frs_god_reply_layout);
        this.q = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this.L);
        TbImageView tbImageView = (TbImageView) l.findViewById(R.id.frs_normal_item_theme_card);
        this.u = tbImageView;
        tbImageView.setPageId(j());
        TbImageView tbImageView2 = (TbImageView) l.findViewById(R.id.frs_normal_item_star_view);
        this.G = tbImageView2;
        if (tbImageView2 != null) {
            tbImageView2.setPageId(j());
        }
        View findViewById = l.findViewById(R.id.thread_multi_del_mask_view);
        this.J = findViewById;
        findViewById.setOnClickListener(new a(this));
        this.o.setOnSelectStatusChangeListener(new b(this));
        this.v = (LinearLayout) l.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.K = (AppletsCellView) l.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void A(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
            if (b2Var == null) {
                if (l() != null) {
                    l().setVisibility(8);
                    return;
                }
                return;
            }
            this.z = b2Var;
            if (l() != null) {
                l().setVisibility(0);
                l().setOnClickListener(this.L);
            }
            this.q.l();
            if (!y() && m.k(this.z.c0())) {
                m.l(this.B, this.z.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.l(this.C, this.z.c0(), R.color.CAM_X0107, R.color.CAM_X0109);
                m.l(this.q.getGodReplyContent(), this.z.c0(), R.color.CAM_X0106, R.color.CAM_X0109);
            }
            x(b2Var);
            this.I.a(this.z);
            N(b2Var);
            this.r.j(this.z);
            this.q.setFromCDN(this.E);
            this.q.setData(this.z.p1());
            this.r.setUserAfterClickListener(this.N);
            M(v(1));
            if (this.r.getHeaderImg() != null) {
                if (this.r.getIsSimpleThread()) {
                    this.r.getHeaderImg().setVisibility(8);
                    this.m.setVisibility(8);
                } else if (b2Var.H() != null && b2Var.H().getPendantData() != null && !StringUtils.isNull(b2Var.H().getPendantData().a())) {
                    this.r.getHeaderImg().setVisibility(4);
                    this.m.setVisibility(0);
                    this.m.setData(b2Var);
                } else {
                    this.m.setVisibility(8);
                    this.r.getHeaderImg().setVisibility(0);
                    this.r.getHeaderImg().setData(b2Var);
                }
            }
            L(b2Var);
            F(b2Var);
            this.K.setData(b2Var.Z0());
            this.K.setForumId(String.valueOf(b2Var.Q()));
            this.K.setFrom("frs_card");
            ArrayList<VoiceData$VoiceModel> x1 = b2Var.x1();
            if (ListUtils.isEmpty(x1)) {
                this.n.setVisibility(8);
            } else {
                this.n.m();
                this.n.setVisibility(0);
                VoiceData$VoiceModel voiceData$VoiceModel = x1.get(0);
                this.n.setVoiceModel(voiceData$VoiceModel);
                this.n.setTag(voiceData$VoiceModel);
                this.n.b();
                if (voiceData$VoiceModel != null) {
                    this.n.k(voiceData$VoiceModel.voice_status.intValue());
                }
            }
            ArrayList<MediaData> z0 = b2Var.z0();
            if (k.c().g() && ListUtils.getCount(z0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < z0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(z0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.D.setVisibility(0);
                    this.D.setFromCDN(this.E);
                    this.D.setImageClickListener(new C1734c(this, linkedList, b2Var));
                    this.D.setImageMediaList(linkedList);
                } else {
                    this.D.setVisibility(8);
                }
            } else {
                this.D.setVisibility(8);
            }
            Q();
            I();
            P();
            if ((d.a.s0.u0.b.e().g() || d.a.s0.u0.a.h().j()) && this.o.isInFrsAllThread()) {
                this.J.setVisibility(0);
                if (!this.z.Z1() && !this.z.a2() && !this.z.o2()) {
                    this.J.setBackgroundResource(R.color.transparent);
                } else {
                    SkinManager.setBackgroundColor(this.J, R.color.CAM_X0201);
                }
            } else {
                this.J.setVisibility(8);
            }
            n(this.A, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) || bdUniqueId == null || this.o == null) {
            return;
        }
        J(bdUniqueId);
    }

    public final void F(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            if (b2Var != null && v(2) == 1) {
                if (!StringUtils.isNull(this.w) && !StringUtils.isNull(this.x)) {
                    b2Var.a4(this.w, this.x);
                }
                SpannableString w2 = b2Var.w2();
                if (w2 != null && !d.a.c.e.p.k.isEmpty(w2.toString())) {
                    this.C.setVisibility(0);
                    this.C.setOnTouchListener(new d.a.s0.z3.i(w2));
                    this.C.setText(w2);
                    m.l(this.C, b2Var.c0(), R.color.CAM_X0107, R.color.CAM_X0109);
                    return;
                }
                this.C.setVisibility(8);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public void G(d.a.c.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || (constrainImageGroup = this.D) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void H(d.a.c.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || (constrainImageGroup = this.D) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n.setClickable(true);
            int childCount = this.D.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.D.getChildAt(i2);
                if (childAt != null) {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public final void J(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.r;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            ConstrainImageGroup constrainImageGroup = this.D;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void K(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d2)}) == null) || (constrainImageGroup = this.D) == null) {
            return;
        }
        constrainImageGroup.setSingleImageRatio(d2);
    }

    public final boolean L(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b2Var)) == null) {
            if (!StringUtils.isNull(this.w) && !StringUtils.isNull(this.x)) {
                b2Var.a4(this.w, this.x);
            }
            SpannableStringBuilder F2 = b2Var.F2(false, true);
            if (F2 != null && !StringUtils.isNull(F2.toString())) {
                this.B.setVisibility(0);
                this.B.setOnTouchListener(new d.a.s0.z3.i(F2));
                this.B.setText(F2);
                m.l(this.B, b2Var.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
            } else {
                this.B.setVisibility(8);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void M(int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (b2Var = this.z) == null) {
            return;
        }
        if (i2 == 1) {
            this.o.setVisibility(8);
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.p;
            if (threadSourceShareAndPraiseLayout != null) {
                threadSourceShareAndPraiseLayout.g(this.z);
                return;
            }
            return;
        }
        this.o.setData(b2Var);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout2 = this.p;
        if (threadSourceShareAndPraiseLayout2 != null) {
            threadSourceShareAndPraiseLayout2.setVisibility(8);
        }
    }

    public final void N(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, b2Var) == null) || this.G == null) {
            return;
        }
        if (this.u != null && b2Var != null) {
            if (!StringUtils.isNull(b2Var.w1) && this.u.getVisibility() != 0) {
                i iVar = this.I;
                if (iVar != null && iVar.b() && (this.G.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.A.getPageActivity(), R.dimen.tbds106);
                    this.G.setLayoutParams(layoutParams);
                }
                this.G.setVisibility(0);
                this.G.setImageDrawable(null);
                this.G.M(b2Var.w1, 10, false);
                this.G.setOnClickListener(new d(this, b2Var));
                return;
            }
            this.G.setVisibility(8);
            return;
        }
        this.G.setVisibility(8);
    }

    public final void O(View view, List<MediaData> list, int i2, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048587, this, view, list, i2, b2Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                l.L(this.A.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                String str = null;
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    str = mediaData.getSrc_pic();
                } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                }
                if (!StringUtils.isNull(str)) {
                    arrayList.add(str);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.E ? 13 : 14;
                    imageUrlData.imageUrl = w(mediaData);
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = d.a.c.e.m.b.f(b2Var.n1(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(str, imageUrlData);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(arrayList);
            bVar.B(i2);
            bVar.z(b2Var.W());
            bVar.y(String.valueOf(b2Var.Q()));
            bVar.O(b2Var.n1());
            bVar.C(this.E);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.N(b2Var);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.A.getPageActivity());
            v.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.A;
            historyMessage.threadId = b2Var.c0();
            historyMessage.threadName = b2Var.getTitle();
            historyMessage.forumName = b2Var.W();
            historyMessage.postID = b2Var.T();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void P() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (textView = this.B) == null || this.n == null || this.D == null || this.f57033g == null || textView.getVisibility() != 8) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.topMargin = this.f57033g.getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.n.setLayoutParams(layoutParams);
        if (this.n.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams2.topMargin = this.f57033g.getResources().getDimensionPixelSize(R.dimen.tbds28);
            this.D.setLayoutParams(layoutParams2);
        }
    }

    public final void Q() {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.F == null || (constrainImageGroup = this.D) == null || this.q == null) {
            return;
        }
        if (constrainImageGroup.getVisibility() == 8 && this.q.getVisibility() == 8 && this.K.getVisibility() == 8) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
    }

    @Override // d.a.s0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i2) == null) {
            if (this.y != i2) {
                SkinManager.setBackgroundResource(l(), R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
                this.D.b();
                this.o.onChangeSkinType();
                this.r.h();
                AppletsCellView appletsCellView = this.K;
                if (appletsCellView != null) {
                    appletsCellView.c();
                }
                this.I.c();
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.p;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.p.f();
                }
                HeadPendantClickableView headPendantClickableView = this.m;
                if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
                    this.m.getHeadView().setPlaceHolder(1);
                }
            }
            this.y = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
        }
    }

    @Override // d.a.s0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.l = i2;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.o;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.R = i2;
                threadCommentAndPraiseInfoLayout.setFrom(2);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.r;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setFrom(3);
            }
        }
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.H = str;
        }
    }

    public int v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? d.a.s0.o.d.c().b(this.H, i2) : invokeI.intValue;
    }

    public final String w(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, mediaData)) == null) {
            if (mediaData == null) {
                return "";
            }
            String picUrl = mediaData.getPicUrl();
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getSmallUrl();
            }
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getThumbnails_url();
            }
            return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
        }
        return (String) invokeL.objValue;
    }

    public void x(b2 b2Var) {
        MetaData H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, b2Var) == null) || b2Var == null || this.u == null || (H = b2Var.H()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = H.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.u.setVisibility(0);
            this.u.setImageDrawable(null);
            this.u.M(themeCard.getCardImageUrlAndroid(), 10, false);
            this.u.setOnClickListener(new e(this, themeCard));
            return;
        }
        this.u.setVisibility(8);
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void z(boolean z);
}
