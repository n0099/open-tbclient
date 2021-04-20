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
/* loaded from: classes6.dex */
public class KsLogoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f37101a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f37102b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37103c;

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
        TextView textView;
        int i;
        LinearLayout.inflate(context, R.layout.ksad_logo_layout, this);
        this.f37101a = (TextView) findViewById(R.id.ksad_logo_text);
        this.f37102b = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.f37103c = z;
        if (z) {
            this.f37102b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_gray));
            textView = this.f37101a;
            i = -6513508;
        } else {
            this.f37102b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_white));
            textView = this.f37101a;
            i = -1711276033;
        }
        textView.setTextColor(i);
    }

    public void a(AdTemplate adTemplate) {
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        if (TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
            this.f37101a.setVisibility(8);
        } else {
            this.f37101a.setText(com.kwad.sdk.core.response.b.a.v(j));
            this.f37101a.setVisibility(0);
        }
        String str = this.f37103c ? j.adBaseInfo.adGrayMarkIcon : j.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str)) {
            this.f37102b.setVisibility(8);
        } else {
            KSImageLoader.loadFeeImage(this.f37102b, str, adTemplate);
            this.f37102b.setVisibility(0);
        }
        findViewById.setVisibility(0);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
            this.f37101a.setVisibility(0);
            this.f37101a.setText(com.kwad.sdk.core.response.b.a.v(j));
            this.f37102b.setVisibility(0);
            this.f37102b.setImageDrawable(getContext().getResources().getDrawable(this.f37103c ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
        }
    }
}
