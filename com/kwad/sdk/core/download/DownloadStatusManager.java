package com.kwad.sdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class DownloadStatusManager {

    /* renamed from: f  reason: collision with root package name */
    public static com.ksad.download.f f54262f;

    /* renamed from: g  reason: collision with root package name */
    public static final BroadcastReceiver f54263g = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadStatusManager.a().a(intent);
        }
    };
    public final WeakHashMap<c, AdTemplate> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<c, AdTemplate> f54264b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f54265c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, AdTemplate> f54266d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, AdTemplate> f54267e;

    /* loaded from: classes7.dex */
    public enum Holder {
        INSTANCE;
        
        public DownloadStatusManager mInstance = new DownloadStatusManager();
        public final Object lock = new Object();

        Holder() {
        }

        public DownloadStatusManager getInstance() {
            if (!this.mInstance.f54265c) {
                synchronized (this.lock) {
                    this.mInstance.b();
                }
            }
            return this.mInstance;
        }
    }

    public DownloadStatusManager() {
        WeakHashMap<c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.a = weakHashMap;
        this.f54264b = Collections.synchronizedMap(weakHashMap);
        this.f54265c = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.f54266d = hashMap;
        this.f54267e = Collections.synchronizedMap(hashMap);
        b();
    }

    public static DownloadStatusManager a() {
        return Holder.INSTANCE.getInstance();
    }

    public static void a(Context context) {
        if (Holder.INSTANCE.mInstance.f54265c) {
            try {
                synchronized (Holder.INSTANCE.lock) {
                    if (Holder.INSTANCE.mInstance.f54265c) {
                        context.unregisterReceiver(f54263g);
                        Holder.INSTANCE.mInstance.f54264b.clear();
                        Holder.INSTANCE.mInstance.f54267e.clear();
                        Holder.INSTANCE.mInstance.f54265c = false;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
        if (KsAdSDKImpl.get().isDebugLogEnable()) {
            com.kwad.sdk.core.d.a.a("DownloadStatusManager", "handleInstallApp(), pkgNameAdded=" + schemeSpecificPart);
        }
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        f fVar = new f();
        synchronized (this.f54264b) {
            for (c cVar : this.f54264b.keySet()) {
                if (cVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, cVar.b())) {
                    cVar.a((String) null, 0, fVar);
                }
            }
        }
        f54262f.a(schemeSpecificPart);
        synchronized (this.f54267e) {
            Iterator<Map.Entry<String, AdTemplate>> it = this.f54267e.entrySet().iterator();
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

    private void a(String str, com.kwad.sdk.b.a<c> aVar) {
        Set<c> keySet = this.f54264b.keySet();
        synchronized (this.f54264b) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(cVar.a(), str)) {
                    try {
                        aVar.a(cVar);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
            }
        }
    }

    private void a(String str, f fVar) {
        AdTemplate value;
        for (Map.Entry<String, AdTemplate> entry : this.f54267e.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(value);
                com.kwad.sdk.core.a.a().a(str, value);
                if (!TextUtils.isEmpty(str) && j2.downloadId.equals(str) && !value.mDownloadFinishReported) {
                    if (fVar.b()) {
                        com.kwad.sdk.core.report.a.e(value, (JSONObject) null);
                        fVar.a();
                    }
                    value.mDownloadFinishReported = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context context = KsAdSDKImpl.get().getContext();
        if (this.f54265c || context == null) {
            return;
        }
        f54262f = new com.kwad.sdk.core.download.b.a(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        context.registerReceiver(f54263g, intentFilter);
        this.f54265c = true;
    }

    public void a(c cVar) {
        this.f54264b.remove(cVar);
    }

    public void a(c cVar, AdTemplate adTemplate) {
        this.f54264b.put(cVar, adTemplate);
    }

    public void a(AdTemplate adTemplate) {
        try {
            String v = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
            if (TextUtils.isEmpty(v)) {
                return;
            }
            this.f54267e.put(v, adTemplate);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public void a(final String str) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.a(str, fVar);
            }
        });
    }

    public void a(final String str, final int i2, final int i3, final int i4) {
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.a(str, i2, i3, i4);
            }
        });
    }

    public void a(final String str, final int i2, final String str2) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.a(str, i2, str2, fVar);
            }
        });
    }

    public void a(final String str, final String str2) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.a(str, str2, fVar);
            }
        });
        a(str, fVar);
    }

    public void b(final String str) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.b(str, fVar);
            }
        });
    }

    public void c(final String str) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.c(str, fVar);
            }
        });
    }

    public void d(final String str) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.d(str, fVar);
            }
        });
    }

    public void e(final String str) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.e(str, fVar);
            }
        });
    }
}
