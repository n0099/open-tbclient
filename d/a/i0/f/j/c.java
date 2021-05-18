package d.a.i0.f.j;

import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import d.a.i0.a.v2.w;
@Singleton
@Service
/* loaded from: classes3.dex */
public class c implements d.a.i0.h.t.c.b {

    /* renamed from: b  reason: collision with root package name */
    public static String f46690b = "hasDownloadApk";

    /* renamed from: a  reason: collision with root package name */
    public String f46691a = "com.baidu.gamenow";

    @Override // d.a.i0.h.t.c.b
    public boolean a(Object obj) {
        if (obj instanceof Download) {
            Download download = (Download) obj;
            if (TextUtils.equals(d.a.i0.f.j.m.c.f46698a, download.getKeyByUser())) {
                return true;
            }
            return TextUtils.isEmpty(w.d(download.getFromParam()).optString("apk_id"));
        }
        return false;
    }

    @Override // d.a.i0.h.t.c.b
    public void b(Object obj) {
        if (obj instanceof Download) {
            d.a.i0.f.j.n.a aVar = new d.a.i0.f.j.n.a((Download) obj);
            d.a.i0.f.j.r.b.n().f("reallyDownloaded", new d.a.i0.f.j.r.a(), aVar.k(), aVar.h(), aVar.j());
        }
    }

    @Override // d.a.i0.h.t.c.b
    public void c(Object obj) {
        if (obj instanceof Download) {
            Download download = (Download) obj;
            d.a.i0.f.j.n.a aVar = new d.a.i0.f.j.n.a(download);
            d.a.i0.f.j.r.b.n().f("statusInstalled", new d.a.i0.f.j.r.a(), download.getKeyByUser(), aVar.h(), aVar.j());
            if (TextUtils.equals(aVar.k(), this.f46691a)) {
                d.a.i0.a.k2.g.h.a().putBoolean(f46690b, true);
                d.a.i0.f.j.r.b.n().p(13, aVar.k(), aVar.f(), aVar.j());
            }
        }
    }
}
