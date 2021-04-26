package d.a.c.h.j.e;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f40232b;

    /* renamed from: a  reason: collision with root package name */
    public b f40233a;

    public static c b() {
        if (f40232b == null) {
            synchronized (c.class) {
                if (f40232b == null) {
                    f40232b = new c();
                }
            }
        }
        return f40232b;
    }

    public void a(String str) {
        b bVar = this.f40233a;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public boolean c(String str) {
        b bVar;
        if (!TextUtils.isEmpty(str) && (bVar = this.f40233a) != null) {
            for (BdFileDownloadData bdFileDownloadData : bVar.b()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d(b bVar) {
        this.f40233a = bVar;
    }

    public void e(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f40233a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f40233a.c(bdFileDownloadData);
    }

    public void f(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f40233a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f40233a.e(bdFileDownloadData, 1);
    }
}
