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
    public static com.ksad.download.f f39395f;

    /* renamed from: g  reason: collision with root package name */
    public static final BroadcastReceiver f39396g = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadStatusManager.a().a(intent);
        }
    };
    public final WeakHashMap<c, AdTemplate> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<c, AdTemplate> f39397b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f39398c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, AdTemplate> f39399d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, AdTemplate> f39400e;

    /* loaded from: classes7.dex */
    public enum Holder {
        INSTANCE;
        
        public DownloadStatusManager mInstance = new DownloadStatusManager();
        public final Object lock = new Object();

        Holder() {
        }

        public DownloadStatusManager getInstance() {
            if (!this.mInstance.f39398c) {
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
        this.f39397b = Collections.synchronizedMap(weakHashMap);
        this.f39398c = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.f39399d = hashMap;
        this.f39400e = Collections.synchronizedMap(hashMap);
        b();
    }

    public static DownloadStatusManager a() {
        return Holder.INSTANCE.getInstance();
    }

    public static void a(Context context) {
        if (Holder.INSTANCE.mInstance.f39398c) {
            try {
                synchronized (Holder.INSTANCE.lock) {
                    if (Holder.INSTANCE.mInstance.f39398c) {
                        context.unregisterReceiver(f39396g);
                        Holder.INSTANCE.mInstance.f39397b.clear();
                        Holder.INSTANCE.mInstance.f39400e.clear();
                        Holder.INSTANCE.mInstance.f39398c = false;
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
        synchronized (this.f39397b) {
            for (c cVar : this.f39397b.keySet()) {
                if (cVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, cVar.b())) {
                    cVar.a((String) null, 0, fVar);
                }
            }
        }
        f39395f.a(schemeSpecificPart);
        synchronized (this.f39400e) {
            Iterator<Map.Entry<String, AdTemplate>> it = this.f39400e.entrySet().iterator();
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
        Set<c> keySet = this.f39397b.keySet();
        synchronized (this.f39397b) {
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
        for (Map.Entry<String, AdTemplate> entry : this.f39400e.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                AdInfo j = com.kwad.sdk.core.response.a.d.j(value);
                com.kwad.sdk.core.a.a().a(str, value);
                if (!TextUtils.isEmpty(str) && j.downloadId.equals(str) && !value.mDownloadFinishReported) {
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
        if (this.f39398c || context == null) {
            return;
        }
        f39395f = new com.kwad.sdk.core.download.b.a(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        context.registerReceiver(f39396g, intentFilter);
        this.f39398c = true;
    }

    public void a(c cVar) {
        this.f39397b.remove(cVar);
    }

    public void a(c cVar, AdTemplate adTemplate) {
        this.f39397b.put(cVar, adTemplate);
    }

    public void a(AdTemplate adTemplate) {
        try {
            String v = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
            if (TextUtils.isEmpty(v)) {
                return;
            }
            this.f39400e.put(v, adTemplate);
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

    public void a(final String str, final int i, final int i2, final int i3) {
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.a(str, i, i2, i3);
            }
        });
    }

    public void a(final String str, final int i, final String str2) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.b.a<c>() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.b.a
            public void a(c cVar) {
                cVar.a(str, i, str2, fVar);
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
