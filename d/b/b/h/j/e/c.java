package d.b.b.h.j.e;

import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f42274b;

    /* renamed from: a  reason: collision with root package name */
    public b f42275a;

    public static c b() {
        if (f42274b == null) {
            synchronized (c.class) {
                if (f42274b == null) {
                    f42274b = new c();
                }
            }
        }
        return f42274b;
    }

    public void a(String str) {
        b bVar = this.f42275a;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public boolean c(String str) {
        b bVar;
        if (!TextUtils.isEmpty(str) && (bVar = this.f42275a) != null) {
            for (BdFileDownloadData bdFileDownloadData : bVar.b()) {
                if (str.equals(bdFileDownloadData.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d(b bVar) {
        this.f42275a = bVar;
    }

    public void e(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f42275a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f42275a.c(bdFileDownloadData);
    }

    public void f(BdFileDownloadData bdFileDownloadData, a aVar) {
        if (bdFileDownloadData == null || this.f42275a == null) {
            return;
        }
        bdFileDownloadData.setCallback(aVar);
        this.f42275a.e(bdFileDownloadData, 1);
    }
}
