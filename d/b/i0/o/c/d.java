package d.b.i0.o.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.kwai.video.player.PlayerPostEvent;
import d.b.i0.r2.t;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Map<DownloadCacheKey, d.b.i0.o.c.f.a> f57183a;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f57184a = new d();
    }

    public static d c() {
        return b.f57184a;
    }

    public d.b.i0.o.c.f.a a(DownloadCacheKey downloadCacheKey) {
        return this.f57183a.get(downloadCacheKey);
    }

    @NonNull
    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData a2 = d.b.i0.o.c.b.c().a(downloadCacheKey);
        if (a2 == null) {
            AdDownloadData f2 = new AdDownloadData.b(downloadCacheKey).f();
            d.b.i0.o.c.b.c().d(downloadCacheKey, f2);
            return f2;
        }
        return a2;
    }

    public void d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : d.b.i0.o.c.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            }
        }
        for (d.b.i0.o.c.f.a aVar : k(str)) {
            if (aVar != null && aVar.l() != 4) {
                aVar.k(4);
                aVar.g();
            }
        }
        d.b.i0.r2.b.b(str);
    }

    public void e(String str) {
        d.b.i0.o.c.g.a.f57195a.get().b(str);
        f(d.b.i0.o.c.b.c().a(g(str)), 702);
    }

    public void f(@NonNull AdDownloadData adDownloadData, int i) {
        d.b.i0.o.c.f.a aVar;
        DownloadCacheKey g2 = g(adDownloadData.adId());
        if (g2 == null || (aVar = this.f57183a.get(g2)) == null) {
            return;
        }
        aVar.j(adDownloadData.getPage(), i, adDownloadData.getPkgName(), adDownloadData.getExtInfo());
    }

    @Nullable
    public DownloadCacheKey g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, d.b.i0.o.c.f.a> entry : this.f57183a.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, d.b.i0.o.c.f.a> entry : this.f57183a.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void i(@NonNull DownloadCacheKey downloadCacheKey, d.b.i0.o.c.f.d dVar) {
        d.b.i0.o.c.f.a aVar = this.f57183a.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new d.b.i0.o.c.f.a(downloadCacheKey);
            this.f57183a.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.e(dVar);
        }
    }

    public void j(String str) {
        d.b.i0.o.c.g.a.f57195a.get().d(str);
        f(d.b.i0.o.c.b.c().a(g(str)), PlayerPostEvent.MEDIA_INFO_NETWORK_BANDWIDTH);
    }

    public final Set<d.b.i0.o.c.f.a> k(String str) {
        HashSet hashSet = new HashSet(this.f57183a.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, d.b.i0.o.c.f.a> entry : this.f57183a.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public String l(@NonNull DownloadCacheKey downloadCacheKey, @Nullable d.b.i0.o.c.f.d dVar) {
        if (dVar != null) {
            i(downloadCacheKey, dVar);
        }
        AdDownloadData a2 = d.b.i0.o.c.b.c().a(downloadCacheKey);
        d.b.i0.o.c.g.a.f57195a.get().c(downloadCacheKey, a2);
        f(a2, 701);
        return downloadCacheKey.mAdId;
    }

    public boolean m(Context context, DownloadCacheKey downloadCacheKey, @NonNull String str) {
        AdDownloadData a2;
        DownloadCacheKey downloadCacheKey2;
        boolean b2 = t.b(str);
        if (!b2) {
            d.b.i0.r2.b.c(new File(str));
        }
        if (downloadCacheKey != null && (a2 = d.b.i0.o.c.b.c().a(downloadCacheKey)) != null) {
            if (TextUtils.isEmpty(a2.pkgName())) {
                a2.setupPkgName(d.b.i0.o.c.a.a(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = a2.pkgName();
            }
            d.b.i0.o.c.f.a aVar = this.f57183a.get(downloadCacheKey);
            if (aVar != null && (downloadCacheKey2 = aVar.f57190c) != null && TextUtils.isEmpty(downloadCacheKey2.mPackageName)) {
                aVar.f57190c.mPackageName = a2.pkgName();
            }
            a2.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            a2.extra().setDownloadPath(str);
            f(a2, 705);
        }
        return b2;
    }

    public boolean n(String str, @NonNull String str2) {
        return m(TbadkCoreApplication.getInst(), g(str), str2);
    }

    public boolean o(Context context, String str) {
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : d.b.i0.o.c.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                f(value, 706);
            }
        }
        return d.b.i0.o.c.a.c(context, str);
    }

    public void p(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : d.b.i0.o.c.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_NONE);
            }
        }
        for (d.b.i0.o.c.f.a aVar : k(str)) {
            if (aVar != null && aVar.l() != 0) {
                aVar.k(0);
                aVar.h();
            }
        }
    }

    public void q(DownloadCacheKey downloadCacheKey, d.b.i0.o.c.f.d dVar) {
        d.b.i0.o.c.f.a aVar = this.f57183a.get(downloadCacheKey);
        if (aVar == null) {
            return;
        }
        aVar.i(dVar);
    }

    public d() {
        this.f57183a = new HashMap();
    }
}
