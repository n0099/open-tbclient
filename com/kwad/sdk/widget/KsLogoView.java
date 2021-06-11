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
/* loaded from: classes7.dex */
public class KsLogoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f37570a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f37571b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37572c;

    public KsLogoView(Context context) {
        super(context);
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        TextView textView;
        int i2;
        LinearLayout.inflate(context, R.layout.ksad_logo_layout, this);
        this.f37570a = (TextView) findViewById(R.id.ksad_logo_text);
        this.f37571b = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.f37572c = z;
        if (z) {
            this.f37571b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_gray));
            textView = this.f37570a;
            i2 = -6513508;
        } else {
            this.f37571b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_white));
            textView = this.f37570a;
            i2 = -1711276033;
        }
        textView.setTextColor(i2);
    }

    public void a(AdTemplate adTemplate) {
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        if (TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
            this.f37570a.setVisibility(8);
        } else {
            this.f37570a.setText(com.kwad.sdk.core.response.b.a.v(j));
            this.f37570a.setVisibility(0);
        }
        String str = this.f37572c ? j.adBaseInfo.adGrayMarkIcon : j.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str)) {
            this.f37571b.setVisibility(8);
        } else {
            KSImageLoader.loadFeeImage(this.f37571b, str, adTemplate);
            this.f37571b.setVisibility(0);
        }
        findViewById.setVisibility(0);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
            this.f37570a.setVisibility(0);
            this.f37570a.setText(com.kwad.sdk.core.response.b.a.v(j));
            this.f37571b.setVisibility(0);
            this.f37571b.setImageDrawable(getContext().getResources().getDrawable(this.f37572c ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
        }
    }
}
