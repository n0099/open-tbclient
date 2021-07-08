package com.kwad.sdk.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import com.kwad.sdk.feed.widget.base.a;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes6.dex */
public class FeedDownloadActivityProxy extends com.kwad.sdk.c.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    public static final String TAG = "FeedDownloadActivity";
    public static a.InterfaceC0436a mAdClickListener;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdContainer mAdContainer;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.download.b.b mApkDownloadHelper;
    public TailFrameBarAppPortraitVertical mAppTailFrameView;
    public Activity mContext;
    public TextProgressBar mProgressBarTv;

    public FeedDownloadActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void bindDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.mApkDownloadHelper = new com.kwad.sdk.core.download.b.b(this.mAdTemplate, null, new c(this) { // from class: com.kwad.sdk.feed.FeedDownloadActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FeedDownloadActivityProxy f35556b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35556b = this;
                }

                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.f35556b.mAppTailFrameView.a(this.f35556b.mAdInfo);
                        this.f35556b.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f35556b.mAppTailFrameView.a(this.f35556b.mAdInfo);
                        this.f35556b.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.u(this.f35556b.mAdInfo), this.f35556b.mProgressBarTv.getMax());
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f35556b.mAppTailFrameView.a(this.f35556b.mAdInfo);
                        this.f35556b.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.a(this.f35556b.mAdTemplate), this.f35556b.mProgressBarTv.getMax());
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f35556b.mAppTailFrameView.a(this.f35556b.mAdInfo);
                        this.f35556b.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.u(this.f35556b.mAdInfo), this.f35556b.mProgressBarTv.getMax());
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.f35556b.mAppTailFrameView.a(this.f35556b.mAdInfo);
                        this.f35556b.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.j(this.f35556b.mAdInfo), this.f35556b.mProgressBarTv.getMax());
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                        this.f35556b.mAppTailFrameView.a(this.f35556b.mAdInfo);
                        this.f35556b.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    }
                }
            });
        }
    }

    private boolean initData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            try {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra));
                this.mAdTemplate = adTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            AdTemplate adTemplate2 = this.mAdTemplate;
            if (adTemplate2 == null) {
                this.mContext.finish();
                return false;
            }
            this.mAdInfo = com.kwad.sdk.core.response.b.c.i(adTemplate2);
            return true;
        }
        return invokeV.booleanValue;
    }

    private void intiView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            KsAdContainer ksAdContainer = (KsAdContainer) this.mContext.findViewById(R.id.ksad_container);
            this.mAdContainer = ksAdContainer;
            ksAdContainer.setOnClickListener(this);
            TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) this.mContext.findViewById(R.id.ksad_download_container);
            this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
            tailFrameBarAppPortraitVertical.a(this.mAdTemplate);
            this.mAppTailFrameView.a(com.kwad.sdk.core.response.b.c.i(this.mAdTemplate));
            this.mAppTailFrameView.setVisibility(0);
            TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
            this.mProgressBarTv = textProgressBar;
            textProgressBar.setOnClickListener(this);
            bindDownloadListener();
        }
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, a.InterfaceC0436a interfaceC0436a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, adTemplate, interfaceC0436a) == null) {
            KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
            Intent intent = new Intent(context, FeedDownloadActivity.class);
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
            mAdClickListener = interfaceC0436a;
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, this.mAdContainer.getTouchCoords());
            a.InterfaceC0436a interfaceC0436a = mAdClickListener;
            if (interfaceC0436a != null) {
                interfaceC0436a.a();
            }
        }
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tailFrameBarAppPortraitVertical = this.mAppTailFrameView) == null) {
            return;
        }
        tailFrameBarAppPortraitVertical.a();
        this.mAppTailFrameView.setVisibility(8);
    }

    @Override // com.kwad.sdk.c.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FeedDownloadActivityProxy" : (String) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.mAdTemplate, new a.InterfaceC0413a(this) { // from class: com.kwad.sdk.feed.FeedDownloadActivityProxy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ FeedDownloadActivityProxy f35557a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35557a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0413a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35557a.notifyAdClick();
                    }
                }
            }, this.mApkDownloadHelper, view == this.mProgressBarTv);
        }
    }

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = getActivity();
            if (!initData()) {
                this.mContext.finish();
                return;
            }
            setContentView(R.layout.ksad_activity_feed_download);
            intiView();
        }
    }
}
