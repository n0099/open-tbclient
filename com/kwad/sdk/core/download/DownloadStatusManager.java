package com.kwad.sdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public class DownloadStatusManager {

    /* renamed from: f  reason: collision with root package name */
    public static com.ksad.download.f f34241f = new com.kwad.sdk.core.download.c.a();

    /* renamed from: g  reason: collision with root package name */
    public static final BroadcastReceiver f34242g = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadStatusManager.a().a(intent);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static final BroadcastReceiver f34243h = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.DownloadStatusManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadStatusManager.a().b(intent);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap<d, AdTemplate> f34244a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<d, AdTemplate> f34245b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f34246c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, AdTemplate> f34247d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, AdTemplate> f34248e;

    /* loaded from: classes7.dex */
    public enum Holder {
        INSTANCE;
        
        public DownloadStatusManager mInstance = new DownloadStatusManager();
        public final Object lock = new Object();

        Holder() {
        }

        public DownloadStatusManager getInstance() {
            if (!this.mInstance.f34246c) {
                synchronized (this.lock) {
                    this.mInstance.b();
                }
            }
            return this.mInstance;
        }
    }

    public DownloadStatusManager() {
        WeakHashMap<d, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.f34244a = weakHashMap;
        this.f34245b = Collections.synchronizedMap(weakHashMap);
        this.f34246c = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.f34247d = hashMap;
        this.f34248e = Collections.synchronizedMap(hashMap);
        b();
    }

    public static DownloadStatusManager a() {
        return Holder.INSTANCE.getInstance();
    }

    public static void a(Context context) {
        if (Holder.INSTANCE.mInstance.f34246c) {
            try {
                synchronized (Holder.INSTANCE.lock) {
                    if (Holder.INSTANCE.mInstance.f34246c) {
                        context.unregisterReceiver(f34242g);
                        context.unregisterReceiver(f34243h);
                        Holder.INSTANCE.mInstance.f34245b.clear();
                        Holder.INSTANCE.mInstance.f34248e.clear();
                        Holder.INSTANCE.mInstance.f34246c = false;
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
        int i2;
        int i3;
        int i4;
        int i5;
        char c2;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString("RESULT_DOWNLOAD_ID");
        String action = intent.getAction();
        char c3 = 2;
        if (TextUtils.equals(a.f34250b, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 1;
        } else if (TextUtils.equals(a.f34251c, action)) {
            i2 = extras.getInt("KEY_RESULT_PROGRESS", 0);
            i5 = extras.getInt("KEY_RESULT_PROGRESS_SOFARBYTES", 0);
            str2 = null;
            c2 = 2;
            i4 = extras.getInt("KEY_RESULT_PROGRESS_TOTALBYTES", 0);
            str = "";
            i3 = 0;
        } else if (TextUtils.equals(a.f34252d, action)) {
            String string2 = extras.getString("KEY_REUSLT_FILEPATH");
            str = "";
            str2 = string2;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 3;
        } else if (TextUtils.equals(a.f34253e, action)) {
            int i6 = extras.getInt("KEY_RESULT_ERROR_CODE", 0);
            str = extras.getString("KEY_RESULT_ERROR_MSG", "");
            str2 = null;
            i4 = 0;
            i5 = 0;
            c2 = 4;
            i3 = i6;
            i2 = 0;
        } else if (TextUtils.equals(a.f34254f, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 5;
        } else if (TextUtils.equals(a.f34255g, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 6;
        } else if (TextUtils.equals(a.f34256h, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 7;
        } else if (TextUtils.equals(a.f34257i, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = '\b';
        } else if (TextUtils.equals(a.j, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = '\t';
        } else if (TextUtils.equals(a.k, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = '\n';
        } else if (TextUtils.equals(a.l, action)) {
            str = "";
            str2 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            c2 = 11;
        } else if (a.n.equals(action)) {
            com.ksad.download.d.a().c(intent.getIntExtra("download.intent.action.EXTRA_TASK_ID", 0));
            com.ksad.download.e.a().a(intent.getIntExtra("download.intent.action.EXTRA_TASK_ID", 0));
            return;
        } else {
            str = "";
            str2 = null;
            if (TextUtils.equals(a.m, action)) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                c2 = '\f';
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                c2 = 0;
            }
        }
        f fVar = new f();
        Set<d> keySet = this.f34245b.keySet();
        synchronized (this.f34245b) {
            for (d dVar : keySet) {
                if (dVar != null) {
                    if (TextUtils.equals(dVar.a(), string)) {
                        if (c2 == 1) {
                            dVar.a(string, fVar);
                        } else if (c2 == c3) {
                            dVar.a(string, i2, i5, i4);
                        } else if (c2 == 3) {
                            dVar.a(string, str2, fVar);
                        } else {
                            if (c2 == 4) {
                                dVar.a(string, i3, str, fVar);
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
        for (Map.Entry<String, AdTemplate> entry : this.f34248e.entrySet()) {
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
        if (this.f34246c || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(a.f34250b);
        intentFilter.addAction(a.f34251c);
        intentFilter.addAction(a.f34252d);
        intentFilter.addAction(a.f34253e);
        intentFilter.addAction(a.f34254f);
        intentFilter.addAction(a.f34255g);
        intentFilter.addAction(a.f34256h);
        intentFilter.addAction(a.f34257i);
        intentFilter.addAction(a.j);
        intentFilter.addAction(a.k);
        intentFilter.addAction(a.m);
        intentFilter.addAction(a.l);
        intentFilter.addAction(a.n);
        KsAdSDKImpl.get().getContext().registerReceiver(f34242g, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter2.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        KsAdSDKImpl.get().getContext().registerReceiver(f34243h, intentFilter2);
        this.f34246c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent) {
        String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        f fVar = new f();
        Set<d> keySet = this.f34245b.keySet();
        synchronized (this.f34245b) {
            for (d dVar : keySet) {
                if (dVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, dVar.b())) {
                    dVar.a((String) null, 0, fVar);
                }
            }
        }
        f34241f.a(schemeSpecificPart);
        Set<Map.Entry<String, AdTemplate>> entrySet = this.f34248e.entrySet();
        synchronized (this.f34248e) {
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
        this.f34245b.remove(dVar);
    }

    public void a(d dVar, AdTemplate adTemplate) {
        this.f34245b.put(dVar, adTemplate);
    }

    public void a(AdTemplate adTemplate) {
        try {
            String s = com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(adTemplate));
            if (TextUtils.isEmpty(s)) {
                return;
            }
            this.f34248e.put(s, adTemplate);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }
}
