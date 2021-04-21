package d.b.j0.o.c.b.d;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.j0.o.d.d;
import d.b.j0.o.d.f.b;
import d.b.j0.s2.w;
import java.io.File;
/* loaded from: classes4.dex */
public class a extends d.b.j0.o.d.f.a<b, AdDownloadData> {

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f59049c;

    /* renamed from: d.b.j0.o.c.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1433a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f59050a;

        static {
            int[] iArr = new int[DownloadStatus.values().length];
            f59050a = iArr;
            try {
                iArr[DownloadStatus.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f59050a[DownloadStatus.STATUS_DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f59050a[DownloadStatus.STATUS_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f59050a[DownloadStatus.STATUS_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f59050a[DownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a(@NonNull b bVar, @NonNull AdDownloadData adDownloadData) {
        super(bVar, adDownloadData);
    }

    public final boolean j() {
        if (c() == null || !(c().getRealView().getContext() instanceof Activity) || d.b.j0.a.e().o()) {
            return true;
        }
        if (this.f59049c == null) {
            this.f59049c = new PermissionJudgePolicy();
        }
        this.f59049c.clearRequestPermissionList();
        this.f59049c.appendRequestPermission((Activity) c().getRealView().getContext(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        return !this.f59049c.startRequestPermission((Activity) c().getRealView().getContext());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.o.d.f.a
    /* renamed from: k */
    public void h(AdDownloadData adDownloadData) {
        if (adDownloadData == null) {
            return;
        }
        DownloadStatus currentState = adDownloadData.getCurrentState();
        DownloadCacheKey g2 = d.c().g(adDownloadData.adId());
        int i = C1433a.f59050a[currentState.ordinal()];
        if (i == 1) {
            if (g2 != null && j()) {
                d.c().l(g2, null);
            }
        } else if (i == 2) {
            d.c().e(adDownloadData.adId());
        } else if (i == 3) {
            if (j()) {
                d.c().j(adDownloadData.adId());
            }
        } else if (i != 4) {
            if (i != 5) {
                return;
            }
            d.c().o(c().getRealView().getContext(), adDownloadData.pkgName());
        } else if (g2 != null && j()) {
            String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
            boolean z = false;
            if (!TextUtils.isEmpty(downloadFilePath) && new File(downloadFilePath).exists()) {
                z = d.c().m(c().getRealView().getContext(), g2, adDownloadData.extra().getDownloadFilePath());
            }
            if (!TextUtils.isEmpty(downloadFilePath) && new File(downloadFilePath).exists() && z) {
                return;
            }
            adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
            h(adDownloadData);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.o.d.f.a
    /* renamed from: l */
    public void i(@NonNull AdDownloadData adDownloadData) {
        if (w.q(adDownloadData.getPkgName())) {
            adDownloadData.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            return;
        }
        String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
        if (TextUtils.isEmpty(downloadFilePath) && !TextUtils.isEmpty(adDownloadData.adId())) {
            downloadFilePath = d.b.j0.s2.b.h(adDownloadData.adId());
        }
        if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
            return;
        }
        adDownloadData.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
    }
}
