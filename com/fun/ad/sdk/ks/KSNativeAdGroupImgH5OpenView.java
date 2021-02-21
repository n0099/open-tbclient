package com.fun.ad.sdk.ks;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fun.ad.ai;
import com.fun.ad.ap;
import com.fun.ad.o1;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class KSNativeAdGroupImgH5OpenView extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public TextView f7829a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f7830b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public TextView f;
    public Button g;

    public KSNativeAdGroupImgH5OpenView(Context context) {
        this(context, null);
    }

    public KSNativeAdGroupImgH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdGroupImgH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.fun.ad.o1
    public void a(Activity activity, String str, String str2, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        List<KsImage> imageList = ksNativeAd.getImageList();
        if (imageList != null && imageList.size() >= 3) {
            KsImage ksImage = imageList.get(0);
            if (ksImage != null && ksImage.isValid()) {
                ap.a.pPQ.a(getContext(), ksImage.getImageUrl(), this.c);
            }
            KsImage ksImage2 = imageList.get(1);
            if (ksImage2 != null && ksImage2.isValid()) {
                ap.a.pPQ.a(getContext(), ksImage2.getImageUrl(), this.d);
            }
            KsImage ksImage3 = imageList.get(2);
            if (ksImage3 != null && ksImage3.isValid()) {
                ap.a.pPQ.a(getContext(), ksImage3.getImageUrl(), this.e);
            }
        }
        this.f7829a.setText(ksNativeAd.getAdDescription());
        this.f.setText(ksNativeAd.getAdSource());
        this.g.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new ai(ksNativeAd, this.g, str, FunAdType.KS_NATIVE, str2));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f7829a = (TextView) findViewById(R.id.ad_description);
        this.f7830b = (LinearLayout) findViewById(R.id.ad_img_container);
        this.c = (ImageView) findViewById(R.id.ad_img_1);
        this.d = (ImageView) findViewById(R.id.ad_img_2);
        this.e = (ImageView) findViewById(R.id.ad_img_3);
        ImageView imageView = (ImageView) findViewById(R.id.ad_logo);
        this.f = (TextView) findViewById(R.id.ad_h5_description);
        this.g = (Button) findViewById(R.id.ad_h5_open);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7830b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = (int) (((((((i5 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.5f);
        this.f7830b.setLayoutParams(layoutParams);
    }
}
