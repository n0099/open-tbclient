package com.repackage;

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
import com.repackage.yr4;
import java.util.List;
/* loaded from: classes7.dex */
public class qs8 extends z8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public MaskVideoView c;
    public yr8 d;
    public Resources e;
    public wr4 f;
    public ss8 g;
    public us8 h;
    public ts8 i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public zl7 o;
    public yr4.e p;

    /* loaded from: classes7.dex */
    public class a implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs8 a;

        public a(qs8 qs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs8Var;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                qs8 qs8Var = this.a;
                if (i == qs8Var.l) {
                    return;
                }
                if (i == 0) {
                    qs8Var.g.l().setVisibility(0);
                    this.a.h.x().setVisibility(8);
                    this.a.i.j().setVisibility(8);
                    this.a.g.u(true);
                    this.a.h.E(false);
                    this.a.i.o(false);
                } else if (i == 1) {
                    qs8Var.i.j().setVisibility(0);
                    this.a.h.x().setVisibility(8);
                    this.a.g.l().setVisibility(8);
                    this.a.g.u(false);
                    if (TextUtils.isEmpty(this.a.h.w())) {
                        this.a.h.E(false);
                    } else {
                        this.a.h.E(true);
                    }
                    this.a.i.o(true);
                } else if (i == 2) {
                    qs8Var.h.x().setVisibility(0);
                    this.a.g.l().setVisibility(8);
                    this.a.i.j().setVisibility(8);
                    this.a.g.u(false);
                    this.a.h.E(true);
                    this.a.i.o(false);
                }
                qs8 qs8Var2 = this.a;
                qs8Var2.l = i;
                qs8Var2.k.setCurrentTab(this.a.l, true, true);
                this.a.d0();
                this.a.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs8 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.g.w();
                }
            }
        }

        /* renamed from: com.repackage.qs8$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0497b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0497b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                    if (i == 3) {
                        qs8 qs8Var = this.a.a;
                        if (qs8Var.l == 0) {
                            qs8Var.c.pause();
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        }

        public b(qs8 qs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs8Var;
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
            this.a.m = mediaPlayer;
            if (!this.a.n) {
                qs8 qs8Var = this.a;
                if (qs8Var.l != 0) {
                    qs8Var.m.setVolume(1.0f, 1.0f);
                    ng.a().postDelayed(new a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.a.c.start();
                        mediaPlayer.setOnInfoListener(new C0497b(this));
                        return;
                    }
                    this.a.c.seekTo(this.a.g.getCurrentPosition());
                    return;
                }
            }
            this.a.m.setVolume(0.0f, 0.0f);
            ng.a().postDelayed(new a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs8 a;

        public c(qs8 qs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs8Var;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                qs8 qs8Var = this.a;
                if (qs8Var.l != 0) {
                    qs8Var.P();
                    this.a.h.K();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs8 a;

        public d(qs8 qs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs8 a;

        public e(qs8 qs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g.n();
                if (this.a.d != null) {
                    this.a.d.onNext();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs8 a;

        public f(qs8 qs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs8Var;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                if (i != 0) {
                    if (i == 1 && this.a.d != null) {
                        this.a.d.finishPage();
                    }
                } else if (this.a.d != null) {
                    this.a.d.onSave();
                }
                if (this.a.f == null || !this.a.f.isShowing() || this.a.getPageContext() == null) {
                    return;
                }
                this.a.f.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qs8(b9 b9Var, yr8 yr8Var, View view2, zl7 zl7Var) {
        super(b9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, yr8Var, view2, zl7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.p = new f(this);
        this.d = yr8Var;
        this.a = view2;
        this.o = zl7Var;
        this.e = view2.getResources();
        this.g = new ss8(this.mContext, this);
        this.h = new us8(this.mContext, this, this.o);
        this.i = new ts8(this.mContext, this);
        this.g.o(this.a);
        this.h.y(this.a);
        this.i.k(this.a);
        C();
        d0();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setCenterTextTitle(this.e.getString(R.string.obfuscated_res_0x7f0f10e0));
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.e.getString(R.string.obfuscated_res_0x7f0f10e1), new e(this)), (int) R.color.CAM_X0106);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String[] stringArray = this.e.getStringArray(R.array.obfuscated_res_0x7f030010);
            for (int i = 0; i < stringArray.length; i++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.e.getDimension(R.dimen.obfuscated_res_0x7f070332));
                this.k.addView(fragmentTabIndicator, i);
            }
            if (!D() && this.k.getChildAt(1) != null) {
                this.k.getChildAt(1).setVisibility(8);
            }
            this.k.setDiverColor(this.e.getColor(R.color.CAM_X0105));
            this.k.setCurrentTab(this.l, true, false);
            this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.k.setDviderRectWidth(mi.f(this.mContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070258));
            this.k.setTabSelectionListener(new a(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f091534);
            MaskVideoView maskVideoView = (MaskVideoView) this.a.findViewById(R.id.obfuscated_res_0x7f0923cd);
            this.c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.c.setZOrderMediaOverlay(true);
            this.c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09084b);
            this.j = frameLayout;
            frameLayout.addView(this.g.l());
            this.k = (FragmentTabWidget) this.a.findViewById(R.id.obfuscated_res_0x7f091e96);
            A();
            B();
            this.j.addView(this.h.x());
            this.j.addView(this.i.j());
            this.h.x().setVisibility(8);
            this.i.j().setVisibility(8);
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Build.VERSION.SDK_INT >= 18 : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void F() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (maskVideoView = this.c) == null) {
            return;
        }
        maskVideoView.v(this.g.getCurrentPosition());
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.l == 0) {
                M();
                Q();
                return;
            }
            P();
        }
    }

    public void H(b9 b9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, b9Var, i) == null) {
            this.b.onChangeSkinType(b9Var, i);
            this.k.h(i);
            this.k.setDiverColor(SkinManager.getColor(i, (int) R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            ss8 ss8Var = this.g;
            if (ss8Var != null) {
                ss8Var.r(b9Var, i);
            }
            us8 us8Var = this.h;
            if (us8Var != null) {
                us8Var.A(b9Var, i);
            }
        }
    }

    public void I(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.h.B(str, str2);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            M();
            this.g.s();
            this.h.C();
            this.i.m();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.onResume();
            if (this.l != 0) {
                this.c.A();
            }
            this.g.t();
            this.h.D();
            this.i.n();
        }
    }

    public void M() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (maskVideoView = this.c) == null) {
            return;
        }
        maskVideoView.y();
    }

    public void N() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (maskVideoView = this.c) == null) {
            return;
        }
        maskVideoView.onPause();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ss8 ss8Var = this.g;
            if (ss8Var != null) {
                ss8Var.v();
            }
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.stopPlayback();
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            M();
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                if (this.n) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
            this.c.start();
            this.c.seekTo(0);
        }
    }

    public void Q() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (maskVideoView = this.c) == null) {
            return;
        }
        maskVideoView.seekTo(this.g.getCurrentPosition());
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.g.x(str);
            this.c.setVideoPath(str);
            this.c.setOnPreparedListener(new b(this));
            this.c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void T(ds8 ds8Var) {
        ts8 ts8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, ds8Var) == null) || (ts8Var = this.i) == null) {
            return;
        }
        ts8Var.r(ds8Var);
    }

    public void U(MaskVideoView.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) || fVar == null || z() == null) {
            return;
        }
        z().setGenMaskCoverListener(fVar);
    }

    public void V(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.h.M(list);
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.n = z;
            if (this.m == null) {
                return;
            }
            P();
        }
    }

    public void X(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            this.g.y(list);
        }
    }

    public void Y(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, intent) == null) {
            this.h.O(intent);
        }
    }

    public void Z(String str, String str2) {
        us8 us8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) || (us8Var = this.h) == null) {
            return;
        }
        us8Var.P(str, str2);
    }

    public void a0(ls8 ls8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ls8Var) == null) {
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(ls8Var);
            }
            ts8 ts8Var = this.i;
            if (ts8Var != null) {
                ts8Var.q(ls8Var);
            }
        }
    }

    public void b0(boolean z) {
        us8 us8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (us8Var = this.h) == null) {
            return;
        }
        us8Var.N(z);
        W(!z);
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.d.finishPage();
                return;
            }
            if (this.f == null) {
                String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f107c), getPageContext().getString(R.string.obfuscated_res_0x7f0f0c95)};
                wr4 wr4Var = new wr4(getPageContext());
                this.f = wr4Var;
                wr4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1088));
                this.f.j(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1088), strArr, this.p);
            }
            this.f.m();
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c12424");
            statisticItem.param("obj_locate", this.l == 0 ? 1 : 3);
            TiebaStatic.log(statisticItem);
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView == null) {
                return 0;
            }
            return maskVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public Bitmap s(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, bitmap)) == null) ? this.g.j(bitmap) : (Bitmap) invokeL.objValue;
    }

    public void t() {
        yr8 yr8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (yr8Var = this.d) == null) {
            return;
        }
        yr8Var.clearFinalVideoPath();
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.h.v() : (String) invokeV.objValue;
    }

    public ls8 v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            if (this.i == null || li.isEmpty(str)) {
                return null;
            }
            return this.i.i(str);
        }
        return (ls8) invokeL.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.h.w() : (String) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.g.m() : (String) invokeV.objValue;
    }

    public MaskVideoView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.c : (MaskVideoView) invokeV.objValue;
    }
}
