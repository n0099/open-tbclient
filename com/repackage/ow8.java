package com.repackage;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.videoplay.videoview.VideoMediaController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nv8;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes6.dex */
public class ow8 extends u78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int M0;
    public int N0;
    public String O0;
    public String P0;
    public TbPageContext<BaseFragmentActivity> Q0;
    public BdUniqueId R0;
    public VideoItemData S0;
    public int T0;
    public View U0;
    public View V0;
    public boolean W0;
    public boolean X0;
    public ObjectAnimator Y0;
    public ObjectAnimator Z0;
    public bs7 a1;
    public VideoDanmuController b1;
    public nv8 c1;
    public d d1;
    public Runnable e1;
    public Runnable f1;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow8 a;

        public a(ow8 ow8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow8 a;

        public b(ow8 ow8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.X0 && (this.a.O instanceof Activity)) {
                this.a.F0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements nv8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow8 a;

        public c(ow8 ow8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow8Var;
        }

        @Override // com.repackage.nv8.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.b1 == null || this.a.c1 == null) {
                return;
            }
            if (z) {
                this.a.b1.Z();
                if (this.a.t.getControl().isPlaying()) {
                    this.a.b1.U();
                } else {
                    this.a.b1.R();
                }
            } else {
                this.a.b1.R();
                this.a.b1.H();
            }
            this.a.c1.j(z);
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ow8(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, View view2, int i) {
        super(tbPageContext.getPageActivity(), view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, view2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.N0 = 0;
        this.e1 = new a(this);
        this.f1 = new b(this);
        this.Q0 = tbPageContext;
        this.R0 = bdUniqueId;
        this.R = bdUniqueId;
        this.T0 = i;
        P();
        this.W0 = TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) || TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity());
        X(true);
        Y(true);
        this.i0 = false;
    }

    public bs7 E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                return videoDanmuController.F();
            }
            return null;
        }
        return (bs7) invokeV.objValue;
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            K0();
            UtilHelper.hideStatusBar((Activity) this.O, this.U0);
            this.X0 = false;
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            X(false);
            Y(false);
            this.d1 = null;
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            nv8 nv8Var = this.c1;
            if (nv8Var != null) {
                nv8Var.f();
            }
        }
    }

    public void H0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoItemData) == null) || videoItemData == null) {
            return;
        }
        this.S0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void I0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.d1 = dVar;
        }
    }

    public void J0(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bs7Var) == null) {
            this.a1 = bs7Var;
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.Z0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.V0, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.Z0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.Z0.start();
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.Y0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.V0, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.Y0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.Y0.start();
        }
    }

    @Override // com.repackage.u78
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i = this.b & (-33);
            this.b = i;
            int i2 = this.o & (-33);
            this.o = i2;
            int i3 = this.d & (-33);
            this.d = i3;
            int i4 = this.e & (-33);
            this.e = i4;
            int i5 = this.n & (-33);
            this.n = i5;
            int i6 = this.f & (-33);
            this.f = i6;
            int i7 = this.g & (-33);
            this.g = i7;
            int i8 = this.h & (-33);
            this.h = i8;
            int i9 = this.i & (-33);
            this.i = i9;
            int i10 = this.j & (-33);
            this.j = i10;
            int i11 = this.k & (-33);
            this.k = i11;
            this.b = i | 1024;
            this.o = i2 | 1024;
            int i12 = i3 | 1024;
            this.d = i12;
            this.e = i4 & (-1025);
            this.n = i5 & (-1025);
            this.f = i6 | 1024;
            this.g = i7 | 1024;
            int i13 = i8 | 1024;
            this.h = i13;
            int i14 = i9 | 1024;
            this.i = i14;
            this.j = i10 | 1024;
            this.k = i11 & (-1025);
            this.d = i12 | 16384;
            this.h = i13 | 16384;
            this.i = i14 & (-2);
        }
    }

    @Override // com.repackage.u78
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.G.a(this.T, this.Y);
            this.H.e(this.T, this.Y);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).q(this.T, this.Y);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            int i = 0;
            int f = (this.Y && this.T) ? oi.f(this.O, R.dimen.tbds42) : 0;
            if (this.Y && !this.T) {
                i = oi.f(this.O, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = f;
            layoutParams.rightMargin = i;
        }
    }

    @Override // com.repackage.u78
    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            Context context = this.O;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.Y);
            }
            super.V(z);
            if (this.Y) {
                this.Q.setVisibility(0);
                q0();
            } else {
                this.Q.setVisibility(8);
                this.Q.removeView(this.t);
            }
            d dVar = this.d1;
            if (dVar != null) {
                dVar.a(this.Y);
            }
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                if (this.Y) {
                    videoDanmuController.b0(this.a1);
                } else {
                    videoDanmuController.c0();
                }
            }
        }
    }

    @Override // com.repackage.u78
    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.obfuscated_res_0x7f0d0647 : invokeV.intValue;
    }

    @Override // com.repackage.u78
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.d0();
            this.u.t();
            this.u.setDrawCorner(false);
            this.M0 = oi.k(this.O) / 10;
            this.H.setShareFrom(18);
        }
    }

    @Override // com.repackage.u78
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.repackage.u78
    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) ? this.Y || motionEvent.getX() > ((float) this.M0) : invokeL.booleanValue;
    }

    @Override // com.repackage.u78
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.u78
    public void o0(int i) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            int i2 = this.p;
            int i3 = this.k;
            if (i2 != i3 && i == i3) {
                pg.a().removeCallbacks(this.e1);
                int i4 = this.p;
                if ((i4 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i4 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.o0(i);
            if (!this.Y) {
                this.I.setVisibility(8);
                this.J.setVisibility(8);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                int i5 = i & 16384;
                operableVideoMediaControllerView.setVisibility((i5 > 0 || (i & 128) > 0) ? 0 : 8);
                ((VideoMediaController) this.F).setBottomBarShow(i5 > 0);
            }
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest() && (findViewById = this.Q.findViewById(R.id.obfuscated_res_0x7f092303)) != null) {
                findViewById.setVisibility((i & 64) > 0 ? 0 : 8);
            }
            if (!this.Y && !this.W0 && (this.O instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.X0) {
                        L0();
                        UtilHelper.showStatusBar((Activity) this.O, this.U0);
                        this.X0 = true;
                        pg.a().removeCallbacks(this.f1);
                        pg.a().postDelayed(this.f1, 3000L);
                    }
                } else if (this.X0) {
                    F0();
                }
            }
            VideoDanmuController videoDanmuController = this.b1;
            if (videoDanmuController != null) {
                if (i != this.d && i != this.f) {
                    videoDanmuController.R();
                } else {
                    this.b1.U();
                }
            }
        }
    }

    @Override // com.repackage.u78, android.view.View.OnClickListener
    public void onClick(View view2) {
        nv8 nv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view2) == null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f09184f) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == R.id.obfuscated_res_0x7f092303 && (nv8Var = this.c1) != null) {
            nv8Var.i();
            VideoItemData videoItemData = this.S0;
            if (videoItemData != null) {
                this.c1.e(videoItemData.thread_id, this.T0);
            }
        }
        super.onClick(view2);
    }

    @Override // com.repackage.u78, com.repackage.r78
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, true, 10);
            pg.a().removeCallbacks(this.e1);
            pg.a().postDelayed(this.e1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.u78, com.repackage.r78
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) || threadData == null) {
            return;
        }
        m78 m78Var = new m78();
        m78Var.a = "6";
        m78Var.c = threadData.getTid();
        m78Var.d = Long.toString(threadData.getFid());
        m78Var.e = TbadkCoreApplication.getCurrentAccount();
        m78Var.x = this.S0.getChannelMidRequestNum();
        m78Var.y = this.S0.getChannelMidRequestVideoNum();
        Context context = this.O;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.N0 = intExtra;
                if (intExtra == 0) {
                    this.N0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.O0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    m78Var.k = this.O0;
                }
                m78Var.i = Integer.toString(this.N0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P0 = stringExtra2;
                m78Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            m78Var.m = threadData.getThreadVideoInfo().video_md5;
            m78Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(m78Var);
        if (this.Y && threadData.getThreadVideoInfo() != null) {
            if (this.T != (threadData.getThreadVideoInfo().is_vertical.intValue() == 1)) {
                U();
            }
        }
        super.setData(threadData);
        X(!this.T);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.U) && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.Q0, this.R0, this.Q, R.id.obfuscated_res_0x7f092304, this.S0, this.T0);
            this.b1 = videoDanmuController;
            videoDanmuController.W(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
        }
        View findViewById = this.Q.findViewById(R.id.obfuscated_res_0x7f09230a);
        View findViewById2 = this.Q.findViewById(R.id.obfuscated_res_0x7f092327);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            nv8 nv8Var = this.c1;
            if (nv8Var != null) {
                nv8Var.f();
                this.c1 = null;
            }
            nv8 nv8Var2 = new nv8(this.Q, R.id.obfuscated_res_0x7f092303);
            this.c1 = nv8Var2;
            nv8Var2.g(this);
            this.c1.h(new c(this));
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                findViewById.setPadding(0, findViewById.getPaddingTop(), 0, findViewById.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.width = UtilHelper.getDimenPixelSize(R.dimen.tbds68);
                layoutParams3.rightMargin = dimenPixelSize;
                ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = dimenPixelSize;
            }
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            findViewById.setPadding(dimenPixelSize, findViewById.getPaddingTop(), dimenPixelSize, findViewById.getPaddingBottom());
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams4.width = UtilHelper.getDimenPixelSize(R.dimen.tbds150);
            layoutParams4.rightMargin = 0;
            ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = 0;
        }
    }

    @Override // com.repackage.u78
    public void u0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    @Override // com.repackage.u78
    public void v0() {
        m78 m78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (m78Var = this.Z) == null) {
            return;
        }
        m78 b2 = m78Var.b();
        b2.a = "pb";
        b78.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
    }
}
