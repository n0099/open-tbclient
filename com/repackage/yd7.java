package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.od7;
import com.repackage.qd7;
/* loaded from: classes7.dex */
public class yd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public y68 c;
    public int d;
    public ImmersiveVideoCardEx.a e;
    public TbImageView f;
    public ImageView g;
    public String h;
    public boolean i;
    public View j;
    public int k;
    public int l;
    public boolean m;
    public xd7 n;
    public od7 o;
    public qd7 p;
    public TbImageView.g q;
    public SeekBar.OnSeekBarChangeListener r;
    public VideoControllerView.d s;
    public View.OnClickListener t;
    public qd7.n u;
    public CyberPlayerManager.OnPreparedListener v;
    public VideoControllerView.c w;
    public od7.h x;

    /* loaded from: classes7.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd7 a;

        public a(yd7 yd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd7Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.f != null) {
                this.a.f.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd7 a;

        public b(yd7 yd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd7Var;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
                this.a.p.X();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || this.a.p.a0() || this.a.p.h0() == null) {
                return;
            }
            this.a.p.D0(this.a.p.h0().getSeekPosition());
            this.a.p.O0(this.a.h);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd7 a;

        public c(yd7 yd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd7Var;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.r()) {
                return;
            }
            this.a.p.i0(i);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd7 a;

        public d(yd7 yd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !this.a.r() && view2.getId() == this.a.b.getId()) {
                if (!mi.z()) {
                    oi.K(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0c17));
                }
                if (this.a.o == null || !this.a.c.isPlaying()) {
                    return;
                }
                this.a.o.r();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements qd7.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd7 a;

        public e(yd7 yd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd7Var;
        }

        @Override // com.repackage.qd7.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.qd7.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o.l();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd7 a;

        public f(yd7 yd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd7Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.c == null) {
                return;
            }
            this.a.o.r();
            if (this.a.n == null || this.a.n.e() == null || !this.a.n.e().equals(this.a.h) || this.a.n.f() <= 0) {
                if (this.a.n == null || this.a.n.g(this.a.h) <= 0) {
                    return;
                }
                this.a.c.seekTo(this.a.n.g(this.a.h));
                return;
            }
            this.a.c.seekTo(this.a.n.f());
            this.a.n.o(null);
            this.a.n.p(0);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd7 a;

        public g(yd7 yd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd7Var;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.r() || this.a.o == null || this.a.j == null) {
                return;
            }
            if (this.a.c.isPlaying()) {
                this.a.o.r();
            }
            if (this.a.j.getAlpha() != 1.0f) {
                this.a.j.setAlpha(1.0f);
            }
            this.a.j.clearAnimation();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements od7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd7 a;

        public h(yd7 yd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd7Var;
        }

        @Override // com.repackage.od7.h
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p.a0()) {
                this.a.p.l0();
            }
        }

        @Override // com.repackage.od7.h
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.p.a0()) {
                this.a.p.W();
            }
        }

        @Override // com.repackage.od7.h
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.p.a0()) {
                this.a.p.W();
            }
        }
    }

    public yd7(TbPageContext<?> tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.v = new f(this);
        this.w = new g(this);
        this.x = new h(this);
        this.a = tbPageContext;
        this.b = view2;
        view2.setOnClickListener(this.t);
        qd7 a2 = rd7.a(tbPageContext);
        this.p = a2;
        a2.H0(this);
        this.c = this.p.f0();
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f092371);
        this.f = tbImageView;
        tbImageView.setEvent(this.q);
        this.g = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090ec5);
        this.j = this.p.b0();
        this.k = oi.k(this.a.getPageActivity());
        this.l = oi.i(this.a.getPageActivity());
        this.n = rd7.c(this.a);
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (r()) {
                return 0;
            }
            return this.c.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public final void o() {
        qd7 qd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (qd7Var = this.p) == null || this.c == null || this.e == null) {
            return;
        }
        qd7Var.P0();
        this.p.A0(this.b);
        if (this.p.e0()) {
            this.p.Q();
        }
        this.p.h0().setOnProgressUpdatedListener(this.s);
        this.p.h0().setOnDragingListener(this.w);
        this.p.h0().setOnSeekBarChangeListener(this.r);
        this.p.z0(this.v);
        this.p.G0(this.e.d);
        this.p.I0(this.e.g);
        this.p.J0(this.h);
        this.p.x0(this.u);
        this.p.r0();
        this.p.L0();
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.i : invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b == null || this.c == null || this.f == null || this.g == null || this.j == null || this.o == null : invokeV.booleanValue;
    }

    public void s(od7 od7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, od7Var) == null) {
            this.o = od7Var;
            if (od7Var != null) {
                od7Var.t(this.x);
            }
        }
    }

    public void t(boolean z) {
        qd7 qd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (qd7Var = this.p) == null) {
            return;
        }
        qd7Var.C0(z);
    }

    public void u(boolean z) {
        qd7 qd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (qd7Var = this.p) == null) {
            return;
        }
        qd7Var.N0(z);
    }

    public void v() {
        qd7 qd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.m) {
            return;
        }
        int i = this.d;
        if (i <= 0 || i == ld7.a) {
            this.m = true;
            if (r()) {
                return;
            }
            o();
            if (!bk8.b() || (qd7Var = this.p) == null) {
                return;
            }
            qd7Var.O0(this.h);
        }
    }

    public void w() {
        qd7 qd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || r()) {
            return;
        }
        if (this.m && (qd7Var = this.p) != null && this.b.equals(qd7Var.c0())) {
            this.p.P0();
            if (this.p.e0()) {
                this.p.j0();
            }
        }
        this.m = false;
        this.i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i) == null) {
            this.e = aVar;
            this.d = i;
            if (r() || aVar == null) {
                return;
            }
            String str = this.h;
            if (str == null || !str.equalsIgnoreCase(aVar.a)) {
                w();
                this.h = aVar.a;
                this.f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.f.K(aVar.d, 17, false);
                int i2 = aVar.e;
                int i3 = aVar.f;
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.h) {
                    if (i2 > i3) {
                        layoutParams.height = ((this.k * 1) * i3) / i2;
                    } else {
                        layoutParams.height = this.k;
                    }
                    this.b.setLayoutParams(layoutParams);
                    this.p.M0();
                } else if (layoutParams != null && aVar.h) {
                    layoutParams.width = this.k;
                    layoutParams.height = this.l;
                    this.b.setLayoutParams(layoutParams);
                    this.p.k0();
                }
                this.p.T();
            }
        }
    }

    public void y(String str, String str2) {
        qd7 qd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || (qd7Var = this.p) == null) {
            return;
        }
        qd7Var.R0(str, str2);
    }
}
