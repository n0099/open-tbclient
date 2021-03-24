package com.fun.ad.sdk.channel.model.gdt;

import a.a.a.a.r.b.c.b;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.R;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class GDTNativeUnifiedImgView extends b {

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30774d;

    /* renamed from: e  reason: collision with root package name */
    public float f30775e;

    public GDTNativeUnifiedImgView(Context context) {
        this(context, null);
    }

    public GDTNativeUnifiedImgView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GDTNativeUnifiedImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30775e = 1.78f;
    }

    @Override // a.a.a.a.r.b.c.b
    public List<View> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1292c);
        arrayList.add(((b) this).f1291b);
        arrayList.add(((b) this).f1290a);
        arrayList.add(this.f30774d);
        return arrayList;
    }

    @Override // a.a.a.a.r.b.c.b
    public void a(Activity activity, NativeUnifiedADData nativeUnifiedADData) {
        super.a(activity, nativeUnifiedADData);
        d.b("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight(), new Object[0]);
        this.f30775e = (((float) nativeUnifiedADData.getPictureWidth()) * 1.0f) / (((float) nativeUnifiedADData.getPictureHeight()) * 1.0f);
        Context context = getContext();
        String imgUrl = nativeUnifiedADData.getImgUrl();
        ImageView imageView = this.f30774d;
        if (context == null) {
            d.b("GlideHelper: context is null when load: " + imgUrl, new Object[0]);
        } else if (context instanceof Activity) {
            Activity activity2 = (Activity) context;
            if (!activity2.isFinishing() && (Build.VERSION.SDK_INT <= 17 || !activity2.isDestroyed())) {
                Glide.with(activity2).load(imgUrl).into(imageView);
                return;
            }
            d.b("GlideHelper: activity is destroyed when load: " + imgUrl, new Object[0]);
        } else {
            Glide.with(context).load(imgUrl).into(imageView);
        }
    }

    @Override // a.a.a.a.r.b.c.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30774d = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30774d.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.f30775e);
        this.f30774d.setLayoutParams(layoutParams);
    }
}
