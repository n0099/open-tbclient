package com.kwad.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.c.d;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.t;
import com.kwai.filedownloader.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d f57632b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f57633c;

    /* renamed from: d  reason: collision with root package name */
    public Context f57634d;

    /* renamed from: e  reason: collision with root package name */
    public b f57635e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.c.kwai.d> f57636f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.kwad.sdk.c.kwai.d> f57637g;

    /* renamed from: h  reason: collision with root package name */
    public List<com.kwad.sdk.c.kwai.d> f57638h;

    /* renamed from: i  reason: collision with root package name */
    public final Lock f57639i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f57640j;

    /* renamed from: k  reason: collision with root package name */
    public List<com.kwad.sdk.c.kwai.d> f57641k;
    public final LinkedHashSet<String> l;
    public com.kwad.sdk.c.a.c m;
    public final NetworkMonitor.a n;

    public c() {
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
        this.f57633c = new HashMap();
        this.f57640j = false;
        this.l = new LinkedHashSet<>();
        this.n = new NetworkMonitor.a(this) { // from class: com.kwad.sdk.c.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public void a(NetworkMonitor.NetworkState networkState) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, networkState) == null) {
                    if ((networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) && this.a.f57637g != null && this.a.f57637g.size() > 0) {
                        this.a.b();
                    }
                }
            }
        };
        this.f57639i = new ReentrantLock();
    }

    private WebResourceResponse a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            synchronized (this.f57633c) {
                String str3 = this.f57633c.get(str);
                com.kwad.sdk.core.d.a.a("WebResourceResponse", str3 + " | " + str2 + " | " + str + "| packageStatusMap size:" + this.f57633c.size());
                if (TextUtils.isEmpty(str3)) {
                    b(str);
                    return null;
                }
                synchronized (this.f57632b) {
                    com.kwad.sdk.c.kwai.d c2 = c(str);
                    if (c2 != null) {
                        return this.f57632b.a(str2, c2, str3);
                    }
                    return null;
                }
            }
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public static synchronized c a() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (c.class) {
                if (a == null) {
                    synchronized (c.class) {
                        if (a == null) {
                            a = new c();
                        }
                    }
                }
                cVar = a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @NonNull
    private List<com.kwad.sdk.c.kwai.d> a(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, file)) == null) {
            String str = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return new ArrayList();
            }
            try {
                str = h.b(new InputStreamReader(fileInputStream));
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return t.a(str, new com.kwad.sdk.core.c<com.kwad.sdk.c.kwai.d>(this) { // from class: com.kwad.sdk.c.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.c
                /* renamed from: b */
                public com.kwad.sdk.c.kwai.d a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new com.kwad.sdk.c.kwai.d() : (com.kwad.sdk.c.kwai.d) invokeV.objValue;
                }
            });
        }
        return (List) invokeL.objValue;
    }

    private void a(List<com.kwad.sdk.c.kwai.d> list) {
        List<com.kwad.sdk.c.kwai.d> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, list) == null) || list.size() <= 0) {
            return;
        }
        this.f57641k = new ArrayList();
        for (com.kwad.sdk.c.kwai.d dVar : list) {
            for (com.kwad.sdk.c.kwai.d dVar2 : this.f57637g) {
                if (TextUtils.equals(dVar.f57655d, dVar2.f57655d)) {
                    if (dVar.c().equals(dVar2.c())) {
                        if (this.f57638h == null) {
                            this.f57638h = new ArrayList();
                        }
                        list2 = this.f57638h;
                    } else {
                        list2 = this.f57641k;
                    }
                    list2.add(dVar);
                }
            }
        }
        a(this.f57637g, this.f57638h);
        a(list, this.f57641k);
        b(this.f57641k);
    }

    private void a(List<com.kwad.sdk.c.kwai.d> list, List<com.kwad.sdk.c.kwai.d> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, this, list, list2) == null) || list == null || list2 == null) {
            return;
        }
        for (com.kwad.sdk.c.kwai.d dVar : list2) {
            for (com.kwad.sdk.c.kwai.d dVar2 : list) {
                if (a(dVar, dVar2)) {
                    list.remove(dVar2);
                }
            }
        }
    }

    private boolean a(com.kwad.sdk.c.kwai.d dVar, com.kwad.sdk.c.kwai.d dVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, dVar, dVar2)) == null) ? TextUtils.equals(dVar.f57655d, dVar2.f57655d) && TextUtils.equals(dVar.c(), dVar2.c()) : invokeLL.booleanValue;
    }

    private boolean a(com.kwad.sdk.c.kwai.d dVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, dVar, str)) == null) ? dVar.f57658g == 3 && TextUtils.equals(dVar.b(), str) : invokeLL.booleanValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            List<com.kwad.sdk.c.kwai.d> c2 = c(context);
            this.f57636f = c2;
            if (c2 == null || c2.size() <= 0) {
                return;
            }
            for (com.kwad.sdk.c.kwai.d dVar : this.f57636f) {
                synchronized (this.f57633c) {
                    this.f57633c.put(dVar.b(), dVar.f57653b);
                    if (dVar.f57660i) {
                        this.l.add(dVar.b());
                    }
                }
            }
        }
    }

    private void b(List<com.kwad.sdk.c.kwai.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, list) == null) {
            for (com.kwad.sdk.c.kwai.d dVar : list) {
                String a2 = com.kwad.sdk.c.b.a.a(this.f57634d, dVar.f());
                if (!TextUtils.isEmpty(a2)) {
                    q.c(new File(a2));
                }
            }
        }
    }

    private com.kwad.sdk.c.kwai.d c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            for (int i2 = 0; i2 < this.f57636f.size(); i2++) {
                if (TextUtils.equals(str, this.f57636f.get(i2).a)) {
                    return this.f57636f.get(i2);
                }
            }
            return null;
        }
        return (com.kwad.sdk.c.kwai.d) invokeL.objValue;
    }

    private List<com.kwad.sdk.c.kwai.d> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            List<com.kwad.sdk.c.kwai.c> list = com.kwad.sdk.core.config.b.aP().h5PreloadConfigs;
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (com.kwad.sdk.c.kwai.c cVar : list) {
                for (com.kwad.sdk.c.kwai.d dVar : cVar.a()) {
                    dVar.a(cVar.b());
                    arrayList.add(dVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private List<com.kwad.sdk.c.kwai.d> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, context)) == null) {
            String c2 = com.kwad.sdk.c.b.a.c(context);
            if (c2 == null) {
                return null;
            }
            File file = new File(c2);
            if (file.exists()) {
                return a(file);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, this) == null) && e()) {
            NetworkMonitor.a().a(this.n);
        }
    }

    private boolean d(com.kwad.sdk.c.kwai.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, dVar)) == null) {
            if (dVar.f57658g != 1) {
                return com.ksad.download.c.b.b(this.f57634d) && dVar.f57658g == 2;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void e(com.kwad.sdk.c.kwai.d dVar) {
        List<com.kwad.sdk.c.kwai.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, dVar) == null) || (list = this.f57637g) == null) {
            return;
        }
        int indexOf = list.indexOf(dVar);
        if (indexOf >= 0) {
            this.f57637g.remove(indexOf);
        }
        if (this.f57640j) {
            d();
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            List<com.kwad.sdk.c.kwai.d> list = this.f57637g;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (com.kwad.sdk.c.kwai.d dVar : this.f57637g) {
                if (dVar.f57658g != 3) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void f(com.kwad.sdk.c.kwai.d dVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, dVar) == null) {
            com.kwad.sdk.c.b.b.a(dVar, 3);
            com.kwad.sdk.core.d.a.a("updatePackageIndexFile", dVar.a + "|" + dVar.f57656e);
            File file = new File(com.kwad.sdk.c.b.a.c(this.f57634d));
            if (!file.exists()) {
                try {
                    z = file.createNewFile();
                } catch (IOException e2) {
                    com.kwad.sdk.c.b.b.a(dVar, 3, e2.getMessage());
                    z = false;
                }
                if (!z) {
                    return;
                }
            }
            if (this.f57636f == null) {
                this.f57636f = a(file);
            }
            int indexOf = this.f57636f.indexOf(dVar);
            if (indexOf >= 0) {
                this.f57636f.get(indexOf).b(dVar.f57656e);
            } else {
                this.f57636f.add(dVar);
            }
            String jSONArray = t.b(this.f57636f).toString();
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(jSONArray.getBytes());
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        com.kwad.sdk.core.d.a.e("updatePackageIndexFile", "write packageIndex file error");
                        fileOutputStream.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Exception unused2) {
                com.kwad.sdk.core.d.a.e("updatePackageIndexFile", "read packageIndex file error");
            }
        }
    }

    public WebResourceResponse a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String a2 = this.f57632b.a(str);
            if (!TextUtils.isEmpty(a2)) {
                this.l.add(a2);
                return a(a2, str);
            }
            Iterator<String> it = this.l.iterator();
            while (it.hasNext()) {
                WebResourceResponse a3 = a(it.next(), str);
                if (a3 != null) {
                    return a3;
                }
            }
            return null;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && com.kwad.sdk.core.config.b.J()) {
            this.f57634d = context;
            this.f57632b = new d(context);
            this.f57635e = new b(context);
            r.a(context);
            b(context);
            this.m = new d.a();
        }
    }

    public void a(com.kwad.sdk.c.kwai.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) && dVar != null && this.m.a(dVar)) {
            this.f57639i.lock();
            String a2 = this.f57635e.a(dVar, false);
            this.f57639i.unlock();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            com.kwad.sdk.core.d.a.a("installPackage", "version" + dVar.c());
            f(dVar);
            if (this.f57636f == null) {
                this.f57636f = new ArrayList();
            }
            this.f57636f.add(dVar);
            synchronized (this.f57633c) {
                this.f57633c.put(dVar.b(), dVar.f57653b);
                if (dVar.f57660i) {
                    this.l.add(dVar.b());
                }
                com.kwad.sdk.c.b.b.a(dVar, 4);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && com.kwad.sdk.core.config.b.J()) {
            if (this.f57636f == null) {
                this.f57636f = c(this.f57634d);
            }
            boolean z = this.f57636f == null;
            List<com.kwad.sdk.c.kwai.d> c2 = c();
            if (c2 == null) {
                return;
            }
            this.f57637g = new ArrayList();
            if (c2.size() > 0) {
                this.f57637g.addAll(c2);
            }
            if (!z) {
                a(this.f57636f);
            }
            ArrayList arrayList = new ArrayList(this.f57637g.size());
            for (com.kwad.sdk.c.kwai.d dVar : this.f57637g) {
                if (dVar.f57659h == 1) {
                    arrayList.add(dVar);
                }
            }
            this.f57637g.clear();
            this.f57637g.addAll(arrayList);
            for (int i2 = 0; i2 < this.f57637g.size(); i2++) {
                com.kwad.sdk.c.kwai.d dVar2 = this.f57637g.get(i2);
                if (d(dVar2)) {
                    new a(this.f57634d).a(dVar2, new com.kwad.sdk.c.a.a(this));
                }
                if (i2 == this.f57637g.size() - 1) {
                    if (d(dVar2)) {
                        this.f57640j = true;
                    } else {
                        d();
                    }
                }
            }
            this.f57633c.clear();
            List<com.kwad.sdk.c.kwai.d> list = this.f57638h;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (com.kwad.sdk.c.kwai.d dVar3 : this.f57638h) {
                synchronized (this.f57633c) {
                    this.f57633c.put(dVar3.b(), dVar3.f57653b);
                }
            }
        }
    }

    public void b(com.kwad.sdk.c.kwai.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            com.kwad.sdk.core.d.a.a("download", "success");
            List<com.kwad.sdk.c.kwai.d> list = this.f57637g;
            if (list == null) {
                return;
            }
            int indexOf = list.indexOf(dVar);
            if (indexOf >= 0) {
                dVar = this.f57637g.remove(indexOf);
            }
            com.kwad.sdk.core.d.a.a("performDownloadSuccess", "installPackage");
            a(dVar);
            if (this.f57640j) {
                d();
            }
        }
    }

    public void b(String str) {
        List<com.kwad.sdk.c.kwai.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (list = this.f57637g) == null || list.size() <= 0) {
            return;
        }
        for (com.kwad.sdk.c.kwai.d dVar : this.f57637g) {
            if (a(dVar, str)) {
                new a(this.f57634d).a(dVar, new com.kwad.sdk.c.a.a(this));
            }
        }
    }

    public void c(com.kwad.sdk.c.kwai.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            com.kwad.sdk.core.d.a.a("download", SmsLoginView.f.l);
            e(dVar);
        }
    }
}
