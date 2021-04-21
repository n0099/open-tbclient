package d.b.j0.o.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.b.j0.s2.w;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Map<DownloadCacheKey, d.b.j0.o.d.g.a> f59053a;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f59054a = new d();
    }

    public static d c() {
        return b.f59054a;
    }

    public d.b.j0.o.d.g.a a(DownloadCacheKey downloadCacheKey) {
        return this.f59053a.get(downloadCacheKey);
    }

    @NonNull
    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData a2 = d.b.j0.o.d.b.c().a(downloadCacheKey);
        if (a2 == null) {
            AdDownloadData g2 = new AdDownloadData.b(downloadCacheKey).g();
            d.b.j0.o.d.b.c().d(downloadCacheKey, g2);
            return g2;
        }
        return a2;
    }

    public void d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        AdDownloadData adDownloadData = null;
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : d.b.j0.o.d.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                adDownloadData = value;
            }
        }
        for (d.b.j0.o.d.g.a aVar : k(str)) {
            if (aVar != null && aVar.l() != 4) {
                aVar.k(4);
                aVar.g();
            }
        }
        d.b.j0.s2.b.b(str);
        e.g().j(context, adDownloadData);
    }

    public void e(String str) {
        d.b.j0.o.d.h.a.f59080a.get().b(str);
        f(d.b.j0.o.d.b.c().a(g(str)), 702);
    }

    public void f(@NonNull AdDownloadData adDownloadData, int i) {
        d.b.j0.o.d.g.a aVar;
        DownloadCacheKey g2 = g(adDownloadData.adId());
        if (g2 == null || (aVar = this.f59053a.get(g2)) == null) {
            return;
        }
        aVar.j(i, adDownloadData.getPkgName(), adDownloadData.getExtInfo(), adDownloadData);
    }

    @Nullable
    public DownloadCacheKey g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, d.b.j0.o.d.g.a> entry : this.f59053a.entrySet()) {
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
        for (Map.Entry<DownloadCacheKey, d.b.j0.o.d.g.a> entry : this.f59053a.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void i(@NonNull DownloadCacheKey downloadCacheKey, d.b.j0.o.d.g.d dVar) {
        d.b.j0.o.d.g.a aVar = this.f59053a.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new d.b.j0.o.d.g.a(downloadCacheKey);
            this.f59053a.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.e(dVar);
        }
    }

    public void j(String str) {
        d.b.j0.o.d.h.a.f59080a.get().d(str);
        f(d.b.j0.o.d.b.c().a(g(str)), 703);
    }

    public final Set<d.b.j0.o.d.g.a> k(String str) {
        HashSet hashSet = new HashSet(this.f59053a.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, d.b.j0.o.d.g.a> entry : this.f59053a.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public String l(@NonNull DownloadCacheKey downloadCacheKey, @Nullable d.b.j0.o.d.g.d dVar) {
        if (dVar != null) {
            i(downloadCacheKey, dVar);
        }
        AdDownloadData a2 = d.b.j0.o.d.b.c().a(downloadCacheKey);
        d.b.j0.o.d.h.a.f59080a.get().c(downloadCacheKey, a2);
        f(a2, 701);
        return downloadCacheKey.mAdId;
    }

    public boolean m(Context context, DownloadCacheKey downloadCacheKey, @NonNull String str) {
        AdDownloadData a2;
        DownloadCacheKey downloadCacheKey2;
        boolean b2 = w.b(str);
        if (!b2) {
            d.b.j0.s2.b.c(new File(str));
        }
        if (downloadCacheKey != null && (a2 = d.b.j0.o.d.b.c().a(downloadCacheKey)) != null) {
            if (TextUtils.isEmpty(a2.pkgName())) {
                a2.setupPkgName(d.b.j0.o.d.a.a(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = a2.pkgName();
            }
            d.b.j0.o.d.g.a aVar = this.f59053a.get(downloadCacheKey);
            if (aVar != null && (downloadCacheKey2 = aVar.f59075c) != null && TextUtils.isEmpty(downloadCacheKey2.mPackageName)) {
                aVar.f59075c.mPackageName = a2.pkgName();
            }
            a2.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            a2.extra().setDownloadPath(str);
            f(a2, SDKLogTypeConstants.SEND_PLAY_FAIL_TYPE);
        }
        return b2;
    }

    public boolean n(String str, @NonNull String str2) {
        return m(TbadkCoreApplication.getInst(), g(str), str2);
    }

    public boolean o(Context context, String str) {
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : d.b.j0.o.d.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                f(value, SDKLogTypeConstants.CLOSE_GAME_TYPE);
            }
        }
        return d.b.j0.o.d.a.c(context, str);
    }

    public void p(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : d.b.j0.o.d.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_NONE);
            }
        }
        for (d.b.j0.o.d.g.a aVar : k(str)) {
            if (aVar != null && aVar.l() != 0) {
                aVar.k(0);
                aVar.h();
            }
        }
    }

    public void q(DownloadCacheKey downloadCacheKey, d.b.j0.o.d.g.d dVar) {
        d.b.j0.o.d.g.a aVar = this.f59053a.get(downloadCacheKey);
        if (aVar == null) {
            return;
        }
        aVar.i(dVar);
    }

    public d() {
        this.f59053a = new HashMap();
        e.g().k();
    }
}
