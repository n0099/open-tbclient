package d.a.n0.a.r0;

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
    public d.a.n0.a.r0.f f46902a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.a.l0.a f46903b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.a.r0.i f46904c;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f46906f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46907g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f46908h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.r0.o.b f46909i;
        public final /* synthetic */ e j;

        /* renamed from: d.a.n0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0872a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46910e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f46911f;

            public RunnableC0872a(a aVar, d.a.n0.a.r0.c cVar) {
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
                this.f46911f = aVar;
                this.f46910e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46911f.f46907g), "dirPath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46910e, "mkdir:", this.f46911f.f46908h);
                    a aVar = this.f46911f;
                    if (d.a.n0.a.r0.n.a(t, aVar.f46909i, hashMap, aVar.j.f46903b)) {
                        d.a.n0.a.r0.o.b bVar = this.f46911f.f46909i;
                        bVar.errMsg = "mkdir:" + this.f46910e.f46895b;
                        a aVar2 = this.f46911f;
                        d.a.n0.a.r0.n.b(aVar2.f46909i, aVar2.f46908h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46905e = str;
            this.f46906f = bool;
            this.f46907g = i2;
            this.f46908h = map;
            this.f46909i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f46903b.runOnJSThread(new RunnableC0872a(this, this.j.f46902a.o(this.f46905e, this.f46906f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46913f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46914g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46915h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f46916i;
        public final /* synthetic */ d.a.n0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46917e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f46918f;

            public a(b bVar, d.a.n0.a.r0.c cVar) {
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
                this.f46918f = bVar;
                this.f46917e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46918f.f46914g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f46918f.f46915h), "destPath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46917e, "copyFile:", this.f46918f.f46916i);
                    b bVar = this.f46918f;
                    if (d.a.n0.a.r0.n.a(t, bVar.j, hashMap, bVar.k.f46903b)) {
                        b bVar2 = this.f46918f;
                        d.a.n0.a.r0.n.b(bVar2.j, bVar2.f46916i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46912e = str;
            this.f46913f = str2;
            this.f46914g = i2;
            this.f46915h = i3;
            this.f46916i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f46903b.runOnJSThread(new a(this, this.k.f46902a.c(this.f46912e, this.f46913f, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46919e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46920f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f46921g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f46922h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f46923i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.n0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46924e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f46925f;

            public a(c cVar, d.a.n0.a.r0.c cVar2) {
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
                this.f46925f = cVar;
                this.f46924e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46925f.k), "filePath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46924e, "appendFile:", this.f46925f.f46922h);
                    c cVar = this.f46925f;
                    if (d.a.n0.a.r0.n.a(t, cVar.l, hashMap, cVar.m.f46903b)) {
                        c cVar2 = this.f46925f;
                        d.a.n0.a.r0.n.b(cVar2.l, cVar2.f46922h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.n0.a.r0.o.b bVar) {
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
            this.f46919e = str;
            this.f46920f = str2;
            this.f46921g = bArr;
            this.f46922h = map;
            this.f46923i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.r0.c b2 = this.m.f46902a.b(this.f46919e, TextUtils.isEmpty(this.f46920f) ? this.f46921g : this.f46920f, d.a.n0.a.r0.n.F("encoding", this.f46922h), false);
                if (!TextUtils.isEmpty(this.f46923i)) {
                    b2.f46895b = this.f46923i;
                    b2.f46894a = -2;
                    d.a.n0.a.r0.n.d(this.m.f46903b, this.f46923i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f46895b = "fail encoding must be a string";
                        b2.f46894a = -2;
                        d.a.n0.a.r0.n.d(this.m.f46903b, b2.f46895b);
                    }
                }
                this.m.f46903b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46927f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46928g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.r0.o.b f46929h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f46930i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46931e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f46932f;

            public a(d dVar, d.a.n0.a.r0.c cVar) {
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
                this.f46932f = dVar;
                this.f46931e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46932f.f46927f), "path");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46931e, "access:", this.f46932f.f46928g);
                    d dVar = this.f46932f;
                    if (d.a.n0.a.r0.n.a(t, dVar.f46929h, hashMap, dVar.f46930i.f46903b)) {
                        d dVar2 = this.f46932f;
                        d.a.n0.a.r0.n.b(dVar2.f46929h, dVar2.f46928g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46930i = eVar;
            this.f46926e = str;
            this.f46927f = i2;
            this.f46928g = map;
            this.f46929h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46930i.f46903b.runOnJSThread(new a(this, this.f46930i.f46902a.a(this.f46926e, false)));
            }
        }
    }

    /* renamed from: d.a.n0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0873e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46933e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46934f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46935g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.r0.o.b f46936h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f46937i;

        /* renamed from: d.a.n0.a.r0.e$e$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46938e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0873e f46939f;

            public a(RunnableC0873e runnableC0873e, d.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0873e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46939f = runnableC0873e;
                this.f46938e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46939f.f46934f), "path");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46938e, "stat:", this.f46939f.f46935g);
                    RunnableC0873e runnableC0873e = this.f46939f;
                    if (d.a.n0.a.r0.n.a(t, runnableC0873e.f46936h, hashMap, runnableC0873e.f46937i.f46903b)) {
                        d.a.n0.a.r0.o.h hVar = new d.a.n0.a.r0.o.h();
                        d.a.n0.a.r0.c cVar = this.f46938e;
                        hVar.stats = cVar.f46897d;
                        hVar.errMsg = cVar.f46895b;
                        d.a.n0.a.r0.n.b(hVar, this.f46939f.f46935g);
                    }
                }
            }
        }

        public RunnableC0873e(e eVar, String str, int i2, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46937i = eVar;
            this.f46933e = str;
            this.f46934f = i2;
            this.f46935g = map;
            this.f46936h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46937i.f46903b.runOnJSThread(new a(this, this.f46937i.f46902a.y(this.f46933e, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46940e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46941f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46942g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.r0.o.b f46943h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f46944i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46945e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f46946f;

            public a(f fVar, d.a.n0.a.r0.c cVar) {
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
                this.f46946f = fVar;
                this.f46945e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46946f.f46941f), "filePath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46945e, "getFileInfo:", this.f46946f.f46942g);
                    f fVar = this.f46946f;
                    if (d.a.n0.a.r0.n.a(t, fVar.f46943h, hashMap, fVar.f46944i.f46903b)) {
                        d.a.n0.a.r0.o.c cVar = new d.a.n0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f46945e.f46895b;
                        d.a.n0.a.r0.c cVar2 = this.f46945e;
                        cVar.digest = cVar2.f46900g;
                        cVar.size = (int) cVar2.f46898e;
                        d.a.n0.a.r0.n.b(cVar, this.f46946f.f46942g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46944i = eVar;
            this.f46940e = str;
            this.f46941f = i2;
            this.f46942g = map;
            this.f46943h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46944i.f46903b.runOnJSThread(new a(this, this.f46944i.f46902a.e(this.f46940e)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f46947e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.r0.o.b f46948f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f46949g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46950e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f46951f;

            public a(g gVar, d.a.n0.a.r0.c cVar) {
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
                this.f46951f = gVar;
                this.f46950e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46950e, "getSavedFileList:", this.f46951f.f46947e);
                    g gVar = this.f46951f;
                    if (d.a.n0.a.r0.n.a(t, gVar.f46948f, null, gVar.f46949g.f46903b)) {
                        d.a.n0.a.r0.o.d dVar = new d.a.n0.a.r0.o.d();
                        List<d.a.n0.a.r0.d> list = this.f46950e.f46899f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new d.a.n0.a.r0.d[0] : (d.a.n0.a.r0.d[]) this.f46950e.f46899f.toArray(new d.a.n0.a.r0.d[size]);
                        g gVar2 = this.f46951f;
                        dVar.errMsg = gVar2.f46948f.errMsg;
                        d.a.n0.a.r0.n.b(dVar, gVar2.f46947e);
                    }
                }
            }
        }

        public g(e eVar, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46949g = eVar;
            this.f46947e = map;
            this.f46948f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46949g.f46903b.runOnJSThread(new a(this, this.f46949g.f46902a.i()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46953f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46954g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.r0.o.b f46955h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f46956i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46957e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f46958f;

            public a(h hVar, d.a.n0.a.r0.c cVar) {
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
                this.f46958f = hVar;
                this.f46957e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46958f.f46953f), "filePath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46957e, "removeSavedFile:", this.f46958f.f46954g);
                    h hVar = this.f46958f;
                    if (d.a.n0.a.r0.n.a(t, hVar.f46955h, hashMap, hVar.f46956i.f46903b)) {
                        h hVar2 = this.f46958f;
                        d.a.n0.a.r0.n.b(hVar2.f46955h, hVar2.f46954g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46956i = eVar;
            this.f46952e = str;
            this.f46953f = i2;
            this.f46954g = map;
            this.f46955h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46956i.f46903b.runOnJSThread(new a(this, this.f46956i.f46902a.t(this.f46952e)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46960f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f46961g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f46962h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f46963i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.n0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46964e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f46965f;

            public a(i iVar, d.a.n0.a.r0.c cVar) {
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
                this.f46965f = iVar;
                this.f46964e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46965f.k), "filePath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46964e, "writeFile:", this.f46965f.f46962h);
                    i iVar = this.f46965f;
                    if (d.a.n0.a.r0.n.a(t, iVar.l, hashMap, iVar.m.f46903b)) {
                        d.a.n0.a.r0.o.b bVar = this.f46965f.l;
                        bVar.errMsg = "writeFile:" + this.f46964e.f46895b;
                        i iVar2 = this.f46965f;
                        d.a.n0.a.r0.n.b(iVar2.l, iVar2.f46962h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.n0.a.r0.o.b bVar) {
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
            this.f46959e = str;
            this.f46960f = str2;
            this.f46961g = bArr;
            this.f46962h = map;
            this.f46963i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.r0.c C = this.m.f46902a.C(false, this.f46959e, TextUtils.isEmpty(this.f46960f) ? this.f46961g : this.f46960f, d.a.n0.a.r0.n.F("encoding", this.f46962h));
                if (!TextUtils.isEmpty(this.f46963i)) {
                    C.f46895b = this.f46963i;
                    C.f46894a = -2;
                    d.a.n0.a.r0.n.d(this.m.f46903b, this.f46963i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        C.f46895b = "fail encoding must be a string";
                        C.f46894a = -2;
                        d.a.n0.a.r0.n.d(this.m.f46903b, C.f46895b);
                    }
                }
                this.m.f46903b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46966e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46967f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46968g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.r0.o.b f46969h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f46970i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46971e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f46972f;

            public a(j jVar, d.a.n0.a.r0.c cVar) {
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
                this.f46972f = jVar;
                this.f46971e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46972f.f46967f), "filePath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46971e, "unlink:", this.f46972f.f46968g);
                    j jVar = this.f46972f;
                    if (d.a.n0.a.r0.n.a(t, jVar.f46969h, hashMap, jVar.f46970i.f46903b)) {
                        d.a.n0.a.r0.o.b bVar = this.f46972f.f46969h;
                        bVar.errMsg = "unlink:" + this.f46971e.f46895b;
                        j jVar2 = this.f46972f;
                        d.a.n0.a.r0.n.b(jVar2.f46969h, jVar2.f46968g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46970i = eVar;
            this.f46966e = str;
            this.f46967f = i2;
            this.f46968g = map;
            this.f46969h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46970i.f46903b.runOnJSThread(new a(this, this.f46970i.f46902a.z(this.f46966e, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46973e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46974f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46975g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46976h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f46977i;
        public final /* synthetic */ d.a.n0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46978e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f46979f;

            public a(k kVar, d.a.n0.a.r0.c cVar) {
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
                this.f46979f = kVar;
                this.f46978e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46979f.f46975g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f46979f.f46976h), "targetPath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46978e, "unzip:", this.f46979f.f46977i);
                    k kVar = this.f46979f;
                    if (d.a.n0.a.r0.n.a(t, kVar.j, hashMap, kVar.k.f46903b)) {
                        d.a.n0.a.r0.o.b bVar = this.f46979f.j;
                        bVar.errMsg = "unzip:" + this.f46978e.f46895b;
                        k kVar2 = this.f46979f;
                        d.a.n0.a.r0.n.b(kVar2.j, kVar2.f46977i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46973e = str;
            this.f46974f = str2;
            this.f46975g = i2;
            this.f46976h = i3;
            this.f46977i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f46903b.runOnJSThread(new a(this, this.k.f46902a.A(this.f46973e, this.f46974f)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46980e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46981f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46982g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46983h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f46984i;
        public final /* synthetic */ d.a.n0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46985e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f46986f;

            public a(l lVar, d.a.n0.a.r0.c cVar) {
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
                this.f46986f = lVar;
                this.f46985e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46986f.f46982g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f46986f.f46983h), "filePath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46985e, "saveFile:", this.f46986f.f46984i);
                    l lVar = this.f46986f;
                    if (d.a.n0.a.r0.n.a(t, lVar.j, hashMap, lVar.k.f46903b)) {
                        d.a.n0.a.r0.o.g gVar = new d.a.n0.a.r0.o.g();
                        List<String> list = this.f46985e.f46896c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f46985e.f46895b;
                        d.a.n0.a.r0.n.b(gVar, this.f46986f.f46984i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46980e = str;
            this.f46981f = str2;
            this.f46982g = i2;
            this.f46983h = i3;
            this.f46984i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f46903b.runOnJSThread(new a(this, this.k.f46902a.x(this.f46980e, this.f46981f, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46987e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46988f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f46989g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.r0.o.b f46990h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f46991i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46992e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f46993f;

            public a(m mVar, d.a.n0.a.r0.c cVar) {
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
                this.f46993f = mVar;
                this.f46992e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f46993f.f46988f), "dirPath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46992e, "readdir:", this.f46993f.f46989g);
                    m mVar = this.f46993f;
                    if (d.a.n0.a.r0.n.a(t, mVar.f46990h, hashMap, mVar.f46991i.f46903b)) {
                        d.a.n0.a.r0.o.e eVar = new d.a.n0.a.r0.o.e();
                        List<String> list = this.f46992e.f46896c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f46992e.f46896c.toArray(new String[size]);
                        eVar.errMsg = this.f46992e.f46895b;
                        d.a.n0.a.r0.n.b(eVar, this.f46993f.f46989g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46991i = eVar;
            this.f46987e = str;
            this.f46988f = i2;
            this.f46989g = map;
            this.f46990h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46991i.f46903b.runOnJSThread(new a(this, this.f46991i.f46902a.s(this.f46987e, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f46995f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46996g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f46997h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.r0.o.b f46998i;
        public final /* synthetic */ e j;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f46999e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f47000f;

            public a(n nVar, d.a.n0.a.r0.c cVar) {
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
                this.f47000f = nVar;
                this.f46999e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47000f.f46996g), "dirPath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f46999e, "rmdir:", this.f47000f.f46997h);
                    n nVar = this.f47000f;
                    if (d.a.n0.a.r0.n.a(t, nVar.f46998i, hashMap, nVar.j.f46903b)) {
                        n nVar2 = this.f47000f;
                        d.a.n0.a.r0.n.b(nVar2.f46998i, nVar2.f46997h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f46994e = str;
            this.f46995f = bool;
            this.f46996g = i2;
            this.f46997h = map;
            this.f46998i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f46903b.runOnJSThread(new a(this, this.j.f46902a.v(this.f46994e, this.f46995f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47001e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47002f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47003g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f47004h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f47005i;
        public final /* synthetic */ d.a.n0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f47006e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f47007f;

            public a(o oVar, d.a.n0.a.r0.c cVar) {
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
                this.f47007f = oVar;
                this.f47006e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47007f.f47004h), "filePath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f47006e, "readFile:", this.f47007f.f47005i);
                    o oVar = this.f47007f;
                    if (d.a.n0.a.r0.n.a(t, oVar.j, hashMap, oVar.k.f46903b)) {
                        if (TextUtils.isEmpty(this.f47007f.f47002f)) {
                            d.a.n0.a.r0.o.a aVar = new d.a.n0.a.r0.o.a();
                            d.a.n0.a.r0.c cVar = this.f47006e;
                            if (cVar.f46901h == null) {
                                cVar.f46901h = new byte[0];
                            }
                            byte[] bArr = this.f47006e.f46901h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f47006e.f46895b;
                            d.a.n0.a.r0.n.b(aVar, this.f47007f.f47005i);
                            return;
                        }
                        List<String> list = this.f47006e.f46896c;
                        String str = list != null ? list.get(0) : null;
                        d.a.n0.a.r0.o.f fVar = new d.a.n0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f47006e.f46895b;
                        d.a.n0.a.r0.n.b(fVar, this.f47007f.f47005i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f47001e = str;
            this.f47002f = str2;
            this.f47003g = i2;
            this.f47004h = i3;
            this.f47005i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.r0.c q = this.k.f46902a.q(this.f47001e, this.f47002f, false);
                int i2 = this.f47003g;
                if (i2 != 7 && i2 != 12) {
                    q.f46895b = "fail encoding must be a string";
                    q.f46894a = -2;
                    d.a.n0.a.r0.n.d(this.k.f46903b, q.f46895b);
                }
                this.k.f46903b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47009f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47010g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f47011h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f47012i;
        public final /* synthetic */ d.a.n0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.r0.c f47013e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f47014f;

            public a(p pVar, d.a.n0.a.r0.c cVar) {
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
                this.f47014f = pVar;
                this.f47013e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f47014f.f47010g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f47014f.f47011h), "newPath");
                    d.a.n0.a.r0.b t = d.a.n0.a.r0.n.t(this.f47013e, "rename:", this.f47014f.f47012i);
                    p pVar = this.f47014f;
                    if (d.a.n0.a.r0.n.a(t, pVar.j, hashMap, pVar.k.f46903b)) {
                        p pVar2 = this.f47014f;
                        d.a.n0.a.r0.n.b(pVar2.j, pVar2.f47012i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, d.a.n0.a.r0.o.b bVar) {
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
            this.f47008e = str;
            this.f47009f = str2;
            this.f47010g = i2;
            this.f47011h = i3;
            this.f47012i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f46903b.runOnJSThread(new a(this, this.k.f46902a.u(this.f47008e, this.f47009f, false)));
            }
        }
    }

    public e(d.a.n0.a.l0.a aVar) {
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
        this.f46903b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("path", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("path", G);
            this.f46904c.h(new d(this, F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
            this.f46904c.k(str);
            d.a.n0.a.r0.n.Z(this.f46903b, this.f46902a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("encoding", jsObject);
            int L2 = d.a.n0.a.r0.n.L("filePath", jsObject);
            int L3 = d.a.n0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.a.n0.a.r0.n.u(L3);
            byte[] p2 = d.a.n0.a.r0.n.p(jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("data", G);
            String F2 = d.a.n0.a.r0.n.F("filePath", G);
            this.f46904c.h(new c(this, F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
            this.f46904c.k(str);
            d.a.n0.a.r0.n.Z(this.f46903b, this.f46902a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        d.a.n0.a.k2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
            if (Q != null) {
                lVar = Q.W();
            } else {
                lVar = new d.a.n0.a.r0.l();
            }
            this.f46902a = new d.a.n0.a.r0.f(AppRuntime.getAppContext(), d.a.n0.a.g1.f.V().A(), lVar);
            this.f46904c = d.a.n0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("srcPath", jsObject);
            int L2 = d.a.n0.a.r0.n.L("destPath", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("srcPath", G);
            String F2 = d.a.n0.a.r0.n.F("destPath", G);
            this.f46904c.h(new b(this, F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
            this.f46904c.k(str, str2);
            d.a.n0.a.r0.n.Z(this.f46903b, this.f46902a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("filePath", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("filePath", G);
            this.f46904c.h(new f(this, F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.a.n0.a.r0.o.b bVar;
        Map<String, Object> G;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, (bVar = new d.a.n0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f46904c.h(new g(this, G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("dirPath", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("dirPath", G);
            this.f46904c.h(new a(this, F, (Boolean) d.a.n0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("filePath", jsObject);
            int L2 = d.a.n0.a.r0.n.L("encoding", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("encoding", G);
            String F2 = d.a.n0.a.r0.n.F("filePath", G);
            this.f46904c.h(new o(this, F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
                this.f46904c.k(str);
                d.a.n0.a.r0.c q = this.f46902a.q(str, str2, true);
                d.a.n0.a.r0.n.Z(this.f46903b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.f46894a != 0 || (list = q.f46896c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("dirPath", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("dirPath", G);
            this.f46904c.h(new m(this, F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
                this.f46904c.k(str);
                d.a.n0.a.r0.c s = this.f46902a.s(str, true);
                d.a.n0.a.r0.n.Z(this.f46903b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.f46894a != 0) {
                    return new String[0];
                }
                List<String> list = s.f46896c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f46896c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("filePath", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f46904c.h(new h(this, d.a.n0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("oldPath", jsObject);
            int L2 = d.a.n0.a.r0.n.L("newPath", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("oldPath", G);
            String F2 = d.a.n0.a.r0.n.F("newPath", G);
            this.f46904c.h(new p(this, F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
            this.f46904c.k(str, str2);
            d.a.n0.a.r0.n.Z(this.f46903b, this.f46902a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("dirPath", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("dirPath", G);
            this.f46904c.h(new n(this, F, (Boolean) d.a.n0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = d.a.n0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("tempFilePath", G);
            String F2 = d.a.n0.a.r0.n.F("filePath", G);
            this.f46904c.h(new l(this, F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, d.a.n0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("path", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("path", G);
            this.f46904c.h(new RunnableC0873e(this, F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.a.n0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
                this.f46904c.k(str);
                d.a.n0.a.r0.c y = this.f46902a.y(str, true);
                d.a.n0.a.r0.n.Z(this.f46903b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.f46894a != 0) {
                    return null;
                }
                return y.f46897d;
            }
            return null;
        }
        return (d.a.n0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("filePath", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("filePath", G);
            this.f46904c.h(new j(this, F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
            this.f46904c.k(str);
            d.a.n0.a.r0.n.Z(this.f46903b, this.f46902a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = d.a.n0.a.r0.n.L("targetPath", jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("zipFilePath", G);
            String F2 = d.a.n0.a.r0.n.F("targetPath", G);
            this.f46904c.h(new k(this, F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.n0.a.r0.n.L("filePath", jsObject);
            String u = d.a.n0.a.r0.n.u(d.a.n0.a.r0.n.L("data", jsObject));
            int L2 = d.a.n0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = d.a.n0.a.r0.n.p(jsObject);
            d.a.n0.a.r0.o.b bVar = new d.a.n0.a.r0.o.b();
            Map<String, Object> G = d.a.n0.a.r0.n.G(this.f46902a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.n0.a.r0.n.F("data", G);
            String F2 = d.a.n0.a.r0.n.F("filePath", G);
            this.f46904c.h(new i(this, F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
            this.f46904c.k(str);
            d.a.n0.a.r0.n.Z(this.f46903b, this.f46902a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
            this.f46904c.k(str);
            d.a.n0.a.r0.n.Z(this.f46903b, this.f46902a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
            this.f46904c.k(str);
            d.a.n0.a.r0.n.Z(this.f46903b, this.f46902a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
                this.f46904c.k(str, str2);
                d.a.n0.a.r0.c x = this.f46902a.x(str, str2, true);
                d.a.n0.a.r0.n.Z(this.f46903b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.f46894a != 0 || (list = x.f46896c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
            this.f46904c.k(str);
            d.a.n0.a.r0.n.Z(this.f46903b, this.f46902a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (d.a.n0.a.r0.n.P(this.f46902a, this.f46903b, null, null)) {
                this.f46904c.k(str);
                d.a.n0.a.r0.c q = this.f46902a.q(str, null, true);
                d.a.n0.a.r0.n.Z(this.f46903b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f46901h == null) {
                    q.f46901h = new byte[0];
                }
                byte[] bArr = q.f46901h;
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
