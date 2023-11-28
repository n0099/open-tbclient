package com.kwad.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class b {
    public static final Map<String, String> amL = new HashMap();
    public final AtomicBoolean amM;
    public final AtomicBoolean amN;
    public final AtomicBoolean amO;
    public final List<String> amP;
    public final List<String> amQ;
    public final BroadcastReceiver amR;
    public Context mContext;
    public final List<com.kwad.sdk.b.a> mListeners;

    /* loaded from: classes10.dex */
    public static class a {
        public static final b amT = new b((byte) 0);
    }

    public static b zt() {
        return a.amT;
    }

    private void zu() {
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.b.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    b.this.zw();
                } catch (Throwable th) {
                    ServiceProvider.b(th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.zv();
                    b.this.zx();
                } catch (Throwable th) {
                    ServiceProvider.b(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        if (!this.amO.get()) {
            return;
        }
        ServiceProvider.Jn().unregisterReceiver(this.amR);
        this.amO.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zx() {
        if (this.amO.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addDataScheme("package");
        ServiceProvider.Jn().registerReceiver(this.amR, intentFilter);
        this.amO.set(true);
    }

    public b() {
        this.amM = new AtomicBoolean();
        this.amN = new AtomicBoolean();
        this.amO = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.amP = new CopyOnWriteArrayList();
        this.amQ = new CopyOnWriteArrayList();
        this.amR = new BroadcastReceiver() { // from class: com.kwad.sdk.b.b.2
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    b.this.mContext = context;
                    if (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, action)) {
                        if (!TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, action)) {
                            return;
                        }
                        b.this.cb(schemeSpecificPart);
                        return;
                    }
                    b.this.y(context, schemeSpecificPart);
                } catch (Throwable th) {
                    c.printStackTrace(th);
                }
            }
        };
    }

    public final synchronized void checkInit() {
        try {
            if (this.amN.get()) {
                return;
            }
            if (((h) ServiceProvider.get(h.class)).yH()) {
                com.kwad.sdk.core.c.b.Ct();
                if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                    zx();
                }
                zu();
            } else {
                zx();
            }
            this.amN.set(true);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    private synchronized void aF(Context context) {
        if (this.amM.get()) {
            return;
        }
        B(context, "com.smile.gifmaker");
        B(context, "com.kuaishou.nebula");
        B(context, "com.tencent.mm");
        this.amM.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(@NonNull String str) {
        c.d("AppInstallManager", "unInstallApp packageName: " + str);
        cg(str);
        cf(str);
        cc(str);
    }

    private void cc(String str) {
        com.kwad.sdk.core.c.b.Ct();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            cd(str);
            return;
        }
        this.amQ.add(str);
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.b.b.4
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.amQ.size() > 0) {
                    for (int i = 0; i < b.this.amQ.size(); i++) {
                        b.cd((String) b.this.amQ.get(i));
                    }
                    b.this.amQ.clear();
                }
                com.kwad.sdk.core.c.b.Ct();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    public static void cd(@NonNull String str) {
        try {
            InstalledAppInfoManager.AppPackageInfo appPackageInfo = new InstalledAppInfoManager.AppPackageInfo();
            appPackageInfo.packageName = str;
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(InstalledAppInfoManager.a(appPackageInfo), 2);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private void ce(String str) {
        for (com.kwad.sdk.b.a aVar : this.mListeners) {
            try {
                aVar.N(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private void cf(String str) {
        for (com.kwad.sdk.b.a aVar : this.mListeners) {
            try {
                aVar.O(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    public static void A(Context context, @NonNull String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(InstalledAppInfoManager.a(InstalledAppInfoManager.a(packageInfo, packageManager)), 1);
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Context context, @NonNull String str) {
        c.d("AppInstallManager", "installApp packageName: " + str);
        B(context, str);
        ce(str);
        z(context, str);
    }

    private void z(Context context, String str) {
        com.kwad.sdk.core.c.b.Ct();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            A(context, str);
            return;
        }
        this.amP.add(str);
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.b.b.3
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.amP.size() > 0) {
                    for (int i = 0; i < b.this.amP.size(); i++) {
                        b.A(b.this.mContext, (String) b.this.amP.get(i));
                    }
                    b.this.amP.clear();
                }
                com.kwad.sdk.core.c.b.Ct();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        aF(context);
        return amL.get(str);
    }

    public static void B(Context context, String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -973170826) {
            if (hashCode != 473713875) {
                if (hashCode == 1659293491 && str.equals("com.smile.gifmaker")) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals("com.kuaishou.nebula")) {
                    c = 1;
                }
                c = 65535;
            }
        } else {
            if (str.equals("com.tencent.mm")) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2) {
                    amL.put("com.tencent.mm", k.M(context, "com.tencent.mm"));
                    return;
                }
                return;
            }
            amL.put("com.kuaishou.nebula", k.M(context, "com.kuaishou.nebula"));
            return;
        }
        amL.put("com.smile.gifmaker", k.M(context, "com.smile.gifmaker"));
    }

    private void aG(Context context) {
        if (this.amM.get()) {
            for (String str : amL.keySet()) {
                String str2 = amL.get(str);
                String M = k.M(context, str);
                if (!TextUtils.isEmpty(M) && !Objects.equals(str2, M)) {
                    y(context, str);
                } else if (TextUtils.isEmpty(M) && !TextUtils.isEmpty(str2)) {
                    cb(str);
                }
            }
        }
    }

    public static void cg(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -973170826) {
            if (hashCode != 473713875) {
                if (hashCode == 1659293491 && str.equals("com.smile.gifmaker")) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals("com.kuaishou.nebula")) {
                    c = 1;
                }
                c = 65535;
            }
        } else {
            if (str.equals("com.tencent.mm")) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2) {
                    amL.put("com.tencent.mm", "");
                    return;
                }
                return;
            }
            amL.put("com.kuaishou.nebula", "");
            return;
        }
        amL.put("com.smile.gifmaker", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zv() {
        Context Jn = ServiceProvider.Jn();
        aG(Jn);
        for (AdTemplate adTemplate : ((f) ServiceProvider.get(f.class)).yj()) {
            AdInfo dP = e.dP(adTemplate);
            int by = com.kwad.sdk.core.response.b.a.by(dP);
            String ay = com.kwad.sdk.core.response.b.a.ay(dP);
            if (by != 12) {
                if (ak.an(Jn, ay)) {
                    y(Jn, ay);
                }
            } else if (!ak.an(Jn, ay)) {
                cb(ay);
            }
        }
    }

    public final void a(com.kwad.sdk.b.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.add(aVar);
    }

    public final void b(com.kwad.sdk.b.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.remove(aVar);
    }
}
