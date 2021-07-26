package d.a.s.d.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.d.a;
import d.a.s.e.a;
import d.a.s.g.d.a;
import d.a.s.h.a;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.s.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public Context f67725g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f67726h;

    /* renamed from: d.a.s.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class CallableC1893a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67727e;

        public CallableC1893a(a aVar) {
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
            this.f67727e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f67727e;
                aVar.i(aVar.f67726h);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f67728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67729f;

        public b(a aVar, a.c cVar) {
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
            this.f67729f = aVar;
            this.f67728e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67729f.f67726h.f67740g == null) {
                    this.f67728e.b(-1, null, null);
                    return;
                }
                this.f67728e.a(this.f67729f.f67726h.f67740g.a(), null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f67730e;

        public c(a aVar, a.c cVar) {
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
            this.f67730e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67730e.b(-1, null, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1894a> f67731a;

        /* renamed from: d.a.s.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C1894a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f67732a;

            /* renamed from: b  reason: collision with root package name */
            public long f67733b;

            public C1894a(boolean z, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67732a = z;
                this.f67733b = j;
            }
        }

        public d() {
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
            this.f67731a = new HashMap();
        }

        public C1894a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f67731a.get(str) : (C1894a) invokeL.objValue;
        }

        public void b(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trustSubject) == null) {
                try {
                    String m = trustSubject.m("config-cs");
                    if (TextUtils.isEmpty(m) || (optJSONObject = new JSONObject(m).optJSONObject("cs")) == null) {
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject = optJSONObject.getJSONObject(next);
                        this.f67731a.put(next, new C1894a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile d.a.s.h.b f67734a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.s.e.b f67735b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f67736c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f67737d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f67738e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.a.s.g.d.a f67739f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f67740g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.a.s.e.a> f67741h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, d.a.s.h.a> f67742i;

        public e() {
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
            this.f67741h = new HashMap();
            this.f67742i = new HashMap();
        }
    }

    /* loaded from: classes8.dex */
    public static class f<T> implements a.d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f67743a;

        public f(a.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67743a = cVar;
        }

        @Override // d.a.s.h.a.d
        public void a(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, t, bundle) == null) {
                this.f67743a.a(t, bundle);
            }
        }

        @Override // d.a.s.h.a.d
        public void b(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, exc, bundle) == null) {
                this.f67743a.b(i2, exc, bundle);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1895a> f67744a;

        /* renamed from: d.a.s.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C1895a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f67745a;

            public C1895a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67745a = z;
            }
        }

        public g() {
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
            this.f67744a = new HashMap();
        }

        public C1895a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f67744a.get(str) : (C1895a) invokeL.objValue;
        }

        public void b(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trustSubject) == null) {
                try {
                    String m = trustSubject.m("config-ids");
                    if (TextUtils.isEmpty(m) || (optJSONObject = new JSONObject(m).optJSONObject("ids")) == null) {
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.f67744a.put(next, new C1895a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.C1904a f67746a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f67747b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f67748c;

        public h(a.C1904a c1904a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1904a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67746a = c1904a;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f67746a.a();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f67746a.d("lock"));
                    this.f67747b = fileOutputStream;
                    this.f67748c = fileOutputStream.getChannel().lock();
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                FileLock fileLock = this.f67748c;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        FileOutputStream fileOutputStream = this.f67747b;
                        if (fileOutputStream != null) {
                            d.a.s.g.c.a.c.b(fileOutputStream);
                            this.f67747b = null;
                        }
                        this.f67748c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.f67747b;
                        if (fileOutputStream2 != null) {
                            d.a.s.g.c.a.c.b(fileOutputStream2);
                            this.f67747b = null;
                        }
                        this.f67748c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.f67747b;
                        if (fileOutputStream3 != null) {
                            d.a.s.g.c.a.c.b(fileOutputStream3);
                            this.f67747b = null;
                        }
                        this.f67748c = null;
                        throw th;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f67749a;

        /* renamed from: b  reason: collision with root package name */
        public String f67750b;

        /* renamed from: c  reason: collision with root package name */
        public long f67751c;

        public i(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67749a = str;
            this.f67750b = str2;
            this.f67751c = j;
        }
    }

    /* loaded from: classes8.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<i> f67752a;

        public j() {
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
            this.f67752a = new ArrayList();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (i iVar : this.f67752a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pkg", iVar.f67749a);
                        jSONObject.put("aid", iVar.f67750b);
                        jSONObject.put("priority", iVar.f67751c);
                        jSONArray.put(jSONObject);
                    }
                } catch (Exception unused) {
                }
                return jSONArray.toString();
            }
            return (String) invokeV.objValue;
        }

        public void b(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
                this.f67752a.add(new i(str, str2, j));
            }
        }
    }

    public a() {
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

    @Override // d.a.s.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            h();
            d.a.s.h.a aVar = this.f67726h.f67742i.get(str);
            if (aVar != null) {
                aVar.g(new f(cVar));
                return;
            }
            if ("sids".equals(str)) {
                executorService = this.f67715e.f67720d;
                cVar2 = new b(this, cVar);
            } else {
                executorService = this.f67715e.f67720d;
                cVar2 = new c(this, cVar);
            }
            executorService.submit(cVar2);
        }
    }

    @Override // d.a.s.d.a
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            h();
            List<TrustSubject> list = this.f67726h.f67737d.f6384a;
            if (list != null) {
                for (TrustSubject trustSubject : list) {
                    if (trustSubject.f6363a.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.s.d.a
    public void e(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f67725g = this.f67715e.f67719c;
            this.f67726h = new e();
            this.f67726h.f67738e = this.f67715e.f67720d.submit(new CallableC1893a(this));
        }
    }

    @Override // d.a.s.d.a
    public a.d f(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            h();
            d.a.s.h.a aVar = this.f67726h.f67742i.get(str);
            return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
        }
        return (a.d) invokeLL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                this.f67726h.f67738e.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public final void i(e eVar) {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            d.a.s.g.d.a aVar = new d.a.s.g.d.a(this.f67725g);
            eVar.f67739f = aVar;
            h hVar = new h(aVar.d().f("init"));
            try {
                hVar.a();
                TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
                aVar2.f6381a = this.f67725g;
                aVar2.f6382b = aVar;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                eVar.f67736c = trustSubjectManager;
                trustSubjectManager.f(aVar2);
                trustSubjectManager.i(new TrustSubjectManager.b());
                eVar.f67737d = trustSubjectManager.j(new TrustSubjectManager.c());
                d.a.s.h.b bVar = new d.a.s.h.b(this.f67715e.f67717a);
                eVar.f67734a = bVar;
                a.b bVar2 = new a.b();
                bVar2.f67927a = this.f67725g;
                bVar2.f67928b = aVar;
                bVar2.f67929c = eVar.f67737d;
                bVar2.f67930d = this.f67715e.f67720d;
                bVar2.f67931e = this.f67715e.f67721e;
                a.c cVar = new a.c();
                cVar.f67932a = false;
                List<d.a.s.h.a> b2 = bVar.b();
                ArrayList<d.a.s.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (eVar.f67737d.f6385b != null) {
                    gVar = new g();
                    gVar.b(eVar.f67737d.f6385b);
                } else {
                    gVar = null;
                }
                if (arrayList.size() > 0 && gVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        g.C1895a a2 = gVar.a(((d.a.s.h.a) it.next()).e());
                        if (a2 != null && !a2.f67745a) {
                            it.remove();
                        }
                    }
                }
                for (d.a.s.h.a aVar3 : arrayList) {
                    eVar.f67742i.put(aVar3.e(), aVar3);
                    aVar3.a(bVar2);
                    aVar3.f(cVar);
                }
                d.a.s.e.b bVar3 = new d.a.s.e.b(this.f67715e.f67718b);
                eVar.f67735b = bVar3;
                a.b bVar4 = new a.b();
                bVar4.f67767a = this.f67725g;
                bVar4.f67769c = bVar;
                bVar4.f67768b = aVar;
                List<d.a.s.e.a> a3 = bVar3.a();
                ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
                if (arrayList2.size() > 0 && eVar.f67737d.f6385b != null) {
                    d dVar = new d();
                    dVar.b(eVar.f67737d.f6385b);
                    Iterator<d.a.s.e.a> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        d.a.s.e.a next = it2.next();
                        d.C1894a a4 = dVar.a(next.c());
                        if (a4 != null) {
                            if (!a4.f67732a) {
                                it2.remove();
                            } else if (a4.f67733b > -1) {
                                next.g(a4.f67733b);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, d.a.s.e.a.f67762e);
                a.d dVar2 = new a.d();
                a.e eVar2 = new a.e();
                for (d.a.s.e.a aVar4 : arrayList2) {
                    eVar.f67741h.put(aVar4.c(), aVar4);
                    aVar4.a(bVar4);
                    aVar4.e(dVar2);
                    aVar4.f(eVar2);
                }
                g.C1895a a5 = gVar != null ? gVar.a("sids") : null;
                if (a5 == null || a5.f67745a) {
                    j(eVar, arrayList2);
                }
            } finally {
                hVar.b();
            }
        }
    }

    public final void j(e eVar, List<d.a.s.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, list) == null) {
            List<TrustSubject> list2 = eVar.f67737d.f6384a;
            a.g gVar = new a.g();
            gVar.f67773a = true;
            eVar.f67740g = new j();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<d.a.s.e.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a.h b2 = it.next().b(trustSubject.f6363a, gVar);
                        if (b2 != null && b2.d()) {
                            eVar.f67740g.b(trustSubject.f6363a, b2.f67774a, trustSubject.o());
                            break;
                        }
                    }
                }
            }
        }
    }
}
