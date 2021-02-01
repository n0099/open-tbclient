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
    public static class C1223a {
        private static a qcz = new a();
    }

    public static a eFc() {
        return C1223a.qcz;
    }

    private a() {
    }

    public void a(long j, int i) {
        d.a jf = d.eEt().jf(j);
        if (jf.a()) {
            i.b();
        } else if (jf.qbb.l()) {
            String c = i == 1 ? jf.qbb.c() : jf.qbb.b();
            String a2 = i.a(jf.qbb.d(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2));
                jSONObject.putOpt(AlaRecorderLog.KEY_NETWORK_AVAILABLE, Integer.valueOf(com.ss.android.socialbase.downloader.m.d.b(j.a()) ? 1 : 2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(c, a2, jSONObject, jf.qba, jf.qbb);
        }
    }

    public void a(long j, int i, c cVar) {
        d.a jf = d.eEt().jf(j);
        if (jf.a()) {
            i.b();
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        switch (i) {
            case 1:
                str = i.a(jf.qbb.i(), "storage_deny");
                break;
            case 2:
                str = i.a(jf.qbb.e(), "click_start");
                a(cVar, jSONObject);
                break;
            case 3:
                str = i.a(jf.qbb.f(), "click_pause");
                b(cVar, jSONObject);
                break;
            case 4:
                str = i.a(jf.qbb.g(), "click_continue");
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
                str = i.a(jf.qbb.h(), "click_install");
                break;
        }
        a(jf.qbb.b(), str, jSONObject, jf.qba.g(), 1, jf.qba, jf.qbb);
    }

    public void b(long j, int i) {
        a(j, i, (c) null);
    }

    public void a(String str, long j) {
        com.ss.android.b.a.b.a je = d.eEt().je(j);
        if (je == null) {
            i.b();
        } else {
            b(je.x(), str, null, je);
        }
    }

    public void a(String str, @NonNull com.ss.android.a.a.b.c cVar, @NonNull com.ss.android.a.a.b.b bVar) {
        a(bVar.b(), str, cVar.eDX(), cVar, bVar);
    }

    public void a(String str, @NonNull d.a aVar) {
        a(aVar.qbb.b(), str, aVar.qba.eDX(), aVar.qba, aVar.qbb);
    }

    public void a(String str, JSONObject jSONObject, @NonNull d.a aVar) {
        a(aVar.qbb.b(), str, jSONObject, aVar.qba, aVar.qbb);
    }

    public void a(String str, int i, d.a aVar) {
        a(aVar.qbb.b(), str, null, i, 2, aVar.qba, aVar.qbb);
    }

    public void a(long j, boolean z, int i) {
        d.a jf = d.eEt().jf(j);
        if (jf.a()) {
            i.b();
        } else if (jf.qba.eDY() != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("click_type", Integer.valueOf(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(jf.qbb.b(), z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, jf.qba, jf.qbb);
        }
    }

    private void a(c cVar, JSONObject jSONObject) {
        try {
            c(cVar, jSONObject);
            com.ss.android.b.a.b.a j = d.eEt().j(cVar);
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
        if (jSONObject != null && (j = d.eEt().j(cVar)) != null) {
            try {
                c(cVar, jSONObject);
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - j.eEi()));
                jSONObject.putOpt("click_download_size", Long.valueOf(j.eEj()));
                jSONObject.putOpt("download_length", Long.valueOf(cVar.eHa()));
                jSONObject.putOpt("download_apk_size", Long.valueOf(cVar.eij()));
                j.d();
                g.eEw().d(j);
                jSONObject.put("click_pause_times", j.c());
                long eij = cVar.eij();
                long eHa = cVar.eHa();
                if (eHa >= 0 && eij > 0) {
                    d = eHa / eij;
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
                jSONObject.put("first_speed_time", cVar.eok());
                jSONObject.put("all_connect_time", cVar.eGS());
                jSONObject.put("download_prepare_time", cVar.eEh());
                jSONObject.put("download_time", cVar.eHu() + cVar.eGS() + cVar.eEh());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c(c cVar, JSONObject jSONObject) {
        if (cVar != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(cVar.eij()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(cVar.eHa()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(cVar.eHM()));
                jSONObject.putOpt("app_name", cVar.i());
                jSONObject.putOpt("network_quality", cVar.eHc());
                jSONObject.putOpt("save_path", cVar.k());
                com.ss.android.b.a.b.a QU = d.eEt().QU(cVar.g());
                if (QU != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(QU.eEi()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(QU.eEj()));
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
        d.a jf = d.eEt().jf(j);
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
        a(jf.qbb.b(), "download_failed", jSONObject, jf.qba, jf.qbb);
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
        com.ss.android.b.a.b.a j = d.eEt().j(cVar);
        if (j != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                c(cVar, jSONObject);
                j.a(System.currentTimeMillis());
                a(j.x(), "download_resume", jSONObject, j);
                g.eEw().d(j);
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
            com.ss.android.b.a.b.a j = d.eEt().j(cVar);
            if (j == null) {
                i.b();
            } else if (!j.f12922a.get()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    b.a(jSONObject, cVar, true);
                    jSONObject.putOpt("fail_status", Integer.valueOf(j.h()));
                    jSONObject.putOpt("fail_msg", j.i());
                    jSONObject.put("download_failed_times", j.a());
                    if (cVar.eij() > 0) {
                        jSONObject.put("download_percent", cVar.eHa() / cVar.eij());
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
            com.ss.android.b.a.b.a j = d.eEt().j(cVar);
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
                    if (cVar.eij() > 0) {
                        jSONObject.put("download_percent", cVar.eHa() / cVar.eij());
                    }
                    jSONObject.put("has_send_download_failed_finally", j.f12923b.get() ? 1 : 2);
                    e.a(j, jSONObject);
                    jSONObject.put("is_update_download", j.I() ? 1 : 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(j.x(), "download_failed", jSONObject, j);
                g.eEw().d(j);
            }
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar) {
        a(str, str2, jSONObject, cVar.g(), 2, cVar, bVar);
    }

    private void a(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.a.a.b.c cVar, com.ss.android.a.a.b.b bVar) {
        try {
            a(new d.a().aaj(i.a(str, "embeded_ad")).aak(str2).BL(cVar.t()).iW(cVar.d()).aal(cVar.u()).iX(j).aam(bVar.a()).gU(cVar.eDW()).fa(i.a(f(cVar), bVar.eDU(), jSONObject)).bF(bVar.eDT()).QM(i).BK(bVar.m()).eEd());
        } catch (Exception e) {
            i.a(e);
        }
    }

    private void b(String str, String str2, JSONObject jSONObject, com.ss.android.b.a.b.a aVar) {
        try {
            a(new d.a().aaj(i.a(str, "embeded_ad")).aak(str2).BL(aVar.p()).iW(aVar.j()).aal(aVar.o()).iX(aVar.k()).aam(aVar.y()).fa(i.a(g(aVar), jSONObject)).QM(2).BK(aVar.u()).eEd());
        } catch (Exception e) {
            i.a(e);
        }
    }

    private JSONObject f(com.ss.android.a.a.b.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            i.a(cVar.eDX(), jSONObject);
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
        if (j.eED() != null) {
            if (dVar.e()) {
                j.eED().a(dVar);
            } else {
                j.eED().b(dVar);
            }
        }
    }
}
