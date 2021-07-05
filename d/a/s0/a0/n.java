package d.a.s0.a0;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class n extends d.a.s0.a0.b<d.a.s0.a0.e0.k> implements d.a.s0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int L;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstrainImageGroup A;
    public View B;
    public boolean C;
    public boolean D;
    public RelativeLayout E;
    public String F;
    public ThreadForumEnterButton G;
    public String H;
    public View.OnClickListener I;
    public final View.OnClickListener J;
    public final View.OnClickListener K;
    public HeadPendantClickableView m;
    public PlayVoiceBntNew n;
    public ThreadCommentAndPraiseInfoLayout o;
    public ThreadGodReplyLayout p;
    public ThreadUserInfoLayout q;
    public LinearLayout r;
    public NEGFeedBackView s;
    public View t;
    public ThreadSourceShareAndPraiseLayout u;
    public int v;
    public d.a.s0.a0.e0.k w;
    public TbPageContext<?> x;
    public TextView y;
    public TextView z;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f57125e;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57125e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57125e.i() != null) {
                    this.f57125e.i().a(view, this.f57125e.w);
                }
                if (this.f57125e.w == null || this.f57125e.w.f57050e == null) {
                    return;
                }
                m.a(this.f57125e.w.f57050e.c0());
                if (this.f57125e.G()) {
                    return;
                }
                m.l(this.f57125e.y, this.f57125e.w.getThreadData().c0(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.l(this.f57125e.z, this.f57125e.w.f57050e.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.l(this.f57125e.p.getGodReplyContent(), this.f57125e.w.f57050e.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f57126e;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57126e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57126e.i() != null) {
                    this.f57126e.i().a(view, this.f57126e.w);
                }
                if (this.f57126e.w == null || this.f57126e.w.f57050e == null) {
                    return;
                }
                n nVar = this.f57126e;
                if (view == nVar.u.f12587e) {
                    return;
                }
                m.a(nVar.w.f57050e.c0());
                if (this.f57126e.G()) {
                    return;
                }
                m.l(this.f57126e.y, this.f57126e.w.getThreadData().c0(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.l(this.f57126e.z, this.f57126e.w.f57050e.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.l(this.f57126e.p.getGodReplyContent(), this.f57126e.w.f57050e.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d.a.r0.b1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f57127a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b2 f57128b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ n f57129c;

        public c(n nVar, LinkedList linkedList, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, linkedList, b2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57129c = nVar;
            this.f57127a = linkedList;
            this.f57128b = b2Var;
        }

        @Override // d.a.r0.b1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                b0<d.a.s0.a0.e0.k> i3 = this.f57129c.i();
                if (i3 != null) {
                    view.setTag("1");
                    if (this.f57129c.K != null) {
                        this.f57129c.K.onClick(this.f57129c.A);
                    }
                    i3.a(view, this.f57129c.w);
                }
                if (z) {
                    this.f57129c.H();
                } else {
                    this.f57129c.T(view, this.f57127a, i2, this.f57128b);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f57130e;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57130e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57130e.w != null) {
                    this.f57130e.w.k = 1;
                }
                if (this.f57130e.i() != null) {
                    this.f57130e.i().a(view, this.f57130e.w);
                }
                n nVar = this.f57130e;
                nVar.I(view == nVar.p);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f57131e;

        public e(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57131e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.s0.a0.e0.k> i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (i2 = this.f57131e.i()) == null) {
                return;
            }
            view.setTag("2");
            i2.a(view, this.f57131e.w);
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f57132e;

        public f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57132e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57132e.w == null) {
                    if (this.f57132e.i() != null) {
                        this.f57132e.i().a(view, this.f57132e.w);
                        return;
                    }
                    return;
                }
                if (view == this.f57132e.q.getUserName()) {
                    this.f57132e.w.k = 3;
                } else if (view == this.f57132e.q.getHeaderImg()) {
                    this.f57132e.w.k = 4;
                } else if (view == this.f57132e.A) {
                    this.f57132e.w.k = 2;
                    return;
                } else {
                    this.f57132e.w.k = 1;
                }
                if (this.f57132e.i() != null) {
                    this.f57132e.i().a(view, this.f57132e.w);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-643885056, "Ld/a/s0/a0/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-643885056, "Ld/a/s0/a0/n;");
                return;
            }
        }
        L = d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - ((d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = null;
        this.v = 3;
        this.C = true;
        this.D = true;
        this.I = new d(this);
        this.J = new e(this);
        this.K = new f(this);
        View l = l();
        this.x = tbPageContext;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) l.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setPlaceHolder(1);
            this.m.getHeadView().setRadius(d.a.c.e.p.l.g(this.x.getPageActivity(), R.dimen.ds70));
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.y = (TextView) l.findViewById(R.id.card_home_page_normal_thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) l.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.n = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.J);
        this.z = (TextView) l.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.A = (ConstrainImageGroup) l.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.B = l.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.A.setChildClickListener(this.I);
        this.A.setImageMargin(dimensionPixelSize);
        d.a.r0.b1.j.f fVar = new d.a.r0.b1.j.f(3);
        fVar.d(1.0d);
        this.A.setImageProcessor(fVar);
        this.t = l.findViewById(R.id.divider_line_above_praise);
        this.o = (ThreadCommentAndPraiseInfoLayout) l.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.q = (ThreadUserInfoLayout) l.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.s = new NEGFeedBackView(this.x);
        this.E = (RelativeLayout) l.findViewById(R.id.card_home_page_normal_thread_root);
        this.s.l(this.E, d.a.c.e.p.l.g(this.f57033g, R.dimen.tbds120), 0);
        if (this.o.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.o.setLayoutParams(layoutParams);
        }
        this.o.setOnClickListener(this.I);
        this.o.setReplyTimeVisible(false);
        this.o.setShowPraiseNum(true);
        this.o.setNeedAddPraiseIcon(true);
        this.o.setNeedAddReplyIcon(true);
        this.o.setShareVisible(true);
        this.o.setFrom(1);
        this.o.setShareReportFrom(3);
        this.o.setForumAfterClickListener(new a(this));
        this.r = (LinearLayout) l.findViewById(R.id.card_home_page_normal_thread_content_layout);
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) l.findViewById(R.id.card_home_page_god_reply_layout);
        this.p = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this.I);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) l.findViewById(R.id.card_home_page_source_read_share_layout);
        this.u = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12588f.setOnClickListener(this.I);
        this.u.setFrom(1);
        this.u.setShareReportFrom(3);
        this.u.setForumAfterClickListener(new b(this));
        this.G = (ThreadForumEnterButton) l.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public int F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? d.a.s0.o.d.c().b(this.F, i2) : invokeI.intValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.s0.a0.e0.k kVar = this.w;
            return kVar.U && !kVar.V;
        }
        return invokeV.booleanValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            I(false);
        }
    }

    public final void I(boolean z) {
        d.a.s0.a0.e0.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (kVar = this.w) == null || kVar.f57050e == null) {
            return;
        }
        if (!G()) {
            m.a(this.w.f57050e.c0());
            m.l(this.y, this.w.getThreadData().c0(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.z, this.w.f57050e.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.p.getGodReplyContent(), this.w.f57050e.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(this.w.f57050e, null, m.g(), 18003, true, false, false).addLocateParam(this.w.getPbInputLocate());
        addLocateParam.setForumId(String.valueOf(this.w.f57050e.Q()));
        addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
        addLocateParam.setForumName(this.w.f57050e.W());
        addLocateParam.setStartFrom(this.l);
        if (z) {
            addLocateParam.setJumpGodReply(true);
        }
        m.a(this.w.getThreadData().n1());
        this.x.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: J */
    public void m(d.a.s0.a0.e0.k kVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            if (kVar != null && kVar.getThreadData() != null) {
                this.w = kVar;
                if (l() != null) {
                    l().setVisibility(0);
                    l().setOnClickListener(this.I);
                }
                if (this.s != null) {
                    SparseArray<String> sparseArray = this.w.feedBackReasonMap;
                    if (sparseArray != null && sparseArray.size() > 0) {
                        w0 w0Var = new w0();
                        w0Var.n(this.w.getThreadData().n1());
                        w0Var.k(this.w.getThreadData().Q());
                        w0Var.m(this.w.getThreadData().A0());
                        w0Var.j(this.w.feedBackReasonMap);
                        this.s.setData(w0Var);
                        this.s.setFirstRowSingleColumn(true);
                        if (kVar.f57050e.H() != null && !StringUtils.isNull(kVar.f57050e.H().getUserId())) {
                            if (kVar.f57050e.H().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                                this.s.setVisibility(8);
                            } else {
                                NEGFeedBackView nEGFeedBackView = this.s;
                                if (nEGFeedBackView != null) {
                                    nEGFeedBackView.setVisibility(this.D ? 0 : 8);
                                }
                            }
                        }
                    } else {
                        this.s.setVisibility(8);
                    }
                }
                this.q.j(kVar.f57050e);
                this.p.setFromCDN(this.C);
                this.p.setData(kVar.f57050e.p1());
                if (!G() && m.k(this.w.f57050e.c0())) {
                    m.l(this.y, this.w.getThreadData().c0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    m.l(this.z, this.w.f57050e.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    m.l(this.p.getGodReplyContent(), this.w.f57050e.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                this.q.setUserAfterClickListener(this.K);
                b2 threadData = kVar.getThreadData();
                if (this.q.getHeaderImg() != null) {
                    if (this.q.getIsSimpleThread()) {
                        this.q.getHeaderImg().setVisibility(8);
                        this.m.setVisibility(8);
                    } else if (threadData.H() != null && threadData.H().getPendantData() != null && !StringUtils.isNull(threadData.H().getPendantData().a())) {
                        this.q.getHeaderImg().setVisibility(4);
                        this.m.setVisibility(0);
                        this.m.setData(threadData);
                    } else {
                        this.m.setVisibility(8);
                        this.q.getHeaderImg().setVisibility(0);
                        this.q.getHeaderImg().setData(threadData);
                    }
                }
                ThreadCardUtils.setTitle(this.y, threadData);
                ThreadCardUtils.setAbstract(this.z, this.y, threadData, L);
                ArrayList<VoiceData$VoiceModel> x1 = kVar.f57050e.x1();
                if (ListUtils.isEmpty(x1)) {
                    this.n.setVisibility(8);
                    z = false;
                } else {
                    this.n.setVisibility(0);
                    VoiceData$VoiceModel voiceData$VoiceModel = x1.get(0);
                    this.n.setVoiceModel(voiceData$VoiceModel);
                    this.n.setTag(voiceData$VoiceModel);
                    this.n.b();
                    if (voiceData$VoiceModel != null) {
                        this.n.k(voiceData$VoiceModel.voice_status.intValue());
                    }
                    this.n.m();
                    z = true;
                }
                if (this.w.U && z) {
                    this.A.setVisibility(8);
                } else {
                    ArrayList<MediaData> z0 = threadData.z0();
                    if (d.a.r0.r.k.c().g() && ListUtils.getCount(z0) != 0) {
                        LinkedList linkedList = new LinkedList();
                        for (int i2 = 0; i2 < z0.size(); i2++) {
                            MediaData mediaData = (MediaData) ListUtils.getItem(z0, i2);
                            if (mediaData != null && mediaData.getType() == 3) {
                                linkedList.add(mediaData);
                            }
                        }
                        if (ListUtils.getCount(linkedList) > 0) {
                            this.A.setVisibility(0);
                            this.A.setFromCDN(this.C);
                            this.A.setImageClickListener(new c(this, linkedList, threadData));
                            this.A.setImageMediaList(linkedList);
                        } else {
                            this.A.setVisibility(8);
                        }
                    } else {
                        this.A.setVisibility(8);
                    }
                }
                U();
                O();
                Q(j());
                this.G.setVisibility(8);
                S(F(1));
                n(this.x, TbadkCoreApplication.getInst().getSkinType());
            } else if (l() != null) {
                l().setVisibility(8);
            }
        }
    }

    public void K(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        Q(bdUniqueId);
    }

    public void L(d.a.c.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (constrainImageGroup = this.A) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void M(d.a.c.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (constrainImageGroup = this.A) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.C = z;
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!this.w.V) {
                this.n.setClickable(false);
            } else {
                this.n.setClickable(true);
            }
            int childCount = this.A.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt != null) {
                    if (!this.w.V) {
                        childAt.setClickable(false);
                    } else {
                        childAt.setClickable(true);
                    }
                }
            }
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.D = z;
        }
    }

    public final void Q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            p(bdUniqueId);
            ConstrainImageGroup constrainImageGroup = this.A;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
            NEGFeedBackView nEGFeedBackView = this.s;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setUniqueId(bdUniqueId);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.q;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void R(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (view = this.B) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void S(int i2) {
        d.a.s0.a0.e0.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (kVar = this.w) == null || kVar.f57050e == null) {
            return;
        }
        this.H = m.g();
        if (i2 == 1) {
            this.o.setVisibility(8);
            this.u.setStType(this.H);
            this.u.g(this.w.f57050e);
            this.q.l(false);
            return;
        }
        this.o.setData(this.w.f57050e);
        this.o.setStType(this.H);
        this.u.setVisibility(8);
        this.q.l(true);
    }

    public final void T(View view, List<MediaData> list, int i2, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048590, this, view, list, i2, b2Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                d.a.c.e.p.l.L(this.x.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    arrayList.add(mediaData.getSrc_pic());
                    if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = this.C ? 13 : 14;
                        imageUrlData.imageUrl = mediaData.getPicUrl();
                        imageUrlData.originalUrl = mediaData.getOriginalUrl();
                        imageUrlData.originalSize = mediaData.getOriginalSize();
                        imageUrlData.isLongPic = mediaData.isLongPic();
                        imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                        imageUrlData.threadId = d.a.c.e.m.b.f(b2Var.n1(), -1L);
                        imageUrlData.postId = mediaData.getPostId();
                        concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                for (MediaData mediaData2 : list) {
                    if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                        arrayList.add(mediaData2.getPicUrl());
                    }
                }
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(arrayList);
            bVar.B(i2);
            bVar.z(b2Var.W());
            bVar.y(String.valueOf(b2Var.Q()));
            bVar.O(b2Var.n1());
            bVar.C(this.C);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.x.getPageActivity());
            if (this.l == 2) {
                v.getIntent().putExtra("from", "index");
            } else {
                v.getIntent().putExtra("from", "other");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.x;
            historyMessage.threadId = b2Var.c0();
            historyMessage.threadName = b2Var.getTitle();
            historyMessage.forumName = b2Var.W();
            historyMessage.postID = b2Var.T();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void U() {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.t == null || (constrainImageGroup = this.A) == null || this.p == null) {
            return;
        }
        if (constrainImageGroup.getVisibility() == 8 && this.p.getVisibility() == 8) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.card_home_page_multi_img_new : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, tbPageContext, i2) == null) {
            if (this.v != i2) {
                SkinManager.setBackgroundResource(l(), R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.t, R.color.transparent);
                this.A.b();
                this.o.onChangeSkinType();
                this.p.l();
                this.q.h();
                NEGFeedBackView nEGFeedBackView = this.s;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.q();
                }
                SkinManager.setBackgroundColor(this.B, R.color.CAM_X0204);
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.u;
                if (threadSourceShareAndPraiseLayout != null) {
                    threadSourceShareAndPraiseLayout.f();
                }
            }
            this.v = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
        }
    }

    @Override // d.a.s0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.F = str;
        }
    }
}
