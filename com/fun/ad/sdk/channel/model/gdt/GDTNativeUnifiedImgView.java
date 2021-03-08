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
/* loaded from: classes4.dex */
public class GDTNativeUnifiedImgView extends b {
    public ImageView d;
    public float e;

    public GDTNativeUnifiedImgView(Context context) {
        this(context, null);
    }

    public GDTNativeUnifiedImgView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GDTNativeUnifiedImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 1.78f;
    }

    @Override // a.a.a.a.r.b.c.b
    public List<View> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.c);
        arrayList.add(((b) this).b);
        arrayList.add(((b) this).f1003a);
        arrayList.add(this.d);
        return arrayList;
    }

    @Override // a.a.a.a.r.b.c.b
    public void a(Activity activity, NativeUnifiedADData nativeUnifiedADData) {
        super.a(activity, nativeUnifiedADData);
        d.b("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight(), new Object[0]);
        this.e = (nativeUnifiedADData.getPictureWidth() * 1.0f) / (nativeUnifiedADData.getPictureHeight() * 1.0f);
        Context context = getContext();
        String imgUrl = nativeUnifiedADData.getImgUrl();
        ImageView imageView = this.d;
        if (context == null) {
            d.b("GlideHelper: context is null when load: " + imgUrl, new Object[0]);
        } else if (context instanceof Activity) {
            Activity activity2 = (Activity) context;
            if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                d.b("GlideHelper: activity is destroyed when load: " + imgUrl, new Object[0]);
            } else {
                Glide.with(activity2).load(imgUrl).into(imageView);
            }
        } else {
            Glide.with(context).load(imgUrl).into(imageView);
        }
    }

    @Override // a.a.a.a.r.b.c.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.e);
        this.d.setLayoutParams(layoutParams);
    }
}
