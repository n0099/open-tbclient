package com.kwad.sdk.reflux.kwai;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes8.dex */
public class c extends a {
    public c(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.reflux.kwai.a
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        FrameLayout.inflate(context, R.layout.ksad_reflux_card_top, this);
        ((a) this).a = (TextView) findViewById(R.id.ksad_reflux_card_title);
        ((a) this).f55756e = (ImageView) findViewById(R.id.ksad_reflux_card_img);
        ((a) this).f55757f = (KsLogoView) findViewById(R.id.ksad_reflux_card_logo);
        ((a) this).f55755d = (ImageView) findViewById(R.id.ksad_reflux_app_icon);
        ((a) this).f55753b = (TextView) findViewById(R.id.ksad_reflux_app_name);
        ((a) this).f55754c = (TextView) findViewById(R.id.ksad_reflux_app_desc);
        ((a) this).f55758g = (ComplianceTextView) findViewById(R.id.ksad_reflux_card_title_compliance);
        this.f55759h = (DownloadProgressView) findViewById(R.id.ksad_reflux_app_download_btn);
    }
}
