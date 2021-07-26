package d.a.q0.v3.i.h;

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
import d.a.d.e.p.k;
import d.a.p0.s.s.j;
import d.a.p0.s.s.l;
import d.a.q0.x1.g;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends d.a.d.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f66137a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f66138b;

    /* renamed from: c  reason: collision with root package name */
    public MaskVideoView f66139c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.v3.i.a f66140d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f66141e;

    /* renamed from: f  reason: collision with root package name */
    public j f66142f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.v3.i.h.c f66143g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.v3.i.h.e f66144h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.v3.i.h.d f66145i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public g o;
    public l.e p;

    /* renamed from: d.a.q0.v3.i.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1812a implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66146e;

        public C1812a(a aVar) {
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
            this.f66146e = aVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                a aVar = this.f66146e;
                if (i2 == aVar.l) {
                    return;
                }
                if (i2 == 0) {
                    aVar.f66143g.k().setVisibility(0);
                    this.f66146e.f66144h.v().setVisibility(8);
                    this.f66146e.f66145i.h().setVisibility(8);
                    this.f66146e.f66143g.s(true);
                    this.f66146e.f66144h.F(false);
                    this.f66146e.f66145i.n(false);
                } else if (i2 == 1) {
                    aVar.f66145i.h().setVisibility(0);
                    this.f66146e.f66144h.v().setVisibility(8);
                    this.f66146e.f66143g.k().setVisibility(8);
                    this.f66146e.f66143g.s(false);
                    if (TextUtils.isEmpty(this.f66146e.f66144h.u())) {
                        this.f66146e.f66144h.F(false);
                    } else {
                        this.f66146e.f66144h.F(true);
                    }
                    this.f66146e.f66145i.n(true);
                } else if (i2 == 2) {
                    aVar.f66144h.v().setVisibility(0);
                    this.f66146e.f66143g.k().setVisibility(8);
                    this.f66146e.f66145i.h().setVisibility(8);
                    this.f66146e.f66143g.s(false);
                    this.f66146e.f66144h.F(true);
                    this.f66146e.f66145i.n(false);
                }
                a aVar2 = this.f66146e;
                aVar2.l = i2;
                aVar2.k.setCurrentTab(this.f66146e.l, true, true);
                this.f66146e.f0();
                this.f66146e.H();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66147e;

        /* renamed from: d.a.q0.v3.i.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1813a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f66148e;

            public RunnableC1813a(b bVar) {
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
                this.f66148e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f66148e.f66147e.f66143g.u();
                }
            }
        }

        /* renamed from: d.a.q0.v3.i.h.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1814b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f66149e;

            public C1814b(b bVar) {
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
                this.f66149e = bVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        a aVar = this.f66149e.f66147e;
                        if (aVar.l == 0) {
                            aVar.f66139c.pause();
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
            this.f66147e = aVar;
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
            this.f66147e.m = mediaPlayer;
            if (!this.f66147e.n) {
                a aVar = this.f66147e;
                if (aVar.l != 0) {
                    aVar.m.setVolume(1.0f, 1.0f);
                    d.a.d.e.m.e.a().postDelayed(new RunnableC1813a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.f66147e.f66139c.start();
                        mediaPlayer.setOnInfoListener(new C1814b(this));
                        return;
                    }
                    this.f66147e.f66139c.seekTo(this.f66147e.f66143g.getCurrentPosition());
                    return;
                }
            }
            this.f66147e.m.setVolume(0.0f, 0.0f);
            d.a.d.e.m.e.a().postDelayed(new RunnableC1813a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66150e;

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
            this.f66150e = aVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                a aVar = this.f66150e;
                if (aVar.l != 0) {
                    aVar.Q();
                    this.f66150e.f66144h.K();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66151e;

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
            this.f66151e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f66151e.e0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66152e;

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
            this.f66152e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f66152e.f66143g.m();
                if (this.f66152e.f66140d != null) {
                    this.f66152e.f66140d.onNext();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66153e;

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
            this.f66153e = aVar;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (i2 != 0) {
                    if (i2 == 1 && this.f66153e.f66140d != null) {
                        this.f66153e.f66140d.finishPage();
                    }
                } else if (this.f66153e.f66140d != null) {
                    this.f66153e.f66140d.onSave();
                }
                if (this.f66153e.f66142f == null || !this.f66153e.f66142f.isShowing() || this.f66153e.getPageContext() == null) {
                    return;
                }
                this.f66153e.f66142f.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.d.a.f fVar, d.a.q0.v3.i.a aVar, View view, g gVar) {
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
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.p = new f(this);
        this.f66140d = aVar;
        this.f66137a = view;
        this.o = gVar;
        this.f66141e = view.getResources();
        this.f66143g = new d.a.q0.v3.i.h.c(this.mContext, this);
        this.f66144h = new d.a.q0.v3.i.h.e(this.mContext, this, this.o);
        this.f66145i = new d.a.q0.v3.i.h.d(this.mContext, this);
        this.f66143g.n(this.f66137a);
        this.f66144h.w(this.f66137a);
        this.f66145i.j(this.f66137a);
        A();
        f0();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66138b = (NavigationBar) this.f66137a.findViewById(R.id.navigation_bar);
            MaskVideoView maskVideoView = (MaskVideoView) this.f66137a.findViewById(R.id.video_view);
            this.f66139c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.f66139c.setZOrderMediaOverlay(true);
            this.f66139c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.f66137a.findViewById(R.id.edit_container);
            this.j = frameLayout;
            frameLayout.addView(this.f66143g.k());
            this.k = (FragmentTabWidget) this.f66137a.findViewById(R.id.tab_widget);
            y();
            z();
            this.j.addView(this.f66144h.v());
            this.j.addView(this.f66145i.h());
            this.f66144h.v().setVisibility(8);
            this.f66145i.h().setVisibility(8);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (maskVideoView = this.f66139c) == null) {
            return;
        }
        maskVideoView.n(this.f66143g.getCurrentPosition());
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.l == 0) {
                M();
                R();
                return;
            }
            Q();
        }
    }

    public void I(d.a.d.a.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, fVar, i2) == null) {
            this.f66138b.onChangeSkinType(fVar, i2);
            this.k.h(i2);
            this.k.setDiverColor(SkinManager.getColor(i2, R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.f66137a, R.color.CAM_X0201);
            d.a.q0.v3.i.h.c cVar = this.f66143g;
            if (cVar != null) {
                cVar.p(fVar, i2);
            }
            d.a.q0.v3.i.h.e eVar = this.f66144h;
            if (eVar != null) {
                eVar.y(fVar, i2);
            }
        }
    }

    public void J(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.f66144h.z(str, str2);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            M();
            this.f66143g.q();
            this.f66144h.A();
            this.f66145i.l();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f66139c.onResume();
            if (this.l != 0) {
                this.f66139c.s();
            }
            this.f66143g.r();
            this.f66144h.B();
            this.f66145i.m();
        }
    }

    public void M() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (maskVideoView = this.f66139c) == null) {
            return;
        }
        maskVideoView.q();
    }

    public void O() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (maskVideoView = this.f66139c) == null) {
            return;
        }
        maskVideoView.onPause();
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.q0.v3.i.h.c cVar = this.f66143g;
            if (cVar != null) {
                cVar.t();
            }
            MaskVideoView maskVideoView = this.f66139c;
            if (maskVideoView != null) {
                maskVideoView.t();
            }
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            M();
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                if (this.n) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
            this.f66139c.start();
            this.f66139c.seekTo(0);
        }
    }

    public void R() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (maskVideoView = this.f66139c) == null) {
            return;
        }
        maskVideoView.seekTo(this.f66143g.getCurrentPosition());
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f66143g.v(str);
            this.f66139c.setVideoPath(str);
            this.f66139c.setOnPreparedListener(new b(this));
            this.f66139c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void T(d.a.q0.v3.i.d.a aVar) {
        d.a.q0.v3.i.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || (dVar = this.f66145i) == null) {
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

    public void V(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.f66144h.M(list);
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
            this.f66143g.w(list);
        }
    }

    public void a0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, intent) == null) {
            this.f66144h.P(intent);
        }
    }

    public void b0(String str, String str2) {
        d.a.q0.v3.i.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || (eVar = this.f66144h) == null) {
            return;
        }
        eVar.Q(str, str2);
    }

    public void c0(d.a.q0.v3.i.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            MaskVideoView maskVideoView = this.f66139c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(aVar);
            }
            d.a.q0.v3.i.h.d dVar = this.f66145i;
            if (dVar != null) {
                dVar.o(aVar);
            }
        }
    }

    public void d0(boolean z) {
        d.a.q0.v3.i.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (eVar = this.f66144h) == null) {
            return;
        }
        eVar.O(z);
        Y(!z);
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.f66140d.finishPage();
                return;
            }
            if (this.f66142f == null) {
                String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
                j jVar = new j(getPageContext());
                this.f66142f = jVar;
                jVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
                this.f66142f.i(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
            }
            this.f66142f.l();
        }
    }

    public final void f0() {
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
            MaskVideoView maskVideoView = this.f66139c;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, bitmap)) == null) ? this.f66143g.h(bitmap) : (Bitmap) invokeL.objValue;
    }

    public void r() {
        d.a.q0.v3.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (aVar = this.f66140d) == null) {
            return;
        }
        aVar.clearFinalVideoPath();
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f66144h.t() : (String) invokeV.objValue;
    }

    public d.a.q0.v3.i.e.a t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (this.f66145i == null || k.isEmpty(str)) {
                return null;
            }
            return this.f66145i.g(str);
        }
        return (d.a.q0.v3.i.e.a) invokeL.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f66144h.u() : (String) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f66137a : (View) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f66143g.l() : (String) invokeV.objValue;
    }

    public MaskVideoView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f66139c : (MaskVideoView) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f66138b.setCenterTextTitle(this.f66141e.getString(R.string.select_cover));
            this.f66138b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.f66138b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f66141e.getString(R.string.select_cover_next), new e(this)), R.color.CAM_X0106);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            String[] stringArray = this.f66141e.getStringArray(R.array.edit_video_tab);
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i2]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.f66141e.getDimension(R.dimen.fontsize34));
                this.k.addView(fragmentTabIndicator, i2);
            }
            if (!B() && this.k.getChildAt(1) != null) {
                this.k.getChildAt(1).setVisibility(8);
            }
            this.k.setDiverColor(this.f66141e.getColor(R.color.CAM_X0105));
            this.k.setCurrentTab(this.l, true, false);
            this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.k.setDviderRectWidth(d.a.d.e.p.l.g(this.mContext.getPageActivity(), R.dimen.ds64));
            this.k.setTabSelectionListener(new C1812a(this));
        }
    }
}
