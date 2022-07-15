package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d40;
import com.repackage.g40;
import com.repackage.q10;
import com.repackage.x10;
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
/* loaded from: classes7.dex */
public class s10 extends q10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;
    public volatile f d;
    public final Object e;

    /* loaded from: classes7.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s10 a;

        public a(s10 s10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s10Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                s10 s10Var = this.a;
                s10Var.o(s10Var.d);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s10 a;

        public b(s10 s10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s10Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                s10 s10Var = this.a;
                s10Var.j(s10Var.d);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q10.c a;
        public final /* synthetic */ s10 b;

        public c(s10 s10Var, q10.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s10Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s10Var;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.d.h == null) {
                    this.a.a(-1, null, null);
                    return;
                }
                this.a.onResult(this.b.d.h.a(), null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q10.c a;

        public d(s10 s10Var, q10.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s10Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(-1, null, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, a> a;

        /* loaded from: classes7.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;
            public long b;

            public a(boolean z, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = z;
                this.b = j;
            }
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashMap();
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.get(str) : (a) invokeL.objValue;
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
                        this.a.put(next, new a(jSONObject.optBoolean("enable", true), jSONObject.optLong("priority", -1L)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile h40 a;
        public volatile y10 b;
        public volatile TrustSubjectManager c;
        public volatile TrustSubjectManager.d d;
        public volatile Future<Boolean> e;
        public volatile Future<Boolean> f;
        public volatile d40 g;
        public volatile k h;
        public volatile Map<String, x10> i;
        public volatile Map<String, g40> j;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = new HashMap();
            this.j = new HashMap();
        }
    }

    /* loaded from: classes7.dex */
    public static class g<T> implements g40.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public q10.c<T> a;

        public g(q10.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.repackage.g40.c
        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                this.a.a(i, exc, bundle);
            }
        }

        @Override // com.repackage.g40.c
        public void onResult(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                this.a.onResult(t, bundle);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, a> a;

        /* loaded from: classes7.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;

            public a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = z;
            }
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashMap();
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.get(str) : (a) invokeL.objValue;
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
                        this.a.put(next, new a(optJSONObject.getJSONObject(next).optBoolean("enable", true)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d40.a a;
        public FileOutputStream b;
        public FileLock c;

        public i(d40.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.a();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.a.d("lock"));
                    this.b = fileOutputStream;
                    this.c = fileOutputStream.getChannel().lock();
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
                FileLock fileLock = this.c;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        FileOutputStream fileOutputStream = this.b;
                        if (fileOutputStream != null) {
                            y30.b(fileOutputStream);
                            this.b = null;
                        }
                        this.c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.b;
                        if (fileOutputStream2 != null) {
                            y30.b(fileOutputStream2);
                            this.b = null;
                        }
                        this.c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.b;
                        if (fileOutputStream3 != null) {
                            y30.b(fileOutputStream3);
                            this.b = null;
                        }
                        this.c = null;
                        throw th;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public long c;

        public j(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = j;
        }
    }

    /* loaded from: classes7.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<j> a;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (j jVar : this.a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pkg", jVar.a);
                        jSONObject.put("aid", jVar.b);
                        jSONObject.put("priority", jVar.c);
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
                this.a.add(new j(str, str2, j));
            }
        }
    }

    public s10() {
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
        this.e = new Object();
    }

    @Override // com.repackage.q10
    public void a(String str, Bundle bundle, q10.c<String> cVar) {
        ExecutorService executorService;
        Runnable dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            m(str);
            g40 g40Var = this.d.j.get(str);
            if (g40Var != null) {
                g40Var.g(new g(cVar));
                return;
            }
            if ("sids".equals(str)) {
                executorService = this.a.d;
                dVar = new c(this, cVar);
            } else {
                executorService = this.a.d;
                dVar = new d(this, cVar);
            }
            executorService.submit(dVar);
        }
    }

    @Override // com.repackage.q10
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i();
        }
    }

    @Override // com.repackage.q10
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            n();
            List<TrustSubject> list = this.d.d.a;
            if (list != null) {
                for (TrustSubject trustSubject : list) {
                    if (trustSubject.a.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.q10
    public void f(q10.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.c = this.a.c;
            this.d = new f();
            this.d.e = this.a.d.submit(new a(this));
        }
    }

    @Override // com.repackage.q10
    public q10.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            m(str);
            g40 g40Var = this.d.j.get(str);
            return g40Var != null ? q10.d.c(g40Var.c()) : q10.d.a(-1, null);
        }
        return (q10.d) invokeLL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.e) {
                if (this.d.f != null) {
                    return;
                }
                this.d.f = this.a.d.submit(new b(this));
            }
        }
    }

    public final void j(f fVar) {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            d40 d40Var = new d40(this.c);
            fVar.g = d40Var;
            i iVar = new i(d40Var.d().f("init"));
            try {
                iVar.a();
                TrustSubjectManager.a aVar = new TrustSubjectManager.a();
                aVar.a = this.c;
                aVar.b = d40Var;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                fVar.c = trustSubjectManager;
                trustSubjectManager.f(aVar);
                trustSubjectManager.i(new TrustSubjectManager.b());
                fVar.d = trustSubjectManager.query(new TrustSubjectManager.c());
                if (fVar.a == null) {
                    fVar.a = new h40(this.a.a);
                }
                h40 h40Var = fVar.a;
                g40.a aVar2 = new g40.a();
                aVar2.a = this.c;
                aVar2.b = d40Var;
                aVar2.c = fVar.d;
                aVar2.d = this.a.d;
                aVar2.e = this.a.e;
                g40.b bVar = new g40.b();
                bVar.a = false;
                List<g40> b2 = h40Var.b();
                ArrayList<g40> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (fVar.d.b != null) {
                    hVar = new h();
                    hVar.b(fVar.d.b);
                } else {
                    hVar = null;
                }
                if (arrayList.size() > 0 && hVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        h.a a2 = hVar.a(((g40) it.next()).e());
                        if (a2 != null && !a2.a) {
                            it.remove();
                        }
                    }
                }
                for (g40 g40Var : arrayList) {
                    fVar.j.put(g40Var.e(), g40Var);
                    g40Var.a(aVar2);
                    g40Var.f(bVar);
                }
                y10 y10Var = new y10(this.a.b);
                fVar.b = y10Var;
                x10.a aVar3 = new x10.a();
                aVar3.a = this.c;
                aVar3.c = h40Var;
                aVar3.b = d40Var;
                List<x10> a3 = y10Var.a();
                ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
                if (arrayList2.size() > 0 && fVar.d.b != null) {
                    e eVar = new e();
                    eVar.b(fVar.d.b);
                    Iterator<x10> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        x10 next = it2.next();
                        e.a a4 = eVar.a(next.c());
                        if (a4 != null) {
                            if (!a4.a) {
                                it2.remove();
                            } else if (a4.b > -1) {
                                next.g(a4.b);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, x10.e);
                x10.c cVar = new x10.c();
                x10.d dVar = new x10.d();
                for (x10 x10Var : arrayList2) {
                    fVar.i.put(x10Var.c(), x10Var);
                    x10Var.a(aVar3);
                    x10Var.e(cVar);
                    x10Var.f(dVar);
                }
                h.a a5 = hVar != null ? hVar.a("sids") : null;
                if (a5 == null || a5.a) {
                    k(fVar, arrayList2);
                }
            } finally {
                iVar.b();
            }
        }
    }

    public final void k(f fVar, List<x10> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fVar, list) == null) {
            List<TrustSubject> list2 = fVar.d.a;
            x10.f fVar2 = new x10.f();
            fVar2.a = true;
            fVar.h = new k();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<x10> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        x10.g b2 = it.next().b(trustSubject.a, fVar2);
                        if (b2 != null && b2.e()) {
                            fVar.h.b(trustSubject.a, b2.a, trustSubject.o());
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.equals(str, "iid")) {
                q();
            } else {
                n();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                i();
                this.d.f.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public final void o(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            d40 d40Var = new d40(this.c);
            fVar.g = d40Var;
            i iVar = new i(d40Var.d().f("init"));
            try {
                iVar.a();
                h40 h40Var = new h40(this.a.a);
                fVar.a = h40Var;
                g40 a2 = h40Var.a("iid");
                g40.a aVar = new g40.a();
                aVar.a = this.c;
                aVar.b = d40Var;
                aVar.d = this.a.d;
                aVar.e = this.a.e;
                g40.b bVar = new g40.b();
                bVar.a = false;
                fVar.j.put(a2.e(), a2);
                a2.a(aVar);
                a2.f(bVar);
            } finally {
                iVar.b();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                this.d.e.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            }
        }
    }
}
