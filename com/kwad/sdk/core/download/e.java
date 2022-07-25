package com.kwad.sdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class e {
    public static e WT;
    public final WeakHashMap<f, AdTemplate> WO;
    public final Map<f, AdTemplate> WP;
    public final HashMap<String, AdTemplate> WR;
    public final Map<String, AdTemplate> WS;
    public volatile boolean mHasInit;
    public static final Map<String, Integer> WQ = Collections.synchronizedMap(new LruHashMap(10));
    public static final BroadcastReceiver IW = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.e.3
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            e.sV().f(intent);
        }
    };

    public e() {
        WeakHashMap<f, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.WO = weakHashMap;
        this.WP = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.WR = hashMap;
        this.WS = Collections.synchronizedMap(hashMap);
    }

    private void a(String str, com.kwad.sdk.d.a<f> aVar) {
        Set<f> keySet = this.WP.keySet();
        synchronized (this.WP) {
            for (f fVar : keySet) {
                if (fVar != null && TextUtils.equals(fVar.mJ(), str)) {
                    try {
                        aVar.accept(fVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.b.printStackTrace(e);
                    }
                }
            }
        }
    }

    public static int bK(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = WQ.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Intent intent) {
        String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
        if (com.kwad.b.kwai.a.aw.booleanValue()) {
            com.kwad.sdk.core.e.b.d("DownloadStatusManager", "handleInstallApp(), pkgNameAdded=" + schemeSpecificPart);
        }
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        h hVar = new h();
        synchronized (this.WP) {
            for (f fVar : this.WP.keySet()) {
                if (fVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, fVar.mK())) {
                    fVar.a((String) null, 0, hVar);
                }
            }
        }
        com.ksad.download.e.S().n(schemeSpecificPart);
        synchronized (this.WS) {
            Iterator<Map.Entry<String, AdTemplate>> it = this.WS.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, AdTemplate> next = it.next();
                if (next != null) {
                    String key = next.getKey();
                    if (!TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, key)) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void f(String str, h hVar) {
        AdTemplate value;
        for (Map.Entry<String, AdTemplate> entry : this.WS.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(value);
                com.kwad.sdk.core.a.rD().b(str, value);
                if (!TextUtils.isEmpty(str) && bQ.downloadId.equals(str) && !value.mDownloadFinishReported) {
                    if (hVar.sX()) {
                        a.b(1, value);
                        hVar.sW();
                    }
                    value.mDownloadFinishReported = true;
                }
            }
        }
    }

    public static e sV() {
        if (WT == null) {
            synchronized (e.class) {
                if (WT == null) {
                    WT = new e();
                }
            }
        }
        return WT;
    }

    public final void a(f fVar) {
        this.WP.remove(fVar);
    }

    public final void a(f fVar, AdTemplate adTemplate) {
        this.WP.put(fVar, adTemplate);
    }

    public final void a(final String str, final int i, final int i2, final int i3) {
        WQ.put(str, 2);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: b */
            public void accept(f fVar) {
                fVar.a(str, i, i2, i3);
            }
        });
    }

    public final void am(AdTemplate adTemplate) {
        try {
            String ag = com.kwad.sdk.core.response.a.a.ag(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
            if (TextUtils.isEmpty(ag)) {
                return;
            }
            this.WS.put(ag, adTemplate);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
        }
    }

    public final void bE(final String str) {
        WQ.put(str, 1);
        final h hVar = new h();
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: b */
            public void accept(f fVar) {
                fVar.a(str, hVar);
            }
        });
    }

    public final void bF(final String str) {
        final h hVar = new h();
        WQ.put(str, 4);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: b */
            public void accept(f fVar) {
                fVar.b(str, hVar);
            }
        });
    }

    public final void bG(final String str) {
        final h hVar = new h();
        WQ.put(str, 1);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: b */
            public void accept(f fVar) {
                fVar.c(str, hVar);
            }
        });
    }

    public final void bH(final String str) {
        final h hVar = new h();
        WQ.put(str, 5);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.9
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: b */
            public void accept(f fVar) {
                fVar.d(str, hVar);
            }
        });
    }

    public final void bI(final String str) {
        final h hVar = new h();
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: b */
            public void accept(f fVar) {
                fVar.al(str);
            }
        });
    }

    public final void bJ(final String str) {
        final h hVar = new h();
        WQ.put(str, 9);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.10
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: b */
            public void accept(f fVar) {
                fVar.e(str, hVar);
            }
        });
    }

    public final synchronized void bp(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        context.unregisterReceiver(IW);
        this.WP.clear();
        this.WS.clear();
        this.mHasInit = false;
    }

    public final void c(final String str, final int i, final String str2) {
        WQ.put(str, 7);
        final h hVar = new h();
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: b */
            public void accept(f fVar) {
                fVar.a(str, i, str2, hVar);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (this.mHasInit || context == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        context.registerReceiver(IW, intentFilter);
        this.mHasInit = true;
    }

    public final void u(final String str, final String str2) {
        final h hVar = new h();
        WQ.put(str, 8);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* renamed from: b */
            public void accept(f fVar) {
                fVar.a(str, str2, hVar);
            }
        });
        f(str, hVar);
    }
}
