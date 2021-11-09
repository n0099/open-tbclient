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
import b.g.a0.d.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.channel.ks.R;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.module.ks.w;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class KSNativeAdVideoAppDownloadView extends w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62807b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f62808c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f62809d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f62810e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62811f;

    /* renamed from: g  reason: collision with root package name */
    public Button f62812g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdVideoAppDownloadView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSNativeAdVideoAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
    }

    @Override // com.fun.module.ks.w
    public void a(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksNativeAd) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            arrayList.add(this.f62812g);
            this.f62883a.clear();
            this.f62883a.addAll(arrayList);
            View videoView = ksNativeAd.getVideoView(getContext(), new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
            LogPrinter.e("KSNativeAd video videoView: " + videoView, new Object[0]);
            if (videoView != null && videoView.getParent() != null) {
                ((ViewGroup) videoView.getParent()).removeView(videoView);
            }
            if (videoView != null) {
                this.f62808c.removeAllViews();
                this.f62808c.addView(videoView);
            }
            this.f62809d.setImageBitmap(getSdkLogo());
            this.f62807b.setText(ksNativeAd.getAdDescription());
            if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
                this.f62810e.setVisibility(8);
            } else {
                this.f62810e.setVisibility(0);
                GlideHelper.get().load(getContext(), ksNativeAd.getAppIconUrl(), this.f62810e);
            }
            this.f62811f.setText(ksNativeAd.getAppName());
            this.f62812g.setText(ksNativeAd.getActionDescription());
            ksNativeAd.setDownloadListener(new x(ksNativeAd.getActionDescription(), this.f62812g));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f62807b = (TextView) findViewById(R.id.ad_description);
            this.f62808c = (FrameLayout) findViewById(R.id.ad_video);
            this.f62809d = (ImageView) findViewById(R.id.ad_logo);
            this.f62810e = (ImageView) findViewById(R.id.ad_app_icon);
            this.f62811f = (TextView) findViewById(R.id.ad_app_title);
            this.f62812g = (Button) findViewById(R.id.ad_app_download);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62808c.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = i6;
            layoutParams.height = (int) (i6 / 1.78f);
            this.f62808c.setLayoutParams(layoutParams);
        }
    }
}
