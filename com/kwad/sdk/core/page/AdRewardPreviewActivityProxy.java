package com.kwad.sdk.core.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.reward.j;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes3.dex */
public class AdRewardPreviewActivityProxy extends com.kwad.sdk.h.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_URL = "key_langingpage_url";
    public static final String TAG = "AdRewardPreviewActivityProxy";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean counterPaused;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public int mCount;
    public TextView mCountDownTips;
    public boolean mEnableSkip;
    public Handler mHandler;
    public long mLastDown;
    public String mUrl;
    public ImageView mWebCloseBtn;
    public AdBaseFrameLayout mWebContainer;

    public AdRewardPreviewActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mEnableSkip = false;
        this.counterPaused = false;
    }

    public static /* synthetic */ int access$410(AdRewardPreviewActivityProxy adRewardPreviewActivityProxy) {
        int i2 = adRewardPreviewActivityProxy.mCount;
        adRewardPreviewActivityProxy.mCount = i2 - 1;
        return i2;
    }

    private void handlerLandingPageAtEndCard(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, ksAdWebView) == null) {
            p.a aVar = new p.a();
            aVar.n = 0;
            ksAdWebView.setClientParams(aVar);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void initView() {
        KsAdWebView ksAdWebView;
        String G;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            KsAdWebView ksAdWebView2 = (KsAdWebView) findViewById(R.id.ksad_video_webview);
            this.mAdWebView = ksAdWebView2;
            handlerLandingPageAtEndCard(ksAdWebView2);
            this.mAdWebView.setTemplateData(this.mAdTemplate);
            this.mAdWebView.setDeepLinkEnabled(false);
            this.mAdWebView.b();
            this.mWebCloseBtn = (ImageView) findViewById(R.id.ksad_web_close_btn);
            this.mWebContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_landing_page_root);
            this.mWebCloseBtn.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdRewardPreviewActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdRewardPreviewActivityProxy a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        com.kwad.sdk.core.report.a.a(this.a.mAdTemplate, 1, (JSONObject) null);
                        this.a.finish();
                    }
                }
            });
            TextView textView = (TextView) findViewById(R.id.ksad_reward_preview_skip_time);
            this.mCountDownTips = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdRewardPreviewActivityProxy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdRewardPreviewActivityProxy a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.showCloseDialog();
                    }
                }
            });
            TextView textView2 = this.mCountDownTips;
            textView2.setText("激励领取视频还有" + this.mCount + "秒");
            this.mHandler.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.core.page.AdRewardPreviewActivityProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdRewardPreviewActivityProxy a;

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
                    this.a = this;
                }

                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.a.counterPaused) {
                            this.a.mHandler.postDelayed(this, 400L);
                            return;
                        }
                        if (this.a.mCount <= 0) {
                            this.a.mEnableSkip = true;
                            this.a.skipToEnd();
                        } else {
                            TextView textView3 = this.a.mCountDownTips;
                            textView3.setText("激励领取视频还有" + this.a.mCount + "秒");
                            this.a.mHandler.postDelayed(this, 1000L);
                        }
                        AdRewardPreviewActivityProxy.access$410(this.a);
                    }
                }
            }, 1000L);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.mAdTemplate);
            if (this.mUrl != null) {
                com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.mAdTemplate);
                if (com.kwad.sdk.core.response.a.a.B(j2) && com.kwad.sdk.core.config.b.Z() && com.ksad.download.c.b.b(getActivity())) {
                    bVar.a((Context) getActivity(), false);
                }
                ksAdWebView = this.mAdWebView;
                G = this.mUrl;
            } else {
                ksAdWebView = this.mAdWebView;
                G = com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.j(this.mAdTemplate));
            }
            ksAdWebView.loadUrl(G);
            this.mAdWebView.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.page.AdRewardPreviewActivityProxy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdRewardPreviewActivityProxy a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.a.mAdTemplate, (JSONObject) null);
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }
            });
            this.mWebContainer.setDispatchTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.core.page.AdRewardPreviewActivityProxy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdRewardPreviewActivityProxy a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getX() > this.a.mWebCloseBtn.getX() && motionEvent.getX() - this.a.mWebCloseBtn.getX() < this.a.mWebCloseBtn.getWidth() && motionEvent.getY() > this.a.mWebCloseBtn.getY() && motionEvent.getY() - this.a.mWebCloseBtn.getY() < this.a.mWebCloseBtn.getHeight()) {
                            com.kwad.sdk.core.d.a.a(AdRewardPreviewActivityProxy.TAG, "onClick backIcon");
                            return false;
                        }
                        if (motionEvent.getAction() == 0) {
                            this.a.mLastDown = SystemClock.elapsedRealtime();
                        } else if (motionEvent.getAction() == 1) {
                            long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.mLastDown;
                            if (this.a.mLastDown > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                                com.kwad.sdk.core.report.a.a(this.a.mAdTemplate, 72, this.a.mWebContainer.getTouchCoords());
                                KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = AdRewardPreviewActivityProxy.mInteractionListener;
                                if (rewardAdInteractionListener != null) {
                                    rewardAdInteractionListener.onAdClicked();
                                }
                            }
                            this.a.mLastDown = 0L;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    public static void launch(Context context, AdTemplate adTemplate, String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65553, null, context, adTemplate, str, rewardAdInteractionListener) == null) || context == null || adTemplate == null) {
            return;
        }
        mInteractionListener = rewardAdInteractionListener;
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdRewardPreviewActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_URL, str);
        context.startActivity(intent);
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCloseDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            j.a(getActivity(), this.mAdTemplate, j.a(this.mAdTemplate, "还差" + (this.mCount + 1) + "秒就可以获取奖励", (com.kwad.sdk.reward.b.a.a) null, (com.kwad.sdk.reward.b.kwai.a) null), new j.c(this) { // from class: com.kwad.sdk.core.page.AdRewardPreviewActivityProxy.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdRewardPreviewActivityProxy a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.counterPaused = true;
                    }
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.counterPaused = false;
                        this.a.finish();
                    }
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.counterPaused = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipToEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.mCountDownTips.setVisibility(8);
            this.mWebCloseBtn.setVisibility(0);
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify();
            }
        }
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView != null && ksAdWebView.canGoBack()) {
                this.mAdWebView.goBack();
                com.kwad.sdk.core.report.a.l(this.mAdTemplate);
            } else if (!this.mEnableSkip) {
                showCloseDialog();
            } else {
                super.onBackPressed();
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, 11, (JSONObject) null);
            }
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setContentView(R.layout.ksad_activity_reward_preview);
            String stringExtra = getIntent().getStringExtra("key_template_json");
            this.mUrl = getIntent().getStringExtra(KEY_URL);
            try {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra));
                this.mAdTemplate = adTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            AdTemplate adTemplate2 = this.mAdTemplate;
            if (adTemplate2 == null) {
                finish();
                return;
            }
            this.mCount = com.kwad.sdk.core.response.a.d.j(adTemplate2).adStyleInfo.adBrowseInfo.adBrowseDuration;
            initView();
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onPageDismiss();
            }
            mInteractionListener = null;
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView != null) {
                ksAdWebView.c();
                this.mAdWebView = null;
            }
            super.onDestroy();
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStop();
        }
    }
}
