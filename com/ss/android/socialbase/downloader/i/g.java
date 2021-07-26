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
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.ak;
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
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.a;
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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Handler f38715a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements d.l.a.e.b.f.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ af f38760a;

        public a(af afVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {afVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38760a = afVar;
        }

        @Override // d.l.a.e.b.f.j
        public boolean a(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadInfo)) == null) {
                try {
                    return this.f38760a.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // d.l.a.e.b.f.j
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
                try {
                    return this.f38760a.b(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // d.l.a.e.b.f.j
        public boolean c(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                try {
                    return this.f38760a.c(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements d.l.a.e.b.g.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.e f38761a;

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
            this.f38761a = eVar;
        }

        @Override // d.l.a.e.b.g.j
        public int a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                try {
                    return this.f38761a.a(j);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            return invokeJ.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.f f38762a;

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
            this.f38762a = fVar;
        }

        @Override // d.l.a.e.b.f.s
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) || downloadInfo == null) {
                return;
            }
            try {
                this.f38762a.a(downloadInfo, baseException, i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f38764a;

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
            this.f38764a = vVar;
        }

        @Override // d.l.a.e.b.f.y
        public boolean a(x xVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xVar)) == null) {
                try {
                    return this.f38764a.a(g.x(xVar));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements d.l.a.e.b.f.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ak f38765a;

        public f(ak akVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {akVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38765a = akVar;
        }

        @Override // d.l.a.e.b.f.m
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                try {
                    this.f38765a.a(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.i.g$g  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0510g implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f38766a;

        public C0510g(p pVar) {
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
            this.f38766a = pVar;
        }

        @Override // d.l.a.e.b.f.u
        public boolean a(long j, long j2, t tVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), tVar})) == null) {
                try {
                    return this.f38766a.a(j, j2, g.s(tVar));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements d.l.a.e.b.g.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ai f38767a;

        public h(ai aiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38767a = aiVar;
        }

        @Override // d.l.a.e.b.g.s
        public long a(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                try {
                    return this.f38767a.a(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0L;
                }
            }
            return invokeII.longValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements d.l.a.e.b.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.h f38768a;

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
            this.f38768a = hVar;
        }

        @Override // d.l.a.e.b.f.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return this.f38768a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.g f38769a;

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
            this.f38769a = gVar;
        }

        @Override // d.l.a.e.b.f.w
        public Uri a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                try {
                    return this.f38769a.a(str, str2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (Uri) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements d.l.a.e.b.f.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.i f38770a;

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
            this.f38770a = iVar;
        }

        @Override // d.l.a.e.b.f.v
        public void a(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
                try {
                    this.f38770a.i(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void b(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                try {
                    this.f38770a.d(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void c(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) {
                try {
                    this.f38770a.b(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void d(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) {
                try {
                    this.f38770a.g(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void e(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
                try {
                    this.f38770a.f(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void f(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) {
                try {
                    this.f38770a.e(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void g(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, downloadInfo) == null) {
                try {
                    this.f38770a.c(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void h(DownloadInfo downloadInfo, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, downloadInfo, baseException) == null) {
                try {
                    this.f38770a.a(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void i(DownloadInfo downloadInfo, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo, baseException) == null) {
                try {
                    this.f38770a.b(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void j(DownloadInfo downloadInfo, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, downloadInfo, baseException) == null) {
                try {
                    this.f38770a.c(downloadInfo, baseException);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void k(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, downloadInfo) == null) {
                try {
                    this.f38770a.h(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.c
        public void l(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, downloadInfo) == null) {
                try {
                    this.f38770a.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.o f38771a;

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
            this.f38771a = oVar;
        }

        @Override // d.l.a.e.b.f.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f38771a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class o implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.l f38774a;

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
            this.f38774a = lVar;
        }

        @Override // d.l.a.e.b.f.r
        public void a(DownloadInfo downloadInfo) throws BaseException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
                try {
                    this.f38774a.a(downloadInfo);
                } catch (RemoteException e2) {
                    throw new BaseException(1008, e2);
                }
            }
        }

        @Override // d.l.a.e.b.f.r
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
                try {
                    return this.f38774a.b(downloadInfo);
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
        f38715a = new Handler(Looper.getMainLooper());
    }

    public static y A(v vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vVar)) == null) {
            if (vVar == null) {
                return null;
            }
            return new e(vVar);
        }
        return (y) invokeL.objValue;
    }

    public static z B(com.ss.android.socialbase.downloader.depend.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jVar)) == null) {
            if (jVar == null) {
                return null;
            }
            return new d(jVar);
        }
        return (z) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.z C(d.l.a.e.b.f.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            return new z.a(eVar) { // from class: com.ss.android.socialbase.downloader.i.g.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.e f38749a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38749a = eVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public void a(int i2, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                        this.f38749a.a(i2, downloadInfo, str, str2);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public boolean a(boolean z) throws RemoteException {
                    InterceptResult invokeZ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeZ = interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? this.f38749a.a(z) : invokeZ.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public String a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f38749a.a() : (String) invokeV.objValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.z) invokeL.objValue;
    }

    public static d.l.a.e.b.g.j D(com.ss.android.socialbase.downloader.depend.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            return new b(eVar);
        }
        return (d.l.a.e.b.g.j) invokeL.objValue;
    }

    public static d.l.a.e.b.g.s E(ai aiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aiVar)) == null) {
            if (aiVar == null) {
                return null;
            }
            return new h(aiVar);
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
                aVar2.Y(b(aVar.e()));
                aVar2.o(r(aVar.f()));
                aVar2.h0(B(aVar.j()));
                aVar2.A(A(aVar.g()));
                aVar2.p(v(aVar.i()));
                aVar2.z(w(aVar.k()));
                aVar2.s0(f(aVar.d()));
                aVar2.C0(E(aVar.h()));
                com.ss.android.socialbase.downloader.depend.i b2 = aVar.b(com.ss.android.socialbase.downloader.constants.f.f38646a.ordinal());
                if (b2 != null) {
                    aVar2.c0(b2.hashCode(), c(b2));
                }
                com.ss.android.socialbase.downloader.depend.i b3 = aVar.b(com.ss.android.socialbase.downloader.constants.f.f38647b.ordinal());
                if (b3 != null) {
                    aVar2.M0(b3.hashCode(), c(b3));
                }
                com.ss.android.socialbase.downloader.depend.i b4 = aVar.b(com.ss.android.socialbase.downloader.constants.f.f38648c.ordinal());
                if (b4 != null) {
                    aVar2.v0(b4.hashCode(), c(b4));
                }
                I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.f.f38646a);
                I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.f.f38647b);
                I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.f.f38648c);
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
            return new a.AbstractBinderC0511a(aVar) { // from class: com.ss.android.socialbase.downloader.i.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.n.a f38716a;

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
                    this.f38716a = aVar;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public DownloadInfo a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38716a.J() : (DownloadInfo) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.e b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? g.j(this.f38716a.D()) : (com.ss.android.socialbase.downloader.depend.e) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.z c() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) ? g.C(this.f38716a.T()) : (com.ss.android.socialbase.downloader.depend.z) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public af d() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048583, this)) == null) ? g.e(this.f38716a.S()) : (af) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.h e() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g.m(this.f38716a.Q()) : (com.ss.android.socialbase.downloader.depend.h) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.f f() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) ? g.k(this.f38716a.E()) : (com.ss.android.socialbase.downloader.depend.f) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public v g() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048586, this)) == null) ? g.y(this.f38716a.O()) : (v) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public ai h() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) ? g.g(this.f38716a.U()) : (ai) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public p i() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048588, this)) == null) ? g.t(this.f38716a.F()) : (p) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.j j() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048589, this)) == null) ? g.o(this.f38716a.R()) : (com.ss.android.socialbase.downloader.depend.j) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.g k() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) ? g.l(this.f38716a.N()) : (com.ss.android.socialbase.downloader.depend.g) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int l() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) ? this.f38716a.H().size() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int a(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? this.f38716a.L(d.l.a.e.b.l.f.H0(i2)) : invokeI.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i b(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) {
                        return g.n(this.f38716a.V(d.l.a.e.b.l.f.H0(i2)), i2 != com.ss.android.socialbase.downloader.constants.f.f38647b.ordinal());
                    }
                    return (com.ss.android.socialbase.downloader.depend.i) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.l c(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048581, this, i2)) == null) ? g.p(this.f38716a.G(i2)) : (com.ss.android.socialbase.downloader.depend.l) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                        return g.n(this.f38716a.K(d.l.a.e.b.l.f.H0(i2), i3), i2 != com.ss.android.socialbase.downloader.constants.f.f38647b.ordinal());
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

    public static void I(d.l.a.e.b.n.a aVar, com.ss.android.socialbase.downloader.model.a aVar2, com.ss.android.socialbase.downloader.constants.f fVar) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, aVar, aVar2, fVar) == null) {
            SparseArray<d.l.a.e.b.f.c> sparseArray = new SparseArray<>();
            for (int i2 = 0; i2 < aVar2.a(fVar.ordinal()); i2++) {
                com.ss.android.socialbase.downloader.depend.i a2 = aVar2.a(fVar.ordinal(), i2);
                if (a2 != null) {
                    sparseArray.put(a2.a(), c(a2));
                }
            }
            aVar.H0(sparseArray, fVar);
        }
    }

    public static d.l.a.e.b.f.b b(com.ss.android.socialbase.downloader.depend.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, hVar)) == null) {
            if (hVar == null) {
                return null;
            }
            return new i(hVar);
        }
        return (d.l.a.e.b.f.b) invokeL.objValue;
    }

    public static d.l.a.e.b.f.c c(com.ss.android.socialbase.downloader.depend.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, iVar)) == null) {
            if (iVar == null) {
                return null;
            }
            return new k(iVar);
        }
        return (d.l.a.e.b.f.c) invokeL.objValue;
    }

    public static d.l.a.e.b.f.e d(com.ss.android.socialbase.downloader.depend.z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, zVar)) == null) {
            if (zVar == null) {
                return null;
            }
            return new n(zVar);
        }
        return (d.l.a.e.b.f.e) invokeL.objValue;
    }

    public static af e(d.l.a.e.b.f.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jVar)) == null) {
            if (jVar == null) {
                return null;
            }
            return new af.a(jVar) { // from class: com.ss.android.socialbase.downloader.i.g.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.j f38750a;

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
                    this.f38750a = jVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, downloadInfo)) == null) ? this.f38750a.a(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.f38750a.b(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) ? this.f38750a.c(downloadInfo) : invokeL2.booleanValue;
                }
            };
        }
        return (af) invokeL.objValue;
    }

    public static d.l.a.e.b.f.j f(af afVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, afVar)) == null) {
            if (afVar == null) {
                return null;
            }
            return new a(afVar);
        }
        return (d.l.a.e.b.f.j) invokeL.objValue;
    }

    public static ai g(d.l.a.e.b.g.s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, sVar)) == null) {
            if (sVar == null) {
                return null;
            }
            return new ai.a(sVar) { // from class: com.ss.android.socialbase.downloader.i.g.27
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.g.s f38751a;

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
                    this.f38751a = sVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ai
                public long a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i2, i3)) == null) ? this.f38751a.a(i2, i3) : invokeII.longValue;
                }
            };
        }
        return (ai) invokeL.objValue;
    }

    public static ak h(d.l.a.e.b.f.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, mVar)) == null) {
            if (mVar == null) {
                return null;
            }
            return new ak.a(mVar) { // from class: com.ss.android.socialbase.downloader.i.g.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.m f38747a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38747a = mVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ak
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        this.f38747a.a(i2, i3);
                    }
                }
            };
        }
        return (ak) invokeL.objValue;
    }

    public static d.l.a.e.b.f.m i(ak akVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, akVar)) == null) {
            if (akVar == null) {
                return null;
            }
            return new f(akVar);
        }
        return (d.l.a.e.b.f.m) invokeL.objValue;
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
                public final /* synthetic */ d.l.a.e.b.g.j f38757a;

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
                    this.f38757a = jVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.e
                public int a(long j2) throws RemoteException {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j2)) == null) ? this.f38757a.a(j2) : invokeJ.intValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.e) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.f k(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, sVar)) == null) {
            if (sVar == null) {
                return null;
            }
            return new f.a(sVar) { // from class: com.ss.android.socialbase.downloader.i.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ s f38754a;

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
                    this.f38754a = sVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.f
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) {
                        this.f38754a.a(downloadInfo, baseException, i2);
                    }
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.f) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.g l(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, wVar)) == null) {
            if (wVar == null) {
                return null;
            }
            return new g.a(wVar) { // from class: com.ss.android.socialbase.downloader.i.g.29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ w f38753a;

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
                    this.f38753a = wVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.g
                public Uri a(String str, String str2) throws RemoteException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, str2)) == null) ? this.f38753a.a(str, str2) : (Uri) invokeLL.objValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.g) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.h m(d.l.a.e.b.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            return new h.a(bVar) { // from class: com.ss.android.socialbase.downloader.i.g.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.b f38758a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38758a = bVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.h
                public boolean a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f38758a.a() : invokeV.booleanValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.h) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.i n(d.l.a.e.b.f.c cVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65559, null, cVar, z)) == null) {
            if (cVar == null) {
                return null;
            }
            return new i.a(cVar, z) { // from class: com.ss.android.socialbase.downloader.i.g.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.f.c f38717a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f38718b;

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$a */
                /* loaded from: classes6.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38719e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38720f;

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
                        this.f38720f = anonymousClass12;
                        this.f38719e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38720f.f38717a.e(this.f38719e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$b */
                /* loaded from: classes6.dex */
                public class b implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38721e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38722f;

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
                        this.f38722f = anonymousClass12;
                        this.f38721e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38722f.f38717a.d(this.f38721e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$c */
                /* loaded from: classes6.dex */
                public class c implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38723e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38724f;

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
                        this.f38724f = anonymousClass12;
                        this.f38723e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38724f.f38717a.k(this.f38723e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$d */
                /* loaded from: classes6.dex */
                public class d implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38725e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38726f;

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
                        this.f38726f = anonymousClass12;
                        this.f38725e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38726f.f38717a.l(this.f38725e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$e */
                /* loaded from: classes6.dex */
                public class e implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38727e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BaseException f38728f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38729g;

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
                        this.f38729g = anonymousClass12;
                        this.f38727e = downloadInfo;
                        this.f38728f = baseException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38729g.f38717a.i(this.f38727e, this.f38728f);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$f */
                /* loaded from: classes6.dex */
                public class f implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38730e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BaseException f38731f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38732g;

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
                        this.f38732g = anonymousClass12;
                        this.f38730e = downloadInfo;
                        this.f38731f = baseException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38732g.f38717a.j(this.f38730e, this.f38731f);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$g  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0509g implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38733e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38734f;

                    public RunnableC0509g(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
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
                        this.f38734f = anonymousClass12;
                        this.f38733e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            ((d.l.a.e.b.f.v) this.f38734f.f38717a).a(this.f38733e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$h */
                /* loaded from: classes6.dex */
                public class h implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38735e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38736f;

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
                        this.f38736f = anonymousClass12;
                        this.f38735e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38736f.f38717a.c(this.f38735e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$i */
                /* loaded from: classes6.dex */
                public class i implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38737e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38738f;

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
                        this.f38738f = anonymousClass12;
                        this.f38737e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38738f.f38717a.g(this.f38737e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$j */
                /* loaded from: classes6.dex */
                public class j implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38739e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38740f;

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
                        this.f38740f = anonymousClass12;
                        this.f38739e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38740f.f38717a.b(this.f38739e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$k */
                /* loaded from: classes6.dex */
                public class k implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38741e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38742f;

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
                        this.f38742f = anonymousClass12;
                        this.f38741e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38742f.f38717a.f(this.f38741e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$l */
                /* loaded from: classes6.dex */
                public class l implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38743e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BaseException f38744f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38745g;

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
                        this.f38745g = anonymousClass12;
                        this.f38743e = downloadInfo;
                        this.f38744f = baseException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38745g.f38717a.h(this.f38743e, this.f38744f);
                        }
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cVar, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38717a = cVar;
                    this.f38718b = z;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public int a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f38717a.hashCode() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, downloadInfo) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new h(this, downloadInfo));
                        } else {
                            this.f38717a.c(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, downloadInfo) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new i(this, downloadInfo));
                        } else {
                            this.f38717a.g(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void d(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, downloadInfo) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new j(this, downloadInfo));
                        } else {
                            this.f38717a.b(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void e(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new k(this, downloadInfo));
                        } else {
                            this.f38717a.f(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void f(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048585, this, downloadInfo) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new a(this, downloadInfo));
                        } else {
                            this.f38717a.e(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void g(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048586, this, downloadInfo) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new b(this, downloadInfo));
                        } else {
                            this.f38717a.d(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void h(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048587, this, downloadInfo) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new c(this, downloadInfo));
                        } else {
                            this.f38717a.k(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void i(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048588, this, downloadInfo) == null) {
                        d.l.a.e.b.f.c cVar2 = this.f38717a;
                        if (cVar2 instanceof d.l.a.e.b.f.v) {
                            if (this.f38718b) {
                                g.f38715a.post(new RunnableC0509g(this, downloadInfo));
                            } else {
                                ((d.l.a.e.b.f.v) cVar2).a(downloadInfo);
                            }
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void a(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new d(this, downloadInfo));
                        } else {
                            this.f38717a.l(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadInfo, baseException) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new e(this, downloadInfo, baseException));
                        } else {
                            this.f38717a.i(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048582, this, downloadInfo, baseException) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new f(this, downloadInfo, baseException));
                        } else {
                            this.f38717a.j(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException) == null) {
                        if (this.f38718b) {
                            g.f38715a.post(new l(this, downloadInfo, baseException));
                        } else {
                            this.f38717a.h(downloadInfo, baseException);
                        }
                    }
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.i) invokeLZ.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.j o(d.l.a.e.b.f.z zVar) {
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
                public final /* synthetic */ d.l.a.e.b.f.z f38756a;

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
                    this.f38756a = zVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public void a(String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        this.f38756a.a(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public int[] b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        d.l.a.e.b.f.z zVar2 = this.f38756a;
                        if (zVar2 instanceof d.l.a.e.b.f.o) {
                            return ((d.l.a.e.b.f.o) zVar2).a();
                        }
                        return null;
                    }
                    return (int[]) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public String a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f38756a.b() : (String) invokeV.objValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.j) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.l p(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, rVar)) == null) {
            if (rVar == null) {
                return null;
            }
            return new l.a(rVar) { // from class: com.ss.android.socialbase.downloader.i.g.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ r f38759a;

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
                    this.f38759a = rVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public void a(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        try {
                            this.f38759a.a(downloadInfo);
                        } catch (BaseException e2) {
                            throw new IllegalArgumentException(e2);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.f38759a.b(downloadInfo) : invokeL2.booleanValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.l) invokeL.objValue;
    }

    public static r q(com.ss.android.socialbase.downloader.depend.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, lVar)) == null) {
            if (lVar == null) {
                return null;
            }
            return new o(lVar);
        }
        return (r) invokeL.objValue;
    }

    public static s r(com.ss.android.socialbase.downloader.depend.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            return new c(fVar);
        }
        return (s) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.o s(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, tVar)) == null) {
            if (tVar == null) {
                return null;
            }
            return new o.a(tVar) { // from class: com.ss.android.socialbase.downloader.i.g.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ t f38748a;

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
                    this.f38748a = tVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.o
                public void a() throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38748a.a();
                    }
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.o) invokeL.objValue;
    }

    public static p t(u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, uVar)) == null) {
            if (uVar == null) {
                return null;
            }
            return new p.a(uVar) { // from class: com.ss.android.socialbase.downloader.i.g.31
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ u f38755a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {uVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38755a = uVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.p
                public boolean a(long j2, long j3, com.ss.android.socialbase.downloader.depend.o oVar) throws RemoteException {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), oVar})) == null) ? this.f38755a.a(j2, j3, g.u(oVar)) : invokeCommon.booleanValue;
                }
            };
        }
        return (p) invokeL.objValue;
    }

    public static t u(com.ss.android.socialbase.downloader.depend.o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, oVar)) == null) {
            if (oVar == null) {
                return null;
            }
            return new l(oVar);
        }
        return (t) invokeL.objValue;
    }

    public static u v(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, pVar)) == null) {
            if (pVar == null) {
                return null;
            }
            return new C0510g(pVar);
        }
        return (u) invokeL.objValue;
    }

    public static w w(com.ss.android.socialbase.downloader.depend.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            return new j(gVar);
        }
        return (w) invokeL.objValue;
    }

    public static com.ss.android.socialbase.downloader.depend.u x(x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, xVar)) == null) {
            if (xVar == null) {
                return null;
            }
            return new u.a(xVar) { // from class: com.ss.android.socialbase.downloader.i.g.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ x f38746a;

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
                    this.f38746a = xVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.u
                public void a(List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                        this.f38746a.a(list);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.u
                public boolean a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38746a.a() : invokeV.booleanValue;
                }
            };
        }
        return (com.ss.android.socialbase.downloader.depend.u) invokeL.objValue;
    }

    public static v y(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, yVar)) == null) {
            if (yVar == null) {
                return null;
            }
            return new v.a(yVar) { // from class: com.ss.android.socialbase.downloader.i.g.28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ y f38752a;

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
                    this.f38752a = yVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean a(com.ss.android.socialbase.downloader.depend.u uVar) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, uVar)) == null) ? this.f38752a.a(g.z(uVar)) : invokeL2.booleanValue;
                }
            };
        }
        return (v) invokeL.objValue;
    }

    public static x z(com.ss.android.socialbase.downloader.depend.u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, uVar)) == null) {
            if (uVar == null) {
                return null;
            }
            return new m(uVar);
        }
        return (x) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public static class d extends d.l.a.e.b.f.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.j f38763a;

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
            this.f38763a = jVar;
        }

        @Override // d.l.a.e.b.f.z
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            try {
                this.f38763a.a(jSONObject.toString());
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
                    return this.f38763a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }

        @Override // d.l.a.e.b.f.o
        public int[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    return this.f38763a.b();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (int[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.u f38772a;

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
            this.f38772a = uVar;
        }

        @Override // d.l.a.e.b.f.x
        public void a(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                try {
                    this.f38772a.a(list);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.x
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    return this.f38772a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements d.l.a.e.b.f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.z f38773a;

        public n(com.ss.android.socialbase.downloader.depend.z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38773a = zVar;
        }

        @Override // d.l.a.e.b.f.e
        public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                try {
                    this.f38773a.a(i2, downloadInfo, str, str2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.e
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                try {
                    return this.f38773a.a(z);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeZ.booleanValue;
        }

        @Override // d.l.a.e.b.f.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return this.f38773a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }
    }
}
