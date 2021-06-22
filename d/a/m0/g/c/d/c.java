package d.a.m0.g.c.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f50790a;

    /* loaded from: classes3.dex */
    public class a implements DownloadManager.DownloadItemFilter {
        public a(c cVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && download.getState() == Download.DownloadState.FINISH && c.j(download) && !d.a.m0.g.c.e.a.h(AppRuntime.getAppContext(), download.getKeyByUser());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DownloadManager.DownloadItemFilter {
        public b(c cVar) {
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && download.getState() == Download.DownloadState.FINISH && d.a.m0.g.c.e.a.h(AppRuntime.getAppContext(), download.getKeyByUser());
        }
    }

    /* renamed from: d.a.m0.g.c.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1057c implements DownloadManager.DownloadItemFilter {
        public C1057c() {
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return c.this.k(download);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DownloadManager.DownloadItemFilter {
        public d() {
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return (download == null || c.this.k(download)) ? false : true;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50793a;

        public e(c cVar, String str) {
            this.f50793a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && TextUtils.equals(download.getKeyByUser(), this.f50793a);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50794a;

        public f(c cVar, String str) {
            this.f50794a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && TextUtils.equals(download.getKeyByUser(), this.f50794a) && download.getState() == Download.DownloadState.FINISH;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50795a;

        public g(c cVar, String str) {
            this.f50795a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && TextUtils.equals(download.getKeyByUser(), this.f50795a) && download.getState() == Download.DownloadState.FINISH;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50796a;

        public h(String str) {
            this.f50796a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return (download == null || !TextUtils.equals(download.getUrl(), this.f50796a) || c.this.k(download)) ? false : true;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50798a;

        public i(c cVar, String str) {
            this.f50798a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && TextUtils.equals(download.getKeyByUser(), this.f50798a);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50799a;

        public j(c cVar, String str) {
            this.f50799a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && download.getState() == Download.DownloadState.FINISH && download.getKeyByUser().contains(this.f50799a);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50800a;

        public k(c cVar, String str) {
            this.f50800a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return download != null && TextUtils.equals(download.getUrl(), this.f50800a);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements DownloadManager.DownloadItemFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f50801a;

        public l(c cVar, Context context) {
            this.f50801a = context;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            return (download == null || download.getState() != Download.DownloadState.FINISH || d.a.m0.g.c.e.a.h(this.f50801a, download.getKeyByUser())) ? false : true;
        }
    }

    public c(DownloadManager downloadManager) {
        this.f50790a = downloadManager;
    }

    public static boolean j(Download download) {
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

    public synchronized boolean b(String str) {
        boolean z;
        Collection<Download> downloadListByFilter = this.f50790a.getDownloadListByFilter(new i(this, str));
        if (downloadListByFilter != null) {
            z = downloadListByFilter.size() > 0;
        }
        return z;
    }

    public synchronized boolean c(String str) {
        boolean z;
        Collection<Download> downloadListByFilter = this.f50790a.getDownloadListByFilter(new j(this, str));
        if (downloadListByFilter != null) {
            z = downloadListByFilter.size() > 0;
        }
        return z;
    }

    public synchronized void d() {
        Collection<Download> downloadListByFilter = this.f50790a.getDownloadListByFilter(new b(this));
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
                this.f50790a.cancel(download.getId().longValue());
            }
            i2++;
        }
    }

    public synchronized void e() {
        h(this.f50790a.getDownloadListByFilter(new C1057c()));
    }

    public synchronized void f() {
        Collection<Download> downloadListByFilter = this.f50790a.getDownloadListByFilter(new a(this));
        if (downloadListByFilter == null) {
            return;
        }
        int size = downloadListByFilter.size() - 20;
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        for (Download download : downloadListByFilter) {
            if (i2 == size) {
                return;
            }
            if (download != null) {
                this.f50790a.cancel(download.getId().longValue());
            }
            i2++;
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h(r(str));
    }

    public void h(Collection<Download> collection) {
        if (collection == null) {
            return;
        }
        for (Download download : collection) {
            if (download != null) {
                this.f50790a.cancel(download.getId().longValue());
            }
        }
    }

    public synchronized String i(String str) {
        if (str.endsWith(".huawei")) {
            return str.replace(".huawei", "");
        } else if (str.endsWith(".mi")) {
            return str.replace(".mi", "");
        } else if (str.endsWith(".nearme.gamecenter")) {
            return str.replace(".nearme.gamecenter", "");
        } else if (str.endsWith(".vivo")) {
            return str.replace(".vivo", "");
        } else {
            return null;
        }
    }

    public final boolean k(Download download) {
        if (download == null) {
            return false;
        }
        return (l(download) || (download.getState() == Download.DownloadState.FINISH && !j(download))) && !d.a.m0.g.c.e.a.h(AppRuntime.getAppContext(), download.getKeyByUser());
    }

    public final boolean l(Download download) {
        return download != null && (System.currentTimeMillis() - new d.a.m0.g.c.d.a(download).e()) / 86400000 >= 30;
    }

    public void m() {
        Collection<Download> n = n();
        if (n == null || n.isEmpty()) {
            return;
        }
        for (Download download : n) {
            if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING)) {
                this.f50790a.pause(download.getId().longValue());
            }
        }
    }

    public Collection<Download> n() {
        return this.f50790a.getDownloadListByFilter(new d());
    }

    public Download o(String str) {
        Collection<Download> downloadListByFilter;
        Download download = null;
        if (TextUtils.isEmpty(str) || (downloadListByFilter = this.f50790a.getDownloadListByFilter(new e(this, str))) == null) {
            return null;
        }
        for (Download download2 : downloadListByFilter) {
            if (download2 != null) {
                download = download2;
            }
        }
        return download;
    }

    public synchronized Collection<Download> p(String str) {
        return this.f50790a.getDownloadListByFilter(new g(this, str));
    }

    public synchronized Collection<Download> q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f50790a.getDownloadListByFilter(new h(str));
    }

    public synchronized Collection<Download> r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f50790a.getDownloadListByFilter(new k(this, str));
    }

    public Collection<Download> s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f50790a.getDownloadListByFilter(new f(this, str));
    }

    public synchronized Collection<Download> t() {
        return this.f50790a.getDownloadListByFilter(new l(this, AppRuntime.getAppContext()));
    }

    public Download u(String str, String str2) {
        Download v = v(str);
        return v == null ? o(str2) : v;
    }

    public Download v(String str) {
        Collection<Download> q = q(str);
        Download download = null;
        if (q == null) {
            return null;
        }
        for (Download download2 : q) {
            if (download2 != null) {
                download = download2;
            }
        }
        return download;
    }

    public Download w(String str) {
        Collection<Download> s = s(str);
        Download download = null;
        if (s != null && s.size() != 0) {
            Iterator<Download> it = s.iterator();
            while (it.hasNext()) {
                download = it.next();
            }
        }
        return download;
    }

    public Collection<Download> x() {
        Collection<Download> n = n();
        if (n == null || n.isEmpty()) {
            return null;
        }
        for (Download download : n) {
            if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.PAUSE)) {
                this.f50790a.resume(download.getId().longValue());
            }
        }
        return n;
    }
}
