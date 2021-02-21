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
/* loaded from: classes6.dex */
public class GDTNativeUnifiedImg2View extends v0 {
    public ImageView d;
    public ImageView e;
    public float f;

    public GDTNativeUnifiedImg2View(Context context) {
        this(context, null);
    }

    public GDTNativeUnifiedImg2View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GDTNativeUnifiedImg2View(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 1.78f;
    }

    @Override // com.fun.ad.v0
    public List<View> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.c);
        arrayList.add(this.e);
        arrayList.add(this.d);
        return arrayList;
    }

    @Override // com.fun.ad.v0
    public void a(Activity activity, au.a aVar, NativeUnifiedADData nativeUnifiedADData, ah ahVar) {
        super.a(activity, aVar, nativeUnifiedADData, ahVar);
        ap.a.pPQ.a(getContext(), nativeUnifiedADData.getIconUrl(), this.d);
        m.a("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight());
        this.f = (nativeUnifiedADData.getPictureWidth() * 1.0f) / (nativeUnifiedADData.getPictureHeight() * 1.0f);
        ap.a.pPQ.a(getContext(), nativeUnifiedADData.getImgUrl(), this.e);
    }

    @Override // com.fun.ad.v0, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = (ImageView) findViewById(R.id.ad_icon);
        this.e = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.f);
        this.e.setLayoutParams(layoutParams);
    }
}
