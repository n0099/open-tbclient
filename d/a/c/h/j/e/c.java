package d.a.c.h.j.e;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f42897b;

    /* renamed from: a  reason: collision with root package name */
    public b f42898a;

    public static c b() {
        if (f42897b == null) {
            synchronized (c.class) {
                if (f42897b == null) {
                    f42897b = new c();
                }
            }
        }
        return f42897b;
    }

    public void a(String str) {
        b bVar = this.f42898a;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public boolean c(String str) {
        b bVar;
        if (!TextUtils.isEmpty(str) && (bVar = this.f42898a) != null) {
            for (BdFileDownloadData bdFileDownloadData : bVar.b()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d(b bVar) {
        this.f42898a = bVar;
    }

    public void e(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f42898a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f42898a.c(bdFileDownloadData);
    }

    public void f(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f42898a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f42898a.e(bdFileDownloadData, 1);
    }
}
