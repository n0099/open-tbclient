package com.ss.android.downloadlib.a;

import android.os.Environment;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.a.f;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Handler f13253a;
    private AtomicBoolean c = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);
    private d.a pVJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Handler handler) {
        this.f13253a = handler;
    }

    public void a(d.a aVar) {
        this.pVJ = aVar;
    }

    public boolean a() {
        return this.d.get();
    }

    public void a(boolean z) {
        this.d.set(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j, long j2, final f.a aVar) {
        long j3;
        if (aVar != null) {
            this.d.set(false);
            long Sn = com.ss.android.downloadlib.f.d.Sn(i);
            this.c.set(false);
            final String a2 = this.pVJ.pVw.a();
            final com.ss.android.b.a.b.a aaN = com.ss.android.downloadlib.a.b.d.eFT().aaN(a2);
            if (aaN == null) {
                aaN = new com.ss.android.b.a.b.a(this.pVJ.pVw, this.pVJ.pVx, this.pVJ.pVy, 0);
                com.ss.android.downloadlib.a.b.d.eFT().d(aaN);
            }
            aaN.e(false);
            if (j.eGn() != null) {
                j.eGn().a(aaN.j());
            }
            com.ss.android.downloadlib.a.c.d.eFY().a(aaN.z());
            boolean z = com.ss.android.downloadlib.f.d.So(i) && com.ss.android.downloadlib.f.d.Sp(i);
            if (j2 > 0 && com.ss.android.downloadlib.f.d.Sp(i)) {
                com.ss.android.downloadlib.e.a.eGB().a("clean_no_need_fetch_apk_size", aaN);
                a(i, a2, j2, aaN, j, aVar);
                j3 = Sn;
            } else if (z) {
                com.ss.android.downloadlib.e.a.eGB().a("clean_fetch_apk_head_switch_open", aaN);
                final com.ss.android.b.a.b.a aVar2 = aaN;
                a(a2, aaN, new f.b() { // from class: com.ss.android.downloadlib.a.e.1
                    @Override // com.ss.android.downloadlib.a.f.b
                    public void a(long j4) {
                        e.this.a(i, a2, j4, aVar2, j, aVar);
                    }
                });
                j3 = Sn;
            } else {
                com.ss.android.downloadlib.e.a.eGB().a("clean_fetch_apk_head_switch_close", aaN);
                j3 = 0;
            }
            this.f13253a.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.a.e.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!e.this.c.get()) {
                        e.this.c.set(true);
                        com.ss.android.downloadlib.e.a.eGB().a("clean_fetch_apk_head_failed", aaN);
                        aVar.a();
                    }
                }
            }, j3);
        }
    }

    private void a(String str, final com.ss.android.b.a.b.a aVar, final f.b bVar) {
        if (bVar != null) {
            com.ss.android.socialbase.downloader.i.a.b.a(str, new com.ss.android.socialbase.downloader.i.i() { // from class: com.ss.android.downloadlib.a.e.3
                @Override // com.ss.android.socialbase.downloader.i.i
                public void a(Map<String, String> map) {
                    long j;
                    long j2;
                    if (!e.this.c.get()) {
                        e.this.c.set(true);
                        try {
                            if (map != null) {
                                com.ss.android.downloadlib.e.a.eGB().a("clean_fetch_apk_head_success", aVar);
                                j2 = Long.parseLong(map.get("Content-Length"));
                            } else {
                                com.ss.android.downloadlib.e.a.eGB().a("clean_fetch_apk_head_failed", aVar);
                                j2 = 0;
                            }
                            j = j2;
                        } catch (Exception e) {
                            e.printStackTrace();
                            j = 0;
                        }
                        if (j > 0) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt(ConstantData.Logo.LOGO_AD_APK_SIZE, Long.valueOf(j));
                                jSONObject.putOpt("available_space", Long.valueOf(e.this.b()));
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            com.ss.android.downloadlib.e.a.eGB().a("clean_fetch_apk_size_success", jSONObject, aVar);
                        }
                        bVar.a(j);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, String str, long j, final com.ss.android.b.a.b.a aVar, long j2, final f.a aVar2) {
        boolean z;
        this.c.set(true);
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(ConstantData.Logo.LOGO_AD_APK_SIZE, Long.valueOf(j));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            long longValue = (Double.valueOf((com.ss.android.downloadlib.f.d.Sl(i) + 1.0d) * j).longValue() + com.ss.android.downloadlib.f.d.Sm(i)) - j2;
            aVar.e(true);
            long b2 = b();
            if (b2 < longValue) {
                a(aVar, jSONObject, longValue, b2);
                d(aVar);
                long b3 = b();
                if (b3 < longValue) {
                    aVar.d(true);
                    final String z2 = aVar.z();
                    com.ss.android.downloadlib.a.c.d.eFY().a(z2, new com.ss.android.downloadlib.a.c.e() { // from class: com.ss.android.downloadlib.a.e.4
                    });
                    z = a(i, aVar, str, longValue);
                    if (z) {
                        this.f13253a.post(new Runnable() { // from class: com.ss.android.downloadlib.a.e.5
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar2.a();
                            }
                        });
                        return;
                    }
                    return;
                }
                aVar.j("1");
                com.ss.android.downloadlib.a.b.g.eFW().d(aVar);
                try {
                    jSONObject.putOpt("quite_clean_size", Long.valueOf(b3 - b2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.eGB().a("cleanspace_download_after_quite_clean", jSONObject, aVar);
            }
        }
        z = false;
        if (z) {
        }
    }

    private boolean a(int i, @NonNull com.ss.android.b.a.b.a aVar, String str, long j) {
        if (!com.ss.android.downloadlib.f.d.Sq(i)) {
            com.ss.android.downloadlib.e.a.eGB().a("clean_space_switch_closed", aVar);
            return false;
        }
        com.ss.android.downloadlib.e.a.eGB().a("cleanspace_switch_open", aVar);
        if (j.eGn() != null) {
            return j.eGn().e(i, str, j);
        }
        com.ss.android.a.a.a.l eGo = j.eGo();
        if (eGo != null) {
            int a2 = eGo.a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("plugin_status", Integer.valueOf(a2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.e.a.eGB().a("clean_ad_plugin_status", jSONObject, aVar);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eGB().a("cleanspace_window_show", jSONObject2, aVar);
        return false;
    }

    private void d(com.ss.android.b.a.b.a aVar) {
        long b2 = b();
        if (j.eGn() != null) {
            j.eGn().b();
        }
        com.ss.android.downloadlib.a.c.c.a();
        com.ss.android.downloadlib.a.c.c.b();
        if (com.ss.android.downloadlib.f.d.Sr(aVar.t())) {
            com.ss.android.downloadlib.a.c.c.a(j.a());
        }
        long b3 = b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(b3 - b2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eGB().a("clean_quite_finish", jSONObject, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long b() {
        try {
            return com.ss.android.socialbase.downloader.m.d.c(Environment.getExternalStorageDirectory().toString());
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private void a(com.ss.android.b.a.b.a aVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eGB().a("clean_space_no_enough_for_download", jSONObject, aVar);
    }
}
