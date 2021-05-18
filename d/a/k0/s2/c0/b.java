package d.a.k0.s2.c0;

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
public class b implements d.a.k0.o.d.h.a {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, DownloadCacheKey> f60827b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.k0.o.d.g.c f60828c = new C1611b();

    /* renamed from: d.a.k0.s2.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1611b implements d.a.k0.o.d.g.c {
        public C1611b() {
        }

        @Override // d.a.k0.o.d.g.c
        public void a(String str, int i2) {
            d.a.k0.o.d.g.a a2 = d.a.k0.o.d.d.c().a((DownloadCacheKey) b.this.f60827b.get(str));
            if (a2 == null) {
                return;
            }
            a2.a(str, i2);
        }

        @Override // d.a.k0.o.d.g.c
        public void b(String str, StopStatus stopStatus) {
            d.a.k0.o.d.g.a a2 = d.a.k0.o.d.d.c().a((DownloadCacheKey) b.this.f60827b.get(str));
            if (a2 == null) {
                return;
            }
            a2.b(str, stopStatus);
        }

        @Override // d.a.k0.o.d.g.c
        public void c(String str) {
            d.a.k0.o.d.g.a a2 = d.a.k0.o.d.d.c().a((DownloadCacheKey) b.this.f60827b.get(str));
            if (a2 == null) {
                return;
            }
            Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
            a2.c(str);
        }

        @Override // d.a.k0.o.d.g.c
        public void d(String str, int i2) {
            d.a.k0.o.d.g.a a2 = d.a.k0.o.d.d.c().a((DownloadCacheKey) b.this.f60827b.get(str));
            if (a2 == null) {
                return;
            }
            a2.d(str, i2);
        }

        @Override // d.a.k0.o.d.g.c
        public void onSuccess(String str, String str2) {
            DownloadCacheKey downloadCacheKey = (DownloadCacheKey) b.this.f60827b.get(str);
            String a2 = d.a.k0.o.d.a.a(TbadkCoreApplication.getInst(), str2);
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
                b.this.f60827b.put(str, downloadCacheKey);
            }
            if (!TextUtils.isEmpty(a2)) {
                downloadCacheKey.mPackageName = a2;
            }
            AdDownloadData b2 = d.a.k0.o.d.d.c().b(downloadCacheKey);
            if (!TextUtils.isEmpty(a2)) {
                b2.setupPkgName(a2);
            }
            d.a.k0.o.d.g.a a3 = d.a.k0.o.d.d.c().a(downloadCacheKey);
            if (a3 == null) {
                return;
            }
            if (d.a.k0.o.d.a.b(TbadkCoreApplication.getInst(), a2)) {
                a3.g();
            } else {
                a3.onSuccess(str, str2);
            }
        }
    }

    @Override // d.a.k0.o.d.h.a
    public void a(String str) {
        DownloadCacheKey downloadCacheKey = this.f60827b.get(str);
        if (downloadCacheKey == null) {
            return;
        }
        i.l().g(downloadCacheKey.mDownloadUrl, str, true);
    }

    @Override // d.a.k0.o.d.h.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        this.f60827b.put(downloadCacheKey.mAdId, downloadCacheKey);
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

    @Override // d.a.k0.o.d.h.a
    public d.a.k0.o.d.g.c c() {
        return this.f60828c;
    }

    @Override // d.a.k0.o.d.h.a
    public void d(String str) {
        DownloadCacheKey downloadCacheKey = this.f60827b.get(str);
        if (downloadCacheKey == null) {
            return;
        }
        this.f60827b.put(downloadCacheKey.mAdId, downloadCacheKey);
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
