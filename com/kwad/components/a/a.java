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
import com.kwad.components.core.k.e;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a PJ;
    public transient /* synthetic */ FieldHolder $fh;
    public long Nt;
    public final List<com.kwad.sdk.e.kwai.b> PK;
    public final List<String> PL;
    public final List<String> PM;
    public final NetworkMonitor.a PN;
    public Context mContext;
    public volatile boolean mHasInit;

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
        this.mHasInit = false;
        this.PK = new CopyOnWriteArrayList();
        this.PL = new CopyOnWriteArrayList();
        this.PM = new CopyOnWriteArrayList();
        this.PN = new NetworkMonitor.a(this) { // from class: com.kwad.components.a.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a PO;

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
                this.PO = this;
            }

            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public final void a(NetworkMonitor.NetworkState networkState) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, networkState) == null) {
                    if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                        this.PO.qq();
                    }
                }
            }
        };
    }

    private WebResourceResponse a(@NonNull String str, String str2, b.a aVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{str, str2, aVar, Boolean.valueOf(z)})) == null) {
            com.kwad.sdk.e.kwai.b aO = aO(str);
            if (aO == null) {
                com.kwad.sdk.e.kwai.b aN = aN(str);
                if (aN == null) {
                    aVar.Qd = "配置文件没有下发该zip资源";
                    return null;
                }
                aVar.Qd = "资源未下载:" + aN.loadType;
                b(aN);
                return null;
            }
            return b.a(this.mContext, str2, aO, aVar, z);
        }
        return (WebResourceResponse) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.kwad.sdk.e.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, bVar) == null) || this.PM.contains(bVar.ait)) {
            return;
        }
        com.kwad.components.a.a.a.a(this.mContext, bVar, new a.InterfaceC0524a(this) { // from class: com.kwad.components.a.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a PO;

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
                this.PO = this;
            }

            @Override // com.kwad.components.a.a.a.InterfaceC0524a
            public final void c(com.kwad.sdk.e.kwai.b bVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar2) == null) {
                    this.PO.PM.add(bVar2.ait);
                    com.kwad.sdk.core.e.b.d("HybridPackageManager", "download onStart: " + bVar2.toString());
                }
            }

            @Override // com.kwad.components.a.a.a.InterfaceC0524a
            public final void d(com.kwad.sdk.e.kwai.b bVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2) == null) {
                    com.kwad.sdk.core.e.b.d("HybridPackageManager", "download success: " + bVar2.toString());
                    if (com.kwad.components.a.a.b.a(this.PO.mContext, bVar2)) {
                        com.kwad.sdk.core.e.b.d("HybridPackageManager", "install success: " + bVar2.toString());
                        this.PO.PK.add(bVar2);
                        a aVar = this.PO;
                        aVar.ax(aVar.mContext);
                        com.kwad.components.a.b.b.a(bVar2, 4);
                    }
                    this.PO.PM.remove(bVar2.ait);
                }
            }

            @Override // com.kwad.components.a.a.a.InterfaceC0524a
            public final void e(com.kwad.sdk.e.kwai.b bVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar2) == null) {
                    com.kwad.sdk.core.e.b.d("HybridPackageManager", "download failure: " + bVar2.toString());
                    this.PO.PM.remove(bVar2.ait);
                }
            }
        });
    }

    private void a(com.kwad.sdk.e.kwai.b bVar, com.kwad.sdk.e.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, bVar, aVar) == null) {
            bVar.ait = aVar.sceneId;
            if (TextUtils.isEmpty(bVar.packageUrl)) {
                return;
            }
            String aS = com.kwad.components.a.b.a.aS(bVar.packageUrl);
            if (TextUtils.isEmpty(aS)) {
                return;
            }
            bVar.aiu = aS;
            bVar.aiv = com.kwad.components.a.b.a.i(this.mContext, aS);
        }
    }

    private WebResourceResponse aM(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            try {
                b.a aVar = new b.a();
                synchronized (this.PK) {
                    for (String str2 : this.PL) {
                        WebResourceResponse a = a(str2, str, aVar, true);
                        if (a != null) {
                            return a;
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

    private com.kwad.sdk.e.kwai.b aN(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            List<com.kwad.sdk.e.kwai.b> qr = qr();
            if (qr != null && !qr.isEmpty()) {
                for (com.kwad.sdk.e.kwai.b bVar : qr) {
                    if (ax.V(str, bVar.ait)) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (com.kwad.sdk.e.kwai.b) invokeL.objValue;
    }

    private com.kwad.sdk.e.kwai.b aO(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            synchronized (this.PK) {
                if (!TextUtils.isEmpty(str) && this.PK.size() > 0) {
                    for (com.kwad.sdk.e.kwai.b bVar : this.PK) {
                        if (TextUtils.equals(str, bVar.ait)) {
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
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:9:0x0022, B:18:0x0037, B:19:0x0042, B:21:0x0048, B:23:0x0052, B:24:0x005a, B:26:0x005c, B:27:0x005f, B:17:0x0034), top: B:35:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ax(Context context) {
        String jSONArray;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, context) == null) {
            synchronized (this.PK) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        File aB = com.kwad.components.a.b.a.aB(context);
                        jSONArray = r.B(this.PK).toString();
                        fileOutputStream = new FileOutputStream(aB);
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(jSONArray.getBytes());
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                } catch (Exception unused2) {
                    fileOutputStream2 = fileOutputStream;
                    com.kwad.sdk.core.e.b.e("updatePackageIndexFile", "read packageIndex file error");
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                    this.PL.clear();
                    while (r5.hasNext()) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                    throw th;
                }
                this.PL.clear();
                for (com.kwad.sdk.e.kwai.b bVar : this.PK) {
                    if (bVar.aiy) {
                        this.PL.add(bVar.ait);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f A[Catch: all -> 0x0074, TryCatch #1 {, blocks: (B:15:0x002e, B:24:0x003f, B:25:0x0049, B:26:0x0054, B:28:0x005a, B:30:0x0064, B:31:0x006c, B:22:0x003a, B:35:0x0070, B:36:0x0073), top: B:43:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x0074, TryCatch #1 {, blocks: (B:15:0x002e, B:24:0x003f, B:25:0x0049, B:26:0x0054, B:28:0x005a, B:30:0x0064, B:31:0x006c, B:22:0x003a, B:35:0x0070, B:36:0x0073), top: B:43:0x0008 }] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ay(Context context) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, context) == null) {
            synchronized (this.PK) {
                FileInputStream fileInputStream3 = null;
                try {
                    File aB = com.kwad.components.a.b.a.aB(context);
                    if (o.I(aB)) {
                        fileInputStream = new FileInputStream(aB);
                        try {
                            try {
                                fileInputStream3 = fileInputStream;
                                fileInputStream2 = r.a(g.b(new InputStreamReader(fileInputStream)), new c<com.kwad.sdk.e.kwai.b>(this) { // from class: com.kwad.components.a.a.7
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ a PO;

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
                                        this.PO = this;
                                    }

                                    public static com.kwad.sdk.e.kwai.b qs() {
                                        InterceptResult invokeV;
                                        Interceptable interceptable2 = $ic;
                                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, null)) == null) ? new com.kwad.sdk.e.kwai.b() : (com.kwad.sdk.e.kwai.b) invokeV.objValue;
                                    }

                                    /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                                    @Override // com.kwad.sdk.core.c
                                    public final /* synthetic */ com.kwad.sdk.e.kwai.b qt() {
                                        return qs();
                                    }
                                });
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                                if (fileInputStream3 != null) {
                                }
                                this.PL.clear();
                                while (r5.hasNext()) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream3 = fileInputStream;
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream3);
                            throw th;
                        }
                    } else {
                        fileInputStream2 = null;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream3);
                    fileInputStream3 = fileInputStream2;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream3);
                    throw th;
                }
                if (fileInputStream3 != null) {
                    this.PK.clear();
                    this.PK.addAll(fileInputStream3);
                }
                this.PL.clear();
                for (com.kwad.sdk.e.kwai.b bVar : this.PK) {
                    if (bVar.aiy) {
                        this.PL.add(bVar.ait);
                    }
                }
            }
        }
    }

    private void b(@NonNull com.kwad.sdk.e.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, bVar) == null) {
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, bVar) { // from class: com.kwad.components.a.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a PO;
                public final /* synthetic */ com.kwad.sdk.e.kwai.b PP;

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
                    this.PO = this;
                    this.PP = bVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.PO.a(this.PP);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(List<com.kwad.sdk.e.kwai.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, list) == null) {
            synchronized (this.PK) {
                ay(this.mContext);
                for (com.kwad.sdk.e.kwai.b bVar : this.PK) {
                    if (list.contains(bVar)) {
                        list.remove(bVar);
                    } else {
                        o.X(new File(bVar.aiv));
                        this.PK.remove(bVar);
                    }
                }
                ax(this.mContext);
            }
        }
    }

    private WebResourceResponse n(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, this, str, str2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                b.a aVar = new b.a();
                this.PL.add(str);
                WebResourceResponse a = a(str, str2, aVar, false);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (a != null) {
                    com.kwad.sdk.core.e.b.d("HybridPackageManager", "load success time:" + currentTimeMillis2 + "--url:" + str2);
                    i = 1;
                    str3 = "";
                } else {
                    com.kwad.sdk.core.e.b.d("HybridPackageManager", "load fail errorMsg:" + aVar.Qd + "-url:" + str2);
                    i = 0;
                    str3 = aVar.Qd;
                }
                com.kwad.components.a.b.b.a(str2, str, i, str3, currentTimeMillis2);
                return a;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                com.kwad.components.a.b.b.a(str2, str, 0, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), currentTimeMillis3);
                return null;
            }
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public static a qo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (PJ == null) {
                synchronized (a.class) {
                    if (PJ == null) {
                        PJ = new a();
                    }
                }
            }
            return PJ;
        }
        return (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public List<com.kwad.sdk.e.kwai.b> qr() {
        InterceptResult invokeV;
        List<com.kwad.sdk.e.kwai.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            SdkConfigData rZ = d.rZ();
            if (rZ == null || (list = rZ.h5PreloadConfigs) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (com.kwad.sdk.e.kwai.a aVar : list) {
                for (com.kwad.sdk.e.kwai.b bVar : aVar.ais) {
                    a(bVar, aVar);
                    if (bVar.isValid()) {
                        arrayList.add(bVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || !d.si() || this.mHasInit || context == null) {
            return;
        }
        this.Nt = System.currentTimeMillis();
        this.mHasInit = true;
        this.mContext = context;
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, context) { // from class: com.kwad.components.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a PO;
            public final /* synthetic */ Context gC;

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
                this.PO = this;
                this.gC = context;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        this.PO.ay(this.gC);
                    } catch (Throwable th) {
                        com.kwad.components.core.b.a.b(th);
                    }
                }
            }
        });
        e.a(new e.a(this) { // from class: com.kwad.components.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a PO;

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
                this.PO = this;
            }

            @Override // com.kwad.components.core.k.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, sdkConfigData) == null) {
                    this.PO.qq();
                }
            }

            @Override // com.kwad.components.core.k.e.a
            public final void no() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        });
        NetworkMonitor.getInstance().a(this.mContext, this.PN);
    }

    @Nullable
    public final WebResourceResponse m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (this.mHasInit) {
                String aR = com.kwad.components.a.b.a.aR(str);
                if (TextUtils.isEmpty(aR)) {
                    return aM(str);
                }
                com.kwad.components.a.b.b.b(str2, aR, str);
                WebResourceResponse n = n(aR, str);
                com.kwad.components.a.b.b.c(str2, aR, str);
                return n;
            }
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public final long qp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Nt : invokeV.longValue;
    }

    public final void qq() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && d.si()) {
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this) { // from class: com.kwad.components.a.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a PO;

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
                    this.PO = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            List<com.kwad.sdk.e.kwai.b> qr = this.PO.qr();
                            if (qr != null && !qr.isEmpty()) {
                                this.PO.k(qr);
                                for (com.kwad.sdk.e.kwai.b bVar : qr) {
                                    if (bVar.packageType == 1 && (bVar.loadType == 1 || (bVar.loadType == 2 && ae.isWifiConnected(this.PO.mContext)))) {
                                        this.PO.a(bVar);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            com.kwad.components.core.b.a.b(th);
                        }
                    }
                }
            });
        }
    }
}
