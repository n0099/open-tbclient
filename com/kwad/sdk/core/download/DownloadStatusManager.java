package com.kwad.sdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes3.dex */
public class DownloadStatusManager {
    private static com.ksad.download.f f = new com.kwad.sdk.core.download.c.a();
    private static final BroadcastReceiver g = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadStatusManager.a().a(intent);
        }
    };
    private static final BroadcastReceiver h = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadStatusManager.a().b(intent);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final WeakHashMap<d, AdTemplate> f6042a;
    private final Map<d, AdTemplate> b;
    private volatile boolean c;
    private final HashMap<String, AdTemplate> d;
    private final Map<String, AdTemplate> e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Holder {
        INSTANCE;
        
        private DownloadStatusManager mInstance = new DownloadStatusManager();
        private final Object lock = new Object();

        Holder() {
        }

        DownloadStatusManager getInstance() {
            if (!this.mInstance.c) {
                synchronized (this.lock) {
                    this.mInstance.b();
                }
            }
            return this.mInstance;
        }
    }

    private DownloadStatusManager() {
        this.f6042a = new WeakHashMap<>();
        this.b = Collections.synchronizedMap(this.f6042a);
        this.c = false;
        this.d = new HashMap<>();
        this.e = Collections.synchronizedMap(this.d);
        b();
    }

    public static DownloadStatusManager a() {
        return Holder.INSTANCE.getInstance();
    }

    public static void a(Context context) {
        if (Holder.INSTANCE.mInstance.c) {
            try {
                synchronized (Holder.INSTANCE.lock) {
                    if (Holder.INSTANCE.mInstance.c) {
                        context.unregisterReceiver(g);
                        context.unregisterReceiver(h);
                        Holder.INSTANCE.mInstance.b.clear();
                        Holder.INSTANCE.mInstance.e.clear();
                        Holder.INSTANCE.mInstance.c = false;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        String str;
        char c = 0;
        int i = 0;
        String str2 = "";
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString("RESULT_DOWNLOAD_ID");
        String action = intent.getAction();
        if (TextUtils.equals(a.b, action)) {
            c = 1;
            str = null;
        } else if (TextUtils.equals(a.c, action)) {
            c = 2;
            i2 = extras.getInt("KEY_RESULT_PROGRESS", 0);
            i3 = extras.getInt("KEY_RESULT_PROGRESS_SOFARBYTES", 0);
            i4 = extras.getInt("KEY_RESULT_PROGRESS_TOTALBYTES", 0);
            str = null;
        } else if (TextUtils.equals(a.d, action)) {
            c = 3;
            str = extras.getString("KEY_REUSLT_FILEPATH");
        } else if (TextUtils.equals(a.e, action)) {
            c = 4;
            i = extras.getInt("KEY_RESULT_ERROR_CODE", 0);
            str2 = extras.getString("KEY_RESULT_ERROR_MSG", "");
            str = null;
        } else if (TextUtils.equals(a.f, action)) {
            c = 5;
            str = null;
        } else if (TextUtils.equals(a.g, action)) {
            c = 6;
            str = null;
        } else if (TextUtils.equals(a.h, action)) {
            c = 7;
            str = null;
        } else if (TextUtils.equals(a.i, action)) {
            c = '\b';
            str = null;
        } else if (TextUtils.equals(a.j, action)) {
            c = '\t';
            str = null;
        } else if (TextUtils.equals(a.k, action)) {
            c = '\n';
            str = null;
        } else if (TextUtils.equals(a.l, action)) {
            c = 11;
            str = null;
        } else if (a.n.equals(action)) {
            com.ksad.download.d.a().c(intent.getIntExtra("download.intent.action.EXTRA_TASK_ID", 0));
            com.ksad.download.e.a().a(intent.getIntExtra("download.intent.action.EXTRA_TASK_ID", 0));
            return;
        } else if (TextUtils.equals(a.m, action)) {
            c = '\f';
            str = null;
        } else {
            str = null;
        }
        f fVar = new f();
        Set<d> keySet = this.b.keySet();
        synchronized (this.b) {
            for (d dVar : keySet) {
                if (dVar != null && TextUtils.equals(dVar.a(), string)) {
                    if (c == 1) {
                        dVar.a(string, fVar);
                    } else if (c == 2) {
                        dVar.a(string, i2, i3, i4);
                    } else if (c == 3) {
                        dVar.a(string, str, fVar);
                    } else if (c == 4) {
                        dVar.a(string, i, str2, fVar);
                    } else if (c == 5) {
                        dVar.b(string, fVar);
                    } else if (c == 6) {
                        dVar.c(string, fVar);
                    } else if (c == 7) {
                        dVar.d(string, fVar);
                    } else if (c == '\b') {
                        dVar.e(string, fVar);
                    } else if (c == '\t') {
                        dVar.a(string);
                    } else if (c == '\n') {
                        dVar.a(string, 0, fVar);
                    } else if (c == 11) {
                        dVar.b(string);
                    } else if (c == '\f') {
                        dVar.f(string, fVar);
                    }
                }
            }
        }
        if (c == 3) {
            a(string, fVar);
        }
    }

    private void a(String str, f fVar) {
        AdTemplate value;
        for (Map.Entry<String, AdTemplate> entry : this.e.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                AdInfo j = com.kwad.sdk.core.response.b.c.j(value);
                com.kwad.sdk.core.a.a().a(str, value);
                if (!TextUtils.isEmpty(str) && j.downloadId.equals(str) && !value.mDownloadFinishReported) {
                    if (fVar.b()) {
                        com.kwad.sdk.core.report.b.c(value);
                        fVar.a();
                    }
                    value.mDownloadFinishReported = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(a.b);
        intentFilter.addAction(a.c);
        intentFilter.addAction(a.d);
        intentFilter.addAction(a.e);
        intentFilter.addAction(a.f);
        intentFilter.addAction(a.g);
        intentFilter.addAction(a.h);
        intentFilter.addAction(a.i);
        intentFilter.addAction(a.j);
        intentFilter.addAction(a.k);
        intentFilter.addAction(a.m);
        intentFilter.addAction(a.l);
        intentFilter.addAction(a.n);
        KsAdSDKImpl.get().getContext().registerReceiver(g, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter2.addDataScheme("package");
        KsAdSDKImpl.get().getContext().registerReceiver(h, intentFilter2);
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent) {
        String schemeSpecificPart = (!TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        f fVar = new f();
        Set<d> keySet = this.b.keySet();
        synchronized (this.b) {
            for (d dVar : keySet) {
                if (dVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, dVar.b())) {
                    dVar.a((String) null, 0, fVar);
                }
            }
        }
        f.a(schemeSpecificPart);
        Set<Map.Entry<String, AdTemplate>> entrySet = this.e.entrySet();
        synchronized (this.e) {
            Iterator<Map.Entry<String, AdTemplate>> it = entrySet.iterator();
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

    public void a(d dVar) {
        this.b.remove(dVar);
    }

    public void a(d dVar, AdTemplate adTemplate) {
        this.b.put(dVar, adTemplate);
    }

    public void a(AdTemplate adTemplate) {
        try {
            String s = com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(adTemplate));
            if (TextUtils.isEmpty(s)) {
                return;
            }
            this.e.put(s, adTemplate);
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }
}
