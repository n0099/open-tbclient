package com.ss.android.downloadlib.a;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.f.j;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements j.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7687a = a.class.getSimpleName();
    private static a qbZ;
    private long d;
    private com.ss.android.downloadlib.f.j qca = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);

    public static a eEB() {
        if (qbZ == null) {
            synchronized (a.class) {
                if (qbZ == null) {
                    qbZ = new a();
                }
            }
        }
        return qbZ;
    }

    private a() {
    }

    public void a(@NonNull com.ss.android.socialbase.downloader.g.c cVar, long j, long j2, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.a.b.a aVar = new com.ss.android.downloadlib.a.b.a(cVar.g(), j, j2, str, str2, str3, str4);
        com.ss.android.socialbase.downloader.k.a Sa = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g());
        if (Sa.a("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.downloader.m.g.j() || com.ss.android.socialbase.downloader.m.g.k()) && com.ss.android.socialbase.downloader.m.i.a(j.a(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.m.d.f(cVar.eIh().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.qca.obtainMessage(200, aVar);
                obtainMessage.arg1 = 2;
                this.qca.sendMessageDelayed(obtainMessage, Sa.a("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEF().je(aVar.b);
            JSONObject jSONObject = new JSONObject();
            int i = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception e) {
            }
            j.eEU().a(null, new com.ss.android.socialbase.downloader.e.a(i, jSONObject.toString()), i);
            com.ss.android.downloadlib.e.a.eFo().a("embeded_ad", "anti_hijack_result", jSONObject, je);
        }
        if (j.u()) {
            long currentTimeMillis = System.currentTimeMillis() - this.d;
            long w = j.w();
            if (currentTimeMillis < j.eoy()) {
                long eoy = j.eoy() - currentTimeMillis;
                w += eoy;
                this.d = eoy + System.currentTimeMillis();
            } else {
                this.d = System.currentTimeMillis();
            }
            this.qca.sendMessageDelayed(this.qca.obtainMessage(200, aVar), w);
        }
    }

    private void a(com.ss.android.downloadlib.a.b.a aVar, int i) {
        if (j.eEY() != null) {
            if ((!j.eEY().a() || j.v()) && aVar != null) {
                if (2 == i) {
                    com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEF().je(aVar.b);
                    JSONObject jSONObject = new JSONObject();
                    int i2 = -1;
                    try {
                        jSONObject.put("ttdownloader_type", "miui_silent_install");
                        if (com.ss.android.downloadlib.f.i.d(j.a(), aVar.d)) {
                            jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                            i2 = 4;
                        } else {
                            jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                            i2 = 5;
                        }
                    } catch (Exception e) {
                    }
                    j.eEU().a(null, new com.ss.android.socialbase.downloader.e.a(i2, jSONObject.toString()), i2);
                    com.ss.android.downloadlib.e.a.eFo().a("embeded_ad", "anti_hijack_result", jSONObject, je);
                }
                if (com.ss.android.downloadlib.f.i.d(j.a(), aVar.d)) {
                    com.ss.android.downloadlib.e.a.eFo().a("delayinstall_installed", aVar.b);
                } else if (!com.ss.android.downloadlib.f.i.a(aVar.g)) {
                    com.ss.android.downloadlib.e.a.eFo().a("delayinstall_file_lost", aVar.b);
                } else if (com.ss.android.downloadlib.a.a.a.eEC().a(aVar.d)) {
                    com.ss.android.downloadlib.e.a.eFo().a("delayinstall_conflict_with_back_dialog", aVar.b);
                } else {
                    com.ss.android.downloadlib.e.a.eFo().a("delayinstall_install_start", aVar.b);
                    com.ss.android.socialbase.appdownloader.d.a(j.a(), (int) aVar.f7691a);
                }
            }
        }
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        switch (message.what) {
            case 200:
                a((com.ss.android.downloadlib.a.b.a) message.obj, message.arg1);
                return;
            default:
                return;
        }
    }
}
