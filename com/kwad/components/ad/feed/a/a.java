package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public abstract class a extends com.kwad.components.core.widget.b<AdTemplate> {
    public com.kwad.components.ad.feed.b dd;

    public a(@NonNull Context context) {
        super(context);
    }

    public final void bf() {
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0911f5);
        if (!com.kwad.sdk.core.response.a.a.ao(this.mAdInfo)) {
            complianceTextView.setVisibility(8);
            return;
        }
        complianceTextView.setVisibility(0);
        complianceTextView.setAdTemplate(this.mAdTemplate);
    }

    public final void g(boolean z) {
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo) && com.kwad.components.ad.feed.kwai.b.bd() && getApkDownloadHelper() != null) {
            DownloadProgressView downloadProgressView = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f0911ce);
            if (!z || getApkDownloadHelper().mI() == 2) {
                com.kwad.components.ad.feed.b bVar = this.dd;
                if (bVar != null) {
                    bVar.aX();
                    return;
                }
                return;
            }
            setPaddingToShowAnim(downloadProgressView);
            if (this.dd == null) {
                this.dd = new com.kwad.components.ad.feed.b();
            }
            this.dd.a(downloadProgressView);
        }
    }

    public com.kwad.components.core.c.a.c getApkDownloadHelper() {
        return null;
    }

    public void setPaddingToShowAnim(View view2) {
        if (view2.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            viewGroup.setPadding(0, 0, com.kwad.sdk.b.kwai.a.a(this.mContext, 4.0f), 0);
            viewGroup.setClipToPadding(false);
        }
    }
}
