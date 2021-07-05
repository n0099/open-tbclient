package d.a.s0.v.d.b.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.toplivecard.AlaSquareLiveVideoMask;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.s0.n2.f;
import d.a.s0.n2.o;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f67482a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f67483b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f67484c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f67485d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.n2.f f67486e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.v.d.b.b.c f67487f;

    /* renamed from: g  reason: collision with root package name */
    public int f67488g;

    /* renamed from: h  reason: collision with root package name */
    public int f67489h;

    /* renamed from: i  reason: collision with root package name */
    public int f67490i;
    public int j;
    public int k;
    public String l;
    public boolean m;
    public f n;
    public int o;
    public TbCyberVideoView.g p;
    public CyberPlayerManager.OnErrorListener q;
    public CyberPlayerManager.OnPreparedListener r;
    public View.OnClickListener s;

    /* loaded from: classes9.dex */
    public class a implements TbCyberVideoView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67491e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67491e = bVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67491e.r();
            }
        }
    }

    /* renamed from: d.a.s0.v.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1794b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67492e;

        public C1794b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67492e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f67492e.s(false);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67493e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67493e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67493e.f67485d == null) {
                return;
            }
            this.f67493e.f67485d.setLooping(false);
            this.f67493e.f67485d.setVolume(0.0f, 0.0f);
            if (this.f67493e.f67487f != null && this.f67493e.f67487f.f67458a != null) {
                if (this.f67493e.m) {
                    if (this.f67493e.n != null) {
                        this.f67493e.n.b(this.f67493e.f67487f.f67458a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.f67493e.f67487f.f67459b != 0) {
                        if (this.f67493e.f67487f.f67459b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.f67493e.f67487f.f67458a.n1());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.f67493e.f67485d.getCyberPlayer() != null) {
                b bVar = this.f67493e;
                bVar.v(bVar.f67485d.getCyberPlayer().getVideoHeight(), this.f67493e.f67485d.getCyberPlayer().getVideoWidth());
            }
            if (this.f67493e.f67484c != null) {
                this.f67493e.f67484c.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.s0.n2.f.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67494e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67494e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f67494e.f67487f == null || this.f67494e.f67487f.f67458a == null) {
                return;
            }
            if (this.f67494e.n != null) {
                this.f67494e.n.a(this.f67494e.f67487f.f67458a);
            }
            if (this.f67494e.f67487f.f67458a != null && this.f67494e.f67487f.f67458a.g1() != null && this.f67494e.f67487f.f67458a.g1().isLegalYYLiveData()) {
                AlaInfoData g1 = this.f67494e.f67487f.f67458a.g1();
                TbPageContext tbPageContext = this.f67494e.f67482a;
                YyExtData yyExtData = g1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + g1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.f67494e;
            bVar.l(bVar.f67482a, this.f67494e.f67487f.f67458a);
        }
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a(b2 b2Var);

        void b(b2 b2Var);
    }

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67482a = null;
        this.l = "";
        this.m = false;
        this.p = new a(this);
        this.q = new C1794b(this);
        this.r = new c(this);
        this.s = new e(this);
        this.f67482a = tbPageContext;
        k();
    }

    public final void i() {
        d.a.s0.v.d.b.b.c cVar;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f67487f) == null || (b2Var = cVar.f67458a) == null || b2Var.g1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f67485d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f67486e = new d.a.s0.n2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f67482a.getPageActivity());
        this.f67485d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f67485d.setOnErrorListener(this.q);
        this.f67485d.setOnSurfaceDestroyedListener(this.p);
        this.f67485d.setVolume(0.0f, 0.0f);
        this.f67485d.setStageType(null);
        this.f67486e.l(this.f67485d);
        this.f67486e.k(new d(this));
        if (this.f67485d.getParent() == null) {
            this.f67483b.addView(this.f67485d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f67487f.f67458a.g1().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67483b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.f67482a) == null) {
            return;
        }
        this.f67483b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f67489h = l.k(this.f67482a.getPageActivity());
        int i2 = l.i(this.f67482a.getPageActivity());
        this.f67490i = i2;
        int i3 = this.f67489h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f67484c = (AlaSquareLiveVideoMask) this.f67483b.findViewById(R.id.video_mask);
        this.f67483b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, b2 b2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, b2Var) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
            return;
        }
        d.a.s0.v.d.b.b.c cVar = this.f67487f;
        if (cVar != null && cVar.f67458a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f67487f.f67459b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f67487f.f67458a.n1());
            TiebaStatic.log(statisticItem);
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = b2Var.H().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        String str2 = this.m ? AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_TAB_TOP_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND_TOP_CARD;
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(b2Var.g1());
        alaLiveInfoCoreData.userName = b2Var.g1().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f67489h = l.k(this.f67482a.getPageActivity());
            int i2 = l.i(this.f67482a.getPageActivity());
            this.f67490i = i2;
            int i3 = this.f67489h;
            this.j = (int) ((i3 / 16.0d) * 9.0d);
            int i4 = (int) ((i3 / 4.0d) * 3.0d);
            this.k = i4;
            this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
            if (this.f67487f != null) {
                TbCyberVideoView tbCyberVideoView = this.f67485d;
                boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
                t(this.f67487f.f67458a.g1().screen_direction);
                u(this.f67487f.f67458a.g1().screen_direction);
                r();
                if (isPlaying) {
                    x(this.l);
                }
            }
        }
    }

    public void n(d.a.s0.v.d.b.b.c cVar) {
        b2 b2Var;
        b2 b2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (b2Var = cVar.f67458a) == null || b2Var.g1() == null) {
            return;
        }
        d.a.s0.v.d.b.b.c cVar2 = this.f67487f;
        if (cVar2 == null || ((b2Var2 = cVar2.f67458a) != null && !b2Var2.n1().equals(cVar.f67458a.n1()))) {
            t(cVar.f67458a.g1().screen_direction);
        }
        this.f67487f = cVar;
        this.f67488g = cVar.f67458a.g1().screen_direction;
        this.f67484c.setData(this.f67487f.f67458a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f67484c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.b();
            }
            SkinManager.setBackgroundColor(this.f67485d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f67484c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.c();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.s0.n2.f fVar = this.f67486e;
            if (fVar != null) {
                fVar.l(null);
                this.f67486e.n();
                this.f67486e = null;
            }
            TbCyberVideoView tbCyberVideoView = this.f67485d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                this.f67485d.G();
                if (this.f67485d.getMediaProgressObserver() != null) {
                    this.f67485d.getMediaProgressObserver().l(null);
                    this.f67485d.getMediaProgressObserver().n();
                }
                this.f67485d = null;
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            s(true);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                q();
            }
            TbCyberVideoView tbCyberVideoView = this.f67485d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
            this.f67484c.f();
            this.f67484c.e();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                if (this.m) {
                    if (this.f67483b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f67483b.getLayoutParams();
                        layoutParams.width = this.f67489h;
                        layoutParams.height = this.k;
                        this.f67483b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f67483b.setLayoutParams(new FrameLayout.LayoutParams(this.f67489h, this.k));
                    return;
                } else if (this.f67483b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f67483b.getLayoutParams();
                    int i3 = this.f67489h;
                    layoutParams2.width = i3;
                    layoutParams2.height = i3;
                    this.f67483b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f67483b;
                    int i4 = this.f67489h;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                    return;
                }
            }
            this.f67488g = 2;
            if (this.m) {
                if (this.f67483b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f67483b.getLayoutParams();
                    layoutParams3.width = this.f67489h;
                    layoutParams3.height = this.j;
                    this.f67483b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f67483b.setLayoutParams(new AbsListView.LayoutParams(this.f67489h, this.j));
            } else if (this.f67483b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f67483b.getLayoutParams();
                layoutParams4.width = this.f67489h;
                layoutParams4.height = this.j;
                this.f67483b.setLayoutParams(layoutParams4);
            } else {
                this.f67483b.setLayoutParams(new AbsListView.LayoutParams(this.f67489h, this.j));
            }
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (tbCyberVideoView = this.f67485d) == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f67485d.getLayoutParams();
                layoutParams.width = this.f67489h;
                layoutParams.height = this.f67490i;
                layoutParams.topMargin = -this.o;
                this.f67485d.setLayoutParams(layoutParams);
                return;
            }
            this.f67485d.setLayoutParams(new FrameLayout.LayoutParams(this.f67489h, this.f67490i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f67485d.getLayoutParams();
            layoutParams2.width = this.f67489h;
            layoutParams2.height = this.j;
            this.f67485d.setLayoutParams(layoutParams2);
        } else {
            this.f67485d.setLayoutParams(new FrameLayout.LayoutParams(this.f67489h, this.j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || this.f67488g != 1 || (tbCyberVideoView = this.f67485d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f67489h;
        float f5 = i4 * f2;
        int i5 = this.f67490i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f67485d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f67485d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f67485d.setLayoutParams(layoutParams);
            return;
        }
        this.f67485d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void x(String str) {
        d.a.s0.v.d.b.b.c cVar;
        b2 b2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f67487f) == null || (b2Var = cVar.f67458a) == null || b2Var.g1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f67485d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f67485d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f67485d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f64043a = "9";
        oVar.f64046d = String.valueOf(this.f67487f.f67458a.Q());
        oVar.f64045c = this.f67487f.f67458a.n1();
        this.f67485d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f67485d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f67487f.f67458a.g1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f67485d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.a.s0.n2.f fVar = this.f67486e;
        if (fVar != null) {
            fVar.m();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = z;
        this.f67484c.setFromSpecialForum(z);
    }
}
