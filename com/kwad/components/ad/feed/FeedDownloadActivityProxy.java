package com.kwad.components.ad.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
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
/* loaded from: classes10.dex */
public class FeedDownloadActivityProxy extends com.kwad.components.core.i.a implements View.OnClickListener {
    public static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    public static final String TAG = "FeedDownloadActivity";
    public static b.InterfaceC0671b sInnerAdInteractionListener;
    public KsAdContainer mAdContainer;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public TailFrameBarAppPortraitVertical mAppTailFrameView;
    public Activity mContext;
    public TextProgressBar mProgressBarTv;

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate, null, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.u(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.al(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.u(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aJ(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.u(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.al(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.u(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.P(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.u(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aX(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.u(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aW(i), i);
            }
        });
    }

    private boolean initData() {
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

    private void intiView() {
        KsAdContainer ksAdContainer = (KsAdContainer) this.mContext.findViewById(R.id.obfuscated_res_0x7f0912a9);
        this.mAdContainer = ksAdContainer;
        ksAdContainer.setOnClickListener(this);
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) this.mContext.findViewById(R.id.obfuscated_res_0x7f0912bb);
        this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.c(this.mAdTemplate);
        this.mAppTailFrameView.u(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv = textProgressBar;
        textProgressBar.setOnClickListener(this);
        bindDownloadListener();
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, b.InterfaceC0671b interfaceC0671b) {
        KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, FeedDownloadActivity.class);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        sInnerAdInteractionListener = interfaceC0671b;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.f().b(this.mAdContainer.getTouchCoords()), (JSONObject) null);
        b.InterfaceC0671b interfaceC0671b = sInnerAdInteractionListener;
        if (interfaceC0671b != null) {
            interfaceC0671b.onAdClicked();
        }
    }

    @InvokeBy(invokerClass = KsAdSDKImpl.class, methodId = KsAdSDKImpl.INVOKER_ID_INIT_COMPONENT_PROXY)
    public static void register() {
        KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.mAppTailFrameView;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.jl();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        return "FeedDownloadActivityProxy";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        com.kwad.components.core.c.a.a.a(new a.C0647a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(view2 == this.mProgressBarTv ? 1 : 2).aj(view2 == this.mProgressBarTv).a(new a.b() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.2
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                FeedDownloadActivityProxy.this.notifyAdClick();
            }
        }));
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
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
        setContentView(R.layout.obfuscated_res_0x7f0d047f);
        intiView();
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        destroy();
    }
}
