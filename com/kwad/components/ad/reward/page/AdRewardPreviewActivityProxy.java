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
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.i.a;
import com.kwad.components.core.m.c;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ae;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes10.dex */
public class AdRewardPreviewActivityProxy extends a {
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_URL = "key_langingpage_url";
    public static final String TAG = "AdRewardPreviewActivityProxy";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public l mCloseDialog;
    public int mCount;
    public TextView mCountDownTips;
    public long mLastDown;
    public String mUrl;
    public ImageView mWebCloseBtn;
    public AdBaseFrameLayout mWebContainer;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean mEnableSkip = false;
    public boolean counterPaused = false;

    public static /* synthetic */ int access$410(AdRewardPreviewActivityProxy adRewardPreviewActivityProxy) {
        int i = adRewardPreviewActivityProxy.mCount;
        adRewardPreviewActivityProxy.mCount = i - 1;
        return i;
    }

    private u.b getClientParams() {
        u.b bVar = new u.b();
        bVar.abM = 0;
        return bVar;
    }

    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.5
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                c.ox().a(AdRewardPreviewActivityProxy.this.mAdTemplate, null, null);
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
            }
        };
    }

    @SuppressLint({"SetTextI18n"})
    private void initView() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09144f);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().b(getClientParams()).R(this.mAdTemplate).aA(false).b(getWebErrorListener()));
        this.mAdWebView.pp();
        this.mWebCloseBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f091453);
        this.mWebContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091302);
        this.mWebCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.kwad.sdk.core.report.a.a(AdRewardPreviewActivityProxy.this.mAdTemplate, 1, (JSONObject) null);
                AdRewardPreviewActivityProxy.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0913d3);
        this.mCountDownTips = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdRewardPreviewActivityProxy.this.showCloseDialog();
            }
        });
        TextView textView2 = this.mCountDownTips;
        textView2.setText("激励领取视频还有" + this.mCount + "秒");
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.3
            @Override // java.lang.Runnable
            @SuppressLint({"SetTextI18n"})
            public final void run() {
                if (AdRewardPreviewActivityProxy.this.counterPaused) {
                    AdRewardPreviewActivityProxy.this.mHandler.postDelayed(this, 400L);
                    return;
                }
                if (AdRewardPreviewActivityProxy.this.mCount <= 0) {
                    AdRewardPreviewActivityProxy.this.mEnableSkip = true;
                    AdRewardPreviewActivityProxy.this.skipToEnd();
                } else {
                    TextView textView3 = AdRewardPreviewActivityProxy.this.mCountDownTips;
                    textView3.setText("激励领取视频还有" + AdRewardPreviewActivityProxy.this.mCount + "秒");
                    AdRewardPreviewActivityProxy.this.mHandler.postDelayed(this, 1000L);
                }
                AdRewardPreviewActivityProxy.access$410(AdRewardPreviewActivityProxy.this);
            }
        }, 1000L);
        AdInfo bQ = d.bQ(this.mAdTemplate);
        if (this.mUrl != null) {
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.am(bQ) && com.kwad.sdk.core.config.d.rT() && ae.isWifiConnected(getActivity())) {
                cVar.m(new a.C0636a(getActivity()).aj(false).ak(false).L(this.mAdTemplate).am(false));
            }
        }
        this.mAdWebView.loadUrl(!TextUtils.isEmpty(this.mUrl) ? this.mUrl : com.kwad.sdk.core.response.a.a.ar(d.bQ(this.mAdTemplate)));
        this.mWebContainer.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.4
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getX() > AdRewardPreviewActivityProxy.this.mWebCloseBtn.getX() && motionEvent.getX() - AdRewardPreviewActivityProxy.this.mWebCloseBtn.getX() < AdRewardPreviewActivityProxy.this.mWebCloseBtn.getWidth() && motionEvent.getY() > AdRewardPreviewActivityProxy.this.mWebCloseBtn.getY() && motionEvent.getY() - AdRewardPreviewActivityProxy.this.mWebCloseBtn.getY() < AdRewardPreviewActivityProxy.this.mWebCloseBtn.getHeight()) {
                    b.d(AdRewardPreviewActivityProxy.TAG, "onClick backIcon");
                    return false;
                }
                if (motionEvent.getAction() == 0) {
                    AdRewardPreviewActivityProxy.this.mLastDown = SystemClock.elapsedRealtime();
                } else if (motionEvent.getAction() == 1) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - AdRewardPreviewActivityProxy.this.mLastDown;
                    if (AdRewardPreviewActivityProxy.this.mLastDown > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                        com.kwad.sdk.core.report.a.a(AdRewardPreviewActivityProxy.this.mAdTemplate, 72, AdRewardPreviewActivityProxy.this.mWebContainer.getTouchCoords());
                        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = AdRewardPreviewActivityProxy.mInteractionListener;
                        if (rewardAdInteractionListener != null) {
                            rewardAdInteractionListener.onAdClicked();
                        }
                    }
                    AdRewardPreviewActivityProxy.this.mLastDown = 0L;
                }
                return false;
            }
        });
    }

    public static void launch(Context context, AdTemplate adTemplate, String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (context == null || adTemplate == null) {
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
        l lVar = this.mCloseDialog;
        if (lVar == null || !lVar.isShowing()) {
            k kVar = new k();
            kVar.mAdTemplate = this.mAdTemplate;
            this.mCloseDialog = l.a(getActivity(), this.mAdTemplate, l.a(kVar, "还差" + (this.mCount + 1) + "秒就可以获取奖励"), new l.b() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.6
                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void G(boolean z) {
                    AdRewardPreviewActivityProxy.this.counterPaused = false;
                    AdRewardPreviewActivityProxy.this.finish();
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void fH() {
                    AdRewardPreviewActivityProxy.this.counterPaused = true;
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void fI() {
                    AdRewardPreviewActivityProxy.this.counterPaused = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipToEnd() {
        this.mCountDownTips.setVisibility(8);
        this.mWebCloseBtn.setVisibility(0);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify();
        }
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        return TAG;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            com.kwad.sdk.core.report.a.ay(this.mAdTemplate);
        } else if (!this.mEnableSkip) {
            showCloseDialog();
        } else {
            super.onBackPressed();
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, 11, (JSONObject) null);
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.obfuscated_res_0x7f0d048d);
        String stringExtra = getIntent().getStringExtra("key_template_json");
        this.mUrl = getIntent().getStringExtra(KEY_URL);
        try {
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            b.printStackTrace(th);
        }
        AdTemplate adTemplate2 = this.mAdTemplate;
        if (adTemplate2 == null) {
            finish();
            return;
        }
        this.mCount = d.bQ(adTemplate2).adStyleInfo.adBrowseInfo.adBrowseDuration;
        initView();
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onPageDismiss();
        }
        mInteractionListener = null;
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }
}
