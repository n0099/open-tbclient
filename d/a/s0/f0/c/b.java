package d.a.s0.f0.c;

import android.graphics.SurfaceTexture;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.view.capture.camera.AspectGLSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import d.a.s0.f0.c.a;
import d.a.y0.p.b;
import d.a.y0.t.j;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class b implements d.a.s0.f0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f59421a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59422b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59423c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59424d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f59425e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.y0.p.b f59426f;

    /* renamed from: g  reason: collision with root package name */
    public AspectGLSurfaceView f59427g;

    /* renamed from: h  reason: collision with root package name */
    public a.b f59428h;

    /* renamed from: i  reason: collision with root package name */
    public a.InterfaceC1420a f59429i;
    public boolean j;
    public d.a.c0.a.d k;
    public b.e l;
    public j.a m;
    public b.d n;
    public d.a.s0.y.c.a o;
    public d.a.s0.y.b.a p;

    /* loaded from: classes9.dex */
    public class a implements d.a.s0.u3.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59430a;

        public a(b bVar) {
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
            this.f59430a = bVar;
        }

        @Override // d.a.s0.u3.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59430a.t();
            }
        }

        @Override // d.a.s0.u3.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f59430a.f59425e.getPageActivity().finish();
            }
        }
    }

    /* renamed from: d.a.s0.f0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1421b extends d.a.c0.a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1421b(b bVar) {
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
                }
            }
        }

        @Override // d.a.c0.a.d, com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                super.onCaseCreate(z, str, str2);
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, duMixErrorType, str, str2) == null) {
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59431a;

        public c(b bVar) {
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
            this.f59431a = bVar;
        }

        @Override // d.a.y0.p.b.e
        public void a(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iCaptureResult) == null) {
            }
        }

        @Override // d.a.y0.p.f.a.b
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f59431a.f59429i == null) {
                return;
            }
            this.f59431a.f59429i.b(j);
        }

        @Override // d.a.y0.p.b.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // d.a.y0.p.b.e
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // d.a.y0.p.b.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // d.a.y0.p.b.e
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // d.a.y0.p.b.e
        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
                return;
            }
            this.f59431a.f59427g.setAspectRatio(i2 / i3, 1);
        }

        @Override // d.a.y0.p.b.e
        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            }
        }

        @Override // d.a.y0.p.f.a.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            }
        }

        @Override // d.a.y0.p.f.a.b
        public void onStartSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f59431a.f59424d = true;
                if (this.f59431a.f59428h != null) {
                    this.f59431a.f59428h.b();
                }
            }
        }

        @Override // d.a.y0.p.f.a.b
        public void onStopSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                if (this.f59431a.f59426f != null && this.f59431a.f59428h != null) {
                    this.f59431a.f59428h.a(this.f59431a.f59426f.b());
                }
                this.f59431a.f59424d = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59432a;

        public d(b bVar) {
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
            this.f59432a = bVar;
        }

        @Override // d.a.y0.t.j.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // d.a.y0.t.j.a
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f59432a.f59426f == null) {
                return;
            }
            this.f59432a.f59426f.n();
        }

        @Override // d.a.y0.t.j.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // d.a.y0.t.j.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // d.a.y0.t.j.a
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.f59432a.f59426f == null) {
                return;
            }
            this.f59432a.f59426f.o(z);
        }

        @Override // d.a.y0.t.j.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }

        @Override // d.a.y0.t.j.a
        public void g(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048582, this, i2) != null) || i2 < 3000) {
            }
        }

        @Override // d.a.y0.t.j.a
        public void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f59432a.f59426f == null) {
                return;
            }
            this.f59432a.f59426f.j();
        }

        @Override // d.a.y0.t.j.a
        public void i() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f59432a.f59426f == null) {
                return;
            }
            this.f59432a.f59426f.h();
        }

        @Override // d.a.y0.t.j.a
        public void j(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            }
        }

        @Override // d.a.y0.t.j.a
        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f59432a.f59426f == null) {
                return;
            }
            this.f59432a.f59426f.D(i2);
        }

        @Override // d.a.y0.t.j.a
        public void onRecordEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59433a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f59434e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f59435f;

            public a(e eVar, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59435f = eVar;
                this.f59434e = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.y0.t.j.j(this.f59434e, this.f59435f.f59433a.m);
                }
            }
        }

        public e(b bVar) {
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
            this.f59433a = bVar;
        }

        @Override // d.a.y0.p.b.d
        public void onBeautyEnableChanged(d.a.c0.a.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            }
        }

        @Override // d.a.y0.p.b.d
        public void onChangeGender(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.f59433a.f59426f == null || this.f59433a.f59426f.d()) {
            }
        }

        @Override // d.a.y0.p.b.d
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
                d.a.c.e.m.e.a().post(new a(this, hashMap));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements d.a.s0.y.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59436a;

        public f(b bVar) {
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
            this.f59436a = bVar;
        }

        @Override // d.a.s0.y.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f59436a.f59426f != null) {
                    this.f59436a.f59426f.x(f2);
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g implements d.a.s0.y.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59437a;

        public g(b bVar) {
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
            this.f59437a = bVar;
        }

        @Override // d.a.s0.y.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f59437a.f59426f != null) {
                    this.f59437a.f59426f.z(f2);
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class h implements d.a.y0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59438a;

        public h(b bVar) {
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
            this.f59438a = bVar;
        }

        @Override // d.a.y0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d.a.s0.z3.m.b(this.f59438a.f59425e.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // d.a.y0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.s0.v3.c.f68590c : (String) invokeV.objValue;
        }

        @Override // d.a.y0.c
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        @Override // d.a.y0.c
        public d.a.y0.j.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (d.a.y0.j.a) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class i implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59439e;

        public i(b bVar) {
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
            this.f59439e = bVar;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) && this.f59439e.f59422b) {
                this.f59439e.f59422b = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59440a;

        public j(b bVar) {
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
            this.f59440a = bVar;
        }

        @Override // d.a.y0.p.b.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f59440a.f59426f != null && z) {
                this.f59440a.f59426f.g();
            }
        }
    }

    public b(TbPageContext tbPageContext, AspectGLSurfaceView aspectGLSurfaceView, boolean z, a.b bVar, a.InterfaceC1420a interfaceC1420a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aspectGLSurfaceView, Boolean.valueOf(z), bVar, interfaceC1420a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59421a = 0;
        this.f59422b = true;
        this.f59423c = false;
        this.f59424d = false;
        this.k = new C1421b(this);
        this.l = new c(this);
        this.m = new d(this);
        this.n = new e(this);
        this.o = new f(this);
        this.p = new g(this);
        this.f59425e = tbPageContext;
        this.f59427g = aspectGLSurfaceView;
        this.j = z;
        this.f59428h = bVar;
        this.f59429i = interfaceC1420a;
        r();
    }

    @Override // d.a.s0.f0.c.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            if (qmFilterItem == null) {
                this.f59426f.l(null);
                return true;
            } else if (this.f59426f != null) {
                if (!StringUtils.isNull(qmFilterItem.localPath) && !FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                    Filter filter = new Filter();
                    filter.setDataType(1);
                    filter.setLevel((d.a.c.e.m.b.c(qmFilterItem.effect, 100.0f) * 1.0f) / 100.0f);
                    filter.setFile(new File(qmFilterItem.localPath));
                    this.f59426f.l(filter);
                } else {
                    this.f59426f.l(null);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.s0.f0.c.a
    public boolean b(QmStickerItem qmStickerItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem)) == null) {
            if (qmStickerItem == null) {
                this.f59426f.y(null, "");
                return true;
            } else if (this.f59426f != null) {
                if ("nosticker".equals(qmStickerItem.localPath)) {
                    this.f59426f.y(null, "");
                } else {
                    Sticker sticker = new Sticker();
                    sticker.setMaxVersion(qmStickerItem.sdkVersionMax);
                    sticker.setMiniVersion(qmStickerItem.sdkVersionMin);
                    sticker.setFile(new File(qmStickerItem.localPath));
                    this.f59426f.y(sticker, "");
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.s0.f0.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59424d : invokeV.booleanValue;
    }

    @Override // d.a.s0.f0.c.a
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.y0.p.b bVar = this.f59426f;
            if (bVar != null) {
                bVar.C();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.f0.c.a
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.y0.p.b bVar = this.f59426f;
            if (bVar != null) {
                bVar.A();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.f0.c.a
    public d.a.s0.y.c.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : (d.a.s0.y.c.a) invokeV.objValue;
    }

    @Override // d.a.s0.f0.c.a
    public d.a.s0.y.b.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (d.a.s0.y.b.a) invokeV.objValue;
    }

    @Override // d.a.s0.f0.c.a
    public boolean onDestroy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.y0.p.b bVar = this.f59426f;
            if (bVar != null) {
                bVar.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.f0.c.a
    public boolean onPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.y0.p.b bVar = this.f59426f;
            if (bVar != null) {
                bVar.f();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.f0.c.a
    public boolean onResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f59423c) {
                s();
                this.f59423c = true;
                return true;
            }
            d.a.y0.p.b bVar = this.f59426f;
            if (bVar != null) {
                bVar.g();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        AspectGLSurfaceView aspectGLSurfaceView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d.a.s0.u3.b.c(this.f59425e.getPageActivity(), new a(this));
            if (d.a.s0.u3.b.b() && (aspectGLSurfaceView = this.f59427g) != null) {
                aspectGLSurfaceView.b(2, 0);
                return true;
            }
            this.f59425e.getPageActivity().finish();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.y0.p.b bVar = new d.a.y0.p.b(this.f59425e.getPageActivity());
            this.f59426f = bVar;
            bVar.k(this.k);
            this.f59426f.m(this.f59427g);
            this.f59426f.r(this.l);
            this.f59426f.q(this.n);
            int i2 = 720;
            int i3 = 1280;
            if (this.f59421a == 1) {
                i2 = 1280;
                i3 = 720;
            }
            this.f59426f.i(i2, i3);
            d.a.s0.z3.k.a.e D = d.a.s0.z3.k.a.e.D(this.f59425e);
            D.h(true);
            D.m(true);
            D.j(true);
            D.u(this.f59425e.getPageActivity().getWindowManager().getDefaultDisplay().getRotation());
            this.f59426f.c(D, 30, 5000000, this.j, FileHelper.getVideoTmpDir());
            this.f59426f.t(false);
            this.f59426f.w(true);
            this.f59426f.v(true);
            this.f59426f.s(false);
            this.f59426f.u(false);
            this.f59426f.p(new i(this));
            this.f59426f.e(new j(this));
        }
    }

    @Override // d.a.s0.f0.c.a
    public boolean stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d.a.y0.p.b bVar = this.f59426f;
            if (bVar != null) {
                bVar.B();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.y0.b.d().i(this.f59425e.getPageActivity());
            d.a.y0.b.d().k(FileHelper.getCacheDir());
            d.a.y0.b.d().l(new h(this));
        }
    }
}
