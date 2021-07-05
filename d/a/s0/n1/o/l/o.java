package d.a.s0.n1.o.l;

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
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.v;
import d.a.s0.n1.o.l.a;
import d.a.s0.n1.o.l.c;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f63867a;

    /* renamed from: b  reason: collision with root package name */
    public View f63868b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f63869c;

    /* renamed from: d  reason: collision with root package name */
    public int f63870d;

    /* renamed from: e  reason: collision with root package name */
    public ImmersiveVideoCardEx.a f63871e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f63872f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f63873g;

    /* renamed from: h  reason: collision with root package name */
    public String f63874h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63875i;
    public View j;
    public int k;
    public int l;
    public boolean m;
    public n n;
    public d.a.s0.n1.o.l.a o;
    public d.a.s0.n1.o.l.c p;
    public TbImageView.f q;
    public SeekBar.OnSeekBarChangeListener r;
    public VideoControllerView.d s;
    public View.OnClickListener t;
    public c.p u;
    public CyberPlayerManager.OnPreparedListener v;
    public VideoControllerView.c w;
    public a.h x;

    /* loaded from: classes9.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f63876a;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63876a = oVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f63876a.f63872f != null) {
                this.f63876a.f63872f.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f63877e;

        public b(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63877e = oVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f63877e.p.X();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || this.f63877e.p.a0() || this.f63877e.p.h0() == null) {
                return;
            }
            this.f63877e.p.D0(this.f63877e.p.h0().getSeekPosition());
            this.f63877e.p.O0(this.f63877e.f63874h);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f63878a;

        public c(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63878a = oVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f63878a.r()) {
                return;
            }
            this.f63878a.p.i0(i2);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f63879e;

        public d(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63879e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f63879e.r() && view.getId() == this.f63879e.f63868b.getId()) {
                if (!d.a.c.e.p.j.z()) {
                    d.a.c.e.p.l.J(this.f63879e.f63867a.getPageActivity(), this.f63879e.f63867a.getString(R.string.neterror));
                }
                if (this.f63879e.o == null || !this.f63879e.f63869c.isPlaying()) {
                    return;
                }
                this.f63879e.o.r();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements c.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f63880a;

        public e(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63880a = oVar;
        }

        @Override // d.a.s0.n1.o.l.c.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.s0.n1.o.l.c.p
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f63880a.o.l();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f63881e;

        public f(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63881e = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63881e.f63869c == null) {
                return;
            }
            this.f63881e.o.r();
            if (this.f63881e.n == null || this.f63881e.n.e() == null || !this.f63881e.n.e().equals(this.f63881e.f63874h) || this.f63881e.n.f() <= 0) {
                if (this.f63881e.n == null || this.f63881e.n.g(this.f63881e.f63874h) <= 0) {
                    return;
                }
                this.f63881e.f63869c.seekTo(this.f63881e.n.g(this.f63881e.f63874h));
                return;
            }
            this.f63881e.f63869c.seekTo(this.f63881e.n.f());
            this.f63881e.n.o(null);
            this.f63881e.n.p(0);
        }
    }

    /* loaded from: classes9.dex */
    public class g implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f63882a;

        public g(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63882a = oVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63882a.r() || this.f63882a.o == null || this.f63882a.j == null) {
                return;
            }
            if (this.f63882a.f63869c.isPlaying()) {
                this.f63882a.o.r();
            }
            if (this.f63882a.j.getAlpha() != 1.0f) {
                this.f63882a.j.setAlpha(1.0f);
            }
            this.f63882a.j.clearAnimation();
        }
    }

    /* loaded from: classes9.dex */
    public class h implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f63883a;

        public h(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63883a = oVar;
        }

        @Override // d.a.s0.n1.o.l.a.h
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f63883a.p.a0()) {
                this.f63883a.p.l0();
            }
        }

        @Override // d.a.s0.n1.o.l.a.h
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f63883a.p.a0()) {
                this.f63883a.p.W();
            }
        }

        @Override // d.a.s0.n1.o.l.a.h
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f63883a.p.a0()) {
                this.f63883a.p.W();
            }
        }
    }

    public o(TbPageContext<?> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63875i = false;
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.v = new f(this);
        this.w = new g(this);
        this.x = new h(this);
        this.f63867a = tbPageContext;
        this.f63868b = view;
        view.setOnClickListener(this.t);
        d.a.s0.n1.o.l.c a2 = d.a.s0.n1.o.l.d.a(tbPageContext);
        this.p = a2;
        a2.H0(this);
        this.f63869c = this.p.f0();
        TbImageView tbImageView = (TbImageView) this.f63868b.findViewById(R.id.video_thumbnail);
        this.f63872f = tbImageView;
        tbImageView.setEvent(this.q);
        this.f63873g = (ImageView) this.f63868b.findViewById(R.id.img_play);
        this.j = this.p.b0();
        this.k = d.a.c.e.p.l.k(this.f63867a.getPageActivity());
        this.l = d.a.c.e.p.l.i(this.f63867a.getPageActivity());
        this.n = d.a.s0.n1.o.l.d.c(this.f63867a);
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (r()) {
                return 0;
            }
            return this.f63869c.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63870d : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63874h : (String) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63868b : (View) invokeV.objValue;
    }

    public final void o() {
        d.a.s0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.p) == null || this.f63869c == null || this.f63871e == null) {
            return;
        }
        cVar.P0();
        this.p.A0(this.f63868b);
        if (this.p.e0()) {
            this.p.Q();
        }
        this.p.h0().setOnProgressUpdatedListener(this.s);
        this.p.h0().setOnDragingListener(this.w);
        this.p.h0().setOnSeekBarChangeListener(this.r);
        this.p.z0(this.v);
        this.p.G0(this.f63871e.f18167d);
        this.p.I0(this.f63871e.f18170g);
        this.p.J0(this.f63874h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f63875i : invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f63868b == null || this.f63869c == null || this.f63872f == null || this.f63873g == null || this.j == null || this.o == null : invokeV.booleanValue;
    }

    public void s(d.a.s0.n1.o.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.o = aVar;
            if (aVar != null) {
                aVar.t(this.x);
            }
        }
    }

    public void t(boolean z) {
        d.a.s0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.C0(z);
    }

    public void u(boolean z) {
        d.a.s0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.N0(z);
    }

    public void v() {
        d.a.s0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.m) {
            return;
        }
        int i2 = this.f63870d;
        if (i2 <= 0 || i2 == d.a.s0.n1.o.k.c.f63812a) {
            this.m = true;
            if (r()) {
                return;
            }
            o();
            if (!v.b() || (cVar = this.p) == null) {
                return;
            }
            cVar.O0(this.f63874h);
        }
    }

    public void w() {
        d.a.s0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || r()) {
            return;
        }
        if (this.m && (cVar = this.p) != null && this.f63868b.equals(cVar.c0())) {
            this.p.P0();
            if (this.p.e0()) {
                this.p.j0();
            }
        }
        this.m = false;
        this.f63875i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i2) == null) {
            this.f63871e = aVar;
            this.f63870d = i2;
            if (r() || aVar == null) {
                return;
            }
            String str = this.f63874h;
            if (str == null || !str.equalsIgnoreCase(aVar.f18164a)) {
                w();
                this.f63874h = aVar.f18164a;
                this.f63872f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.f63872f.M(aVar.f18167d, 17, false);
                int i3 = aVar.f18168e;
                int i4 = aVar.f18169f;
                ViewGroup.LayoutParams layoutParams = this.f63868b.getLayoutParams();
                if (i3 > 0 && i4 > 0 && layoutParams != null && !aVar.f18171h) {
                    if (i3 > i4) {
                        layoutParams.height = ((this.k * 1) * i4) / i3;
                    } else {
                        layoutParams.height = this.k;
                    }
                    this.f63868b.setLayoutParams(layoutParams);
                    this.p.M0();
                } else if (layoutParams != null && aVar.f18171h) {
                    layoutParams.width = this.k;
                    layoutParams.height = this.l;
                    this.f63868b.setLayoutParams(layoutParams);
                    this.p.k0();
                }
                this.p.T();
            }
        }
    }

    public void y(String str, String str2) {
        d.a.s0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.R0(str, str2);
    }
}
