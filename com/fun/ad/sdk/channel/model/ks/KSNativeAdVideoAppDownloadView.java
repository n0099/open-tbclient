package com.fun.ad.sdk.channel.model.ks;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.d.a0.d.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.module.ks.x;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class KSNativeAdVideoAppDownloadView extends x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f38582b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f38583c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f38584d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38585e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f38586f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38587g;

    /* renamed from: h  reason: collision with root package name */
    public Button f38588h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdVideoAppDownloadView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdVideoAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSNativeAdVideoAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.module.ks.x
    public void a(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksNativeAd) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            arrayList.add(this.f38588h);
            this.a.clear();
            this.a.addAll(arrayList);
            View videoView = ksNativeAd.getVideoView(getContext(), new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
            LogPrinter.e("KSNativeAd video videoView: " + videoView, new Object[0]);
            if (videoView != null && videoView.getParent() != null) {
                ((ViewGroup) videoView.getParent()).removeView(videoView);
            }
            if (videoView != null) {
                this.f38583c.removeAllViews();
                this.f38583c.addView(videoView);
            }
            this.f38584d.setImageBitmap(getSdkLogo());
            String adSource = ksNativeAd.getAdSource();
            if (TextUtils.isEmpty(adSource)) {
                adSource = "快手广告";
            }
            this.f38585e.setText(adSource);
            this.f38582b.setText(ksNativeAd.getAdDescription());
            if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
                this.f38586f.setVisibility(8);
            } else {
                this.f38586f.setVisibility(0);
                GlideHelper.get().load(getContext(), ksNativeAd.getAppIconUrl(), this.f38586f);
            }
            this.f38587g.setText(ksNativeAd.getAppName());
            this.f38588h.setText(ksNativeAd.getActionDescription());
            ksNativeAd.setDownloadListener(new y(ksNativeAd.getActionDescription(), this.f38588h));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f38582b = (TextView) findViewById(R.id.obfuscated_res_0x7f09009d);
            this.f38583c = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900f8);
            this.f38584d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900d1);
            this.f38585e = (TextView) findViewById(R.id.obfuscated_res_0x7f090085);
            this.f38586f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090083);
            this.f38587g = (TextView) findViewById(R.id.obfuscated_res_0x7f090086);
            this.f38588h = (Button) findViewById(R.id.obfuscated_res_0x7f090082);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f38583c.getLayoutParams();
            int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = i5;
            layoutParams.height = (int) (i5 / 1.78f);
            this.f38583c.setLayoutParams(layoutParams);
        }
    }
}
