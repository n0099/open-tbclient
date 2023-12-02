package com.kwad.components.ad.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.b;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes10.dex */
public class FeedDownloadActivityProxy extends com.kwad.components.core.proxy.c implements View.OnClickListener {
    public static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    public static final String TAG = "FeedDownloadActivity";
    public static b.a sInnerAdInteractionListener;
    public KsAdContainer mAdContainer;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public TailFrameBarAppPortraitVertical mAppTailFrameView;
    public TextProgressBar mProgressBarTv;

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04a1;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "FeedDownloadActivityProxy";
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.1
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.cR(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.cQ(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.aE(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.bX(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.aE(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.ac(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new j().d(this.mAdContainer.getTouchCoords()), (JSONObject) null);
        b.a aVar = sInnerAdInteractionListener;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.mAppTailFrameView;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.kk();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        destroy();
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        if (this.mAdTemplate != null) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, b.a aVar) {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, FeedDownloadActivity.class);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        sInnerAdInteractionListener = aVar;
        context.startActivity(intent);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        KsAdContainer ksAdContainer = (KsAdContainer) findViewById(R.id.obfuscated_res_0x7f09133c);
        this.mAdContainer = ksAdContainer;
        ksAdContainer.setOnClickListener(this);
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.obfuscated_res_0x7f09134e);
        this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.b(this.mAdTemplate);
        this.mAppTailFrameView.D(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv = textProgressBar;
        textProgressBar.setOnClickListener(this);
        bindDownloadListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        boolean z = true;
        if (view2 == this.mProgressBarTv) {
            i = 1;
        } else {
            i = 2;
        }
        a.C0644a an = new a.C0644a(view2.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(i);
        if (view2 != this.mProgressBarTv) {
            z = false;
        }
        com.kwad.components.core.e.d.a.a(an.ao(z).a(new a.b() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                FeedDownloadActivityProxy.this.notifyAdClick();
            }
        }));
    }
}
