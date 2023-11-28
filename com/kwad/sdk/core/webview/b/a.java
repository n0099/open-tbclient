package com.kwad.sdk.core.webview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.b.b.a;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.e;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.t;
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
    public static volatile a aDd;
    public Context mContext;
    public long mInitTime;
    public volatile boolean mHasInit = false;
    public final List<com.kwad.sdk.h.a.b> aDe = new CopyOnWriteArrayList();
    public final List<String> aDf = new CopyOnWriteArrayList();
    public final List<String> aDg = new CopyOnWriteArrayList();
    public final NetworkMonitor.a aDh = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.b.a.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.FO();
            }
        }
    };

    public static a FM() {
        if (aDd == null) {
            synchronized (a.class) {
                if (aDd == null) {
                    aDd = new a();
                }
            }
        }
        return aDd;
    }

    public final long FN() {
        return this.mInitTime;
    }

    public final void FO() {
        if (!d.AZ()) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.webview.b.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    List<com.kwad.sdk.h.a.b> FP = a.this.FP();
                    if (FP != null && !FP.isEmpty()) {
                        a.this.B(FP);
                        for (com.kwad.sdk.h.a.b bVar : FP) {
                            if (bVar.packageType == 1 && (bVar.loadType == 1 || (bVar.loadType == 2 && ag.isWifiConnected(a.this.mContext)))) {
                                a.this.a(bVar);
                            }
                        }
                    }
                } catch (Throwable th) {
                    ((e) ServiceProvider.get(e.class)).gatherException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(List<com.kwad.sdk.h.a.b> list) {
        synchronized (this.aDe) {
            bp(this.mContext);
            for (com.kwad.sdk.h.a.b bVar : this.aDe) {
                if (list.contains(bVar)) {
                    if (q.fL(com.kwad.sdk.core.webview.b.c.a.I(this.mContext, bVar.aGT))) {
                        list.remove(bVar);
                    }
                } else {
                    q.aa(new File(bVar.aGU));
                    this.aDe.remove(bVar);
                }
            }
            bo(this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: all -> 0x005c, TryCatch #4 {, blocks: (B:7:0x001e, B:16:0x0033, B:17:0x003e, B:19:0x0044, B:21:0x004e, B:22:0x0056, B:24:0x0058, B:25:0x005b, B:15:0x0030), top: B:33:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bo(Context context) {
        String jSONArray;
        FileOutputStream fileOutputStream;
        synchronized (this.aDe) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File bs = com.kwad.sdk.core.webview.b.c.a.bs(context);
                    jSONArray = t.K(this.aDe).toString();
                    fileOutputStream = new FileOutputStream(bs);
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
                c.e("updatePackageIndexFile", "read packageIndex file error");
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                this.aDf.clear();
                while (r5.hasNext()) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                throw th;
            }
            this.aDf.clear();
            for (com.kwad.sdk.h.a.b bVar : this.aDe) {
                if (bVar.aGW) {
                    this.aDf.add(bVar.aGS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public List<com.kwad.sdk.h.a.b> FP() {
        List<com.kwad.sdk.h.a.a> list;
        SdkConfigData AR = d.AR();
        if (AR == null || (list = AR.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.h.a.a aVar : list) {
            for (com.kwad.sdk.h.a.b bVar : aVar.aGR) {
                a(bVar, aVar);
                if (bVar.isValid()) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private WebResourceResponse Z(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.aDf.add(str);
            WebResourceResponse a = a(str, str2, aVar, false);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a != null) {
                c.d("HybridPackageManager", "load success time:" + currentTimeMillis2 + "--url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 1, "", currentTimeMillis2);
            } else {
                c.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, aVar.msg, currentTimeMillis2);
            }
            return a;
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), currentTimeMillis3);
            return null;
        }
    }

    @Nullable
    public final WebResourceResponse Y(String str, String str2) {
        if (!this.mHasInit) {
            return null;
        }
        String ev = com.kwad.sdk.core.webview.b.c.a.ev(str);
        if (!TextUtils.isEmpty(ev)) {
            com.kwad.sdk.core.webview.b.c.b.c(str2, ev, str);
            WebResourceResponse Z = Z(ev, str);
            com.kwad.sdk.core.webview.b.c.b.d(str2, ev, str);
            return Z;
        }
        return eq(str);
    }

    private WebResourceResponse eq(String str) {
        try {
            b.a aVar = new b.a();
            synchronized (this.aDe) {
                for (String str2 : this.aDf) {
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

    private com.kwad.sdk.h.a.b er(String str) {
        List<com.kwad.sdk.h.a.b> FP = FP();
        if (FP != null && !FP.isEmpty()) {
            for (com.kwad.sdk.h.a.b bVar : FP) {
                if (bg.isEquals(str, bVar.aGS)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public final synchronized void init(final Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = ServiceProvider.Jn();
            this.mHasInit = true;
            g.execute(new ay() { // from class: com.kwad.sdk.core.webview.b.a.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    try {
                        if (!d.b(com.kwad.sdk.core.config.c.apR)) {
                            return;
                        }
                        a.this.mInitTime = System.currentTimeMillis();
                        a.this.bp(context);
                        a.this.FO();
                        NetworkMonitor.getInstance().a(a.this.mContext, a.this.aDh);
                    } catch (Throwable th) {
                        ((e) ServiceProvider.get(e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    private WebResourceResponse a(@NonNull String str, String str2, b.a aVar, boolean z) {
        com.kwad.sdk.h.a.b es = es(str);
        if (es == null) {
            com.kwad.sdk.h.a.b er = er(str);
            if (er == null) {
                aVar.msg = "配置文件没有下发该zip资源";
                return null;
            }
            aVar.msg = "资源未下载:" + er.loadType;
            b(er);
            return null;
        }
        return b.a(this.mContext, str2, es, aVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.kwad.sdk.h.a.b bVar) {
        if (!this.aDg.contains(bVar.aGS) && !TextUtils.isEmpty(bVar.packageUrl)) {
            com.kwad.sdk.core.webview.b.b.a.a(bVar, new a.InterfaceC0714a() { // from class: com.kwad.sdk.core.webview.b.a.4
                @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0714a
                public final void c(com.kwad.sdk.h.a.b bVar2) {
                    a.this.aDg.add(bVar2.aGS);
                    c.d("HybridPackageManager", "download onStart: " + bVar2.toString());
                }

                @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0714a
                public final void e(com.kwad.sdk.h.a.b bVar2) {
                    c.d("HybridPackageManager", "download failure: " + bVar2.toString());
                    a.this.aDg.remove(bVar2.aGS);
                }

                @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0714a
                public final void d(com.kwad.sdk.h.a.b bVar2) {
                    c.d("HybridPackageManager", "download success: " + bVar2.toString());
                    if (com.kwad.sdk.core.webview.b.b.b.a(a.this.mContext, bVar2)) {
                        c.d("HybridPackageManager", "install success: " + bVar2.toString());
                        a.this.aDe.add(bVar2);
                        a aVar = a.this;
                        aVar.bo(aVar.mContext);
                        com.kwad.sdk.core.webview.b.c.b.a(bVar2, 4);
                    }
                    a.this.aDg.remove(bVar2.aGS);
                }
            });
        }
    }

    private void b(@NonNull final com.kwad.sdk.h.a.b bVar) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.webview.b.a.5
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(bVar);
            }
        });
    }

    private void a(com.kwad.sdk.h.a.b bVar, com.kwad.sdk.h.a.a aVar) {
        bVar.aGS = aVar.sceneId;
        if (!TextUtils.isEmpty(bVar.packageUrl)) {
            String ew = com.kwad.sdk.core.webview.b.c.a.ew(bVar.packageUrl);
            if (!TextUtils.isEmpty(ew)) {
                bVar.aGT = ew;
                bVar.aGU = com.kwad.sdk.core.webview.b.c.a.G(this.mContext, ew);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x006a, B:29:0x006f, B:31:0x0073, B:32:0x007b, B:20:0x0036, B:36:0x007f, B:37:0x0082), top: B:41:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x006a, B:29:0x006f, B:31:0x0073, B:32:0x007b, B:20:0x0036, B:36:0x007f, B:37:0x0082), top: B:41:0x0004 }] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bp(Context context) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        synchronized (this.aDe) {
            FileInputStream fileInputStream3 = null;
            try {
                File bs = com.kwad.sdk.core.webview.b.c.a.bs(context);
                if (q.L(bs)) {
                    fileInputStream = new FileInputStream(bs);
                    try {
                        try {
                            fileInputStream3 = fileInputStream;
                            fileInputStream2 = t.a(h.b(new InputStreamReader(fileInputStream)), new com.kwad.sdk.core.c<com.kwad.sdk.h.a.b>() { // from class: com.kwad.sdk.core.webview.b.a.6
                                public static com.kwad.sdk.h.a.b FQ() {
                                    return new com.kwad.sdk.h.a.b();
                                }

                                /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                                @Override // com.kwad.sdk.core.c
                                public final /* synthetic */ com.kwad.sdk.h.a.b Ac() {
                                    return FQ();
                                }
                            });
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                            if (fileInputStream3 != null) {
                            }
                            this.aDf.clear();
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
                this.aDe.clear();
                this.aDe.addAll(fileInputStream3);
            }
            this.aDf.clear();
            for (com.kwad.sdk.h.a.b bVar : this.aDe) {
                if (!q.fL(com.kwad.sdk.core.webview.b.c.a.I(this.mContext, bVar.aGT))) {
                    this.aDe.remove(bVar);
                }
                if (bVar.aGW) {
                    this.aDf.add(bVar.aGS);
                }
            }
        }
    }

    private com.kwad.sdk.h.a.b es(String str) {
        synchronized (this.aDe) {
            if (!TextUtils.isEmpty(str) && this.aDe.size() > 0) {
                for (com.kwad.sdk.h.a.b bVar : this.aDe) {
                    if (TextUtils.equals(str, bVar.aGS)) {
                        return bVar;
                    }
                }
                return null;
            }
            return null;
        }
    }
}
