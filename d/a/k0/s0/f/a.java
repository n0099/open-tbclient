package d.a.k0.s0.f;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.view.FunAdButton;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import d.a.k0.d3.h0.n;
/* loaded from: classes4.dex */
public class a implements TTAppDownloadListener, ChannelNativeAds_6.GdtADStatusChangeListener, KsAppDownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public final FunAdButton f60769a;

    /* renamed from: b  reason: collision with root package name */
    public final n f60770b;

    public a(FunAdButton funAdButton, n nVar) {
        this.f60769a = funAdButton;
        this.f60770b = nVar;
    }

    public void a(int i2) {
        FunAdButton funAdButton = this.f60769a;
        if (funAdButton != null && funAdButton.getTag() == this.f60770b) {
            this.f60769a.setText(i2);
        }
        n nVar = this.f60770b;
        if (nVar != null) {
            nVar.i(TbadkApplication.getInst().getString(i2));
        }
    }

    public void b(int i2) {
        FunAdButton funAdButton = this.f60769a;
        if (funAdButton == null || funAdButton.getTag() != this.f60770b) {
            return;
        }
        this.f60769a.setProgress(i2);
    }

    @Override // com.fun.ad.sdk.ChannelNativeAds_6.GdtADStatusChangeListener
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
    public void onProgressUpdate(int i2) {
        b(i2);
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
