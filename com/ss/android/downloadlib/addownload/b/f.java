package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<Long, DownloadModel> f59512b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<Long, DownloadEventConfig> f59513c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentHashMap<Long, DownloadController> f59514d;

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> f59515e;

    /* loaded from: classes4.dex */
    public static class a {
        public static f a = new f();
    }

    public DownloadController c(long j2) {
        return this.f59514d.get(Long.valueOf(j2));
    }

    public com.ss.android.downloadad.api.a.b d(long j2) {
        return this.f59515e.get(Long.valueOf(j2));
    }

    @NonNull
    public e e(long j2) {
        e eVar = new e();
        eVar.a = j2;
        eVar.f59509b = a(j2);
        DownloadEventConfig b2 = b(j2);
        eVar.f59510c = b2;
        if (b2 == null) {
            eVar.f59510c = new com.ss.android.download.api.download.c();
        }
        DownloadController c2 = c(j2);
        eVar.f59511d = c2;
        if (c2 == null) {
            eVar.f59511d = new com.ss.android.download.api.download.b();
        }
        return eVar;
    }

    public void f(long j2) {
        this.f59512b.remove(Long.valueOf(j2));
        this.f59513c.remove(Long.valueOf(j2));
        this.f59514d.remove(Long.valueOf(j2));
    }

    public f() {
        this.a = false;
        this.f59512b = new ConcurrentHashMap<>();
        this.f59513c = new ConcurrentHashMap<>();
        this.f59514d = new ConcurrentHashMap<>();
        this.f59515e = new ConcurrentHashMap<>();
    }

    public void b() {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.a) {
                    return;
                }
                synchronized (f.class) {
                    if (!f.this.a) {
                        f.this.f59515e.putAll(i.a().b());
                        f.this.a = true;
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> c() {
        return this.f59515e;
    }

    public static f a() {
        return a.a;
    }

    public DownloadEventConfig b(long j2) {
        return this.f59513c.get(Long.valueOf(j2));
    }

    public void a(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.f59512b.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public com.ss.android.downloadad.api.a.b b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.f59515e.values()) {
            if (bVar != null && str.equals(bVar.a())) {
                return bVar;
            }
        }
        return null;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.f59512b.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void a(long j2, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.f59513c.put(Long.valueOf(j2), downloadEventConfig);
        }
    }

    public void a(long j2, DownloadController downloadController) {
        if (downloadController != null) {
            this.f59514d.put(Long.valueOf(j2), downloadController);
        }
    }

    public synchronized void a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f59515e.put(Long.valueOf(bVar.b()), bVar);
        i.a().a(bVar);
    }

    public DownloadModel a(long j2) {
        return this.f59512b.get(Long.valueOf(j2));
    }

    public com.ss.android.downloadad.api.a.b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.f59515e.values()) {
            if (bVar != null && str.equals(bVar.e())) {
                return bVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.a.b a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.f59515e.values()) {
            if (bVar != null && bVar.s() == downloadInfo.getId()) {
                return bVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long a2 = l.a(new JSONObject(downloadInfo.getExtra()), "extra");
                if (a2 != 0) {
                    for (com.ss.android.downloadad.api.a.b bVar2 : this.f59515e.values()) {
                        if (bVar2 != null && bVar2.b() == a2) {
                            return bVar2;
                        }
                    }
                    com.ss.android.downloadlib.e.c.a().a("getNativeModelByInfo");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.a.b bVar3 : this.f59515e.values()) {
            if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.getUrl())) {
                return bVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.a.b a(int i2) {
        for (com.ss.android.downloadad.api.a.b bVar : this.f59515e.values()) {
            if (bVar != null && bVar.s() == i2) {
                return bVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.a.b> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.a.b bVar : this.f59515e.values()) {
                if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                    bVar.b(str2);
                    hashMap.put(Long.valueOf(bVar.b()), bVar);
                }
            }
        }
        return hashMap;
    }

    public synchronized void a(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (Long l : list) {
            long longValue = l.longValue();
            arrayList.add(String.valueOf(longValue));
            this.f59515e.remove(Long.valueOf(longValue));
        }
        i.a().a((List<String>) arrayList);
    }
}
