package d.b.i0.r0.f;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.view.FunAdButton;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import d.b.i0.c3.h0.n;
/* loaded from: classes4.dex */
public class a implements TTAppDownloadListener, ChannelNativeAds_5.GdtADStatusChangeListener, KsAppDownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public final FunAdButton f59727a;

    /* renamed from: b  reason: collision with root package name */
    public final n f59728b;

    public a(FunAdButton funAdButton, n nVar) {
        this.f59727a = funAdButton;
        this.f59728b = nVar;
    }

    public void a(int i) {
        FunAdButton funAdButton = this.f59727a;
        if (funAdButton != null && funAdButton.getTag() == this.f59728b) {
            this.f59727a.setText(i);
        }
        n nVar = this.f59728b;
        if (nVar != null) {
            nVar.g(TbadkApplication.getInst().getString(i));
        }
    }

    public void b(int i) {
        FunAdButton funAdButton = this.f59727a;
        if (funAdButton == null || funAdButton.getTag() != this.f59728b) {
            return;
        }
        this.f59727a.setProgress(i);
    }

    @Override // com.fun.ad.sdk.ChannelNativeAds_5.GdtADStatusChangeListener
    public void onADStatusChanged(NativeUnifiedADData nativeUnifiedADData) {
        if (!nativeUnifiedADData.isAppAd()) {
            a(R.string.ad_interaction_type_view);
            return;
        }
        int appStatus = nativeUnifiedADData.getAppStatus();
        if (appStatus == 0) {
            a(R.string.ad_interaction_type_download);
        } else if (appStatus == 1) {
            a(R.string.ad_interaction_type_start);
        } else if (appStatus == 2) {
            a(R.string.ad_interaction_type_update);
        } else if (appStatus == 4) {
            b(nativeUnifiedADData.getProgress());
        } else if (appStatus == 8) {
            a(R.string.ad_interaction_type_install);
        } else if (appStatus != 16) {
            a(R.string.ad_interaction_type_view);
        } else {
            a(R.string.ad_interaction_type_redownload);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        if (j > 0) {
            b((int) ((j2 * 100) / j));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        a(R.string.ad_interaction_type_download);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        a(R.string.ad_interaction_type_install);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        if (j > 0) {
            b((int) ((j2 * 100) / j));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        a(R.string.ad_interaction_type_download);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        a(R.string.ad_interaction_type_open);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        b(i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        a(R.string.ad_interaction_type_download);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        a(R.string.ad_interaction_type_install);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        a(R.string.ad_interaction_type_open);
    }
}
