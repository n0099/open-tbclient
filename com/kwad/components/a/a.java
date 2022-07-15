package com.kwad.components.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.a.a.a;
import com.kwad.components.a.b.b;
import com.kwad.components.core.j.e;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a a;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean b;
    public Context c;
    public final List<com.kwad.sdk.e.kwai.b> d;
    public final List<String> e;
    public final List<String> f;
    public long g;
    public final NetworkMonitor.a h;

    public a() {
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
        this.b = false;
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.f = new CopyOnWriteArrayList();
        this.h = new NetworkMonitor.a(this) { // from class: com.kwad.components.a.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public final void a(NetworkMonitor.NetworkState networkState) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, networkState) == null) {
                    if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                        this.a.c();
                    }
                }
            }
        };
    }

    private WebResourceResponse a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                b.a aVar = new b.a();
                synchronized (this.d) {
                    for (String str2 : this.e) {
                        WebResourceResponse a2 = a(str2, str, aVar, true);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    private WebResourceResponse a(@NonNull String str, String str2, b.a aVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, str2, aVar, Boolean.valueOf(z)})) == null) {
            com.kwad.sdk.e.kwai.b c = c(str);
            if (c == null) {
                com.kwad.sdk.e.kwai.b b = b(str);
                if (b == null) {
                    aVar.a = "配置文件没有下发该zip资源";
                    return null;
                }
                aVar.a = "资源未下载:" + b.h;
                b(b);
                return null;
            }
            return b.a(this.c, str2, c, aVar, z);
        }
        return (WebResourceResponse) invokeCommon.objValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.kwad.sdk.e.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, bVar) == null) || this.f.contains(bVar.a)) {
            return;
        }
        com.kwad.components.a.a.a.a(this.c, bVar, new a.InterfaceC0456a(this) { // from class: com.kwad.components.a.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.a.a.a.InterfaceC0456a
            public final void a(com.kwad.sdk.e.kwai.b bVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar2) == null) {
                    this.a.f.add(bVar2.a);
                    com.kwad.sdk.core.d.b.a("HybridPackageManager", "download onStart: " + bVar2.toString());
                }
            }

            @Override // com.kwad.components.a.a.a.InterfaceC0456a
            public final void b(com.kwad.sdk.e.kwai.b bVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2) == null) {
                    com.kwad.sdk.core.d.b.a("HybridPackageManager", "download success: " + bVar2.toString());
                    if (com.kwad.components.a.a.b.a(this.a.c, bVar2)) {
                        com.kwad.sdk.core.d.b.a("HybridPackageManager", "install success: " + bVar2.toString());
                        this.a.d.add(bVar2);
                        a aVar = this.a;
                        aVar.b(aVar.c);
                        com.kwad.components.a.b.b.a(bVar2, 4);
                    }
                    this.a.f.remove(bVar2.a);
                }
            }

            @Override // com.kwad.components.a.a.a.InterfaceC0456a
            public final void c(com.kwad.sdk.e.kwai.b bVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar2) == null) {
                    com.kwad.sdk.core.d.b.a("HybridPackageManager", "download failure: " + bVar2.toString());
                    this.a.f.remove(bVar2.a);
                }
            }
        });
    }

    private void a(com.kwad.sdk.e.kwai.b bVar, com.kwad.sdk.e.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, bVar, aVar) == null) {
            bVar.a = aVar.a;
            if (TextUtils.isEmpty(bVar.e)) {
                return;
            }
            String b = com.kwad.components.a.b.a.b(bVar.e);
            if (TextUtils.isEmpty(b)) {
                return;
            }
            bVar.b = b;
            bVar.c = com.kwad.components.a.b.a.b(this.c, b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.kwad.sdk.e.kwai.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, list) == null) {
            synchronized (this.d) {
                c(this.c);
                for (com.kwad.sdk.e.kwai.b bVar : this.d) {
                    if (list.contains(bVar)) {
                        list.remove(bVar);
                    } else {
                        o.l(new File(bVar.c));
                        this.d.remove(bVar);
                    }
                }
                b(this.c);
            }
        }
    }

    private WebResourceResponse b(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, str2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                b.a aVar = new b.a();
                this.e.add(str);
                WebResourceResponse a2 = a(str, str2, aVar, false);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (a2 != null) {
                    com.kwad.sdk.core.d.b.a("HybridPackageManager", "load success time:" + currentTimeMillis2 + "--url:" + str2);
                    i = 1;
                    str3 = "";
                } else {
                    com.kwad.sdk.core.d.b.a("HybridPackageManager", "load fail errorMsg:" + aVar.a + "-url:" + str2);
                    i = 0;
                    str3 = aVar.a;
                }
                com.kwad.components.a.b.b.a(str2, str, i, str3, currentTimeMillis2);
                return a2;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                com.kwad.components.a.b.b.a(str2, str, 0, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), currentTimeMillis3);
                return null;
            }
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    private com.kwad.sdk.e.kwai.b b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            List<com.kwad.sdk.e.kwai.b> d = d();
            if (d != null && !d.isEmpty()) {
                for (com.kwad.sdk.e.kwai.b bVar : d) {
                    if (at.a(str, bVar.a)) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (com.kwad.sdk.e.kwai.b) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:9:0x0022, B:18:0x0037, B:19:0x0042, B:21:0x0048, B:23:0x0052, B:24:0x005a, B:26:0x005c, B:27:0x005f, B:17:0x0034), top: B:35:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context) {
        String jSONArray;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            synchronized (this.d) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        File a2 = com.kwad.components.a.b.a.a(context);
                        jSONArray = r.b(this.d).toString();
                        fileOutputStream = new FileOutputStream(a2);
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(jSONArray.getBytes());
                    com.kwad.sdk.crash.utils.b.a(fileOutputStream);
                } catch (Exception unused2) {
                    fileOutputStream2 = fileOutputStream;
                    com.kwad.sdk.core.d.b.e("updatePackageIndexFile", "read packageIndex file error");
                    com.kwad.sdk.crash.utils.b.a(fileOutputStream2);
                    this.e.clear();
                    while (r5.hasNext()) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    com.kwad.sdk.crash.utils.b.a(fileOutputStream2);
                    throw th;
                }
                this.e.clear();
                for (com.kwad.sdk.e.kwai.b bVar : this.d) {
                    if (bVar.j) {
                        this.e.add(bVar.a);
                    }
                }
            }
        }
    }

    private void b(@NonNull com.kwad.sdk.e.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, bVar) == null) {
            g.a(new Runnable(this, bVar) { // from class: com.kwad.components.a.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.e.kwai.b a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.b.a(this.a);
                    }
                }
            });
        }
    }

    private com.kwad.sdk.e.kwai.b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            synchronized (this.d) {
                if (!TextUtils.isEmpty(str) && this.d.size() > 0) {
                    for (com.kwad.sdk.e.kwai.b bVar : this.d) {
                        if (TextUtils.equals(str, bVar.a)) {
                            return bVar;
                        }
                    }
                    return null;
                }
                return null;
            }
        }
        return (com.kwad.sdk.e.kwai.b) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f A[Catch: all -> 0x0074, TryCatch #1 {, blocks: (B:15:0x002e, B:24:0x003f, B:25:0x0049, B:26:0x0054, B:28:0x005a, B:30:0x0064, B:31:0x006c, B:22:0x003a, B:35:0x0070, B:36:0x0073), top: B:43:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x0074, TryCatch #1 {, blocks: (B:15:0x002e, B:24:0x003f, B:25:0x0049, B:26:0x0054, B:28:0x005a, B:30:0x0064, B:31:0x006c, B:22:0x003a, B:35:0x0070, B:36:0x0073), top: B:43:0x0008 }] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(Context context) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, context) == null) {
            synchronized (this.d) {
                FileInputStream fileInputStream3 = null;
                try {
                    File a2 = com.kwad.components.a.b.a.a(context);
                    if (o.a(a2)) {
                        fileInputStream = new FileInputStream(a2);
                        try {
                            try {
                                fileInputStream3 = fileInputStream;
                                fileInputStream2 = r.a(com.kwad.sdk.crash.utils.g.a(new InputStreamReader(fileInputStream)), new c<com.kwad.sdk.e.kwai.b>(this) { // from class: com.kwad.components.a.a.7
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ a a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.a = this;
                                    }

                                    public static com.kwad.sdk.e.kwai.b b() {
                                        InterceptResult invokeV;
                                        Interceptable interceptable2 = $ic;
                                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, null)) == null) ? new com.kwad.sdk.e.kwai.b() : (com.kwad.sdk.e.kwai.b) invokeV.objValue;
                                    }

                                    /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                                    @Override // com.kwad.sdk.core.c
                                    public final /* synthetic */ com.kwad.sdk.e.kwai.b a() {
                                        return b();
                                    }
                                });
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                com.kwad.sdk.crash.utils.b.a(fileInputStream);
                                if (fileInputStream3 != null) {
                                }
                                this.e.clear();
                                while (r5.hasNext()) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream3 = fileInputStream;
                            com.kwad.sdk.crash.utils.b.a(fileInputStream3);
                            throw th;
                        }
                    } else {
                        fileInputStream2 = null;
                    }
                    com.kwad.sdk.crash.utils.b.a(fileInputStream3);
                    fileInputStream3 = fileInputStream2;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.a(fileInputStream3);
                    throw th;
                }
                if (fileInputStream3 != null) {
                    this.d.clear();
                    this.d.addAll(fileInputStream3);
                }
                this.e.clear();
                for (com.kwad.sdk.e.kwai.b bVar : this.d) {
                    if (bVar.j) {
                        this.e.add(bVar.a);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public List<com.kwad.sdk.e.kwai.b> d() {
        InterceptResult invokeV;
        List<com.kwad.sdk.e.kwai.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            SdkConfigData G = d.G();
            if (G == null || (list = G.h5PreloadConfigs) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (com.kwad.sdk.e.kwai.a aVar : list) {
                for (com.kwad.sdk.e.kwai.b bVar : aVar.b) {
                    a(bVar, aVar);
                    if (bVar.b()) {
                        arrayList.add(bVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public final WebResourceResponse a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.b) {
                String a2 = com.kwad.components.a.b.a.a(str);
                if (TextUtils.isEmpty(a2)) {
                    return a(str);
                }
                com.kwad.components.a.b.b.a(str2, a2, str);
                WebResourceResponse b = b(a2, str);
                com.kwad.components.a.b.b.b(str2, a2, str);
                return b;
            }
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || !d.U() || this.b || context == null) {
            return;
        }
        this.g = System.currentTimeMillis();
        this.b = true;
        this.c = context;
        g.a(new Runnable(this, context) { // from class: com.kwad.components.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ a b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = this;
                this.a = context;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.b.c(this.a);
                }
            }
        });
        e.a(new e.a(this) { // from class: com.kwad.components.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.j.e.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.components.core.j.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkConfigData) == null) {
                    this.a.c();
                }
            }
        });
        NetworkMonitor.a().a(this.c, this.h);
    }

    public final long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : invokeV.longValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && d.U()) {
            g.a(new Runnable(this) { // from class: com.kwad.components.a.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    List<com.kwad.sdk.e.kwai.b> d;
                    int i;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (d = this.a.d()) == null || d.isEmpty()) {
                        return;
                    }
                    this.a.a(d);
                    for (com.kwad.sdk.e.kwai.b bVar : d) {
                        if (bVar.i == 1 && ((i = bVar.h) == 1 || (i == 2 && ac.c(this.a.c)))) {
                            this.a.a(bVar);
                        }
                    }
                }
            });
        }
    }
}
