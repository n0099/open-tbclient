package d.a.q0.x3.i;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.videoplay.videoview.VideoMediaController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.e;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.q0.n2.h;
import d.a.q0.n2.n;
import d.a.q0.n2.o;
import d.a.q0.n2.q.d;
/* loaded from: classes8.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int L0;
    public int M0;
    public int N0;
    public String O0;
    public String P0;
    public View Q0;
    public View R0;
    public boolean S0;
    public boolean T0;
    public ObjectAnimator U0;
    public ObjectAnimator V0;
    public c W0;
    public Runnable X0;
    public Runnable Y0;

    /* renamed from: d.a.q0.x3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1851a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66959e;

        public RunnableC1851a(a aVar) {
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
            this.f66959e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66959e.L.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66960e;

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
            this.f66960e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f66960e.T0 && (this.f66960e.P instanceof Activity)) {
                this.f66960e.F0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, View view) {
        super(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
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
        this.L0 = -1;
        this.N0 = 0;
        this.X0 = new RunnableC1851a(this);
        this.Y0 = new b(this);
        O();
        Activity activity = (Activity) context;
        this.S0 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        X(true);
        Y(true);
        this.j0 = false;
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            I0();
            UtilHelper.hideStatusBar((Activity) this.P, this.Q0);
            this.T0 = false;
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            X(false);
            Y(false);
        }
    }

    public void H0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.W0 = cVar;
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.V0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.R0, "alpha", 1.0f, 0.0f);
                this.V0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.V0.start();
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.U0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.R0, "alpha", 0.0f, 1.0f);
                this.U0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.U0.start();
        }
    }

    @Override // d.a.q0.n2.q.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.f61448f & (-33);
            this.f61448f = i2;
            int i3 = this.f61449g & (-33);
            this.f61449g = i3;
            int i4 = this.f61450h & (-33);
            this.f61450h = i4;
            int i5 = this.f61451i & (-33);
            this.f61451i = i5;
            int i6 = this.j & (-33);
            this.j = i6;
            int i7 = this.k & (-33);
            this.k = i7;
            int i8 = this.l & (-33);
            this.l = i8;
            int i9 = this.m & (-33);
            this.m = i9;
            int i10 = this.n & (-33);
            this.n = i10;
            this.f61448f = i2 | 1024;
            int i11 = i3 | 1024;
            this.f61449g = i11;
            this.f61450h = i4 & (-1025);
            this.f61451i = i5 | 1024;
            this.j = i6 | 1024;
            int i12 = i7 | 1024;
            this.k = i12;
            int i13 = i8 | 1024;
            this.l = i13;
            this.m = i9 | 1024;
            this.n = i10 & (-1025);
            this.f61449g = i11 | 16384;
            this.k = i12 | 16384;
            this.l = i13 & (-2);
        }
    }

    @Override // d.a.q0.n2.q.d
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.H.a(this.U, this.a0);
            this.I.e(this.U, this.a0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).t(this.U, this.a0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
            int i2 = 0;
            int g2 = (this.a0 && this.U) ? l.g(this.P, R.dimen.tbds42) : 0;
            if (this.a0 && !this.U) {
                i2 = l.g(this.P, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = g2;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // d.a.q0.n2.q.d
    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            Context context = this.P;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
            }
            super.U(z);
            if (this.a0) {
                this.R.setVisibility(0);
                t0();
            } else {
                this.R.setVisibility(8);
                this.R.removeView(this.u);
            }
            c cVar = this.W0;
            if (cVar != null) {
                cVar.a(this.a0);
            }
        }
    }

    @Override // d.a.q0.n2.q.d
    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.layout.operable_video_container : invokeV.intValue;
    }

    @Override // d.a.q0.n2.q.d
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.d0();
            this.v.s();
            this.v.setDrawCorner(false);
            this.M0 = l.k(this.P) / 10;
            this.I.setShareFrom(18);
        }
    }

    @Override // d.a.q0.n2.q.d
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.u.setVolume(1.0f, 1.0f);
        }
    }

    @Override // d.a.q0.n2.q.d
    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.M0) : invokeL.booleanValue;
    }

    @Override // d.a.q0.n2.q.d
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n2.q.d, d.a.q0.n2.q.a
    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.q == this.n) {
                return false;
            }
            this.L.setVisibility(0);
            this.L.d(this.P, true, 10);
            e.a().removeCallbacks(this.X0);
            e.a().postDelayed(this.X0, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view);
    }

    @Override // d.a.q0.n2.q.d
    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            int i3 = this.q;
            int i4 = this.n;
            if (i3 != i4 && i2 == i4) {
                e.a().removeCallbacks(this.X0);
                int i5 = this.q;
                if ((i5 & 16384) > 0) {
                    i2 = (i2 | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i2 = (i2 & (-16385)) | 128 | 64;
                }
                this.n = i2;
            }
            super.p0(i2);
            int i6 = 8;
            if (!this.a0) {
                this.J.setVisibility(8);
                this.K.setVisibility(8);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                int i7 = i2 & 16384;
                operableVideoMediaControllerView.setVisibility((i7 > 0 || (i2 & 128) > 0) ? 0 : 0);
                ((VideoMediaController) this.G).setBottomBarShow(i7 > 0);
            }
            if (this.a0 || this.S0 || !(this.P instanceof Activity)) {
                return;
            }
            if ((i2 & 128) > 0) {
                if (this.T0) {
                    return;
                }
                J0();
                UtilHelper.showStatusBar((Activity) this.P, this.Q0);
                this.T0 = true;
                e.a().removeCallbacks(this.Y0);
                e.a().postDelayed(this.Y0, 3000L);
            } else if (this.T0) {
                F0();
            }
        }
    }

    @Override // d.a.q0.n2.q.d, d.a.q0.n2.q.a
    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, b2Var) == null) || b2Var == null) {
            return;
        }
        b2Var.J();
        o oVar = new o();
        oVar.f61423a = "6";
        oVar.f61425c = b2Var.o1();
        oVar.f61426d = Long.toString(b2Var.R());
        oVar.f61427e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (b2Var.J1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.N0 = intExtra;
                if (intExtra == 0) {
                    this.N0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.O0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    oVar.k = this.O0;
                }
                oVar.f61431i = Integer.toString(this.N0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P0 = stringExtra2;
                oVar.f61431i = stringExtra2;
            }
        }
        if (b2Var.m1() != null) {
            oVar.m = b2Var.m1().video_md5;
            oVar.p = String.valueOf(b2Var.m1().is_vertical);
        }
        q0(oVar);
        if (this.a0 && b2Var.m1() != null) {
            if (this.U != (b2Var.m1().is_vertical.intValue() == 1)) {
                T();
            }
        }
        super.setData(b2Var);
        X(!this.U);
        if (b2Var.H() != null) {
            b2Var.H().setIsLike(b2Var.H().hadConcerned());
        }
    }

    @Override // d.a.q0.n2.q.d, d.a.q0.n2.q.a
    public boolean v0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            if (!this.S0) {
                F0();
            }
            if (z) {
                int i2 = this.q;
                this.L0 = i2;
                if (i2 == this.j || ((i2 == this.k && !this.u.isPlaying()) || this.q == this.l)) {
                    this.L0 |= 1;
                }
                stopPlay();
            } else {
                int i3 = this.L0;
                if (i3 == -1) {
                    startPlay();
                } else if (i3 != this.f61449g && i3 != this.f61451i && i3 != this.f61450h) {
                    this.G.setCurrentDuration(n.d().c(this.V), false);
                    p0(this.L0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // d.a.q0.n2.q.d
    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
        }
    }

    @Override // d.a.q0.n2.q.d
    public void z0() {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (oVar = this.b0) == null) {
            return;
        }
        o b2 = oVar.b();
        b2.f61423a = "pb";
        h.e(b2.m, "", "2", b2, this.u.getPcdnState());
    }
}
