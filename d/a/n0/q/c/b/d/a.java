package d.a.n0.q.c.b.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.n0.q.d.d;
import d.a.n0.q.d.e;
import d.a.n0.q.d.g.b;
import d.a.n0.t2.y;
import java.io.File;
/* loaded from: classes4.dex */
public class a extends d.a.n0.q.d.g.a<b, AdDownloadData> {

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f61887c;

    /* renamed from: d  reason: collision with root package name */
    public final d f61888d;

    /* renamed from: d.a.n0.q.c.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1529a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f61889a;

        static {
            int[] iArr = new int[DownloadStatus.values().length];
            f61889a = iArr;
            try {
                iArr[DownloadStatus.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61889a[DownloadStatus.STATUS_DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61889a[DownloadStatus.STATUS_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f61889a[DownloadStatus.STATUS_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f61889a[DownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a(@NonNull b bVar, @NonNull AdDownloadData adDownloadData) {
        super(bVar, adDownloadData);
        this.f61888d = new d(this, adDownloadData);
    }

    @Override // d.a.n0.q.d.g.a
    public void g(int i2) {
        super.g(i2);
        if (c().getContentLength() <= 1) {
            AdDownloadData c2 = c();
            long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(c2.adId(), 0L);
            c2.setContentLength(Math.max(c().getContentLength(), j));
            this.f61888d.d(j);
        }
    }

    @Override // d.a.n0.q.d.g.a
    public void h(@NonNull DownloadStatus downloadStatus) {
        super.h(downloadStatus);
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c().setFakePercent(0);
            c().setPercent(0);
        }
    }

    public final boolean l() {
        if (d() == null || !(d().getRealView().getContext() instanceof Activity) || d.a.n0.a.h().r()) {
            return true;
        }
        if (this.f61887c == null) {
            this.f61887c = new PermissionJudgePolicy();
        }
        this.f61887c.clearRequestPermissionList();
        this.f61887c.appendRequestPermission((Activity) d().getRealView().getContext(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        return !this.f61887c.startRequestPermission((Activity) d().getRealView().getContext());
    }

    public void m() {
        i();
        this.f61888d.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.q.d.g.a
    /* renamed from: n */
    public void j(AdDownloadData adDownloadData) {
        if (adDownloadData == null) {
            return;
        }
        DownloadStatus currentState = adDownloadData.getCurrentState();
        DownloadCacheKey g2 = e.c().g(adDownloadData.adId());
        int i2 = C1529a.f61889a[currentState.ordinal()];
        if (i2 == 1) {
            if (g2 != null && l()) {
                e.c().l(g2, null);
                this.f61888d.a();
            }
        } else if (i2 == 2) {
            e.c().e(adDownloadData.adId());
        } else if (i2 == 3) {
            if (l()) {
                e.c().j(adDownloadData.adId());
                this.f61888d.a();
            }
        } else if (i2 != 4) {
            if (i2 != 5) {
                return;
            }
            e.c().o(d().getRealView().getContext(), adDownloadData.pkgName());
            adDownloadData.setFakePercent(0);
            adDownloadData.setPercent(0);
        } else if (g2 != null && l()) {
            String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
            boolean m = (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) ? false : e.c().m(d().getRealView().getContext(), g2, adDownloadData.extra().getDownloadFilePath());
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists() || !m) {
                adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
                j(adDownloadData);
            }
            adDownloadData.setFakePercent(0);
            adDownloadData.setPercent(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.q.d.g.a
    /* renamed from: o */
    public void k(@NonNull AdDownloadData adDownloadData) {
        if (y.q(adDownloadData.getPkgName())) {
            adDownloadData.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            return;
        }
        String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
        if (TextUtils.isEmpty(downloadFilePath) && !TextUtils.isEmpty(adDownloadData.adId())) {
            downloadFilePath = d.a.n0.t2.b.h(adDownloadData.adId());
        }
        if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
            return;
        }
        adDownloadData.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
    }
}
