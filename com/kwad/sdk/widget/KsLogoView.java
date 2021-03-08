package com.kwad.sdk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class KsLogoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f7158a;
    ImageView b;
    private boolean c;

    public KsLogoView(Context context) {
        super(context);
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        inflate(context, R.layout.ksad_logo_layout, this);
        this.f7158a = (TextView) findViewById(R.id.ksad_logo_text);
        this.b = (ImageView) findViewById(R.id.ksad_logo_icon);
        this.c = getBackground() == null;
        if (this.c) {
            this.b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_gray));
            this.f7158a.setTextColor(-6513508);
            return;
        }
        this.b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_white));
        this.f7158a.setTextColor(-1711276033);
    }

    public void a(AdTemplate adTemplate) {
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        if (TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
            this.f7158a.setVisibility(8);
        } else {
            this.f7158a.setText(com.kwad.sdk.core.response.b.a.v(j));
            this.f7158a.setVisibility(0);
        }
        String str = this.c ? j.adBaseInfo.adGrayMarkIcon : j.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str)) {
            this.b.setVisibility(8);
        } else {
            KSImageLoader.loadFeeImage(this.b, str, adTemplate);
            this.b.setVisibility(0);
        }
        findViewById.setVisibility(0);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
            this.f7158a.setVisibility(0);
            this.f7158a.setText(com.kwad.sdk.core.response.b.a.v(j));
            this.b.setVisibility(0);
            this.b.setImageDrawable(getContext().getResources().getDrawable(this.c ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
        }
    }
}
