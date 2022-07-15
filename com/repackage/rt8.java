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
import com.repackage.qs8;
/* loaded from: classes7.dex */
public class rt8 extends a78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public int O0;
    public String P0;
    public String Q0;
    public TbPageContext<BaseFragmentActivity> R0;
    public BdUniqueId S0;
    public VideoItemData T0;
    public int U0;
    public View V0;
    public View W0;
    public boolean X0;
    public boolean Y0;
    public ObjectAnimator Z0;
    public ObjectAnimator a1;
    public jr7 b1;
    public VideoDanmuController c1;
    public qs8 d1;
    public d e1;
    public Runnable f1;
    public Runnable g1;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt8 a;

        public a(rt8 rt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rt8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt8 a;

        public b(rt8 rt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rt8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.Y0 && (this.a.O instanceof Activity)) {
                this.a.E0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements qs8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt8 a;

        public c(rt8 rt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rt8Var;
        }

        @Override // com.repackage.qs8.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.c1 == null || this.a.d1 == null) {
                return;
            }
            if (z) {
                this.a.c1.Z();
                if (this.a.t.getControl().isPlaying()) {
                    this.a.c1.U();
                } else {
                    this.a.c1.R();
                }
            } else {
                this.a.c1.R();
                this.a.c1.H();
            }
            this.a.d1.j(z);
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt8(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, View view2, int i) {
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
        this.O0 = 0;
        this.f1 = new a(this);
        this.g1 = new b(this);
        this.R0 = tbPageContext;
        this.S0 = bdUniqueId;
        this.R = bdUniqueId;
        this.U0 = i;
        P();
        this.X0 = TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) || TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity());
        X(true);
        Y(true);
        this.i0 = false;
    }

    public jr7 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                return videoDanmuController.F();
            }
            return null;
        }
        return (jr7) invokeV.objValue;
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J0();
            UtilHelper.hideStatusBar((Activity) this.O, this.V0);
            this.Y0 = false;
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            X(false);
            Y(false);
            this.e1 = null;
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            qs8 qs8Var = this.d1;
            if (qs8Var != null) {
                qs8Var.f();
            }
        }
    }

    public void G0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoItemData) == null) || videoItemData == null) {
            return;
        }
        this.T0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void H0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.e1 = dVar;
        }
    }

    public void I0(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jr7Var) == null) {
            this.b1 = jr7Var;
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.a1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.W0, "alpha", 1.0f, 0.0f);
                this.a1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.a1.start();
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.Z0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.W0, "alpha", 0.0f, 1.0f);
                this.Z0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.Z0.start();
        }
    }

    @Override // com.repackage.a78
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

    @Override // com.repackage.a78
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
            int f = (this.Y && this.T) ? pi.f(this.O, R.dimen.tbds42) : 0;
            if (this.Y && !this.T) {
                i = pi.f(this.O, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = f;
            layoutParams.rightMargin = i;
        }
    }

    @Override // com.repackage.a78
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
            d dVar = this.e1;
            if (dVar != null) {
                dVar.a(this.Y);
            }
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                if (this.Y) {
                    videoDanmuController.b0(this.b1);
                } else {
                    videoDanmuController.c0();
                }
            }
        }
    }

    @Override // com.repackage.a78
    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.obfuscated_res_0x7f0d0649 : invokeV.intValue;
    }

    @Override // com.repackage.a78
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.d0();
            this.u.s();
            this.u.setDrawCorner(false);
            this.N0 = pi.k(this.O) / 10;
            this.H.setShareFrom(18);
        }
    }

    @Override // com.repackage.a78
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.repackage.a78
    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) ? this.Y || motionEvent.getX() > ((float) this.N0) : invokeL.booleanValue;
    }

    @Override // com.repackage.a78
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a78
    public void o0(int i) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            int i2 = this.p;
            int i3 = this.k;
            if (i2 != i3 && i == i3) {
                qg.a().removeCallbacks(this.f1);
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
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest() && (findViewById = this.Q.findViewById(R.id.obfuscated_res_0x7f092391)) != null) {
                findViewById.setVisibility((i & 64) > 0 ? 0 : 8);
            }
            if (!this.Y && !this.X0 && (this.O instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.Y0) {
                        K0();
                        UtilHelper.showStatusBar((Activity) this.O, this.V0);
                        this.Y0 = true;
                        qg.a().removeCallbacks(this.g1);
                        qg.a().postDelayed(this.g1, 3000L);
                    }
                } else if (this.Y0) {
                    E0();
                }
            }
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                if (i != this.d && i != this.f) {
                    videoDanmuController.R();
                } else {
                    this.c1.U();
                }
            }
        }
    }

    @Override // com.repackage.a78, android.view.View.OnClickListener
    public void onClick(View view2) {
        qs8 qs8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view2) == null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0918fb) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == R.id.obfuscated_res_0x7f092391 && (qs8Var = this.d1) != null) {
            qs8Var.i();
            VideoItemData videoItemData = this.T0;
            if (videoItemData != null) {
                this.d1.e(videoItemData.thread_id, this.U0);
            }
        }
        super.onClick(view2);
    }

    @Override // com.repackage.a78, com.repackage.x68
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, true, 10);
            qg.a().removeCallbacks(this.f1);
            qg.a().postDelayed(this.f1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a78, com.repackage.x68
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) || threadData == null) {
            return;
        }
        s68 s68Var = new s68();
        s68Var.a = "6";
        s68Var.c = threadData.getTid();
        s68Var.d = Long.toString(threadData.getFid());
        s68Var.e = TbadkCoreApplication.getCurrentAccount();
        s68Var.x = this.T0.getChannelMidRequestNum();
        s68Var.y = this.T0.getChannelMidRequestVideoNum();
        Context context = this.O;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.O0 = intExtra;
                if (intExtra == 0) {
                    this.O0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.P0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    s68Var.k = this.P0;
                }
                s68Var.i = Integer.toString(this.O0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Q0 = stringExtra2;
                s68Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            s68Var.m = threadData.getThreadVideoInfo().video_md5;
            s68Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(s68Var);
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
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.R0, this.S0, this.Q, R.id.obfuscated_res_0x7f092392, this.T0, this.U0);
            this.c1 = videoDanmuController;
            videoDanmuController.W(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
        }
        View findViewById = this.Q.findViewById(R.id.obfuscated_res_0x7f092398);
        View findViewById2 = this.Q.findViewById(R.id.obfuscated_res_0x7f0923b7);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            qs8 qs8Var = this.d1;
            if (qs8Var != null) {
                qs8Var.f();
                this.d1 = null;
            }
            qs8 qs8Var2 = new qs8(this.Q, R.id.obfuscated_res_0x7f092391);
            this.d1 = qs8Var2;
            qs8Var2.g(this);
            this.d1.h(new c(this));
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

    @Override // com.repackage.a78
    public void t0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    @Override // com.repackage.a78
    public void u0() {
        s68 s68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (s68Var = this.Z) == null) {
            return;
        }
        s68 b2 = s68Var.b();
        b2.a = "pb";
        h68.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
    }
}
