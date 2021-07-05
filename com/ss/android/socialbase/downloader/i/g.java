package com.ss.android.socialbase.downloader.i;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.al;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.a;
import d.l.a.e.b.f.q;
import d.l.a.e.b.f.r;
import d.l.a.e.b.f.s;
import d.l.a.e.b.f.t;
import d.l.a.e.b.f.u;
import d.l.a.e.b.f.w;
import d.l.a.e.b.f.x;
import d.l.a.e.b.f.y;
import d.l.a.e.b.f.z;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Handler f41529a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements d.l.a.e.b.f.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ag f41574a;

        public a(ag agVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41574a = agVar;
        }

        @Override // d.l.a.e.b.f.i
        public boolean a(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadInfo)) == null) {
                try {
                    return this.f41574a.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // d.l.a.e.b.f.i
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
                try {
                    return this.f41574a.b(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // d.l.a.e.b.f.i
        public boolean c(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                try {
                    return this.f41574a.c(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements d.l.a.e.b.g.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.e f41575a;

        public b(com.ss.android.socialbase.downloader.depend.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41575a = eVar;
        }

        @Override // d.l.a.e.b.g.j
        public int a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                try {
                    return this.f41575a.a(j);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            return invokeJ.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.f f41576a;

        public c(com.ss.android.socialbase.downloader.depend.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41576a = fVar;
        }

        @Override // d.l.a.e.b.f.r
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) || downloadInfo == null) {
                return;
            }
            try {
                this.f41576a.a(downloadInfo, baseException, i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f41578a;

        public e(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41578a = vVar;
        }

        @Override // d.l.a.e.b.f.x
        public boolean a(w wVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wVar)) == null) {
                try {
                    return this.f41578a.a(g.x(wVar));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements d.l.a.e.b.f.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ al f41579a;

        public f(al alVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41579a = alVar;
        }

        @Override // d.l.a.e.b.f.l
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                try {
                    this.f41579a.a(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.i.g$g  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0547g implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f41580a;

        public C0547g(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41580a = pVar;
        }

        @Override // d.l.a.e.b.f.t
        public boolean a(long j, long j2, s sVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), sVar})) == null) {
                try {
                    return this.f41580a.a(j, j2, g.s(sVar));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements d.l.a.e.b.g.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aj f41581a;

        public h(aj ajVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ajVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41581a = ajVar;
        }

        @Override // d.l.a.e.b.g.s
        public long a(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                try {
                    return this.f41581a.a(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0L;
                }
            }
            return invokeII.longValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.h f41582a;

        public i(com.ss.android.socialbase.downloader.depend.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41582a = hVar;
        }

        @Override // d.l.a.e.b.f.y
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return this.f41582a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements d.l.a.e.b.f.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.g f41583a;

        public j(com.ss.android.socialbase.downloader.depend.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41583a = gVar;
        }

        @Override // d.l.a.e.b.f.v
        public Uri a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                try {
                    return this.f41583a.a(str, str2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (Uri) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class k implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.i f41584a;

        public k(com.ss.android.socialbase.downloader.depend.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41584a = iVar;
        }

        @Override // d.l.a.e.b.f.u
        public void a(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
                try {
                    this.f41584a.i(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void b(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                try {
                    this.f41584a.d(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void c(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) {
                try {
                    this.f41584a.b(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void d(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) {
                try {
                    this.f41584a.g(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void e(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
                try {
                    this.f41584a.f(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void f(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) {
                try {
                    this.f41584a.e(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void g(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, downloadInfo) == null) {
                try {
                    this.f41584a.c(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void h(DownloadInfo downloadInfo, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, downloadInfo, baseException) == null) {
                try {
                    this.f41584a.a(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void i(DownloadInfo downloadInfo, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo, baseException) == null) {
                try {
                    this.f41584a.b(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void j(DownloadInfo downloadInfo, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, downloadInfo, baseException) == null) {
                try {
                    this.f41584a.c(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void k(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, downloadInfo) == null) {
                try {
                    this.f41584a.h(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.b
        public void l(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, downloadInfo) == null) {
                try {
                    this.f41584a.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.o f41585a;

        public l(com.ss.android.socialbase.downloader.depend.o oVar) {
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
            this.f41585a = oVar;
        }

        @Override // d.l.a.e.b.f.s
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f41585a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class o implements q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.l f41588a;

        public o(com.ss.android.socialbase.downloader.depend.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41588a = lVar;
        }

        @Override // d.l.a.e.b.f.q
        public void a(DownloadInfo downloadInfo) throws BaseException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
                try {
                    this.f41588a.a(downloadInfo);
                } catch (RemoteException e2) {
                    throw new BaseException(1008, e2);
                }
            }
        }

        @Override // d.l.a.e.b.f.q
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
                try {
                    return this.f41588a.b(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(479430456, "Lcom/ss/android/socialbase/downloader/i/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(479430456, "Lcom/ss/android/socialbase/downloader/i/g;");
                return;
            }
        }
        f41529a = new Handler(Looper.getMainLooper());
    }

    public static x A(v vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vVar)) == null) {
            if (vVar == null) {
                return null;
            }
            return new e(vVar);
        }
        return (x) invokeL.objValue;
    }

    public static y B(com.ss.android.socialbase.downloader.depend.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hVar)) == null) {
            if (hVar == null) {
                return null;
            }
            return new i(hVar);
        }
        return (y) invokeL.objValue;
    }

    public static z C(com.ss.android.socialbase.downloader.depend.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jVar)) == null) {
            if (jVar == null) {
                return null;
            }
            return new d(jVar);
        }
        return (z) invokeL.objValue;
    }

    public static d.l.a.e.b.g.j D(com.ss.android.socialbase.downloader.depend.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            return new b(eVar);
        }
        return (d.l.a.e.b.g.j) invokeL.objValue;
    }

    public static d.l.a.e.b.g.s E(aj ajVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, ajVar)) == null) {
            if (ajVar == null) {
                return null;
            }
            return new h(ajVar);
        }
        return (d.l.a.e.b.g.s) invokeL.objValue;
    }

    public static d.l.a.e.b.n.a F(com.ss.android.socialbase.downloader.model.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            try {
                d.l.a.e.b.n.a aVar2 = new d.l.a.e.b.n.a(aVar.a());
                aVar2.l(D(aVar.b()));
                aVar2.t0(d(aVar.c()));
                aVar2.Y(B(aVar.e()));
                aVar2.o(r(aVar.f()));
                aVar2.h0(C(aVar.j()));
                aVar2.A(A(aVar.g()));
                aVar2.p(v(aVar.i()));
                aVar2.z(w(aVar.k()));
                aVar2.s0(f(aVar.d()));
                aVar2.C0(E(aVar.h()));
                com.ss.android.socialbase.downloader.depend.i b2 = aVar.b(com.ss.android.socialbase.downloader.constants.g.f41460a.ordinal());
                if (b2 != null) {
                    aVar2.c0(b2.hashCode(), b(b2));
                }
                com.ss.android.socialbase.downloader.depend.i b3 = aVar.b(com.ss.android.socialbase.downloader.constants.g.f41461b.ordinal());
                if (b3 != null) {
                    aVar2.M0(b3.hashCode(), b(b3));
                }
                com.ss.android.socialbase.downloader.depend.i b4 = aVar.b(com.ss.android.socialbase.downloader.constants.g.f41462c.ordinal());
                if (b4 != null) {
                    aVar2.v0(b4.hashCode(), b(b4));
                }
                I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.g.f41460a);
                I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.g.f41461b);
                I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.g.f41462c);
                H(aVar2, aVar);
                return aVar2;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (d.l.a.e.b.n.a) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.model.a G(d.l.a.e.b.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return new a.AbstractBinderC0548a(aVar) { // from class: com.ss.android.socialbase.downloader.i.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.n.a f41530a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41530a = aVar;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public DownloadInfo a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41530a.J() : (DownloadInfo) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.e b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? g.j(this.f41530a.D()) : (com.ss.android.socialbase.downloader.depend.e) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public aa c() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) ? g.c(this.f41530a.T()) : (aa) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public ag d() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048583, this)) == null) ? g.e(this.f41530a.S()) : (ag) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.h e() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g.m(this.f41530a.Q()) : (com.ss.android.socialbase.downloader.depend.h) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.f f() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) ? g.k(this.f41530a.E()) : (com.ss.android.socialbase.downloader.depend.f) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public v g() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048586, this)) == null) ? g.y(this.f41530a.O()) : (v) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public aj h() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) ? g.g(this.f41530a.U()) : (aj) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public p i() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048588, this)) == null) ? g.t(this.f41530a.F()) : (p) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.j j() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048589, this)) == null) ? g.o(this.f41530a.R()) : (com.ss.android.socialbase.downloader.depend.j) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.g k() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) ? g.l(this.f41530a.N()) : (com.ss.android.socialbase.downloader.depend.g) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int l() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) ? this.f41530a.H().size() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int a(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? this.f41530a.L(d.l.a.e.b.l.f.H0(i2)) : invokeI.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i b(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) {
                        return g.n(this.f41530a.V(d.l.a.e.b.l.f.H0(i2)), i2 != com.ss.android.socialbase.downloader.constants.g.f41461b.ordinal());
                    }
                    return (com.ss.android.socialbase.downloader.depend.i) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.l c(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048582, this, i2)) == null) ? g.p(this.f41530a.G(i2)) : (com.ss.android.socialbase.downloader.depend.l) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                        return g.n(this.f41530a.K(d.l.a.e.b.l.f.H0(i2), i3), i2 != com.ss.android.socialbase.downloader.constants.g.f41461b.ordinal());
                    }
                    return (com.ss.android.socialbase.downloader.depend.i) invokeII.objValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.model.a) invokeL.objValue;
    }

    public static void H(d.l.a.e.b.n.a aVar, com.ss.android.socialbase.downloader.model.a aVar2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, aVar, aVar2) == null) {
            for (int i2 = 0; i2 < aVar2.l(); i2++) {
                com.ss.android.socialbase.downloader.depend.l c2 = aVar2.c(i2);
                if (c2 != null) {
                    aVar.b(q(c2));
                }
            }
        }
    }

    public static void I(d.l.a.e.b.n.a aVar, com.ss.android.socialbase.downloader.model.a aVar2, com.ss.android.socialbase.downloader.constants.g gVar) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, aVar, aVar2, gVar) == null) {
            SparseArray<d.l.a.e.b.f.b> sparseArray = new SparseArray<>();
            for (int i2 = 0; i2 < aVar2.a(gVar.ordinal()); i2++) {
                com.ss.android.socialbase.downloader.depend.i a2 = aVar2.a(gVar.ordinal(), i2);
                if (a2 != null) {
                    sparseArray.put(a2.a(), b(a2));
                }
            }
            aVar.H0(sparseArray, gVar);
        }
    }

    public static d.l.a.e.b.f.b b(com.ss.android.socialbase.downloader.depend.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, iVar)) == null) {
            if (iVar == null) {
                return null;
            }
            return new k(iVar);
        }
        return (d.l.a.e.b.f.b) invokeL.objValue;
    }

    public static aa c(d.l.a.e.b.f.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, dVar)) == null) {
            if (dVar == null) {
                return null;
            }
            return new aa.a(dVar) { // from class: com.ss.android.socialbase.downloader.i.g.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.d f41563a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41563a = dVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.aa
                public void a(int i2, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                        this.f41563a.a(i2, downloadInfo, str, str2);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.aa
                public boolean a(boolean z) throws RemoteException {
                    InterceptResult invokeZ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeZ = interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? this.f41563a.a(z) : invokeZ.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.aa
                public String a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f41563a.a() : (String) invokeV.objValue;
                }
            };
        }
        return (aa) invokeL.objValue;
    }

    public static d.l.a.e.b.f.d d(aa aaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, aaVar)) == null) {
            if (aaVar == null) {
                return null;
            }
            return new n(aaVar);
        }
        return (d.l.a.e.b.f.d) invokeL.objValue;
    }

    public static ag e(d.l.a.e.b.f.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, iVar)) == null) {
            if (iVar == null) {
                return null;
            }
            return new ag.a(iVar) { // from class: com.ss.android.socialbase.downloader.i.g.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.i f41564a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41564a = iVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ag
                public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, downloadInfo)) == null) ? this.f41564a.a(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ag
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.f41564a.b(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ag
                public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) ? this.f41564a.c(downloadInfo) : invokeL2.booleanValue;
                }
            };
        }
        return (ag) invokeL.objValue;
    }

    public static d.l.a.e.b.f.i f(ag agVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, agVar)) == null) {
            if (agVar == null) {
                return null;
            }
            return new a(agVar);
        }
        return (d.l.a.e.b.f.i) invokeL.objValue;
    }

    public static aj g(d.l.a.e.b.g.s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, sVar)) == null) {
            if (sVar == null) {
                return null;
            }
            return new aj.a(sVar) { // from class: com.ss.android.socialbase.downloader.i.g.27
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.g.s f41565a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41565a = sVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.aj
                public long a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i2, i3)) == null) ? this.f41565a.a(i2, i3) : invokeII.longValue;
                }
            };
        }
        return (aj) invokeL.objValue;
    }

    public static al h(d.l.a.e.b.f.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, lVar)) == null) {
            if (lVar == null) {
                return null;
            }
            return new al.a(lVar) { // from class: com.ss.android.socialbase.downloader.i.g.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.l f41561a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {lVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41561a = lVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.al
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        this.f41561a.a(i2, i3);
                    }
                }
            };
        }
        return (al) invokeL.objValue;
    }

    public static d.l.a.e.b.f.l i(al alVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, alVar)) == null) {
            if (alVar == null) {
                return null;
            }
            return new f(alVar);
        }
        return (d.l.a.e.b.f.l) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.e j(d.l.a.e.b.g.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, jVar)) == null) {
            if (jVar == null) {
                return null;
            }
            return new e.a(jVar) { // from class: com.ss.android.socialbase.downloader.i.g.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.g.j f41571a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41571a = jVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.e
                public int a(long j2) throws RemoteException {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j2)) == null) ? this.f41571a.a(j2) : invokeJ.intValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.e) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.f k(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, rVar)) == null) {
            if (rVar == null) {
                return null;
            }
            return new f.a(rVar) { // from class: com.ss.android.socialbase.downloader.i.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ r f41568a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {rVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41568a = rVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.f
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) {
                        this.f41568a.a(downloadInfo, baseException, i2);
                    }
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.f) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.g l(d.l.a.e.b.f.v vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, vVar)) == null) {
            if (vVar == null) {
                return null;
            }
            return new g.a(vVar) { // from class: com.ss.android.socialbase.downloader.i.g.29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.v f41567a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {vVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41567a = vVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.g
                public Uri a(String str, String str2) throws RemoteException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, str2)) == null) ? this.f41567a.a(str, str2) : (Uri) invokeLL.objValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.g) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.h m(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, yVar)) == null) {
            if (yVar == null) {
                return null;
            }
            return new h.a(yVar) { // from class: com.ss.android.socialbase.downloader.i.g.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ y f41572a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {yVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41572a = yVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.h
                public boolean a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f41572a.a() : invokeV.booleanValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.h) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.i n(d.l.a.e.b.f.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65559, null, bVar, z)) == null) {
            if (bVar == null) {
                return null;
            }
            return new i.a(bVar, z) { // from class: com.ss.android.socialbase.downloader.i.g.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.b f41531a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f41532b;

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$a */
                /* loaded from: classes7.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41533e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41534f;

                    public a(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41534f = anonymousClass12;
                        this.f41533e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41534f.f41531a.e(this.f41533e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$b */
                /* loaded from: classes7.dex */
                public class b implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41535e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41536f;

                    public b(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41536f = anonymousClass12;
                        this.f41535e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41536f.f41531a.d(this.f41535e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$c */
                /* loaded from: classes7.dex */
                public class c implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41537e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41538f;

                    public c(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41538f = anonymousClass12;
                        this.f41537e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41538f.f41531a.k(this.f41537e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$d */
                /* loaded from: classes7.dex */
                public class d implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41539e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41540f;

                    public d(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41540f = anonymousClass12;
                        this.f41539e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41540f.f41531a.l(this.f41539e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$e */
                /* loaded from: classes7.dex */
                public class e implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41541e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BaseException f41542f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41543g;

                    public e(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo, BaseException baseException) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo, baseException};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41543g = anonymousClass12;
                        this.f41541e = downloadInfo;
                        this.f41542f = baseException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41543g.f41531a.i(this.f41541e, this.f41542f);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$f */
                /* loaded from: classes7.dex */
                public class f implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41544e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BaseException f41545f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41546g;

                    public f(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo, BaseException baseException) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo, baseException};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41546g = anonymousClass12;
                        this.f41544e = downloadInfo;
                        this.f41545f = baseException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41546g.f41531a.j(this.f41544e, this.f41545f);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$g  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class RunnableC0546g implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41547e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41548f;

                    public RunnableC0546g(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41548f = anonymousClass12;
                        this.f41547e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            ((u) this.f41548f.f41531a).a(this.f41547e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$h */
                /* loaded from: classes7.dex */
                public class h implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41549e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41550f;

                    public h(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41550f = anonymousClass12;
                        this.f41549e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41550f.f41531a.c(this.f41549e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$i */
                /* loaded from: classes7.dex */
                public class i implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41551e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41552f;

                    public i(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41552f = anonymousClass12;
                        this.f41551e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41552f.f41531a.g(this.f41551e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$j */
                /* loaded from: classes7.dex */
                public class j implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41553e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41554f;

                    public j(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41554f = anonymousClass12;
                        this.f41553e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41554f.f41531a.b(this.f41553e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$k */
                /* loaded from: classes7.dex */
                public class k implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41555e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41556f;

                    public k(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41556f = anonymousClass12;
                        this.f41555e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41556f.f41531a.f(this.f41555e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$l */
                /* loaded from: classes7.dex */
                public class l implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f41557e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BaseException f41558f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f41559g;

                    public l(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo, BaseException baseException) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass12, downloadInfo, baseException};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41559g = anonymousClass12;
                        this.f41557e = downloadInfo;
                        this.f41558f = baseException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f41559g.f41531a.h(this.f41557e, this.f41558f);
                        }
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41531a = bVar;
                    this.f41532b = z;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public int a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f41531a.hashCode() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, downloadInfo) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new h(this, downloadInfo));
                        } else {
                            this.f41531a.c(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, downloadInfo) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new i(this, downloadInfo));
                        } else {
                            this.f41531a.g(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void d(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, downloadInfo) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new j(this, downloadInfo));
                        } else {
                            this.f41531a.b(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void e(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new k(this, downloadInfo));
                        } else {
                            this.f41531a.f(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void f(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048585, this, downloadInfo) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new a(this, downloadInfo));
                        } else {
                            this.f41531a.e(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void g(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048586, this, downloadInfo) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new b(this, downloadInfo));
                        } else {
                            this.f41531a.d(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void h(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048587, this, downloadInfo) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new c(this, downloadInfo));
                        } else {
                            this.f41531a.k(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void i(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048588, this, downloadInfo) == null) {
                        d.l.a.e.b.f.b bVar2 = this.f41531a;
                        if (bVar2 instanceof u) {
                            if (this.f41532b) {
                                g.f41529a.post(new RunnableC0546g(this, downloadInfo));
                            } else {
                                ((u) bVar2).a(downloadInfo);
                            }
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void a(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new d(this, downloadInfo));
                        } else {
                            this.f41531a.l(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadInfo, baseException) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new e(this, downloadInfo, baseException));
                        } else {
                            this.f41531a.i(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048582, this, downloadInfo, baseException) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new f(this, downloadInfo, baseException));
                        } else {
                            this.f41531a.j(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException) == null) {
                        if (this.f41532b) {
                            g.f41529a.post(new l(this, downloadInfo, baseException));
                        } else {
                            this.f41531a.h(downloadInfo, baseException);
                        }
                    }
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.i) invokeLZ.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.j o(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, zVar)) == null) {
            if (zVar == null) {
                return null;
            }
            return new j.a(zVar) { // from class: com.ss.android.socialbase.downloader.i.g.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ z f41570a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41570a = zVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public void a(String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        this.f41570a.a(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public int[] b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        z zVar2 = this.f41570a;
                        if (zVar2 instanceof d.l.a.e.b.f.n) {
                            return ((d.l.a.e.b.f.n) zVar2).a();
                        }
                        return null;
                    }
                    return (int[]) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public String a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f41570a.b() : (String) invokeV.objValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.j) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.l p(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, qVar)) == null) {
            if (qVar == null) {
                return null;
            }
            return new l.a(qVar) { // from class: com.ss.android.socialbase.downloader.i.g.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f41573a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {qVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41573a = qVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public void a(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        try {
                            this.f41573a.a(downloadInfo);
                        } catch (BaseException e2) {
                            throw new IllegalArgumentException(e2);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.f41573a.b(downloadInfo) : invokeL2.booleanValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.l) invokeL.objValue;
    }

    public static q q(com.ss.android.socialbase.downloader.depend.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, lVar)) == null) {
            if (lVar == null) {
                return null;
            }
            return new o(lVar);
        }
        return (q) invokeL.objValue;
    }

    public static r r(com.ss.android.socialbase.downloader.depend.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            return new c(fVar);
        }
        return (r) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.o s(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, sVar)) == null) {
            if (sVar == null) {
                return null;
            }
            return new o.a(sVar) { // from class: com.ss.android.socialbase.downloader.i.g.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ s f41562a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {sVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41562a = sVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.o
                public void a() throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f41562a.a();
                    }
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.o) invokeL.objValue;
    }

    public static p t(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, tVar)) == null) {
            if (tVar == null) {
                return null;
            }
            return new p.a(tVar) { // from class: com.ss.android.socialbase.downloader.i.g.31
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ t f41569a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41569a = tVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.p
                public boolean a(long j2, long j3, com.ss.android.socialbase.downloader.depend.o oVar) throws RemoteException {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), oVar})) == null) ? this.f41569a.a(j2, j3, g.u(oVar)) : invokeCommon.booleanValue;
                }
            };
        }
        return (p) invokeL.objValue;
    }

    public static s u(com.ss.android.socialbase.downloader.depend.o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, oVar)) == null) {
            if (oVar == null) {
                return null;
            }
            return new l(oVar);
        }
        return (s) invokeL.objValue;
    }

    public static t v(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, pVar)) == null) {
            if (pVar == null) {
                return null;
            }
            return new C0547g(pVar);
        }
        return (t) invokeL.objValue;
    }

    public static d.l.a.e.b.f.v w(com.ss.android.socialbase.downloader.depend.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            return new j(gVar);
        }
        return (d.l.a.e.b.f.v) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.u x(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, wVar)) == null) {
            if (wVar == null) {
                return null;
            }
            return new u.a(wVar) { // from class: com.ss.android.socialbase.downloader.i.g.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ w f41560a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {wVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41560a = wVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.u
                public void a(List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                        this.f41560a.a(list);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.u
                public boolean a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41560a.a() : invokeV.booleanValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.u) invokeL.objValue;
    }

    public static v y(x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, xVar)) == null) {
            if (xVar == null) {
                return null;
            }
            return new v.a(xVar) { // from class: com.ss.android.socialbase.downloader.i.g.28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ x f41566a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41566a = xVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean a(com.ss.android.socialbase.downloader.depend.u uVar) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, uVar)) == null) ? this.f41566a.a(g.z(uVar)) : invokeL2.booleanValue;
                }
            };
        }
        return (v) invokeL.objValue;
    }

    public static w z(com.ss.android.socialbase.downloader.depend.u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, uVar)) == null) {
            if (uVar == null) {
                return null;
            }
            return new m(uVar);
        }
        return (w) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public static class d extends d.l.a.e.b.f.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.j f41577a;

        public d(com.ss.android.socialbase.downloader.depend.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41577a = jVar;
        }

        @Override // d.l.a.e.b.f.z
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            try {
                this.f41577a.a(jSONObject.toString());
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.l.a.e.b.f.z
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    return this.f41577a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }

        @Override // d.l.a.e.b.f.n
        public int[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    return this.f41577a.b();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (int[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.u f41586a;

        public m(com.ss.android.socialbase.downloader.depend.u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41586a = uVar;
        }

        @Override // d.l.a.e.b.f.w
        public void a(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                try {
                    this.f41586a.a(list);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.w
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    return this.f41586a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements d.l.a.e.b.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aa f41587a;

        public n(aa aaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41587a = aaVar;
        }

        @Override // d.l.a.e.b.f.d
        public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                try {
                    this.f41587a.a(i2, downloadInfo, str, str2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.d
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                try {
                    return this.f41587a.a(z);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeZ.booleanValue;
        }

        @Override // d.l.a.e.b.f.d
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return this.f41587a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }
    }
}
