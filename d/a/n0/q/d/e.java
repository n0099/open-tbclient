package d.a.n0.q.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.a.n0.t2.y;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final Map<DownloadCacheKey, d.a.n0.q.d.h.a> f58206a;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final e f58207a = new e();
    }

    public static e c() {
        return b.f58207a;
    }

    public d.a.n0.q.d.h.a a(DownloadCacheKey downloadCacheKey) {
        return this.f58206a.get(downloadCacheKey);
    }

    @NonNull
    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData a2 = d.a.n0.q.d.b.c().a(downloadCacheKey);
        if (a2 == null) {
            AdDownloadData e2 = new AdDownloadData.b(downloadCacheKey).e();
            d.a.n0.q.d.b.c().d(downloadCacheKey, e2);
            return e2;
        }
        return a2;
    }

    public void d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        AdDownloadData adDownloadData = null;
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : d.a.n0.q.d.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                adDownloadData = value;
            }
        }
        for (d.a.n0.q.d.h.a aVar : k(str)) {
            if (aVar != null && aVar.l() != 4) {
                aVar.k(4);
                aVar.g();
            }
        }
        d.a.n0.t2.b.b(str);
        f.g().j(context, adDownloadData);
    }

    public void e(String str) {
        d.a.n0.q.d.i.a.f58232a.get().a(str);
        f(d.a.n0.q.d.b.c().a(g(str)), CyberPlayerManager.MEDIA_INFO_BUFFERING_END);
    }

    public void f(@NonNull AdDownloadData adDownloadData, int i2) {
        d.a.n0.q.d.h.a aVar;
        DownloadCacheKey g2 = g(adDownloadData.adId());
        if (g2 == null || (aVar = this.f58206a.get(g2)) == null) {
            return;
        }
        aVar.j(i2, adDownloadData.getPkgName(), adDownloadData.getExtInfo(), adDownloadData);
    }

    @Nullable
    public DownloadCacheKey g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, d.a.n0.q.d.h.a> entry : this.f58206a.entrySet()) {
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
        for (Map.Entry<DownloadCacheKey, d.a.n0.q.d.h.a> entry : this.f58206a.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void i(@NonNull DownloadCacheKey downloadCacheKey, d.a.n0.q.d.h.d dVar) {
        d.a.n0.q.d.h.a aVar = this.f58206a.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new d.a.n0.q.d.h.a(downloadCacheKey);
            this.f58206a.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.e(dVar);
        }
    }

    public void j(String str) {
        d.a.n0.q.d.i.a.f58232a.get().d(str);
        f(d.a.n0.q.d.b.c().a(g(str)), SDKLogTypeConstants.TYPE_LP_LIFE_CIRCLE);
    }

    public final Set<d.a.n0.q.d.h.a> k(String str) {
        HashSet hashSet = new HashSet(this.f58206a.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, d.a.n0.q.d.h.a> entry : this.f58206a.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public String l(@NonNull DownloadCacheKey downloadCacheKey, @Nullable d.a.n0.q.d.h.d dVar) {
        if (dVar != null) {
            i(downloadCacheKey, dVar);
        }
        AdDownloadData a2 = d.a.n0.q.d.b.c().a(downloadCacheKey);
        d.a.n0.q.d.i.a.f58232a.get().b(downloadCacheKey, a2);
        f(a2, 701);
        return downloadCacheKey.mAdId;
    }

    public boolean m(Context context, DownloadCacheKey downloadCacheKey, @NonNull String str) {
        AdDownloadData a2;
        DownloadCacheKey downloadCacheKey2;
        boolean b2 = y.b(str);
        if (!b2) {
            d.a.n0.t2.b.c(new File(str));
        }
        if (downloadCacheKey != null && (a2 = d.a.n0.q.d.b.c().a(downloadCacheKey)) != null) {
            if (TextUtils.isEmpty(a2.pkgName())) {
                a2.setupPkgName(d.a.n0.q.d.a.a(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = a2.pkgName();
            }
            d.a.n0.q.d.h.a aVar = this.f58206a.get(downloadCacheKey);
            if (aVar != null && (downloadCacheKey2 = aVar.f58228c) != null && TextUtils.isEmpty(downloadCacheKey2.mPackageName)) {
                aVar.f58228c.mPackageName = a2.pkgName();
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
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : d.a.n0.q.d.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                f(value, SDKLogTypeConstants.CLOSE_GAME_TYPE);
            }
        }
        return d.a.n0.q.d.a.c(context, str);
    }

    public void p(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : d.a.n0.q.d.b.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_NONE);
            }
        }
        for (d.a.n0.q.d.h.a aVar : k(str)) {
            if (aVar != null && aVar.l() != 0) {
                aVar.k(0);
                aVar.h();
            }
        }
    }

    public void q(DownloadCacheKey downloadCacheKey, d.a.n0.q.d.h.d dVar) {
        d.a.n0.q.d.h.a aVar = this.f58206a.get(downloadCacheKey);
        if (aVar == null) {
            return;
        }
        aVar.i(dVar);
    }

    public e() {
        this.f58206a = new HashMap();
        f.g().k();
    }
}
