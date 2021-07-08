package d.a.p0.v.d.b.d;

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
import d.a.o0.r.q.b2;
import d.a.p0.n2.f;
import d.a.p0.n2.o;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f64264a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f64265b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f64266c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f64267d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.n2.f f64268e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.v.d.b.b.c f64269f;

    /* renamed from: g  reason: collision with root package name */
    public int f64270g;

    /* renamed from: h  reason: collision with root package name */
    public int f64271h;

    /* renamed from: i  reason: collision with root package name */
    public int f64272i;
    public int j;
    public int k;
    public String l;
    public boolean m;
    public f n;
    public int o;
    public TbCyberVideoView.h p;
    public CyberPlayerManager.OnErrorListener q;
    public CyberPlayerManager.OnPreparedListener r;
    public View.OnClickListener s;

    /* loaded from: classes8.dex */
    public class a implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64273e;

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
            this.f64273e = bVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64273e.r();
            }
        }
    }

    /* renamed from: d.a.p0.v.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1752b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64274e;

        public C1752b(b bVar) {
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
            this.f64274e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f64274e.s(false);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64275e;

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
            this.f64275e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64275e.f64267d == null) {
                return;
            }
            this.f64275e.f64267d.setLooping(false);
            this.f64275e.f64267d.setVolume(0.0f, 0.0f);
            if (this.f64275e.f64269f != null && this.f64275e.f64269f.f64240a != null) {
                if (this.f64275e.m) {
                    if (this.f64275e.n != null) {
                        this.f64275e.n.b(this.f64275e.f64269f.f64240a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.f64275e.f64269f.f64241b != 0) {
                        if (this.f64275e.f64269f.f64241b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.f64275e.f64269f.f64240a.n1());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.f64275e.f64267d.getCyberPlayer() != null) {
                b bVar = this.f64275e;
                bVar.v(bVar.f64267d.getCyberPlayer().getVideoHeight(), this.f64275e.f64267d.getCyberPlayer().getVideoWidth());
            }
            if (this.f64275e.f64266c != null) {
                this.f64275e.f64266c.d();
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.p0.n2.f.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64276e;

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
            this.f64276e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64276e.f64269f == null || this.f64276e.f64269f.f64240a == null) {
                return;
            }
            if (this.f64276e.n != null) {
                this.f64276e.n.a(this.f64276e.f64269f.f64240a);
            }
            if (this.f64276e.f64269f.f64240a != null && this.f64276e.f64269f.f64240a.g1() != null && this.f64276e.f64269f.f64240a.g1().isLegalYYLiveData()) {
                AlaInfoData g1 = this.f64276e.f64269f.f64240a.g1();
                TbPageContext tbPageContext = this.f64276e.f64264a;
                YyExtData yyExtData = g1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + g1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.f64276e;
            bVar.l(bVar.f64264a, this.f64276e.f64269f.f64240a);
        }
    }

    /* loaded from: classes8.dex */
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
        this.f64264a = null;
        this.l = "";
        this.m = false;
        this.p = new a(this);
        this.q = new C1752b(this);
        this.r = new c(this);
        this.s = new e(this);
        this.f64264a = tbPageContext;
        k();
    }

    public final void i() {
        d.a.p0.v.d.b.b.c cVar;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f64269f) == null || (b2Var = cVar.f64240a) == null || b2Var.g1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f64267d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f64268e = new d.a.p0.n2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f64264a.getPageActivity());
        this.f64267d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f64267d.setOnErrorListener(this.q);
        this.f64267d.setOnSurfaceDestroyedListener(this.p);
        this.f64267d.setVolume(0.0f, 0.0f);
        this.f64267d.setStageType(null);
        this.f64268e.l(this.f64267d);
        this.f64268e.k(new d(this));
        if (this.f64267d.getParent() == null) {
            this.f64265b.addView(this.f64267d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f64269f.f64240a.g1().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64265b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.f64264a) == null) {
            return;
        }
        this.f64265b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f64271h = l.k(this.f64264a.getPageActivity());
        int i2 = l.i(this.f64264a.getPageActivity());
        this.f64272i = i2;
        int i3 = this.f64271h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f64266c = (AlaSquareLiveVideoMask) this.f64265b.findViewById(R.id.video_mask);
        this.f64265b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, b2 b2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, b2Var) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
            return;
        }
        d.a.p0.v.d.b.b.c cVar = this.f64269f;
        if (cVar != null && cVar.f64240a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f64269f.f64241b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f64269f.f64240a.n1());
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
            this.f64271h = l.k(this.f64264a.getPageActivity());
            int i2 = l.i(this.f64264a.getPageActivity());
            this.f64272i = i2;
            int i3 = this.f64271h;
            this.j = (int) ((i3 / 16.0d) * 9.0d);
            int i4 = (int) ((i3 / 4.0d) * 3.0d);
            this.k = i4;
            this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
            if (this.f64269f != null) {
                TbCyberVideoView tbCyberVideoView = this.f64267d;
                boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
                t(this.f64269f.f64240a.g1().screen_direction);
                u(this.f64269f.f64240a.g1().screen_direction);
                r();
                if (isPlaying) {
                    x(this.l);
                }
            }
        }
    }

    public void n(d.a.p0.v.d.b.b.c cVar) {
        b2 b2Var;
        b2 b2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (b2Var = cVar.f64240a) == null || b2Var.g1() == null) {
            return;
        }
        d.a.p0.v.d.b.b.c cVar2 = this.f64269f;
        if (cVar2 == null || ((b2Var2 = cVar2.f64240a) != null && !b2Var2.n1().equals(cVar.f64240a.n1()))) {
            t(cVar.f64240a.g1().screen_direction);
        }
        this.f64269f = cVar;
        this.f64270g = cVar.f64240a.g1().screen_direction;
        this.f64266c.setData(this.f64269f.f64240a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f64266c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.b();
            }
            SkinManager.setBackgroundColor(this.f64267d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f64266c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.c();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.p0.n2.f fVar = this.f64268e;
            if (fVar != null) {
                fVar.l(null);
                this.f64268e.n();
                this.f64268e = null;
            }
            TbCyberVideoView tbCyberVideoView = this.f64267d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                this.f64267d.I();
                if (this.f64267d.getMediaProgressObserver() != null) {
                    this.f64267d.getMediaProgressObserver().l(null);
                    this.f64267d.getMediaProgressObserver().n();
                }
                this.f64267d = null;
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
            TbCyberVideoView tbCyberVideoView = this.f64267d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
            this.f64266c.f();
            this.f64266c.e();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                if (this.m) {
                    if (this.f64265b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f64265b.getLayoutParams();
                        layoutParams.width = this.f64271h;
                        layoutParams.height = this.k;
                        this.f64265b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f64265b.setLayoutParams(new FrameLayout.LayoutParams(this.f64271h, this.k));
                    return;
                } else if (this.f64265b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f64265b.getLayoutParams();
                    int i3 = this.f64271h;
                    layoutParams2.width = i3;
                    layoutParams2.height = i3;
                    this.f64265b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f64265b;
                    int i4 = this.f64271h;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                    return;
                }
            }
            this.f64270g = 2;
            if (this.m) {
                if (this.f64265b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f64265b.getLayoutParams();
                    layoutParams3.width = this.f64271h;
                    layoutParams3.height = this.j;
                    this.f64265b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f64265b.setLayoutParams(new AbsListView.LayoutParams(this.f64271h, this.j));
            } else if (this.f64265b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f64265b.getLayoutParams();
                layoutParams4.width = this.f64271h;
                layoutParams4.height = this.j;
                this.f64265b.setLayoutParams(layoutParams4);
            } else {
                this.f64265b.setLayoutParams(new AbsListView.LayoutParams(this.f64271h, this.j));
            }
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (tbCyberVideoView = this.f64267d) == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f64267d.getLayoutParams();
                layoutParams.width = this.f64271h;
                layoutParams.height = this.f64272i;
                layoutParams.topMargin = -this.o;
                this.f64267d.setLayoutParams(layoutParams);
                return;
            }
            this.f64267d.setLayoutParams(new FrameLayout.LayoutParams(this.f64271h, this.f64272i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f64267d.getLayoutParams();
            layoutParams2.width = this.f64271h;
            layoutParams2.height = this.j;
            this.f64267d.setLayoutParams(layoutParams2);
        } else {
            this.f64267d.setLayoutParams(new FrameLayout.LayoutParams(this.f64271h, this.j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || this.f64270g != 1 || (tbCyberVideoView = this.f64267d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f64271h;
        float f5 = i4 * f2;
        int i5 = this.f64272i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f64267d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f64267d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f64267d.setLayoutParams(layoutParams);
            return;
        }
        this.f64267d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void x(String str) {
        d.a.p0.v.d.b.b.c cVar;
        b2 b2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f64269f) == null || (b2Var = cVar.f64240a) == null || b2Var.g1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f64267d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f64267d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f64267d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f60809a = "9";
        oVar.f60812d = String.valueOf(this.f64269f.f64240a.Q());
        oVar.f60811c = this.f64269f.f64240a.n1();
        this.f64267d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f64267d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f64269f.f64240a.g1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f64267d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.a.p0.n2.f fVar = this.f64268e;
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
        this.f64266c.setFromSpecialForum(z);
    }
}
