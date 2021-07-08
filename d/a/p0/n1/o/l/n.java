package d.a.p0.n1.o.l;

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
import d.a.p0.h3.v;
import d.a.p0.n1.o.l.a;
import d.a.p0.n1.o.l.c;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60633a;

    /* renamed from: b  reason: collision with root package name */
    public View f60634b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f60635c;

    /* renamed from: d  reason: collision with root package name */
    public int f60636d;

    /* renamed from: e  reason: collision with root package name */
    public ImmersiveVideoCardEx.a f60637e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f60638f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60639g;

    /* renamed from: h  reason: collision with root package name */
    public String f60640h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60641i;
    public View j;
    public int k;
    public int l;
    public boolean m;
    public m n;
    public d.a.p0.n1.o.l.a o;
    public d.a.p0.n1.o.l.c p;
    public TbImageView.f q;
    public SeekBar.OnSeekBarChangeListener r;
    public VideoControllerView.d s;
    public View.OnClickListener t;
    public c.p u;
    public CyberPlayerManager.OnPreparedListener v;
    public VideoControllerView.c w;
    public a.h x;

    /* loaded from: classes8.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f60642a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60642a = nVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f60642a.f60638f != null) {
                this.f60642a.f60638f.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f60643e;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60643e = nVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f60643e.p.X();
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || this.f60643e.p.a0() || this.f60643e.p.h0() == null) {
                return;
            }
            this.f60643e.p.D0(this.f60643e.p.h0().getSeekPosition());
            this.f60643e.p.O0(this.f60643e.f60640h);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f60644a;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60644a = nVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f60644a.r()) {
                return;
            }
            this.f60644a.p.i0(i2);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f60645e;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60645e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && !this.f60645e.r() && view.getId() == this.f60645e.f60634b.getId()) {
                if (!d.a.c.e.p.j.z()) {
                    d.a.c.e.p.l.J(this.f60645e.f60633a.getPageActivity(), this.f60645e.f60633a.getString(R.string.neterror));
                }
                if (this.f60645e.o == null || !this.f60645e.f60635c.isPlaying()) {
                    return;
                }
                this.f60645e.o.r();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements c.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f60646a;

        public e(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60646a = nVar;
        }

        @Override // d.a.p0.n1.o.l.c.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.p0.n1.o.l.c.p
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f60646a.o.l();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f60647e;

        public f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60647e = nVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60647e.f60635c == null) {
                return;
            }
            this.f60647e.o.r();
            if (this.f60647e.n == null || this.f60647e.n.e() == null || !this.f60647e.n.e().equals(this.f60647e.f60640h) || this.f60647e.n.f() <= 0) {
                if (this.f60647e.n == null || this.f60647e.n.g(this.f60647e.f60640h) <= 0) {
                    return;
                }
                this.f60647e.f60635c.seekTo(this.f60647e.n.g(this.f60647e.f60640h));
                return;
            }
            this.f60647e.f60635c.seekTo(this.f60647e.n.f());
            this.f60647e.n.o(null);
            this.f60647e.n.p(0);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f60648a;

        public g(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60648a = nVar;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60648a.r() || this.f60648a.o == null || this.f60648a.j == null) {
                return;
            }
            if (this.f60648a.f60635c.isPlaying()) {
                this.f60648a.o.r();
            }
            if (this.f60648a.j.getAlpha() != 1.0f) {
                this.f60648a.j.setAlpha(1.0f);
            }
            this.f60648a.j.clearAnimation();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f60649a;

        public h(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60649a = nVar;
        }

        @Override // d.a.p0.n1.o.l.a.h
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f60649a.p.a0()) {
                this.f60649a.p.l0();
            }
        }

        @Override // d.a.p0.n1.o.l.a.h
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f60649a.p.a0()) {
                this.f60649a.p.W();
            }
        }

        @Override // d.a.p0.n1.o.l.a.h
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f60649a.p.a0()) {
                this.f60649a.p.W();
            }
        }
    }

    public n(TbPageContext<?> tbPageContext, View view) {
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
        this.f60641i = false;
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.v = new f(this);
        this.w = new g(this);
        this.x = new h(this);
        this.f60633a = tbPageContext;
        this.f60634b = view;
        view.setOnClickListener(this.t);
        d.a.p0.n1.o.l.c a2 = d.a.p0.n1.o.l.d.a(tbPageContext);
        this.p = a2;
        a2.H0(this);
        this.f60635c = this.p.f0();
        TbImageView tbImageView = (TbImageView) this.f60634b.findViewById(R.id.video_thumbnail);
        this.f60638f = tbImageView;
        tbImageView.setEvent(this.q);
        this.f60639g = (ImageView) this.f60634b.findViewById(R.id.img_play);
        this.j = this.p.b0();
        this.k = d.a.c.e.p.l.k(this.f60633a.getPageActivity());
        this.l = d.a.c.e.p.l.i(this.f60633a.getPageActivity());
        this.n = d.a.p0.n1.o.l.d.c(this.f60633a);
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (r()) {
                return 0;
            }
            return this.f60635c.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60636d : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60640h : (String) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60634b : (View) invokeV.objValue;
    }

    public final void o() {
        d.a.p0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.p) == null || this.f60635c == null || this.f60637e == null) {
            return;
        }
        cVar.P0();
        this.p.A0(this.f60634b);
        if (this.p.e0()) {
            this.p.Q();
        }
        this.p.h0().setOnProgressUpdatedListener(this.s);
        this.p.h0().setOnDragingListener(this.w);
        this.p.h0().setOnSeekBarChangeListener(this.r);
        this.p.z0(this.v);
        this.p.G0(this.f60637e.f18207d);
        this.p.I0(this.f60637e.f18210g);
        this.p.J0(this.f60640h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f60641i : invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60634b == null || this.f60635c == null || this.f60638f == null || this.f60639g == null || this.j == null || this.o == null : invokeV.booleanValue;
    }

    public void s(d.a.p0.n1.o.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.o = aVar;
            if (aVar != null) {
                aVar.t(this.x);
            }
        }
    }

    public void t(boolean z) {
        d.a.p0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.C0(z);
    }

    public void u(boolean z) {
        d.a.p0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.N0(z);
    }

    public void v() {
        d.a.p0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.m) {
            return;
        }
        int i2 = this.f60636d;
        if (i2 <= 0 || i2 == d.a.p0.n1.o.k.c.f60578a) {
            this.m = true;
            if (r()) {
                return;
            }
            o();
            if (!v.b() || (cVar = this.p) == null) {
                return;
            }
            cVar.O0(this.f60640h);
        }
    }

    public void w() {
        d.a.p0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || r()) {
            return;
        }
        if (this.m && (cVar = this.p) != null && this.f60634b.equals(cVar.c0())) {
            this.p.P0();
            if (this.p.e0()) {
                this.p.j0();
            }
        }
        this.m = false;
        this.f60641i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i2) == null) {
            this.f60637e = aVar;
            this.f60636d = i2;
            if (r() || aVar == null) {
                return;
            }
            String str = this.f60640h;
            if (str == null || !str.equalsIgnoreCase(aVar.f18204a)) {
                w();
                this.f60640h = aVar.f18204a;
                this.f60638f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.f60638f.M(aVar.f18207d, 17, false);
                int i3 = aVar.f18208e;
                int i4 = aVar.f18209f;
                ViewGroup.LayoutParams layoutParams = this.f60634b.getLayoutParams();
                if (i3 > 0 && i4 > 0 && layoutParams != null && !aVar.f18211h) {
                    if (i3 > i4) {
                        layoutParams.height = ((this.k * 1) * i4) / i3;
                    } else {
                        layoutParams.height = this.k;
                    }
                    this.f60634b.setLayoutParams(layoutParams);
                    this.p.M0();
                } else if (layoutParams != null && aVar.f18211h) {
                    layoutParams.width = this.k;
                    layoutParams.height = this.l;
                    this.f60634b.setLayoutParams(layoutParams);
                    this.p.k0();
                }
                this.p.T();
            }
        }
    }

    public void y(String str, String str2) {
        d.a.p0.n1.o.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.R0(str, str2);
    }
}
