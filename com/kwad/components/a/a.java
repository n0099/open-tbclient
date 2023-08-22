package com.kwad.components.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes10.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a PJ;
    public long Nt;
    public Context mContext;
    public volatile boolean mHasInit = false;
    public final List<com.kwad.sdk.e.kwai.b> PK = new CopyOnWriteArrayList();
    public final List<String> PL = new CopyOnWriteArrayList();
    public final List<String> PM = new CopyOnWriteArrayList();
    public final NetworkMonitor.a PN = new NetworkMonitor.a() { // from class: com.kwad.components.a.a.3
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.qq();
            }
        }
    };

    private WebResourceResponse a(@NonNull String str, String str2, b.a aVar, boolean z) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.kwad.sdk.e.kwai.b bVar) {
        if (this.PM.contains(bVar.ait)) {
            return;
        }
        com.kwad.components.a.a.a.a(this.mContext, bVar, new a.InterfaceC0597a() { // from class: com.kwad.components.a.a.5
            @Override // com.kwad.components.a.a.a.InterfaceC0597a
            public final void c(com.kwad.sdk.e.kwai.b bVar2) {
                a.this.PM.add(bVar2.ait);
                com.kwad.sdk.core.e.b.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.components.a.a.a.InterfaceC0597a
            public final void d(com.kwad.sdk.e.kwai.b bVar2) {
                com.kwad.sdk.core.e.b.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.components.a.a.b.a(a.this.mContext, bVar2)) {
                    com.kwad.sdk.core.e.b.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.PK.add(bVar2);
                    a aVar = a.this;
                    aVar.ax(aVar.mContext);
                    com.kwad.components.a.b.b.a(bVar2, 4);
                }
                a.this.PM.remove(bVar2.ait);
            }

            @Override // com.kwad.components.a.a.a.InterfaceC0597a
            public final void e(com.kwad.sdk.e.kwai.b bVar2) {
                com.kwad.sdk.core.e.b.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.PM.remove(bVar2.ait);
            }
        });
    }

    private void a(com.kwad.sdk.e.kwai.b bVar, com.kwad.sdk.e.kwai.a aVar) {
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

    private WebResourceResponse aM(String str) {
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

    private com.kwad.sdk.e.kwai.b aN(String str) {
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

    private com.kwad.sdk.e.kwai.b aO(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: all -> 0x005c, TryCatch #4 {, blocks: (B:7:0x001e, B:16:0x0033, B:17:0x003e, B:19:0x0044, B:21:0x004e, B:22:0x0056, B:24:0x0058, B:25:0x005b, B:15:0x0030), top: B:33:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ax(Context context) {
        String jSONArray;
        FileOutputStream fileOutputStream;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[Catch: all -> 0x0070, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x0060, B:29:0x0068, B:20:0x0036, B:33:0x006c, B:34:0x006f), top: B:38:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056 A[Catch: all -> 0x0070, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x0060, B:29:0x0068, B:20:0x0036, B:33:0x006c, B:34:0x006f), top: B:38:0x0004 }] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ay(Context context) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        synchronized (this.PK) {
            FileInputStream fileInputStream3 = null;
            try {
                File aB = com.kwad.components.a.b.a.aB(context);
                if (o.I(aB)) {
                    fileInputStream = new FileInputStream(aB);
                    try {
                        try {
                            fileInputStream3 = fileInputStream;
                            fileInputStream2 = r.a(g.b(new InputStreamReader(fileInputStream)), new c<com.kwad.sdk.e.kwai.b>() { // from class: com.kwad.components.a.a.7
                                public static com.kwad.sdk.e.kwai.b qs() {
                                    return new com.kwad.sdk.e.kwai.b();
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

    private void b(@NonNull final com.kwad.sdk.e.kwai.b bVar) {
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.a.a.6
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(List<com.kwad.sdk.e.kwai.b> list) {
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

    private WebResourceResponse n(String str, String str2) {
        int i;
        String str3;
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

    public static a qo() {
        if (PJ == null) {
            synchronized (a.class) {
                if (PJ == null) {
                    PJ = new a();
                }
            }
        }
        return PJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public List<com.kwad.sdk.e.kwai.b> qr() {
        List<com.kwad.sdk.e.kwai.a> list;
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

    public final void init(final Context context) {
        if (!d.si() || this.mHasInit || context == null) {
            return;
        }
        this.Nt = System.currentTimeMillis();
        this.mHasInit = true;
        this.mContext = context;
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.ay(context);
                } catch (Throwable th) {
                    com.kwad.components.core.b.a.b(th);
                }
            }
        });
        e.a(new e.a() { // from class: com.kwad.components.a.a.2
            @Override // com.kwad.components.core.k.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                a.this.qq();
            }

            @Override // com.kwad.components.core.k.e.a
            public final void no() {
            }
        });
        NetworkMonitor.getInstance().a(this.mContext, this.PN);
    }

    @Nullable
    public final WebResourceResponse m(String str, String str2) {
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

    public final long qp() {
        return this.Nt;
    }

    public final void qq() {
        if (d.si()) {
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        List<com.kwad.sdk.e.kwai.b> qr = a.this.qr();
                        if (qr != null && !qr.isEmpty()) {
                            a.this.k(qr);
                            for (com.kwad.sdk.e.kwai.b bVar : qr) {
                                if (bVar.packageType == 1 && (bVar.loadType == 1 || (bVar.loadType == 2 && ae.isWifiConnected(a.this.mContext)))) {
                                    a.this.a(bVar);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.b.a.b(th);
                    }
                }
            });
        }
    }
}
