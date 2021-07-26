package d.a.o0.a.r0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.r0.f f47406a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.a.l0.a f47407b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.a.r0.i f47408c;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47409e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f47410f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47411g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f47412h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.r0.o.b f47413i;
        public final /* synthetic */ e j;

        /* renamed from: d.a.o0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0881a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47414e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f47415f;

            public RunnableC0881a(a aVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47415f = aVar;
                this.f47414e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47415f.f47411g), "dirPath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47414e, "mkdir:", this.f47415f.f47412h);
                    a aVar = this.f47415f;
                    if (d.a.o0.a.r0.n.a(t, aVar.f47413i, hashMap, aVar.j.f47407b)) {
                        d.a.o0.a.r0.o.b bVar = this.f47415f.f47413i;
                        bVar.errMsg = "mkdir:" + this.f47414e.f47399b;
                        a aVar2 = this.f47415f;
                        d.a.o0.a.r0.n.b(aVar2.f47413i, aVar2.f47412h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, bool, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = eVar;
            this.f47409e = str;
            this.f47410f = bool;
            this.f47411g = i2;
            this.f47412h = map;
            this.f47413i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f47407b.runOnJSThread(new RunnableC0881a(this, this.j.f47406a.o(this.f47409e, this.f47410f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47417f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47418g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f47419h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f47420i;
        public final /* synthetic */ d.a.o0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47421e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f47422f;

            public a(b bVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47422f = bVar;
                this.f47421e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47422f.f47418g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f47422f.f47419h), "destPath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47421e, "copyFile:", this.f47422f.f47420i);
                    b bVar = this.f47422f;
                    if (d.a.o0.a.r0.n.a(t, bVar.j, hashMap, bVar.k.f47407b)) {
                        b bVar2 = this.f47422f;
                        d.a.o0.a.r0.n.b(bVar2.j, bVar2.f47420i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f47416e = str;
            this.f47417f = str2;
            this.f47418g = i2;
            this.f47419h = i3;
            this.f47420i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f47407b.runOnJSThread(new a(this, this.k.f47406a.c(this.f47416e, this.f47417f, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47424f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f47425g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f47426h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f47427i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.o0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47428e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f47429f;

            public a(c cVar, d.a.o0.a.r0.c cVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47429f = cVar;
                this.f47428e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47429f.k), "filePath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47428e, "appendFile:", this.f47429f.f47426h);
                    c cVar = this.f47429f;
                    if (d.a.o0.a.r0.n.a(t, cVar.l, hashMap, cVar.m.f47407b)) {
                        c cVar2 = this.f47429f;
                        d.a.o0.a.r0.n.b(cVar2.l, cVar2.f47426h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, bArr, map, str3, Integer.valueOf(i2), Integer.valueOf(i3), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = eVar;
            this.f47423e = str;
            this.f47424f = str2;
            this.f47425g = bArr;
            this.f47426h = map;
            this.f47427i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.r0.c b2 = this.m.f47406a.b(this.f47423e, TextUtils.isEmpty(this.f47424f) ? this.f47425g : this.f47424f, d.a.o0.a.r0.n.F("encoding", this.f47426h), false);
                if (!TextUtils.isEmpty(this.f47427i)) {
                    b2.f47399b = this.f47427i;
                    b2.f47398a = -2;
                    d.a.o0.a.r0.n.d(this.m.f47407b, this.f47427i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f47399b = "fail encoding must be a string";
                        b2.f47398a = -2;
                        d.a.o0.a.r0.n.d(this.m.f47407b, b2.f47399b);
                    }
                }
                this.m.f47407b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47430e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47431f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f47432g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.r0.o.b f47433h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f47434i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47435e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f47436f;

            public a(d dVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47436f = dVar;
                this.f47435e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47436f.f47431f), "path");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47435e, "access:", this.f47436f.f47432g);
                    d dVar = this.f47436f;
                    if (d.a.o0.a.r0.n.a(t, dVar.f47433h, hashMap, dVar.f47434i.f47407b)) {
                        d dVar2 = this.f47436f;
                        d.a.o0.a.r0.n.b(dVar2.f47433h, dVar2.f47432g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47434i = eVar;
            this.f47430e = str;
            this.f47431f = i2;
            this.f47432g = map;
            this.f47433h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47434i.f47407b.runOnJSThread(new a(this, this.f47434i.f47406a.a(this.f47430e, false)));
            }
        }
    }

    /* renamed from: d.a.o0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0882e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47437e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47438f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f47439g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.r0.o.b f47440h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f47441i;

        /* renamed from: d.a.o0.a.r0.e$e$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47442e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0882e f47443f;

            public a(RunnableC0882e runnableC0882e, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0882e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47443f = runnableC0882e;
                this.f47442e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47443f.f47438f), "path");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47442e, "stat:", this.f47443f.f47439g);
                    RunnableC0882e runnableC0882e = this.f47443f;
                    if (d.a.o0.a.r0.n.a(t, runnableC0882e.f47440h, hashMap, runnableC0882e.f47441i.f47407b)) {
                        d.a.o0.a.r0.o.h hVar = new d.a.o0.a.r0.o.h();
                        d.a.o0.a.r0.c cVar = this.f47442e;
                        hVar.stats = cVar.f47401d;
                        hVar.errMsg = cVar.f47399b;
                        d.a.o0.a.r0.n.b(hVar, this.f47443f.f47439g);
                    }
                }
            }
        }

        public RunnableC0882e(e eVar, String str, int i2, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47441i = eVar;
            this.f47437e = str;
            this.f47438f = i2;
            this.f47439g = map;
            this.f47440h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47441i.f47407b.runOnJSThread(new a(this, this.f47441i.f47406a.y(this.f47437e, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47445f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f47446g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.r0.o.b f47447h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f47448i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47449e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f47450f;

            public a(f fVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47450f = fVar;
                this.f47449e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47450f.f47445f), "filePath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47449e, "getFileInfo:", this.f47450f.f47446g);
                    f fVar = this.f47450f;
                    if (d.a.o0.a.r0.n.a(t, fVar.f47447h, hashMap, fVar.f47448i.f47407b)) {
                        d.a.o0.a.r0.o.c cVar = new d.a.o0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f47449e.f47399b;
                        d.a.o0.a.r0.c cVar2 = this.f47449e;
                        cVar.digest = cVar2.f47404g;
                        cVar.size = (int) cVar2.f47402e;
                        d.a.o0.a.r0.n.b(cVar, this.f47450f.f47446g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47448i = eVar;
            this.f47444e = str;
            this.f47445f = i2;
            this.f47446g = map;
            this.f47447h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47448i.f47407b.runOnJSThread(new a(this, this.f47448i.f47406a.e(this.f47444e)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f47451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.r0.o.b f47452f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f47453g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47454e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f47455f;

            public a(g gVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47455f = gVar;
                this.f47454e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47454e, "getSavedFileList:", this.f47455f.f47451e);
                    g gVar = this.f47455f;
                    if (d.a.o0.a.r0.n.a(t, gVar.f47452f, null, gVar.f47453g.f47407b)) {
                        d.a.o0.a.r0.o.d dVar = new d.a.o0.a.r0.o.d();
                        List<d.a.o0.a.r0.d> list = this.f47454e.f47403f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new d.a.o0.a.r0.d[0] : (d.a.o0.a.r0.d[]) this.f47454e.f47403f.toArray(new d.a.o0.a.r0.d[size]);
                        g gVar2 = this.f47455f;
                        dVar.errMsg = gVar2.f47452f.errMsg;
                        d.a.o0.a.r0.n.b(dVar, gVar2.f47451e);
                    }
                }
            }
        }

        public g(e eVar, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47453g = eVar;
            this.f47451e = map;
            this.f47452f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47453g.f47407b.runOnJSThread(new a(this, this.f47453g.f47406a.i()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47456e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47457f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f47458g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.r0.o.b f47459h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f47460i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47461e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f47462f;

            public a(h hVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47462f = hVar;
                this.f47461e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47462f.f47457f), "filePath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47461e, "removeSavedFile:", this.f47462f.f47458g);
                    h hVar = this.f47462f;
                    if (d.a.o0.a.r0.n.a(t, hVar.f47459h, hashMap, hVar.f47460i.f47407b)) {
                        h hVar2 = this.f47462f;
                        d.a.o0.a.r0.n.b(hVar2.f47459h, hVar2.f47458g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47460i = eVar;
            this.f47456e = str;
            this.f47457f = i2;
            this.f47458g = map;
            this.f47459h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47460i.f47407b.runOnJSThread(new a(this, this.f47460i.f47406a.t(this.f47456e)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47464f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f47465g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f47466h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f47467i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.o0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47468e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f47469f;

            public a(i iVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47469f = iVar;
                this.f47468e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47469f.k), "filePath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47468e, "writeFile:", this.f47469f.f47466h);
                    i iVar = this.f47469f;
                    if (d.a.o0.a.r0.n.a(t, iVar.l, hashMap, iVar.m.f47407b)) {
                        d.a.o0.a.r0.o.b bVar = this.f47469f.l;
                        bVar.errMsg = "writeFile:" + this.f47468e.f47399b;
                        i iVar2 = this.f47469f;
                        d.a.o0.a.r0.n.b(iVar2.l, iVar2.f47466h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, bArr, map, str3, Integer.valueOf(i2), Integer.valueOf(i3), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = eVar;
            this.f47463e = str;
            this.f47464f = str2;
            this.f47465g = bArr;
            this.f47466h = map;
            this.f47467i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.r0.c C = this.m.f47406a.C(false, this.f47463e, TextUtils.isEmpty(this.f47464f) ? this.f47465g : this.f47464f, d.a.o0.a.r0.n.F("encoding", this.f47466h));
                if (!TextUtils.isEmpty(this.f47467i)) {
                    C.f47399b = this.f47467i;
                    C.f47398a = -2;
                    d.a.o0.a.r0.n.d(this.m.f47407b, this.f47467i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        C.f47399b = "fail encoding must be a string";
                        C.f47398a = -2;
                        d.a.o0.a.r0.n.d(this.m.f47407b, C.f47399b);
                    }
                }
                this.m.f47407b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47470e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47471f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f47472g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.r0.o.b f47473h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f47474i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47475e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f47476f;

            public a(j jVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47476f = jVar;
                this.f47475e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47476f.f47471f), "filePath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47475e, "unlink:", this.f47476f.f47472g);
                    j jVar = this.f47476f;
                    if (d.a.o0.a.r0.n.a(t, jVar.f47473h, hashMap, jVar.f47474i.f47407b)) {
                        d.a.o0.a.r0.o.b bVar = this.f47476f.f47473h;
                        bVar.errMsg = "unlink:" + this.f47475e.f47399b;
                        j jVar2 = this.f47476f;
                        d.a.o0.a.r0.n.b(jVar2.f47473h, jVar2.f47472g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47474i = eVar;
            this.f47470e = str;
            this.f47471f = i2;
            this.f47472g = map;
            this.f47473h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47474i.f47407b.runOnJSThread(new a(this, this.f47474i.f47406a.z(this.f47470e, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47477e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47478f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47479g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f47480h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f47481i;
        public final /* synthetic */ d.a.o0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47482e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f47483f;

            public a(k kVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47483f = kVar;
                this.f47482e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47483f.f47479g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f47483f.f47480h), "targetPath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47482e, "unzip:", this.f47483f.f47481i);
                    k kVar = this.f47483f;
                    if (d.a.o0.a.r0.n.a(t, kVar.j, hashMap, kVar.k.f47407b)) {
                        d.a.o0.a.r0.o.b bVar = this.f47483f.j;
                        bVar.errMsg = "unzip:" + this.f47482e.f47399b;
                        k kVar2 = this.f47483f;
                        d.a.o0.a.r0.n.b(kVar2.j, kVar2.f47481i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f47477e = str;
            this.f47478f = str2;
            this.f47479g = i2;
            this.f47480h = i3;
            this.f47481i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f47407b.runOnJSThread(new a(this, this.k.f47406a.A(this.f47477e, this.f47478f)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47484e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47485f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47486g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f47487h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f47488i;
        public final /* synthetic */ d.a.o0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47489e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f47490f;

            public a(l lVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47490f = lVar;
                this.f47489e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47490f.f47486g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f47490f.f47487h), "filePath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47489e, "saveFile:", this.f47490f.f47488i);
                    l lVar = this.f47490f;
                    if (d.a.o0.a.r0.n.a(t, lVar.j, hashMap, lVar.k.f47407b)) {
                        d.a.o0.a.r0.o.g gVar = new d.a.o0.a.r0.o.g();
                        List<String> list = this.f47489e.f47400c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f47489e.f47399b;
                        d.a.o0.a.r0.n.b(gVar, this.f47490f.f47488i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f47484e = str;
            this.f47485f = str2;
            this.f47486g = i2;
            this.f47487h = i3;
            this.f47488i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f47407b.runOnJSThread(new a(this, this.k.f47406a.x(this.f47484e, this.f47485f, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47491e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47492f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f47493g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.r0.o.b f47494h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f47495i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47496e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f47497f;

            public a(m mVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47497f = mVar;
                this.f47496e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47497f.f47492f), "dirPath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47496e, "readdir:", this.f47497f.f47493g);
                    m mVar = this.f47497f;
                    if (d.a.o0.a.r0.n.a(t, mVar.f47494h, hashMap, mVar.f47495i.f47407b)) {
                        d.a.o0.a.r0.o.e eVar = new d.a.o0.a.r0.o.e();
                        List<String> list = this.f47496e.f47400c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f47496e.f47400c.toArray(new String[size]);
                        eVar.errMsg = this.f47496e.f47399b;
                        d.a.o0.a.r0.n.b(eVar, this.f47497f.f47493g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47495i = eVar;
            this.f47491e = str;
            this.f47492f = i2;
            this.f47493g = map;
            this.f47494h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47495i.f47407b.runOnJSThread(new a(this, this.f47495i.f47406a.s(this.f47491e, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f47499f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47500g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f47501h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.r0.o.b f47502i;
        public final /* synthetic */ e j;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47503e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f47504f;

            public a(n nVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47504f = nVar;
                this.f47503e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47504f.f47500g), "dirPath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47503e, "rmdir:", this.f47504f.f47501h);
                    n nVar = this.f47504f;
                    if (d.a.o0.a.r0.n.a(t, nVar.f47502i, hashMap, nVar.j.f47407b)) {
                        n nVar2 = this.f47504f;
                        d.a.o0.a.r0.n.b(nVar2.f47502i, nVar2.f47501h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, bool, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = eVar;
            this.f47498e = str;
            this.f47499f = bool;
            this.f47500g = i2;
            this.f47501h = map;
            this.f47502i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f47407b.runOnJSThread(new a(this, this.j.f47406a.v(this.f47498e, this.f47499f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47505e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47506f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47507g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f47508h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f47509i;
        public final /* synthetic */ d.a.o0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47510e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f47511f;

            public a(o oVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47511f = oVar;
                this.f47510e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47511f.f47508h), "filePath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47510e, "readFile:", this.f47511f.f47509i);
                    o oVar = this.f47511f;
                    if (d.a.o0.a.r0.n.a(t, oVar.j, hashMap, oVar.k.f47407b)) {
                        if (TextUtils.isEmpty(this.f47511f.f47506f)) {
                            d.a.o0.a.r0.o.a aVar = new d.a.o0.a.r0.o.a();
                            d.a.o0.a.r0.c cVar = this.f47510e;
                            if (cVar.f47405h == null) {
                                cVar.f47405h = new byte[0];
                            }
                            byte[] bArr = this.f47510e.f47405h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f47510e.f47399b;
                            d.a.o0.a.r0.n.b(aVar, this.f47511f.f47509i);
                            return;
                        }
                        List<String> list = this.f47510e.f47400c;
                        String str = list != null ? list.get(0) : null;
                        d.a.o0.a.r0.o.f fVar = new d.a.o0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f47510e.f47399b;
                        d.a.o0.a.r0.n.b(fVar, this.f47511f.f47509i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f47505e = str;
            this.f47506f = str2;
            this.f47507g = i2;
            this.f47508h = i3;
            this.f47509i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.r0.c q = this.k.f47406a.q(this.f47505e, this.f47506f, false);
                int i2 = this.f47507g;
                if (i2 != 7 && i2 != 12) {
                    q.f47399b = "fail encoding must be a string";
                    q.f47398a = -2;
                    d.a.o0.a.r0.n.d(this.k.f47407b, q.f47399b);
                }
                this.k.f47407b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47512e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47513f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47514g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f47515h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f47516i;
        public final /* synthetic */ d.a.o0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.r0.c f47517e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f47518f;

            public a(p pVar, d.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47518f = pVar;
                this.f47517e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47518f.f47514g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f47518f.f47515h), "newPath");
                    d.a.o0.a.r0.b t = d.a.o0.a.r0.n.t(this.f47517e, "rename:", this.f47518f.f47516i);
                    p pVar = this.f47518f;
                    if (d.a.o0.a.r0.n.a(t, pVar.j, hashMap, pVar.k.f47407b)) {
                        p pVar2 = this.f47518f;
                        d.a.o0.a.r0.n.b(pVar2.j, pVar2.f47516i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, d.a.o0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f47512e = str;
            this.f47513f = str2;
            this.f47514g = i2;
            this.f47515h = i3;
            this.f47516i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f47407b.runOnJSThread(new a(this, this.k.f47406a.u(this.f47512e, this.f47513f, false)));
            }
        }
    }

    public e(d.a.o0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47407b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("path", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("path", G);
            this.f47408c.h(new d(this, F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
            this.f47408c.k(str);
            d.a.o0.a.r0.n.Z(this.f47407b, this.f47406a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("encoding", jsObject);
            int L2 = d.a.o0.a.r0.n.L("filePath", jsObject);
            int L3 = d.a.o0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.a.o0.a.r0.n.u(L3);
            byte[] p2 = d.a.o0.a.r0.n.p(jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("data", G);
            String F2 = d.a.o0.a.r0.n.F("filePath", G);
            this.f47408c.h(new c(this, F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
            this.f47408c.k(str);
            d.a.o0.a.r0.n.Z(this.f47407b, this.f47406a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        d.a.o0.a.k2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            if (Q != null) {
                lVar = Q.W();
            } else {
                lVar = new d.a.o0.a.r0.l();
            }
            this.f47406a = new d.a.o0.a.r0.f(AppRuntime.getAppContext(), d.a.o0.a.g1.f.V().A(), lVar);
            this.f47408c = d.a.o0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("srcPath", jsObject);
            int L2 = d.a.o0.a.r0.n.L("destPath", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("srcPath", G);
            String F2 = d.a.o0.a.r0.n.F("destPath", G);
            this.f47408c.h(new b(this, F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
            this.f47408c.k(str, str2);
            d.a.o0.a.r0.n.Z(this.f47407b, this.f47406a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("filePath", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("filePath", G);
            this.f47408c.h(new f(this, F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.a.o0.a.r0.o.b bVar;
        Map<String, Object> G;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, (bVar = new d.a.o0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f47408c.h(new g(this, G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("dirPath", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("dirPath", G);
            this.f47408c.h(new a(this, F, (Boolean) d.a.o0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            mkdirSync(str, false);
        }
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("filePath", jsObject);
            int L2 = d.a.o0.a.r0.n.L("encoding", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("encoding", G);
            String F2 = d.a.o0.a.r0.n.F("filePath", G);
            this.f47408c.h(new o(this, F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
                this.f47408c.k(str);
                d.a.o0.a.r0.c q = this.f47406a.q(str, str2, true);
                d.a.o0.a.r0.n.Z(this.f47407b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.f47398a != 0 || (list = q.f47400c) == null) {
                    return null;
                }
                return list.get(0);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("dirPath", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("dirPath", G);
            this.f47408c.h(new m(this, F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
                this.f47408c.k(str);
                d.a.o0.a.r0.c s = this.f47406a.s(str, true);
                d.a.o0.a.r0.n.Z(this.f47407b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.f47398a != 0) {
                    return new String[0];
                }
                List<String> list = s.f47400c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f47400c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("filePath", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f47408c.h(new h(this, d.a.o0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("oldPath", jsObject);
            int L2 = d.a.o0.a.r0.n.L("newPath", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("oldPath", G);
            String F2 = d.a.o0.a.r0.n.F("newPath", G);
            this.f47408c.h(new p(this, F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
            this.f47408c.k(str, str2);
            d.a.o0.a.r0.n.Z(this.f47407b, this.f47406a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("dirPath", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("dirPath", G);
            this.f47408c.h(new n(this, F, (Boolean) d.a.o0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            rmdirSync(str, false);
        }
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = d.a.o0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("tempFilePath", G);
            String F2 = d.a.o0.a.r0.n.F("filePath", G);
            this.f47408c.h(new l(this, F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, d.a.o0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("path", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("path", G);
            this.f47408c.h(new RunnableC0882e(this, F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.a.o0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
                this.f47408c.k(str);
                d.a.o0.a.r0.c y = this.f47406a.y(str, true);
                d.a.o0.a.r0.n.Z(this.f47407b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.f47398a != 0) {
                    return null;
                }
                return y.f47401d;
            }
            return null;
        }
        return (d.a.o0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("filePath", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("filePath", G);
            this.f47408c.h(new j(this, F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
            this.f47408c.k(str);
            d.a.o0.a.r0.n.Z(this.f47407b, this.f47406a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = d.a.o0.a.r0.n.L("targetPath", jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("zipFilePath", G);
            String F2 = d.a.o0.a.r0.n.F("targetPath", G);
            this.f47408c.h(new k(this, F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.o0.a.r0.n.L("filePath", jsObject);
            String u = d.a.o0.a.r0.n.u(d.a.o0.a.r0.n.L("data", jsObject));
            int L2 = d.a.o0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = d.a.o0.a.r0.n.p(jsObject);
            d.a.o0.a.r0.o.b bVar = new d.a.o0.a.r0.o.b();
            Map<String, Object> G = d.a.o0.a.r0.n.G(this.f47406a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.o0.a.r0.n.F("data", G);
            String F2 = d.a.o0.a.r0.n.F("filePath", G);
            this.f47408c.h(new i(this, F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
            this.f47408c.k(str);
            d.a.o0.a.r0.n.Z(this.f47407b, this.f47406a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
            this.f47408c.k(str);
            d.a.o0.a.r0.n.Z(this.f47407b, this.f47406a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
            this.f47408c.k(str);
            d.a.o0.a.r0.n.Z(this.f47407b, this.f47406a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
                this.f47408c.k(str, str2);
                d.a.o0.a.r0.c x = this.f47406a.x(str, str2, true);
                d.a.o0.a.r0.n.Z(this.f47407b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.f47398a != 0 || (list = x.f47400c) == null) {
                    return null;
                }
                return list.get(0);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            appendFileSync(str, str2, (String) null);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            writeFileSync(str, str2, "");
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, jsArrayBuffer, str2) == null) {
            appendFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
            this.f47408c.k(str);
            d.a.o0.a.r0.n.Z(this.f47407b, this.f47406a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (d.a.o0.a.r0.n.P(this.f47406a, this.f47407b, null, null)) {
                this.f47408c.k(str);
                d.a.o0.a.r0.c q = this.f47406a.q(str, null, true);
                d.a.o0.a.r0.n.Z(this.f47407b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f47405h == null) {
                    q.f47405h = new byte[0];
                }
                byte[] bArr = q.f47405h;
                return new JsArrayBuffer(bArr, bArr.length);
            }
            return null;
        }
        return (JsArrayBuffer) invokeL.objValue;
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jsArrayBuffer) == null) {
            appendFileSync(str, jsArrayBuffer, (String) null);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, str, jsArrayBuffer, str2) == null) {
            writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
        }
    }
}
