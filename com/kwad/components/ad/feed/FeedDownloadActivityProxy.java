package com.kwad.components.ad.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.b;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes5.dex */
public class FeedDownloadActivityProxy extends com.kwad.components.core.i.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    public static final String TAG = "FeedDownloadActivity";
    public static b.InterfaceC0376b sInnerAdInteractionListener;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdContainer mAdContainer;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public TailFrameBarAppPortraitVertical mAppTailFrameView;
    public Activity mContext;
    public TextProgressBar mProgressBarTv;

    public FeedDownloadActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void bindDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate, null, new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FeedDownloadActivityProxy cH;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.cH = this;
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.cH.mAppTailFrameView.u(this.cH.mAdInfo);
                        this.cH.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.al(this.cH.mAdInfo), this.cH.mProgressBarTv.getMax());
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.cH.mAppTailFrameView.u(this.cH.mAdInfo);
                        this.cH.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aJ(this.cH.mAdTemplate), this.cH.mProgressBarTv.getMax());
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.cH.mAppTailFrameView.u(this.cH.mAdInfo);
                        this.cH.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.al(this.cH.mAdInfo), this.cH.mProgressBarTv.getMax());
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.cH.mAppTailFrameView.u(this.cH.mAdInfo);
                        this.cH.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.P(this.cH.mAdInfo), this.cH.mProgressBarTv.getMax());
                    }
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                        this.cH.mAppTailFrameView.u(this.cH.mAdInfo);
                        this.cH.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aX(i), i);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                        this.cH.mAppTailFrameView.u(this.cH.mAdInfo);
                        this.cH.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aW(i), i);
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
                com.kwad.sdk.core.e.b.printStackTrace(th);
            }
            AdTemplate adTemplate2 = this.mAdTemplate;
            if (adTemplate2 == null) {
                this.mContext.finish();
                return false;
            }
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate2);
            return true;
        }
        return invokeV.booleanValue;
    }

    private void intiView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            KsAdContainer ksAdContainer = (KsAdContainer) this.mContext.findViewById(R.id.obfuscated_res_0x7f091068);
            this.mAdContainer = ksAdContainer;
            ksAdContainer.setOnClickListener(this);
            TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) this.mContext.findViewById(R.id.obfuscated_res_0x7f09107a);
            this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
            tailFrameBarAppPortraitVertical.c(this.mAdTemplate);
            this.mAppTailFrameView.u(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
            this.mAppTailFrameView.setVisibility(0);
            TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
            this.mProgressBarTv = textProgressBar;
            textProgressBar.setOnClickListener(this);
            bindDownloadListener();
        }
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, b.InterfaceC0376b interfaceC0376b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, adTemplate, interfaceC0376b) == null) {
            KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
            Intent intent = new Intent(context, FeedDownloadActivity.class);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
            sInnerAdInteractionListener = interfaceC0376b;
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.f().b(this.mAdContainer.getTouchCoords()), (JSONObject) null);
            b.InterfaceC0376b interfaceC0376b = sInnerAdInteractionListener;
            if (interfaceC0376b != null) {
                interfaceC0376b.onAdClicked();
            }
        }
    }

    @InvokeBy(invokerClass = KsAdSDKImpl.class, methodId = KsAdSDKImpl.INVOKER_ID_INIT_COMPONENT_PROXY)
    public static void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        }
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tailFrameBarAppPortraitVertical = this.mAppTailFrameView) == null) {
            return;
        }
        tailFrameBarAppPortraitVertical.jl();
        this.mAppTailFrameView.setVisibility(8);
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FeedDownloadActivityProxy" : (String) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0352a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(view2 == this.mProgressBarTv ? 1 : 2).aj(view2 == this.mProgressBarTv).a(new a.b(this) { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FeedDownloadActivityProxy cH;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.cH = this;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.cH.notifyAdClick();
                    }
                }
            }));
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            try {
                getIntent().removeExtra(AdWebViewVideoActivityProxy.KEY_TEMPLATE);
            } catch (Throwable unused) {
            }
            super.onCreate(bundle);
            this.mContext = getActivity();
            if (!initData()) {
                this.mContext.finish();
                return;
            }
            getActivity().setTheme(16973838);
            setContentView(R.layout.obfuscated_res_0x7f0d03fe);
            intiView();
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            destroy();
        }
    }
}
