package com.fun.ad.sdk.channel.model.gdt;

import a.a.a.a.t.b.b.b;
import a.a.a.a.x.d;
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
    public ImageView f30721d;

    /* renamed from: e  reason: collision with root package name */
    public float f30722e;

    public GDTNativeUnifiedImgView(Context context) {
        this(context, null);
    }

    public GDTNativeUnifiedImgView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GDTNativeUnifiedImgView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30722e = 1.78f;
    }

    @Override // a.a.a.a.t.b.b.b
    public List<View> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1296c);
        arrayList.add(((b) this).f1295b);
        arrayList.add(((b) this).f1294a);
        arrayList.add(this.f30721d);
        return arrayList;
    }

    @Override // a.a.a.a.t.b.b.b
    public void a(Activity activity, NativeUnifiedADData nativeUnifiedADData) {
        super.a(activity, nativeUnifiedADData);
        d.b("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight(), new Object[0]);
        this.f30722e = (((float) nativeUnifiedADData.getPictureWidth()) * 1.0f) / (((float) nativeUnifiedADData.getPictureHeight()) * 1.0f);
        Context context = getContext();
        String imgUrl = nativeUnifiedADData.getImgUrl();
        ImageView imageView = this.f30721d;
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

    @Override // a.a.a.a.t.b.b.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30721d = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30721d.getLayoutParams();
        int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i6;
        layoutParams.height = (int) (i6 / this.f30722e);
        this.f30721d.setLayoutParams(layoutParams);
    }
}
