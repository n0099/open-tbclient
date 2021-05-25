package d.a.n0.t2.c0;

import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b implements d.a.n0.q.d.i.a {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, DownloadCacheKey> f60929b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.n0.q.d.h.c f60930c = new C1617b();

    /* renamed from: d.a.n0.t2.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1617b implements d.a.n0.q.d.h.c {
        public C1617b() {
        }

        @Override // d.a.n0.q.d.h.c
        public void a(String str, int i2) {
            d.a.n0.q.d.h.a a2 = d.a.n0.q.d.e.c().a((DownloadCacheKey) b.this.f60929b.get(str));
            if (a2 == null) {
                return;
            }
            a2.a(str, i2);
        }

        @Override // d.a.n0.q.d.h.c
        public void b(String str, StopStatus stopStatus) {
            d.a.n0.q.d.h.a a2 = d.a.n0.q.d.e.c().a((DownloadCacheKey) b.this.f60929b.get(str));
            if (a2 == null) {
                return;
            }
            a2.b(str, stopStatus);
        }

        @Override // d.a.n0.q.d.h.c
        public void c(String str) {
            d.a.n0.q.d.h.a a2 = d.a.n0.q.d.e.c().a((DownloadCacheKey) b.this.f60929b.get(str));
            if (a2 == null) {
                return;
            }
            Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
            a2.c(str);
        }

        @Override // d.a.n0.q.d.h.c
        public void d(String str, int i2) {
            d.a.n0.q.d.h.a a2 = d.a.n0.q.d.e.c().a((DownloadCacheKey) b.this.f60929b.get(str));
            if (a2 == null) {
                return;
            }
            a2.d(str, i2);
        }

        @Override // d.a.n0.q.d.h.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.f60929b.get(str);
            String a2 = d.a.n0.q.d.a.a(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.f60929b.put(str, downloadCacheKey);
            }
            if (!TextUtils.isEmpty(a2)) {
                downloadCacheKey.mPackageName = a2;
            }
            AdDownloadData b2 = d.a.n0.q.d.e.c().b(downloadCacheKey);
            if (!TextUtils.isEmpty(a2)) {
                b2.setupPkgName(a2);
            }
            d.a.n0.q.d.h.a a3 = d.a.n0.q.d.e.c().a(downloadCacheKey);
            if (a3 == null) {
                return;
            }
            if (d.a.n0.q.d.a.b(TbadkCoreApplication.getInst(), a2)) {
                a3.g();
            } else {
                a3.onSuccess(str, str2);
            }
        }
    }

    @Override // d.a.n0.q.d.i.a
    public void a(String str) {
        DownloadCacheKey downloadCacheKey = this.f60929b.get(str);
        if (downloadCacheKey == null) {
            return;
        }
        i.l().g(downloadCacheKey.mDownloadUrl, str, true);
    }

    @Override // d.a.n0.q.d.i.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.f60929b.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.m(downloadCacheKey.mPackageName).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.l().w(downloadData);
    }

    @Override // d.a.n0.q.d.i.a
    public d.a.n0.q.d.h.c c() {
        return this.f60930c;
    }

    @Override // d.a.n0.q.d.i.a
    public void d(String str) {
        DownloadCacheKey downloadCacheKey = this.f60929b.get(str);
        if (downloadCacheKey == null) {
            return;
        }
        this.f60929b.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.m(downloadData.getName()).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.l().w(downloadData);
    }
}
