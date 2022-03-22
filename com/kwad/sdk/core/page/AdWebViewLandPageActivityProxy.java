package com.kwad.sdk.core.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.page.kwai.d;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.KsLogoView;
import java.io.InputStream;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes7.dex */
public class AdWebViewLandPageActivityProxy extends com.kwad.sdk.core.e.a<com.kwad.sdk.reward.a> {
    public static final String KEY_NEED_CLOSE_REWARD = "key_close_reward";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewLandPageActivityProxy";
    public static boolean showingAdWebViewLandPage;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.download.a.b mApkDownloadHelper;
    public ImageView mBackIcon;
    public ImageView mCloseIcon;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public KSRelativeLayout mKsadVideoContainer;
    public boolean mNeedCloseReward;
    public com.kwad.sdk.reward.c.a mRewardPlayModule;
    public KSRelativeLayout mRootContainer;
    public ImageView mVideoBlurBg;
    public ImageView mVideoCover;
    public com.kwad.sdk.contentalliance.detail.video.d mVideoPlayStateListener;

    private void buildView(ComplianceTextView complianceTextView, KSLinearLayout kSLinearLayout, KsLogoView ksLogoView) {
        if (com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.j(this.mAdTemplate))) {
            return;
        }
        ((FrameLayout.LayoutParams) complianceTextView.getLayoutParams()).gravity = 80;
        if (!af.e(this.mContext)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ksLogoView.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, com.kwad.sdk.a.kwai.a.a(this.mContext, 100.0f));
            ksLogoView.setLayoutParams(marginLayoutParams);
        }
        ksLogoView.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kSLinearLayout.getLayoutParams();
        layoutParams.gravity = 17;
        kSLinearLayout.setLayoutParams(layoutParams);
    }

    private com.kwad.sdk.contentalliance.detail.video.d getVideoPlayStateListener() {
        e eVar = new e() { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.6
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i, int i2) {
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                AdWebViewLandPageActivityProxy.this.mVideoCover.setVisibility(8);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                AdWebViewLandPageActivityProxy.this.mVideoCover.setVisibility(0);
            }
        };
        this.mVideoPlayStateListener = eVar;
        return eVar;
    }

    @NonNull
    private d.a getWebViewStateListener() {
        return new d.a() { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.3
            @Override // com.kwad.sdk.core.page.kwai.d.a
            public void a(int i) {
                if (i != 1) {
                    AdWebViewLandPageActivityProxy.this.initNativeLandPage();
                }
            }
        };
    }

    private void handleCloseBtn() {
        long t = com.kwad.sdk.core.config.b.t() * 1000;
        if (t == 0) {
            this.mCloseIcon.setVisibility(0);
        } else {
            this.mCloseIcon.postDelayed(new Runnable() { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.7
                @Override // java.lang.Runnable
                public void run() {
                    if (AdWebViewLandPageActivityProxy.this.getActivity() == null || AdWebViewLandPageActivityProxy.this.getActivity().isFinishing()) {
                        return;
                    }
                    AdWebViewLandPageActivityProxy.this.mCloseIcon.setVisibility(0);
                    AdWebViewLandPageActivityProxy.this.mCloseIcon.setAlpha(0.0f);
                    AdWebViewLandPageActivityProxy.this.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
                }
            }, t);
        }
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.reward.b.a().b();
                AdWebViewLandPageActivityProxy.this.finish();
            }
        });
    }

    private boolean initData() {
        String stringExtra = getIntent().getStringExtra("key_template_json");
        this.mNeedCloseReward = getIntent().getBooleanExtra(KEY_NEED_CLOSE_REWARD, false);
        try {
            AdTemplate adTemplate = new AdTemplate();
            if (stringExtra != null) {
                adTemplate.parseJson(new JSONObject(stringExtra));
            }
            this.mAdTemplate = adTemplate;
            this.mAdInfo = com.kwad.sdk.core.response.a.d.j(adTemplate);
            return true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNativeLandPage() {
        findViewById(R.id.obfuscated_res_0x7f091021).setVisibility(0);
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f091058);
        complianceTextView.setVisibility(0);
        complianceTextView.setAdTemplate(this.mAdTemplate);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f091013);
        KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(R.id.obfuscated_res_0x7f091090);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0910b1);
        DownloadProgressBar downloadProgressBar = (DownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f09118e);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.mAdTemplate);
        setAdTitle((TextView) findViewById(R.id.obfuscated_res_0x7f091028), j);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f09101e)).setText(j.adBaseInfo.adDescription);
        roundAngleImageView.setRadius(32.0f);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.au(j))) {
            KSImageLoader.loadImage(roundAngleImageView, com.kwad.sdk.core.response.a.a.au(j), this.mAdTemplate);
        }
        setAdkDownload(downloadProgressBar, j);
        buildView(complianceTextView, kSLinearLayout, ksLogoView);
    }

    private void initView() {
        this.mRootContainer = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091131);
        this.mKsadVideoContainer = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f09115e);
        this.mDetailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091177);
        this.mVideoBlurBg = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f09115a);
        this.mBackIcon = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091044);
        this.mCloseIcon = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091130);
        this.mVideoCover = (ImageView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091169);
        if (this.mAdTemplate.adInfoList.size() > 0) {
            loadBlurImage(com.kwad.sdk.core.response.a.a.h(this.mAdTemplate.adInfoList.get(0)), this.mVideoBlurBg);
        }
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.report.a.f(AdWebViewLandPageActivityProxy.this.mAdTemplate, 153);
                AdWebViewLandPageActivityProxy.this.finish();
            }
        });
        if (com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.j(this.mAdTemplate))) {
            setVideoData();
        }
        if (this.mNeedCloseReward) {
            handleCloseBtn();
        }
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        launch(context, adTemplate, false);
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z) {
        Class cls = af.e(context) ? AdWebViewActivity.class : KsFullScreenLandScapeVideoActivity.class;
        KsAdSDKImpl.putComponentProxy(cls, AdWebViewLandPageActivityProxy.class);
        Intent intent = new Intent(context, cls);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_NEED_CLOSE_REWARD, z);
        context.startActivity(intent);
    }

    private void loadBlurImage(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setVisibility(0);
        KSImageLoader.loadImage(imageView, str, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }

    private void setAdTitle(TextView textView, AdInfo adInfo) {
        String str;
        if (!TextUtils.isEmpty(adInfo.adBaseInfo.appName)) {
            str = adInfo.adBaseInfo.appName;
        } else if (TextUtils.isEmpty(adInfo.advertiserInfo.rawUserName)) {
            return;
        } else {
            str = adInfo.advertiserInfo.rawUserName;
        }
        textView.setText(str);
    }

    private void setAdkDownload(final DownloadProgressBar downloadProgressBar, final AdInfo adInfo) {
        if (com.kwad.sdk.core.response.a.a.B(adInfo)) {
            this.mApkDownloadHelper = new com.kwad.sdk.core.download.a.b(this.mAdTemplate, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.4
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.b(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.a(AdWebViewLandPageActivityProxy.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.A(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.m(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.a(i));
                }
            });
            downloadProgressBar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.kwad.sdk.core.report.a.f(AdWebViewLandPageActivityProxy.this.mAdTemplate, (int) Cea708Decoder.COMMAND_DF0);
                    AdWebViewLandPageActivityProxy.this.mApkDownloadHelper.a(AdWebViewLandPageActivityProxy.this.mContext, true);
                }
            });
        }
    }

    private void setVideoData() {
        ViewGroup.LayoutParams layoutParams = this.mKsadVideoContainer.getLayoutParams();
        if (af.e(this.mContext)) {
            layoutParams.height = (com.kwad.sdk.a.kwai.a.c(this.mContext) * 9) / 16;
            layoutParams.width = -1;
            this.mDetailVideoView.a(true);
        } else {
            layoutParams.width = com.kwad.sdk.a.kwai.a.c(this.mContext) / 2;
            layoutParams.height = -1;
            this.mDetailVideoView.setHorizontalVideo(true);
        }
        this.mKsadVideoContainer.setLayoutParams(layoutParams);
        this.mKsadVideoContainer.setVisibility(0);
        KSImageLoader.loadImage(this.mVideoCover, com.kwad.sdk.core.response.a.a.aa(this.mAdInfo).a(), this.mAdTemplate);
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        return TAG;
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(getActivity());
        this.mContext = wrapContextIfNeed;
        showingAdWebViewLandPage = true;
        setContentView(af.e(wrapContextIfNeed) ? R.layout.obfuscated_res_0x7f0d0415 : R.layout.obfuscated_res_0x7f0d041b);
        if (!initData()) {
            finish();
            return;
        }
        initView();
        onActivityCreated(this.mRootContainer);
    }

    @Override // com.kwad.sdk.core.e.a
    public com.kwad.sdk.reward.a onCreateCallerContext() {
        com.kwad.sdk.reward.a aVar = new com.kwad.sdk.reward.a();
        aVar.f40748h = getActivity();
        aVar.i = this.mContext;
        AdTemplate adTemplate = this.mAdTemplate;
        aVar.f40747g = adTemplate;
        aVar.r = false;
        if (com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            com.kwad.sdk.utils.b.a(this.mContext).a(true);
            com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(this.mAdTemplate, this.mDetailVideoView, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
            this.mRewardPlayModule = aVar2;
            aVar.k = aVar2;
            aVar2.a(getVideoPlayStateListener());
            aVar.a.add(this.mRewardPlayModule);
        }
        return aVar;
    }

    @Override // com.kwad.sdk.core.e.a
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        if (com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.j(this.mAdTemplate))) {
            presenter.a((Presenter) new com.kwad.sdk.core.page.kwai.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.core.page.kwai.d(getWebViewStateListener()));
        return presenter;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        showingAdWebViewLandPage = false;
        com.kwad.sdk.core.download.a.b bVar = this.mApkDownloadHelper;
        if (bVar != null) {
            bVar.i();
        }
        com.kwad.sdk.reward.c.a aVar = this.mRewardPlayModule;
        if (aVar != null) {
            aVar.e();
        }
    }
}
