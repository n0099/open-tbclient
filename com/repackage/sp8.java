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
import com.repackage.oq4;
import java.util.List;
/* loaded from: classes7.dex */
public class sp8 extends z8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public MaskVideoView c;
    public ap8 d;
    public Resources e;
    public mq4 f;
    public up8 g;
    public wp8 h;
    public vp8 i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public hj7 o;
    public oq4.e p;

    /* loaded from: classes7.dex */
    public class a implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp8 a;

        public a(sp8 sp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp8Var;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                sp8 sp8Var = this.a;
                if (i == sp8Var.l) {
                    return;
                }
                if (i == 0) {
                    sp8Var.g.k().setVisibility(0);
                    this.a.h.w().setVisibility(8);
                    this.a.i.i().setVisibility(8);
                    this.a.g.t(true);
                    this.a.h.D(false);
                    this.a.i.n(false);
                } else if (i == 1) {
                    sp8Var.i.i().setVisibility(0);
                    this.a.h.w().setVisibility(8);
                    this.a.g.k().setVisibility(8);
                    this.a.g.t(false);
                    if (TextUtils.isEmpty(this.a.h.v())) {
                        this.a.h.D(false);
                    } else {
                        this.a.h.D(true);
                    }
                    this.a.i.n(true);
                } else if (i == 2) {
                    sp8Var.h.w().setVisibility(0);
                    this.a.g.k().setVisibility(8);
                    this.a.i.i().setVisibility(8);
                    this.a.g.t(false);
                    this.a.h.D(true);
                    this.a.i.n(false);
                }
                sp8 sp8Var2 = this.a;
                sp8Var2.l = i;
                sp8Var2.k.setCurrentTab(this.a.l, true, true);
                this.a.c0();
                this.a.F();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp8 a;

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
                    this.a.a.g.v();
                }
            }
        }

        /* renamed from: com.repackage.sp8$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0519b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0519b(b bVar) {
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
                        sp8 sp8Var = this.a.a;
                        if (sp8Var.l == 0) {
                            sp8Var.c.pause();
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        }

        public b(sp8 sp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp8Var;
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
                sp8 sp8Var = this.a;
                if (sp8Var.l != 0) {
                    sp8Var.m.setVolume(1.0f, 1.0f);
                    mg.a().postDelayed(new a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.a.c.start();
                        mediaPlayer.setOnInfoListener(new C0519b(this));
                        return;
                    }
                    this.a.c.seekTo(this.a.g.getCurrentPosition());
                    return;
                }
            }
            this.a.m.setVolume(0.0f, 0.0f);
            mg.a().postDelayed(new a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp8 a;

        public c(sp8 sp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp8Var;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                sp8 sp8Var = this.a;
                if (sp8Var.l != 0) {
                    sp8Var.O();
                    this.a.h.I();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp8 a;

        public d(sp8 sp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp8 a;

        public e(sp8 sp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g.m();
                if (this.a.d != null) {
                    this.a.d.onNext();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp8 a;

        public f(sp8 sp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp8Var;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
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
    public sp8(b9 b9Var, ap8 ap8Var, View view2, hj7 hj7Var) {
        super(b9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, ap8Var, view2, hj7Var};
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
        this.d = ap8Var;
        this.a = view2;
        this.o = hj7Var;
        this.e = view2.getResources();
        this.g = new up8(this.mContext, this);
        this.h = new wp8(this.mContext, this, this.o);
        this.i = new vp8(this.mContext, this);
        this.g.n(this.a);
        this.h.x(this.a);
        this.i.j(this.a);
        B();
        c0();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String[] stringArray = this.e.getStringArray(R.array.obfuscated_res_0x7f030010);
            for (int i = 0; i < stringArray.length; i++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.e.getDimension(R.dimen.obfuscated_res_0x7f070332));
                this.k.addView(fragmentTabIndicator, i);
            }
            if (!C() && this.k.getChildAt(1) != null) {
                this.k.getChildAt(1).setVisibility(8);
            }
            this.k.setDiverColor(this.e.getColor(R.color.CAM_X0105));
            this.k.setCurrentTab(this.l, true, false);
            this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.k.setDviderRectWidth(li.f(this.mContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070258));
            this.k.setTabSelectionListener(new a(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0914f2);
            MaskVideoView maskVideoView = (MaskVideoView) this.a.findViewById(R.id.obfuscated_res_0x7f092372);
            this.c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.c.setZOrderMediaOverlay(true);
            this.c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09082f);
            this.j = frameLayout;
            frameLayout.addView(this.g.k());
            this.k = (FragmentTabWidget) this.a.findViewById(R.id.obfuscated_res_0x7f091e3c);
            z();
            A();
            this.j.addView(this.h.w());
            this.j.addView(this.i.i());
            this.h.w().setVisibility(8);
            this.i.i().setVisibility(8);
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Build.VERSION.SDK_INT >= 18 : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void E() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (maskVideoView = this.c) == null) {
            return;
        }
        maskVideoView.v(this.g.getCurrentPosition());
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.l == 0) {
                L();
                P();
                return;
            }
            O();
        }
    }

    public void G(b9 b9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, b9Var, i) == null) {
            this.b.onChangeSkinType(b9Var, i);
            this.k.h(i);
            this.k.setDiverColor(SkinManager.getColor(i, (int) R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            up8 up8Var = this.g;
            if (up8Var != null) {
                up8Var.q(b9Var, i);
            }
            wp8 wp8Var = this.h;
            if (wp8Var != null) {
                wp8Var.z(b9Var, i);
            }
        }
    }

    public void H(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.h.A(str, str2);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            L();
            this.g.r();
            this.h.B();
            this.i.l();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c.onResume();
            if (this.l != 0) {
                this.c.A();
            }
            this.g.s();
            this.h.C();
            this.i.m();
        }
    }

    public void L() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (maskVideoView = this.c) == null) {
            return;
        }
        maskVideoView.y();
    }

    public void M() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (maskVideoView = this.c) == null) {
            return;
        }
        maskVideoView.onPause();
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            up8 up8Var = this.g;
            if (up8Var != null) {
                up8Var.u();
            }
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.stopPlayback();
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            L();
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

    public void P() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (maskVideoView = this.c) == null) {
            return;
        }
        maskVideoView.seekTo(this.g.getCurrentPosition());
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.g.w(str);
            this.c.setVideoPath(str);
            this.c.setOnPreparedListener(new b(this));
            this.c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void R(fp8 fp8Var) {
        vp8 vp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, fp8Var) == null) || (vp8Var = this.i) == null) {
            return;
        }
        vp8Var.q(fp8Var);
    }

    public void T(MaskVideoView.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) || fVar == null || y() == null) {
            return;
        }
        y().setGenMaskCoverListener(fVar);
    }

    public void U(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.h.L(list);
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.n = z;
            if (this.m == null) {
                return;
            }
            O();
        }
    }

    public void W(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            this.g.x(list);
        }
    }

    public void X(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, intent) == null) {
            this.h.N(intent);
        }
    }

    public void Y(String str, String str2) {
        wp8 wp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) || (wp8Var = this.h) == null) {
            return;
        }
        wp8Var.O(str, str2);
    }

    public void Z(np8 np8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, np8Var) == null) {
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(np8Var);
            }
            vp8 vp8Var = this.i;
            if (vp8Var != null) {
                vp8Var.o(np8Var);
            }
        }
    }

    public void a0(boolean z) {
        wp8 wp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (wp8Var = this.h) == null) {
            return;
        }
        wp8Var.M(z);
        V(!z);
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.d.finishPage();
                return;
            }
            if (this.f == null) {
                String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f108c), getPageContext().getString(R.string.obfuscated_res_0x7f0f0c9d)};
                mq4 mq4Var = new mq4(getPageContext());
                this.f = mq4Var;
                mq4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1098));
                this.f.j(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1098), strArr, this.p);
            }
            this.f.m();
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c12424");
            statisticItem.param("obj_locate", this.l == 0 ? 1 : 3);
            TiebaStatic.log(statisticItem);
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView == null) {
                return 0;
            }
            return maskVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public Bitmap r(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, bitmap)) == null) ? this.g.i(bitmap) : (Bitmap) invokeL.objValue;
    }

    public void s() {
        ap8 ap8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (ap8Var = this.d) == null) {
            return;
        }
        ap8Var.clearFinalVideoPath();
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.h.u() : (String) invokeV.objValue;
    }

    public np8 u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            if (this.i == null || ki.isEmpty(str)) {
                return null;
            }
            return this.i.h(str);
        }
        return (np8) invokeL.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.h.v() : (String) invokeV.objValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.g.l() : (String) invokeV.objValue;
    }

    public MaskVideoView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.c : (MaskVideoView) invokeV.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.b.setCenterTextTitle(this.e.getString(R.string.obfuscated_res_0x7f0f10f0));
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.e.getString(R.string.obfuscated_res_0x7f0f10f1), new e(this)), (int) R.color.CAM_X0106);
        }
    }
}
