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
/* loaded from: classes5.dex */
public class KsLogoView extends LinearLayout {
    public TextView a;
    public ImageView b;
    public boolean c;
    public SimpleImageLoadingListener d;
    public a e;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public KsLogoView(Context context) {
        super(context);
        this.d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.e != null) {
                    KsLogoView.this.e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.e != null) {
                    KsLogoView.this.e.a();
                }
            }
        };
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.e != null) {
                    KsLogoView.this.e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.e != null) {
                    KsLogoView.this.e.a();
                }
            }
        };
        a(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.e != null) {
                    KsLogoView.this.e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.e != null) {
                    KsLogoView.this.e.a();
                }
            }
        };
        a(context);
    }

    public KsLogoView(Context context, boolean z) {
        super(context);
        this.d = new SimpleImageLoadingListener() { // from class: com.kwad.sdk.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.e != null) {
                    KsLogoView.this.e.a();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.a();
                if (KsLogoView.this.e != null) {
                    KsLogoView.this.e.a();
                }
            }
        };
        if (z) {
            setBackgroundResource(R.drawable.obfuscated_res_0x7f080cac);
        }
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b.setImageDrawable(getContext().getResources().getDrawable(this.c ? R.drawable.obfuscated_res_0x7f080bd1 : R.drawable.obfuscated_res_0x7f080bd2));
    }

    private void a(Context context) {
        TextView textView;
        int i;
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d044d, this);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0910b1);
        this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910b0);
        boolean z = getBackground() == null;
        this.c = z;
        if (z) {
            this.b.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bd1));
            textView = this.a;
            i = -6513508;
        } else {
            this.b.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bd2));
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
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0910af);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        String str = this.c ? j.adBaseInfo.adGrayMarkIcon : j.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
            this.a.setVisibility(0);
            this.a.setText(com.kwad.sdk.core.response.a.a.z(j));
            this.b.setVisibility(0);
            a();
            aVar = this.e;
        } else {
            if (TextUtils.isEmpty(j.adBaseInfo.adSourceDescription)) {
                this.a.setVisibility(8);
                this.a.setText("");
            } else {
                this.a.setText(com.kwad.sdk.core.response.a.a.z(j));
                this.a.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.b.setVisibility(8);
                this.b.setImageDrawable(null);
                aVar = this.e;
            } else {
                KSImageLoader.loadFeeImage(this.b, str, adTemplate, this.d);
                this.b.setVisibility(0);
            }
        }
        findViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.b;
    }

    public TextView getTextView() {
        return this.a;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.e = aVar;
    }
}
