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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Handler f38543a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements d.l.a.e.b.f.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ag f38588a;

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
            this.f38588a = agVar;
        }

        @Override // d.l.a.e.b.f.i
        public boolean a(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadInfo)) == null) {
                try {
                    return this.f38588a.a(downloadInfo);
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
                    return this.f38588a.b(downloadInfo);
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
                    return this.f38588a.c(downloadInfo);
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
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.e f38589a;

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
            this.f38589a = eVar;
        }

        @Override // d.l.a.e.b.g.j
        public int a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                try {
                    return this.f38589a.a(j);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            return invokeJ.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.f f38590a;

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
            this.f38590a = fVar;
        }

        @Override // d.l.a.e.b.f.r
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) || downloadInfo == null) {
                return;
            }
            try {
                this.f38590a.a(downloadInfo, baseException, i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f38592a;

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
            this.f38592a = vVar;
        }

        @Override // d.l.a.e.b.f.x
        public boolean a(w wVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wVar)) == null) {
                try {
                    return this.f38592a.a(g.x(wVar));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements d.l.a.e.b.f.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ al f38593a;

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
            this.f38593a = alVar;
        }

        @Override // d.l.a.e.b.f.l
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                try {
                    this.f38593a.a(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.i.g$g  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0508g implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f38594a;

        public C0508g(p pVar) {
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
            this.f38594a = pVar;
        }

        @Override // d.l.a.e.b.f.t
        public boolean a(long j, long j2, s sVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), sVar})) == null) {
                try {
                    return this.f38594a.a(j, j2, g.s(sVar));
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
        public final /* synthetic */ aj f38595a;

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
            this.f38595a = ajVar;
        }

        @Override // d.l.a.e.b.g.s
        public long a(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                try {
                    return this.f38595a.a(i2, i3);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return 0L;
                }
            }
            return invokeII.longValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.h f38596a;

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
            this.f38596a = hVar;
        }

        @Override // d.l.a.e.b.f.y
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return this.f38596a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements d.l.a.e.b.f.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.g f38597a;

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
            this.f38597a = gVar;
        }

        @Override // d.l.a.e.b.f.v
        public Uri a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                try {
                    return this.f38597a.a(str, str2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (Uri) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.i f38598a;

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
            this.f38598a = iVar;
        }

        @Override // d.l.a.e.b.f.u
        public void a(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
                try {
                    this.f38598a.i(downloadInfo);
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
                    this.f38598a.d(downloadInfo);
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
                    this.f38598a.b(downloadInfo);
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
                    this.f38598a.g(downloadInfo);
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
                    this.f38598a.f(downloadInfo);
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
                    this.f38598a.e(downloadInfo);
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
                    this.f38598a.c(downloadInfo);
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
                    this.f38598a.a(downloadInfo, baseException);
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
                    this.f38598a.b(downloadInfo, baseException);
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
                    this.f38598a.c(downloadInfo, baseException);
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
                    this.f38598a.h(downloadInfo);
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
                    this.f38598a.a(downloadInfo);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class l implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.o f38599a;

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
            this.f38599a = oVar;
        }

        @Override // d.l.a.e.b.f.s
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f38599a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class o implements q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.l f38602a;

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
            this.f38602a = lVar;
        }

        @Override // d.l.a.e.b.f.q
        public void a(DownloadInfo downloadInfo) throws BaseException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
                try {
                    this.f38602a.a(downloadInfo);
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
                    return this.f38602a.b(downloadInfo);
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
        f38543a = new Handler(Looper.getMainLooper());
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar)) == null) {
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
                com.ss.android.socialbase.downloader.depend.i b2 = aVar.b(com.ss.android.socialbase.downloader.constants.g.f38474a.ordinal());
                if (b2 != null) {
                    aVar2.c0(b2.hashCode(), b(b2));
                }
                com.ss.android.socialbase.downloader.depend.i b3 = aVar.b(com.ss.android.socialbase.downloader.constants.g.f38475b.ordinal());
                if (b3 != null) {
                    aVar2.M0(b3.hashCode(), b(b3));
                }
                com.ss.android.socialbase.downloader.depend.i b4 = aVar.b(com.ss.android.socialbase.downloader.constants.g.f38476c.ordinal());
                if (b4 != null) {
                    aVar2.v0(b4.hashCode(), b(b4));
                }
                I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.g.f38474a);
                I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.g.f38475b);
                I(aVar2, aVar, com.ss.android.socialbase.downloader.constants.g.f38476c);
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
            return new a.AbstractBinderC0509a(aVar) { // from class: com.ss.android.socialbase.downloader.i.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.n.a f38544a;

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
                    this.f38544a = aVar;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public DownloadInfo a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38544a.J() : (DownloadInfo) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.e b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? g.j(this.f38544a.D()) : (com.ss.android.socialbase.downloader.depend.e) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public aa c() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) ? g.c(this.f38544a.T()) : (aa) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public ag d() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048583, this)) == null) ? g.e(this.f38544a.S()) : (ag) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.h e() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g.m(this.f38544a.Q()) : (com.ss.android.socialbase.downloader.depend.h) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.f f() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) ? g.k(this.f38544a.E()) : (com.ss.android.socialbase.downloader.depend.f) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public v g() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048586, this)) == null) ? g.y(this.f38544a.O()) : (v) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public aj h() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) ? g.g(this.f38544a.U()) : (aj) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public p i() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048588, this)) == null) ? g.t(this.f38544a.F()) : (p) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.j j() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048589, this)) == null) ? g.o(this.f38544a.R()) : (com.ss.android.socialbase.downloader.depend.j) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.g k() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) ? g.l(this.f38544a.N()) : (com.ss.android.socialbase.downloader.depend.g) invokeV.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int l() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) ? this.f38544a.H().size() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public int a(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? this.f38544a.L(d.l.a.e.b.l.f.H0(i2)) : invokeI.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i b(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) {
                        return g.n(this.f38544a.V(d.l.a.e.b.l.f.H0(i2)), i2 != com.ss.android.socialbase.downloader.constants.g.f38475b.ordinal());
                    }
                    return (com.ss.android.socialbase.downloader.depend.i) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.l c(int i2) throws RemoteException {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048582, this, i2)) == null) ? g.p(this.f38544a.G(i2)) : (com.ss.android.socialbase.downloader.depend.l) invokeI.objValue;
                }

                @Override // com.ss.android.socialbase.downloader.model.a
                public com.ss.android.socialbase.downloader.depend.i a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                        return g.n(this.f38544a.K(d.l.a.e.b.l.f.H0(i2), i3), i2 != com.ss.android.socialbase.downloader.constants.g.f38475b.ordinal());
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
                public final /* synthetic */ d.l.a.e.b.f.d f38577a;

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
                    this.f38577a = dVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.aa
                public void a(int i2, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                        this.f38577a.a(i2, downloadInfo, str, str2);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.aa
                public boolean a(boolean z) throws RemoteException {
                    InterceptResult invokeZ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeZ = interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? this.f38577a.a(z) : invokeZ.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.aa
                public String a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f38577a.a() : (String) invokeV.objValue;
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
                public final /* synthetic */ d.l.a.e.b.f.i f38578a;

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
                    this.f38578a = iVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ag
                public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, downloadInfo)) == null) ? this.f38578a.a(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ag
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.f38578a.b(downloadInfo) : invokeL2.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ag
                public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) ? this.f38578a.c(downloadInfo) : invokeL2.booleanValue;
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
                public final /* synthetic */ d.l.a.e.b.g.s f38579a;

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
                    this.f38579a = sVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.aj
                public long a(int i2, int i3) throws RemoteException {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i2, i3)) == null) ? this.f38579a.a(i2, i3) : invokeII.longValue;
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
                public final /* synthetic */ d.l.a.e.b.f.l f38575a;

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
                    this.f38575a = lVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.al
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        this.f38575a.a(i2, i3);
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
                public final /* synthetic */ d.l.a.e.b.g.j f38585a;

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
                    this.f38585a = jVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.e
                public int a(long j2) throws RemoteException {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j2)) == null) ? this.f38585a.a(j2) : invokeJ.intValue;
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
                public final /* synthetic */ r f38582a;

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
                    this.f38582a = rVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.f
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) {
                        this.f38582a.a(downloadInfo, baseException, i2);
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
                public final /* synthetic */ d.l.a.e.b.f.v f38581a;

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
                    this.f38581a = vVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.g
                public Uri a(String str, String str2) throws RemoteException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, str2)) == null) ? this.f38581a.a(str, str2) : (Uri) invokeLL.objValue;
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
                public final /* synthetic */ y f38586a;

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
                    this.f38586a = yVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.h
                public boolean a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f38586a.a() : invokeV.booleanValue;
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
                public final /* synthetic */ d.l.a.e.b.f.b f38545a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f38546b;

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$a */
                /* loaded from: classes6.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38547e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38548f;

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
                        this.f38548f = anonymousClass12;
                        this.f38547e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38548f.f38545a.e(this.f38547e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$b */
                /* loaded from: classes6.dex */
                public class b implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38549e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38550f;

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
                        this.f38550f = anonymousClass12;
                        this.f38549e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38550f.f38545a.d(this.f38549e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$c */
                /* loaded from: classes6.dex */
                public class c implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38551e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38552f;

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
                        this.f38552f = anonymousClass12;
                        this.f38551e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38552f.f38545a.k(this.f38551e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$d */
                /* loaded from: classes6.dex */
                public class d implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38553e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38554f;

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
                        this.f38554f = anonymousClass12;
                        this.f38553e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38554f.f38545a.l(this.f38553e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$e */
                /* loaded from: classes6.dex */
                public class e implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38555e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BaseException f38556f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38557g;

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
                        this.f38557g = anonymousClass12;
                        this.f38555e = downloadInfo;
                        this.f38556f = baseException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38557g.f38545a.i(this.f38555e, this.f38556f);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$f */
                /* loaded from: classes6.dex */
                public class f implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38558e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BaseException f38559f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38560g;

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
                        this.f38560g = anonymousClass12;
                        this.f38558e = downloadInfo;
                        this.f38559f = baseException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38560g.f38545a.j(this.f38558e, this.f38559f);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$g  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0507g implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38561e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38562f;

                    public RunnableC0507g(AnonymousClass12 anonymousClass12, DownloadInfo downloadInfo) {
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
                        this.f38562f = anonymousClass12;
                        this.f38561e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            ((u) this.f38562f.f38545a).a(this.f38561e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$h */
                /* loaded from: classes6.dex */
                public class h implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38563e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38564f;

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
                        this.f38564f = anonymousClass12;
                        this.f38563e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38564f.f38545a.c(this.f38563e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$i */
                /* loaded from: classes6.dex */
                public class i implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38565e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38566f;

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
                        this.f38566f = anonymousClass12;
                        this.f38565e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38566f.f38545a.g(this.f38565e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$j */
                /* loaded from: classes6.dex */
                public class j implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38567e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38568f;

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
                        this.f38568f = anonymousClass12;
                        this.f38567e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38568f.f38545a.b(this.f38567e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$k */
                /* loaded from: classes6.dex */
                public class k implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38569e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38570f;

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
                        this.f38570f = anonymousClass12;
                        this.f38569e = downloadInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38570f.f38545a.f(this.f38569e);
                        }
                    }
                }

                /* renamed from: com.ss.android.socialbase.downloader.i.g$12$l */
                /* loaded from: classes6.dex */
                public class l implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f38571e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BaseException f38572f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass12 f38573g;

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
                        this.f38573g = anonymousClass12;
                        this.f38571e = downloadInfo;
                        this.f38572f = baseException;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.f38573g.f38545a.h(this.f38571e, this.f38572f);
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
                    this.f38545a = bVar;
                    this.f38546b = z;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public int a() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f38545a.hashCode() : invokeV.intValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, downloadInfo) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new h(this, downloadInfo));
                        } else {
                            this.f38545a.c(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, downloadInfo) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new i(this, downloadInfo));
                        } else {
                            this.f38545a.g(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void d(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, downloadInfo) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new j(this, downloadInfo));
                        } else {
                            this.f38545a.b(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void e(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new k(this, downloadInfo));
                        } else {
                            this.f38545a.f(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void f(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048585, this, downloadInfo) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new a(this, downloadInfo));
                        } else {
                            this.f38545a.e(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void g(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048586, this, downloadInfo) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new b(this, downloadInfo));
                        } else {
                            this.f38545a.d(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void h(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048587, this, downloadInfo) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new c(this, downloadInfo));
                        } else {
                            this.f38545a.k(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void i(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048588, this, downloadInfo) == null) {
                        d.l.a.e.b.f.b bVar2 = this.f38545a;
                        if (bVar2 instanceof u) {
                            if (this.f38546b) {
                                g.f38543a.post(new RunnableC0507g(this, downloadInfo));
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
                        if (this.f38546b) {
                            g.f38543a.post(new d(this, downloadInfo));
                        } else {
                            this.f38545a.l(downloadInfo);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void b(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadInfo, baseException) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new e(this, downloadInfo, baseException));
                        } else {
                            this.f38545a.i(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void c(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048582, this, downloadInfo, baseException) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new f(this, downloadInfo, baseException));
                        } else {
                            this.f38545a.j(downloadInfo, baseException);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.i
                public void a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException) == null) {
                        if (this.f38546b) {
                            g.f38543a.post(new l(this, downloadInfo, baseException));
                        } else {
                            this.f38545a.h(downloadInfo, baseException);
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
                public final /* synthetic */ z f38584a;

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
                    this.f38584a = zVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public void a(String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        this.f38584a.a(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.j
                public int[] b() throws RemoteException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        z zVar2 = this.f38584a;
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
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f38584a.b() : (String) invokeV.objValue;
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
                public final /* synthetic */ q f38587a;

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
                    this.f38587a = qVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public void a(DownloadInfo downloadInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, downloadInfo) == null) {
                        try {
                            this.f38587a.a(downloadInfo);
                        } catch (BaseException e2) {
                            throw new IllegalArgumentException(e2);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.l
                public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? this.f38587a.b(downloadInfo) : invokeL2.booleanValue;
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
                public final /* synthetic */ s f38576a;

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
                    this.f38576a = sVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.o
                public void a() throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38576a.a();
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
                public final /* synthetic */ t f38583a;

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
                    this.f38583a = tVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.p
                public boolean a(long j2, long j3, com.ss.android.socialbase.downloader.depend.o oVar) throws RemoteException {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), oVar})) == null) ? this.f38583a.a(j2, j3, g.u(oVar)) : invokeCommon.booleanValue;
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
            return new C0508g(pVar);
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
                public final /* synthetic */ w f38574a;

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
                    this.f38574a = wVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.u
                public void a(List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                        this.f38574a.a(list);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.u
                public boolean a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38574a.a() : invokeV.booleanValue;
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
                public final /* synthetic */ x f38580a;

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
                    this.f38580a = xVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.v
                public boolean a(com.ss.android.socialbase.downloader.depend.u uVar) throws RemoteException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, uVar)) == null) ? this.f38580a.a(g.z(uVar)) : invokeL2.booleanValue;
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

    /* loaded from: classes6.dex */
    public static class d extends d.l.a.e.b.f.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.j f38591a;

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
            this.f38591a = jVar;
        }

        @Override // d.l.a.e.b.f.z
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            try {
                this.f38591a.a(jSONObject.toString());
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
                    return this.f38591a.a();
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
                    return this.f38591a.b();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (int[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.ss.android.socialbase.downloader.depend.u f38600a;

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
            this.f38600a = uVar;
        }

        @Override // d.l.a.e.b.f.w
        public void a(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                try {
                    this.f38600a.a(list);
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
                    return this.f38600a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements d.l.a.e.b.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ aa f38601a;

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
            this.f38601a = aaVar;
        }

        @Override // d.l.a.e.b.f.d
        public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                try {
                    this.f38601a.a(i2, downloadInfo, str, str2);
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
                    return this.f38601a.a(z);
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
                    return this.f38601a.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }
    }
}
