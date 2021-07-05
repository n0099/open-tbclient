package d.a.q0.a.r0;

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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.r0.f f50204a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.l0.a f50205b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.a.r0.i f50206c;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50207e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f50208f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50209g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f50210h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.r0.o.b f50211i;
        public final /* synthetic */ e j;

        /* renamed from: d.a.q0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0923a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50212e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f50213f;

            public RunnableC0923a(a aVar, d.a.q0.a.r0.c cVar) {
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
                this.f50213f = aVar;
                this.f50212e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50213f.f50209g), "dirPath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50212e, "mkdir:", this.f50213f.f50210h);
                    a aVar = this.f50213f;
                    if (d.a.q0.a.r0.n.a(t, aVar.f50211i, hashMap, aVar.j.f50205b)) {
                        d.a.q0.a.r0.o.b bVar = this.f50213f.f50211i;
                        bVar.errMsg = "mkdir:" + this.f50212e.f50197b;
                        a aVar2 = this.f50213f;
                        d.a.q0.a.r0.n.b(aVar2.f50211i, aVar2.f50210h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50207e = str;
            this.f50208f = bool;
            this.f50209g = i2;
            this.f50210h = map;
            this.f50211i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f50205b.runOnJSThread(new RunnableC0923a(this, this.j.f50204a.o(this.f50207e, this.f50208f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50214e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50215f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50216g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f50217h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f50218i;
        public final /* synthetic */ d.a.q0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50219e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f50220f;

            public a(b bVar, d.a.q0.a.r0.c cVar) {
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
                this.f50220f = bVar;
                this.f50219e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50220f.f50216g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f50220f.f50217h), "destPath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50219e, "copyFile:", this.f50220f.f50218i);
                    b bVar = this.f50220f;
                    if (d.a.q0.a.r0.n.a(t, bVar.j, hashMap, bVar.k.f50205b)) {
                        b bVar2 = this.f50220f;
                        d.a.q0.a.r0.n.b(bVar2.j, bVar2.f50218i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50214e = str;
            this.f50215f = str2;
            this.f50216g = i2;
            this.f50217h = i3;
            this.f50218i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f50205b.runOnJSThread(new a(this, this.k.f50204a.c(this.f50214e, this.f50215f, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50221e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50222f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f50223g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f50224h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f50225i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.q0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50226e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f50227f;

            public a(c cVar, d.a.q0.a.r0.c cVar2) {
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
                this.f50227f = cVar;
                this.f50226e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50227f.k), "filePath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50226e, "appendFile:", this.f50227f.f50224h);
                    c cVar = this.f50227f;
                    if (d.a.q0.a.r0.n.a(t, cVar.l, hashMap, cVar.m.f50205b)) {
                        c cVar2 = this.f50227f;
                        d.a.q0.a.r0.n.b(cVar2.l, cVar2.f50224h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.q0.a.r0.o.b bVar) {
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
            this.f50221e = str;
            this.f50222f = str2;
            this.f50223g = bArr;
            this.f50224h = map;
            this.f50225i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.r0.c b2 = this.m.f50204a.b(this.f50221e, TextUtils.isEmpty(this.f50222f) ? this.f50223g : this.f50222f, d.a.q0.a.r0.n.F("encoding", this.f50224h), false);
                if (!TextUtils.isEmpty(this.f50225i)) {
                    b2.f50197b = this.f50225i;
                    b2.f50196a = -2;
                    d.a.q0.a.r0.n.d(this.m.f50205b, this.f50225i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f50197b = "fail encoding must be a string";
                        b2.f50196a = -2;
                        d.a.q0.a.r0.n.d(this.m.f50205b, b2.f50197b);
                    }
                }
                this.m.f50205b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50229f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f50230g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.r0.o.b f50231h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f50232i;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50233e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f50234f;

            public a(d dVar, d.a.q0.a.r0.c cVar) {
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
                this.f50234f = dVar;
                this.f50233e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50234f.f50229f), "path");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50233e, "access:", this.f50234f.f50230g);
                    d dVar = this.f50234f;
                    if (d.a.q0.a.r0.n.a(t, dVar.f50231h, hashMap, dVar.f50232i.f50205b)) {
                        d dVar2 = this.f50234f;
                        d.a.q0.a.r0.n.b(dVar2.f50231h, dVar2.f50230g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50232i = eVar;
            this.f50228e = str;
            this.f50229f = i2;
            this.f50230g = map;
            this.f50231h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50232i.f50205b.runOnJSThread(new a(this, this.f50232i.f50204a.a(this.f50228e, false)));
            }
        }
    }

    /* renamed from: d.a.q0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0924e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50235e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50236f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f50237g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.r0.o.b f50238h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f50239i;

        /* renamed from: d.a.q0.a.r0.e$e$a */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50240e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0924e f50241f;

            public a(RunnableC0924e runnableC0924e, d.a.q0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0924e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50241f = runnableC0924e;
                this.f50240e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50241f.f50236f), "path");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50240e, "stat:", this.f50241f.f50237g);
                    RunnableC0924e runnableC0924e = this.f50241f;
                    if (d.a.q0.a.r0.n.a(t, runnableC0924e.f50238h, hashMap, runnableC0924e.f50239i.f50205b)) {
                        d.a.q0.a.r0.o.h hVar = new d.a.q0.a.r0.o.h();
                        d.a.q0.a.r0.c cVar = this.f50240e;
                        hVar.stats = cVar.f50199d;
                        hVar.errMsg = cVar.f50197b;
                        d.a.q0.a.r0.n.b(hVar, this.f50241f.f50237g);
                    }
                }
            }
        }

        public RunnableC0924e(e eVar, String str, int i2, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50239i = eVar;
            this.f50235e = str;
            this.f50236f = i2;
            this.f50237g = map;
            this.f50238h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50239i.f50205b.runOnJSThread(new a(this, this.f50239i.f50204a.y(this.f50235e, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50242e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50243f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f50244g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.r0.o.b f50245h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f50246i;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50247e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f50248f;

            public a(f fVar, d.a.q0.a.r0.c cVar) {
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
                this.f50248f = fVar;
                this.f50247e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50248f.f50243f), "filePath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50247e, "getFileInfo:", this.f50248f.f50244g);
                    f fVar = this.f50248f;
                    if (d.a.q0.a.r0.n.a(t, fVar.f50245h, hashMap, fVar.f50246i.f50205b)) {
                        d.a.q0.a.r0.o.c cVar = new d.a.q0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f50247e.f50197b;
                        d.a.q0.a.r0.c cVar2 = this.f50247e;
                        cVar.digest = cVar2.f50202g;
                        cVar.size = (int) cVar2.f50200e;
                        d.a.q0.a.r0.n.b(cVar, this.f50248f.f50244g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50246i = eVar;
            this.f50242e = str;
            this.f50243f = i2;
            this.f50244g = map;
            this.f50245h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50246i.f50205b.runOnJSThread(new a(this, this.f50246i.f50204a.e(this.f50242e)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f50249e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.r0.o.b f50250f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f50251g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50252e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f50253f;

            public a(g gVar, d.a.q0.a.r0.c cVar) {
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
                this.f50253f = gVar;
                this.f50252e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50252e, "getSavedFileList:", this.f50253f.f50249e);
                    g gVar = this.f50253f;
                    if (d.a.q0.a.r0.n.a(t, gVar.f50250f, null, gVar.f50251g.f50205b)) {
                        d.a.q0.a.r0.o.d dVar = new d.a.q0.a.r0.o.d();
                        List<d.a.q0.a.r0.d> list = this.f50252e.f50201f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new d.a.q0.a.r0.d[0] : (d.a.q0.a.r0.d[]) this.f50252e.f50201f.toArray(new d.a.q0.a.r0.d[size]);
                        g gVar2 = this.f50253f;
                        dVar.errMsg = gVar2.f50250f.errMsg;
                        d.a.q0.a.r0.n.b(dVar, gVar2.f50249e);
                    }
                }
            }
        }

        public g(e eVar, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50251g = eVar;
            this.f50249e = map;
            this.f50250f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50251g.f50205b.runOnJSThread(new a(this, this.f50251g.f50204a.i()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50254e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50255f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f50256g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.r0.o.b f50257h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f50258i;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50259e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f50260f;

            public a(h hVar, d.a.q0.a.r0.c cVar) {
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
                this.f50260f = hVar;
                this.f50259e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50260f.f50255f), "filePath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50259e, "removeSavedFile:", this.f50260f.f50256g);
                    h hVar = this.f50260f;
                    if (d.a.q0.a.r0.n.a(t, hVar.f50257h, hashMap, hVar.f50258i.f50205b)) {
                        h hVar2 = this.f50260f;
                        d.a.q0.a.r0.n.b(hVar2.f50257h, hVar2.f50256g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50258i = eVar;
            this.f50254e = str;
            this.f50255f = i2;
            this.f50256g = map;
            this.f50257h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50258i.f50205b.runOnJSThread(new a(this, this.f50258i.f50204a.t(this.f50254e)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50262f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f50263g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f50264h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f50265i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ d.a.q0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50266e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f50267f;

            public a(i iVar, d.a.q0.a.r0.c cVar) {
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
                this.f50267f = iVar;
                this.f50266e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50267f.k), "filePath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50266e, "writeFile:", this.f50267f.f50264h);
                    i iVar = this.f50267f;
                    if (d.a.q0.a.r0.n.a(t, iVar.l, hashMap, iVar.m.f50205b)) {
                        d.a.q0.a.r0.o.b bVar = this.f50267f.l;
                        bVar.errMsg = "writeFile:" + this.f50266e.f50197b;
                        i iVar2 = this.f50267f;
                        d.a.q0.a.r0.n.b(iVar2.l, iVar2.f50264h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, d.a.q0.a.r0.o.b bVar) {
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
            this.f50261e = str;
            this.f50262f = str2;
            this.f50263g = bArr;
            this.f50264h = map;
            this.f50265i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.r0.c C = this.m.f50204a.C(false, this.f50261e, TextUtils.isEmpty(this.f50262f) ? this.f50263g : this.f50262f, d.a.q0.a.r0.n.F("encoding", this.f50264h));
                if (!TextUtils.isEmpty(this.f50265i)) {
                    C.f50197b = this.f50265i;
                    C.f50196a = -2;
                    d.a.q0.a.r0.n.d(this.m.f50205b, this.f50265i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        C.f50197b = "fail encoding must be a string";
                        C.f50196a = -2;
                        d.a.q0.a.r0.n.d(this.m.f50205b, C.f50197b);
                    }
                }
                this.m.f50205b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50268e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50269f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f50270g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.r0.o.b f50271h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f50272i;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50273e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f50274f;

            public a(j jVar, d.a.q0.a.r0.c cVar) {
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
                this.f50274f = jVar;
                this.f50273e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50274f.f50269f), "filePath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50273e, "unlink:", this.f50274f.f50270g);
                    j jVar = this.f50274f;
                    if (d.a.q0.a.r0.n.a(t, jVar.f50271h, hashMap, jVar.f50272i.f50205b)) {
                        d.a.q0.a.r0.o.b bVar = this.f50274f.f50271h;
                        bVar.errMsg = "unlink:" + this.f50273e.f50197b;
                        j jVar2 = this.f50274f;
                        d.a.q0.a.r0.n.b(jVar2.f50271h, jVar2.f50270g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50272i = eVar;
            this.f50268e = str;
            this.f50269f = i2;
            this.f50270g = map;
            this.f50271h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50272i.f50205b.runOnJSThread(new a(this, this.f50272i.f50204a.z(this.f50268e, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50276f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50277g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f50278h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f50279i;
        public final /* synthetic */ d.a.q0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50280e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f50281f;

            public a(k kVar, d.a.q0.a.r0.c cVar) {
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
                this.f50281f = kVar;
                this.f50280e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50281f.f50277g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f50281f.f50278h), "targetPath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50280e, "unzip:", this.f50281f.f50279i);
                    k kVar = this.f50281f;
                    if (d.a.q0.a.r0.n.a(t, kVar.j, hashMap, kVar.k.f50205b)) {
                        d.a.q0.a.r0.o.b bVar = this.f50281f.j;
                        bVar.errMsg = "unzip:" + this.f50280e.f50197b;
                        k kVar2 = this.f50281f;
                        d.a.q0.a.r0.n.b(kVar2.j, kVar2.f50279i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50275e = str;
            this.f50276f = str2;
            this.f50277g = i2;
            this.f50278h = i3;
            this.f50279i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f50205b.runOnJSThread(new a(this, this.k.f50204a.A(this.f50275e, this.f50276f)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50284g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f50285h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f50286i;
        public final /* synthetic */ d.a.q0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50287e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f50288f;

            public a(l lVar, d.a.q0.a.r0.c cVar) {
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
                this.f50288f = lVar;
                this.f50287e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50288f.f50284g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f50288f.f50285h), "filePath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50287e, "saveFile:", this.f50288f.f50286i);
                    l lVar = this.f50288f;
                    if (d.a.q0.a.r0.n.a(t, lVar.j, hashMap, lVar.k.f50205b)) {
                        d.a.q0.a.r0.o.g gVar = new d.a.q0.a.r0.o.g();
                        List<String> list = this.f50287e.f50198c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f50287e.f50197b;
                        d.a.q0.a.r0.n.b(gVar, this.f50288f.f50286i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50282e = str;
            this.f50283f = str2;
            this.f50284g = i2;
            this.f50285h = i3;
            this.f50286i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f50205b.runOnJSThread(new a(this, this.k.f50204a.x(this.f50282e, this.f50283f, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50289e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50290f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f50291g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.r0.o.b f50292h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f50293i;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50294e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f50295f;

            public a(m mVar, d.a.q0.a.r0.c cVar) {
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
                this.f50295f = mVar;
                this.f50294e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50295f.f50290f), "dirPath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50294e, "readdir:", this.f50295f.f50291g);
                    m mVar = this.f50295f;
                    if (d.a.q0.a.r0.n.a(t, mVar.f50292h, hashMap, mVar.f50293i.f50205b)) {
                        d.a.q0.a.r0.o.e eVar = new d.a.q0.a.r0.o.e();
                        List<String> list = this.f50294e.f50198c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f50294e.f50198c.toArray(new String[size]);
                        eVar.errMsg = this.f50294e.f50197b;
                        d.a.q0.a.r0.n.b(eVar, this.f50295f.f50291g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50293i = eVar;
            this.f50289e = str;
            this.f50290f = i2;
            this.f50291g = map;
            this.f50292h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50293i.f50205b.runOnJSThread(new a(this, this.f50293i.f50204a.s(this.f50289e, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f50297f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50298g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f50299h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.r0.o.b f50300i;
        public final /* synthetic */ e j;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50301e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f50302f;

            public a(n nVar, d.a.q0.a.r0.c cVar) {
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
                this.f50302f = nVar;
                this.f50301e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50302f.f50298g), "dirPath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50301e, "rmdir:", this.f50302f.f50299h);
                    n nVar = this.f50302f;
                    if (d.a.q0.a.r0.n.a(t, nVar.f50300i, hashMap, nVar.j.f50205b)) {
                        n nVar2 = this.f50302f;
                        d.a.q0.a.r0.n.b(nVar2.f50300i, nVar2.f50299h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50296e = str;
            this.f50297f = bool;
            this.f50298g = i2;
            this.f50299h = map;
            this.f50300i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f50205b.runOnJSThread(new a(this, this.j.f50204a.v(this.f50296e, this.f50297f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50303e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50304f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50305g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f50306h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f50307i;
        public final /* synthetic */ d.a.q0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50308e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f50309f;

            public a(o oVar, d.a.q0.a.r0.c cVar) {
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
                this.f50309f = oVar;
                this.f50308e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50309f.f50306h), "filePath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50308e, "readFile:", this.f50309f.f50307i);
                    o oVar = this.f50309f;
                    if (d.a.q0.a.r0.n.a(t, oVar.j, hashMap, oVar.k.f50205b)) {
                        if (TextUtils.isEmpty(this.f50309f.f50304f)) {
                            d.a.q0.a.r0.o.a aVar = new d.a.q0.a.r0.o.a();
                            d.a.q0.a.r0.c cVar = this.f50308e;
                            if (cVar.f50203h == null) {
                                cVar.f50203h = new byte[0];
                            }
                            byte[] bArr = this.f50308e.f50203h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f50308e.f50197b;
                            d.a.q0.a.r0.n.b(aVar, this.f50309f.f50307i);
                            return;
                        }
                        List<String> list = this.f50308e.f50198c;
                        String str = list != null ? list.get(0) : null;
                        d.a.q0.a.r0.o.f fVar = new d.a.q0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f50308e.f50197b;
                        d.a.q0.a.r0.n.b(fVar, this.f50309f.f50307i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50303e = str;
            this.f50304f = str2;
            this.f50305g = i2;
            this.f50306h = i3;
            this.f50307i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.r0.c q = this.k.f50204a.q(this.f50303e, this.f50304f, false);
                int i2 = this.f50305g;
                if (i2 != 7 && i2 != 12) {
                    q.f50197b = "fail encoding must be a string";
                    q.f50196a = -2;
                    d.a.q0.a.r0.n.d(this.k.f50205b, q.f50197b);
                }
                this.k.f50205b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50310e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50311f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50312g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f50313h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f50314i;
        public final /* synthetic */ d.a.q0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.r0.c f50315e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f50316f;

            public a(p pVar, d.a.q0.a.r0.c cVar) {
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
                this.f50316f = pVar;
                this.f50315e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f50316f.f50312g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f50316f.f50313h), "newPath");
                    d.a.q0.a.r0.b t = d.a.q0.a.r0.n.t(this.f50315e, "rename:", this.f50316f.f50314i);
                    p pVar = this.f50316f;
                    if (d.a.q0.a.r0.n.a(t, pVar.j, hashMap, pVar.k.f50205b)) {
                        p pVar2 = this.f50316f;
                        d.a.q0.a.r0.n.b(pVar2.j, pVar2.f50314i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, d.a.q0.a.r0.o.b bVar) {
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
            this.f50310e = str;
            this.f50311f = str2;
            this.f50312g = i2;
            this.f50313h = i3;
            this.f50314i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f50205b.runOnJSThread(new a(this, this.k.f50204a.u(this.f50310e, this.f50311f, false)));
            }
        }
    }

    public e(d.a.q0.a.l0.a aVar) {
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
        this.f50205b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("path", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("path", G);
            this.f50206c.h(new d(this, F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
            this.f50206c.k(str);
            d.a.q0.a.r0.n.Z(this.f50205b, this.f50204a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("encoding", jsObject);
            int L2 = d.a.q0.a.r0.n.L("filePath", jsObject);
            int L3 = d.a.q0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : d.a.q0.a.r0.n.u(L3);
            byte[] p2 = d.a.q0.a.r0.n.p(jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("data", G);
            String F2 = d.a.q0.a.r0.n.F("filePath", G);
            this.f50206c.h(new c(this, F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
            this.f50206c.k(str);
            d.a.q0.a.r0.n.Z(this.f50205b, this.f50204a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        d.a.q0.a.k2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q != null) {
                lVar = Q.W();
            } else {
                lVar = new d.a.q0.a.r0.l();
            }
            this.f50204a = new d.a.q0.a.r0.f(AppRuntime.getAppContext(), d.a.q0.a.g1.f.V().A(), lVar);
            this.f50206c = d.a.q0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("srcPath", jsObject);
            int L2 = d.a.q0.a.r0.n.L("destPath", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("srcPath", G);
            String F2 = d.a.q0.a.r0.n.F("destPath", G);
            this.f50206c.h(new b(this, F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
            this.f50206c.k(str, str2);
            d.a.q0.a.r0.n.Z(this.f50205b, this.f50204a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("filePath", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("filePath", G);
            this.f50206c.h(new f(this, F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        d.a.q0.a.r0.o.b bVar;
        Map<String, Object> G;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, (bVar = new d.a.q0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f50206c.h(new g(this, G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("dirPath", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("dirPath", G);
            this.f50206c.h(new a(this, F, (Boolean) d.a.q0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("filePath", jsObject);
            int L2 = d.a.q0.a.r0.n.L("encoding", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("encoding", G);
            String F2 = d.a.q0.a.r0.n.F("filePath", G);
            this.f50206c.h(new o(this, F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
                this.f50206c.k(str);
                d.a.q0.a.r0.c q = this.f50204a.q(str, str2, true);
                d.a.q0.a.r0.n.Z(this.f50205b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.f50196a != 0 || (list = q.f50198c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("dirPath", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("dirPath", G);
            this.f50206c.h(new m(this, F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
                this.f50206c.k(str);
                d.a.q0.a.r0.c s = this.f50204a.s(str, true);
                d.a.q0.a.r0.n.Z(this.f50205b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.f50196a != 0) {
                    return new String[0];
                }
                List<String> list = s.f50198c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f50198c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("filePath", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f50206c.h(new h(this, d.a.q0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("oldPath", jsObject);
            int L2 = d.a.q0.a.r0.n.L("newPath", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("oldPath", G);
            String F2 = d.a.q0.a.r0.n.F("newPath", G);
            this.f50206c.h(new p(this, F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
            this.f50206c.k(str, str2);
            d.a.q0.a.r0.n.Z(this.f50205b, this.f50204a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("dirPath", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("dirPath", G);
            this.f50206c.h(new n(this, F, (Boolean) d.a.q0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = d.a.q0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("tempFilePath", G);
            String F2 = d.a.q0.a.r0.n.F("filePath", G);
            this.f50206c.h(new l(this, F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, d.a.q0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("path", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("path", G);
            this.f50206c.h(new RunnableC0924e(this, F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public d.a.q0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
                this.f50206c.k(str);
                d.a.q0.a.r0.c y = this.f50204a.y(str, true);
                d.a.q0.a.r0.n.Z(this.f50205b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.f50196a != 0) {
                    return null;
                }
                return y.f50199d;
            }
            return null;
        }
        return (d.a.q0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("filePath", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("filePath", G);
            this.f50206c.h(new j(this, F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
            this.f50206c.k(str);
            d.a.q0.a.r0.n.Z(this.f50205b, this.f50204a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = d.a.q0.a.r0.n.L("targetPath", jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("zipFilePath", G);
            String F2 = d.a.q0.a.r0.n.F("targetPath", G);
            this.f50206c.h(new k(this, F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = d.a.q0.a.r0.n.L("filePath", jsObject);
            String u = d.a.q0.a.r0.n.u(d.a.q0.a.r0.n.L("data", jsObject));
            int L2 = d.a.q0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = d.a.q0.a.r0.n.p(jsObject);
            d.a.q0.a.r0.o.b bVar = new d.a.q0.a.r0.o.b();
            Map<String, Object> G = d.a.q0.a.r0.n.G(this.f50204a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = d.a.q0.a.r0.n.F("data", G);
            String F2 = d.a.q0.a.r0.n.F("filePath", G);
            this.f50206c.h(new i(this, F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
            this.f50206c.k(str);
            d.a.q0.a.r0.n.Z(this.f50205b, this.f50204a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
            this.f50206c.k(str);
            d.a.q0.a.r0.n.Z(this.f50205b, this.f50204a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
            this.f50206c.k(str);
            d.a.q0.a.r0.n.Z(this.f50205b, this.f50204a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
                this.f50206c.k(str, str2);
                d.a.q0.a.r0.c x = this.f50204a.x(str, str2, true);
                d.a.q0.a.r0.n.Z(this.f50205b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.f50196a != 0 || (list = x.f50198c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
            this.f50206c.k(str);
            d.a.q0.a.r0.n.Z(this.f50205b, this.f50204a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (d.a.q0.a.r0.n.P(this.f50204a, this.f50205b, null, null)) {
                this.f50206c.k(str);
                d.a.q0.a.r0.c q = this.f50204a.q(str, null, true);
                d.a.q0.a.r0.n.Z(this.f50205b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f50203h == null) {
                    q.f50203h = new byte[0];
                }
                byte[] bArr = q.f50203h;
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
