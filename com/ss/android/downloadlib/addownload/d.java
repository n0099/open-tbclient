package com.ss.android.downloadlib.addownload;

import android.net.http.Headers;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public com.ss.android.downloadlib.addownload.b.e f59558b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f59559c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f59560d = new AtomicBoolean(false);

    public d(Handler handler) {
        this.a = handler;
    }

    public static long b() {
        if (j.l() != null) {
            return j.l().a();
        }
        return 0L;
    }

    public static long d() {
        return com.ss.android.downloadlib.g.l.a(0L);
    }

    private void b(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j2, long j3) {
        bVar.l("1");
        com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j3 - j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, bVar);
    }

    public void a(com.ss.android.downloadlib.addownload.b.e eVar) {
        this.f59558b = eVar;
    }

    public boolean a() {
        return this.f59560d.get();
    }

    public void a(boolean z) {
        this.f59560d.set(z);
    }

    public void a(final int i2, final long j2, long j3, final e.a aVar) {
        this.f59560d.set(false);
        if (aVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.g.e.f(i2) && com.ss.android.downloadlib.g.e.e(i2)) {
            long c2 = com.ss.android.downloadlib.g.e.c(i2);
            this.f59559c.set(false);
            final String downloadUrl = this.f59558b.f59509b.getDownloadUrl();
            com.ss.android.downloadad.api.a.b b2 = com.ss.android.downloadlib.addownload.b.f.a().b(downloadUrl);
            if (b2 == null) {
                com.ss.android.downloadlib.addownload.b.e eVar = this.f59558b;
                b2 = new com.ss.android.downloadad.api.a.b(eVar.f59509b, eVar.f59510c, eVar.f59511d, 0);
                com.ss.android.downloadlib.addownload.b.f.a().a(b2);
            }
            final com.ss.android.downloadad.api.a.b bVar = b2;
            bVar.e(false);
            if (j.l() != null) {
                j.l().a(bVar.b());
            }
            com.ss.android.downloadlib.addownload.c.d.a().a(bVar.a());
            boolean d2 = com.ss.android.downloadlib.g.e.d(i2);
            if (j3 > 0) {
                a(i2, downloadUrl, j3, bVar, j2, aVar);
            } else if (d2) {
                a(downloadUrl, bVar, new e.b() { // from class: com.ss.android.downloadlib.addownload.d.1
                    @Override // com.ss.android.downloadlib.addownload.e.b
                    public void a(long j4) {
                        d.this.a(i2, downloadUrl, j4, bVar, j2, aVar);
                    }
                });
            } else {
                c2 = 0;
            }
            this.a.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f59559c.get()) {
                        return;
                    }
                    d.this.f59559c.set(true);
                    aVar.a();
                }
            }, c2);
            return;
        }
        aVar.a();
    }

    private void a(String str, com.ss.android.downloadad.api.a.b bVar, final e.b bVar2) {
        if (bVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.a.b.a(str, new com.ss.android.socialbase.downloader.network.j() { // from class: com.ss.android.downloadlib.addownload.d.3
            @Override // com.ss.android.socialbase.downloader.network.j
            public void a(Map<String, String> map) {
                if (d.this.f59559c.get()) {
                    return;
                }
                d.this.f59559c.set(true);
                long a = d.this.a(map);
                if (a > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(a));
                        jSONObject.putOpt("available_space", Long.valueOf(d.d()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                bVar2.a(a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String value = entry.getValue();
                    if (Headers.CONTENT_LEN.equalsIgnoreCase(entry.getKey())) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, long j2, final com.ss.android.downloadad.api.a.b bVar, long j3, final e.a aVar) {
        this.f59559c.set(true);
        boolean z = false;
        if (j2 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            long longValue = (Double.valueOf((com.ss.android.downloadlib.g.e.a(i2) + 1.0d) * j2).longValue() + com.ss.android.downloadlib.g.e.b(i2)) - j3;
            long d2 = d();
            if (d2 < longValue) {
                a(bVar, jSONObject, longValue, d2);
                a(bVar);
                long d3 = d();
                if (d3 < longValue) {
                    bVar.d(true);
                    final String a = bVar.a();
                    com.ss.android.downloadlib.addownload.c.d.a().a(a, new com.ss.android.downloadlib.addownload.c.e() { // from class: com.ss.android.downloadlib.addownload.d.4
                    });
                    z = a(i2, bVar, str, longValue);
                    if (z) {
                        bVar.e(true);
                    }
                } else {
                    b(bVar, jSONObject, d2, d3);
                }
            }
        }
        if (z) {
            return;
        }
        this.a.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.5
            @Override // java.lang.Runnable
            public void run() {
                aVar.a();
            }
        });
    }

    private boolean a(int i2, @NonNull com.ss.android.downloadad.api.a.b bVar, String str, long j2) {
        if (com.ss.android.downloadlib.g.e.f(i2)) {
            if (j.l() != null) {
                return j.l().a(i2, str, true, j2);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("show_dialog_result", 3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject, bVar);
            return false;
        }
        return false;
    }

    public static boolean a(final DownloadInfo downloadInfo, long j2) {
        int id = downloadInfo.getId();
        boolean z = false;
        if (com.ss.android.downloadlib.g.e.f(id)) {
            if (j.l() != null && (z = j.l().a(id, downloadInfo.getUrl(), false, j2))) {
                com.ss.android.downloadlib.addownload.c.d.a().a(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.c.e() { // from class: com.ss.android.downloadlib.addownload.d.6
                });
            }
            return z;
        }
        return false;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(int i2) {
        if (com.ss.android.downloadlib.g.e.f(i2) && j.l() != null && j.l().b()) {
            j.l().c();
        }
    }

    public static void a(com.ss.android.downloadad.api.a.b bVar) {
        long d2 = d();
        if (j.l() != null) {
            j.l().e();
        }
        com.ss.android.downloadlib.addownload.c.c.a();
        com.ss.android.downloadlib.addownload.c.c.b();
        if (com.ss.android.downloadlib.g.e.g(bVar.s())) {
            com.ss.android.downloadlib.addownload.c.c.a(j.getContext());
        }
        long d3 = d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(d3 - d2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_quite_finish", jSONObject, bVar);
    }

    private void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j2, long j3) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j3));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_space_no_enough_for_download", jSONObject, bVar);
    }
}
