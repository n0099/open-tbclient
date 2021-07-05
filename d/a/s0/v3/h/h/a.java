package d.a.s0.v3.h.h;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.r0.r.s.j;
import d.a.r0.r.s.l;
import d.a.s0.x1.g;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends d.a.c.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f68696a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f68697b;

    /* renamed from: c  reason: collision with root package name */
    public MaskVideoView f68698c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.v3.h.a f68699d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f68700e;

    /* renamed from: f  reason: collision with root package name */
    public j f68701f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.v3.h.h.c f68702g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.v3.h.h.e f68703h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.v3.h.h.d f68704i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public g o;
    public l.e p;

    /* renamed from: d.a.s0.v3.h.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1851a implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68705e;

        public C1851a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68705e = aVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                a aVar = this.f68705e;
                if (i2 == aVar.l) {
                    return;
                }
                if (i2 == 0) {
                    aVar.f68702g.k().setVisibility(0);
                    this.f68705e.f68703h.v().setVisibility(8);
                    this.f68705e.f68704i.h().setVisibility(8);
                    this.f68705e.f68702g.s(true);
                    this.f68705e.f68703h.F(false);
                    this.f68705e.f68704i.n(false);
                } else if (i2 == 1) {
                    aVar.f68704i.h().setVisibility(0);
                    this.f68705e.f68703h.v().setVisibility(8);
                    this.f68705e.f68702g.k().setVisibility(8);
                    this.f68705e.f68702g.s(false);
                    if (TextUtils.isEmpty(this.f68705e.f68703h.u())) {
                        this.f68705e.f68703h.F(false);
                    } else {
                        this.f68705e.f68703h.F(true);
                    }
                    this.f68705e.f68704i.n(true);
                } else if (i2 == 2) {
                    aVar.f68703h.v().setVisibility(0);
                    this.f68705e.f68702g.k().setVisibility(8);
                    this.f68705e.f68704i.h().setVisibility(8);
                    this.f68705e.f68702g.s(false);
                    this.f68705e.f68703h.F(true);
                    this.f68705e.f68704i.n(false);
                }
                a aVar2 = this.f68705e;
                aVar2.l = i2;
                aVar2.k.setCurrentTab(this.f68705e.l, true, true);
                this.f68705e.g0();
                this.f68705e.H();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68706e;

        /* renamed from: d.a.s0.v3.h.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1852a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f68707e;

            public RunnableC1852a(b bVar) {
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
                this.f68707e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f68707e.f68706e.f68702g.u();
                }
            }
        }

        /* renamed from: d.a.s0.v3.h.h.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1853b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f68708e;

            public C1853b(b bVar) {
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
                this.f68708e = bVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        a aVar = this.f68708e.f68706e;
                        if (aVar.l == 0) {
                            aVar.f68698c.pause();
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68706e = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
        @Override // android.media.MediaPlayer.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mediaPlayer) != null) {
                return;
            }
            this.f68706e.m = mediaPlayer;
            if (!this.f68706e.n) {
                a aVar = this.f68706e;
                if (aVar.l != 0) {
                    aVar.m.setVolume(1.0f, 1.0f);
                    d.a.c.e.m.e.a().postDelayed(new RunnableC1852a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.f68706e.f68698c.start();
                        mediaPlayer.setOnInfoListener(new C1853b(this));
                        return;
                    }
                    this.f68706e.f68698c.seekTo(this.f68706e.f68702g.getCurrentPosition());
                    return;
                }
            }
            this.f68706e.m.setVolume(0.0f, 0.0f);
            d.a.c.e.m.e.a().postDelayed(new RunnableC1852a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68709e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68709e = aVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                a aVar = this.f68709e;
                if (aVar.l != 0) {
                    aVar.Q();
                    this.f68709e.f68703h.K();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68710e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68710e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f68710e.f0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68711e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68711e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f68711e.f68702g.m();
                if (this.f68711e.f68699d != null) {
                    this.f68711e.f68699d.onNext();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68712e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68712e = aVar;
        }

        @Override // d.a.r0.r.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (i2 != 0) {
                    if (i2 == 1 && this.f68712e.f68699d != null) {
                        this.f68712e.f68699d.finishPage();
                    }
                } else if (this.f68712e.f68699d != null) {
                    this.f68712e.f68699d.onSave();
                }
                if (this.f68712e.f68701f == null || !this.f68712e.f68701f.isShowing() || this.f68712e.getPageContext() == null) {
                    return;
                }
                this.f68712e.f68701f.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.c.a.f fVar, d.a.s0.v3.h.a aVar, View view, g gVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, view, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.p = new f(this);
        this.f68699d = aVar;
        this.f68696a = view;
        this.o = gVar;
        this.f68700e = view.getResources();
        this.f68702g = new d.a.s0.v3.h.h.c(this.mContext, this);
        this.f68703h = new d.a.s0.v3.h.h.e(this.mContext, this, this.o);
        this.f68704i = new d.a.s0.v3.h.h.d(this.mContext, this);
        this.f68702g.n(this.f68696a);
        this.f68703h.w(this.f68696a);
        this.f68704i.i(this.f68696a);
        A();
        g0();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f68697b = (NavigationBar) this.f68696a.findViewById(R.id.navigation_bar);
            MaskVideoView maskVideoView = (MaskVideoView) this.f68696a.findViewById(R.id.video_view);
            this.f68698c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.f68698c.setZOrderMediaOverlay(true);
            this.f68698c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.f68696a.findViewById(R.id.edit_container);
            this.j = frameLayout;
            frameLayout.addView(this.f68702g.k());
            this.k = (FragmentTabWidget) this.f68696a.findViewById(R.id.tab_widget);
            y();
            z();
            this.j.addView(this.f68703h.v());
            this.j.addView(this.f68704i.h());
            this.f68703h.v().setVisibility(8);
            this.f68704i.h().setVisibility(8);
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Build.VERSION.SDK_INT >= 18 : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void G() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (maskVideoView = this.f68698c) == null) {
            return;
        }
        maskVideoView.n(this.f68702g.getCurrentPosition());
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.l == 0) {
                N();
                R();
                return;
            }
            Q();
        }
    }

    public void I(d.a.c.a.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, fVar, i2) == null) {
            this.f68697b.onChangeSkinType(fVar, i2);
            this.k.h(i2);
            this.k.setDiverColor(SkinManager.getColor(i2, R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.f68696a, R.color.CAM_X0201);
            d.a.s0.v3.h.h.c cVar = this.f68702g;
            if (cVar != null) {
                cVar.p(fVar, i2);
            }
            d.a.s0.v3.h.h.e eVar = this.f68703h;
            if (eVar != null) {
                eVar.y(fVar, i2);
            }
        }
    }

    public void J(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.f68703h.z(str, str2);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            N();
            this.f68702g.q();
            this.f68703h.A();
            this.f68704i.l();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f68698c.onResume();
            if (this.l != 0) {
                this.f68698c.s();
            }
            this.f68702g.r();
            this.f68703h.B();
            this.f68704i.m();
        }
    }

    public void N() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (maskVideoView = this.f68698c) == null) {
            return;
        }
        maskVideoView.q();
    }

    public void O() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (maskVideoView = this.f68698c) == null) {
            return;
        }
        maskVideoView.onPause();
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.s0.v3.h.h.c cVar = this.f68702g;
            if (cVar != null) {
                cVar.t();
            }
            MaskVideoView maskVideoView = this.f68698c;
            if (maskVideoView != null) {
                maskVideoView.t();
            }
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            N();
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                if (this.n) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
            this.f68698c.start();
            this.f68698c.seekTo(0);
        }
    }

    public void R() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (maskVideoView = this.f68698c) == null) {
            return;
        }
        maskVideoView.seekTo(this.f68702g.getCurrentPosition());
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f68702g.v(str);
            this.f68698c.setVideoPath(str);
            this.f68698c.setOnPreparedListener(new b(this));
            this.f68698c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void T(d.a.s0.v3.h.d.a aVar) {
        d.a.s0.v3.h.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || (dVar = this.f68704i) == null) {
            return;
        }
        dVar.p(aVar);
    }

    public void U(MaskVideoView.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) || fVar == null || x() == null) {
            return;
        }
        x().setGenMaskCoverListener(fVar);
    }

    public void X(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.f68703h.N(list);
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.n = z;
            if (this.m == null) {
                return;
            }
            Q();
        }
    }

    public void Z(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.f68702g.w(list);
        }
    }

    public void a0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, intent) == null) {
            this.f68703h.P(intent);
        }
    }

    public void b0(String str, String str2) {
        d.a.s0.v3.h.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || (eVar = this.f68703h) == null) {
            return;
        }
        eVar.Q(str, str2);
    }

    public void c0(d.a.s0.v3.h.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            MaskVideoView maskVideoView = this.f68698c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(aVar);
            }
            d.a.s0.v3.h.h.d dVar = this.f68704i;
            if (dVar != null) {
                dVar.o(aVar);
            }
        }
    }

    public void d0(boolean z) {
        d.a.s0.v3.h.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (eVar = this.f68703h) == null) {
            return;
        }
        eVar.O(z);
        Y(!z);
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.f68699d.finishPage();
                return;
            }
            if (this.f68701f == null) {
                String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
                j jVar = new j(getPageContext());
                this.f68701f = jVar;
                jVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
                this.f68701f.i(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
            }
            this.f68701f.l();
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c12424");
            statisticItem.param("obj_locate", this.l == 0 ? 1 : 3);
            TiebaStatic.log(statisticItem);
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            MaskVideoView maskVideoView = this.f68698c;
            if (maskVideoView == null) {
                return 0;
            }
            return maskVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public Bitmap q(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, bitmap)) == null) ? this.f68702g.h(bitmap) : (Bitmap) invokeL.objValue;
    }

    public void r() {
        d.a.s0.v3.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (aVar = this.f68699d) == null) {
            return;
        }
        aVar.clearFinalVideoPath();
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f68703h.t() : (String) invokeV.objValue;
    }

    public d.a.s0.v3.h.e.a t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (this.f68704i == null || k.isEmpty(str)) {
                return null;
            }
            return this.f68704i.g(str);
        }
        return (d.a.s0.v3.h.e.a) invokeL.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f68703h.u() : (String) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f68696a : (View) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f68702g.l() : (String) invokeV.objValue;
    }

    public MaskVideoView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f68698c : (MaskVideoView) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f68697b.setCenterTextTitle(this.f68700e.getString(R.string.select_cover));
            this.f68697b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.f68697b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f68700e.getString(R.string.select_cover_next), new e(this)), R.color.CAM_X0106);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            String[] stringArray = this.f68700e.getStringArray(R.array.edit_video_tab);
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i2]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.f68700e.getDimension(R.dimen.fontsize34));
                this.k.addView(fragmentTabIndicator, i2);
            }
            if (!B() && this.k.getChildAt(1) != null) {
                this.k.getChildAt(1).setVisibility(8);
            }
            this.k.setDiverColor(this.f68700e.getColor(R.color.CAM_X0105));
            this.k.setCurrentTab(this.l, true, false);
            this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.k.setDviderRectWidth(d.a.c.e.p.l.g(this.mContext.getPageActivity(), R.dimen.ds64));
            this.k.setTabSelectionListener(new C1851a(this));
        }
    }
}
