package d.a.t.d.c;

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
import d.a.t.d.a;
import d.a.t.e.a;
import d.a.t.g.d.a;
import d.a.t.h.a;
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
/* loaded from: classes9.dex */
public class a extends d.a.t.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public Context f70189g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f70190h;

    /* renamed from: d.a.t.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class CallableC1926a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f70191e;

        public CallableC1926a(a aVar) {
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
            this.f70191e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f70191e;
                aVar.i(aVar.f70190h);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f70192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f70193f;

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
            this.f70193f = aVar;
            this.f70192e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70193f.f70190h.f70204g == null) {
                    this.f70192e.b(-1, null, null);
                    return;
                }
                this.f70192e.a(this.f70193f.f70190h.f70204g.a(), null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f70194e;

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
            this.f70194e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70194e.b(-1, null, null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1927a> f70195a;

        /* renamed from: d.a.t.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C1927a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f70196a;

            /* renamed from: b  reason: collision with root package name */
            public long f70197b;

            public C1927a(boolean z, long j) {
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
                this.f70196a = z;
                this.f70197b = j;
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
            this.f70195a = new HashMap();
        }

        public C1927a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f70195a.get(str) : (C1927a) invokeL.objValue;
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
                        this.f70195a.put(next, new C1927a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile d.a.t.h.b f70198a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.t.e.b f70199b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f70200c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f70201d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f70202e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.a.t.g.d.a f70203f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f70204g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.a.t.e.a> f70205h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, d.a.t.h.a> f70206i;

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
            this.f70205h = new HashMap();
            this.f70206i = new HashMap();
        }
    }

    /* loaded from: classes9.dex */
    public static class f<T> implements a.d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f70207a;

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
            this.f70207a = cVar;
        }

        @Override // d.a.t.h.a.d
        public void a(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, t, bundle) == null) {
                this.f70207a.a(t, bundle);
            }
        }

        @Override // d.a.t.h.a.d
        public void b(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, exc, bundle) == null) {
                this.f70207a.b(i2, exc, bundle);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1928a> f70208a;

        /* renamed from: d.a.t.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C1928a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f70209a;

            public C1928a(boolean z) {
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
                this.f70209a = z;
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
            this.f70208a = new HashMap();
        }

        public C1928a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f70208a.get(str) : (C1928a) invokeL.objValue;
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
                        this.f70208a.put(next, new C1928a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.C1937a f70210a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f70211b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f70212c;

        public h(a.C1937a c1937a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1937a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70210a = c1937a;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f70210a.a();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f70210a.d("lock"));
                    this.f70211b = fileOutputStream;
                    this.f70212c = fileOutputStream.getChannel().lock();
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
                FileLock fileLock = this.f70212c;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        FileOutputStream fileOutputStream = this.f70211b;
                        if (fileOutputStream != null) {
                            d.a.t.g.c.a.c.b(fileOutputStream);
                            this.f70211b = null;
                        }
                        this.f70212c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.f70211b;
                        if (fileOutputStream2 != null) {
                            d.a.t.g.c.a.c.b(fileOutputStream2);
                            this.f70211b = null;
                        }
                        this.f70212c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.f70211b;
                        if (fileOutputStream3 != null) {
                            d.a.t.g.c.a.c.b(fileOutputStream3);
                            this.f70211b = null;
                        }
                        this.f70212c = null;
                        throw th;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f70213a;

        /* renamed from: b  reason: collision with root package name */
        public String f70214b;

        /* renamed from: c  reason: collision with root package name */
        public long f70215c;

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
            this.f70213a = str;
            this.f70214b = str2;
            this.f70215c = j;
        }
    }

    /* loaded from: classes9.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<i> f70216a;

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
            this.f70216a = new ArrayList();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (i iVar : this.f70216a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pkg", iVar.f70213a);
                        jSONObject.put("aid", iVar.f70214b);
                        jSONObject.put("priority", iVar.f70215c);
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
                this.f70216a.add(new i(str, str2, j));
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

    @Override // d.a.t.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            h();
            d.a.t.h.a aVar = this.f70190h.f70206i.get(str);
            if (aVar != null) {
                aVar.g(new f(cVar));
                return;
            }
            if ("sids".equals(str)) {
                executorService = this.f70179e.f70184d;
                cVar2 = new b(this, cVar);
            } else {
                executorService = this.f70179e.f70184d;
                cVar2 = new c(this, cVar);
            }
            executorService.submit(cVar2);
        }
    }

    @Override // d.a.t.d.a
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            h();
            List<TrustSubject> list = this.f70190h.f70201d.f6341a;
            if (list != null) {
                for (TrustSubject trustSubject : list) {
                    if (trustSubject.f6320a.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.t.d.a
    public void e(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f70189g = this.f70179e.f70183c;
            this.f70190h = new e();
            this.f70190h.f70202e = this.f70179e.f70184d.submit(new CallableC1926a(this));
        }
    }

    @Override // d.a.t.d.a
    public a.d f(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            h();
            d.a.t.h.a aVar = this.f70190h.f70206i.get(str);
            return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
        }
        return (a.d) invokeLL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                this.f70190h.f70202e.get();
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
            d.a.t.g.d.a aVar = new d.a.t.g.d.a(this.f70189g);
            eVar.f70203f = aVar;
            h hVar = new h(aVar.d().f("init"));
            try {
                hVar.a();
                TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
                aVar2.f6338a = this.f70189g;
                aVar2.f6339b = aVar;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                eVar.f70200c = trustSubjectManager;
                trustSubjectManager.f(aVar2);
                trustSubjectManager.i(new TrustSubjectManager.b());
                eVar.f70201d = trustSubjectManager.j(new TrustSubjectManager.c());
                d.a.t.h.b bVar = new d.a.t.h.b(this.f70179e.f70181a);
                eVar.f70198a = bVar;
                a.b bVar2 = new a.b();
                bVar2.f70391a = this.f70189g;
                bVar2.f70392b = aVar;
                bVar2.f70393c = eVar.f70201d;
                bVar2.f70394d = this.f70179e.f70184d;
                bVar2.f70395e = this.f70179e.f70185e;
                a.c cVar = new a.c();
                cVar.f70396a = false;
                List<d.a.t.h.a> b2 = bVar.b();
                ArrayList<d.a.t.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (eVar.f70201d.f6342b != null) {
                    gVar = new g();
                    gVar.b(eVar.f70201d.f6342b);
                } else {
                    gVar = null;
                }
                if (arrayList.size() > 0 && gVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        g.C1928a a2 = gVar.a(((d.a.t.h.a) it.next()).e());
                        if (a2 != null && !a2.f70209a) {
                            it.remove();
                        }
                    }
                }
                for (d.a.t.h.a aVar3 : arrayList) {
                    eVar.f70206i.put(aVar3.e(), aVar3);
                    aVar3.a(bVar2);
                    aVar3.f(cVar);
                }
                d.a.t.e.b bVar3 = new d.a.t.e.b(this.f70179e.f70182b);
                eVar.f70199b = bVar3;
                a.b bVar4 = new a.b();
                bVar4.f70231a = this.f70189g;
                bVar4.f70233c = bVar;
                bVar4.f70232b = aVar;
                List<d.a.t.e.a> a3 = bVar3.a();
                ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
                if (arrayList2.size() > 0 && eVar.f70201d.f6342b != null) {
                    d dVar = new d();
                    dVar.b(eVar.f70201d.f6342b);
                    Iterator<d.a.t.e.a> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        d.a.t.e.a next = it2.next();
                        d.C1927a a4 = dVar.a(next.c());
                        if (a4 != null) {
                            if (!a4.f70196a) {
                                it2.remove();
                            } else if (a4.f70197b > -1) {
                                next.g(a4.f70197b);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, d.a.t.e.a.f70226e);
                a.d dVar2 = new a.d();
                a.e eVar2 = new a.e();
                for (d.a.t.e.a aVar4 : arrayList2) {
                    eVar.f70205h.put(aVar4.c(), aVar4);
                    aVar4.a(bVar4);
                    aVar4.e(dVar2);
                    aVar4.f(eVar2);
                }
                g.C1928a a5 = gVar != null ? gVar.a("sids") : null;
                if (a5 == null || a5.f70209a) {
                    j(eVar, arrayList2);
                }
            } finally {
                hVar.b();
            }
        }
    }

    public final void j(e eVar, List<d.a.t.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, list) == null) {
            List<TrustSubject> list2 = eVar.f70201d.f6341a;
            a.g gVar = new a.g();
            gVar.f70237a = true;
            eVar.f70204g = new j();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<d.a.t.e.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a.h b2 = it.next().b(trustSubject.f6320a, gVar);
                        if (b2 != null && b2.d()) {
                            eVar.f70204g.b(trustSubject.f6320a, b2.f70238a, trustSubject.o());
                            break;
                        }
                    }
                }
            }
        }
    }
}
