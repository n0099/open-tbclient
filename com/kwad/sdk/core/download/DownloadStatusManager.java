package com.kwad.sdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
/* loaded from: classes6.dex */
public class DownloadStatusManager {

    /* renamed from: f  reason: collision with root package name */
    public static com.ksad.download.f f33810f = new com.kwad.sdk.core.download.c.a();

    /* renamed from: g  reason: collision with root package name */
    public static final BroadcastReceiver f33811g = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadStatusManager.a().a(intent);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static final BroadcastReceiver f33812h = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadStatusManager.a().b(intent);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap<d, AdTemplate> f33813a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<d, AdTemplate> f33814b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f33815c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, AdTemplate> f33816d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, AdTemplate> f33817e;

    /* loaded from: classes6.dex */
    public enum Holder {
        INSTANCE;
        
        public DownloadStatusManager mInstance = new DownloadStatusManager();
        public final Object lock = new Object();

        Holder() {
        }

        public DownloadStatusManager getInstance() {
            if (!this.mInstance.f33815c) {
                synchronized (this.lock) {
                    this.mInstance.b();
                }
            }
            return this.mInstance;
        }
    }

    public DownloadStatusManager() {
        WeakHashMap<d, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.f33813a = weakHashMap;
        this.f33814b = Collections.synchronizedMap(weakHashMap);
        this.f33815c = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.f33816d = hashMap;
        this.f33817e = Collections.synchronizedMap(hashMap);
        b();
    }

    public static DownloadStatusManager a() {
        return Holder.INSTANCE.getInstance();
    }

    public static void a(Context context) {
        if (Holder.INSTANCE.mInstance.f33815c) {
            try {
                synchronized (Holder.INSTANCE.lock) {
                    if (Holder.INSTANCE.mInstance.f33815c) {
                        context.unregisterReceiver(f33811g);
                        context.unregisterReceiver(f33812h);
                        Holder.INSTANCE.mInstance.f33814b.clear();
                        Holder.INSTANCE.mInstance.f33817e.clear();
                        Holder.INSTANCE.mInstance.f33815c = false;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        char c2;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString("RESULT_DOWNLOAD_ID");
        String action = intent.getAction();
        char c3 = 2;
        if (TextUtils.equals(a.f33819b, action)) {
            str = "";
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            c2 = 1;
        } else if (TextUtils.equals(a.f33820c, action)) {
            i = extras.getInt("KEY_RESULT_PROGRESS", 0);
            i4 = extras.getInt("KEY_RESULT_PROGRESS_SOFARBYTES", 0);
            str2 = null;
            c2 = 2;
            i3 = extras.getInt("KEY_RESULT_PROGRESS_TOTALBYTES", 0);
            str = "";
            i2 = 0;
        } else if (TextUtils.equals(a.f33821d, action)) {
            String string2 = extras.getString("KEY_REUSLT_FILEPATH");
            str = "";
            str2 = string2;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            c2 = 3;
        } else if (TextUtils.equals(a.f33822e, action)) {
            int i5 = extras.getInt("KEY_RESULT_ERROR_CODE", 0);
            str = extras.getString("KEY_RESULT_ERROR_MSG", "");
            str2 = null;
            i3 = 0;
            i4 = 0;
            c2 = 4;
            i2 = i5;
            i = 0;
        } else if (TextUtils.equals(a.f33823f, action)) {
            str = "";
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            c2 = 5;
        } else if (TextUtils.equals(a.f33824g, action)) {
            str = "";
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            c2 = 6;
        } else if (TextUtils.equals(a.f33825h, action)) {
            str = "";
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            c2 = 7;
        } else if (TextUtils.equals(a.i, action)) {
            str = "";
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            c2 = '\b';
        } else if (TextUtils.equals(a.j, action)) {
            str = "";
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            c2 = '\t';
        } else if (TextUtils.equals(a.k, action)) {
            str = "";
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            c2 = '\n';
        } else if (TextUtils.equals(a.l, action)) {
            str = "";
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            c2 = 11;
        } else if (a.n.equals(action)) {
            com.ksad.download.d.a().c(intent.getIntExtra("download.intent.action.EXTRA_TASK_ID", 0));
            com.ksad.download.e.a().a(intent.getIntExtra("download.intent.action.EXTRA_TASK_ID", 0));
            return;
        } else {
            str = "";
            str2 = null;
            if (TextUtils.equals(a.m, action)) {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                c2 = '\f';
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                c2 = 0;
            }
        }
        f fVar = new f();
        Set<d> keySet = this.f33814b.keySet();
        synchronized (this.f33814b) {
            for (d dVar : keySet) {
                if (dVar != null) {
                    if (TextUtils.equals(dVar.a(), string)) {
                        if (c2 == 1) {
                            dVar.a(string, fVar);
                        } else if (c2 == c3) {
                            dVar.a(string, i, i4, i3);
                        } else if (c2 == 3) {
                            dVar.a(string, str2, fVar);
                        } else {
                            if (c2 == 4) {
                                dVar.a(string, i2, str, fVar);
                            } else if (c2 == 5) {
                                dVar.b(string, fVar);
                            } else if (c2 == 6) {
                                dVar.c(string, fVar);
                            } else if (c2 == 7) {
                                dVar.d(string, fVar);
                            } else if (c2 == '\b') {
                                dVar.e(string, fVar);
                            } else if (c2 == '\t') {
                                dVar.a(string);
                            } else if (c2 == '\n') {
                                dVar.a(string, 0, fVar);
                            } else if (c2 == 11) {
                                dVar.b(string);
                            } else {
                                if (c2 == '\f') {
                                    dVar.f(string, fVar);
                                }
                                c3 = 2;
                            }
                            c3 = 2;
                        }
                    }
                    c3 = 2;
                }
            }
        }
        if (c2 == 3) {
            a(string, fVar);
        }
    }

    private void a(String str, f fVar) {
        AdTemplate value;
        for (Map.Entry<String, AdTemplate> entry : this.f33817e.entrySet()) {
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
        if (this.f33815c || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(a.f33819b);
        intentFilter.addAction(a.f33820c);
        intentFilter.addAction(a.f33821d);
        intentFilter.addAction(a.f33822e);
        intentFilter.addAction(a.f33823f);
        intentFilter.addAction(a.f33824g);
        intentFilter.addAction(a.f33825h);
        intentFilter.addAction(a.i);
        intentFilter.addAction(a.j);
        intentFilter.addAction(a.k);
        intentFilter.addAction(a.m);
        intentFilter.addAction(a.l);
        intentFilter.addAction(a.n);
        KsAdSDKImpl.get().getContext().registerReceiver(f33811g, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter2.addDataScheme("package");
        KsAdSDKImpl.get().getContext().registerReceiver(f33812h, intentFilter2);
        this.f33815c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent) {
        String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        f fVar = new f();
        Set<d> keySet = this.f33814b.keySet();
        synchronized (this.f33814b) {
            for (d dVar : keySet) {
                if (dVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, dVar.b())) {
                    dVar.a((String) null, 0, fVar);
                }
            }
        }
        f33810f.a(schemeSpecificPart);
        Set<Map.Entry<String, AdTemplate>> entrySet = this.f33817e.entrySet();
        synchronized (this.f33817e) {
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
        this.f33814b.remove(dVar);
    }

    public void a(d dVar, AdTemplate adTemplate) {
        this.f33814b.put(dVar, adTemplate);
    }

    public void a(AdTemplate adTemplate) {
        try {
            String s = com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(adTemplate));
            if (TextUtils.isEmpty(s)) {
                return;
            }
            this.f33817e.put(s, adTemplate);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }
}
