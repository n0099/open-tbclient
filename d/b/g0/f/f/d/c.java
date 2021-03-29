package d.b.g0.f.f.d;

import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Collection;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f47788a;

    /* loaded from: classes3.dex */
    public class a implements DownloadManager.DownloadItemFilter {
        public a() {
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return (download == null || c.this.j(download)) ? false : true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47790a;

        public b(String str) {
            this.f47790a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return (download == null || !TextUtils.equals(download.getUrl(), this.f47790a) || c.this.j(download)) ? false : true;
        }
    }

    /* renamed from: d.b.g0.f.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0943c implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47792a;

        public C0943c(c cVar, String str) {
            this.f47792a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && TextUtils.equals(download.getKeyByUser(), this.f47792a);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47793a;

        public d(c cVar, String str) {
            this.f47793a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && TextUtils.equals(download.getUrl(), this.f47793a);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DownloadManager.DownloadItemFilter {
        public e() {
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return (download == null || download.getState() != Download.DownloadState.FINISH || c.this.k(download) || !c.i(download) || d.b.g0.f.f.e.a.g(AppRuntime.getAppContext(), download.getKeyByUser())) ? false : true;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DownloadManager.DownloadItemFilter {
        public f(c cVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && download.getState() == Download.DownloadState.FINISH && d.b.g0.f.f.e.a.g(AppRuntime.getAppContext(), download.getKeyByUser());
        }
    }

    /* loaded from: classes3.dex */
    public class g implements DownloadManager.DownloadItemFilter {
        public g() {
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return c.this.j(download);
        }
    }

    public c(DownloadManager downloadManager) {
        this.f47788a = downloadManager;
    }

    public static boolean i(Download download) {
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

    public synchronized boolean c(String str) {
        boolean z;
        Collection<Download> downloadListByFilter = this.f47788a.getDownloadListByFilter(new C0943c(this, str));
        if (downloadListByFilter != null) {
            z = downloadListByFilter.size() > 0;
        }
        return z;
    }

    public synchronized void d() {
        Collection<Download> downloadListByFilter = this.f47788a.getDownloadListByFilter(new f(this));
        if (downloadListByFilter == null) {
            return;
        }
        int size = downloadListByFilter.size() - 30;
        if (size <= 0) {
            return;
        }
        int i = 0;
        for (Download download : downloadListByFilter) {
            if (i == size) {
                return;
            }
            if (download != null) {
                this.f47788a.cancel(download.getId().longValue());
            }
            i++;
        }
    }

    public synchronized void e() {
        h(this.f47788a.getDownloadListByFilter(new g()));
    }

    public synchronized void f() {
        Collection<Download> downloadListByFilter = this.f47788a.getDownloadListByFilter(new e());
        if (downloadListByFilter == null) {
            return;
        }
        int size = downloadListByFilter.size() - 20;
        if (size <= 0) {
            return;
        }
        int i = 0;
        for (Download download : downloadListByFilter) {
            if (i == size) {
                return;
            }
            if (download != null) {
                this.f47788a.cancel(download.getId().longValue());
            }
            i++;
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h(o(str));
    }

    public void h(Collection<Download> collection) {
        if (collection == null) {
            return;
        }
        for (Download download : collection) {
            if (download != null) {
                this.f47788a.cancel(download.getId().longValue());
            }
        }
    }

    public final boolean j(Download download) {
        if (download == null) {
            return false;
        }
        return (k(download) || (download.getState() == Download.DownloadState.FINISH && !i(download))) && !d.b.g0.f.f.e.a.g(AppRuntime.getAppContext(), download.getKeyByUser());
    }

    public final boolean k(Download download) {
        return download != null && (System.currentTimeMillis() - new d.b.g0.f.f.d.a(download).e()) / 86400000 >= 30;
    }

    public void l() {
        Collection<Download> m = m();
        if (m == null || m.isEmpty()) {
            return;
        }
        for (Download download : m) {
            if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING)) {
                this.f47788a.pause(download.getId().longValue());
            }
        }
    }

    public Collection<Download> m() {
        return this.f47788a.getDownloadListByFilter(new a());
    }

    public synchronized Collection<Download> n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f47788a.getDownloadListByFilter(new b(str));
    }

    public synchronized Collection<Download> o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f47788a.getDownloadListByFilter(new d(this, str));
    }

    public Download p(String str) {
        Collection<Download> n = n(str);
        Download download = null;
        if (n == null) {
            return null;
        }
        for (Download download2 : n) {
            if (download2 != null) {
                download = download2;
            }
        }
        return download;
    }

    public Collection<Download> q() {
        Collection<Download> m = m();
        if (m == null || m.isEmpty()) {
            return null;
        }
        for (Download download : m) {
            if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.PAUSE)) {
                this.f47788a.resume(download.getId().longValue());
            }
        }
        return m;
    }
}
