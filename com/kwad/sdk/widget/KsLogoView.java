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
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class KsLogoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f34944a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34945b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34946c;

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

    public KsLogoView(Context context, boolean z) {
        super(context);
        if (z) {
            setBackgroundResource(R.drawable.ksad_splash_logo_bg);
        }
        a(context);
    }

    private void a(Context context) {
        TextView textView;
        int i2;
        LinearLayout.inflate(context, R.layout.ksad_logo_layout, this);
        this.f34944a = (TextView) findViewById(R.id.ksad_logo_text);
        this.f34945b = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.f34946c = z;
        if (z) {
            this.f34945b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_gray));
            textView = this.f34944a;
            i2 = -6513508;
        } else {
            this.f34945b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_white));
            textView = this.f34944a;
            i2 = -1711276033;
        }
        textView.setTextColor(i2);
    }

    public void a(AdTemplate adTemplate) {
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo g2 = c.g(adTemplate);
        if (TextUtils.isEmpty(g2.adBaseInfo.adSourceDescription)) {
            this.f34944a.setVisibility(8);
            this.f34944a.setText("");
        } else {
            this.f34944a.setText(a.t(g2));
            this.f34944a.setVisibility(0);
        }
        String str = this.f34946c ? g2.adBaseInfo.adGrayMarkIcon : g2.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str)) {
            this.f34945b.setVisibility(8);
            this.f34945b.setImageDrawable(null);
        } else {
            KSImageLoader.loadFeeImage(this.f34945b, str, adTemplate);
            this.f34945b.setVisibility(0);
        }
        findViewById.setVisibility(0);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(g2.adBaseInfo.adSourceDescription)) {
            this.f34944a.setVisibility(0);
            this.f34944a.setText(a.t(g2));
            this.f34945b.setVisibility(0);
            this.f34945b.setImageDrawable(getContext().getResources().getDrawable(this.f34946c ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
        }
    }

    public ImageView getIcon() {
        return this.f34945b;
    }

    public TextView getTextView() {
        return this.f34944a;
    }
}
