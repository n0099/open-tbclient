package com.ss.android.downloadlib.e;

import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.ss.android.a.a.d.d;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.a.b.g;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.b;
import com.ss.android.downloadlib.f.e;
import com.ss.android.downloadlib.f.i;
import com.ss.android.socialbase.downloader.g.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1225a {
        private static a qcZ = new a();
    }

    public static a eFk() {
        return C1225a.qcZ;
    }

    private a() {
    }

    public void a(long j, int i) {
        d.a jf = d.eEB().jf(j);
        if (jf.a()) {
            i.b();
        } else if (jf.qbB.l()) {
            String c = i == 1 ? jf.qbB.c() : jf.qbB.b();
            String a2 = i.a(jf.qbB.d(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2));
                jSONObject.putOpt(AlaRecorderLog.KEY_NETWORK_AVAILABLE, Integer.valueOf(com.ss.android.socialbase.downloader.m.d.b(j.a()) ? 1 : 2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(c, a2, jSONObject, jf.qbA, jf.qbB);
        }
    }

    public void a(long j, int i, c cVar) {
        d.a jf = d.eEB().jf(j);
        if (jf.a()) {
            i.b();
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        switch (i) {
            case 1:
                str = i.a(jf.qbB.i(), "storage_deny");
                break;
            case 2:
                str = i.a(jf.qbB.e(), "click_start");
                a(cVar, jSONObject);
                break;
            case 3:
                str = i.a(jf.qbB.f(), "click_pause");
                b(cVar, jSONObject);
                break;
            case 4:
                str = i.a(jf.qbB.g(), "click_continue");
                c(cVar, jSONObject);
                break;
            case 5:
                if (cVar != null) {
                    try {
                        e.a(jSONObject, cVar.g());
                        b.a(jSONObject, cVar);
                    } catch (Throwable th) {
                    }
                }
                str = i.a(jf.qbB.h(), "click_install");
                break;
        }
        a(jf.qbB.b(), str, jSONObject, jf.qbA.g(), 1, jf.qbA, jf.qbB);
    }

    public void b(long j, int i) {
        a(j, i, (c) null);
    }

    public void a(String str, long j) {
        com.ss.android.b.a.b.a je = d.eEB().je(j);
        if (je == null) {
            i.b();
        } else {
            b(je.x(), str, null, je);
        }
    }

    public void a(String str, @NonNull com.ss.android.a.a.b.c cVar, @NonNull com.ss.android.a.a.b.b bVar) {
        a(bVar.b(), str, cVar.eEf(), cVar, bVar);
    }

    public void a(String str, @NonNull d.a aVar) {
        a(aVar.qbB.b(), str, aVar.qbA.eEf(), aVar.qbA, aVar.qbB);
    }

    public void a(String str, JSONObject jSONObject, @NonNull d.a aVar) {
        a(aVar.qbB.b(), str, jSONObject, aVar.qbA, aVar.qbB);
    }

    public void a(String str, int i, d.a aVar) {
        a(aVar.qbB.b(), str, null, i, 2, aVar.qbA, aVar.qbB);
    }

    public void a(long j, boolean z, int i) {
        d.a jf = d.eEB().jf(j);
        if (jf.a()) {
            i.b();
        } else if (jf.qbA.eEg() != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("click_type", Integer.valueOf(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(jf.qbB.b(), z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, jf.qbA, jf.qbB);
        }
    }

    private void a(c cVar, JSONObject jSONObject) {
        try {
            c(cVar, jSONObject);
            com.ss.android.b.a.b.a j = d.eEB().j(cVar);
            if (j != null) {
                jSONObject.put("is_update_download", j.I() ? 1 : 2);
                e.a(j, jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(c cVar, JSONObject jSONObject) {
        com.ss.android.b.a.b.a j;
        double d;
        if (jSONObject != null && (j = d.eEB().j(cVar)) != null) {
            try {
                c(cVar, jSONObject);
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - j.eEq()));
                jSONObject.putOpt("click_download_size", Long.valueOf(j.eEr()));
                jSONObject.putOpt("download_length", Long.valueOf(cVar.eHi()));
                jSONObject.putOpt("download_apk_size", Long.valueOf(cVar.eir()));
                j.d();
                g.eEE().d(j);
                jSONObject.put("click_pause_times", j.c());
                long eir = cVar.eir();
                long eHi = cVar.eHi();
                if (eHi >= 0 && eir > 0) {
                    d = eHi / eir;
                } else {
                    d = 0.0d;
                }
                jSONObject.put("download_percent", d);
                jSONObject.put("download_status", cVar.w());
                long currentTimeMillis = System.currentTimeMillis();
                long n = j.n();
                if (n > 0) {
                    jSONObject.put("time_from_start_download", currentTimeMillis - n);
                }
                long e = j.e();
                if (e > 0) {
                    jSONObject.put("time_from_download_resume", currentTimeMillis - e);
                }
                jSONObject.putOpt("fail_status", Integer.valueOf(j.h()));
                jSONObject.putOpt("fail_msg", j.i());
                jSONObject.put("download_failed_times", j.a());
                jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
                jSONObject.put("first_speed_time", cVar.eos());
                jSONObject.put("all_connect_time", cVar.eHa());
                jSONObject.put("download_prepare_time", cVar.eEp());
                jSONObject.put("download_time", cVar.eHC() + cVar.eHa() + cVar.eEp());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c(c cVar, JSONObject jSONObject) {
        if (cVar != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(cVar.eir()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(cVar.eHi()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(cVar.eHU()));
                jSONObject.putOpt("app_name", cVar.i());
                jSONObject.putOpt("network_quality", cVar.eHk());
                jSONObject.putOpt("save_path", cVar.k());
                com.ss.android.b.a.b.a QV = d.eEB().QV(cVar.g());
                if (QV != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(QV.eEq()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(QV.eEr()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2));
        jSONObject.putOpt(AlaRecorderLog.KEY_NETWORK_AVAILABLE, Integer.valueOf(com.ss.android.socialbase.downloader.m.d.b(j.a()) ? 1 : 2));
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(com.ss.android.socialbase.downloader.m.d.a(j.a()) ? 1 : 2));
    }

    public void a(long j, com.ss.android.socialbase.downloader.e.a aVar) {
        d.a jf = d.eEB().jf(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (aVar != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(aVar.a()));
                jSONObject.putOpt("fail_msg", aVar.b());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(jf.qbB.b(), "download_failed", jSONObject, jf.qbA, jf.qbB);
    }

    public void a(String str, String str2, com.ss.android.b.a.b.a aVar) {
        if (aVar == null) {
            i.b();
        } else {
            b(str, str2, null, aVar);
        }
    }

    public void a(String str, com.ss.android.b.a.b.a aVar) {
        if (aVar == null) {
            i.b();
        } else {
            b(aVar.x(), str, null, aVar);
        }
    }

    public void a(String str, String str2, JSONObject jSONObject, @NonNull com.ss.android.b.a.b.a aVar) {
        b(str, str2, jSONObject, aVar);
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.b.a.b.a aVar) {
        if (aVar == null) {
            i.b();
        } else {
            b("embeded_ad", str, jSONObject, aVar);
        }
    }

    public void a(JSONObject jSONObject, @NonNull com.ss.android.b.a.b.a aVar) {
        b(aVar.x(), "download_finish", jSONObject, aVar);
    }

    public void a(c cVar) {
        com.ss.android.b.a.b.a j = d.eEB().j(cVar);
        if (j != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                c(cVar, jSONObject);
                j.a(System.currentTimeMillis());
                a(j.x(), "download_resume", jSONObject, j);
                g.eEE().d(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void b(JSONObject jSONObject, @NonNull com.ss.android.b.a.b.a aVar) {
        com.ss.android.downloadlib.guide.install.c.a(jSONObject);
        b(aVar.x(), "install_finish", jSONObject, aVar);
    }

    public void a(c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
        if (cVar != null) {
            com.ss.android.b.a.b.a j = d.eEB().j(cVar);
            if (j == null) {
                i.b();
            } else if (!j.f12922a.get()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    b.a(jSONObject, cVar, true);
                    jSONObject.putOpt("fail_status", Integer.valueOf(j.h()));
                    jSONObject.putOpt("fail_msg", j.i());
                    jSONObject.put("download_failed_times", j.a());
                    if (cVar.eir() > 0) {
                        jSONObject.put("download_percent", cVar.eHi() / cVar.eir());
                    }
                    jSONObject.put("download_status", cVar.w());
                    long currentTimeMillis = System.currentTimeMillis();
                    if (j.n() > 0) {
                        jSONObject.put("time_from_start_download", currentTimeMillis - j.n());
                    }
                    if (j.e() > 0) {
                        jSONObject.put("time_from_download_resume", currentTimeMillis - j.e());
                    }
                    jSONObject.put("is_update_download", j.I() ? 1 : 2);
                    jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
                    jSONObject.put("has_send_download_failed_finally", j.f12923b.get() ? 1 : 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(j.x(), "download_cancel", jSONObject, j);
            }
        }
    }

    public void b(c cVar, com.ss.android.socialbase.downloader.e.a aVar) {
        if (cVar != null) {
            com.ss.android.b.a.b.a j = d.eEB().j(cVar);
            if (j == null) {
                i.b();
            } else if (!j.f12922a.get()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    c(cVar, jSONObject);
                    b.a(jSONObject, cVar, true);
                    if (aVar != null) {
                        jSONObject.putOpt("fail_status", Integer.valueOf(aVar.a()));
                        jSONObject.putOpt("fail_msg", aVar.b());
                        j.d(aVar.a());
                        j.a(aVar.b());
                    }
                    j.b();
                    jSONObject.put("download_failed_times", j.a());
                    if (cVar.eir() > 0) {
                        jSONObject.put("download_percent", cVar.eHi() / cVar.eir());
                    }
                    jSONObject.put("has_send_download_failed_finally", j.f12923b.get() ? 1 : 2);
                    e.a(j, jSONObject);
                    jSONObject.put("is_update_download", j.I() ? 1 : 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(j.x(), "download_failed", jSONObject, j);
                g.eEE().d(j);
            }
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar) {
        a(str, str2, jSONObject, cVar.g(), 2, cVar, bVar);
    }

    private void a(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar) {
        try {
            a(new d.a().aav(i.a(str, "embeded_ad")).aaw(str2).BL(cVar.t()).iW(cVar.d()).aax(cVar.u()).iX(j).aay(bVar.a()).gU(cVar.eEe()).fa(i.a(f(cVar), bVar.eEc(), jSONObject)).bF(bVar.eEb()).QN(i).BK(bVar.m()).eEl());
        } catch (Exception e) {
            i.a(e);
        }
    }

    private void b(String str, String str2, JSONObject jSONObject, com.ss.android.b.a.b.a aVar) {
        try {
            a(new d.a().aav(i.a(str, "embeded_ad")).aaw(str2).BL(aVar.p()).iW(aVar.j()).aax(aVar.o()).iX(aVar.k()).aay(aVar.y()).fa(i.a(g(aVar), jSONObject)).QN(2).BK(aVar.u()).eEl());
        } catch (Exception e) {
            i.a(e);
        }
    }

    private JSONObject f(com.ss.android.a.a.b.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            i.a(cVar.eEf(), jSONObject);
            jSONObject.putOpt("download_url", cVar.a());
            jSONObject.putOpt("package_name", cVar.v());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.downloader.m.g.f());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.downloader.m.g.g());
            jSONObject.putOpt("ttdownloader", 1);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private JSONObject g(com.ss.android.b.a.b.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            i.a(aVar.q(), jSONObject);
            jSONObject.putOpt("download_url", aVar.z());
            jSONObject.putOpt("package_name", aVar.m());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.downloader.m.g.f());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.downloader.m.g.g());
            jSONObject.putOpt("ttdownloader", 1);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private void a(com.ss.android.a.a.d.d dVar) {
        if (j.eEL() != null) {
            if (dVar.e()) {
                j.eEL().a(dVar);
            } else {
                j.eEL().b(dVar);
            }
        }
    }
}
