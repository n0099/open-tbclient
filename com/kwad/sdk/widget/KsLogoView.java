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
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class KsLogoView extends LinearLayout {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60331b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60332c;

    /* renamed from: d  reason: collision with root package name */
    public SimpleImageLoadingListener f60333d;

    /* renamed from: e  reason: collision with root package name */
    public a f60334e;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public KsLogoView(Context context) {
        super(context);
        this.f60333d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.f60334e != null) {
                    KsLogoView.this.f60334e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.f60334e != null) {
                    KsLogoView.this.f60334e.a();
                }
            }
        };
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60333d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.f60334e != null) {
                    KsLogoView.this.f60334e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.f60334e != null) {
                    KsLogoView.this.f60334e.a();
                }
            }
        };
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f60333d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.f60334e != null) {
                    KsLogoView.this.f60334e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.f60334e != null) {
                    KsLogoView.this.f60334e.a();
                }
            }
        };
        a(context);
    }

    public KsLogoView(Context context, boolean z) {
        super(context);
        this.f60333d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.f60334e != null) {
                    KsLogoView.this.f60334e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.f60334e != null) {
                    KsLogoView.this.f60334e.a();
                }
            }
        };
        if (z) {
            setBackgroundResource(R.drawable.ksad_splash_logo_bg);
        }
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f60331b.setImageDrawable(getContext().getResources().getDrawable(this.f60332c ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
    }

    private void a(Context context) {
        TextView textView;
        int i2;
        LinearLayout.inflate(context, R.layout.ksad_logo_layout, this);
        this.a = (TextView) findViewById(R.id.ksad_logo_text);
        this.f60331b = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.f60332c = z;
        if (z) {
            this.f60331b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_gray));
            textView = this.a;
            i2 = -6513508;
        } else {
            this.f60331b.setImageDrawable(context.getResources().getDrawable(R.drawable.ksad_logo_white));
            textView = this.a;
            i2 = -1711276033;
        }
        textView.setTextColor(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r7 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
        r7.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
        if (r7 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(AdTemplate adTemplate) {
        a aVar;
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        String str = this.f60332c ? j2.adBaseInfo.adGrayMarkIcon : j2.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(j2.adBaseInfo.adSourceDescription)) {
            this.a.setVisibility(0);
            this.a.setText(com.kwad.sdk.core.response.a.a.z(j2));
            this.f60331b.setVisibility(0);
            a();
            aVar = this.f60334e;
        } else {
            if (TextUtils.isEmpty(j2.adBaseInfo.adSourceDescription)) {
                this.a.setVisibility(8);
                this.a.setText("");
            } else {
                this.a.setText(com.kwad.sdk.core.response.a.a.z(j2));
                this.a.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.f60331b.setVisibility(8);
                this.f60331b.setImageDrawable(null);
                aVar = this.f60334e;
            } else {
                KSImageLoader.loadFeeImage(this.f60331b, str, adTemplate, this.f60333d);
                this.f60331b.setVisibility(0);
            }
        }
        findViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.f60331b;
    }

    public TextView getTextView() {
        return this.a;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.f60334e = aVar;
    }
}
