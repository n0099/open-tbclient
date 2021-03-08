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
public class GDTNativeUnifiedImg3View extends b {
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
        Context context = getContext();
        String str = nativeUnifiedADData.getImgList().get(0);
        ImageView imageView = this.e;
        if (context == null) {
            d.b("GlideHelper: context is null when load: " + str, new Object[0]);
        } else if (context instanceof Activity) {
            Activity activity2 = (Activity) context;
            if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                d.b("GlideHelper: activity is destroyed when load: " + str, new Object[0]);
            } else {
                Glide.with(activity2).load(str).into(imageView);
            }
        } else {
            Glide.with(context).load(str).into(imageView);
        }
        Context context2 = getContext();
        String str2 = nativeUnifiedADData.getImgList().get(1);
        ImageView imageView2 = this.f;
        if (context2 == null) {
            d.b("GlideHelper: context is null when load: " + str2, new Object[0]);
        } else if (context2 instanceof Activity) {
            Activity activity3 = (Activity) context2;
            if (activity3.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity3.isDestroyed())) {
                d.b("GlideHelper: activity is destroyed when load: " + str2, new Object[0]);
            } else {
                Glide.with(activity3).load(str2).into(imageView2);
            }
        } else {
            Glide.with(context2).load(str2).into(imageView2);
        }
        Context context3 = getContext();
        String str3 = nativeUnifiedADData.getImgList().get(2);
        ImageView imageView3 = this.g;
        if (context3 == null) {
            d.b("GlideHelper: context is null when load: " + str3, new Object[0]);
        } else if (context3 instanceof Activity) {
            Activity activity4 = (Activity) context3;
            if (activity4.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity4.isDestroyed())) {
                d.b("GlideHelper: activity is destroyed when load: " + str3, new Object[0]);
            } else {
                Glide.with(activity4).load(str3).into(imageView3);
            }
        } else {
            Glide.with(context3).load(str3).into(imageView3);
        }
    }

    @Override // a.a.a.a.r.b.c.b, android.view.View
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
