package com.kwad.components.ad.reward.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.m;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.b;
import com.kwad.components.core.h.a;
import com.kwad.components.core.l.c;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes5.dex */
public class AdRewardPreviewActivityProxy extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_URL = "key_langingpage_url";
    public static final String TAG = "AdRewardPreviewActivityProxy";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean counterPaused;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public m mCloseDialog;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        int i = adRewardPreviewActivityProxy.mCount;
        adRewardPreviewActivityProxy.mCount = i - 1;
        return i;
    }

    private u.b getClientParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            u.b bVar = new u.b();
            bVar.p = 0;
            return bVar;
        }
        return (u.b) invokeV.objValue;
    }

    private KsAdWebView.d getWebErrorListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.5
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    c.a().a(this.a.mAdTemplate, null, null);
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    @SuppressLint({"SetTextI18n"})
    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0911e9);
            this.mAdWebView = ksAdWebView;
            this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().a(getClientParams()).a(this.mAdTemplate).a(false).a(getWebErrorListener()));
            this.mAdWebView.b();
            this.mWebCloseBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911ed);
            this.mWebContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f09107e);
            this.mWebCloseBtn.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        com.kwad.sdk.core.report.a.a(this.a.mAdTemplate, 1, (JSONObject) null);
                        this.a.finish();
                    }
                }
            });
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09116b);
            this.mCountDownTips = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.2
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.showCloseDialog();
                    }
                }
            });
            TextView textView2 = this.mCountDownTips;
            textView2.setText("激励领取视频还有" + this.mCount + "秒");
            this.mHandler.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.3
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
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
            AdInfo i = d.i(this.mAdTemplate);
            if (this.mUrl != null) {
                b bVar = new b(this.mAdTemplate);
                if (com.kwad.sdk.core.response.a.a.I(i) && com.kwad.sdk.core.config.d.w() && ac.c(getActivity())) {
                    bVar.a(new a.C0507a(getActivity()).a(false).b(false).a(this.mAdTemplate).d(false));
                }
            }
            this.mAdWebView.loadUrl(!TextUtils.isEmpty(this.mUrl) ? this.mUrl : com.kwad.sdk.core.response.a.a.N(d.i(this.mAdTemplate)));
            this.mWebContainer.a(new View.OnTouchListener(this) { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.4
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
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        if (motionEvent.getX() > this.a.mWebCloseBtn.getX() && motionEvent.getX() - this.a.mWebCloseBtn.getX() < this.a.mWebCloseBtn.getWidth() && motionEvent.getY() > this.a.mWebCloseBtn.getY() && motionEvent.getY() - this.a.mWebCloseBtn.getY() < this.a.mWebCloseBtn.getHeight()) {
                            com.kwad.sdk.core.d.b.a(AdRewardPreviewActivityProxy.TAG, "onClick backIcon");
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
        if (!(interceptable == null || interceptable.invokeLLLL(65554, null, context, adTemplate, str, rewardAdInteractionListener) == null) || context == null || adTemplate == null) {
            return;
        }
        mInteractionListener = rewardAdInteractionListener;
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdRewardPreviewActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
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
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            m mVar = this.mCloseDialog;
            if (mVar == null || !mVar.a()) {
                l lVar = new l();
                lVar.g = this.mAdTemplate;
                this.mCloseDialog = m.a(getActivity(), this.mAdTemplate, m.a(lVar, "还差" + (this.mCount + 1) + "秒就可以获取奖励"), new m.b(this) { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.6
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.counterPaused = true;
                        }
                    }

                    @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                    public final void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                            this.a.counterPaused = false;
                            this.a.finish();
                        }
                    }

                    @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                    public final void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.a.counterPaused = false;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipToEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.mCountDownTips.setVisibility(8);
            this.mWebCloseBtn.setVisibility(0);
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify();
            }
        }
    }

    @Override // com.kwad.components.core.h.a
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
                com.kwad.sdk.core.report.a.j(this.mAdTemplate);
            } else if (!this.mEnableSkip) {
                showCloseDialog();
            } else {
                super.onBackPressed();
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, 11, (JSONObject) null);
            }
        }
    }

    @Override // com.kwad.components.core.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d03ff);
            String stringExtra = getIntent().getStringExtra("key_template_json");
            this.mUrl = getIntent().getStringExtra(KEY_URL);
            try {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra));
                this.mAdTemplate = adTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.a(th);
            }
            AdTemplate adTemplate2 = this.mAdTemplate;
            if (adTemplate2 == null) {
                finish();
                return;
            }
            this.mCount = d.i(adTemplate2).adStyleInfo.adBrowseInfo.adBrowseDuration;
            initView();
        }
    }

    @Override // com.kwad.components.core.h.a, com.kwad.sdk.api.proxy.IActivityProxy
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
}
