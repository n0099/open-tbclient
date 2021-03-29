package d.b.i0.r2.x;

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
public class b implements d.b.i0.o.c.g.a {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, DownloadCacheKey> f59895b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final d.b.i0.o.c.f.c f59896c = new C1514b();

    /* renamed from: d.b.i0.r2.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1514b implements d.b.i0.o.c.f.c {
        public C1514b() {
        }

        @Override // d.b.i0.o.c.f.c
        public void a(String str, int i) {
            d.b.i0.o.c.f.a a2 = d.b.i0.o.c.d.c().a((DownloadCacheKey) b.this.f59895b.get(str));
            if (a2 == null) {
                return;
            }
            a2.a(str, i);
        }

        @Override // d.b.i0.o.c.f.c
        public void b(String str) {
            d.b.i0.o.c.f.a a2 = d.b.i0.o.c.d.c().a((DownloadCacheKey) b.this.f59895b.get(str));
            if (a2 == null) {
                return;
            }
            Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
            a2.b(str);
        }

        @Override // d.b.i0.o.c.f.c
        public void c(String str, int i) {
            d.b.i0.o.c.f.a a2 = d.b.i0.o.c.d.c().a((DownloadCacheKey) b.this.f59895b.get(str));
            if (a2 == null) {
                return;
            }
            a2.c(str, i);
        }

        @Override // d.b.i0.o.c.f.c
        public void d(String str, StopStatus stopStatus) {
            d.b.i0.o.c.f.a a2 = d.b.i0.o.c.d.c().a((DownloadCacheKey) b.this.f59895b.get(str));
            if (a2 == null) {
                return;
            }
            a2.d(str, stopStatus);
        }

        @Override // d.b.i0.o.c.f.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.f59895b.get(str);
            String a2 = d.b.i0.o.c.a.a(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.f59895b.put(str, downloadCacheKey);
            }
            if (!TextUtils.isEmpty(a2)) {
                downloadCacheKey.mPackageName = a2;
            }
            AdDownloadData b2 = d.b.i0.o.c.d.c().b(downloadCacheKey);
            if (!TextUtils.isEmpty(a2)) {
                b2.setupPkgName(a2);
            }
            d.b.i0.o.c.f.a a3 = d.b.i0.o.c.d.c().a(downloadCacheKey);
            if (a3 == null) {
                return;
            }
            if (d.b.i0.o.c.a.b(TbadkCoreApplication.getInst(), a2)) {
                a3.g();
            } else {
                a3.onSuccess(str, str2);
            }
        }
    }

    @Override // d.b.i0.o.c.g.a
    public d.b.i0.o.c.f.c a() {
        return this.f59896c;
    }

    @Override // d.b.i0.o.c.g.a
    public void b(String str) {
        DownloadCacheKey downloadCacheKey = this.f59895b.get(str);
        if (downloadCacheKey == null) {
            return;
        }
        i.l().g(downloadCacheKey.mDownloadUrl, str, true);
    }

    @Override // d.b.i0.o.c.g.a
    public void c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.f59895b.put(downloadCacheKey.mAdId, downloadCacheKey);
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

    @Override // d.b.i0.o.c.g.a
    public void d(String str) {
        DownloadCacheKey downloadCacheKey = this.f59895b.get(str);
        if (downloadCacheKey == null) {
            return;
        }
        this.f59895b.put(downloadCacheKey.mAdId, downloadCacheKey);
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
