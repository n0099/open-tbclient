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
/* loaded from: classes10.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile g f74429f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f74430a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.l.a.d.b.h> f74431b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.l.a.d.b.h> f74432c;

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f74433d;

    /* renamed from: e  reason: collision with root package name */
    public long f74434e;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.d f74435e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.b f74436f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.c f74437g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f74438h;

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
            this.f74438h = gVar;
            this.f74435e = dVar;
            this.f74436f = bVar;
            this.f74437g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f74438h.f74433d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).a(this.f74435e, this.f74436f, this.f74437g);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).a(this.f74435e, this.f74436f, this.f74437g);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f74439e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseException f74440f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f74441g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f74442h;

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
            this.f74442h = gVar;
            this.f74439e = downloadInfo;
            this.f74440f = baseException;
            this.f74441g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f74442h.f74433d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).a(this.f74439e, this.f74440f, this.f74441g);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).a(this.f74439e, this.f74440f, this.f74441g);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f74443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f74444f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f74445g;

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
            this.f74445g = gVar;
            this.f74443e = downloadInfo;
            this.f74444f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f74445g.f74433d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).a(this.f74443e, this.f74444f);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).a(this.f74443e, this.f74444f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f74446e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f74447f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f74448g;

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
            this.f74448g = gVar;
            this.f74446e = downloadInfo;
            this.f74447f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f74448g.f74433d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).b(this.f74446e, this.f74447f);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).b(this.f74446e, this.f74447f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f74449e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f74450f;

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
            this.f74450f = gVar;
            this.f74449e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.f74450f.f74433d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof d.l.a.a.a.d.a.a) {
                        ((d.l.a.a.a.d.a.a) next).a(this.f74449e);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof d.l.a.a.a.d.a.a) {
                            ((d.l.a.a.a.d.a.a) softReference.get()).a(this.f74449e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements d.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public class a implements d.l.a.d.i.a.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.k f74451a;

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
                this.f74451a = kVar;
            }

            @Override // d.l.a.d.i.a.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f74451a.a();
                }
            }
        }

        /* loaded from: classes10.dex */
        public class b implements d.l.a.d.i.a.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f74452a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.l.a.d.i.a.a f74453b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ f f74454c;

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
                this.f74454c = fVar;
                this.f74452a = downloadInfo;
                this.f74453b = aVar;
            }

            @Override // d.l.a.d.i.a.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f74454c.d(this.f74452a, this.f74453b);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class c implements d.l.a.d.i.a.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.l.a.d.i.a.a f74455a;

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
                this.f74455a = aVar;
            }

            @Override // d.l.a.d.i.a.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f74455a.a();
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
    /* loaded from: classes10.dex */
    public class C2064g implements d.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2064g() {
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

    /* loaded from: classes10.dex */
    public class h implements d.l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static volatile h f74456b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d.l> f74457a;

        /* loaded from: classes10.dex */
        public class a implements d.k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f74458a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f74459b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d.k f74460c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ h f74461d;

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
                this.f74461d = hVar;
                this.f74458a = i2;
                this.f74459b = downloadInfo;
                this.f74460c = kVar;
            }

            @Override // d.l.a.e.a.d.k
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f74461d.d(this.f74459b, this.f74458a + 1, this.f74460c);
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
            this.f74457a = arrayList;
            arrayList.add(new C2064g());
            this.f74457a.add(new f());
        }

        public static h b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f74456b == null) {
                    synchronized (h.class) {
                        if (f74456b == null) {
                            f74456b = new h();
                        }
                    }
                }
                return f74456b;
            }
            return (h) invokeV.objValue;
        }

        @Override // d.l.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, downloadInfo, kVar) == null) {
                if (downloadInfo != null && this.f74457a.size() != 0) {
                    d(downloadInfo, 0, kVar);
                } else if (kVar != null) {
                    kVar.a();
                }
            }
        }

        public final void d(DownloadInfo downloadInfo, int i2, d.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, i2, kVar) == null) {
                if (i2 != this.f74457a.size() && i2 >= 0) {
                    this.f74457a.get(i2).a(downloadInfo, new a(this, i2, downloadInfo, kVar));
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
        this.f74431b = new CopyOnWriteArrayList();
        this.f74432c = new ConcurrentHashMap();
        this.f74433d = new CopyOnWriteArrayList<>();
        this.f74430a = new Handler(Looper.getMainLooper());
    }

    public static g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f74429f == null) {
                synchronized (g.class) {
                    if (f74429f == null) {
                        f74429f = new g();
                    }
                }
            }
            return f74429f;
        }
        return (g) invokeV.objValue;
    }

    public d.l.a.d.b.g a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map<String, d.l.a.d.b.h> map = this.f74432c;
            if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
                d.l.a.d.b.h hVar = this.f74432c.get(str);
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
        d.l.a.d.b.h hVar = this.f74432c.get(dVar.a());
        if (hVar != null) {
            hVar.b(context).f(i2, eVar).c(dVar).a();
        } else if (!this.f74431b.isEmpty()) {
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
            this.f74433d.add(new SoftReference(aVar));
        } else {
            this.f74433d.add(aVar);
        }
    }

    public void f(d.l.a.a.a.d.d dVar, @Nullable d.l.a.a.a.d.b bVar, @Nullable d.l.a.a.a.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, dVar, bVar, cVar) == null) {
            this.f74430a.post(new a(this, dVar, bVar, cVar));
        }
    }

    public void g(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
            this.f74430a.post(new e(this, downloadInfo));
        }
    }

    public void h(DownloadInfo downloadInfo, BaseException baseException, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, downloadInfo, baseException, str) == null) {
            this.f74430a.post(new b(this, downloadInfo, baseException, str));
        }
    }

    public void i(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, downloadInfo, str) == null) {
            this.f74430a.post(new c(this, downloadInfo, str));
        }
    }

    public void j(String str, int i2) {
        d.l.a.d.b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || TextUtils.isEmpty(str) || (hVar = this.f74432c.get(str)) == null) {
            return;
        }
        if (hVar.a(i2)) {
            this.f74431b.add(hVar);
            this.f74432c.remove(str);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), cVar, bVar, vVar, nVar}) == null) || TextUtils.isEmpty(str) || (hVar = this.f74432c.get(str)) == null) {
            return;
        }
        hVar.a(j).b(cVar).a(bVar).d(vVar).e(nVar).b(i2);
    }

    public void m(String str, boolean z) {
        d.l.a.d.b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) || TextUtils.isEmpty(str) || (hVar = this.f74432c.get(str)) == null) {
            return;
        }
        hVar.a(z);
    }

    public Handler n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f74430a : (Handler) invokeV.objValue;
    }

    public final synchronized void o(Context context, int i2, d.l.a.a.a.d.e eVar, d.l.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048588, this, context, i2, eVar, dVar) == null) {
            synchronized (this) {
                if (this.f74431b.size() <= 0) {
                    r(context, i2, eVar, dVar);
                } else {
                    d.l.a.d.b.h remove = this.f74431b.remove(0);
                    remove.b(context).f(i2, eVar).c(dVar).a();
                    this.f74432c.put(dVar.a(), remove);
                }
            }
        }
    }

    public void p(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, downloadInfo, str) == null) {
            this.f74430a.post(new d(this, downloadInfo, str));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f74434e < 300000) {
                return;
            }
            this.f74434e = currentTimeMillis;
            if (this.f74431b.isEmpty()) {
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
        this.f74432c.put(dVar.a(), gVar);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (d.l.a.d.b.h hVar : this.f74431b) {
                if (!hVar.b() && currentTimeMillis - hVar.d() > 300000) {
                    hVar.h();
                    arrayList.add(hVar);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f74431b.removeAll(arrayList);
        }
    }
}
