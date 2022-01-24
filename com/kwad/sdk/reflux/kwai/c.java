package com.kwad.sdk.reflux.kwai;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes3.dex */
public class c extends a {
    public c(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.reflux.kwai.a
    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        FrameLayout.inflate(context, R.layout.ksad_reflux_card_top, this);
        ((a) this).a = (TextView) findViewById(R.id.ksad_reflux_card_title);
        ((a) this).f57239e = (ImageView) findViewById(R.id.ksad_reflux_card_img);
        ((a) this).f57240f = (KsLogoView) findViewById(R.id.ksad_reflux_card_logo);
        ((a) this).f57238d = (ImageView) findViewById(R.id.ksad_reflux_app_icon);
        ((a) this).f57236b = (TextView) findViewById(R.id.ksad_reflux_app_name);
        ((a) this).f57237c = (TextView) findViewById(R.id.ksad_reflux_app_desc);
        ((a) this).f57241g = (ComplianceTextView) findViewById(R.id.ksad_reflux_card_title_compliance);
        this.f57242h = (DownloadProgressView) findViewById(R.id.ksad_reflux_app_download_btn);
    }
}
