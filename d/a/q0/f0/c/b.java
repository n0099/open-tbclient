package d.a.q0.f0.c;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import d.a.q0.f0.c.a;
import d.a.w0.p.b;
import d.a.w0.t.j;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b implements d.a.q0.f0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f56708a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56709b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56710c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56711d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f56712e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.w0.p.b f56713f;

    /* renamed from: g  reason: collision with root package name */
    public AspectGLSurfaceView f56714g;

    /* renamed from: h  reason: collision with root package name */
    public a.b f56715h;

    /* renamed from: i  reason: collision with root package name */
    public a.InterfaceC1383a f56716i;
    public boolean j;
    public d.a.a0.a.d k;
    public b.e l;
    public j.a m;
    public b.d n;
    public d.a.q0.y.c.a o;
    public d.a.q0.y.b.a p;

    /* loaded from: classes8.dex */
    public class a extends d.a.a0.a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // d.a.a0.a.d, com.baidu.ar.DuMixCallback
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

    /* renamed from: d.a.q0.f0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1384b implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56717a;

        public C1384b(b bVar) {
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
            this.f56717a = bVar;
        }

        @Override // d.a.w0.p.b.e
        public void a(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iCaptureResult) == null) {
            }
        }

        @Override // d.a.w0.p.f.a.b
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f56717a.f56716i == null) {
                return;
            }
            this.f56717a.f56716i.b(j);
        }

        @Override // d.a.w0.p.b.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // d.a.w0.p.b.e
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // d.a.w0.p.b.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // d.a.w0.p.b.e
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // d.a.w0.p.b.e
        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
                return;
            }
            this.f56717a.f56714g.setAspectRatio(i2 / i3, 1);
        }

        @Override // d.a.w0.p.b.e
        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            }
        }

        @Override // d.a.w0.p.f.a.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            }
        }

        @Override // d.a.w0.p.f.a.b
        public void onStartSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f56717a.f56711d = true;
                if (this.f56717a.f56715h != null) {
                    this.f56717a.f56715h.b();
                }
            }
        }

        @Override // d.a.w0.p.f.a.b
        public void onStopSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                if (this.f56717a.f56713f != null && this.f56717a.f56715h != null) {
                    this.f56717a.f56715h.a(this.f56717a.f56713f.b());
                }
                this.f56717a.f56711d = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56718a;

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
            this.f56718a = bVar;
        }

        @Override // d.a.w0.t.j.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // d.a.w0.t.j.a
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f56718a.f56713f == null) {
                return;
            }
            this.f56718a.f56713f.n();
        }

        @Override // d.a.w0.t.j.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // d.a.w0.t.j.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // d.a.w0.t.j.a
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.f56718a.f56713f == null) {
                return;
            }
            this.f56718a.f56713f.o(z);
        }

        @Override // d.a.w0.t.j.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }

        @Override // d.a.w0.t.j.a
        public void g(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048582, this, i2) != null) || i2 < 3000) {
            }
        }

        @Override // d.a.w0.t.j.a
        public void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f56718a.f56713f == null) {
                return;
            }
            this.f56718a.f56713f.j();
        }

        @Override // d.a.w0.t.j.a
        public void i() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f56718a.f56713f == null) {
                return;
            }
            this.f56718a.f56713f.h();
        }

        @Override // d.a.w0.t.j.a
        public void j(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            }
        }

        @Override // d.a.w0.t.j.a
        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f56718a.f56713f == null) {
                return;
            }
            this.f56718a.f56713f.D(i2);
        }

        @Override // d.a.w0.t.j.a
        public void onRecordEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56719a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f56720e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f56721f;

            public a(d dVar, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56721f = dVar;
                this.f56720e = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    j.j(this.f56720e, this.f56721f.f56719a.m);
                }
            }
        }

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
            this.f56719a = bVar;
        }

        @Override // d.a.w0.p.b.d
        public void onBeautyEnableChanged(d.a.a0.a.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            }
        }

        @Override // d.a.w0.p.b.d
        public void onChangeGender(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.f56719a.f56713f == null || this.f56719a.f56713f.d()) {
            }
        }

        @Override // d.a.w0.p.b.d
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
                d.a.d.e.m.e.a().post(new a(this, hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.y.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56722a;

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
            this.f56722a = bVar;
        }

        @Override // d.a.q0.y.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f56722a.f56713f != null) {
                    this.f56722a.f56713f.x(f2);
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.y.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56723a;

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
            this.f56723a = bVar;
        }

        @Override // d.a.q0.y.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f56723a.f56713f != null) {
                    this.f56723a.f56713f.z(f2);
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.w0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56724a;

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
            this.f56724a = bVar;
        }

        @Override // d.a.w0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d.a.q0.z3.m.b(this.f56724a.f56712e.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // d.a.w0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.q0.v3.c.f66021d : (String) invokeV.objValue;
        }

        @Override // d.a.w0.c
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        @Override // d.a.w0.c
        public d.a.w0.j.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (d.a.w0.j.a) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56725e;

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
            this.f56725e = bVar;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) && this.f56725e.f56709b) {
                this.f56725e.f56709b = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56726a;

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
            this.f56726a = bVar;
        }

        @Override // d.a.w0.p.b.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f56726a.f56713f != null && z) {
                this.f56726a.f56713f.g();
            }
        }
    }

    public b(TbPageContext tbPageContext, AspectGLSurfaceView aspectGLSurfaceView, boolean z, a.b bVar, a.InterfaceC1383a interfaceC1383a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aspectGLSurfaceView, Boolean.valueOf(z), bVar, interfaceC1383a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56708a = 0;
        this.f56709b = true;
        this.f56710c = false;
        this.f56711d = false;
        this.k = new a(this);
        this.l = new C1384b(this);
        this.m = new c(this);
        this.n = new d(this);
        this.o = new e(this);
        this.p = new f(this);
        this.f56712e = tbPageContext;
        this.f56714g = aspectGLSurfaceView;
        this.j = z;
        this.f56715h = bVar;
        this.f56716i = interfaceC1383a;
        q();
    }

    @Override // d.a.q0.f0.c.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            if (qmFilterItem == null) {
                this.f56713f.l(null);
                return true;
            } else if (this.f56713f != null) {
                if (!StringUtils.isNull(qmFilterItem.localPath) && !FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                    Filter filter = new Filter();
                    filter.setDataType(1);
                    filter.setLevel((d.a.d.e.m.b.c(qmFilterItem.effect, 100.0f) * 1.0f) / 100.0f);
                    filter.setFile(new File(qmFilterItem.localPath));
                    this.f56713f.l(filter);
                } else {
                    this.f56713f.l(null);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.f0.c.a
    public boolean b(QmStickerItem qmStickerItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem)) == null) {
            if (qmStickerItem == null) {
                this.f56713f.y(null, "");
                return true;
            } else if (this.f56713f != null) {
                if ("nosticker".equals(qmStickerItem.localPath)) {
                    this.f56713f.y(null, "");
                } else {
                    Sticker sticker = new Sticker();
                    sticker.setMaxVersion(qmStickerItem.sdkVersionMax);
                    sticker.setMiniVersion(qmStickerItem.sdkVersionMin);
                    sticker.setFile(new File(qmStickerItem.localPath));
                    this.f56713f.y(sticker, "");
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.f0.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56711d : invokeV.booleanValue;
    }

    @Override // d.a.q0.f0.c.a
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.w0.p.b bVar = this.f56713f;
            if (bVar != null) {
                bVar.C();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f0.c.a
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.w0.p.b bVar = this.f56713f;
            if (bVar != null) {
                bVar.A();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f0.c.a
    public d.a.q0.y.c.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : (d.a.q0.y.c.a) invokeV.objValue;
    }

    @Override // d.a.q0.f0.c.a
    public d.a.q0.y.b.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (d.a.q0.y.b.a) invokeV.objValue;
    }

    @Override // d.a.q0.f0.c.a
    public boolean onDestroy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.w0.p.b bVar = this.f56713f;
            if (bVar != null) {
                bVar.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f0.c.a
    public boolean onPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.w0.p.b bVar = this.f56713f;
            if (bVar != null) {
                bVar.f();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f0.c.a
    public boolean onResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f56710c) {
                r();
                this.f56710c = true;
                return true;
            }
            d.a.w0.p.b bVar = this.f56713f;
            if (bVar != null) {
                bVar.g();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (d.a.q0.u3.a.a() && this.f56714g != null) {
                s();
                this.f56714g.b(2, 0);
                return true;
            }
            this.f56712e.getPageActivity().finish();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.w0.p.b bVar = new d.a.w0.p.b(this.f56712e.getPageActivity());
            this.f56713f = bVar;
            bVar.k(this.k);
            this.f56713f.m(this.f56714g);
            this.f56713f.r(this.l);
            this.f56713f.q(this.n);
            int i2 = 720;
            int i3 = 1280;
            if (this.f56708a == 1) {
                i2 = 1280;
                i3 = 720;
            }
            this.f56713f.i(i2, i3);
            d.a.q0.z3.k.a.e D = d.a.q0.z3.k.a.e.D(this.f56712e);
            D.h(true);
            D.m(true);
            D.j(true);
            D.u(this.f56712e.getPageActivity().getWindowManager().getDefaultDisplay().getRotation());
            this.f56713f.c(D, 30, 5000000, this.j, FileHelper.getVideoTmpDir());
            this.f56713f.t(false);
            this.f56713f.w(true);
            this.f56713f.v(true);
            this.f56713f.s(false);
            this.f56713f.u(false);
            this.f56713f.p(new h(this));
            this.f56713f.e(new i(this));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.w0.b.d().i(TbadkCoreApplication.getInst());
            d.a.w0.b.d().k(FileHelper.getCacheDir());
            d.a.w0.b.d().l(new g(this));
        }
    }

    @Override // d.a.q0.f0.c.a
    public boolean stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.w0.p.b bVar = this.f56713f;
            if (bVar != null) {
                bVar.B();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
