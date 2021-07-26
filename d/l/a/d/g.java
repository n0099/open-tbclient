package d.l.a.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.a.a.c.n;
import d.l.a.a.a.c.v;
import d.l.a.d.b.c;
import d.l.a.d.c;
import d.l.a.e.a.d;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile g f71935f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f71936a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.l.a.d.b.h> f71937b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.l.a.d.b.h> f71938c;

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f71939d;

    /* renamed from: e  reason: collision with root package name */
    public long f71940e;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.d f71941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.b f71942f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.c f71943g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f71944h;

        public a(g gVar, d.l.a.a.a.d.d dVar, d.l.a.a.a.d.b bVar, d.l.a.a.a.d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, dVar, bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71944h = gVar;
            this.f71941e = dVar;
            this.f71942f = bVar;
            this.f71943g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f71944h.f71939d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).a(this.f71941e, this.f71942f, this.f71943g);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).a(this.f71941e, this.f71942f, this.f71943g);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f71945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseException f71946f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f71947g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f71948h;

        public b(g gVar, DownloadInfo downloadInfo, BaseException baseException, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, downloadInfo, baseException, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71948h = gVar;
            this.f71945e = downloadInfo;
            this.f71946f = baseException;
            this.f71947g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f71948h.f71939d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).a(this.f71945e, this.f71946f, this.f71947g);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).a(this.f71945e, this.f71946f, this.f71947g);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f71949e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f71950f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f71951g;

        public c(g gVar, DownloadInfo downloadInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, downloadInfo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71951g = gVar;
            this.f71949e = downloadInfo;
            this.f71950f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f71951g.f71939d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).a(this.f71949e, this.f71950f);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).a(this.f71949e, this.f71950f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f71952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f71953f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f71954g;

        public d(g gVar, DownloadInfo downloadInfo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, downloadInfo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71954g = gVar;
            this.f71952e = downloadInfo;
            this.f71953f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f71954g.f71939d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).b(this.f71952e, this.f71953f);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).b(this.f71952e, this.f71953f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f71955e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f71956f;

        public e(g gVar, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71956f = gVar;
            this.f71955e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f71956f.f71939d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).a(this.f71955e);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).a(this.f71955e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public class a implements d.l.a.d.i.a.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.k f71957a;

            public a(f fVar, d.k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71957a = kVar;
            }

            @Override // d.l.a.d.i.a.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f71957a.a();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements d.l.a.d.i.a.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f71958a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.l.a.d.i.a.a f71959b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ f f71960c;

            public b(f fVar, DownloadInfo downloadInfo, d.l.a.d.i.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, downloadInfo, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71960c = fVar;
                this.f71958a = downloadInfo;
                this.f71959b = aVar;
            }

            @Override // d.l.a.d.i.a.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f71960c.d(this.f71958a, this.f71959b);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements d.l.a.d.i.a.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.l.a.d.i.a.a f71961a;

            public c(f fVar, d.l.a.d.i.a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71961a = aVar;
            }

            @Override // d.l.a.d.i.a.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f71961a.a();
                }
            }
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.l.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, downloadInfo, kVar) == null) {
                c(downloadInfo, new a(this, kVar));
            }
        }

        public void c(DownloadInfo downloadInfo, @NonNull d.l.a.d.i.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, aVar) == null) {
                d.l.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                if (c2 != null && c.l.a(c2)) {
                    TTDelegateActivity.a(c2, new b(this, downloadInfo, aVar));
                } else {
                    d(downloadInfo, aVar);
                }
            }
        }

        public final void d(DownloadInfo downloadInfo, @NonNull d.l.a.d.i.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, aVar) == null) {
                d.l.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                boolean c3 = c.i.c(c2);
                boolean e2 = c.i.e(c2);
                if (c3 && e2) {
                    c.f.a(c2, new c(this, aVar));
                } else {
                    aVar.a();
                }
            }
        }
    }

    /* renamed from: d.l.a.d.g$g  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C2031g implements d.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2031g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.l.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            d.l.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, downloadInfo, kVar) == null) {
                if (downloadInfo != null && (c2 = c.g.e().c(downloadInfo)) != null) {
                    downloadInfo.setLinkMode(c2.L());
                }
                if (kVar != null) {
                    kVar.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements d.l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static volatile h f71962b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d.l> f71963a;

        /* loaded from: classes8.dex */
        public class a implements d.k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f71964a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f71965b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d.k f71966c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ h f71967d;

            public a(h hVar, int i2, DownloadInfo downloadInfo, d.k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Integer.valueOf(i2), downloadInfo, kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71967d = hVar;
                this.f71964a = i2;
                this.f71965b = downloadInfo;
                this.f71966c = kVar;
            }

            @Override // d.l.a.e.a.d.k
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f71967d.d(this.f71965b, this.f71964a + 1, this.f71966c);
                }
            }
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.f71963a = arrayList;
            arrayList.add(new C2031g());
            this.f71963a.add(new f());
        }

        public static h b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f71962b == null) {
                    synchronized (h.class) {
                        if (f71962b == null) {
                            f71962b = new h();
                        }
                    }
                }
                return f71962b;
            }
            return (h) invokeV.objValue;
        }

        @Override // d.l.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, downloadInfo, kVar) == null) {
                if (downloadInfo != null && this.f71963a.size() != 0) {
                    d(downloadInfo, 0, kVar);
                } else if (kVar != null) {
                    kVar.a();
                }
            }
        }

        public final void d(DownloadInfo downloadInfo, int i2, d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, i2, kVar) == null) {
                if (i2 != this.f71963a.size() && i2 >= 0) {
                    this.f71963a.get(i2).a(downloadInfo, new a(this, i2, downloadInfo, kVar));
                } else {
                    kVar.a();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(179570887, "Ld/l/a/d/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(179570887, "Ld/l/a/d/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71937b = new CopyOnWriteArrayList();
        this.f71938c = new ConcurrentHashMap();
        this.f71939d = new CopyOnWriteArrayList<>();
        this.f71936a = new Handler(Looper.getMainLooper());
    }

    public static g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f71935f == null) {
                synchronized (g.class) {
                    if (f71935f == null) {
                        f71935f = new g();
                    }
                }
            }
            return f71935f;
        }
        return (g) invokeV.objValue;
    }

    public d.l.a.d.b.g a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map<String, d.l.a.d.b.h> map = this.f71938c;
            if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
                d.l.a.d.b.h hVar = this.f71938c.get(str);
                if (hVar instanceof d.l.a.d.b.g) {
                    return (d.l.a.d.b.g) hVar;
                }
            }
            return null;
        }
        return (d.l.a.d.b.g) invokeL.objValue;
    }

    public void d(Context context, int i2, d.l.a.a.a.d.e eVar, d.l.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, eVar, dVar) == null) || dVar == null || TextUtils.isEmpty(dVar.a())) {
            return;
        }
        d.l.a.d.b.h hVar = this.f71938c.get(dVar.a());
        if (hVar != null) {
            hVar.b(context).f(i2, eVar).c(dVar).a();
        } else if (!this.f71937b.isEmpty()) {
            o(context, i2, eVar, dVar);
        } else {
            r(context, i2, eVar, dVar);
        }
    }

    public void e(d.l.a.a.a.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        if (d.l.a.e.b.j.a.r().q("fix_listener_oom", false)) {
            this.f71939d.add(new SoftReference(aVar));
        } else {
            this.f71939d.add(aVar);
        }
    }

    public void f(d.l.a.a.a.d.d dVar, @Nullable d.l.a.a.a.d.b bVar, @Nullable d.l.a.a.a.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, dVar, bVar, cVar) == null) {
            this.f71936a.post(new a(this, dVar, bVar, cVar));
        }
    }

    public void g(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
            this.f71936a.post(new e(this, downloadInfo));
        }
    }

    public void h(DownloadInfo downloadInfo, BaseException baseException, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, downloadInfo, baseException, str) == null) {
            this.f71936a.post(new b(this, downloadInfo, baseException, str));
        }
    }

    public void i(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, downloadInfo, str) == null) {
            this.f71936a.post(new c(this, downloadInfo, str));
        }
    }

    public void j(String str, int i2) {
        d.l.a.d.b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || TextUtils.isEmpty(str) || (hVar = this.f71938c.get(str)) == null) {
            return;
        }
        if (hVar.a(i2)) {
            this.f71937b.add(hVar);
            this.f71938c.remove(str);
        }
        q();
    }

    public void k(String str, long j, int i2, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), cVar, bVar}) == null) {
            l(str, j, i2, cVar, bVar, null, null);
        }
    }

    public void l(String str, long j, int i2, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar, v vVar, n nVar) {
        d.l.a.d.b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), cVar, bVar, vVar, nVar}) == null) || TextUtils.isEmpty(str) || (hVar = this.f71938c.get(str)) == null) {
            return;
        }
        hVar.a(j).b(cVar).a(bVar).d(vVar).e(nVar).b(i2);
    }

    public void m(String str, boolean z) {
        d.l.a.d.b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) || TextUtils.isEmpty(str) || (hVar = this.f71938c.get(str)) == null) {
            return;
        }
        hVar.a(z);
    }

    public Handler n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f71936a : (Handler) invokeV.objValue;
    }

    public final synchronized void o(Context context, int i2, d.l.a.a.a.d.e eVar, d.l.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048588, this, context, i2, eVar, dVar) == null) {
            synchronized (this) {
                if (this.f71937b.size() <= 0) {
                    r(context, i2, eVar, dVar);
                } else {
                    d.l.a.d.b.h remove = this.f71937b.remove(0);
                    remove.b(context).f(i2, eVar).c(dVar).a();
                    this.f71938c.put(dVar.a(), remove);
                }
            }
        }
    }

    public void p(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, downloadInfo, str) == null) {
            this.f71936a.post(new d(this, downloadInfo, str));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f71940e < 300000) {
                return;
            }
            this.f71940e = currentTimeMillis;
            if (this.f71937b.isEmpty()) {
                return;
            }
            s();
        }
    }

    public final void r(Context context, int i2, d.l.a.a.a.d.e eVar, d.l.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048591, this, context, i2, eVar, dVar) == null) || dVar == null) {
            return;
        }
        d.l.a.d.b.g gVar = new d.l.a.d.b.g();
        gVar.b(context);
        gVar.f(i2, eVar);
        gVar.c(dVar);
        gVar.a();
        this.f71938c.put(dVar.a(), gVar);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (d.l.a.d.b.h hVar : this.f71937b) {
                if (!hVar.b() && currentTimeMillis - hVar.d() > 300000) {
                    hVar.h();
                    arrayList.add(hVar);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f71937b.removeAll(arrayList);
        }
    }
}
