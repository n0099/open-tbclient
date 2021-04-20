package com.fun.ad.sdk.channel.model.gdt;

import a.a.a.a.r.b.b.b;
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
public class GDTNativeUnifiedImg2View extends b {

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30441d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f30442e;

    /* renamed from: f  reason: collision with root package name */
    public float f30443f;

    public GDTNativeUnifiedImg2View(Context context) {
        this(context, null);
    }

    public GDTNativeUnifiedImg2View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GDTNativeUnifiedImg2View(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30443f = 1.78f;
    }

    @Override // a.a.a.a.r.b.b.b
    public List<View> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1278c);
        arrayList.add(((b) this).f1277b);
        arrayList.add(((b) this).f1276a);
        arrayList.add(this.f30442e);
        arrayList.add(this.f30441d);
        return arrayList;
    }

    @Override // a.a.a.a.r.b.b.b
    public void a(Activity activity, NativeUnifiedADData nativeUnifiedADData) {
        super.a(activity, nativeUnifiedADData);
        Context context = getContext();
        String iconUrl = nativeUnifiedADData.getIconUrl();
        ImageView imageView = this.f30441d;
        if (context == null) {
            d.b("GlideHelper: context is null when load: " + iconUrl, new Object[0]);
        } else if (context instanceof Activity) {
            Activity activity2 = (Activity) context;
            if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                d.b("GlideHelper: activity is destroyed when load: " + iconUrl, new Object[0]);
            } else {
                Glide.with(activity2).load(iconUrl).into(imageView);
            }
        } else {
            Glide.with(context).load(iconUrl).into(imageView);
        }
        d.b("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight(), new Object[0]);
        this.f30443f = (((float) nativeUnifiedADData.getPictureWidth()) * 1.0f) / (((float) nativeUnifiedADData.getPictureHeight()) * 1.0f);
        Context context2 = getContext();
        String imgUrl = nativeUnifiedADData.getImgUrl();
        ImageView imageView2 = this.f30442e;
        if (context2 == null) {
            d.b("GlideHelper: context is null when load: " + imgUrl, new Object[0]);
        } else if (context2 instanceof Activity) {
            Activity activity3 = (Activity) context2;
            if (!activity3.isFinishing() && (Build.VERSION.SDK_INT <= 17 || !activity3.isDestroyed())) {
                Glide.with(activity3).load(imgUrl).into(imageView2);
                return;
            }
            d.b("GlideHelper: activity is destroyed when load: " + imgUrl, new Object[0]);
        } else {
            Glide.with(context2).load(imgUrl).into(imageView2);
        }
    }

    @Override // a.a.a.a.r.b.b.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30441d = (ImageView) findViewById(R.id.ad_icon);
        this.f30442e = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30442e.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.f30443f);
        this.f30442e.setLayoutParams(layoutParams);
    }
}
