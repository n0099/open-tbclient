package d.a.c.h.j.e;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f39477b;

    /* renamed from: a  reason: collision with root package name */
    public b f39478a;

    public static c b() {
        if (f39477b == null) {
            synchronized (c.class) {
                if (f39477b == null) {
                    f39477b = new c();
                }
            }
        }
        return f39477b;
    }

    public void a(String str) {
        b bVar = this.f39478a;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public boolean c(String str) {
        b bVar;
        if (!TextUtils.isEmpty(str) && (bVar = this.f39478a) != null) {
            for (BdFileDownloadData bdFileDownloadData : bVar.b()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d(b bVar) {
        this.f39478a = bVar;
    }

    public void e(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f39478a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f39478a.c(bdFileDownloadData);
    }

    public void f(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f39478a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f39478a.e(bdFileDownloadData, 1);
    }
}
