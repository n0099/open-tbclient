package d.a.q0.v.d.b.d;

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
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.q0.n2.f;
import d.a.q0.n2.o;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f64909a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f64910b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f64911c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f64912d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.n2.f f64913e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.v.d.b.b.c f64914f;

    /* renamed from: g  reason: collision with root package name */
    public int f64915g;

    /* renamed from: h  reason: collision with root package name */
    public int f64916h;

    /* renamed from: i  reason: collision with root package name */
    public int f64917i;
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
        public final /* synthetic */ b f64918e;

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
            this.f64918e = bVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64918e.r();
            }
        }
    }

    /* renamed from: d.a.q0.v.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1755b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64919e;

        public C1755b(b bVar) {
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
            this.f64919e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f64919e.s(false);
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
        public final /* synthetic */ b f64920e;

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
            this.f64920e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64920e.f64912d == null) {
                return;
            }
            this.f64920e.f64912d.setLooping(false);
            this.f64920e.f64912d.setVolume(0.0f, 0.0f);
            if (this.f64920e.f64914f != null && this.f64920e.f64914f.f64885a != null) {
                if (this.f64920e.m) {
                    if (this.f64920e.n != null) {
                        this.f64920e.n.b(this.f64920e.f64914f.f64885a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.f64920e.f64914f.f64886b != 0) {
                        if (this.f64920e.f64914f.f64886b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.f64920e.f64914f.f64885a.o1());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.f64920e.f64912d.getCyberPlayer() != null) {
                b bVar = this.f64920e;
                bVar.v(bVar.f64912d.getCyberPlayer().getVideoHeight(), this.f64920e.f64912d.getCyberPlayer().getVideoWidth());
            }
            if (this.f64920e.f64911c != null) {
                this.f64920e.f64911c.d();
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

        @Override // d.a.q0.n2.f.d
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
        public final /* synthetic */ b f64921e;

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
            this.f64921e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64921e.f64914f == null || this.f64921e.f64914f.f64885a == null) {
                return;
            }
            if (this.f64921e.n != null) {
                this.f64921e.n.a(this.f64921e.f64914f.f64885a);
            }
            if (this.f64921e.f64914f.f64885a != null && this.f64921e.f64914f.f64885a.h1() != null && this.f64921e.f64914f.f64885a.h1().isLegalYYLiveData()) {
                AlaInfoData h1 = this.f64921e.f64914f.f64885a.h1();
                TbPageContext tbPageContext = this.f64921e.f64909a;
                YyExtData yyExtData = h1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + h1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.f64921e;
            bVar.l(bVar.f64909a, this.f64921e.f64914f.f64885a);
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
        this.f64909a = null;
        this.l = "";
        this.m = false;
        this.p = new a(this);
        this.q = new C1755b(this);
        this.r = new c(this);
        this.s = new e(this);
        this.f64909a = tbPageContext;
        k();
    }

    public final void i() {
        d.a.q0.v.d.b.b.c cVar;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f64914f) == null || (b2Var = cVar.f64885a) == null || b2Var.h1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f64912d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f64913e = new d.a.q0.n2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f64909a.getPageActivity());
        this.f64912d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f64912d.setOnErrorListener(this.q);
        this.f64912d.setOnSurfaceDestroyedListener(this.p);
        this.f64912d.setVolume(0.0f, 0.0f);
        this.f64912d.setStageType(null);
        this.f64913e.l(this.f64912d);
        this.f64913e.k(new d(this));
        if (this.f64912d.getParent() == null) {
            this.f64910b.addView(this.f64912d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f64914f.f64885a.h1().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64910b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.f64909a) == null) {
            return;
        }
        this.f64910b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f64916h = l.k(this.f64909a.getPageActivity());
        int i2 = l.i(this.f64909a.getPageActivity());
        this.f64917i = i2;
        int i3 = this.f64916h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f64911c = (AlaSquareLiveVideoMask) this.f64910b.findViewById(R.id.video_mask);
        this.f64910b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, b2 b2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, b2Var) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.h1() == null) {
            return;
        }
        d.a.q0.v.d.b.b.c cVar = this.f64914f;
        if (cVar != null && cVar.f64885a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f64914f.f64886b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f64914f.f64885a.o1());
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
        alaLiveInfoCoreData.fillWithInfoData(b2Var.h1());
        alaLiveInfoCoreData.userName = b2Var.h1().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f64916h = l.k(this.f64909a.getPageActivity());
            int i2 = l.i(this.f64909a.getPageActivity());
            this.f64917i = i2;
            int i3 = this.f64916h;
            this.j = (int) ((i3 / 16.0d) * 9.0d);
            int i4 = (int) ((i3 / 4.0d) * 3.0d);
            this.k = i4;
            this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
            if (this.f64914f != null) {
                TbCyberVideoView tbCyberVideoView = this.f64912d;
                boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
                t(this.f64914f.f64885a.h1().screen_direction);
                u(this.f64914f.f64885a.h1().screen_direction);
                r();
                if (isPlaying) {
                    x(this.l);
                }
            }
        }
    }

    public void n(d.a.q0.v.d.b.b.c cVar) {
        b2 b2Var;
        b2 b2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (b2Var = cVar.f64885a) == null || b2Var.h1() == null) {
            return;
        }
        d.a.q0.v.d.b.b.c cVar2 = this.f64914f;
        if (cVar2 == null || ((b2Var2 = cVar2.f64885a) != null && !b2Var2.o1().equals(cVar.f64885a.o1()))) {
            t(cVar.f64885a.h1().screen_direction);
        }
        this.f64914f = cVar;
        this.f64915g = cVar.f64885a.h1().screen_direction;
        this.f64911c.setData(this.f64914f.f64885a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f64911c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.b();
            }
            SkinManager.setBackgroundColor(this.f64912d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f64911c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.c();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.q0.n2.f fVar = this.f64913e;
            if (fVar != null) {
                fVar.l(null);
                this.f64913e.n();
                this.f64913e = null;
            }
            TbCyberVideoView tbCyberVideoView = this.f64912d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                this.f64912d.I();
                if (this.f64912d.getMediaProgressObserver() != null) {
                    this.f64912d.getMediaProgressObserver().l(null);
                    this.f64912d.getMediaProgressObserver().n();
                }
                this.f64912d = null;
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
            TbCyberVideoView tbCyberVideoView = this.f64912d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
            this.f64911c.f();
            this.f64911c.e();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                if (this.m) {
                    if (this.f64910b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f64910b.getLayoutParams();
                        layoutParams.width = this.f64916h;
                        layoutParams.height = this.k;
                        this.f64910b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f64910b.setLayoutParams(new FrameLayout.LayoutParams(this.f64916h, this.k));
                    return;
                } else if (this.f64910b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f64910b.getLayoutParams();
                    int i3 = this.f64916h;
                    layoutParams2.width = i3;
                    layoutParams2.height = i3;
                    this.f64910b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f64910b;
                    int i4 = this.f64916h;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                    return;
                }
            }
            this.f64915g = 2;
            if (this.m) {
                if (this.f64910b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f64910b.getLayoutParams();
                    layoutParams3.width = this.f64916h;
                    layoutParams3.height = this.j;
                    this.f64910b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f64910b.setLayoutParams(new AbsListView.LayoutParams(this.f64916h, this.j));
            } else if (this.f64910b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f64910b.getLayoutParams();
                layoutParams4.width = this.f64916h;
                layoutParams4.height = this.j;
                this.f64910b.setLayoutParams(layoutParams4);
            } else {
                this.f64910b.setLayoutParams(new AbsListView.LayoutParams(this.f64916h, this.j));
            }
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (tbCyberVideoView = this.f64912d) == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f64912d.getLayoutParams();
                layoutParams.width = this.f64916h;
                layoutParams.height = this.f64917i;
                layoutParams.topMargin = -this.o;
                this.f64912d.setLayoutParams(layoutParams);
                return;
            }
            this.f64912d.setLayoutParams(new FrameLayout.LayoutParams(this.f64916h, this.f64917i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f64912d.getLayoutParams();
            layoutParams2.width = this.f64916h;
            layoutParams2.height = this.j;
            this.f64912d.setLayoutParams(layoutParams2);
        } else {
            this.f64912d.setLayoutParams(new FrameLayout.LayoutParams(this.f64916h, this.j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || this.f64915g != 1 || (tbCyberVideoView = this.f64912d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f64916h;
        float f5 = i4 * f2;
        int i5 = this.f64917i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f64912d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f64912d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f64912d.setLayoutParams(layoutParams);
            return;
        }
        this.f64912d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void x(String str) {
        d.a.q0.v.d.b.b.c cVar;
        b2 b2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f64914f) == null || (b2Var = cVar.f64885a) == null || b2Var.h1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f64912d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f64912d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f64912d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f61423a = "9";
        oVar.f61426d = String.valueOf(this.f64914f.f64885a.R());
        oVar.f61425c = this.f64914f.f64885a.o1();
        this.f64912d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f64912d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f64914f.f64885a.h1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f64912d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.a.q0.n2.f fVar = this.f64913e;
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
        this.f64911c.setFromSpecialForum(z);
    }
}
