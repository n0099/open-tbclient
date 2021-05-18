package d.a.i0.f.j.n;

import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Collection;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f46713a;

    /* loaded from: classes3.dex */
    public class a implements DownloadManager.DownloadItemFilter {
        public a(b bVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && download.getState() == Download.DownloadState.FINISH && d.a.i0.f.j.o.a.g(AppRuntime.getAppContext(), download.getKeyByUser());
        }
    }

    /* renamed from: d.a.i0.f.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0980b implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46714a;

        public C0980b(b bVar, String str) {
            this.f46714a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && TextUtils.equals(download.getKeyByUser(), this.f46714a);
        }
    }

    public b(DownloadManager downloadManager) {
        this.f46713a = downloadManager;
    }

    public static boolean c(Download download) {
        if (download == null) {
            return false;
        }
        String realDownloadDir = download.getRealDownloadDir();
        String fileName = download.getFileName();
        if (TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
            return false;
        }
        File file = new File(realDownloadDir + File.separator + fileName);
        return file.isFile() && file.exists();
    }

    public synchronized void a() {
        Collection<Download> downloadListByFilter = this.f46713a.getDownloadListByFilter(new a(this));
        if (downloadListByFilter == null) {
            return;
        }
        int size = downloadListByFilter.size() - 30;
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        for (Download download : downloadListByFilter) {
            if (i2 == size) {
                return;
            }
            if (download != null) {
                this.f46713a.cancel(download.getId().longValue());
            }
            i2++;
        }
    }

    public void b(String str) {
        Download d2;
        if (TextUtils.isEmpty(str) || (d2 = d(str)) == null) {
            return;
        }
        this.f46713a.cancel(d2.getId().longValue());
    }

    public Download d(String str) {
        Collection<Download> downloadListByFilter;
        if (TextUtils.isEmpty(str) || (downloadListByFilter = this.f46713a.getDownloadListByFilter(new C0980b(this, str))) == null) {
            return null;
        }
        for (Download download : downloadListByFilter) {
            if (download != null) {
                return download;
            }
        }
        return null;
    }
}
