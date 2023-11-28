package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextPaint;
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
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class KsLogoView extends LinearLayout {
    public boolean abY;
    public TextView abZ;
    public ImageView aca;
    public a acb;
    public SimpleImageLoadingListener ez;

    /* loaded from: classes10.dex */
    public interface a {
        void ka();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.acb = aVar;
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(l.wrapContextIfNeed(context), attributeSet, i);
        this.ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.acb != null) {
                    KsLogoView.this.acb.ka();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.ti();
                if (KsLogoView.this.acb != null) {
                    KsLogoView.this.acb.ka();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z) {
        super(l.wrapContextIfNeed(context));
        this.ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view2, DecodedResult decodedResult) {
                if (KsLogoView.this.acb != null) {
                    KsLogoView.this.acb.ka();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view2, FailReason failReason) {
                KsLogoView.this.ti();
                if (KsLogoView.this.acb != null) {
                    KsLogoView.this.acb.ka();
                }
            }
        };
        if (z) {
            setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080efa));
        }
        init();
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        int i;
        int i2;
        TextView textView = ksLogoView.getTextView();
        TextPaint paint = textView.getPaint();
        if (ksLogoView.getVisibility() == 0 && textView.getText() != null && textView.getText().length() > 0) {
            i = ((int) Math.ceil(paint.measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight();
        } else {
            i = 0;
        }
        if (ksLogoView.getIcon().getVisibility() == 0) {
            i2 = com.kwad.sdk.d.a.a.a(ksLogoView.getContext(), 18.0f);
        } else {
            i2 = 0;
        }
        int i3 = i + i2;
        int a2 = com.kwad.sdk.d.a.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(i3, a2);
        ksLogoView.layout(0, 0, i3, a2);
        Bitmap createBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return createBitmap;
    }

    private void init() {
        boolean z;
        l.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04ed, this);
        this.abZ = (TextView) findViewById(R.id.obfuscated_res_0x7f0913d4);
        this.aca = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913d3);
        if (getBackground() == null) {
            z = true;
        } else {
            z = false;
        }
        this.abY = z;
        if (z) {
            this.aca.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ea5));
            this.abZ.setTextColor(-6513508);
            return;
        }
        this.aca.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ea6));
        this.abZ.setTextColor(-1711276033);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti() {
        int i;
        Resources resources = getContext().getResources();
        if (this.abY) {
            i = R.drawable.obfuscated_res_0x7f080ea5;
        } else {
            i = R.drawable.obfuscated_res_0x7f080ea6;
        }
        this.aca.setImageDrawable(resources.getDrawable(i));
    }

    public ImageView getIcon() {
        return this.aca;
    }

    public TextView getTextView() {
        return this.abZ;
    }

    public final void aD(AdTemplate adTemplate) {
        String str;
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0913d2);
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if (this.abY) {
            str = dP.adBaseInfo.adGrayMarkIcon;
        } else {
            str = dP.adBaseInfo.adMarkIcon;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(dP.adBaseInfo.adSourceDescription)) {
            this.abZ.setVisibility(0);
            this.abZ.setText(com.kwad.sdk.core.response.b.a.aD(dP));
            this.aca.setVisibility(0);
            ti();
            a aVar = this.acb;
            if (aVar != null) {
                aVar.ka();
            }
        } else {
            if (!TextUtils.isEmpty(dP.adBaseInfo.adSourceDescription)) {
                this.abZ.setText(com.kwad.sdk.core.response.b.a.aD(dP));
                this.abZ.setVisibility(0);
            } else {
                this.abZ.setVisibility(8);
                this.abZ.setText("");
            }
            if (!TextUtils.isEmpty(str)) {
                KSImageLoader.loadFeeImage(this.aca, str, adTemplate, this.ez);
                this.aca.setVisibility(0);
            } else {
                this.aca.setVisibility(8);
                this.aca.setImageDrawable(null);
                a aVar2 = this.acb;
                if (aVar2 != null) {
                    aVar2.ka();
                }
            }
        }
        findViewById.setVisibility(0);
    }
}
