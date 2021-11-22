package com.fun.ad.sdk.channel.model.jy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.channel.jy.R;
import com.win.opensdk.PBMediaView;
/* loaded from: classes11.dex */
public final class JYNativeAdView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f63671a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f63672b;

    /* renamed from: c  reason: collision with root package name */
    public View f63673c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63674d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f63675e;

    /* renamed from: f  reason: collision with root package name */
    public Button f63676f;

    /* renamed from: g  reason: collision with root package name */
    public float f63677g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JYNativeAdView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63677g = 1.78f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JYNativeAdView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63677g = 1.78f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JYNativeAdView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f63677g = 1.78f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onFinishInflate();
            this.f63671a = (TextView) findViewById(R.id.ad_description);
            this.f63672b = (FrameLayout) findViewById(R.id.ad_img_container);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            PBMediaView pBMediaView = new PBMediaView(getContext());
            this.f63673c = pBMediaView;
            this.f63672b.addView(pBMediaView, layoutParams);
            this.f63674d = (TextView) findViewById(R.id.ad_title);
            this.f63675e = (ImageView) findViewById(R.id.ad_icon);
            this.f63676f = (Button) findViewById(R.id.ad_creative);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f63672b.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = i6;
            layoutParams.height = (int) (i6 / this.f63677g);
            this.f63672b.setLayoutParams(layoutParams);
        }
    }
}
