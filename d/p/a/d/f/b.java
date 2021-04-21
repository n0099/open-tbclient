package d.p.a.d.f;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.d.f.a.a;
import d.p.a.d.f.c;
import d.p.a.d.j;
import d.p.a.d.n.l;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements l.a {

    /* renamed from: c  reason: collision with root package name */
    public static b f67647c;

    /* renamed from: a  reason: collision with root package name */
    public d.p.a.d.n.l f67648a = new d.p.a.d.n.l(Looper.getMainLooper(), this);

    /* renamed from: b  reason: collision with root package name */
    public long f67649b;

    public static b a() {
        if (f67647c == null) {
            synchronized (b.class) {
                if (f67647c == null) {
                    f67647c = new b();
                }
            }
        }
        return f67647c;
    }

    public final void b(c.b bVar, int i) {
        if (n.u() == null) {
            return;
        }
        if ((!n.u().a() || n.C()) && bVar != null) {
            if (2 == i) {
                d.p.a.b.a.c.b u = c.g.e().u(bVar.f67654b);
                JSONObject jSONObject = new JSONObject();
                int i2 = -1;
                try {
                    jSONObject.put("ttdownloader_type", "miui_silent_install");
                    if (d.p.a.d.n.k.I(n.a(), bVar.f67656d)) {
                        jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                        i2 = 4;
                    } else {
                        jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                        i2 = 5;
                    }
                } catch (Exception unused) {
                }
                n.q().a(null, new BaseException(i2, jSONObject.toString()), i2);
                j.c.a().r("embeded_ad", "ah_result", jSONObject, u);
            }
            if (d.p.a.d.n.k.I(n.a(), bVar.f67656d)) {
                j.c.a().l("delayinstall_installed", bVar.f67654b);
            } else if (!d.p.a.d.n.k.x(bVar.f67659g)) {
                j.c.a().l("delayinstall_file_lost", bVar.f67654b);
            } else if (a.a().i(bVar.f67656d)) {
                j.c.a().l("delayinstall_conflict_with_back_dialog", bVar.f67654b);
            } else {
                j.c.a().l("delayinstall_install_start", bVar.f67654b);
                d.p.a.e.a.e.s(n.a(), (int) bVar.f67653a);
            }
        }
    }

    public void c(@NonNull DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        c.b bVar = new c.b(downloadInfo.c0(), j, j2, str, str2, str3, str4);
        d.p.a.e.b.j.a d2 = d.p.a.e.b.j.a.d(downloadInfo.c0());
        if (d2.b("back_miui_silent_install", 1) == 0 && ((d.p.a.e.a.h.c.m() || d.p.a.e.a.h.c.n()) && d.p.a.e.b.l.g.a(n.a(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (d.p.a.e.b.l.e.O(downloadInfo.L0().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.f67648a.obtainMessage(200, bVar);
                obtainMessage.arg1 = 2;
                this.f67648a.sendMessageDelayed(obtainMessage, d2.b("check_silent_install_interval", 60000));
                return;
            }
            d.p.a.b.a.c.b u = c.g.e().u(bVar.f67654b);
            JSONObject jSONObject = new JSONObject();
            int i = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
            }
            n.q().a(null, new BaseException(i, jSONObject.toString()), i);
            j.c.a().r("embeded_ad", "ah_result", jSONObject, u);
        }
        if (n.B()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f67649b;
            long D = n.D();
            if (currentTimeMillis < n.E()) {
                long E = n.E() - currentTimeMillis;
                D += E;
                this.f67649b = System.currentTimeMillis() + E;
            } else {
                this.f67649b = System.currentTimeMillis();
            }
            d.p.a.d.n.l lVar = this.f67648a;
            lVar.sendMessageDelayed(lVar.obtainMessage(200, bVar), D);
        }
    }

    @Override // d.p.a.d.n.l.a
    public void a(Message message) {
        if (message.what != 200) {
            return;
        }
        b((c.b) message.obj, message.arg1);
    }
}
