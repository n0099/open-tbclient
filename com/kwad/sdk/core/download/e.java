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
    public static e g;
    public final WeakHashMap<f, AdTemplate> a;
    public final Map<f, AdTemplate> b;
    public volatile boolean d;
    public final HashMap<String, AdTemplate> e;
    public final Map<String, AdTemplate> f;
    public static final Map<String, Integer> c = Collections.synchronizedMap(new LruHashMap(10));
    public static final BroadcastReceiver h = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.e.3
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            e.a().a(intent);
        }
    };

    public e() {
        WeakHashMap<f, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.a = weakHashMap;
        this.b = Collections.synchronizedMap(weakHashMap);
        this.d = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.e = hashMap;
        this.f = Collections.synchronizedMap(hashMap);
    }

    public static int a(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = c.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public static e a() {
        if (g == null) {
            synchronized (e.class) {
                if (g == null) {
                    g = new e();
                }
            }
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
        if (com.kwad.b.kwai.a.b.booleanValue()) {
            com.kwad.sdk.core.d.b.a("DownloadStatusManager", "handleInstallApp(), pkgNameAdded=" + schemeSpecificPart);
        }
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        h hVar = new h();
        synchronized (this.b) {
            for (f fVar : this.b.keySet()) {
                if (fVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, fVar.c())) {
                    fVar.a((String) null, 0, hVar);
                }
            }
        }
        com.ksad.download.e.a().a(schemeSpecificPart);
        synchronized (this.f) {
            Iterator<Map.Entry<String, AdTemplate>> it = this.f.entrySet().iterator();
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

    private void a(String str, h hVar) {
        AdTemplate value;
        for (Map.Entry<String, AdTemplate> entry : this.f.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                AdInfo i = com.kwad.sdk.core.response.a.d.i(value);
                com.kwad.sdk.core.a.a().a(str, value);
                if (!TextUtils.isEmpty(str) && i.downloadId.equals(str) && !value.mDownloadFinishReported) {
                    if (hVar.b()) {
                        a.a(1, value);
                        hVar.a();
                    }
                    value.mDownloadFinishReported = true;
                }
            }
        }
    }

    private void a(String str, com.kwad.sdk.d.a<f> aVar) {
        Set<f> keySet = this.b.keySet();
        synchronized (this.b) {
            for (f fVar : keySet) {
                if (fVar != null && TextUtils.equals(fVar.b(), str)) {
                    try {
                        aVar.a(fVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.a(e);
                    }
                }
            }
        }
    }

    public final synchronized void a(Context context) {
        if (this.d || context == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        context.registerReceiver(h, intentFilter);
        this.d = true;
    }

    public final void a(f fVar) {
        this.b.remove(fVar);
    }

    public final void a(f fVar, AdTemplate adTemplate) {
        this.b.put(fVar, adTemplate);
    }

    public final void a(AdTemplate adTemplate) {
        try {
            String C = com.kwad.sdk.core.response.a.a.C(com.kwad.sdk.core.response.a.d.i(adTemplate));
            if (TextUtils.isEmpty(C)) {
                return;
            }
            this.f.put(C, adTemplate);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.a(th);
        }
    }

    public final void a(final String str, final int i, final int i2, final int i3) {
        c.put(str, 2);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(f fVar) {
                fVar.a(str, i, i2, i3);
            }
        });
    }

    public final void a(final String str, final int i, final String str2) {
        c.put(str, 7);
        final h hVar = new h();
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(f fVar) {
                fVar.a(str, i, str2, hVar);
            }
        });
    }

    public final void a(final String str, final String str2) {
        final h hVar = new h();
        c.put(str, 8);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(f fVar) {
                fVar.a(str, str2, hVar);
            }
        });
        a(str, hVar);
    }

    public final synchronized void b(Context context) {
        if (!this.d || context == null) {
            return;
        }
        context.unregisterReceiver(h);
        this.b.clear();
        this.f.clear();
        this.d = false;
    }

    public final void b(final String str) {
        c.put(str, 1);
        final h hVar = new h();
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(f fVar) {
                fVar.a(str, hVar);
            }
        });
    }

    public final void c(final String str) {
        final h hVar = new h();
        c.put(str, 4);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(f fVar) {
                fVar.b(str, hVar);
            }
        });
    }

    public final void d(final String str) {
        final h hVar = new h();
        c.put(str, 1);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(f fVar) {
                fVar.c(str, hVar);
            }
        });
    }

    public final void e(final String str) {
        final h hVar = new h();
        c.put(str, 5);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.9
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(f fVar) {
                fVar.d(str, hVar);
            }
        });
    }

    public final void f(final String str) {
        final h hVar = new h();
        c.put(str, 9);
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.10
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(f fVar) {
                fVar.e(str, hVar);
            }
        });
    }

    public final void g(final String str) {
        final h hVar = new h();
        a(str, new com.kwad.sdk.d.a<f>() { // from class: com.kwad.sdk.core.download.e.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            public void a(f fVar) {
                fVar.a(str);
            }
        });
    }
}
