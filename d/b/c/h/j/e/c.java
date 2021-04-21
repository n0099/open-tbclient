package d.b.c.h.j.e;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f43011b;

    /* renamed from: a  reason: collision with root package name */
    public b f43012a;

    public static c b() {
        if (f43011b == null) {
            synchronized (c.class) {
                if (f43011b == null) {
                    f43011b = new c();
                }
            }
        }
        return f43011b;
    }

    public void a(String str) {
        b bVar = this.f43012a;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public boolean c(String str) {
        b bVar;
        if (!TextUtils.isEmpty(str) && (bVar = this.f43012a) != null) {
            for (BdFileDownloadData bdFileDownloadData : bVar.b()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d(b bVar) {
        this.f43012a = bVar;
    }

    public void e(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f43012a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f43012a.c(bdFileDownloadData);
    }

    public void f(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f43012a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f43012a.e(bdFileDownloadData, 1);
    }
}
