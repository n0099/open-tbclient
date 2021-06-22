package d.o.a.d.f;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.f.a.a;
import d.o.a.d.f.c;
import d.o.a.d.j;
import d.o.a.d.n.l;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements l.a {

    /* renamed from: c  reason: collision with root package name */
    public static b f70612c;

    /* renamed from: a  reason: collision with root package name */
    public d.o.a.d.n.l f70613a = new d.o.a.d.n.l(Looper.getMainLooper(), this);

    /* renamed from: b  reason: collision with root package name */
    public long f70614b;

    public static b a() {
        if (f70612c == null) {
            synchronized (b.class) {
                if (f70612c == null) {
                    f70612c = new b();
                }
            }
        }
        return f70612c;
    }

    public final void b(c.b bVar, int i2) {
        if (n.u() == null) {
            return;
        }
        if ((!n.u().a() || n.C()) && bVar != null) {
            if (2 == i2) {
                d.o.a.b.a.c.b u = c.g.e().u(bVar.f70619b);
                JSONObject jSONObject = new JSONObject();
                int i3 = -1;
                try {
                    jSONObject.put("ttdownloader_type", "miui_silent_install");
                    if (d.o.a.d.n.k.I(n.a(), bVar.f70621d)) {
                        jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                        i3 = 4;
                    } else {
                        jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                        i3 = 5;
                    }
                } catch (Exception unused) {
                }
                n.q().a(null, new BaseException(i3, jSONObject.toString()), i3);
                j.c.a().r("embeded_ad", "ah_result", jSONObject, u);
            }
            if (d.o.a.d.n.k.I(n.a(), bVar.f70621d)) {
                j.c.a().l("delayinstall_installed", bVar.f70619b);
            } else if (!d.o.a.d.n.k.x(bVar.f70624g)) {
                j.c.a().l("delayinstall_file_lost", bVar.f70619b);
            } else if (a.a().i(bVar.f70621d)) {
                j.c.a().l("delayinstall_conflict_with_back_dialog", bVar.f70619b);
            } else {
                j.c.a().l("delayinstall_install_start", bVar.f70619b);
                d.o.a.e.a.e.s(n.a(), (int) bVar.f70618a);
            }
        }
    }

    public void c(@NonNull DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        c.b bVar = new c.b(downloadInfo.c0(), j, j2, str, str2, str3, str4);
        d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(downloadInfo.c0());
        if (d2.b("back_miui_silent_install", 1) == 0 && ((d.o.a.e.a.h.c.m() || d.o.a.e.a.h.c.n()) && d.o.a.e.b.l.g.a(n.a(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (d.o.a.e.b.l.e.O(downloadInfo.L0().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.f70613a.obtainMessage(200, bVar);
                obtainMessage.arg1 = 2;
                this.f70613a.sendMessageDelayed(obtainMessage, d2.b("check_silent_install_interval", 60000));
                return;
            }
            d.o.a.b.a.c.b u = c.g.e().u(bVar.f70619b);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i2 = 5;
            } catch (Exception unused) {
            }
            n.q().a(null, new BaseException(i2, jSONObject.toString()), i2);
            j.c.a().r("embeded_ad", "ah_result", jSONObject, u);
        }
        if (n.B()) {
            long currentTimeMillis = System.currentTimeMillis() - this.f70614b;
            long D = n.D();
            if (currentTimeMillis < n.E()) {
                long E = n.E() - currentTimeMillis;
                D += E;
                this.f70614b = System.currentTimeMillis() + E;
            } else {
                this.f70614b = System.currentTimeMillis();
            }
            d.o.a.d.n.l lVar = this.f70613a;
            lVar.sendMessageDelayed(lVar.obtainMessage(200, bVar), D);
        }
    }

    @Override // d.o.a.d.n.l.a
    public void a(Message message) {
        if (message.what != 200) {
            return;
        }
        b((c.b) message.obj, message.arg1);
    }
}
