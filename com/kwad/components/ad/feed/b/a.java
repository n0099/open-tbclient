package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public abstract class a extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> {
    public boolean ex;
    public long ey;
    public SimpleImageLoadingListener ez;

    public a(@NonNull Context context) {
        super(context);
        this.ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.a.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 1, 2, str, null, SystemClock.elapsedRealtime() - a.this.ey);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 2, 2, str, failReason.toString(), SystemClock.elapsedRealtime() - a.this.ey);
            }
        };
    }

    public final void ba() {
        if (this.ex) {
            return;
        }
        this.ex = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 1, getStayTime());
    }

    public final void bb() {
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f09133a);
        if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
            return;
        }
        complianceTextView.setVisibility(8);
    }
}
