package com.fun.ad.sdk.gdt;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.fun.ad.ah;
import com.fun.ad.ap;
import com.fun.ad.au;
import com.fun.ad.m;
import com.fun.ad.sdk.R;
import com.fun.ad.v0;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class GDTNativeUnifiedImg3View extends v0 {
    public LinearLayout d;
    public ImageView e;
    public ImageView f;
    public ImageView g;

    public GDTNativeUnifiedImg3View(Context context) {
        this(context, null);
    }

    public GDTNativeUnifiedImg3View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GDTNativeUnifiedImg3View(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.fun.ad.v0
    public List<View> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.c);
        arrayList.add(this.d);
        return arrayList;
    }

    @Override // com.fun.ad.v0
    public void a(Activity activity, au.a aVar, NativeUnifiedADData nativeUnifiedADData, ah ahVar) {
        super.a(activity, aVar, nativeUnifiedADData, ahVar);
        m.a("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight());
        ap.a.pId.a(getContext(), nativeUnifiedADData.getImgList().get(0), this.e);
        ap.a.pId.a(getContext(), nativeUnifiedADData.getImgList().get(1), this.f);
        ap.a.pId.a(getContext(), nativeUnifiedADData.getImgList().get(2), this.g);
    }

    @Override // com.fun.ad.v0, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = (LinearLayout) findViewById(R.id.ad_img_container);
        this.e = (ImageView) findViewById(R.id.ad_img_1);
        this.f = (ImageView) findViewById(R.id.ad_img_2);
        this.g = (ImageView) findViewById(R.id.ad_img_3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = (int) (((((((i5 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.52f);
        this.d.setLayoutParams(layoutParams);
    }
}
