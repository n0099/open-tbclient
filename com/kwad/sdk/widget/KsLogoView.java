package com.kwad.sdk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class KsLogoView extends LinearLayout {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f41482b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41483c;

    /* renamed from: d  reason: collision with root package name */
    public SimpleImageLoadingListener f41484d;

    /* renamed from: e  reason: collision with root package name */
    public a f41485e;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public KsLogoView(Context context) {
        super(context);
        this.f41484d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.f41485e != null) {
                    KsLogoView.this.f41485e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.f41485e != null) {
                    KsLogoView.this.f41485e.a();
                }
            }
        };
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41484d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.f41485e != null) {
                    KsLogoView.this.f41485e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.f41485e != null) {
                    KsLogoView.this.f41485e.a();
                }
            }
        };
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41484d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.f41485e != null) {
                    KsLogoView.this.f41485e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.f41485e != null) {
                    KsLogoView.this.f41485e.a();
                }
            }
        };
        a(context);
    }

    public KsLogoView(Context context, boolean z) {
        super(context);
        this.f41484d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.f41485e != null) {
                    KsLogoView.this.f41485e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.f41485e != null) {
                    KsLogoView.this.f41485e.a();
                }
            }
        };
        if (z) {
            setBackgroundResource(R.drawable.obfuscated_res_0x7f080ca7);
        }
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f41482b.setImageDrawable(getContext().getResources().getDrawable(this.f41483c ? R.drawable.obfuscated_res_0x7f080bcc : R.drawable.obfuscated_res_0x7f080bcd));
    }

    private void a(Context context) {
        TextView textView;
        int i;
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0452, this);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0910b7);
        this.f41482b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910b6);
        boolean z = getBackground() == null;
        this.f41483c = z;
        if (z) {
            this.f41482b.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bcc));
            textView = this.a;
            i = -6513508;
        } else {
            this.f41482b.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bcd));
            textView = this.a;
            i = -1711276033;
        }
        textView.setTextColor(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (r7 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
        r7.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008e, code lost:
        if (r7 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(AdTemplate adTemplate) {
        a aVar;
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0910b5);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        String str = this.f41483c ? j.adBaseInfo.adGrayMarkIcon : j.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
            this.a.setVisibility(0);
            this.a.setText(com.kwad.sdk.core.response.a.a.z(j));
            this.f41482b.setVisibility(0);
            a();
            aVar = this.f41485e;
        } else {
            if (TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
                this.a.setVisibility(8);
                this.a.setText("");
            } else {
                this.a.setText(com.kwad.sdk.core.response.a.a.z(j));
                this.a.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.f41482b.setVisibility(8);
                this.f41482b.setImageDrawable(null);
                aVar = this.f41485e;
            } else {
                KSImageLoader.loadFeeImage(this.f41482b, str, adTemplate, this.f41484d);
                this.f41482b.setVisibility(0);
            }
        }
        findViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.f41482b;
    }

    public TextView getTextView() {
        return this.a;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.f41485e = aVar;
    }
}
