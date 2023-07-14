package com.kwad.components.core.widget;

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
/* loaded from: classes10.dex */
public class KsLogoView extends LinearLayout {
    public SimpleImageLoadingListener PA;
    public a PB;
    public boolean Px;
    public TextView Py;
    public ImageView Pz;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public KsLogoView(Context context) {
        super(context);
        this.PA = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.PB != null) {
                    a unused = KsLogoView.this.PB;
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.qg();
                if (KsLogoView.this.PB != null) {
                    a unused = KsLogoView.this.PB;
                }
            }
        };
        init(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PA = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.PB != null) {
                    a unused = KsLogoView.this.PB;
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.qg();
                if (KsLogoView.this.PB != null) {
                    a unused = KsLogoView.this.PB;
                }
            }
        };
        init(context);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PA = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.PB != null) {
                    a unused = KsLogoView.this.PB;
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.qg();
                if (KsLogoView.this.PB != null) {
                    a unused = KsLogoView.this.PB;
                }
            }
        };
        init(context);
    }

    public KsLogoView(Context context, boolean z) {
        super(context);
        this.PA = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.PB != null) {
                    a unused = KsLogoView.this.PB;
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.qg();
                if (KsLogoView.this.PB != null) {
                    a unused = KsLogoView.this.PB;
                }
            }
        };
        if (z) {
            setBackgroundResource(R.drawable.obfuscated_res_0x7f080e9b);
        }
        init(context);
    }

    private void init(Context context) {
        TextView textView;
        int i;
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04b2, this);
        this.Py = (TextView) findViewById(R.id.obfuscated_res_0x7f0912f7);
        this.Pz = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912f6);
        boolean z = getBackground() == null;
        this.Px = z;
        if (z) {
            this.Pz.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e52));
            textView = this.Py;
            i = -6513508;
        } else {
            this.Pz.setImageDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e53));
            textView = this.Py;
            i = -1711276033;
        }
        textView.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        this.Pz.setImageDrawable(getContext().getResources().getDrawable(this.Px ? R.drawable.obfuscated_res_0x7f080e52 : R.drawable.obfuscated_res_0x7f080e53));
    }

    public final void T(AdTemplate adTemplate) {
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0912f5);
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        String str = this.Px ? bQ.adBaseInfo.adGrayMarkIcon : bQ.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(bQ.adBaseInfo.adSourceDescription)) {
            this.Py.setVisibility(0);
            this.Py.setText(com.kwad.sdk.core.response.a.a.ak(bQ));
            this.Pz.setVisibility(0);
            qg();
            a aVar = this.PB;
        } else {
            if (TextUtils.isEmpty(bQ.adBaseInfo.adSourceDescription)) {
                this.Py.setVisibility(8);
                this.Py.setText("");
            } else {
                this.Py.setText(com.kwad.sdk.core.response.a.a.ak(bQ));
                this.Py.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.Pz.setVisibility(8);
                this.Pz.setImageDrawable(null);
            } else {
                KSImageLoader.loadFeeImage(this.Pz, str, adTemplate, this.PA);
                this.Pz.setVisibility(0);
            }
        }
        findViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.Pz;
    }

    public TextView getTextView() {
        return this.Py;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.PB = aVar;
    }
}
